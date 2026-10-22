package com.bytedance.kmp.ec.yata.view.render.screenmanager.popup.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/kmp/ec/yata/view/render/screenmanager/popup/view/RoundFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Path;", "getPath", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "yata-view-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class RoundFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f252072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f252073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f252074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f252075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f252076e;

    public RoundFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoundFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Path getPath() {
        if (this.f252072a != null) goto L5;
        this.f252072a = new Path();
    L5:
        Path r100 = this.f252072a;
        if (r100 == null) goto L8;
        r100.reset();
    L8:
        Path r101 = this.f252072a;
        if (r101 == null) goto L11;
        RectF r102 = new RectF(getBackground().getBounds());
        float r103 = this.f252073b;
        float r104 = this.f252074c;
        float r105 = this.f252075d;
        float r106 = this.f252076e;
        r101.addRoundRect(r102, new float[]{r103, r103, r104, r104, r105, r105, r106, r106}, Path.Direction.CW);
    L11:
        Path r107 = this.f252072a;
        Intrinsics.checkNotNull(r107);
        return r107;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.save();
        r100.clipPath(getPath());
        super.dispatchDraw(r100);
        r100.restoreToCount(r101);
    }

    public RoundFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ RoundFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
