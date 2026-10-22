package com.bytedance.ug.sdk.luckycat.impl.manager;

/* JADX INFO: loaded from: classes22.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f271310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f271311b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c0 f271312a = null;

        static {
            f271312a = new c0();
        }
    }

    public c0() {
        this.f271311b = false;
        i.a.f271322a.getClass();
        com.bytedance.ug.sdk.luckycat.impl.utils.u r100 = com.bytedance.ug.sdk.luckycat.impl.utils.u.a();
        r100.e("key_next_profit_remind_time");
        this.f271310a = r100.f271527a.getLong("key_next_profit_remind_time", 0);
    }
}
