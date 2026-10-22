package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f277119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f277120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Parcelable f277121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CancellationToken f277123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f277124f;

    public abstract void doExecute(ClientT r100, ResponseErrorCode r101, String r102, TaskCompletionSource<ResultT> r103);

    public int getMinApkVersion() {
        return 30000000;
    }

    public int getApiLevel() {
        return this.f277124f;
    }

    public Parcelable getParcelable() {
        return this.f277121c;
    }

    public String getRequestJson() {
        return this.f277120b;
    }

    public CancellationToken getToken() {
        return this.f277123e;
    }

    public String getTransactionId() {
        return this.f277122d;
    }

    public String getUri() {
        return this.f277119a;
    }

    public void setApiLevel(int r100) {
        this.f277124f = r100;
    }

    public void setParcelable(Parcelable r100) {
        this.f277121c = r100;
    }

    public void setToken(CancellationToken r100) {
        this.f277123e = r100;
    }

    public void setTransactionId(String r100) {
        this.f277122d = r100;
    }

    public TaskApiCall(String r100, String r101) {
        this.f277124f = 1;
        this.f277119a = r100;
        this.f277120b = r101;
        this.f277121c = null;
        this.f277122d = null;
    }

    public TaskApiCall(String r100, String r101, String r102) {
        this.f277124f = 1;
        this.f277119a = r100;
        this.f277120b = r101;
        this.f277121c = null;
        this.f277122d = r102;
    }

    public TaskApiCall(String r100, String r101, String r102, int r103) {
        this.f277119a = r100;
        this.f277120b = r101;
        this.f277121c = null;
        this.f277122d = r102;
        this.f277124f = r103;
    }

    public final void onResponse(ClientT r100, ResponseErrorCode r101, String r102, TaskCompletionSource<ResultT> r103) {
        CancellationToken r104 = this.f277123e;
        if (r104 != null) goto L5;
    L8:
        HMSLog.i("TaskApiCall", "doExecute, uri:" + this.f277119a + ", errorCode:" + r101.getErrorCode() + ", transactionId:" + this.f277122d);
        doExecute(r100, r101, r102, r103);
        return;
    L5:
        if (r104.isCancellationRequested() == false) goto L8;
        HMSLog.i("TaskApiCall", "This Task has been canceled, uri:" + this.f277119a + ", transactionId:" + this.f277122d);
    }
}
