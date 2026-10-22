package s5;

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

/* JADX INFO: loaded from: classes43.dex */
public final class f implements SharedPreferences, Keva.OnChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f540692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f540693b;

    public static final class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Keva f540694a;

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.f540694a.clear();
            return this;
        }

        public a(Keva r100) {
            Intrinsics.checkNotNullParameter(r100, CloudControlInf.SP);
            this.f540694a = r100;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r100) {
            this.f540694a.erase(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            Keva r102 = this.f540694a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r102.storeBoolean(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r100, float r101) {
            Keva r102 = this.f540694a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r102.storeFloat(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r100, int r101) {
            Keva r102 = this.f540694a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r102.storeInt(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r100, long r101) {
            Keva r102 = this.f540694a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r102.storeLong(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r100, String r101) {
            Keva r102 = this.f540694a;
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
            Keva r102 = this.f540694a;
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

    public static final class b extends g<SharedPreferences.OnSharedPreferenceChangeListener> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f540695c;

        public b(f r100) {
            this.f540695c = r100;
        }

        public final void a(int r100) {
            if (r100 != 0) goto L4;
            this.f540695c.a().unRegisterChangeListener(this.f540695c);
            return;
        L4:
            if (r100 != 1) goto L10;
            this.f540695c.a().registerChangeListener(this.f540695c);
            return;
        }
    }

    public final Keva a() {
        return (Keva) this.f540692a.getValue();
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
        b r101 = (b) this.f540693b.getValue();
        if (r100 == null) goto L15;
        Object r102 = r101.f540696a;
        monitor-enter(r102);
        T r103 = (T) r100;
        if (r101.f540697b.put(r103, r101.f540696a) != null) goto L9;
        r101.a(r101.f540697b.size());     // Catch: Throwable -> L12
    L9:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r102);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        r101.getClass();
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        b r101 = (b) this.f540693b.getValue();
        if (r100 == null) goto L15;
        Object r102 = r101.f540696a;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r101.f540697b.remove(r100) == null) goto L9;
        r101.a(r101.f540697b.size());     // Catch: Throwable -> L12
    L9:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r102);
        return;
    L15:
        r101.getClass();
    }

    public f(final String r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        this.f540692a = LazyKt.lazy(new d(r100, r101));
        this.f540693b = LazyKt.lazy(new e(this));
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
        b r102 = (b) this.f540693b.getValue();
        Object r103 = r102.f540696a;
        monitor-enter(r103);
        HashSet r104 = new HashSet(r102.f540697b.keySet());     // Catch: Throwable -> L11
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
