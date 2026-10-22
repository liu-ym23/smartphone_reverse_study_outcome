package com.bytedance.awemeopen.apps.photo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/view/CustomCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Lcom/bytedance/awemeopen/apps/photo/view/CustomCoordinatorLayout$b;", "listener", "", "setGestureListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public final class CustomCoordinatorLayout extends CoordinatorLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f198049d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f198050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GestureDetector f198051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GestureDetector f198052c;

    public static final class a {
    }

    public interface b {
    }

    public static final class c extends com.bytedance.awemeopen.apps.framework.feed.pinch.utils.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomCoordinatorLayout f198053a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            return false;
        }

        public c(CustomCoordinatorLayout r100) {
            this.f198053a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            CustomCoordinatorLayout r101 = this.f198053a;
            int r102 = CustomCoordinatorLayout.f198049d;
            r101.getClass();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            if (r100 == null) goto L18;
            if (r101 == null) goto L21;
            float r104 = r101.getY() - r100.getY();
            float r105 = r101.getX() - r100.getX();
            if (r104 <= 150.0f) goto L12;
            if ((Math.abs(r105) / r104) >= 1.0f) goto L12;
            CustomCoordinatorLayout r106 = this.f198053a;
            int r107 = CustomCoordinatorLayout.f198049d;
            r106.getClass();
            return true;
        L12:
            if (Math.abs(r104) > 150.0f) goto L14;
            return false;
        L14:
            if ((Math.abs(r105) / Math.abs(r104)) >= 1.0f) goto L20;
            CustomCoordinatorLayout r108 = this.f198053a;
            int r109 = CustomCoordinatorLayout.f198049d;
            r108.getClass();
            return false;
        L20:
            return false;
        L21:
            return false;
        L18:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            CustomCoordinatorLayout r104 = this.f198053a;
            int r105 = CustomCoordinatorLayout.f198049d;
            r104.getClass();
            return false;
        }
    }

    public static final class d extends com.bytedance.awemeopen.apps.framework.feed.pinch.utils.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomCoordinatorLayout f198054a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return false;
        }

        public d(CustomCoordinatorLayout r100) {
            this.f198054a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            if (r100 == null) goto L14;
            if (r101 == null) goto L14;
            float r104 = r101.getY() - r100.getY();
            float r105 = r101.getX() - r100.getX();
            if (r105 <= 150.0f) goto L14;
            if (r104 <= (-this.f198054a.f198050a)) goto L14;
            if ((Math.abs(r104) / r105) >= 1.0f) goto L14;
            this.f198054a.getClass();
            return true;
        L14:
            return false;
        }
    }

    static {
    }

    public CustomCoordinatorLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomCoordinatorLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setGestureListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        this.f198051b.onTouchEvent(r100);
        if (this.f198050a >= 0) goto L8;
        this.f198050a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    L8:
        r100.getActionMasked();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        return super.dispatchTouchEvent(r100);
    L11:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L5;
        this.f198052c.onTouchEvent(r100);
    L5:
        return super.onTouchEvent(r100);
    }

    public CustomCoordinatorLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f198050a = -1;
        this.f198051b = new GestureDetector(r100, new c(this));
        this.f198052c = new GestureDetector(r100, new d(this));
    }

    public /* synthetic */ CustomCoordinatorLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
