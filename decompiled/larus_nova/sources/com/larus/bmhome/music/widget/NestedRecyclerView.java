package com.larus.bmhome.music.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.utils.SwipingControlVm;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/music/widget/NestedRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "swipeModel", "Lcom/larus/bmhome/view/utils/SwipingControlVm;", "getSwipeModel", "()Lcom/larus/bmhome/view/utils/SwipingControlVm;", "setSwipeModel", "(Lcom/larus/bmhome/view/utils/SwipingControlVm;)V", "dispatchTouchEvent", "", "e", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SwipingControlVm f313287a;

    public static final class a {
    }

    static {
    }

    public NestedRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NestedRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final SwipingControlVm getSwipeModel() {
        return this.f313287a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("on touch dispatch ");
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.getAction());
    L6:
        r102.append(r103);
        r101.i("NestedRecyclerView", r102.toString());
        boolean r104 = true;
        if (r100 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == true) goto L19;
        if (r100 != null) goto L15;
    L17:
        r104 = false;
    L18:
        if (r104 == true) goto L19;
    L25:
        return super.dispatchTouchEvent(r100);
    L15:
        if (r100.getAction() != 3) goto L17;
    L19:
        SwipingControlVm r106 = this.f313287a;
        if (r106 == null) goto L25;
        MutableSharedFlow<Boolean> r107 = r106.getSwipingControlFlow();
        if (r107 == null) goto L25;
        r107.tryEmit(Boolean.TRUE);
        goto L25
    L9:
        if (r100.getAction() != 1) goto L11;
        r105 = true;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("on touch interception ");
        Integer r103 = null;
        if (r100 == null) goto L5;
        Integer r104 = Integer.valueOf(r100.getAction());
    L6:
        r102.append(r104);
        r101.i("NestedRecyclerView", r102.toString());
        if (r100 == null) goto L9;
        r103 = Integer.valueOf(r100.getAction());
    L9:
        if (r103 != null) goto L12;
    L18:
        if (r103 == null) goto L22;
        r103.intValue();
    L22:
        return super.onInterceptTouchEvent(r100);
    L12:
        if (r103.intValue() != 0) goto L18;
        SwipingControlVm r105 = this.f313287a;
        if (r105 == null) goto L22;
        MutableSharedFlow<Boolean> r106 = r105.getSwipingControlFlow();
        if (r106 == null) goto L22;
        r106.tryEmit(Boolean.FALSE);
        goto L22
    L5:
        r104 = null;
        goto L6
    }

    public final void setSwipeModel(SwipingControlVm r100) {
        this.f313287a = r100;
    }

    public NestedRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = CircleProgressBarView.f328410k;
        addItemDecoration(new SpacesItemDecoration((int) CircleProgressBarView.a.a(r100, 5.0f)));
    }

    public /* synthetic */ NestedRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
