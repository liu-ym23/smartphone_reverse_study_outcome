package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.y2;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.kf1;
import com.bytedance.android.livesdk.config.lf1;
import com.bytedance.android.livesdk.config.mf1;
import com.bytedance.android.livesdk.config.nf1;
import com.bytedance.android.livesdk.config.z41;
import com.bytedance.android.livesdk.g6;
import com.bytedance.android.livesdk.ktvapi.WidgetViewModelProviders;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.widget.HolderRoomScopeWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.dialog.RealTimeChrousCellularDialog;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPlayerState;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamSycnInfoConfig;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamPushMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.jd;
import com.bytedance.android.livesdk.message.model.m2;
import com.bytedance.android.livesdk.message.model.n2;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.RealTimeChorusUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveRTChorusSpatialAudioConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.kmp.live.livelink.api.multilink.media.StreamType;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusBusinessWidget;", "Lfd2/s;", "Lcom/bytedance/android/livesdk/ktvimpl/base/widget/HolderRoomScopeWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusBusinessWidget extends HolderRoomScopeWidget implements fd2.s, com.bytedance.android.livesdk.ktvimpl.base.sei.c {
    public static final /* synthetic */ int V0 = 0;
    public long A;
    public fd2.e0 B;
    public int C;
    public MixStreamType D;
    public boolean E;
    public MusicPanel F;
    public Disposable G;
    public Disposable H;
    public final j H0;
    public long I;
    public final boolean J;
    public int K;
    public boolean L;
    public final d L0;
    public boolean M;
    public int N;
    public final lf1 O;
    public ValueAnimator P;
    public boolean P0;
    public ValueAnimator Q;
    public String R;
    public String S;
    public boolean T;
    public boolean U;
    public boolean V;
    public final k W;
    public com.bytedance.android.livesdk.chatroom.model.v X;
    public boolean Y;
    public final i Z;
    public final com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive.a d;
    public RealTimeChorusViewModel e;
    public c1 f;
    public final nd2.d g;
    public final xe2.c h;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c i;
    public final CompositeDisposable j;
    public final long k;
    public final h k0;
    public final long l;
    public final long m;
    public final long n;
    public final long o;
    public final boolean p;
    public final c0 p0;
    public Disposable q;
    public Disposable r;
    public long s;
    public long t;
    public int u;
    public LiveWrappedPlayerState v;
    public final m1 w;
    public long x;
    public long y;
    public long z;

    public static final class a {
    }

    public static final class a0 extends com.bytedance.android.live.ktv.common.music.download.b {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public a0(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void a(MusicPanel r1, String r2, String r3) {
            StringBuilder r4 = new StringBuilder();
            if (r1 == null) goto L7;
            KtvMusic r5 = r1.a;
            if (r5 == null) goto L7;
            String r6 = r5.getMTitle();
        L8:
            r4.append(r6);
            r4.append(" download  onSuccessed ");
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r4.toString());
            if (r1 == null) goto L14;
            c1 r7 = this.a.f;
            if (r7 == null) goto L15;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.c.a(r7, r1, RealTimeChorusBusinessWidget.Mq());
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r6 = null;
            goto L8
        }

        public final void b(MusicPanel r1, int r2, String r3) {
            StringBuilder r4 = new StringBuilder();
            if (r1 == null) goto L7;
            KtvMusic r5 = r1.a;
            if (r5 == null) goto L7;
            String r6 = r5.getMTitle();
        L8:
            r4.append(r6);
            r4.append(" download  onFailed ");
            r4.append(r3);
            r4.append(' ');
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r4.toString());
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public b(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            Long r12 = (Long) r11;
            RealTimeChorusBusinessWidget r13 = this.a;
            int r0 = RealTimeChorusBusinessWidget.V0;
            ei6.a r14 = r13.Z0();
            if (r14 == null) goto L9;
            ui6.d r15 = r14.l();
            if (r15 == null) goto L9;
            mi6.a r16 = r15.b();
            if (r16 == null) goto L9;
            r16.v();
        L9:
            KtvModeOrderedSongDataContext r17 = this.a.Kq();
            int r1 = 0;
            if (r17 == null) goto L18;
            List<MusicPanel> r18 = r17.m200getKtvSingSongList();
            if (r18 == null) goto L18;
            MusicPanel r19 = (MusicPanel) KtvUtilsKt.K(r18, 0);
            if (r19 == null) goto L18;
            RealTimeChorusInfo r110 = r19.C;
            if (r110 == null) goto L18;
            long r3 = r110.getChorusID();
        L20:
            if (r3 == 0) goto L25;
            if (r3 == this.a.I) goto L25;
            xe2.b r111 = xe2.b.b;
            String r5 = String.valueOf(r3);
            int r6 = RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole();
            boolean r7 = this.a.isEngineOn();
            r111.getClass();
            xe2.b.u(r5, r6, r7);
            this.a.I = r3;
        L25:
            if (KtvSettingHelper.y() == false) goto L27;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "beginSendStreamSyncInfo ntp error ntp: 0");
            return;
        L27:
            JSONObject r112 = new JSONObject();
            KtvContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.i r4 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
            if (r4 == null) goto L32;
            Long r8 = r4.e();
            if (r8 == null) goto L32;
            long r9 = r8.longValue();
        L50:
            r112.put("pos", r9 - ((long) this.a.u));     // Catch: JSONException -> L39
            r112.put("ntp", 0);     // Catch: JSONException -> L39
            if (this.a.v != LiveWrappedPlayerState.PAUSED) goto L37;
            r1 = 1;
        L37:
            r112.put("br_st", r1);     // Catch: JSONException -> L39
        L41:
            String r113 = r112.toString();
            RealTimeChorusBusinessWidget r2 = this.a;
            int r10 = r2.C + 1;
            r2.C = r10;
            if ((r10 % 100) != 0) goto L44;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "sendStreamSyncInfo " + r113 + " audioDeviceLoopDelay: " + this.a.u);
        L44:
            ei6.a r20 = this.a.Z0();
            if (r20 == null) goto L53;
            ChorusManager r21 = r20.i();
            if (r21 == null) goto L54;
            r21.s(StringsKt.encodeToByteArray(r113), new LiveWrappedStreamSycnInfoConfig(LiveWrappedStreamIndex.STREAM_INDEX_3RD, LiveWrappedStreamSycnInfoConfig.LiveWrappedSyncInfoStreamType.SYNC_INFO_STREAM_TYPE_AUDIO));
            return;
        L54:
            return;
        L53:
            return;
        L39:
            e = move-exception;
            e.printStackTrace();
        L32:
            r9 = 0;
        L18:
            r3 = 0;
            goto L20
        }
    }

    public static final class b0 implements com.bytedance.android.live.ktv.common.music.download.p.a {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;
        public final /* synthetic */ Ref.ObjectRef b;

        public final void c(MusicPanel r1, int r2) {
        }

        public b0(RealTimeChorusBusinessWidget r1, Ref.ObjectRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(MusicPanel r1, String r2, String r3) {
            StringBuilder r4 = new StringBuilder();
            if (r1 == null) goto L7;
            KtvMusic r5 = r1.a;
            if (r5 == null) goto L7;
            String r6 = r5.getMTitle();
        L8:
            r4.append(r6);
            r4.append(" download  onSuccessed ");
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r4.toString());
            if (r1 == null) goto L14;
            c1 r7 = this.a.f;
            if (r7 == null) goto L15;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.c.a(r7, r1, RealTimeChorusBusinessWidget.Mq());
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r6 = null;
            goto L8
        }

        public final void b(MusicPanel r1, int r2, String r3) {
            StringBuilder r4 = new StringBuilder();
            MusicPanel r5 = (MusicPanel) this.b.element;
            if (r5 == null) goto L7;
            KtvMusic r6 = r5.a;
            if (r6 == null) goto L7;
            String r7 = r6.getMTitle();
        L8:
            r4.append(r7);
            r4.append(" download  onFailed ");
            r4.append(r3);
            r4.append(' ');
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r4.toString());
            return;
        L7:
            r7 = null;
            goto L8
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public c(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Long r9 = (Long) r8;
            RealTimeChorusBusinessWidget r10 = this.a;
            int r0 = RealTimeChorusBusinessWidget.V0;
            ei6.a r11 = r10.Z0();
            if (r11 == null) goto L10;
            ui6.d r12 = r11.l();
            if (r12 == null) goto L10;
            mi6.a r13 = r12.b();
            if (r13 == null) goto L10;
            r13.v();
        L10:
            if (KtvSettingHelper.y() == false) goto L12;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "beginSendSyncRTS ntp error ntp: 0");
            return;
        L12:
            JSONObject r14 = new JSONObject();
            KtvContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.i r1 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
            if (r1 == null) goto L17;
            Long r2 = r1.e();
            if (r2 == null) goto L17;
            long r3 = r2.longValue();
        L32:
            r14.put("pos", r3 - ((long) this.a.u));     // Catch: JSONException -> L24
            r14.put("ntp", 0);     // Catch: JSONException -> L24
            if (this.a.v != LiveWrappedPlayerState.PAUSED) goto L21;
            int r4 = 1;
        L22:
            r14.put("br_st", r4);     // Catch: JSONException -> L24
        L26:
            String r15 = r14.toString();
            ei6.a r5 = this.a.Z0();
            if (r5 == null) goto L35;
            si6.b r6 = r5.b();
            if (r6 == null) goto L36;
            r6.n(bj6.a.b(this.a.Z0()), r15);
            return;
        L36:
            return;
        L35:
            return;
        L21:
            r4 = 0;
        L24:
            e = move-exception;
            e.printStackTrace();
        L17:
            r3 = 0;
            goto L32
        }
    }

    public static final class c0 implements m1.a {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public c0(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.m1.a
        public final void a(com.bytedance.android.livesdk.ktvimpl.realtimechorus.q r24) {
            Intrinsics.checkNotNullParameter(r24, LocationMonitorConst.INFO);
            this.a.s = System.currentTimeMillis();
            if (RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole() != 2) goto L56;
            this.a.Cq();
            RealTimeChorusBusinessWidget r1 = this.a;
            c1 r3 = r1.f;
            if (r3 == null) goto L7;
            MusicPanel r4 = r3.b;
        L8:
            if (r4 == null) goto L11;
            r1.h.c("seek_sync_info_time", System.currentTimeMillis());
        L11:
            if (r24.c() != 1) goto L15;
            c1 r2 = this.a.f;
            if (r2 == null) goto L57;
            r2.e();
            return;
        L57:
            return;
        L15:
            c1 r5 = this.a.f;
            if (r5 == null) goto L18;
            r5.g("onReceivedSyncInfo");
        L18:
            ei6.a r6 = this.a.Z0();
            if (r6 == null) goto L25;
            ui6.d r7 = r6.l();
            if (r7 == null) goto L25;
            mi6.a r8 = r7.b();
            if (r8 == null) goto L25;
            r8.v();
        L25:
            c1 r9 = this.a.f;
            if (r9 == null) goto L28;
            long r10 = r9.a();
        L29:
            RealTimeChorusBusinessWidget r11 = this.a;
            long r12 = r10 - r11.z;
            long r13 = 0 - r11.A;
            r11.z = r10;
            r11.A = 0;
            long r14 = 0 - r24.a();
            long r15 = ((long) this.a.u) + (r24.b() + r14);
            long r16 = r10 - r15;
            long r17 = System.currentTimeMillis();
            RealTimeChorusBusinessWidget r18 = this.a;
            long r19 = r17 - r18.x;
            KtvModeOrderedSongDataContext r20 = r18.Kq();
            if (r20 == null) goto L38;
            List<MusicPanel> r21 = r20.m200getKtvSingSongList();
            if (r21 == null) goto L38;
            MusicPanel r22 = (MusicPanel) KtvUtilsKt.K(r21, 0);
            if (r22 == null) goto L38;
            RealTimeChorusInfo r23 = r22.C;
            if (r23 == null) goto L38;
            long r25 = r23.getChorusID();
        L40:
            if (r25 == 0) goto L45;
            long r110 = r14;
            if (r25 == this.a.I) goto L46;
            xe2.b r111 = xe2.b.b;
            String r112 = String.valueOf(r25);
            int r113 = RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole();
            boolean r26 = this.a.isEngineOn();
            r111.getClass();
            xe2.b.u(r112, r113, r26);
            this.a.I = r25;
        L46:
            long r27 = Math.abs(r16);
            RealTimeChorusBusinessWidget r114 = this.a;
            if (r27 >= r114.l) goto L49;
            return;
        L49:
            if (r19 < r114.m) goto L60;
            StringBuilder r28 = new StringBuilder("onReceivedSyncInfo localProgressDiff : ");
            r28.append(r12);
            r28.append(" localNtpDiff : ");
            r28.append(r13);
            r28.append("  audioDeviceLoopDelay : ");
            r28.append(this.a.u);
            r28.append(" curNtp : 0 curProgress : ");
            long r115 = r10;
            r28.append(r115);
            r28.append(" ntpDiff : ");
            r28.append(r110);
            r28.append(" progressDiff : ");
            r28.append(r16);
            r28.append(" seekDiff : ");
            r28.append(r19);
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r28.toString());
            this.a.x = System.currentTimeMillis();
            c1 r29 = this.a.f;
            if (r29 == null) goto L54;
            r29.h(r15);
        L54:
            xe2.b r30 = xe2.b.b;
            String r31 = String.valueOf(r25);
            int r32 = RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole();
            int r33 = this.a.u;
            r30.getClass();
            xe2.b.t(r31, r32, r33, r115, r16, r19);
            int r34 = xe2.g.a;
            xe2.g.a(String.valueOf(r25), RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole(), this.a.u, r115, r16, r19);
            return;
        L60:
            return;
        L45:
            r110 = r14;
        L38:
            r25 = 0;
            goto L40
        L28:
            r10 = 0;
            goto L29
        L7:
            r4 = null;
            goto L8
        }
    }

    public static final class d extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final boolean c() {
            RealTimeChorusBusinessContext.Companion.getClass();
            return RealTimeChorusBusinessContext.a.g();
        }

        public d(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3) {
            Intrinsics.checkNotNullParameter(r3, "transition");
            StringBuilder r0 = new StringBuilder("onKtvStateChange ");
            r0.append(((KtvRoomLyricsStateMachineConfig.d) r3.c).a);
            r0.append(" role :");
            RealTimeChorusViewModel r1 = RealTimeChorusBusinessWidget.wq(this.a);
            if (r1 == null) goto L5;
            Integer r2 = Integer.valueOf(r1.getUserChorusRole());
        L6:
            r0.append(r2.intValue());
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r0.toString());
            MusicPanel r4 = ((KtvRoomLyricsStateMachineConfig.d) r3.c).b();
            if (r4 == null) goto L9;
            this.a.F = r4;
        L9:
            RealTimeChorusViewModel r5 = RealTimeChorusBusinessWidget.wq(this.a);
            if (r5 != null) goto L12;
        L14:
            KtvRoomLyricsStateMachineConfig.d r6 = (KtvRoomLyricsStateMachineConfig.d) r3.c;
            if ((r6 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L18;
            RealTimeChorusBusinessWidget r7 = this.a;
            r7.v = LiveWrappedPlayerState.PLAYING;
        L32:
            Object r8 = r3.a;
            if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L38;
            if ((r3.c instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L38;
            RealTimeChorusBusinessWidget.yq(this.a, "resume");
        L42:
            RealTimeChorusBusinessWidget.wq(this.a).handleStateChanged(r3);
            return;
        L38:
            if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L42;
            if ((r3.c instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L42;
            RealTimeChorusBusinessWidget.yq(this.a, "pause");
            goto L42
        L18:
            if ((r6 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L27;
            RealTimeChorusBusinessWidget r9 = this.a;
            r9.v = LiveWrappedPlayerState.PLAYING;
            RealTimeChorusViewModel r10 = r9.e;
            if (r10 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L23:
            if (r10.getCurrentUserChorusRole() != 1) goto L32;
            this.a.Aq();
            this.a.Bq();
            goto L32
        L27:
            if ((r6 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L30;
            RealTimeChorusBusinessWidget r11 = this.a;
            r11.v = LiveWrappedPlayerState.PAUSED;
            goto L32
        L30:
            if ((r6 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L32;
            RealTimeChorusBusinessWidget r12 = this.a;
            r12.v = LiveWrappedPlayerState.IDLE;
            r12.q.dispose();
            r12.r.dispose();
            r12.C = 0;
            RealTimeChorusBusinessWidget.wq(this.a).clearInfo();
            xe2.h.j();
            jc0.a.a = false;
            jc0.a.b = false;
            goto L32
        L12:
            if (r5.getUserChorusRole() != 2) goto L14;
            this.a.Zq((KtvRoomLyricsStateMachineConfig.d) r3.c);
            goto L32
        L5:
            r2 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void b(KtvRoomLyricsStateMachineConfig.b r5) {
            Intrinsics.checkNotNullParameter(r5, "sideEffect");
            if ((r5 instanceof KtvRoomLyricsStateMachineConfig.b.f) == false) goto L18;
            KtvContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.i r6 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
            long r0 = 0;
            if (r6 == null) goto L7;
            long r2 = r6.b();
        L8:
            if (r6 == null) goto L13;
            Long r7 = r6.f();
            if (r7 == null) goto L13;
            r0 = r7.longValue();
        L13:
            if (r2 >= r0) goto L15;
            String r8 = "cut";
        L16:
            RealTimeChorusBusinessWidget.Qq(this.a.F, r8);
            return;
        L15:
            r8 = "normal";
            goto L16
        L7:
            r2 = 0;
            goto L8
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = KSongTuningPanelHelperKt.d();
            if (r0 == null) goto L9;
            Object r4 = r3.getAnimatedValue();
            if (r4 == null) goto L8;
            r0.m(((Float) r4).floatValue(), false, false);
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class f extends AnimatorListenerAdapter {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ boolean c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            super.onAnimationEnd(r5);
            ei6.a r6 = (ei6.a) this.b.element;
            if (r6 == null) goto L8;
            ri6.b r7 = r6.r();
            if (r7 == null) goto L8;
            RealTimeChorusBusinessWidget r1 = this.a;
            int r2 = RealTimeChorusBusinessWidget.V0;
            r7.s(bj6.a.b(r1.Z0()), true);
        L8:
            if (KtvSettingHelper.q().m() == false) goto L17;
            if (this.a.i0() != 1) goto L17;
            ei6.a r8 = (ei6.a) this.b.element;
            if (r8 == null) goto L17;
            ri6.b r9 = r8.r();
            if (r9 == null) goto L17;
            r9.B(bj6.a.a((ei6.a) this.b.element), LiveWrappedStreamIndex.STREAM_INDEX_3RD);
        L17:
            if (KtvSettingHelper.q().k() == false) goto L19;
        L25:
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r10 = KSongTuningPanelHelperKt.d();
            if (r10 == null) goto L29;
            RealTimeChorusBusinessWidget r3 = this.a;
            int r4 = RealTimeChorusBusinessWidget.V0;
            r10.m(r3.Lq(), false, true);
            return;
        L29:
            return;
        L19:
            if (this.c == false) goto L25;
            ei6.a r11 = (ei6.a) this.b.element;
            if (r11 == null) goto L25;
            ChorusManager r12 = r11.i();
            if (r12 == null) goto L25;
            r12.x(false);
            goto L25
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2, r3);
        }

        public f(RealTimeChorusBusinessWidget r1, Ref.ObjectRef r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class g implements rj0.b {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;
        public final /* synthetic */ MusicPanel b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ Function1 d;

        public final void onSuccess() {
            RealTimeChorusBusinessWidget.wq(this.a).joinRealTimeChorus(this.b, this.c, this.d, "btnClicked");
        }

        public final void onFailed(Exception r2) {
            if (r2 == null) goto L5;
            this.d.invoke(r2);
            return;
        }

        public g(RealTimeChorusBusinessWidget r1, MusicPanel r2, Function1 r3, Function1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class h implements com.bytedance.android.live.liveinteract.plantform.core.k {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ h a;

            public a(h r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                Long r5 = (Long) r4;
                com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onAudioDeviceWarning timeout reset.");
                RealTimeChorusBusinessWidget r6 = this.a.a;
                r6.M = false;
                RealTimeChorusViewModel r7 = r6.e;
                if (r7 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            L5:
                Boolean r8 = (Boolean) r7.isNeedPush().getValue();
                if (r8 == null) goto L18;
                this.a.a.ar(r8.booleanValue(), true, "audiosqueal intercept cancel");
                int r9 = xe2.g.a;
                com.bytedance.live.datacontext.m r10 = o3.g(this.a.a).getRoom();
                Long r0 = null;
                if (r10 == null) goto L12;
                IRoom r11 = (IRoom) r10.getValue();
                if (r11 == null) goto L12;
                String r12 = r11.getIdStr();
            L13:
                RealTimeChorusBusinessWidget r1 = this.a.a;
                String r2 = jc1.k.n(IMiddlewareUserService.class).user().n();
                r1.getClass();
                String r3 = RealTimeChorusBusinessWidget.Iq(r2);
                RealTimeChorusUIInfo r13 = RealTimeChorusBusinessWidget.wq(this.a.a).getLastChorusInfo();
                if (r13 == null) goto L16;
                r0 = r13.getChorusID();
            L16:
                xe2.g.d(r12, r3, "Time Rset updatePublishStatus", r0);
                xe2.b.b.getClass();
                xe2.b.w("time reset recover publish", "audio_squeal");
                xe2.h.n((Boolean) RealTimeChorusBusinessWidget.wq(this.a.a).isNeedPush().getValue(), com.bytedance.android.live.ktv.common.util.j.i(), RealTimeChorusBusinessWidget.wq(this.a.a).getCurrentUserChorusRole(), "recover");
                return;
            L12:
                r12 = null;
                goto L13
            }
        }

        public final void D1(String r1, ByteBuffer r2, int r3) {
        }

        public final void G9(long r1, Exception r3) {
        }

        public final void J(String[] r1, boolean[] r2, int[] r3) {
        }

        public final void L(String r1) {
        }

        public final void L0(String r1, TextureView r2, int r3, int r4) {
        }

        public final void Lb() {
        }

        public final void M1() {
        }

        public final void R(long r1, Exception r3) {
        }

        public final void S(String r1, int r2, int r3) {
        }

        public final void T6(String r1, zf2.s0 r2) {
        }

        public final void V4(String r1, uf2.z.a r2) {
        }

        public final void Xi(int r1, int r2) {
        }

        public final void al(String r1, int r2) {
        }

        public final void b4(String r1, uf2.z.a r2, int r3, int r4) {
        }

        public final void ci() {
        }

        public final void e1(String r1, long r2) {
        }

        public final void f0(long r1, Exception r3) {
        }

        public final void f1(long r1, long r3) {
        }

        public final void f4() {
        }

        public final void h1(String r1, SurfaceView r2, int r3, int r4) {
        }

        public final void h6(int r1) {
        }

        public final void j0(String r1, TextureView r2, int r3, int r4) {
        }

        public final void k1() {
        }

        public final void o() {
        }

        public final void o0(long r1) {
        }

        public final void p2(fi6.a r1) {
        }

        public final void wf(String r1) {
        }

        public final void wk(String r1) {
        }

        public final void y0(String r1, SurfaceView r2, int r3, int r4) {
        }

        public final void z7() {
        }

        public h(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void ip(Object r13) {
            m1 r0 = this.a.w;
            if ((r13 instanceof ByteBuffer) == true) goto L5;
            r13 = null;
        L5:
            ByteBuffer r14 = (ByteBuffer) r13;
            r0.getClass();
            if (r14 != null) goto L8;
            return;
        L8:
            if (r14.remaining() != 0) goto L22;
            return;
        L22:
            JSONObject r1 = new JSONObject(Charset.defaultCharset().decode(r14.duplicate()).toString());     // Catch: JSONException -> L19
            if (r1.has("br_st") == false) goto L27;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.q r15 = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.q(r1.optLong("ntp"), r1.optLong("pos"), r1.optLong("br_st"), r1.optLong("index"));
            Iterator<m1.a> r2 = r0.a.iterator();
        L17:
            if (r2.hasNext() == false) goto L28;
            r2.next().a(r15);
            goto L17
        L28:
            return;
        L27:
            return;
        L19:
            e = move-exception;
            e.printStackTrace();
        }

        public final void onUserJoined(String r2) {
            Intrinsics.checkNotNullParameter(r2, "s");
            Intrinsics.checkNotNullParameter(r2, "s");
        }

        public final void A(String r1, Boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "interactId");
            Intrinsics.checkNotNullParameter(r1, "interactId");
        }

        public final void J3(String r24, String r25) {
            Intrinsics.checkNotNullParameter(r24, "from");
            Intrinsics.checkNotNullParameter(r25, "message");
            if (RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole() != 2) goto L65;
            RealTimeChorusBusinessWidget r2 = this.a;
            r2.getClass();
            if (StringsKt.contains$default(r25, "br_st", false, 2, null) == true) goto L8;
            return;
        L8:
            if ((System.currentTimeMillis() - r2.s) < KtvSettingHelper.q().n()) goto L70;
            JSONObject r3 = new JSONObject(r25);
            long r6 = JSONObjectProtectorUtils.getLong(r3, "pos");
            long r8 = JSONObjectProtectorUtils.getLong(r3, "ntp");
            if (d5.b(JSONObjectProtectorUtils.getString(r3, "br_st")) != 1) goto L15;
            c1 r1 = r2.f;
            if (r1 == null) goto L66;
            r1.e();
            return;
        L66:
            return;
        L15:
            c1 r4 = r2.f;
            if (r4 == null) goto L18;
            r4.g("handleRoomRtsMessage");
        L18:
            ei6.a r5 = r2.Z0();
            if (r5 == null) goto L25;
            ui6.d r7 = r5.l();
            if (r7 == null) goto L25;
            mi6.a r9 = r7.b();
            if (r9 == null) goto L25;
            r9.v();
        L25:
            c1 r10 = r2.f;
            if (r10 == null) goto L28;
            long r11 = r10.a();
        L29:
            long r12 = r11 - r2.z;
            long r14 = 0 - r2.A;
            r2.z = r11;
            r2.A = 0;
            long r13 = 0 - r8;
            long r15 = (r6 + r13) + ((long) r2.u);
            long r16 = r11 - r15;
            long r17 = System.currentTimeMillis() - r2.y;
            KtvModeOrderedSongDataContext r18 = r2.Kq();
            if (r18 == null) goto L38;
            List<MusicPanel> r19 = r18.m200getKtvSingSongList();
            if (r19 == null) goto L38;
            MusicPanel r20 = (MusicPanel) KtvUtilsKt.K(r19, 0);
            if (r20 == null) goto L38;
            RealTimeChorusInfo r21 = r20.C;
            if (r21 == null) goto L38;
            long r0 = r21.getChorusID();
        L40:
            if (r0 == 0) goto L47;
            long r26 = r13;
            if (r0 == r2.I) goto L50;
            xe2.b r22 = xe2.b.b;
            String r23 = String.valueOf(r0);
            RealTimeChorusViewModel r110 = r2.e;
            if (r110 != null) goto L46;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L46:
            int r111 = r110.getCurrentUserChorusRole();
            boolean r112 = r2.isEngineOn();
            r22.getClass();
            xe2.b.u(r23, r111, r112);
            r2.I = r0;
        L50:
            if (Math.abs(r16) >= r2.l) goto L52;
            return;
        L52:
            if (r17 < r2.m) goto L71;
            StringBuilder r27 = new StringBuilder("handleRoomRtsMessage localProgressDiff : ");
            r27.append(r12);
            r27.append(" localNtpDiff : ");
            r27.append(r14);
            r27.append("  audioDeviceLoopDelay : ");
            r27.append(r2.u);
            r27.append(" curNtp : 0 curProgress : ");
            long r113 = r11;
            r27.append(r113);
            r27.append(" ntpDiff : ");
            r27.append(r26);
            r27.append(" progressDiff : ");
            r27.append(r16);
            r27.append(" seekDiff : ");
            r27.append(r17);
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r27.toString());
            r2.y = System.currentTimeMillis();
            c1 r28 = r2.f;
            if (r28 == null) goto L57;
            r28.h(r15);
        L57:
            xe2.b r29 = xe2.b.b;
            String r114 = String.valueOf(r0);
            RealTimeChorusViewModel r30 = r2.e;
            if (r30 != null) goto L60;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L60:
            int r115 = r30.getCurrentUserChorusRole();
            int r116 = r2.u;
            r29.getClass();
            xe2.b.t(r114, r115, r116, r113, r16, r17);
            int r31 = xe2.g.a;
            String r117 = String.valueOf(r0);
            RealTimeChorusViewModel r32 = r2.e;
            if (r32 != null) goto L63;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L63:
            xe2.g.a(r117, r32.getCurrentUserChorusRole(), r2.u, r113, r16, r17);
            return;
        L71:
            return;
        L47:
            r26 = r13;
        L38:
            r0 = 0;
            goto L40
        L28:
            r11 = 0;
            goto L29
        L70:
            return;
        }

        public final void S1(String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r12, "interactId");
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onExRtcRoomLocalUserLeaved rtcRoomId " + r11 + " interactId " + r12);
            int r2 = xe2.g.a;
            Intrinsics.checkNotNullParameter(r11, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r12, "interactId");
            JSONObject r8 = new JSONObject();
            r8.put("rtcRoomId", r11);
            r8.put("interactId", r12);
            int r13 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusCDNStream, "LeaveExRoomEvent", 0, null, r8, 88);
            this.a.V = false;
        }

        public final void Z4(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "interactId");
            RealTimeChorusBusinessWidget r4 = this.a;
            if (r3 != r4.u) goto L5;
        L16:
            this.a.u = r3;
            return;
        L5:
            if (RealTimeChorusBusinessWidget.Fq() == false) goto L16;
            cg6.a r5 = r4.Jq();
            if (r5 == null) goto L16;
            hg6.g r6 = r5.getRtcManager();
            if (r6 == null) goto L16;
            ec6.b r7 = r6.R();
            if (r7 == null) goto L16;
            com.bytedance.android.live.pushstream.d r8 = gc6.b.a(r7);
            if (r8 == null) goto L16;
            r8.u();
            goto L16
        }

        public final void d5(dg2.e r12, dg2.e[] r13) {
            Intrinsics.checkNotNullParameter(r12, "localQuality");
            Intrinsics.checkNotNullParameter(r13, "remoteQualities");
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onNetworkQuality localQuality rtt:0 totalBandwidth:0  fractionLost:0.0 rxQuality:0");
            if (this.a.i0() == 2) goto L5;
        L15:
            boolean r14 = false;
        L17:
            if (r14 == false) goto L37;
            Lazy r15 = KtvSettingHelper.E;
            if (((mf1) r15.getValue()).d() <= 0) goto L21;
            RealTimeChorusBusinessWidget r16 = this.a;
            int r6 = r16.K;
            if (r6 <= 0) goto L48;
            int r7 = r6 - 1;
            r16.K = r7;
            if (r7 != 0) goto L48;
            r16.L = false;
            RealTimeChorusViewModel r17 = r16.e;
            if (r17 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L32:
            Boolean r18 = (Boolean) r17.isNeedPush().getValue();
            if (r18 == null) goto L35;
            this.a.ar(r18.booleanValue(), true, "network intercept cancel");
        L35:
            xe2.b.b.getClass();
            xe2.b.w("reset by count", "network rtt bad");
        L48:
            if (KtvSettingHelper.x().a() == false) goto L50;
            this.a.B = new fd2.e0(KtvSettingHelper.x().c(), KtvSettingHelper.x().b());
        L51:
            StringBuilder r19 = new StringBuilder("WeekNetWork: cellularEnable:");
            r19.append(this.a.O.c());
            r19.append(" ifWifi:");
            r19.append(NetworkUtils.g(((Widget) this.a).context));
            r19.append(" isMobileAvailable:");
            r19.append(NetworkUtils.e(((Widget) this.a).context));
            r19.append(" txQuality:0 txQualityLevel:");
            r19.append(this.a.O.f());
            r19.append(" localWeakNetworkCount:");
            r19.append(this.a.N);
            r19.append(" dialogShowCounts:");
            com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.c.O;
            r19.append((Long) r3.getValue());
            r19.append(" dialogShowCountsLimit:");
            r19.append(this.a.O.d());
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r19.toString());
            if (this.a.O.c() == true) goto L54;
            return;
        L54:
            if (this.a.i0() != 2) goto L56;
        L57:
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r110 = KSongTuningPanelHelperKt.d();
            if (r110 == null) goto L64;
            if (r110.p() != true) goto L64;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "show Cellular but has opened");
            return;
        L64:
            if (NetworkUtils.g(((Widget) this.a).context) == true) goto L66;
        L95:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "show Cellular but not wifi or sim ready");
            return;
        L66:
            if (NetworkUtils.e(((Widget) this.a).context) == false) goto L95;
            if ((((Number) r3.getValue()).longValue() + 1) <= this.a.O.d()) goto L72;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "show Cellular but show cout is more : " + ((Long) r3.getValue()) + " -> " + this.a.O.d());
            return;
        L72:
            long r2 = System.currentTimeMillis();
            com.bytedance.android.livesdk.sharedpref.e r111 = com.bytedance.android.livesdk.sharedpref.c.P;
            Long r4 = (Long) r111.getValue();
            if (r4 == null) goto L78;
            if (r4.longValue() != 0) goto L78;
        L82:
            if (this.a.O.f() > 0) goto L94;
            RealTimeChorusBusinessWidget r112 = this.a;
            int r113 = r112.N + 1;
            r112.N = r113;
            if (r113 != r112.O.e()) goto L102;
            FragmentActivity r114 = ContextUtil.contextToFragmentActivity(((Widget) this.a).context);
            if (r114 == null) goto L93;
            RealTimeChrousCellularDialog r115 = new RealTimeChrousCellularDialog();
            FragmentManager r116 = r114.getSupportFragmentManager();
            LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r115, "RealTimeChrousCellularDialog", r1);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r116, r115, r1) == false) goto L98;
        L92:
            com.bytedance.android.livesdk.sharedpref.e r117 = com.bytedance.android.livesdk.sharedpref.c.O;
            com.bytedance.android.livesdk.sharedpref.f.d(r117, Long.valueOf(((Long) r117.getValue()).longValue() + 1));
            com.bytedance.android.livesdk.sharedpref.e r118 = com.bytedance.android.livesdk.sharedpref.c.P;
            Long r119 = Long.valueOf(r2);
            r118.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r118, r119);
            goto L93
        L98:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L97
        L91:
            r115.show(r116, "RealTimeChrousCellularDialog");
        L93:
            this.a.N = 0;
            return;
        L102:
            return;
        L94:
            this.a.N = 0;
            return;
        L78:
            if (r2 >= (((Number) r111.getValue()).longValue() + this.a.O.b())) goto L82;
            StringBuilder r0 = new StringBuilder("show Cellular but day limit current:");
            SimpleDateFormat r5 = p6.a;
            r0.append(r5.format(new Date(r2)));
            r0.append(" lastTime:");
            r0.append(r5.format(new Date(((Number) r111.getValue()).longValue())));
            r0.append(" interval:");
            r0.append(this.a.O.b());
            r0.append(' ');
            r0.append(r2);
            r0.append(" vs ");
            r0.append((Long) r111.getValue());
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r0.toString());
            return;
        L56:
            if (this.a.i0() == 1) goto L57;
            return;
        L50:
            this.a.B = new fd2.e0(0, 0.0d);
            goto L51
        L21:
            if (this.a.K >= ((mf1) r15.getValue()).b()) goto L48;
            RealTimeChorusBusinessWidget r8 = this.a;
            int r9 = r8.K + 1;
            r8.K = r9;
            if (r9 != ((mf1) r15.getValue()).b()) goto L48;
            RealTimeChorusBusinessWidget r120 = this.a;
            r120.L = true;
            r120.Gq(true);
            xe2.b.b.getClass();
            xe2.b.w("unpublish", "network rtt bad");
            goto L48
        L37:
            if (RealTimeChorusBusinessWidget.wq(this.a).isAssignLead() == false) goto L48;
            RealTimeChorusBusinessWidget r121 = this.a;
            if (r121.L == false) goto L48;
            r121.L = false;
            r121.K = 0;
            RealTimeChorusViewModel r122 = r121.e;
            if (r122 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L43:
            Boolean r123 = (Boolean) r122.isNeedPush().getValue();
            if (r123 == null) goto L46;
            this.a.ar(r123.booleanValue(), true, "network intercept cancel");
        L46:
            xe2.b.b.getClass();
            xe2.b.w("reset by lead", "network rtt bad");
            goto L48
        L5:
            if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L15;
            if (KtvSettingHelper.q().l() == false) goto L15;
            Lazy r124 = KtvSettingHelper.E;
            if (((mf1) r124.getValue()).c() > RealTimeChorusBusinessWidget.wq(this.a).getCurChorusUserCount()) goto L15;
            if (RealTimeChorusBusinessWidget.wq(this.a).isAssignLead() == true) goto L13;
        L14:
            r14 = true;
            goto L17
        L13:
            if (((mf1) r124.getValue()).a() == true) goto L15;
            goto L14
        }

        public final void g(String r1, Boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "interactId");
            Intrinsics.checkNotNullParameter(r1, "interactId");
        }

        public final void n2(String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r12, "interactId");
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onJoinExtRoomResult rtcRoomId " + r11 + " interactId " + r12);
            int r2 = xe2.g.a;
            Intrinsics.checkNotNullParameter(r11, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r12, "interactId");
            JSONObject r8 = new JSONObject();
            r8.put("rtcRoomId", r11);
            r8.put("interactId", r12);
            int r13 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusCDNStream, "JoinExRoomEvent", 0, null, r8, 88);
            this.a.V = true;
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L9;
            RealTimeChorusBusinessWidget r14 = this.a;
            RealTimeChorusViewModel r15 = r14.e;
            if (r15 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L7:
            r14.Pq((String) r15.getSubToken().getValue());
            this.a.Tq("onJoinExtRoomResult");
            return;
        }

        public final void Hf(int r7, String r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "deviceId");
            Lazy r0 = KtvSettingHelper.G;
            if (((kf1) r0.getValue()).a() == true) goto L5;
            return;
        L5:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onAudioDeviceWarning : deviceType:" + r7 + " / deviceId:" + r8 + " / deviceWarning:" + r9);
            int r10 = xe2.g.a;
            com.bytedance.live.datacontext.m r11 = o3.g(this.a).getRoom();
            Long r12 = null;
            if (r11 == null) goto L10;
            IRoom r13 = (IRoom) r11.getValue();
            if (r13 == null) goto L10;
            String r14 = r13.getIdStr();
        L11:
            RealTimeChorusBusinessWidget r1 = this.a;
            String r2 = jc1.k.n(IMiddlewareUserService.class).user().n();
            r1.getClass();
            String r3 = RealTimeChorusBusinessWidget.Iq(r2);
            String r4 = "deviceWarning:" + r9;
            RealTimeChorusUIInfo r5 = RealTimeChorusBusinessWidget.wq(this.a).getLastChorusInfo();
            if (r5 == null) goto L14;
            Long r6 = r5.getChorusID();
        L15:
            xe2.g.d(r14, r3, r4, r6);
            xe2.b.b.getClass();
            xe2.b.w("warning", "audio_squeal");
            xe2.h.n((Boolean) RealTimeChorusBusinessWidget.wq(this.a).isNeedPush().getValue(), com.bytedance.android.live.ktv.common.util.j.i(), RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole(), "device_warning");
            if (r9 == 16) goto L18;
            return;
        L18:
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L20;
            return;
        L20:
            if (this.a.i0() == 2) goto L22;
            return;
        L22:
            if (((kf1) r0.getValue()).b() <= 0) goto L38;
            Disposable r15 = this.a.H;
            if (r15 != null) goto L26;
        L28:
            RealTimeChorusBusinessWidget r16 = this.a;
            r16.M = true;
            r16.Gq(true);
            com.bytedance.live.datacontext.m r17 = o3.g(this.a).getRoom();
            if (r17 == null) goto L33;
            IRoom r18 = (IRoom) r17.getValue();
            if (r18 == null) goto L33;
            String r19 = r18.getIdStr();
        L34:
            RealTimeChorusBusinessWidget r20 = this.a;
            String r21 = jc1.k.n(IMiddlewareUserService.class).user().n();
            r20.getClass();
            String r22 = RealTimeChorusBusinessWidget.Iq(r21);
            RealTimeChorusUIInfo r23 = RealTimeChorusBusinessWidget.wq(this.a).getLastChorusInfo();
            if (r23 == null) goto L37;
            r12 = r23.getChorusID();
        L37:
            xe2.g.d(r19, r22, "AudioSqueal make UnPublish", r12);
            xe2.b.w("unpublish", "audio_squeal");
            xe2.h.n((Boolean) RealTimeChorusBusinessWidget.wq(this.a).isNeedPush().getValue(), com.bytedance.android.live.ktv.common.util.j.i(), RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole(), "unpublish");
            RealTimeChorusBusinessWidget r24 = this.a;
            Disposable r25 = Observable.timer(((kf1) r0.getValue()).b(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this));
            RxUtilKt.c(r25, this.a.j);
            r24.H = r25;
            return;
        L33:
            r19 = null;
            goto L34
        L26:
            if (r15.isDisposed() == true) goto L28;
            r15.dispose();
            goto L28
        L38:
            com.bytedance.live.datacontext.m r26 = o3.g(this.a).getRoom();
            if (r26 == null) goto L43;
            IRoom r27 = (IRoom) r26.getValue();
            if (r27 == null) goto L43;
            String r28 = r27.getIdStr();
        L44:
            RealTimeChorusBusinessWidget r29 = this.a;
            String r30 = jc1.k.n(IMiddlewareUserService.class).user().n();
            r29.getClass();
            String r31 = RealTimeChorusBusinessWidget.Iq(r30);
            RealTimeChorusUIInfo r32 = RealTimeChorusBusinessWidget.wq(this.a).getLastChorusInfo();
            if (r32 == null) goto L47;
            r12 = r32.getChorusID();
        L47:
            xe2.g.d(r28, r31, "AudioSqueal Do Nothing", r12);
            xe2.b.w("only record", "audio_squeal");
            xe2.h.n((Boolean) RealTimeChorusBusinessWidget.wq(this.a).isNeedPush().getValue(), com.bytedance.android.live.ktv.common.util.j.i(), RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole(), "audio_squeal");
            return;
        L43:
            r28 = null;
            goto L44
        L14:
            r6 = null;
        L10:
            r14 = null;
            goto L11
        }

        public final void Rj(int r10, int r11, String r12) {
            Intrinsics.checkNotNullParameter(r12, "taskId");
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onExtraStreamMixFailed " + r10 + ' ' + r11 + ' ' + r12);
            int r1 = xe2.g.a;
            Intrinsics.checkNotNullParameter(r12, "taskId");
            JSONObject r7 = new JSONObject();
            r7.put("errorCode", r10);
            r7.put("mixType", r11);
            r7.put("taskId", r12);
            int r13 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusCDNStream, "ChorusMixStreamFailed", 0, null, r7, 88);
        }

        public final void x1(LiveWrappedNetworkDetectionLinkType r3, int r4, double r5) {
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TYPE);
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onNetworkDetectionResult rtt " + r4 + " lostRate " + r5);
            if (KtvSettingHelper.x().a() == false) goto L5;
            this.a.B = new fd2.e0(KtvSettingHelper.x().c(), KtvSettingHelper.x().b());
            return;
        L5:
            this.a.B = new fd2.e0(r4, r5);
        }
    }

    public static final class i extends Handler {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            super.handleMessage(r3);
            int r4 = r3.what;
            if (r4 != 1) goto L5;
            RealTimeChorusBusinessWidget r5 = this.a;
            int r1 = RealTimeChorusBusinessWidget.V0;
            r5.Yq(true);
            return;
        L5:
            if (r4 != 2) goto L14;
            RealTimeChorusBusinessWidget r6 = this.a;
            int r0 = RealTimeChorusBusinessWidget.V0;
            if (r6.isEngineOn() == false) goto L10;
            RealTimeChorusBusinessWidget r7 = this.a;
            RealTimeChorusBusinessWidget.zq(r7, RealTimeChorusBusinessWidget.wq(r7).getCurrentUserChorusRole());
        L10:
            RealTimeChorusBusinessWidget r8 = this.a;
            RealTimeChorusBusinessWidget.xq(r8, RealTimeChorusBusinessWidget.wq(r8).getCurrentUserChorusRole());
            return;
        }

        public i(RealTimeChorusBusinessWidget r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class j implements com.bytedance.android.live.ktv.common.music.download.p.a {
        public j() {
        }

        public final void c(MusicPanel r1, int r2) {
        }

        public final void a(MusicPanel r1, String r2, String r3) {
            StringBuilder r4 = new StringBuilder("download music ");
            if (r1 == null) goto L7;
            KtvMusic r5 = r1.a;
            if (r5 == null) goto L7;
            String r6 = r5.getMTitle();
        L8:
            r4.append(r6);
            r4.append(" successed");
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r4.toString());
            return;
        L7:
            r6 = null;
            goto L8
        }

        public final void b(MusicPanel r2, int r3, String r4) {
            StringBuilder r5 = new StringBuilder("download music ");
            if (r2 == null) goto L7;
            KtvMusic r6 = r2.a;
            if (r6 == null) goto L7;
            String r7 = r6.getMTitle();
        L8:
            r5.append(r7);
            r5.append(" failed errorCode: ");
            r5.append(r3);
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r5.toString());
            return;
        L7:
            r7 = null;
            goto L8
        }
    }

    public static final class k implements vlc.l {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public k(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r18) {
            if ((r18 instanceof jd) == false) goto L58;
            RealTimeChorusBusinessWidget r2 = this.a;
            jd r0 = (jd) r18;
            int r3 = RealTimeChorusBusinessWidget.V0;
            r2.getClass();
            Integer r4 = r0.getMsgType();
            boolean r5 = false;
            Object r8 = null;
            if (r4 != null) goto L8;
        L47:
            if (r4 != null) goto L50;
            return;
        L50:
            if (r4.intValue() != 5) goto L61;
            int r6 = xe2.g.a;
            Integer r7 = r0.getMsgType();
            n2 r9 = r0.getStopContent();
            JSONObject r15 = new JSONObject();
            r15.put("msgType", r7);
            if (r9 == null) goto L54;
            r8 = Long.valueOf(r9.a());
        L54:
            r15.put("roomId", r8);
            int r10 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusCDNStream, "ReceiverChorusActionMessage", 0, null, r15, 88);
            if (r0.getStopContent() == null) goto L62;
            r2.T = false;
            r2.Wq("actionMessage");
            return;
        L62:
            return;
        L61:
            return;
        L8:
            if (r4.intValue() != 4) goto L47;
            int r11 = xe2.g.a;
            Integer r12 = r0.getMsgType();
            m2 r13 = r0.getStartContent();
            JSONObject r16 = new JSONObject();
            r16.put("msgType", r12);
            if (r13 == null) goto L12;
            Long r14 = Long.valueOf(r13.a());
        L13:
            r16.put("roomId", r14);
            if (r13 == null) goto L16;
            String r17 = r13.b();
        L17:
            r16.put("taskId", r17);
            int r19 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusCDNStream, "ReceiverChorusActionMessage", 0, null, r16, 88);
            m2 r1 = r0.getStartContent();
            if (r1 == null) goto L59;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onActionMessage CHORUS_FOLLOW_CDN_START: " + r1.b());
            com.bytedance.android.livesdk.chatroom.model.v r20 = r2.X;
            if (r20 == null) goto L24;
            y2 r21 = r20.getPushInfo();
            if (r21 == null) goto L24;
            r8 = r21.getPushUrl();
        L24:
            if (r8 == null) goto L64;
            r2.T = true;
            String r22 = r1.b();
            if (r22 != null) goto L29;
        L30:
            r5 = true;
        L31:
            if (r5 == true) goto L33;
        L43:
            String r23 = r1.b();
            if (r23 != null) goto L46;
            r23 = "";
        L46:
            r2.R = r23;
            r2.Tq("actionMessage");
            return;
        L33:
            if (((Boolean) KtvSettingHelper.k0.getValue()).booleanValue() == false) goto L43;
            com.bytedance.android.livesdk.chatroom.o r24 = o3.g(r2);
            if (r24 == null) goto L41;
            com.bytedance.live.datacontext.m r25 = r24.getRoom();
            if (r25 == null) goto L41;
            IRoom r26 = (IRoom) r25.getValue();
            if (r26 == null) goto L41;
            long r27 = r26.getRoomId();
        L42:
            r1.c("mass_chorus-" + r27);
        L41:
            r27 = 0;
            goto L42
        L29:
            if (r22.length() != 0) goto L31;
        L64:
            return;
        L59:
            return;
        L16:
            r17 = null;
            goto L17
        L12:
            r14 = null;
            goto L13
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public l(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            List r3 = (List) r2;
            RealTimeChorusBusinessWidget r4 = this.a;
            int r0 = RealTimeChorusBusinessWidget.V0;
            KtvModeOrderedSongDataContext r5 = r4.Kq();
            if (r5 == null) goto L5;
            MusicPanel r6 = r5.getKtvPublicFirstOrderedSong();
        L6:
            if (r6 == null) goto L10;
            this.a.br();
            return;
        L10:
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public m(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            List r11 = (List) r10;
            RealTimeChorusBusinessWidget r0 = this.a;
            int r1 = RealTimeChorusBusinessWidget.V0;
            if (r0.isEngineOn() == true) goto L5;
            return;
        L5:
            if (this.a.ko() == false) goto L22;
            RealTimeChorusBusinessWidget r2 = this.a;
            r2.getClass();
            ArrayList r3 = new ArrayList();
            int r4 = r11.size();
            Lazy r5 = KtvSettingHelper.J;
            if (r4 < ((Number) r5.getValue()).intValue()) goto L14;
            int r6 = ((Number) r5.getValue()).intValue() - 1;
            if (r6 < 0) goto L15;
            int r7 = 0;
        L11:
            r3.add(ListProtector.get(r11, r7));
            if (r7 == r6) goto L15;
            r7 = r7 + 1;
        L15:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "needDownloadList count: " + r3.size());
            Iterator r12 = r3.iterator();
        L17:
            if (r12.hasNext() == false) goto L23;
            KtvMusicManager.e(KtvMusicManager.m, (MusicPanel) r12.next(), r2.H0, false, null, false, 24);
            goto L17
        L23:
            return;
        L14:
            r3.addAll(r11);
            goto L15
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public n(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onRtcClient advanceLinkSuccess " + ((jd0.p) r3).a + "  " + RealTimeChorusBusinessWidget.Iq(RealTimeChorusBusinessWidget.wq(this.a).m469getLeadSingerUid()));
            this.a.Nq();
            cg6.a r4 = this.a.Jq();
            if (r4 == null) goto L10;
            vb6.g r5 = r4.O5();
            if (r5 == null) goto L11;
            yb6.e r6 = r5.j();
            if (r6 == null) goto L12;
            r6.P(StreamType.AUDIO_VIDEO, "RTChorus");
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public o(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onLiveClient InitSuccess " + ((jd0.o) r4).a);
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r5 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
            if (r5 == null) goto L5;
            r5.Ji();
        L5:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r6 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
            if (r6 == null) goto L8;
            r6.K();
        L8:
            Integer r7 = (Integer) RealTimeChorusBusinessWidget.wq(this.a).getChorusUserType().getValue();
            if (r7 != null) goto L12;
        L13:
            Integer r8 = (Integer) RealTimeChorusBusinessWidget.wq(this.a).getChorusUserType().getValue();
            if (r8 != null) goto L17;
            return;
        L17:
            if (r8.intValue() != 4) goto L36;
        L18:
            RealTimeChorusBusinessWidget.wq(this.a).handleSongListChange();
            if (((Boolean) KtvSettingHelper.l0.getValue()).booleanValue() == false) goto L23;
            c1 r9 = this.a.f;
            if (r9 == null) goto L23;
            r9.c();
        L23:
            KtvModeOrderedSongDataContext r10 = this.a.Kq();
            if (r10 == null) goto L30;
            List<MusicPanel> r11 = r10.m200getKtvSingSongList();
            if (r11 == null) goto L30;
            MusicPanel r12 = (MusicPanel) KtvUtilsKt.K(r11, 0);
            if (r12 == null) goto L30;
            this.a.Sq(r12);
        L30:
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r13 = KSongTuningPanelHelperKt.d();
            if (r13 == null) goto L37;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("KSongTuningCore", "setPlayerVolume " + (r13.V() / r13.D()));
            ILivePlayerClient r0 = hs0.a.b.getCurrentClient();
            if (r0 == null) goto L38;
            r0.setPlayerVolume(r13.V() / r13.D());
            return;
        L38:
            return;
        L37:
            return;
        L36:
            return;
        L12:
            if (r7.intValue() == 3) goto L18;
            goto L13
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public p(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r24) {
            jd0.q r1 = (jd0.q) r24;
            if (RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole() == 1) goto L5;
        L23:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onRtcClient LinkEnd " + r1.a);
            RealTimeChorusBusinessWidget.wq(this.a).updateRole(4, "onRtcClient LinkEnd");
            RealTimeChorusBusinessWidget r2 = this.a;
            r2.t = 0;
            c1 r3 = r2.f;
            if (r3 == null) goto L27;
            r3.i();
            return;
        L27:
            return;
        L5:
            if (RealTimeChorusBusinessWidget.wq(this.a).isPermanentLinkGuest() == false) goto L23;
            KtvModeOrderedSongDataContext r4 = this.a.Kq();
            if (r4 == null) goto L9;
            MusicPanel r5 = r4.getKtvPublicFirstOrderedSong();
        L10:
            String r7 = jc1.k.n(IMiddlewareUserService.class).user().n();
            if (r5 == null) goto L23;
            KtvMusic r8 = r5.a;
            if (r8 == null) goto L23;
            if (r8.isOrderedBy(r7) != true) goto L23;
            long r9 = System.currentTimeMillis();
            com.bytedance.live.datacontext.m r6 = o3.g(this.a).getRoom();
            if (r6 == null) goto L21;
            IRoom r10 = (IRoom) r6.getValue();
            if (r10 == null) goto L21;
            long r13 = r10.getId();
        L22:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "firstMusic isOrderedBy self so remove");
            int r11 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
            com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a.e(r9, r13, r13, r5.c(), r7, false, 0, 0, RealTimeChorusBusinessWidget$onCreate$12$1.INSTANCE, RealTimeChorusBusinessWidget$onCreate$12$2.INSTANCE);
        L21:
            r13 = 0;
            goto L22
        L9:
            r5 = null;
            goto L10
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public q(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            sh6.b r5 = (sh6.b) r4;
            RealTimeChorusBusinessWidget r0 = this.a;
            int r1 = RealTimeChorusBusinessWidget.V0;
            KtvModeOrderedSongDataContext r2 = r0.Kq();
            if (r2 == null) goto L31;
            MusicPanel r3 = r2.getKtvPublicFirstOrderedSong();
            if (r3 != null) goto L8;
            return;
        L8:
            if (sh6.c.b(r5) == null) goto L10;
            return;
        L10:
            if (RealTimeChorusBusinessWidget.wq(this.a).getUserChorusRole() != 2) goto L12;
        L13:
            c1 r6 = this.a.f;
            if (r6 != null) goto L16;
            return;
        L16:
            if (r6.d(r3) != true) goto L35;
            c1 r7 = this.a.f;
            if (r7 == null) goto L20;
            com.bytedance.android.livesdk.ktvimpl.base.i r8 = r7.a;
        L21:
            if (r8 == null) goto L36;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "ktvCoreController is null and isChorusLeader or isChorusViceSinger and musicPanel is playing");
            KtvContext.Companion.getClass();
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r9 = KtvContext.a.g().getKtvCoreController();
            c1 r10 = this.a.f;
            if (r10 == null) goto L25;
            com.bytedance.android.livesdk.ktvimpl.base.i r11 = r10.a;
        L26:
            r9.setValue(r11);
            RealTimeChorusBusinessWidget r12 = this.a;
            c1 r13 = r12.f;
            if (r13 == null) goto L29;
            r13.b = null;
        L29:
            r12.Sq(r3);
            return;
        L25:
            r11 = null;
            goto L26
        L36:
            return;
        L20:
            r8 = null;
            goto L21
        L35:
            return;
        L12:
            if (RealTimeChorusBusinessWidget.wq(this.a).getUserChorusRole() == 1) goto L13;
            return;
        }
    }

    public static final class r<T> implements Observer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public r(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            if (r6 != null) goto L6;
        L46:
            RealTimeChorusBusinessWidget.zq(this.a, r6.intValue());
            RealTimeChorusBusinessWidget.xq(this.a, r6.intValue());
            return;
        L6:
            if (r6.intValue() != 2) goto L46;
            this.a.Z.removeMessages(2);
            this.a.Z.sendEmptyMessageDelayed(2, 600);
            this.a.getClass();
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L41;
            IInteractService r7 = jc1.k.f(IInteractService.class);
            ILinkPlayerInfoBridge r0 = null;
            T r1 = null;
            r0 = null;
            r0 = null;
            if (r7 == null) goto L33;
            com.bytedance.android.live.liveinteract.plantform.base.i r8 = r7.getLinkUserInfoCenter();
            if (r8 == null) goto L33;
            List r9 = r8.getOnlineUserList();
            if (r9 == null) goto L33;
            Iterator<T> r10 = r9.iterator();
        L17:
            if (r10.hasNext() == false) goto L31;
            T r2 = r10.next();
            IBaseUser r3 = ((ILinkPlayerInfoBridge) r2).getUser();
            if (r3 == null) goto L21;
            String r4 = r3.getIdString();
        L22:
            IMiddlewareUserService r11 = jc1.k.f(IMiddlewareUserService.class);
            if (r11 == null) goto L27;
            com.bytedance.android.livesdk.user.e r12 = r11.user();
            if (r12 == null) goto L27;
            String r13 = r12.n();
        L29:
            if (Intrinsics.areEqual(r4, r13) == false) goto L17;
            r1 = r2;
        L27:
            r13 = null;
            goto L29
        L21:
            r4 = null;
        L31:
            r0 = (ILinkPlayerInfoBridge) r1;
        L33:
            if (r0 != null) goto L35;
        L38:
            boolean r14 = true;
        L39:
            if (r14 == false) goto L41;
            f2.b(2131918507, 0);
            goto L41
        L35:
            if (r0.getSilenceStatus() != 0) goto L38;
            r14 = false;
        L41:
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r15 = this.a.i;
            if (r15 == null) goto L51;
            KtvRoomLyricsStateMachineConfig.d r16 = r15.getCurState();
            if (r16 == null) goto L52;
            this.a.Zq(r16);
            return;
        L52:
            return;
        }
    }

    public static final class s<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public s(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            RealTimeChorusBusinessWidget r0 = this.a;
            int r5 = ((Integer) r4).intValue();
            int r1 = RealTimeChorusBusinessWidget.V0;
            r0.getClass();
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "updateVisibleByUserType " + r5);
            if (r5 != 1) goto L5;
            ei6.a r6 = r0.Z0();
            if (r6 == null) goto L32;
            si6.b r7 = r6.b();
            if (r7 == null) goto L32;
            r7.i();
        L32:
            ei6.a r8 = r0.Z0();
            if (r8 == null) goto L37;
            si6.b r9 = r8.b();
            if (r9 == null) goto L37;
            r9.o(bj6.a.b(r0.Z0()), true);
        L37:
            ei6.a r10 = r0.Z0();
            if (r10 == null) goto L46;
            si6.b r11 = r10.b();
            if (r11 == null) goto L47;
            r11.o(bj6.a.a(r0.Z0()), true);
            return;
        L47:
            return;
        L46:
            return;
        L5:
            if (r5 != 2) goto L48;
            ei6.a r12 = r0.Z0();
            if (r12 == null) goto L12;
            ri6.b r13 = r12.r();
            if (r13 == null) goto L12;
            r13.s(bj6.a.b(r0.Z0()), true);
        L12:
            ei6.a r14 = r0.Z0();
            if (r14 == null) goto L17;
            si6.b r15 = r14.b();
            if (r15 == null) goto L17;
            r15.o(bj6.a.b(r0.Z0()), false);
        L17:
            ei6.a r16 = r0.Z0();
            if (r16 == null) goto L22;
            si6.b r17 = r16.b();
            if (r17 == null) goto L22;
            r17.o(bj6.a.a(r0.Z0()), false);
        L22:
            ei6.a r18 = r0.Z0();
            if (r18 == null) goto L43;
            si6.b r19 = r18.b();
            if (r19 == null) goto L44;
            r19.q((int) KtvSettingHelper.q().o());
            return;
        L44:
            return;
        L43:
            return;
        }
    }

    public static final class t<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public t(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            if (r5.booleanValue() == true) goto L5;
        L7:
            RealTimeChorusBusinessWidget r0 = this.a;
            boolean r6 = r5.booleanValue();
            int r2 = RealTimeChorusBusinessWidget.V0;
            r0.ar(r6, true, "wrds update");
            return;
        L5:
            if (this.a.f8() == 1) goto L7;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "need push but userType not on mic");
        }
    }

    public static final class u<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public u(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            String r10 = (String) r9;
            StringBuilder r0 = new StringBuilder("setLeaderSingerUid leadSingerID : ");
            r0.append(RealTimeChorusBusinessWidget.wq(this.a).m469getLeadSingerUid());
            r0.append("  ");
            r0.append(RealTimeChorusBusinessWidget.Iq(RealTimeChorusBusinessWidget.wq(this.a).m469getLeadSingerUid()));
            r0.append(" client == null ");
            boolean r2 = true;
            if (this.a.Z0() != null) goto L5;
            boolean r1 = true;
        L6:
            r0.append(r1);
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r0.toString());
            this.a.getClass();
            if (RealTimeChorusBusinessWidget.Iq(r10).length() == 0) goto L10;
            r2 = false;
        L10:
            if (r2 == true) goto L16;
            ei6.a r3 = this.a.Z0();
            if (r3 == null) goto L16;
            ChorusManager r4 = r3.i();
            if (r4 == null) goto L16;
            this.a.getClass();
            r4.t(RealTimeChorusBusinessWidget.Iq(r10), com.bytedance.android.live.ktv.common.util.j.i());
        L16:
            RealTimeChorusViewModel r5 = RealTimeChorusBusinessWidget.wq(this.a);
            this.a.getClass();
            r5.setLastLeaderInteractId(RealTimeChorusBusinessWidget.Iq(r10));
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L35;
            ei6.a r6 = this.a.Z0();
            if (r6 == null) goto L23;
            ChorusManager r7 = r6.i();
            if (r7 == null) goto L23;
            zi6.a.d r8 = zi6.a.d.a;
            this.a.getClass();
            r7.H(r8, RealTimeChorusBusinessWidget.Iq(r10));
        L23:
            KtvModeOrderedSongDataContext r11 = this.a.Kq();
            if (r11 == null) goto L32;
            List<MusicPanel> r12 = r11.m200getKtvSingSongList();
            if (r12 == null) goto L32;
            MusicPanel r13 = (MusicPanel) KtvUtilsKt.K(r12, 0);
            if (r13 == null) goto L32;
            RealTimeChorusInfo r14 = r13.C;
            if (r14 == null) goto L32;
            long r15 = r14.getChorusID();
        L33:
            xe2.b r16 = xe2.b.b;
            String r17 = String.valueOf(r15);
            int r18 = RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole();
            String r19 = RealTimeChorusBusinessWidget.wq(this.a).m469getLeadSingerUid().toString();
            this.a.getClass();
            String r20 = RealTimeChorusBusinessWidget.Iq(r10);
            boolean r21 = this.a.isEngineOn();
            r16.getClass();
            xe2.b.v(r17, r18, r19, r20, r21);
            int r22 = xe2.g.a;
            String r23 = String.valueOf(r15);
            int r24 = RealTimeChorusBusinessWidget.wq(this.a).getCurrentUserChorusRole();
            String r25 = RealTimeChorusBusinessWidget.wq(this.a).m469getLeadSingerUid().toString();
            this.a.getClass();
            xe2.g.g(r23, r24, r25, RealTimeChorusBusinessWidget.Iq(r10), this.a.isEngineOn());
            return;
        L32:
            r15 = 0;
            goto L33
        L35:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class v<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public v(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            RealTimeChorusBusinessWidget r4 = this.a;
            int r0 = RealTimeChorusBusinessWidget.V0;
            r4.br();
        }
    }

    public static final class w<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public w(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            RealTimeChorusBusinessWidget r4 = this.a;
            int r0 = RealTimeChorusBusinessWidget.V0;
            r4.br();
        }
    }

    public static final class x<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public x(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ArrayList r4 = (ArrayList) r3;
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L10;
            RealTimeChorusBusinessWidget r0 = this.a;
            int r1 = RealTimeChorusBusinessWidget.V0;
            ei6.a r2 = r0.Z0();
            if (r2 == null) goto L11;
            ChorusManager r5 = r2.i();
            if (r5 == null) goto L12;
            r5.J(r4);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class y<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public y(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            RealTimeChorusBusinessWidget r0 = this.a;
            r0.i = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) sh6.c.b((sh6.b) r4);
            RealTimeChorusBusinessWidget r5 = this.a;
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r1 = r5.i;
            if (r1 == null) goto L5;
            r1.unregisterKtvCoreListener(r5.L0);
        L5:
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r6 = this.a.i;
            if (r6 == null) goto L9;
            r6.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE, BaseCoreViewModel.CORE_TAG_EFFECT}), this.a.L0, false);
            return;
        }
    }

    public static final class z<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusBusinessWidget a;

        public z(RealTimeChorusBusinessWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onRtcClient LinkSuccess " + ((jd0.r) r3).a + "  " + RealTimeChorusBusinessWidget.Iq(RealTimeChorusBusinessWidget.wq(this.a).m469getLeadSingerUid()));
            this.a.Nq();
        }
    }

    static {
    }

    public static int Mq() {
        KtvContext.Companion.getClass();
        oe2.b r0 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.d());
    L6:
        if (r1 != null) goto L8;
        oe2.l.f.getClass();
        return oe2.l.a.a();
    L8:
        return r1.intValue();
    L5:
        r1 = null;
        goto L6
    }

    public final void Aq() {
        if (this.q.isDisposed() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "beginSendStreamSyncInfo");
        this.q = du2.a.b(0, this.k, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).subscribe(new b(this));
    }

    public final void Bq() {
        if (this.r.isDisposed() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "beginSendSyncRTS");
        this.r = du2.a.b(0, this.k, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).subscribe(new c(this));
    }

    public final void Cq() {
        Disposable r0 = this.G;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    public final cg6.a Jq() {
        return getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    public final String Kb() {
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return r0.getLastLeaderInteractId();
    }

    public final KtvModeOrderedSongDataContext Kq() {
        return KtvModeOrderedSongDataContext.Companion.getContext();
    }

    public final float Lq() {
        if (((Boolean) KtvSettingHelper.I.getValue()).booleanValue() == false) goto L20;
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L8:
        if (r0.getCurrentChorusMode() == 0) goto L17;
        RealTimeChorusViewModel r1 = this.e;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L13:
        if (r1.isAssignLead() == false) goto L15;
        int r2 = KtvSettingHelper.c().a();
    L25:
        return r2;
    L15:
        r2 = KtvSettingHelper.c().l();
        goto L25
    L17:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r3 = KSongTuningPanelHelperKt.d();
        if (r3 != null) goto L26;
    L23:
        return 0.0f;
    L26:
        return r3.e();
    L20:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r4 = KSongTuningPanelHelperKt.d();
        if (r4 == null) goto L23;
        return r4.e();
    }

    public final void Pa() {
        if (this.P0 == false) goto L5;
        return;
    L5:
        this.P0 = true;
        RealTimeChorusViewModel r1 = this.e;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L8:
        r1.observerKtvOrderedSongList(this);
        KtvModeOrderedSongDataContext r2 = Kq();
        if (r2 == null) goto L13;
        Disposable r3 = r2.observerKtvSingSongListChange(this, true, new l(this));
        if (r3 == null) goto L13;
        RxUtilKt.c(r3, this.j);
    L13:
        KtvModeOrderedSongDataContext r4 = Kq();
        if (r4 == null) goto L16;
        r4.observerKtvSingSongListChange(this, true, new m(this));
    L16:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive.a r5 = this.d;
        Context r6 = ((Widget) this).context;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        ALogger.d("GroupLiveChorusController", "onCreate");
        r5.a = r6;
        com.bytedance.live.datacontext.m r7 = o3.f().getRoom();
        if (r7 == null) goto L25;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L25;
        RoomExtra r9 = r8.getExtra();
        if (r9 == null) goto L25;
        if (r9.isGroupLiveChorus() != true) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == true) goto L28;
        return;
    L28:
        if (gh0.a.d() == false) goto L30;
        new com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive.c().a(r6, true);
        return;
    L30:
        KtvModeOrderedSongDataContext r11 = KtvModeOrderedSongDataContext.Companion.getContext();
        if (r11 == null) goto L33;
        Disposable r0 = r11.observerKtvSingSongListChange(this, true, new com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive.b(r5));
    L34:
        r5.c = r0;
        return;
    L33:
        r0 = null;
    L25:
        r10 = false;
        goto L26
    }

    public final long Qm() {
        c1 r0 = this.f;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a();
    }

    public final boolean Y5() {
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return r0.curUserIsLead();
    }

    public final int f8() {
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        Integer r1 = (Integer) r0.getChorusUserType().getValue();
        if (r1 != null) goto L10;
        return 0;
    L10:
        return r1.intValue();
    }

    public final int i0() {
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return r0.getCurrentUserChorusRole();
    }

    public final boolean isEngineOn() {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.isEngineOn();
    L6:
        if (r1 == false) goto L8;
    L9:
        return true;
    L8:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L9;
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public final boolean isPlaying() {
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return Intrinsics.areEqual((Boolean) r0.isPlayingMusic().getValue(), Boolean.TRUE);
    }

    public final boolean k8() {
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return r0.isJoinUnPublish();
    }

    public final boolean ko() {
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return r0.isAssignLead();
    }

    public final void onDestroy() {
        super.onDestroy();
        Qq(this.F, "break");
        Yq(false);
        StringBuilder r2 = new StringBuilder("onDestroy currentClient  ");
        hs0.a r3 = hs0.a.b;
        r2.append(r3.getCurrentClient());
        r2.append(" data ");
        com.bytedance.live.datacontext.m r4 = o3.g(this).getRoom();
        if (r4 == null) goto L7;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L7;
        String r6 = r5.getMultiStreamData();
    L8:
        r2.append(r6);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r2.toString());
        ILivePlayerClient r7 = r3.getCurrentClient();
        String r8 = "";
        if (r7 == null) goto L18;
        com.bytedance.live.datacontext.m r9 = o3.g(this).getRoom();
        if (r9 == null) goto L16;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L16;
        String r11 = r10.getMultiStreamData();
        if (r11 == null) goto L16;
    L17:
        r7.switchStreamData(r11);
    L16:
        r11 = "";
    L18:
        ILivePlayerClient r12 = r3.getCurrentClient();
        if (r12 == null) goto L21;
        r12.setPlayerVolume(1.0f);
    L21:
        int r13 = xe2.g.a;
        com.bytedance.live.datacontext.m r14 = o3.g(this).getRoom();
        if (r14 == null) goto L29;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L29;
        String r16 = r15.getMultiStreamData();
        if (r16 == null) goto L29;
        r8 = r16;
    L29:
        xe2.g.h(r8, "closeRoom");
        RealTimeChorusViewModel r17 = this.e;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L32:
        Integer r18 = (Integer) r17.getChorusUserType().getValue();
        if (r18 != null) goto L36;
    L37:
        RealTimeChorusViewModel r19 = this.e;
        if (r19 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L40:
        Integer r20 = (Integer) r19.getChorusUserType().getValue();
        if (r20 != null) goto L44;
    L51:
        if (((Boolean) KtvSettingHelper.e1.getValue()).booleanValue() == false) goto L66;
        RealTimeChorusViewModel r21 = this.e;
        if (r21 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L55:
        Integer r22 = (Integer) r21.getChorusUserType().getValue();
        if (r22 == null) goto L66;
        if (r22.intValue() != 2) goto L66;
        cg6.a r23 = Jq();
        if (r23 == null) goto L66;
        MultiLinkGuestManager r24 = r23.W4();
        if (r24 == null) goto L66;
        r24.f("rt_chorus_leave", true);
    L66:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L74;
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.h() == false) goto L74;
        ei6.a r25 = Z0();
        if (r25 == null) goto L74;
        ChorusManager r26 = r25.i();
        if (r26 == null) goto L74;
        r26.o();
    L74:
        this.j.dispose();
        this.q.dispose();
        this.r.dispose();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r27 = this.i;
        if (r27 == null) goto L77;
        r27.unregisterKtvCoreListener(this.L0);
    L77:
        m1 r28 = this.w;
        c0 r29 = this.p0;
        r28.getClass();
        Intrinsics.checkNotNullParameter(r29, "listener");
        if (r28.a.contains(r29) == false) goto L81;
        r28.a.remove(r29);
    L81:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L89;
        com.bytedance.android.livesdk.chatroom.o r30 = o3.g(this);
        if (r30 == null) goto L89;
        com.bytedance.live.datacontext.j r31 = r30.getMessageManager();
        if (r31 == null) goto L89;
        vlc.d r32 = (vlc.d) r31.getValue();
        if (r32 == null) goto L89;
        r32.removeMessageListener(MessageType.KTV_CHORUS_ACTION_MESSAGE.getIntType(), this.W);
    L89:
        c1 r33 = this.f;
        if (r33 == null) goto L101;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusPlayer", r33.hashCode() + ' ' + ThreadMethodProxy.currentThread().getName() + " : " + ThreadMethodProxy.currentThread().getId() + " onDestroy");
        com.bytedance.android.livesdk.ktvimpl.base.i r34 = r33.a;
        if (r34 == null) goto L94;
        r34.l();
    L94:
        com.bytedance.android.livesdk.ktvimpl.base.i r35 = r33.a;
        if (r35 == null) goto L97;
        r35.j();
    L97:
        KtvContext.Companion.getClass();
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r36 = KtvContext.a.g().getKtvCoreController();
        if (r36 == null) goto L100;
        r36.setValue(null);
    L100:
        r33.c.dispose();
    L101:
        ValueAnimator r37 = this.P;
        if (r37 == null) goto L104;
        r37.cancel();
    L104:
        ValueAnimator r38 = this.Q;
        if (r38 == null) goto L108;
        r38.cancel();
    L108:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L110;
        Wq("chorus  finish");
    L110:
        KtvModeOrderedSongDataContext r39 = Kq();
        if (r39 == null) goto L113;
        List<MusicPanel> r40 = r39.m199getKtvOrderedSongList();
    L114:
        String r110 = jc1.k.n(IMiddlewareUserService.class).user().n();
        long r41 = System.currentTimeMillis();
        if (r40 == null) goto L125;
        Iterator<T> r42 = r40.iterator();
        int r43 = 0;
        boolean r44 = false;
    L118:
        if (r42.hasNext() == false) goto L124;
        MusicPanel r45 = (MusicPanel) r42.next();
        KtvMusic r111 = r45.a;
        if (r111 == null) goto L118;
        if (r111.isOrderedBy(r110) != true) goto L118;
        r43 = r45.a.getSongType();
        r44 = true;
        goto L118
    L124:
        int r112 = r43;
    L126:
        com.bytedance.live.datacontext.m r46 = o3.g(this).getRoom();
        if (r46 == null) goto L131;
        IRoom r47 = (IRoom) r46.getValue();
        if (r47 == null) goto L131;
        long r48 = r47.getId();
    L132:
        long r113 = r48;
        if (r44 == false) goto L135;
        int r49 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
        com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a.e(r41, r113, r113, 0, r110, false, r112, 0, RealTimeChorusBusinessWidget$removeMyOrderSong$2.INSTANCE, RealTimeChorusBusinessWidget$removeMyOrderSong$3.INSTANCE);
    L135:
        Rq(this, false, 0);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r1 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r1 == null) goto L138;
        r1.C3(this.k0);
    L138:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r50 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r50 == null) goto L141;
        r50.C3(this.k0);
    L141:
        KtvContext.Companion.getClass();
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) KtvContext.a.g().getSeiProcessor().getValue()).g(this);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive.a r51 = this.d;
        r51.getClass();
        ALogger.d("GroupLiveChorusController", "onDestroy");
        Disposable r52 = r51.c;
        if (r52 == null) goto L144;
        r52.dispose();
    L144:
        r51.c = null;
        return;
    L131:
        r48 = 0;
        goto L132
    L125:
        r44 = false;
        r112 = 0;
        goto L126
    L113:
        r40 = null;
        goto L114
    L44:
        if (r20.intValue() != 4) goto L51;
    L45:
        cg6.a r53 = Jq();
        if (r53 == null) goto L51;
        vb6.g r54 = r53.O5();
        if (r54 == null) goto L51;
        r54.E0("RealTimeChorusBusinessWidget onDestroy");
        goto L51
    L36:
        if (r18.intValue() == 3) goto L45;
    L7:
        r6 = null;
        goto L8
    }

    public final int sb() {
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return r0.getCurrentChorusMode();
    }

    public final long u7() {
        c1 r0 = this.f;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.base.i r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        return 0;
    }

    public RealTimeChorusBusinessWidget() {
        this.d = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive.a();
        this.g = new nd2.d();
        this.h = new xe2.c();
        this.j = new CompositeDisposable();
        this.k = KtvSettingHelper.q().a();
        this.l = KtvSettingHelper.q().b();
        this.m = KtvSettingHelper.q().p();
        this.n = KtvSettingHelper.q().c();
        this.o = KtvSettingHelper.q().e();
        this.p = KtvSettingHelper.q().d();
        this.q = Disposables.disposed();
        this.r = Disposables.disposed();
        this.v = LiveWrappedPlayerState.IDLE;
        this.w = new m1();
        this.J = ((Boolean) vm2.h.b.getValue(null, vm2.h.a[0])).booleanValue();
        this.O = (lf1) KtvSettingHelper.F.getValue();
        this.R = "";
        this.S = "";
        this.W = new k(this);
        this.Z = new i(this, Looper.getMainLooper());
        this.k0 = new h(this);
        this.p0 = new c0(this);
        this.H0 = new j();
        this.L0 = new d(this);
    }

    public static boolean Fq() {
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) KtvSettingHelper.u0.getValue()).booleanValue() == false) goto L7;
        return true;
    }

    public final void Eq() {
        if (Fq() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "enablePulseGeneratorFilter, deviceLoopDelay: " + this.u);
        cg6.a r0 = Jq();
        if (r0 == null) goto L15;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L16;
        ec6.b r2 = r1.R();
        if (r2 == null) goto L17;
        com.bytedance.android.live.pushstream.d r3 = gc6.b.a(r2);
        if (r3 == null) goto L18;
        r3.u();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void Nq() {
        ei6.a r0 = Z0();
        if (r0 == null) goto L10;
        ChorusManager r1 = r0.i();
        if (r1 == null) goto L10;
        RealTimeChorusViewModel r2 = this.e;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L9:
        r1.v((String) r2.getSubToken().getValue(), KtvSettingHelper.B());
    L10:
        RealTimeChorusViewModel r3 = this.e;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L13:
        r3.handleSongListChange();
        ei6.a r4 = Z0();
        if (r4 == null) goto L21;
        ui6.d r5 = r4.l();
        if (r5 == null) goto L21;
        mi6.a r6 = r5.b();
        if (r6 == null) goto L21;
        r6.v();
    L21:
        if (((Boolean) KtvSettingHelper.l0.getValue()).booleanValue() == false) goto L25;
        c1 r7 = this.f;
        if (r7 == null) goto L25;
        r7.c();
    L25:
        this.Z.removeMessages(2);
        this.Z.removeMessages(1);
        this.Z.sendEmptyMessage(1);
        this.Z.sendEmptyMessageDelayed(2, 600);
        RealTimeChorusViewModel r8 = this.e;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L29:
        if (r8.isPermanentLinkGuest() == false) goto L36;
        ei6.a r9 = Z0();
        if (r9 == null) goto L36;
        ChorusManager r10 = r9.i();
        if (r10 == null) goto L36;
        r10.x(false);
    L36:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L45;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "tryUnMuteSelf join chorus need open audio capture");
        cg6.a r11 = Jq();
        if (r11 == null) goto L52;
        jg6.a r12 = r11.e5();
        if (r12 == null) goto L52;
        kg6.e r13 = r12.b();
        if (r13 == null) goto L52;
        r13.f("join chorus need open audio capture");
    L52:
        if (((Boolean) KtvSettingHelper.D.getValue()).booleanValue() == false) goto L61;
        cg6.a r14 = Jq();
        if (r14 == null) goto L61;
        jg6.a r15 = r14.e5();
        if (r15 == null) goto L61;
        kg6.e r16 = r15.b();
        if (r16 == null) goto L61;
        r16.w();
    L61:
        if (KtvSettingHelper.q().h() == false) goto L63;
        Rq(this, true, (int) KtvSettingHelper.q().g());
        return;
    L63:
        Rq(this, false, 0);
        return;
    L45:
        if (this.T == false) goto L52;
        ei6.a r17 = Z0();
        if (r17 == null) goto L52;
        ChorusManager r18 = r17.i();
        if (r18 == null) goto L52;
        r18.A();
        goto L52
    }

    public final ei6.a Z0() {
        cg6.a r0 = Jq();
        if (r0 == null) goto L7;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L7;
        return r1.V0();
    L7:
        return null;
    }

    public final void br() {
        KtvModeOrderedSongDataContext r0 = Kq();
        if (r0 == null) goto L7;
        List<MusicPanel> r1 = r0.m200getKtvSingSongList();
        if (r1 == null) goto L7;
        MusicPanel r2 = (MusicPanel) KtvUtilsKt.K(r1, 0);
    L8:
        if (r2 != null) goto L13;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r3 = KSongTuningPanelHelperKt.d();
        if (r3 == null) goto L45;
        r3.m(100.0f, false, false);
        return;
    L45:
        return;
    L13:
        RealTimeChorusViewModel r4 = this.e;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L16:
        boolean r5 = r4.isAssignLead();
        StringBuilder r6 = new StringBuilder(" updateVolumeByLeadMode isChorusLeader : ");
        r6.append(r5);
        r6.append("  currentChorusMode ");
        RealTimeChorusViewModel r7 = this.e;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L19:
        r6.append(r7.getCurrentChorusMode());
        r6.append(" updateVoiceVolume");
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r6.toString());
        if (((Boolean) KtvSettingHelper.H.getValue()).booleanValue() == false) goto L43;
        RealTimeChorusViewModel r8 = this.e;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L25:
        if (r8.getCurrentChorusMode() == 0) goto L37;
        RealTimeChorusViewModel r9 = this.e;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L30:
        if (r9.isAssignLead() == false) goto L34;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r10 = KSongTuningPanelHelperKt.d();
        if (r10 == null) goto L43;
        r10.m(KtvSettingHelper.c().a(), false, true);
        goto L43
    L34:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r11 = KSongTuningPanelHelperKt.d();
        if (r11 == null) goto L43;
        r11.m(KtvSettingHelper.c().l(), false, true);
        goto L43
    L37:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r12 = KSongTuningPanelHelperKt.d();
        if (r12 == null) goto L43;
        z41 r13 = KtvSettingHelper.c();
        Float r14 = (Float) com.bytedance.android.livesdk.sharedpref.c.e0.getValue();
        if (Intrinsics.areEqual(r14, -1.0f) == false) goto L42;
        r14 = Float.valueOf(r13.g());
    L42:
        r12.m(r14.floatValue() * r13.k(), false, true);
    L43:
        jc0.a.b = r5;
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(RealTimeChorusBusinessWidget$initDataContext$pair$1.INSTANCE);
        RealTimeChorusBusinessContext r1 = (RealTimeChorusBusinessContext) r0.getFirst();
        r1.m454getService().d(this);
        com.bytedance.live.datacontext.b.a(r1, RealTimeChorusBusinessContext.class);
        this.j.add((Disposable) r0.getSecond());
        WidgetViewModelProviders r2 = WidgetViewModelProviders.a;
        RealTimeChorusViewModelFactory r3 = new RealTimeChorusViewModelFactory(getContext(), ((Widget) this).dataCenter);
        r2.getClass();
        RealTimeChorusViewModel r4 = (RealTimeChorusViewModel) WidgetViewModelProviders.a(this, r3).get(RealTimeChorusViewModel.class);
        this.e = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r4.observerCurUserRealTimeChorusRole(this, new r(this));
        RealTimeChorusViewModel r5 = this.e;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L8:
        NextLiveData<Integer> r6 = r5.getChorusUserType();
        if (r6 == null) goto L11;
        r6.observe(this, new s(this));
    L11:
        RealTimeChorusViewModel r7 = this.e;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L14:
        r7.isNeedPush().observe(this, new t(this));
        RealTimeChorusViewModel r8 = this.e;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L17:
        r8.getLeadSingerUid().observe(this, new u(this));
        RealTimeChorusViewModel r9 = this.e;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L20:
        r9.isChorusAssignLeader().observe(this, new v(this));
        RealTimeChorusViewModel r10 = this.e;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L23:
        r10.getChorusMode().observe(this, new w(this));
        RealTimeChorusViewModel r11 = this.e;
        if (r11 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L26:
        r11.getSubToken().observe(this, new com.bytedance.android.livesdk.ktvimpl.realtimechorus.u(this));
        RealTimeChorusViewModel r12 = this.e;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L29:
        r12.getChorusSpatialList().observe(this, new x(this));
        KtvContext.Companion.getClass();
        this.i = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        RxUtilKt.c(KtvContext.a.g().getKtvCoreViewModel().a().subscribe(new y(this)), this.j);
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r13 = this.i;
        if (r13 == null) goto L33;
        r13.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE, BaseCoreViewModel.CORE_TAG_EFFECT}), this.L0, false);
    L33:
        if (Z0() == null) goto L41;
        ei6.a r14 = Z0();
        if (r14 == null) goto L41;
        ui6.d r15 = r14.l();
        if (r15 == null) goto L41;
        mi6.a r16 = r15.b();
        if (r16 == null) goto L41;
        r16.v();
    L41:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r17 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r17 == null) goto L44;
        r17.E4(this.k0);
    L44:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r18 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r18 == null) goto L47;
        r18.E4(this.k0);
    L47:
        this.f = new c1();
        if (((Boolean) KtvSettingHelper.l0.getValue()).booleanValue() == false) goto L52;
        c1 r19 = this.f;
        if (r19 == null) goto L52;
        r19.c();
    L52:
        RxUtilKt.c(xs2.b.a().b(jd0.r.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new z(this)), this.j);
        RxUtilKt.c(xs2.b.a().b(jd0.p.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this)), this.j);
        RxUtilKt.c(xs2.b.a().b(jd0.o.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this)), this.j);
        if (this.J == true) goto L55;
    L60:
        RxUtilKt.c(xs2.b.a().b(jd0.q.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this)), this.j);
        m1 r20 = this.w;
        c0 r21 = this.p0;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r21, "listener");
        if (r20.a.contains(r21) == true) goto L64;
        r20.a.add(r21);
    L64:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L93;
        RealTimeChorusViewModel r22 = this.e;
        if (r22 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L68:
        NextLiveData<String> r23 = r22.getSubToken();
        com.bytedance.live.datacontext.m r24 = o3.g(this).getRoom();
        com.bytedance.android.livesdk.chatroom.model.v r25 = null;
        if (r24 == null) goto L75;
        IRoom r26 = (IRoom) r24.getValue();
        if (r26 == null) goto L75;
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r27 = r26.getLinkInitResult();
        if (r27 == null) goto L75;
        String r28 = r27.getSubRoomToken();
    L76:
        r23.setValue(r28);
        com.bytedance.live.datacontext.m r29 = o3.g(this).getRoom();
        if (r29 == null) goto L83;
        IRoom r30 = (IRoom) r29.getValue();
        if (r30 == null) goto L83;
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r31 = r30.getLinkInitResult();
        if (r31 == null) goto L83;
        r25 = r31.getChorusCDNInfo();
    L83:
        this.X = r25;
        if (r25 != null) goto L86;
        this.X = tc0.c.h().l;
    L86:
        com.bytedance.android.livesdk.chatroom.o r32 = o3.g(this);
        if (r32 == null) goto L93;
        com.bytedance.live.datacontext.j r33 = r32.getMessageManager();
        if (r33 == null) goto L93;
        vlc.d r34 = (vlc.d) r33.getValue();
        if (r34 == null) goto L93;
        r34.addMessageListener(MessageType.KTV_CHORUS_ACTION_MESSAGE.getIntType(), this.W);
    L75:
        r28 = null;
    L93:
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) KtvContext.a.g().getSeiProcessor().getValue(), this);
        if (((Boolean) KtvSettingHelper.d1.getValue()).booleanValue() == false) goto L97;
        RxUtilKt.c(KtvContext.a.g().getKtvCoreController().a().subscribe(new q(this)), this.j);
        return;
    L97:
        return;
    L55:
        if (Z0() == null) goto L60;
        RealTimeChorusViewModel r35 = this.e;
        if (r35 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L59:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onCreate client is not null  ".concat(Iq(r35.m469getLeadSingerUid())));
        Nq();
        goto L60
    }

    public final fd2.e0 D7() {
        return this.B;
    }

    public final String Mm() {
        return this.S;
    }

    public final xe2.c Qe() {
        return this.h;
    }

    public final nd2.d oj() {
        return this.g;
    }

    public static String Iq(String r4) {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        ILinkPlayerInfoBridge r1 = null;
        Object r2 = null;
        r1 = null;
        if (com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a() == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r0 == null) goto L15;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r3 = r0.getLinkUserInfoCenter();
    L16:
        if (r3 == null) goto L30;
        List r5 = r3.getOnlineUserList();
        if (r5 == null) goto L30;
        Iterator r6 = r5.iterator();
    L21:
        if (r6.hasNext() == false) goto L29;
        Object r7 = r6.next();
        IBaseUser r8 = ((ILinkPlayerInfoBridge) r7).getUser();
        if (r8 == null) goto L25;
        String r9 = r8.getIdString();
    L27:
        if (Intrinsics.areEqual(r9, r4) == false) goto L21;
        r2 = r7;
        goto L29
    L25:
        r9 = null;
    L29:
        r1 = (ILinkPlayerInfoBridge) r2;
    L30:
        if (r1 == null) goto L33;
        String r10 = r1.getInteractId();
        if (r10 == null) goto L33;
        return r10;
    L33:
        return "";
    L15:
        r3 = null;
        goto L16
    L7:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a() == null) goto L12;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r11 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r11 == null) goto L15;
        r3 = r11.getLinkUserInfoCenter();
        goto L16
    L12:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r12 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r12 == null) goto L15;
        r3 = r12.getLinkUserInfoCenter();
        goto L16
    }

    public static final /* synthetic */ RealTimeChorusViewModel wq(RealTimeChorusBusinessWidget r1) {
        RealTimeChorusViewModel r2 = r1.e;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        return r2;
    }

    public final void Gq(boolean r6) {
        ValueAnimator r0 = this.Q;
        if (r0 != null) goto L5;
    L7:
        ValueAnimator r1 = this.P;
        if (r1 != null) goto L10;
    L14:
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = Z0();
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{Lq(), 0.0f});
        this.Q = r3;
        if (r3 == null) goto L17;
        r3.setDuration((long) (((nf1) KtvSettingHelper.c0.getValue()).a() * 1000));
    L17:
        ValueAnimator r4 = this.Q;
        if (r4 == null) goto L20;
        r4.addUpdateListener(e.a);
    L20:
        ValueAnimator r5 = this.Q;
        if (r5 == null) goto L23;
        r5.addListener(new f(this, r2, r6));
    L23:
        ValueAnimator r7 = this.Q;
        if (r7 == null) goto L27;
        r7.start();
        return;
    L27:
        return;
    L10:
        if (r1.isRunning() != true) goto L14;
        ValueAnimator r8 = this.P;
        if (r8 == null) goto L14;
        r8.cancel();
        goto L14
    L5:
        if (r0.isRunning() != true) goto L7;
    }

    public final void Pq(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L26;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "setRealTimeChorusInfo " + r3 + "  config : " + KtvSettingHelper.B());
        ei6.a r1 = Z0();
        if (r1 == null) goto L14;
        ChorusManager r2 = r1.i();
        if (r2 == null) goto L14;
        r2.v(r3, KtvSettingHelper.B());
    L14:
        ei6.a r4 = Z0();
        String r5 = null;
        if (r4 == null) goto L19;
        li6.a r6 = r4.e();
        if (r6 == null) goto L19;
        li6.c r7 = r6.b(r3);
    L20:
        if (r7 == null) goto L24;
        li6.b r8 = r7.c;
        if (r8 == null) goto L24;
        r5 = r8.b;
    L24:
        this.S = String.valueOf(r5);
        return;
    L19:
        r7 = null;
        goto L20
    L26:
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void Sq(MusicPanel r11) {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = r11;
        String r2 = null;
        if (((Boolean) KtvSettingHelper.L.getValue()).booleanValue() == false) goto L25;
        if (KtvUtilsKt.z(r11) == false) goto L7;
    L22:
        MusicPanel r1 = r11;
    L23:
        r0.element = r1;
        goto L25
    L7:
        if (KtvUtilsKt.G(r11) == true) goto L22;
        KtvModeOrderedSongDataContext r3 = Kq();
        if (r3 == null) goto L13;
        List<MusicPanel> r4 = r3.m200getKtvSingSongList();
        if (r4 == null) goto L13;
        r1 = (MusicPanel) KtvUtilsKt.K(r4, 0);
    L14:
        if (r1 == null) goto L20;
        KtvMusic r5 = r1.a;
        if (r5 == null) goto L20;
        if (r5.getMId() != r11.c()) goto L20;
    L21:
        if (r1 != null) goto L23;
    L20:
        r1 = null;
    L13:
        r1 = null;
    L25:
        if (KtvSettingHelper.v().getEnableOptimize() == false) goto L27;
        boolean r6 = KtvUtilsKt.n((MusicPanel) r0.element);
    L28:
        StringBuilder r7 = new StringBuilder("startPlayMusic，");
        KtvMusic r12 = r11.a;
        if (r12 == null) goto L31;
        r2 = r12.getMTitle();
    L31:
        r7.append(r2);
        r7.append("，canSetBgm：");
        r7.append(r6);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r7.toString());
        if (r6 == false) goto L37;
        c1 r13 = this.f;
        if (r13 == null) goto L41;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.c.a(r13, (MusicPanel) r0.element, Mq());
        return;
    L41:
        return;
    L37:
        if (KtvSettingHelper.v().getEnableOptimize() == false) goto L39;
        nd2.d.a(this.g, (MusicPanel) r0.element, new a0(this), ((Boolean) KtvSettingHelper.n.getValue()).booleanValue());
        return;
    L39:
        KtvMusicManager.e(KtvMusicManager.m, (MusicPanel) r0.element, new b0(this, r0), false, null, false, 28);
        return;
    L27:
        com.bytedance.android.live.ktv.common.music.download.m r8 = KtvMusicManager.a;
        MusicPanel r9 = (MusicPanel) r0.element;
        Intrinsics.checkNotNullParameter(r9, "panel");
        r6 = KtvUtilsKt.m(r9);
        goto L28
    }

    public final void Tq(String r13) {
        boolean r1 = true;
        if (this.U == false) goto L5;
    L29:
        StringBuilder r14 = new StringBuilder("startPushChorusCDN failed isChorusCDNStreamPushing:  ");
        r14.append(this.U);
        r14.append(" client == null: ");
        if (Z0() == null) goto L33;
        r1 = false;
    L33:
        r14.append(r1);
        r14.append("  isExRoomJoined : ");
        r14.append(this.V);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r14.toString());
        return;
    L5:
        if (Z0() == null) goto L29;
        if (this.V == false) goto L29;
        if (this.T == false) goto L29;
        this.U = true;
        com.bytedance.android.livesdk.chatroom.model.v r0 = this.X;
        if (r0 == null) goto L16;
        y2 r2 = r0.getPushInfo();
        if (r2 == null) goto L16;
        String r3 = r2.getPushUrl();
    L17:
        com.bytedance.live.datacontext.m r4 = o3.g(this).getRoom();
        if (r4 == null) goto L22;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L22;
        long r6 = r5.getRoomId();
    L23:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "startPushChorusCDNStream roomId " + r6 + ",taskId " + this.R + " streamUrl " + r3 + " source " + r13);
        int r15 = xe2.g.a;
        String r16 = this.R;
        Intrinsics.checkNotNullParameter(r16, "taskId");
        JSONObject r10 = new JSONObject();
        r10.put("roomId", r6);
        r10.put("taskId", r16);
        r10.put("streamUrl", r3);
        int r17 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusCDNStream, "StartPushCDNStream", 0, null, r10, 88);
        if (r3 == null) goto L35;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r18 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r18 == null) goto L36;
        r18.zg(this.R, r3);
        return;
    L36:
        return;
    L35:
        return;
    L22:
        r6 = 0;
    L16:
        r3 = null;
        goto L17
    }

    public final void W8(String r3) {
        Intrinsics.checkNotNullParameter(r3, "token");
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.getSubToken().setValue(r3);
    }

    public final void Wq(String r4) {
        if (this.U == true) goto L6;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "stopPushChorusCDN failed isChorusCDNStreamPushing: " + this.U + ' ');
        return;
    L6:
        this.U = false;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "stopPushChorusCDN lastPushTaskId " + this.R + "  source " + r4);
        cg6.a r5 = Jq();
        if (r5 == null) goto L16;
        hg6.g r6 = r5.getRtcManager();
        if (r6 == null) goto L17;
        ei6.a r7 = r6.V0();
        if (r7 == null) goto L18;
        ti6.d r8 = r7.p();
        if (r8 == null) goto L19;
        r8.b(this.R, "RealTimeChorusBusinessWidget stopPushChorusCDN");
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void Yq(boolean r7) {
        long r0 = 0;
        boolean r3 = true;
        boolean r4 = false;
        if (r7 == false) goto L74;
        StringBuilder r8 = new StringBuilder("startRealTimeChorus --------------- client == null : ");
        if (Z0() != null) goto L7;
        boolean r5 = true;
    L8:
        r8.append(r5);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r8.toString());
        ei6.a r9 = Z0();
        if (r9 == null) goto L13;
        ChorusManager r10 = r9.i();
        if (r10 == null) goto L13;
        r10.A();
    L13:
        ei6.a r11 = Z0();
        if (r11 == null) goto L18;
        fi6.a r12 = r11.g();
        if (r12 == null) goto L18;
        r4 = r12.Z;
    L18:
        this.E = r4;
        if (((Boolean) KtvSettingHelper.W.getValue()).booleanValue() == false) goto L33;
        cg6.a r13 = Jq();
        if (r13 == null) goto L27;
        hg6.g r14 = r13.getRtcManager();
        if (r14 == null) goto L27;
        pf6.a r15 = r14.f0();
        if (r15 == null) goto L27;
        r15.O(true);
    L27:
        ei6.a r16 = Z0();
        if (r16 == null) goto L33;
        fi6.a r17 = r16.g();
        if (r17 == null) goto L33;
        r17.Z = true;
    L33:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L62;
        ei6.a r18 = Z0();
        if (r18 == null) goto L39;
        fi6.a r19 = r18.g();
        if (r19 == null) goto L39;
        MixStreamType r20 = r19.U;
    L40:
        this.D = r20;
        ei6.a r21 = Z0();
        if (r21 == null) goto L45;
        fi6.a r22 = r21.g();
        if (r22 == null) goto L45;
        r22.p = ((Boolean) vm2.h.k.getValue(null, vm2.h.a[9])).booleanValue();
    L45:
        ei6.a r23 = Z0();
        if (r23 == null) goto L50;
        fi6.a r24 = r23.g();
        if (r24 == null) goto L50;
        LiveWrappedMixedStreamPushMode r2 = LiveWrappedMixedStreamPushMode.ON_START_REQUEST;
        Intrinsics.checkNotNullParameter(r2, "mTargetPushStreamMode");
        r24.q = r2;
    L50:
        ei6.a r25 = Z0();
        if (r25 == null) goto L55;
        ti6.d r26 = r25.p();
        if (r26 == null) goto L55;
        r26.m(MixStreamType.SERVER_MIX);
    L55:
        int r27 = xe2.g.a;
        com.bytedance.live.datacontext.m r28 = o3.g(this).getRoom();
        if (r28 == null) goto L60;
        IRoom r29 = (IRoom) r28.getValue();
        if (r29 == null) goto L60;
        r0 = r29.getRoomId();
    L60:
        xe2.g.i(r0, MixStreamType.SERVER_MIX.ordinal(), "startRealTimeChorus");
    L39:
        r20 = null;
    L62:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L121;
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.h() == false) goto L122;
        ei6.a r30 = Z0();
        if (r30 == null) goto L123;
        ChorusManager r31 = r30.i();
        if (r31 == null) goto L124;
        g6 r1 = g6.a;
        if (((LiveRTChorusSpatialAudioConfig) r1.getValue()).getSpatialLayout() != 0) goto L72;
        zi6.c.b r6 = zi6.c.b.a;
    L73:
        r31.p(r6, ((LiveRTChorusSpatialAudioConfig) r1.getValue()).getDistanceParams());
        return;
    L72:
        r6 = zi6.c.c.a;
        goto L73
    L124:
        return;
    L123:
        return;
    L122:
        return;
    L121:
        return;
    L7:
        r5 = false;
        goto L8
    L74:
        StringBuilder r32 = new StringBuilder("stopRealTimeChorus ---------------lastMixStreamType ");
        r32.append(this.D);
        r32.append(" client == null : ");
        if (Z0() == null) goto L78;
        r3 = false;
    L78:
        r32.append(r3);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r32.toString());
        this.q.dispose();
        this.r.dispose();
        this.C = 0;
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L99;
        MixStreamType r33 = this.D;
        if (r33 == null) goto L99;
        ei6.a r34 = Z0();
        if (r34 == null) goto L87;
        fi6.a r35 = r34.g();
        if (r35 == null) goto L87;
        r35.p = false;
    L87:
        ei6.a r36 = Z0();
        if (r36 == null) goto L92;
        ti6.d r37 = r36.p();
        if (r37 == null) goto L92;
        r37.m(r33);
    L92:
        int r38 = xe2.g.a;
        com.bytedance.live.datacontext.m r39 = o3.g(this).getRoom();
        if (r39 == null) goto L97;
        IRoom r40 = (IRoom) r39.getValue();
        if (r40 == null) goto L97;
        r0 = r40.getRoomId();
    L97:
        xe2.g.i(r0, r33.ordinal(), "stopRealTimeChorus");
    L99:
        if (((Boolean) KtvSettingHelper.W.getValue()).booleanValue() == false) goto L112;
        cg6.a r41 = Jq();
        if (r41 == null) goto L107;
        hg6.g r42 = r41.getRtcManager();
        if (r42 == null) goto L107;
        pf6.a r43 = r42.f0();
        if (r43 == null) goto L107;
        r43.O(this.E);
    L107:
        ei6.a r44 = Z0();
        if (r44 == null) goto L112;
        fi6.a r45 = r44.g();
        if (r45 == null) goto L112;
        r45.Z = this.E;
    L112:
        RealTimeChorusViewModel r46 = this.e;
        if (r46 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L115:
        r46.updateRole(3, "stopRealTimeChorus");
        ei6.a r47 = Z0();
        if (r47 == null) goto L126;
        ChorusManager r48 = r47.i();
        if (r48 == null) goto L127;
        r48.D();
        return;
    L127:
        return;
    }

    public final void Zq(KtvRoomLyricsStateMachineConfig.d r9) {
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L11;
        if (((Boolean) KtvSettingHelper.R.getValue()).booleanValue() == true) goto L79;
        RealTimeChorusViewModel r10 = this.e;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L9:
        r10.updateRole(3, "Idle");
        return;
    L79:
        return;
    L11:
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L17;
        KtvModeOrderedSongDataContext r11 = Kq();
        if (r11 == null) goto L81;
        MusicPanel r12 = r11.getKtvPublicFirstOrderedSong();
        if (r12 == null) goto L82;
        Sq(r12);
        return;
    L82:
        return;
    L81:
        return;
    L17:
        MusicPanel r3 = null;
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L62;
        KtvModeOrderedSongDataContext r13 = Kq();
        if (r13 == null) goto L22;
        r3 = r13.getKtvPublicFirstOrderedSong();
    L22:
        if (r3 == null) goto L54;
        c1 r14 = this.f;
        if (r14 != null) goto L26;
    L28:
        RealTimeChorusViewModel r15 = this.e;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L32:
        if (r15.isCDNViceSinger() == false) goto L54;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r16 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r16 == null) goto L38;
        RealTimeChorusMainViewWidget r17 = r16.u2();
        if (r17 == null) goto L38;
        long r5 = r17.G2;
    L39:
        boolean r18 = this.Y;
        if (r18 == false) goto L42;
    L49:
        if (r18 == false) goto L54;
        c1 r19 = this.f;
        if (r19 == null) goto L54;
        r19.g("Singing");
        goto L54
    L42:
        if (r5 == 0) goto L49;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "hasReciveredSei is false so need to seek before resume " + r5);
        c1 r20 = this.f;
        if (r20 == null) goto L46;
        r20.h(r5);
    L46:
        c1 r21 = this.f;
        if (r21 == null) goto L54;
        r21.g("Singing");
    L38:
        r5 = 0;
        goto L39
    L26:
        if (r14.d(r3) == true) goto L28;
        Sq(r3);
    L54:
        if (KtvSettingHelper.q().f() == false) goto L84;
        RealTimeChorusViewModel r22 = this.e;
        if (r22 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L58:
        Boolean r23 = (Boolean) r22.isNeedPush().getValue();
        if (r23 == null) goto L85;
        ar(r23.booleanValue(), false, "on singing state");
        return;
    L85:
        return;
    L84:
        return;
    L62:
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L87;
        KtvModeOrderedSongDataContext r24 = Kq();
        if (r24 == null) goto L66;
        r3 = r24.getKtvPublicFirstOrderedSong();
    L66:
        if (r3 == null) goto L72;
        c1 r25 = this.f;
        if (r25 == null) goto L72;
        if (r25.d(r3) == true) goto L72;
        Sq(r3);
    L72:
        c1 r26 = this.f;
        if (r26 == null) goto L76;
        r26.e();
    L76:
        if (KtvSettingHelper.q().f() == false) goto L88;
        ar(true, false, "on paused state");
        return;
    L88:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(com.bytedance.android.livesdk.ktvimpl.base.sei.w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r2, "result");
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r17) {
        Intrinsics.checkNotNullParameter(r17, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r1 = r17.b;
        if ((r1 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L57;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r2 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r1;
        long r3 = (long) ((r2.y() + r2.m()) * 1000.0f);
        if (this.t < r3) goto L7;
        return;
    L7:
        c1 r4 = this.f;
        if (r4 == null) goto L10;
        MusicPanel r5 = r4.b;
    L11:
        if (r5 != null) goto L13;
        return;
    L13:
        this.t = r3;
        RealTimeChorusViewModel r6 = this.e;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L17:
        if (r6.isCDNViceSinger() == true) goto L19;
    L49:
        RealTimeChorusViewModel r7 = this.e;
        if (r7 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L53:
        if (r7.isCDNViceSinger() == true) goto L59;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onSeiResult set  hasReciveredSei false");
        this.Y = false;
        return;
    L59:
        return;
    L19:
        if (r3 == 0) goto L49;
        c1 r8 = this.f;
        if (r8 == null) goto L23;
        long r10 = r8.a();
    L24:
        long r12 = r10 - r3;
        long r14 = System.currentTimeMillis() - this.x;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "curProgress " + r10 + " seiProgress " + r3 + ' ' + this.Y);
        if (Math.abs(r12) >= this.n) goto L27;
        return;
    L27:
        if (r14 >= this.o) goto L30;
        return;
    L30:
        if (this.p == false) goto L32;
    L35:
        this.x = System.currentTimeMillis();
        c1 r9 = this.f;
        if (r9 == null) goto L38;
        r9.h(r3);
    L38:
        this.Y = true;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r11 = this.i;
        if (r11 == null) goto L41;
        KtvRoomLyricsStateMachineConfig.d r13 = r11.getCurState();
    L43:
        if ((r13 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L47;
        c1 r15 = this.f;
        if (r15 == null) goto L47;
        r15.g("onSeiResult");
    L47:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "isCDNViceSinger onSingProgressChange seek seekDiff: " + r14 + "  progressDiff: " + r12 + "  sendUser " + r2.A() + " seiProgress " + r3);
        return;
    L41:
        r13 = null;
        goto L43
    L32:
        if (r12 <= 0) goto L35;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "onSeiResult " + this.p);
        return;
    L23:
        r10 = 0;
        goto L24
    L10:
        r5 = null;
        goto L11
    }

    public final void qf(boolean r3) {
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.isPlayingMusic().setValue(Boolean.valueOf(r3));
    }

    public final void setChorusCDNInfo(com.bytedance.android.livesdk.chatroom.model.v r2) {
        Intrinsics.checkNotNullParameter(r2, "cdnInfo");
        this.X = r2;
    }

    public static void Qq(MusicPanel r34, String r35) {
        if (r34 != null) goto L5;
        return;
    L5:
        String r0 = r34.d;
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        com.bytedance.android.livesdk.log.filter.o r1 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r1 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L11;
        r1 = null;
    L11:
        com.bytedance.android.livesdk.log.filter.t r2 = (com.bytedance.android.livesdk.log.filter.t) r1;
        if (r2 == null) goto L16;
        Map<String, String> r3 = r2.getMap();
        if (r3 == null) goto L16;
        String r4 = r3.get("enter_from_merge");
    L18:
        if (Intrinsics.areEqual(r4, "single_song") == false) goto L41;
        com.bytedance.android.livesdk.log.filter.o r5 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r5 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L22;
        r5 = null;
    L22:
        com.bytedance.android.livesdk.log.filter.t r6 = (com.bytedance.android.livesdk.log.filter.t) r5;
        if (r6 == null) goto L27;
        Map<String, String> r7 = r6.getMap();
        if (r7 == null) goto L27;
        String r8 = r7.get("enter_method");
    L29:
        if (Intrinsics.areEqual(r8, "song") == false) goto L41;
        KtvMusic r9 = r34.a;
        if (r9 == null) goto L33;
        Long r10 = Long.valueOf(r9.getMId());
    L34:
        long r11 = r10.longValue();
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r12 = KtvRoomContext.a.a();
        if (r12 == null) goto L41;
        com.bytedance.live.datacontext.m<Long> r13 = r12.getRelevantLiveSongId();
        if (r13 == null) goto L41;
        if (r11 != ((Number) r13.getValue()).longValue()) goto L41;
        r0 = "from_detail_pop_music";
        goto L41
    L33:
        r10 = null;
    L27:
        r8 = null;
    L41:
        KtvMusic r14 = r34.a;
        if (r14 == null) goto L44;
        String r15 = com.bytedance.android.live.ktv.common.util.a.b(r14);
    L46:
        if (r15.length() != 0) goto L48;
        boolean r16 = true;
    L49:
        if (r16 == false) goto L51;
        HashMap r17 = null;
    L52:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r18 = KSongTuningPanelHelperKt.d();
        if ((r18 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L55;
        r18 = null;
    L55:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r19 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r18;
        if (r19 == null) goto L58;
        Boolean r20 = r19.J();
    L59:
        boolean r110 = Intrinsics.areEqual(r20, Boolean.TRUE);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r21 = KSongTuningPanelHelperKt.d();
        if (r21 == null) goto L62;
        r21.b();
    L62:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r22 = KSongTuningPanelHelperKt.d();
        if (r22 == null) goto L65;
        r22.P();
    L65:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r23 = KSongTuningPanelHelperKt.d();
        if (r23 == null) goto L68;
        r23.P();
    L68:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r24 = KSongTuningPanelHelperKt.d();
        if (r24 == null) goto L71;
        r24.b();
    L71:
        KtvContext.Companion.getClass();
        oe2.b r25 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        Long r26 = KtvLoggerHelper.a;
        KtvMusic r27 = r34.a;
        if (r27 == null) goto L74;
        Long r28 = Long.valueOf(r27.getMId());
    L75:
        long r29 = r28.longValue();
        long r30 = (xe2.h.b + (System.currentTimeMillis() - xe2.h.a)) / ((long) 1000);
        String r111 = com.bytedance.android.live.ktv.common.util.j.g();
        KtvMusic r31 = r34.a;
        if (r31 == null) goto L81;
        String r32 = r31.getMTitle();
        if (r32 == null) goto L81;
        String r112 = r32;
    L82:
        boolean r113 = Intrinsics.areEqual(r35, "normal");
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r33 = KSongTuningPanelHelperKt.d();
        if ((r33 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L85;
        r33 = null;
    L85:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r36 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r33;
        if (r36 == null) goto L88;
        boolean r210 = r36.d0();
    L89:
        String r37 = r34.b();
        if (r37 != null) goto L92;
        String r211 = "";
    L93:
        KtvMusic r38 = r34.a;
        if (r38 == null) goto L99;
        String r39 = r38.getMAuthor();
        if (r39 == null) goto L99;
        String r212 = r39;
    L100:
        if (r25 == null) goto L102;
        String r213 = r25.getEnterFrom();
    L103:
        KtvMusic r40 = r34.a;
        if (r40 == null) goto L108;
        List r41 = r40.getTags();
        if (r41 == null) goto L108;
        boolean r214 = r41.contains("原唱");
    L109:
        if (r25 == null) goto L111;
        String r215 = r25.c();
    L112:
        if (r25 == null) goto L114;
        String r216 = r25.a();
    L115:
        KtvMusic r42 = r34.a;
        if (r42 == null) goto L124;
        String r43 = r42.getMidiUrl();
        if (r43 == null) goto L124;
        if (r43.length() <= 0) goto L122;
        boolean r44 = true;
    L123:
        Boolean r310 = Boolean.valueOf(r44);
    L125:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r45 = KtvRoomContext.a.a();
        if (r45 == null) goto L132;
        com.bytedance.live.datacontext.n<Float> r46 = r45.getReportMidiScore();
        if (r46 == null) goto L132;
        Float r47 = (Float) r46.getValue();
        if (r47 == null) goto L132;
        Integer r311 = Integer.valueOf((int) r47.floatValue());
    L134:
        if (r34.t != true) goto L136;
        boolean r312 = true;
    L137:
        KtvComponentContext r48 = KtvComponentContext.Companion.getContext();
        if (r48 == null) goto L146;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r49 = r48.getKtvComponentUIContext();
        if (r49 == null) goto L146;
        KtvComponentUIContext r50 = (KtvComponentUIContext) r49.getValue();
        if (r50 == null) goto L146;
        MutableLiveData<Boolean> r51 = r50.getScoreOpen();
        if (r51 == null) goto L146;
        Boolean r313 = (Boolean) r51.getValue();
    L147:
        Boolean r52 = r34.A;
        KtvLoggerHelper.a0(r0, r29, r30, r111, r112, r113, r35, r210, r211, r212, r17, r110 ? 1 : 0, "", false, r213, r214, r215, r216, r310, r311, r312, r313, r52, r34, null, null);
        return;
    L146:
        r313 = null;
        goto L147
    L136:
        r312 = false;
    L132:
        r311 = null;
        goto L134
    L122:
        r44 = false;
    L124:
        r310 = null;
        goto L125
    L114:
        r216 = null;
        goto L115
    L111:
        r215 = null;
    L108:
        r214 = false;
        goto L109
    L102:
        r213 = null;
    L99:
        r212 = "";
        goto L100
    L92:
        r211 = r37;
        goto L93
    L88:
        r210 = false;
    L81:
        r112 = "";
        goto L82
    L74:
        r28 = null;
        goto L75
    L58:
        r20 = null;
        goto L59
    L51:
        r17 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("song_type", r15)});
        goto L52
    L48:
        r16 = false;
        goto L49
    L44:
        r15 = "";
    L16:
        r4 = null;
        goto L18
    }

    public static final void xq(RealTimeChorusBusinessWidget r2, int r3) {
        r2.getClass();
        if (r3 != 2) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4 = r2.i;
        if (r4 == null) goto L33;
        KtvRoomLyricsStateMachineConfig.d r5 = r4.getCurState();
        if (r5 == null) goto L34;
        r2.Zq(r5);
        return;
    L34:
        return;
    L33:
        return;
    L5:
        if (r3 != 3) goto L7;
    L9:
        c1 r6 = r2.f;
        if (r6 == null) goto L12;
        MusicPanel r7 = r6.b;
    L13:
        if (r7 != null) goto L20;
        RealTimeChorusViewModel r8 = r2.e;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L17:
        if (r8 != null) goto L19;
        return;
    L19:
        if (r8.getLastRole() == 2) goto L20;
        return;
    L20:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "lastRole is vice now stop Music");
        r2.t = 0;
        c1 r9 = r2.f;
        if (r9 == null) goto L23;
        r9.i();
    L23:
        r2.Y = false;
        return;
    L12:
        r7 = null;
        goto L13
    L7:
        if (r3 == 4) goto L9;
    }

    public static final void yq(RealTimeChorusBusinessWidget r7, String r8) {
        r7.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "updateRealTimeChorusDuration ;; source: ".concat(r8));
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.i r9 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r9 == null) goto L29;
        MusicPanel r0 = r7.F;
        if (r0 == null) goto L8;
        long r3 = r0.c();
    L9:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r10 = r7.i;
        if (r10 == null) goto L16;
        KtvRoomLyricsStateMachineConfig.d r11 = r10.getCurState();
        if (r11 == null) goto L16;
        MusicPanel r12 = r11.b();
        if (r12 == null) goto L16;
        long r5 = r12.c();
    L18:
        if (r3 == r5) goto L20;
        return;
    L20:
        if (r9.m == true) goto L22;
        xe2.h.a = System.currentTimeMillis();
        return;
    L22:
        if (xe2.h.a == 0) goto L27;
        xe2.h.b += System.currentTimeMillis() - xe2.h.a;
        return;
    L27:
        return;
    L16:
        r5 = -1;
        goto L18
    L8:
        r3 = 0;
        goto L9
    }

    public static final void zq(RealTimeChorusBusinessWidget r16, int r17) {
        r16.getClass();
        StringBuilder r2 = new StringBuilder("updateRoleForRtc ");
        r2.append(r17);
        r2.append(" chorusUserType ");
        r2.append(r16.f8());
        r2.append(" leadSingerID : ");
        RealTimeChorusViewModel r3 = r16.e;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r2.append(Iq(r3.m469getLeadSingerUid()));
        r2.append(" getRtcClient == null : ");
        boolean r5 = true;
        if (r16.Z0() != null) goto L8;
        boolean r4 = true;
    L9:
        r2.append(r4);
        r2.append(" token= ");
        RealTimeChorusViewModel r6 = r16.e;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L12:
        r2.append((String) r6.getSubToken().getValue());
        r2.append(" config : ");
        r2.append(KtvSettingHelper.B());
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", r2.toString());
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        RealTimeChorusViewModel r8 = r16.e;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L15:
        r7.element = Iq(r8.m469getLeadSingerUid());
        Ref.LongRef r9 = new Ref.LongRef();
        KtvModeOrderedSongDataContext r10 = r16.Kq();
        if (r10 == null) goto L24;
        List<MusicPanel> r11 = r10.m200getKtvSingSongList();
        if (r11 == null) goto L24;
        MusicPanel r12 = (MusicPanel) KtvUtilsKt.K(r11, 0);
        if (r12 == null) goto L24;
        RealTimeChorusInfo r13 = r12.C;
        if (r13 == null) goto L24;
        long r14 = r13.getChorusID();
    L25:
        r9.element = r14;
        if (r17 != 3) goto L38;
        RealTimeChorusViewModel r15 = r16.e;
        if (r15 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L31:
        if (r15.isPermanentLinkGuest() == false) goto L38;
        ei6.a r18 = r16.Z0();
        if (r18 == null) goto L38;
        ChorusManager r19 = r18.i();
        if (r19 == null) goto L38;
        r19.x(false);
    L38:
        if (((Boolean) KtvSettingHelper.I.getValue()).booleanValue() == false) goto L40;
        r16.br();
    L40:
        String r20 = (String) r7.element;
        if (r20 != null) goto L43;
    L46:
        boolean r21 = true;
    L47:
        if (r21 == true) goto L76;
        ei6.a r22 = r16.Z0();
        if (r22 == null) goto L54;
        ChorusManager r23 = r22.i();
        if (r23 == null) goto L54;
        r23.t((String) r7.element, com.bytedance.android.live.ktv.common.util.j.i());
    L54:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L76;
        ei6.a r24 = r16.Z0();
        if (r24 == null) goto L63;
        ChorusManager r25 = r24.i();
        if (r25 == null) goto L63;
        zi6.a.d r110 = zi6.a.d.a;
        RealTimeChorusViewModel r111 = r16.e;
        if (r111 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L62:
        r25.H(r110, Iq(r111.m469getLeadSingerUid()));
    L63:
        xe2.b r26 = xe2.b.b;
        String r112 = String.valueOf(r9.element);
        RealTimeChorusViewModel r113 = r16.e;
        if (r113 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L66:
        String r114 = r113.m469getLeadSingerUid().toString();
        String r115 = (String) r7.element;
        boolean r116 = r16.isEngineOn();
        r26.getClass();
        xe2.b.v(r112, r17, r114, r115, r116);
        int r27 = xe2.g.a;
        String r28 = String.valueOf(r9.element);
        RealTimeChorusViewModel r117 = r16.e;
        if (r117 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L69:
        int r118 = r117.getCurrentUserChorusRole();
        RealTimeChorusViewModel r119 = r16.e;
        if (r119 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L72:
        String r120 = r119.m469getLeadSingerUid().toString();
        RealTimeChorusViewModel r121 = r16.e;
        if (r121 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L75:
        xe2.g.g(r28, r118, r120, r121.m469getLeadSingerUid().toString(), r16.isEngineOn());
    L76:
        RealTimeChorusViewModel r29 = r16.e;
        if (r29 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L80:
        if (r29.getLastRole() != 1) goto L87;
        RealTimeChorusViewModel r30 = r16.e;
        if (r30 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L85:
        if (r17 == r30.getLastRole()) goto L87;
        r16.q.dispose();
        r16.r.dispose();
        r16.C = 0;
    L87:
        xe2.b r31 = xe2.b.b;
        String r122 = String.valueOf(r9.element);
        RealTimeChorusViewModel r123 = r16.e;
        if (r123 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L90:
        String r124 = r123.m469getLeadSingerUid().toString();
        String r125 = (String) r7.element;
        boolean r126 = r16.isEngineOn();
        RealTimeChorusViewModel r127 = r16.e;
        if (r127 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L93:
        String r128 = (String) r127.getSubToken().getValue();
        String r129 = KtvSettingHelper.B();
        r31.getClass();
        Intrinsics.checkNotNullParameter(r122, "chorusId");
        Intrinsics.checkNotNullParameter(r124, "leaderSingerId");
        Intrinsics.checkNotNullParameter(r125, "leaderSingerInteractId");
        Intrinsics.checkNotNullParameter(r129, "rtcEncodeConfig");
        JSONObject r32 = new JSONObject();
        r32.put("chorusId", r122);
        r32.put("cur_chorus_role", String.valueOf(r17));
        r32.put("lead_singer_uid", r124);
        r32.put("lead_singer_interactId", r125);
        if (r126 == false) goto L96;
        String r33 = "1";
    L97:
        r32.put("is_engine_on", r33);
        r32.put("sub_rtc_token", r128);
        r32.put("rtc_encode_config", r129);
        xe2.b.s(LinkMonitorData.UpdateChorusRoleToRtc, r32);
        ei6.a r34 = r16.Z0();
        if (r34 == null) goto L105;
        ChorusManager r35 = r34.i();
        if (r35 == null) goto L105;
        RealTimeChorusViewModel r36 = r16.e;
        if (r36 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L104:
        r35.v((String) r36.getSubToken().getValue(), KtvSettingHelper.B());
    L105:
        if (r17 != 1) goto L107;
        r16.Aq();
        r16.Bq();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = KSongTuningPanelHelperKt.d();
        if (r1 == null) goto L182;
        float r37 = r1.V();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r38 = KSongTuningPanelHelperKt.d();
        if (r38 == null) goto L182;
        r38.j(r37);
    L182:
        ei6.a r39 = r16.Z0();
        if (r39 == null) goto L187;
        ChorusManager r40 = r39.i();
        if (r40 == null) goto L187;
        r40.w(zi6.b.c.a, com.bytedance.android.live.ktv.common.util.j.i());
    L187:
        r16.Cq();
        r16.Eq();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r41 = KSongTuningPanelHelperKt.d();
        if (r41 != null) goto L190;
    L194:
        String r42 = (String) r7.element;
        if (r42 != null) goto L197;
    L200:
        if (r5 == false) goto L207;
        ei6.a r0 = r16.Z0();
        if (r0 == null) goto L208;
        ChorusManager r43 = r0.i();
        if (r43 == null) goto L209;
        r43.t("", com.bytedance.android.live.ktv.common.util.j.i());
        return;
    L209:
        return;
    L208:
        return;
    L207:
        return;
    L197:
        if (r42.length() == 0) goto L200;
        r5 = false;
        goto L200
    L190:
        if (r16.O.c() == false) goto L194;
        if (r41.p() == false) goto L194;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a.a.a(r41, true, "lead singer");
        goto L194
    L107:
        if (r17 != 2) goto L109;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r44 = KSongTuningPanelHelperKt.d();
        if (r44 == null) goto L156;
        float r45 = r44.V();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r46 = KSongTuningPanelHelperKt.d();
        if (r46 == null) goto L156;
        r46.j(r45);
    L156:
        r16.s = System.currentTimeMillis();
        int r47 = r16.f8();
        if (r47 == 1) goto L165;
        if (r47 != 2) goto L170;
        ei6.a r48 = r16.Z0();
        if (r48 == null) goto L170;
        ChorusManager r49 = r48.i();
        if (r49 == null) goto L170;
        r49.w(zi6.b.d.a, com.bytedance.android.live.ktv.common.util.j.i());
    L170:
        Disposable r50 = Observable.timer(KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.v(r16, r9, r7));
        RxUtilKt.c(r50, r16.j);
        r16.G = r50;
        r16.Eq();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r51 = KSongTuningPanelHelperKt.d();
        if (r51 == null) goto L194;
        if (r16.O.c() == false) goto L194;
        if (r51.p() == false) goto L194;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a.a.a(r51, true, "vice singer");
        goto L194
    L165:
        ei6.a r52 = r16.Z0();
        if (r52 == null) goto L170;
        ChorusManager r53 = r52.i();
        if (r53 == null) goto L170;
        r53.w(zi6.b.f.a, com.bytedance.android.live.ktv.common.util.j.i());
        goto L170
    L109:
        if (r17 != 3) goto L111;
        ei6.a r54 = r16.Z0();
        if (r54 == null) goto L131;
        ri6.b r55 = r54.r();
        if (r55 == null) goto L131;
        r55.d(100);
    L131:
        ei6.a r56 = r16.Z0();
        if (r56 == null) goto L136;
        ChorusManager r57 = r56.i();
        if (r57 == null) goto L136;
        r57.w(zi6.b.a.a, com.bytedance.android.live.ktv.common.util.j.i());
    L136:
        r16.Cq();
        if (Fq() == false) goto L148;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "disablePulseGeneratorFilter");
        cg6.a r58 = r16.Jq();
        if (r58 == null) goto L148;
        hg6.g r59 = r58.getRtcManager();
        if (r59 == null) goto L148;
        ec6.b r60 = r59.R();
        if (r60 == null) goto L148;
        com.bytedance.android.live.pushstream.d r61 = gc6.b.a(r60);
        if (r61 == null) goto L148;
        r61.u();
    L148:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r62 = KSongTuningPanelHelperKt.d();
        if (r62 == null) goto L194;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a.a.a(r62, false, "onlooker");
        goto L194
    L111:
        if (r17 != 4) goto L194;
        ei6.a r63 = r16.Z0();
        if (r63 == null) goto L118;
        ri6.b r64 = r63.r();
        if (r64 == null) goto L118;
        r64.d(100);
    L118:
        ei6.a r65 = r16.Z0();
        if (r65 == null) goto L123;
        ChorusManager r66 = r65.i();
        if (r66 == null) goto L123;
        r66.w(zi6.b.a.a, com.bytedance.android.live.ktv.common.util.j.i());
    L123:
        r16.Cq();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r67 = KSongTuningPanelHelperKt.d();
        if (r67 == null) goto L194;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a.a.a(r67, false, "offline guest");
        goto L194
    L96:
        r33 = BDLocationException.ERROR_TIMEOUT;
        goto L97
    L43:
        if (r20.length() == 0) goto L46;
        r21 = false;
    L24:
        r14 = 0;
        goto L25
    L8:
        r4 = false;
        goto L9
    }

    public final void cp(LifecycleOwner r3, Observer<Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.observerCurUserRealTimeChorusRole(r3, r4);
    }

    public final void kj(LifecycleOwner r3, Observer<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.isChorusAssignLeader().observe(r3, r4);
    }

    public final void pn(LifecycleOwner r3, Observer<Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.getChorusUserType().observe(r3, r4);
    }

    public final void y9(RealTimeChorusBusinessLifecycleOwner r3, RealTimeChorusMainViewWidget$initIsPlayingMusicObserver$$inlined$let$lambda$1 r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.isPlayingMusic().observe(r3, r4);
    }

    public final void yj(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        if (Intrinsics.areEqual(this.R, r3) == true) goto L5;
    L8:
        this.T = r4;
        this.R = r3;
        return;
    L5:
        if (this.T != r4) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "updateChorusCDNStatus lastPushTaskId " + this.R + " taskId " + r3 + "  isNeedPushChorusCDN " + this.T + " status " + r4);
    }

    public static void Rq(RealTimeChorusBusinessWidget r3, boolean r4, int r5) {
        ArrayList r0 = new ArrayList();
        r3.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "setAudioSelect " + r4 + " selectCount " + r5 + " highPriorityRemoteUsers " + r0);
        cg6.a r6 = r3.Jq();
        if (r6 == null) goto L10;
        vb6.g r7 = r6.O5();
        if (r7 == null) goto L11;
        yb6.e r8 = r7.j();
        if (r8 == null) goto L12;
        r8.b0(r4, r5, r0, "RTCHorus");
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void Ch(String r3, long r4, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "toUsers");
        RealTimeChorusViewModel r0 = this.e;
        if (r0 == null) goto L9;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        if (r0 == null) goto L10;
        r0.updateRealtimeChorusGuestStatus(r3, r4, r6);
        return;
    L10:
        return;
    }

    public final void Fi(MusicPanel r5, Function1<Object, Unit> r6, Function1<? super Throwable, Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, "music");
        Intrinsics.checkNotNullParameter(r6, "successCallback");
        Intrinsics.checkNotNullParameter(r7, "failCallback");
        Context r0 = ((Widget) this).context;
        g r1 = new g(this, r5, r6, r7);
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "listener");
        OperateType r8 = OperateType.APPLY;
        ArrayList r9 = new ArrayList();
        r9.add(qh0.g.a(r8, 2));
        r9.add(new qh0.f.g(r0, r8, 2));
        r9.add(new qh0.f.c(r0, r8, 2));
        r9.add(new qh0.f.a(r0));
        r9.add(new qh0.f.d(r0, r8, 2, true));
        r9.add(new qh0.f.f(r0, r8, 2, true));
        r9.add(new qh0.f.e(r0, r8));
        qh0.f.a(r9).a(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.r(r1));
    }

    public final void ar(boolean r22, boolean r23, String r24) {
        if (Z0() != null) goto L6;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "updatePublishStatus rtc client == null");
    L6:
        if (this.L == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "updatePublishStatus localNetworkInterceptPush");
        return;
    L10:
        if (this.M == false) goto L13;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "updatePublishStatus localAudioSquealInterceptPush");
        return;
    L13:
        MusicPanel r6 = null;
        if (KtvSettingHelper.q().f() == false) goto L24;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4 = this.i;
        if (r4 == null) goto L18;
        KtvRoomLyricsStateMachineConfig.d r5 = r4.getCurState();
    L20:
        if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L24;
        if (r22 == true) goto L24;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "updatePublishStatus isNeedPush " + r22 + " but in Paused");
        return;
    L18:
        r5 = null;
    L24:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusBusinessWidget", "updatePublishStatus " + r22 + ' ' + r24);
        if (r22 == false) goto L50;
        ValueAnimator r7 = this.P;
        if (r7 != null) goto L29;
    L31:
        ValueAnimator r8 = this.Q;
        if (r8 != null) goto L34;
    L38:
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = Z0();
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, Lq()});
        this.P = r10;
        if (r10 == null) goto L41;
        r10.setDuration((long) (((nf1) KtvSettingHelper.c0.getValue()).a() * 1000));
    L41:
        ValueAnimator r11 = this.P;
        if (r11 == null) goto L44;
        r11.addUpdateListener(com.bytedance.android.livesdk.ktvimpl.realtimechorus.s.a);
    L44:
        ValueAnimator r12 = this.P;
        if (r12 == null) goto L47;
        r12.addListener(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.t(this, r9, r23));
    L47:
        ValueAnimator r2 = this.P;
        if (r2 == null) goto L51;
        r2.start();
    L51:
        KtvModeOrderedSongDataContext r3 = Kq();
        if (r3 == null) goto L56;
        List<MusicPanel> r13 = r3.m200getKtvSingSongList();
        if (r13 == null) goto L56;
        r6 = (MusicPanel) KtvUtilsKt.K(r13, 0);
    L56:
        xe2.b r14 = xe2.b.b;
        RealTimeChorusViewModel r15 = this.e;
        if (r15 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L59:
        int r16 = r15.getCurrentUserChorusRole();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r24, "source");
        JSONObject r17 = new JSONObject();
        Object r18 = BDLocationException.ERROR_TIMEOUT;
        if (r6 == null) goto L64;
        KtvMusic r19 = r6.a;
        if (r19 == null) goto L64;
        Object r20 = Long.valueOf(r19.getMId());
    L65:
        r17.put("music_id", r20);
        String r21 = "";
        if (r6 == null) goto L71;
        KtvMusic r110 = r6.a;
        if (r110 == null) goto L71;
        String r111 = r110.getMTitle();
        if (r111 == null) goto L71;
    L72:
        r17.put("music_name", r111);
        r17.put("need_push_rtc", String.valueOf(r22));
        r17.put("cur_chorus_role", String.valueOf(r16));
        r17.put("source", r24);
        xe2.b.s(LinkMonitorData.UpdateRtcStreamPushStatus, r17);
        int r25 = xe2.g.a;
        RealTimeChorusViewModel r26 = this.e;
        if (r26 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L75:
        int r27 = r26.getCurrentUserChorusRole();
        Intrinsics.checkNotNullParameter(r24, "source");
        JSONObject r28 = new JSONObject();
        if (r6 == null) goto L80;
        KtvMusic r29 = r6.a;
        if (r29 == null) goto L80;
        r18 = Long.valueOf(r29.getMId());
    L80:
        r28.put("music_id", r18);
        if (r6 == null) goto L88;
        KtvMusic r30 = r6.a;
        if (r30 == null) goto L88;
        String r31 = r30.getMTitle();
        if (r31 == null) goto L88;
        r21 = r31;
    L88:
        r28.put("music_name", r21);
        r28.put("need_push_rtc", String.valueOf(r22));
        r28.put("cur_chorus_role", String.valueOf(r27));
        r28.put("source", r24);
        xe2.g.f(r28);
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusFlow, "RtcPushUpdate", 0, null, r28, 88);
        return;
    L71:
        r111 = "";
    L64:
        r20 = BDLocationException.ERROR_TIMEOUT;
        goto L65
    L34:
        if (r8.isRunning() != true) goto L38;
        ValueAnimator r32 = this.Q;
        if (r32 == null) goto L38;
        r32.cancel();
        goto L38
    L29:
        if (r7.isRunning() != true) goto L31;
    L50:
        Gq(r23);
        goto L51
    }

    public final void km(double r10, int r12, Function1<? super Boolean, Unit> r13) {
        RealTimeChorusViewModel r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        RealTimeChorusViewModel.leaveRealTimeChorus$default(r0, r10, r12, 0, r13, 4, null);
    }
}
