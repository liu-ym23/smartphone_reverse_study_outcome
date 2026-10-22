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
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.document.export.view.FileExportTypeItemView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0012\u001a\u00020\n2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\rJ\u0006\u0010\u0016\u001a\u00020\nJ\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0019H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020\nH\u0016J\u0018\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001bH\u0002J\u0018\u00100\u001a\u00020\n2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u00020\nH\u0002J\b\u00105\u001a\u00020\u0006H\u0002J\b\u00106\u001a\u00020\nH\u0002J\b\u00107\u001a\u00020\nH\u0002R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/document/print/PrintContentOptionDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "optionSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "includeComments", "", "confirmListener", "cancelListener", "Lkotlin/Function0;", "selectedOption", "", "terminalEventDispatched", "restoredFromSavedState", "setListeners", "onOptionSelected", "onConfirm", "onCancel", "clearListeners", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", WidgetCostModule.TYPE_ON_START, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onSaveInstanceState", "outState", "dialog", "Landroid/content/DialogInterface;", "onDismiss", LiveCommonConstants.REASON_ON_DEDTROY, "configurePanel", "panel", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "exportRoot", "resetWindowSize", "activity", "Landroidx/fragment/app/FragmentActivity;", "configuration", "closeAsCancel", "hasListeners", "dispatchConfirm", "dispatchCancel", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrintContentOptionDialogFragment extends BaseAntiScreenshotsDialogFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f221079n = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f221080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f221081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f221082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f221083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f221084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f221085m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f221086a = null;

        static {
            f221086a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrintContentOptionDialogFragment f221087a;

        public c(PrintContentOptionDialogFragment r100) {
            this.f221087a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            PrintContentOptionDialogFragment r101 = this.f221087a;
            int r102 = PrintContentOptionDialogFragment.f221079n;
            r101.aa0();
            this.f221087a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r103 = DialogFragmentLancet.sLastShowStack;
            if (r103 == null) goto L12;
            com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrintContentOptionDialogFragment f221088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FileExportTypeItemView f221089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FileExportTypeItemView f221090c;

        public d(PrintContentOptionDialogFragment r100, FileExportTypeItemView r101, FileExportTypeItemView r102) {
            this.f221088a = r100;
            this.f221089b = r101;
            this.f221090c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            PrintContentOptionDialogFragment r101 = this.f221088a;
            r101.f221083k = 0;
            PrintContentOptionDialogFragment.ba0(this.f221089b, r101, this.f221090c);
            Function1<? super Boolean, Unit> r102 = this.f221088a.f221080h;
            if (r102 == null) goto L6;
            r102.invoke(Boolean.TRUE);
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrintContentOptionDialogFragment f221091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FileExportTypeItemView f221092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FileExportTypeItemView f221093c;

        public e(PrintContentOptionDialogFragment r100, FileExportTypeItemView r101, FileExportTypeItemView r102) {
            this.f221091a = r100;
            this.f221092b = r101;
            this.f221093c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            PrintContentOptionDialogFragment r101 = this.f221091a;
            r101.f221083k = 1;
            PrintContentOptionDialogFragment.ba0(this.f221092b, r101, this.f221093c);
            Function1<? super Boolean, Unit> r102 = this.f221091a.f221080h;
            if (r102 == null) goto L6;
            r102.invoke(Boolean.FALSE);
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrintContentOptionDialogFragment f221094a;

        public f(PrintContentOptionDialogFragment r100) {
            this.f221094a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            PrintContentOptionDialogFragment r101 = this.f221094a;
            if (r101.f221084l == true) goto L14;
            boolean r102 = true;
            r101.f221084l = true;
            Function1<? super Boolean, Unit> r103 = r101.f221081i;
            r101.f221080h = null;
            r101.f221081i = null;
            r101.f221082j = null;
            PrintContentOptionDialogFragment.Z90(r101);
            if (r103 != null) goto L8;
            return;
        L8:
            if (r101.f221083k == 0) goto L11;
            r102 = false;
        L11:
            r103.invoke(Boolean.valueOf(r102));
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.f221080h = null;
        this.f221081i = null;
        this.f221082j = null;
        super.onDestroy();
    }

    public final void aa0() {
        if (this.f221084l == false) goto L5;
        return;
    L5:
        this.f221084l = true;
        Function0<Unit> r100 = this.f221082j;
        this.f221080h = null;
        this.f221081i = null;
        this.f221082j = null;
        if (r100 == null) goto L14;
        r100.invoke();     // Catch: RuntimeException -> L9
        return;
    L9:
        e = move-exception;
        tt5.a.l("PrintContentOptionDialog", "dispatch print scope cancellation failed", e);
        return;
    }

    public PrintContentOptionDialogFragment() {
        this.f221083k = 1;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (this.f221085m == true) goto L5;
    L14:
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L26;
        Dialog r101 = getDialog();
        if (r101 == null) goto L25;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L27;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.gravity = 80;
        r103.windowAnimations = R.style.ActionSheetWindowStyle;
        r103.y = com.bytedance.ee.util.ui.k.e(r100);
        r103.flags |= Integer.MIN_VALUE;
        r102.setAttributes(r103);
        ca0(r100, r100.getResources().getConfiguration());
        r102.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L27:
        return;
    L25:
        return;
    L26:
        return;
    L5:
        if (this.f221080h != null) goto L7;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L14;
        tt5.a.k("PrintContentOptionDialog", "dismiss restored content option dialog without coordinator");
        this.f221084l = true;
        Z90(this);
        return;
    L7:
        if (this.f221081i == null) goto L11;
        if (this.f221082j == null) goto L11;
        r104 = true;
        goto L12
    }

    public static void Z90(PrintContentOptionDialogFragment r100) {
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

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCancel(r100);
        aa0();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        FragmentActivity r101 = getActivity();
        if (r101 != null) goto L5;
        return;
    L5:
        ca0(r101, r100);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        int r101 = 0;
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        this.f221085m = r102;
        if (r100 == null) goto L9;
        Integer r103 = Integer.valueOf(r100.getInt("selected_content_option", 1));
    L10:
        if (r103 != null) goto L13;
    L15:
        r101 = 1;
    L16:
        this.f221083k = r101;
        return;
    L13:
        if (r103.intValue() != 0) goto L15;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        r100.putInt("selected_content_option", this.f221083k);
        super.onSaveInstanceState(r100);
    }

    public final void ca0(FragmentActivity r100, Configuration r101) {
        Dialog r102 = getDialog();
        if (r102 == null) goto L13;
        Window r103 = r102.getWindow();
        if (r103 != null) goto L8;
        return;
    L8:
        if (r101.orientation != 2) goto L10;
        int r104 = (int) (com.bytedance.ee.util.ui.n.q(r100) * 0.7f);
    L11:
        r103.setLayout(r104, -1);
        return;
    L10:
        r104 = -1;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FrameLayout r102 = (FrameLayout) r100.findViewById(R.id.export_root);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(r102);
        CommonActionPanelLayout r103 = (CommonActionPanelLayout) r100.findViewById(R.id.panel_layout);
        r103.setTitle(getString(R.string.LarkCCM_Docs_Print_PrintRange_Title));
        r103.setPanelBackgroundColor(R.color.bg_float_base);
        r103.setDividerVisible(false);
        r103.setOnClickListener(b.f221086a);
        Intrinsics.checkNotNull(r103);
        Intrinsics.checkNotNull(r102);
        float r104 = getResources().getDimensionPixelSize(R.dimen.document_export_default_height);
        r103.l(0.0f, r104, r104);
        r103.setOnActionListener(new com.bytedance.ee.bear.document.print.d(this));
        com.bytedance.ee.util.ui.j.c(new com.bytedance.ee.bear.document.print.e(r102, r104, r103));
        r100.setOnClickListener(new c(this));
        FrameLayout r105 = (FrameLayout) r100.findViewById(R.id.export_container);
        View r106 = getLayoutInflater().inflate(R.layout.document_print_content_options, r105, false);
        r105.addView(r106);
        FileExportTypeItemView r107 = (FileExportTypeItemView) r106.findViewById(R.id.print_content_with_comments);
        FileExportTypeItemView r108 = (FileExportTypeItemView) r106.findViewById(R.id.print_content_document_only);
        r107.a(n.a(R.drawable.ud_icon_doc_comment_colorful), R.string.LarkCCM_Docs_Print_DocumentWithComments_Option);
        r108.a(n.a(R.drawable.ud_icon_file_doc_colorful), R.string.LarkCCM_Docs_Print_DocumentOnly_Option);
        r107.setTitleMaxLines(2);
        r108.setTitleMaxLines(2);
        r107.setContentDescription(getString(R.string.LarkCCM_Docs_Print_DocumentWithComments_Option));
        r108.setContentDescription(getString(R.string.LarkCCM_Docs_Print_DocumentOnly_Option));
        r107.setOnClickListener(new d(this, r107, r108));
        r108.setOnClickListener(new e(this, r107, r108));
        r106.findViewById(R.id.print_content_confirm_button).setOnClickListener(new f(this));
        ba0(r107, this, r108);
    }

    public static final void ba0(FileExportTypeItemView r100, PrintContentOptionDialogFragment r101, FileExportTypeItemView r102) {
        boolean r103 = false;
        if (r101.f221083k != 0) goto L5;
        boolean r104 = true;
    L6:
        r100.setSelected(r104);
        if (r101.f221083k != 1) goto L9;
        r103 = true;
    L9:
        r102.setSelected(r103);
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.document_export_dialog_fragment, r101, false);
    }
}
