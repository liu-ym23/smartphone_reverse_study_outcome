package com.bytedance.ee.bear.middleground.permission.secret;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0002J&\u0010+\u001a\u0004\u0018\u00010\u00172\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0016\u00102\u001a\u00020\u00192\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b04H\u0002J\u0010\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u000207H\u0002J\u0012\u00108\u001a\u00020\u00192\b\u00109\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u001bH\u0002J\u0010\u0010<\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u001bH\u0002J\u0010\u0010=\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u001bH\u0002J(\u0010>\u001a\u00020\u00192\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001b0?j\b\u0012\u0004\u0012\u00020\u001b`@2\u0006\u00101\u001a\u00020\u0017H\u0002J\u0012\u0010A\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0010\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u0017H\u0002J\u0018\u0010F\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\rH\u0002J\b\u0010H\u001a\u00020\u0019H\u0002J\b\u0010I\u001a\u00020\u0005H\u0002J\n\u0010J\u001a\u0004\u0018\u00010KH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b\u001e\u0010\u001f¨\u0006M"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/SecretLevelFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "meta", "Lcom/bytedance/ee/bear/DocMetaInfo;", WikiFolderPushPlugin.WIKI_TOKEN, "inSourceFrom", "canModifyLevel", "", "isSecurityDemotion", "isSingleApply", "adapter", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretLevelAdapter;", "getAdapter", "()Lcom/bytedance/ee/bear/middleground/permission/secret/SecretLevelAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "helpDocView", "Landroid/view/View;", "setDoneBtn", "", "it", "Lcom/bytedance/ee/bear/secret/SecretLevel;", "viewModel", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/middleground/permission/secret/SecretViewModel;", "viewModel$delegate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "isSupportScreenLandscape", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initPeekHeight", "handleFetchSecretLive", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "updateOldSecretLevel", "allSecretLevels", "", "buildRightAction", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setHelpDocLink", "helpDocLink", "needShowSecretDialog", "selected", "handleLowerApply", "handleLowerApplyV2", "updateAdapter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportView", "secretApprovalModel", "Lcom/bytedance/ee/bear/middleground/permission/secret/model/SecretApprovalModel;", "showLoading", "root", "hideLoading", "success", "addWatermark", "getSecurityType", "getUserFgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecretLevelFragment extends BaseBottomSheetDialogFragment {
    public static final /* synthetic */ int v = 0;
    public String k;
    public int l;
    public DocMetaInfo m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public boolean r;
    public final Lazy s;
    public View t;
    public final Lazy u;

    public static final class a {
    }

    public static final class b extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ SecretLevelFragment c;

        public b(SecretLevelFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r9) {
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            SecretLevelFragment r10 = this.c;
            com.bytedance.ee.bear.middleground.permission.c.R(DocFeed$Value$Result.CANCEL, "none", "", r10.q, r10.r, r10.o, SecretLevelFragment.ea0(r10));
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r11 = DialogFragmentLancet.sLastShowStack;
            if (r11 == null) goto L9;
            com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ SecretLevelFragment a;
        public final /* synthetic */ View b;

        public c(SecretLevelFragment r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            VisibleSecretResult r5 = (VisibleSecretResult) r4;
            if (r5 == null) goto L7;
            SecretLevelFragment.ia0(this.a, (ArrayList) ((Result) r5).data, this.b);
            SecretLevelFragment.ha0(this.a, r5.getHelpDocLink());
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ SecretLevelFragment a;
        public final /* synthetic */ View b;

        public d(SecretLevelFragment r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r20) {
            di5.a r1 = (di5.a) r20;
            if (r1 == null) goto L61;
            boolean r2 = r1.a;
            if (r2 == true) goto L8;
            SecretLevelFragment.ia0(this.a, new ArrayList(), this.b);
            return;
        L8:
            if (r2 == false) goto L48;
            SecretLevelFragment r3 = this.a;
            int r4 = SecretLevelFragment.v;
            SecretLevelAdapter r5 = r3.ja0();
            SecretApprovalInstanceModel r6 = r1.c;
            y r7 = new y(this.a);
            r5.getClass();
            Intrinsics.checkNotNullParameter(r7, "call");
            if (r6 == null) goto L12;
            r5.e = r6;
        L13:
            r5.f = r7;
            SecretLevelFragment r8 = this.a;
            boolean r9 = true;
            String r10 = "none";
            if (r8.m.getGetSecLabelCode() != 1) goto L16;
        L26:
            String r11 = "acquisition_failed";
        L27:
            ArrayList<SecretApprovalInstanceModel.Instance> r12 = r1.c.getInstances();
            if (r12 != null) goto L30;
        L33:
            boolean r13 = true;
        L34:
            boolean r14 = !r13;
            r8.q = r14;
            if (r14 == false) goto L44;
            HashMap r15 = new HashMap();
            Iterator<T> r16 = r1.c.getInstances().iterator();
            boolean r17 = true;
        L38:
            if (r16.hasNext() == false) goto L43;
            SecretApprovalInstanceModel.Instance r18 = (SecretApprovalInstanceModel.Instance) r16.next();
            if (r15.containsKey(r18.getApply_sec_label_id()) == true) goto L41;
            r15.put(r18.getApply_sec_label_id(), 1);
            goto L38
        L41:
            r17 = false;
            goto L38
        L43:
            r9 = r17;
        L44:
            r8.r = r9;
            boolean r19 = r8.q;
            String r21 = r8.o;
            String r22 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r11, "securityType");
            Intrinsics.checkNotNullParameter(r21, "view_from");
            JSONObject r110 = new JSONObject();
            String r111 = com.bytedance.ee.bear.middleground.permission.c.f;
            int r112 = com.bytedance.ee.bear.middleground.permission.c.g;
            if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L47;
            r10 = ThumbGlideUrl.SOURCE_VC;
        L47:
            com.bytedance.ee.bear.middleground.permission.c.a(r110, r111, r112, r10, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
            r110.put("security_type", r11);
            r110.put("is_security_demotion", r19);
            r110.put("is_single_apply", r9);
            r110.put("view_from", r21);
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_security_setting_view", r110);
            goto L48
        L30:
            if (r12.isEmpty() == true) goto L33;
            r13 = false;
            goto L34
        L16:
            if (r8.m.getGetSecLabelCode() == 2) goto L26;
            if (r8.m.getGetSecLabelCode() != 0) goto L25;
            SecretLevel r23 = r8.m.getSecretLevel();
            if (r23 == null) goto L23;
            String r24 = r23.getId();
        L24:
            r11 = du5.b.g(r24);
            goto L27
        L23:
            r24 = null;
            goto L24
        L25:
            r11 = "none";
            goto L27
        L12:
            SecretApprovalInstanceModel r25 = new SecretApprovalInstanceModel();
            r5.e = r25;
            r25.setSuccess(false);
        L48:
            SecretLevelFragment.ia0(this.a, (ArrayList) r1.d.getData(), this.b);
            SecretLevelFragment r26 = this.a;
            VisibleSecretResult r27 = r1.d;
            if (r27 == null) goto L51;
            String r28 = r27.getHelpDocLink();
        L52:
            SecretLevelFragment.ha0(r26, r28);
            return;
        L51:
            r28 = null;
            goto L52
        }
    }

    public static final class e extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ SecretLevelFragment c;

        public e(SecretLevelFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r9) {
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            SecretLevelFragment r10 = this.c;
            com.bytedance.ee.bear.middleground.permission.c.R(DocFeed$Value$Result.CANCEL, "none", "", r10.q, r10.r, r10.o, SecretLevelFragment.ea0(r10));
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r11 = DialogFragmentLancet.sLastShowStack;
            if (r11 == null) goto L9;
            com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public static final class f extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ SecretLevelFragment c;
        public final /* synthetic */ View d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L6;
            Toast.showFailureText(this.c.getContext(), this.c.getString(2131887782), 0);
            return;
        L6:
            SecretLevelFragment r4 = this.c;
            View r0 = this.d;
            int r1 = SecretLevelFragment.v;
            r4.getClass();
            SecretLevelFragment.pa0(r0);
            this.c.la0();
        }

        public f(SecretLevelFragment r1, View r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ SecretLevelFragment a;

        public g(SecretLevelFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((UpdateSecretLevelResult) r2).getSuccess() == false) goto L11;
            Toast.showSuccessText(this.a.getContext(), 2131889256);
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L15;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L15:
            return;
        L11:
            Toast.showFailureText(this.a.getContext(), 2131887364);
        }
    }

    static {
    }

    public SecretLevelFragment() {
        this.k = "";
        this.l = sbb.e.g.b;
        this.m = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
        this.n = "";
        this.o = "";
        this.r = true;
        this.s = LazyKt.lazy(new SecretLevelFragment$adapter$2(this));
        this.u = LazyKt.lazy(new SecretLevelFragment$viewModel$2(this));
    }

    public final SecretLevelAdapter ja0() {
        return (SecretLevelAdapter) this.s.getValue();
    }

    public final SecretViewModel ka0() {
        return (SecretViewModel) this.u.getValue();
    }

    public final void la0() {
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.permisson.degrade_approval") == true) goto L5;
    L7:
        ka0().fetchVisibleSecretLive(this.k, this.l);
        return;
    L5:
        if (this.p == false) goto L7;
        ka0().fetchApprovalSecretLive(this.k, this.l);
    }

    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    public final void na0() {
        Dialog r0 = getDialog();     // Catch: Throwable -> L11
        if (r0 == null) goto L17;
        Window r1 = r0.getWindow();     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        View r2 = r1.getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r3 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r3 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");     // Catch: Throwable -> L11
    L13:
        if (r2 == null) goto L17;
        FrameLayout r4 = (FrameLayout) r2.findViewById(2131368870);     // Catch: Throwable -> L11
        if (r4 == null) goto L17;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();     // Catch: Throwable -> L11
    L19:
        if ((r5 instanceof CoordinatorLayout.LayoutParams) == false) goto L27;
        BottomSheetBehavior r6 = ((CoordinatorLayout.LayoutParams) r5).getBehavior();     // Catch: Throwable -> L11
        if ((r6 instanceof BottomSheetBehavior) == false) goto L27;
        if (com.bytedance.ee.util.ui.n.D(getActivity()) == false) goto L25;
        r6.setPeekHeight((int) (((double) com.bytedance.ee.util.ui.n.p(getActivity())) * 0.5d));     // Catch: Throwable -> L11
        goto L27
    L25:
        r6.setPeekHeight((int) (((double) com.bytedance.ee.util.ui.n.p(getActivity())) * 1.0d));     // Catch: Throwable -> L11
    L27:
        if (ForsetiHelper.s(this) == false) goto L34;
        ForsetiHelper.w(getActivity(), 0.9f);     // Catch: Throwable -> L11
        return;
    L34:
        return;
    L17:
        r5 = null;
    L11:
        th = move-exception;
        tt5.a.e("SecretFragment", "init peek height", th, false);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        na0();
    }

    public static void da0(SecretLevelFragment r1) {
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

    public static final String ea0(SecretLevelFragment r2) {
        if (r2.m.getGetSecLabelCode() != 1) goto L5;
    L15:
        return "acquisition_failed";
    L5:
        if (r2.m.getGetSecLabelCode() == 2) goto L15;
        if (TextUtils.isEmpty(r2.m.getSecretLevel().getId()) == true) goto L14;
        SecretLevel r3 = r2.m.getSecretLevel();
        if (r3 == null) goto L12;
        String r4 = r3.getId();
    L17:
        return du5.b.g(r4);
    L12:
        r4 = null;
        goto L17
    L14:
        return "none";
    }

    public static void pa0(View r3) {
        ((FrameLayout) r3.findViewById(2131387253)).setVisibility(0);
        r3.findViewById(2131378988).setVisibility(0);
        r3.findViewById(2131378988).playAnimation();
        ((LinearLayout) r3.findViewById(2131378979)).setVisibility(8);
        r3.findViewById(2131384071).setVisibility(8);
        ((LinearLayout) r3.findViewById(2131364623)).setVisibility(8);
        ((RelativeLayout) r3.findViewById(2131385707)).setVisibility(8);
    }

    public final void oa0(SecretLevel r5) {
        UDButton r3 = null;
        if (this.m.getSecretLevel().isValid() == true) goto L5;
    L19:
        View r6 = getView();
        if (r6 == null) goto L22;
        r3 = r6.findViewById(2131369397);
    L22:
        if (r3 == null) goto L27;
        r3.setText(2131889945);
        return;
    L27:
        return;
    L5:
        if (this.m.isSecretAdminDefault() == false) goto L19;
        if (Intrinsics.areEqual(this.m.getSecretLevel().getId(), r5.getId()) == false) goto L19;
        View r7 = getView();
        if (r7 == null) goto L11;
        UDButton r8 = r7.findViewById(2131369397);
    L12:
        if (r8 == null) goto L14;
        r8.setText(2131889945);
    L14:
        View r9 = getView();
        if (r9 == null) goto L17;
        r3 = r9.findViewById(2131369397);
    L17:
        if (r3 == null) goto L25;
        r3.setEnabled(true);
        return;
    L25:
        return;
    L11:
        r8 = null;
        goto L12
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        na0();
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L6;
        this.k = r5.getString("extra_token", "");
        this.l = r5.getInt("extra_type");
        this.n = r5.getString("extra_wiki_token", "");
        DocMetaInfo r0 = r5.getSerializable("extra_meta");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.DocMetaInfo");
        this.m = r0;
        this.o = r5.getString("extra_from", "");
        this.p = r5.getBoolean("extra_canModifyLevel", false);
        la0();
        return;
    }

    public static final void fa0(SecretLevelFragment r15, SecretLevel r16) {
        if (r15.ka0().getSecretModelData().getValue() == null) goto L30;
        Object r1 = r15.ka0().getSecretModelData().getValue();
        Intrinsics.checkNotNull(r1);
        boolean r2 = false;
        if (((di5.a) r1).c.getMy_instance() == null) goto L7;
        boolean r7 = true;
    L8:
        Object r3 = r15.ka0().getSecretModelData().getValue();
        Intrinsics.checkNotNull(r3);
        SecretApprovalInstanceModel r4 = ((di5.a) r3).c;
        Object r5 = r15.ka0().getSecretModelData().getValue();
        Intrinsics.checkNotNull(r5);
        SecretReviewModel r6 = b0.e(r4, r16, ((di5.a) r5).b, r15.m.getSecretLevel());
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        Object r9 = r15.ka0().getSecretModelData().getValue();
        Intrinsics.checkNotNull(r9);
        r8.element = ((di5.a) r9).b;
        if (r6 != null) goto L11;
    L13:
        boolean r10 = false;
    L14:
        if (r10 == false) goto L16;
        int r11 = InputReasonFragment.B;
        InputReasonFragment.a.a(r15.requireActivity(), r15.k, r15.l, r16.getId(), r16.getName(), r16.getLevel(), r16.getApplyTips(), r15.n, r15.m.getSecretLevel(), (SecretApprovalDefModel) r8.element, false, null, r16);
        da0(r15);
        return;
    L16:
        if (r6 != null) goto L18;
    L20:
        boolean r12 = false;
    L21:
        if (r12 == false) goto L23;
        int r13 = ReSubmitApplyDialog.a;
        ReSubmitApplyDialog.d(r15.requireActivity(), new u(r15, r16, r8), null, false, r15.l, 28);
        return;
    L23:
        if (r6 != null) goto L25;
    L27:
        if (r2 == false) goto L29;
        int r14 = ReSubmitApplyDialog.a;
        ReSubmitApplyDialog.d(r15.requireActivity(), new v(r15, r16, r8), r6, r7, r15.l, 4);
        return;
    L29:
        int r17 = InputReasonFragment.B;
        InputReasonFragment.a.a(r15.requireActivity(), r15.k, r15.l, r16.getId(), r16.getName(), r16.getLevel(), r16.getApplyTips(), r15.n, r15.m.getSecretLevel(), null, false, null, r16);
        da0(r15);
        return;
    L25:
        if (r6.getState() != 2) goto L27;
        r2 = true;
        goto L27
    L18:
        if (r6.getState() != 1) goto L20;
        r12 = true;
        goto L21
    L11:
        if (r6.getState() != 3) goto L13;
        r10 = true;
        goto L14
    L7:
        r7 = false;
        goto L8
    L30:
        int r18 = InputReasonFragment.B;
        InputReasonFragment.a.a(r15.requireActivity(), r15.k, r15.l, r16.getId(), r16.getName(), r16.getLevel(), r16.getApplyTips(), r15.n, r15.m.getSecretLevel(), null, false, null, r16);
        da0(r15);
    }

    public static final void ga0(SecretLevelFragment r15, SecretLevel r16) {
        di5.a r1 = (di5.a) r15.ka0().getSecretModelData().getValue();
        if (r1 == null) goto L39;
        boolean r3 = false;
        if (r1.c.getMy_instance() == null) goto L7;
        boolean r8 = true;
    L8:
        SecretReviewModel r7 = b0.e(r1.c, r16, r1.b, r15.m.getSecretLevel());
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        SecretApprovalDefModel r5 = r1.b;
        r2.element = r5;
        if (r7 == null) goto L11;
        ArrayList<SecretApprovalDefModel.Reviewer> r6 = r5.getReviewers();
        if (r6 != null) goto L17;
    L20:
        boolean r9 = true;
    L21:
        if (r9 == false) goto L29;
        ArrayList<SecretApprovalDefModel.Reviewer> r4 = r1.b.getCcUsers();
        if (r4 != null) goto L25;
    L26:
        r3 = true;
    L27:
        if (r3 == true) goto L29;
        int r10 = InputReasonFragment.B;
        InputReasonFragment.a.a(r15.requireActivity(), r15.k, r15.l, r16.getId(), r16.getName(), r16.getLevel(), r16.getApplyTips(), r15.n, r15.m.getSecretLevel(), (SecretApprovalDefModel) r2.element, false, null, r16);
        da0(r15);
        return;
    L25:
        if (r4.isEmpty() == false) goto L27;
    L29:
        int r11 = r7.getState();
        if (r11 != 1) goto L32;
        int r12 = ReSubmitApplyDialog.a;
        ReSubmitApplyDialog.d(r15.requireActivity(), new w(r15, r16, r2), null, false, r15.l, 28);
        return;
    L32:
        if (r11 != 2) goto L34;
        int r13 = ReSubmitApplyDialog.a;
        ReSubmitApplyDialog.d(r15.requireActivity(), new x(r15, r16, r2), r7, r8, r15.l, 4);
        return;
    L34:
        if (r11 == 3) goto L36;
        int r14 = InputReasonFragment.B;
        InputReasonFragment.a.a(r15.requireActivity(), r15.k, r15.l, r16.getId(), r16.getName(), r16.getLevel(), r16.getApplyTips(), r15.n, r15.m.getSecretLevel(), null, false, null, r16);
        da0(r15);
        return;
    L36:
        int r17 = InputReasonFragment.B;
        InputReasonFragment.a.a(r15.requireActivity(), r15.k, r15.l, r16.getId(), r16.getName(), r16.getLevel(), r16.getApplyTips(), r15.n, r15.m.getSecretLevel(), (SecretApprovalDefModel) r2.element, false, null, r16);
        da0(r15);
        return;
    L17:
        if (r6.isEmpty() == true) goto L20;
        r9 = false;
        goto L21
    L11:
        if (r1.d.getMustNeedDowngradeReason() == false) goto L13;
        int r18 = InputReasonFragment.B;
        InputReasonFragment.a.a(r15.requireActivity(), r15.k, r15.l, r16.getId(), r16.getName(), r16.getLevel(), r16.getApplyTips(), r15.n, r15.m.getSecretLevel(), null, false, null, r16);
        da0(r15);
        return;
    L13:
        int r19 = InputReasonFragment.B;
        InputReasonFragment.a.a(r15.requireActivity(), r15.k, r15.l, r16.getId(), r16.getName(), r16.getLevel(), r16.getApplyTips(), r15.n, r15.m.getSecretLevel(), null, true, null, r16);
        da0(r15);
        return;
    L7:
        r8 = false;
        goto L8
    L39:
        int r20 = InputReasonFragment.B;
        InputReasonFragment.a.a(r15.requireActivity(), r15.k, r15.l, r16.getId(), r16.getName(), r16.getLevel(), r16.getApplyTips(), r15.n, r15.m.getSecretLevel(), null, false, null, r16);
        da0(r15);
    }

    public static final void ha0(SecretLevelFragment r3, String r4) {
        View r0 = r3.t;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r4 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        r0.setOnClickListener(null);
        r0.setVisibility(8);
        return;
    L14:
        r0.setOnClickListener(new z(r3, r4));
        r0.setVisibility(0);
        return;
    L8:
        if (r4.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public final void ma0(View r7, boolean r8) {
        int r2 = 8;
        r7.findViewById(2131378988).setVisibility(8);
        r7.findViewById(2131378988).cancelAnimation();
        FrameLayout r0 = (FrameLayout) r7.findViewById(2131387253);
        if (r8 == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        LinearLayout r1 = (LinearLayout) r7.findViewById(2131378979);
        if (r8 == false) goto L9;
        int r4 = 8;
    L10:
        r1.setVisibility(r4);
        RecyclerView r5 = r7.findViewById(2131384071);
        if (r8 == false) goto L13;
        int r6 = 0;
    L14:
        r5.setVisibility(r6);
        if (r8 == true) goto L17;
    L21:
        ((LinearLayout) r7.findViewById(2131364623)).setVisibility(8);
    L22:
        RelativeLayout r9 = (RelativeLayout) r7.findViewById(2131385707);
        if (r8 == false) goto L25;
        r2 = 0;
    L25:
        r9.setVisibility(r2);
        return;
    L17:
        if (this.p == false) goto L21;
        ((LinearLayout) r7.findViewById(2131364623)).setVisibility(0);
        ViewGroup.LayoutParams r10 = ((LinearLayout) r7.findViewById(2131364623)).getLayoutParams();
        if ((r10 instanceof LinearLayout.LayoutParams) == false) goto L22;
        int r11 = com.bytedance.ee.util.ui.n.d(24);
        ((LinearLayout.LayoutParams) r10).topMargin = r11;
        ((LinearLayout) r7.findViewById(2131364623)).setLayoutParams(r10);
        goto L22
    L13:
        r6 = 8;
        goto L14
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r6, r7);
        if (ForsetiHelper.s(this) == false) goto L9;
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        if (r8 == null) goto L8;
        r8.height = -1;
        r6.setLayoutParams(r8);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L9:
        pa0(r6);
        ((BaseTitleBar) r6.findViewById(2131388775)).setLeftClickListener(new b(this));
        BaseTitleBar r0 = (BaseTitleBar) r6.findViewById(2131388775);
        int r1 = a0.a;
        r0.setTitle(a0.a(this.l, 2131888864, 2131887381));
        View r9 = ((BaseTitleBar) r6.findViewById(2131388775)).a(new BaseTitleBar.c(com.bytedance.ee.util.ui.l.a(getContext(), 2131255085, 2131108729)), true);
        this.t = r9;
        if (r9 == null) goto L12;
        r9.setVisibility(8);
    L12:
        r6.findViewById(2131385708).setVisibility(8);
        r6.findViewById(2131363912).setVisibility(8);
        if (fj5.a.e(this.m) == false) goto L22;
        r6.findViewById(2131385708).setVisibility(0);
        AppCompatTextView r10 = r6.findViewById(2131385708);
        Context r2 = getContext();
        if (r2 == null) goto L17;
        String r3 = r2.getString(a0.a(this.l, 2131888883, 2131889917));
    L18:
        if (r3 != null) goto L20;
        r3 = "";
    L20:
        r10.setText(r3);
    L26:
        r6.findViewById(2131384071).setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        r6.findViewById(2131384071).setAdapter(ja0());
        SecretLevelAdapter r11 = ja0();
        String r4 = this.m.getDefaultSecretLabelId();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r4, "defaultSecretLabelId");
        r11.d = r4;
        ka0().getSecretLiveData().observe(this, new c(this, r6));
        ka0().getSecretModelData().observe(this, new d(this, r6));
        r6.findViewById(2131365115).setOnClickListener(new e(this));
        r6.findViewById(2131369397).setOnClickListener(new AnonymousClass6(this));
        ((LinearLayout) r6.findViewById(2131378979)).setOnClickListener(new f(this, r6));
        ((RelativeLayout) r6.findViewById(2131385707)).setOnClickListener(new AnonymousClass8(this));
        ka0().getUpdateSecLiveData().observe(this, new g(this));
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(this.k, this.l, getDialog());
        oa0(this.m.getSecretLevel());
        return;
    L17:
        r3 = null;
        goto L18
    L22:
        if (this.m.isSecCreateFail() == false) goto L26;
        if (this.m.isVisibleSecList() == false) goto L26;
        r6.findViewById(2131363912).setVisibility(0);
        r6.findViewById(2131363912).setText(2131887382);
        goto L26
    }

    public static final void ia0(SecretLevelFragment r5, ArrayList r6, View r7) {
        r5.getClass();
        boolean r1 = false;
        if (r6.isEmpty() == false) goto L9;
        r5.ma0(r7, false);
        if (r5.m.isNoSec() == true) goto L7;
        return;
    L7:
        if (r5.m.isVisibleSecList() == false) goto L43;
        r7.findViewById(2131363912).setVisibility(8);
        r7.findViewById(2131385708).setVisibility(8);
        return;
    L43:
        return;
    L9:
        r5.ma0(r7, true);
        if (r5.m.getSecretLevel().isValid() == false) goto L17;
        Iterator r8 = r6.iterator();
    L13:
        if (r8.hasNext() == false) goto L17;
        SecretLevel r2 = (SecretLevel) r8.next();
        if (Intrinsics.areEqual(r2.getId(), r5.m.getSecretLevel().getId()) == false) goto L13;
        r2.setSelected(true);
    L17:
        Iterator r9 = r6.iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        ((SecretLevel) r9.next()).setCanModify(r5.p);
        goto L19
    L21:
        SecretLevelAdapter r10 = r5.ja0();
        r10.setNewData(r6);
        if (125 == r5.l) goto L34;
        FragmentActivity r11 = r5.getActivity();
        if (r11 == null) goto L28;
        Application r12 = r11.getApplication();
        if (r12 == null) goto L28;
        com.bytedance.ee.bear.appsetting.c.a.a.getClass();
        UserSession r3 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r12, com.ss.android.lark.passportc.convention.a.class)).b();
        jdb.g r13 = ((dn4.a) e0c.k.b(((com.ss.android.lark.passportc.internal.v) e0c.k.a(r12, com.ss.android.lark.passportc.internal.v.class)).c(r3), dn4.a.class)).a();
    L29:
        if (r13 == null) goto L31;
        boolean r14 = r13.isEnable("ccm.permission.secret_level_searchable_tip");
    L32:
        if (r14 == false) goto L34;
        r1 = true;
        goto L34
    L31:
        r14 = false;
    L28:
        r13 = null;
    L34:
        r10.c = r1;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564174, r3, false);
    }
}
