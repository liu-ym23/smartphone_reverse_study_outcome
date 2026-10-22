package com.lynx.clay.embedding.engine.loader;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import com.lynx.serval.svg.SVGRender;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes32.dex */
public class SVGDom {
    private static SVGRender svgRender;
    private String content;

    public SVGDom(ByteBuffer r100) {
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (svgRender != null) goto L6;
        svgRender = new SVGRender();     // Catch: OutOfMemoryError -> L8 Exception -> L10
    L6:
        this.content = StandardCharsets.UTF_8.decode(r100).toString();     // Catch: OutOfMemoryError -> L8 Exception -> L10
    }

    public static SVGDom create(ByteBuffer r100) {
        return new SVGDom(r100);
    }

    public Bitmap render(int r100, int r101) {
        Picture r102 = svgRender.renderPicture(this.content, new Rect(0, 0, r100, r101));
        Bitmap r103 = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(r103);
        r104.drawARGB(0, 0, 0, 0);
        r104.drawPicture(r102);
        return r103;
    }
}
