package com.larus.bmhome.chat.layout.holder.progressloading;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J.\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/progressloading/RadiusCardView;", "Lcom/google/android/material/card/MaterialCardView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tlRadius", "", "trRadius", "brRadius", "blRadius", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setRadius", "rectF", "Landroid/graphics/RectF;", "getRectF", "()Landroid/graphics/RectF;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RadiusCardView extends MaterialCardView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f304030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f304031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f304032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f304033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f304034e;

    public RadiusCardView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RadiusCardView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final RectF getRectF() {
        Rect r100 = new Rect();
        getDrawingRect(r100);
        return new RectF(r100);
    }

    public final Path getPath() {
        return this.f304034e;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f304034e.reset();
        RectF r101 = getRectF();
        float r102 = this.f304030a;
        float r103 = this.f304031b;
        float r104 = this.f304032c;
        float r105 = this.f304033d;
        this.f304034e.addRoundRect(r101, new float[]{r102, r102, r103, r103, r104, r104, r105, r105}, Path.Direction.CW);
        r100.clipPath(this.f304034e, Region.Op.INTERSECT);
        super.onDraw(r100);
    }

    public RadiusCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f304034e = new Path();
        setRadius(0.0f);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_rcv_bottomLeftRadius, R.attr.larus_rcv_bottomRightRadius, R.attr.larus_rcv_topLeftRadius, R.attr.larus_rcv_topRightRadius});
        this.f304030a = r103.getDimension(2, 0.0f);
        this.f304031b = r103.getDimension(3, 0.0f);
        this.f304032c = r103.getDimension(1, 0.0f);
        this.f304033d = r103.getDimension(0, 0.0f);
        setBackground(new ColorDrawable());
        r103.recycle();
    }

    public /* synthetic */ RadiusCardView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = R.attr.materialCardViewStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    public final void a(float r100, float r101, float r102, float r103) {
        this.f304030a = r100;
        this.f304031b = r101;
        this.f304032c = r102;
        this.f304033d = r103;
        invalidate();
    }
}
