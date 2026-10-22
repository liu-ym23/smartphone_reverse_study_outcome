package com.bytedance.ee.bear.document.print;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.document.export.view.FileExportTypeItemView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0012\u001a\u00020\n2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\rJ\u0006\u0010\u0016\u001a\u00020\nJ\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0019H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020\nH\u0016J\u0018\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001bH\u0002J\u0018\u00100\u001a\u00020\n2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u00020\nH\u0002J\b\u00105\u001a\u00020\u0006H\u0002J\b\u00106\u001a\u00020\nH\u0002J\b\u00107\u001a\u00020\nH\u0002R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/document/print/PrintContentOptionDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "optionSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "includeComments", "", "confirmListener", "cancelListener", "Lkotlin/Function0;", "selectedOption", "", "terminalEventDispatched", "restoredFromSavedState", "setListeners", "onOptionSelected", "onConfirm", "onCancel", "clearListeners", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onSaveInstanceState", "outState", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onDestroy", "configurePanel", "panel", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "exportRoot", "resetWindowSize", "activity", "Landroidx/fragment/app/FragmentActivity;", "configuration", "closeAsCancel", "hasListeners", "dispatchConfirm", "dispatchCancel", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrintContentOptionDialogFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int n = 0;
    public Function1<? super Boolean, Unit> h;
    public Function1<? super Boolean, Unit> i;
    public Function0<Unit> j;
    public int k;
    public boolean l;
    public boolean m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PrintContentOptionDialogFragment a;

        public c(PrintContentOptionDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            PrintContentOptionDialogFragment r3 = this.a;
            int r0 = PrintContentOptionDialogFragment.n;
            r3.aa0();
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
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

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ PrintContentOptionDialogFragment a;
        public final /* synthetic */ FileExportTypeItemView b;
        public final /* synthetic */ FileExportTypeItemView c;

        public d(PrintContentOptionDialogFragment r1, FileExportTypeItemView r2, FileExportTypeItemView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            PrintContentOptionDialogFragment r4 = this.a;
            r4.k = 0;
            PrintContentOptionDialogFragment.ba0(this.b, r4, this.c);
            Function1<? super Boolean, Unit> r5 = this.a.h;
            if (r5 == null) goto L6;
            r5.invoke(Boolean.TRUE);
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ PrintContentOptionDialogFragment a;
        public final /* synthetic */ FileExportTypeItemView b;
        public final /* synthetic */ FileExportTypeItemView c;

        public e(PrintContentOptionDialogFragment r1, FileExportTypeItemView r2, FileExportTypeItemView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            PrintContentOptionDialogFragment r4 = this.a;
            r4.k = 1;
            PrintContentOptionDialogFragment.ba0(this.b, r4, this.c);
            Function1<? super Boolean, Unit> r5 = this.a.h;
            if (r5 == null) goto L6;
            r5.invoke(Boolean.FALSE);
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ PrintContentOptionDialogFragment a;

        public f(PrintContentOptionDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            PrintContentOptionDialogFragment r5 = this.a;
            if (r5.l == true) goto L14;
            boolean r0 = true;
            r5.l = true;
            Function1<? super Boolean, Unit> r1 = r5.i;
            r5.h = null;
            r5.i = null;
            r5.j = null;
            PrintContentOptionDialogFragment.Z90(r5);
            if (r1 != null) goto L8;
            return;
        L8:
            if (r5.k == 0) goto L11;
            r0 = false;
        L11:
            r1.invoke(Boolean.valueOf(r0));
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        this.h = null;
        this.i = null;
        this.j = null;
        super.onDestroy();
    }

    public final void aa0() {
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        Function0<Unit> r0 = this.j;
        this.h = null;
        this.i = null;
        this.j = null;
        if (r0 == null) goto L14;
        r0.invoke();     // Catch: RuntimeException -> L9
        return;
    L9:
        e = move-exception;
        tt5.a.l("PrintContentOptionDialog", "dispatch print scope cancellation failed", e);
        return;
    }

    public PrintContentOptionDialogFragment() {
        this.k = 1;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (this.m == true) goto L5;
    L14:
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L26;
        Dialog r2 = getDialog();
        if (r2 == null) goto L25;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L27;
        WindowManager.LayoutParams r4 = r3.getAttributes();
        r4.gravity = 80;
        r4.windowAnimations = 2131951623;
        r4.y = com.bytedance.ee.util.ui.k.e(r0);
        r4.flags |= ShareItemModel.SRC_TINT_UNDEFINED;
        r3.setAttributes(r4);
        ca0(r0, r0.getResources().getConfiguration());
        r3.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L27:
        return;
    L25:
        return;
    L26:
        return;
    L5:
        if (this.h != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L14;
        tt5.a.k("PrintContentOptionDialog", "dismiss restored content option dialog without coordinator");
        this.l = true;
        Z90(this);
        return;
    L7:
        if (this.i == null) goto L11;
        if (this.j == null) goto L11;
        r1 = true;
        goto L12
    }

    public static void Z90(PrintContentOptionDialogFragment r1) {
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

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCancel(r2);
        aa0();
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        ca0(r0, r2);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        int r0 = 0;
        if (r4 == null) goto L5;
        boolean r2 = true;
    L6:
        this.m = r2;
        if (r4 == null) goto L9;
        Integer r5 = Integer.valueOf(r4.getInt("selected_content_option", 1));
    L10:
        if (r5 != null) goto L13;
    L15:
        r0 = 1;
    L16:
        this.k = r0;
        return;
    L13:
        if (r5.intValue() != 0) goto L15;
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        aa0();     // Catch: Throwable -> L5
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

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        r3.putInt("selected_content_option", this.k);
        super.onSaveInstanceState(r3);
    }

    public final void ca0(FragmentActivity r4, Configuration r5) {
        Dialog r0 = getDialog();
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r5.orientation != 2) goto L10;
        int r6 = (int) (com.bytedance.ee.util.ui.n.q(r4) * 0.7f);
    L11:
        r1.setLayout(r6, -1);
        return;
    L10:
        r6 = -1;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        FrameLayout r7 = (FrameLayout) r5.findViewById(2131371974);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(r7);
        CommonActionPanelLayout r0 = r5.findViewById(2131381877);
        r0.setTitle(getString(2131889216));
        r0.setPanelBackgroundColor(2131100558);
        r0.setDividerVisible(false);
        r0.setOnClickListener(b.a);
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNull(r7);
        float r2 = getResources().getDimensionPixelSize(2131165842);
        r0.l(0.0f, r2, r2);
        r0.setOnActionListener(new com.bytedance.ee.bear.document.print.d(this));
        com.bytedance.ee.util.ui.j.c(new com.bytedance.ee.bear.document.print.e(r7, r2, r0));
        r5.setOnClickListener(new c(this));
        FrameLayout r8 = (FrameLayout) r5.findViewById(2131371947);
        View r9 = getLayoutInflater().inflate(2131560125, r8, false);
        r8.addView(r9);
        FileExportTypeItemView r10 = (FileExportTypeItemView) r9.findViewById(2131383025);
        FileExportTypeItemView r1 = (FileExportTypeItemView) r9.findViewById(2131383023);
        r10.a(n.a(2131254241), 2131889208);
        r1.a(n.a(2131254431), 2131889207);
        r10.setTitleMaxLines(2);
        r1.setTitleMaxLines(2);
        r10.setContentDescription(getString(2131889208));
        r1.setContentDescription(getString(2131889207));
        r10.setOnClickListener(new d(this, r10, r1));
        r1.setOnClickListener(new e(this, r10, r1));
        r9.findViewById(2131383022).setOnClickListener(new f(this));
        ba0(r10, this, r1);
    }

    public static final void ba0(FileExportTypeItemView r3, PrintContentOptionDialogFragment r4, FileExportTypeItemView r5) {
        boolean r1 = false;
        if (r4.k != 0) goto L5;
        boolean r0 = true;
    L6:
        r3.setSelected(r0);
        if (r4.k != 1) goto L9;
        r1 = true;
    L9:
        r5.setSelected(r1);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560118, r3, false);
    }
}
