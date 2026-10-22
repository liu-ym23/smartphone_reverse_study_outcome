package com.larus.api.bussiness;

import com.bytedance.keva.Keva;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f286896a = null;

    static {
        f286896a = Keva.getRepo("key_remind_dou_yin_authorization", 0);
    }

    public static void a(long r100) {
        f286896a.storeLong("last_remind_timestamp", r100);
    }
}
