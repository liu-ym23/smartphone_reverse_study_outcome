package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.live.ktv.common.model.bean.SetBgmFunctionType;
import com.bytedance.android.live.ktv.common.music.control.IMusicControlNode;
import com.bytedance.android.live.ktv.common.music.control.KtvMusicControlManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.CutMusicControlNode;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RegionList;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvRoomSingerController extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a implements IMusicControlNode.a {
    public static final /* synthetic */ int H = 0;
    public final oe2.b A;
    public JSONObject B;
    public KtvMusic C;
    public final sb0.b D;
    public final com.bytedance.android.live.pushstream.d E;
    public final oe2.b F;
    public final Function2<Integer, Long, Unit> G;
    public com.bytedance.android.livesdk.ktvimpl.base.sei.f a;
    public boolean b;
    public com.bytedance.android.livesdk.ktvimpl.base.sei.k c;
    public int d;
    public int e;
    public final MutableLiveData<Boolean> f;
    public final MutableLiveData<Boolean> g;
    public long h;
    public long i;
    public long j;
    public boolean k;
    public String l;
    public String m;
    public Disposable n;
    public final CompositeDisposable o;
    public final Disposable p;
    public final long q;
    public final oe2.d r;
    public boolean s;
    public long t;
    public final long u;
    public final KtvContext v;
    public final boolean w;
    public final Lazy x;
    public final Lazy y;
    public final d z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvRoomSingerController a;

        public b(KtvRoomSingerController r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            MusicPanel r7 = this.a.p().f;
            if (r7 == null) goto L13;
            KtvMusic r8 = r7.a;
            if (r8 != null) goto L8;
            return;
        L8:
            if (KtvSettingHelper.z() == false) goto L10;
            JSONObject r9 = KtvRoomSingerController.k(this.a).put("cmd", 0);
        L11:
            this.a.v(r9);
            return;
        L10:
            r9 = KtvRoomSingerController.j(this.a).put("cmd", 0).put("id", r8.getMId());
            goto L11
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvRoomSingerController a;

        public c(KtvRoomSingerController r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            KtvRoomSingerController r6 = this.a;
            MusicPanel r0 = r6.p().f;
            if (r0 == null) goto L7;
            KtvMusic r1 = r0.a;
            if (r1 == null) goto L7;
            long r2 = r1.getMId();
        L8:
            r6.v(com.bytedance.android.livesdk.ktvimpl.base.sei.t.e(3, r2));
            return;
        L7:
            r2 = 0;
            goto L8
        }
    }

    public static final class d extends IHostAppMonitorListener.Stub {
        public d() {
        }

        public final void appEnterBackground(boolean r4, boolean r5) {
            if (r4 == false) goto L7;
            KtvContext.Companion.getClass();
            if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L8;
            Long r6 = KtvLoggerHelper.a;
            LinkedHashMap r7 = new LinkedHashMap();
            KtvLoggerHelper.A(r7);
            j0.l().sendLog("livesdk_anchor_ksonging_exit", r7, new Object[]{IRoom.class, am2.x.class});
            return;
        L8:
            return;
        }
    }

    static {
    }

    public final void b(IMusicControlNode.b r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void g(com.bytedance.android.livesdk.ktvimpl.base.sei.k r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "seiModel");
        Intrinsics.checkNotNullParameter(r3, "sourceSei");
    }

    public final com.bytedance.android.livesdk.ktvimpl.base.i p() {
        return (com.bytedance.android.livesdk.ktvimpl.base.i) this.x.getValue();
    }

    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a q() {
        return (com.bytedance.android.live.ktv.common.tuningpanel.ability.a) this.y.getValue();
    }

    public final void l() {
        this.n.dispose();
        ALogger.i(bb0.b.b(), "有歌词，开始ping, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        this.n = du2.a.b(0, this.q, TimeUnit.MILLISECONDS).subscribe(new b(this));
    }

    public final void m() {
        this.n.dispose();
        ALogger.i(bb0.b.b(), "没有歌词，开始ping, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        this.n = du2.a.b(0, this.q, TimeUnit.MILLISECONDS).subscribe(new c(this));
    }

    public final BaseCoreViewModel o() {
        return (BaseCoreViewModel) this.v.getKtvCoreViewModel().getValue();
    }

    public final void u() {
        String r0 = "togglePause:sendPauseEvent is pause: " + p().m;
        ALogger.i(bb0.b.b(), r0 + ", invoke class :" + KtvRoomSingerController.class.getSimpleName());
        BaseCoreViewModel r1 = o();
        if (r1 != null) goto L5;
        return;
    L5:
        if (p().m == false) goto L7;
        KtvRoomLyricsStateMachineConfig.a r2 = new KtvRoomLyricsStateMachineConfig.a.d(null);
    L8:
        r1.sendEvent(r2, "KtvRoomSingerController");
        return;
    L7:
        r2 = new KtvRoomLyricsStateMachineConfig.a.b(0);
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void i() {
        ALogger.i(bb0.b.b(), "歌曲演唱结束，停止发送sei, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        this.n.dispose();
        this.o.dispose();
        Disposable r0 = this.p;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        p().l();
        Lazy r1 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().b(this.z);
        KtvRoomLyricsStateMachineConfig.d r2 = null;
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L12;
        p().j();
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        if (r3 == null) goto L12;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r4 = r3.getKtvCoreController();
        if (r4 == null) goto L12;
        r4.setValue(null);
    L12:
        BaseCoreViewModel r5 = o();
        if (r5 == null) goto L16;
        r2 = r5.getCurState();
    L16:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L23;
        KtvContext.Companion.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g()) != null) goto L24;
        BaseCoreViewModel r6 = o();
        if (r6 == null) goto L25;
        r6.sendEvent(KtvRoomLyricsStateMachineConfig.a.h.c, "KtvRoomSingerController");
        return;
    L25:
        return;
    L24:
        return;
    }

    public static final JSONObject j(KtvRoomSingerController r6) {
        MusicPanel r0 = r6.p().f;
        if (r0 == null) goto L31;
        KtvMusic r1 = r0.a;
        if (r1 == null) goto L31;
        List r2 = r1.getMLyricUrlList();
        String r3 = "";
        if (r2 == null) goto L11;
        String r4 = (String) CollectionsKt.firstOrNull(r2);
        if (r4 == null) goto L11;
    L12:
        String r5 = "获取歌词url，".concat(r4);
        ALogger.i(bb0.b.b(), r5 + ", invoke class :" + KtvRoomSingerController.class.getSimpleName());
        JSONObject r7 = new JSONObject().put("lyrics_type", r1.getMLyricType()).put("lyrics_offset", Float.valueOf(r1.getMPreviewStartTime()));
        List r8 = r1.getMLyricUrlList();
        if (r8 == null) goto L18;
        String r9 = (String) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L18;
        r3 = r9;
    L18:
        JSONObject r10 = r7.put("lyric_url", r3).put("copyrighted_app_ids", new JSONArray(r1.getCopyrightedAppIds()));
        Map r11 = r1.getGlobalCopyrightRegionInfo();
        if (r11 == null) goto L24;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        RegionList r12 = (RegionList) r11.get(Long.valueOf(com.bytedance.android.livesdk.ktvimpl.base.util.j.d));
        if (r12 == null) goto L24;
        List r13 = r12.getValues();
        if (r13 == null) goto L24;
    L25:
        JSONObject r14 = r10.put("copyrighted_region_ids", new JSONArray(r13));
        MusicPanel r15 = r6.p().f;
        if (r15 != null) goto L28;
        return r14;
    L28:
        if (KtvUtilsKt.B(r15) != true) goto L33;
        r14.put("midi_url", r1.getMidiUrl());
        return r14;
    L33:
        return r14;
    L24:
        r13 = CollectionsKt.emptyList();
    L11:
        r4 = "";
    L31:
        return new JSONObject();
    }

    public static final JSONObject k(KtvRoomSingerController r12) {
        MusicPanel r0 = r12.p().f;
        if (r0 == null) goto L5;
        KtvMusic r1 = r0.a;
    L6:
        if (r1 != null) goto L8;
        JSONObject r2 = new JSONObject();
        r12.B = r2;
        return r2;
    L8:
        KtvMusic r3 = r12.C;
        String r7 = "";
        if (r3 != null) goto L11;
    L29:
        List r4 = r1.getMLyricUrlList();
        if (r4 == null) goto L33;
        String r5 = (String) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L33;
    L34:
        String r6 = "获取歌词url，".concat(r5);
        ALogger.i(bb0.b.b(), r6 + ", invoke class :" + KtvRoomSingerController.class.getSimpleName());
        JSONObject r8 = new JSONObject().put("lyrics_type", r1.getMLyricType()).put("lyrics_offset", Float.valueOf(r1.getMPreviewStartTime()));
        List r9 = r1.getMLyricUrlList();
        if (r9 == null) goto L40;
        String r10 = (String) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L40;
        r7 = r10;
    L40:
        JSONObject r11 = r8.put("lyric_url", r7).put("id", r1.getMId()).put("copyrighted_app_ids", new JSONArray(r1.getCopyrightedAppIds()));
        Map r13 = r1.getGlobalCopyrightRegionInfo();
        if (r13 == null) goto L46;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        RegionList r14 = (RegionList) r13.get(Long.valueOf(com.bytedance.android.livesdk.ktvimpl.base.util.j.d));
        if (r14 == null) goto L46;
        List r15 = r14.getValues();
        if (r15 == null) goto L46;
    L47:
        JSONObject r16 = r11.put("copyrighted_region_ids", new JSONArray(r15));
        MusicPanel r17 = r12.p().f;
        if (r17 != null) goto L50;
    L52:
        r12.B = r16;
        r12.C = r1;
        return r16;
    L50:
        if (KtvUtilsKt.B(r17) != true) goto L52;
        r16.put("midi_url", r1.getMidiUrl());
    L46:
        r15 = CollectionsKt.emptyList();
    L33:
        r5 = "";
        goto L34
    L11:
        if (r3.getMId() != r1.getMId()) goto L29;
        if (KtvSettingHelper.w() == false) goto L55;
        JSONObject r18 = r12.B.put("lyrics_type", r1.getMLyricType()).put("lyrics_offset", Float.valueOf(r1.getMPreviewStartTime()));
        List r19 = r1.getMLyricUrlList();
        if (r19 == null) goto L20;
        String r20 = (String) CollectionsKt.firstOrNull(r19);
        if (r20 == null) goto L20;
        r7 = r20;
    L20:
        JSONObject r21 = r18.put("lyric_url", r7).put("copyrighted_app_ids", new JSONArray(r1.getCopyrightedAppIds()));
        Map r22 = r1.getGlobalCopyrightRegionInfo();
        if (r22 == null) goto L26;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        RegionList r23 = (RegionList) r22.get(Long.valueOf(com.bytedance.android.livesdk.ktvimpl.base.util.j.d));
        if (r23 == null) goto L26;
        List r24 = r23.getValues();
        if (r24 == null) goto L26;
    L27:
        r21.put("copyrighted_region_ids", new JSONArray(r24));
    L26:
        r24 = CollectionsKt.emptyList();
    L55:
        return r12.B;
    L5:
        r1 = null;
        goto L6
    }

    public static void n(KtvRoomSingerController r7) {
        if (r7.k == true) goto L5;
        r7.l = "cut";
    L5:
        BaseCoreViewModel r8 = r7.o();
        if (r8 == null) goto L28;
        KtvRoomLyricsStateMachineConfig.d r9 = r8.getCurState();
        if (r9 == null) goto L29;
        MusicPanel r10 = r9.b();
        if (r10 == null) goto L30;
        KtvContext.Companion.getClass();
        OrderedSongDataContext r0 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.d(KtvContext.a.k());
        if (r0 == null) goto L16;
        List<MusicPanel> r1 = r0.m200getKtvSingSongList();
        if (r1 == null) goto L16;
        MusicPanel r2 = (MusicPanel) KtvUtilsKt.K(r1, 0);
    L17:
        long r3 = r10.a.getMId();
        if (r2 == null) goto L26;
        KtvMusic r4 = r2.a;
        if (r4 == null) goto L26;
        if (r3 != r4.getMId()) goto L26;
        if (r2.a.isOrderedBy(gh0.a.c()) == false) goto L31;
        Lazy r5 = KtvMusicControlManager.d;
        KtvMusicControlManager.a.a().d(new CutMusicControlNode(r10), null);
        return;
    L31:
        return;
    L26:
        Lazy r6 = KtvMusicControlManager.d;
        KtvMusicControlManager.a.a().d(new CutMusicControlNode(r10), null);
        return;
    L16:
        r2 = null;
        goto L17
    L30:
        return;
    L29:
        return;
    }

    public final void a(IMusicControlNode.b r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        IMusicControlNode.OperationType r3 = r2.getType();
        if (t.a[r3.ordinal()] == 1) goto L6;
        return;
    L6:
        if (ChorusContext.Companion.c() == false) goto L8;
        return;
    L8:
        if (((Boolean) KtvSettingHelper.r1.getValue()).booleanValue() == true) goto L12;
        u();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void c(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "valid");
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r3.c;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L5;
        return;
    L5:
        if ((r3.a instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L19;
        MusicPanel r4 = r0.b();
        if (r4 == null) goto L13;
        KtvMusic r5 = r4.a;
        if (r5 == null) goto L13;
        if (KtvUtilsKt.w(r5) != true) goto L13;
    L14:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r6 = q();
        if (r6 == null) goto L21;
        r6.c();
        return;
    L21:
        return;
    L13:
        if (ChorusContext.Companion.c() == true) goto L14;
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void f(com.bytedance.android.livesdk.ktvimpl.base.sei.k r7) {
        Intrinsics.checkNotNullParameter(r7, "seiModel");
        int r0 = r7.C();
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r1 = this.c;
        if (r1 != null) goto L5;
    L6:
        this.c = r7;
    L7:
        int r2 = r7.C();
        if (r2 == 0) goto L59;
        String r3 = "";
        if (r2 == 1) goto L24;
        if (r2 != 2) goto L74;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r8 = r7.w();
        if (r8 == null) goto L20;
        String r9 = r8.h();
        if (r9 == null) goto L20;
        r3 = r9;
    L20:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a.e(r3) == true) goto L63;
        KtvRoomLyricsStateMachineConfig.a.h r10 = KtvRoomLyricsStateMachineConfig.a.h.c;
        BaseCoreViewModel r4 = o();
        if (r4 == null) goto L64;
        r4.sendEvent(r10, "KtvRoomSingerController");
        return;
    L64:
        return;
    L63:
        return;
    L74:
        return;
    L24:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r11 = r7.w();
        if (r11 == null) goto L31;
        String r12 = r11.h();
        if (r12 == null) goto L31;
        r3 = r12;
    L31:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a.e(r3) == true) goto L42;
        Integer r13 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r13 != null) goto L36;
    L37:
        String r14 = "break";
    L39:
        this.l = r14;
        KtvRoomLyricsStateMachineConfig.a.h r15 = KtvRoomLyricsStateMachineConfig.a.h.c;
        BaseCoreViewModel r5 = o();
        if (r5 == null) goto L66;
        r5.sendEvent(r15, "KtvRoomSingerController");
        return;
    L66:
        return;
    L36:
        if (r13.intValue() != 2) goto L37;
        r14 = "cut";
        goto L39
    L42:
        ALogger.i(bb0.b.b(), "receive watting state, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        KtvContext.Companion.getClass();
        MusicPanel r16 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r16 != null) goto L45;
        return;
    L45:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a.d(r16.a) == false) goto L69;
        BaseCoreViewModel r6 = o();
        if (r6 == null) goto L56;
        KtvRoomLyricsStateMachineConfig.d r17 = r6.getCurState();
        if (r17 == null) goto L56;
        MusicPanel r18 = r17.b();
        if (r18 == null) goto L56;
        KtvMusic r19 = r18.a;
        if (r19 == null) goto L56;
        if (r19.getMId() != r16.a.getMId()) goto L56;
        return;
    L56:
        pd2.d.M(pd2.d.n, r16, "singer_comfirm");
        KtvRoomLyricsStateMachineConfig.a.i r20 = new KtvRoomLyricsStateMachineConfig.a.i(r16);
        BaseCoreViewModel r21 = o();
        if (r21 == null) goto L71;
        r21.sendEvent(r20, "KtvRoomSingerController");
        return;
    L71:
        return;
    L69:
        return;
    L59:
        KtvRoomLyricsStateMachineConfig.a.h r22 = KtvRoomLyricsStateMachineConfig.a.h.c;
        BaseCoreViewModel r23 = o();
        if (r23 == null) goto L73;
        r23.sendEvent(r22, "KtvRoomSingerController");
        return;
    L73:
        return;
    L5:
        if (r0 == r1.C()) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void h(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
        KtvRoomLyricsStateMachineConfig.b r3 = (KtvRoomLyricsStateMachineConfig.b) r2.d;
        if (r3 == null) goto L6;
        t(r3);
        return;
    }

    public final void r(int r24) {
        BaseCoreViewModel r1 = o();
        if (r1 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r2 = r1.getCurState();
    L7:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L9;
        r2 = null;
    L9:
        KtvRoomLyricsStateMachineConfig.d.f r3 = (KtvRoomLyricsStateMachineConfig.d.f) r2;
        if (r3 != null) goto L12;
        return;
    L12:
        if (this.d != this.e) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == true) goto L20;
        r3 = null;
    L20:
        if (r3 == null) goto L120;
        KtvRoomLyricsStateMachineConfig.c r5 = r3.d;
        long r7 = r5.a;
        List<com.bytedance.component.lyric.model.b> r6 = r5.c;
        KtvMusic r8 = r5.b.a;
        Boolean r9 = Boolean.FALSE;
        Long r10 = p().f();
        if (r10 == null) goto L24;
        float r11 = r10.longValue() / 1000.0f;
    L25:
        Float r12 = Float.valueOf(r11);
        List<ILinkPlayerInfoBridge> r13 = com.bytedance.android.livesdk.ktvimpl.base.sei.t.a;
        Intrinsics.checkNotNullParameter(r8, "curMusic");
        int r14 = r8.getMLyricType();
        long r15 = r8.getMId();
        if (r12 == null) goto L28;
        float r16 = r12.floatValue();
    L29:
        float r17 = r8.getMPreviewStartTime();
        float r18 = r7 / 1000.0f;
        if (r6 == null) goto L69;
        float r19 = r17;
        long r20 = r7 + ((long) (r17 * 1000.0f));
        if (r6.size() != 1) goto L35;
        Integer r21 = 0;
        String r22 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r6, 0)).e;
        Float r23 = Float.valueOf(1000.0f);
        int r25 = r14;
    L71:
        String r26 = r22;
        Integer r110 = r21;
        Float r27 = r23;
        Float r28 = null;
        String r29 = null;
        Float r30 = null;
        Integer r111 = null;
        Integer r112 = null;
        String r113 = null;
    L72:
        if (r26 == null) goto L74;
        int r114 = r26.length();
    L75:
        if (r113 == null) goto L77;
        int r115 = r113.length();
    L78:
        int r116 = r114 + r115;
        if (r29 == null) goto L81;
        int r117 = r29.length();
    L82:
        int r118 = r116 + r117;
        String r119 = r29;
        KtvRoomLyricsStateMachineConfig.d.f r210 = r3;
        if (r118 < ((Number) vm2.h.u3.getValue(null, vm2.h.a[227(0xe3, float:3.18E-43)])).intValue()) goto L85;
        String r31 = "";
    L86:
        Integer r0 = Integer.valueOf(r25);
        Float r32 = Float.valueOf(r18);
        Long r33 = Long.valueOf(r15);
        Float r34 = Float.valueOf(r16);
        Float r120 = Float.valueOf(r19);
        JSONObject r121 = new JSONObject();
        r121.put("cmd", r24);
        if (r0 == null) goto L89;
        r121.put("lyrics_type", r0.intValue());
    L89:
        JSONArray r35 = new JSONArray();
        if (r110 == null) goto L93;
        r35.put(new JSONObject().put("row", r110.intValue()).put("lyrics", r26).put("duration", r27));
    L93:
        if (r112 == null) goto L95;
        r35.put(new JSONObject().put("row", r112.intValue()).put("lyrics", r113).put("duration", r30));
    L95:
        if (r111 == null) goto L98;
        r35.put(new JSONObject().put("row", r111.intValue()).put("lyrics", r31).put("duration", r28));
    L98:
        if (r35.length() <= 0) goto L100;
        r121.put("lyrics_info", r35);
    L100:
        if (r32 == null) goto L102;
        r121.put("playTime", Float.valueOf(r32.floatValue()));
    L102:
        if (r33 == 0) goto L104;
        r121.put("id", r33.longValue());
    L104:
        if (r34 == 0) goto L106;
        r121.put("duration", Float.valueOf(r34.floatValue()));
    L106:
        if (r120 == null) goto L108;
        r121.put("lyrics_offset", Float.valueOf(r120.floatValue()));
    L108:
        if (r9 == null) goto L111;
        r121.put("show_score", false);
    L111:
        if (KtvUtilsKt.B(r210.d.b) == false) goto L113;
        r121.put("midi_url", r210.d.b.a.getMidiUrl());
    L113:
        v(r121);
        this.d = this.e;
        return;
    L85:
        r31 = r119;
        goto L86
    L81:
        r117 = 0;
        goto L82
    L77:
        r115 = 0;
        goto L78
    L74:
        r114 = 0;
        goto L75
    L35:
        if (r6.size() <= 1) goto L70;
        int r36 = r6.size();
        int r37 = 0;
        String r122 = null;
        Integer r123 = null;
        Float r211 = null;
    L37:
        if (r37 >= r36) goto L68;
        r25 = r14;
        if (r20 <= ((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r37)).b) goto L40;
        if (r37 != (r6.size() - 1)) goto L67;
        r123 = Integer.valueOf(r37);
        String r124 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r37)).e;
        r211 = Float.valueOf(1000.0f);
        r122 = r124;
    L67:
        r37 = r37 + 1;
        r14 = r25;
        goto L37
    L40:
        if (r37 != 0) goto L42;
        int r38 = 0;
    L43:
        Integer r39 = Integer.valueOf(r38);
        r26 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r38)).e;
        int r125 = r38 + 1;
        if (r6.size() <= r125) goto L46;
        r27 = Float.valueOf((((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r125)).b - ((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r38)).b) / 1000.0f);
    L48:
        if (r6.size() <= r125) goto L53;
        r112 = Integer.valueOf(r125);
        r113 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r125)).e;
        r110 = r39;
        int r40 = r38 + 2;
        if (r6.size() <= r40) goto L52;
        Float r41 = Float.valueOf((((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r40)).b - ((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r125)).b) / 1000.0f);
    L54:
        int r126 = r38 + 2;
        if (r6.size() <= r126) goto L61;
        r111 = Integer.valueOf(r126);
        String r42 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r126)).e;
        int r43 = r38 + 3;
        if (r6.size() <= r43) goto L59;
        r28 = Float.valueOf((((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r43)).b - ((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r126)).b) / 1000.0f);
    L60:
        r29 = r42;
    L62:
        r30 = r41;
        goto L72
    L59:
        r28 = Float.valueOf(1000.0f);
        goto L60
    L61:
        r28 = null;
        r29 = null;
        r111 = null;
        goto L62
    L52:
        r41 = Float.valueOf(1000.0f);
        goto L54
    L53:
        r110 = r39;
        r41 = null;
        r112 = null;
        r113 = null;
        goto L54
    L46:
        r27 = Float.valueOf(1000.0f);
        goto L48
    L42:
        r38 = r37 - 1;
        goto L43
    L68:
        r25 = r14;
        r22 = r122;
        r21 = r123;
        r23 = r211;
    L70:
        r25 = r14;
        r22 = null;
        r21 = null;
        r23 = null;
        goto L71
    L69:
        r19 = r17;
        goto L70
    L28:
        KtvMusic.Companion.getClass();
        r16 = KtvMusic.a.a(r8);
        goto L29
    L24:
        r11 = 0.0f;
        goto L25
    L120:
        return;
    L14:
        if (r3.d.c.size() <= 0) goto L16;
        r4 = true;
        goto L17
    L5:
        r2 = null;
        goto L7
    }

    public final void t(KtvRoomLyricsStateMachineConfig.b r39) {
        Intrinsics.checkNotNullParameter(r39, "sideEffect");
        int r4 = 5;
        if ((r39 instanceof KtvRoomLyricsStateMachineConfig.b.e) == false) goto L157;
        KtvRoomLyricsStateMachineConfig.b.e r1 = (KtvRoomLyricsStateMachineConfig.b.e) r39;
        String r7 = "user";
        if (this.D.b().isAnchor() == false) goto L7;
        String r2 = "anchor";
    L13:
        String r9 = r2;
    L15:
        ALogger.i(bb0.b.b(), "handleStartSingForSinger, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        this.h = r1.a.a.getMId();
        this.j = System.currentTimeMillis();
        MusicPanel r3 = r1.a;
        String r8 = com.bytedance.android.live.ktv.common.util.a.b(r3.a);
        if (r8.length() != 0) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L21;
        HashMap r15 = null;
    L22:
        String r11 = r3.d;
        com.bytedance.android.livesdk.log.filter.o r12 = j0.l().c(am2.x.class);
        if ((r12 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L25;
        r12 = null;
    L25:
        com.bytedance.android.livesdk.log.filter.t r13 = (com.bytedance.android.livesdk.log.filter.t) r12;
        if (r13 == null) goto L30;
        Map<String, String> r14 = r13.getMap();
        if (r14 == null) goto L30;
        String r16 = r14.get("enter_from_merge");
    L32:
        if (Intrinsics.areEqual(r16, "single_song") == false) goto L51;
        com.bytedance.android.livesdk.log.filter.o r17 = j0.l().c(am2.x.class);
        if ((r17 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L36;
        r17 = null;
    L36:
        com.bytedance.android.livesdk.log.filter.t r18 = (com.bytedance.android.livesdk.log.filter.t) r17;
        if (r18 == null) goto L41;
        Map<String, String> r19 = r18.getMap();
        if (r19 == null) goto L41;
        String r110 = r19.get("enter_method");
    L43:
        if (Intrinsics.areEqual(r110, "song") == false) goto L51;
        long r111 = r3.a.getMId();
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r112 = KtvRoomContext.a.a();
        if (r112 == null) goto L51;
        com.bytedance.live.datacontext.m<Long> r113 = r112.getRelevantLiveSongId();
        if (r113 == null) goto L51;
        if (r111 != ((Number) r113.getValue()).longValue()) goto L51;
        r11 = "from_detail_pop_music";
    L41:
        r110 = null;
    L51:
        MultiChorusContext.a r114 = MultiChorusContext.Companion;
        MultiChorusContext r115 = r114.getContext();
        if (r115 == null) goto L72;
        jd2.d r116 = r114.j();
        if (r116 == null) goto L56;
        Long r117 = r116.c;
    L57:
        long r118 = r3.a.getMId();
        if (r117 != null) goto L61;
    L70:
        int r119 = 0;
    L71:
        r115.setOneSongAccumulatorMultiChorusUserCount(r119);
        goto L72
    L61:
        if (r117.longValue() != r118) goto L70;
        List<jd2.e> r120 = r114.k();
        if (r120 == null) goto L65;
        int r121 = r120.size();
    L66:
        if (r121 <= 0) goto L70;
        List<jd2.e> r122 = r114.k();
        if (r122 == null) goto L70;
        r119 = r122.size();
        goto L71
    L65:
        r121 = 0;
        goto L66
    L56:
        r117 = null;
    L72:
        com.bytedance.android.livesdk.ktvapi.model.mv.g r123 = this.v.getOpusMvService();
        if (r123 == null) goto L80;
        od r124 = r123.k();
        if (r124 == null) goto L80;
        String r125 = r124.f();
        if (r124.g() == false) goto L79;
        r7 = "recommend";
    L79:
        String r27 = r7;
        String r28 = r125;
    L81:
        Long r20 = KtvLoggerHelper.a;
        String r21 = r3.a.getMTitle();
        if (r21 != null) goto L84;
        r21 = "";
    L84:
        long r126 = r1.a.a.getMId();
        String r127 = r3.b();
        String r128 = r3.a.getMAuthor();
        if (r128 != null) goto L87;
        r128 = "";
    L87:
        oe2.b r5 = this.F;
        if (r5 == null) goto L90;
        String r129 = r5.getEnterFrom();
    L91:
        List r6 = r3.a.getTags();
        if (r6 == null) goto L94;
        boolean r130 = r6.contains("原唱");
    L95:
        boolean r131 = Intrinsics.areEqual(r3.A, Boolean.TRUE);
        oe2.b r22 = this.F;
        if (r22 == null) goto L98;
        String r132 = r22.c();
    L99:
        oe2.b r23 = this.F;
        if (r23 == null) goto L102;
        String r24 = r23.a();
    L103:
        KtvMusic r25 = r3.a;
        if (r25 == null) goto L112;
        String r26 = r25.getMidiUrl();
        if (r26 == null) goto L112;
        if (r26.length() <= 0) goto L110;
        boolean r29 = true;
    L111:
        Boolean r210 = Boolean.valueOf(r29);
    L113:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r30 = q();
        if (r30 == null) goto L116;
        boolean r211 = r30.R();
    L117:
        Boolean r212 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.M.getValue();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r31 = q();
        if (r31 == null) goto L123;
        MutableLiveData r32 = r31.F();
        if (r32 == null) goto L123;
        Boolean r33 = (Boolean) r32.getValue();
        if (r33 == null) goto L123;
    L124:
        boolean r213 = r33.booleanValue();
        String r34 = r3.g();
        if (r34 != null) goto L127;
        String r214 = "";
    L128:
        oe2.b r35 = this.A;
        if (r35 == null) goto L135;
        cg6.a r36 = r35.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r36 == null) goto L135;
        hg6.g r37 = r36.getRtcManager();
        if (r37 == null) goto L135;
        r37.b();
    L135:
        KtvLoggerHelper.Z(r11, r9, r21, r126, r127, r128, r15, r129, r130, r131, r132, r24, r210, r211, r212, r213, r214, r3, r27, r28, BDLocationException.ERROR_TIMEOUT);
        MusicPanel r38 = r1.a;
        r38.b = 5;
        com.bytedance.android.livesdk.ktvimpl.base.i r310 = p();
        SetBgmFunctionType r311 = SetBgmFunctionType.MULTI_KTV;
        KtvContext.Companion.getClass();
        oe2.b r40 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r40 == null) goto L138;
        Integer r41 = Integer.valueOf(r40.d());
    L139:
        if (r41 == null) goto L141;
        int r42 = r41.intValue();
    L142:
        int r312 = r42;
        Map<Integer, String> r43 = com.bytedance.android.livesdk.ktvimpl.base.i.t;
        r310.o(r38, r311, r312, 0, null, false);
        this.g.setValue(Boolean.valueOf(p().m));
        MutableLiveData<Boolean> r44 = this.f;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r45 = q();
        if (r45 == null) goto L145;
        Boolean r46 = Boolean.valueOf(r45.R());
    L146:
        r44.setValue(r46);
        List<com.bytedance.component.lyric.model.b> r47 = r1.b.c;
        if (r47 != null) goto L149;
    L152:
        boolean r48 = true;
    L153:
        if (r48 == false) goto L155;
        this.b = false;
        m();
        return;
    L155:
        this.b = true;
        l();
        return;
    L149:
        if (r47.isEmpty() == true) goto L152;
        r48 = false;
        goto L153
    L145:
        r46 = null;
        goto L146
    L141:
        oe2.l.f.getClass();
        r42 = oe2.l.a.a();
        goto L142
    L138:
        r41 = null;
        goto L139
    L127:
        r214 = r34;
    L123:
        r33 = Boolean.FALSE;
        goto L124
    L116:
        r211 = false;
        goto L117
    L110:
        r29 = false;
    L112:
        r210 = null;
        goto L113
    L102:
        r24 = null;
        goto L103
    L98:
        r132 = null;
        goto L99
    L94:
        r130 = false;
        goto L95
    L90:
        r129 = null;
    L80:
        r27 = null;
        r28 = null;
    L30:
        r16 = null;
        goto L32
    L21:
        r15 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("song_type", r8)});
        goto L22
    L18:
        r10 = false;
        goto L19
    L7:
        Integer r49 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r49 != null) goto L11;
    L12:
        r2 = "guest";
        goto L13
    L11:
        if (r49.intValue() != 0) goto L12;
        r9 = "user";
        goto L15
    L157:
        if ((r39 instanceof KtvRoomLyricsStateMachineConfig.b.f) == false) goto L166;
        BaseCoreViewModel r50 = o();
        if (r50 == null) goto L163;
        KtvRoomLyricsStateMachineConfig.d r51 = r50.getFromSate();
        if (r51 == null) goto L163;
        MusicPanel r52 = r51.b();
    L164:
        s(r52, ((KtvRoomLyricsStateMachineConfig.b.f) r39).a, false);
        return;
    L163:
        r52 = null;
        goto L164
    L166:
        if ((r39 instanceof KtvRoomLyricsStateMachineConfig.b.a) == false) goto L178;
        this.n.dispose();
        ALogger.i(bb0.b.b(), "singer controller onClear, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        MusicPanel r53 = p().f;
        p().l();
        p().j();
        KtvContext.Companion.getClass();
        KtvContext r54 = KtvContext.a.g();
        if (r54 == null) goto L172;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r55 = r54.getKtvCoreController();
        if (r55 == null) goto L172;
        MusicPanel r56 = null;
        r55.setValue(null);
    L174:
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L176;
        r56 = r53;
    L176:
        s(r56, true, true);
        Lazy r57 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().b(this.z);
        return;
    L172:
        r56 = null;
        goto L174
    L178:
        if ((r39 instanceof KtvRoomLyricsStateMachineConfig.b.d) == false) goto L218;
        p().u();
        boolean r58 = p().m;
        BaseCoreViewModel r59 = o();
        if (r59 == null) goto L188;
        KtvRoomLyricsStateMachineConfig.d r60 = r59.getCurState();
        if (r60 == null) goto L188;
        MusicPanel r61 = r60.b();
        if (r61 == null) goto L188;
        KtvMusic r62 = r61.a;
        if (r62 == null) goto L188;
        long r63 = r62.getMId();
    L189:
        List<ILinkPlayerInfoBridge> r64 = com.bytedance.android.livesdk.ktvimpl.base.sei.t.a;
        JSONObject r65 = new JSONObject();
        if (r58 == false) goto L192;
        r4 = 4;
    L192:
        v(r65.put("cmd", r4).put("id", r63));
        this.g.setValue(Boolean.valueOf(p().m));
        if (p().m == false) goto L195;
        this.n.dispose();
        ALogger.i(bb0.b.b(), "歌曲暂停（或者无歌曲播放），开始ping暂停时的sei, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        this.n = du2.a.b(0, this.q, TimeUnit.MILLISECONDS).subscribe(new u(this));
    L199:
        BaseCoreViewModel r66 = o();
        if (r66 == null) goto L219;
        KtvRoomLyricsStateMachineConfig.d r67 = r66.getCurState();
        if (r67 == null) goto L220;
        MusicPanel r68 = r67.b();
        if (r68 == null) goto L221;
        KtvMusic r69 = r68.a;
        if (r69 != null) goto L208;
        return;
    L208:
        if (r69.getMId() == this.h) goto L210;
        return;
    L210:
        if (p().m == false) goto L212;
        this.i += System.currentTimeMillis() - this.j;
        return;
    L212:
        this.j = System.currentTimeMillis();
        return;
    L221:
        return;
    L220:
        return;
    L219:
        return;
    L195:
        this.n.dispose();
        ALogger.i(bb0.b.b(), "歌曲暂停后恢复演唱, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        if (this.b == false) goto L198;
        l();
        goto L199
    L198:
        m();
    L188:
        r63 = 0;
        goto L189
    }

    public final void v(JSONObject r7) {
        if (this.w == true) goto L5;
    L7:
        r7.put("anchor_id", com.bytedance.android.livesdk.ktvimpl.base.sei.t.h(this.D.b().a()));
        r7.put("sender_user_id", com.bytedance.android.livesdk.ktvimpl.base.sei.t.h(jc1.k.n(IMiddlewareUserService.class).user().n().toString()));
        oe2.b r0 = this.A;
        if (r0 == null) goto L10;
        int r1 = r0.k();
    L11:
        r7.put("scene", r1);
        int r2 = 2;
        r7.put(BaseCoreViewModel.CORE_TAG_STATE, 2);
        if (p().m == false) goto L14;
        r2 = 1;
    L14:
        r7.put("music_play_status", r2);
        oe2.b r3 = this.A;
        if (r3 == null) goto L17;
        int r4 = r3.b();
    L18:
        r7.put("mode", r4);
        r7.put("is_in_chorus", ChorusContext.Companion.c());
        Object r5 = (String) this.v.getCurrentMvVid().getValue();
        if (r5 == null) goto L21;
        r7.put("vid", r5);
    L21:
        r7.put("grid_y", Float.valueOf(this.v.getKtvInteractRegionOffset()));
        Long r6 = p().h();
        if (r6 == null) goto L24;
        r7.put("start", Float.valueOf(r6.longValue() / 1000.0f));
    L24:
        Long r8 = p().f();
        if (r8 == null) goto L27;
        r7.put("duration", Float.valueOf(r8.longValue() / 1000.0f));
    L27:
        Long r9 = p().e();
        if (r9 == null) goto L30;
        r7.put("playTime", Float.valueOf(r9.longValue() / 1000.0f));
    L30:
        KtvContext.Companion.getClass();
        if (KtvContext.access$getEnableRoomStateSync$cp() == false) goto L39;
        oe2.d r10 = this.r;
        if (r10 == null) goto L39;
        MutableLiveData r11 = r10.e;
        if (r11 == null) goto L39;
        oe2.e r12 = (oe2.e) r11.getValue();
        if (r12 == null) goto L39;
        int r13 = oe2.e.a;
        Intrinsics.checkNotNullParameter(r12, "$this$getJson");
        r7.put("roomState", new JSONObject().put(BaseCoreViewModel.CORE_TAG_STATE, r12.a()).put("stateTs", r12.c()).put("statePos", r12.b()));
    L39:
        r7.put("song_type", 1);
        oe2.b r14 = this.A;
        int r15 = 0;
        if (r14 != null) goto L42;
    L61:
        BaseCoreViewModel r16 = o();
        List r17 = null;
        if (r16 == null) goto L66;
        KtvRoomLyricsStateMachineConfig.d r18 = r16.getCurState();
        if (r18 == null) goto L66;
        MusicPanel r19 = r18.b();
    L67:
        Long r20 = KtvLoggerHelper.a;
        if (KtvLoggerHelper.x() != 9) goto L86;
        boolean r21 = ne2.a.d();
        if (r19 != null) goto L72;
    L74:
        boolean r22 = false;
    L75:
        if (r22 == false) goto L115;
        if (r21 == true) goto L115;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r23 = KtvRoomContext.a.a();
        if (r23 == null) goto L84;
        com.bytedance.live.datacontext.m<Boolean> r24 = r23.isMidiOpened();
        if (r24 == null) goto L84;
        if (((Boolean) r24.getValue()).booleanValue() != true) goto L84;
    L113:
        r15 = 1;
    L84:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.M.getValue()).booleanValue() == true) goto L113;
    L115:
        if (qe2.d.a() != 9) goto L117;
    L118:
        r7.put("midi_status", r15);
    L120:
        if (MidiContext.Companion.d() == false) goto L122;
        r7.put("midi_cover", 1);
    L122:
        KtvContext r25 = KtvContext.a.g();
        if (r25 == null) goto L127;
        com.bytedance.live.datacontext.n<MidiSkinDressInfo> r26 = r25.getMidiSkinContext();
        if (r26 == null) goto L127;
        MidiSkinDressInfo r27 = (MidiSkinDressInfo) r26.getValue();
    L128:
        if (r27 == null) goto L139;
        KtvContext r28 = KtvContext.a.g();
        if (r28 == null) goto L137;
        com.bytedance.live.datacontext.n<MidiSkinDressInfo> r29 = r28.getMidiSkinContext();
        if (r29 == null) goto L137;
        MidiSkinDressInfo r30 = (MidiSkinDressInfo) r29.getValue();
        if (r30 == null) goto L137;
        Object r31 = r30.getDressId();
        if (r31 == null) goto L137;
    L138:
        r7.put("midi_dress_id", r31);
    L137:
        r31 = BDLocationException.ERROR_TIMEOUT;
    L139:
        BaseCoreViewModel r32 = o();
        if (r32 == null) goto L146;
        KtvRoomLyricsStateMachineConfig.d r33 = r32.getCurState();
        if (r33 == null) goto L146;
        MusicPanel r34 = r33.b();
        if (r34 == null) goto L146;
        KtvMusic r35 = r34.a;
    L147:
        if (r35 == null) goto L149;
        WantListenInfo r36 = r35.getWantListenInfo();
    L150:
        JSONObject r37 = new JSONObject();
        if (r36 == null) goto L153;
        Long r38 = Long.valueOf(r36.getWantListenCount().longValue());
    L154:
        r37.put("want_listen_count", r38);
        r7.put("want_listen_info", r37);
        BaseCoreViewModel r39 = o();
        if (r39 == null) goto L163;
        KtvRoomLyricsStateMachineConfig.d r40 = r39.getCurState();
        if (r40 == null) goto L163;
        MusicPanel r41 = r40.b();
        if (r41 == null) goto L163;
        KtvMusic r42 = r41.a;
        if (r42 == null) goto L163;
        r17 = r42.getCopyrightedAppIds();
    L163:
        r7.put("copyrighted_app_ids", new JSONArray(r17));
        BaseCoreViewModel r43 = o();
        if (r43 == null) goto L177;
        KtvRoomLyricsStateMachineConfig.d r44 = r43.getCurState();
        if (r44 == null) goto L177;
        MusicPanel r45 = r44.b();
        if (r45 == null) goto L177;
        KtvMusic r46 = r45.a;
        if (r46 == null) goto L177;
        Map r47 = r46.getGlobalCopyrightRegionInfo();
        if (r47 == null) goto L177;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        RegionList r48 = (RegionList) r47.get(Long.valueOf(com.bytedance.android.livesdk.ktvimpl.base.util.j.d));
        if (r48 == null) goto L177;
        List r49 = r48.getValues();
        if (r49 == null) goto L177;
    L178:
        r7.put("copyrighted_region_ids", new JSONArray(r49));
        com.bytedance.android.livesdk.ktvimpl.base.sei.f r50 = this.a;
        if (r50 == null) goto L182;
        r50.a("ktv_sei", r7);
        return;
    L182:
        return;
    L177:
        r49 = CollectionsKt.emptyList();
        goto L178
    L153:
        r38 = null;
        goto L154
    L149:
        r36 = null;
    L146:
        r35 = null;
    L127:
        r27 = null;
        goto L128
    L117:
        if (MidiContext.Companion.d() == false) goto L120;
    L72:
        if (KtvUtilsKt.B(r19) != true) goto L74;
        r22 = true;
        goto L75
    L86:
        if (r19 != null) goto L88;
    L92:
        boolean r51 = false;
    L93:
        KtvComponentContext r52 = KtvComponentContext.Companion.getContext();
        if (r52 == null) goto L104;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r53 = r52.getKtvComponentUIContext();
        if (r53 == null) goto L104;
        KtvComponentUIContext r54 = (KtvComponentUIContext) r53.getValue();
        if (r54 == null) goto L104;
        MutableLiveData<Boolean> r55 = r54.getScoreOpen();
        if (r55 == null) goto L104;
        Boolean r56 = (Boolean) r55.getValue();
        if (r56 == null) goto L104;
        boolean r57 = r56.booleanValue();
    L105:
        if (r57 == false) goto L107;
    L110:
        boolean r58 = true;
    L111:
        if (r51 == false) goto L115;
        if (r58 == false) goto L115;
    L107:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.H.getValue()).booleanValue() == true) goto L110;
        r58 = false;
    L104:
        r57 = false;
        goto L105
    L88:
        if (KtvUtilsKt.B(r19) != true) goto L92;
        if (ne2.a.d() == true) goto L92;
        r51 = true;
    L66:
        r19 = null;
        goto L67
    L42:
        if (r14.l() != true) goto L49;
        Boolean r59 = r14.e();
        if (r59 == null) goto L46;
        boolean r60 = r59.booleanValue();
    L47:
        r7.put("show_score", r60);
        goto L49
    L46:
        r60 = false;
    L49:
        if (r14.j() == false) goto L61;
        BaseCoreViewModel r61 = o();
        if (r61 == null) goto L61;
        KtvRoomLyricsStateMachineConfig.d r62 = r61.getCurState();
        if (r62 == null) goto L61;
        MusicPanel r63 = r62.b();
        if (r63 == null) goto L61;
        KtvMusic r64 = r63.a;
        if (r64 == null) goto L61;
        Object r65 = r64.getCoverUrl();
        if (r65 == null) goto L61;
        r7.put("cover_url", r65);
        goto L61
    L17:
        r4 = -1;
        goto L18
    L10:
        r1 = 1;
        goto L11
    L5:
        if (KtvUtilsKt.v() == false) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v27, types: [com.bytedance.android.livesdk.ktvimpl.base.KtvContext] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    public final void s(MusicPanel r39, boolean r40, boolean r41) {
        KtvRoomSingerController r0 = this;
        String r1 = bb0.b.b();
        StringBuilder r2 = new StringBuilder("MusicPanel：");
        if (r39 == null) goto L7;
        KtvMusic r3 = r39.a;
        if (r3 == null) goto L7;
        String r4 = r3.getMTitle();
    L8:
        r2.append(r4);
        r2.append(", handleStopSideEffect");
        ALogger.i(r1, r2.toString());
        pd2.d.M(pd2.d.n, r39, "sing_cut");
        if (r39 == null) goto L258;
        r0.v(com.bytedance.android.livesdk.ktvimpl.base.sei.t.e(6, r39.a.getMId()));
        if (r39.a.getMId() != r0.h) goto L258;
        r0.i += System.currentTimeMillis() - r0.j;
        if (r0.D.b().isAnchor() == false) goto L15;
        String r5 = "anchor";
    L16:
        String r6 = r5;
        String r7 = com.bytedance.android.live.ktv.common.util.a.b(r39.a);
        if (r7.length() != 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L22;
        HashMap r16 = null;
    L23:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r9 = q();
        if ((r9 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L26;
        r9 = null;
    L26:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r10 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r9;
        if (r10 == null) goto L29;
        Boolean r11 = r10.J();
    L30:
        Boolean r12 = Boolean.TRUE;
        boolean r17 = Intrinsics.areEqual(r11, r12);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r13 = q();
        if (r13 == null) goto L33;
        r13.b();
    L33:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r14 = q();
        if (r14 == null) goto L36;
        r14.P();
    L36:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r15 = q();
        if (r15 == null) goto L39;
        r15.P();
    L39:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r18 = q();
        if (r18 == null) goto L42;
        r18.b();
    L42:
        String r19 = r0.m;
        if (r19 == null) goto L45;
        r0.l = r19;
    L45:
        r0.m = null;
        String r20 = r39.d;
        com.bytedance.android.livesdk.log.filter.o r21 = j0.l().c(am2.x.class);
        if ((r21 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L48;
        r21 = null;
    L48:
        com.bytedance.android.livesdk.log.filter.t r22 = (com.bytedance.android.livesdk.log.filter.t) r21;
        if (r22 == null) goto L53;
        Map<String, String> r23 = r22.getMap();
        if (r23 == null) goto L53;
        String r24 = r23.get("enter_from_merge");
    L55:
        if (Intrinsics.areEqual(r24, "single_song") == false) goto L75;
        com.bytedance.android.livesdk.log.filter.o r25 = j0.l().c(am2.x.class);
        if ((r25 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L59;
        r25 = null;
    L59:
        com.bytedance.android.livesdk.log.filter.t r26 = (com.bytedance.android.livesdk.log.filter.t) r25;
        if (r26 == null) goto L64;
        Map<String, String> r27 = r26.getMap();
        if (r27 == null) goto L64;
        String r28 = r27.get("enter_method");
    L66:
        if (Intrinsics.areEqual(r28, "song") == false) goto L75;
        long r29 = r39.a.getMId();
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r30 = KtvRoomContext.a.a();
        if (r30 == null) goto L75;
        com.bytedance.live.datacontext.m<Long> r31 = r30.getRelevantLiveSongId();
        if (r31 == null) goto L75;
        if (r29 != ((Number) r31.getValue()).longValue()) goto L75;
        r20 = "from_detail_pop_music";
    L64:
        r28 = null;
    L75:
        if (r41 == true) goto L87;
        Integer r32 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r32 == null) goto L87;
        if (r32.intValue() != 2) goto L87;
        if ((!Intrinsics.areEqual(r0.l, "sing_challenge")) == false) goto L88;
        long r33 = r0.i / 1000;
        KtvMusic.a r110 = KtvMusic.Companion;
        KtvMusic r111 = r39.a;
        r110.getClass();
        if (r33 >= KtvMusic.a.a(r111)) goto L88;
        r0.l = "cut";
    L88:
        com.bytedance.android.livesdk.ktvimpl.base.logger.b r34 = com.bytedance.android.livesdk.ktvimpl.base.logger.a.a;
        long r35 = r39.a.getMId();
        long r112 = r0.i / 1000;
        String r113 = r39.a.getMTitle();
        if (r113 != null) goto L91;
        r113 = "";
    L91:
        boolean r114 = r0.k;
        String r36 = r0.l;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r37 = q();
        if ((r37 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L94;
        r37 = null;
    L94:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r38 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r37;
        if (r38 == null) goto L97;
        boolean r42 = r38.d0();
    L98:
        String r115 = r39.b();
        String r43 = r39.a.getMAuthor();
        if (r43 != null) goto L101;
        r43 = "";
    L101:
        oe2.b r44 = r0.F;
        if (r44 == null) goto L104;
        String r45 = r44.getEnterFrom();
    L105:
        List r46 = r39.a.getTags();
        boolean r210 = r42;
        if (r46 == null) goto L108;
        boolean r47 = r46.contains("原唱");
    L109:
        oe2.b r48 = r0.F;
        if (r48 == null) goto L112;
        String r310 = r48.c();
    L113:
        oe2.b r49 = r0.F;
        if (r49 == null) goto L116;
        String r50 = r49.a();
    L117:
        KtvMusic r51 = r39.a;
        if (r51 == null) goto L126;
        String r52 = r51.getMidiUrl();
        if (r52 == null) goto L126;
        if (r52.length() <= 0) goto L124;
        boolean r53 = true;
    L125:
        Boolean r54 = Boolean.valueOf(r53);
    L127:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r311 = KtvRoomContext.a.a();
        if (r311 == null) goto L134;
        com.bytedance.live.datacontext.n<Float> r312 = r311.getReportMidiScore();
        if (r312 == null) goto L134;
        Float r313 = (Float) r312.getValue();
        if (r313 == null) goto L134;
        Integer r314 = Integer.valueOf((int) r313.floatValue());
    L135:
        boolean r55 = r39.t;
        KtvComponentContext.a r315 = KtvComponentContext.Companion;
        KtvComponentContext r316 = r315.getContext();
        if (r316 == null) goto L144;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r317 = r316.getKtvComponentUIContext();
        if (r317 == null) goto L144;
        KtvComponentUIContext r318 = (KtvComponentUIContext) r317.getValue();
        if (r318 == null) goto L144;
        MutableLiveData<Boolean> r319 = r318.getScoreOpen();
        if (r319 == null) goto L144;
        Boolean r320 = (Boolean) r319.getValue();
    L145:
        Boolean r56 = r39.A;
        Intrinsics.checkNotNullParameter(r20, "fromRequestType");
        Intrinsics.checkNotNullParameter(r6, "userType");
        Intrinsics.checkNotNullParameter(r113, "songName");
        Intrinsics.checkNotNullParameter(r36, "endType");
        Intrinsics.checkNotNullParameter(r115, "artistId");
        Intrinsics.checkNotNullParameter(r43, "artistName");
        Intrinsics.checkNotNullParameter("", "orderUserId");
        HashMap r116 = new HashMap();
        r116.put("from_request_type", r20);
        r116.put("ksong_id", String.valueOf(r35));
        r116.put("duration", String.valueOf(r112));
        r116.put("end_type", r36);
        Long r57 = KtvLoggerHelper.a;
        r116.put("function_type", KtvLoggerHelper.H(com.bytedance.android.live.ktv.common.util.j.c()));
        r116.put("user_type", r6);
        r116.put("song_name", r113);
        r116.put("room_type", "radio");
        String r58 = "1";
        if (r114 == false) goto L148;
        ?? r59 = "1";
    L149:
        r116.put("is_full", r59);
        if (r56 != null) goto L152;
    L156:
        if (r210 == false) goto L158;
        ?? r60 = "1";
    L159:
        r116.put("original_switch_used", r60);
        r116.put("artist_id", r115);
        r116.put("artist_name", r43);
        r116.put("live_type", KtvLoggerHelper.F());
        r116.put("earphone_used", String.valueOf(r17 ? 1 : 0));
        KtvLoggerHelper.m0(r116);
        if (r45 == null) goto L162;
        r116.put("enter_from", r45);
    L162:
        if (r47 == false) goto L164;
        ?? r61 = "1";
    L165:
        r116.put("is_original_flag", r61);
        KtvLoggerHelper.o0(r116);
        r116.put("function_type2", jc1.k.n(IInteractService.class).getFunctionType2());
        if (r310 == null) goto L168;
        r116.put("ksong_element_source", r310);
    L168:
        if (r50 == null) goto L170;
        r116.put("element_open_method", r50);
    L170:
        if (r54 != 0) goto L172;
    L176:
        if (r314 == null) goto L178;
        r116.put("midi_score", String.valueOf(r314.intValue()));
    L178:
        if (r55 == false) goto L180;
        ?? r62 = "1";
    L181:
        r116.put("is_original_used", r62);
        if (Intrinsics.areEqual(r320, r12) == false) goto L184;
        ?? r63 = "1";
    L185:
        r116.put("is_score", r63);
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r116);
        com.bytedance.android.livesdk.ktvimpl.chorus.c.c(r116, "");
        if (Intrinsics.areEqual(r56, r12) == true) goto L189;
        r58 = BDLocationException.ERROR_TIMEOUT;
    L189:
        r116.put("is_play_all", r58);
        com.bytedance.android.livesdk.ktvimpl.base.logger.b r64 = com.bytedance.android.livesdk.ktvimpl.base.logger.a.a;
        r116.put("perfect_cnt", String.valueOf(r64.a));
        r116.put("good_cnt", String.valueOf(r64.b));
        r116.put("nice_cnt", String.valueOf(r64.c));
        r116.put("perfect_combo", String.valueOf(r64.e));
        r116.put("advanced_combo", String.valueOf(r64.d));
        j0.l().sendLog("livesdk_audience_ktv_mode_sing_score", r116, new Object[]{IRoom.class});
        r64.a = 0;
        r64.b = 0;
        r64.c = 0;
        r64.d = 0;
        r64.e = 0;
        com.bytedance.android.livesdk.ktvapi.model.mv.g r65 = this.v.getOpusMvService();
        if (r65 == null) goto L194;
        com.bytedance.android.livesdk.ktvapi.model.mv.f r66 = r65.l(r39.a.getMId(), r39.a.getOrderUserIdString());
        if (r66 == null) goto L194;
        Integer r67 = Integer.valueOf(r66.i().c);
        Integer r211 = Integer.valueOf(r66.i().d);
        Integer r212 = r67;
    L195:
        long r68 = r39.a.getMId();
        long r69 = this.i / 1000;
        String r70 = r39.a.getMTitle();
        if (r70 != null) goto L198;
        String r117 = "";
    L199:
        boolean r118 = this.k;
        String r119 = this.l;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r71 = q();
        if ((r71 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L202;
        r71 = null;
    L202:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r72 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r71;
        if (r72 == null) goto L205;
        boolean r120 = r72.d0();
    L206:
        String r213 = r39.b();
        String r73 = r39.a.getMAuthor();
        if (r73 != null) goto L209;
        String r214 = "";
    L210:
        oe2.b r74 = this.F;
        if (r74 == null) goto L213;
        String r215 = r74.getEnterFrom();
    L214:
        List r75 = r39.a.getTags();
        if (r75 == null) goto L217;
        boolean r216 = r75.contains("原唱");
    L218:
        oe2.b r76 = this.F;
        if (r76 == null) goto L221;
        String r321 = r76.c();
    L222:
        oe2.b r77 = this.F;
        if (r77 == null) goto L225;
        String r322 = r77.a();
    L226:
        KtvMusic r78 = r39.a;
        if (r78 == null) goto L235;
        String r79 = r78.getMidiUrl();
        if (r79 == null) goto L235;
        if (r79.length() <= 0) goto L233;
        boolean r80 = true;
    L234:
        Boolean r323 = Boolean.valueOf(r80);
    L236:
        KtvRoomContext r81 = KtvRoomContext.a.a();
        if (r81 == null) goto L243;
        com.bytedance.live.datacontext.n<Float> r82 = r81.getReportMidiScore();
        if (r82 == null) goto L243;
        Float r83 = (Float) r82.getValue();
        if (r83 == null) goto L243;
        Integer r324 = Integer.valueOf((int) r83.floatValue());
    L244:
        boolean r85 = r39.t;
        KtvComponentContext r86 = r315.getContext();
        if (r86 == null) goto L253;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r87 = r86.getKtvComponentUIContext();
        if (r87 == null) goto L253;
        KtvComponentUIContext r88 = (KtvComponentUIContext) r87.getValue();
        if (r88 == null) goto L253;
        MutableLiveData<Boolean> r89 = r88.getScoreOpen();
        if (r89 == null) goto L253;
        Boolean r325 = (Boolean) r89.getValue();
    L254:
        int r326 = 2;
        KtvLoggerHelper.a0(r20, r68, r69, r6, r117, r118, r119, r120, r213, r214, r16, r17 ? 1 : 0, "", false, r215, r216, r321, r322, r323, r324, r85, r325, r39.A, r39, r211, r212);
        MultiChorusContext r90 = MultiChorusContext.Companion.getContext();
        if (r90 == null) goto L257;
        r90.setOneSongAccumulatorMultiChorusUserCount(0);
    L257:
        r0 = this;
        long r91 = 0;
        ?? r92 = 0;
        r0.i = 0;
        r0.j = 0;
        r0.h = 0;
        r0.d = -1;
    L259:
        p().s();
        r0.n.dispose();
        if (r40 == false) goto L271;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L271;
        Function2<Integer, Long, Unit> r93 = r0.G;
        Integer r94 = Integer.valueOf(r326);
        if (r39 == null) goto L268;
        KtvMusic r95 = r39.a;
        if (r95 == null) goto L268;
        long r121 = r95.getMId();
    L269:
        r93.invoke(r94, Long.valueOf(r121));
        KtvContext.a.g().updateCurrentUserIsSinger(r92);
    L268:
        r121 = r91;
    L271:
        if (((Boolean) vm2.h.g4.getValue(null, vm2.h.a[265(0x109, float:3.71E-43)])).booleanValue() == false) goto L274;
        return;
    L274:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L294;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r96 = KtvRoomContext.a.a();
        if (r96 == null) goto L281;
        com.bytedance.live.datacontext.m<Integer> r97 = r96.getMidiSingLyricsLineCount();
        if (r97 == null) goto L281;
        if (((Number) r97.getValue()).intValue() == 0) goto L294;
    L281:
        StringBuilder r98 = new StringBuilder("KtvRoomSingerController#clearMidiData(), reportMidiScore: ");
        KtvRoomContext r99 = KtvRoomContext.a.a();
        if (r99 == null) goto L286;
        com.bytedance.live.datacontext.n<Float> r100 = r99.getReportMidiScore();
        if (r100 == null) goto L286;
        Float r122 = (Float) r100.getValue();
    L287:
        r98.append(r122);
        r98.append("midiSingLyricsLineCount: ");
        KtvRoomContext r101 = KtvRoomContext.a.a();
        if (r101 == null) goto L292;
        com.bytedance.live.datacontext.m<Integer> r102 = r101.getMidiSingLyricsLineCount();
        if (r102 == null) goto L292;
        Integer r123 = (Integer) r102.getValue();
    L293:
        r98.append(r123);
        pd2.d.I(null, r98.toString());
    L292:
        r123 = null;
    L286:
        r122 = null;
    L294:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r103 = KtvRoomContext.a.a();
        if (r103 == null) goto L299;
        com.bytedance.live.datacontext.m<Integer> r104 = r103.getMidiSingLyricsLineCount();
        if (r104 == null) goto L299;
        r104.setValue(Integer.valueOf(r92));
    L299:
        KtvRoomContext r105 = KtvRoomContext.a.a();
        if (r105 == null) goto L304;
        com.bytedance.live.datacontext.n<Float> r106 = r105.getReportMidiScore();
        if (r106 == null) goto L304;
        r106.setValue(null);
    L304:
        KtvRoomContext r107 = KtvRoomContext.a.a();
        if (r107 == null) goto L312;
        com.bytedance.live.datacontext.m<Map<Integer, Float>> r108 = r107.getScoreMap();
        if (r108 == null) goto L313;
        Map r109 = (Map) r108.getValue();
        if (r109 == null) goto L314;
        r109.clear();
        return;
    L314:
        return;
    L313:
        return;
    L312:
        return;
    L253:
        r325 = null;
    L243:
        r324 = null;
        goto L244
    L233:
        r80 = false;
    L235:
        r323 = null;
        goto L236
    L225:
        r322 = null;
        goto L226
    L221:
        r321 = null;
        goto L222
    L217:
        r216 = false;
        goto L218
    L213:
        r215 = null;
        goto L214
    L209:
        r214 = r73;
        goto L210
    L205:
        r120 = false;
        goto L206
    L198:
        r117 = r70;
    L194:
        r211 = null;
        r212 = null;
        goto L195
    L184:
        r63 = BDLocationException.ERROR_TIMEOUT;
        goto L185
    L180:
        r62 = BDLocationException.ERROR_TIMEOUT;
        goto L181
    L172:
        if (r54.booleanValue() == false) goto L174;
        ?? r124 = "1";
    L175:
        r116.put("is_midi", r124);
        goto L176
    L174:
        r124 = BDLocationException.ERROR_TIMEOUT;
        goto L175
    L164:
        r61 = BDLocationException.ERROR_TIMEOUT;
        goto L165
    L158:
        r60 = BDLocationException.ERROR_TIMEOUT;
        goto L159
    L152:
        if (r56.booleanValue() == false) goto L154;
        ?? r125 = "1";
    L155:
        r116.put("is_play_all", r125);
        goto L156
    L154:
        r125 = BDLocationException.ERROR_TIMEOUT;
        goto L155
    L148:
        r59 = BDLocationException.ERROR_TIMEOUT;
    L144:
        r320 = null;
    L134:
        r314 = null;
        goto L135
    L124:
        r53 = false;
    L126:
        r54 = null;
        goto L127
    L116:
        r50 = null;
        goto L117
    L112:
        r310 = null;
        goto L113
    L108:
        r47 = false;
        goto L109
    L104:
        r45 = null;
        goto L105
    L97:
        r42 = false;
    L87:
        r0.l = "break";
    L53:
        r24 = null;
        goto L55
    L29:
        r11 = null;
        goto L30
    L22:
        r16 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("song_type", r7)});
        goto L23
    L19:
        r8 = false;
        goto L20
    L15:
        r5 = "guest";
    L258:
        r91 = 0;
        r92 = 0;
        r326 = 2;
    L7:
        r4 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvRoomSingerController(sb0.b r3, CompositeDisposable r4, com.bytedance.android.live.pushstream.d r5, oe2.b r6, Function2<? super Integer, ? super Long, Unit> r7) {
        Intrinsics.checkNotNullParameter(r3, "dataEntity");
        Intrinsics.checkNotNullParameter(r4, "cd");
        Intrinsics.checkNotNullParameter(r7, "singerUpdateAction");
        this.D = r3;
        this.E = r5;
        this.F = r6;
        this.G = r7;
        this.b = true;
        this.d = -1;
        this.f = new MutableLiveData();
        this.g = new MutableLiveData();
        this.l = "normal";
        this.n = Disposables.disposed();
        this.o = new CompositeDisposable();
        this.p = Disposables.disposed();
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L5;
        long r8 = KtvSettingHelper.q().i();
    L6:
        this.q = r8;
        KtvContext.Companion.getClass();
        this.r = (oe2.d) KtvContext.a.g().getKtvRoomModel().getValue();
        ReadOnlyProperty r9 = vm2.h.h4;
        KProperty[] r10 = vm2.h.a;
        this.u = ((Number) r9.getValue(null, r10[266(0x10a, float:3.73E-43)])).longValue();
        this.v = KtvContext.a.g();
        this.w = ((Boolean) vm2.h.e4.getValue(null, r10[263(0x107, float:3.69E-43)])).booleanValue();
        this.x = LazyKt.lazy(new KtvRoomSingerController$ktvCoreController$2(this));
        this.y = LazyKt.lazy(KtvRoomSingerController$tuningCore$2.INSTANCE);
        d r11 = new d();
        this.z = r11;
        ALogger.i("logKtvMainPath", "KtvRoomSingerController init, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        Lazy r12 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().a(r11);
        this.A = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        this.B = new JSONObject();
        return;
    L5:
        int r13 = com.bytedance.android.livesdk.ktvimpl.base.c.a;
        r8 = ((Number) vm2.h.Y2.getValue(null, vm2.h.a[205(0xcd, float:2.87E-43)])).longValue() * ((long) 1000.0f);
        goto L6
    }
}
