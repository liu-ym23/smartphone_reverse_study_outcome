package com.ss.android.lark.officesdk.api;

import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0005\u000e\u000f\u0010\u0011\u0012J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00062\u0006\u0010\t\u001a\u00020\rH&¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService;", "", "getState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State;", "online", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineResult;", "params", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineParams;", OperationName.OPERATION_OFFLINE_AVAILABLE, "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OfflineResult;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OfflineParams;", "OnlineParams", "OfflineParams", "State", "OnlineResult", "OfflineResult", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOnlineOfflineService {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OfflineParams;", "", "action", "Lcom/ss/android/lark/officesdk/api/OfficeSDKPassportUserAction;", "<init>", "(Lcom/ss/android/lark/officesdk/api/OfficeSDKPassportUserAction;)V", "getAction", "()Lcom/ss/android/lark/officesdk/api/OfficeSDKPassportUserAction;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OfflineParams {
        private final OfficeSDKPassportUserAction action;

        /* JADX WARN: Multi-variable type inference failed */
        public OfflineParams() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final OfficeSDKPassportUserAction getAction() {
            return this.action;
        }

        public OfflineParams(OfficeSDKPassportUserAction r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.action = r100;
        }

        public /* synthetic */ OfflineParams(OfficeSDKPassportUserAction r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = OfficeSDKPassportUserAction.LOGOUT;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OfflineResult;", "", "<init>", "()V", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OfflineResult {
        public OfflineResult() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineParams;", "", "isFastOnline", "", "<init>", "(Z)V", "()Z", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OnlineParams {
        private final boolean isFastOnline;

        public OnlineParams() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public final boolean isFastOnline() {
            return this.isFastOnline;
        }

        public OnlineParams(boolean r100) {
            this.isFastOnline = r100;
        }

        public /* synthetic */ OnlineParams(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = true;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineResult;", "", "user", "Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "<init>", "(Lcom/ss/android/lark/passport/signinsdk_api/account/User;)V", "getUser", "()Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OnlineResult {
        private final User user;

        public final User getUser() {
            return this.user;
        }

        public OnlineResult(User r100) {
            Intrinsics.checkNotNullParameter(r100, "user");
            this.user = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State;", "", "Offline", "DoingOnline", "Online", "DoingOffline", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State$DoingOffline;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State$DoingOnline;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State$Offline;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State$Online;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface State {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State$DoingOffline;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State;", "params", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OfflineParams;", "<init>", "(Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OfflineParams;)V", "getParams", "()Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OfflineParams;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class DoingOffline implements State {
            private final OfflineParams params;

            public final OfflineParams getParams() {
                return this.params;
            }

            public DoingOffline(OfflineParams r100) {
                Intrinsics.checkNotNullParameter(r100, "params");
                this.params = r100;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State$DoingOnline;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State;", "params", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineParams;", "<init>", "(Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineParams;)V", "getParams", "()Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineParams;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class DoingOnline implements State {
            private final OnlineParams params;

            public final OnlineParams getParams() {
                return this.params;
            }

            public DoingOnline(OnlineParams r100) {
                Intrinsics.checkNotNullParameter(r100, "params");
                this.params = r100;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State$Offline;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State;", "<init>", "()V", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Offline implements State {
            public static final Offline INSTANCE = null;

            static {
                INSTANCE = new Offline();
            }

            private Offline() {
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State$Online;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State;", "result", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineResult;", "<init>", "(Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineResult;)V", "getResult", "()Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineResult;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Online implements State {
            private final OnlineResult result;

            public final OnlineResult getResult() {
                return this.result;
            }

            public Online(OnlineResult r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                this.result = r100;
            }
        }
    }

    i1<State> getState();

    Flow<Result<OfflineResult>> offline(OfflineParams r100);

    Flow<Result<OnlineResult>> online(OnlineParams r100);
}
