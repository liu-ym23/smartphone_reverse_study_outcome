package com.larus.voicecall.impl.component.net;

import android.content.Context;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.service.audio.y0;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.network.NetworkQualityType;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.voicecall.impl.RealtimeCallService;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002*\u00019\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010'\u001a\u00020!H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u001a\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001d2\b\b\u0002\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020)H\u0002J\u0018\u0010/\u001a\u00020!2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002J\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u001dH\u0002J\u0010\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u001bH\u0002J\u001a\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020\u001f2\b\b\u0002\u0010-\u001a\u00020!H\u0002J\f\u0010=\u001a\u00020\u001b*\u00020\u001fH\u0002J\f\u0010>\u001a\u00020\u001d*\u00020\u001fH\u0002J\u0012\u0010?\u001a\u00020)2\b\b\u0002\u0010-\u001a\u00020!H\u0002J\u0018\u0010@\u001a\u00020)2\u0006\u00106\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001bH\u0002J\u0010\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GH\u0002J\u001a\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020G2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b$\u0010%R\u000e\u00107\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006N"}, d2 = {"Lcom/larus/voicecall/impl/component/net/RealtimeNetNoticeComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/net/IRealtimeNetNoticeAbility;", "<init>", "()V", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "currentState", "Lcom/larus/voicecall/impl/component/net/INetworkViewState;", "lastQuality", "", "lastTtnetQuality", "Lcom/larus/network/NetworkQualityType;", "hasMultiPathToastToday", "", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "needShowBadNetNotice", "onAttach", "", LiveCommonConstants.REASON_ON_DEDTROY, "onNetworkQualityChange", GearStrategyConsts.EV_QUALITY, "force", "onMultiPathWork", "isSameDay", "lastShowTime", "", "currentTime", "initQualityState", "initQuality", "transitionTo", "newState", "lastPoorToastTime", "ttnetNetworkQualityChangeListener", "com/larus/voicecall/impl/component/net/RealtimeNetNoticeComponent$ttnetNetworkQualityChangeListener$1", "Lcom/larus/voicecall/impl/component/net/RealtimeNetNoticeComponent$ttnetNetworkQualityChangeListener$1;", "onTtnetNetworkQualityChange", "type", "toNetworkViewState", "toNetInfoQuality", "syncTtnetNetworkQuality", "enterNewState", "oldState", "onConnectionStateChanged", "state", "Lcom/larus/im/internal/audio/context/SessionState;", "mobNoticeShow", "noticeContent", "", "noticeType", "otherEvent", "event", "content", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeNetNoticeComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.net.b {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f377543y = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f377544n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f377545o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f377546p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f377547q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.larus.voicecall.impl.component.net.a f377548r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f377549s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public NetworkQualityType f377550t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f377551u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f377552v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f377553w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f377554x;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f377555a = null;

        static {
            int[] r100 = new int[NetworkQualityType.values().length];
            r100[NetworkQualityType.NO_NET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[NetworkQualityType.WEAK_NETWORK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[NetworkQualityType.NORMAL_NETWORK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f377555a = r100;
        }
    }

    public static final class c implements com.larus.network.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealtimeNetNoticeComponent f377556a;

        public c(RealtimeNetNoticeComponent r100) {
            this.f377556a = r100;
        }

        @Override // com.larus.network.k
        public final void a(final NetworkQualityType r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            RealtimeNetNoticeComponent r101 = this.f377556a;
            int r102 = RealtimeNetNoticeComponent.f377543y;
            if (y0.b(((e3a.b) r101.f377546p.getValue()).f484264e) == true) goto L5;
            return;
        L5:
            final RealtimeNetNoticeComponent r103 = this.f377556a;
            t0.e(new o(r103, r100));
        }
    }

    static {
    }

    @Override // com.larus.voicecall.impl.component.net.b
    public final boolean fo() {
        return this.f377548r instanceof p;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        if (y0.b(((e3a.b) this.f377546p.getValue()).f484264e) == false) goto L6;
        NetConnectionTypeProvider.NetworkStatus r100 = NetConnectionTypeProvider.f360084a;
        c r101 = this.f377554x;
        NetConnectionTypeProvider.f360087d.remove(r101);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.net.b.class);
        if (y0.b(((e3a.b) this.f377546p.getValue()).f484264e) == false) goto L9;
        NetConnectionTypeProvider.NetworkStatus r100 = NetConnectionTypeProvider.f360084a;
        c r101 = this.f377554x;
        if (r101 == null) goto L7;
        NetConnectionTypeProvider.f360087d.addIfAbsent(r101);
    L7:
        z3(false);
        return;
    }

    public RealtimeNetNoticeComponent() {
        this.f377544n = LazyKt.lazy(new g(this));
        this.f377545o = LazyKt.lazy(new h(this));
        this.f377546p = LazyKt.lazy(new i(this));
        this.f377547q = LazyKt.lazy(new j(this));
        this.f377548r = new e();
        this.f377549s = -1;
        this.f377552v = LazyKt.lazy(new k(this));
        t0.a(new l(this));
        this.f377554x = new c(this);
    }

    public final void B3(com.larus.voicecall.impl.component.net.a r100) {
        FLogger.f375446a.i("RealtimeNetNoticeComponent", "transitionTo newState=" + r100.getLogTag() + ' ');
        if (Intrinsics.areEqual(this.f377548r, r100) == true) goto L29;
        com.larus.voicecall.impl.component.net.a r101 = this.f377548r;
        this.f377548r = r100;
        boolean r102 = false;
        if ((r100 instanceof e) == false) goto L17;
        if ((SystemClock.elapsedRealtime() - this.f377553w) > 3000) goto L12;
        if ((r101 instanceof f) == false) goto L12;
        s.f544207a.a();
    L12:
        if ((r101 instanceof p) == false) goto L30;
        com.larus.voicecall.impl.component.bottom.b r103 = (com.larus.voicecall.impl.component.bottom.b) this.f377544n.getValue();
        if (r103 == null) goto L31;
        r103.ci(false);
        return;
    L31:
        return;
    L30:
        return;
    L17:
        if ((r100 instanceof f) == false) goto L24;
        Lazy r104 = d.f377557a;
        if ((SystemClock.elapsedRealtime() - ((Keva) r104.getValue()).getLong("LAST_POOR_NET_STATE_TOAST_SHOW_TIME", 0)) <= 900000) goto L21;
        r102 = true;
    L21:
        if (r102 == false) goto L33;
        String r105 = Y2(R.string.larus_audio_network_errToast_bad);
        m3(r105, "toast");
        s r106 = s.f544207a;
        Context r107 = getContext();
        r106.getClass();
        s.u(r107, r105, 3000);
        ((Keva) r104.getValue()).storeLong("LAST_POOR_NET_STATE_TOAST_SHOW_TIME", SystemClock.elapsedRealtime());
        this.f377553w = SystemClock.elapsedRealtime();
        return;
    L33:
        return;
    L24:
        if ((r100 instanceof p) == false) goto L35;
        m3(getContext().getString(R.string.larus_audio_network_errToast_veryBad), "text");
        com.larus.voicecall.impl.component.bottom.b r108 = (com.larus.voicecall.impl.component.bottom.b) this.f377544n.getValue();
        if (r108 == null) goto L36;
        r108.ci(true);
        return;
    L36:
        return;
    L35:
        return;
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void I6(jd9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        h3(0);
        if ((r100 instanceof jd9.c.a) == false) goto L10;
        z3(true);
        if (z2.f365865a.updateNetInfoAndSubtitleStatusEnabled() == true) goto L7;
        return;
    L7:
        if (this.f377549s == (-1)) goto L12;
        ((RealtimeCallService) this.f377552v.getValue()).p().L(this.f377549s);
        return;
    L12:
        return;
    }

    public final void h3(int r100) {
        if (r100 >= 4) goto L5;
        com.larus.voicecall.impl.component.net.a r101 = new e();
    L10:
        B3(r101);
        return;
    L5:
        if (r100 != 4) goto L7;
        r101 = new f();
        goto L10
    L7:
        if (r100 <= 4) goto L9;
        r101 = new p();
        goto L10
    L9:
        r101 = new e();
        goto L10
    }

    public final void z3(boolean r100) {
        if (y0.b(((e3a.b) this.f377546p.getValue()).f484264e) == true) goto L5;
        return;
    L5:
        NetworkQualityType r101 = NetConnectionTypeProvider.a(NetConnectionTypeProvider.f360084a);
        FLogger.f375446a.i("RealtimeNetNoticeComponent", "syncTtnetNetworkQuality quality=" + r101);
        p3(r101, r100);
    }

    public final void m3(String r100, String r101) {
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        JSONObject r103 = new JSONObject();
        r103.put("scene", NotificationCompat.CATEGORY_CALL);
        r103.put("call_id", ((e3a.b) this.f377546p.getValue()).a().f288745e);
        com.larus.voicecall.impl.component.scene.a r104 = (com.larus.voicecall.impl.component.scene.a) this.f377547q.getValue();
        if (r104 == null) goto L11;
        LiveData<com.larus.voicecall.impl.scene.m> r105 = r104.getCurrentScene();
        if (r105 == null) goto L11;
        com.larus.voicecall.impl.scene.m r106 = r105.getValue();
        if (r106 == null) goto L11;
        SceneModel r107 = r106.f378735a;
        if (r107 == null) goto L11;
        String r108 = r107.getKey();
    L12:
        r103.put("call_scene", r108);
        r103.put("bot_id", ((e3a.a) this.f377545o.getValue()).f484235d);
        r103.put("prompt_content", r100);
        r103.put("prompt_type", r101);
        Unit r109 = Unit.INSTANCE;
        r102.reportEvent("call_scene_network_quality_prompt_show", r103);
        return;
    L11:
        r108 = null;
        goto L12
    }

    public final void p3(NetworkQualityType r100, boolean r101) {
        if (r101 == false) goto L4;
    L6:
        int[] r102 = b.f377555a;
        int r103 = r102[r100.ordinal()];
        if (r103 == 1) goto L14;
        if (r103 == 2) goto L13;
        if (r103 != 3) goto L12;
        int r104 = 2;
    L15:
        int r105 = r102[r100.ordinal()];
        if (r105 == 1) goto L23;
        if (r105 == 2) goto L22;
        if (r105 != 3) goto L21;
        com.larus.voicecall.impl.component.net.a r106 = new e();
    L24:
        B3(r106);
        FLogger.f375446a.i("RealtimeNetNoticeComponent", "onTtnetNetworkQualityChange type=" + r100 + " quality=" + r104 + " lastType=" + this.f377550t + " currentState=" + this.f377548r.getLogTag());
        if (z2.f365865a.updateNetInfoAndSubtitleStatusEnabled() == false) goto L27;
        ((RealtimeCallService) this.f377552v.getValue()).p().L(r104);
    L27:
        this.f377550t = r100;
        this.f377549s = r104;
        return;
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        r106 = new f();
        goto L24
    L23:
        r106 = new p();
        goto L24
    L12:
        throw new NoWhenBranchMatchedException();
    L13:
        r104 = 4;
        goto L15
    L14:
        r104 = 6;
        goto L15
    L4:
        if (r100 != this.f377550t) goto L6;
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void z2(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Intrinsics.areEqual(r100, "OTHER_EVENT_RTC_NETWORK_QUALITY_CHANGE") == false) goto L17;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        if ((r101 instanceof String) == false) goto L7;
        String r103 = (String) r101;     // Catch: Throwable -> L10
    L8:
        JSONObject r104 = new JSONObject(r103);     // Catch: Throwable -> L10
        final int r105 = Math.min(JSONObjectProtectorUtils.getInt(r104, "upQuality"), JSONObjectProtectorUtils.getInt(r104, "downQuality"));     // Catch: Throwable -> L10
        t0.e(new m(this, r105));     // Catch: Throwable -> L10
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L24;
        FLogger.f375446a.i("RealtimeNetNoticeComponent", "otherEvent error.err=" + r107 + " event=" + r100 + " content=" + r101 + ' ');
        return;
    L24:
        return;
    L7:
        r103 = null;
    L10:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L17:
        if (Intrinsics.areEqual(r100, "OTHER_EVENT_RTC_MULTIPATH_WORK") == false) goto L23;
        t0.e(new n(this));
        return;
    }
}
