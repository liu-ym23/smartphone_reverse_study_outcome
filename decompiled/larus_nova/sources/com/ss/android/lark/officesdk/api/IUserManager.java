package com.ss.android.lark.officesdk.api;

import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0014\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001e\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0018\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IUserManager;", "", "loginState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State;", "login", "", "callback", "Lcom/ss/android/lark/officesdk/api/ILoginCallback;", "logout", "Lcom/ss/android/lark/officesdk/api/ILogoutCallback;", "action", "Lcom/ss/android/lark/officesdk/api/OfficeSDKPassportUserAction;", "getUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "awaitUserApi", "timeoutMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginRx", "Lio/reactivex/Single;", "Lcom/ss/android/lark/officesdk/api/OfficeSDKDriveResult;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/ss/android/lark/officesdk/api/OfficeSDKHostSession;", "logoutRx", "createUserHandle", "Lcom/ss/android/lark/officesdk/api/IOfficeSDKUserHandle;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IUserManager {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void login$default(IUserManager r100, ILoginCallback r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.login(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }

        public static /* synthetic */ Object awaitUserApi$default(IUserManager r100, long r101, Continuation r102, int r103, Object r104) throws OfficeSDKException {
            if (r104 != null) goto L9;
            if ((r103 & 1) == 0) goto L7;
            r101 = 30000;
        L7:
            return r100.awaitUserApi(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitUserApi");
        }

        public static /* synthetic */ void logout$default(IUserManager r100, ILogoutCallback r101, OfficeSDKPassportUserAction r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = null;
        L7:
            if ((r103 & 2) == 0) goto L9;
            r102 = OfficeSDKPassportUserAction.LOGOUT;
        L9:
            r100.logout(r101, r102);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logout");
        }
    }

    Object awaitUserApi(long r100, Continuation<? super OfficeSDKUserApi> r101) throws OfficeSDKException;

    IOfficeSDKUserHandle createUserHandle(OfficeSDKHostSession r100);

    OfficeSDKUserApi getUserApi();

    void login(ILoginCallback r100);

    Single<OfficeSDKDriveResult> loginRx(OfficeSDKHostSession r100);

    i1<IOnlineOfflineService.State> loginState();

    void logout(ILogoutCallback r100, OfficeSDKPassportUserAction r101);

    Single<OfficeSDKDriveResult> logoutRx(OfficeSDKHostSession r100);
}
