package ou5;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.dtf.face.api.IDTFacade;
import idb.f;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f526745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f526746b = null;

    static {
        f526745a = MapsKt.mapOf(new Pair[]{TuplesKt.to("zh", "zh-CN"), TuplesKt.to(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_TW, IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_TW), TuplesKt.to(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_HK, IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_HK), TuplesKt.to("en", "en-US"), TuplesKt.to(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_JA, "ja-JP"), TuplesKt.to("fr", "fr-FR"), TuplesKt.to("hi", "hi-IN"), TuplesKt.to("id", "id-ID"), TuplesKt.to("it", "it-IT"), TuplesKt.to(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_KO, "ko-KR"), TuplesKt.to(GXTemplateKey.GAIAX_PT, "pt-BR"), TuplesKt.to("ru", "ru-RU"), TuplesKt.to("th", "th-TH"), TuplesKt.to("vi", "vi-VN"), TuplesKt.to("de", "de-DE"), TuplesKt.to("es", "es-ES"), TuplesKt.to("ms", "ms-MY")});
        f526746b = MapsKt.mapOf(new Pair[]{TuplesKt.to("zh-CN", "zh_cn"), TuplesKt.to(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_TW, "zh_tw"), TuplesKt.to(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_HK, "zh_hk"), TuplesKt.to("en-US", "en_us"), TuplesKt.to("ja-JP", "ja_jp"), TuplesKt.to("fr-FR", "fr_fr"), TuplesKt.to("hi-IN", "hi_in"), TuplesKt.to("id-ID", "id_id"), TuplesKt.to("it-IT", "it_it"), TuplesKt.to("ko-KR", "ko_kr"), TuplesKt.to("pt-BR", "pt_br"), TuplesKt.to("ru-RU", "ru_ru"), TuplesKt.to("th-TH", "th_th"), TuplesKt.to("vi-VN", "vi_vn"), TuplesKt.to("de-DE", "de_de"), TuplesKt.to("es-ES", "es_es"), TuplesKt.to("ms-MY", "ms_my")});
    }

    @JvmStatic
    public static final String a(Map<String, String> r100) {
        if (r100 == null) goto L5;
        String r101 = r100.get("zh_cn");
        if (r101 == null) goto L5;
        return r101;
    L5:
        if (r100 == null) goto L7;
        String r102 = r100.get("zh-CN");
    L8:
        String r103 = r102;
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    L7:
        r102 = null;
        goto L8
    }

    @JvmStatic
    public static final String b(Map<String, String> r100) {
        if (r100 == null) goto L5;
        String r101 = r100.get("en_us");
        if (r101 == null) goto L5;
        return r101;
    L5:
        if (r100 == null) goto L7;
        String r102 = r100.get("en-US");
    L8:
        String r103 = r102;
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    L7:
        r102 = null;
        goto L8
    }

    @JvmStatic
    public static final String d(Map<String, String> r100) {
        if (r100 == null) goto L5;
        String r101 = r100.get("ja_jp");
        if (r101 == null) goto L5;
        return r101;
    L5:
        if (r100 == null) goto L7;
        String r102 = r100.get("ja-JP");
    L8:
        String r103 = r102;
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    L7:
        r102 = null;
        goto L8
    }

    @JvmStatic
    public static final String c(Map<String, String> r110, String r111) {
        boolean r100 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return "";
    L12:
        if (r111 != null) goto L14;
    L17:
        boolean r102 = true;
    L18:
        if (r102 == true) goto L29;
        String r103 = r110.get(r111);
        if (r103 != null) goto L22;
    L25:
        boolean r104 = true;
    L26:
        if (r104 == true) goto L29;
        return r103;
    L22:
        if (r103.length() == 0) goto L25;
        r104 = false;
    L29:
        if (r111 == null) goto L31;
        String r105 = f526745a.get(r111);
    L32:
        if (r105 != null) goto L34;
    L37:
        boolean r106 = true;
    L38:
        if (r106 == true) goto L49;
        String r107 = r110.get(r105);
        if (r107 != null) goto L42;
    L45:
        boolean r108 = true;
    L46:
        if (r108 == true) goto L49;
        return r107;
    L42:
        if (r107.length() == 0) goto L45;
        r108 = false;
    L49:
        if (r111 == null) goto L53;
        Map<String, String> r109 = f526745a;
        String r112 = r109.get(r111);
        if (r112 != null) goto L54;
        r112 = r109.get(StringsKt.take(r111, 2));
    L54:
        String r113 = f526746b.get(r112);
        if (r113 == null) goto L57;
        String r114 = r110.get(r113);
    L58:
        if (r114 != null) goto L60;
    L63:
        boolean r115 = true;
    L64:
        if (r115 == true) goto L66;
        return r114;
    L66:
        if (r111 != null) goto L68;
    L71:
        boolean r116 = true;
    L72:
        if (r116 == false) goto L91;
    L90:
        return "";
    L91:
    L88:
        e = move-exception;
        tt5.a.e("LocaleMappingUtil", "Failed to map systemLanguage to Locale: " + r111, e, false);
        goto L90
    L74:
        if (StringsKt.contains$default(r111, "-", false, 2, null) == false) goto L79;
        List r117 = StringsKt.split$default(r111, new String[]{"-"}, false, 2, 2, null);     // Catch: Exception -> L88
        if (r117.size() != 2) goto L78;
        Locale r118 = new Locale((String) ListProtector.get(r117, 0), (String) ListProtector.get(r117, 1));     // Catch: Exception -> L88
    L80:
        String r119 = r110.get(r118.toLanguageTag());     // Catch: Exception -> L88
        if (r119 == null) goto L86;
        if (r119.length() == 0) goto L86;
        r100 = false;
    L86:
        if (r100 == true) goto L90;
        return r119;
    L78:
        r118 = new Locale(r111);     // Catch: Exception -> L88
        goto L80
    L79:
        r118 = new Locale(r111);     // Catch: Exception -> L88
        goto L80
    L68:
        if (r111.length() == 0) goto L71;
        r116 = false;
        goto L72
    L60:
        if (r114.length() == 0) goto L63;
        r115 = false;
        goto L64
    L57:
        r114 = null;
        goto L58
    L53:
        r112 = null;
        goto L54
    L34:
        if (r105.length() == 0) goto L37;
        r106 = false;
        goto L38
    L31:
        r105 = null;
        goto L32
    L14:
        if (r111.length() == 0) goto L17;
        r102 = false;
        goto L18
    L5:
        if (r110.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    @JvmStatic
    public static final String e(String r100, Map<String, String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "language");
        String r103 = c(r101, r100);
        if (f.a().isEnable("ccm.bytedance_english_name_fallback") == false) goto L8;
        if (TextUtils.isEmpty(r103) == false) goto L8;
        r103 = b(r101);
    L8:
        if (TextUtils.isEmpty(r103) == true) goto L14;
        if (r102 == null) goto L14;
        if (StringsKt.contains$default(r102, r103, false, 2, null) == true) goto L14;
        return r102 + '(' + r103 + ')';
    L14:
        if (r102 != null) goto L17;
        return "";
    L17:
        return r102;
    }
}
