package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements Runnable {
    public final /* synthetic */ IntroManagerViewModel.c a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ s a;

        public a(s r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            LiveIntroResponse r1 = (LiveIntroResponse) r10;
            int r11 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
            com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[query] retry success, statusCode=" + ((com.bytedance.android.ec.model.g) r1).statusCode);
            if (((com.bytedance.android.ec.model.g) r1).statusCode != 0) goto L5;
            IntroManagerViewModel.c r12 = this.a.a;
            IntroManagerViewModel.handleIntroResp$default(r12.a, r1, r12.b, r12.c, true, false, r12.d, 16, null);
            return;
        L5:
            IntroManagerViewModel.c r13 = this.a.a;
            IntroManagerViewModel.handleIntroResp$default(r13.a, null, r13.b, r13.c, true, false, r13.d, 16, null);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ s a;

        public b(s r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            int r0 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
            com.bytedance.android.livesdk.livecommerce.intro.utils.k.b("[query] retry error, errorMsg=" + r11.getMessage());
            ECExceptionMonitor.e(r11);
            IntroManagerViewModel.c r12 = this.a.a;
            IntroManagerViewModel.handleIntroResp$default(r12.a, null, r12.b, r12.c, true, false, r12.d, 16, null);
        }
    }

    public s(IntroManagerViewModel.c r1) {
        this.a = r1;
    }

    public final void a() {
        IntroManagerViewModel.access$setDelayRunnable$p(this.a.a, null);
        IntroManagerViewModel r0 = this.a.a;
        r r1 = IntroManagerViewModel.access$getRepo$p(r0);
        com.bytedance.android.livesdk.livecommerce.room.model.e r2 = IntroManagerViewModel.access$getLiveRoomInfo$p(this.a.a);
        IntroManagerViewModel.c r3 = this.a;
        IntroManagerViewModel.access$setIntroRetryDispose$p(r0, bk2.c.a(bg4.b.b(r1.a(r2, r3.b, false, true, r3.e, r3.f, r3.g, r3.h)).subscribe(new a(this), new b(this)), this.a.a.getDisposableContext()));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
