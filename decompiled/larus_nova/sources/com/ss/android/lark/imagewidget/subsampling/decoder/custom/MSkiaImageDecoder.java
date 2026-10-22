package com.ss.android.lark.imagewidget.subsampling.decoder.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.imagewidget.subsampling.decoder.SkiaImageDecoder;

/* JADX INFO: loaded from: classes36.dex */
public class MSkiaImageDecoder extends SkiaImageDecoder {
    private static final String FILE_PREFIX = "file://";
    public boolean mIsSecret;

    public MSkiaImageDecoder() {
        this.mIsSecret = false;
    }

    public MSkiaImageDecoder(Bitmap.Config r100) {
        super(r100);
        this.mIsSecret = false;
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.decoder.SkiaImageDecoder, rlb.c
    public Bitmap decode(Context r100, Uri r101) throws Exception {
        Bitmap r102 = super.decode(r100, r101);
        if (this.mIsSecret == false) goto L7;
        String r103 = r101.toString();
        if (r103.startsWith("file://") == false) goto L7;
        FileUtils.g(r103.substring(7));
    L7:
        return r102;
    }
}
