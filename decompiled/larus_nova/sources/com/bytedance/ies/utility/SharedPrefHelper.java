package com.bytedance.ies.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.LruCache;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.obric.miniapp.alarm.AccountType;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes19.dex */
public final class SharedPrefHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static LruCache<String, SharedPrefHelper> f249251c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f249252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f249253b;

    public static final enum Type extends Enum<Type> {
        public static final Type ALL = null;
        public static final Type BOOLEAN = null;
        public static final Type FLOAT = null;
        public static final Type INTEGER = null;
        public static final Type LONG = null;
        public static final Type STRING = null;
        public static final Type STRING_SET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f249254a = null;

        static {
            Type r100 = new Type("STRING", 0);
            STRING = r100;
            Type r101 = new Type("INTEGER", 1);
            INTEGER = r101;
            Type r102 = new Type("BOOLEAN", 2);
            BOOLEAN = r102;
            Type r103 = new Type("FLOAT", 3);
            FLOAT = r103;
            Type r104 = new Type("LONG", 4);
            LONG = r104;
            Type r105 = new Type("STRING_SET", 5);
            STRING_SET = r105;
            Type r110 = new Type(AccountType.ALL, 6);
            ALL = r110;
            f249254a = new Type[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static Type[] values() {
            return (Type[]) f249254a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f249255a = null;

        static {
            int[] r100 = new int[Type.values().length];
            f249255a = r100;
            r100[Type.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f249255a[Type.INTEGER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f249255a[Type.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f249255a[Type.FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f249255a[Type.LONG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f249255a[Type.STRING_SET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f249255a[Type.ALL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public final void a() {
        SharedPreferences.Editor r100 = this.f249253b;
        if (r100 == null) goto L6;
        SharedPrefsEditorCompat.apply(r100);
        return;
    }

    public final Map<String, ?> e() {
        return (Map) d("", Type.ALL, null);
    }

    public static SharedPrefHelper b(Context r100) {
        return c(r100, "default_app_sp");
    }

    public SharedPrefHelper(Context r100, String r101) {
        this.f249252a = r100.getSharedPreferences(r101, 0);
    }

    public static SharedPrefHelper c(Context r100, String r101) {
        if (r100 == null) goto L11;
        if (f249251c != null) goto L6;
        f249251c = new LruCache(3);
    L6:
        SharedPrefHelper r102 = f249251c.get(r101);
        if (r102 != null) goto L12;
        SharedPrefHelper r103 = new SharedPrefHelper(r100, r101);
        f249251c.put(r101, r103);
        return r103;
    L12:
        return r102;
    L11:
        throw new NullPointerException("null context!!");
    }

    public final boolean f(String r100, boolean r101) {
        return ((Boolean) d(r100, Type.BOOLEAN, Boolean.valueOf(r101))).booleanValue();
    }

    public final float g(String r100, float r101) {
        return ((Float) d(r100, Type.FLOAT, Float.valueOf(r101))).floatValue();
    }

    public final int h(String r100, int r101) {
        return ((Integer) d(r100, Type.INTEGER, Integer.valueOf(r101))).intValue();
    }

    public final long i(String r100, long r101) {
        return ((Long) d(r100, Type.LONG, Long.valueOf(r101))).longValue();
    }

    public final String j(String r100, String r101) {
        return (String) d(r100, Type.STRING, r101);
    }

    public final Set<String> k(String r100, Set<String> r101) {
        return (Set) d(r100, Type.STRING_SET, r101);
    }

    public final void l(String r100, Object r101) {
        if (this.f249253b != null) goto L6;
        this.f249253b = this.f249252a.edit();
    L6:
        if ((r101 instanceof String) == false) goto L9;
        this.f249253b.putString(r100, (String) r101);
        return;
    L9:
        if ((r101 instanceof Integer) == false) goto L12;
        this.f249253b.putInt(r100, ((Integer) r101).intValue());
        return;
    L12:
        if ((r101 instanceof Boolean) == false) goto L15;
        this.f249253b.putBoolean(r100, ((Boolean) r101).booleanValue());
        return;
    L15:
        if ((r101 instanceof Float) == false) goto L18;
        this.f249253b.putFloat(r100, ((Float) r101).floatValue());
        return;
    L18:
        if ((r101 instanceof Long) == false) goto L21;
        this.f249253b.putLong(r100, ((Long) r101).longValue());
        return;
    L21:
        if ((r101 instanceof Set) == false) goto L23;
        this.f249253b.putStringSet(r100, (Set) r101);
        return;
    L23:
        this.f249253b.putString(r100, String.valueOf(r101));
    }

    public final void m(String r100, Object r101) {
        l(r100, r101);
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T d(String r100, Type r101, Object r102) {
        switch(a.f249255a[r101.ordinal()]) {
            case 1: goto L12;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            default: goto L19;
        };
    L19:
        return r102;
    L13:
        return (T) this.f249252a.getAll();
    L14:
        return (T) this.f249252a.getStringSet(r100, (Set) r102);
    L15:
        return (T) Long.valueOf(this.f249252a.getLong(r100, ((Long) r102).longValue()));
    L16:
        return (T) Float.valueOf(this.f249252a.getFloat(r100, ((Float) r102).floatValue()));
    L17:
        return (T) Boolean.valueOf(this.f249252a.getBoolean(r100, ((Boolean) r102).booleanValue()));
    L18:
        return (T) Integer.valueOf(this.f249252a.getInt(r100, ((Integer) r102).intValue()));
    L12:
        return (T) this.f249252a.getString(r100, (String) r102);
    }
}
