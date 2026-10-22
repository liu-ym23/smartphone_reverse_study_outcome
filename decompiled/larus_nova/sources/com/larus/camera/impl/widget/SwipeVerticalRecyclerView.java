package com.larus.camera.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/larus/camera/impl/widget/SwipeVerticalRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "swipeListener", "Lcom/larus/camera/impl/widget/OnSwipeListener;", "setOnSwipeListener", "", "listener", "isInMovingMode", "", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "onTouchEvent", "e", "Landroid/view/MotionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwipeVerticalRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f322877d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f322878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f322879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f322880c;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeVerticalRecyclerView f322881a;

        public a(SwipeVerticalRecyclerView r100) {
            this.f322881a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f322881a.f322879b = false;
            return super.onDown(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            if (Math.abs(r103) <= Math.abs(r102)) goto L17;
            SwipeVerticalRecyclerView r104 = this.f322881a;
            if (r104.f322879b == false) goto L7;
        L16:
            return true;
        L7:
            if (r103 <= 20.0f) goto L12;
            r104.f322879b = true;
            p r105 = r104.f322878a;
            if (r105 == null) goto L16;
            r105.a();
            goto L16
        L12:
            if (r103 >= (-20.0f)) goto L16;
            r104.f322879b = true;
            p r106 = r104.f322878a;
            if (r106 == null) goto L16;
            r106.b();
            goto L16
        L17:
            return false;
        }
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.f322880c.getValue();
    }

    public SwipeVerticalRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f322880c = LazyKt.lazy(new u(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        getGestureDetector().onTouchEvent(r100);
        return super.onTouchEvent(r100);
    }

    public final void setOnSwipeListener(p r100) {
        this.f322878a = r100;
    }

    public SwipeVerticalRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f322880c = LazyKt.lazy(new u(this));
    }

    public SwipeVerticalRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f322880c = LazyKt.lazy(new u(this));
    }
}
