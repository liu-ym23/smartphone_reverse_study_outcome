package com.volcengine.zeus.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class BaseProxyProvider extends ContentProviderProxy {
    private static final long WAIT_TIMEOUT_MS = 3000;
    private volatile String authority;

    public abstract String getPluginName();

    private void logAwaitLoadFailed() {
        if (GlobalParam.getInstance().isDebug() == true) goto L5;
        return;
    L5:
        int r0 = Binder.getCallingUid();
        String r1 = getCallingPackage();
        if (r1 == null) goto L8;
    L14:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "logAwaitLoadFailed, callingUid=" + r0 + ", callingPackage=" + r1);
        return;
    L8:
        if (getContext() == null) goto L14;
        String[] r2 = getContext().getPackageManager().getPackagesForUid(r0);
        if (r2 == null) goto L14;
        if (r2.length <= 0) goto L14;
        r1 = r2[0];
        goto L14
    }

    public BaseProxyProvider() {
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public String getType(Uri r4) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.getType(buildProxyUri(r4, getPluginName()));
    }

    private Uri buildProxyUri(Uri r1, String r2) {
        return a.a(r1, r2);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r2, ProviderInfo r3) {
        super.attachInfo(r2, r3);
        if (r3 == null) goto L11;
        String r4 = r3.authority;
        if (r4 == null) goto L10;
        int r5 = r4.indexOf(59);
        if (r5 < 0) goto L9;
        r4 = r4.substring(0, r5);
    L9:
        this.authority = r4;
        return;
    L10:
        this.authority = null;
        return;
    L11:
        this.authority = null;
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public int delete(Uri r4, Bundle r5) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.delete(buildProxyUri(r4, getPluginName()), r5);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Uri insert(Uri r4, ContentValues r5) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.insert(buildProxyUri(r4, getPluginName()), r5);
    }

    private Uri buildProxyUri(String r1, Uri r2, String r3) {
        return a.a(r1, r2, r3);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r4, String r5, Bundle r6) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L5;
        logAwaitLoadFailed();
    L5:
        if (r6 != null) goto L7;
        r6 = new Bundle();
    L7:
        r6.putString("provider_params", this.authority);
        r6.putString(ContentProviderManager.PROVIDER_PROXY_URI, buildProxyUri(getPluginName(), null, this.authority).toString());
        return super.call(r4, r5, r6);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public int delete(Uri r4, String r5, String[] r6) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.delete(buildProxyUri(r4, getPluginName()), r5, r6);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Uri insert(Uri r4, ContentValues r5, Bundle r6) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.insert(buildProxyUri(r4, getPluginName()), r5, r6);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public int update(Uri r4, ContentValues r5, Bundle r6) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.update(buildProxyUri(r4, getPluginName()), r5, r6);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r4, String r5, String r6, Bundle r7) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L5;
        logAwaitLoadFailed();
    L5:
        if (r7 != null) goto L7;
        r7 = new Bundle();
    L7:
        r7.putString("provider_params", this.authority);
        r7.putString(ContentProviderManager.PROVIDER_PROXY_URI, buildProxyUri(getPluginName(), null, this.authority).toString());
        return super.call(r4, r5, r6, r7);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Cursor query(Uri r4, String[] r5, Bundle r6, CancellationSignal r7) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.query(buildProxyUri(r4, getPluginName()), r5, r6, r7);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public int update(Uri r4, ContentValues r5, String r6, String[] r7) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.update(buildProxyUri(r4, getPluginName()), r5, r6, r7);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Cursor query(Uri r8, String[] r9, String r10, String[] r11, String r12) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.query(buildProxyUri(r8, getPluginName()), r9, r10, r11, r12);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Cursor query(Uri r9, String[] r10, String r11, String[] r12, String r13, CancellationSignal r14) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), WAIT_TIMEOUT_MS) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.query(buildProxyUri(r9, getPluginName()), r10, r11, r12, r13, r14);
    }
}
