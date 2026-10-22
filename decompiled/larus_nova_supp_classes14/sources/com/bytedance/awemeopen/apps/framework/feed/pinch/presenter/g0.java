package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.bizmodels.profile.User;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 extends b {
    public boolean h;
    public boolean i;
    public final f0 j;
    public final a k;

    public static final class a implements com.bytedance.awemeopen.infra.base.player.k {
        public final /* synthetic */ g0 a;

        public final void c(String r1) {
        }

        public final void d(String r1, long r2, int r4) {
        }

        public final void e(String r1, int r2, String r3) {
        }

        public final void f(String r1, boolean r2, int r3, int r4) {
        }

        public final void g(String r1, boolean r2, String r3) {
        }

        public final void onPlayPrepare(String r1) {
        }

        public a(g0 r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            sz3.c r0 = this.a.b;
            if (r0 == null) goto L7;
            r14.c r1 = r0.f;
            if (r1 == null) goto L7;
            String r3 = r1.c();
        L9:
            if (Intrinsics.areEqual(r2, r3) == true) goto L11;
            return;
        L11:
            g0 r4 = this.a;
            if (r4.h == true) goto L14;
            r4.g("click_screen");
        L14:
            g0 r5 = this.a;
            r5.h = false;
            r5.i = false;
            return;
        L7:
            r3 = null;
            goto L9
        }

        public final void onPlaying(String r2) {
            sz3.c r0 = this.a.b;
            if (r0 == null) goto L7;
            r14.c r1 = r0.f;
            if (r1 == null) goto L7;
            String r3 = r1.c();
        L9:
            if (Intrinsics.areEqual(r2, r3) == true) goto L11;
            return;
        L11:
            g0 r4 = this.a;
            if (r4.i == true) goto L14;
            r4.h("click_screen");
        L14:
            g0 r5 = this.a;
            r5.h = false;
            r5.i = false;
            return;
        L7:
            r3 = null;
            goto L9
        }

        public final void l(String r1, com.bytedance.awemeopen.infra.base.player.l r2) {
            Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void e() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void c() {
        sz3.c r0 = this.b;
        if (r0 == null) goto L7;
        qz3.b r1 = r0.i;
        if (r1 == null) goto L7;
        r1.p(r0.b, this.j);
    L7:
        sz3.c r2 = this.b;
        if (r2 == null) goto L13;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r3 = r2.c;
        if (r3 == null) goto L14;
        r3.addPlayStateListener(this.k);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void f() {
        sz3.c r0 = this.b;
        if (r0 == null) goto L7;
        qz3.b r1 = r0.i;
        if (r1 == null) goto L7;
        r1.y(this.j);
    L7:
        sz3.c r2 = this.b;
        if (r2 == null) goto L13;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r3 = r2.c;
        if (r3 == null) goto L14;
        r3.removePlayStateListener(this.k);
        return;
    L14:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.f0] */
    public g0(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r2);
        this.j = new f0(this);
        this.k = new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    public final void g(String r9) {
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = com.bytedance.awemeopen.bizmodels.user.d.a;
        Intrinsics.checkNotNull(r0);
        sz3.c r2 = r0.d;
        if (r2 == null) goto L8;
        r14.c r3 = r2.f;
    L10:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r3) == false) goto L12;
        return;
    L12:
        LinkedHashMap r4 = new LinkedHashMap();
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r5 = this.c;
        Intrinsics.checkNotNull(r5);
        sz3.c r6 = r5.d;
        String r7 = "";
        if (r6 == null) goto L16;
        String r8 = r6.e;
        if (r8 == null) goto L16;
    L17:
        r4.put("enter_from", r8);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r10 = this.c;
        Intrinsics.checkNotNull(r10);
        sz3.c r11 = r10.d;
        if (r11 == null) goto L23;
        r14.c r12 = r11.f;
        if (r12 == null) goto L23;
        String r13 = r12.c();
        if (r13 == null) goto L23;
    L24:
        r4.put("group_id", r13);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r14 = this.c;
        Intrinsics.checkNotNull(r14);
        sz3.c r15 = r14.d;
        if (r15 == null) goto L34;
        r14.c r16 = r15.f;
        if (r16 == null) goto L34;
        User r17 = r16.f();
        if (r17 == null) goto L34;
        String r18 = r17.u();
        if (r18 == null) goto L34;
        r7 = r18;
    L34:
        r4.put("author_id", r7);
        r4.put("enter_method", r9);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r19 = this.c;
        Intrinsics.checkNotNull(r19);
        sz3.c r20 = r19.d;
        ?? r21 = 0;
        r21 = 0;
        r21 = 0;
        if (r20 == null) goto L39;
        r14.c r22 = r20.f;
        if (r22 == null) goto L39;
        int r23 = r22.q();
    L40:
        r4.put("item_duration", Integer.valueOf(r23));
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r24 = this.c;
        Intrinsics.checkNotNull(r24);
        sz3.c r25 = r24.d;
        if (r25 == null) goto L47;
        qz3.b r26 = r25.i;
        if (r26 == null) goto L47;
        int r27 = 1;
        if (r26.A() != true) goto L47;
    L48:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r28 = this.c;
        Intrinsics.checkNotNull(r28);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r29 = r28.a;
        if (r29 == null) goto L55;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r30 = r29.c;
        if (r30 == null) goto L55;
        DiscardFirstValueLiveData<Boolean> r31 = r30.getEnterPinchMode();
        if (r31 == null) goto L55;
        r21 = Intrinsics.areEqual(r31.getValue(), Boolean.TRUE);
    L55:
        r4.put("pinch_zoom", Integer.valueOf(r21));
        r4.put("pure_zoom", Integer.valueOf(r27));
        AosEventReporter.s(AosEventReporter.a, "video_play_pause", r4, null, null, null, 28);
        return;
    L47:
        r27 = 0;
    L39:
        r23 = 0;
    L23:
        r13 = "";
    L16:
        r8 = "";
        goto L17
    L8:
        r3 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final void h(String r9) {
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = com.bytedance.awemeopen.bizmodels.user.d.a;
        Intrinsics.checkNotNull(r0);
        sz3.c r2 = r0.d;
        if (r2 == null) goto L8;
        r14.c r3 = r2.f;
    L10:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r3) == false) goto L12;
        return;
    L12:
        LinkedHashMap r4 = new LinkedHashMap();
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r5 = this.c;
        Intrinsics.checkNotNull(r5);
        sz3.c r6 = r5.d;
        String r7 = "";
        if (r6 == null) goto L16;
        String r8 = r6.e;
        if (r8 == null) goto L16;
    L17:
        r4.put("enter_from", r8);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r10 = this.c;
        Intrinsics.checkNotNull(r10);
        sz3.c r11 = r10.d;
        if (r11 == null) goto L23;
        r14.c r12 = r11.f;
        if (r12 == null) goto L23;
        String r13 = r12.c();
        if (r13 == null) goto L23;
    L24:
        r4.put("group_id", r13);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r14 = this.c;
        Intrinsics.checkNotNull(r14);
        sz3.c r15 = r14.d;
        if (r15 == null) goto L34;
        r14.c r16 = r15.f;
        if (r16 == null) goto L34;
        User r17 = r16.f();
        if (r17 == null) goto L34;
        String r18 = r17.u();
        if (r18 == null) goto L34;
        r7 = r18;
    L34:
        r4.put("author_id", r7);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r19 = this.c;
        Intrinsics.checkNotNull(r19);
        sz3.c r20 = r19.d;
        ?? r21 = 0;
        r21 = 0;
        r21 = 0;
        if (r20 == null) goto L39;
        r14.c r22 = r20.f;
        if (r22 == null) goto L39;
        int r23 = r22.q();
    L40:
        r4.put("item_duration", Integer.valueOf(r23));
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r24 = this.c;
        Intrinsics.checkNotNull(r24);
        sz3.c r25 = r24.d;
        if (r25 == null) goto L47;
        qz3.b r26 = r25.i;
        if (r26 == null) goto L47;
        int r27 = 1;
        if (r26.A() != true) goto L47;
    L48:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r28 = this.c;
        Intrinsics.checkNotNull(r28);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r29 = r28.a;
        if (r29 == null) goto L55;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r30 = r29.c;
        if (r30 == null) goto L55;
        DiscardFirstValueLiveData<Boolean> r31 = r30.getEnterPinchMode();
        if (r31 == null) goto L55;
        r21 = Intrinsics.areEqual(r31.getValue(), Boolean.TRUE);
    L55:
        r4.put("pinch_zoom", Integer.valueOf(r21));
        r4.put("pure_zoom", Integer.valueOf(r27));
        if (Intrinsics.areEqual(r9, "click_button") == false) goto L60;
        if (r27 == 0) goto L59;
        r9 = "click_play_button";
        goto L60
    L59:
        r9 = "click_button";
    L60:
        r4.put("enter_method", r9);
        AosEventReporter.s(AosEventReporter.a, "feed_screen_video_play", r4, null, null, null, 28);
        return;
    L47:
        r27 = 0;
    L39:
        r23 = 0;
    L23:
        r13 = "";
    L16:
        r8 = "";
        goto L17
    L8:
        r3 = null;
        goto L10
    }
}
