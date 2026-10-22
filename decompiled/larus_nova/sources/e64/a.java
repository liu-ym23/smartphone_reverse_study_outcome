package e64;

import android.content.SharedPreferences;
import android.util.ArrayMap;
import com.bytedance.keva.Keva;
import com.bytedance.tma.base.keva.KevaManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<SharedPreferences.OnSharedPreferenceChangeListener, Keva.OnChangeListener> f471128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f471129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Keva f471130c;

    /* JADX INFO: renamed from: e64.a$a, reason: collision with other inner class name */
    public class C5745a implements Keva.OnChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SharedPreferences.OnSharedPreferenceChangeListener f471131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f471132b;

        public C5745a(a r100, SharedPreferences.OnSharedPreferenceChangeListener r101) {
            this.f471132b = r100;
            this.f471131a = r101;
        }

        @Override // com.bytedance.keva.Keva.OnChangeListener
        public final void onChanged(Keva r100, String r101) {
            this.f471131a.onSharedPreferenceChanged(this.f471132b, r101);
        }
    }

    public class b implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, Object> f471133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f471134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f471135c;

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.f471134b = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            Map<String, Object> r100 = this.f471133a;
            boolean r101 = this.f471134b;
            a r102 = this.f471135c;
            if (r101 == false) goto L5;
            r102.f471130c.clear();
        L6:
            monitor-enter(r100);
            Iterator r103 = ((ArrayMap) r100).entrySet().iterator();     // Catch: Throwable -> L38
        L9:
            if (r103.hasNext() == false) goto L29;
            Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Throwable -> L38
            String r105 = (String) r104.getKey();     // Catch: Throwable -> L38
            Object r106 = r104.getValue();     // Catch: Throwable -> L38
            if ((r106 instanceof Integer) == true) goto L12;
            if ((r106 instanceof Boolean) == true) goto L15;
            if ((r106 instanceof String) == true) goto L18;
            if ((r106 instanceof Long) == true) goto L21;
            if ((r106 instanceof Float) == true) goto L24;
            if ((r106 instanceof Set) == true) goto L27;
            r102.f471130c.erase(r105);     // Catch: Throwable -> L38
            goto L9
        L27:
            r102.f471130c.storeStringSet(r105, (Set) r106);     // Catch: Throwable -> L38
            goto L9
        L24:
            r102.f471130c.storeFloat(r105, ((Float) r106).floatValue());     // Catch: Throwable -> L38
            goto L9
        L21:
            r102.f471130c.storeLong(r105, ((Long) r106).longValue());     // Catch: Throwable -> L38
            goto L9
        L18:
            r102.f471130c.storeString(r105, (String) r106);     // Catch: Throwable -> L38
            goto L9
        L15:
            r102.f471130c.storeBoolean(r105, ((Boolean) r106).booleanValue());     // Catch: Throwable -> L38
            goto L9
        L12:
            r102.f471130c.storeInt(r105, ((Integer) r106).intValue());     // Catch: Throwable -> L38
            goto L9
        L29:
            monitor-exit(r100);     // Catch: Throwable -> L38
            a r107 = this.f471135c;
            if (r107.f471129b == false) goto L33;
            r107.a();
        L33:
            this.f471133a = new ArrayMap();
            if (this.f471134b == false) goto L64;
            this.f471134b = false;
            return true;
        L64:
            return true;
        L38:
            th = move-exception;
            throw th;
        L5:
            r102.getClass();
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            commit();
        }

        public b(a r100) {
            this.f471135c = r100;
            this.f471133a = new ArrayMap();
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r100) {
            Map<String, Object> r101 = this.f471133a;
            monitor-enter(r101);
            r101.put(r100, this);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            Map<String, Object> r102 = this.f471133a;
            monitor-enter(r102);
            r102.put(r100, Boolean.valueOf(r101));     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r100, float r101) {
            Map<String, Object> r102 = this.f471133a;
            monitor-enter(r102);
            r102.put(r100, Float.valueOf(r101));     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r100, int r101) {
            Map<String, Object> r102 = this.f471133a;
            monitor-enter(r102);
            r102.put(r100, Integer.valueOf(r101));     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r100, long r101) {
            Map<String, Object> r102 = this.f471133a;
            monitor-enter(r102);
            r102.put(r100, Long.valueOf(r101));     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r100, String r101) {
            Map<String, Object> r102 = this.f471133a;
            monitor-enter(r102);
            r102.put(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
            Map<String, Object> r102 = this.f471133a;
            monitor-enter(r102);
            r102.put(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public abstract void a();

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new b(this);
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        HashMap r100 = new HashMap();
        Iterator<Map.Entry<String, ?>> r101 = this.f471130c.getAll().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<String, ?> r102 = r101.next();
        String r103 = r102.getKey();
        Object r104 = r102.getValue();
        if (r104 == null) goto L4;
        if ((r104 instanceof String[]) == false) goto L13;
        String[] r105 = (String[]) r104;
        HashSet r106 = new HashSet(16, 0.75f);
        int r107 = r105.length;
        int r108 = 0;
    L10:
        if (r108 >= r107) goto L12;
        r106.add(r105[r108]);
        r108 = r108 + 1;
        goto L10
    L12:
        r104 = r106;
    L13:
        r100.put(r103, r104);
        goto L4
    L14:
        return r100;
    }

    public a(String r100) {
        this.f471128a = new ArrayMap();
        this.f471129b = false;
        Lazy r101 = KevaManager.f270924a;
        Intrinsics.checkNotNullParameter(r100, "repoName");
        this.f471130c = Keva.getRepo(r100, 1);
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r100) {
        return this.f471130c.contains(r100);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        C5745a r101 = new C5745a(this, r100);
        this.f471130c.registerChangeListener(r101);
        ((ArrayMap) this.f471128a).put(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        Keva.OnChangeListener r101 = (Keva.OnChangeListener) ((ArrayMap) this.f471128a).remove(r100);
        this.f471130c.unRegisterChangeListener(r101);
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r100, boolean r101) {
        return this.f471130c.getBoolean(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r100, float r101) {
        return this.f471130c.getFloat(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r100, int r101) {
        return this.f471130c.getInt(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r100, long r101) {
        return this.f471130c.getLong(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r100, String r101) {
        String r102 = this.f471130c.getString(r100, r101);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        Set<String> r102 = this.f471130c.getStringSet(r100, r101);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102;
    }
}
