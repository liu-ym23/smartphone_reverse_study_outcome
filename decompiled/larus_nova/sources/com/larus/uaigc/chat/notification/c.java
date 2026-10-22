package com.larus.uaigc.chat.notification;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f371331a = null;

    static {
        f371331a = Keva.getRepo("creation_task", 0);
    }

    public static void a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "msgIdList");
        Keva r101 = f371331a;
        String r102 = "creating_task_list".concat(AccountService.f365697a.getUserId());
        zd9.h.f571481a.getClass();
        r101.storeString(r102, zd9.h.c(r100));
    }
}
