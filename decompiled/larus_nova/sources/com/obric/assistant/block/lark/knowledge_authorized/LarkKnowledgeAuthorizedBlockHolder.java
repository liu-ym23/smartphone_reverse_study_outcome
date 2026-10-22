package com.obric.assistant.block.lark.knowledge_authorized;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OLarkKnowledgeBlock;
import com.larus.im.bean.message.block.OLarkKnowledgeButton;
import com.larus.im.bean.message.block.OLarkKnowledgeSubtitle;
import com.larus.im.observer.MessageListState;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.card.databinding.ObricImBlockKnowledgeAuthorizationBinding;
import com.obric.assistant.t1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kc8.g;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes32.dex */
public final class LarkKnowledgeAuthorizedBlockHolder extends jc8.b<com.obric.assistant.block.lark.knowledge_authorized.a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f385941k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObricImBlockKnowledgeAuthorizationBinding f385942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f385943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f385944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Message f385945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f385946h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f385947i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f385948j;

    public static final class a {
    }

    public static final class b implements nf9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LarkKnowledgeAuthorizedBlockHolder f385949a;

        @Override // nf9.b
        public final void a(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void c(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void d(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void e(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void f(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void onMessageListReplaced(String r100, List<Message> r101, List<Message> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "oldMsgList");
            Intrinsics.checkNotNullParameter(r102, "newMsgList");
        }

        public b(LarkKnowledgeAuthorizedBlockHolder r100) {
            this.f385949a = r100;
        }

        @Override // nf9.b
        public final void b(String r100, MessageListState r101, List<Message> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r102, "msgList");
            Message r103 = this.f385949a.f385945g;
            if (r103 == null) goto L5;
            String r104 = r103.getConversationId();
        L7:
            if (Intrinsics.areEqual(r100, r104) == false) goto L10;
            FLogger.f375446a.i("KnowledgeAuthorizedBlockHolder", "onMessageListChanged: cid=" + r100 + ", state=" + r101 + ", msgList.size=" + r102.size());
            this.f385949a.k();
            return;
        L10:
            return;
        L5:
            r104 = null;
            goto L7
        }
    }

    static {
    }

    @Override // jc8.b
    public final String c() {
        return "LarkKnowledgeAuthorizedBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        FLogger.f375446a.i("KnowledgeAuthorizedBlockHolder", "onViewRecycled");
        Job r100 = this.f385946h;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        Job r101 = this.f385947i;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        m();
    }

    public final void k() {
        Message r100 = this.f385945g;
        if (r100 != null) goto L6;
        FLogger.f375446a.i("KnowledgeAuthorizedBlockHolder", "checkLastMessage: blockMessage is null");
        return;
    L6:
        Job r101 = this.f385946h;
        if (r101 == null) goto L9;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L9:
        this.f385946h = BuildersKt.launch$default(this.f385943e, null, null, new LarkKnowledgeAuthorizedBlockHolder$checkLastMessageAndDisableBlock$1(this, r100, null), 3, null);
    }

    public final void l() {
        ObricImBlockKnowledgeAuthorizationBinding r100 = this.f385942d;
        if (r100 == null) goto L7;
        TextView r101 = r100.f386235b;
        if (r101 == null) goto L7;
        r101.setClickable(false);
    L7:
        ObricImBlockKnowledgeAuthorizationBinding r102 = this.f385942d;
        if (r102 == null) goto L12;
        TextView r103 = r102.f386235b;
        if (r103 == null) goto L12;
        r103.setFocusable(false);
    L12:
        ObricImBlockKnowledgeAuthorizationBinding r104 = this.f385942d;
        if (r104 == null) goto L17;
        TextView r105 = r104.f386235b;
        if (r105 == null) goto L17;
        r105.setEnabled(false);
    L17:
        ObricImBlockKnowledgeAuthorizationBinding r106 = this.f385942d;
        if (r106 == null) goto L22;
        TextView r107 = r106.f386235b;
        if (r107 == null) goto L22;
        r107.setOnClickListener(null);
    L22:
        ObricImBlockKnowledgeAuthorizationBinding r108 = this.f385942d;
        if (r108 == null) goto L28;
        RelativeLayout r109 = r108.f386234a;
        if (r109 == null) goto L29;
        r109.setAlpha(0.6f);
        return;
    L29:
        return;
    }

    public final void m() {
        if (this.f385944f.compareAndSet(true, false) == false) goto L6;
        FLogger.f375446a.i("KnowledgeAuthorizedBlockHolder", "unregisterOnGlobalMessageObserver");
        com.larus.im.d.e().unregisterOnGlobalMessageObserver((b) this.f385948j.getValue());
        return;
    }

    public LarkKnowledgeAuthorizedBlockHolder() {
        this.f385943e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f385944f = new AtomicBoolean(false);
        this.f385948j = LazyKt.lazy(new com.obric.assistant.block.lark.knowledge_authorized.b(this));
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r100) {
        Intrinsics.checkNotNullParameter((com.obric.assistant.block.lark.knowledge_authorized.a) r100, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    @Override // jc8.b
    public final void g(jc8.a r110) {
        com.obric.assistant.block.lark.knowledge_authorized.a r111 = (com.obric.assistant.block.lark.knowledge_authorized.a) r110;
        Intrinsics.checkNotNullParameter(r111, "blockModel");
        BlockContent r100 = r111.f498145a.getContent();
        String r101 = null;
        if (r100 == null) goto L5;
        OLarkKnowledgeBlock r102 = r100.getOLarkKnowledgeBlock();
    L6:
        FLogger r103 = FLogger.f375446a;
        r103.i("KnowledgeAuthorizedBlockHolder", "onBindBlockView: larkKnowledgeBlock = " + r102);
        if (r102 != null) goto L9;
        r103.w("KnowledgeAuthorizedBlockHolder", "onBindBlockView: larkKnowledgeBlock is null");
        return;
    L9:
        ObricImBlockKnowledgeAuthorizationBinding r104 = this.f385942d;
        if (r104 != null) goto L12;
        r103.w("KnowledgeAuthorizedBlockHolder", "onBindBlockView: binding is null");
        return;
    L12:
        this.f385945g = g.a(r111.f385950i);
        ObricImBlockKnowledgeAuthorizationBinding r105 = this.f385942d;
        if (r105 == null) goto L17;
        ImageView r106 = r105.f386244k;
        if (r106 == null) goto L17;
        r106.setImageResource(R.drawable.obric_ic_card_app_lark_knowledge);
    L17:
        ObricImBlockKnowledgeAuthorizationBinding r107 = this.f385942d;
        if (r107 == null) goto L22;
        ImageView r108 = r107.f386236c;
        if (r108 == null) goto L22;
        r108.setImageResource(R.drawable.obric_ic_card_exchange_icon);
    L22:
        ObricImBlockKnowledgeAuthorizationBinding r109 = this.f385942d;
        if (r109 == null) goto L27;
        ImageView r112 = r109.f386245l;
        if (r112 == null) goto L27;
        r112.setImageResource(R.drawable.obric_ic_card_app_doubao);
    L27:
        ObricImBlockKnowledgeAuthorizationBinding r113 = this.f385942d;
        String r114 = "";
        if (r113 == null) goto L35;
        TextView r115 = r113.f386246m;
        if (r115 == null) goto L35;
        String r116 = r102.title;
        if (r116 != null) goto L34;
        r116 = "";
    L34:
        r115.setText(r116);
    L35:
        ObricImBlockKnowledgeAuthorizationBinding r117 = this.f385942d;
        if (r117 == null) goto L43;
        TextView r118 = r117.f386242i;
        if (r118 == null) goto L43;
        String r119 = r102.hint;
        if (r119 != null) goto L42;
        r119 = "";
    L42:
        r118.setText(r119);
    L43:
        List<OLarkKnowledgeSubtitle> r120 = r102.subtitles;
        if (r120 != null) goto L46;
        r120 = CollectionsKt.emptyList();
    L46:
        ObricImBlockKnowledgeAuthorizationBinding r121 = this.f385942d;
        if (r121 == null) goto L57;
        TextView r122 = r121.f386240g;
        if (r122 == null) goto L57;
        OLarkKnowledgeSubtitle r123 = (OLarkKnowledgeSubtitle) CollectionsKt.getOrNull(r120, 0);
        if (r123 == null) goto L53;
        String r124 = r123.subtitle;
    L54:
        if (r124 != null) goto L56;
        r124 = "";
    L56:
        r122.setText(r124);
        goto L57
    L53:
        r124 = null;
    L57:
        ObricImBlockKnowledgeAuthorizationBinding r125 = this.f385942d;
        if (r125 == null) goto L68;
        TextView r126 = r125.f386241h;
        if (r126 == null) goto L68;
        OLarkKnowledgeSubtitle r127 = (OLarkKnowledgeSubtitle) CollectionsKt.getOrNull(r120, 1);
        if (r127 == null) goto L64;
        String r128 = r127.subtitle;
    L65:
        if (r128 != null) goto L67;
        r128 = "";
    L67:
        r126.setText(r128);
        goto L68
    L64:
        r128 = null;
    L68:
        ObricImBlockKnowledgeAuthorizationBinding r129 = this.f385942d;
        if (r129 == null) goto L79;
        TextView r130 = r129.f386238e;
        if (r130 == null) goto L79;
        OLarkKnowledgeSubtitle r131 = (OLarkKnowledgeSubtitle) CollectionsKt.getOrNull(r120, 0);
        if (r131 == null) goto L75;
        String r132 = r131.subContent;
    L76:
        if (r132 != null) goto L78;
        r132 = "";
    L78:
        r130.setText(r132);
        goto L79
    L75:
        r132 = null;
    L79:
        ObricImBlockKnowledgeAuthorizationBinding r133 = this.f385942d;
        if (r133 == null) goto L90;
        TextView r134 = r133.f386239f;
        if (r134 == null) goto L90;
        OLarkKnowledgeSubtitle r135 = (OLarkKnowledgeSubtitle) CollectionsKt.getOrNull(r120, 1);
        if (r135 == null) goto L86;
        String r136 = r135.subContent;
    L87:
        if (r136 != null) goto L89;
        r136 = "";
    L89:
        r134.setText(r136);
        goto L90
    L86:
        r136 = null;
    L90:
        ObricImBlockKnowledgeAuthorizationBinding r137 = this.f385942d;
        if (r137 == null) goto L95;
        ConstraintLayout r138 = r137.f386247n;
        if (r138 == null) goto L95;
        r138.setClickable(false);
    L95:
        ObricImBlockKnowledgeAuthorizationBinding r139 = this.f385942d;
        if (r139 == null) goto L100;
        LinearLayout r140 = r139.f386243j;
        if (r140 == null) goto L100;
        r140.setClickable(false);
    L100:
        ObricImBlockKnowledgeAuthorizationBinding r141 = this.f385942d;
        if (r141 == null) goto L106;
        LinearLayout r142 = r141.f386237d;
        if (r142 == null) goto L106;
        r142.setClickable(false);
    L106:
        if (t1.f393353a.isLarkKnowledgeAuthorizationEnable() == false) goto L116;
        TextView r143 = r104.f386235b;
        List<OLarkKnowledgeButton> r144 = r102.buttons;
        if (r144 == null) goto L112;
        OLarkKnowledgeButton r145 = (OLarkKnowledgeButton) CollectionsKt.firstOrNull(r144);
        if (r145 == null) goto L112;
        r101 = r145.textSelected;
    L112:
        if (r101 == null) goto L115;
        r114 = r101;
    L115:
        r143.setText(r114);
        l();
        return;
    L116:
        boolean r146 = Intrinsics.areEqual(r102.enabled, Boolean.TRUE);
        r103.i("KnowledgeAuthorizedBlockHolder", "onBindBlockView: isBlockEnabled = " + r146 + " , curBlockMessage = " + this.f385945g);
        o(r111, r102);
        if (r146 == false) goto L135;
        Map<String, String> r147 = g.a(r111.f385950i).getExt();
        if (r147 == null) goto L121;
        String r148 = r147.get("o_task_type");
    L123:
        if (Intrinsics.areEqual(r148, "complex_task") == false) goto L125;
        return;
    L125:
        if (this.f385944f.compareAndSet(false, true) == false) goto L127;
        r103.i("KnowledgeAuthorizedBlockHolder", "registerOnGlobalMessageObserver");
        com.larus.im.d.e().registerOnGlobalMessageObserver((b) this.f385948j.getValue());
    L127:
        k();
        Job r149 = this.f385947i;
        if (r149 == null) goto L130;
        Job.DefaultImpls.cancel$default(r149, null, 1, null);
    L130:
        this.f385947i = BuildersKt.launch$default(this.f385943e, null, null, new LarkKnowledgeAuthorizedBlockHolder$startTimeoutCheck$1(this, null), 3, null);
        return;
    L121:
        r148 = null;
        goto L123
    L135:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // jc8.b
    public final View h(ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r110, "viewGroup");
        FLogger.f375446a.i("KnowledgeAuthorizedBlockHolder", "onCreatedBlockView: viewGroup = " + r110);
        View r100 = LayoutInflater.from(r110.getContext()).inflate(R.layout.obric_im_block_knowledge_authorization, r110, false);
        int r101 = R.id.authorization_but;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.authorization_but);
        if (r102 == null) goto L35;
        r101 = R.id.exchange_icon;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r100, R.id.exchange_icon);
        if (r103 == null) goto L35;
        r101 = R.id.foot_zone;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.foot_zone);
        if (r104 == null) goto L35;
        r101 = R.id.hint_icon1;
        if (((ImageView) ViewBindings.findChildViewById(r100, R.id.hint_icon1)) == null) goto L35;
        r101 = R.id.hint_icon2;
        if (((ImageView) ViewBindings.findChildViewById(r100, R.id.hint_icon2)) == null) goto L35;
        r101 = R.id.hint_subcontent1;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r100, R.id.hint_subcontent1);
        if (r105 == null) goto L35;
        r101 = R.id.hint_subcontent2;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r100, R.id.hint_subcontent2);
        if (r106 == null) goto L35;
        r101 = R.id.hint_subtitle1;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r100, R.id.hint_subtitle1);
        if (r111 == null) goto L35;
        r101 = R.id.hint_subtitle2;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r100, R.id.hint_subtitle2);
        if (r112 == null) goto L35;
        r101 = R.id.hint_title;
        TextView r113 = (TextView) ViewBindings.findChildViewById(r100, R.id.hint_title);
        if (r113 == null) goto L35;
        r101 = R.id.middle_zone;
        LinearLayout r114 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.middle_zone);
        if (r114 == null) goto L35;
        r101 = R.id.source_icon;
        ImageView r115 = (ImageView) ViewBindings.findChildViewById(r100, R.id.source_icon);
        if (r115 == null) goto L35;
        r101 = R.id.target_icon;
        ImageView r116 = (ImageView) ViewBindings.findChildViewById(r100, R.id.target_icon);
        if (r116 == null) goto L35;
        r101 = R.id.title;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r100, R.id.title);
        if (r117 == null) goto L35;
        r101 = R.id.top_zone;
        ConstraintLayout r118 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.top_zone);
        if (r118 == null) goto L35;
        RelativeLayout r107 = (RelativeLayout) r100;
        this.f385942d = new ObricImBlockKnowledgeAuthorizationBinding(r107, r102, r103, r104, r105, r106, r111, r112, r113, r114, r115, r116, r117, r118);
        return r107;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public final void o(final com.obric.assistant.block.lark.knowledge_authorized.a r100, final OLarkKnowledgeBlock r101) {
        ObricImBlockKnowledgeAuthorizationBinding r102 = this.f385942d;
        if (r102 != null) goto L7;
        FLogger.f375446a.w("KnowledgeAuthorizedBlockHolder", "updateViewHolder: binding is null");
        return;
    L7:
        if (Intrinsics.areEqual(r101.type, "lark_knowledge_authorized") == true) goto L10;
        FLogger.f375446a.i("KnowledgeAuthorizedBlockHolder", "updateViewHolder: unknown knowledge authorized type");
        return;
    L10:
        List<OLarkKnowledgeButton> r103 = r101.buttons;
        if (r103 == null) goto L24;
        OLarkKnowledgeButton r104 = (OLarkKnowledgeButton) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L24;
        TextView r105 = r102.f386235b;
        if (Intrinsics.areEqual(r104.isSelected, Boolean.TRUE) == false) goto L19;
        String r106 = r104.textSelected;
        if (r106 == null) goto L21;
    L22:
        r105.setText(r106);
    L21:
        r106 = "";
        goto L22
    L19:
        r106 = r104.textNormal;
        if (r106 != null) goto L22;
    L24:
        if (Intrinsics.areEqual(r101.enabled, Boolean.FALSE) == false) goto L26;
        l();
        return;
    L26:
        r102.f386234a.setAlpha(1.0f);
        r102.f386235b.setClickable(true);
        r102.f386235b.setFocusable(true);
        e1.d(r102.f386235b, new c(r101, this, r100));
    }

    public static final Object j(LarkKnowledgeAuthorizedBlockHolder r100, String r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof LarkKnowledgeAuthorizedBlockHolder$getLastMessage$1) == false) goto L7;
        LarkKnowledgeAuthorizedBlockHolder$getLastMessage$1 r101 = (LarkKnowledgeAuthorizedBlockHolder$getLastMessage$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r110 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L123:
        Message r105 = (Message) r112;
        if (r105 == null) goto L126;
        FLogger.f375446a.i("KnowledgeAuthorizedBlockHolder", "getLastMessage from repo " + r105.getMessageId());
        return r105;
    L126:
        FLogger.f375446a.i("KnowledgeAuthorizedBlockHolder", "getLastMessage: cvsId = " + r110 + ", not found");
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        kc8.b r113 = (kc8.b) jc8.c.a(r100, kc8.b.class);
        if (r113 == null) goto L64;
        y r114 = r113.f502425a;
        if (r114 == null) goto L64;
        Fragment r115 = r114.f502620a;
        if (r115 == null) goto L64;
        t1a.b r116 = s1a.a.g(r115);
        if (r116 == null) goto L64;
        u7 r117 = (u7) r116.getAbility(u7.class);
        if (r117 == null) goto L64;
        List<Message> r118 = r117.zj();
        if (r118 == null) goto L64;
        Iterator<T> r119 = r118.iterator();
    L28:
        if (r119.hasNext() == false) goto L62;
        Object r106 = r119.next();
        Message r107 = (Message) r106;
        if (com.larus.bmhome.chat.bean.d.i0(r107) == false) goto L35;
        if (com.larus.bmhome.chat.bean.d.w(r107) == true) goto L35;
    L54:
        boolean r108 = false;
    L55:
        if (r108 == true) goto L57;
    L59:
        boolean r109 = false;
    L60:
        if (r109 == false) goto L28;
    L63:
        Message r120 = (Message) r106;
    L65:
        if (r120 == null) goto L67;
        FLogger.f375446a.i("KnowledgeAuthorizedBlockHolder", "getLastMessage from last message list " + r120.getMessageId());
        return r120;
    L67:
        kc8.b r121 = (kc8.b) jc8.c.a(r100, kc8.b.class);
        if (r121 == null) goto L117;
        y r122 = r121.f502425a;
        if (r122 == null) goto L117;
        Fragment r123 = r122.f502620a;
        if (r123 == null) goto L117;
        t1a.b r124 = s1a.a.g(r123);
        if (r124 == null) goto L117;
        u7 r125 = (u7) r124.getAbility(u7.class);
        if (r125 == null) goto L117;
        MessageAdapter r126 = r125.MF();
        if (r126 == null) goto L117;
        Iterator<T> r127 = r126.getCurrentList().iterator();
    L81:
        if (r127.hasNext() == false) goto L115;
        Object r128 = r127.next();
        Message r129 = (Message) r128;
        if (com.larus.bmhome.chat.bean.d.i0(r129) == false) goto L88;
        if (com.larus.bmhome.chat.bean.d.w(r129) == true) goto L88;
    L107:
        boolean r130 = false;
    L108:
        if (r130 == true) goto L110;
    L112:
        boolean r131 = false;
    L113:
        if (r131 == false) goto L81;
    L116:
        Message r132 = (Message) r128;
    L118:
        if (r132 == null) goto L120;
        FLogger.f375446a.i("KnowledgeAuthorizedBlockHolder", "getLastMessage from adapter list " + r132.getMessageId());
        return r132;
    L120:
        IChatRepoService r133 = zh8.a.f572196a;
        r101.L$0 = r110;
        r101.label = 1;
        r112 = r133.D1(r110, r101);
        if (r112 != r103) goto L123;
        return r103;
    L110:
        if (b0.f(r129) == true) goto L112;
        r131 = true;
    L88:
        if (com.larus.bmhome.chat.bean.d.T(r129) == true) goto L107;
        if (com.larus.bmhome.chat.bean.d.p0(r129) == true) goto L107;
        if (com.larus.bmhome.chat.bean.d.C0(r129) == true) goto L95;
    L97:
        MessageStatus r134 = r129.getMessageStatus();
        if (r134 != null) goto L100;
    L102:
        boolean r135 = false;
    L103:
        if (r135 == false) goto L105;
    L106:
        r130 = true;
        goto L108
    L105:
        if (b0.f(r129) == false) goto L107;
    L100:
        if (r134.isVisible() != true) goto L102;
        r135 = true;
        goto L103
    L95:
        if (r129.getRegenVisible() == true) goto L97;
    L115:
        r128 = null;
    L117:
        r132 = null;
        goto L118
    L57:
        if (b0.f(r107) == true) goto L59;
        r109 = true;
    L35:
        if (com.larus.bmhome.chat.bean.d.T(r107) == true) goto L54;
        if (com.larus.bmhome.chat.bean.d.p0(r107) == true) goto L54;
        if (com.larus.bmhome.chat.bean.d.C0(r107) == true) goto L42;
    L44:
        MessageStatus r136 = r107.getMessageStatus();
        if (r136 != null) goto L47;
    L49:
        boolean r137 = false;
    L50:
        if (r137 == false) goto L52;
    L53:
        r108 = true;
        goto L55
    L52:
        if (b0.f(r107) == false) goto L54;
    L47:
        if (r136.isVisible() != true) goto L49;
        r137 = true;
        goto L50
    L42:
        if (r107.getRegenVisible() == true) goto L44;
    L62:
        r106 = null;
    L64:
        r120 = null;
    L7:
        r101 = new LarkKnowledgeAuthorizedBlockHolder$getLastMessage$1(r100, r111);
        goto L8
    }
}
