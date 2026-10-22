package com.bytedance.ee.bear.quoto;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0006\u0010\u001d\u001a\u00020\u0010J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\u0006\u0010\u001f\u001a\u00020\u0010J\b\u0010 \u001a\u00020\u0010H\u0002J\u0006\u0010!\u001a\u00020\u0010J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/quoto/SingleFileExceedQuotaFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "mRootView", "Landroid/view/View;", "mPresenter", "Lcom/bytedance/ee/bear/quoto/SingleFileExceedQuotaPresenter;", "mFileSize", "", "Ljava/lang/Long;", "mQuotaConfig", "Lcom/bytedance/ee/bear/quoto/SingleFileQuotaConfig;", "mNeedReportClose", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "parseArgs", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initMVP", LiveCommonConstants.REASON_ON_DEDTROY, "onClickContactService", "gotoContactService", "onClickLarkCertExplain", "gotoLarkCertExplain", "onClickDissAllowingStateLoss", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "features-quoto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleFileExceedQuotaFragment extends BaseBottomSheetDialogFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f236324p = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f236325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d0 f236326l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Long f236327m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SingleFileQuotaConfig f236328n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f236329o;

    public static final class a {
    }

    static {
    }

    public final void fa0() {
        this.f236329o = false;
        String r100 = jcb.b.c().a("applink");
        if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand() == true) goto L5;
        ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).u5("https://" + r100 + "/TJoXwqd");
    L9:
        da0(this);
        return;
    L5:
        String r101 = "https://" + r100 + "/client/helpdesk/open?id=6626260912531570952&extra=%7B%22channel%22%3A14%2C%22created_at%22%3A1616898084%2C%22human_service%22%3Atrue%2C%22scenario_id%22%3A6888204905589325826%2C%22signature%22%3A%2278b0c5156b727a66d02c9b689ea0785d1a865bb5%22%7D";
        if (((NetService) e0c.k.a(LarkContext.getApplication(), NetService.class)).getEnv() == 1) goto L8;
        r101 = "https://" + r100 + "/client/helpdesk/open?id=6934871265543159828&extra=%7B%22channel%22%3A14%2C%22created_at%22%3A1617246713%2C%22human_service%22%3Atrue%2C%22scenario_id%22%3A6937491551345967123%2C%22signature%22%3A%229df9ed53d1cd7fd62be8055f37ab2f8b8cf71583%22%7D";
    L8:
        ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).u5(r101);
        goto L9
    }

    public SingleFileExceedQuotaFragment() {
        this.f236329o = true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        d0 r100 = this.f236326l;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    public static void da0(SingleFileExceedQuotaFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void ea0(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onDismiss(r100);
        if (this.f236329o == false) goto L14;
        String r101 = null;
        com.bytedance.ee.bear.contract.d r102 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        d0 r103 = this.f236326l;
        if (r103 == null) goto L7;
        String r104 = r103.f236356c;
    L8:
        if (r103 == null) goto L10;
        Boolean r105 = r103.f236357d;
    L11:
        if (r103 == null) goto L13;
        r101 = r103.f236358e;
    L13:
        y.b(r102, r104, r105, r101, "close");
        goto L14
    L10:
        r105 = null;
        goto L11
    L7:
        r104 = null;
    L14:
        FragmentActivity r106 = getActivity();
        if (r106 == null) goto L18;
        r106.finish();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        this.f236327m = Long.valueOf(r101.getLong("key_file_size"));
        this.f236328n = (SingleFileQuotaConfig) r101.getParcelable("key_quota_config");
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        ea0(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        f0 r102 = new f0(this.f236325k, this, getContext(), this.f236328n);
        d0 r103 = new d0(new a0(), r102, this.f236327m);
        this.f236326l = r103;
        r103.create();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.fragment_single_file_quota_layout, r101, true);
        this.f236325k = r103;
        return r103;
    }
}
