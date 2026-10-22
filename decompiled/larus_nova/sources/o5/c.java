package o5;

import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.net.AIRealDeviceDebugVerifyRequestBody;
import com.bytedance.ai.resource.core.net.AIRealDeviceDebugVerifyResponseData;
import com.bytedance.retrofit2.SsResponse;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    static {
    }

    public static OpenPlatformBaseResponse a(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "debugToken");
        Intrinsics.checkNotNullParameter(r111, "encryptedDebugPayload");
        Intrinsics.checkNotNullParameter(r112, "xToken");
        if (StringsKt.isBlank(r112) == true) goto L5;
        SsResponse<OpenPlatformBaseResponse<AIRealDeviceDebugVerifyResponseData>> r100 = j.a().verifyDebugChannel(r112, 2, "application/json", new AIRealDeviceDebugVerifyRequestBody(0, r110, r111, 1, null)).execute();
        if (r100.isSuccessful() == false) goto L12;
        OpenPlatformBaseResponse<AIRealDeviceDebugVerifyResponseData> r101 = r100.body();
        if (r101 == null) goto L14;
        return r101;
    L14:
        return new OpenPlatformBaseResponse(-1, "empty response body", null, null, 12, null);
    L12:
        return new OpenPlatformBaseResponse(r100.code(), r100.message(), null, null, 8, null);
    L5:
        return new OpenPlatformBaseResponse(-1, "x-tt-token is empty", null, null, 12, null);
    }
}
