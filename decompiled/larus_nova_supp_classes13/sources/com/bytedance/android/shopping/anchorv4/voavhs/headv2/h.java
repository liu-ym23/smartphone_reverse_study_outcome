package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.shopping.anchorv4.floatwidget.replay.AnchorV4PlaybackArea;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements com.bytedance.android.shopping.anchorv4.video.float.t {
    public final /* synthetic */ HeadScrollStateManager b;

    public static final class a implements Runnable {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        public final void a() {
            HeadScrollStateManager r0 = this.a.b;
            int r1 = HeadScrollStateManager.n;
            r0.getClass();
            int r2 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
            AnchorV4TrackerImpl r3 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r0.m);
            if (r3 == null) goto L11;
            LinkedHashMap r4 = new LinkedHashMap();
            o r5 = r0.g;
            if (r5 == null) goto L9;
            Map<String, Object> r6 = r5.d();
            if (r6 == null) goto L9;
            r4.putAll(r6);
        L9:
            Unit r7 = Unit.INSTANCE;
            r3.c = r4;
            AnchorV4TrackerImpl.b(r3, "main_video_window_show", false, null, false, null, 30);
            return;
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

    public final void a() {
        o r0 = this.b.g;
        if (r0 != null) goto L5;
    L9:
        o r1 = this.b.g;
        if (r1 != null) goto L12;
    L16:
        o r2 = this.b.g;
        if (r2 == null) goto L19;
        r2.a();
    L19:
        HeadScrollStateManager.j(this.b, false);
        return;
    L12:
        if (r1.b() != true) goto L16;
        com.bytedance.android.shopping.anchorv4.video.float.u r3 = this.b.h;
        if (r3 == null) goto L16;
        r3.a();
        goto L16
    L5:
        if (r0.c() != true) goto L9;
        com.bytedance.android.shopping.anchorv4.video.float.u r4 = this.b.h;
        if (r4 == null) goto L16;
        r4.pause();
        goto L16
    }

    public final void onShow() {
        HeadScrollStateManager r0 = this.b;
        a73.g r1 = r0.b;
        if (r1 == null) goto L5;
        r1.X();
    L5:
        a73.g r2 = r0.b;
        boolean r3 = true;
        if (r2 == null) goto L15;
        AnchorV4PlaybackArea r4 = r2.c();
        if (r4 == null) goto L15;
        if (r4.getVisibility() != 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 != true) goto L15;
        boolean r6 = true;
    L16:
        r0.i = r6;
        HeadScrollStateManager r7 = this.b;
        a73.e r8 = r7.d;
        if (r8 != null) goto L19;
    L21:
        r3 = false;
    L22:
        r7.j = r3;
        HeadScrollStateManager r9 = this.b;
        a73.g r10 = r9.b;
        if (r10 == null) goto L25;
        r10.X();
    L25:
        a73.g r11 = r9.b;
        if (r11 == null) goto L30;
        AnchorV4PlaybackArea r12 = r11.c();
        if (r12 == null) goto L30;
        r12.setVisibility(8);
    L30:
        a73.e r13 = r9.d;
        if (r13 == null) goto L33;
        r13.g(false);
    L33:
        this.b.k.post(new a(this));
        return;
    L19:
        if (r8.d() != true) goto L21;
    L12:
        r5 = false;
    L15:
        r6 = false;
        goto L16
    }

    public h(HeadScrollStateManager r1) {
        this.b = r1;
    }

    public final void b(com.bytedance.android.shopping.anchorv4.video.float.i r2) {
        Intrinsics.checkNotNullParameter(r2, "other");
        Intrinsics.checkNotNullParameter(r2, "other");
    }

    public final void c(com.bytedance.android.shopping.anchorv4.video.float.a r2) {
        Intrinsics.checkNotNullParameter(r2, "floatVideo");
        Intrinsics.checkNotNullParameter(r2, "floatVideo");
    }

    public final void onClose(boolean r4) {
        if (r4 == false) goto L5;
        HeadScrollStateManager.j(this.b, true);
    L5:
        HeadScrollStateManager r5 = this.b;
        if (r5.i == false) goto L16;
        a73.g r1 = r5.b;
        if (r1 == null) goto L10;
        r1.X();
    L10:
        a73.g r2 = r5.b;
        if (r2 == null) goto L16;
        AnchorV4PlaybackArea r3 = r2.c();
        if (r3 == null) goto L16;
        r3.setVisibility(0);
    L16:
        if (r5.j == false) goto L20;
        a73.e r6 = r5.d;
        if (r6 == null) goto L20;
        r6.g(true);
    L20:
        this.b.h = null;
    }
}
