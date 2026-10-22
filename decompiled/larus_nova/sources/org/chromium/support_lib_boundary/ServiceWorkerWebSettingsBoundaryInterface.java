package org.chromium.support_lib_boundary;

/* JADX INFO: loaded from: classes42.dex */
public interface ServiceWorkerWebSettingsBoundaryInterface {
    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkLoads();

    int getCacheMode();

    int getRequestedWithHeaderMode();

    void setAllowContentAccess(boolean r100);

    void setAllowFileAccess(boolean r100);

    void setBlockNetworkLoads(boolean r100);

    void setCacheMode(int r100);

    void setRequestedWithHeaderMode(int r100);
}
