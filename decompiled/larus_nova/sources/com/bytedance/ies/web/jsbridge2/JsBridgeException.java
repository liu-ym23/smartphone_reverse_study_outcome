package com.bytedance.ies.web.jsbridge2;

/* JADX INFO: loaded from: classes19.dex */
class JsBridgeException extends Exception {
    static final int CODE_FAILED = 0;
    static final int CODE_MALFORMED_DATA = -5;
    static final int CODE_NAMESPACE_NOT_FOUND = -4;
    static final int CODE_NOT_FOUND = -2;
    static final int CODE_PERMISSION_DENIED = -1;
    int code;

    public JsBridgeException(int r100) {
        this.code = r100;
    }

    public JsBridgeException(int r100, String r101) {
        super(r101);
        this.code = r100;
    }
}
