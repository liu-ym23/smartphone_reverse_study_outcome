package com.ss.android.lark.applink.ipc;

import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;

/* JADX INFO: loaded from: classes34.dex */
@RemoteService
public interface AppLinkProxy extends IHookInterface {
    void handle(String r100, AppLink r101);
}
