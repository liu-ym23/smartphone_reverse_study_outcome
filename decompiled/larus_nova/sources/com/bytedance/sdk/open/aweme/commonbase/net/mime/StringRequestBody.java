package com.bytedance.sdk.open.aweme.commonbase.net.mime;

import com.bytedance.sdk.open.aweme.commonbase.net.b;

/* JADX INFO: loaded from: classes22.dex */
public class StringRequestBody extends ByteArrayRequestBody {
    public StringRequestBody(String r100) {
        super("text/plain; charset=UTF-8", b.a(r100), null);
    }
}
