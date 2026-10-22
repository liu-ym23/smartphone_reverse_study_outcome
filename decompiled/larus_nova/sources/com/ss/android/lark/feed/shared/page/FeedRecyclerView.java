package com.ss.android.lark.feed.shared.page;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0014\u0010\u0015\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ(\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0014R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/FeedRecyclerView;", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialMaxFlingVelocity", "finalMaxFlingVelocity", "onSizeChangedListener", "Lkotlin/Function0;", "", "fling", "", "velocityX", "velocityY", "setOnSizeChangedListener", "listener", "onSizeChanged", "w", "h", "oldw", "oldh", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedRecyclerView extends CommonRecyclerView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f421271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f421272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<Unit> f421273m;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeedRecyclerView f421274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f421275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f421276c;

        public a(FeedRecyclerView r100, int r101, int r102) {
            this.f421274a = r100;
            this.f421275b = r101;
            this.f421276c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FeedRecyclerView.u(this.f421274a, this.f421275b, this.f421276c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public FeedRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setOnSizeChangedListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f421273m = r100;
    }

    public FeedRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int r100, int r101) {
        if (Math.abs(r101) <= (getMaxFlingVelocity() / 2)) goto L5;
        int r102 = this.f421271k;
        int r103 = Math.max(-r102, Math.min(r101, r102));
        int r104 = this.f421271k;
        int r105 = this.f421272l;
        if (r104 >= r105) goto L11;
        int r106 = r104 + 2000;
        this.f421271k = r106;
        if (r106 <= r105) goto L11;
        this.f421271k = r105;
    L11:
        post(new a(this, r100, r103));
        return true;
    L5:
        return super.fling(r100, r101);
    }

    public FeedRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        requestDisallowInterceptTouchEvent(true);
        int r103 = (int) (((double) getMaxFlingVelocity()) * 0.5d);
        int r104 = (int) (((double) getMaxFlingVelocity()) * 0.8d);
        int r105 = Build.VERSION.SDK_INT;
        if (r105 >= 23) goto L6;
        this.f421271k = r103;
        this.f421272l = r103;
        return;
    L6:
        if (r105 > 26) goto L8;
        this.f421271k = r103;
        this.f421272l = r104;
        return;
    L8:
        this.f421271k = r104;
        this.f421272l = getMaxFlingVelocity();
    }

    public static final /* synthetic */ void u(FeedRecyclerView r100, int r101, int r102) {
        super.fling(r101, r102);
    }

    @Override // com.ss.android.lark.widget.recyclerview.CommonRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Function0<Unit> r104 = this.f421273m;
        if (r104 == null) goto L6;
        r104.invoke();
        return;
    }
}
