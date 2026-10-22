package com.ttnet.org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import f06.d;
import java.io.IOException;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("net::android")
public class HttpNegotiateAuthenticator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "net_auth";
    private final String mAccountType;
    private Bundle mSpnegoContext;

    public class GetAccountsCallback implements AccountManagerCallback<Account[]> {
        private final RequestData mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Account[]> r110) {
            Account[] r111 = r110.getResult();     // Catch: IOException -> L12 Throwable -> L14 OperationCanceledException -> L16
            if (r111.length != 0) goto L9;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
            return;
        L9:
            if (r111.length <= 1) goto L21;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", new Object[]{Integer.valueOf(r111.length)});
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
            return;
        L21:
            return;
        L14:
            e = move-exception;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", new Object[]{e});
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, -9, null);
        }

        public GetAccountsCallback(HttpNegotiateAuthenticator r100, RequestData r101) {
            this.this$0 = r100;
            this.mRequestData = r101;
        }
    }

    public class GetTokenCallback implements AccountManagerCallback<Bundle> {
        private final RequestData mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        public static /* synthetic */ RequestData access$000(GetTokenCallback r100) {
            return r100.mRequestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> r100) {
            Bundle r101 = r100.getResult();     // Catch: IOException -> L8 AuthenticatorException -> L10 Throwable -> L12
            if (r101.containsKey("intent") == false) goto L6;
            final Context r102 = ContextUtils.getApplicationContext();
            INVOKEVIRTUAL_com_ttnet_org_chromium_net_HttpNegotiateAuthenticator$GetTokenCallback_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r102, new AnonymousClass1(this, r102), new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
            return;
        L6:
            HttpNegotiateAuthenticator.access$100(this.this$0, r101, this.mRequestData);
            return;
        L12:
            e = move-exception;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to obtain a token.", new Object[]{e});
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, -9, null);
        }

        public GetTokenCallback(HttpNegotiateAuthenticator r100, RequestData r101) {
            this.this$0 = r100;
            this.mRequestData = r101;
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static Intent INVOKEVIRTUAL_com_ttnet_org_chromium_net_HttpNegotiateAuthenticator$GetTokenCallback_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L42:
        L36:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
            throw e;
        L40:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
            if (r110 == null) goto L25;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
            ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
            int r103 = r102.result;     // Catch: Exception -> L36
            if (r103 == 1) goto L23;
            if (r103 == 2) goto L21;
            if (r103 == 3) goto L19;
            return r100.registerReceiver(r101, r110);
        L19:
            return r102.intent;
        L21:
            return new Intent();
        L23:
            return r100.registerReceiver(r101, r110);
        L25:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
            return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
        L29:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
            return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
        L35:
            return r100.registerReceiver(r101, r110);
        }
    }

    public interface Natives {
        void setResult(long r100, HttpNegotiateAuthenticator r101, int r102, String r103);
    }

    public static class RequestData {
        public Account account;
        public AccountManager accountManager;
        public String authTokenType;
        public long nativeResultObject;
        public Bundle options;

        public RequestData() {
        }
    }

    private void requestTokenWithActivity(Context r100, Activity r101, RequestData r102, String[] r103) {
    }

    private void requestTokenWithoutActivity(Context r100, RequestData r101, String[] r102) {
    }

    static {
    }

    public HttpNegotiateAuthenticator(String r100) {
        this.mAccountType = r100;
    }

    public static HttpNegotiateAuthenticator create(String r100) {
        return new HttpNegotiateAuthenticator(r100);
    }

    private void processResult(Bundle r100, RequestData r110) {
        this.mSpnegoContext = r100.getBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT);
        switch(r100.getInt(HttpNegotiateConstants.KEY_SPNEGO_RESULT, 1)) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L13;
        };
    L5:
        int r101 = NetError.ERR_MALFORMED_IDENTITY;
    L15:
        HttpNegotiateAuthenticatorJni.get().setResult(r110.nativeResultObject, this, r101, r100.getString("authtoken"));
        return;
    L6:
        r101 = NetError.ERR_UNDOCUMENTED_SECURITY_LIBRARY_STATUS;
        goto L15
    L7:
        r101 = NetError.ERR_MISSING_AUTH_CREDENTIALS;
        goto L15
    L8:
        r101 = NetError.ERR_UNSUPPORTED_AUTH_SCHEME;
        goto L15
    L9:
        r101 = NetError.ERR_INVALID_AUTH_CREDENTIALS;
        goto L15
    L10:
        r101 = NetError.ERR_INVALID_RESPONSE;
        goto L15
    L11:
        r101 = NetError.ERR_UNEXPECTED_SECURITY_LIBRARY_STATUS;
        goto L15
    L12:
        r101 = -3;
        goto L15
    L13:
        r101 = -9;
        goto L15
    L14:
        r101 = 0;
        goto L15
    }

    public static /* synthetic */ void access$100(HttpNegotiateAuthenticator r100, Bundle r101, RequestData r102) {
        r100.processResult(r101, r102);
    }

    public boolean lacksPermission(Context r100, String r101, boolean r102) {
        if (r102 == false) goto L8;
        if (Build.VERSION.SDK_INT < 23) goto L8;
        return false;
    L8:
        if (com_ttnet_org_chromium_net_HttpNegotiateAuthenticator_android_content_Context_checkPermission(r100, r101, Process.myPid(), Process.myUid()) == 0) goto L11;
        return true;
    L11:
        return false;
    }

    private static int com_ttnet_org_chromium_net_HttpNegotiateAuthenticator_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_com_ttnet_org_chromium_net_HttpNegotiateAuthenticator_android_content_Context_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public void getNextAuthToken(long r100, String r101, String r102, boolean r103) {
        Context r104 = ContextUtils.getApplicationContext();
        RequestData r105 = new RequestData();
        r105.authTokenType = HttpNegotiateConstants.SPNEGO_TOKEN_TYPE_BASE + r101;
        r105.accountManager = AccountManager.get(r104);
        r105.nativeResultObject = r100;
        String[] r106 = {HttpNegotiateConstants.SPNEGO_FEATURE};
        Bundle r107 = new Bundle();
        r105.options = r107;
        if (r102 == null) goto L5;
        r107.putString(HttpNegotiateConstants.KEY_INCOMING_AUTH_TOKEN, r102);
    L5:
        Bundle r108 = this.mSpnegoContext;
        if (r108 == null) goto L8;
        r105.options.putBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT, r108);
    L8:
        r105.options.putBoolean(HttpNegotiateConstants.KEY_CAN_DELEGATE, r103);
        Activity r109 = ApplicationStatus.getLastTrackedFocusedActivity();
        if (r109 != null) goto L11;
        requestTokenWithoutActivity(r104, r105, r106);
        return;
    L11:
        requestTokenWithActivity(r104, r109, r105, r106);
    }
}
