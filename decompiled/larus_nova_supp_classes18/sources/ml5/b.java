package ml5;

import android.content.SharedPreferences;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements SharedPreferences {
    public final /* synthetic */ a a;

    public static final class a implements SharedPreferences, SharedPreferences.Editor {
        public final KVRepo a;
        public final List<SharedPreferences.OnSharedPreferenceChangeListener> b;

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences
        public final SharedPreferences.Editor edit() {
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.a.clear();
            return this;
        }

        @Override // android.content.SharedPreferences
        public final Map<String, ?> getAll() {
            return this.a.getAll();
        }

        public a(com.ss.android.lark.storage.kv.repo.a r2) {
            Intrinsics.checkNotNullParameter(r2, "repo");
            this.a = r2;
            this.b = new ArrayList();
        }

        public final void a(String r3) {
            ArrayList r0 = new ArrayList();
            r0.addAll(this.b);
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((SharedPreferences.OnSharedPreferenceChangeListener) r1.next()).onSharedPreferenceChanged(this, r3);
            goto L4
        }

        @Override // android.content.SharedPreferences
        public final boolean contains(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            return this.a.contains(r2);
        }

        @Override // android.content.SharedPreferences
        public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
            if (r2 == null) goto L5;
            ((ArrayList) this.b).add(r2);
            return;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a.remove(r2);
            a(r2);
            return this;
        }

        @Override // android.content.SharedPreferences
        public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
            if (r2 == null) goto L5;
            ((ArrayList) this.b).remove(r2);
            return;
        }

        @Override // android.content.SharedPreferences
        public final boolean getBoolean(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            return this.a.getBoolean(r2, r3);
        }

        @Override // android.content.SharedPreferences
        public final float getFloat(String r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            return this.a.getFloat(r2, r3);
        }

        @Override // android.content.SharedPreferences
        public final int getInt(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            return this.a.getInt(r2, r3);
        }

        @Override // android.content.SharedPreferences
        public final long getLong(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            return this.a.getLong(r2, r3);
        }

        @Override // android.content.SharedPreferences
        public final String getString(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            return this.a.getString(r2, r3);
        }

        @Override // android.content.SharedPreferences
        public final Set<String> getStringSet(String r2, Set<String> r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            return this.a.getStringSet(r2, r3);
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a.putBoolean(r2, r3);
            a(r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a.putFloat(r2, r3);
            a(r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a.putInt(r2, r3);
            a(r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a.putLong(r2, r3);
            a(r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a.putString(r2, r3);
            a(r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r2, Set<String> r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a.putStringSet(r2, r3);
            a(r2);
            return this;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r2) {
        return this.a.contains(r2);
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        a r0 = this.a;
        r0.getClass();
        return r0;
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        return this.a.getAll();
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r2, boolean r3) {
        return this.a.getBoolean(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r2, float r3) {
        return this.a.getFloat(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r2, int r3) {
        return this.a.getInt(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r2, long r3) {
        return this.a.getLong(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r2, String r3) {
        return this.a.getString(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r2, Set<String> r3) {
        return this.a.getStringSet(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        this.a.registerOnSharedPreferenceChangeListener(r2);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        this.a.unregisterOnSharedPreferenceChangeListener(r2);
    }

    public b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "name");
        this.a = new a(ay4.b.b(r4, true, ay4.b.a(r4)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.util.Set] */
    public final <T> T a(Object r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "defValue");
        String r5 = r3.toString();
        if ((r4 instanceof String) == false) goto L9;
        ?? r6 = (T) ((String) r4);
        Object r7 = getString(r5, r6);
        if (r7 != null) goto L24;
        return r6;
    L24:
        return (T) r7;
    L9:
        if ((r4 instanceof Boolean) == false) goto L12;
        return (T) Boolean.valueOf(getBoolean(r5, ((Boolean) r4).booleanValue()));
    L12:
        if ((r4 instanceof Float) == false) goto L15;
        return (T) Float.valueOf(getFloat(r5, ((Number) r4).floatValue()));
    L15:
        if ((r4 instanceof Integer) == false) goto L18;
        return (T) Integer.valueOf(getInt(r5, ((Number) r4).intValue()));
    L18:
        if ((r4 instanceof Long) == false) goto L21;
        return (T) Long.valueOf(getLong(r5, ((Number) r4).longValue()));
    L21:
        if ((r4 instanceof Set) == false) goto L26;
        ?? r8 = (T) ((Set) r4);
        r7 = getStringSet(r5, r8);
        if (r7 != null) goto L24;
        return r8;
    L26:
        throw new IllegalStateException("Unsupported type in SharedPreferences: " + r4.getClass());
    }

    public final void b(Object r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (r5 == null) goto L24;
        String r6 = r4.toString();
        a r0 = this.a;
        r0.getClass();
        if ((r5 instanceof String) == false) goto L8;
        r0.putString(r6, (String) r5);
        return;
    L8:
        if ((r5 instanceof Boolean) == false) goto L11;
        r0.putBoolean(r6, ((Boolean) r5).booleanValue());
        return;
    L11:
        if ((r5 instanceof Float) == false) goto L14;
        r0.putFloat(r6, ((Number) r5).floatValue());
        return;
    L14:
        if ((r5 instanceof Integer) == false) goto L17;
        r0.putInt(r6, ((Number) r5).intValue());
        return;
    L17:
        if ((r5 instanceof Long) == false) goto L20;
        r0.putLong(r6, ((Number) r5).longValue());
        return;
    L20:
        if ((r5 instanceof Set) == false) goto L30;
        r0.putStringSet(r6, (Set) r5);
        return;
    L30:
        return;
    L24:
        throw new IllegalStateException("Required value was null.".toString());
    }
}
