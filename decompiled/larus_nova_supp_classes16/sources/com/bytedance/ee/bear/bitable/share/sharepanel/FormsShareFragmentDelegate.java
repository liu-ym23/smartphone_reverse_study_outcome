package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.view.form.BitableSharePlugin;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.bitable.share.permission.BitableSharePermission;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareState;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class FormsShareFragmentDelegate extends com.bytedance.ee.bear.bitable.share.sharepanel.a {
    public final BitableSharePlugin.c f;
    public final gu4.b g;
    public UDNotice h;
    public com.bytedance.ee.bear.bitable.share.view.memberview.d i;
    public View j;
    public UDSwitch k;
    public mu4.c l;
    public boolean m;
    public com.bytedance.ee.bear.share.export.k n;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ FormsShareFragmentDelegate a;

        public b(FormsShareFragmentDelegate r1) {
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

    public static final class c implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ FormsShareFragmentDelegate a;

        public c(FormsShareFragmentDelegate r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r1, boolean r2) {
            gu4.b r3 = this.a.g;
            if (r3 == null) goto L6;
            r3.a(r2);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ FormsShareFragmentDelegate a;

        public d(FormsShareFragmentDelegate r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            BitableSharePlugin.c r5 = this.a.f;
            if (r5 == null) goto L5;
            JSONObject r0 = new JSONObject();
            r0.put("shareToken", this.a.o().getBitableShareMeta().getShareToken());
            Unit r1 = Unit.INSTANCE;
            r5.a(r0);
        L5:
            this.a.p().X9();
        }
    }

    static {
    }

    public FormsShareFragmentDelegate() {
        this(null, null, null);
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void j() {
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void onViewCreated() {
        super.onViewCreated();
        if (v() == true) goto L6;
        tt5.a.d("FormsShareFragmentDelegate", "shareHost unInit onViewCreated");
        return;
    L6:
        int r4 = 0;
        if (en4.a.l() == true) goto L9;
    L11:
        boolean r1 = false;
    L12:
        com.bytedance.ee.bear.share.export.d r5 = p();
        String r6 = o().getPanelTitle();
        if (r6 != null) goto L15;
        r6 = com.bytedance.ee.util.ui.n.x(p().requireContext(), 2131886673);
    L15:
        Intrinsics.checkNotNull(r6);
        r5.AB(r6);
        p().K80();
        p().gN();
        if (o().getBitableShareMeta().getShareToken().length() != 0) goto L18;
        boolean r7 = true;
    L19:
        this.m = r7;
        if (o().getBitableShareRecordInfo().hasLinkField() == false) goto L39;
        UDNotice r8 = new UDNotice(p().requireContext());
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-1, -2);
        int r11 = com.bytedance.ee.util.ui.n.d(16);
        r10.leftMargin = r11;
        r10.rightMargin = r11;
        r10.topMargin = r11;
        r8.setLayoutParams(r10);
        this.h = r8;
        String r9 = p().requireContext().getString(2131886543);
        UDNotice r12 = this.h;
        if (r12 == null) goto L24;
        r12.setText(2131886530);
    L24:
        UDNotice r13 = this.h;
        if (r13 == null) goto L27;
        r13.setTextButton(r9);
    L27:
        UDNotice r14 = this.h;
        if (r14 == null) goto L30;
        r14.setTextButtonPosition(UDNotice.TextButtonPosition.BOTTOM);
    L30:
        UDNotice r16 = this.h;
        if (r16 == null) goto L33;
        r16.setTextButtonListener(new b(this));
    L33:
        UDNotice r17 = this.h;
        if (r17 == null) goto L36;
        r17.setRadius(UDRadius.M);
    L36:
        p().Pf().addView(this.h);
        UDNotice r18 = this.h;
        if (r18 == null) goto L39;
        r18.setVisibility(8);
    L39:
        String[] r19 = o().getPanelComponents();
        if (r19 != null) goto L42;
    L44:
        boolean r20 = false;
    L45:
        com.bytedance.ee.bear.bitable.share.view.memberview.d r110 = null;
        if (r20 == true) goto L48;
    L54:
        String[] r21 = o().getPanelComponents();
        if (r21 != null) goto L57;
    L59:
        boolean r22 = false;
    L60:
        if (r22 == false) goto L72;
        View r23 = LayoutInflater.from(p().requireActivity()).inflate(2131564194, null);
        this.j = r23;
        if (r23 == null) goto L64;
        UDSwitch r24 = (UDSwitch) r23.findViewById(2131387837);
    L65:
        this.k = r24;
        int r26 = com.bytedance.ee.util.ui.n.d(16);
        int r27 = com.bytedance.ee.util.ui.n.d(12);
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-1, -2);
        r111.setMarginEnd(r26);
        r111.setMarginStart(r26);
        r111.topMargin = r27;
        UDSwitch r28 = this.k;
        if (r28 == null) goto L68;
        r28.setChecked(Intrinsics.areEqual(o().getNoticeMe(), Boolean.TRUE));
    L68:
        UDSwitch r29 = this.k;
        if (r29 == null) goto L71;
        r29.setOnCheckedChangeListener(new c(this));
    L71:
        p().Pf().addView(this.j, r111);
        goto L72
    L64:
        r24 = null;
    L72:
        if (r1 == true) goto L80;
        int r2 = com.bytedance.ee.bear.bitable.c.a;
        int r3 = com.bytedance.ee.bear.bitable.n.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.base.lark_form_remind_inviter.enable") == false) goto L80;
        com.bytedance.ee.bear.bitable.share.view.memberview.d r30 = this.i;
        if ((r30 instanceof com.bytedance.ee.bear.bitable.share.view.memberview.d) == false) goto L78;
        r110 = r30;
    L78:
        if (r110 == null) goto L80;
        r110.setSendNotificationEnable(true);
        r110.setSendNotificationClickListener(new d(this));
        r110.setSendNotificationTitle(2131886666);
    L80:
        y(true);
        boolean r31 = o().getBitableShareMeta().isOpen();
        if (v() == true) goto L83;
        tt5.a.d("FormsShareFragmentDelegate", "shareHost unInit updateViewStatus");
    L100:
        mu4.f.i();
        return;
    L83:
        com.bytedance.ee.bear.bitable.share.view.memberview.d r32 = this.i;
        if ((r32 instanceof mu4.d) == false) goto L86;
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
        r32.setEnable(r31);
    L86:
        List r33 = com.bytedance.ee.bear.bitable.share.sharepanel.a.C0018a.a(p().ul(), true, AppInfoUtils.f().booleanValue(), FormsShareFragmentDelegate$updateViewStatus$config$1.INSTANCE);
        com.bytedance.ee.bear.bitable.share.sharepanel.a.u(r33);
        if (r31 == true) goto L93;
        Iterator r34 = r33.iterator();
    L90:
        if (r34.hasNext() == false) goto L92;
        ((ShareItemModel) r34.next()).setState(ShareState.NOT_CLICK);
        goto L90
    L92:
        p().ZB(new mu4.a(p().requireContext()));
    L94:
        p().L30(r33);
        UDNotice r36 = this.h;
        if (r36 == null) goto L100;
        if (r31 == true) goto L99;
        r4 = 8;
    L99:
        r36.setVisibility(r4);
        goto L100
    L93:
        p().ZB(p().c90());
        goto L94
    L57:
        if (ArraysKt.contains(r21, "notice") != true) goto L59;
        r22 = true;
        goto L60
    L48:
        if (ForsetiHelper.s(o().getSourceFragment()) == true) goto L50;
    L52:
        Fragment r112 = null;
    L53:
        final com.bytedance.ee.bear.bitable.share.view.memberview.d r37 = new com.bytedance.ee.bear.bitable.share.view.memberview.d(p().requireActivity(), r112, o().getType(), o().getToken(), o().getBitableShareMeta().getShareToken());
        r37.setCollaborateViewTitle(2131886671);
        r37.setInviteMemberTitle(2131886520);
        r37.setManageMemberTitle(2131886523);
        r37.setUnableClickListener(new FormsShareFragmentDelegate$onViewCreated$3$1(r37));
        this.i = r37;
        p().Pf().addView(this.i, new ViewGroup.LayoutParams(-1, -2));
        goto L54
    L50:
        if (com.bytedance.ee.bear.bitable.c.j() == false) goto L52;
        r112 = o().getSourceFragment();
        goto L53
    L42:
        if (ArraysKt.contains(r19, "memberSetting") != true) goto L44;
        r20 = true;
        goto L45
    L18:
        r7 = false;
        goto L19
    L9:
        if (en4.a.k() == true) goto L11;
        r1 = true;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void x1() {
        com.bytedance.ee.bear.share.export.k r0 = this.n;
        if (r0 == null) goto L6;
        r0.onDismiss();
        return;
    }

    public final String i() {
        if (v() == true) goto L7;
        tt5.a.d("FormsShareFragmentDelegate", "shareHost unInit getExternalShareContent");
        return "";
    L7:
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
        r1.j("bitableFormPermCommonParams", "form_version", "form_v2");
        if (o().getFormEditable() == false) goto L11;
        r1.j("bitableFormPermCommonParams", "form_permission", JSEventListener.ACTION_EDIT);
        return;
    L11:
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
        if (this.m == false) goto L5;
        tt5.a.k("FormsShareFragmentDelegate", "shareToken is empty!!!");
        this.l = new mu4.c(o().getToken(), o().getType(), new BitableSharePermission(0));
        z(new BitableSharePermission(0));
        return;
    L5:
        Disposable r0 = pu4.a.a(o().getToken(), o().getBitableShareMeta().getShareToken(), o().getTableId(), o().getViewId(), EShareType.FORM.getType()).observeOn(fo5.d.d()).subscribe(new t(this), new u(this));
        this.c.add(r0);
    }

    public final com.bytedance.ee.bear.share.export.f w1() {
        return this.l;
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final boolean k(String r9) {
        super.k(r9);
        if (v() == true) goto L6;
        tt5.a.d("FormsShareFragmentDelegate", "onQRCode failed due to shareHost unInitialized");
        return false;
    L6:
        if (r9 == null) goto L30;
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r0.h("base.forms.qrcode_opentype.disable") == true) goto L10;
        r9 = UriProtector.parse(r9).buildUpon().appendQueryParameter("ccm_open_type", "form_qrcode").build().toString();
    L10:
        String r4 = r9;
        int r10 = e.a;
        if (r0.h("base.oldform.support.qrcode") == false) goto L17;
        int r11 = FormsQRCodePanelFragmentV2.u;
        FormsQRCodePanelFragmentV2 r12 = FormsQRCodePanelFragmentV2.c.a(o().getDocName(), o().getBannerURL(), null, r4, o().getToken(), null);
        FormsShareFragmentDelegate$onQRCode$1$1$1 r1 = FormsShareFragmentDelegate$onQRCode$1$1$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "listener");
        r12.q = r1;
        FragmentManager r2 = p().requireActivity().getSupportFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, "FormsQRCodePanelFragment", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r12, r3) == true) goto L32;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L16:
        r12.show(r2, "FormsQRCodePanelFragment");
        return true;
    L32:
        return true;
    L17:
        int r13 = FormsQRCodePanelFragment.o;
        FormsQRCodePanelFragment r14 = FormsQRCodePanelFragment.a.a(o().getDocName(), o().getBannerURL(), r4, o().getToken(), null);
        FormsShareFragmentDelegate$onQRCode$1$2$1 r5 = FormsShareFragmentDelegate$onQRCode$1$2$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "listener");
        r14.m = r5;
        FragmentManager r6 = p().requireActivity().getSupportFragmentManager();
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, "FormsQRCodePanelFragment", r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r14, r7) == true) goto L33;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L21:
        r14.show(r6, "FormsQRCodePanelFragment");
        return true;
    L33:
        return true;
    L30:
        return true;
    }

    public final void z(BitableSharePermission r9) {
        BitableSharePermSetInfo r7 = new BitableSharePermSetInfo(o().getUrl(), o().getType(), o().getToken(), o().getBitableShareMeta(), r9, o().getBitableShareRecordInfo());
        com.bytedance.ee.bear.bitable.share.view.memberview.d r10 = this.i;
        if ((r10 instanceof mu4.d) == false) goto L6;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
        r10.setBitableSharePermSetInfo(r7);
        return;
    }

    public FormsShareFragmentDelegate(com.bytedance.ee.bear.share.export.e r1, com.bytedance.ee.bear.bitable.card.view.form.f r2, gu4.b r3) {
        super(r1);
        this.f = r2;
        this.g = r3;
    }
}
