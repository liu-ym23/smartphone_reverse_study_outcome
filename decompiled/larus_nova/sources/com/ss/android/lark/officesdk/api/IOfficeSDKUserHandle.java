package com.ss.android.lark.officesdk.api;

import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOfficeSDKUserHandle;", "", "awaitUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "timeoutMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserApiOrNull", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeSDKUserHandle {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object awaitUserApi$default(IOfficeSDKUserHandle r100, long r101, Continuation r102, int r103, Object r104) throws OfficeSDKException {
            if (r104 != null) goto L9;
            if ((r103 & 1) == 0) goto L7;
            r101 = 30000;
        L7:
            return r100.awaitUserApi(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitUserApi");
        }
    }

    Object awaitUserApi(long r100, Continuation<? super OfficeSDKUserApi> r101) throws OfficeSDKException;

    OfficeSDKUserApi getUserApiOrNull();
}
