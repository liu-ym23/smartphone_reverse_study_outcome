package com.bytedance.android.ui.base.widget.viewflipper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u00011\b\u0007\u0018\u00002\u00020\u0001:\u0005FGHIJB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00106\u001a\u00020!2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u0014H\u0014J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0007H\u0016J\u0016\u0010<\u001a\u00020\u00142\f\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010>H\u0016J\u0012\u0010?\u001a\u00020\u00142\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u000e\u0010B\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u001aJ\u0010\u0010C\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0007H\u0016J\u0006\u0010D\u001a\u00020\u0014J\u0006\u0010E\u001a\u00020\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0004\n\u0002\u00102R$\u00103\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u0011¨\u0006K"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "countDownHandler", "Landroid/os/Handler;", "currentPos", "getCurrentPos", "()I", "value", "currentPosInternal", "setCurrentPosInternal", "(I)V", "endCallback", "Lkotlin/Function0;", "", "getEndCallback", "()Lkotlin/jvm/functions/Function0;", "setEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "flipperAdapter", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperAdapter;", "interval", "", "getInterval", "()J", "setInterval", "(J)V", "", "isInfinity", "()Z", "setInfinity", "(Z)V", "isRunning", "needKeepLastView", "getNeedKeepLastView", "setNeedKeepLastView", "positionChangeListener", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$IOnPositionChangeListener;", "getPositionChangeListener", "()Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$IOnPositionChangeListener;", "setPositionChangeListener", "(Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$IOnPositionChangeListener;)V", "runnable", "com/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$runnable$1", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$runnable$1;", "scrollSpeed", "getScrollSpeed", "setScrollSpeed", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "scrollToPosition", "position", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setLayoutManager", "layout", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setViewFlipperAdapter", "smoothScrollToPosition", "startFlipping", "stopFlipping", "ECViewFlipperAdapter", "ECViewFlipperHolder", "EmptyFlipperHolder", "IOnPositionChangeListener", "SmoothLinearLayoutManager", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECViewFlipper extends RecyclerView {
    private final Handler countDownHandler;
    private int currentPosInternal;
    private Function0<Unit> endCallback;
    private ECViewFlipperAdapter flipperAdapter;
    private long interval;
    private boolean isInfinity;
    private boolean isRunning;
    private boolean needKeepLastView;
    private IOnPositionChangeListener positionChangeListener;
    private ECViewFlipper$runnable$1 runnable;
    private int scrollSpeed;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u000eH&J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH&J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH&J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperHolder;", "()V", "viewFlipper", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper;", "getViewFlipper", "()Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper;", "setViewFlipper", "(Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper;)V", "bindFooterHolder", "", "holder", "getFlipperItemCount", "", "getFlipperItemViewType", "position", "getItemCount", "getItemViewType", "onBindViewFlipperHolder", "onBindViewHolder", "onCreateViewFlipperHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onCreateViewHolder", "Companion", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class ECViewFlipperAdapter extends RecyclerView.Adapter<ECViewFlipperHolder> {
        public static final Companion Companion = null;
        private static final int EMPTY_FOOTER = 100000;
        public ECViewFlipper viewFlipper;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperAdapter$Companion;", "", "()V", "EMPTY_FOOTER", "", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        private final void bindFooterHolder(ECViewFlipperHolder r1) {
        }

        public abstract int getFlipperItemCount();

        public final int getFlipperItemViewType(int r1) {
            return 1;
        }

        public abstract void onBindViewFlipperHolder(ECViewFlipperHolder r1, int r2);

        public abstract ECViewFlipperHolder onCreateViewFlipperHolder(ViewGroup r1, int r2);

        public int getItemCount() {
            ECViewFlipper r0 = this.viewFlipper;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("viewFlipper");
        L6:
            if (r0.isInfinity() == false) goto L9;
            return Integer.MAX_VALUE;
        L9:
            ECViewFlipper r1 = this.viewFlipper;
            if (r1 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("viewFlipper");
        L13:
            if (r1.getNeedKeepLastView() == false) goto L17;
            return getFlipperItemCount();
        L17:
            return getFlipperItemCount() + 1;
        }

        public final ECViewFlipper getViewFlipper() {
            ECViewFlipper r0 = this.viewFlipper;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewFlipper");
        L5:
            return r0;
        }

        public ECViewFlipperAdapter() {
        }

        public int getItemViewType(int r3) {
            ECViewFlipper r0 = this.viewFlipper;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("viewFlipper");
        L6:
            if (r0.getNeedKeepLastView() == true) goto L12;
            if (r3 != getFlipperItemCount()) goto L12;
            return EMPTY_FOOTER;
        L12:
            return getFlipperItemViewType(r3);
        }

        public final void setViewFlipper(ECViewFlipper r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.viewFlipper = r2;
        }

        public void onBindViewHolder(ECViewFlipperHolder r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "holder");
            int r0 = getFlipperItemCount();
            if (r0 != 0) goto L5;
            return;
        L5:
            ECViewFlipper r1 = this.viewFlipper;
            if (r1 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("viewFlipper");
        L9:
            if (r1.getNeedKeepLastView() == true) goto L12;
            if (r5 != r0) goto L12;
            bindFooterHolder(r4);
            return;
        L12:
            onBindViewFlipperHolder(r4, r5 % r0);
        }

        /* JADX INFO: renamed from: onCreateViewHolder, reason: collision with other method in class */
        public ECViewFlipperHolder m516onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            ViewGroup.LayoutParams r0 = new RecyclerView.LayoutParams(-1, -1);
            if (r4 != EMPTY_FOOTER) goto L6;
            EmptyFlipperHolder r5 = new EmptyFlipperHolder(r3.getContext());
            ((RecyclerView.ViewHolder) r5).itemView.setLayoutParams(r0);
            return r5;
        L6:
            ECViewFlipperHolder r6 = onCreateViewFlipperHolder(r3, r4);
            ((RecyclerView.ViewHolder) r6).itemView.setLayoutParams(r0);
            return r6;
        }

        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            onBindViewHolder((ECViewFlipperHolder) r1, r2);
        }

        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            return m516onCreateViewHolder(r1, r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class ECViewFlipperHolder extends RecyclerView.ViewHolder {
        public ECViewFlipperHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$EmptyFlipperHolder;", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EmptyFlipperHolder extends ECViewFlipperHolder {
        public EmptyFlipperHolder(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(new View(r2));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$IOnPositionChangeListener;", "", "onPositionChange", "", "oldPosition", "", "position", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IOnPositionChangeListener {
        void onPositionChange(int r1, int r2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$SmoothLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper;Landroid/content/Context;)V", "smoothScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "getSmoothScroller", "()Landroidx/recyclerview/widget/LinearSmoothScroller;", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SmoothLinearLayoutManager extends LinearLayoutManager {
        private final LinearSmoothScroller smoothScroller;
        final /* synthetic */ ECViewFlipper this$0;

        public final LinearSmoothScroller getSmoothScroller() {
            return this.smoothScroller;
        }

        public SmoothLinearLayoutManager(ECViewFlipper r2, final Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.this$0 = r2;
            super(r3);
            this.smoothScroller = new ECViewFlipper$SmoothLinearLayoutManager$smoothScroller$1(this, r3, r3);
        }

        public void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "recyclerView");
            this.smoothScroller.setTargetPosition(r3);
            startSmoothScroll(this.smoothScroller);
        }
    }

    public ECViewFlipper(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public ECViewFlipper(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return false;
    }

    public void setAdapter(RecyclerView.Adapter<?> r1) {
    }

    public void setLayoutManager(RecyclerView.LayoutManager r1) {
    }

    public final int getCurrentPos() {
        ECViewFlipperAdapter r0 = this.flipperAdapter;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getFlipperItemCount());
    L7:
        if (r1 == null) goto L13;
        if (r1.intValue() != 0) goto L13;
        return -1;
    L13:
        if (this.isInfinity == false) goto L20;
        int r2 = this.currentPosInternal;
        if (r1 == null) goto L17;
        int r3 = r1.intValue();
    L29:
        return r2 % r3;
    L17:
        r3 = 1;
        goto L29
    L20:
        if (this.needKeepLastView == false) goto L28;
        int r4 = this.currentPosInternal;
        if (r1 == null) goto L28;
        if (r4 != r1.intValue()) goto L28;
        return -1;
    L28:
        return this.currentPosInternal;
    L5:
        r1 = null;
        goto L7
    }

    public final void startFlipping() {
        ECViewFlipperAdapter r0 = this.flipperAdapter;
        if (r0 == null) goto L5;
        int r1 = r0.getFlipperItemCount();
    L7:
        if (r1 > 1) goto L10;
        return;
    L10:
        if (this.isRunning == false) goto L12;
        return;
    L12:
        this.isRunning = true;
        this.countDownHandler.postDelayed(this.runnable, this.interval);
        return;
    L5:
        r1 = 0;
        goto L7
    }

    public final void stopFlipping() {
        this.countDownHandler.removeCallbacks(this.runnable);
        this.isRunning = false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopFlipping();
    }

    public final Function0<Unit> getEndCallback() {
        return this.endCallback;
    }

    public final long getInterval() {
        return this.interval;
    }

    public final boolean getNeedKeepLastView() {
        return this.needKeepLastView;
    }

    public final IOnPositionChangeListener getPositionChangeListener() {
        return this.positionChangeListener;
    }

    public final int getScrollSpeed() {
        return this.scrollSpeed;
    }

    public final boolean isInfinity() {
        return this.isInfinity;
    }

    public static final /* synthetic */ Handler access$getCountDownHandler$p(ECViewFlipper r0) {
        return r0.countDownHandler;
    }

    public static final /* synthetic */ int access$getCurrentPosInternal$p(ECViewFlipper r0) {
        return r0.currentPosInternal;
    }

    public static final /* synthetic */ ECViewFlipperAdapter access$getFlipperAdapter$p(ECViewFlipper r0) {
        return r0.flipperAdapter;
    }

    public static final /* synthetic */ boolean access$isRunning$p(ECViewFlipper r0) {
        return r0.isRunning;
    }

    private final void setCurrentPosInternal(int r3) {
        int r0 = this.currentPosInternal;
        this.currentPosInternal = r3;
        if (r3 == r0) goto L8;
        IOnPositionChangeListener r1 = this.positionChangeListener;
        if (r1 == null) goto L9;
        r1.onPositionChange(r0, r3);
        return;
    L9:
        return;
    }

    public void scrollToPosition(int r1) {
        setCurrentPosInternal(r1);
        super.scrollToPosition(r1);
    }

    public final void setEndCallback(Function0<Unit> r1) {
        this.endCallback = r1;
    }

    public final void setInfinity(boolean r3) {
        if (this.isRunning == false) goto L5;
        return;
    L5:
        if (this.currentPosInternal > getCurrentPos()) goto L10;
        this.isInfinity = r3;
        return;
    }

    public final void setInterval(long r1) {
        this.interval = r1;
    }

    public final void setNeedKeepLastView(boolean r3) {
        if (this.isRunning == false) goto L5;
        return;
    L5:
        if (this.currentPosInternal > getCurrentPos()) goto L10;
        this.needKeepLastView = r3;
        return;
    }

    public final void setPositionChangeListener(IOnPositionChangeListener r1) {
        this.positionChangeListener = r1;
    }

    public final void setScrollSpeed(int r2) {
        this.scrollSpeed = Math.max(0, Math.min(r2, ECDraweeView.SQUARE));
    }

    public final void setViewFlipperAdapter(ECViewFlipperAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        this.flipperAdapter = r2;
        if (r2 == null) goto L5;
        r2.setViewFlipper(this);
    L5:
        super.setAdapter(r2);
    }

    public void smoothScrollToPosition(int r1) {
        setCurrentPosInternal(r1);
        super.smoothScrollToPosition(r1);
    }

    public static final /* synthetic */ void access$setCurrentPosInternal$p(ECViewFlipper r0, int r1) {
        r0.setCurrentPosInternal(r1);
    }

    public static final /* synthetic */ void access$setFlipperAdapter$p(ECViewFlipper r0, ECViewFlipperAdapter r1) {
        r0.flipperAdapter = r1;
    }

    public static final /* synthetic */ void access$setRunning$p(ECViewFlipper r0, boolean r1) {
        r0.isRunning = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper$runnable$1] */
    public ECViewFlipper(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.interval = 2000;
        this.scrollSpeed = 200;
        this.needKeepLastView = true;
        this.isInfinity = true;
        this.runnable = new ECViewFlipper$runnable$1(this);
        this.countDownHandler = new Handler(Looper.getMainLooper());
        setEnabled(false);
        super.setLayoutManager(new SmoothLinearLayoutManager(this, r2));
    }

    public /* synthetic */ ECViewFlipper(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
