package com.bytedance.locallife.hybrid.bridge.network.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public class ClientProtocolException extends IOException {
    private static final long serialVersionUID = -5596590843227115865L;

    public ClientProtocolException() {
    }

    public ClientProtocolException(Throwable r100) {
        initCause(r100);
    }

    public ClientProtocolException(String r100) {
        super(r100);
    }

    public ClientProtocolException(String r100, Throwable r101) {
        super(r100);
        initCause(r101);
    }
}
