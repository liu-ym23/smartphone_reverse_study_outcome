package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.os.SystemClock;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.VideoCoverLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q implements com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.e {
    public final /* synthetic */ AnchorV4VideoView a;

    public static final class a implements Runnable {
        public final /* synthetic */ q a;

        public a(q r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnchorV4VideoView r0 = this.a.a;     // Catch: Throwable -> L8
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r1 = r0.e;     // Catch: Throwable -> L8
            if (r1 == null) goto L5;
            Integer r2 = r1.h();     // Catch: Throwable -> L8
        L6:
            r0.n("pause", r2, false);     // Catch: Throwable -> L8
            return;
        L5:
            r2 = null;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }
    }

    public final void T() {
    }

    public final void U() {
        AnchorV4VideoView r0 = this.a;
        r0.r = SystemClock.elapsedRealtime();
        VideoCoverLayout r1 = this.a.C;
        if (r1 == null) goto L6;
        r1.g();
        return;
    }

    public final void g() {
        VideoCoverLayout r0 = this.a.C;
        if (r0 == null) goto L5;
        int r1 = VideoCoverLayout.t;
        r0.f(false);
    L5:
        AnchorV4VideoView r2 = this.a;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r3 = r2.e;
        if (r3 == null) goto L8;
        Integer r4 = r3.h();
    L9:
        r2.n("pause", r4, true);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final void onPausePlay() {
        if (this.a.t == true) goto L5;
        Lazy r0 = UIUtils.a;
        UIUtils.c().post(new a(this));
    L5:
        VideoCoverLayout r1 = this.a.C;
        if (r1 == null) goto L9;
        r1.e();
        return;
    }

    public final void S() {
        U();
    }

    public q(AnchorV4VideoView r1) {
        this.a = r1;
    }
}
