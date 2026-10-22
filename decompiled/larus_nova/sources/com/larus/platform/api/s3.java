package com.larus.platform.api;

import com.larus.platform.model.TriggerLoginScene;

/* JADX INFO: loaded from: classes4.dex */
public interface s3 {

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ void b() {
            com.larus.platform.service.i3.f365750a.g(TriggerLoginScene.TRIGGER_LOGIN_CLICK_OTHERS);
        }

        public static /* synthetic */ void a(TriggerLoginScene r100, int r101) {
            com.larus.platform.service.i3 r102 = com.larus.platform.service.i3.f365750a;
            if ((r101 & 1) == 0) goto L5;
            r100 = TriggerLoginScene.TRIGGER_LOGIN_CLICK_OTHERS;
        L5:
            r102.d(r100, null);
        }
    }

    boolean a();

    void b();

    boolean c();

    void d(TriggerLoginScene r100, String r101);

    void e();

    boolean f();

    void g(TriggerLoginScene r100);

    boolean h();

    boolean i();
}
