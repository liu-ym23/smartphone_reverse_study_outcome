package com.bytedance.sdk.open.aweme.core.net;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes22.dex */
public abstract class OpenRequestBody {
    public OpenRequestBody() {
    }

    public abstract String contentType();

    public abstract String fileName();

    public abstract long length();

    public abstract void writeTo(OutputStream r100) throws IOException;
}
