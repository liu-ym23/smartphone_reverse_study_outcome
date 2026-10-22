package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.message.params.o;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyBlock;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.coremd.utils.MessageStyleHelper;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.ss.android.lark.widget.span.i0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class d extends CommonReplyContentRender implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m2b.a f412140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.a f412141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.a f412142d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f412143a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f412144b = null;

        static {
            int[] r100 = new int[Message.Type.values().length];
            r100[Message.Type.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Message.Type.RED_PACKET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            f412143a = r100;
            int[] r101 = new int[ReplyActionUtils.ReplyStyle.values().length];
            r101[ReplyActionUtils.ReplyStyle.PARTIAL_REPLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r101[ReplyActionUtils.ReplyStyle.FULL_REPLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            f412144b = r101;
        }
    }

    public c.a d() {
        return this.f412141c;
    }

    public m2b.a e() {
        return this.f412140b;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c
    public final void a(ReplyBlock.b r100) {
        this.f412142d = r100;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c
    public final String b(y6b.b r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterVO");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.f566460i;
    }

    public final void g(ReplyBlock.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.f412909f.setImageResource(R.drawable.chat_no_view_perm_drawable_noboarder);
        r100.f412910g.setRadius(6.0f);
        r100.f412910g.setBorderWidth(1.0f);
        r100.f412910g.setBorderColor(UDColorUtils.getColor(e().getContext(), R.color.line_border_card));
    }

    public d(m2b.a r100, c.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        Intrinsics.checkNotNullParameter(r101, "callbackHub");
        this.f412140b = r100;
        this.f412141c = r101;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c
    public final void c(y6b.c r110, y6b.c r111, ReplyBlock.a r112) {
        u5b.b r100 = u5b.b.f548898e;
        Intrinsics.checkNotNullParameter(r110, "replyMessageVO");
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r112, "holder");
        Intrinsics.checkNotNullParameter(r100, "replyStyle");
        r112.f412907d.setVisibility(0);
        r112.f412909f.setVisibility(8);
        r112.f412910g.setVisibility(8);
        boolean r101 = true;
        if (r110.j() == false) goto L10;
        if (Message.RecallerIdentity.ENTERPRISE_ADMINISTRATOR != r110.f566514x) goto L7;
        String r102 = UIHelper.getString(R.string.Lark_IM_MessageRecalledByAdmin_Text);
    L8:
        Function2<String, b, Unit> r103 = this.f412137a;
        Intrinsics.checkNotNull(r102);
        r103.invoke(r102, r112);
    L20:
        boolean r104 = true;
    L22:
        if (r104 == false) goto L24;
        return;
    L24:
        r112.f412907d.setVisibility(8);
        r112.f412909f.setVisibility(0);
        r112.f412910g.setVisibility(0);
        int r105 = a.f412143a[r110.getType().ordinal()];
        if (r105 == 1) goto L29;
        if (r105 == 2) goto L28;
        boolean r106 = false;
    L31:
        if (r106 == false) goto L33;
        return;
    L33:
        r112.f412907d.setVisibility(0);
        r112.f412909f.setVisibility(8);
        r112.f412910g.setVisibility(8);
        r112.f412907d.setTranslateEmojiCode(false);
        EllipsizedEmojiconTextView r107 = r112.f412907d;
        int r108 = h18.e.f483540a;
        r107.setTypeface(h18.e.b(e().getContext(), 0));
        Message.Type r109 = r110.getType();
        int r113 = ReplyActionUtils.f416623a;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        Intrinsics.checkNotNullParameter(r109, "replyMsgType");
        Message.Type r114 = Message.Type.DOUBAO;
        if (r109 != r114) goto L41;
        if (ReplyActionUtils.c() == false) goto L41;
        if (r111.f566515x1 == null) goto L41;
        ReplyActionUtils.ReplyStyle r115 = ReplyActionUtils.ReplyStyle.PARTIAL_REPLY;
    L48:
        int r116 = a.f412144b[r115.ordinal()];
        if (r116 == 1) goto L78;
        if (r116 != 2) goto L77;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        CharSequence r117 = r110.H0;
        if (TextUtils.isEmpty(r117) == true) goto L54;
    L58:
        if (r117 == null) goto L96;
        MessageEditInfo r118 = r110.C;
        if (r118 != null) goto L62;
    L64:
        r101 = false;
    L65:
        if (r101 == false) goto L97;
        String r119 = e().getContext().getString(R.string.Lark_IM_EditMessage_Edited_Label);
        com.ss.android.lark.biz.im.api.message.params.e r120 = (com.ss.android.lark.biz.im.api.message.params.e) e().d0(com.ss.android.lark.biz.im.api.message.params.e.class);
        if (r120 == null) goto L74;
        o r121 = r120.f410347b;
        if (r121 == null) goto L74;
        if (MessageStyleHelper.b(r111) == false) goto L73;
        int r122 = r121.f410372a;
    L75:
        SpannableStringBuilder r123 = new SpannableStringBuilder(r119);
        r123.setSpan(new i0(r119, UDColorUtils.getColor(e().getContext(), r122), UIUtils.dp2px(e().getContext(), 12.0f)), 0, r123.length(), 33);
        CharSequence r124 = r123.insert(0, r117);
    L95:
        r117 = r124;
        goto L97
    L73:
        r122 = r121.f410373b;
    L74:
        r122 = R.color.text_caption;
    L97:
        if (r117 != null) goto L99;
        r112.f412904a.setVisibility(8);
        return;
    L99:
        SpannableStringBuilder r125 = new SpannableStringBuilder(r117);
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.message.replay_content.icon_span.enable") == false) goto L115;
        Log.i("MessageReplyContentRender", "enable icon span");
        Iterator r126 = ArrayIteratorKt.iterator((ncc.e[]) r125.getSpans(0, r125.length(), ncc.e.class));
    L103:
        if (r126.hasNext() == false) goto L116;
        ncc.e r127 = (ncc.e) r126.next();
        Intrinsics.checkNotNull(r127);
        Intrinsics.checkNotNullParameter(r127, "span");
        Intrinsics.checkNotNullParameter(r100, "replyStyle");
        Intrinsics.checkNotNullParameter(r112, "holder");
        if (r127.f518728e == false) goto L109;
        if (r127.f518729f == 0) goto L103;
    L109:
        Drawable r128 = r127.f518726c;
        if (r128 == null) goto L112;
        r128.mutate();
        r128.setTint(r100.f548900b);
    L112:
        r127.a(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.a(r112.f412907d));
        if (r127.f518725b == null) goto L103;
        Paint r129 = new Paint();
        r129.setColorFilter(new PorterDuffColorFilter(r100.f548900b, PorterDuff.Mode.SRC_IN));
        Bitmap r130 = Bitmap.createBitmap(r127.f518725b.getWidth(), r127.f518725b.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r130).drawBitmap(r127.f518725b, 0.0f, 0.0f, r129);
        r127.f518725b = r130;
    L116:
        r112.f412907d.setText(r125);
        return;
    L115:
        Log.i("MessageReplyContentRender", "disable icon span");
        goto L116
    L62:
        if (r118.isEdited() != true) goto L64;
    L96:
        r117 = null;
        goto L97
    L54:
        if (r110.L0 == null) goto L58;
        Log.d("CommonReplyContentRender", "generator displayText");
        y6b.c.b r131 = r110.L0;
        if (r131 == null) goto L58;
        u2b.b r132 = (u2b.b) r131;
        r117 = r132.f548489a.d(r132.f548490b);
        goto L58
    L77:
        throw new NoWhenBranchMatchedException();
    L78:
        Message.Type r133 = r110.getType();
        Intrinsics.checkNotNullParameter(r111, "<this>");
        Intrinsics.checkNotNullParameter(r133, "partialReplyMessageType");
        y6b.c.b r134 = r111.L0;
        if (r134 == null) goto L96;
        u2b.b r135 = (u2b.b) r134;
        if (r133 != r114) goto L89;
        PartialReplyInfo r136 = r135.f548490b.getMessage().getPartialReplyInfo();
        if (r136 == null) goto L96;
        RichText r137 = r136.getContent();     // Catch: Exception -> L87
        ReplyActionUtils.a(r137);     // Catch: Exception -> L87
        r124 = i.j(r137);     // Catch: Exception -> L87
    L87:
        e = move-exception;
        Log.e("ChatMessageDataMapper", "generatePartialDisplayText error", e);
        goto L96
    L89:
        List r138 = (List) ((HashMap) r135.f548491c.f548507p).get(r133);
        if (r138 == null) goto L94;
        Iterator r139 = r138.iterator();
        if (r139.hasNext() == false) goto L94;
        r124 = ((y6b.d) r139.next()).b(r135.f548490b);
    L94:
        r124 = r135.f548489a.b(r135.f548490b);
    L41:
        if (ReplyActionUtils.c() == false) goto L47;
        PartialReplyInfo r140 = r111.f566515x1;
        if (r140 == null) goto L47;
        if (r140.getPosition() == PartialReplyInfo.PartialContentRelativePosition.UNKNOWN) goto L47;
        r115 = ReplyActionUtils.ReplyStyle.PARTIAL_REPLY;
    L47:
        r115 = ReplyActionUtils.ReplyStyle.FULL_REPLY;
        goto L48
    L28:
        r112.f412910g.setBorderColor(UDColorUtils.getColor(e().getContext(), R.color.transparent));
        r112.f412910g.setBorderWidth(0.0f);
        r112.f412910g.setRadius(3.0f);
        ViewGroup.LayoutParams r141 = r112.f412909f.getLayoutParams();
        r141.width = -2;
        r141.height = -2;
        r112.f412909f.setLayoutParams(r141);
        r112.f412909f.setImageResource(R.drawable.icon_red_packet_reply_holder);
        r112.f412909f.setOnClickListener(new g(this, r112, r111));
    L30:
        r106 = true;
        goto L31
    L29:
        f(r112, r110, r111);
        goto L30
    L7:
        r102 = UIHelper.getString(R.string.Lark_Legacy_MessageIsrecalled);
        goto L8
    L10:
        if (r110.f566493j == false) goto L13;
        String r142 = UIHelper.getString(R.string.Lark_Legacy_MessageRemove);
        Function2<String, b, Unit> r143 = this.f412137a;
        Intrinsics.checkNotNull(r142);
        r143.invoke(r142, r112);
        goto L20
    L13:
        if (r110.f566517y == false) goto L16;
        String r144 = UIHelper.getString(R.string.Lark_IMSecureKey_InvalidChatSecureKeyCantDisplayContent_Text);
        Function2<String, b, Unit> r145 = this.f412137a;
        Intrinsics.checkNotNull(r144);
        r145.invoke(r144, r112);
        goto L20
    L16:
        if (r110.Y == true) goto L18;
    L21:
        r104 = false;
        goto L22
    L18:
        if (r110.f566502p0 == false) goto L21;
        String r146 = UIHelper.getString(R.string.Lark_IM_MsgDeleted_Desc);
        Function2<String, b, Unit> r147 = this.f412137a;
        Intrinsics.checkNotNull(r146);
        r147.invoke(r146, r112);
        goto L20
    }

    public void f(ReplyBlock.a r110, y6b.c r111, y6b.c r112) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "replyMessageVO");
        Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
        LKUIRoundableLayout r100 = r110.f412910g;
        boolean r101 = r112.f566492i;
        int r102 = p3b.a.W;
        if (r101 == false) goto L5;
        int r103 = v4b.a.f553170h;
    L6:
        r100.setBorderColor(r103);
        ViewGroup.LayoutParams r104 = r110.f412909f.getLayoutParams();
        int r105 = r104.width;
        if (r105 <= 0) goto L11;
        int r106 = r104.height;
        if (r106 <= 0) goto L11;
        int r107 = Math.min(r105, r106);
    L13:
        if (r104.width == r107) goto L15;
    L16:
        r104.width = r107;
        r104.height = r107;
        r110.f412909f.setLayoutParams(r104);
    L17:
        ValidateResult r108 = MessagePermissionUtil.b();
        boolean r109 = MessagePermissionUtil.f(r111, e().getChat(), r108);
        ValidateIMFileResult r113 = r111.F;
        if (r113 == null) goto L20;
        IMFileResult r114 = r113.getResultType();
    L21:
        MessagePermissionUtil.ReceiveAuthorizationState r115 = MessagePermissionUtil.h(r114);
        r110.f412909f.setOnClickListener(new e(r111, this, r115, r109, r108, r110));
        r110.f412909f.setOnLongClickListener(new f(this, r110, r112));
        ResourceCleanScene r116 = lpc.a.b(r111);
        if (r116 == null) goto L26;
        boolean r117 = true;
        if (r116.isCSAMDelete() != true) goto L26;
    L27:
        if (r117 == false) goto L29;
        g(r110);
        return;
    L29:
        if (r109 == true) goto L31;
    L33:
        g(r110);
        return;
    L31:
        if (MessagePermissionUtil.g(r115) == true) goto L33;
        FragmentActivity r118 = e().getContext();
        ImageView r119 = r110.f412909f;
        T r120 = r111.f566500o;
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
        h7b.i.e(r118, r119, (ImageContentVO) r120);
        return;
    L26:
        r117 = false;
        goto L27
    L20:
        r114 = null;
        goto L21
    L15:
        if (r104.height == r107) goto L17;
    L11:
        r107 = UIHelper.dp2px(40.0f);
        goto L13
    L5:
        r103 = v4b.a.G;
        goto L6
    }
}
