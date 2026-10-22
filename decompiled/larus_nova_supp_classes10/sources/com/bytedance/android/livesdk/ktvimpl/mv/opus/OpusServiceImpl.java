package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.content.Context;
import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.r;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct;
import com.bytedance.android.livesdk.ktvapi.model.mv.f;
import com.bytedance.android.livesdk.ktvapi.model.mv.g;
import com.bytedance.android.livesdk.ktvapi.model.mv.h;
import com.bytedance.android.livesdk.ktvapi.model.mv.k;
import com.bytedance.android.livesdk.ktvimpl.mv.KtvMvPlayer;
import com.bytedance.android.livesdk.ktvimpl.mv.t;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.ag;
import com.bytedance.android.livesdk.message.model.dd;
import com.bytedance.android.livesdk.message.model.ed;
import com.bytedance.android.livesdk.message.model.gd;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.android.livesdkapi.depend.message.MVUrlStruct;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.RoomSongInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class OpusServiceImpl implements g, l {
    public final KtvMvPlayer a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public od f;
    public final ArrayList<f> g;
    public f h;
    public boolean i;
    public String j;
    public String k;
    public r l;
    public Function1<? super od, Boolean> m;
    public com.bytedance.android.livesdk.ktvapi.model.mv.l n;
    public Function1<? super Boolean, Unit> o;
    public int p;
    public Long q;
    public final lb0.b r;
    public final com.bytedance.android.livesdk.ktvimpl.mv.b s;
    public final Long t;
    public final Context u;
    public final com.bytedance.android.live.pushstream.d v;

    public static final class a<T> implements IMediaPlayer.OnErrorListener {
        public final /* synthetic */ OpusServiceImpl a;

        public a(OpusServiceImpl r1) {
            this.a = r1;
        }

        public final void a(AbsPlayer r1, int r2, int r3, String r4) {
            String r5 = "code:" + r2 + ",desc:" + r4;
            Intrinsics.checkNotNullParameter(r5, "str");
            ALogger.e("ktv-opus", r5);
            OpusServiceImpl r6 = this.a;
            if (r6.f == null) goto L6;
            r6.s();
            return;
        }
    }

    public static final class b<T> implements IMediaPlayer.OnFirstFrameListener {
        public final /* synthetic */ OpusServiceImpl a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ RoomSongInfo c;

        public b(OpusServiceImpl r1, Function0 r2, RoomSongInfo r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(AbsPlayer r3) {
            this.b.invoke();
            ed r4 = OpusServiceImpl.p(this.a, this.c, 0);
            if (r4 == null) goto L6;
            this.a.s.b(r4);
            return;
        }
    }

    public final void s() {
        if (r(false) == false) goto L11;
        od r0 = this.f;
        if (r0 == null) goto L7;
        r0.h();
    L7:
        com.bytedance.android.livesdk.ktvapi.model.mv.l r1 = this.n;
        if (r1 == null) goto L12;
        r1.a(3, this.f);
        return;
    L12:
        return;
    }

    public final Float m() {
        lb0.b r0 = this.r;
        Integer r1 = r0.c;
        Integer r2 = r0.d;
        int r3 = 0;
        if (r1 == null) goto L5;
        int r4 = (r1.intValue() >> 16) & 255;
        int r5 = Math.max(r1.intValue() & 255, Math.max((r1.intValue() >> 8) & 255, r4));
    L6:
        if (r2 == null) goto L9;
        int r6 = (r2.intValue() >> 16) & 255;
        r3 = Math.max(r2.intValue() & 255, Math.max((r2.intValue() >> 8) & 255, r6));
    L9:
        return Float.valueOf(Math.max(r5, r3) / 255.0f);
    L5:
        r5 = 0;
        goto L6
    }

    public final void q() {
        if (this.q == null) goto L10;
        int r0 = this.p;
        long r1 = System.currentTimeMillis();
        Long r3 = this.q;
        if (r3 == null) goto L7;
        long r4 = r3.longValue();
    L8:
        this.p = r0 + ((int) (r1 - r4));
        return;
    L7:
        r4 = 0;
        goto L8
    }

    public final void release() {
        this.a.release();
        this.l = null;
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).release();
        goto L4
    L6:
        this.g.clear();
        q();
    }

    public final void stop() {
        this.a.stop();
    }

    public final int n() {
        q();
        return this.p;
    }

    public final h<?> a() {
        return this.a;
    }

    public final lb0.b b() {
        return this.r;
    }

    public final Context getContext() {
        return this.u;
    }

    public final od k() {
        return this.f;
    }

    public final void c(Surface r2) {
        this.a.setSurface(r2);
    }

    public final void h(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        this.a.q(new t(r5, null, null, 14));
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof gd) == true) goto L5;
        r5 = null;
    L5:
        gd r6 = (gd) r5;
        if (r6 == null) goto L17;
        dd r7 = r6.videoContent;
        if (r7 == null) goto L18;
        Long r0 = r7.c();
        if (r0 == null) goto L12;
        long r1 = r0.longValue();
    L13:
        String r2 = r7.a();
        od r8 = r7.b();
        if (r8 == null) goto L19;
        d(r8, new k(r1, r2), false);
        return;
    L19:
        return;
    L12:
        r1 = 0;
        goto L13
    L18:
        return;
    }

    public final boolean r(boolean r7) {
        String r0 = this.j;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (KtvSettingHelper.w() == false) goto L12;
        if (r7 == false) goto L8;
    L15:
        com.bytedance.android.live.ktv.common.util.g.f("playDefaultOffical");
        this.a.q(new t(r0, this.b, this.k, 8));
        com.bytedance.android.live.pushstream.d r8 = this.v;
        if (r8 == null) goto L18;
        f(false, r8, false);
    L18:
        this.f = null;
        return true;
    L8:
        if (Intrinsics.areEqual(this.a.g, r0) == false) goto L15;
        com.bytedance.android.live.ktv.common.util.g.f("playDefaultUrlMv repeat");
        return false;
    L12:
        if (Intrinsics.areEqual(this.a.g, r0) == false) goto L15;
        com.bytedance.android.live.ktv.common.util.g.f("playDefaultUrlMv repeat");
        return false;
    }

    public final void u(OpusMvManager.a r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        this.n = r2;
    }

    public final void g(List<MusicPanel> r14, Function1<? super Long, Boolean> r15) {
        Intrinsics.checkNotNullParameter(r15, "removeInterceptor");
        ArrayList r0 = null;
        if (r14 == null) goto L8;
        List<MusicPanel> r16 = r14;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
    L6:
        if (r17.hasNext() == false) goto L9;
        r1.add(((MusicPanel) r17.next()).a);
    L9:
        ArrayList r18 = new ArrayList();
        Iterator<f> r2 = this.g.iterator();
    L11:
        if (r2.hasNext() == false) goto L33;
        f r3 = r2.next();
        if (r1 == null) goto L27;
        Iterator r5 = r1.iterator();
    L16:
        if (r5.hasNext() == false) goto L25;
        Object r6 = r5.next();
        KtvMusic r7 = (KtvMusic) r6;
        if (r3.getMId() == r7.getMId()) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == false) goto L16;
    L26:
        KtvMusic r9 = (KtvMusic) r6;
    L28:
        if (r9 != null) goto L11;
        if (((Boolean) r15.invoke(Long.valueOf(r3.getMId()))).booleanValue() == false) goto L11;
        r18.add(r3);
        goto L11
    L20:
        if (Intrinsics.areEqual(r3.getSingerId(), r7.getOrderUserIdString()) == false) goto L22;
        r8 = true;
        goto L23
    L25:
        r6 = null;
        goto L26
    L27:
        r9 = null;
        goto L28
    L33:
        if ((!r18.isEmpty()) == false) goto L35;
        r0 = r18;
    L35:
        if (r0 == null) goto L51;
        this.g.removeAll(r0);
        return;
    L51:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void j(vlc.d r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        r2.addMessageListener(MessageType.KTV_MV_VIDEO_MESSAGE.getIntType(), this);
        this.i = r3;
    }

    public final f l(long r9, String r11) {
        Intrinsics.checkNotNullParameter(r11, "singerId");
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        f r2 = (f) r1;
        if (r2.getMId() == r9) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
    L14:
        f r4 = (f) r1;
        if (r4 != null) goto L21;
        Long r5 = this.t;
        if (r5 == null) goto L19;
        long r6 = r5.longValue();
    L20:
        r4 = new rb0.a(r6, r11, r9);
        this.g.add(r4);
        goto L21
    L19:
        r6 = 0;
    L21:
        return r4;
    L8:
        if (Intrinsics.areEqual(r11, r2.getSingerId()) == false) goto L10;
        r3 = true;
        goto L11
    L13:
        r1 = null;
        goto L14
    }

    public final void o(k r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "songInfo");
        f r0 = l(r4.e, r4.f);
        this.h = r0;
        r0.a(r4);
        if (r5 == false) goto L8;
        f r6 = this.h;
        if (r6 == null) goto L9;
        r6.h();
        return;
    L9:
        return;
    }

    public static final ed p(OpusServiceImpl r3, RoomSongInfo r4, int r5) {
        r3.getClass();
        IMVBaseInfo r0 = r4.getMvBaseInfo();
        if (r0 == null) goto L5;
        int r6 = r0.getDuration();
    L7:
        if (r6 <= 0) goto L20;
        List r7 = r4.getMvColorList();
        if (r7 != null) goto L12;
        return null;
    L12:
        if ((!r7.isEmpty()) != true) goto L21;
        int r8 = (int) ((r5 / r6) * r7.size());
        if (r8 < r7.size()) goto L18;
        r8 = r7.size() - 1;
    L18:
        return (ed) ListProtector.get(r7, r8);
    L21:
        return null;
    L20:
        return null;
    L5:
        r6 = r3.a.h();
        goto L7
    }

    public final void d(od r4, k r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "mvInfo");
        Intrinsics.checkNotNullParameter(r5, "mvSongInfo");
        com.bytedance.android.live.ktv.common.util.g.f("handelPlayMvInfo:" + r5 + "---" + r4);
        f r0 = l(r5.e, r5.f);
        String r1 = r5.a;
        if (r1 != null) goto L5;
    L10:
        MusicPanel r7 = r5.b;
        if (r7 == null) goto L14;
        r0.i().b = r7;
    L14:
        if (this.h != null) goto L16;
        this.h = r0;
    L16:
        r0.g(r4);
        f r8 = this.h;
        if (r8 == null) goto L22;
        NextLiveData r9 = r8.e();
        if (r9 == null) goto L22;
        r9.setValue(r4);
    L22:
        if (this.i == true) goto L24;
        if (r6 == true) goto L24;
        return;
    L24:
        t(r4, false, false);
        return;
    L5:
        if ((!TextUtils.isEmpty(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r0.i().a = r1;
        goto L10
    }

    public final void f(boolean r2, com.bytedance.android.live.pushstream.d r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "liveStream");
        if (r2 == true) goto L5;
    L9:
        if (r2 == false) goto L11;
    L16:
        if (r4 == false) goto L24;
        Function1<? super Boolean, Unit> r5 = this.o;
        if (r5 == null) goto L25;
        Unit r6 = (Unit) r5.invoke(Boolean.valueOf(r2));
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if (this.l == null) goto L16;
        this.a.o().setExtraSurface(null, 3);
        Function1<? super Boolean, Unit> r7 = this.o;
        if (r7 == null) goto L15;
        Unit r8 = (Unit) r7.invoke(Boolean.FALSE);
    L15:
        this.l = null;
        return;
    L5:
        if (this.l != null) goto L9;
        r r9 = new r(r3, this.d, this.e);
        r9.a();
        Unit r10 = Unit.INSTANCE;
        this.l = r9;
        Function1<? super Boolean, Unit> r11 = this.o;
        if (r11 == null) goto L21;
        Unit r12 = (Unit) r11.invoke(Boolean.TRUE);
        return;
    }

    public final void i(final RoomSongInfo r3, Function0<Unit> r4, final Function1<? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "songInfo");
        Intrinsics.checkNotNullParameter(r4, "onFirstFrameCallback");
        Intrinsics.checkNotNullParameter(r5, "onProgressCallback");
        KtvMvPlayer r0 = this.a;
        ((AbsPlayer) r0).f = new b(this, r4, r3);
        r0.k(new OpusServiceImpl$fetchSongInfo$2(this, r3, r5));
        IMVBaseInfo r6 = r3.getMvBaseInfo();
        if (r6 == null) goto L10;
        IMVUrlStruct r7 = r6.getDownloadAddr();
        if (r7 == null) goto L10;
        List r8 = r7.getUrlList();
        if (r8 == null) goto L10;
        String r9 = (String) ListProtector.get(r8, 0);
        if (r9 == null) goto L10;
    L11:
        h(r9);
        return;
    L10:
        r9 = "";
        goto L11
    }

    public final void t(od r18, boolean r19, boolean r20) {
        com.bytedance.android.live.ktv.common.util.g.f("playThisMvInfo:" + r18);
        if (Intrinsics.areEqual(this.f, r18) == false) goto L7;
        if (r19 == true) goto L7;
        com.bytedance.android.live.ktv.common.util.g.f("playThisMvInfo fail");
        return;
    L7:
        boolean r4 = Intrinsics.areEqual(r18.f(), this.c);
        String r5 = r18.d();
        if (r5 == null) goto L78;
        Function1<? super od, Boolean> r6 = this.m;
        if (r6 != null) goto L12;
    L14:
        f r7 = this.h;
        if (r7 == null) goto L17;
        k r8 = r7.i();
    L18:
        if (r8 == null) goto L31;
        if (r18.g() == false) goto L23;
        if (r4 == true) goto L23;
        r8.d++;
    L25:
        r18.c = Long.valueOf(r8.e);
        MusicPanel r9 = r8.b;
        if (r9 == null) goto L28;
        String r10 = r9.d;
    L29:
        r18.e = r10;
        r18.d = r8.a;
        goto L31
    L28:
        r10 = null;
    L23:
        if (r4 == true) goto L25;
        r8.c++;
    L31:
        if ((!Intrinsics.areEqual(this.f, r18)) == false) goto L41;
        od r11 = this.f;
        if (r11 == null) goto L35;
        r11.h();
    L35:
        com.bytedance.android.livesdk.ktvapi.model.mv.l r12 = this.n;
        if (r12 == null) goto L38;
        r12.a(3, this.f);
    L38:
        od r13 = this.f;
        if (r13 == null) goto L41;
        r13.a = null;
        r13.b = null;
    L41:
        this.f = r18;
        r18.h();
        if (r18.g() == true) goto L61;
        ag r14 = r18.a();
        if (r14 == null) goto L46;
        MVUrlStruct r15 = r14.b();
    L47:
        if (r15 == null) goto L54;
        Long r16 = Long.valueOf(r15.getHeight());
        if (r16.longValue() <= 0) goto L51;
        boolean r17 = true;
    L52:
        if (r17 == false) goto L54;
    L55:
        if (r16 != null) goto L58;
        this.a.u(2);
    L63:
        if (this.q != null) goto L65;
        this.q = Long.valueOf(System.currentTimeMillis());
    L65:
        if (r4 == false) goto L67;
        r(r19);
    L68:
        com.bytedance.android.livesdk.ktvapi.model.mv.l r2 = this.n;
        if (r2 == null) goto L72;
        r2.a(2, this.f);
    L72:
        if (this.v != null) goto L74;
        return;
    L74:
        if (r18.g() == false) goto L76;
        f(false, this.v, r20);
        return;
    L76:
        f(true, this.v, r20);
        return;
    L67:
        this.a.q(new t(r5, null, null, 14));
        goto L68
    L58:
        if ((r15.getWidth() / r15.getHeight()) <= ((Number) vm2.h.p4.getValue(null, vm2.h.a[274(0x112, float:3.84E-43)])).floatValue()) goto L60;
        this.a.u(4);
        goto L63
    L60:
        this.a.u(2);
        goto L63
    L51:
        r17 = false;
    L54:
        r16 = null;
        goto L55
    L46:
        r15 = null;
        goto L47
    L61:
        this.a.u(2);
        goto L63
    L17:
        r8 = null;
        goto L18
    L12:
        if (((Boolean) r6.invoke(r18)).booleanValue() != true) goto L14;
        return;
    }

    public OpusServiceImpl(Long r2, Context r3, HashMap<Integer, Integer> r4, com.bytedance.android.live.pushstream.d r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.t = r2;
        this.u = r3;
        this.v = r5;
        KtvMvPlayer r6 = new KtvMvPlayer(r3, r4);
        r6.setLooping(true);
        r6.o().setIsMute(true);
        Unit r7 = Unit.INSTANCE;
        this.a = r6;
        this.b = "ttlive_ktv_opus_default_mv";
        ReadOnlyProperty r8 = vm2.h.q4;
        KProperty[] r9 = vm2.h.a;
        this.c = (String) r8.getValue(null, r9[275(0x113, float:3.85E-43)]);
        this.d = ((Number) vm2.h.o4.getValue(null, r9[273(0x111, float:3.83E-43)])).intValue();
        this.e = ((Number) vm2.h.n4.getValue(null, r9[272(0x110, float:3.81E-43)])).intValue();
        this.g = new ArrayList();
        lb0.b r10 = new lb0.b();
        this.r = r10;
        this.s = new com.bytedance.android.livesdk.ktvimpl.mv.b(r10);
        ((AbsPlayer) r6).e = new a(this);
    }

    public final void e(k r3, String r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "songInfo");
        Intrinsics.checkNotNullParameter(r4, "videoId");
        l(r3.e, r3.f).d(r4, r5, r6);
    }
}
