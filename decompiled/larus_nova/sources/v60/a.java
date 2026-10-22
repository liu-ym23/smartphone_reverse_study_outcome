package v60;

import a70.c;
import android.content.SharedPreferences;
import com.bytedance.android.live.core.setting.d6;
import com.bytedance.android.live.core.setting.v2.cache.ICacheManger;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w60.b;
import y60.d;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f553369a = null;

    public a() {
    }

    static {
        f553369a = new a();
    }

    public static Map c() {
        return SettingIncStrategy.f65434a.c();
    }

    public static Object e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (StringsKt.startsWith$default(r100, "__origin_Type__", false, 2, null) == false) goto L6;
        return SettingIncStrategy.f65434a.b().get(r100);
    L6:
        return c().get(r100);
    }

    public static Object g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b r101 = SettingIncStrategy.f65434a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        d r102 = r101.f558393a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        r102.a();
        y60.b r103 = r102.f566311b;
        if (r103 == null) goto L9;
        r103.f();
        SharedPreferences r104 = r103.f566298b;
        if (r104 == null) goto L9;
        Map<String, ?> r105 = r104.getAll();
        if (r105 == null) goto L9;
        return r105.get(r100);
    L9:
        return null;
    }

    public static boolean a(String r100, ICacheManger.CacheType r101) {
        b r102 = SettingIncStrategy.f65434a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueCacheType");
        int r103 = w60.a.f558388c[r101.ordinal()];
        if (r103 == 1) goto L15;
        if (r103 == 2) goto L19;
        if (r103 == 3) goto L18;
        if (r103 == 4) goto L17;
        return false;
    L17:
        return r102.f558397e.containsKey(r100);
    L18:
        return r102.f558396d.containsKey(r100);
    L19:
        return r102.f558395c.containsKey(r100);
    L15:
        return r102.f558394b.containsKey(r100);
    }

    public static boolean b(String r100, boolean r101, Type r102) {
        Object r103 = j(r100, Boolean.valueOf(r101), r102, ICacheManger.CacheType.LOCAL_CACHE);
        if (r103 != null) goto L5;
        return r101;
    L5:
        if ((r103 instanceof Unit) == false) goto L8;
        Map<String, Long> r104 = a70.b.f1985a;
        a70.b.d("SettingCacheV2 getBooleanError,value is kotlin.Unit,return defValue,key=" + r100 + ", defValue=" + r101);
        return r101;
    L8:
        return x60.a.a(r103, r101);
    }

    public static String f(String r100, String r101, Type r102) {
        Object r103 = j(r100, r101, r102, ICacheManger.CacheType.LOCAL_CACHE);
        if ((r103 instanceof String) == true) goto L9;
        if (r103 == null) goto L8;
        a70.b.e("_MAIN", "SettingCacheV2 getStringError, value is not String，key=" + r100 + ", value=" + r103);
        r101 = GsonProtectorUtils.toJson(x60.b.f562576a, r103);
    L8:
        return r101;
    L9:
        return (String) r103;
    }

    public static Object h(String r100, Object r101, Type r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b r103 = SettingIncStrategy.f65434a;     // Catch: Exception -> L17
        Object r104 = null;
        if (r103.a(r100) == false) goto L16;
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Exception -> L17
        d r105 = r103.f558393a;     // Catch: Exception -> L17
        r105.getClass();     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Exception -> L17
        r105.a();     // Catch: Exception -> L17
        y60.b r106 = r105.f566311b;     // Catch: Exception -> L17
        if (r106 == null) goto L8;
        Object r107 = r106.e(r100, r101, r102);     // Catch: Exception -> L17
    L9:
        if ((r107 instanceof Object) == false) goto L13;
        r104 = r107;
    L13:
        if (r104 != null) goto L16;
        return r101;
    L8:
        r107 = null;
    L16:
        return r104;
    L17:
        e = move-exception;
        Map<String, Long> r108 = a70.b.f1985a;
        a70.b.d("key = " + r100 + e.getLocalizedMessage());
        return r101;
    }

    public static Object i(String r100, Type r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r102 == true) goto L5;
    L11:
        ICacheManger.CacheType r103 = ICacheManger.CacheType.TRANSIENT;
        if (a(r100, r103) == false) goto L18;
        Object r104 = j(r100, null, r101, r103);
        if (r104 != null) goto L16;
        return null;
    L16:
        return x60.b.a(r104, r101);
    L18:
        if (c().containsKey(r100) == true) goto L20;
        return null;
    L20:
        Object r105 = c().get(r100);
        if (r105 == null) goto L24;
        a r106 = f553369a;
        ICacheManger.Operation r107 = ICacheManger.Operation.PLUS;
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put(r100, r105);
        Unit r109 = Unit.INSTANCE;
        r106.update(r103, r107, r108);
        return x60.b.a(r105, r101);
    L24:
        return null;
    L5:
        if (SettingIncStrategy.f65434a.a(r100) == false) goto L11;
        Object r110 = h(r100, null, r101);
        a70.b.e("_TEST", "getValue 从test开始获取值，key=" + r100 + ", value = " + r110);
        if ((r110 instanceof Object) == true) goto L10;
        return null;
    L10:
        return r110;
    }

    public static boolean l(String r100, String r101, Type r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        b r104 = SettingIncStrategy.f65434a;
        ICacheManger.Operation r105 = ICacheManger.Operation.MINUS;
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put(r100, "");
        Unit r107 = Unit.INSTANCE;
        return r104.e(r105, r106);
    L12:
        b r108 = SettingIncStrategy.f65434a;
        ICacheManger.Operation r109 = ICacheManger.Operation.PLUS;
        LinkedHashMap r110 = new LinkedHashMap();
        if (Intrinsics.areEqual(r102, Boolean.class) == false) goto L15;
    L34:
        Object r111 = Boolean.valueOf(Boolean.parseBoolean(r101));
    L35:
        r110.put(r100, r111);
        Unit r112 = Unit.INSTANCE;
        return r108.e(r109, r110);
    L15:
        if (Intrinsics.areEqual(r102, Boolean.TYPE) == true) goto L34;
        if (Intrinsics.areEqual(r102, Integer.class) == false) goto L20;
    L33:
        r111 = Integer.valueOf(CastIntegerProtector.parseInt(r101));
        goto L35
    L20:
        if (Intrinsics.areEqual(r102, Integer.TYPE) == true) goto L33;
        if (Intrinsics.areEqual(r102, Float.class) == false) goto L25;
    L32:
        r111 = Float.valueOf(CastFloatProtector.parseFloat(r101));
        goto L35
    L25:
        if (Intrinsics.areEqual(r102, Float.TYPE) == true) goto L32;
        if (Intrinsics.areEqual(r102, Long.class) == true) goto L31;
        r111 = r101;
        if (Intrinsics.areEqual(r102, Long.TYPE) == false) goto L35;
    L31:
        r111 = Long.valueOf(CastLongProtector.parseLong(r101));
        goto L35
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    private final Object update(ICacheManger.CacheType r100, ICacheManger.Operation r101, Map<String, ? extends Object> r102) {
        b r103 = SettingIncStrategy.f65434a;
        return Boolean.valueOf(SettingIncStrategy.f65434a.update(r100, r101, r102));
    }

    public final <T> T d(String r100, T r101, Type r102) {
        ICacheManger.CacheType r103 = ICacheManger.CacheType.OBJECT;
        if (a(r100, r103) == false) goto L14;
        T r104 = (T) j(r100, r101, r102, r103);
        if ((r102 instanceof Class) == true) goto L7;
        Type r105 = null;
    L8:
        Class<?> r106 = (Class) r105;
        if (r106 == null) goto L14;
        if (r104 == null) goto L14;
        if (r104.getClass().isAssignableFrom(r106) == false) goto L14;
        return r104;
    L7:
        r105 = r102;
    L14:
        Object r107 = j(r100, r101, r102, ICacheManger.CacheType.LOCAL_CACHE);
        if (r107 == null) goto L18;
        r101 = (T) r107;
    L18:
        if (r101 != null) goto L20;
        ICacheManger.Operation r108 = ICacheManger.Operation.MINUS;
        LinkedHashMap r109 = new LinkedHashMap();
        r109.put(r100, "");
        Unit r110 = Unit.INSTANCE;
        update(r103, r108, r109);
    L21:
        return r101;
    L20:
        ICacheManger.Operation r111 = ICacheManger.Operation.PLUS;
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put(r100, r101);
        Unit r113 = Unit.INSTANCE;
        update(r103, r111, r112);
        goto L21
    }

    public static Object j(String r100, Object r101, Type r102, ICacheManger.CacheType r103) {
        b r104 = SettingIncStrategy.f65434a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r103, "valueCacheType");
        int r105 = w60.a.f558387b[r103.ordinal()];     // Catch: Exception -> L21
        if (r105 != 1) goto L6;
        d r106 = r104.f558393a;     // Catch: Exception -> L21
        r106.getClass();     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Exception -> L21
        return r106.f566310a.e(r100, r101, r102);
    L6:
        if (r105 == 2) goto L28;
        if (r105 == 3) goto L27;
        if (r105 == 4) goto L26;
        if (r105 != 5) goto L15;
        return r104.f558397e.get(r100);
    L15:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L21
    L26:
        return r104.f558396d.get(r100);
    L27:
        return r104.f558394b.get(r100);
    L28:
        return r104.f558395c.get(r100);
    L21:
        e = move-exception;
        a70.b.e("_MAIN", "CacheManger getValue exception，key=" + r100 + " , error info = " + e.getStackTrace());
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v40, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v49 */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r10v51 */
    /* JADX WARN: Type inference failed for: r10v52 */
    /* JADX WARN: Type inference failed for: r10v53 */
    /* JADX WARN: Type inference failed for: r10v54 */
    /* JADX WARN: Type inference failed for: r10v55 */
    /* JADX WARN: Type inference failed for: r10v56 */
    /* JADX WARN: Type inference failed for: r10v57 */
    /* JADX WARN: Type inference failed for: r10v58 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4 */
    public final <T> T k(String r100, T r101, Type r102, boolean r103, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r104 = null;
        if (r110 == true) goto L96;
    L8:
        if (r101 == 0) goto L10;
        if (r103 == false) goto L22;
        ICacheManger.CacheType r112 = ICacheManger.CacheType.STICKY;     // Catch: Exception -> L51
        if (a(r100, r112) == false) goto L22;
        Object r105 = j(r100, r101, r102, r112);     // Catch: Exception -> L51
        if ((r105 instanceof Object) == false) goto L18;
        r104 = r105;
    L18:
        if (r104 != null) goto L21;
        return r101;
    L21:
        return (T) r104;
    L22:
        if (r111 == false) goto L34;
        ICacheManger.CacheType r113 = ICacheManger.CacheType.PRELOAD_CACHE;     // Catch: Exception -> L51
        if (a(r100, r113) == false) goto L34;
        Object r106 = j(r100, r101, r102, r113);     // Catch: Exception -> L51
        if ((r106 instanceof Object) == false) goto L29;
        r104 = r106;
    L29:
        if (r104 != null) goto L32;
        return r101;
    L32:
        return (T) r104;
    L34:
        if (Intrinsics.areEqual(r102, Boolean.class) == false) goto L37;
        ?? r114 = Boolean.valueOf(b(r100, ((Boolean) r101).booleanValue(), r102));     // Catch: Exception -> L51
    L70:
        boolean r107 = r114 instanceof Object;     // Catch: Exception -> L51
        ?? r115 = r114;
        if (r107 == true) goto L73;
        r115 = 0;
    L73:
        if (r103 == false) goto L76;
        if (r115 == 0) goto L76;
        ICacheManger.CacheType r108 = ICacheManger.CacheType.STICKY;     // Catch: Exception -> L51
        ICacheManger.Operation r109 = ICacheManger.Operation.PLUS;     // Catch: Exception -> L51
        LinkedHashMap r116 = new LinkedHashMap();     // Catch: Exception -> L51
        r116.put(r100, r115);     // Catch: Exception -> L51
        Unit r117 = Unit.INSTANCE;     // Catch: Exception -> L51
        update(r108, r109, r116);     // Catch: Exception -> L51
    L76:
        if (r111 == false) goto L79;
        if (r115 == 0) goto L79;
        ICacheManger.CacheType r118 = ICacheManger.CacheType.PRELOAD_CACHE;     // Catch: Exception -> L51
        ICacheManger.Operation r119 = ICacheManger.Operation.PLUS;     // Catch: Exception -> L51
        LinkedHashMap r120 = new LinkedHashMap();     // Catch: Exception -> L51
        r120.put(r100, r115);     // Catch: Exception -> L51
        Unit r121 = Unit.INSTANCE;     // Catch: Exception -> L51
        update(r118, r119, r120);     // Catch: Exception -> L51
    L79:
        if (r115 != 0) goto L82;
        return r101;
    L82:
        return (T) r115;
    L37:
        if (Intrinsics.areEqual(r102, String.class) == false) goto L40;
        r114 = f(r100, (String) r101, r102);     // Catch: Exception -> L51
        goto L70
    L40:
        if (Intrinsics.areEqual(r102, Integer.class) == false) goto L54;
        Object r122 = j(r100, r101, r102, ICacheManger.CacheType.LOCAL_CACHE);     // Catch: Exception -> L51
        ?? r123 = r122;
        if (r122 != null) goto L45;
        r123 = r101;
    L45:
        if ((r123 instanceof Long) == true) goto L47;
        ?? r124 = 0;
    L48:
        Long r125 = (Long) r124;     // Catch: Exception -> L51
        r114 = r123;
        if (r125 == null) goto L70;
        r114 = Integer.valueOf((int) r125.longValue());     // Catch: Exception -> L51
        goto L70
    L47:
        r124 = r123;
        goto L48
    L54:
        if (Intrinsics.areEqual(r102, Float.class) == false) goto L65;
        Object r126 = j(r100, r101, r102, ICacheManger.CacheType.LOCAL_CACHE);     // Catch: Exception -> L51
        ?? r127 = r126;
        if (r126 != null) goto L58;
        r127 = r101;
    L58:
        String r128 = r127.toString();     // Catch: Exception -> L51
        float r129 = ((Float) r101).floatValue();     // Catch: Exception -> L51
        r129 = CastFloatProtector.parseFloat(r128);     // Catch: Exception -> L61
    L63:
        r114 = Float.valueOf(r129);     // Catch: Exception -> L51
        goto L70
    L61:
        e = move-exception;
        d6.a("ConvertHelper", e);     // Catch: Exception -> L51
    L51:
        e = move-exception;
        d6.a("SettingCacheV2", e);
        int r130 = c.f1986a;
        if (r102 == null) goto L86;
        String r131 = r102.toString();
    L87:
        if (r101 == 0) goto L89;
        String r132 = r101.toString();
    L90:
        Object r133 = e(r100);
        if (r133 == null) goto L93;
        String r134 = r133.toString();
    L94:
        String r135 = e.getMessage();
        JSONObject r136 = new JSONObject();
        r136.put("status_code", 1);
        r136.put("key", r100);
        JSONObject r137 = new JSONObject();
        r137.put(ComposerHelper.COMPOSER_DEFAULT_VALUE, r132);
        r137.put("origin_value", r134);
        r137.put("type", r131);
        r137.put("msg", r135);
        d6.d("ttlive_setting_get_local_value_exception", r136, null, r137);
        a70.b.e("_SLADAR", "statusCode = 1, key = " + r100 + ", msg = " + r135 + ", origin_value=" + r134);
        return r101;
    L93:
        r134 = null;
        goto L94
    L89:
        r132 = null;
        goto L90
    L86:
        r131 = null;
        goto L87
    L65:
        if (Intrinsics.areEqual(r102, Long.class) == false) goto L69;
        Object r138 = j(r100, r101, r102, ICacheManger.CacheType.LOCAL_CACHE);     // Catch: Exception -> L51
        r114 = r138;
        if (r138 != null) goto L70;
        r114 = r101;
        goto L70
    L69:
        r114 = d(r100, r101, r102);     // Catch: Exception -> L51
        goto L70
    L10:
        return (T) i(r100, r102, r110);
    L96:
        if (SettingIncStrategy.f65434a.a(r100) == false) goto L8;
        return (T) h(r100, r101, r102);
    }
}
