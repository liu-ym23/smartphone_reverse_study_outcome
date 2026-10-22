package com.bytedance.sdk.open.aweme.init;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class DouYinSdkContext {
    private static volatile DouYinSdkContext INSTANCE;
    private String boeProd;
    private String clientKey;
    private boolean isBoe;
    private boolean isPpe;
    private Context mContext;
    private String ppeProd;
    private boolean useClientTicket;

    private DouYinSdkContext() {
        this.mContext = null;
        this.clientKey = null;
        this.isBoe = false;
        this.isPpe = false;
        this.boeProd = null;
        this.ppeProd = null;
        this.useClientTicket = false;
    }

    public static DouYinSdkContext inst() {
        if (INSTANCE != null) goto L15;
        monitor-enter(DouYinSdkContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new DouYinSdkContext();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DouYinSdkContext.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    public String getBoeProd() {
        return this.boeProd;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public Context getContext() {
        Context r100 = this.mContext;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new RuntimeException("please init config");
    }

    public String getPpeProd() {
        return this.ppeProd;
    }

    public boolean isBoe() {
        return this.isBoe;
    }

    public boolean isPpe() {
        return this.isPpe;
    }

    public boolean isUseClientTicket() {
        return this.useClientTicket;
    }

    public void setBoe(boolean r100) {
        this.isBoe = r100;
    }

    public void setBoeProd(String r100) {
        this.boeProd = r100;
    }

    public void setClientKey(String r100) {
        this.clientKey = r100;
    }

    public void setContext(Context r100) {
        if (r100 == null) goto L5;
        this.mContext = r100.getApplicationContext();
        return;
    }

    public void setPpe(boolean r100) {
        this.isPpe = r100;
    }

    public void setPpeProd(String r100) {
        this.ppeProd = r100;
    }

    public void setUseClientTicket(boolean r100) {
        this.useClientTicket = r100;
    }
}
