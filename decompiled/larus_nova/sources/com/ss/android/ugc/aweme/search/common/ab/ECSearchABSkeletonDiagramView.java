package com.ss.android.ugc.aweme.search.common.ab;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ab/ECSearchABSkeletonDiagramView;", "Landroid/widget/FrameLayout;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchABSkeletonDiagramView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECSearchABSkeletonShimmerView f451398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f451399b;

    public ECSearchABSkeletonDiagramView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECSearchABSkeletonDiagramView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ECSearchABSkeletonShimmerView r100 = this.f451398a;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        if (r100 == 0) goto L4;
        ECSearchABSkeletonShimmerView r101 = this.f451398a;
        if (r101 == null) goto L12;
        r101.c();
    L12:
        super.setVisibility(r100);
        return;
    L4:
        if (this.f451399b == true) goto L6;
        this.f451399b = true;
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.search_ab_skeleton_bg));
    L6:
        ECSearchABSkeletonShimmerView r102 = this.f451398a;
        if (r102 == null) goto L12;
        r102.b();
        goto L12
    }

    public ECSearchABSkeletonDiagramView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ECSearchABSkeletonShimmerView r103 = new ECSearchABSkeletonShimmerView(r100, null, 6, 0);
        this.f451398a = r103;
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r103);
    }

    public /* synthetic */ ECSearchABSkeletonDiagramView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
