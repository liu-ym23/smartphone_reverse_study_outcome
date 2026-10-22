package com.larus.bmhome.chat.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0017R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/map/PoiMapConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/common_ui/widget/ILastMotionView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isIntercept", "", "lastMotionDelegate", "Lcom/larus/common_ui/widget/LastMotionViewDelegate;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "lastMotionX", "", "getLastMotionX", "()Ljava/lang/Float;", "lastMotionY", "getLastMotionY", "onTouchEvent", "event", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PoiMapConstraintLayout extends ConstraintLayout implements z19.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f306877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z19.r f306878b;

    public PoiMapConstraintLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiMapConstraintLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // z19.j
    public Float getLastMotionX() {
        return this.f306878b.f569704a;
    }

    @Override // z19.j
    public Float getLastMotionY() {
        return this.f306878b.f569705b;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f306877a == false) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        this.f306878b.a(r100);
        return super.onTouchEvent(r100);
    }

    public PoiMapConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f306877a = true;
        this.f306878b = new z19.r();
    }

    public /* synthetic */ PoiMapConstraintLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
