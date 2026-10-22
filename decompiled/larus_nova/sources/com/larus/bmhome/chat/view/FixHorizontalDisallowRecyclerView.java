package com.larus.bmhome.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/view/FixHorizontalDisallowRecyclerView;", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startActionDownX", "", "startActionDownY", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FixHorizontalDisallowRecyclerView extends HorizontalOverScrollRV {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f310332i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f310333j;

    public FixHorizontalDisallowRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FixHorizontalDisallowRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L6:
        if (r101 != null) goto L9;
    L11:
        if (r101 != null) goto L14;
    L20:
        return super.dispatchTouchEvent(r100);
    L14:
        if (r101.intValue() != 2) goto L20;
        if (Math.abs(r100.getX() - this.f310332i) <= Math.abs(r100.getY() - this.f310333j)) goto L18;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L20
    L18:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L20
    L9:
        if (r101.intValue() != 0) goto L11;
        this.f310332i = r100.getX();
        this.f310333j = r100.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L20
    L4:
        r101 = null;
        goto L6
    }

    public FixHorizontalDisallowRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ FixHorizontalDisallowRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
