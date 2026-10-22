package com.ss.ugc.effectplatform.extension;

import bytekn.foundation.io.file.ContentEncoding;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.util.CommonUtilExKt;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public static final String a(ByteReadStream r100) {
        if (r100.available() == true) goto L6;
        return "";
    L6:
        bytekn.foundation.io.file.a r101 = new bytekn.foundation.io.file.a(32);
        byte[] r102 = new byte[1024];
        int r103 = r100.read(r102, 0, 1024);
    L7:
        if (r103 < 0) goto L9;
        r101.a(r102, 0, r103);
        r103 = r100.read(r102, 0, 1024);
        goto L7
    L9:
        r100.close();
        return CommonUtilExKt.a(Arrays.copyOf(r101.f21784a, r101.f21785b), ContentEncoding.Utf8);
    }
}
