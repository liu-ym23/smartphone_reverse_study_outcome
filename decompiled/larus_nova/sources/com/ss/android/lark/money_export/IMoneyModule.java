package com.ss.android.lark.money_export;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes36.dex */
public interface IMoneyModule {
    void createRedPacket(Context r100, String r101, boolean r102, int r103, String r104, String r105);

    void initIAP();

    void openH5(Context r100, String r101);

    void openLynxPage(Context r100, String r101, boolean r102, boolean r103);

    void openRedPacket(Activity r100, String r101, String r102, boolean r103, boolean r104, boolean r105, String r106);

    void openWallet(Context r100);
}
