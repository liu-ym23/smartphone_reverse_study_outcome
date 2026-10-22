package com.bytedance.ee.bear.share.newshare;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.supervisor.token.Token;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.pb.security_event.AppDetail;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001\\B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\u001a\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010%\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020/H\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\u0010\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u000205H\u0016J\u0016\u00106\u001a\u00020\u00122\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0016J\u0010\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020<H\u0016J\u0010\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020+H\u0016J\b\u0010A\u001a\u000205H\u0016J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020908H\u0016J\b\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020DH\u0002J\u0010\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020\u0012H\u0002J\b\u0010K\u001a\u00020\u0012H\u0002J\b\u0010L\u001a\u00020\u0012H\u0002J\u0018\u0010M\u001a\u00020<2\u0006\u0010N\u001a\u00020,2\u0006\u0010O\u001a\u00020,H\u0002J\b\u0010P\u001a\u00020\u0012H\u0002J\b\u0010Q\u001a\u00020\u0012H\u0002J\b\u0010R\u001a\u00020\u0012H\u0002J\b\u0010S\u001a\u00020\u0012H\u0002J\b\u0010T\u001a\u00020\u0012H\u0002J\u0010\u0010U\u001a\u00020\u00122\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010V\u001a\u00020,H\u0002J\b\u0010W\u001a\u00020\u0012H\u0016J\b\u0010X\u001a\u00020\u0012H\u0016J\u0010\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020[H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/bytedance/ee/bear/share/newshare/ShareFragmentExtend;", "Lcom/bytedance/ee/bear/share/newshare/BaseShareFragment;", "Lcom/bytedance/ee/bear/share/export/IShareFragmentHost;", "<init>", "()V", "shareContainerFromXml", "Landroid/widget/LinearLayout;", "getShareContainerFromXml", "()Landroid/widget/LinearLayout;", "setShareContainerFromXml", "(Landroid/widget/LinearLayout;)V", "formShareExternalViewFromXml", "Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;", "getFormShareExternalViewFromXml", "()Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;", "setFormShareExternalViewFromXml", "(Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;)V", "clearFromXmlViewCache", "", "onDestroyView", "shareFragmentDelegate", "Lcom/bytedance/ee/bear/share/export/IShareFragmentDelegate;", "shareActionDelegate", "Lcom/bytedance/ee/bear/share/export/IShareActionDelegate;", "bindFragmentDelegate", "bindActionDelegate", "onAttach", "context", "Landroid/content/Context;", "initData", "onStart", "initPeekHeight", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "getChildFM", "Landroidx/fragment/app/FragmentManager;", "setTitleBarText", "title", "", "", "getShareContainer", "getShareParams", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "getShareInfo", "Lcom/bytedance/ee/bear/share/export/IShareInfo;", "onResume", "setOnShareItemClickListener", "onShareResultListener", "Lcom/bytedance/ee/bear/bizwidget/shareview/OnShareItemClickListener;", "updateShareItemState", "newItemModel", "", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", "setInterceptNotClick", "intercept", "", "useExternalContainerTop", "yes", "setExternalViewTitle", "titleRes", "getDefualtOnShareItemClickListener", "getExternalConfig", "buildShareItemModelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "hideTopArea", "modelParams", "doShareToType", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "shareToLark", "copyLink", "shareQRCode", "safeCopyLink", ResourceData.KEY_URL, ResourceData.KEY_TOKEN, "shareToWechat", "shareToWechatMoments", "shareToQQ", "shareToWeibo", "shareMore", "performSysShareText", "getExternalShareContent", "onDestroy", "dismissShareFragment", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareFragmentExtend extends BaseShareFragment implements com.bytedance.ee.bear.share.export.d {
    public static final /* synthetic */ int C = 0;
    public com.bytedance.ee.bear.share.export.c A;
    public com.bytedance.ee.bear.share.export.b B;
    public LinearLayout y;
    public ExternalShareView z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.Lark.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ShareType.CopyLink.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ShareType.QRCode.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ShareType.Wechat.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ShareType.WechatMoments.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ShareType.QQ.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ShareType.Weibo.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ShareType.More.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ShareFragmentExtend a;

        public c(ShareFragmentExtend r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final ShareFragmentExtend c90() {
        return this;
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final void K80() {
        tt5.a.h("ShareFragmentExtend", "useExternalContainerTop true");
        Ra0().setLayoutManager(new GridLayoutManager(requireContext(), 5));
        Ra0().setVisibility(0);
        ra0().setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final LinearLayout Pf() {
        View r0 = this.y;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131386050);
    L8:
        this.y = (LinearLayout) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (LinearLayout) r0;
    }

    public final ExternalShareView Ra0() {
        View r0 = this.z;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131373170);
    L8:
        this.z = (ExternalShareView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (ExternalShareView) r0;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final km5.a ga0() {
        return new km5.a(oa0().getSource(), oa0().getType(), oa0().getToken(), oa0().isWiki(), true, oa0().getMindnoteViewType(), oa0().getDisabledShareTypes(), oa0().getBadgeShareTypes(), oa0().isAtVC(), oa0().getAdminPerceiveControl(), true, false, null, null, false, oa0().getShowExportImage(), null, 81920);
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final com.bytedance.ee.bear.share.export.f sa0() {
        com.bytedance.ee.bear.share.export.c r0 = this.A;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.w1();
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final void YH() {
        if (ra0().getVisibility() != 0) goto L6;
        ra0().setInterceptNotClick(false);
        return;
    L6:
        if (Ra0().getVisibility() != 0) goto L8;
        Ra0().setInterceptNotClick(false);
        return;
    L8:
        tt5.a.k("ShareFragmentExtend", "setInterceptNotClick invalid");
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final void gN() {
        if (ra0().getVisibility() != 0) goto L6;
        ra0().setTitle(2131886674);
        return;
    L6:
        if (Ra0().getVisibility() != 0) goto L8;
        Ra0().setTitle(2131886674);
        return;
    L8:
        tt5.a.k("ShareFragmentExtend", "setExternalViewTitle invalid");
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void ha0() {
        super.ha0();
        this.y = null;
        this.z = null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void initData() {
        super.initData();
        requireContext();
        com.bytedance.ee.bear.share.export.c r0 = this.A;
        if (r0 == null) goto L6;
        r0.initData();
        return;
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final ShareParams l80() {
        return oa0();
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.ee.bear.share.export.c r0 = this.A;
        if (r0 == null) goto L6;
        r0.onDestory();
        return;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onDestroyView() {
        super.onDestroyView();
        ha0();
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onResume() {
        super.onResume();
        com.bytedance.ee.bear.share.export.c r0 = this.A;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.big_screen_bottom_panel_height_fix_enable") == true) goto L5;
        return;
    L5:
        if (getActivity() != null) goto L7;
        tt5.a.d("ShareFragmentExtend", "activity is null");
        return;
    L7:
        if (com.bytedance.ee.util.ui.n.D(getActivity()) == false) goto L9;
    L36:
        Dialog r0 = getDialog();     // Catch: Throwable -> L32
        if (r0 == null) goto L25;
        Window r1 = r0.getWindow();     // Catch: Throwable -> L32
        if (r1 == null) goto L25;
        View r2 = r1.getDecorView();     // Catch: Throwable -> L32
        if (com.larus.home.impl.utils.c.e == false) goto L21;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L32
        Thread r3 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L32
        if (r3 == com.larus.home.impl.utils.c.a) goto L21;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");     // Catch: Throwable -> L32
    L21:
        if (r2 == null) goto L25;
        FrameLayout r4 = (FrameLayout) r2.findViewById(2131368870);     // Catch: Throwable -> L32
        if (r4 == null) goto L25;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();     // Catch: Throwable -> L32
    L27:
        if ((r5 instanceof CoordinatorLayout.LayoutParams) == false) goto L40;
        BottomSheetBehavior r6 = ((CoordinatorLayout.LayoutParams) r5).getBehavior();     // Catch: Throwable -> L32
        if ((r6 instanceof BottomSheetBehavior) == false) goto L41;
        r6.setPeekHeight(com.bytedance.ee.util.ui.n.p(getContext()));     // Catch: Throwable -> L32
        return;
    L41:
        return;
    L40:
        return;
    L25:
        r5 = null;
    L32:
        th = move-exception;
        tt5.a.e("ShareFragmentExtend", "init peek height", th, false);
        return;
    L9:
        if (rcb.b.b(getActivity()) == true) goto L36;
        if (com.bytedance.ee.util.ui.n.C(getActivity()) == true) goto L36;
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final List<ShareItemModel> ul() {
        km5.a r0 = ga0();
        List<ShareItemModel> r1 = ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).getProvider().a(r0);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L5
        return r1;
    L5:
        th = move-exception;
        tt5.a.e("ShareFragmentExtend", "getExternalConfig failed", th, false);
        return CollectionsKt.emptyList();
    }

    public ShareFragmentExtend() {
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final void X9() {
        Qa0(this);
    }

    public static void Qa0(ShareFragmentExtend r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final void AB(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        ta0().setTitle(r2);
        ta0().setMainTitleSize(17.0f);
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final void Ax(int r2) {
        ta0().setTitle(r2);
        ta0().setMainTitleSize(17.0f);
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final void L30(List<? extends ShareItemModel> r2) {
        Intrinsics.checkNotNullParameter(r2, "newItemModel");
        if (ra0().getVisibility() != 0) goto L6;
        ra0().b(r2);
        return;
    L6:
        if (Ra0().getVisibility() != 0) goto L8;
        Ra0().b(r2);
        return;
    L8:
        tt5.a.k("ShareFragmentExtend", "updateShareItemState invalid");
    }

    @Override // com.bytedance.ee.bear.share.export.d
    public final void ZB(com.bytedance.ee.bear.bizwidget.shareview.b r2) {
        Intrinsics.checkNotNullParameter(r2, "onShareResultListener");
        if (ra0().getVisibility() != 0) goto L6;
        ra0().setOnShareItemClickListener(r2);
        return;
    L6:
        if (Ra0().getVisibility() != 0) goto L8;
        Ra0().setOnShareItemClickListener(r2);
        return;
    L8:
        tt5.a.k("ShareFragmentExtend", "setOnShareItemClickListener invalid");
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.DialogFragment*/.onAttach(r2);
        com.bytedance.ee.bear.share.export.c r3 = this.A;
        if (r3 == null) goto L6;
        r3.b(this);
        return;
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        if (Intrinsics.areEqual(oa0().getExpandAtInit(), Boolean.TRUE) == false) goto L7;
        BottomSheetBehavior r0 = com.bytedance.ee.bear.bizwidget.dialogfragment.b.b(r4);
        if (r0 == null) goto L7;
        r0.setState(3);
    L7:
        return r4;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        com.bytedance.ee.bear.share.export.c r3 = this.A;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.x1();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void s10(ShareType r9) {
        Intrinsics.checkNotNullParameter(r9, "shareType");
        Integer r2 = null;
        String r3 = "";
        boolean r6 = false;
        boolean r7 = true;
        switch(b.a[r9.ordinal()]) {
            case 1: goto L113;
            case 2: goto L93;
            case 3: goto L86;
            case 4: goto L72;
            case 5: goto L47;
            case 6: goto L33;
            case 7: goto L19;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        super.s10(r9);
        return;
    L5:
        com.bytedance.ee.bear.share.export.b r10 = this.B;
        if (r10 != null) goto L8;
    L10:
        if (r6 == true) goto L147;
        int r11 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.a(AppDetail.Others, oa0(), this.o);
        FragmentActivity r12 = getActivity();
        com.bytedance.ee.bear.share.export.b r0 = this.B;
        if (r0 == null) goto L18;
        String r1 = r0.i();
        if (r1 == null) goto L18;
        r3 = r1;
    L18:
        km5.c.b(r12, r3);
        Qa0(this);
        return;
    L147:
        return;
    L8:
        if (r10.e() != true) goto L10;
        r6 = true;
        goto L10
    L19:
        com.bytedance.ee.bear.share.export.b r13 = this.B;
        if (r13 != null) goto L22;
    L24:
        if (r6 == true) goto L148;
        int r14 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.a(AppDetail.Weibo, oa0(), this.o);
        ShareType r15 = ShareType.Weibo;
        Context r4 = requireContext();
        com.bytedance.ee.bear.share.export.b r5 = this.B;
        if (r5 == null) goto L32;
        String r8 = r5.i();
        if (r8 == null) goto L32;
        r3 = r8;
    L32:
        km5.c.j(r4, r15, r3, null);
        Qa0(this);
        return;
    L148:
        return;
    L22:
        if (r13.c() != true) goto L24;
        r6 = true;
        goto L24
    L33:
        com.bytedance.ee.bear.share.export.b r16 = this.B;
        if (r16 != null) goto L36;
    L38:
        if (r6 == true) goto L149;
        int r17 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.a(AppDetail.QQ, oa0(), this.o);
        ShareType r18 = ShareType.QQ;
        Context r19 = requireContext();
        com.bytedance.ee.bear.share.export.b r20 = this.B;
        if (r20 == null) goto L46;
        String r21 = r20.i();
        if (r21 == null) goto L46;
        r3 = r21;
    L46:
        km5.c.j(r19, r18, r3, null);
        Qa0(this);
        return;
    L149:
        return;
    L36:
        if (r16.h() != true) goto L38;
        r6 = true;
        goto L38
    L47:
        com.bytedance.ee.bear.share.export.b r22 = this.B;
        if (r22 != null) goto L50;
    L52:
        r7 = false;
    L53:
        if (r7 == true) goto L150;
        int r23 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.a(AppDetail.WeChatMoments, oa0(), this.o);
        String r24 = na0();
        r6 = ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(r24, false, new Token("LARK-PSDA-bitable_share_wechatmoments_set_clipboard"));     // Catch: Throwable -> L58
    L60:
        if (r6 == false) goto L68;
        ShareType r25 = ShareType.WechatMoments;
        com.bytedance.ee.bear.share.export.b r26 = this.B;
        if (r26 == null) goto L67;
        String r27 = r26.i();
        if (r27 == null) goto L67;
        r3 = r27;
    L67:
        Na0(r25, r3);
        return;
    L68:
        Context r28 = getContext();
        if (r28 == null) goto L71;
        UDToast.show(r28, 2131887724);
    L71:
        tt5.a.d("ShareFragmentExtend", "copy link fail");
        return;
    L58:
        th = move-exception;
        tt5.a.f("ShareFragmentExtend", th, false);
        goto L60
    L150:
        return;
    L50:
        if (r22.f() != true) goto L52;
    L72:
        com.bytedance.ee.bear.share.export.b r29 = this.B;
        if (r29 != null) goto L75;
    L77:
        if (r6 == true) goto L151;
        int r30 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.a(AppDetail.WeChat, oa0(), this.o);
        ShareType r31 = ShareType.Wechat;
        Context r32 = requireContext();
        com.bytedance.ee.bear.share.export.b r33 = this.B;
        if (r33 == null) goto L85;
        String r34 = r33.i();
        if (r34 == null) goto L85;
        r3 = r34;
    L85:
        km5.c.j(r32, r31, r3, null);
        Qa0(this);
        return;
    L151:
        return;
    L75:
        if (r29.l() != true) goto L77;
        r6 = true;
        goto L77
    L86:
        Ba0();
        com.bytedance.ee.bear.share.export.b r35 = this.B;
        if (r35 != null) goto L89;
    L91:
        if (r6 == false) goto L144;
        Qa0(this);
        return;
    L144:
        return;
    L89:
        if (r35.k(na0()) != true) goto L91;
        r6 = true;
        goto L91
    L93:
        tt5.a.h("ShareFragmentExtend", "onCopyLink()...");
        com.bytedance.ee.bear.share.export.b r36 = this.B;
        if (r36 != null) goto L96;
    L98:
        r7 = false;
    L99:
        if (r7 == true) goto L152;
        com.bytedance.ee.bear.share.export.b r37 = this.B;
        if (r37 == null) goto L104;
        r37.j();
    L104:
        String r38 = Oa0(na0());
        r6 = ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(r38, false, new Token("LARK-PSDA-bitable_share_copy_link_set_clipboard"));     // Catch: Throwable -> L107
    L109:
        if (r6 == false) goto L111;
        Toast.showSuccessText(getContext(), 2131887727);
    L112:
        Qa0(this);
        return;
    L111:
        Toast.showFailureText(getContext(), 2131887724);
    L107:
        th = move-exception;
        tt5.a.f("ShareFragmentExtend", th, false);
        goto L109
    L152:
        return;
    L96:
        if (r36.a() != true) goto L98;
    L113:
        com.bytedance.ee.bear.share.export.b r39 = this.B;
        if (r39 != null) goto L116;
    L118:
        if (r6 == true) goto L153;
        com.bytedance.ee.bear.share.export.b r40 = this.B;
        if (r40 == null) goto L124;
        final String r41 = r40.g();
        if (r41 == null) goto L124;
    L125:
        com.bytedance.ee.bear.share.export.c r42 = this.A;
        if (r42 == null) goto L128;
        r2 = r42.y1();
    L128:
        if (r2 == null) goto L130;
        final FragmentActivity r43 = getActivity();
        final String r44 = na0();
        final int r45 = r2.intValue();
        Flowable.just("").subscribeOn(fo5.d.b()).map(new u()).map(new v(r41, r44, r43, r45)).subscribe(new w(), new x());
    L131:
        Qa0(this);
        return;
    L130:
        y.a(r41, na0());
    L124:
        r41 = oa0().getDocName();
        goto L125
    L153:
        return;
    L116:
        if (r39.d() != true) goto L118;
        r6 = true;
        goto L118
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        com.bytedance.ee.bear.share.export.c r6 = this.A;
        if (r6 == null) goto L6;
        r6.onViewCreated();
    L6:
        if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == false) goto L8;
        int r7 = mm5.c.a;
        mm5.c.a(ta0(), new c(this));
    L8:
        km5.a r8 = ga0();
        View r9 = null;
        boolean r10 = ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).getProvider().b(r8);     // Catch: Throwable -> L11
    L13:
        if (r10 == false) goto L24;
        View r11 = this.y;
        if (r11 != null) goto L20;
        View r12 = getView();
        if (r12 == null) goto L19;
        r9 = r12.findViewById(2131386050);
    L19:
        this.y = (LinearLayout) r9;
        r11 = r9;
    L20:
        ((LinearLayout) r11).setVisibility(8);
        return;
    L24:
        return;
    L11:
        th = move-exception;
        tt5.a.e("ShareFragmentExtend", "hideTopArea failed", th, false);
        r10 = false;
        goto L13
    }
}
