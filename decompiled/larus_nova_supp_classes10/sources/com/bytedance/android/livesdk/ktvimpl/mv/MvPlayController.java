package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.message.model.ed;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import com.ss.ttvideoengine.Resolution;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class MvPlayController {
    public volatile boolean a;
    public int b;
    public l c;
    public Function1<? super Integer, Unit> d;
    public Function1<? super KtvMvPlayer, Unit> e;
    public Function1<? super String, Unit> f;
    public Function5<? super String, ? super Long, ? super String, ? super String, ? super Integer, Unit> g;
    public Function3<? super String, ? super Long, ? super String, Boolean> h;
    public Function1<? super l, Unit> i;
    public int j;
    public Function1<? super String, Unit> k;
    public final KtvMvPlayer l;
    public final KtvMvModel m;
    public final com.bytedance.android.livesdk.ktvimpl.mv.b n;
    public final Integer o;
    public final Function0<y> p;

    public static final class a<T> implements IMediaPlayer.OnErrorListener {
        public final /* synthetic */ MvPlayController a;

        public a(MvPlayController r1) {
            this.a = r1;
        }

        public final void a(AbsPlayer r7, int r8, int r9, String r10) {
            com.bytedance.android.live.ktv.common.util.g.c("playError:" + r10);
            MvPlayController r11 = this.a;
            Function5<? super String, ? super Long, ? super String, ? super String, ? super Integer, Unit> r0 = r11.g;
            if (r0 == null) goto L6;
            Unit r12 = (Unit) r0.invoke(r11.l.n(), null, null, r10, Integer.valueOf(r8));
            return;
        }
    }

    public static final class b<T> implements IMediaPlayer.OnFirstFrameListener {
        public final /* synthetic */ MvPlayController a;

        public b(MvPlayController r1) {
            this.a = r1;
        }

        public final void a(AbsPlayer r6) {
            boolean r0 = r6 instanceof KtvMvPlayer;
            if (r0 == true) goto L5;
            AbsPlayer r2 = null;
        L6:
            KtvMvPlayer r3 = (KtvMvPlayer) r2;
            if (r3 == null) goto L9;
            int r4 = r3.o().getDuration();
        L10:
            l r5 = this.a.c;
            if (r5 == null) goto L13;
            r5.a = Integer.valueOf(r4);
        L13:
            MvPlayController r7 = this.a;
            l r8 = r7.c;
            if (r8 == null) goto L18;
            ed r9 = MvPlayController.a(r7, r8, 0);
            if (r9 == null) goto L18;
            this.a.n.b(r9);
        L18:
            Function1<? super KtvMvPlayer, Unit> r10 = this.a.e;
            if (r10 == null) goto L23;
            if (r0 == true) goto L22;
            r6 = null;
        L22:
            Unit r11 = (Unit) r10.invoke((KtvMvPlayer) r6);
        L23:
            this.a.b = 1;
            return;
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = r6;
            goto L6
        }
    }

    public static final class c<T> implements IMediaPlayer.OnPreparedListener {
        public final /* synthetic */ MvPlayController a;

        public c(MvPlayController r1) {
            this.a = r1;
        }

        public final void a(IMediaPlayer r3) {
            AbsPlayer r4 = (AbsPlayer) r3;
            String r1 = null;
            if ((r4 instanceof KtvMvPlayer) == true) goto L5;
            r4 = null;
        L5:
            KtvMvPlayer r5 = (KtvMvPlayer) r4;
            if (r5 == null) goto L8;
            r1 = r5.n();
        L8:
            Function1<? super String, Unit> r6 = this.a.f;
            if (r6 == null) goto L12;
            Unit r7 = (Unit) r6.invoke(r1);
            return;
        }
    }

    public static final class d {
    }

    static {
    }

    public final void c() {
        this.l.pause();
        com.bytedance.android.live.ktv.common.util.g.d("pause play");
        this.b = 2;
        this.a = true;
    }

    public final void d() {
        com.bytedance.android.live.ktv.common.util.g.g("playDefaultMv");
        final KtvMvModel r0 = this.m;
        final Function1<l, Unit> r1 = new MvPlayController$playDefaultMv$1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "cb");
        l r2 = r0.i;
        if (r2 == null) goto L5;
        r1.invoke(r2);
        return;
    L5:
        String r3 = r0.e;
        Function1<l, Unit> r9 = new KtvMvModel$getDefaultMvInfo$1(r0, r1);
        Intrinsics.checkNotNullParameter(r3, "vId");
        Long r4 = r0.k;
        com.bytedance.android.live.ktv.common.util.g.d("requestMvInfoByVid:" + r3 + "---" + r4);
        if (r4 == null) goto L10;
        r4.longValue();
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getAtmosphereVideoInfoByVid(r4, r3, null, null, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(r0, r9), new g(r0, r3)), r0.b);
        return;
    }

    public static boolean b(y r6, l r7) {
        Intrinsics.checkNotNullParameter(r6, "$this$checkMvInfoValid");
        if (r7 != null) goto L6;
        return true;
    L6:
        if (r7.f == r6.b) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(r7.g, r6.d) == false) goto L10;
        return true;
    }

    public static final ed a(MvPlayController r2, l r3, int r4) {
        r2.getClass();
        Integer r0 = r3.a;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        r2.j = r1;
        if (r1 <= 0) goto L18;
        List<ed> r5 = r3.h;
        if (r5 == null) goto L18;
        if ((!r5.isEmpty()) != true) goto L18;
        int r6 = (int) ((r4 / r2.j) * r3.h.size());
        if (r6 < r3.h.size()) goto L20;
        r6 = r3.h.size() - 1;
    L20:
        return (ed) ListProtector.get(r3.h, r6);
    L18:
        return null;
    L5:
        r1 = r2.l.o().getDuration();
        r3.a = Integer.valueOf(r2.l.o().getDuration());
        Unit r7 = Unit.INSTANCE;
        goto L6
    }

    public MvPlayController(KtvMvPlayer r2, KtvMvModel r3, com.bytedance.android.livesdk.ktvimpl.mv.b r4, Integer r5, Function0<y> r6) {
        Intrinsics.checkNotNullParameter(r2, "player");
        Intrinsics.checkNotNullParameter(r3, "mvModel");
        Intrinsics.checkNotNullParameter(r4, "dynamicBgController");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.p = r6;
        r2.o().setIsMute(true);
        r2.setLooping(true);
        r3.f = new AnonymousClass1(this);
        r2.k = new AnonymousClass2(this);
        r3.g = new AnonymousClass3(this);
        ((AbsPlayer) r2).e = new a(this);
        r4.e = new AnonymousClass5(this);
        ((AbsPlayer) r2).f = new b(this);
        r2.k(new AnonymousClass7(this));
        ((AbsPlayer) r2).d = new c(this);
    }

    public static boolean e(MvPlayController r7, l r8, boolean r9, Integer r10, int r11) {
        boolean r1 = false;
        if ((r11 & 1) == 0) goto L6;
        r9 = false;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = null;
    L8:
        r7.getClass();
        com.bytedance.android.live.ktv.common.util.g.g("播放playInfo：" + r8);
        if (r10 != null) goto L12;
    L19:
        KtvMvPlayer r12 = r7.l;
        KtvMvModel r3 = r7.m;
        String r4 = r8.d;
        String r5 = r8.e;
        Long r6 = r8.m;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "vid");
        u r13 = new u(r4, r5, r6);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "request");
        com.bytedance.android.live.ktv.common.util.g.d("requestPlayByVid：" + r13.a);
        if (Intrinsics.areEqual(r13.a, r12.o().getVideoID()) == false) goto L23;
        if (r9 == true) goto L23;
        com.bytedance.android.live.ktv.common.util.g.d("requestPlay：same vid");
    L31:
        if (r1 == false) goto L39;
        r7.b = 1;
        Function1<? super l, Unit> r14 = r7.i;
        if (r14 == null) goto L35;
        Unit r15 = (Unit) r14.invoke(r8);
    L35:
        r7.m.a = r8.d;
        r7.c = r8;
        return r1;
    L39:
        return r1;
    L23:
        r12.o().setVideoID(r13.a);
        r12.o().setPlayAPIVersion(2, null);
        r12.o().setDataSource(new i(r12, r13));
        Long r16 = r13.c;
        if (r16 != null) goto L26;
    L30:
        r12.m(r13.a);
        r12.o().configResolution(Resolution.High);
        r12.n = Long.valueOf(System.currentTimeMillis());
        r12.o().play();
        r1 = true;
        goto L31
    L26:
        if (r12.z == false) goto L30;
        long r0 = r16.longValue();
        if (r0 <= 0) goto L30;
        r12.o().setStartTime((int) r0);
        goto L30
    L12:
        if (r10.intValue() != 2) goto L19;
        String r17 = r8.c;
        if (r17 == null) goto L37;
        r7.l.q(new t(r17, null, null, 14));
        r7.b = 1;
        Function1<? super l, Unit> r18 = r7.i;
        if (r18 == null) goto L18;
        Unit r19 = (Unit) r18.invoke(r8);
    L18:
        r7.m.a = r8.d;
        r7.c = r8;
        return true;
    L37:
        return false;
    }
}
