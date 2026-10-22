package com.larus.office.plugins.snapshot;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u001a\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0018\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010(\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\b\u0010*\u001a\u00020\u0019H\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/office/plugins/snapshot/DocShotFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mSnapShotView", "Landroid/view/View;", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "snapshotPresenter", "Lcom/larus/office/plugins/snapshot/DocShotPresenter;", "mWebView", "Landroid/webkit/WebView;", "mDocUrl", "", "mListener", "Lcom/larus/office/snapshot/IFlowDocSnapshotResultListener;", "mInputViewHeight", "", "Ljava/lang/Integer;", "mBgDrawable", "Landroid/graphics/drawable/Drawable;", "mJustShowLoading", "", "dismissListener", "Lkotlin/Function0;", "", "setDismissListener", "listener", "setArgs", "activity", "params", "Lcom/larus/office/plugins/snapshot/DocShotParams;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", WidgetCostModule.TYPE_ON_START, "onResume", "onRequestSnapshot", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocShotFragment extends DialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f363470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f363471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WebView f363472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public yo9.a f363473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f363474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f363475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f363476j;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        View r100 = this.f363470d;
        if (r100 == null) goto L11;
        View r101 = r100.findViewById(R.id.doc_screen_shot_view);
        if (r101 == null) goto L12;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L10;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        r103.bottomMargin = u.b(getActivity());
        r101.setLayoutParams(r103);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L12:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        WindowManager.LayoutParams r101 = null;
        if (r100 == null) goto L5;
        Window r102 = r100.getWindow();
    L6:
        if (r102 == null) goto L9;
        r101 = r102.getAttributes();
    L9:
        if (r101 == null) goto L11;
        r101.width = -1;
    L11:
        if (r101 == null) goto L13;
        r101.height = -1;
    L13:
        if (r102 == null) goto L15;
        r102.setAttributes(r101);
    L15:
        if (r102 == null) goto L17;
        r102.addFlags(512);
    L17:
        if (r102 == null) goto L20;
        r102.setBackgroundDrawableResource(android.R.color.transparent);
        return;
    L20:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public DocShotFragment() {
    }

    public final void S90(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        b r101 = this.f363471e;
        if (r101 == null) goto L10;
        FLogger.f375446a.i("DocShotPresenter", "onBackPressed()...");
        WebView r102 = r101.f363483a;
        if (r102 == null) goto L7;
        JSONObject r103 = new JSONObject();
        r103.put("state", 1);
        ap5.a.a(r102, "javascript:window.native.screenshot", r103, null);
        r101.f363483a = r102;
    L7:
        b.InterfaceC4449b r104 = r101.f363484b;
        if (r104 == null) goto L10;
        r104.onBack();
    L10:
        super.onDismiss(r100);
        Function0<Unit> r105 = this.f363476j;
        if (r105 == null) goto L14;
        r105.invoke();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        setStyle(1, R.style.Theme_FlowFullScreenDialog);
        super.onCreate(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        S90(r100);     // Catch: Throwable -> L5
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

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_office_sdk_doc_screen_shot_layout, r101, false);
        this.f363470d = r103;
        if (r103 == null) goto L7;
        View r104 = r103.findViewById(R.id.doc_screen_shot_view);
        if (r104 == null) goto L7;
        r104.setBackground(this.f363474h);
    L7:
        Dialog r105 = getDialog();
        if (r105 == null) goto L13;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L13;
        r106.requestFeature(1);
    L13:
        if (this.f363475i == true) goto L31;
        FLogger r107 = FLogger.f375446a;
        r107.i("DocShotFragment", "onRequestSnapshot()... ");
        FragmentActivity r108 = getActivity();
        if (r108 == null) goto L19;
        Lifecycle r109 = r108.getLifecycle();
        if (r109 == null) goto L19;
        Lifecycle.State r110 = r109.getCurrentState();
    L21:
        if (r110 == Lifecycle.State.RESUMED) goto L23;
        r107.w("DocShotFragment", "onRequestSnapshot, activity is not RESUMED");
        goto L31
    L23:
        FragmentActivity r111 = getActivity();
        if (r111 == null) goto L31;
        b r112 = new b(r111);
        this.f363471e = r112;
        r112.f363484b = new com.larus.office.plugins.snapshot.a(this);
        Intrinsics.checkNotNullParameter(new uo9.a(this), "listener");
        b r113 = this.f363471e;
        if (r113 == null) goto L31;
        WebView r114 = this.f363472f;
        if (r114 == null) goto L31;
        r114.getScrollY();
        JSONObject r115 = new JSONObject();
        r115.put("state", 0);
        ap5.a.a(r114, "javascript:window.native.screenshot", r115, null);
        r113.f363483a = r114;
        r114.scrollTo(0, 0);
    L19:
        r110 = null;
    L31:
        return this.f363470d;
    }
}
