package com.bytedance.ee.bear.lynx.api;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH$J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH$J\b\u0010\u0010\u001a\u00020\u0011H$J\b\u0010\u0012\u001a\u00020\u0011H$J\b\u0010\u0013\u001a\u00020\u0011H$J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u001a\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0003H\u0002R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/lynx/api/BaseLynxDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment;", "logTag", "", "<init>", "(Ljava/lang/String;)V", "value", "Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView;", "lynxView", "getLynxView", "()Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView;", "getLynxViewType", "", "getLynxViewInitParams", "", "", "onLynxViewCreated", "", "onLynxViewAdded", "onLynxViewDestroyed", "getLynxViewLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onCancel", "onDestroy", "createLynxView", "rootView", "destroyLynxView", "fromFunction", "features-lynx-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseLynxDialogFragment extends BaseUDBottomSheetDialogFragment {
    public CCMLynxCardView t;

    public abstract Map<String, Object> sa0();

    public abstract int ua0();

    public abstract void va0();

    public abstract void wa0();

    public abstract void xa0();

    public final void onDestroyView() {
        ra0("onDestroyView");
        super.onDestroyView();
    }

    public ViewGroup.LayoutParams ta0() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i(((BaseUDBottomSheetDialogFragment) this).k, "onDestroy");
        ra0("onDestroy");
    }

    public BaseLynxDialogFragment(String r2) {
        Intrinsics.checkNotNullParameter(r2, "logTag");
        super(r2);
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        ra0("onCancel");
        super.onCancel(r2);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        ra0("onDismiss");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
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

    public final void ra0(String r4) {
        Log.i(((BaseUDBottomSheetDialogFragment) this).k, "destroyLynxView(" + r4 + "), lynxView: " + this.t);
        CCMLynxCardView r5 = this.t;
        if (r5 == null) goto L6;
        r5.destroy();
        this.t = null;
        xa0();
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        FrameLayout r6 = fa0();
        if (r6 == null) goto L8;
        Log.w(((BaseUDBottomSheetDialogFragment) this).k, "onViewCreated, createLynxView");
        CCMLynxCardView r7 = this.t;
        if (r7 == null) goto L7;
        r7.destroy();
    L7:
        CCMLynxCardView r8 = (CCMLynxCardView) org.koin.java.a.b(CCMLynxCardView.class, null, new BaseLynxDialogFragment$createLynxView$newLynxView$1(this));
        this.t = r8;
        wa0();
        CCMLynxCardView.a.a(r8, r6, ua0(), sa0(), ta0());
        va0();
        Log.i(((BaseUDBottomSheetDialogFragment) this).k, "createLynxView, lynxView: " + this.t);
        return;
    L8:
        Log.w(((BaseUDBottomSheetDialogFragment) this).k, "onViewCreated, contentContainer is null.");
    }
}
