package com.oplus.ocs.base.common.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.oplus.ocs.base.IAuthenticationListener;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes34.dex */
public class InternalClient implements Handler.Callback {
    private static final int HANDLE_UNBIND = 1001;
    private static final String TAG = null;
    private e mAuthenticateCustomer;
    private String mClient;
    private Context mContext;
    private Handler mHandler;
    private boolean mIsActiveWritePermits;
    private boolean mIsWaitService;
    private IAuthenticationListener mListener;
    private String mPackageName;
    private int mThirdPid;

    static {
        TAG = "InternalClient";
    }

    public boolean connect() {
        e r100 = this.mAuthenticateCustomer;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.a();
    }

    public boolean connect4Stat() {
        e r100 = this.mAuthenticateCustomer;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.b();
    }

    public void serviceUnbind() {
        this.mHandler.sendEmptyMessage(1001);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        com.oplus.ocs.base.utils.a.a(TAG, String.format("current thread - %s and what - %d", new Object[]{ThreadMethodProxy.currentThread().getName(), Integer.valueOf(r100.what)}));
        if (r100.what != 1001) goto L8;
        e r101 = this.mAuthenticateCustomer;
        if (r101 == null) goto L8;
        r101.c();
    L8:
        return false;
    }

    public Intent getServiceIntent(String r100, String r101, String r102) {
        Intent r103 = new Intent(r100);
        r103.setComponent(new ComponentName(r101, r102));
        r103.putExtra("bind_type", 1);
        r103.putExtra("internal_third_packagename", this.mPackageName);
        r103.putExtra("internal_capability_client", this.mClient);
        r103.putExtra("internal_third_pid", this.mThirdPid);
        r103.putExtra("internal_active_write_permits", this.mIsActiveWritePermits);
        r103.putExtra("internal_base_version", "1.0.11");
        r103.putExtra("internal_wait_service", this.mIsWaitService);
        r103.setType("internal_service_" + this.mClient);
        return r103;
    }

    public Intent getServiceIntent4Stat(String r100, String r101, String r102) {
        Intent r103 = new Intent(r100);
        r103.setComponent(new ComponentName(r101, r102));
        r103.putExtra("bind_type", 2);
        r103.putExtra("internal_third_packagename", this.mPackageName);
        r103.putExtra("internal_capability_client", this.mClient);
        r103.setType("internal_service_" + this.mClient);
        return r103;
    }

    public InternalClient(Context r100, String r110, String r111, int r112, boolean r113, IAuthenticationListener r114) {
        this(r100, r110, r111, r112, r113, false, r114);
    }

    public InternalClient(Context r100, String r101, String r102, int r103, boolean r104, boolean r105, IAuthenticationListener r106) {
        this.mIsActiveWritePermits = false;
        this.mContext = r100.getApplicationContext();
        this.mListener = r106;
        this.mPackageName = r101;
        this.mClient = r102;
        this.mThirdPid = r103;
        this.mIsActiveWritePermits = r104;
        this.mIsWaitService = r105;
        PthreadHandlerThreadV2 r107 = new PthreadHandlerThreadV2("internal");
        ThreadMethodProxy.start(r107);
        if (r107.getLooper() == null) goto L5;
        this.mHandler = new Handler(r107.getLooper(), this);
    L6:
        b.a();
        this.mAuthenticateCustomer = b.a(this.mContext, this, this.mListener);
        return;
    L5:
        this.mHandler = new Handler(this);
        goto L6
    }
}
