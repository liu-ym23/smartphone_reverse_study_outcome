package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public interface BDNetworkRouterListener {
    public static final int ContextTypeRoutALL = 1;
    public static final int ContextTypeRoutError = 2;
    public static final int ContextTypeRoutFirst = 0;

    int networkRouteCheckNetState(int r100, int r101);

    void onRouteContext(int r100, int r101, String r102);
}
