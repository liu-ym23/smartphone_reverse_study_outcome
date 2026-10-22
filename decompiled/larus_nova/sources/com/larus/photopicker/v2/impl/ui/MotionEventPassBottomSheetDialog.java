package com.larus.photopicker.v2.impl.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.common_ui.view.BottomOverlayView;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MotionEventPassBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "myContext", "Landroid/content/Context;", "theme", "", "<init>", "(Landroid/content/Context;I)V", "bottomSheet", "Landroid/view/View;", "isTouchEventPassedEnable", "", "bottomOverlayView", "Lcom/larus/common_ui/view/BottomOverlayView;", "hostDialogWindow", "Landroid/view/Window;", "setTouchEventPassedEnable", "", "enable", "setBottomOverlayView", "overlayView", "setHostDialogWindow", LiveEndPageData.TAG_WINDOW, "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchOnBottomOverlay", "passTouchEventToUnderlyingView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MotionEventPassBottomSheetDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f364672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f364673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f364674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BottomOverlayView f364675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Window f364676e;

    public static final class a {
    }

    static {
    }

    public MotionEventPassBottomSheetDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "myContext");
        super(r100, R.style.larus_BottomSheetPhotoPickerDialog);
        this.f364672a = r100;
        this.f364674c = true;
    }

    public static View I0(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.f364674c == true) goto L7;
        return super.dispatchTouchEvent(r110);
    L61:
        return false;
    L7:
        if (this.f364673b != null) goto L9;
        this.f364673b = findViewById(R.id.design_bottom_sheet);
    L9:
        View r100 = this.f364673b;
        if (r100 == null) goto L58;
        Rect r101 = new Rect();
        r100.getGlobalVisibleRect(r101);
        boolean r102 = r101.contains((int) r110.getX(), (int) r110.getY());
        BottomOverlayView r103 = this.f364675d;
        boolean r104 = true;
        if (r103 != null) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == false) goto L29;
        Rect r106 = new Rect();
        BottomOverlayView r107 = this.f364675d;
        if (r107 != null) goto L22;
    L24:
        boolean r108 = false;
    L25:
        if (r108 == false) goto L29;
        if (r106.contains((int) r110.getX(), (int) r110.getY()) == false) goto L29;
    L30:
        if (r102 == true) goto L58;
        if (r104 == true) goto L58;
        MotionEvent r109 = MotionEvent.obtain(r110);     // Catch: Exception -> L53
        FLogger r111 = FLogger.f375446a;     // Catch: Exception -> L53
        r111.i("MotionEventPassBottomSheetDialog", "attachdialog passTouchEventToUnderlyingView hostDialogWindow=" + this.f364676e + " event.y=" + r110.getY());     // Catch: Exception -> L53
        Window r112 = this.f364676e;     // Catch: Exception -> L53
        if (r112 == null) goto L36;
        View r113 = I0(r112).getRootView();     // Catch: Exception -> L53
        Rect r114 = new Rect();     // Catch: Exception -> L53
        r113.getGlobalVisibleRect(r114);     // Catch: Exception -> L53
        r109.offsetLocation(-r114.left, -r114.top);     // Catch: Exception -> L53
        r113.dispatchTouchEvent(r109);     // Catch: Exception -> L53
        r109.recycle();     // Catch: Exception -> L53
        r111.i("MotionEventPassBottomSheetDialog", "attachdialog passTouchEventToUnderlyingView hostDialogWindow=" + this.f364676e + " event.y=" + r110.getY() + " pass to hostDialogWindow");     // Catch: Exception -> L53
        goto L50
    L36:
        Context r115 = this.f364672a;     // Catch: Exception -> L53
        if ((r115 instanceof FragmentActivity) == false) goto L39;
        FragmentActivity r116 = (FragmentActivity) r115;     // Catch: Exception -> L53
    L40:
        if (r116 == null) goto L50;
        Window r117 = r116.getWindow();     // Catch: Exception -> L53
        if (r117 == null) goto L50;
        View r118 = I0(r117);     // Catch: Exception -> L53
        if (r118 == null) goto L50;
        View r119 = r118.getRootView();     // Catch: Exception -> L53
        if (r119 == null) goto L50;
        Rect r120 = new Rect();     // Catch: Exception -> L53
        r119.getGlobalVisibleRect(r120);     // Catch: Exception -> L53
        r109.offsetLocation(-r120.left, -r120.top);     // Catch: Exception -> L53
        r119.dispatchTouchEvent(r109);     // Catch: Exception -> L53
        r109.recycle();     // Catch: Exception -> L53
        goto L50
    L39:
        r116 = null;
    L50:
        return false;
    L22:
        if (r107.getGlobalVisibleRect(r106) != true) goto L24;
        r108 = true;
    L29:
        r104 = false;
        goto L30
    L14:
        if (r103.isShown() != true) goto L16;
        r105 = true;
    L58:
        return super.dispatchTouchEvent(r110);
    L62:
        return false;
    }
}
