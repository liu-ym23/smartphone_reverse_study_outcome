package com.ss.android.lark.flow.group;

import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.auditsdk.authorization.AuthorizationService;
import com.ss.android.lark.flow.group.page.FlowQRCodeGroupCardActivity;
import com.ss.android.lark.flow.group.page.FlowQRCodeGroupCardActivity$onCreate$1$onJoinGroupButtonClick$1;
import com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowJoinGroupChatUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f423638a = 0;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/flow/group/FlowJoinGroupChatUtil$CallbackWrap;", "Lcom/ss/android/lark/member_manage/export/callback/IJoinGroupCallback;", "callback", "<init>", "(Lcom/ss/android/lark/member_manage/export/callback/IJoinGroupCallback;)V", "getCallback", "()Lcom/ss/android/lark/member_manage/export/callback/IJoinGroupCallback;", "sendApplySuccess", "", "joinGroupChatSuccess", "chatId", "", LynxVideoManagerLite.EVENT_ON_ERROR, "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "onSendApplyError", "onCancelSendApply", "onShowSendApplyDialog", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CallbackWrap implements IJoinGroupCallback {
        private final IJoinGroupCallback callback;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CallbackWrap f423639a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f423640b;

            public a(CallbackWrap r100, String r101) {
                this.f423639a = r100;
                this.f423640b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r100 = this.f423639a.getCallback();     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.joinGroupChatSuccess(this.f423640b);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CallbackWrap f423641a;

            public b(CallbackWrap r100) {
                this.f423641a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r100 = this.f423641a.getCallback();     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.onCancelSendApply();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CallbackWrap f423642a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ErrorResult f423643b;

            public c(CallbackWrap r100, ErrorResult r101) {
                this.f423642a = r100;
                this.f423643b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r100 = this.f423642a.getCallback();     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.onError(this.f423643b);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CallbackWrap f423644a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ErrorResult f423645b;

            public d(CallbackWrap r100, ErrorResult r101) {
                this.f423644a = r100;
                this.f423645b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r100 = this.f423644a.getCallback();     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.onSendApplyError(this.f423645b);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CallbackWrap f423646a;

            public e(CallbackWrap r100) {
                this.f423646a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r100 = this.f423646a.getCallback();     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.onShowSendApplyDialog();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CallbackWrap f423647a;

            public f(CallbackWrap r100) {
                this.f423647a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r100 = this.f423647a.getCallback();     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.sendApplySuccess();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onCancelSendApply() {
            UICallbackExecutor.execute(new b(this));
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onShowSendApplyDialog() {
            UICallbackExecutor.execute(new e(this));
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void sendApplySuccess() {
            UICallbackExecutor.execute(new f(this));
        }

        public final IJoinGroupCallback getCallback() {
            return this.callback;
        }

        public CallbackWrap(IJoinGroupCallback r100) {
            this.callback = r100;
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void joinGroupChatSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            UICallbackExecutor.execute(new a(this, r100));
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onError(ErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "errorResult");
            UICallbackExecutor.execute(new c(this, r100));
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onSendApplyError(ErrorResult r100) {
            UICallbackExecutor.execute(new d(this, r100));
        }
    }

    static {
        owa.a.b().getClass();
        f423638a = AuthorizationService.UserAuthority.LOGIN_USER_DENIED_CODE;
    }

    public static void a(final FlowQRCodeGroupCardActivity r100, final String r101, final List r110, final String r111, final String r112, FlowQRCodeGroupCardActivity$onCreate$1$onJoinGroupButtonClick$1 r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "userList");
        Intrinsics.checkNotNullParameter(r111, "inviterId");
        Intrinsics.checkNotNullParameter(r113, "callback");
        if (TextUtils.isEmpty(r111) == false) goto L5;
    L11:
        Exception r102 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        ErrorResult r103 = new ErrorResult(0);
        ErrorResult.access$002(r103, -1);
        ErrorResult.access$102(r103, -9999);
        ErrorResult.access$202(r103, 0);
        ErrorResult.access$302(r103, r102);
        ErrorResult.access$402(r103, "");
        ErrorResult.access$502(r103, "joinGroupViaQRCode params invalid");
        ErrorResult.access$602(r103, "");
        ErrorResult.access$702(r103, "");
        ErrorResult.access$802(r103, 0);
        ErrorResult.access$902(r103, null);
        ErrorResult.access$1002(r103, null);
        ErrorResult.access$1102(r103, null);
        r113.onError(r103);
        return;
    L5:
        if (TextUtils.isEmpty(r112) == true) goto L11;
        if (TextUtils.isEmpty(r101) == true) goto L11;
        final CallbackWrap r104 = new CallbackWrap(r113);
        RxScheduledExecutor.justInIO(new FlowJoinGroupChatUtil$joinGroupViaQRCode$1(r101, r111, r112, r104, r100, r110));
    }
}
