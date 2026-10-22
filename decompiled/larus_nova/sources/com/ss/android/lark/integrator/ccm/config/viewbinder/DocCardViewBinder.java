package com.ss.android.lark.integrator.ccm.config.viewbinder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.doc.v1.UpdateDocPermissionRequest;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.doc.entity.DocCard;
import com.ss.android.lark.doc.entity.DocPermPair;
import com.ss.android.lark.doc.entity.DocPermission;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.doc.entity.Extra;
import com.ss.android.lark.doc.entity.ThumbnailDetail;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import dwa.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class DocCardViewBinder implements ibb.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f427788b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f427789a;

    public static class DocCardViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f427790a;

        @BindView(11068)
        public TextView askOwnerTv;

        @BindView(12032)
        public View askOwnerView;

        @BindView(12034)
        public ImageView orangeTipsIV;

        @BindView(12037)
        public View permStatusContainer;

        @BindView(12036)
        public TextView permStatusView;

        @BindView(12038)
        public TextView permTypeTv;

        @BindView(12033)
        public View pointIv;

        @BindView(12042)
        public ViewGroup previewThumbContainer;

        @BindView(12035)
        public TextView shareInfoView;

        @BindView(12041)
        public ImageView thumbImageView;

        @BindView(12039)
        public ImageView thumbLoadFailView;

        public DocCardViewHolder(View r100) {
            this.f427790a = r100;
            r100.setTag(this);
            ButterKnife.bind(this, r100);
        }
    }

    public class DocCardViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DocCardViewHolder f427791a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            DocCardViewHolder r100 = this.f427791a;
            if (r100 == null) goto L7;
            this.f427791a = null;
            r100.previewThumbContainer = null;
            r100.thumbImageView = null;
            r100.thumbLoadFailView = null;
            r100.permStatusContainer = null;
            r100.shareInfoView = null;
            r100.permStatusView = null;
            r100.askOwnerView = null;
            r100.askOwnerTv = null;
            r100.pointIv = null;
            r100.orangeTipsIV = null;
            r100.permTypeTv = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public DocCardViewHolder_ViewBinding(DocCardViewHolder r100, View r101) {
            this.f427791a = r100;
            r100.previewThumbContainer = (ViewGroup) Utils.findRequiredViewAsType(r101, R.id.doc_card_preview_thumb_layout, "field 'previewThumbContainer'", ViewGroup.class);
            r100.thumbImageView = (ImageView) Utils.findRequiredViewAsType(r101, R.id.doc_card_preview_thumb, "field 'thumbImageView'", ImageView.class);
            r100.thumbLoadFailView = (ImageView) Utils.findRequiredViewAsType(r101, R.id.doc_card_preview_image_load_fail, "field 'thumbLoadFailView'", ImageView.class);
            r100.permStatusContainer = Utils.findRequiredView(r101, R.id.doc_card_perm_status_layout, "field 'permStatusContainer'");
            r100.shareInfoView = (TextView) Utils.findRequiredViewAsType(r101, R.id.doc_card_perm_share_info, "field 'shareInfoView'", TextView.class);
            r100.permStatusView = (TextView) Utils.findRequiredViewAsType(r101, R.id.doc_card_perm_status, "field 'permStatusView'", TextView.class);
            r100.askOwnerView = Utils.findRequiredView(r101, R.id.doc_card_ask_owner, "field 'askOwnerView'");
            r100.askOwnerTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.askOwnerTv, "field 'askOwnerTv'", TextView.class);
            r100.pointIv = Utils.findRequiredView(r101, R.id.doc_card_exclamation_point, "field 'pointIv'");
            r100.orangeTipsIV = (ImageView) Utils.findRequiredViewAsType(r101, R.id.doc_card_exclamation_point_orange, "field 'orangeTipsIV'", ImageView.class);
            r100.permTypeTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.doc_card_perm_type, "field 'permTypeTv'", TextView.class);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f427792a = null;

        static {
            int[] r100 = new int[DocType.values().length];
            f427792a = r100;
            r100[DocType.DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            f427792a[DocType.SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            f427792a[DocType.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            f427792a[DocType.MINDNOTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            f427792a[DocType.SLIDES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            f427792a[DocType.BITABLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            f427792a[DocType.WIKI.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            f427792a[DocType.DOCX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            f427792a[DocType.DOCX_SYNCED_BLOCK.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            f427792a[DocType.DOUBAO_CHAT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            f427792a[DocType.UNKNOWN_DOC_TYPE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public DocCardViewBinder(Context r100) {
        this.f427789a = r100;
    }

    public static int c(DocType r100) {
        if (r100 != null) goto L7;
        tt5.a.k("DocCardViewBinder", "doc card type unknown, reason=null_type, ccmType=-1");
        return sbb.e.f541294e.f541317b;
    L7:
        switch(a.f427792a[r100.ordinal()]) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L11;
            case 10: goto L9;
            default: goto L8;
        };
    L8:
        tt5.a.k("DocCardViewBinder", "doc card type unknown, imType=" + r100.getNumber() + ", ccmType=-1");
        return sbb.e.f541294e.f541317b;
    L9:
        tt5.a.h("DocCardViewBinder", "doc card type mapped, imType=" + r100.getNumber() + ", ccmType=125");
        return 125;
    L11:
        return 44;
    L15:
        return 16;
    L17:
        return 8;
    L19:
        return 30;
    L21:
        return 11;
    L23:
        return 12;
    L25:
        return 3;
    L27:
        return 2;
    L14:
        return sbb.e.f541304o.f541317b;
    }

    public static String d(DocPermission r100) {
        tt5.a.b("DocCardViewBinder", "can Edit = " + r100.canEdit() + " can Read = " + r100.canRead());
        if (r100.canEdit() == false) goto L6;
        return UIHelper.getString(R.string.Lark_Docs_ChatDocPermissionEdit);
    L6:
        return UIHelper.getString(R.string.Lark_Docs_ChatDocPermissionRead);
    }

    @Override // ibb.c
    public final View b(ViewGroup r100) {
        View r101 = j.d(r100.getContext()).a(r100.getContext(), R.layout.doc_message_card_layout, r100);
        DocCardViewHolder r102 = new DocCardViewHolder(r101);
        DesktopUtil.a(r100.getContext());
        zz7.a.a(r102.pointIv, 14);
        zz7.a.c(r102.shareInfoView, 14);
        zz7.a.c(r102.permStatusView, 14);
        zz7.a.a(r102.orangeTipsIV, 14);
        zz7.a.c(r102.askOwnerTv, 14);
        return r101;
    }

    public final void e(final DocCard r100, final DocPermPair.PermType r101) {
        ArrayList r102 = new ArrayList();
        r102.add(new DocPermPair(r100.getMessageId(), r100.getDocId(), r101));
        UIGetDataCallback<List<String>> r103 = new AnonymousClass3(this, r100, r101);
        if (r102.size() <= 0) goto L12;
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        DocPermPair r106 = (DocPermPair) r105.next();
        r104.add(new UpdateDocPermissionRequest.Pair.Builder().message_id(r106.getMessageId()).perm(UpdateDocPermissionRequest.Permission.fromValue(r106.getPerm().getNumber())).token(r106.getDocToken()).build());
        goto L7
    L9:
        UpdateDocPermissionRequest.Builder r107 = new UpdateDocPermissionRequest.Builder().pairs(r104);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_DOC_PERMISSION, r107, r103, new h());
        return;
    }

    public final void f(DocCardViewHolder r110, final DocCard r111, final boolean r112, final String r113) {
        tt5.a.b("DocCardViewBinder", "showPermissionCouldPutText");
        List<DocPermission> r100 = r111.getPermissions();
        DocPermission r101 = r111.getUserPermission();
        r110.askOwnerView.setVisibility(8);
        r110.pointIv.setVisibility(8);
        if (r101.canShare() == false) goto L32;
        tt5.a.b("DocCardViewBinder", "userPermission.canShare");
        r110.permStatusView.setVisibility(0);
        if (r112 == false) goto L7;
        String r102 = UIHelper.getString(R.string.Lark_Docs_DocsActionsheetTip);
    L9:
        if (r100.size() == 0) goto L30;
        r110.permStatusContainer.setVisibility(0);
        boolean r103 = true;
        if (r100.size() > 1) goto L14;
        r103 = false;
    L14:
        tt5.a.h("DocCardViewBinder", "canEditPerm" + r103);
        r110.permStatusView.setEnabled(r103);
        TextView r104 = r110.permStatusView;
        if (r103 == false) goto L17;
        int r105 = UIHelper.getColor(R.color.primary_fill_default);
    L18:
        r104.setTextColor(r105);
        int r106 = UIUtils.dp2px(this.f427789a, 10.0f);
        Drawable r107 = this.f427789a.getDrawable(R.drawable.ud_icon_av_set_down_outlined);
        r107.setTint(UIUtils.getColor(this.f427789a, R.color.primary_fill_default));
        r107.setBounds(0, 0, r106, r106);
        TextView r108 = r110.permStatusView;
        if (r103 == true) goto L22;
        r107 = null;
    L22:
        r108.setCompoundDrawables(null, null, r107, null);
        DocPermission r109 = r111.getCurrentDocPerm();
        if (r112 == false) goto L28;
        tt5.a.b("DocCardViewBinder", "can Edit = " + r109.canEdit() + " can Read = " + r109.canRead());
        if (r109.canEdit() == false) goto L27;
        String r114 = UIHelper.getString(R.string.Lark_Docs_ChatDocPermissionEdit3rdpl);
    L29:
        r110.permStatusView.setText(r114);
    L31:
        r110.permStatusView.setOnClickListener(new c(this, r111, r113, r112));
        r110.permTypeTv.setVisibility(8);
    L33:
        r110.shareInfoView.setText(r102);
        return;
    L27:
        r114 = UIHelper.getString(R.string.Lark_Docs_ChatDocPermissionRead3rdpl);
        goto L29
    L28:
        r114 = d(r109);
        goto L29
    L17:
        r105 = UIHelper.getColor(R.color.text_title);
        goto L18
    L30:
        tt5.a.d("DocCardViewBinder", "docPermissions.size() == 0 !");
        r110.permStatusContainer.setVisibility(8);
        goto L31
    L7:
        r102 = r113;
        goto L9
    L32:
        r110.permStatusView.setVisibility(8);
        r102 = UIHelper.getString(R.string.Lark_Docs_NoSharePermission);
        goto L33
    }

    @Override // ibb.c
    public final void a(View r210, final DocResult r211, String r212, String r213, String r214, String r310, String r311, final String r312, String r313, boolean r314, final boolean r315, boolean r316, boolean r317) {
        tt5.a.b("DocCardViewBinder", "start onBindView");
        DocCardViewHolder r110 = (DocCardViewHolder) r210.getTag();
        final Doc r111 = r211.getDoc();
        if (r111 == null) goto L112;
        r110.f427790a.setVisibility(0);
        String r100 = r111.getAbstract();
        if (TextUtils.isEmpty(r100) == true) goto L21;
        ImageView r101 = r110.thumbImageView;
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101.getLayoutParams();
        int r103 = r101.getMeasuredWidth();
        int r112 = f427788b;
        if (r112 <= 0) goto L9;
        r103 = r112;
    L9:
        if (r103 <= 0) goto L14;
        r102.width = r103;
        int r104 = (int) (r103 / 1.7f);
        if (r104 <= 0) goto L13;
        r102.height = r104;
        r101.setLayoutParams(r102);
    L13:
        f427788b = r103;
    L14:
        tt5.a.b("HWC", "width:" + r102.width + "--height:" + r102.height + "--url:" + r100);
        SpacekitSdkWrapper r105 = SpacekitSdkWrapper.b.f427892a;
        ec5.a.C5766a r106 = new ec5.a.C5766a();
        r106.f472105a = this.f427789a;
        r106.f472106b = r100;
        r106.f472109e = r110.thumbImageView;
        r106.f472107c = r111.getDocType().getNumber();
        r106.f472108d = new f(r110);
        ThumbnailDetail r107 = r111.getThumbnaimDetail();
        if (r107 != null) goto L119;
    L20:
        ec5.a r108 = new ec5.a(r106);
        r105.getClass();
        Log.i("SpacekitSdkWrapper", "DocsImpl.loadThumbnail ");
        RxScheduledExecutor.justInIO(new com.ss.android.lark.integrator.ccm.spacekit.e(r108));
    L22:
        r110.previewThumbContainer.setOnClickListener(new com.ss.android.lark.integrator.ccm.config.viewbinder.a(r111, r315, r312, r211));
        if (r317 == false) goto L25;
        r110.previewThumbContainer.setBackground(UIUtils.getDrawable(this.f427789a, R.drawable.doc_bg_doc_preview_thumb_container));
        int r109 = UIUtils.dp2px(this.f427789a, 1.0f);
        r110.previewThumbContainer.setPadding(r109, r109, r109, r109);
    L26:
        if (r315 == true) goto L28;
        String r113 = r310;
        String r114 = r213;
        String r115 = r214;
    L29:
        FragmentActivity r116 = (FragmentActivity) this.f427789a;
        String r117 = r111.getId();
        int r118 = c(r111.getDocType());
        String r215 = r111.getOwnerId();
        String r216 = r111.getOwnerName();
        if (r315 == false) goto L32;
        int r217 = 2;
    L33:
        Doc r119 = r111;
        String r120 = "DocCardViewBinder";
        final vb5.a r121 = new vb5.a(r116, r117, r118, r215, r216, r217, r314, r115, r114, r113);
        final DocType r122 = r119.getDocType();
        final DocCard r123 = r211.getDocCard();
        tt5.a.h(r120, "showDocPermStatusView & isSlef= " + r316);
        tt5.a.h(r120, "sendId=" + r212 + " p2pChatterId= " + r214);
        if (r316 == true) goto L36;
    L100:
        tt5.a.b(r120, "not sender");
        r110.permStatusContainer.setVisibility(0);
        r110.askOwnerView.setVisibility(8);
        r110.permStatusView.setVisibility(8);
        DocPermission r124 = r123.getUserPermission();
        if (r124.canEdit() == false) goto L103;
    L106:
        r110.pointIv.setVisibility(8);
        tt5.a.b(r120, "can Edit = " + r124.canEdit() + " can Read = " + r124.canRead());
        if (r124.canEdit() == false) goto L109;
        String r125 = UIHelper.getString(R.string.Lark_Legacy_ChatDocPermissionEdit);
    L110:
        String r126 = UIHelper.mustacheFormat(R.string.Lark_Docs_ShareDocsPermission, "permission", r125);
    L111:
        r110.shareInfoView.setText(r126);
    L113:
        if (r119 != null) goto L115;
    L117:
        tt5.a.b(r120, "end onBindView");
        return;
    L115:
        if (TextUtils.isEmpty(r119.getUrl()) == true) goto L117;
        String r127 = r119.getUrl();
        SpacekitSdkWrapper r128 = SpacekitSdkWrapper.b.f427892a;
        List r129 = Collections.singletonList(r127);
        r128.getClass();
        SpacekitSdkWrapper.h(r129);
        goto L117
    L109:
        r125 = UIHelper.getString(R.string.Lark_Legacy_ChatDocPermissionView);
        goto L110
    L103:
        if (r124.canRead() == true) goto L106;
        r110.pointIv.setVisibility(0);
        r126 = UIHelper.getString(R.string.Lark_Docs_ShareDocsNoPermission);
        goto L111
    L36:
        if (TextUtils.equals(r212, r214) == true) goto L100;
        r110.permStatusView.setVisibility(0);
        long r130 = r123.getShareStatus();
        LongSparseArray<Integer> r131 = xb5.a.f563114a;
        tt5.a.h(r120, "shareStatus = " + r130);
        if (r130 > 1) goto L40;
        boolean r132 = FeatureGatingModule.getFeatureGatingService().isEnable("spacekit.mobile.external_share_tips_enable", false);
        boolean r133 = r123.getSenderIsExternal();
        Extra r134 = r123.getExtra();
        if (r134 == null) goto L81;
        boolean r135 = r134.hasReadOrEditPer();
    L82:
        tt5.a.h(r120, "senderIsExternal = " + r133 + " isCrossTenant = " + r314 + " = " + r135);
        if (r132 == false) goto L90;
        if (r135 == false) goto L90;
        if (r133 == false) goto L87;
        if (r314 == true) goto L87;
    L89:
        boolean r136 = true;
    L91:
        if (r136 == false) goto L99;
        f(r110, r123, r315, r213);
        tt5.a.b(r120, "showCancelSharedUI  isGroup = " + r315);
        r110.askOwnerView.setVisibility(0);
        r110.pointIv.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) r110.orangeTipsIV.getLayoutParams()).leftMargin = UIUtils.dp2px(this.f427789a, 8.0f);
        ((ViewGroup.MarginLayoutParams) r110.askOwnerTv.getLayoutParams()).rightMargin = UIUtils.dp2px(this.f427789a, 8.0f);
        LinearLayout.LayoutParams r137 = (LinearLayout.LayoutParams) r110.askOwnerView.getLayoutParams();
        r137.bottomMargin = cu5.c.b(6);
        r137.topMargin = cu5.c.b(12);
        if (r314 == false) goto L97;
        if (r315 == false) goto L96;
        int r138 = R.string.Lark_Permission_ChatExternalDesc;
    L98:
        String r139 = this.f427789a.getString(r138);
        String r140 = r139 + this.f427789a.getText(R.string.Lark_Permission_CancelGrantButton).toString();
        SpannableStringBuilder r141 = new SpannableStringBuilder(r140);
        r141.setSpan(new ForegroundColorSpan(this.f427789a.getResources().getColor(R.color.text_title)), 0, r139.length(), 33);
        r141.setSpan(new ForegroundColorSpan(this.f427789a.getResources().getColor(R.color.text_link_normal)), r139.length(), r140.length(), 33);
        r110.askOwnerTv.setText(r141);
        r110.askOwnerTv.setOnClickListener(new d(this, r122, r123, r121));
        r110.askOwnerView.setVisibility(0);
        goto L113
    L96:
        r138 = R.string.Lark_Permission_ExternalPersonTips;
        goto L98
    L97:
        r138 = R.string.Lark_Permission_ExternalOwnerShareTips;
        goto L98
    L99:
        f(r110, r123, r315, r213);
    L87:
        if (r133 == true) goto L90;
        if (r314 == true) goto L89;
    L90:
        r136 = false;
        goto L91
    L81:
        r135 = false;
        goto L82
    L40:
        if (r315 == true) goto L42;
    L47:
        boolean r142 = true;
    L49:
        if (r130 != 6) goto L51;
    L54:
        boolean r143 = true;
    L55:
        if (r143 == false) goto L66;
        if (r142 == false) goto L66;
        tt5.a.h(r120, "noSharePerm");
        if (r123.getReceiverPermission().canRead() == false) goto L60;
        tt5.a.b(r120, "showTextWithoutSharePerm");
        r110.permStatusView.setVisibility(8);
        r110.permStatusContainer.setVisibility(0);
        r110.askOwnerView.setVisibility(8);
        r110.pointIv.setVisibility(8);
        r110.shareInfoView.setText(xb5.e.a(r315, r213, d(r123.getReceiverPermission())));
        goto L113
    L60:
        tt5.a.b(r120, "showAskOwnerUI");
        r110.permStatusView.setVisibility(8);
        r110.permStatusContainer.setVisibility(8);
        r110.askOwnerView.setVisibility(0);
        r110.pointIv.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) r110.orangeTipsIV.getLayoutParams()).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) r110.askOwnerTv.getLayoutParams()).rightMargin = 0;
        LinearLayout.LayoutParams r144 = (LinearLayout.LayoutParams) r110.askOwnerView.getLayoutParams();
        r144.bottomMargin = 0;
        r144.topMargin = 0;
        Context r145 = this.f427789a;
        if (r315 == false) goto L63;
        int r146 = R.string.Lark_Docs_ChatDocAskOwnerText;
    L64:
        String r147 = r145.getText(r146).toString();
        String r148 = r147 + this.f427789a.getText(R.string.Lark_Docs_ChatDocAskOwnerButton).toString();
        SpannableStringBuilder r149 = new SpannableStringBuilder(r148);
        r149.setSpan(new ForegroundColorSpan(this.f427789a.getResources().getColor(R.color.text_title)), 0, r147.length(), 33);
        r149.setSpan(new ForegroundColorSpan(this.f427789a.getResources().getColor(R.color.text_link_normal)), r147.length(), r148.length(), 33);
        r110.askOwnerTv.setText(r149);
        r110.askOwnerTv.setOnClickListener(new b(r121));
        r110.askOwnerView.setVisibility(0);
        goto L113
    L63:
        r146 = R.string.Lark_Docs_AskOwerP2PText;
    L66:
        if (r131.indexOfKey(r130) < 0) goto L68;
        int r150 = r131.get(r130).intValue();
    L69:
        r110.askOwnerView.setVisibility(8);
        r110.permStatusContainer.setVisibility(0);
        String r151 = UIHelper.getString(r150);
        tt5.a.h(r120, "hasSharePerm：" + r151);
        r110.shareInfoView.setText(r151);
        r110.permStatusView.setVisibility(8);
        if (r130 >= 6) goto L72;
    L74:
        boolean r152 = false;
    L75:
        if (r152 == false) goto L77;
        r110.pointIv.setVisibility(0);
        goto L113
    L77:
        r110.pointIv.setVisibility(8);
        goto L113
    L72:
        if (r130 > 12) goto L74;
        r152 = true;
        goto L75
    L68:
        r150 = R.string.Lark_Docs_ShareDocs_DefaultInfo;
        goto L69
    L51:
        if (r130 == 7) goto L54;
        r143 = false;
        goto L55
    L42:
        if (r123.getExtra() != null) goto L44;
    L46:
        r142 = false;
        goto L49
    L44:
        if (r123.getExtra().owner_in_group == false) goto L46;
    L32:
        r217 = 0;
        goto L33
    L28:
        r114 = r311;
        r113 = r313;
        r115 = r312;
        goto L29
    L25:
        r110.previewThumbContainer.setBackgroundColor(UIUtils.getColor(this.f427789a, R.color.transparent));
        r110.previewThumbContainer.setPadding(0, 0, 0, 0);
        goto L26
    L119:
        r106.f472114j = "chat";     // Catch: Exception -> L18
        r106.f472113i = CastIntegerProtector.parseInt(r107.cipherType);     // Catch: Exception -> L18
        r106.f472110f = r107.thumbnailUrlMobile;     // Catch: Exception -> L18
        r106.f472111g = r107.decryptKeyMobile;     // Catch: Exception -> L18
        r106.f472112h = r107.decryptNonceMobile;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        tt5.a.f("DocCardViewBinder", e, false);
        goto L20
    L21:
        tt5.a.d("DocCardViewBinder", "previewThumbUrl is empty");
        goto L22
    L112:
        r119 = r111;
        r120 = "DocCardViewBinder";
        r110.f427790a.setVisibility(8);
        tt5.a.d(r120, "doc is null");
        goto L113
    }
}
