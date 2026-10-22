package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* JADX INFO: loaded from: classes23.dex */
public class BinderAdapter implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f276895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f276896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f276897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BinderCallBack f276898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IBinder f276899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f276900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f276901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f276902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f276903i;

    public interface BinderCallBack {
        void onBinderFailed(int r100);

        void onBinderFailed(int r100, Intent r101);

        void onNullBinding(ComponentName r100);

        void onServiceConnected(ComponentName r100, IBinder r101);

        void onServiceDisconnected(ComponentName r100);

        void onTimedDisconnected();
    }

    public int getConnTimeOut() {
        return 0;
    }

    public int getMsgDelayDisconnect() {
        return 0;
    }

    private void a() {
        if (TextUtils.isEmpty(this.f276896b) == false) goto L5;
    L6:
        e();
    L7:
        Intent r100 = new Intent(this.f276896b);
        r100.setPackage(this.f276897c);     // Catch: IllegalArgumentException -> L10
    L11:
        Object r101 = this.f276900f;
        monitor-enter(r101);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (this.f276895a.bindService(r100, this, 1) == false) goto L18;
        g();     // Catch: Throwable -> L22
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L18:
        this.f276901g = true;     // Catch: Throwable -> L22
        monitor-exit(r101);     // Catch: Throwable -> L22
        e();
        return;
    L10:
        HMSLog.e("BinderAdapter", "IllegalArgumentException when bindCoreService intent.setPackage");
        e();
        goto L11
    L5:
        if (TextUtils.isEmpty(this.f276897c) == false) goto L7;
        goto L6
    }

    private void c() {
        Object r100 = this.f276900f;
        monitor-enter(r100);
        Handler r101 = this.f276902h;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.removeMessages(getConnTimeOut());     // Catch: Throwable -> L9
        this.f276902h = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void d() {
        Handler r100 = new Handler(Looper.getMainLooper(), new AnonymousClass2(this));
        this.f276903i = r100;
        r100.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000);
    }

    private void e() {
        HMSLog.e("BinderAdapter", "In connect, bind core service fail");
        ComponentName r100 = new ComponentName(this.f276895a.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");     // Catch: RuntimeException -> L7
        Intent r101 = new Intent();     // Catch: RuntimeException -> L7
        r101.setComponent(r100);     // Catch: RuntimeException -> L7
        r101.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());     // Catch: RuntimeException -> L7
        BinderCallBack r102 = f();     // Catch: RuntimeException -> L7
        if (r102 == null) goto L12;
        r102.onBinderFailed(-1, r101);     // Catch: RuntimeException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        HMSLog.e("BinderAdapter", "getBindFailPendingIntent failed " + e.getMessage());
    }

    private void g() {
        Handler r100 = this.f276902h;
        if (r100 == null) goto L5;
        r100.removeMessages(getConnTimeOut());
    L6:
        this.f276902h.sendEmptyMessageDelayed(getConnTimeOut(), 10000);
        return;
    L5:
        this.f276902h = new Handler(Looper.getMainLooper(), new AnonymousClass1(this));
        goto L6
    }

    private void h() {
        HMSLog.d("BinderAdapter", "removeDelayDisconnectTask.");
        monitor-enter(BinderAdapter.class);
        Handler r100 = this.f276903i;     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        r100.removeMessages(getMsgDelayDisconnect());     // Catch: Throwable -> L9
    L7:
        monitor-exit(BinderAdapter.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.f276895a, this);
    }

    public void updateDelayTask() {
        HMSLog.d("BinderAdapter", "updateDelayTask.");
        monitor-enter(BinderAdapter.class);
        Handler r100 = this.f276903i;     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        r100.removeMessages(getMsgDelayDisconnect());     // Catch: Throwable -> L9
        this.f276903i.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000);     // Catch: Throwable -> L9
    L7:
        monitor-exit(BinderAdapter.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void b() {
        BinderCallBack r100 = f();
        if (r100 == null) goto L6;
        r100.onBinderFailed(-1);
        return;
    }

    private BinderCallBack f() {
        return this.f276898d;
    }

    public String getServiceAction() {
        return this.f276896b;
    }

    public IBinder getServiceBinder() {
        return this.f276899e;
    }

    public static /* synthetic */ void a(BinderAdapter r100) {
        r100.b();
    }

    public static /* synthetic */ BinderCallBack b(BinderAdapter r100) {
        return r100.f();
    }

    public void binder(BinderCallBack r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f276898d = r100;
        a();
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r100) {
        HMSLog.e("BinderAdapter", "Enter onNullBinding, than unBind.");
        if (this.f276901g == false) goto L6;
        this.f276901g = false;
        return;
    L6:
        unBind();
        c();
        BinderCallBack r101 = f();
        if (r101 == null) goto L10;
        r101.onNullBinding(r100);
        return;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r100) {
        HMSLog.i("BinderAdapter", "Enter onServiceDisconnected.");
        BinderCallBack r101 = f();
        if (r101 == null) goto L5;
        r101.onServiceDisconnected(r100);
    L5:
        h();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r100, IBinder r101) {
        HMSLog.i("BinderAdapter", "BinderAdapter Enter onServiceConnected.");
        this.f276899e = r101;
        c();
        BinderCallBack r102 = f();
        if (r102 == null) goto L5;
        r102.onServiceConnected(r100, r101);
    L5:
        d();
    }

    public BinderAdapter(Context r100, String r101, String r102) {
        this.f276900f = new Object();
        this.f276901g = false;
        this.f276902h = null;
        this.f276903i = null;
        this.f276895a = r100;
        this.f276896b = r101;
        this.f276897c = r102;
    }
}
