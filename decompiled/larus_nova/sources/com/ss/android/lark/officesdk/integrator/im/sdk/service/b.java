package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.impl.service.ModelParserImage;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements okb.c {
    public b() {
    }

    @Override // okb.c
    public final Image a(ImageSet r100) {
        return ModelParserImage.getThumbnailFromPb(r100);
    }

    @Override // okb.c
    public final ByteString b(ImageSet r100) {
        return ModelParserImage.getInlinePreviewFromPb(r100);
    }

    @Override // okb.c
    public final Image c(ImageSet r100) {
        return ModelParserImage.getMiddleFromPb(r100);
    }

    @Override // okb.c
    public final Image d(com.bytedance.lark.pb.basic.v1.Image r100) {
        return ModelParserImage.getImage(r100);
    }
}
