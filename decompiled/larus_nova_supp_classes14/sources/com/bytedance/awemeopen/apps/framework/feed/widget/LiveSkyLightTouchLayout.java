package com.bytedance.awemeopen.apps.framework.feed.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u00035B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/B\u0019\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b.\u00102B!\b\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00103\u001a\u00020\u0002¢\u0006\u0004\b.\u00104R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eRR\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRR\u0010 \u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010$\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\"\u0010+\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00066"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/widget/LiveSkyLightTouchLayout;", "Landroid/widget/FrameLayout;", "", "a", "I", "getMIN_DISTANCE", "()I", "MIN_DISTANCE", "", "f", "Z", "isSkyLightAnimating", "()Z", "setSkyLightAnimating", "(Z)V", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "dx", "dy", "", "i", "Lkotlin/jvm/functions/Function2;", "getCallBack", "()Lkotlin/jvm/functions/Function2;", "setCallBack", "(Lkotlin/jvm/functions/Function2;)V", "callBack", "j", "getScrollPredicate", "setScrollPredicate", "scrollPredicate", "k", "getNeedIntercept", "setNeedIntercept", "needIntercept", "l", "F", "getMagicDy", "()F", "setMagicDy", "(F)V", "magicDy", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class LiveSkyLightTouchLayout extends FrameLayout {
    public final int a;
    public boolean b;
    public float c;
    public float d;
    public long e;
    public boolean f;
    public a g;
    public final c h;
    public Function2<? super Float, ? super Float, Unit> i;
    public Function2<? super Float, ? super Float, Boolean> j;
    public boolean k;
    public float l;

    public final class a implements Runnable {
        public final /* synthetic */ LiveSkyLightTouchLayout a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.getNeedIntercept() == false) goto L9;
            AoLogger.g("LiveSkyLightTouchEventFL", new Object[]{"CheckForLongPress"});     // Catch: Throwable -> L6
            this.a.getCallBack().invoke(Float.valueOf(0.0f), Float.valueOf(0.0f));     // Catch: Throwable -> L6
            return;
        }

        public a(LiveSkyLightTouchLayout r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public static final class c extends Handler {
        public c(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            if (r3.what != 1) goto L7;
            Object r0 = r3.obj;
            if ((r0 instanceof a) == false) goto L7;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.widget.LiveSkyLightTouchLayout.CheckForLongPress");
            ((a) r0).run();
            return;
        L7:
            super.handleMessage(r3);
        }
    }

    static {
    }

    public final Function2<Float, Float, Unit> getCallBack() {
        return this.i;
    }

    public final int getMIN_DISTANCE() {
        return this.a;
    }

    public final float getMagicDy() {
        return this.l;
    }

    public final boolean getNeedIntercept() {
        return this.k;
    }

    public final Function2<Float, Float, Boolean> getScrollPredicate() {
        return this.j;
    }

    public LiveSkyLightTouchLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.a = x54.a.a(8);
        this.h = new c(Looper.getMainLooper());
        this.i = LiveSkyLightTouchLayout$callBack$1.INSTANCE;
        this.j = LiveSkyLightTouchLayout$scrollPredicate$1.INSTANCE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        float r0 = this.l;
        if (r0 != 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L10;
        if (r4 == null) goto L10;
        r4.offsetLocation(0.0f, r0);
    L10:
        return super.dispatchTouchEvent(r4);
    L5:
        r2 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        super.onInterceptTouchEvent(r8);
        this.b = false;
        int r0 = r8.getAction();
        if (r0 == 0) goto L51;
        if (r0 == 1) goto L39;
        if (r0 == 2) goto L16;
        if (r0 != 3) goto L60;
        if (this.h.hasMessages(1) == false) goto L60;
        if (this.g == null) goto L60;
        this.h.removeMessages(1);
    L60:
        return this.b;
    L16:
        if (this.k == false) goto L18;
    L19:
        float r1 = r8.getX() - this.c;
        float r9 = r8.getY() - this.d;
        if (this.f == false) goto L23;
        this.b = true;
        goto L60
    L23:
        if (Math.abs(r1) > this.a) goto L33;
        if (Math.abs(r9) > this.a) goto L33;
        if ((System.currentTimeMillis() - this.e) <= ViewConfiguration.getDoubleTapTimeout()) goto L60;
        this.i.invoke(Float.valueOf(r1), Float.valueOf(r9));
        this.b = true;
        if (this.g == null) goto L60;
        this.h.removeMessages(1);
    L33:
        if (((Boolean) this.j.invoke(Float.valueOf(r1), Float.valueOf(r9))).booleanValue() == false) goto L36;
        this.i.invoke(Float.valueOf(r1), Float.valueOf(r9));
        this.b = true;
    L36:
        if (this.g == null) goto L60;
        this.h.removeMessages(1);
        goto L60
    L18:
        if (this.f == false) goto L60;
    L39:
        if (this.k == false) goto L46;
        float r2 = r8.getX() - this.c;
        float r10 = r8.getY() - this.d;
        if (Math.abs(r2) >= this.a) goto L46;
        if (Math.abs(r10) >= this.a) goto L46;
        this.i.invoke(Float.valueOf(r2), Float.valueOf(r10));
        this.b = true;
    L46:
        if (this.h.hasMessages(1) == false) goto L60;
        if (this.g == null) goto L60;
        this.h.removeMessages(1);
        goto L60
    L51:
        if (this.f == false) goto L53;
        this.b = true;
    L53:
        this.c = r8.getX();
        this.d = r8.getY();
        this.e = System.currentTimeMillis();
        if (this.g != null) goto L57;
        this.g = new a(this);
    L57:
        if (this.h.hasMessages(1) == true) goto L60;
        this.h.sendMessageDelayed(this.h.obtainMessage(1, this.g), ViewConfiguration.getDoubleTapTimeout());
        goto L60
    }

    public final void setCallBack(Function2<? super Float, ? super Float, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    public final void setMagicDy(float r1) {
        this.l = r1;
    }

    public final void setNeedIntercept(boolean r1) {
        this.k = r1;
    }

    public final void setScrollPredicate(Function2<? super Float, ? super Float, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.j = r2;
    }

    public final void setSkyLightAnimating(boolean r1) {
        this.f = r1;
    }

    public LiveSkyLightTouchLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attr");
        new LinkedHashMap();
        super(r2, r3);
        this.a = x54.a.a(8);
        this.h = new c(Looper.getMainLooper());
        this.i = LiveSkyLightTouchLayout$callBack$1.INSTANCE;
        this.j = LiveSkyLightTouchLayout$scrollPredicate$1.INSTANCE;
    }

    public LiveSkyLightTouchLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attr");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = x54.a.a(8);
        this.h = new c(Looper.getMainLooper());
        this.i = LiveSkyLightTouchLayout$callBack$1.INSTANCE;
        this.j = LiveSkyLightTouchLayout$scrollPredicate$1.INSTANCE;
    }
}
