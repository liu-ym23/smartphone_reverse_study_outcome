package ww7;

import android.content.Context;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.common.data.UpMsgType;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* JADX INFO: loaded from: classes23.dex */
public final class p extends s<PushTokenResult> {
    public p() {
        super(UpMsgType.REQUEST_PUSH_TOKEN);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // ww7.s
    public final void a(ApiException r100, Object r101) {
        if (r100 != null) goto L5;
        r100 = HonorPushErrorEnum.ERROR_UNKNOWN.toApiException();
    L5:
        if (r100.getErrorCode() == HonorPushErrorEnum.SUCCESS.getErrorCode()) goto L7;
    L13:
        r100.getErrorCode();
        this.f561702a.a(r100);
        return;
    L7:
        if ((r101 instanceof PushTokenResult) == false) goto L12;
        PushTokenResult r102 = (PushTokenResult) r101;
        String r103 = r102.getPushToken();
        Context r104 = c0.f561643e.a();     // Catch: Exception -> L15
        n.f561683b.a(r104, r103);     // Catch: Exception -> L15
    L10:
        this.f561702a.b((TResult) r102);
        return;
    L12:
        r100 = HonorPushErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        goto L13
    }
}
