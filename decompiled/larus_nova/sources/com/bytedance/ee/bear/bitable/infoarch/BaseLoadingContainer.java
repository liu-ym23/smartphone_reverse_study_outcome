package com.bytedance.ee.bear.bitable.infoarch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.loading.BitableLoadingWrapper;
import com.bytedance.ee.bear.bitable.loading.ELoadingType;
import com.bytedance.ee.bear.bitable.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.supercharge.shimmerlayout.ShimmerLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J\n\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0017J\b\u0010\u001e\u001a\u00020\u0015H\u0004R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/BaseLoadingContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/loading/ILoadingContainer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadingView", "Landroid/view/View;", "loading", "", "getLoading", "()Z", "setLoading", "(Z)V", "hasSetData", "showLoadingView", "", "removeLoadingView", "state", "Lcom/bytedance/ee/bear/bitable/loading/BitableLoadingWrapper$LoadingState;", "getLoadingView", "showLoadingError", "view", "removeLoadingError", "interruptLoading", "checkHideLoadingWhenSetData", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseLoadingContainer extends FrameLayout implements com.bytedance.ee.bear.bitable.loading.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ShimmerLayout f213140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f213141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f213142c;

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public boolean A30() {
        this.f213141b = true;
        if (this.f213142c == false) goto L7;
        du4.a.a(this);
        return false;
    L7:
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final /* synthetic */ void Nr() {
        du4.a.a(this);
    }

    @Override // du4.c
    public final void ZX() {
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public abstract /* synthetic */ ELoadingType getLoadingType();

    public final void a() {
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.old.form.view.accelerate.v1") == false) goto L8;
        this.f213142c = true;
        if (this.f213141b == false) goto L9;
        du4.a.a(this);
        return;
    L9:
        return;
    }

    public final boolean getLoading() {
        return this.f213141b;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public View getLoadingView() {
        return this.f213140a;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final void TQ(View r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        ShimmerLayout r101 = du4.b.a(this, r100, null);
        m.a(this, r101);
        this.f213140a = r101;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final void aS(BitableLoadingWrapper.LoadingState r100) {
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.old.form.view.accelerate.v1") == false) goto L5;
        this.f213141b = false;
    L5:
        ShimmerLayout r101 = this.f213140a;
        if (r101 == null) goto L9;
        removeView(r101);
        return;
    }

    public final void setLoading(boolean r100) {
        this.f213141b = r100;
    }

    @Override // du4.c
    public final void xr(View r100) {
        aS(BitableLoadingWrapper.LoadingState.FAIL);
    }

    public BaseLoadingContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
