package xg9;

import android.content.SharedPreferences;
import com.bytedance.keva.Keva;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class e implements SharedPreferences, Keva.OnChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f563819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f563820b;

    public static final class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Keva f563821a;

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.f563821a.clear();
            return this;
        }

        public a(Keva r100) {
            Intrinsics.checkNotNullParameter(r100, CloudControlInf.SP);
            this.f563821a = r100;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r100) {
            this.f563821a.erase(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            Keva r102 = this.f563821a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r102.storeBoolean(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r100, float r101) {
            Keva r102 = this.f563821a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r102.storeFloat(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r100, int r101) {
            Keva r102 = this.f563821a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r102.storeInt(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r100, long r101) {
            Keva r102 = this.f563821a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r102.storeLong(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r100, String r101) {
            Keva r102 = this.f563821a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            if (r101 != null) goto L7;
            r101 = "";
        L7:
            r102.storeString(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
            Keva r102 = this.f563821a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            if (r101 != null) goto L7;
            r101 = new LinkedHashSet();
        L7:
            r102.storeStringSet(r100, r101);
            return this;
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class b extends f<SharedPreferences.OnSharedPreferenceChangeListener> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f563822c;

        public b(e r100) {
            this.f563822c = r100;
        }

        public final void a(int r100) {
            if (r100 != 0) goto L4;
            this.f563822c.a().unRegisterChangeListener(this.f563822c);
            return;
        L4:
            if (r100 != 1) goto L10;
            this.f563822c.a().registerChangeListener(this.f563822c);
            return;
        }
    }

    public final Keva a() {
        return (Keva) this.f563819a.getValue();
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new a(a());
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        return a().getAll();
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r100) {
        Keva r101 = a();
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return r101.contains(r100);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        b r101 = (b) this.f563820b.getValue();
        if (r100 == null) goto L15;
        byte[] r102 = r101.f563823a;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r101.f563824b.put((T) r100, r101.f563823a) != null) goto L9;
        r101.a(r101.f563824b.size());     // Catch: Throwable -> L12
    L9:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r102);
        return;
    L15:
        r101.getClass();
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        b r101 = (b) this.f563820b.getValue();
        if (r100 == null) goto L12;
        byte[] r102 = r101.f563823a;
        monitor-enter(r102);
        r101.f563824b.remove(r100, r101.f563823a);     // Catch: Throwable -> L9
        r101.a(r101.f563824b.size());     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r102);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        r101.getClass();
    }

    public e(final String r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        this.f563819a = LazyKt.lazy(new c(r100, r101));
        this.f563820b = LazyKt.lazy(new d(this));
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r100, boolean r101) {
        Keva r102 = a();
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return r102.getBoolean(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r100, float r101) {
        Keva r102 = a();
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return r102.getFloat(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r100, int r101) {
        Keva r102 = a();
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return r102.getInt(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r100, long r101) {
        return a().getLong(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r100, String r101) {
        Keva r102 = a();
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return r102.getString(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        Keva r102 = a();
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return r102.getStringSet(r100, r101);
    }

    @Override // com.bytedance.keva.Keva.OnChangeListener
    public final void onChanged(Keva r100, String r101) {
        b r102 = (b) this.f563820b.getValue();
        byte[] r103 = r102.f563823a;
        monitor-enter(r103);
        HashSet r104 = new HashSet(r102.f563824b.keySet());     // Catch: Throwable -> L11
        monitor-exit(r103);
        Iterator r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        ((SharedPreferences.OnSharedPreferenceChangeListener) r105.next()).onSharedPreferenceChanged(this, r101);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
