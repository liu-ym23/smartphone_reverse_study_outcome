package com.oplus.ocs.base.common.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.api.Api.ApiOptions;
import com.oplus.ocs.base.common.api.OplusApi;
import com.oplus.ocs.base.internal.ClientSettings;
import com.oplus.ocs.base.task.Task;
import com.oplus.ocs.base.task.TaskImpl;
import com.oplus.ocs.base.utils.ServiceCheck;

/* JADX INFO: loaded from: classes34.dex */
public abstract class OplusApi<O extends Api.ApiOptions, R extends OplusApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    O f404173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f404174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Api<O> f404175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l f404176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ClientSettings f404177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f404178f;

    public void checkAuthResult(CapabilityInfo r100) {
    }

    public String getClientName() {
        return "";
    }

    public abstract int getVersion();

    public abstract boolean hasFeature(String r100);

    public abstract void init();

    public void addThis2Cache() {
        if (this.f404178f == false) goto L6;
        this.f404176d.a(this, this.f404177e);
        return;
    }

    public void checkCapability() {
        if (this.f404176d == null) goto L6;
        l.a(this);
        return;
    }

    public boolean checkExist() {
        if (ServiceCheck.check(this.f404174b, "com.coloros.ocs.opencapabilityservice") == false) goto L5;
        return true;
    L5:
        if (ServiceCheck.check(this.f404174b, "com.oplus.ocs") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public void disconnect() {
        if (this.f404178f == false) goto L6;
        l r100 = this.f404176d;
        Api<O> r101 = this.f404175c;
        Message r102 = r100.f404238b.obtainMessage();
        r102.what = 1;
        r102.obj = r101;
        r100.f404238b.sendMessage(r102);
        return;
    }

    public AuthResult getAuthResult() {
        if (this.f404178f == true) goto L5;
        return null;
    L5:
        return l.d(this);
    }

    public IBinder getRemoteService() {
        if (this.f404178f == true) goto L5;
        return null;
    L5:
        return l.b(this);
    }

    public int getRemoteVersion() {
        if (this.f404178f == true) goto L5;
        return 0;
    L5:
        return l.c(this);
    }

    public boolean isConnected() {
        if (this.f404178f == true) goto L5;
        return true;
    L5:
        return l.e(this);
    }

    public void releaseClientKey() {
        if (this.f404178f == false) goto L6;
        l.a(this.f404175c.getClientKey());
        return;
    }

    public Api<O> getApi() {
        return this.f404175c;
    }

    public static boolean checkInternal(Context r100) {
        return ServiceCheck.a(r100);
    }

    public R addOnConnectionFailedListener(OnConnectionFailedListener r100) {
        return (R) addOnConnectionFailedListener(r100, new Handler(Looper.getMainLooper()));
    }

    public R addOnConnectionSucceedListener(OnConnectionSucceedListener r100) {
        return (R) addOnConnectionSucceedListener(r100, new Handler(Looper.getMainLooper()));
    }

    public R addOnConnectionFailedListener(OnConnectionFailedListener r100, Handler r101) {
        if (this.f404178f == false) goto L5;
        l.a(this, r100, r101);
    L5:
        return this;
    }

    public R addOnConnectionSucceedListener(final OnConnectionSucceedListener r100, Handler r101) {
        if (this.f404178f == false) goto L5;
        this.f404176d.a(this, r100, r101);
    L9:
        return this;
    L5:
        if (r100 == null) goto L9;
        if (r101 != null) goto L8;
        r100.onConnectionSucceed();
        goto L9
    L8:
        r101.post(new AnonymousClass1(this, r100));
        goto L9
    }

    public <TResult> Task<TResult> doRegisterListener(TaskListenerHolder.SuccessNotifier<TResult> r100, TaskListenerHolder.FailureNotifier<TResult> r101) {
        return doRegisterListener(Looper.getMainLooper(), r100, r101);
    }

    public OplusApi(Context r100, Api<O> r101, ClientSettings r102) {
        this(r100, r101, null, r102, true);
    }

    public <TResult> Task<TResult> doRegisterListener(Looper r100, TaskListenerHolder.SuccessNotifier<TResult> r101, TaskListenerHolder.FailureNotifier<TResult> r102) {
        com.oplus.ocs.base.utils.a.a("capability doRegisterListener");
        TaskImpl r103 = new TaskImpl();
        TaskListenerHolder r104 = new TaskListenerHolder(r100, r103, r101, r102);
        if (this.f404178f == false) goto L5;
        l.a(this, r104);
    L5:
        return r103;
    }

    public OplusApi(Activity r100, Api<O> r101, O r102, ClientSettings r110) {
        this(r100, r101, r102, r110, true);
    }

    public OplusApi(Context r100, Api<O> r101, O r102, ClientSettings r110) {
        this(r100, r101, r102, r110, true);
    }

    public OplusApi(Context r100, Api<O> r101, O r110, ClientSettings r111, boolean r112) {
        com.oplus.ocs.base.utils.d.a(r100, "Null context is not permitted.");
        com.oplus.ocs.base.utils.d.a(r101, "Api must not be null.");
        this.f404174b = r100;
        this.f404175c = r101;
        this.f404173a = r110;
        this.f404177e = r111;
        this.f404178f = r112;
        if (r112 == false) goto L7;
        l r102 = l.a(r100);
        this.f404176d = r102;
        r102.a(this, this.f404177e);
        return;
    L7:
        if (r101.isAuth() == true) goto L18;
        String r103 = getClientName();
        if (TextUtils.isEmpty(r103) == false) goto L13;
        Api.Client r104 = getApi().getClientBuilder().buildClient(this.f404174b, Looper.getMainLooper(), r111, null);
        if ((r104 instanceof BaseClient) == false) goto L13;
        r103 = ((BaseClient) r104).getClientName();
    L13:
        String r105 = r103;
        if (TextUtils.isEmpty(r105) == false) goto L16;
        return;
    L16:
        Context r106 = this.f404174b;
        new InternalClient(r106, r106.getPackageName(), r105, 0, false, null).connect4Stat();
        return;
    }
}
