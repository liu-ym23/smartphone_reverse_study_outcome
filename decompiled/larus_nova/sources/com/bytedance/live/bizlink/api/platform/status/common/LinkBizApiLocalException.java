package com.bytedance.live.bizlink.api.platform.status.common;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/live/bizlink/api/platform/status/common/LinkBizApiLocalException;", "Lcom/bytedance/live/bizlink/api/platform/status/common/BaseApiLocalException;", "errorCode", "", LynxError.LYNX_THROWABLE, "", "(ILjava/lang/Throwable;)V", "message", "", "getMessage", "()Ljava/lang/String;", "multi-biz-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkBizApiLocalException extends BaseApiLocalException {
    @Override // com.bytedance.live.bizlink.api.platform.status.common.BaseApiLocalException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = LinkBizApiLocalException, errorCode = " + getErrorCode() + " " + super.getMessage();
    }

    public LinkBizApiLocalException(int r100, Throwable r101) {
        super(r100, r101);
    }
}
