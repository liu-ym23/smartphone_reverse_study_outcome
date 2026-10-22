package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;

/* JADX INFO: loaded from: classes23.dex */
public class BindingFailedResolution implements IBridgeActivityDelegate, ServiceConnection {
    private static final Object LOCK_CONNECT_TIMEOUT_HANDLER = null;
    private static final int MSG_CONN_TIMEOUT = 2;
    private static final int MSG_SELF_DESTROY_TIMEOUT = 3;
    private static final int REQUEST_CODE = 2003;
    private static final String TAG = "BindingFailedResolution";
    private FailedBinderCallBack.BinderCallBack callBack;
    private Activity curActivity;
    private boolean isStarting;
    private Handler mConnectTimeoutHandler;
    private d promptdlg;
    private Handler selfDestroyHandler;

    public class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BindingFailedResolution f276933a;

        public a(BindingFailedResolution r100) {
            this.f276933a = r100;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r100) {
            if (r100 != null) goto L4;
            return false;
        L4:
            if (r100.what != 3) goto L10;
            HMSLog.i(BindingFailedResolution.TAG, "selfDestroyHandle：MSG_SELF_DESTROY_TIMEOUT");
            BindingFailedResolution.access$000(this.f276933a);
            BindingFailedResolution.access$100(this.f276933a, 8);
            return true;
        L10:
            return false;
        }
    }

    public class b implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BindingFailedResolution f276934a;

        public b(BindingFailedResolution r100) {
            this.f276934a = r100;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r100) {
            if (r100 != null) goto L5;
        L9:
            return false;
        L5:
            if (r100.what != 2) goto L9;
            HMSLog.e(BindingFailedResolution.TAG, "In connect, bind core try timeout");
            BindingFailedResolution.access$200(this.f276934a, false);
            return true;
        }
    }

    public class c implements AbstractDialog.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BindingFailedResolution f276935a;

        public c(BindingFailedResolution r100) {
            this.f276935a = r100;
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(AbstractDialog r100) {
            BindingFailedResolution.access$402(this.f276935a, null);
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.access$100(this.f276935a, 8);
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(AbstractDialog r100) {
            BindingFailedResolution.access$402(this.f276935a, null);
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.access$100(this.f276935a, 8);
        }
    }

    public static class d extends AbstractPromptDialog {
        private d() {
        }

        public /* synthetic */ d(a r100) {
            this();
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetMessageString(Context r100) {
            String r101 = Util.getAppName(r100, null);
            String r102 = Util.getAppName(r100, HMSPackageManager.getInstance(r100).getHMSPackageNameForMultiService());
            Object[] r103 = new Object[2];
            r103[0] = r101;
            if (TextUtils.isEmpty(r102) == false) goto L5;
            r102 = "com.huawei.hwid";
        L5:
            r103[1] = r102;
            return ResourceLoaderUtil.getString("hms_bindfaildlg_message", r103);
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetPositiveButtonString(Context r100) {
            return ResourceLoaderUtil.getString("hms_confirm");
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 2003;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r100) {
    }

    static {
        LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
    }

    private void cancelConnDelayHandle() {
        Object r100 = LOCK_CONNECT_TIMEOUT_HANDLER;
        monitor-enter(r100);
        Handler r101 = this.mConnectTimeoutHandler;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.removeMessages(2);     // Catch: Throwable -> L9
        this.mConnectTimeoutHandler = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void noticeBindFailed() {
        FailedBinderCallBack.BinderCallBack r100 = this.callBack;
        if (r100 == null) goto L6;
        r100.binderCallBack(8);
        return;
    }

    private void postConnDelayHandle() {
        Handler r100 = this.mConnectTimeoutHandler;
        if (r100 == null) goto L5;
        r100.removeMessages(2);
    L6:
        this.mConnectTimeoutHandler.sendEmptyMessageDelayed(2, 5000);
        return;
    L5:
        this.mConnectTimeoutHandler = new Handler(Looper.getMainLooper(), new b(this));
        goto L6
    }

    private void selfDestroyHandle() {
        Handler r100 = this.selfDestroyHandler;
        if (r100 == null) goto L5;
        r100.removeMessages(3);
    L6:
        this.selfDestroyHandler.sendEmptyMessageDelayed(3, 4000);
        return;
    L5:
        this.selfDestroyHandler = new Handler(Looper.getMainLooper(), new a(this));
        goto L6
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.promptdlg != null) goto L5;
        return;
    L5:
        HMSLog.i(TAG, "re show prompt dialog");
        showPromptdlg();
    }

    public BindingFailedResolution() {
        this.isStarting = true;
        this.mConnectTimeoutHandler = null;
        this.selfDestroyHandler = null;
    }

    private void showPromptdlg() {
        Activity r100 = getActivity();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L14;
        d r101 = this.promptdlg;
        if (r101 != null) goto L10;
        this.promptdlg = new d(null);
    L11:
        HMSLog.i(TAG, "showPromptdlg to resolve conn error");
        this.promptdlg.show(r100, new c(this));
        return;
    L10:
        r101.dismiss();
        goto L11
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        cancelConnDelayHandle();
        BindingFailedResolveMgr.f276936b.b(this.curActivity);
        this.curActivity = null;
    }

    public Activity getActivity() {
        return this.curActivity;
    }

    public static /* synthetic */ void access$000(BindingFailedResolution r100) {
        r100.noticeBindFailed();
    }

    private void bindCoreService(boolean r100) {
        Activity r101 = getActivity();
        if (r101 != null) goto L6;
        HMSLog.e(TAG, "In connect, bind core try fail");
        fireStartResult(false);
        noticeBindResult(r100, 8);
        return;
    L6:
        Intent r102 = new Intent(HMSPackageManager.getInstance(r101.getApplicationContext()).getServiceAction());
        String r103 = HMSPackageManager.getInstance(r101.getApplicationContext()).getHMSPackageNameForMultiService();     // Catch: IllegalArgumentException -> L25
        if (TextUtils.isEmpty(r103) == false) goto L11;
        HMSLog.e(TAG, "servicePackageName is empty, Service is invalid.");     // Catch: IllegalArgumentException -> L25
        fireStartResult(false);     // Catch: IllegalArgumentException -> L25
        noticeBindResult(r100, 1);     // Catch: IllegalArgumentException -> L25
        return;
    L11:
        r102.setPackage(r103);     // Catch: IllegalArgumentException -> L25
        Object r104 = LOCK_CONNECT_TIMEOUT_HANDLER;
        monitor-enter(r104);
    L22:
        th = move-exception;
        throw th;
    L15:
        if (r101.bindService(r102, this, 1) == false) goto L19;
        postConnDelayHandle();     // Catch: Throwable -> L22
        monitor-exit(r104);     // Catch: Throwable -> L22
        return;
    L19:
        monitor-exit(r104);     // Catch: Throwable -> L22
        HMSLog.e(TAG, "In connect, bind core try fail");
        fireStartResult(false);
        noticeBindResult(r100, 8);
        return;
    L25:
        HMSLog.e(TAG, "IllegalArgumentException when bindCoreService intent.setPackage");
        fireStartResult(false);
        noticeBindResult(r100, 8);
    }

    private void finishBridgeActivity(int r100) {
        Activity r101 = getActivity();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isFinishing() == true) goto L10;
        HMSLog.i(TAG, "finishBridgeActivity：" + r100);
        Intent r102 = new Intent();
        r102.putExtra(BridgeActivity.EXTRA_RESULT, r100);
        r101.setResult(-1, r102);
        Util.unBindServiceCatchException(r101, this);
        r101.finish();
        return;
    }

    private void fireStartResult(boolean r100) {
        if (this.isStarting == false) goto L6;
        this.isStarting = false;
        onStartResult(r100);
        return;
    }

    private void tryStartHmsActivity(Activity r100) {
        String r101 = HMSPackageManager.getInstance(r100.getApplicationContext()).getHMSPackageNameForMultiService();
        if (TextUtils.isEmpty(r101) == false) goto L9;
        HMSLog.w(TAG, "servicePackageName is empty, Service is invalid.");
        Handler r102 = this.selfDestroyHandler;
        if (r102 == null) goto L7;
        r102.removeMessages(3);
        this.selfDestroyHandler = null;
    L7:
        bindCoreService(false);
        return;
    L9:
        Intent r103 = new Intent();
        r103.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(r100));
        r103.setClassName(r101, HuaweiApiAvailability.ACTIVITY_NAME);
        HMSLog.i(TAG, "onBridgeActivityCreate：try to start HMS");
        r100.startActivityForResult(r103, getRequestCode());     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        HMSLog.e(TAG, "ActivityNotFoundException：" + th.getMessage());
        Handler r104 = this.selfDestroyHandler;
        if (r104 == null) goto L16;
        r104.removeMessages(3);
        this.selfDestroyHandler = null;
    L16:
        bindCoreService(false);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity r100) {
        if (r100 != null) goto L7;
        HMSLog.e(TAG, "activity is null");
        selfDestroyHandle();
        return;
    L7:
        if (r100.isFinishing() == false) goto L10;
        HMSLog.e(TAG, "activity is finishing");
        return;
    L10:
        Intent r101 = r100.getIntent();
        if (r101 != null) goto L13;
    L20:
        this.curActivity = r100;
        BindingFailedResolveMgr.f276936b.a(r100);
        selfDestroyHandle();
        tryStartHmsActivity(r100);
        return;
    L13:
        if (r101.hasExtra(FailedBinderCallBack.CALLER_ID) == false) goto L20;
        long r102 = 0;
        r102 = r101.getLongExtra(FailedBinderCallBack.CALLER_ID, 0);     // Catch: Exception -> L17
    L19:
        this.callBack = FailedBinderCallBack.getInstance().getCallBack(Long.valueOf(r102));
    L17:
        e = move-exception;
        HMSLog.e(TAG, "getExtras for callId exception:" + e.getMessage());
        goto L19
    }

    public void onStartResult(boolean r100) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L8;
        finishBridgeActivity(0);
        return;
    L8:
        showPromptdlg();
    }

    public static /* synthetic */ void access$100(BindingFailedResolution r100, int r101) {
        r100.finishBridgeActivity(r101);
    }

    public static /* synthetic */ void access$200(BindingFailedResolution r100, boolean r101) {
        r100.fireStartResult(r101);
    }

    public static /* synthetic */ d access$402(BindingFailedResolution r100, d r101) {
        r100.promptdlg = r101;
        return r101;
    }

    private void noticeBindResult(boolean r100, int r101) {
        if (r100 == false) goto L7;
        FailedBinderCallBack.BinderCallBack r102 = this.callBack;
        if (r102 == null) goto L8;
        r102.binderCallBack(r101);
        return;
    L8:
        return;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int r100, KeyEvent r101) {
        HMSLog.i(TAG, "On key up when resolve conn error");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r100, IBinder r101) {
        cancelConnDelayHandle();
        fireStartResult(true);
        if (getActivity() != null) goto L5;
        return;
    L5:
        HMSLog.i(TAG, "test connect success, try to reConnect and reply message");
        BindResolveClients.getInstance().notifyClientReconnect();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int r100, int r101, Intent r102) {
        if (r100 == getRequestCode()) goto L6;
        return false;
    L6:
        HMSLog.i(TAG, "onBridgeActivityResult");
        Handler r103 = this.selfDestroyHandler;
        if (r103 == null) goto L9;
        r103.removeMessages(3);
        this.selfDestroyHandler = null;
    L9:
        bindCoreService(true);
        return true;
    }
}
