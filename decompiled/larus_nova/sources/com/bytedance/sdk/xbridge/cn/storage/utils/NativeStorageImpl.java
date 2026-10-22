package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.cn.utils.i;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeStorageImpl implements com.bytedance.sdk.xbridge.cn.storage.utils.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f270142c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f270143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f270144b;

    public static final class Companion extends SingletonHolder<NativeStorageImpl, Context> {

        /* JADX INFO: renamed from: com.bytedance.sdk.xbridge.cn.storage.utils.NativeStorageImpl$Companion$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Context, NativeStorageImpl> {
            public static final AnonymousClass1 INSTANCE = null;

            static {
                INSTANCE = new AnonymousClass1();
            }

            public AnonymousClass1() {
                super(1, NativeStorageImpl.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ NativeStorageImpl invoke(Context r100) {
                return invoke2(r100);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final NativeStorageImpl invoke2(Context r100) {
                return new NativeStorageImpl(r100);
            }
        }

        public Companion() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f270145a = null;

        static {
            int[] r100 = new int[XReadableType.values().length];
            r100[XReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[XReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[XReadableType.Long.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[XReadableType.Number.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[XReadableType.String.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[XReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[XReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f270145a = r100;
        }
    }

    static {
        f270142c = new Companion();
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.b
    public final Set<String> c() {
        SharedPreferences r100 = this.f270144b;
        if (r100 == null) goto L9;
        Map<String, ?> r101 = r100.getAll();
        if (r101 == null) goto L9;
        Set<String> r102 = r101.keySet();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return SetsKt.emptySet();
    }

    public final Context getContext() {
        return this.f270143a;
    }

    public NativeStorageImpl(Context r100) {
        this.f270143a = r100;
        if (r100 == null) goto L5;
        SharedPreferences r101 = r100.getSharedPreferences("xbridge-storage", 0);
    L6:
        this.f270144b = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.b
    public final boolean a(String r100) {
        if (r100 == null) goto L22;
        SharedPreferences r101 = this.f270144b;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.contains(r100) == true) goto L10;
        return false;
    L10:
        SharedPreferences r102 = this.f270144b;
        Unit r103 = null;
        if (r102 == null) goto L13;
        SharedPreferences.Editor r104 = r102.edit();
    L14:
        if (r104 == null) goto L18;
        SharedPreferences.Editor r105 = r104.remove(r100);
        if (r105 == null) goto L18;
        r105.apply();
        r103 = Unit.INSTANCE;
    L18:
        if (r103 != null) goto L20;
        return false;
    L20:
        return true;
    L13:
        r104 = null;
        goto L14
    L22:
        return false;
    }

    public final SharedPreferences h(String r100) {
        Context r101 = this.f270143a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSharedPreferences(r100 + "-xbridge-storage", 0);
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.a
    public final boolean b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        if (r101 == null) goto L22;
        SharedPreferences r102 = h(r100);
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.contains(r101) == true) goto L10;
        return false;
    L10:
        SharedPreferences r103 = h(r100);
        Unit r104 = null;
        if (r103 == null) goto L13;
        SharedPreferences.Editor r105 = r103.edit();
    L14:
        if (r105 == null) goto L18;
        SharedPreferences.Editor r106 = r105.remove(r101);
        if (r106 == null) goto L18;
        r106.apply();
        r104 = Unit.INSTANCE;
    L18:
        if (r104 != null) goto L20;
        return false;
    L20:
        return true;
    L13:
        r105 = null;
        goto L14
    L22:
        return false;
    }

    public static String k(Object r100, String r101, String r102) {
        new LinkedHashMap();
        if ((r100 instanceof Boolean) == false) goto L6;
        Gson r103 = te7.c.f545587a;
        String r104 = te7.c.b(new e(XReadableType.Boolean.name(), r100.toString(), null));
    L24:
        if (r101 != null) goto L26;
        r101 = "unknown";
    L26:
        i.b(r101, "content:" + r104, "BridgeProcessing", r102);
        return r104;
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        Gson r105 = te7.c.f545587a;
        r104 = te7.c.b(new e(XReadableType.Int.name(), r100.toString(), null));
        goto L24
    L9:
        if ((r100 instanceof Long) == false) goto L12;
        Gson r106 = te7.c.f545587a;
        r104 = te7.c.b(new e(XReadableType.Long.name(), r100.toString(), null));
        goto L24
    L12:
        if ((r100 instanceof Double) == false) goto L15;
        Gson r107 = te7.c.f545587a;
        r104 = te7.c.b(new e(XReadableType.Number.name(), r100.toString(), null));
        goto L24
    L15:
        if ((r100 instanceof String) == false) goto L18;
        Gson r108 = te7.c.f545587a;
        r104 = te7.c.b(new e(XReadableType.String.name(), r100.toString(), null));
        goto L24
    L18:
        if ((r100 instanceof List) == false) goto L21;
        Gson r109 = te7.c.f545587a;
        r104 = te7.c.b(new e(XReadableType.Array.name(), te7.c.b(r100), null));
        goto L24
    L21:
        if ((r100 instanceof Map) == false) goto L23;
        Gson r110 = te7.c.f545587a;
        r104 = te7.c.b(new e(XReadableType.Map.name(), te7.c.b(r100), null));
        goto L24
    L23:
        r104 = "";
        goto L24
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.b
    public final Object e(String r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        SharedPreferences r103 = this.f270144b;
        if (r103 != null) goto L9;
        return null;
    L9:
        if (r103.contains(r100) == true) goto L11;
        return null;
    L11:
        String r104 = r103.getString(r100, "");
        if (TextUtils.isEmpty(r104) == false) goto L14;
        return null;
    L14:
        Intrinsics.checkNotNull(r104);
        return i(r100, r104, r101, r102);
    }

    public static String j(Object r100, long r101, String r102, String r103) {
        long r104 = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(r101);
        new LinkedHashMap();
        if ((r100 instanceof Boolean) == false) goto L6;
        Gson r105 = te7.c.f545587a;
        String r106 = te7.c.b(new e(XReadableType.Boolean.name(), r100.toString(), Long.valueOf(r104)));
    L24:
        if (r102 != null) goto L26;
        r102 = "unknown";
    L26:
        i.b(r102, "expiredTime:" + r104 + "|content:" + r106, "BridgeProcessing", r103);
        return r106;
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        Gson r107 = te7.c.f545587a;
        r106 = te7.c.b(new e(XReadableType.Int.name(), r100.toString(), Long.valueOf(r104)));
        goto L24
    L9:
        if ((r100 instanceof Long) == false) goto L12;
        Gson r108 = te7.c.f545587a;
        r106 = te7.c.b(new e(XReadableType.Long.name(), r100.toString(), Long.valueOf(r104)));
        goto L24
    L12:
        if ((r100 instanceof Double) == false) goto L15;
        Gson r109 = te7.c.f545587a;
        r106 = te7.c.b(new e(XReadableType.Number.name(), r100.toString(), Long.valueOf(r104)));
        goto L24
    L15:
        if ((r100 instanceof String) == false) goto L18;
        Gson r110 = te7.c.f545587a;
        r106 = te7.c.b(new e(XReadableType.String.name(), r100.toString(), Long.valueOf(r104)));
        goto L24
    L18:
        if ((r100 instanceof List) == false) goto L21;
        Gson r111 = te7.c.f545587a;
        r106 = te7.c.b(new e(XReadableType.Array.name(), te7.c.b(r100), Long.valueOf(r104)));
        goto L24
    L21:
        if ((r100 instanceof Map) == false) goto L23;
        Gson r112 = te7.c.f545587a;
        r106 = te7.c.b(new e(XReadableType.Map.name(), te7.c.b(r100), Long.valueOf(r104)));
        goto L24
    L23:
        r106 = "";
        goto L24
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.a
    public final Object d(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        if (r101 != null) goto L5;
        return null;
    L5:
        SharedPreferences r104 = h(r100);
        if (r104 != null) goto L9;
        return null;
    L9:
        if (r104.contains(r101) == true) goto L11;
        return null;
    L11:
        String r105 = r104.getString(r101, "");
        if (TextUtils.isEmpty(r105) == false) goto L14;
        return null;
    L14:
        Intrinsics.checkNotNull(r105);
        return i(r101, r105, r102, r103);
    }

    public final Object i(String r100, String r101, String r102, String r103) {
        Gson r104 = te7.c.f545587a;
        e r105 = (e) te7.c.a(r101, e.class);
        Long r106 = r105.a();
        long r107 = System.currentTimeMillis();
        if (r102 != null) goto L5;
        r102 = "unknown";
    L5:
        StringBuilder r108 = new StringBuilder("expiredTime:");
        if (r106 != null) goto L8;
        Object r109 = "null";
    L9:
        r108.append(r109);
        r108.append("|curTime:");
        r108.append(r107);
        r108.append("|storageVal:");
        r108.append(r105);
        i.b(r102, r108.toString(), "BridgeProcessing", r103);
        if (r106 != null) goto L12;
    L15:
        String r110 = r105.b();
        XReadableType r111 = XReadableType.valueOf(r105.getType());
        switch(a.f270145a[r111.ordinal()]) {
            case 1: goto L25;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            default: goto L32;
        };
    L32:
        return null;
    L26:
        return te7.c.a(r110, Map.class);
    L27:
        return te7.c.a(r110, List.class);
    L28:
        return r110;
    L29:
        return Double.valueOf(CastDoubleProtector.parseDouble(r110));
    L30:
        return Long.valueOf(CastLongProtector.parseLong(r110));
    L31:
        return Integer.valueOf(CastIntegerProtector.parseInt(r110));
    L25:
        return Boolean.valueOf(Boolean.parseBoolean(r110));
    L12:
        if (r107 <= r106.longValue()) goto L15;
        a(r100);
        return null;
    L8:
        r109 = r106;
        goto L9
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.b
    public final boolean g(String r100, Object r101, Long r102, String r103, String r110) {
        if (r100 == null) goto L29;
        if (r101 == null) goto L29;
        Unit r104 = null;
        if (r102 == null) goto L17;
        SharedPreferences r105 = this.f270144b;
        if (r105 == null) goto L10;
        SharedPreferences.Editor r106 = r105.edit();
    L11:
        if (r106 == null) goto L15;
        SharedPreferences.Editor r107 = r106.putString(r100, j(r101, r102.longValue(), r103, r110));
        if (r107 == null) goto L15;
        r107.apply();
        r104 = Unit.INSTANCE;
    L15:
        if (r104 != null) goto L27;
        return false;
    L27:
        return true;
    L10:
        r106 = null;
        goto L11
    L17:
        SharedPreferences r108 = this.f270144b;
        if (r108 == null) goto L20;
        SharedPreferences.Editor r109 = r108.edit();
    L21:
        if (r109 == null) goto L25;
        SharedPreferences.Editor r111 = r109.putString(r100, k(r101, r103, r110));
        if (r111 == null) goto L25;
        r111.apply();
        r104 = Unit.INSTANCE;
    L25:
        if (r104 != null) goto L30;
        return false;
    L30:
        return true;
    L20:
        r109 = null;
    L29:
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.a
    public final boolean f(String r100, String r101, Object r102, Long r103, String r104, String r110) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        if (r101 == null) goto L29;
        if (r102 == null) goto L29;
        Unit r105 = null;
        if (r103 == null) goto L17;
        SharedPreferences r106 = h(r100);
        if (r106 == null) goto L10;
        SharedPreferences.Editor r107 = r106.edit();
    L11:
        if (r107 == null) goto L15;
        SharedPreferences.Editor r108 = r107.putString(r101, j(r102, r103.longValue(), r104, r110));
        if (r108 == null) goto L15;
        r108.apply();
        r105 = Unit.INSTANCE;
    L15:
        if (r105 != null) goto L27;
        return false;
    L27:
        return true;
    L10:
        r107 = null;
        goto L11
    L17:
        SharedPreferences r109 = h(r100);
        if (r109 == null) goto L20;
        SharedPreferences.Editor r111 = r109.edit();
    L21:
        if (r111 == null) goto L25;
        SharedPreferences.Editor r112 = r111.putString(r101, k(r102, r104, r110));
        if (r112 == null) goto L25;
        r112.apply();
        r105 = Unit.INSTANCE;
    L25:
        if (r105 != null) goto L30;
        return false;
    L30:
        return true;
    L20:
        r111 = null;
    L29:
        return false;
    }
}
