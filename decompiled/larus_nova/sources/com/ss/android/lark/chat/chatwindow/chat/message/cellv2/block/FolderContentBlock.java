package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.view.View;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.im.sdk.statistics.ImSdkChatHitPointV2;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class FolderContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>, com.ss.android.lark.chat.base.view.vo.message.a> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f412756j = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f412758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b3b.f f412759i;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FileView f412761b;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412760a;
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412760a = r100;
            FileView r101 = (FileView) r100.findViewById(R.id.chat_file);
            this.f412761b = r101;
            r101.S5();
        }
    }

    public static final class c extends FileView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FolderContentBlock f412762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> f412763b;

        @Override // com.suite.lark.platform.component.widget_biz_fileview.FileView.c
        public final void d(FileView.b r100) {
        }

        @Override // com.suite.lark.platform.component.widget_biz_fileview.FileView.c
        public final void c(FileView.b r110) {
            FolderContentBlock r111 = this.f412762a;
            y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r100 = this.f412763b;
            r111.getClass();
            if (r100.isPreMessage() == true) goto L58;
            boolean r101 = false;
            Map r102 = MapsKt.mapOf(new Pair[]{TuplesKt.to("msg_id", r100.getId()), TuplesKt.to("file_type", DocumentType.FOLDER_NAME)});
            String r103 = r100.getChatId();
            Lazy r104 = ChatHitPointNew.f440661a;
            Intrinsics.checkNotNullParameter("file_card", "click");
            Intrinsics.checkNotNullParameter("im_chat_file_manage_view", PickerReporterConstants.KEY.TARGET);
            Lazy r105 = ImSdkChatHitPointV2.f426133a;
            Intrinsics.checkNotNullParameter("file_card", "click");
            Intrinsics.checkNotNullParameter("im_chat_file_manage_view", PickerReporterConstants.KEY.TARGET);
            Map<String, Object> r106 = ChatParamUtils.f(r103);
            if (r106 == null) goto L9;
            ImSdkChatHitPointV2.a("file_card", "im_chat_file_manage_view", r106, r102);
        L9:
            Message.FileDeletedStatus r107 = r100.b().f411871q;
            if (r107 != Message.FileDeletedStatus.RECOVERABLE) goto L12;
        L13:
            r101 = true;
        L14:
            String r108 = null;
            IMFileResult r109 = null;
            if (((FolderContent) r100.b().f553338a).resourceIsCleaned() == true) goto L48;
            if (r101 == true) goto L48;
            ValidateIMFileResult r112 = r100.N();
            if (r112 == null) goto L21;
            ValidateResult r113 = r112.getValidateResult();
        L22:
            ValidateIMFileResult r114 = r100.N();
            if (r114 == null) goto L25;
            r109 = r114.getResultType();
        L25:
            MessagePermissionUtil.ReceiveAuthorizationState r115 = MessagePermissionUtil.h(r109);
            if (MessagePermissionUtil.g(r115) == true) goto L28;
            owa.a.c().a(r113, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
            ValidateResult r116 = MessagePermissionUtil.b();
            if (MessagePermissionUtil.f(r100, r111.f412673c.getChat(), r116) == true) goto L37;
            MessagePermissionUtil.n(r111.getContext(), R.string.Lark_IM_UnableToPreviewFile_PopUpDesc, r116);
            owa.a.c().a(r116, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
            return;
        L37:
            owa.a.c().a(r116, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
            if (r111.f412673c.r() == true) goto L40;
        L42:
            mya.n r117 = (mya.n) r111.f412673c.j5().b(mya.n.class);
            if (r117 == null) goto L45;
            r117.n(r100.getId(), r111.f412673c.getContext());
            return;
        L45:
            b3b.f r118 = r111.f412759i;
            if (r118 == null) goto L56;
            r118.u(r100.getId());
            return;
        L56:
            return;
        L40:
            if ((r100 instanceof ThreadMessageVO) == false) goto L42;
            ThreadMessageVO r119 = (ThreadMessageVO) r100;
            goto L42
        L28:
            if (r115 != MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE) goto L31;
            MessagePermissionUtil.m(r111.getContext());
        L33:
            owa.a.c().a(r113, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
            return;
        L31:
            if (r115 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L33;
            owa.a.c().d(r113, MessagePermissionUtil.a());
            goto L33
        L21:
            r113 = null;
        L48:
            Context r120 = r111.getContext();
            ResourceType r121 = ResourceType.FILE;
            ResourceCleanScene r122 = lpc.a.b(r100);
            y6b.b r123 = r100.a();
            if (r123 == null) goto L51;
            r108 = r123.f566474w;
        L51:
            acc.a.f(r120, new acc.d(r121, r122, acc.a.d(r108)));
            return;
        L12:
            if (r107 != Message.FileDeletedStatus.UNRECOVERABLE) goto L14;
        }

        public c(FolderContentBlock r100, y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r101) {
            this.f412762a = r100;
            this.f412763b = r101;
        }
    }

    public static final class d implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>> f412764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FolderContentBlock f412765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> f412766c;

        public d(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>> r100, FolderContentBlock r101, y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r102) {
            this.f412764a = r100;
            this.f412765b = r101;
            this.f412766c = r102;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>> r101 = this.f412764a;
            if ((r101 instanceof e6b.b) == false) goto L5;
            e6b.b r102 = (e6b.b) r101;
        L6:
            if (r102 == null) goto L8;
            FolderContentBlock r103 = this.f412765b;
            y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r104 = this.f412766c;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.AbsMessageVO<*>");
            return r102.e(r103, r104);
        L8:
            return false;
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412757g;
    }

    public FolderContentBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412757g = IMMessageKeys$Blocks.FOLDER_CONTENT;
        this.f412758h = LazyKt.lazy(new FolderContentBlock$fgService$2(this));
        b3b.f r101 = this.f412674d;
        if ((r101 instanceof p4b.a) == true) goto L6;
        r101 = null;
    L6:
        this.f412759i = r101;
    }

    public boolean h(y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f412673c.m() == false) goto L5;
    L12:
        return true;
    L5:
        if (r100.l() == false) goto L12;
        if (this.f412673c.Y() == true) goto L12;
        if (this.f412673c.r() == true) goto L12;
        return false;
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>> r310, com.ss.android.lark.blueprint.q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.a>> r311, y6b.a<com.ss.android.lark.chat.base.view.vo.message.a> r312) {
        Intrinsics.checkNotNullParameter(r310, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r311, "layout");
        Intrinsics.checkNotNullParameter(r312, "data");
        b r100 = (b) r311.c(this.f412757g, IMMessageKeys$Slots.CONTENT, FolderContentBlock$update$blockView$1.INSTANCE);
        ValidateIMFileResult r101 = r312.N();
        if (r101 == null) goto L5;
        IMFileResult r102 = r101.getResultType();
    L6:
        MessagePermissionUtil.ReceiveAuthorizationState r103 = MessagePermissionUtil.h(r102);
        boolean r110 = MessagePermissionUtil.f(r312, this.f412673c.getChat(), null);
        r100.f412761b.setTag(r312.getcId());
        com.ss.android.lark.chat.base.view.vo.message.a r104 = r312.b();
        FileState r105 = FileState.DOWNLOAD;
        Log.d("FolderContentBlock", "folder key = " + r104.e());
        boolean r106 = r104.g();
        boolean r107 = r104.h();
        boolean r111 = r104.i();
        boolean r112 = r104.f411868n;
        Message.FileDeletedStatus r113 = r104.f411871q;
        Message.FileDeletedStatus r114 = Message.FileDeletedStatus.UNRECOVERABLE;
        if (r113 != r114) goto L9;
        boolean r115 = true;
    L10:
        Message.FileDeletedStatus r108 = Message.FileDeletedStatus.RECOVERABLE;
        if (r113 != r108) goto L13;
        boolean r116 = true;
    L14:
        Message.FileDeletedStatus r109 = Message.FileDeletedStatus.FREED_UP;
        if (r113 != r109) goto L17;
        boolean r117 = true;
    L18:
        boolean r118 = !r312.isPreMessage();
        FileView.FileState r119 = new FileView.FileState(r105.getFileStateType(), UIUtils.getString(getContext(), r105.getValue()));
        String r120 = r104.f();
        long r210 = ((Number) r104.f411858d.getValue()).longValue();
        int r121 = r103.getValue();
        ResourceCleanScene r211 = ((FolderContent) r104.f553338a).currentResourceScene();
        y6b.b r122 = r312.a();
        if (r122 == null) goto L21;
        String r313 = r122.f566474w;
    L22:
        FileView.b r123 = new FileView.b(r106, r107, r111, r112, r115, r116, r117, r118, r110, "", r119, r120, r210, 0, 0, true, null, r121, r211, r313);
        FileView r124 = r100.f412761b;
        if (r104.f411868n == true) goto L31;
        Message.FileDeletedStatus r125 = r104.f411871q;
        if (r125 == r108) goto L31;
        if (r125 == r114) goto L31;
        if (r125 == r109) goto L31;
        if (r104.h() == true) goto L31;
        boolean r126 = true;
    L32:
        r124.setFileSizeVisibility(r126);
        if (r312.j() == false) goto L35;
    L43:
        boolean r127 = false;
    L44:
        boolean r128 = h(r312);
        FileView r129 = r100.f412761b;
        if (r128 == true) goto L49;
        if (r127 == true) goto L49;
        boolean r130 = false;
    L50:
        r129.setBottomMargin(r130);
        r100.f412761b.getFileIconView().setCornerRadiusDP(0.0f);
        if (this.f412673c.m() == false) goto L53;
    L56:
        r100.f412761b.setBackgroundResource(R.drawable.file_message_cell_bg);
    L57:
        r100.f412761b.S5();
        r100.f412761b.setTopBorderColor(UIUtils.getColor(this.f412673c.getContext(), R.color.line_border_card));
        FileView r131 = r100.f412761b;
        if (com.ss.android.lark.message.lynxcard.message.r.a(r312.i()) == true) goto L60;
    L62:
        boolean r132 = false;
    L63:
        r131.setTopBorderVisibility(r132);
        FileView r133 = r100.f412761b;
        r133.setCallback(new c(this, r312));
        r133.setInfo(r123);
        r100.f412761b.setOnLongClickListener(new d(r310, this, r312));
        UIUtils.hide(r100.f412761b.f460891l);
        return;
    L60:
        if (r312.d() == true) goto L62;
        r132 = true;
        goto L63
    L53:
        if (this.f412673c.r() == true) goto L56;
        if (this.f412673c.Y() == false) goto L57;
    L49:
        r130 = true;
        goto L50
    L35:
        if (r312.m() == true) goto L43;
        if (r312.O() == true) goto L43;
        if (r312.l() == false) goto L43;
        if (r312.d() == false) goto L43;
        r127 = true;
    L31:
        r126 = false;
        goto L32
    L21:
        r313 = null;
        goto L22
    L17:
        r117 = false;
        goto L18
    L13:
        r116 = false;
        goto L14
    L9:
        r115 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
