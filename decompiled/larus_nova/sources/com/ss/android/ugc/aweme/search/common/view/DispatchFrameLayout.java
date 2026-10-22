package com.ss.android.ugc.aweme.search.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/view/DispatchFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/ugc/aweme/search/common/view/DispatchFrameLayout$DispatchTouchEventListener;", "listener", "", "setOnDispatchTouchEventListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "DispatchTouchEventListener", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DispatchFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DispatchTouchEventListener f452304a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/view/DispatchFrameLayout$DispatchTouchEventListener;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface DispatchTouchEventListener {
        void c(MotionEvent r100);
    }

    public DispatchFrameLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 0) goto L9;
        DispatchTouchEventListener r101 = this.f452304a;
        if (r101 == null) goto L9;
        r101.c(r100);
    L9:
        return super.dispatchTouchEvent(r100);
    }

    public final void setOnDispatchTouchEventListener(DispatchTouchEventListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f452304a = r100;
    }

    public DispatchFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
