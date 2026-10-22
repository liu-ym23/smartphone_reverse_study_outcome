package ww7;

import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.common.data.UpMsgType;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* JADX INFO: loaded from: classes23.dex */
public final class m extends s<Void> {
    public m() {
        super(UpMsgType.UNREGISTER_PUSH_TOKEN);
    }

    @Override // ww7.s
    public final void a(ApiException r100, Object r101) {
        if (r100 != null) goto L5;
        r100 = HonorPushErrorEnum.ERROR_UNKNOWN.toApiException();
    L5:
        if (r100.getErrorCode() != HonorPushErrorEnum.SUCCESS.getErrorCode()) goto L7;
        this.f561702a.b(null);
        return;
    L7:
        r100.getErrorCode();
        this.f561702a.a(r100);
    }
}
