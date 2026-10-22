package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m extends BaseBitmapDataSubscriber {
    public final /* synthetic */ c a;

    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r1) {
    }

    public m(c r1) {
        this.a = r1;
    }

    public final void onNewResultImpl(Bitmap r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if ((!r3.isRecycled()) == true) goto L7;
        r3 = null;
    L7:
        if (r3 == null) goto L13;
        Bitmap r4 = r3.copy(Bitmap.Config.ARGB_8888, false);
        if (r4 == null) goto L14;
        this.a.d(r4);
        return;
    L14:
        return;
    }
}
