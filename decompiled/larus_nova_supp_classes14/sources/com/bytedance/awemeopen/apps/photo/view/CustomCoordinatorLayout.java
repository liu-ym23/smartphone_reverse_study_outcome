package com.bytedance.awemeopen.apps.photo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/view/CustomCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Lcom/bytedance/awemeopen/apps/photo/view/CustomCoordinatorLayout$b;", "listener", "", "setGestureListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public final class CustomCoordinatorLayout extends CoordinatorLayout {
    public static final /* synthetic */ int d = 0;
    public int a;
    public final GestureDetector b;
    public final GestureDetector c;

    public static final class a {
    }

    public interface b {
    }

    public static final class c extends com.bytedance.awemeopen.apps.framework.feed.pinch.utils.e {
        public final /* synthetic */ CustomCoordinatorLayout a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r1) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r1) {
            return false;
        }

        public c(CustomCoordinatorLayout r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            CustomCoordinatorLayout r3 = this.a;
            int r0 = CustomCoordinatorLayout.d;
            r3.getClass();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
            if (r2 == null) goto L18;
            if (r3 == null) goto L21;
            float r6 = r3.getY() - r2.getY();
            float r7 = r3.getX() - r2.getX();
            if (r6 <= 150.0f) goto L12;
            if ((Math.abs(r7) / r6) >= 1.0f) goto L12;
            CustomCoordinatorLayout r8 = this.a;
            int r9 = CustomCoordinatorLayout.d;
            r8.getClass();
            return true;
        L12:
            if (Math.abs(r6) > 150.0f) goto L14;
            return false;
        L14:
            if ((Math.abs(r7) / Math.abs(r6)) >= 1.0f) goto L20;
            CustomCoordinatorLayout r10 = this.a;
            int r11 = CustomCoordinatorLayout.d;
            r10.getClass();
            return false;
        L20:
            return false;
        L21:
            return false;
        L18:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            CustomCoordinatorLayout r5 = this.a;
            int r6 = CustomCoordinatorLayout.d;
            r5.getClass();
            return false;
        }
    }

    public static final class d extends com.bytedance.awemeopen.apps.framework.feed.pinch.utils.e {
        public final /* synthetic */ CustomCoordinatorLayout a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return false;
        }

        public d(CustomCoordinatorLayout r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
            if (r2 == null) goto L14;
            if (r3 == null) goto L14;
            float r6 = r3.getY() - r2.getY();
            float r7 = r3.getX() - r2.getX();
            if (r7 <= 150.0f) goto L14;
            if (r6 <= (-this.a.a)) goto L14;
            if ((Math.abs(r6) / r7) >= 1.0f) goto L14;
            this.a.getClass();
            return true;
        L14:
            return false;
        }
    }

    static {
    }

    public CustomCoordinatorLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomCoordinatorLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setGestureListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        this.b.onTouchEvent(r3);
        if (this.a >= 0) goto L8;
        this.a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    L8:
        r3.getActionMasked();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r3);
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        return false;
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        if (r2 == null) goto L5;
        this.c.onTouchEvent(r2);
    L5:
        return super.onTouchEvent(r2);
    }

    public CustomCoordinatorLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = -1;
        this.b = new GestureDetector(r2, new c(this));
        this.c = new GestureDetector(r2, new d(this));
    }

    public /* synthetic */ CustomCoordinatorLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
