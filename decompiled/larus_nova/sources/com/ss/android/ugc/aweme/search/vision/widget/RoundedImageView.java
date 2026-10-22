package com.ss.android.ugc.aweme.search.vision.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0002R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/widget/RoundedImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "radius", "", "setRadius", "radiusFraction", "setRadiusFraction", "", "e", "Z", "getUseCanvasWidth", "()Z", "setUseCanvasWidth", "(Z)V", "useCanvasWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributes", "", "styleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoundedImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f454060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f454061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f454062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f454063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f454064e;

    public RoundedImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoundedImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getUseCanvasWidth() {
        return this.f454064e;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f454061b == false) goto L10;
        float r100 = this.f454063d;
        if (this.f454064e == false) goto L7;
        int r101 = r110.getWidth();
    L8:
        this.f454062c = r100 * r101;
        goto L10
    L7:
        r101 = getWidth();
    L10:
        if (this.f454062c <= 0) goto L12;
        this.f454060a.reset();
        Path r102 = this.f454060a;
        float r103 = getWidth();
        float r104 = getHeight();
        float r105 = this.f454062c;
        r102.addRoundRect(0.0f, 0.0f, r103, r104, r105, r105, Path.Direction.CW);
        r110.clipPath(this.f454060a);
    L12:
        super.onDraw(r110);
    }

    public final void setRadius(float r100) {
        this.f454061b = false;
        this.f454062c = r100;
        invalidate();
    }

    public final void setRadiusFraction(float r100) {
        this.f454061b = true;
        this.f454063d = r100;
        invalidate();
    }

    public final void setUseCanvasWidth(boolean r100) {
        this.f454064e = r100;
    }

    public RoundedImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f454060a = new Path();
    }

    public /* synthetic */ RoundedImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
