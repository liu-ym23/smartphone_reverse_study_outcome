package com.oplus.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.internal.ClientSettings;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes34.dex */
public class m implements OplusApiClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f404248a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Lock f404249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Api f404250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Api.Client f404251d;

    static {
        f404248a = "m";
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public void connect() {
        this.f404249b.lock();
        Api.Client r100 = this.f404251d;     // Catch: Throwable -> L8 Exception -> L10
        if (r100 == null) goto L6;
        r100.connect();     // Catch: Throwable -> L8 Exception -> L10
    L6:
        this.f404249b.unlock();
        return;
    L8:
        th = move-exception;
        this.f404249b.unlock();
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L6
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public void disconnect() {
        this.f404249b.lock();
        Api.Client r100 = this.f404251d;     // Catch: Throwable -> L10 Exception -> L12
        if (r100 != null) goto L6;
    L8:
        this.f404249b.unlock();
        return;
    L6:
        if (r100.isConnected() == false) goto L8;
        this.f404251d.disconnect();     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.f404249b.unlock();
        throw th;
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public AuthResult getAuthResult() {
        Api.Client r100 = this.f404251d;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getAuthResult();
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public Looper getLooper() {
        Api.Client r100 = this.f404251d;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getLooper();
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public IBinder getRemoteService() {
        Api.Client r100 = this.f404251d;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getRemoteService();
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public int getRemoteVersion() {
        Api.Client r100 = this.f404251d;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getMinApkVersion();
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public boolean isConnected() {
        Api.Client r100 = this.f404251d;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isConnected();
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public boolean isConnecting() {
        Api.Client r100 = this.f404251d;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isConnecting();
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public Api getApi() {
        return this.f404250c;
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public <T> void addQueue(TaskListenerHolder<T> r100) {
        Api.Client r101 = this.f404251d;
        if (r101 == null) goto L6;
        r101.addQueue(r100);
        return;
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public void setOnCapabilityAuthListener(i r100) {
        Api.Client r101 = this.f404251d;
        if (r101 == null) goto L6;
        r101.setOnCapabilityAuthListener(r100);
        return;
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public void setOnClearListener(j r100) {
        Api.Client r101 = this.f404251d;
        if (r101 == null) goto L6;
        r101.setOnClearListener(r100);
        return;
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public void setOnConnectionFailedListener(OnConnectionFailedListener r100, Handler r101) {
        Api.Client r102 = this.f404251d;
        if (r102 == null) goto L6;
        r102.setOnConnectionFailedListener(r100, r101);
        return;
    }

    @Override // com.oplus.ocs.base.common.api.OplusApiClient
    public void setOnConnectionSucceedListener(OnConnectionSucceedListener r100, Handler r101) {
        Api.Client r102 = this.f404251d;
        if (r102 == null) goto L6;
        r102.setOnConnectionSucceedListener(r100, r101);
        return;
    }

    public m(Context r100, Api r101, Api.ApiOptions r102, ClientSettings r103) {
        this.f404249b = new ReentrantLock();
        this.f404250c = r101;
        this.f404251d = r101.getClientBuilder().buildClient(r100, Looper.getMainLooper(), r103, r102);
    }
}
