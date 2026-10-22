package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import android.graphics.Bitmap;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ImageExtensionsKt$setGeckoImage$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ SimpleDraweeView $this_setGeckoImage;

    public ImageExtensionsKt$setGeckoImage$1(SimpleDraweeView r1) {
        this.$this_setGeckoImage = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Bitmap) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Bitmap r2) {
        this.$this_setGeckoImage.setImageBitmap(r2);
    }
}
