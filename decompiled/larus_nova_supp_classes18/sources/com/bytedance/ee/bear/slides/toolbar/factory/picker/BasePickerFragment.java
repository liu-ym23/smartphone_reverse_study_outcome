package com.bytedance.ee.bear.slides.toolbar.factory.picker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 62\u00020\u0001:\u000267B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH$J\b\u0010\u001f\u001a\u00020\u001dH\u0004J\u0012\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020$H\u0002J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u001bH\u0016J\u0006\u0010.\u001a\u00020\u001bJ\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u0005H\u0004J\b\u00101\u001a\u00020\u001bH\u0002J\u000e\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u0013J\u000e\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u00020\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0005X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/BasePickerFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseDialogFragment;", "<init>", "()V", "contentLayoutId", "", "getContentLayoutId", "()I", "dialogStyle", "getDialogStyle", "heightOffset", "getHeightOffset", "setHeightOffset", "(I)V", "resultKey", "", "getResultKey", "()Ljava/lang/String;", "itemClickListener", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/BasePickerFragment$OnItemClickListener;", "getItemClickListener", "()Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/BasePickerFragment$OnItemClickListener;", "setItemClickListener", "(Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/BasePickerFragment$OnItemClickListener;)V", "onBackPressCallBack", "Landroidx/activity/OnBackPressedCallback;", "setupContentView", "", "view", "Landroid/view/View;", "onBackPressedCallback", "getContentView", "setArguments", "args", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "onStart", "onStop", "configureDialogWindow", "dialog", "onAttach", "context", "Landroid/content/Context;", "onDetach", "exit", "removeSelfFromFragmentManager", "animExit", "close", "setOnItemClickListener", "listener", "setPanelHeightOffset", "toolBarHeight", "Companion", "OnItemClickListener", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BasePickerFragment extends BaseDialogFragment {
    public final int h;
    public int i;

    public static final class a {
    }

    static {
    }

    public abstract int ca0();

    public abstract String da0();

    public abstract void fa0(View r1);

    public BasePickerFragment() {
        this.h = 2131953786;
        this.i = n.d(125);
    }

    public final void ba0() {
        FragmentKt.setFragmentResult(this, da0(), new Bundle());
        FragmentTransaction r0 = getParentFragmentManager().beginTransaction();
        r0.setCustomAnimations(0, 2130772180);
        r0.remove(this).commitAllowingStateLoss();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L10;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        if (r2 == null) goto L12;
        r2.gravity = 80;
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    public final void ea0(int r3) {
        tt5.a.h("BasePickerFragment", "setHeightOffset() called with: toolBarHeight = " + r3);
        this.i = r3 + n.d(10);
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.DialogFragment*/.onAttach(r2);
    }

    public final Dialog onCreateDialog(Bundle r7) {
        setStyle(0, this.h);
        Dialog r8 = super/*androidx.fragment.app.DialogFragment*/.onCreateDialog(r7);
        r8.requestWindowFeature(1);
        ViewGroup r4 = null;
        View r2 = View.inflate(getActivity(), ca0(), null);
        Intrinsics.checkNotNull(r2);
        fa0(r2);
        ViewParent r3 = r2.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L5;
        r4 = (ViewGroup) r3;
    L5:
        if (r4 == null) goto L7;
        r4.removeAllViews();
    L7:
        r8.setContentView(r2);
        if (r8.getWindow() == null) goto L23;
        Window r5 = r8.getWindow();
        if (r5 == null) goto L23;
        WindowManager.LayoutParams r6 = r5.getAttributes();
        if (r6 == null) goto L23;
        r6.type = CCMLynxCardView.ViewType.BANNER;
        r6.width = -1;
        r6.softInputMode = 1;
        r6.flags = (r6.flags & (-3)) | 8;
        r6.gravity = 80;
        r6.height = pcb.a.a.b(getActivity()).keyBoardRawHeight() + this.i;
        Window r0 = r8.getWindow();
        if (r0 == null) goto L17;
        r0.setAttributes(r6);
    L17:
        Window r1 = r8.getWindow();
        if (r1 == null) goto L20;
        r1.setBackgroundDrawableResource(R.color.transparent);
    L20:
        r8.setCanceledOnTouchOutside(false);
        Window r9 = r8.getWindow();
        if (r9 == null) goto L23;
        r9.setWindowAnimations(2131953778);
    L23:
        return r8;
    }

    public final void setArguments(Bundle r1) {
        super/*androidx.fragment.app.Fragment*/.setArguments(r1);
    }
}
