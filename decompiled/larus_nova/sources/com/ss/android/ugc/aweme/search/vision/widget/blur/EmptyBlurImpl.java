package com.ss.android.ugc.aweme.search.vision.widget.blur;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes40.dex */
public class EmptyBlurImpl implements BlurImpl {
    public EmptyBlurImpl() {
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final boolean a(Context r100, Bitmap r101, float r102) {
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final void b(Bitmap r100, Bitmap r101) {
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final void release() {
    }
}
