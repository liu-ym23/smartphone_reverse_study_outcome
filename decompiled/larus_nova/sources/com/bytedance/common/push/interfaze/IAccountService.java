package com.bytedance.common.push.interfaze;

import java.util.List;
import rgc.a;
import rgc.c;
import tgc.b;

/* JADX INFO: loaded from: classes3.dex */
public interface IAccountService extends a {
    List<String> getLoginHistoryUids();

    String getSecUid();

    void registerOnAccountSwitchListener(c.d<tgc.c> r100);

    void registerOnLoginListener(c.d<tgc.a> r100);

    void registerOnLogoutListener(c.d<b> r100);
}
