package com.ss.android.lark.image.impl.service;

import com.ss.android.lark.image.impl.compress2.IParamsProvider;
import com.ss.android.lark.image.uploader.utils.ImageInfo;

/* JADX INFO: loaded from: classes36.dex */
public class CompressParamsProvider implements IParamsProvider {
    int[] lastCompressParams;
    ImageInfo lastImageInfo;
    private final int preferQuality;
    private final int preferShortSize;

    @Override // com.ss.android.lark.image.impl.compress2.IParamsProvider
    public int[] getPreferParams(ImageInfo r110) {
        int r100 = Math.min(r110.f426421a, r110.f426422b);
        int r101 = Math.max(r110.f426421a, r110.f426422b);
        int r102 = this.preferShortSize;
        if (r102 <= 0) goto L9;
        if (this.preferQuality <= 0) goto L9;
        return new int[]{Math.min(r100, r102), Math.min(this.preferQuality, 100)};
    L9:
        if (this.lastCompressParams != null) goto L11;
    L12:
        this.lastCompressParams = ImageService.inst().getImageCompressParams(r110.f426423c, r100, r101, r110.f426424d, -1, -1);
        this.lastImageInfo = r110;
    L13:
        int[] r111 = this.lastCompressParams;
        if (r111 != null) goto L16;
    L17:
        this.lastCompressParams = new int[]{1080, 50};
    L19:
        return this.lastCompressParams;
    L16:
        if (r111.length >= 2) goto L19;
    L11:
        if (this.lastImageInfo == r110) goto L13;
        goto L12
    }

    public CompressParamsProvider(int r100, int r101) {
        this.preferShortSize = r100;
        this.preferQuality = r101;
    }
}
