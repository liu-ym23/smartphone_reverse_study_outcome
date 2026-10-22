package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.os.SystemClock;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PlayerBlockWrapper {
    public boolean a;
    public String b;
    public long c;
    public final PlayerBlock d;
    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b e;
    public final HeaderContentModel f;

    public static final class a implements com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.e {
        public final /* synthetic */ PlayerBlockWrapper a;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.PlayerBlockWrapper$a$a, reason: collision with other inner class name */
        public static final class RunnableC0010a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0010a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PlayerBlockWrapper r0 = this.a.a;     // Catch: Throwable -> L4
                r0.a("pause", r0.e.h(), false);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void T() {
        }

        public final void U() {
            PlayerBlockWrapper r0 = this.a;
            r0.c = SystemClock.elapsedRealtime();
        }

        public final void g() {
            PlayerBlockWrapper r0 = this.a;
            r0.a("pause", r0.e.h(), true);
            if (this.a.d.w() == false) goto L6;
            PlayerBlockWrapper r1 = this.a;
            r1.c = SystemClock.elapsedRealtime();
            return;
        }

        public final void onPausePlay() {
            if (this.a.a == true) goto L6;
            Lazy r0 = UIUtils.a;
            UIUtils.c().post(new RunnableC0010a(this));
            return;
        }

        public final void S() {
            U();
        }

        public a(PlayerBlockWrapper r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    static {
    }

    public PlayerBlockWrapper(PlayerBlock r2, com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r3, HeaderContentModel r4) {
        Intrinsics.checkNotNullParameter(r2, "player");
        Intrinsics.checkNotNullParameter(r3, "videoInfo");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.b = "auto";
        this.c = -1;
        r2.h(new a(this));
        r2.setPlayBlockClickListener(new AnonymousClass2(this));
    }

    public final void a(String r17, Integer r18, boolean r19) {
        if (this.c >= 0) goto L5;
        return;
    L5:
        long r1 = SystemClock.elapsedRealtime();
        HeaderContentModel r3 = this.f;
        if (r3 == null) goto L10;
        boolean r4 = true;
        if (r3.isCommentTest() != true) goto L10;
    L11:
        c63.c r5 = this.d.getLogAction();
        if (r5 == null) goto L18;
        String r6 = this.b;
        if (r4 == false) goto L16;
        String r7 = "inflow";
    L17:
        r5.w(r6, r7, r1 - this.c, r17, r18, null, null, r19, this.d.getFromEntrance());
        goto L18
    L16:
        r7 = "product";
    L18:
        this.c = -1;
        return;
    L10:
        r4 = false;
        goto L11
    }
}
