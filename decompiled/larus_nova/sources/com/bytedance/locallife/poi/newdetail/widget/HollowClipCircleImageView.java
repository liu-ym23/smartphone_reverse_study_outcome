package com.bytedance.locallife.poi.newdetail.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/HollowClipCircleImageView;", "Lcom/bytedance/locallife/poi/newdetail/widget/CircleImageView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class HollowClipCircleImageView extends CircleImageView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f263300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f263301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f263302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f263303e;

    public HollowClipCircleImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HollowClipCircleImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.CircleImageView, android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f263300b.reset();
        this.f263300b.addCircle(this.f263301c, this.f263302d, this.f263303e, Path.Direction.CW);
        r100.clipPath(this.f263300b, Region.Op.DIFFERENCE);
        this.f263300b.close();
        super.onDraw(r100);
    }

    public HollowClipCircleImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263300b = new Path();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.clip_radius, R.attr.x_offset, R.attr.y_offset});
        this.f263301c = r103.getDimensionPixelSize(1, 0);
        this.f263302d = r103.getDimensionPixelSize(2, 0);
        this.f263303e = r103.getDimensionPixelSize(0, 0);
        r103.recycle();
    }

    public /* synthetic */ HollowClipCircleImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
