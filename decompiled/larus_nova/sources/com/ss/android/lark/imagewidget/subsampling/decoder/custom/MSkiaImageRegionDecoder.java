package com.ss.android.lark.imagewidget.subsampling.decoder.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.imagewidget.subsampling.decoder.SkiaImageRegionDecoder;

/* JADX INFO: loaded from: classes36.dex */
public class MSkiaImageRegionDecoder extends SkiaImageRegionDecoder {
    public static final String FILE_PREFIX = "file://";
    public boolean mIsSecret;
    private String uriString;

    public MSkiaImageRegionDecoder() {
        this.mIsSecret = false;
        this.uriString = null;
    }

    public MSkiaImageRegionDecoder(Bitmap.Config r100) {
        super(r100);
        this.mIsSecret = false;
        this.uriString = null;
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.decoder.SkiaImageRegionDecoder, rlb.d
    public Bitmap decodeRegion(Rect r100, int r101) {
        Bitmap r102 = super.decodeRegion(r100, r101);
        if (TextUtils.isEmpty(this.uriString) == false) goto L5;
    L9:
        return r102;
    L5:
        if (this.uriString.startsWith(FILE_PREFIX) == false) goto L9;
        if (this.mIsSecret == false) goto L9;
        FileUtils.g(this.uriString.substring(7));
        goto L9
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.decoder.SkiaImageRegionDecoder, rlb.d
    public Point init(Context r100, Uri r101) throws Exception {
        Point r102 = super.init(r100, r101);
        this.uriString = r101.toString();
        return r102;
    }
}
