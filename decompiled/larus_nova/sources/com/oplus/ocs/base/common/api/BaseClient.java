package com.oplus.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.ConnectionResult;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes34.dex */
public abstract class BaseClient<T extends IBinder> implements Api.Client, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f404154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile int f404155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    CapabilityInfo f404156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Queue<TaskListenerHolder> f404157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    j f404158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    i f404159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    d f404160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    e f404161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f404162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Looper f404163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private c f404164k;

    public abstract String getClientName();

    static {
        f404154a = "BaseClient";
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public void connect() {
        e r100 = this.f404161h;
        if (r100 == null) goto L6;
        r100.a();
        return;
    L6:
        this.f404156c = b(3);
        a(3);
        j r101 = this.f404158e;
        if (r101 == null) goto L10;
        r101.a();
        return;
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public void disconnect() {
        this.f404161h.c();
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public AuthResult getAuthResult() {
        return this.f404156c.getAuthResult();
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public boolean isConnected() {
        if (this.f404155b != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public boolean isConnecting() {
        if (this.f404155b != 2) goto L6;
        return true;
    L6:
        return false;
    }

    private void a() {
        if (isConnected() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public int getMinApkVersion() {
        a();
        return this.f404156c.getVersion();
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public T getRemoteService() {
        a();
        return (T) this.f404156c.getBinder();
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public Looper getLooper() {
        return this.f404163j;
    }

    public static CapabilityInfo b(int r100) {
        AuthResult r101 = new AuthResult("", 0, 0, r100, new byte[0]);
        return new CapabilityInfo(new ArrayList(), 1, r101);
    }

    public final void a(Handler r100) {
        d r101 = this.f404160g;
        if (r101 != null) goto L9;
        if (r100 != null) goto L7;
        this.f404160g = new d(this.f404163j, this.f404164k);
        return;
    L7:
        this.f404160g = new d(r100.getLooper(), this.f404164k);
        return;
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        if (r101.getLooper() == r100.getLooper()) goto L15;
        com.oplus.ocs.base.utils.a.a(f404154a, "the new handler looper is not the same as the old one.");
        return;
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public <T> void addQueue(TaskListenerHolder<T> r100) {
        if (isConnected() == false) goto L7;
        a(r100);
        return;
    L7:
        if (this.f404155b != 13) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        a(r100, true);
        return;
    L13:
        a(r100, false);
        return;
    L9:
        r101 = false;
        goto L10
    }

    @Override // com.oplus.ocs.base.common.api.k
    public void onStateChange(int r100) {
        this.f404155b = r100;
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public void setOnCapabilityAuthListener(i r100) {
        this.f404159f = r100;
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public void setOnClearListener(j r100) {
        this.f404158e = r100;
    }

    public final void a(TaskListenerHolder r100) {
        CapabilityInfo r101 = this.f404156c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getAuthResult() != null) goto L7;
        return;
    L7:
        if (this.f404156c.getAuthResult().getErrrorCode() != 1001) goto L10;
        r100.setErrorCode(0);
        return;
    L10:
        r100.setErrorCode(this.f404156c.getAuthResult().getErrrorCode());
    }

    public final void a(int r100) {
        com.oplus.ocs.base.utils.a.a(f404154a, "handleAuthenticateFailure");
        if (this.f404160g != null) goto L5;
        a(null);
    L5:
        Message r101 = Message.obtain();
        r101.what = 101;
        r101.arg1 = r100;
        this.f404160g.sendMessage(r101);
    }

    public BaseClient(Context r100, Looper r101) {
        this.f404155b = 4;
        this.f404157d = new LinkedList();
        this.f404160g = null;
        if (r100 == null) goto L11;
        this.f404162i = r100;
        if (r101 == null) goto L9;
        this.f404163j = r101;
        this.f404164k = c.a(this);
        b.a();
        this.f404161h = b.a(this.f404162i, getClientName(), this.f404164k, this);
        return;
    L9:
        throw new NullPointerException("Looper must not be null");
    L11:
        throw new NullPointerException("null reference");
    }

    private void a(TaskListenerHolder r100, boolean r101) {
        this.f404157d.add(r100);
        if (r101 == false) goto L6;
        connect();
        return;
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public void setOnConnectionFailedListener(OnConnectionFailedListener r100, Handler r101) {
        CapabilityInfo r102 = this.f404156c;
        if (r102 != null) goto L5;
    L11:
        a(r101);
        this.f404160g.f404204b = r100;
        return;
    L5:
        if (r102.getAuthResult() == null) goto L11;
        if (this.f404156c.getAuthResult().getErrrorCode() == 1001) goto L11;
        if (r100 == null) goto L13;
        r100.onConnectionFailed(new ConnectionResult(this.f404156c.getAuthResult().getErrrorCode()));
        return;
    }

    @Override // com.oplus.ocs.base.common.api.Api.Client
    public void setOnConnectionSucceedListener(final OnConnectionSucceedListener r100, Handler r101) {
        CapabilityInfo r102 = this.f404156c;
        if (r102 != null) goto L5;
    L14:
        a(r101);
        this.f404160g.f404203a = r100;
        return;
    L5:
        if (r102.getAuthResult() == null) goto L14;
        if (this.f404156c.getAuthResult().getErrrorCode() != 1001) goto L14;
        if (r100 == null) goto L16;
        if (r101 != null) goto L12;
        r100.onConnectionSucceed();
        return;
    L12:
        r101.post(new AnonymousClass1(this, r100));
        return;
    }
}
