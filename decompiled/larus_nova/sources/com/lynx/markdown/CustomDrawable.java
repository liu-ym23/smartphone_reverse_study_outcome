package com.lynx.markdown;

import android.graphics.Canvas;
import com.lynx.textra.BBufferInputStream;
import com.lynx.textra.TTTextDefinition;
import java.io.IOException;

/* JADX INFO: loaded from: classes32.dex */
public class CustomDrawable {
    public CustomDrawable() {
    }

    public static native void align(long r100, float r101, float r102);

    public static native long measure(long r100, float r101, int r102, float r103, int r104);

    private static native byte[] nativeDrawCustomDrawable(long r100);

    public static void a(long r100, Canvas r101, h r102) {
        byte[] r103 = nativeDrawCustomDrawable(r100);
        f r104 = new f(r101, r102);
        BBufferInputStream r105 = new BBufferInputStream(r103);
    L13:
        if (r105.available() <= 0) goto L21;
        byte r106 = r105.readByte();     // Catch: IOException -> L10
        if (r106 == (-1)) goto L7;
        r104.drawOp(TTTextDefinition.GetCanvasOp(r106), r105);     // Catch: IOException -> L10
        goto L13
    L7:
        r104.b(r105);     // Catch: IOException -> L10
        goto L13
    L21:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }
}
