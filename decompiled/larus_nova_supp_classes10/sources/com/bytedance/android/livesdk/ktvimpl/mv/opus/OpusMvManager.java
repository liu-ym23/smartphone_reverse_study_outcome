package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import am2.x;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.g;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvapi.model.mv.f;
import com.bytedance.android.livesdk.ktvapi.model.mv.l;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.mv.KtvMvPlayer;
import com.bytedance.android.livesdk.ktvimpl.mv.SmoothEnterSurfaceView;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.j;
import java.io.File;
import java.util.HashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class OpusMvManager {
    public final TextureView a;
    public final SmoothEnterSurfaceView b;
    public boolean c;
    public boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final OpusServiceImpl h;
    public boolean i;
    public SurfaceTexture j;
    public final boolean k;
    public final sb0.b l;
    public final ViewGroup m;
    public final Context n;
    public final KtvContext o;

    public static final class a implements l {
        public final /* synthetic */ OpusMvManager a;

        public a(OpusMvManager r1) {
            this.a = r1;
        }

        public final void a(int r8, od r9) {
            if (r8 != 3) goto L23;
            if (r9 != null) goto L6;
            return;
        L6:
            if (this.a.o.isCurrentUserIsSinger() == false) goto L25;
            Long r10 = KtvLoggerHelper.a;
            if (r9.g() == false) goto L10;
            String r11 = "recommend";
        L11:
            String r0 = r9.f();
            Long r1 = r9.b;
            if (r1 == null) goto L14;
            long r2 = r1.longValue();
        L15:
            long r3 = r2 / ((long) 1000);
            DataCenter r4 = this.a.l.getDataCenter();
            Long r5 = r9.c;
            String r6 = r9.d;
            String r12 = r9.e;
            Intrinsics.checkNotNullParameter(r11, "mvType");
            Intrinsics.checkNotNullParameter(r0, "vId");
            HashMap r7 = new HashMap();
            KtvLoggerHelper.z(r4, r7);
            r7.put("song_id", String.valueOf(r5));
            if (r6 != null) goto L18;
            r6 = "";
        L18:
            r7.put("song_name", r6);
            if (r12 != null) goto L21;
            r12 = "";
        L21:
            r7.put("from_request_type", r12);
            r7.put("mv_type", r11);
            r7.put("mv_id", r0);
            r7.put("duration", String.valueOf(r3));
            j0.l().sendLog("livesdk_anchor_ksong_mv_play_duration", r7, new Object[]{IRoom.class, x.class});
            return;
        L14:
            r2 = 0;
            goto L15
        L10:
            r11 = "user";
            goto L11
        L25:
            return;
        }
    }

    public static final class b implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ OpusMvManager a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
        }

        public b(OpusMvManager r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
            OpusMvManager r0 = this.a;
            r0.j = r2;
            return !r0.k;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "surface");
            OpusMvManager r6 = this.a;
            if (r6.k == false) goto L15;
            SurfaceTexture r7 = r6.j;
            if (r7 != null) goto L7;
        L13:
            this.a.h.c(new Surface(r3));
        L14:
            this.a.j = r3;
        L16:
            ((Boolean) vm2.d.d5.getValue(null, vm2.d.a[313(0x139, float:4.39E-43)])).booleanValue();
            OpusMvManager r8 = this.a;
            if (r8.e == false) goto L19;
            return;
        L19:
            if (r8.d == true) goto L23;
            r8.h.s();
            this.a.d = true;
            return;
        L23:
            return;
        L7:
            if (Build.VERSION.SDK_INT < 26) goto L13;
            if (r7.isReleased() == true) goto L13;
            if ((!Intrinsics.areEqual(r3, r7)) == false) goto L13;
            this.a.a.setSurfaceTexture(r7);
            r3 = r7;
            goto L14
        L15:
            r6.h.c(new Surface(r3));
            goto L16
        }
    }

    public static com.bytedance.android.live.pushstream.d a() {
        o r0 = m.i();
        if (r0 == null) goto L8;
        j r1 = r0.getLiveStream();
        if (r1 == null) goto L8;
        com.bytedance.android.live.pushstream.d r2 = (com.bytedance.android.live.pushstream.d) r1.getValue();
        if (r2 == null) goto L8;
        return r2;
    L8:
        IInteractService r3 = k.f(IInteractService.class);
        if (r3 == null) goto L13;
        rj0.d r4 = r3.getCommonService();
        if (r4 == null) goto L13;
        return r4.getLiveStream();
    L13:
        return null;
    }

    public final Context getContext() {
        return this.n;
    }

    public final void b(boolean r7) {
        g.f("setVideoSingState:" + r7);
        if (this.c != r7) goto L5;
    L57:
        this.c = r7;
        return;
    L5:
        if (this.l.isAnchor() == false) goto L18;
        if (r7 == true) goto L18;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) this.o.getKtvCoreViewModel().getValue();
        if (r0 == null) goto L18;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
        if (r1 == null) goto L18;
        MusicPanel r2 = r1.b();
        if (r2 == null) goto L18;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L18;
        f r4 = this.h.l(r3.getMId(), r3.getOrderUserIdString());
        g.f("setVideoSingState:" + r4.e());
        od r5 = (od) r4.e().getValue();
        if (r5 == null) goto L18;
        r4.d(r5.f(), r5.e(), true);
    L18:
        this.c = r7;
        SmoothEnterSurfaceView r6 = null;
        if (r7 == false) goto L39;
        if (this.g == false) goto L28;
        this.b.setVisibility(8);
        SmoothEnterSurfaceView r8 = this.b;
        if ((r8 instanceof SmoothEnterSurfaceView) == false) goto L26;
        r6 = r8;
    L26:
        if (r6 == null) goto L28;
        r6.setBusinessVisible(8);
    L28:
        OpusServiceImpl r9 = this.h;
        r9.q();
        r9.a.pause();
        od r10 = r9.f;
        if (r10 == null) goto L31;
        r10.h();
    L31:
        l r11 = r9.n;
        if (r11 == null) goto L34;
        r11.a(1, r9.f);
    L34:
        com.bytedance.android.live.pushstream.d r12 = r9.v;
        if (r12 == null) goto L37;
        r9.f(false, r12, false);
    L37:
        this.o.isPushingExternalVideo().setValue(Boolean.FALSE);
        goto L57
    L39:
        if (this.g == false) goto L46;
        this.b.setVisibility(0);
        SmoothEnterSurfaceView r13 = this.b;
        if ((r13 instanceof SmoothEnterSurfaceView) == false) goto L44;
        r6 = r13;
    L44:
        if (r6 == null) goto L46;
        r6.setBusinessVisible(0);
    L46:
        OpusServiceImpl r14 = this.h;
        f r15 = r14.h;
        if (r15 == null) goto L53;
        NextLiveData r16 = r15.e();
        if (r16 == null) goto L53;
        od r17 = (od) r16.getValue();
        if (r17 == null) goto L53;
        r14.t(r17, true, true);
    L53:
        l r18 = r14.n;
        if (r18 == null) goto L56;
        r18.a(2, r14.f);
    L56:
        r14.q = Long.valueOf(System.currentTimeMillis());
        goto L57
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.SurfaceView, android.view.View, com.bytedance.android.livesdk.ktvimpl.mv.SmoothEnterSurfaceView] */
    public OpusMvManager(sb0.b r18, ViewGroup r19, Context r20, KtvContext r21) {
        Intrinsics.checkNotNullParameter(r18, "dataEntity");
        Intrinsics.checkNotNullParameter(r19, "container");
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r21, "ktvContext");
        this.l = r18;
        this.m = r19;
        this.n = r20;
        this.o = r21;
        TextureView r6 = new TextureView(r20);
        this.a = r6;
        ?? r7 = new SmoothEnterSurfaceView(r20, null);
        this.b = r7;
        ReadOnlyProperty r9 = vm2.d.c5;
        KProperty[] r10 = vm2.d.a;
        this.e = ((Boolean) r9.getValue(null, r10[312(0x138, float:4.37E-43)])).booleanValue();
        String r11 = (String) h.g3.getValue(null, h.a[213(0xd5, float:2.98E-43)]);
        boolean r12 = r18.isAnchor();
        this.f = r12;
        boolean r13 = KtvSettingHelper.z();
        this.g = r13;
        Long r14 = Long.valueOf(r18.b().getRoomId());
        HashMap r15 = new HashMap();
        r15.put(199, 1);
        if (((Boolean) vm2.d.e5.getValue(null, r10[314(0x13a, float:4.4E-43)])).booleanValue() == false) goto L5;
        r15.put(1, 1);
    L5:
        Unit r1 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r15, "map");
        if (r12 == false) goto L8;
        com.bytedance.android.live.pushstream.d r2 = a();
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "stream");
    L9:
        com.bytedance.android.live.ktv.common.music.download.h r8 = com.bytedance.android.live.ktv.common.music.download.h.a;
        StringBuilder r16 = new StringBuilder(KtvCommonConfigParams.a());
        String r17 = File.separator;
        r16.append(r17);
        r16.append("musicPack");
        r16.append(r17);
        r16.append("mv");
        r16.append(r17);
        String r22 = r16.toString();
        Intrinsics.checkNotNullParameter(r20, "context");
        OpusServiceImpl r5 = new OpusServiceImpl(r14, r20, r15, r2);
        r5.j = r11;
        r5.k = r22;
        this.h = r5;
        this.k = ((Boolean) vm2.d.d5.getValue(null, r10[313(0x139, float:4.39E-43)])).booleanValue();
        r21.setOpusMvService(r5);
        r19.setVisibility(0);
        r5.u(new a(this));
        Function1<od, Boolean> r3 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r3, "playInterceptor");
        r5.m = r3;
        Function1<Boolean, Unit> r4 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r4, "cb");
        r5.o = r4;
        KtvMvPlayer r23 = r5.a;
        if ((r23 instanceof com.bytedance.android.live.ktv.common.util.c) == true) goto L12;
        r23 = null;
    L12:
        if (r23 == null) goto L15;
        r21.getStatisticHelper().b(r23);
    L15:
        if (r13 == false) goto L17;
        r5.a.s(r7.getHolder());
        r19.addView(r7, 0, new ViewGroup.LayoutParams(-1, -1));
        r7.setZOrderMediaOverlay(true);
        r5.s();
    L18:
        DataCenter r24 = r18.getDataCenter();
        if (r24 == null) goto L24;
        vlc.d r25 = (vlc.d) r24.get("data_message_manager", null);
        if (r25 == null) goto L25;
        r5.j(r25, true);
        return;
    L25:
        return;
    L24:
        return;
    L17:
        r19.addView(r6, 0, new ViewGroup.LayoutParams(-1, -1));
        r6.setSurfaceTextureListener(new b(this));
        goto L18
    L8:
        r2 = null;
        goto L9
    }
}
