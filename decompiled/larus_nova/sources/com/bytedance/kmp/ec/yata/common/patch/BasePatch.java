package com.bytedance.kmp.ec.yata.common.patch;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.kmp.ec.yata.common.utils.c;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内部API")
public final class BasePatch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BasePatch f251443a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f251444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f251445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f251446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f251447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, Object> f251448e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f251449f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f251450g;

        public a(boolean r100, Map<String, ? extends Object> r101, Throwable r102, String r103, Map<String, Object> r104, boolean r105) {
            this.f251444a = r100;
            this.f251445b = r101;
            this.f251446c = r102;
            this.f251447d = r103;
            this.f251448e = r104;
            this.f251449f = r105;
            if (r100 == false) goto L5;
        L7:
            boolean r106 = false;
        L8:
            this.f251450g = r106;
            return;
        L5:
            if ((r102 instanceof BasePatchTestException) == true) goto L7;
            r106 = true;
            goto L8
        }
    }

    static {
        f251443a = new BasePatch();
    }

    public BasePatch() {
    }

    public static List d(String r110) {
        if (r110 == null) goto L13;
        List r100 = StringsKt.split$default(StringsKt.replace$default(r110, "\"", "", false, 4, null), new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        f251443a.getClass();
        String r104 = new Regex("~1").replace(r103, HTTP.URL_DEFAULT);
        r101.add(new Regex("~0").replace(r104, Constants.WAVE_SEPARATOR));
        goto L5
    L8:
        if (r101.isEmpty() == true) goto L11;
        return r101;
    L11:
        throw new BasePatchErrorException("path_list_is_empty", "path_list_is_empty");
    L13:
        throw new BasePatchErrorException("path_is_null", "path_is_null");
    }

    public static int h(String r100) {
        Integer r101 = StringsKt.toIntOrNull(new Regex("\"").replace(r100, ""));
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        throw new BasePatchErrorException("can_not_convert_to_int", r100 + " 无法转换为数字");
    }

    public static String i(String r100) {
        return new Regex("\"").replace(r100, "");
    }

    public static Object c(String r100, Object r101) throws BasePatchException {
        List r102 = CollectionsKt.drop(d(r100), 1);
        Iterator r103 = r102.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L33;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r107 = (String) r105;
        f251443a.getClass();
        if ((r101 instanceof Map) == false) goto L16;
        Map r108 = (Map) r101;
        if (r108.containsKey(r107) == false) goto L14;
        r101 = r108.get(r107);
    L19:
        if (r104 == CollectionsKt.getLastIndex(r102)) goto L30;
        if (r101 == null) goto L29;
        if ((r101 instanceof Map) == true) goto L30;
        if ((r101 instanceof List) == true) goto L30;
        throw new BasePatchErrorException("path_can_not_find_next", "不到最后一个path就读到了非Map、非List，" + Reflection.getOrCreateKotlinClass(r101.getClass()).getSimpleName() + " 说明无法继续往下查找");
    L29:
        throw new BasePatchErrorException("path_not_exist", "不到最后一个path就读到了null，说明无法继续往下查找");
    L30:
        r104 = r106;
        goto L4
    L14:
        throw new BasePatchErrorException("path_not_exist", "对应的数据不存在");
    L16:
        if ((r101 instanceof List) == false) goto L32;
        r101 = ListProtector.get((List) r101, h(r107));
        goto L19
    L32:
        throw new BasePatchErrorException("path_must_can_operate", "要操作的对象不是Map也不是List，而是" + c.a(r101) + ", 所以无法操作");
    L33:
        return r101;
    }

    @Deprecated(message = "测试使用")
    public static Object e(Object r100, List r101) throws BasePatchException {
        Intrinsics.checkNotNullParameter(r101, "infos");
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L25;
        Map<String, Object> r103 = (Map) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        f251443a.getClass();     // Catch: Throwable -> L8
        r100 = Result.m9449constructorimpl(f(r100, r103));     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r100);
        if ((r105 instanceof BasePatchException) == false) goto L13;
        BasePatchException r106 = (BasePatchException) r105;
    L14:
        if (r106 == null) goto L17;
        r106.setPatchInfo(r103);
    L17:
        if (Result.m9455isFailureimpl(r100) == true) goto L18;
        if (Result.m9455isFailureimpl(r100) == false) goto L4;
        r100 = null;
        goto L4
    L18:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r100);
        if (r107 != null) goto L34;
        BasePatchErrorException r108 = new BasePatchErrorException("default_error", "默认兜底值");
        r108.setPatchInfo(r103);
        throw r108;
    L34:
        throw r107;
    L13:
        r106 = null;
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r100 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L25:
        return r100;
    }

    public static Object f(Object r110, Map r111) throws BasePatchException {
        if (r111.containsKey("path") == false) goto L106;
        Object r100 = r111.get("op");
        if ((r100 instanceof String) == false) goto L7;
        String r101 = (String) r100;
    L9:
        if (r101 == null) goto L54;
        Object r112 = "path";
        Object r113 = "op";
        switch(r101.hashCode()) {
            case -934610812: goto L53;
            case 96417: goto L46;
            case 3059573: goto L38;
            case 3357649: goto L30;
            case 3556498: goto L22;
            case 1094496948: goto L14;
            default: goto L55;
        };
    L53:
        r101.equals("remove");
    L55:
        if (r110 != null) goto L58;
        return null;
    L58:
        Object r102 = r111.get(r113);
        if ((r102 instanceof String) == false) goto L61;
        String r103 = (String) r102;
    L62:
        Object r104 = r111.get(r112);
        if ((r104 instanceof String) == false) goto L65;
        String r105 = (String) r104;
    L66:
        Object r106 = r111.get("from");
        if ((r106 instanceof String) == false) goto L69;
        String r107 = (String) r106;
    L70:
        final Object r108 = r111.get("value");
        if (r103 == null) goto L104;
        switch(r103.hashCode()) {
            case -934610812: goto L100;
            case 96417: goto L97;
            case 3059573: goto L94;
            case 3357649: goto L91;
            case 3556498: goto L84;
            case 1094496948: goto L76;
            default: goto L104;
        };
    L76:
        if (r103.equals("replace") == false) goto L104;
        final List r109 = d(r105);
        if (((ArrayList) r109).size() != 1) goto L108;
        if (Intrinsics.areEqual(CollectionsKt.first(r109), "") == false) goto L108;
        return r108;
    L108:
        return b(r110, CollectionsKt.dropLast(r109, 1), 1, new BasePatch$replace$1(r109, r108));
    L84:
        if (r103.equals(EffectConstants.CHANNEL_TEST) == false) goto L104;
        if (Intrinsics.areEqual(c(r105, r110), r108) == false) goto L89;
        return r110;
    L89:
        throw new BasePatchTestException("normal_error", "正常test校验不通过");
    L91:
        if (r103.equals("move") == false) goto L104;
        Object r114 = c(r107, r110);
        final List r115 = d(r107);
        return a(b(r110, CollectionsKt.dropLast(r115, 1), 1, new BasePatch$remove$1(r115)), r105, r114);
    L94:
        if (r103.equals("copy") == false) goto L104;
        return a(r110, r105, c(r107, r110));
    L97:
        if (r103.equals("add") == false) goto L104;
        return a(r110, r105, r108);
    L100:
        if (r103.equals("remove") == false) goto L104;
        final List r116 = d(r105);
        return b(r110, CollectionsKt.dropLast(r116, 1), 1, new BasePatch$remove$1(r116));
    L104:
        throw new BasePatchErrorException("not_in_standard", "不在标准op内");
    L69:
        r107 = null;
        goto L70
    L65:
        r105 = null;
        goto L66
    L61:
        r103 = null;
        goto L62
    L14:
        if (r101.equals("replace") == false) goto L55;
        if (r111.containsKey("value") == true) goto L55;
        throw new BasePatchErrorException("miss_value", "value不存在");
    L22:
        if (r101.equals(EffectConstants.CHANNEL_TEST) == false) goto L55;
        if (r111.containsKey("value") == true) goto L55;
        throw new BasePatchErrorException("miss_value", "value不存在");
    L30:
        if (r101.equals("move") == false) goto L55;
        if (r111.containsKey("from") == true) goto L55;
        throw new BasePatchErrorException("miss_from", "from不存在");
    L38:
        if (r101.equals("copy") == false) goto L55;
        if (r111.containsKey("from") == true) goto L55;
        throw new BasePatchErrorException("miss_from", "from不存在");
    L46:
        if (r101.equals("add") == false) goto L55;
        if (r111.containsKey("value") == true) goto L55;
        throw new BasePatchErrorException("miss_value", "value不存在");
    L54:
        r112 = "path";
        r113 = "op";
        goto L55
    L7:
        r101 = null;
        goto L9
    L106:
        throw new BasePatchErrorException("miss_path", "path不存在");
    }

    public static Object a(Object r100, String r101, final Object r102) {
        final List r103 = d(r101);
        if (((ArrayList) r103).size() != 1) goto L8;
        if (Intrinsics.areEqual(CollectionsKt.first(r103), "") == false) goto L8;
        return r102;
    L8:
        return b(r100, CollectionsKt.dropLast(r103, 1), 1, new BasePatch$add$1(r103, r102));
    }

    public static a g(Map r110, List r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r111, "infos");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r113 = Result.m9449constructorimpl(e(r110, r111));     // Catch: Throwable -> L5
    L8:
        if (Result.m9456isSuccessimpl(r113) == false) goto L27;
        Map r101 = null;
        if (Result.m9455isFailureimpl(r113) == false) goto L13;
        r113 = null;
    L13:
        if ((r113 instanceof Map) == false) goto L15;
        r101 = (Map) r113;
    L15:
        Map r102 = r101;
        if (r112 == true) goto L26;
        if (r102 != null) goto L19;
    L22:
        boolean r114 = true;
    L23:
        if (r114 == false) goto L26;
        return new a(false, r110, null, "result_map_is_empty", null, true);
    L19:
        if (r102.isEmpty() == true) goto L22;
        r114 = false;
    L26:
        return new a(true, r102, null, null, null, false);
    L27:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r113);
        if ((r103 instanceof BasePatchErrorException) == false) goto L32;
        BasePatchErrorException r115 = (BasePatchErrorException) r103;
        return new a(false, r110, r103, r115.getDetail(), r115.getPatchInfo(), false);
    L32:
        if ((r103 instanceof BasePatchTestException) == false) goto L36;
        BasePatchTestException r116 = (BasePatchTestException) r103;
        return new a(false, r110, r103, r116.getDetail(), r116.getPatchInfo(), false);
    L36:
        return new a(false, r110, r103, "patch_crash", null, true);
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static Object b(Object r100, List r101, int r102, Function1 r103) throws BasePatchException {
        if (r102 >= r101.size()) goto L5;
        String r104 = (String) ListProtector.get(r101, r102);
        if ((r100 instanceof List) == false) goto L11;
        int r105 = h(r104);
        List r106 = (List) r100;
        Object r107 = b(ListProtector.get(r106, r105), r101, r102 + 1, r103);
        List r108 = CollectionsKt.toMutableList(r106);
        ListProtector.set(r108, r105, r107);
        return r108;
    L11:
        if ((r100 instanceof Map) == false) goto L15;
        Map r109 = (Map) r100;
        String r110 = i(r104);
        Object r111 = b(r109.get(r104), r101, r102 + 1, r103);
        Map r112 = MapsKt.toMutableMap(r109);
        r112.put(r110, r111);
        return r112;
    L15:
        throw new BasePatchErrorException("path_must_can_operate", "要操作的对象不是Map也不是List，而是" + c.a(r100) + ", 所以无法操作");
    L5:
        return r103.invoke(r100);
    }
}
