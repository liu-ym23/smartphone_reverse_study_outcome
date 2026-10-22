package com.bytedance.locallife.poi.poidetail.screenshot.model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/ImageView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class PoiScreenshotCollectChannel$showNoticePopup$1$1$4 extends Lambda implements Function1<ImageView, Unit> {
    public static final PoiScreenshotCollectChannel$showNoticePopup$1$1$4 INSTANCE = null;

    static {
        INSTANCE = new PoiScreenshotCollectChannel$showNoticePopup$1$1$4();
    }

    public PoiScreenshotCollectChannel$showNoticePopup$1$1$4() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
        Drawable r101 = ContextCompat.getDrawable(r100.getContext(), R.drawable.ic_s_s_arrowright_outlined_12);
        if (r101 == null) goto L6;
        Drawable r102 = DrawableCompat.wrap(r101).mutate();
        r100.setImageDrawable(r102);
        DrawableCompat.setTint(r102, ContextCompat.getColor(r100.getContext(), R.color.white));
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ImageView r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
