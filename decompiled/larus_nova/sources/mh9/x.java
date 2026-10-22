package mh9;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;
import ouc.g0;

/* JADX INFO: loaded from: classes30.dex */
public final class x {
    public static void f() {
        d0 r100 = new d0(new LinkedHashMap());
        Intrinsics.checkNotNullParameter(r100, "params");
        i("popup_voice_edit_function_show", r100, CollectionsKt.emptyList());
    }

    public static final Pair<String, ouc.i> a(String r100, Float r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return TuplesKt.to(r100, ouc.k.b(Float.valueOf(r101.floatValue())));
    }

    public static final Pair<String, ouc.i> b(String r100, Integer r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return TuplesKt.to(r100, ouc.k.b(Integer.valueOf(r101.intValue())));
    }

    public static final Pair<String, ouc.i> c(String r100, Long r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return TuplesKt.to(r100, ouc.k.b(Long.valueOf(r101.longValue())));
    }

    public static final Pair<String, ouc.i> j(String r100, String r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return TuplesKt.to(r100, ouc.k.c(r101));
    }

    public static void e(String r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        d0 r103 = new d0(new LinkedHashMap());
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = null;
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = null;
    L12:
        Intrinsics.checkNotNullParameter(r103, "params");
        i("popup_voice_edit_function_click", r103, CollectionsKt.listOfNotNull(new Pair[]{j("click_from", r100), j("to_status", r101)}));
        return;
    L5:
        r103 = null;
        goto L7
    }

    public static final void i(String r100, d0 r101, List<? extends Pair<String, ? extends ouc.i>> r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, ouc.i>> r104 = r101.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<String, ouc.i> r105 = r104.next();
        String r106 = r105.getKey();
        ouc.i r107 = r105.getValue();
        Intrinsics.checkNotNullParameter(r106, "key");
        Intrinsics.checkNotNullParameter(r107, "element");
        ouc.i r108 = (ouc.i) r103.put(r106, r107);
        goto L4
    L6:
        Iterator<? extends Pair<String, ? extends ouc.i>> r109 = r102.iterator();
    L8:
        if (r109.hasNext() == false) goto L10;
        Pair<String, ? extends ouc.i> r110 = r109.next();
        String r111 = r110.component1();
        ouc.i r112 = r110.component2();
        Intrinsics.checkNotNullParameter(r111, "key");
        Intrinsics.checkNotNullParameter(r112, "element");
        ouc.i r113 = (ouc.i) r103.put(r111, r112);
        goto L8
    L10:
        g0 r114 = ouc.k.b(1);
        Intrinsics.checkNotNullParameter("is_kmp_page", "key");
        Intrinsics.checkNotNullParameter(r114, "element");
        ouc.i r115 = (ouc.i) r103.put("is_kmp_page", r114);
        d0 r116 = new d0(r103);
        int r117 = t.f514021a;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r116, "params");
        u.a(r100, r116);
    }

    public static final void h(d0 r100, String r101, Integer r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "params");
        i("record_voice_validate_result", r100, CollectionsKt.listOfNotNull(new Pair[]{j("validate_scene", r101), b("success", r102), c("duration", r103)}));
    }

    public static final void g(d0 r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "params");
        i("record_own_voice_complete", r100, CollectionsKt.listOfNotNull(new Pair[]{j("enter_from", r101), j("previous_page", r101), j("enter_method", r102), j("voice_id", r103), j("is_public", r104), j("speaker_id", r105), j("speaker_name", r106)}));
    }

    public static void d(Integer r210, String r211, String r212, String r213, String r214, Long r215, String r216, String r217, String r218, String r310, String r311, Boolean r312, String r313, String r314, String r315, String r316, String r317, int r318) {
        if ((r318 & 1) == 0) goto L5;
        d0 r100 = new d0(new LinkedHashMap());
    L7:
        if ((r318 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r318 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r318 & 128) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r318 & 256) == 0) goto L29;
        Long r106 = null;
    L31:
        if ((r318 & 512) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r318 & 1024) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r318 & 2048) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r318 & 4096) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r318 & 8192) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r318 & 16384) == 0) goto L53;
        Boolean r114 = null;
    L55:
        if ((32768 & r318) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r318 & 65536) == 0) goto L61;
        String r116 = null;
    L63:
        if ((r318 & 131072) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r318 & 262144) == 0) goto L69;
        String r118 = null;
    L71:
        if ((r318 & 524288) == 0) goto L73;
        String r108 = null;
    L74:
        Intrinsics.checkNotNullParameter(r100, "params");
        Pair[] r109 = new Pair[19];
        d0 r219 = r100;
        r109[0] = b("change_voice_count", r101);
        r109[1] = j("is_best_match", r102);
        r109[2] = j("is_public", r103);
        r109[3] = j("recommend_from", null);
        r109[4] = j("req_id", null);
        r109[5] = j("voice_id", r104);
        r109[6] = j("voice_type", r105);
        r109[7] = c("duration", r106);
        r109[8] = j("voice_remix_id", r107);
        r109[9] = j(com.alipay.sdk.m.p.e.f25671s, r110);
        r109[10] = j("speaker_id", r111);
        r109[11] = j("speaker_name", r112);
        r109[12] = j("if_mix_voice", r113);
        if (r114 == null) goto L77;
        String r119 = y.a(r114.booleanValue());
    L78:
        r109[13] = j("if_voice_change", r119);
        r109[14] = j("scene", r115);
        r109[15] = j("click_from", r116);
        r109[16] = j("from_voice_id", r117);
        r109[17] = j("to_tts_speaker", r118);
        r109[18] = j("bot_id", r108);
        i("leave_change_voice_page", r219, CollectionsKt.listOfNotNull(r109));
        return;
    L77:
        r119 = null;
        goto L78
    L73:
        r108 = r317;
        goto L74
    L69:
        r118 = r316;
        goto L71
    L65:
        r117 = r315;
        goto L67
    L61:
        r116 = r314;
        goto L63
    L57:
        r115 = r313;
        goto L59
    L53:
        r114 = r312;
        goto L55
    L49:
        r113 = r311;
        goto L51
    L45:
        r112 = r310;
        goto L47
    L41:
        r111 = r218;
        goto L43
    L37:
        r110 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = null;
        goto L7
    }
}
