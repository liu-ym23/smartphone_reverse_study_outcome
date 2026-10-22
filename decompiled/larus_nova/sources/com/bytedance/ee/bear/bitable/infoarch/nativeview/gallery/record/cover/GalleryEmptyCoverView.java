package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.bytedance.ee.bear.bitable.card.view.table.EmptyCoverView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryEmptyCoverView;", "Lcom/bytedance/ee/bear/bitable/card/view/table/EmptyCoverView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawCircle", "", "canvas", "Landroid/graphics/Canvas;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryEmptyCoverView extends EmptyCoverView {

    public static final class a {
    }

    static {
    }

    public GalleryEmptyCoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GalleryEmptyCoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.table.EmptyCoverView
    public final void a(Canvas r100) {
        getPaint().setColor(getMTopCircleColor());
        getPaint().setStyle(Paint.Style.FILL);
        if (r100 == null) goto L5;
        r100.drawCircle(y9c.d.a(14) + y9c.d.a(8), y9c.d.a(10) + y9c.d.a(8), y9c.d.a(8), getPaint());
    L5:
        getPaint().setColor(-1);
        float r101 = 255;
        getPaint().setAlpha((int) (getLeftAlpha() * r101));
        if (r100 == null) goto L8;
        r100.drawCircle((-y9c.d.a(44)) + y9c.d.a(52), y9c.d.a(42) + y9c.d.a(52), y9c.d.a(52), getPaint());
    L8:
        getPaint().setAlpha((int) (getRightAlpha() * r101));
        if (r100 == null) goto L12;
        r100.drawCircle(y9c.d.a(16) + y9c.d.a(74), y9c.d.a(14) + y9c.d.a(74), y9c.d.a(74), getPaint());
        return;
    }

    public GalleryEmptyCoverView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ GalleryEmptyCoverView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
