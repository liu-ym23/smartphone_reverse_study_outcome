package com.ss.android.lark.image.impl.compress2;

import android.graphics.Bitmap;
import com.huawei.hms.utils.FileUtil;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.image.uploader.utils.ImageInfo;

/* JADX INFO: loaded from: classes36.dex */
class CompressStrategy implements ICompressStrategy {
    private final IParamsProvider paramsProvider;

    private static long calculateBitmapMemoryUse(int r100, int r101) {
        return (r100 * r101) * 4;
    }

    private int getNearestPow2(int r100) {
        int r101 = 1;
    L3:
        int r102 = r101 << 1;
        if (r102 > r100) goto L6;
        r101 = r102;
        goto L3
    L6:
        return r101;
    }

    public CompressStrategy(IParamsProvider r100) {
        this.paramsProvider = r100;
    }

    private int getPreferShortSize(ImageInfo r100) {
        return this.paramsProvider.getPreferParams(r100)[0];
    }

    private int getTargetQuality(ImageInfo r100) {
        int r101 = this.paramsProvider.getPreferParams(r100)[1];
        if (r101 > 0) goto L6;
        return 100;
    L6:
        return r101;
    }

    @Override // com.ss.android.lark.image.impl.compress2.ICompressStrategy
    public int calcExpectShortSize(ImageInfo r100) {
        int r101 = calcSampleSize(r100);
        float r102 = r101;
        int r103 = (int) ((r100.f426421a * 1.0f) / r102);
        int r104 = (int) ((r100.f426422b * 1.0f) / r102);
        int r105 = Math.min(r103, r104);
        int r106 = getPreferShortSize(r100);
        if (r105 > r106) goto L5;
    L7:
        return r105;
    L5:
        if (calculateBitmapMemoryUse(r103, r104) > (Runtime.getRuntime().maxMemory() / 10)) goto L7;
        return r106;
    }

    @Override // com.ss.android.lark.image.impl.compress2.ICompressStrategy
    public int calcSampleSize(ImageInfo r100) {
        int r101 = Math.min(r100.f426421a, r100.f426422b);
        if ((r101 % 2) != 1) goto L5;
        r101 = r101 + 1;
    L5:
        int r102 = getPreferShortSize(r100);
        if (r101 > r102) goto L8;
    L10:
        int r103 = 1;
    L12:
        return Math.max(r103, 1);
    L8:
        if (r101 < 1944.0f) goto L10;
        r103 = getNearestPow2((int) Math.round((((double) r101) * 1.0d) / ((double) r102)));
        goto L12
    }

    @Override // com.ss.android.lark.image.impl.compress2.ICompressStrategy
    public int calcTargetQuality(ImageInfo r100) {
        return getTargetQuality(r100);
    }

    @Override // com.ss.android.lark.image.impl.compress2.ICompressStrategy
    public Bitmap.CompressFormat getCompressFormat(String r100) {
        if ("image/png".equalsIgnoreCase(r100) == false) goto L7;
        return Bitmap.CompressFormat.JPEG;
    L7:
        if (MimeType.WEBP.equalsIgnoreCase(r100) == false) goto L11;
        return Bitmap.CompressFormat.WEBP;
    L11:
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.ss.android.lark.image.impl.compress2.ICompressStrategy
    public boolean shouldSkipCompress(ImageInfo r100, int r101, int r102) {
        boolean r103 = r100.f426427g;
        long r104 = r100.f426423c;
        if (r104 < FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) goto L13;
        if (r103 == true) goto L8;
        if (r104 < 20480) goto L13;
    L8:
        if (Math.min(r100.f426421a, r100.f426422b) <= r101) goto L10;
    L12:
        return false;
    L10:
        if (r100.f426424d > r102) goto L12;
    L13:
        return true;
    }
}
