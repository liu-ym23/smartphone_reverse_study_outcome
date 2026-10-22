package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/view/ViewPager2FixLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewPagerControl", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/view/ViewPager2FixLayout$IViewPagerControl;", "getViewPagerControl", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/view/ViewPager2FixLayout$IViewPagerControl;", "setViewPagerControl", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/view/ViewPager2FixLayout$IViewPagerControl;)V", "startX", "startY", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "resetEvent", "", "IViewPagerControl", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewPager2FixLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f414373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f414374b;

    public interface a {
    }

    public ViewPager2FixLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ViewPager2FixLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final a getViewPagerControl() {
        return null;
    }

    public final void setViewPagerControl(a r100) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction() & 255;
        if (r101 != 0) goto L5;
        this.f414373a = (int) r100.getX();
        this.f414374b = (int) r100.getY();
    L15:
        return super.dispatchTouchEvent(r100);
    L5:
        if (r101 != 1) goto L7;
    L12:
        this.f414373a = 0;
        this.f414374b = 0;
        goto L15
    L7:
        if (r101 != 2) goto L9;
        int r102 = (int) r100.getX();
        int r103 = (int) r100.getY();
        Math.abs(r102 - this.f414373a);
        Math.abs(r103 - this.f414374b);
        goto L15
    L9:
        if (r101 == 3) goto L12;
        goto L12
    }

    public ViewPager2FixLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ViewPager2FixLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
