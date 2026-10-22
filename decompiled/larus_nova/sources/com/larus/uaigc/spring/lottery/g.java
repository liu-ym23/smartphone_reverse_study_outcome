package com.larus.uaigc.spring.lottery;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f374131a = null;

    static {
        f374131a = Keva.getRepo("lottery_state", 0);
    }

    public static String a(int r100) {
        return "lottery_state_" + AccountService.f365697a.getUserId() + '_' + r100;
    }
}
