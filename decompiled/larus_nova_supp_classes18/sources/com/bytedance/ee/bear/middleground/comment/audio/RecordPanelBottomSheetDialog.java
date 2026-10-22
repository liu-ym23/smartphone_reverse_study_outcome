package com.bytedance.ee.bear.middleground.comment.audio;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*BP\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0016J\u0006\u0010\"\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R(\u0010%\u001a\u0004\u0018\u00010$2\b\u0010#\u001a\u0004\u0018\u00010$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/audio/RecordPanelBottomSheetDialog;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "context", "Landroid/content/Context;", "width", "", "showCallBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "height", "", "dismissCallBack", "Lkotlin/Function0;", "<init>", "(Landroid/content/Context;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "recordPanelView", "Lcom/bytedance/ee/bear/middleground/comment/audio/RecordPanelView;", "getRecordPanelView", "()Lcom/bytedance/ee/bear/middleground/comment/audio/RecordPanelView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "reset", "value", "Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;", "commentAnalytic", "getCommentAnalytic", "()Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;", "setCommentAnalytic", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;)V", "Companion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordPanelBottomSheetDialog extends BaseAntiScreenshotsDialogFragment {
    public final int h;
    public final Function1<Integer, Unit> i;
    public final Function0<Unit> j;
    public final RecordPanelView k;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnShowListener {
        public final /* synthetic */ Dialog a;
        public final /* synthetic */ RecordPanelBottomSheetDialog b;

        public b(Dialog r1, RecordPanelBottomSheetDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r4) {
            Window r5 = this.a.getWindow();
            if (r5 == null) goto L11;
            View r6 = r5.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L9;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r0 = ThreadMethodProxy.currentThread();
            if (r0 == com.larus.home.impl.utils.c.a) goto L9;
            com.larus.home.impl.utils.c.a(r0, "getDecorView");
        L9:
            if (r6 == null) goto L11;
            int r7 = r6.getHeight();
        L12:
            tt5.a.h("RecordPanelBottomSheetDialog", "onCreateDialog: onShow height " + r7);
            Function1<Integer, Unit> r1 = this.b.i;
            if (r1 == null) goto L16;
            r1.invoke(Integer.valueOf(r7));
            return;
        L16:
            return;
        L11:
            r7 = 0;
            goto L12
        }
    }

    static {
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        int r1 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l.a;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l.d(r0, this.h);
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super/*androidx.fragment.app.DialogFragment*/.onCreateDialog(r2);
        r3.setOnShowListener(new b(r3, this));
        return r3;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L7
        Function0<Unit> r3 = this.j;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.invoke();     // Catch: Throwable -> L7
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

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return this.k;
    }

    public RecordPanelBottomSheetDialog(FragmentActivity r2, int r3, Function1 r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = new RecordPanelView(r2, null, 6, 0);
    }
}
