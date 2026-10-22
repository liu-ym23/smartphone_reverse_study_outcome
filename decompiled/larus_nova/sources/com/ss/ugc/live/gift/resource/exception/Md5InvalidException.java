package com.ss.ugc.live.gift.resource.exception;

import qlc.a;

/* JADX INFO: loaded from: classes36.dex */
public class Md5InvalidException extends BaseGetResourceException {
    private String mMd5;

    @Override // com.ss.ugc.live.gift.resource.exception.BaseGetResourceException, java.lang.Throwable
    public String getMessage() {
        return "md5:" + this.mMd5 + "\n" + super.getMessage();
    }

    public Md5InvalidException(a r100, String r101) {
        super(r100);
        this.mMd5 = r101;
    }

    public Md5InvalidException(String r100, a r101, String r102) {
        super(r100, r101);
        this.mMd5 = r102;
    }

    public Md5InvalidException(String r100, Throwable r101, a r102, String r103) {
        super(r100, r101, r102);
        this.mMd5 = r103;
    }
}
