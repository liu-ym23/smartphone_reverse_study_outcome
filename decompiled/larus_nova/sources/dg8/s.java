package dg8;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.font.FontLevel;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.bmhome.web.IAiChatHostWebService;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.PhoneNumberConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import com.larus.business.markdown.api.model.TitleStyle;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.api.f3;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.noties.markwon.core.spans.ListMarginInfo;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f468532a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f468533b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f468534c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f468535d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f468536e = false;

    public s() {
    }

    static {
        f468532a = LazyKt.lazy(new n());
        f468533b = new Regex("(-\\s+){4,}-");
        f468534c = LazyKt.lazy(new o());
        f468535d = LazyKt.lazy(new p());
        f468536e = e2.f365734a.isPad();
    }

    public static lw8.d a(Context r610, boolean r611, boolean r710, Message r711, Integer r712, Integer r713, boolean r714, boolean r715, boolean r716, boolean r717, int r718) {
        if ((r718 & 8) == 0) goto L5;
        final Message r100 = null;
    L7:
        if ((r718 & 16) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r718 & 32) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r718 & 64) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r718 & 128) == 0) goto L21;
        boolean r110 = true;
    L23:
        if ((r718 & 256) == 0) goto L25;
        boolean r210 = true;
    L27:
        if ((r718 & 512) == 0) goto L29;
        boolean r310 = false;
    L31:
        if ((r718 & 1024) == 0) goto L33;
        boolean r410 = false;
    L34:
        Intrinsics.checkNotNullParameter(r610, PerfLog.PARAM_KEY_CONTEXT_ID);
        float r104 = we8.a.a(i5.q(), r710);
        int r510 = we8.e.a(r710);
        if (r103 == false) goto L37;
        int r111 = ContextCompat.getColor(r610, v19.c.b(R.attr.larus_neutral_transparent_2, r610, R.color.larus_neutral_transparent_2));
    L38:
        int r112 = ContextCompat.getColor(r610, v19.c.b(R.attr.larus_neutral_70, r610, R.color.larus_neutral_70));
        z2 r411 = z2.f365865a;
        if (r411.M1().getEnableNewQuoteStyle() == false) goto L41;
        lw8.a r511 = new lw8.a(true, Integer.valueOf(c7.b(2)), Integer.valueOf(ContextCompat.getColor(r610, v19.c.b(R.attr.larus_neutral_30, r610, R.color.larus_neutral_30))), Integer.valueOf(c7.b(2)), Integer.valueOf(c7.b(15)), Integer.valueOf(r112), Integer.valueOf(r112), Integer.valueOf(r112));
    L42:
        r411.w3();
        int r113 = c7.b(8);
        Intrinsics.checkNotNullParameter(r610, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r105 = ContextCompat.getColor(r610, R.color.press);
        int r512 = c7.b(80);
        ThematicBreakConfig r114 = new ThematicBreakConfig(Integer.valueOf(c7.b(Double.valueOf(0.5d))), null, 2, null);
        if (r101 == null) goto L45;
        int r106 = r101.intValue();
    L46:
        int r107 = c7.b(8);
        int r115 = i5.r0();
        TitleStyle r211 = TitleStyle.LARGE;
        boolean r116 = !r103;
        if (r103 == true) goto L49;
        Integer r212 = Integer.valueOf(ContextCompat.getColor(r610, v19.c.b(R.attr.larus_neutral_transparent_1, r610, R.color.larus_neutral_transparent_1)));
    L51:
        if (AppHost.f326268a.isOversea() == true) goto L58;
        AiChatHostWebService.f317594a.getClass();
        if (((IAiChatHostWebService) AiChatHostWebService.f317595b.getValue()) == null) goto L55;
        boolean r117 = true;
    L56:
        if (r117 == false) goto L58;
        boolean r213 = true;
    L59:
        if (r103 == true) goto L61;
        Integer r214 = Integer.valueOf(r111);
    L62:
        if (r103 == true) goto L64;
        Integer r412 = Integer.valueOf(r111);
    L65:
        CodeBlockConfig r513 = new CodeBlockConfig(Integer.valueOf(r115), Integer.valueOf(r111), r116, r212, 14, null, true, "", r213, true, r211, r210, r214, r412, Integer.valueOf(ContextCompat.getColor(r610, v19.c.b(R.attr.larus_neutral_100, r610, R.color.larus_neutral_100))), null, false, false, null, false, null, null, null, false, Boolean.valueOf(r103), r310, r410, 16744480, null);
        int r118 = ContextCompat.getColor(r610, v19.c.b(R.attr.larus_neutral_transparent_1, r610, R.color.larus_neutral_transparent_1));
        int r108 = i5.b();
        int r109 = ContextCompat.getColor(r610, v19.c.b(R.attr.larus_neutral_transparent_3_web, null, R.color.larus_neutral_transparent_3_web));
        if (r110 == false) goto L68;
        int r119 = 0;
    L69:
        int r120 = i5.r0();
        String r215 = r610.getString(R.string.larus_chat_list_subtitle_table);
        boolean r216 = ((Boolean) f468532a.getValue()).booleanValue();
        int r217 = ContextCompat.getColor(r610, android.R.color.transparent);
        if (r102 == null) goto L73;
        int r121 = r102.intValue();
        r106 = r106;
        r107 = r107;
    L94:
        Float r122 = Float.valueOf(r104);
        Integer r123 = Integer.valueOf(r108);
        Boolean r124 = null;
        TableConfig r514 = new TableConfig(r110, r118, r122, r123, Integer.valueOf(r109), null, Integer.valueOf(r120), Integer.valueOf(r119), Integer.valueOf(r121), null, null, null, r215, 14, true, r216, true, true, false, null, Integer.valueOf(r217), null, 2887200, null);
        PhoneNumberConfig r125 = new PhoneNumberConfig(r411.M1().getEnablePhoneHighlight(), r411.M1().getPhoneNumberRegex(), new q(r100));
        int r126 = we8.e.f559403d;
        if (r126 != FontLevel.EXTRA_SMALL.getValue()) goto L98;
        ListMarginInfo r127 = new ListMarginInfo(c7.b(4), c7.b(-2), c7.b(12));
    L112:
        ListMarginInfo r612 = r127;
    L115:
        if (r411.enableSwDpOffline() == true) goto L117;
        Map r613 = null;
    L119:
        if (((Boolean) f468535d.getValue()).booleanValue() == false) goto L121;
        List r614 = CollectionsKt.listOf(new r());
    L122:
        if (r710 == false) goto L125;
        r124 = Boolean.TRUE;
    L125:
        return com.larus.bmhome.chat.markdown.richtext.c.a(new lw8.d(r113, Integer.valueOf(r105), null, r611, null, 0, null, 0.0f, null, r510, r512, Integer.valueOf(r106), Integer.valueOf(r107), null, r511, r114, r513, r514, r125, r612, r614, r124, new mw8.b(r104, ContextCompat.getColor(r610, R.color.neutral_100)), r613, -603566116, 26), r610.getResources());
    L121:
        r614 = null;
        goto L122
    L117:
        float r128 = r610.getResources().getDimension(v19.c.b(R.attr.larus_dp_20, r610, R.dimen.larus_dp_20_static));
        float r129 = r610.getResources().getDimension(v19.c.b(R.attr.larus_dp_19, r610, R.dimen.larus_dp_19_static));
        float r130 = r610.getResources().getDimension(v19.c.b(R.attr.larus_dp_17, r610, R.dimen.larus_dp_17_static));
        r613 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(1, Float.valueOf(r128)), TuplesKt.to(2, Float.valueOf(r129)), TuplesKt.to(3, Float.valueOf(r130)), TuplesKt.to(4, Float.valueOf(r130)), TuplesKt.to(5, Float.valueOf(r130)), TuplesKt.to(6, Float.valueOf(r130))});
        goto L119
    L98:
        if (r126 != FontLevel.SMALL.getValue()) goto L101;
        r127 = new ListMarginInfo(c7.b(5), c7.b(Double.valueOf(-2.5d)), c7.b(14));
        goto L112
    L101:
        if (r126 != FontLevel.STANDARD.getValue()) goto L104;
        r127 = new ListMarginInfo(c7.b(5), c7.b(Double.valueOf(-3.5d)), c7.b(16));
        goto L112
    L104:
        if (r126 != FontLevel.LARGE.getValue()) goto L107;
        r127 = new ListMarginInfo(c7.b(6), c7.b(-5), c7.b(20));
        goto L112
    L107:
        if (r126 != FontLevel.EXTRA_LARGE.getValue()) goto L110;
        r127 = new ListMarginInfo(c7.b(6), c7.b(-6), c7.b(22));
        goto L112
    L110:
        if (r126 != FontLevel.SUPER_EXTRA_LARGE.getValue()) goto L113;
        r127 = new ListMarginInfo(c7.b(7), c7.b(-7), c7.b(24));
        goto L112
    L113:
        r612 = null;
        goto L115
    L73:
        if (f468536e == false) goto L75;
        e2 r131 = e2.f365734a;
        int r132 = f3.a.a();
    L76:
        Resources r133 = r610.getResources();
        if (((Boolean) f468534c.getValue()).booleanValue() == false) goto L81;
        if (r710 == true) goto L81;
    L87:
        int r134 = (r133.getDimensionPixelSize(R.dimen.larus_message_content_horizontal_padding) + r133.getDimensionPixelSize(R.dimen.larus_message_item_start_margin)) * 2;
        r106 = r106;
        r107 = r107;
    L93:
        r121 = Math.max(r132 - r134, 0);
    L81:
        if (r100 == null) goto L83;
        String r135 = r100.getBizContentType();
    L85:
        if (Intrinsics.areEqual(r135, "deep_search_card") == true) goto L87;
        int r136 = r133.getDimensionPixelSize(R.dimen.larus_message_item_start_margin) + r133.getDimensionPixelSize(R.dimen.larus_message_item_end_margin);
        int r137 = r133.getDimensionPixelSize(R.dimen.larus_message_content_horizontal_padding) * 2;
        if (r710 == false) goto L91;
        int r138 = r133.getDimensionPixelSize(R.dimen.larus_message_item_immerse_end_margin) - r133.getDimensionPixelSize(R.dimen.larus_message_item_end_margin);
    L92:
        r132 = (r132 - r136) - r137;
        r134 = r138;
        goto L93
    L91:
        r138 = 0;
        goto L92
    L83:
        r135 = null;
        goto L85
    L75:
        Resources r139 = r610.getResources();
        r132 = WindowDisplayMetricsOverride.apply(r139, r139.getDisplayMetrics()).widthPixels;
        goto L76
    L68:
        r119 = i5.r0();
        goto L69
    L64:
        r412 = null;
        goto L65
    L61:
        r214 = null;
        goto L62
    L55:
        r117 = false;
    L58:
        r213 = false;
        goto L59
    L49:
        r212 = null;
        goto L51
    L45:
        r106 = c7.b(16);
        goto L46
    L41:
        r511 = null;
        goto L42
    L37:
        r111 = ContextCompat.getColor(r610, v19.c.b(R.attr.larus_base_1, r610, R.color.larus_base_1));
        goto L38
    L33:
        r410 = r717;
        goto L34
    L29:
        r310 = r716;
        goto L31
    L25:
        r210 = false;
        goto L27
    L21:
        r110 = r715;
        goto L23
    L17:
        r103 = r714;
        goto L19
    L13:
        r102 = r713;
        goto L15
    L9:
        r101 = r712;
        goto L11
    L5:
        r100 = r711;
        goto L7
    }
}
