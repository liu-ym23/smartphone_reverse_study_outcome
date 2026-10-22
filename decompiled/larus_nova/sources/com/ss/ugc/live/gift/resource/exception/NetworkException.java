package com.ss.ugc.live.gift.resource.exception;

import com.ss.ugc.live.gift.resource.download.a;

/* JADX INFO: loaded from: classes36.dex */
public class NetworkException extends BaseGetResourceException {
    private a mDownloadRequest;
    private int mErrorCode;

    @Override // com.ss.ugc.live.gift.resource.exception.BaseGetResourceException, java.lang.Throwable
    public String getMessage() {
        throw null;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public NetworkException(qlc.a r100, int r101, a r102) {
        super(r100);
        this.mErrorCode = r101;
    }

    public NetworkException(String r100, qlc.a r101, int r102, a r103) {
        super(r100, r101);
        this.mErrorCode = r102;
    }

    public NetworkException(String r100, Throwable r101, qlc.a r102, int r103, a r104) {
        super(r100, r101, r102);
        this.mErrorCode = r103;
    }
}
