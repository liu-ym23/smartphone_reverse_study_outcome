package com.bytedance.android.window.shop.widget.category;

import android.content.Context;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends ECDraweeView implements a {
    public boolean a;
    public final float b;
    public final float c;
    public final WindowProductCategoryVODeprecated.c d;
    public final Function3<WindowProductCategoryVODeprecated.a, Integer, Integer, Unit> e;

    public /* bridge */ /* synthetic */ WindowProductCategoryVODeprecated.a getCategory() {
        return m973getCategory();
    }

    @Override // com.bytedance.android.window.shop.widget.category.a
    public final void u() {
        String r0 = m973getCategory().e.getFirstUrl();
        if (r0 != null) goto L5;
        return;
    L5:
        setController(Fresco.newDraweeControllerBuilder().setUri(r0).build());
        setAspectRatio(this.b);
    }

    @Override // com.bytedance.android.window.shop.widget.category.a
    public final void w() {
        String r0 = m973getCategory().f.getFirstUrl();
        if (r0 != null) goto L5;
        return;
    L5:
        setController(Fresco.newDraweeControllerBuilder().setUri(r0).build());
        setAspectRatio(this.c);
    }

    public boolean getLastChosen() {
        return this.a;
    }

    /* JADX INFO: renamed from: getCategory, reason: collision with other method in class */
    public WindowProductCategoryVODeprecated.c m973getCategory() {
        return this.d;
    }

    public void setLastChosen(boolean r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(WindowProductCategoryVODeprecated.c r8, Context r9, Function3<? super WindowProductCategoryVODeprecated.a, ? super Integer, ? super Integer, Unit> r10) {
        Intrinsics.checkNotNullParameter(r8, "category");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, null, 0, 6, null);
        this.d = r8;
        this.e = r10;
        this.b = RangesKt.coerceIn(m973getCategory().e.getWidth() / m973getCategory().e.getHeight(), 0.01f, 100.0f);
        this.c = RangesKt.coerceIn(m973getCategory().f.getWidth() / m973getCategory().f.getHeight(), 0.01f, 100.0f);
        getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(q.a(6)));
        getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        String r11 = m973getCategory().f.getFirstUrl();
        if (r11 == null) goto L6;
        Fresco.getImagePipeline().prefetchToBitmapCache(ImageRequest.fromUri(r11), null);
    L6:
        String r12 = m973getCategory().e.getFirstUrl();
        if (r12 == null) goto L11;
        Fresco.getImagePipeline().prefetchToBitmapCache(ImageRequest.fromUri(r12), null);
        return;
    }
}
