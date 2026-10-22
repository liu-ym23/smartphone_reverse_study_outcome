package y60;

import android.content.SharedPreferences;
import android.util.ArrayMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f566292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile ConcurrentHashMap<String, Object> f566293b;

    /* JADX INFO: renamed from: y60.a$a, reason: collision with other inner class name */
    public class SharedPreferencesEditorC8307a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f566294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, Object> f566295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f566296c;

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.f566294a = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            if (this.f566296c.f566293b != null) goto L5;
        L6:
            this.f566296c.a();
        L7:
            Map<String, Object> r100 = this.f566295b;
            boolean r101 = this.f566294a;
            SharedPreferences.Editor r102 = this.f566296c.f566292a.edit();
            if (r101 == false) goto L10;
            r102.clear();
            this.f566296c.f566293b.clear();
        L10:
            monitor-enter(r100);
            Iterator<Map.Entry<String, Object>> r103 = r100.entrySet().iterator();     // Catch: Throwable -> L47
        L12:
            boolean r104 = true;
            if (r103.hasNext() == false) goto L42;
            Map.Entry<String, Object> r105 = r103.next();     // Catch: Throwable -> L47
            String r106 = r105.getKey();     // Catch: Throwable -> L47
            Object r107 = r105.getValue();     // Catch: Throwable -> L47
            if (r107 != null) goto L18;
            r102.remove(r106);     // Catch: Throwable -> L47
        L36:
            r104 = false;
        L37:
            if (r106 != null) goto L39;
            r106 = "";
        L39:
            if (r104 == true) goto L40;
            this.f566296c.f566293b.remove(r106);     // Catch: Throwable -> L47
            goto L12
        L40:
            this.f566296c.f566293b.put(r106, r107);     // Catch: Throwable -> L47
            goto L12
        L18:
            if ((r107 instanceof Integer) == false) goto L21;
            r102.putInt(r106, ((Integer) r107).intValue());     // Catch: Throwable -> L47
            goto L37
        L21:
            if ((r107 instanceof Boolean) == false) goto L24;
            r102.putBoolean(r106, ((Boolean) r107).booleanValue());     // Catch: Throwable -> L47
            goto L37
        L24:
            if ((r107 instanceof String) == false) goto L27;
            r102.putString(r106, (String) r107);     // Catch: Throwable -> L47
            goto L37
        L27:
            if ((r107 instanceof Long) == false) goto L30;
            r102.putLong(r106, ((Long) r107).longValue());     // Catch: Throwable -> L47
            goto L37
        L30:
            if ((r107 instanceof Float) == false) goto L33;
            r102.putFloat(r106, ((Float) r107).floatValue());     // Catch: Throwable -> L47
            goto L37
        L33:
            if ((r107 instanceof Set) == false) goto L35;
            r102.putStringSet(r106, (Set) r107);     // Catch: Throwable -> L47
            goto L37
        L35:
            r102.remove(r106);     // Catch: Throwable -> L47
            goto L36
        L42:
            monitor-exit(r100);     // Catch: Throwable -> L47
            r102.commit();
            this.f566295b = new ArrayMap();
            if (this.f566294a == false) goto L46;
            this.f566294a = false;
        L46:
            return true;
        L47:
            th = move-exception;
            throw th;
        L5:
            if (this.f566296c.f566293b.isEmpty() == false) goto L7;
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            commit();
        }

        public SharedPreferencesEditorC8307a(a r100) {
            this.f566296c = r100;
            this.f566295b = new ArrayMap();
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r100) {
            Map<String, Object> r101 = this.f566295b;
            monitor-enter(r101);
            this.f566295b.put(r100, this);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            Map<String, Object> r102 = this.f566295b;
            monitor-enter(r102);
            this.f566295b.put(r100, Boolean.valueOf(r101));     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r100, float r101) {
            Map<String, Object> r102 = this.f566295b;
            monitor-enter(r102);
            this.f566295b.put(r100, Float.valueOf(r101));     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r100, int r101) {
            Map<String, Object> r102 = this.f566295b;
            monitor-enter(r102);
            this.f566295b.put(r100, Integer.valueOf(r101));     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r100, long r101) {
            Map<String, Object> r102 = this.f566295b;
            monitor-enter(r102);
            this.f566295b.put(r100, Long.valueOf(r101));     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r100, String r101) {
            Map<String, Object> r102 = this.f566295b;
            monitor-enter(r102);
            this.f566295b.put(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
            Map<String, Object> r102 = this.f566295b;
            monitor-enter(r102);
            this.f566295b.put(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public final Map<String, ?> a() {
        if (this.f566293b != null) goto L5;
    L6:
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (this.f566293b != null) goto L10;
    L11:
        Map<String, ?> r100 = this.f566292a.getAll();     // Catch: Throwable -> L17
        Object r101 = r100.remove(null);     // Catch: Throwable -> L17
        this.f566293b = new ConcurrentHashMap(r100);     // Catch: Throwable -> L17
        if (r101 == null) goto L14;
        this.f566293b.put("", r101);     // Catch: Throwable -> L17
    L14:
        monitor-exit(this);     // Catch: Throwable -> L17
    L16:
        return this.f566293b;
    L10:
        if (this.f566293b.isEmpty() == false) goto L14;
    L5:
        if (this.f566293b.isEmpty() == false) goto L16;
        goto L6
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new SharedPreferencesEditorC8307a(this);
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        return Collections.unmodifiableMap(a());
    }

    public a(SharedPreferences r100) {
        this.f566293b = null;
        this.f566292a = r100;
    }

    public final Object b(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        return a().get(r100);
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r100) {
        if (this.f566293b == null) goto L15;
        if (this.f566293b.isEmpty() == true) goto L15;
        if (r100 != null) goto L10;
        r100 = "";
    L10:
        if (a().get(r100) == null) goto L12;
        return true;
    L12:
        return false;
    L15:
        return this.f566292a.contains(r100);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        this.f566292a.registerOnSharedPreferenceChangeListener(r100);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        this.f566292a.unregisterOnSharedPreferenceChangeListener(r100);
    }

    public static void c(Object r100, Throwable r101) {
        Objects.toString(r100);
        r101.getMessage();
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r100, boolean r101) {
        if (this.f566293b == null) goto L15;
        if (this.f566293b.isEmpty() == true) goto L15;
        Object r102 = b(r100);     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        return ((Boolean) r102).booleanValue();
    L13:
        return r101;
    L11:
        th = move-exception;
        c(Boolean.valueOf(r101), th);
    L15:
        return this.f566292a.getBoolean(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r100, float r101) {
        if (this.f566293b == null) goto L15;
        if (this.f566293b.isEmpty() == true) goto L15;
        Object r102 = b(r100);     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        return ((Float) r102).floatValue();
    L13:
        return r101;
    L11:
        th = move-exception;
        c(Float.valueOf(r101), th);
    L15:
        return this.f566292a.getFloat(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r100, int r101) {
        if (this.f566293b == null) goto L15;
        if (this.f566293b.isEmpty() == true) goto L15;
        Object r102 = b(r100);     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        return ((Integer) r102).intValue();
    L13:
        return r101;
    L11:
        th = move-exception;
        c(Integer.valueOf(r101), th);
    L15:
        return this.f566292a.getInt(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r100, long r101) {
        if (this.f566293b == null) goto L15;
        if (this.f566293b.isEmpty() == true) goto L15;
        Object r102 = b(r100);     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        return ((Long) r102).longValue();
    L13:
        return r101;
    L11:
        th = move-exception;
        c(Long.valueOf(r101), th);
    L15:
        return this.f566292a.getLong(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r100, String r101) {
        if (this.f566293b == null) goto L15;
        if (this.f566293b.isEmpty() == true) goto L15;
        Object r102 = b(r100);     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        return (String) r102;
    L13:
        return r101;
    L11:
        th = move-exception;
        c(r101, th);
    L15:
        return this.f566292a.getString(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        if (this.f566293b == null) goto L15;
        if (this.f566293b.isEmpty() == true) goto L15;
        Object r102 = b(r100);     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        return (Set) r102;
    L13:
        return r101;
    L11:
        th = move-exception;
        c(r101, th);
    L15:
        return this.f566292a.getStringSet(r100, r101);
    }
}
