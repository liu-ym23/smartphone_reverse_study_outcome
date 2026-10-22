package com.bytedance.ies.bullet.service.popup.ui.primary;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.crash.d;
import com.bytedance.ies.bullet.service.popup.ui.AbsPopupDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/primary/PrimaryDialog;", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupDialog;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public class PrimaryDialog extends AbsPopupDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f248029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Rect f248030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final GestureDetector f248031i;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrimaryDialog f248032a;

        public a(PrimaryDialog r100) {
            this.f248032a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if (this.f248032a.f248030h.contains((int) r100.getRawX(), (int) r100.getRawY()) == true) goto L31;
            Function0<Boolean> r101 = this.f248032a.f247982b;
            if (r101 == null) goto L31;
            if (r101 != null) goto L9;
        L11:
            boolean r102 = false;
        L12:
            if (r102 == false) goto L31;
            PrimaryDialog r103 = this.f248032a;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L16;
        L18:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L21 Exception -> L23
        L27:
            DialogLancet.afterDialogDismiss(r103);
        L28:
            return true;
        L21:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L23:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
            if (r105 == null) goto L27;
            d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
            goto L27
        L16:
            if (Looper.myLooper() == r104.getLooper()) goto L18;
            r104.post(DialogLancet.createDismissRunnable(r103));
            goto L28
        L9:
            if (r101.invoke().booleanValue() != true) goto L11;
            r102 = true;
        L31:
            return false;
        }
    }

    public PrimaryDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.Dialog_Immersive_NoAnim);
        this.f248030h = new Rect();
        this.f248031i = new GestureDetector(r100, new a(this));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f248029g != null) goto L5;
        this.f248029g = findViewById(R.id.bullet_popup_round);
    L5:
        View r101 = this.f248029g;
        if (r101 == null) goto L8;
        int[] r102 = {(int) r101.getX(), (int) r101.getY()};
        r101.getLocationOnScreen(r102);
        int r103 = r102[0];
        Rect r104 = new Rect(r103, r102[1], r101.getWidth() + r103, r102[1] + r101.getHeight());
    L9:
        if (r104 != null) goto L13;
        return super.dispatchTouchEvent(r100);
    L13:
        if (r100.getActionMasked() != 0) goto L16;
        this.f248030h = r104;
    L16:
        if (r104.contains((int) r100.getRawX(), (int) r100.getRawY()) == true) goto L23;
        if (this.f247981a == false) goto L23;
        Activity r105 = getOwnerActivity();
        if (r105 == null) goto L23;
        r105.dispatchTouchEvent(r100);
    L23:
        if (this.f248031i.onTouchEvent(r100) == false) goto L25;
        return true;
    L25:
        if (super.dispatchTouchEvent(r100) == true) goto L30;
        return false;
    L30:
        return true;
    L8:
        r104 = null;
        goto L9
    }
}
