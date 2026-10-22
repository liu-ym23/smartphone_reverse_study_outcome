package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LinkReaderBlock;
import com.larus.im.bean.message.block.SearchQueryBlock;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusBlockItemTextSwitchBinding;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class t2 extends AbsBlockView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LarusBlockItemTextSwitchBinding f302562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Message f302563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BotModel f302564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f302565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f302566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f302567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public po8.z f302568h;

    public t2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v27, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v37, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List] */
    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(final Block r110, Map<String, Object> r111) {
        String r100 = "";
        String r101 = null;
        if (r111 == null) goto L5;
        Object r102 = r111.get("block_view_extra_message");
    L7:
        if ((r102 instanceof Message) == false) goto L9;
        Message r103 = (Message) r102;
    L10:
        this.f302563c = r103;
        if (r111 == null) goto L13;
        Object r104 = r111.get("block_view_extra_bot_model");
    L15:
        if ((r104 instanceof BotModel) == false) goto L17;
        BotModel r105 = (BotModel) r104;
    L18:
        this.f302564d = r105;
        if (r111 == null) goto L21;
        Object r106 = r111.get("block_view_extra_mob_research_id");
    L23:
        if ((r106 instanceof String) == false) goto L25;
        String r107 = (String) r106;
    L26:
        this.f302565e = r107;
        if (r111 == null) goto L29;
        Object r108 = r111.get("block_view_extra_previous_page");
    L31:
        if ((r108 instanceof String) == false) goto L33;
        String r109 = (String) r108;
    L34:
        this.f302566f = r109;
        if (r111 == null) goto L37;
        Object r112 = r111.get("block_view_extra_current_page");
    L39:
        if ((r112 instanceof String) == false) goto L41;
        String r113 = (String) r112;
    L42:
        this.f302567g = r113;
        final LarusBlockItemTextSwitchBinding r114 = this.f302562b;
        boolean r115 = true;
        if (r114 == null) goto L310;
        AbsBlockView.a.e(r114.f358497b, r110);
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L220
        if (r110 == null) goto L48;
        Integer r117 = Integer.valueOf(r110.getBlockType());     // Catch: Throwable -> L220
    L49:
        int r118 = j.f302423k;     // Catch: Throwable -> L220
        if (r117 != null) goto L53;
    L182:
        int r119 = j.f302427m;     // Catch: Throwable -> L220
        if (r117 != null) goto L186;
    L218:
        ?? r120 = CollectionsKt.emptyList();     // Catch: Throwable -> L220
    L225:
        ?? r121 = r120;
        if (r110 != null) goto L228;
    L230:
        boolean r122 = false;
    L231:
        if (r122 == false) goto L259;
        po8.z r123 = this.f302568h;
        if (r123 == null) goto L235;
        r123.b();
    L235:
        TextSwitcher r124 = r114.f358499d;
        if (r124 == null) goto L238;
        r124.setInAnimation(null);
    L238:
        TextSwitcher r125 = r114.f358499d;
        if (r125 == null) goto L241;
        r125.setOutAnimation(null);
    L241:
        TextSwitcher r126 = r114.f358499d;
        if (r121 == 0) goto L247;
        String r127 = (String) CollectionsKt.getOrNull(r121, 0);
        if (r127 == null) goto L247;
        r100 = r127;
    L247:
        r126.setText(r100);
        View r128 = r114.f358499d.getNextView();
        if ((r128 instanceof ShimmerTextView) == false) goto L250;
        ShimmerTextView r129 = (ShimmerTextView) r128;
    L251:
        View r130 = r114.f358499d.getCurrentView();
        if ((r130 instanceof ShimmerTextView) == false) goto L254;
        ShimmerTextView r131 = (ShimmerTextView) r130;
    L255:
        if (r129 == null) goto L257;
        r129.x();
    L257:
        if (r131 == null) goto L265;
        r131.x();
    L265:
        if (r110 == null) goto L267;
        Integer r132 = Integer.valueOf(r110.getBlockType());
    L268:
        int r133 = j.f302423k;
        if (r132 != null) goto L272;
    L283:
        boolean r134 = false;
    L284:
        if (r134 == false) goto L305;
        LarusBlockItemTextSwitchBinding r135 = this.f302562b;
        if (r135 == null) goto L290;
        AppCompatTextView r136 = r135.f358498c;
        if (r136 == null) goto L290;
        r136.setVisibility(0);
    L290:
        LarusBlockItemTextSwitchBinding r137 = this.f302562b;
        if (r137 == null) goto L295;
        AppCompatTextView r138 = r137.f358498c;
        if (r138 == null) goto L295;
        we8.a.b(r138, i5.o(), false, null, null, 12);
    L295:
        LarusBlockItemTextSwitchBinding r139 = this.f302562b;
        if (r139 == null) goto L300;
        AppCompatTextView r140 = r139.f358498c;
        if (r140 == null) goto L300;
        r140.setLineHeight(i5.E());
    L300:
        LarusBlockItemTextSwitchBinding r141 = this.f302562b;
        if (r141 == null) goto L310;
        AppCompatTextView r142 = r141.f358498c;
        if (r142 == null) goto L310;
        r142.setText(AbsBlockView.a.f(r110, false, false));
        goto L310
    L305:
        LarusBlockItemTextSwitchBinding r143 = this.f302562b;
        if (r143 == null) goto L310;
        AppCompatTextView r144 = r143.f358498c;
        if (r144 == null) goto L310;
        r144.setVisibility(8);
        goto L310
    L272:
        if (r132.intValue() != r133) goto L283;
        if (r110.isFinish() == false) goto L283;
        BlockContent r145 = r110.getContent();
        if (r145 == null) goto L281;
        SearchQueryBlock r146 = r145.getSearchQueryBlock();
        if (r146 == null) goto L281;
        r101 = r146.summaryV2;
    L281:
        if (com.larus.utils.o0.d(r101) == false) goto L283;
        r134 = true;
        goto L284
    L267:
        r132 = null;
        goto L268
    L254:
        r131 = null;
        goto L255
    L250:
        r129 = null;
        goto L251
    L259:
        po8.z r147 = this.f302568h;
        if (r147 == null) goto L262;
        r147.b();
    L262:
        po8.z r148 = new po8.z(r114.f358499d, r121, 1000, new o2(r114));
        this.f302568h = r148;
        r148.a(r114.f358499d.getContext());
        po8.z r149 = this.f302568h;
        if (r149 == null) goto L265;
        r149.c();
        goto L265
    L228:
        if (r110.isFinish() != true) goto L230;
        r122 = true;
        goto L231
    L186:
        if (r117.intValue() != r119) goto L218;
        if (r110 == null) goto L208;
        BlockContent r150 = r110.getContent();     // Catch: Throwable -> L220
        if (r150 == null) goto L208;
        LinkReaderBlock r151 = r150.getLinkReaderBlock();     // Catch: Throwable -> L220
        if (r151 == null) goto L208;
        List<TextCard> r152 = r151.items;     // Catch: Throwable -> L220
        if (r152 == null) goto L208;
        ArrayList r153 = new ArrayList();     // Catch: Throwable -> L220
        Iterator r154 = r152.iterator();     // Catch: Throwable -> L220
    L196:
        if (r154.hasNext() == false) goto L207;
        TextCard r155 = (TextCard) r154.next();     // Catch: Throwable -> L220
        StringCompanionObject r156 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L220
        BlockContent r157 = r110.getContent();     // Catch: Throwable -> L220
        if (r157 == null) goto L203;
        LinkReaderBlock r158 = r157.getLinkReaderBlock();     // Catch: Throwable -> L220
        if (r158 == null) goto L203;
        String r159 = r158.summary;     // Catch: Throwable -> L220
        if (r159 == null) goto L203;
    L204:
        String r160 = String.format(r159, Arrays.copyOf(new Object[]{r155}, 1));     // Catch: Throwable -> L220
        if (r160 == null) goto L196;
        r153.add(r160);     // Catch: Throwable -> L220
    L203:
        r159 = "";
        goto L204
    L207:
        r120 = r153;
    L209:
        if (r120 != 0) goto L225;
        BlockContent r161 = r110.getContent();     // Catch: Throwable -> L220
        if (r161 == null) goto L216;
        LinkReaderBlock r162 = r161.getLinkReaderBlock();     // Catch: Throwable -> L220
        if (r162 == null) goto L216;
        String r163 = r162.summary;     // Catch: Throwable -> L220
        if (r163 == null) goto L216;
    L217:
        r120 = CollectionsKt.listOf(r163);     // Catch: Throwable -> L220
    L216:
        r163 = "";
    L208:
        r120 = 0;
        goto L209
    L53:
        if (r117.intValue() != r118) goto L182;
        BlockContent r164 = r110.getContent();     // Catch: Throwable -> L220
        if (r164 == null) goto L59;
        SearchQueryBlock r165 = r164.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r165 == null) goto L59;
        String r166 = r165.summaryV2;     // Catch: Throwable -> L220
    L60:
        if (r166 != null) goto L62;
    L65:
        boolean r167 = true;
    L67:
        if (r167 == false) goto L106;
        BlockContent r168 = r110.getContent();     // Catch: Throwable -> L220
        if (r168 == null) goto L95;
        SearchQueryBlock r169 = r168.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r169 == null) goto L95;
        List<String> r170 = r169.queries;     // Catch: Throwable -> L220
        if (r170 == null) goto L95;
        r120 = new ArrayList();     // Catch: Throwable -> L220
        Iterator r171 = r170.iterator();     // Catch: Throwable -> L220
    L76:
        if (r171.hasNext() == false) goto L96;
        String r172 = (String) r171.next();     // Catch: Throwable -> L220
        StringCompanionObject r173 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L220
        BlockContent r174 = r110.getContent();     // Catch: Throwable -> L220
        if (r174 == null) goto L83;
        SearchQueryBlock r175 = r174.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r175 == null) goto L83;
        String r176 = r175.summary;     // Catch: Throwable -> L220
        if (r176 == null) goto L83;
    L84:
        Object[] r177 = new Object[2];     // Catch: Throwable -> L220
        r177[0] = r172;     // Catch: Throwable -> L220
        BlockContent r178 = r110.getContent();     // Catch: Throwable -> L220
        if (r178 == null) goto L91;
        SearchQueryBlock r179 = r178.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r179 == null) goto L91;
        List<String> r180 = r179.queries;     // Catch: Throwable -> L220
        if (r180 == null) goto L91;
        Integer r181 = Integer.valueOf(r180.size());     // Catch: Throwable -> L220
    L92:
        r177[1] = r181;     // Catch: Throwable -> L220
        String r182 = String.format(r176, Arrays.copyOf(r177, 2));     // Catch: Throwable -> L220
        if (r182 == null) goto L76;
        r120.add(r182);     // Catch: Throwable -> L220
    L91:
        r181 = null;
    L83:
        r176 = "";
    L96:
        if (r120 != 0) goto L225;
        BlockContent r183 = r110.getContent();     // Catch: Throwable -> L220
        if (r183 == null) goto L103;
        SearchQueryBlock r184 = r183.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r184 == null) goto L103;
        String r185 = r184.summary;     // Catch: Throwable -> L220
        if (r185 == null) goto L103;
    L104:
        r120 = CollectionsKt.listOf(r185);     // Catch: Throwable -> L220
    L103:
        r185 = "";
    L95:
        r120 = 0;
        goto L96
    L106:
        if (r110.isFinish() == false) goto L145;
        BlockContent r186 = r110.getContent();     // Catch: Throwable -> L220
        if (r186 == null) goto L135;
        SearchQueryBlock r187 = r186.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r187 == null) goto L135;
        List<String> r188 = r187.queries;     // Catch: Throwable -> L220
        if (r188 == null) goto L135;
        ArrayList r189 = new ArrayList();     // Catch: Throwable -> L220
        Iterator r190 = r188.iterator();     // Catch: Throwable -> L220
    L115:
        if (r190.hasNext() == false) goto L134;
        String r191 = (String) r190.next();     // Catch: Throwable -> L220
        StringCompanionObject r192 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L220
        BlockContent r193 = r110.getContent();     // Catch: Throwable -> L220
        if (r193 == null) goto L122;
        SearchQueryBlock r194 = r193.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r194 == null) goto L122;
        String r195 = r194.summaryV2;     // Catch: Throwable -> L220
        if (r195 == null) goto L122;
    L123:
        Object[] r196 = new Object[1];     // Catch: Throwable -> L220
        BlockContent r197 = r110.getContent();     // Catch: Throwable -> L220
        if (r197 == null) goto L130;
        SearchQueryBlock r198 = r197.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r198 == null) goto L130;
        List<String> r199 = r198.queries;     // Catch: Throwable -> L220
        if (r199 == null) goto L130;
        Integer r200 = Integer.valueOf(r199.size());     // Catch: Throwable -> L220
    L131:
        r196[0] = r200;     // Catch: Throwable -> L220
        String r201 = String.format(r195, Arrays.copyOf(r196, 1));     // Catch: Throwable -> L220
        if (r201 == null) goto L115;
        r189.add(r201);     // Catch: Throwable -> L220
    L130:
        r200 = null;
    L122:
        r195 = "";
        goto L123
    L134:
        r120 = r189;
    L136:
        if (r120 != 0) goto L225;
        BlockContent r202 = r110.getContent();     // Catch: Throwable -> L220
        if (r202 == null) goto L143;
        SearchQueryBlock r203 = r202.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r203 == null) goto L143;
        String r204 = r203.summaryV2;     // Catch: Throwable -> L220
        if (r204 == null) goto L143;
    L144:
        r120 = CollectionsKt.listOf(r204);     // Catch: Throwable -> L220
    L143:
        r204 = "";
    L135:
        r120 = 0;
        goto L136
    L145:
        BlockContent r205 = r110.getContent();     // Catch: Throwable -> L220
        if (r205 == null) goto L172;
        SearchQueryBlock r206 = r205.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r206 == null) goto L172;
        List<String> r207 = r206.queries;     // Catch: Throwable -> L220
        if (r207 == null) goto L172;
        r120 = new ArrayList();     // Catch: Throwable -> L220
        Iterator r208 = r207.iterator();     // Catch: Throwable -> L220
    L153:
        if (r208.hasNext() == false) goto L173;
        String r209 = (String) r208.next();     // Catch: Throwable -> L220
        StringCompanionObject r210 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L220
        BlockContent r211 = r110.getContent();     // Catch: Throwable -> L220
        if (r211 == null) goto L160;
        SearchQueryBlock r212 = r211.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r212 == null) goto L160;
        String r213 = r212.summaryV2;     // Catch: Throwable -> L220
        if (r213 == null) goto L160;
    L161:
        Object[] r214 = new Object[2];     // Catch: Throwable -> L220
        r214[0] = r209;     // Catch: Throwable -> L220
        BlockContent r215 = r110.getContent();     // Catch: Throwable -> L220
        if (r215 == null) goto L168;
        SearchQueryBlock r216 = r215.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r216 == null) goto L168;
        List<String> r217 = r216.queries;     // Catch: Throwable -> L220
        if (r217 == null) goto L168;
        Integer r218 = Integer.valueOf(r217.size());     // Catch: Throwable -> L220
    L169:
        r214[1] = r218;     // Catch: Throwable -> L220
        String r219 = String.format(r213, Arrays.copyOf(r214, 2));     // Catch: Throwable -> L220
        if (r219 == null) goto L153;
        r120.add(r219);     // Catch: Throwable -> L220
    L168:
        r218 = null;
    L160:
        r213 = "";
    L173:
        if (r120 != 0) goto L225;
        BlockContent r220 = r110.getContent();     // Catch: Throwable -> L220
        if (r220 == null) goto L180;
        SearchQueryBlock r221 = r220.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r221 == null) goto L180;
        String r222 = r221.summaryV2;     // Catch: Throwable -> L220
        if (r222 == null) goto L180;
    L181:
        r120 = CollectionsKt.listOf(r222);     // Catch: Throwable -> L220
    L180:
        r222 = "";
    L172:
        r120 = 0;
        goto L173
    L62:
        if (r166.length() == 0) goto L65;
        r167 = false;
    L59:
        r166 = null;
        goto L60
    L48:
        r117 = null;
    L220:
        th = move-exception;
        Result.Companion r223 = Result.Companion;
        Throwable r224 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r224 == null) goto L224;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(r224);
        FLogger.f375446a.i("AbsBlockView", r224.toString());
        r120 = CollectionsKt.emptyList();
        goto L225
    L224:
        r120 = CollectionsKt.emptyList();
    L310:
        String r1100 = AbsBlockView.a.d(r110);
        if (r1100 != null) goto L313;
    L316:
        if (r115 == true) goto L341;
        ExposureTrackerExtKt.a(this, new q2(r110, this));
        return;
    L341:
        return;
    L313:
        if (r1100.length() == 0) goto L316;
        r115 = false;
        goto L316
    L41:
        r113 = null;
        goto L42
    L37:
        r112 = null;
        goto L39
    L33:
        r109 = null;
        goto L34
    L29:
        r108 = null;
        goto L31
    L25:
        r107 = null;
        goto L26
    L21:
        r106 = null;
        goto L23
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L15
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_block_item_text_switch, this, false);
        addView(r102);
        int r103 = R.id.deep_research_item_icon;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.deep_research_item_icon);
        if (r104 == null) goto L11;
        r103 = R.id.deepResearchItemTextContainer;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.deepResearchItemTextContainer);
        if (r105 == null) goto L11;
        r103 = R.id.research_reference_switcher;
        TextSwitcher r106 = (TextSwitcher) ViewBindings.findChildViewById(r102, R.id.research_reference_switcher);
        if (r106 == null) goto L11;
        final LarusBlockItemTextSwitchBinding r107 = new LarusBlockItemTextSwitchBinding((LinearLayout) r102, r104, r105, r106);
        this.f302562b = r107;
        r106.setFactory(new p2(r107, r100));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
