package com.bytedance.awemeopen.apps.framework.feed.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u00035B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/B\u0019\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b.\u00102B!\b\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00103\u001a\u00020\u0002¢\u0006\u0004\b.\u00104R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eRR\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRR\u0010 \u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010$\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\"\u0010+\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00066"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/widget/LiveSkyLightTouchLayout;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getMIN_DISTANCE", "()I", "MIN_DISTANCE", "", "f", "Z", "isSkyLightAnimating", "()Z", "setSkyLightAnimating", "(Z)V", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "dx", "dy", "", RXScreenCaptureService.KEY_INDEX, "Lkotlin/jvm/functions/Function2;", "getCallBack", "()Lkotlin/jvm/functions/Function2;", "setCallBack", "(Lkotlin/jvm/functions/Function2;)V", "callBack", ce.f26395j, "getScrollPredicate", "setScrollPredicate", "scrollPredicate", ce.f26396k, "getNeedIntercept", "setNeedIntercept", "needIntercept", "l", FaceService.girlLabel, "getMagicDy", "()F", "setMagicDy", "(F)V", "magicDy", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class LiveSkyLightTouchLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f196830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f196831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f196832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f196833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f196834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f196835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f196836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f196837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super Float, ? super Float, Unit> f196838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function2<? super Float, ? super Float, Boolean> f196839j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f196840k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f196841l;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSkyLightTouchLayout f196842a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f196842a.getNeedIntercept() == false) goto L9;
            AoLogger.g("LiveSkyLightTouchEventFL", new Object[]{"CheckForLongPress"});     // Catch: Throwable -> L6
            this.f196842a.getCallBack().invoke(Float.valueOf(0.0f), Float.valueOf(0.0f));     // Catch: Throwable -> L6
            return;
        }

        public a(LiveSkyLightTouchLayout r100) {
            this.f196842a = r100;
        }
    }

    public static final class b {
    }

    public static final class c extends Handler {
        public c(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 1) goto L7;
            Object r101 = r100.obj;
            if ((r101 instanceof a) == false) goto L7;
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.widget.LiveSkyLightTouchLayout.CheckForLongPress");
            ((a) r101).run();
            return;
        L7:
            super.handleMessage(r100);
        }
    }

    static {
    }

    public final Function2<Float, Float, Unit> getCallBack() {
        return this.f196838i;
    }

    public final int getMIN_DISTANCE() {
        return this.f196830a;
    }

    public final float getMagicDy() {
        return this.f196841l;
    }

    public final boolean getNeedIntercept() {
        return this.f196840k;
    }

    public final Function2<Float, Float, Boolean> getScrollPredicate() {
        return this.f196839j;
    }

    public LiveSkyLightTouchLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f196830a = x54.a.a(8);
        this.f196837h = new c(Looper.getMainLooper());
        this.f196838i = LiveSkyLightTouchLayout$callBack$1.INSTANCE;
        this.f196839j = LiveSkyLightTouchLayout$scrollPredicate$1.INSTANCE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        float r101 = this.f196841l;
        if (r101 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        if (r100 == null) goto L10;
        r100.offsetLocation(0.0f, r101);
    L10:
        return super.dispatchTouchEvent(r100);
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        super.onInterceptTouchEvent(r100);
        this.f196831b = false;
        int r101 = r100.getAction();
        if (r101 == 0) goto L51;
        if (r101 == 1) goto L39;
        if (r101 == 2) goto L16;
        if (r101 != 3) goto L60;
        if (this.f196837h.hasMessages(1) == false) goto L60;
        if (this.f196836g == null) goto L60;
        this.f196837h.removeMessages(1);
    L60:
        return this.f196831b;
    L16:
        if (this.f196840k == false) goto L18;
    L19:
        float r102 = r100.getX() - this.f196832c;
        float r103 = r100.getY() - this.f196833d;
        if (this.f196835f == false) goto L23;
        this.f196831b = true;
        goto L60
    L23:
        if (Math.abs(r102) > this.f196830a) goto L33;
        if (Math.abs(r103) > this.f196830a) goto L33;
        if ((System.currentTimeMillis() - this.f196834e) <= ViewConfiguration.getDoubleTapTimeout()) goto L60;
        this.f196838i.invoke(Float.valueOf(r102), Float.valueOf(r103));
        this.f196831b = true;
        if (this.f196836g == null) goto L60;
        this.f196837h.removeMessages(1);
    L33:
        if (this.f196839j.invoke(Float.valueOf(r102), Float.valueOf(r103)).booleanValue() == false) goto L36;
        this.f196838i.invoke(Float.valueOf(r102), Float.valueOf(r103));
        this.f196831b = true;
    L36:
        if (this.f196836g == null) goto L60;
        this.f196837h.removeMessages(1);
        goto L60
    L18:
        if (this.f196835f == false) goto L60;
    L39:
        if (this.f196840k == false) goto L46;
        float r104 = r100.getX() - this.f196832c;
        float r105 = r100.getY() - this.f196833d;
        if (Math.abs(r104) >= this.f196830a) goto L46;
        if (Math.abs(r105) >= this.f196830a) goto L46;
        this.f196838i.invoke(Float.valueOf(r104), Float.valueOf(r105));
        this.f196831b = true;
    L46:
        if (this.f196837h.hasMessages(1) == false) goto L60;
        if (this.f196836g == null) goto L60;
        this.f196837h.removeMessages(1);
        goto L60
    L51:
        if (this.f196835f == false) goto L53;
        this.f196831b = true;
    L53:
        this.f196832c = r100.getX();
        this.f196833d = r100.getY();
        this.f196834e = System.currentTimeMillis();
        if (this.f196836g != null) goto L57;
        this.f196836g = new a(this);
    L57:
        if (this.f196837h.hasMessages(1) == true) goto L60;
        this.f196837h.sendMessageDelayed(this.f196837h.obtainMessage(1, this.f196836g), ViewConfiguration.getDoubleTapTimeout());
        goto L60
    }

    public final void setCallBack(Function2<? super Float, ? super Float, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f196838i = r100;
    }

    public final void setMagicDy(float r100) {
        this.f196841l = r100;
    }

    public final void setNeedIntercept(boolean r100) {
        this.f196840k = r100;
    }

    public final void setScrollPredicate(Function2<? super Float, ? super Float, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f196839j = r100;
    }

    public final void setSkyLightAnimating(boolean r100) {
        this.f196835f = r100;
    }

    public LiveSkyLightTouchLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ATTR);
        new LinkedHashMap();
        super(r100, r101);
        this.f196830a = x54.a.a(8);
        this.f196837h = new c(Looper.getMainLooper());
        this.f196838i = LiveSkyLightTouchLayout$callBack$1.INSTANCE;
        this.f196839j = LiveSkyLightTouchLayout$scrollPredicate$1.INSTANCE;
    }

    public LiveSkyLightTouchLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ATTR);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f196830a = x54.a.a(8);
        this.f196837h = new c(Looper.getMainLooper());
        this.f196838i = LiveSkyLightTouchLayout$callBack$1.INSTANCE;
        this.f196839j = LiveSkyLightTouchLayout$scrollPredicate$1.INSTANCE;
    }
}
