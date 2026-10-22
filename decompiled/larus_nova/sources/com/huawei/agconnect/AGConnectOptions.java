package com.huawei.agconnect;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface AGConnectOptions {
    boolean getBoolean(String r100);

    boolean getBoolean(String r100, boolean r101);

    Context getContext();

    String getIdentifier();

    int getInt(String r100);

    int getInt(String r100, int r101);

    String getPackageName();

    AGCRoutePolicy getRoutePolicy();

    String getString(String r100);

    String getString(String r100, String r101);
}
