package com.bytedance.ee.bear.bitable.infoarch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.loading.BitableLoadingWrapper;
import com.bytedance.ee.bear.bitable.loading.ELoadingType;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.util.ui.k;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import du4.b;
import io.supercharge.shimmerlayout.ShimmerLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u00162\b\b\u0001\u0010\u001e\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\u0012\u0010#\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u001cH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/view/BitableLoadingContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/loading/ILoadingContainer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadingError", "Landroid/view/View;", "loadingView", "closeView", "headerDecoration", KtvSubElement.CONTAINER, "shimmerColor", "Ljava/lang/Integer;", "globalLoadingType", "Lcom/bytedance/ee/bear/bitable/loading/ELoadingType;", "setLoadingType", "", "setBackClickListener", "listener", "Landroid/view/View$OnClickListener;", "setHeaderDecorationVisible", "visible", "", "setShimmerColor", "color", "showLoadingView", "showLoadingError", "view", "getLoadingType", "removeLoadingView", "state", "Lcom/bytedance/ee/bear/bitable/loading/BitableLoadingWrapper$LoadingState;", "getLoadingView", "removeLoadingError", "interruptLoading", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableLoadingContainer extends FrameLayout implements com.bytedance.ee.bear.bitable.loading.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f213712h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f213713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ShimmerLayout f213714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f213715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f213716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f213717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f213718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ELoadingType f213719g;

    public static final class a {
    }

    public BitableLoadingContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableLoadingContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final boolean A30() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final /* synthetic */ void Nr() {
        du4.a.a(this);
    }

    static {
        f213712h = UIHelper.dp2px(8.0f);
    }

    @Override // du4.c
    public final void ZX() {
        View r100 = this.f213713a;
        if (r100 == null) goto L8;
        FrameLayout r101 = this.f213717e;
        if (r101 == null) goto L9;
        r101.removeView(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public ELoadingType getLoadingType() {
        return this.f213719g;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public View getLoadingView() {
        return this.f213714b;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final void TQ(View r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        ShimmerLayout r101 = b.a(this, r100, this.f213718f);
        FrameLayout r102 = this.f213717e;
        if (r102 == null) goto L5;
        m.a(r102, r101);
    L5:
        this.f213714b = r101;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final void aS(BitableLoadingWrapper.LoadingState r100) {
        ShimmerLayout r101 = this.f213714b;
        if (r101 == null) goto L7;
        FrameLayout r102 = this.f213717e;
        if (r102 == null) goto L7;
        r102.removeView(r101);
    L7:
        BitableLoadingWrapper.LoadingState r103 = BitableLoadingWrapper.LoadingState.SUC;
        if (r100 == r103) goto L10;
    L11:
        if (r100 == r103) goto L13;
        return;
    L13:
        if (this.f213719g != ELoadingType.GLOBAL_BASE_ADD) goto L17;
    L14:
        setVisibility(8);
        return;
    L17:
        return;
    L10:
        if (this.f213719g == ELoadingType.GLOBAL_SHARE_RECORD) goto L14;
        goto L11
    }

    public final void setBackClickListener(View.OnClickListener r100) {
        View r101 = this.f213715c;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public final void setHeaderDecorationVisible(boolean r100) {
        View r101 = this.f213716d;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public final void setLoadingType(ELoadingType r100) {
        Intrinsics.checkNotNullParameter(r100, "globalLoadingType");
        this.f213719g = r100;
    }

    public final void setShimmerColor(int r100) {
        this.f213718f = Integer.valueOf(r100);
    }

    @Override // du4.c
    public final void xr(View r100) {
        if (r100 == null) goto L7;
        this.f213713a = r100;
        FrameLayout r101 = this.f213717e;
        if (r101 == null) goto L8;
        m.a(r101, r100);
        return;
    L8:
        return;
    }

    public BitableLoadingContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f213719g = ELoadingType.GLOBAL_BASE_ADD;
        LayoutInflater.from(r100).inflate(R.layout.bitable_loading_container_layout, this, true);
        View r103 = findViewById(R.id.loading_close);
        this.f213715c = r103;
        this.f213716d = findViewById(R.id.loading_header_decoration);
        this.f213717e = (FrameLayout) findViewById(R.id.loading_container);
        LinearLayout.LayoutParams r104 = null;
        if (r103 == null) goto L5;
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
    L7:
        if ((r105 instanceof LinearLayout.LayoutParams) == false) goto L9;
        r104 = (LinearLayout.LayoutParams) r105;
    L9:
        if (r104 == null) goto L12;
        r104.topMargin = k.e(r100) + f213712h;
        return;
    L12:
        return;
    L5:
        r105 = null;
        goto L7
    }

    public /* synthetic */ BitableLoadingContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
