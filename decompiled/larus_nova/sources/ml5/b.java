package ml5;

import android.content.SharedPreferences;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f514368a;

    public static final class a implements SharedPreferences, SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KVRepo f514369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<SharedPreferences.OnSharedPreferenceChangeListener> f514370b;

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
            this.f514369a.clear();
            return this;
        }

        @Override // android.content.SharedPreferences
        public final Map<String, ?> getAll() {
            return this.f514369a.getAll();
        }

        public a(com.ss.android.lark.storage.kv.repo.a r100) {
            Intrinsics.checkNotNullParameter(r100, "repo");
            this.f514369a = r100;
            this.f514370b = new ArrayList();
        }

        public final void a(String r100) {
            ArrayList r101 = new ArrayList();
            r101.addAll(this.f514370b);
            Iterator r102 = r101.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((SharedPreferences.OnSharedPreferenceChangeListener) r102.next()).onSharedPreferenceChanged(this, r100);
            goto L4
        }

        @Override // android.content.SharedPreferences
        public final boolean contains(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return this.f514369a.contains(r100);
        }

        @Override // android.content.SharedPreferences
        public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
            if (r100 == null) goto L5;
            ((ArrayList) this.f514370b).add(r100);
            return;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f514369a.remove(r100);
            a(r100);
            return this;
        }

        @Override // android.content.SharedPreferences
        public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
            if (r100 == null) goto L5;
            ((ArrayList) this.f514370b).remove(r100);
            return;
        }

        @Override // android.content.SharedPreferences
        public final boolean getBoolean(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return this.f514369a.getBoolean(r100, r101);
        }

        @Override // android.content.SharedPreferences
        public final float getFloat(String r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return this.f514369a.getFloat(r100, r101);
        }

        @Override // android.content.SharedPreferences
        public final int getInt(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return this.f514369a.getInt(r100, r101);
        }

        @Override // android.content.SharedPreferences
        public final long getLong(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return this.f514369a.getLong(r100, r101);
        }

        @Override // android.content.SharedPreferences
        public final String getString(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return this.f514369a.getString(r100, r101);
        }

        @Override // android.content.SharedPreferences
        public final Set<String> getStringSet(String r100, Set<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return this.f514369a.getStringSet(r100, r101);
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f514369a.putBoolean(r100, r101);
            a(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f514369a.putFloat(r100, r101);
            a(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f514369a.putInt(r100, r101);
            a(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f514369a.putLong(r100, r101);
            a(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f514369a.putString(r100, r101);
            a(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f514369a.putStringSet(r100, r101);
            a(r100);
            return this;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r100) {
        return this.f514368a.contains(r100);
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        a r100 = this.f514368a;
        r100.getClass();
        return r100;
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        return this.f514368a.getAll();
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r100, boolean r101) {
        return this.f514368a.getBoolean(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r100, float r101) {
        return this.f514368a.getFloat(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r100, int r101) {
        return this.f514368a.getInt(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r100, long r101) {
        return this.f514368a.getLong(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r100, String r101) {
        return this.f514368a.getString(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        return this.f514368a.getStringSet(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        this.f514368a.registerOnSharedPreferenceChangeListener(r100);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        this.f514368a.unregisterOnSharedPreferenceChangeListener(r100);
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f514368a = new a(ay4.b.b(r100, true, ay4.b.a(r100)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.util.Set] */
    public final <T> T a(Object r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        String r102 = r100.toString();
        if ((r101 instanceof String) == false) goto L9;
        ?? r103 = (T) ((String) r101);
        Object r104 = getString(r102, r103);
        if (r104 != null) goto L24;
        return r103;
    L24:
        return (T) r104;
    L9:
        if ((r101 instanceof Boolean) == false) goto L12;
        return (T) Boolean.valueOf(getBoolean(r102, ((Boolean) r101).booleanValue()));
    L12:
        if ((r101 instanceof Float) == false) goto L15;
        return (T) Float.valueOf(getFloat(r102, ((Number) r101).floatValue()));
    L15:
        if ((r101 instanceof Integer) == false) goto L18;
        return (T) Integer.valueOf(getInt(r102, ((Number) r101).intValue()));
    L18:
        if ((r101 instanceof Long) == false) goto L21;
        return (T) Long.valueOf(getLong(r102, ((Number) r101).longValue()));
    L21:
        if ((r101 instanceof Set) == false) goto L26;
        ?? r105 = (T) ((Set) r101);
        r104 = getStringSet(r102, r105);
        if (r104 != null) goto L24;
        return r105;
    L26:
        throw new IllegalStateException("Unsupported type in SharedPreferences: " + r101.getClass());
    }

    public final void b(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L24;
        String r102 = r100.toString();
        a r103 = this.f514368a;
        r103.getClass();
        if ((r101 instanceof String) == false) goto L8;
        r103.putString(r102, (String) r101);
        return;
    L8:
        if ((r101 instanceof Boolean) == false) goto L11;
        r103.putBoolean(r102, ((Boolean) r101).booleanValue());
        return;
    L11:
        if ((r101 instanceof Float) == false) goto L14;
        r103.putFloat(r102, ((Number) r101).floatValue());
        return;
    L14:
        if ((r101 instanceof Integer) == false) goto L17;
        r103.putInt(r102, ((Number) r101).intValue());
        return;
    L17:
        if ((r101 instanceof Long) == false) goto L20;
        r103.putLong(r102, ((Number) r101).longValue());
        return;
    L20:
        if ((r101 instanceof Set) == false) goto L30;
        r103.putStringSet(r102, (Set) r101);
        return;
    L30:
        return;
    L24:
        throw new IllegalStateException("Required value was null.".toString());
    }
}
