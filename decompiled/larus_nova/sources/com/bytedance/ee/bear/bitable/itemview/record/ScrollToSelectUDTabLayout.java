package com.bytedance.ee.bear.bitable.itemview.record;

import android.content.Context;
import android.util.AttributeSet;
import com.byted.cast.common.CastMonitor;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ScrollToSelectUDTabLayout;", "Lcom/larksuite/component/universe_design/tab/UDTabLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "needScrollToSelectAfterLayout", "", "getNeedScrollToSelectAfterLayout", "()Z", "setNeedScrollToSelectAfterLayout", "(Z)V", "onLayout", "", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "", "t", "r", "b", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrollToSelectUDTabLayout extends UDTabLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f214053a;

    public final boolean getNeedScrollToSelectAfterLayout() {
        return this.f214053a;
    }

    public ScrollToSelectUDTabLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setNeedScrollToSelectAfterLayout(boolean r100) {
        this.f214053a = r100;
    }

    public ScrollToSelectUDTabLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // com.larksuite.component.universe_design.tab.UDTabLayout, android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f214053a == false) goto L6;
        this.f214053a = false;
        selectTabAt(getSelectPosition());
        return;
    }
}
