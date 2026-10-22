package com.bytedance.ee.bear.quoto;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/quoto/FullQuotoDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "config", "Lcom/bytedance/ee/bear/quoto/FullQuotoConfig;", "onDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "cancelable", "", "<init>", "(Lcom/bytedance/ee/bear/quoto/FullQuotoConfig;Landroid/content/DialogInterface$OnDismissListener;Z)V", "getConfig", "()Lcom/bytedance/ee/bear/quoto/FullQuotoConfig;", "getOnDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "getCancelable", "()Z", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "gotoContactService", "", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStart", "Companion", "features-quoto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullQuotoDialogFragment extends BaseBottomSheetDialogFragment {
    public static long n;
    public static final /* synthetic */ int o = 0;
    public final FullQuotoConfig k;
    public final DialogInterface.OnDismissListener l;
    public final boolean m;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.quoto.FullQuotoDialogFragment$a$a, reason: collision with other inner class name */
        public static final class RunnableC0137a implements Runnable {
            public final /* synthetic */ FullQuotoConfig a;
            public final /* synthetic */ DialogInterface.OnDismissListener b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ FragmentActivity d;

            public RunnableC0137a(FullQuotoConfig r1, DialogInterface.OnDismissListener r2, boolean r3, FragmentActivity r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void a() {
                FullQuotoDialogFragment r0 = new FullQuotoDialogFragment(this.a, this.b, this.c);
                FragmentManager r1 = this.d.getSupportFragmentManager();
                LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
                LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "FullQuotoDialogFragment", r2);
                if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r0, r2) == true) goto L11;
                DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
            L6:
                r0.show(r1, "FullQuotoDialogFragment");
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @JvmStatic
        public static void a(FragmentActivity r6, FullQuotoConfig r7, boolean r8, DialogInterface.OnDismissListener r9) {
            Intrinsics.checkNotNullParameter(r6, "activity");
            Intrinsics.checkNotNullParameter(r7, "config");
            tt5.a.h("FullQuotoDialogFragment", "show config == " + r7.name());
            Lifecycle.State r0 = r6.getLifecycle().getCurrentState();
            tt5.a.h("FullQuotoDialogFragment", "currentState +=" + r0);
            if (r0.isAtLeast(Lifecycle.State.RESUMED) == true) goto L6;
            return;
        L6:
            if ((System.currentTimeMillis() - FullQuotoDialogFragment.n) > BaseKeyboardHeightProducer.CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL) goto L10;
            tt5.a.h("FullQuotoDialogFragment", "return by deconded");
            return;
        L10:
            if (r6.getSupportFragmentManager().findFragmentByTag("FullQuotoDialogFragment") != null) goto L12;
            FullQuotoDialogFragment.n = System.currentTimeMillis();
            Map r1 = MapsKt.mutableMapOf(new Pair[]{new Pair("function_type", r7.getReportType())});
            r1.put("admin_flag", ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).G2().isSuperAdmin + "");
            r1.put("target", "none");
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("common_pricing_popup_view", r1);
            com.bytedance.ee.util.ui.j.f(new RunnableC0137a(r7, r9, r8, r6));
            return;
        L12:
            tt5.a.h("FullQuotoDialogFragment", "already has fragment");
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ FullQuotoDialogFragment a;

        public b(FullQuotoDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            FullQuotoConfig r7 = this.a.k;
            boolean r0 = false;
            if (r7 != null) goto L5;
        L7:
            if (r0 == false) goto L20;
            this.a.getClass();
            String r8 = jcb.b.c().a("applink");
            String r1 = "https://" + r8 + "/client/helpdesk/open?id=6626260912531570952&extra=%7B%22channel%22%3A14%2C%22created_at%22%3A1616898084%2C%22human_service%22%3Atrue%2C%22scenario_id%22%3A6888204905589325826%2C%22signature%22%3A%2278b0c5156b727a66d02c9b689ea0785d1a865bb5%22%7D";
            if (((NetService) e0c.k.a(LarkContext.getApplication(), NetService.class)).getEnv() == 1) goto L11;
            r1 = "https://" + r8 + "/client/helpdesk/open?id=6934871265543159828&extra=%7B%22channel%22%3A14%2C%22created_at%22%3A1617246713%2C%22human_service%22%3Atrue%2C%22scenario_id%22%3A6937491551345967123%2C%22signature%22%3A%229df9ed53d1cd7fd62be8055f37ab2f8b8cf71583%22%7D";
        L11:
            ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).u5(r1);
        L20:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L15
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r9 = DialogFragmentLancet.sLastShowStack;
            if (r9 == null) goto L22;
            com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L22:
            return;
        L5:
            if (r7.getGotoContactService() != true) goto L7;
            r0 = true;
            goto L7
        }
    }

    static {
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        if (this.k == null) goto L5;
        super.onStart();
    L5:
        Dialog r0 = getDialog();
        if (r0 == null) goto L15;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L15;
        View r2 = r1.findViewById(2131368870);
        if (r2 == null) goto L15;
        TextView r3 = new TextView(r2.getContext());
        FullQuotoConfig r4 = this.k;
        Intrinsics.checkNotNull(r4);
        r3.setText(r4.getSubTitleId());
        int r5 = cu5.c.d() - y9c.d.a(32);
        r3.measure(View.MeasureSpec.makeMeasureSpec(r5, 1073741824), View.MeasureSpec.makeMeasureSpec(r5, Integer.MIN_VALUE));
        int r6 = r3.getLineCount();
        int r7 = 348;
        if (r6 <= 2) goto L14;
        r7 = 348 + ((r6 - 2) * 20);
    L14:
        ViewGroup.LayoutParams r8 = r2.getLayoutParams();
        r8.height = cu5.c.b(r7);
    L15:
        Dialog r9 = getDialog();
        if (r9 == null) goto L18;
        r9.setCanceledOnTouchOutside(this.m);
    L18:
        Dialog r10 = getDialog();
        if (r10 == null) goto L21;
        r10.setCancelable(this.m);
    L21:
        setCancelable(this.m);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        DialogInterface.OnDismissListener r0 = this.l;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.onDismiss(r2);     // Catch: Throwable -> L7
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

    public FullQuotoDialogFragment(FullQuotoConfig r1, DialogInterface.OnDismissListener r2, boolean r3) {
        this.k = r1;
        this.l = r2;
        this.m = r3;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        int r0 = 0;
        View r7 = r4.inflate(2131561259, r5, false);
        FullQuotoConfig r8 = this.k;
        if (r8 == null) goto L5;
        ((ImageView) r7.findViewById(2131382374)).setImageResource(r8.getPlaceHolderId());
        ((TextView) r7.findViewById(2131379424)).setText(r8.getMainTitleId());
        ((TextView) r7.findViewById(2131387517)).setText(r8.getSubTitleId());
        ((TextView) r7.findViewById(2131369396)).setText(r8.getButtonStringId());
    L5:
        r7.findViewById(2131369396).setOnClickListener(new b(this));
        View r9 = r7.findViewById(2131370202);
        if (this.m == true) goto L9;
        r0 = 8;
    L9:
        r9.setVisibility(r0);
        return r7;
    }
}
