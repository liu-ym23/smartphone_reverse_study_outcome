package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ImageExtensionsKt$asGeckoBitmap$1 extends Lambda implements Function1<byte[], Unit> {
    final /* synthetic */ Function1 $bmpCB;

    public ImageExtensionsKt$asGeckoBitmap$1(Function1 r1) {
        this.$bmpCB = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((byte[]) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(byte[] r4) {
        Function1 r0 = this.$bmpCB;
        if (r4 == null) goto L5;
        Bitmap r5 = BitmapFactory.decodeByteArray(r4, 0, r4.length);
    L6:
        r0.invoke(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
