package com.bytedance.ies.xelement;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0014\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00020\u0007\"\u00020\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/xelement/RefreshHeaderView;", "Landroid/widget/FrameLayout;", "Lm6a/f;", "Ln6a/b;", "getSpinnerStyle", "Landroid/view/View;", "getView", "", "", "colors", "", "setPrimaryColors", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "x-element-pull-refresh_release"}, k = 1, mv = {1, 6, 0})
public final class RefreshHeaderView extends FrameLayout implements m6a.f {
    public RefreshHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RefreshHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // m6a.g
    public final boolean a() {
        return false;
    }

    @Override // m6a.g
    public final void b(boolean r100, float r101, int r102, int r103, int r104) {
    }

    @Override // m6a.g
    public final void d(float r100, int r101, int r102) {
    }

    @Override // m6a.g
    public final int e(SmartRefreshLayout r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        return 0;
    }

    @Override // m6a.g
    public View getView() {
        return this;
    }

    @Override // q6a.e
    public final void i(m6a.i r100, RefreshState r101, RefreshState r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        Intrinsics.checkNotNullParameter(r101, "oldState");
        Intrinsics.checkNotNullParameter(r102, "newState");
    }

    @Override // m6a.g
    public final void j(SmartRefreshLayout.i r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "kernel");
    }

    @Override // m6a.g
    public final void k(m6a.i r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
    }

    @Override // m6a.g
    public final void n(m6a.i r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
    }

    @Override // m6a.g
    public void setPrimaryColors(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
    }

    @Override // m6a.g
    public n6a.b getSpinnerStyle() {
        return n6a.b.f518183d;
    }

    public RefreshHeaderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
    }

    public /* synthetic */ RefreshHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
