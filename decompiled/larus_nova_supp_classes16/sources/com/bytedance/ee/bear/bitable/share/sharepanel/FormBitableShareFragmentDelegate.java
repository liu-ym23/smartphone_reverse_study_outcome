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
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.bitable.share.permission.BitableSharePermission;
import com.bytedance.ee.bear.bitable.share.view.BitableShareLinkShareSetView;
import com.bytedance.ee.bear.bitable.share.view.BitableShareSwitchView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareState;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class FormBitableShareFragmentDelegate extends com.bytedance.ee.bear.bitable.share.sharepanel.a implements CompoundButton.OnCheckedChangeListener {
    public final gu4.b f;
    public UDNotice g;
    public BitableShareLinkShareSetView h;
    public com.bytedance.ee.bear.bitable.share.view.memberview.d i;
    public View j;
    public UDSwitch k;
    public mu4.c l;
    public boolean m;
    public boolean n;
    public final Lazy o;
    public vv4.k p;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ FormBitableShareFragmentDelegate a;

        public b(FormBitableShareFragmentDelegate r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.ee.bear.route.h r5 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
            this.a.getClass();
            s45.h r1 = s45.g.a;
            r5.u5(s45.g.a.b("183307421587#tabs0|lineguid-kjsbo", "362275149321#tabs0|lineguid-7W01O", null));
        }
    }

    public static final class c implements BitableShareLinkShareSetView.a {
        public final /* synthetic */ FormBitableShareFragmentDelegate a;

        @Override // com.bytedance.ee.bear.bitable.share.view.BitableShareLinkShareSetView.a
        public final void a() {
            this.a.A();
        }

        @Override // com.bytedance.ee.bear.bitable.share.view.BitableShareLinkShareSetView.a
        public final vv4.k b() {
            return this.a.p;
        }

        @Override // com.bytedance.ee.bear.bitable.share.view.BitableShareLinkShareSetView.a
        public final FragmentManager getFragmentManager() {
            return this.a.o().getActivity().getSupportFragmentManager();
        }

        public c(FormBitableShareFragmentDelegate r1) {
            this.a = r1;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ FormBitableShareFragmentDelegate a;

        public d(FormBitableShareFragmentDelegate r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            BitableSharePermission r6 = (BitableSharePermission) r5;
            FormBitableShareFragmentDelegate r0 = this.a;
            String r2 = r0.o().getToken();
            int r3 = this.a.o().getType();
            Intrinsics.checkNotNull(r6);
            r0.l = new mu4.c(r2, r3, r6);
            this.a.z(r6);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ FormBitableShareFragmentDelegate a;

        public e(FormBitableShareFragmentDelegate r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("FormShareFragmentDelegate", "updatePermission()...error", r5, false);
            FormBitableShareFragmentDelegate r0 = this.a;
            Intrinsics.checkNotNull(r5);
            r0.x(r5);
            FormBitableShareFragmentDelegate r6 = this.a;
            com.bytedance.ee.bear.bitable.share.view.memberview.d r1 = r6.i;
            if (r1 == null) goto L5;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
            r1.s();
        L5:
            BitableShareLinkShareSetView r7 = r6.h;
            if (r7 == null) goto L9;
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
            r7.s();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void j() {
    }

    public final void A() {
        if (this.m == false) goto L6;
        tt5.a.k("FormShareFragmentDelegate", "shareToken is empty!!!");
        this.l = new mu4.c(o().getToken(), o().getType(), new BitableSharePermission(0));
        z(new BitableSharePermission(0));
        return;
    L6:
        Disposable r0 = pu4.a.a(o().getToken(), o().getBitableShareMeta().getShareToken(), o().getTableId(), o().getViewId(), EShareType.FORM.getType()).observeOn(fo5.d.d()).subscribe(new d(this), new e(this));
        this.c.add(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r2v19, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View, com.bytedance.ee.bear.bitable.share.view.BitableShareSwitchView] */
    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void onViewCreated() {
        super.onViewCreated();
        boolean r10 = true;
        boolean r11 = !TextUtils.isEmpty(o().getFormMode());
        if (r11 == true) goto L5;
    L7:
        p().Ax(2131886532);
    L9:
        if (Intrinsics.areEqual("formUser", o().getFormMode()) == false) goto L25;
        if (o().getFormEditable() == true) goto L25;
        p().Pf().setVisibility(8);
        y(true);
        if (o().getBitableShareMeta().isOpen() == true) goto L17;
        if (r11 == true) goto L17;
        boolean r0 = false;
    L18:
        B(r0);
        if (o().getBitableShareMeta().getShareToken().length() == 0) goto L22;
        r10 = false;
    L22:
        this.m = r10;
        mu4.f.i();
        return;
    L17:
        r0 = true;
    L25:
        if (o().getBitableShareRecordInfo().hasLinkField() == false) goto L44;
        UDNotice r1 = new UDNotice(p().requireContext());
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, -2);
        int r3 = com.bytedance.ee.util.ui.n.d(16);
        r2.leftMargin = r3;
        r2.rightMargin = r3;
        r2.topMargin = r3;
        r1.setLayoutParams(r2);
        this.g = r1;
        String r4 = p().requireContext().getString(2131886543);
        UDNotice r5 = this.g;
        if (r5 == null) goto L29;
        r5.setText(2131886530);
    L29:
        UDNotice r6 = this.g;
        if (r6 == null) goto L32;
        r6.setTextButton(r4);
    L32:
        UDNotice r7 = this.g;
        if (r7 == null) goto L35;
        r7.setTextButtonPosition(UDNotice.TextButtonPosition.BOTTOM);
    L35:
        UDNotice r8 = this.g;
        if (r8 == null) goto L38;
        r8.setTextButtonListener(new b(this));
    L38:
        UDNotice r9 = this.g;
        if (r9 == null) goto L41;
        r9.setRadius(UDRadius.M);
    L41:
        p().Pf().addView(this.g);
        UDNotice r12 = this.g;
        if (r12 == null) goto L44;
        r12.setVisibility(8);
    L44:
        ViewGroup.LayoutParams r13 = new ViewGroup.LayoutParams(-1, -2);
        View r14 = com.bytedance.ee.bear.bitable.share.sharepanel.a.t(p().requireContext());
        r14.setHasDivider(false);
        p().Pf().addView(r14);
        if (TextUtils.isEmpty(o().getFormMode()) == false) goto L47;
        ?? r16 = new BitableShareSwitchView(p().requireContext());
        ?? r17 = r14;
        ViewGroup.LayoutParams r18 = r13;
        r16.S5(o().getToken(), o().getTableId(), o().getViewId(), o().getRecordId(), EShareType.FORM.getType(), o().getBitableShareMeta(), AnonymousClass3.INSTANCE, this);
        r17.addView(r16, r18);
        ?? r19 = r17;
    L49:
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L51;
    L53:
        Fragment r20 = null;
    L54:
        final BitableShareLinkShareSetView r21 = new BitableShareLinkShareSetView(p().requireContext(), r20);
        r21.setUIDelegate(new FormBitableShareFragmentDelegate$onViewCreated$4$1(r21));
        r21.setUnableClickListener(new FormBitableShareFragmentDelegate$onViewCreated$4$2(r21));
        r21.setIsNewLarkForm(r11);
        r21.setDelegate(new c(this));
        this.h = r21;
        r19.addView((View) this.o.getValue());
        r19.addView(this.h, r18);
        final com.bytedance.ee.bear.bitable.share.view.memberview.d r22 = new com.bytedance.ee.bear.bitable.share.view.memberview.d(p().requireActivity(), r20, o().getType(), o().getToken(), o().getBitableShareMeta().getShareToken());
        r22.setInviteMemberTitle(2131886520);
        r22.setManageMemberTitle(2131886523);
        r22.setUnableClickListener(new FormBitableShareFragmentDelegate$onViewCreated$5$1(r22));
        if (o().getShowRemindMe() == false) goto L57;
        r22.setSendNotificationEnable(true);
        r22.setSendNotificationTitle(2131886666);
    L57:
        this.i = r22;
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(-1, -2);
        r23.topMargin = com.bytedance.ee.util.ui.n.d(16);
        p().Pf().addView(this.i, r23);
        if (o().getShowNoticeMe() == false) goto L66;
        View r24 = LayoutInflater.from(p().requireActivity()).inflate(2131564194, null);
        this.j = r24;
        this.k = r24.findViewById(2131387837);
        int r26 = com.bytedance.ee.util.ui.n.d(16);
        int r27 = com.bytedance.ee.util.ui.n.d(12);
        LinearLayout.LayoutParams r28 = new LinearLayout.LayoutParams(-1, -2);
        r28.setMarginEnd(r26);
        r28.setMarginStart(r26);
        r28.topMargin = r27;
        UDSwitch r29 = this.k;
        if (r29 == null) goto L62;
        r29.setChecked(Intrinsics.areEqual(o().getNoticeMe(), Boolean.TRUE));
    L62:
        UDSwitch r30 = this.k;
        if (r30 == null) goto L65;
        r30.setOnCheckedChangeListener(new com.bytedance.ee.bear.bitable.share.sharepanel.b(this));
    L65:
        p().Pf().addView(r24, r28);
    L66:
        y(true);
        if (o().getBitableShareMeta().isOpen() == true) goto L71;
        if (r11 == true) goto L71;
        boolean r31 = false;
    L72:
        B(r31);
        if (o().getBitableShareMeta().getShareToken().length() == 0) goto L76;
        r10 = false;
    L76:
        this.m = r10;
        mu4.f.i();
        return;
    L71:
        r31 = true;
        goto L72
    L51:
        if (ForsetiHelper.s(p().l80().getSourceFragment()) == false) goto L53;
        r20 = p().l80().getSourceFragment();
        goto L54
    L47:
        r19 = r14;
        r18 = r13;
        goto L49
    L5:
        if (Intrinsics.areEqual(o().getFormMode(), "formMaker") == false) goto L7;
        p().Ax(2131886665);
        goto L9
    }

    public final String i() {
        return mu4.b.b(p().requireContext(), r().getShareType(), o());
    }

    public final void initData() {
        if (o().getBitableShareMeta().getShareToken().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        o().setUrl(n(o().getBitableShareMeta().getShareToken()));
    L8:
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        r1.h("bitableFormPermCommonParams");
        r1.j("bitableFormPermCommonParams", "bitable_id", du5.b.g(o().getToken()));
        r1.j("bitableFormPermCommonParams", "table_id", du5.b.g(o().getTableId()));
        r1.j("bitableFormPermCommonParams", "view_id", du5.b.g(o().getViewId()));
        r1.j("bitableFormPermCommonParams", "bitable_type", o().getBitableType());
        r1.j("bitableFormPermCommonParams", "is_full_screen", "true");
        r1.j("bitableFormPermCommonParams", "view_type", "form");
        if ((true ^ TextUtils.isEmpty(o().getFormMode())) == false) goto L12;
        r1.j("bitableFormPermCommonParams", "form_version", "form_v2");
    L12:
        if (o().getFormEditable() == false) goto L14;
        r1.j("bitableFormPermCommonParams", "form_permission", JSEventListener.ACTION_EDIT);
        return;
    L14:
        r1.j("bitableFormPermCommonParams", "form_permission", "read");
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void onDestory() {
        super.onDestory();
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).c("bitableFormPermCommonParams");
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void onResume() {
        super.onResume();
        A();
    }

    public final com.bytedance.ee.bear.share.export.f w1() {
        return this.l;
    }

    public final void B(boolean r6) {
        BitableShareLinkShareSetView r0 = this.h;
        float r2 = 0.3f;
        if ((r0 instanceof mu4.d) == false) goto L9;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
        r0.setEnable(r6);
        View r1 = (View) this.o.getValue();
        if (r6 == false) goto L7;
        float r3 = 1.0f;
    L8:
        r1.setAlpha(r3);
        goto L9
    L7:
        r3 = 0.3f;
    L9:
        com.bytedance.ee.bear.bitable.share.view.memberview.d r4 = this.i;
        if ((r4 instanceof mu4.d) == false) goto L12;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
        r4.setEnable(r6);
    L12:
        com.bytedance.ee.bear.bitable.share.view.memberview.d r5 = this.i;
        com.bytedance.ee.bear.bitable.share.sharepanel.c r7 = null;
        if ((r5 instanceof com.bytedance.ee.bear.bitable.share.view.memberview.d) == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
        r5.setSendNotificationClickListener(new com.bytedance.ee.bear.bitable.share.sharepanel.d(r6, this));
    L18:
        View r8 = this.j;
        if (r8 == null) goto L23;
        if (r6 == false) goto L22;
        r2 = 1.0f;
    L22:
        r8.setAlpha(r2);
    L23:
        View r9 = this.j;
        if (r9 == null) goto L29;
        if (r6 == true) goto L28;
        r7 = new com.bytedance.ee.bear.bitable.share.sharepanel.c(this);
    L28:
        r9.setOnClickListener(r7);
    L29:
        UDSwitch r10 = this.k;
        if (r10 == null) goto L32;
        r10.setEnabled(r6);
    L32:
        List r11 = p().ul();
        int r12 = com.bytedance.ee.bear.bitable.share.sharepanel.e.a;
        List r13 = com.bytedance.ee.bear.bitable.share.sharepanel.a.C0018a.a(r11, com.bytedance.ee.bear.appsetting.c.a.a.h("base.oldform.support.qrcode"), AppInfoUtils.f().booleanValue(), FormBitableShareFragmentDelegate$updateViewStatus$config$1.INSTANCE);
        com.bytedance.ee.bear.bitable.share.sharepanel.a.u(r13);
        if (r6 == true) goto L39;
        Iterator r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L38;
        ((ShareItemModel) r14.next()).setState(ShareState.NOT_CLICK);
        goto L36
    L38:
        p().ZB(new mu4.a(p().requireContext()));
    L40:
        p().L30(r13);
        UDNotice r16 = this.g;
        if (r16 == null) goto L48;
        if (r6 == false) goto L44;
        int r17 = 0;
    L45:
        r16.setVisibility(r17);
        return;
    L44:
        r17 = 8;
        goto L45
    L48:
        return;
    L39:
        p().ZB(p().c90());
        goto L40
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final boolean k(String r7) {
        if (v() == true) goto L6;
        tt5.a.d("FormShareFragmentDelegate", "onQRCode failed due to shareHost unInitialized");
        return false;
    L6:
        super.k(r7);
        int r0 = com.bytedance.ee.bear.bitable.share.sharepanel.e.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("base.oldform.support.qrcode") == true) goto L9;
        return false;
    L9:
        if (r7 == null) goto L20;
        String r3 = UriProtector.parse(r7).buildUpon().appendQueryParameter("ccm_open_type", "form_v1_qrcode_share").build().toString();
        int r8 = FormsQRCodePanelFragmentV2.u;
        FormsQRCodePanelFragmentV2 r9 = FormsQRCodePanelFragmentV2.c.a(o().getDocName(), o().getBannerURL(), o().getBannerResId(), r3, o().getToken(), null);
        FormBitableShareFragmentDelegate$onQRCode$1$1$1 r1 = FormBitableShareFragmentDelegate$onQRCode$1$1$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "listener");
        r9.q = r1;
        FragmentManager r2 = p().requireActivity().getSupportFragmentManager();
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, "FormsQRCodePanelFragment", r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r9, r4) == true) goto L21;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L14:
        r9.show(r2, "FormsQRCodePanelFragment");
        return true;
    L21:
        return true;
    L20:
        return true;
    }

    public final void z(BitableSharePermission r9) {
        BitableSharePermSetInfo r7 = new BitableSharePermSetInfo(o().getUrl(), o().getType(), o().getToken(), o().getBitableShareMeta(), r9, o().getBitableShareRecordInfo());
        BitableShareLinkShareSetView r0 = this.h;
        if ((r0 instanceof mu4.d) == false) goto L5;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
        r0.setBitableSharePermSetInfo(r7);
    L5:
        com.bytedance.ee.bear.bitable.share.view.memberview.d r1 = this.i;
        if ((r1 instanceof mu4.d) == false) goto L8;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
        r1.setBitableSharePermSetInfo(r7);
    L8:
        boolean r2 = com.bytedance.ee.bear.appsetting.c.a.a.h("base.forms.share.external.disable");
        boolean r3 = !TextUtils.isEmpty(o().getFormMode());
        if (r2 == true) goto L13;
        if (r3 == false) goto L13;
        B(true);
        return;
    L13:
        if (r9.a.canShare() == true) goto L17;
        tt5.a.h("FormShareFragmentDelegate", "can not share");
        B(false);
        return;
    }

    public FormBitableShareFragmentDelegate(com.bytedance.ee.bear.share.export.e r1, com.bytedance.ee.bear.bitable.card.view.form.a r2) {
        super(r1);
        this.f = r2;
        this.o = LazyKt.lazy(new FormBitableShareFragmentDelegate$linkShareSetingDivier$2(this));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "buttonView");
        B(r7);
        boolean r0 = true;
        if (r7 == true) goto L17;
        UDSwitch r2 = this.k;
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L17;
        Boolean r4 = Boolean.FALSE;
        this.n = true;
        UDSwitch r5 = this.k;
        if (r5 == null) goto L14;
        r5.setChecked(Intrinsics.areEqual(r4, Boolean.TRUE));
    L14:
        this.n = false;
        gu4.b r8 = this.f;
        if (r8 == null) goto L17;
        r8.b(false, "formShareClosed");
        goto L17
    L7:
        if (r2.isChecked() != true) goto L9;
        r3 = true;
    L17:
        Context r9 = r6.getContext();
        if (r9 == null) goto L32;
        if (r7 == false) goto L32;
        if (o().getBitableShareRecordInfo().hasFormulaField() == false) goto L26;
        if (o().getBitableShareRecordInfo().hasLookupField() == false) goto L26;
        UDToast.show(r9, 2131886516, 2131256189);
    L26:
        if (o().getBitableShareRecordInfo().hasFormulaField() == false) goto L29;
        UDToast.show(r9, 2131886517, 2131256189);
        goto L32
    L29:
        if (o().getBitableShareRecordInfo().hasLookupField() == false) goto L32;
        UDToast.show(r9, 2131886522, 2131256189);
    L32:
        if (this.m == true) goto L34;
        return;
    L34:
        if (o().getBitableShareMeta().getShareToken().length() > 0) goto L37;
        r0 = false;
    L37:
        if (r0 == false) goto L41;
        this.m = false;
        A();
        o().setUrl(n(o().getBitableShareMeta().getShareToken()));
        return;
    }
}
