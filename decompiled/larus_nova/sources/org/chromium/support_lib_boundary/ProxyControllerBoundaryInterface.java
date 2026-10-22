package org.chromium.support_lib_boundary;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes42.dex */
public interface ProxyControllerBoundaryInterface {
    void clearProxyOverride(Runnable r100, Executor r101);

    void setProxyOverride(String[][] r100, String[] r101, Runnable r102, Executor r103);

    void setProxyOverride(String[][] r100, String[] r101, Runnable r102, Executor r103, boolean r104);
}
