package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.cn.utils.i;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class UserDomainNativeStorageImpl implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f270148b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f270149a;

    public static final class Companion extends SingletonHolder<UserDomainNativeStorageImpl, Context> {

        /* JADX INFO: renamed from: com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainNativeStorageImpl$Companion$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Context, UserDomainNativeStorageImpl> {
            public static final AnonymousClass1 INSTANCE = null;

            static {
                INSTANCE = new AnonymousClass1();
            }

            public AnonymousClass1() {
                super(1, UserDomainNativeStorageImpl.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ UserDomainNativeStorageImpl invoke(Context r100) {
                return invoke2(r100);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final UserDomainNativeStorageImpl invoke2(Context r100) {
                return new UserDomainNativeStorageImpl(r100);
            }
        }

        public Companion() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f270150a = null;

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
            f270150a = r100;
        }
    }

    static {
        f270148b = new Companion();
    }

    public final Context getContext() {
        return this.f270149a;
    }

    public UserDomainNativeStorageImpl(Context r100) {
        this.f270149a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.c
    public final Set<String> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "storageName");
        SharedPreferences r101 = e(r100);
        if (r101 == null) goto L9;
        Map<String, ?> r102 = r101.getAll();
        if (r102 == null) goto L9;
        Set<String> r103 = r102.keySet();
        if (r103 == null) goto L9;
        return r103;
    L9:
        return SetsKt.emptySet();
    }

    public final SharedPreferences e(String r100) {
        Context r101 = this.f270149a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSharedPreferences(r100 + "_xbridge_storage", 0);
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.c
    public final Pair<Boolean, Boolean> b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "storageName");
        Intrinsics.checkNotNullParameter(r101, "key");
        SharedPreferences r102 = e(r100);
        if (r102 != null) goto L7;
        Boolean r103 = Boolean.FALSE;
        return new Pair(r103, r103);
    L7:
        if (r102.contains(r101) == true) goto L10;
        Boolean r104 = Boolean.FALSE;
        return new Pair(r104, r104);
    L10:
        SharedPreferences r105 = e(r100);
        Unit r106 = null;
        if (r105 == null) goto L13;
        SharedPreferences.Editor r107 = r105.edit();
    L14:
        if (r107 == null) goto L18;
        SharedPreferences.Editor r108 = r107.remove(r101);
        if (r108 == null) goto L18;
        r108.apply();
        r106 = Unit.INSTANCE;
    L18:
        if (r106 == null) goto L20;
        Boolean r109 = Boolean.TRUE;
        return new Pair(r109, r109);
    L20:
        return new Pair(Boolean.TRUE, Boolean.FALSE);
    L13:
        r107 = null;
        goto L14
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.c
    public final Triple<Boolean, Boolean, Object> c(String r110, String r111, String r112, String r210) {
        Intrinsics.checkNotNullParameter(r110, "storageName");
        Intrinsics.checkNotNullParameter(r111, "key");
        SharedPreferences r100 = e(r110);
        String r101 = "unknown";
        if (r100 != null) goto L10;
        if (r112 == null) goto L7;
        r101 = r112;
    L7:
        i.b(r101, "The storage of uid is not exist. So data is not exist.", "BridgeProcessing", r210);
        Boolean r102 = Boolean.FALSE;
        return new Triple(r102, r102, null);
    L10:
        if (r100.contains(r111) == true) goto L16;
        if (r112 == null) goto L14;
        r101 = r112;
    L14:
        i.b(r101, "Data is not exist.", "BridgeProcessing", r210);
        Boolean r103 = Boolean.FALSE;
        return new Triple(r103, r103, null);
    L16:
        String r113 = "";
        String r104 = r100.getString(r111, "");
        if (r104 != null) goto L19;
    L22:
        boolean r114 = true;
    L23:
        if (r114 == false) goto L80;
        if (r112 == null) goto L27;
        r101 = r112;
    L27:
        i.b(r101, "key:" + r111 + ", Data is not exist.", "BridgeProcessing", r210);
        Boolean r105 = Boolean.FALSE;
        return new Triple(r105, r105, null);
    L80:
        Gson r115 = te7.c.f545587a;     // Catch: Exception -> L71
        if (r104 == null) goto L33;
        r113 = r104;
    L33:
        h r106 = (h) te7.c.a(r113, h.class);     // Catch: Exception -> L71
        Long r116 = r106.b();     // Catch: Exception -> L71
        long r117 = System.currentTimeMillis();     // Catch: Exception -> L71
        if (r112 != null) goto L36;
        String r118 = "unknown";
    L37:
        StringBuilder r119 = new StringBuilder("expiredTime:");     // Catch: Exception -> L71
        if (r116 != null) goto L40;
        Object r107 = "null";
    L41:
        r119.append(r107);     // Catch: Exception -> L71
        r119.append("|curTime:");     // Catch: Exception -> L71
        r119.append(r117);     // Catch: Exception -> L71
        r119.append("|storageVal:");     // Catch: Exception -> L71
        r119.append(r106);     // Catch: Exception -> L71
        i.b(r118, r119.toString(), "BridgeProcessing", r210);     // Catch: Exception -> L71
        if (r116 != null) goto L45;
    L53:
        String r120 = r106.d();     // Catch: Exception -> L71
        String r121 = r106.getType();     // Catch: Exception -> L71
        if (r121 == null) goto L56;
        if (r120 == null) goto L70;
        f(r110, r111, r106, r112, r210);     // Catch: Exception -> L71
        Object r122 = r120;
        switch(a.f270150a[XReadableType.valueOf(r121).ordinal()]) {
            case 1: goto L66;
            case 2: goto L65;
            case 3: goto L64;
            case 4: goto L63;
            case 5: goto L68;
            case 6: goto L62;
            case 7: goto L61;
            default: goto L60;
        };     // Catch: Exception -> L71
    L60:
        r122 = null;
        goto L68
    L61:
        r122 = te7.c.a(r120, Map.class);     // Catch: Exception -> L71
        goto L68
    L62:
        r122 = te7.c.a(r120, List.class);     // Catch: Exception -> L71
        goto L68
    L63:
        r122 = Double.valueOf(CastDoubleProtector.parseDouble(r120));     // Catch: Exception -> L71
        goto L68
    L64:
        r122 = Long.valueOf(CastLongProtector.parseLong(r120));     // Catch: Exception -> L71
        goto L68
    L65:
        r122 = Integer.valueOf(CastIntegerProtector.parseInt(r120));     // Catch: Exception -> L71
        goto L68
    L66:
        r122 = Boolean.valueOf(Boolean.parseBoolean(r120));     // Catch: Exception -> L71
    L68:
        return new Triple(Boolean.TRUE, Boolean.FALSE, r122);
    L70:
        return new Triple(Boolean.TRUE, Boolean.FALSE, null);
    L56:
        return new Triple(Boolean.TRUE, Boolean.FALSE, null);
    L45:
        if (r117 <= r116.longValue()) goto L53;
        if (r112 != null) goto L48;
        String r108 = "unknown";
    L78:
        i.b(r108, "The data is expired. expiredTime:" + r116 + "|curTime:" + r117 + "|storageVal:" + r106, "BridgeProcessing", r210);     // Catch: Exception -> L51
        Pair<Boolean, Boolean> r109 = b(r110, r111);     // Catch: Exception -> L51
        r109.component1().booleanValue();     // Catch: Exception -> L51
        r109.component2().booleanValue();     // Catch: Exception -> L51
        Boolean r123 = Boolean.TRUE;     // Catch: Exception -> L51
        return new Triple(r123, r123, null);
    L51:
        e = e;
        boolean r124 = true;
    L73:
        if (r112 == null) goto L76;
        r101 = r112;
    L76:
        i.b(r101, "JSON deserialization failed.Error:" + e, "BridgeProcessing", r210);
        return new Triple(Boolean.TRUE, Boolean.valueOf(r124), null);
    L48:
        r108 = r112;
        goto L78
    L40:
        r107 = r116;
        goto L41
    L36:
        r118 = r112;
    L71:
        e = e;
        r124 = false;
        goto L73
    L19:
        if (r104.length() == 0) goto L22;
        r114 = false;
        goto L23
    }

    public final void f(String r110, String r111, h r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "storageName");
        Intrinsics.checkNotNullParameter(r111, "key");
        Intrinsics.checkNotNullParameter(r112, "userDomainStorageValue");
        long r100 = System.currentTimeMillis();
        Gson r101 = te7.c.f545587a;
        String r115 = te7.c.b(new h(r112.getType(), r112.d(), r112.a(), Long.valueOf(r100), r112.c(), r112.b()));
        if (r113 != null) goto L5;
        r113 = "unknown";
    L5:
        i.b(r113, "modify: key:" + r111 + ",content:" + r115, "BridgeProcessing", r114);
        SharedPreferences r116 = e(r110);
        if (r116 == null) goto L8;
        SharedPreferences.Editor r117 = r116.edit();
    L9:
        if (r117 == null) goto L14;
        SharedPreferences.Editor r118 = r117.putString(r111, r115);
        if (r118 == null) goto L15;
        r118.apply();
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r117 = null;
        goto L9
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.c
    public final boolean d(String r210, String r211, Object r212, Long r213, String r214, String r215) {
        Intrinsics.checkNotNullParameter(r210, "storageName");
        if (r211 == null) goto L72;
        if (r212 == null) goto L72;
        Intrinsics.checkNotNullParameter(r210, "storageName");
        Intrinsics.checkNotNullParameter(r211, "key");
        SharedPreferences r100 = e(r210);
        Unit r101 = null;
        if (r100 == null) goto L8;
        String r102 = r100.getString(r211, "");
    L10:
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == false) goto L18;
        Long r104 = null;
    L19:
        if (r104 == null) goto L21;
        long r105 = r104.longValue();
    L22:
        long r110 = System.currentTimeMillis();
        long r111 = System.currentTimeMillis();
        Long r106 = Long.valueOf(r105);
        Long r107 = Long.valueOf(r111);
        Long r108 = Long.valueOf(r110);
        if (r213 == null) goto L27;
        long r112 = r213.longValue();
        if (r112 <= 0) goto L27;
        Long r113 = Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(r112));
    L29:
        if ((r212 instanceof Boolean) == false) goto L32;
        String r109 = XReadableType.Boolean.name();
        String r114 = String.valueOf(((Boolean) r212).booleanValue());
    L49:
        String r115 = r114;
        String r116 = r109;
    L51:
        String r117 = te7.c.b(new h(r116, r115, r106, r107, r108, r113));
        if (r214 != null) goto L54;
        String r118 = "unknown";
    L55:
        i.b(r118, "createTime:" + r106 + ",last_access_time:" + r107 + ",last_modified_time:" + r108 + ",expiredTime:" + r113 + "|content:" + r117, "BridgeProcessing", r215);
        if (r117.length() != 0) goto L58;
        boolean r119 = true;
    L59:
        if (r119 == false) goto L61;
        return false;
    L61:
        SharedPreferences r120 = e(r210);
        if (r120 == null) goto L64;
        SharedPreferences.Editor r121 = r120.edit();
    L65:
        if (r121 == null) goto L69;
        SharedPreferences.Editor r122 = r121.putString(r211, r117);
        if (r122 == null) goto L69;
        r122.apply();
        r101 = Unit.INSTANCE;
    L69:
        if (r101 != null) goto L71;
        return false;
    L71:
        return true;
    L64:
        r121 = null;
        goto L65
    L58:
        r119 = false;
        goto L59
    L54:
        r118 = r214;
        goto L55
    L32:
        if ((r212 instanceof Integer) == false) goto L35;
        r109 = XReadableType.Int.name();
        r114 = String.valueOf(((Number) r212).intValue());
        goto L49
    L35:
        if ((r212 instanceof Long) == false) goto L38;
        r109 = XReadableType.Long.name();
        r114 = String.valueOf(((Number) r212).longValue());
        goto L49
    L38:
        if ((r212 instanceof Double) == false) goto L41;
        r109 = XReadableType.Number.name();
        r114 = String.valueOf(((Number) r212).doubleValue());
        goto L49
    L41:
        if ((r212 instanceof String) == false) goto L44;
        r109 = XReadableType.String.name();
        r114 = r212.toString();
        goto L49
    L44:
        if ((r212 instanceof List) == false) goto L47;
        r109 = XReadableType.Array.name();
        r114 = te7.c.b(r212);
        goto L49
    L47:
        if ((r212 instanceof Map) == false) goto L50;
        r109 = XReadableType.Map.name();
        r114 = te7.c.b(r212);
        goto L49
    L50:
        r116 = "";
        r115 = r116;
    L27:
        r113 = null;
        goto L29
    L21:
        r105 = System.currentTimeMillis();
        goto L22
    L18:
        Gson r123 = te7.c.f545587a;
        Intrinsics.checkNotNull(r102);
        r104 = ((h) te7.c.a(r102, h.class)).a();
        goto L19
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L8:
        r102 = null;
    L72:
        return false;
    }
}
