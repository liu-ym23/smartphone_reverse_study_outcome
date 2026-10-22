package com.ss.android.cert.manager.ablity.service;

import android.content.Context;

/* JADX INFO: loaded from: classes34.dex */
public interface ICertRouterService extends ICertService {

    public interface OpenSchemaCallback {
        void onResult(boolean r100, String r101);
    }

    void openSchema(Context r100, String r101, OpenSchemaCallback r102);
}
