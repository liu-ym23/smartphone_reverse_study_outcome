package com.bytedance.bdp.appbase.base.launchcache.meta;

import com.bytedance.bdp.appbase.errorcode.ErrorCode;

/* JADX INFO: loaded from: classes11.dex */
public class MetaParseException extends Exception {
    public final ErrorCode.META errorCode;
    public final String errorMsg;

    public MetaParseException(ErrorCode.META r100, String r101) {
        this.errorCode = r100;
        this.errorMsg = r101;
    }
}
