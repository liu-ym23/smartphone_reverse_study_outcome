package com.ss.android.ugc.aweme.search.common.topsection.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.ugc.aweme.search.vision.widget.ViewOffsetHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/widget/OffsetFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/ugc/aweme/search/vision/widget/ViewOffsetHelper$IReOffsetAfterLayout;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OffsetFrameLayout extends FrameLayout implements ViewOffsetHelper.IReOffsetAfterLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f452246a;

    public OffsetFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OffsetFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.ViewOffsetHelper.IReOffsetAfterLayout
    public final void a(int r100) {
        this.f452246a = r100;
    }

    public OffsetFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100, r101, r102);
    }

    public /* synthetic */ OffsetFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = this.f452246a;
        if (r105 == 0) goto L6;
        offsetTopAndBottom(r105 - getTop());
        return;
    }
}
