package com.bytedance.sdk.open.aweme.commonbase.net.mime;

import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.net.OpenRequestBody;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes22.dex */
public class ByteArrayRequestBody extends OpenRequestBody {
    private byte[] bytes;
    private String contentType;
    private String fileName;
    private String realContentType;

    public ByteArrayRequestBody(String r100, byte[] r101, String r102) {
        this.contentType = r100;
        this.bytes = r101;
        this.fileName = r102;
        if (TextUtils.isEmpty(r100) == true) goto L5;
    L8:
        this.realContentType = r100;
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L7;
        r100 = "application/unknown";
        goto L8
    L7:
        r100 = "application/octet-stream";
        goto L8
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public String contentType() {
        return this.realContentType;
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public String fileName() {
        return this.fileName;
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public long length() {
        return this.bytes.length;
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public void writeTo(OutputStream r100) throws IOException {
        r100.write(this.bytes);
    }
}
