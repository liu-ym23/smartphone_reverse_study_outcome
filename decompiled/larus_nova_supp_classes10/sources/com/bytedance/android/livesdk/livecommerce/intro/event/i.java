package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements Runnable {
    public final /* synthetic */ IntroCardEventCenter a;
    public final /* synthetic */ ql.a b;
    public final /* synthetic */ long c;

    public static final class a implements Runnable {
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g a;
        public final /* synthetic */ i b;

        public a(com.bytedance.android.ec.common.api.jump.model.g r1, i r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            v r0 = new v("livesdk_popup_card_show_duration", this.a);     // Catch: Throwable -> L9
            r0.b("duration", this.b.c);     // Catch: Throwable -> L9
            com.bytedance.android.livesdk.livecommerce.intro.event.a r1 = this.b.a.a;     // Catch: Throwable -> L9
            if (r1 == null) goto L6;
            r1.a();     // Catch: Throwable -> L9
            String r2 = "a1128.b3295.c59667.d30609";
        L7:
            r0.i(r2);     // Catch: Throwable -> L9
            return;
        L6:
            r2 = null;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    public i(IntroCardEventCenter r1, ql.a r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IntroCardEventCenter r0 = this.a;     // Catch: Throwable -> L6
        ql.a r1 = this.b;     // Catch: Throwable -> L6
        com.bytedance.android.ec.common.api.jump.model.g r2 = (com.bytedance.android.ec.common.api.jump.model.g) r0.d.invoke(r1);     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        oh.a.c("showDurationEvent", new a(r2, this));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
