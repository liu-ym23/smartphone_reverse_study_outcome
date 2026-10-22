package com.bytedance.ee.bear.more.fresh;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import ax4.f;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pj5.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\rH\u0016J\u001a\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/more/fresh/ExpiredContentReasonFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "objToken", "", "objType", "", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "docMetaInfo", "Lcom/bytedance/ee/bear/DocMetaInfo;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setOwnerName", "rootView", "onStart", "onViewCreated", "view", "addWatermark", "onDestroy", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpiredContentReasonFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int l = 0;
    public String h;
    public int i;
    public final CompositeDisposable j;
    public DocMetaInfo k;

    public static final class a {
    }

    public static final class b extends t {
        public final /* synthetic */ View c;
        public final /* synthetic */ ExpiredContentReasonFragment d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            rcb.c.d(this.c.findViewById(2131375324));
            this.d.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public b(View r1, ExpiredContentReasonFragment r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ ExpiredContentReasonFragment b;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ View a;
            public final /* synthetic */ ExpiredContentReasonFragment b;

            public a(View r1, ExpiredContentReasonFragment r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r2) {
                Boolean r3 = (Boolean) r2;
                Toast.showSuccessText(eu5.b.a, 2131888845);
                rcb.c.d(this.a.findViewById(2131375324));
                this.b.dismissAllowingStateLoss();     // Catch: Exception -> L5
                return;
            L5:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
                Throwable r4 = DialogFragmentLancet.sLastShowStack;
                if (r4 == null) goto L12;
                com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ ExpiredContentReasonFragment a;
            public final /* synthetic */ View b;

            public b(ExpiredContentReasonFragment r1, View r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r5) {
                if (ax4.d.b((Throwable) r5, 9100) == false) goto L11;
                String r6 = this.a.getString(2131888845);
                Toast.showWarningText(eu5.b.a, r6, 0);
                this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
                return;
            L7:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
                Throwable r7 = DialogFragmentLancet.sLastShowStack;
                if (r7 == null) goto L23;
                com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            L23:
                return;
            L11:
                rcb.c.d(this.b.findViewById(2131375324));
                Toast.showFailureText(eu5.b.a, 2131888843);
                this.a.dismissAllowingStateLoss();     // Catch: Exception -> L14
                return;
            L14:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
                Throwable r8 = DialogFragmentLancet.sLastShowStack;
                if (r8 == null) goto L25;
                com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            }
        }

        public c(View r1, ExpiredContentReasonFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            Object r8 = ((SpaceEditText) this.a.findViewById(2131375324)).getText();
            if (r8 != null) goto L6;
            r8 = "";
        L6:
            ExpiredContentReasonFragment r0 = this.b;
            CompositeDisposable r1 = r0.j;
            int r2 = mj5.b.a;
            String r3 = r0.h;
            int r4 = r0.i;
            String r9 = r8.toString();
            Intrinsics.checkNotNullParameter(r3, "objToken");
            Intrinsics.checkNotNullParameter(r9, "reason");
            NetService r5 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
            NetService.f r6 = new NetService.f("space/api/platform/fresh_status/feedback_expired");
            ((NetService.e) r6).c = 1;
            r6.b(ResourceData.KEY_OBJ_TOKEN, r3);
            r6.b("obj_type", String.valueOf(r4));
            r6.b("feedback_note", r9);
            Flowable r10 = r5.Vc(new f()).a(r6).map(mj5.a.a);
            View r11 = this.a;
            ExpiredContentReasonFragment r12 = this.b;
            r1.add(r10.subscribe(new a(r11, r12), new b(r12, r11)));
        }
    }

    public static final class d extends t {
        public final /* synthetic */ View c;
        public final /* synthetic */ ExpiredContentReasonFragment d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            rcb.c.d(this.c.findViewById(2131375324));
            this.d.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public d(View r1, ExpiredContentReasonFragment r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    static {
    }

    public ExpiredContentReasonFragment() {
        this.h = "";
        this.i = -1;
        this.j = new CompositeDisposable();
        this.k = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.j.clear();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.softInputMode = 16;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r46) {
        super.onCreate(r46);
        Bundle r1 = getArguments();
        if (r1 == null) goto L12;
        this.h = r1.getString("extra_token", "");
        this.i = r1.getInt("extra_type");
        DocMetaInfo r2 = r1.getSerializable("extra_meta");
        if ((r2 instanceof DocMetaInfo) == false) goto L7;
        DocMetaInfo r3 = r2;
    L8:
        if (r3 != null) goto L10;
        r3 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    L10:
        this.k = r3;
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r10, r11);
        ((BaseTitleBar) r10.findViewById(2131388775)).setLeftClickListener(new b(r10, this));
        if (getContext() == null) goto L6;
        String r0 = "@" + this.k.getOwnerName();
        SpannableString r8 = new SpannableString(xo5.a.c(getContext(), 2131888848, "owner", r0));
        int r1 = StringsKt.indexOf$default(r8, r0, 0, false, 6, null);
        r8.setSpan(new n(this), r1, r0.length() + r1, 17);
        ((TextView) r10.findViewById(2131372262)).setText(r8);
        ((TextView) r10.findViewById(2131372262)).setMovementMethod(LinkMovementMethod.getInstance());
    L6:
        ((SpaceEditText) r10.findViewById(2131375324)).setHint(getString(2131888849));
        r10.findViewById(2131369397).setOnClickListener(new c(r10, this));
        ((BaseTitleBar) r10.findViewById(2131388775)).setLeftClickListener(new d(r10, this));
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(this.h, this.i, getDialog());
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561083, r3, false);
    }
}
