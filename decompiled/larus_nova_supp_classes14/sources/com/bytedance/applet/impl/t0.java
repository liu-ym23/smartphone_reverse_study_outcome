package com.bytedance.applet.impl;

import com.bytedance.ai.bridge.service.IHostUserDepend;
import com.larus.platform.service.AccountService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t0 implements IHostUserDepend {
    public t0() {
    }

    public final void getBoundPhone() {
    }

    public final void getUserModelExt() {
    }

    public final String getAvatarURL() {
        return AccountService.a.s();
    }

    public final String getNickname() {
        return AccountService.a.getNickname();
    }

    public final String getSecUid() {
        return AccountService.a.getSecUserId();
    }

    public final String getUniqueID() {
        return com.larus.platform.service.o.a.getUserUniqueID();
    }

    public final String getUserId() {
        return com.larus.platform.service.o.a.getUserID();
    }

    public final boolean hasLogin() {
        return AccountService.a.isLogin().booleanValue();
    }
}
