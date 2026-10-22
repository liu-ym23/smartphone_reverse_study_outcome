package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends uo7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f271330a;

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements pi7.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f271331a;

        @Override // pi7.g
        public final void onFailed() {
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("polaris", "check foreground from init callback");
            this.f271331a.getClass();
            l.l();
        }

        @Override // pi7.g
        public final void onSuccess() {
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("polaris", "check foreground from init callback");
            this.f271331a.getClass();
            l.l();
        }

        public a(l r100) {
            this.f271331a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f271332a = null;

        static {
            f271332a = new l(0);
        }
    }

    public static void l() {
        m r100 = m.a.f271349a;
        com.bytedance.ug.sdk.luckycat.api.depend.d r101 = r100.f271337e;
        if (r101 == null) goto L7;
        bn7.a r102 = ((cn7.a) r101).f24554b;
        if (r102 == null) goto L7;
        r102.isTeenMode();
    L7:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("FissionManager", "is teenMode : false");
        r100.n();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("FissionManager", "is enable fission : false");
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "isEnableProfitRemindDialog:false");
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "isEnablePopUpDialog:false");
        cj7.a.b("check_dialog");
    }

    public l(int r100) {
    }

    @Override // uo7.c, uo7.b
    public final void onEnterForeground(Activity r100) {
        if (q.b.f271365a.f271357b == true) goto L6;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("polaris", "sdk not init");
        return;
    L6:
        i r101 = i.a.f271322a;
        if (r101.f271320b == false) goto L9;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("polaris", "check foreground");
        l();
        return;
    L9:
        a r102 = new a(this);
        List<pi7.g> r103 = r101.f271321c;
        monitor-enter(r103);
        ((ArrayList) r101.f271321c).add(r102);     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
