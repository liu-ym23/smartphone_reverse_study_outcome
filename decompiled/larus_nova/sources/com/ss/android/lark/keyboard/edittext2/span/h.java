package com.ss.android.lark.keyboard.edittext2.span;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.edittext2.widget.o;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class h extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f429218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f429219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f429220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f429221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f429222e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f429223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f429224b;

        public final void a() {
            this.f429223a.cancelLongPress();
            this.f429224b.b(this.f429223a);
            ViewParent r100 = this.f429223a.getParent();
            if ((r100 instanceof ViewGroup) == false) goto L6;
            long r101 = SystemClock.uptimeMillis();
            MotionEvent r102 = MotionEvent.obtain(r101, r101, 1, 0.0f, 0.0f, 0);
            r102.setSource(4098);
            ((ViewGroup) r100).dispatchTouchEvent(r102);
            r102.recycle();
        L6:
            Log.d("LongClickLinkMovementMethod", "CheckForLongClick: invoke long click");
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

        public a(TextView r100, i r101) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            this.f429223a = r100;
            this.f429224b = r101;
        }
    }

    public static final class b {
    }

    static {
    }

    public h() {
        this.f429221d = new Handler(Looper.getMainLooper());
        this.f429222e = ViewConfiguration.getLongPressTimeout() - ViewConfiguration.getTapTimeout();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.widget.o, android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r110, Spannable r111, MotionEvent r112) {
        if (r112 == null) goto L40;
        if (r110 == null) goto L40;
        if (r111 == null) goto L40;
        int r100 = r112.getActionMasked();
        float r101 = r112.getX();
        float r102 = r112.getY();
        float r103 = r101 - r110.getTotalPaddingLeft();
        float r104 = r102 - r110.getTotalPaddingTop();
        float r105 = r103 + r110.getScrollX();
        float r106 = r104 + r110.getScrollY();
        Layout r107 = r110.getLayout();
        int r108 = r107.getOffsetForHorizontal(r107.getLineForVertical((int) r106), r105);
        i[] r109 = (i[]) r111.getSpans(r108, r108, i.class);
        boolean r113 = false;
        if (r109 != null) goto L9;
    L15:
        boolean r114 = true;
    L16:
        if (r114 == true) goto L18;
        i r115 = r109[0];
        Log.d("LongClickLinkMovementMethod", "onTouchEvent: action is " + r100);
        if (r100 == 0) goto L36;
        if (r100 != 1) goto L23;
        Log.d("LongClickLinkMovementMethod", "onTouchEvent: MotionEvent.ACTION_UP");
        if ((System.currentTimeMillis() - this.f429218a) >= this.f429222e) goto L38;
        this.f429221d.removeMessages(65297);
    L38:
        return super.onTouchEvent(r110, r111, r112);
    L23:
        if (r100 != 2) goto L25;
        Log.d("LongClickLinkMovementMethod", "onTouchEvent: MotionEvent.ACTION_MOVE");
        int r116 = ViewConfiguration.get(r110.getContext()).getScaledTouchSlop();
        double r117 = 2;
        if ((((float) Math.pow(r105 - this.f429219b, r117)) + ((float) Math.pow(r106 - this.f429220c, r117))) <= (r116 * r116)) goto L31;
        r113 = true;
    L31:
        if (r113 == false) goto L38;
        this.f429221d.removeMessages(65297);
        goto L38
    L25:
        if (r100 != 3) goto L38;
        Log.d("LongClickLinkMovementMethod", "onTouchEvent: MotionEvent.ACTION_CANCEL");
        this.f429221d.removeMessages(65297);
        goto L38
    L36:
        Log.d("LongClickLinkMovementMethod", "onTouchEvent: MotionEvent.ACTION_DOWN, handler. handler contains pending msg:" + this.f429221d.hasMessages(65297));
        this.f429221d.removeMessages(65297);
        Handler r118 = this.f429221d;
        Intrinsics.checkNotNull(r115);
        Message r119 = Message.obtain(r118, new a(r110, r115));
        r119.what = 65297;
        StringBuilder r120 = new StringBuilder("handler#sendDelay, delayed ");
        r120.append(this.f429222e);
        Log.d("LongClickLinkMovementMethod", r120.toString());
        this.f429221d.sendMessageDelayed(r119, this.f429222e);
        this.f429218a = System.currentTimeMillis();
        this.f429219b = r105;
        this.f429220c = r106;
        goto L38
    L18:
        return super.onTouchEvent(r110, r111, r112);
    L9:
        if (r109.length != 0) goto L11;
        boolean r121 = true;
    L12:
        if (r121 == true) goto L15;
        r114 = false;
        goto L16
    L11:
        r121 = false;
    L40:
        return super.onTouchEvent(r110, r111, r112);
    }
}
