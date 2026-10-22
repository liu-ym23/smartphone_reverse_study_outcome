package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.bitable.share.permission.BitableSharePermission;
import com.bytedance.ee.bear.bitable.share.view.BitableShareLinkShareSetView;
import com.bytedance.ee.bear.bitable.share.view.BitableShareSwitchView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareState;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class FormBitableShareFragmentDelegate extends com.bytedance.ee.bear.bitable.share.sharepanel.a implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final gu4.b f215360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDNotice f215361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BitableShareLinkShareSetView f215362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.share.view.memberview.d f215363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f215364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public UDSwitch f215365k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public mu4.c f215366l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f215367m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f215368n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f215369o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public vv4.k f215370p;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormBitableShareFragmentDelegate f215371a;

        public b(FormBitableShareFragmentDelegate r100) {
            this.f215371a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.ee.bear.route.h r101 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
            this.f215371a.getClass();
            s45.h r102 = s45.g.f540568a;
            r101.u5(s45.g.a.b("183307421587#tabs0|lineguid-kjsbo", "362275149321#tabs0|lineguid-7W01O", null));
        }
    }

    public static final class c implements BitableShareLinkShareSetView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormBitableShareFragmentDelegate f215372a;

        @Override // com.bytedance.ee.bear.bitable.share.view.BitableShareLinkShareSetView.a
        public final void a() {
            this.f215372a.A();
        }

        @Override // com.bytedance.ee.bear.bitable.share.view.BitableShareLinkShareSetView.a
        public final vv4.k b() {
            return this.f215372a.f215370p;
        }

        @Override // com.bytedance.ee.bear.bitable.share.view.BitableShareLinkShareSetView.a
        public final FragmentManager getFragmentManager() {
            return this.f215372a.o().getActivity().getSupportFragmentManager();
        }

        public c(FormBitableShareFragmentDelegate r100) {
            this.f215372a = r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormBitableShareFragmentDelegate f215373a;

        public d(FormBitableShareFragmentDelegate r100) {
            this.f215373a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BitableSharePermission r101 = (BitableSharePermission) r100;
            FormBitableShareFragmentDelegate r102 = this.f215373a;
            String r103 = r102.o().getToken();
            int r104 = this.f215373a.o().getType();
            Intrinsics.checkNotNull(r101);
            r102.f215366l = new mu4.c(r103, r104, r101);
            this.f215373a.z(r101);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormBitableShareFragmentDelegate f215374a;

        public e(FormBitableShareFragmentDelegate r100) {
            this.f215374a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e("FormShareFragmentDelegate", "updatePermission()...error", r101, false);
            FormBitableShareFragmentDelegate r102 = this.f215374a;
            Intrinsics.checkNotNull(r101);
            r102.x(r101);
            FormBitableShareFragmentDelegate r103 = this.f215374a;
            com.bytedance.ee.bear.bitable.share.view.memberview.d r104 = r103.f215363i;
            if (r104 == null) goto L5;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
            r104.s();
        L5:
            BitableShareLinkShareSetView r105 = r103.f215362h;
            if (r105 == null) goto L9;
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
            r105.s();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a, com.bytedance.ee.bear.share.export.b
    public final void j() {
    }

    public final void A() {
        if (this.f215367m == false) goto L6;
        tt5.a.k("FormShareFragmentDelegate", "shareToken is empty!!!");
        this.f215366l = new mu4.c(o().getToken(), o().getType(), new BitableSharePermission(0));
        z(new BitableSharePermission(0));
        return;
    L6:
        Disposable r100 = pu4.a.a(o().getToken(), o().getBitableShareMeta().getShareToken(), o().getTableId(), o().getViewId(), EShareType.FORM.getType()).observeOn(fo5.d.d()).subscribe(new d(this), new e(this));
        this.f215433c.add(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a, com.bytedance.ee.bear.share.export.e
    public final void onViewCreated() {
        super.onViewCreated();
        boolean r110 = true;
        boolean r111 = !TextUtils.isEmpty(o().getFormMode());
        if (r111 == true) goto L5;
    L7:
        p().Ax(R.string.Bitable_Form_ShareForm);
    L9:
        if (Intrinsics.areEqual("formUser", o().getFormMode()) == false) goto L25;
        if (o().getFormEditable() == true) goto L25;
        p().Pf().setVisibility(8);
        y(true);
        if (o().getBitableShareMeta().isOpen() == true) goto L17;
        if (r111 == true) goto L17;
        boolean r100 = false;
    L18:
        B(r100);
        if (o().getBitableShareMeta().getShareToken().length() == 0) goto L22;
        r110 = false;
    L22:
        this.f215367m = r110;
        mu4.f.i();
        return;
    L17:
        r100 = true;
    L25:
        if (o().getBitableShareRecordInfo().hasLinkField() == false) goto L44;
        UDNotice r101 = new UDNotice(p().requireContext());
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-1, -2);
        int r103 = com.bytedance.ee.util.ui.n.d(16);
        r102.leftMargin = r103;
        r102.rightMargin = r103;
        r102.topMargin = r103;
        r101.setLayoutParams(r102);
        this.f215361g = r101;
        String r104 = p().requireContext().getString(R.string.Bitable_Formula_LearnMore);
        UDNotice r105 = this.f215361g;
        if (r105 == null) goto L29;
        r105.setText(R.string.Bitable_Form_RespondentCanViewReferencedData_Notice);
    L29:
        UDNotice r106 = this.f215361g;
        if (r106 == null) goto L32;
        r106.setTextButton(r104);
    L32:
        UDNotice r107 = this.f215361g;
        if (r107 == null) goto L35;
        r107.setTextButtonPosition(UDNotice.TextButtonPosition.BOTTOM);
    L35:
        UDNotice r108 = this.f215361g;
        if (r108 == null) goto L38;
        r108.setTextButtonListener(new b(this));
    L38:
        UDNotice r109 = this.f215361g;
        if (r109 == null) goto L41;
        r109.setRadius(UDRadius.M);
    L41:
        p().Pf().addView(this.f215361g);
        UDNotice r112 = this.f215361g;
        if (r112 == null) goto L44;
        r112.setVisibility(8);
    L44:
        ViewGroup.LayoutParams r113 = new ViewGroup.LayoutParams(-1, -2);
        SpaceSettingGroupLayout r114 = com.bytedance.ee.bear.bitable.share.sharepanel.a.t(p().requireContext());
        r114.setHasDivider(false);
        p().Pf().addView(r114);
        if (TextUtils.isEmpty(o().getFormMode()) == false) goto L47;
        BitableShareSwitchView r115 = new BitableShareSwitchView(p().requireContext());
        LinearLayout r116 = r114;
        ViewGroup.LayoutParams r117 = r113;
        r115.S5(o().getToken(), o().getTableId(), o().getViewId(), o().getRecordId(), EShareType.FORM.getType(), o().getBitableShareMeta(), AnonymousClass3.INSTANCE, this);
        r116.addView(r115, r117);
    L49:
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L51;
    L53:
        Fragment r118 = null;
    L54:
        final BitableShareLinkShareSetView r119 = new BitableShareLinkShareSetView(p().requireContext(), r118);
        r119.setUIDelegate(new FormBitableShareFragmentDelegate$onViewCreated$4$1(r119));
        r119.setUnableClickListener(new FormBitableShareFragmentDelegate$onViewCreated$4$2(r119));
        r119.setIsNewLarkForm(r111);
        r119.setDelegate(new c(this));
        this.f215362h = r119;
        r116.addView((View) this.f215369o.getValue());
        r116.addView(this.f215362h, r117);
        final com.bytedance.ee.bear.bitable.share.view.memberview.d r120 = new com.bytedance.ee.bear.bitable.share.view.memberview.d(p().requireActivity(), r118, o().getType(), o().getToken(), o().getBitableShareMeta().getShareToken());
        r120.setInviteMemberTitle(R.string.Bitable_Form_InviteCollaborator);
        r120.setManageMemberTitle(R.string.Bitable_Form_ManageCollaborator);
        r120.setUnableClickListener(new FormBitableShareFragmentDelegate$onViewCreated$5$1(r120));
        if (o().getShowRemindMe() == false) goto L57;
        r120.setSendNotificationEnable(true);
        r120.setSendNotificationTitle(R.string.Bitable_NewSurvey_Mobile_Reminder_SendReminder_Button);
    L57:
        this.f215363i = r120;
        LinearLayout.LayoutParams r121 = new LinearLayout.LayoutParams(-1, -2);
        r121.topMargin = com.bytedance.ee.util.ui.n.d(16);
        p().Pf().addView(this.f215363i, r121);
        if (o().getShowNoticeMe() == false) goto L66;
        View r122 = LayoutInflater.from(p().requireActivity()).inflate(R.layout.permission_share_forms_notice_view, null);
        this.f215364j = r122;
        this.f215365k = (UDSwitch) r122.findViewById(R.id.switchView);
        int r123 = com.bytedance.ee.util.ui.n.d(16);
        int r124 = com.bytedance.ee.util.ui.n.d(12);
        LinearLayout.LayoutParams r125 = new LinearLayout.LayoutParams(-1, -2);
        r125.setMarginEnd(r123);
        r125.setMarginStart(r123);
        r125.topMargin = r124;
        UDSwitch r126 = this.f215365k;
        if (r126 == null) goto L62;
        r126.setChecked(Intrinsics.areEqual(o().getNoticeMe(), Boolean.TRUE));
    L62:
        UDSwitch r127 = this.f215365k;
        if (r127 == null) goto L65;
        r127.setOnCheckedChangeListener(new com.bytedance.ee.bear.bitable.share.sharepanel.b(this));
    L65:
        p().Pf().addView(r122, r125);
    L66:
        y(true);
        if (o().getBitableShareMeta().isOpen() == true) goto L71;
        if (r111 == true) goto L71;
        boolean r128 = false;
    L72:
        B(r128);
        if (o().getBitableShareMeta().getShareToken().length() == 0) goto L76;
        r110 = false;
    L76:
        this.f215367m = r110;
        mu4.f.i();
        return;
    L71:
        r128 = true;
        goto L72
    L51:
        if (ForsetiHelper.s(p().l80().getSourceFragment()) == false) goto L53;
        r118 = p().l80().getSourceFragment();
        goto L54
    L47:
        r116 = r114;
        r117 = r113;
        goto L49
    L5:
        if (Intrinsics.areEqual(o().getFormMode(), "formMaker") == false) goto L7;
        p().Ax(R.string.Bitable_NewSurvey_General_Publish_Button);
        goto L9
    }

    @Override // com.bytedance.ee.bear.share.export.g
    public final String i() {
        return mu4.b.b(p().requireContext(), r().getShareType(), o());
    }

    @Override // com.bytedance.ee.bear.share.export.c
    public final void initData() {
        if (o().getBitableShareMeta().getShareToken().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        o().setUrl(n(o().getBitableShareMeta().getShareToken()));
    L8:
        com.bytedance.ee.bear.contract.d r101 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        r101.h("bitableFormPermCommonParams");
        r101.j("bitableFormPermCommonParams", "bitable_id", du5.b.g(o().getToken()));
        r101.j("bitableFormPermCommonParams", "table_id", du5.b.g(o().getTableId()));
        r101.j("bitableFormPermCommonParams", BitableResourceData.KEY_VIEW_ID, du5.b.g(o().getViewId()));
        r101.j("bitableFormPermCommonParams", "bitable_type", o().getBitableType());
        r101.j("bitableFormPermCommonParams", "is_full_screen", "true");
        r101.j("bitableFormPermCommonParams", BytedCertConstant.IntentKey.VIEW_TYPE, "form");
        if ((true ^ TextUtils.isEmpty(o().getFormMode())) == false) goto L12;
        r101.j("bitableFormPermCommonParams", "form_version", "form_v2");
    L12:
        if (o().getFormEditable() == false) goto L14;
        r101.j("bitableFormPermCommonParams", "form_permission", "edit");
        return;
    L14:
        r101.j("bitableFormPermCommonParams", "form_permission", "read");
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a, com.bytedance.ee.bear.share.export.e
    public final void onDestory() {
        super.onDestory();
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).c("bitableFormPermCommonParams");
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a, com.bytedance.ee.bear.share.export.e
    public final void onResume() {
        super.onResume();
        A();
    }

    @Override // com.bytedance.ee.bear.share.export.c
    public final com.bytedance.ee.bear.share.export.f w1() {
        return this.f215366l;
    }

    public final void B(boolean r100) {
        BitableShareLinkShareSetView r101 = this.f215362h;
        float r102 = 0.3f;
        if ((r101 instanceof mu4.d) == false) goto L9;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
        r101.setEnable(r100);
        View r103 = (View) this.f215369o.getValue();
        if (r100 == false) goto L7;
        float r104 = 1.0f;
    L8:
        r103.setAlpha(r104);
        goto L9
    L7:
        r104 = 0.3f;
    L9:
        com.bytedance.ee.bear.bitable.share.view.memberview.d r105 = this.f215363i;
        if ((r105 instanceof mu4.d) == false) goto L12;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
        r105.setEnable(r100);
    L12:
        com.bytedance.ee.bear.bitable.share.view.memberview.d r106 = this.f215363i;
        com.bytedance.ee.bear.bitable.share.sharepanel.c r107 = null;
        if ((r106 instanceof com.bytedance.ee.bear.bitable.share.view.memberview.d) == true) goto L16;
        r106 = null;
    L16:
        if (r106 == null) goto L18;
        r106.setSendNotificationClickListener(new com.bytedance.ee.bear.bitable.share.sharepanel.d(r100, this));
    L18:
        View r108 = this.f215364j;
        if (r108 == null) goto L23;
        if (r100 == false) goto L22;
        r102 = 1.0f;
    L22:
        r108.setAlpha(r102);
    L23:
        View r109 = this.f215364j;
        if (r109 == null) goto L29;
        if (r100 == true) goto L28;
        r107 = new com.bytedance.ee.bear.bitable.share.sharepanel.c(this);
    L28:
        r109.setOnClickListener(r107);
    L29:
        UDSwitch r110 = this.f215365k;
        if (r110 == null) goto L32;
        r110.setEnabled(r100);
    L32:
        List<ShareItemModel> r111 = p().ul();
        int r112 = com.bytedance.ee.bear.bitable.share.sharepanel.e.f215440a;
        List<? extends ShareItemModel> r113 = com.bytedance.ee.bear.bitable.share.sharepanel.a.C3074a.a(r111, com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.oldform.support.qrcode"), AppInfoUtils.f().booleanValue(), FormBitableShareFragmentDelegate$updateViewStatus$config$1.INSTANCE);
        com.bytedance.ee.bear.bitable.share.sharepanel.a.u(r113);
        if (r100 == true) goto L39;
        Iterator<? extends ShareItemModel> r114 = r113.iterator();
    L36:
        if (r114.hasNext() == false) goto L38;
        r114.next().setState(ShareState.NOT_CLICK);
        goto L36
    L38:
        p().ZB(new mu4.a(p().requireContext()));
    L40:
        p().L30(r113);
        UDNotice r115 = this.f215361g;
        if (r115 == null) goto L48;
        if (r100 == false) goto L44;
        int r116 = 0;
    L45:
        r115.setVisibility(r116);
        return;
    L44:
        r116 = 8;
        goto L45
    L48:
        return;
    L39:
        p().ZB(p().c90());
        goto L40
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a, com.bytedance.ee.bear.share.export.b
    public final boolean k(String r100) {
        if (v() == true) goto L6;
        tt5.a.d("FormShareFragmentDelegate", "onQRCode failed due to shareHost unInitialized");
        return false;
    L6:
        super.k(r100);
        int r101 = com.bytedance.ee.bear.bitable.share.sharepanel.e.f215440a;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.oldform.support.qrcode") == true) goto L9;
        return false;
    L9:
        if (r100 == null) goto L20;
        String r102 = UriProtector.parse(r100).buildUpon().appendQueryParameter("ccm_open_type", "form_v1_qrcode_share").build().toString();
        int r103 = FormsQRCodePanelFragmentV2.f215387u;
        FormsQRCodePanelFragmentV2 r104 = FormsQRCodePanelFragmentV2.c.a(o().getDocName(), o().getBannerURL(), o().getBannerResId(), r102, o().getToken(), null);
        FormBitableShareFragmentDelegate$onQRCode$1$1$1 r105 = FormBitableShareFragmentDelegate$onQRCode$1$1$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r105, "listener");
        r104.f215401q = r105;
        FragmentManager r106 = p().requireActivity().getSupportFragmentManager();
        LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r104, "FormsQRCodePanelFragment", r107);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r106, r104, r107) == true) goto L21;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L14:
        r104.show(r106, "FormsQRCodePanelFragment");
        return true;
    L21:
        return true;
    L20:
        return true;
    }

    public final void z(BitableSharePermission r100) {
        BitableSharePermSetInfo r101 = new BitableSharePermSetInfo(o().getUrl(), o().getType(), o().getToken(), o().getBitableShareMeta(), r100, o().getBitableShareRecordInfo());
        BitableShareLinkShareSetView r102 = this.f215362h;
        if ((r102 instanceof mu4.d) == false) goto L5;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
        r102.setBitableSharePermSetInfo(r101);
    L5:
        com.bytedance.ee.bear.bitable.share.view.memberview.d r103 = this.f215363i;
        if ((r103 instanceof mu4.d) == false) goto L8;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
        r103.setBitableSharePermSetInfo(r101);
    L8:
        boolean r104 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.forms.share.external.disable");
        boolean r105 = !TextUtils.isEmpty(o().getFormMode());
        if (r104 == true) goto L13;
        if (r105 == false) goto L13;
        B(true);
        return;
    L13:
        if (r100.f215332a.canShare() == true) goto L17;
        tt5.a.h("FormShareFragmentDelegate", "can not share");
        B(false);
        return;
    }

    public FormBitableShareFragmentDelegate(com.bytedance.ee.bear.share.export.e r100, com.bytedance.ee.bear.bitable.card.view.form.a r101) {
        super(r100);
        this.f215360f = r101;
        this.f215369o = LazyKt.lazy(new FormBitableShareFragmentDelegate$linkShareSetingDivier$2(this));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        B(r101);
        boolean r102 = true;
        if (r101 == true) goto L17;
        UDSwitch r103 = this.f215365k;
        if (r103 != null) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L17;
        Boolean r105 = Boolean.FALSE;
        this.f215368n = true;
        UDSwitch r106 = this.f215365k;
        if (r106 == null) goto L14;
        r106.setChecked(Intrinsics.areEqual(r105, Boolean.TRUE));
    L14:
        this.f215368n = false;
        gu4.b r107 = this.f215360f;
        if (r107 == null) goto L17;
        r107.b(false, "formShareClosed");
        goto L17
    L7:
        if (r103.isChecked() != true) goto L9;
        r104 = true;
    L17:
        Context r108 = r100.getContext();
        if (r108 == null) goto L32;
        if (r101 == false) goto L32;
        if (o().getBitableShareRecordInfo().hasFormulaField() == false) goto L26;
        if (o().getBitableShareRecordInfo().hasLookupField() == false) goto L26;
        UDToast.show(r108, R.string.Bitable_Form_FormulaResultsAndLookupResultsWillBeVisible, R.drawable.ud_icon_warning_outlined);
    L26:
        if (o().getBitableShareRecordInfo().hasFormulaField() == false) goto L29;
        UDToast.show(r108, R.string.Bitable_Form_FormulaResultsWillBeVisible, R.drawable.ud_icon_warning_outlined);
        goto L32
    L29:
        if (o().getBitableShareRecordInfo().hasLookupField() == false) goto L32;
        UDToast.show(r108, R.string.Bitable_Form_LookupResultsWillBeVisible, R.drawable.ud_icon_warning_outlined);
    L32:
        if (this.f215367m == true) goto L34;
        return;
    L34:
        if (o().getBitableShareMeta().getShareToken().length() > 0) goto L37;
        r102 = false;
    L37:
        if (r102 == false) goto L41;
        this.f215367m = false;
        A();
        o().setUrl(n(o().getBitableShareMeta().getShareToken()));
        return;
    }
}
