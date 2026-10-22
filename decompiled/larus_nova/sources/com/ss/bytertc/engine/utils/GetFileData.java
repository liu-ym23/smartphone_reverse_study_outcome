package com.ss.bytertc.engine.utils;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.bytertc.base.utils.RtcContextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class GetFileData {
    public GetFileData() {
    }

    private static ByteBuffer convertDirectBuffer(ByteBuffer r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.isDirect() == false) goto L8;
        return r100;
    L8:
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.remaining());
        r101.position(0);
        r101.put(r100);
        r101.rewind();
        return r101;
    }

    public static ByteBuffer readFile(String r100) {
        Context r101 = RtcContextUtils.getApplicationContext();
        if (r100.startsWith("/assets/") == false) goto L8;
        if (r101 == null) goto L8;
        return getAssets(r101, r100.substring(8));
    L8:
        if (r100.startsWith("content://") == false) goto L12;
        if (r101 != null) goto L11;
        return null;
    L11:
        return getOthers(r101, r100);
    L12:
        return null;
    }

    public static ByteBuffer getAssets(Context r100, String r101) {
        InputStream r102 = r100.getResources().getAssets().open(r101);     // Catch: IOException -> L11
        if (r102 != null) goto L6;
        return null;
    L6:
        byte[] r103 = new byte[r102.available()];     // Catch: IOException -> L11
        int r104 = r102.read(r103);     // Catch: IOException -> L11
        r102.close();     // Catch: IOException -> L11
        if (r104 > 0) goto L9;
        return null;
    L9:
        return convertDirectBuffer(ByteBuffer.wrap(r103));
    L11:
        return null;
    }

    public static ByteBuffer getOthers(Context r100, String r101) {
        Uri r102 = UriProtector.parse(r101);     // Catch: Exception -> L11
        InputStream r103 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r102);     // Catch: Exception -> L11
        if (r103 != null) goto L6;
        return null;
    L6:
        byte[] r104 = new byte[r103.available()];     // Catch: Exception -> L11
        int r105 = r103.read(r104);     // Catch: Exception -> L11
        r103.close();     // Catch: Exception -> L11
        if (r105 > 0) goto L9;
        return null;
    L9:
        return convertDirectBuffer(ByteBuffer.wrap(r104));
    L11:
        return null;
    }
}
