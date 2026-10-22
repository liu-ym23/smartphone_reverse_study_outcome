package com.larus.bmhome.chat.standarduikit.quickreply.blockadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.applet.block.permissionapplycard.view.PermissionApplyCardView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.quickreply.IMoaGrantingAppletService;
import com.larus.bmhome.chat.quickreply.MoaGrantingDecision;
import com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.QuickReplyVMDependencyImpl;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyBlockStatus;
import com.larus.im.bean.message.block.QuickReplyDecisionContext;
import com.larus.im.bean.message.block.QuickReplyEnvironment;
import com.larus.im.bean.message.block.QuickReplyIcon;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc8.b;
import jc8.d;
import jc8.e;
import kc8.l0;
import kc8.y;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mi8.f;
import mi8.g;
import qm8.c;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends b<c> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f309533j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public mi8.a f309534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b f309535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<Pair<Integer, QuickReplyItem>> f309536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f309537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f309538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final QuickReplyVMDependencyImpl f309539i;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a$a, reason: collision with other inner class name */
    public static final class C4075a {
    }

    static {
    }

    @Override // jc8.b
    public final String c() {
        return "MoaGrantingQuickReplyBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        mi8.a r100 = this.f309534d;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        this.f309535e = null;
        this.f309536f = CollectionsKt.emptyList();
        this.f309537g = null;
        this.f309538h = null;
    }

    public a() {
        this.f309536f = CollectionsKt.emptyList();
        this.f309539i = new QuickReplyVMDependencyImpl();
    }

    @Override // jc8.b
    public final d f(jc8.a r100) {
        c r101 = (c) r100;
        Intrinsics.checkNotNullParameter(r101, "blockModel");
        return e.d(r101);
    }

    @Override // jc8.b
    public final void g(jc8.a r310) {
        c r100 = (c) r310;
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        mi8.a r101 = this.f309534d;
        if (r101 == null) goto L5;
        r101.recycle();
    L5:
        mi8.a r102 = this.f309534d;
        if (r102 == null) goto L8;
        r102.hide();
    L8:
        String r103 = null;
        this.f309535e = null;
        this.f309536f = CollectionsKt.emptyList();
        if (Intrinsics.areEqual(this.f309537g, r100.f498151g) == true) goto L11;
        this.f309537g = r100.f498151g;
        this.f309538h = null;
    L11:
        BlockContent r104 = r100.f498145a.getContent();
        if (r104 == null) goto L179;
        QuickReplyBlock r105 = r104.getQuickReplyBlock();
        if (r105 == null) goto L184;
        QuickReplyDecisionContext r106 = r105.getDecisionContext();
        if (r106 == null) goto L185;
        Integer r107 = r105.getStatus();
        int r108 = QuickReplyBlockStatus.STATUS_HIDDEN.getValue();
        boolean r109 = false;
        if (r107 != null) goto L23;
    L25:
        List<QuickReplyItem> r110 = r105.getItems();
        if (r110 != null) goto L28;
        r110 = CollectionsKt.emptyList();
    L28:
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
    L30:
        if (r112.hasNext() == false) goto L41;
        Object r113 = r112.next();
        String r114 = ((QuickReplyItem) r113).getText();
        if (r114 != null) goto L34;
    L37:
        boolean r115 = true;
    L39:
        if ((!r115) == false) goto L30;
        r111.add(r113);
        goto L30
    L34:
        if (StringsKt.isBlank(r114) == true) goto L37;
        r115 = false;
        goto L39
    L41:
        List r116 = r111;
    L42:
        Iterator r117 = r116.iterator();
        int r118 = 0;
    L43:
        int r119 = -1;
        if (r117.hasNext() == false) goto L55;
        Integer r120 = ((QuickReplyItem) r117.next()).getActionType();
        int r121 = ActionType.MOA_AUTH_ALLOW.getValue();
        if (r120 != null) goto L49;
    L51:
        boolean r122 = false;
    L52:
        if (r122 == true) goto L56;
        r118 = r118 + 1;
    L56:
        Integer r123 = Integer.valueOf(r118);
        if (r123.intValue() < 0) goto L59;
        boolean r124 = true;
    L60:
        if (r124 == true) goto L63;
        r123 = null;
    L63:
        if (r123 == null) goto L180;
        int r125 = r123.intValue();
        Iterator r126 = r116.iterator();
        int r127 = 0;
    L66:
        if (r126.hasNext() == false) goto L77;
        Integer r128 = ((QuickReplyItem) r126.next()).getActionType();
        int r129 = ActionType.MOA_AUTH_REFUSE.getValue();
        if (r128 != null) goto L71;
    L73:
        boolean r130 = false;
    L74:
        if (r130 == true) goto L75;
        r127 = r127 + 1;
        goto L66
    L75:
        r119 = r127;
        goto L77
    L71:
        if (r128.intValue() != r129) goto L73;
        r130 = true;
    L77:
        Integer r131 = Integer.valueOf(r119);
        if (r131.intValue() < 0) goto L80;
        boolean r132 = true;
    L81:
        if (r132 == true) goto L84;
        r131 = null;
    L84:
        if (r131 == null) goto L181;
        int r133 = r131.intValue();
        QuickReplyItem r134 = (QuickReplyItem) ListProtector.get(r116, r125);
        QuickReplyItem r135 = (QuickReplyItem) ListProtector.get(r116, r133);
        kc8.b r136 = (kc8.b) jc8.c.a(this, kc8.b.class);
        BlockContent r137 = r100.f498145a.getContent();
        if (r137 == null) goto L138;
        QuickReplyBlock r210 = r137.getQuickReplyBlock();
        if (r210 == null) goto L138;
        if (r136 == null) goto L92;
        y r138 = r136.f502425a;
    L93:
        Message r211 = r100.j();
        jc8.a r139 = r100.k();
        if (r139 == null) goto L96;
        long r140 = r139.f498147c;
    L97:
        long r141 = r140;
        String r142 = r100.f498151g;
        if (r138 == null) goto L103;
        Function0<String> r143 = r138.f502625f;
        if (r143 == null) goto L103;
        String r144 = r143.invoke();
        if (r144 == null) goto L103;
    L104:
        String r145 = r144;
        String r146 = r211.getMessageId();
        if (r138 == null) goto L112;
        Function0<BotModel> r147 = r138.f502631l;
        if (r147 == null) goto L112;
        BotModel r148 = r147.invoke();
        if (r148 == null) goto L112;
        String r149 = r148.getBotId();
        if (r149 == null) goto L112;
    L113:
        String r150 = r149;
        if (r138 == null) goto L120;
        Function0<ChatParam> r151 = r138.f502632m;
        if (r151 == null) goto L120;
        ChatParam r152 = r151.invoke();
        if (r152 == null) goto L120;
        String r153 = r152.f296892d;
    L121:
        Map<String, String> r212 = r211.getExt();
        if (r136 == null) goto L126;
        l0 r154 = r136.f502443s;
        if (r154 == null) goto L126;
        Function6<String, QuickReplyBlock, String, QuickReplyItem, Integer, Integer, Boolean> r213 = r154.f502523a;
    L127:
        if (r136 == null) goto L131;
        l0 r155 = r136.f502443s;
        if (r155 == null) goto L131;
        Integer r156 = r155.f502524b;
    L132:
        if (r138 == null) goto L136;
        Function0<ChatPageContext> r157 = r138.f502633n;
        if (r157 == null) goto L136;
        ChatPageContext r214 = r157.invoke();
    L137:
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r158 = new com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b(r145, r146, r150, r153, r141, r212, r213, r156, r210, r214, r142, r211);
    L139:
        this.f309535e = r158;
        this.f309536f = CollectionsKt.listOf(new Pair[]{TuplesKt.to(Integer.valueOf(r133), r135), TuplesKt.to(Integer.valueOf(r125), r134)});
        mi8.a r159 = this.f309534d;
        if (r159 == null) goto L157;
        String r160 = r100.f498151g;
        QuickReplyEnvironment r161 = r106.getEnvironment();
        if (r161 == null) goto L146;
        QuickReplyIcon r162 = r161.getIcon();
        if (r162 == null) goto L146;
        String r163 = r162.getUrlLight();
    L147:
        QuickReplyEnvironment r164 = r106.getEnvironment();
        if (r164 == null) goto L152;
        QuickReplyIcon r165 = r164.getIcon();
        if (r165 == null) goto L152;
        String r166 = r165.getUrlDark();
    L153:
        QuickReplyEnvironment r167 = r106.getEnvironment();
        if (r167 == null) goto L156;
        r103 = r167.getTitle();
    L156:
        r159.P5(new mi8.d(r160, r163, r166, r103, r106.getTitle(), r106.getContent(), r135.getText(), r134.getText()), new qm8.b(this, r158, r135, r133, r134, r125));
    L152:
        r166 = null;
    L146:
        r163 = null;
    L157:
        Integer r168 = this.f309538h;
        if (r168 == null) goto L182;
        mi8.a r169 = this.f309534d;
        if (r169 != null) goto L162;
        return;
    L162:
        if (r168.intValue() != ActionType.MOA_AUTH_ALLOW.getValue()) goto L164;
        boolean r170 = true;
    L166:
        if (r168.intValue() != ActionType.MOA_AUTH_REFUSE.getValue()) goto L168;
        r109 = true;
    L168:
        r169.P2(r170, r109);
        return;
    L164:
        r170 = false;
        goto L166
    L182:
        return;
    L136:
        r214 = null;
    L131:
        r156 = null;
    L126:
        r213 = null;
    L120:
        r153 = null;
    L112:
        r149 = r211.getSenderId();
    L103:
        r144 = r211.getConversationId();
        goto L104
    L96:
        r140 = 0;
        goto L97
    L92:
        r138 = null;
    L138:
        r158 = new com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b(null, null, null, null, 0, null, null, null, UnixStat.PERM_MASK);
        goto L139
    L181:
        return;
    L80:
        r132 = false;
        goto L81
    L180:
        return;
    L59:
        r124 = false;
        goto L60
    L49:
        if (r120.intValue() != r121) goto L51;
        r122 = true;
        goto L52
    L55:
        r118 = -1;
        goto L56
    L23:
        if (r107.intValue() != r108) goto L25;
        r116 = CollectionsKt.emptyList();
        goto L42
    L185:
        return;
    L184:
        return;
    }

    @Override // jc8.b
    public final View h(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        int r101 = mi8.c.f514110a;
        Context r102 = r100.getContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        IMoaGrantingAppletService r103 = mi8.c.a();
        if (r103 == null) goto L5;
        PermissionApplyCardView r104 = r103.b(r102);
    L6:
        this.f309534d = r104;
        if (r104 == null) goto L11;
        View r105 = r104.getView();
        if (r105 == null) goto L11;
        return r105;
    L11:
        return new View(r100.getContext());
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [qm8.a] */
    public static final void j(a r100, QuickReplyItem r110, int r111) {
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r101 = r100.f309535e;
        if (r101 == null) goto L76;
        List<Pair<Integer, QuickReplyItem>> r102 = r100.f309536f;
        boolean r103 = false;
        if ((r102 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L21;
        Pair r105 = (Pair) r104.next();
        if (((Number) r105.getFirst()).intValue() == r111) goto L16;
    L18:
        boolean r106 = false;
    L19:
        if (r106 == false) goto L12;
        boolean r112 = false;
    L22:
        if (r112 == false) goto L24;
        return;
    L24:
        if (r100.f309538h != null) goto L77;
        Integer r113 = r110.getActionType();
        if (r113 == null) goto L73;
        final int r114 = r113.intValue();
        final String r107 = r101.f309573k;
        if (r107 == null) goto L78;
        r100.f309538h = Integer.valueOf(r114);
        mi8.a r108 = r100.f309534d;
        if (r108 != null) goto L34;
    L41:
        final WeakReference r109 = new WeakReference(r100);
        ?? r115 = new qm8.a(r109, r107, r114);
        int r116 = com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.f309562a;
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.c(r101, r110, r110.getTrackIndex());
        String r117 = r110.getSchemaPayload();
        if (r117 != null) goto L45;
        r115.invoke();
        return;
    L45:
        if (r114 != ActionType.MOA_AUTH_ALLOW.getValue()) goto L49;
        MoaGrantingDecision r118 = MoaGrantingDecision.ALLOW;
    L47:
        MoaGrantingDecision r119 = r118;
        int r120 = mi8.c.f514110a;
        String r121 = r101.f309564b;
        if (r121 != null) goto L55;
        r121 = "";
    L55:
        f r122 = new f(r121);
        mi8.a r123 = r100.f309534d;
        if (r123 == null) goto L62;
        View r124 = r123.getView();
        if (r124 == null) goto L62;
        Context r125 = r124.getContext();
        if (r125 == null) goto L62;
        WeakReference r126 = new WeakReference(r125);
    L63:
        g r127 = new g(r117, r119, r122, r126, r115);
        Intrinsics.checkNotNullParameter(r127, "request");
        IMoaGrantingAppletService r128 = mi8.c.a();
        if (r128 == null) goto L75;
        r128.a(r127);
        return;
    L75:
        return;
    L62:
        r126 = null;
        goto L63
    L49:
        if (r114 != ActionType.MOA_AUTH_REFUSE.getValue()) goto L51;
        r118 = MoaGrantingDecision.REFUSE;
        goto L47
    L51:
        r118 = MoaGrantingDecision.UNSUPPORTED;
        goto L47
    L34:
        if (r114 != ActionType.MOA_AUTH_ALLOW.getValue()) goto L36;
        boolean r129 = true;
    L38:
        if (r114 != ActionType.MOA_AUTH_REFUSE.getValue()) goto L40;
        r103 = true;
    L40:
        r108.P2(r129, r103);
        goto L41
    L36:
        r129 = false;
        goto L38
    L78:
        return;
    L73:
        return;
    L77:
        return;
    L16:
        if (r105.getSecond() != r110) goto L18;
        r106 = true;
    L21:
        r112 = true;
        goto L22
    L8:
        if (r102.isEmpty() == false) goto L10;
    }
}
