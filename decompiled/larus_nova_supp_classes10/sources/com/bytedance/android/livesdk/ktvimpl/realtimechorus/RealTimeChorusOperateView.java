package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.RealTimeChorusAnchorWidget;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00012B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\b¢\u0006\u0004\b0\u00101J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010*\u001a\u0004\u0018\u00010\u00048B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusOperateView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "getCurPlayingMusicPanel", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/l1;", "infoProvider", "", "setSingInfoProvider", "", "getJoinBtnStatus", "Lxe2/c;", "b", "Lxe2/c;", "getJoinChorusMonitor", "()Lxe2/c;", "joinChorusMonitor", "Lnd2/d;", "c", "Lnd2/d;", "getKtvMusicDownloadOptWrapper", "()Lnd2/d;", "ktvMusicDownloadOptWrapper", "", "value", "d", "Z", "isJoiningChorus", "()Z", "setJoiningChorus", "(Z)V", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealtimeChorusProgressImageView;", "k", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealtimeChorusProgressImageView;", "getChorusContainer", "()Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealtimeChorusProgressImageView;", "setChorusContainer", "(Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealtimeChorusProgressImageView;)V", "chorusContainer", "o", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/l1;", "getSingInfoProvider", "()Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/l1;", "singInfoProvider", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusOperateView extends ConstraintLayout {
    public static final /* synthetic */ int r = 0;
    public final CompositeDisposable a;
    public xe2.c b;
    public nd2.d c;
    public boolean d;
    public TextView e;
    public ConstraintLayout f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public ImageView j;
    public RealtimeChorusProgressImageView k;
    public FrameLayout l;
    public int m;
    public WeakReference<l1> n;
    public l1 o;
    public final List<MusicPanel> p;
    public final RealTimeChorusOperateView$musicDownloadCallback$1 q;

    public static final class a {
    }

    static {
    }

    public RealTimeChorusOperateView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RealTimeChorusOperateView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final MusicPanel getCurPlayingMusicPanel() {
        KtvModeOrderedSongDataContext r0 = KtvModeOrderedSongDataContext.Companion.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvPublicFirstOrderedSong();
    }

    private final xe2.c getJoinChorusMonitor() {
        if (this.b != null) goto L14;
        fd2.s r0 = RealTimeChorusBusinessContext.Companion.c();
        xe2.c r1 = null;
        if (r0 == null) goto L7;
        xe2.c r2 = r0.Qe();
    L9:
        if ((r2 instanceof xe2.c) == false) goto L12;
        r1 = r2;
    L12:
        this.b = r1;
        goto L14
    L7:
        r2 = null;
    L14:
        return this.b;
    }

    private final nd2.d getKtvMusicDownloadOptWrapper() {
        if (this.c != null) goto L14;
        fd2.s r0 = RealTimeChorusBusinessContext.Companion.c();
        nd2.d r1 = null;
        if (r0 == null) goto L7;
        nd2.d r2 = r0.oj();
    L9:
        if ((r2 instanceof nd2.d) == false) goto L12;
        r1 = r2;
    L12:
        this.c = r1;
        goto L14
    L7:
        r2 = null;
    L14:
        return this.c;
    }

    public final void Z5() {
        int r0 = this.m;
        if (r0 != 1) goto L5;
    L8:
        RealtimeChorusProgressImageView r1 = this.k;
        if (r1 == null) goto L17;
        l1 r2 = getSingInfoProvider();
        if (r2 == null) goto L13;
        py.k r3 = r2.dp();
    L14:
        r1.a(r3);
        return;
    L13:
        r3 = null;
        goto L14
    L17:
        return;
    L5:
        if (r0 == 2) goto L8;
        if (r0 == 3) goto L8;
    }

    public final void b6() {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        Boolean r2 = null;
        if ((r0 instanceof RealTimeChorusAnchorWidget) == true) goto L5;
        r0 = null;
    L5:
        RealTimeChorusAnchorWidget r1 = (RealTimeChorusAnchorWidget) r0;
        if (r1 == null) goto L9;
        r2 = r1.t0();
    L9:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L13;
        ImageView r3 = this.j;
        if (r3 == null) goto L17;
        r3.setImageResource(2131252731);
        return;
    L17:
        return;
    L13:
        ImageView r4 = this.j;
        if (r4 == null) goto L19;
        r4.setImageResource(2131252732);
        return;
    }

    private final l1 getSingInfoProvider() {
        if (KtvSettingHelper.r().booleanValue() == false) goto L9;
        WeakReference<l1> r0 = this.n;
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0.get();
    L9:
        return this.o;
    }

    public final RealtimeChorusProgressImageView getChorusContainer() {
        return this.k;
    }

    public final int getJoinBtnStatus() {
        return this.m;
    }

    public static final /* synthetic */ MusicPanel R5(RealTimeChorusOperateView r0) {
        return r0.getCurPlayingMusicPanel();
    }

    public static final /* synthetic */ xe2.c S5(RealTimeChorusOperateView r0) {
        return r0.getJoinChorusMonitor();
    }

    public static final void T5(RealTimeChorusOperateView r12) {
        r12.getClass();
        if (KtvSettingHelper.v().getEnableOptimize() == false) goto L5;
        r12.setJoiningChorus(false);
    L5:
        xe2.h.k("exit");
        RealTimeChorusBusinessContext.a r0 = RealTimeChorusBusinessContext.Companion;
        l1 r1 = r12.getSingInfoProvider();
        if (r1 == null) goto L8;
        double r2 = r1.Uc();
    L9:
        r0.l(r2, 1, RealTimeChorusOperateView$tryLeaveChorus$1.INSTANCE);
        MusicPanel r13 = r12.getCurPlayingMusicPanel();
        xe2.b.b.getClass();
        Long r3 = null;
        if (r13 == null) goto L17;
        JSONObject r4 = new JSONObject();
        r4.put("music_name", r13.a.getTitle());
        r4.put("music_id", r13.a.getMId());
        InteractiveSongUserInfo r5 = r13.f();
        if (r5 == null) goto L15;
        Long r6 = Long.valueOf(r5.getId());
    L16:
        r4.put("order_user_id", String.valueOf(r6));
        xe2.b.s(LinkMonitorData.LeaveChorusBtnClicked, r4);
        goto L17
    L15:
        r6 = null;
    L17:
        int r7 = xe2.g.a;
        if (r13 == null) goto L25;
        JSONObject r10 = new JSONObject();
        r10.put("music_name", r13.a.getTitle());
        r10.put("music_id", r13.a.getMId());
        InteractiveSongUserInfo r14 = r13.f();
        if (r14 == null) goto L23;
        r3 = Long.valueOf(r14.getId());
    L23:
        r10.put("order_user_id", String.valueOf(r3));
        xe2.g.f(r10);
        int r15 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.LeaveChorus, "LeaveChorusClick", 0, null, r10, 88);
        return;
    L25:
        return;
    L8:
        r2 = 0.0d;
        goto L9
    }

    public final void U5(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        if (((Boolean) KtvSettingHelper.m.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.m == 1) goto L8;
        return;
    L8:
        final RealtimeChorusProgressImageView r1 = this.k;
        if (r1 == null) goto L21;
        Intrinsics.checkNotNullParameter(r5, "url");
        HSImageView r2 = r1.e;
        if (r2 == null) goto L13;
        r2.setVisibility(0);
    L13:
        HSImageView r3 = r1.e;
        Function0<Unit> r4 = new RealtimeChorusProgressImageView$showAnimView$1(r1);
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r4, "onAnimationEnd");
        PipelineDraweeControllerBuilder r0 = Fresco.newDraweeControllerBuilder();
        if (r3 == null) goto L16;
        DraweeController r6 = r3.getController();
    L17:
        AbstractDraweeController r7 = r0.setOldController(r6).setUri(UriProtector.parse(r5)).setControllerListener(new g1(r4)).build();
        if (r3 == null) goto L22;
        r3.setController(r7);
        return;
    L22:
        return;
    L16:
        r6 = null;
        goto L17
    }

    public final void V5(String r14) {
        if (KtvSettingHelper.v().getEnableOptimize() == true) goto L5;
    L9:
        MusicPanel r0 = getCurPlayingMusicPanel();
        xe2.h.k("join");
        Long r2 = null;
        if (r0 == null) goto L38;
        xe2.c r3 = getJoinChorusMonitor();
        if (r3 == null) goto L20;
        r3.a();
        BehaviorSubject<Long> r4 = r3.a.get("start_time");
        if (r4 == null) goto L16;
        r4.onNext(Long.valueOf(System.currentTimeMillis()));
    L16:
        Disposable r5 = Observable.combineLatest(r3.a.values(), new xe2.d(r3)).subscribe(xe2.e.a, xe2.f.a);
        if (r5 == null) goto L20;
        RxUtilKt.c(r5, r3.b);
    L20:
        if (((Boolean) KtvSettingHelper.n.getValue()).booleanValue() == false) goto L35;
        Iterator r6 = ((ArrayList) this.p).iterator();
    L23:
        if (r6.hasNext() == false) goto L27;
        Object r7 = r6.next();
        if ((!((MusicPanel) r7).a.isSameKtvMusic(r0.a)) == false) goto L23;
    L29:
        if (((MusicPanel) r7) == null) goto L34;
        Iterator r1 = ((ArrayList) this.p).iterator();
    L32:
        if (r1.hasNext() == false) goto L34;
        MusicPanel r8 = (MusicPanel) r1.next();
        com.bytedance.android.live.ktv.common.music.download.m r9 = KtvMusicManager.a;
        KtvMusicManager.a(r8);
    L34:
        ((ArrayList) this.p).add(r0);
        goto L35
    L27:
        r7 = null;
    L35:
        nd2.d r10 = getKtvMusicDownloadOptWrapper();
        if (r10 == null) goto L39;
        nd2.d.a(r10, r0, this.q, ((Boolean) KtvSettingHelper.n.getValue()).booleanValue());
    L39:
        xe2.b.b.getClass();
        if (r0 == null) goto L47;
        JSONObject r11 = new JSONObject();
        r11.put("music_name", r0.a.getTitle());
        r11.put("music_id", r0.a.getMId());
        InteractiveSongUserInfo r12 = r0.f();
        if (r12 == null) goto L45;
        Long r13 = Long.valueOf(r12.getId());
    L46:
        r11.put("order_user_id", String.valueOf(r13));
        xe2.b.s(LinkMonitorData.JoinChorusBtnClicked, r11);
        goto L47
    L45:
        r13 = null;
    L47:
        int r15 = xe2.g.a;
        Intrinsics.checkNotNullParameter(r14, "source");
        if (r0 == null) goto L59;
        JSONObject r16 = new JSONObject();
        r16.put("music_name", r0.a.getTitle());
        r16.put("music_id", r0.a.getMId());
        InteractiveSongUserInfo r17 = r0.f();
        if (r17 == null) goto L53;
        r2 = Long.valueOf(r17.getId());
    L53:
        r16.put("order_user_id", String.valueOf(r2));
        r16.put("source", r14);
        r16.put("log_trace", Log.getStackTraceString(new Throwable()));
        int r18 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.JoinChorus, "JoinChorusClick", 0, null, r16, 88);
        return;
    L59:
        return;
    L38:
        setJoiningChorus(false);
        goto L39
    L5:
        if (this.d == false) goto L8;
        w.a("RealTimeChorusOperateView", "isJoiningChorus so return");
        return;
    L8:
        setJoiningChorus(true);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5(int r13) {
        if (KtvSettingHelper.v().getEnableOptimize() == false) goto L24;
        if (r13 != 4) goto L24;
        RealTimeChorusBusinessContext.a r0 = RealTimeChorusBusinessContext.Companion;
        boolean r4 = r0.j();
        if (r0.b() != 1) goto L8;
        boolean r5 = true;
    L9:
        fd2.s r1 = r0.c();
        if (r1 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r5 == true) goto L19;
        if (r4 == false) goto L20;
        if (r2 == true) goto L19;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == true) goto L24;
        w.a("RealTimeChorusOperateView", "updateChorusBtnStatus ;; music not ready ;; isViceSinger == " + r4 + " ;; isLeadSinger == " + r5 + " ;; isPlaying == " + r2);
        return;
    L19:
        r6 = true;
        goto L21
    L12:
        if (r1.isPlaying() != true) goto L14;
        r2 = true;
        goto L15
    L8:
        r5 = false;
    L24:
        int r3 = this.m;
        if (r3 != r13) goto L28;
        return;
    L28:
        if (r3 != 1) goto L30;
        if (r13 != 2) goto L30;
    L34:
        boolean r7 = true;
    L36:
        this.m = r13;
        if (getVisibility() != 0) goto L58;
        if (r7 == true) goto L58;
        if (r13 == 1) goto L43;
        if (r13 == 2) goto L43;
        if (r13 == 4) goto L43;
        if (r13 != 5) goto L58;
    L43:
        if (r13 == 1) goto L47;
        if (r13 == 2) goto L47;
        String r8 = "exit";
    L48:
        String r9 = BDLocationException.ERROR_TIMEOUT;
        if (r13 == 1) goto L53;
        if (r13 == 4) goto L53;
        Object r10 = BDLocationException.ERROR_TIMEOUT;
    L54:
        Intrinsics.checkNotNullParameter(r8, "buttonType");
        Intrinsics.checkNotNullParameter(r10, "isUsed");
        HashMap r11 = new HashMap();
        xe2.h.a(r11);
        xe2.h.c(r11);
        xe2.h.b(r11);
        r11.put("button_type", r8);
        r11.put("is_used", r10);
        if (xe2.h.h() == false) goto L57;
        r9 = "1";
    L57:
        r11.put("is_fixed_guest", r9);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chorus_join_icon_show", r11, new Object[]{IRoom.class, am2.x.class});
    L53:
        r10 = "1";
    L47:
        r8 = "join";
    L58:
        py.k r12 = null;
        if (r13 != 1) goto L61;
        RealtimeChorusProgressImageView r14 = this.k;
        if (r14 == null) goto L171;
        r14.setText(s1.B(2131921856));
    L171:
        RealtimeChorusProgressImageView r15 = this.k;
        if (r15 == null) goto L176;
        RoundCornerProgressBar r16 = r15.a;
        if (r16 == null) goto L176;
        r16.setProgress(0.0f);
    L176:
        RealtimeChorusProgressImageView r17 = this.k;
        if (r17 == null) goto L182;
        l1 r18 = getSingInfoProvider();
        if (r18 == null) goto L181;
        r12 = r18.dp();
    L181:
        r17.a(r12);
    L182:
        RealtimeChorusProgressImageView r19 = this.k;
        if (r19 == null) goto L185;
        r19.setAlpha(1.0f);
    L185:
        RealtimeChorusProgressImageView r110 = this.k;
        if (r110 == null) goto L188;
        r110.setClickable(true);
    L188:
        RealtimeChorusProgressImageView r111 = this.k;
        if (r111 == null) goto L204;
        r111.setTextColor(ColorProtector.parseColor("#2E2929"));
        return;
    L204:
        return;
    L61:
        if (r13 == 2) goto L140;
        if (r13 != 3) goto L64;
        RealtimeChorusProgressImageView r112 = this.k;
        if (r112 == null) goto L120;
        r112.setText(s1.B(2131921854));
    L120:
        RealtimeChorusProgressImageView r113 = this.k;
        if (r113 == null) goto L126;
        l1 r20 = getSingInfoProvider();
        if (r20 == null) goto L125;
        r12 = r20.dp();
    L125:
        r113.a(r12);
    L126:
        RealtimeChorusProgressImageView r114 = this.k;
        if (r114 == null) goto L129;
        r114.setAlpha(1.0f);
    L129:
        RealtimeChorusProgressImageView r115 = this.k;
        if (r115 == null) goto L132;
        r115.setClickable(true);
    L132:
        RealtimeChorusProgressImageView r116 = this.k;
        if (r116 == null) goto L135;
        r116.setTextColor(ColorProtector.parseColor("#2E2929"));
    L135:
        RealtimeChorusProgressImageView r117 = this.k;
        if (r117 == null) goto L198;
        HSImageView r118 = r117.e;
        if (r118 == null) goto L199;
        r118.setVisibility(8);
        return;
    L199:
        return;
    L198:
        return;
    L64:
        if (r13 == 4) goto L92;
        if (r13 != 5) goto L205;
        RealtimeChorusProgressImageView r119 = this.k;
        if (r119 == null) goto L70;
        r119.setText(s1.B(2131921857));
    L70:
        RealtimeChorusProgressImageView r120 = this.k;
        if (r120 == null) goto L75;
        RoundCornerProgressBar r121 = r120.a;
        if (r121 == null) goto L75;
        r121.setProgress(0.0f);
    L75:
        RealtimeChorusProgressImageView r122 = this.k;
        if (r122 == null) goto L78;
        int r21 = qy.a.a;
        r122.a(qy.a.a(com.bytedance.android.live.ktv.common.midi.i.b));
    L78:
        RealtimeChorusProgressImageView r123 = this.k;
        if (r123 == null) goto L81;
        r123.setAlpha(0.34f);
    L81:
        RealtimeChorusProgressImageView r124 = this.k;
        if (r124 == null) goto L84;
        r124.setClickable(false);
    L84:
        RealtimeChorusProgressImageView r125 = this.k;
        if (r125 == null) goto L87;
        r125.setTextColor(ColorProtector.parseColor("#FFFFFF"));
    L87:
        RealtimeChorusProgressImageView r126 = this.k;
        if (r126 == null) goto L192;
        HSImageView r127 = r126.e;
        if (r127 == null) goto L193;
        r127.setVisibility(8);
        return;
    L193:
        return;
    L192:
        return;
    L205:
        return;
    L92:
        RealtimeChorusProgressImageView r128 = this.k;
        if (r128 == null) goto L95;
        r128.setText(s1.B(2131921857));
    L95:
        RealtimeChorusProgressImageView r129 = this.k;
        if (r129 == null) goto L100;
        RoundCornerProgressBar r130 = r129.a;
        if (r130 == null) goto L100;
        r130.setProgress(0.0f);
    L100:
        RealtimeChorusProgressImageView r131 = this.k;
        if (r131 == null) goto L103;
        int r22 = qy.a.a;
        r131.a(qy.a.a(com.bytedance.android.live.ktv.common.midi.i.b));
    L103:
        RealtimeChorusProgressImageView r132 = this.k;
        if (r132 == null) goto L106;
        r132.setAlpha(1.0f);
    L106:
        RealtimeChorusProgressImageView r133 = this.k;
        if (r133 == null) goto L109;
        r133.setClickable(true);
    L109:
        RealtimeChorusProgressImageView r134 = this.k;
        if (r134 == null) goto L112;
        r134.setTextColor(ColorProtector.parseColor("#FFFFFF"));
    L112:
        RealtimeChorusProgressImageView r135 = this.k;
        if (r135 == null) goto L195;
        HSImageView r136 = r135.e;
        if (r136 == null) goto L196;
        r136.setVisibility(8);
        return;
    L196:
        return;
    L195:
        return;
    L140:
        RealtimeChorusProgressImageView r137 = this.k;
        if (r137 == null) goto L143;
        r137.setText(s1.B(2131921856));
    L143:
        RealtimeChorusProgressImageView r138 = this.k;
        if (r138 == null) goto L148;
        RoundCornerProgressBar r139 = r138.a;
        if (r139 == null) goto L148;
        r139.setProgress(0.0f);
    L148:
        RealtimeChorusProgressImageView r140 = this.k;
        if (r140 == null) goto L154;
        l1 r23 = getSingInfoProvider();
        if (r23 == null) goto L153;
        r12 = r23.dp();
    L153:
        r140.a(r12);
    L154:
        RealtimeChorusProgressImageView r141 = this.k;
        if (r141 == null) goto L157;
        r141.setAlpha(0.5f);
    L157:
        RealtimeChorusProgressImageView r142 = this.k;
        if (r142 == null) goto L160;
        r142.setClickable(false);
    L160:
        RealtimeChorusProgressImageView r143 = this.k;
        if (r143 == null) goto L163;
        r143.setTextColor(ColorProtector.parseColor("#2E2929"));
    L163:
        RealtimeChorusProgressImageView r144 = this.k;
        if (r144 == null) goto L201;
        HSImageView r145 = r144.e;
        if (r145 == null) goto L202;
        r145.setVisibility(8);
        return;
    L202:
        return;
    L201:
        return;
    L30:
        if (r3 != 2) goto L32;
        if (r13 == 1) goto L34;
    L32:
        if (r3 != 3) goto L35;
        if (r13 == 1) goto L34;
    L35:
        r7 = false;
        goto L36
    }

    public final void c6(int r7) {
        if (r7 <= 0) goto L26;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.i() == true) goto L26;
        TextView r2 = this.h;
        if (r2 == null) goto L9;
        r2.setVisibility(8);
    L9:
        TextView r0 = this.g;
        if (r0 == null) goto L12;
        r0.setVisibility(0);
    L12:
        TextView r1 = this.g;
        if (r1 != null) goto L15;
    L19:
        TextView r8 = this.e;
        if (r8 == null) goto L22;
        com.bytedance.android.live.core.utils.a1.o(r8, s1.f(7.0f));
    L22:
        TextView r9 = this.e;
        if (r9 == null) goto L50;
        com.bytedance.android.live.core.utils.a1.n(r9, s1.f(7.0f));
        return;
    L50:
        return;
    L15:
        if (r7 <= 99) goto L17;
        String r10 = "99+";
    L18:
        r1.setText(r10);
        goto L19
    L17:
        r10 = String.valueOf(r7);
    L26:
        if (KtvSettingHelper.C() == true) goto L28;
    L34:
        TextView r11 = this.h;
        if (r11 == null) goto L37;
        r11.setVisibility(8);
    L37:
        TextView r12 = this.g;
        if (r12 == null) goto L40;
        r12.setVisibility(8);
    L40:
        TextView r13 = this.g;
        if (r13 == null) goto L43;
        r13.setText("");
    L43:
        TextView r14 = this.e;
        if (r14 == null) goto L46;
        com.bytedance.android.live.core.utils.a1.o(r14, 0);
    L46:
        TextView r15 = this.e;
        if (r15 == null) goto L52;
        com.bytedance.android.live.core.utils.a1.n(r15, 0);
        return;
    L52:
        return;
    L28:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.X.getValue()).booleanValue() == true) goto L34;
        if ((((long) ((Number) KtvSettingHelper.p1.getValue()).intValue()) * 1000) <= System.currentTimeMillis()) goto L34;
        TextView r16 = this.h;
        if (r16 == null) goto L37;
        r16.setVisibility(0);
        goto L37
    }

    public final void i6(boolean r6) {
        if (KtvSettingHelper.v().getEnableOptimize() == false) goto L25;
        if (r6 == false) goto L25;
        RealTimeChorusBusinessContext.a r0 = RealTimeChorusBusinessContext.Companion;
        boolean r2 = r0.j();
        boolean r4 = true;
        if (r0.b() != 1) goto L8;
        boolean r3 = true;
    L9:
        fd2.s r1 = r0.c();
        if (r1 != null) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r3 == true) goto L21;
        if (r2 == false) goto L20;
        if (r5 == true) goto L21;
    L20:
        r4 = false;
    L21:
        if (r4 == true) goto L25;
        w.a("RealTimeChorusOperateView", "updateSingStatus ;; music not ready ;; isViceSinger == " + r2 + " ;; isLeadSinger == " + r3 + " ;; isPlaying == " + r5);
        return;
    L12:
        if (r1.isPlaying() != true) goto L14;
        r5 = true;
        goto L15
    L8:
        r3 = false;
    L25:
        if (r6 == false) goto L37;
        ImageView r7 = this.i;
        if (r7 == null) goto L30;
        r7.setVisibility(0);
    L30:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L34;
        FrameLayout r8 = this.l;
        if (r8 == null) goto L49;
        r8.setVisibility(0);
        return;
    L49:
        return;
    L34:
        FrameLayout r9 = this.l;
        if (r9 == null) goto L51;
        r9.setVisibility(8);
        return;
    L51:
        return;
    L37:
        ImageView r10 = this.i;
        if (r10 == null) goto L41;
        r10.setVisibility(8);
    L41:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L45;
        FrameLayout r11 = this.l;
        if (r11 == null) goto L53;
        r11.setVisibility(0);
        return;
    L53:
        return;
    L45:
        FrameLayout r12 = this.l;
        if (r12 == null) goto L55;
        r12.setVisibility(8);
        return;
    }

    public final void setChorusContainer(RealtimeChorusProgressImageView r1) {
        this.k = r1;
    }

    public final void setJoiningChorus(boolean r3) {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L8;
        if (this.d == r3) goto L8;
        ALogger.i("RealTimeChorusOperateView", "isJoiningChorus " + this.d + " to " + r3 + " ;; " + Log.getStackTraceString(new Throwable()));
    L8:
        if (this.d == r3) goto L11;
        this.d = r3;
        return;
    }

    public final void setSingInfoProvider(l1 r2) {
        Intrinsics.checkNotNullParameter(r2, "infoProvider");
        if (KtvSettingHelper.r().booleanValue() == false) goto L5;
        this.n = new WeakReference(r2);
        return;
    L5:
        this.o = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusOperateView$musicDownloadCallback$1] */
    public RealTimeChorusOperateView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.a = new CompositeDisposable();
        new Pair(null, Boolean.TRUE);
        this.p = new ArrayList();
        this.q = new RealTimeChorusOperateView$musicDownloadCallback$1(this);
        LayoutInflater.from(r6).inflate(2131567252, this);
        this.f = findViewById(2131365700);
        this.e = (TextView) findViewById(2131365699);
        this.g = (TextView) findViewById(2131365701);
        this.h = (TextView) findViewById(2131365702);
        this.i = (ImageView) findViewById(2131365681);
        this.j = (ImageView) findViewById(2131365691);
        this.l = (FrameLayout) findViewById(2131365692);
        RealtimeChorusProgressImageView r9 = (RealtimeChorusProgressImageView) findViewById(2131365683);
        this.k = r9;
        if (r9 == null) goto L8;
        View r10 = new HSImageView(r9.getContext());
        r9.c = r10;
        r9.addView(r10, new FrameLayout.LayoutParams(-1, -1, 17));
        RoundCornerProgressBar r11 = new RoundCornerProgressBar(r9.getContext(), null);
        r9.a = r11;
        r9.addView(r11, new FrameLayout.LayoutParams(-1, -1, 17));
        HSImageView r12 = new HSImageView(r9.getContext());
        r12.setScaleType(ImageView.ScaleType.FIT_XY);
        Unit r0 = Unit.INSTANCE;
        r9.e = r12;
        r9.addView(r12, new FrameLayout.LayoutParams(s1.f(165.0f), s1.f(68.0f), 17));
        HSImageView r13 = r9.e;
        if (r13 == null) goto L7;
        r13.setVisibility(8);
    L7:
        TextView r14 = new TextView(r9.getContext());
        r14.setTextColor(ColorProtector.parseColor("#2E2929"));
        r14.setTextSize(12.0f);
        r14.setGravity(17);
        r14.setText(2131921856);
        r9.b = r14;
        r9.addView(r14, new FrameLayout.LayoutParams(-1, -1, 17));
    L8:
        ImageView r15 = this.i;
        if (r15 == null) goto L12;
        r15.setVisibility(8);
    L12:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L16;
        FrameLayout r16 = this.l;
        if (r16 == null) goto L19;
        r16.setVisibility(8);
    L19:
        RealtimeChorusProgressImageView r17 = this.k;
        if (r17 == null) goto L22;
        r17.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new RealTimeChorusOperateView$initView$1(this)));
    L22:
        ImageView r18 = this.i;
        if (r18 == null) goto L25;
        r18.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new RealTimeChorusOperateView$initView$2(this)));
    L25:
        ConstraintLayout r19 = this.f;
        if (r19 == null) goto L28;
        r19.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new RealTimeChorusOperateView$initView$3(this)));
    L28:
        FrameLayout r20 = this.l;
        if (r20 == null) goto L32;
        r20.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new RealTimeChorusOperateView$initView$4(this)));
        return;
    L32:
        return;
    L16:
        FrameLayout r21 = this.l;
        if (r21 == null) goto L19;
        r21.setVisibility(0);
        goto L19
    }

    public /* synthetic */ RealTimeChorusOperateView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
