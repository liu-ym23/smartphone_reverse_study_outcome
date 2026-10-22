package com.bytedance.ee.bear.bitable.infoarch.block;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.ee.bear.bitable.common.ClearFocusWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J*\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u00172\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J*\u0010&\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u00172\u0006\u0010!\u001a\u00020\u00172\u0006\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020#H\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/block/BaseDrawerContainer;", "Lcom/bytedance/ee/bear/bitable/common/ClearFocusWrapper;", "Landroid/view/GestureDetector$OnGestureListener;", "Lcom/bytedance/ee/bear/bitable/infoarch/block/IDrawerAbility;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "onDrawerFlingListener", "Lcom/bytedance/ee/bear/bitable/infoarch/block/IDrawerAbility$OnDrawerFlingListener;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "onDown", "e", "onShowPress", "", "onSingleTapUp", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onLongPress", "onFling", "velocityX", "velocityY", "setOnFlingListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseDrawerContainer extends ClearFocusWrapper implements GestureDetector.OnGestureListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f213191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f213192c;

    public BaseDrawerContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseDrawerContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return false;
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.f213191b.getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.common.ClearFocusWrapper, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        getGestureDetector().onTouchEvent(r100);
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        getGestureDetector().onTouchEvent(r100);
        return super.onTouchEvent(r100);
    }

    public void setOnFlingListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "onDrawerFlingListener");
        this.f213192c = r100;
    }

    public BaseDrawerContainer(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f213191b = LazyKt.lazy(new BaseDrawerContainer$gestureDetector$2(r100, this));
    }

    public /* synthetic */ BaseDrawerContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        if (r100 != null) goto L7;
        return false;
    L7:
        if (Math.abs(r101.getX() - r100.getX()) <= Math.abs(r101.getY() - r100.getY())) goto L17;
        if (r102 >= 0.0f) goto L13;
        c r104 = this.f213192c;
        if (r104 == null) goto L26;
        r104.a(IDrawerAbility$EFlingDirection.LEFT);
        return true;
    L26:
        return true;
    L13:
        c r105 = this.f213192c;
        if (r105 == null) goto L28;
        r105.a(IDrawerAbility$EFlingDirection.RIGHT);
        return true;
    L28:
        return true;
    L17:
        if (r103 >= 0.0f) goto L21;
        c r106 = this.f213192c;
        if (r106 == null) goto L30;
        r106.a(IDrawerAbility$EFlingDirection.TOP);
        return true;
    L30:
        return true;
    L21:
        c r107 = this.f213192c;
        if (r107 == null) goto L32;
        r107.a(IDrawerAbility$EFlingDirection.DOWN);
        return true;
    L32:
        return true;
    }
}
