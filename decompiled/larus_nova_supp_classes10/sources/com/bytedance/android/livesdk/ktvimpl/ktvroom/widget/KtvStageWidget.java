package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvRoomViewModelFactory;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidget;
import com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget;
import com.bytedance.android.livesdk.ktvimpl.base.frame.RecycleWidgetHelper;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvMvLyricPresenter;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget.MvLyricWidget;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvRoomChallengeViewWrapper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvMvMidiMicLabelAnim;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.stage.KtvMicHighScoreLabelAnim;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.ktvimpl.mv.KtvMvViewModel;
import com.bytedance.android.livesdk.ktvimpl.mv.KtvMvWidget;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.qd;
import com.bytedance.android.livesdkapi.depend.message.KtvDressSyncData;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvStageWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;", "Lfd2/k;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "Ltb0/a;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class KtvStageWidget extends AbsKWidget<KtvRoomViewModel> implements fd2.k, com.bytedance.android.livesdk.ktvimpl.base.sei.c, tb0.a {
    public static final /* synthetic */ int A = 0;
    public boolean f;
    public KtvMvControlAreaWidget g;
    public KtvMvMidiWidget h;
    public MvLyricWidget i;
    public com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a j;
    public KtvMvMidiMicLabelAnim k;
    public View l;
    public final CompositeDisposable m;
    public boolean n;
    public Boolean o;
    public final BaseCoreViewModel p;
    public Integer q;
    public KtvDressSyncData r;
    public final com.bytedance.android.live.ktv.common.util.e s;
    public final b t;
    public final boolean u;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b v;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b w;
    public final j x;
    public final KtvContext y;
    public final sb0.b z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ KtvStageWidget a;

        public b(KtvStageWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L6;
            ALogger.i("ttlive_ktv", "KtvMvStageWidget, challenge is open");
            KtvStageWidget r4 = this.a;
            int r0 = KtvStageWidget.A;
            r4.Cq(false, true);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ KtvStageWidget a;

        public c(KtvStageWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            qd r5 = (qd) r4;
            String r0 = null;
            if (r5 == null) goto L5;
            Boolean r6 = r5.f;
        L7:
            if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L39;
            KtvStageWidget r7 = this.a;
            int r1 = KtvStageWidget.A;
            KtvRoomViewModel r8 = (KtvRoomViewModel) r7.d;
            if (r8 == null) goto L13;
            MutableLiveData<qd> r9 = r8.getKtvMicLabelEvent();
            if (r9 == null) goto L13;
            com.bytedance.android.livesdk.ktvapi.util.d.b(r9, KtvStageWidget$initView$10$1.INSTANCE);
        L13:
            KtvStageWidget r10 = this.a;
            KtvRoomViewModel r2 = (KtvRoomViewModel) r10.d;
            if (r2 != null) goto L17;
            return;
        L17:
            if (r10.u == false) goto L40;
            qd r3 = (qd) r2.getKtvMicLabelEvent().getValue();
            if (r3 == null) goto L21;
            String r11 = r3.b;
        L23:
            if (TextUtils.isEmpty(r11) == true) goto L41;
            qd r12 = (qd) r2.getKtvMicLabelEvent().getValue();
            if (r12 == null) goto L28;
            r0 = r12.h;
        L28:
            if (TextUtils.isEmpty(r0) == true) goto L45;
            KtvMvMidiMicLabelAnim r13 = r10.k;
            if (r13 == null) goto L33;
            r13.setOnClickListener(new z1(r13, r10, r2));
            r13.setOnLabelAnimStatusChange(new a2(r10));
        L33:
            qd r14 = (qd) r2.getKtvMicLabelEvent().getValue();
            if (r14 == null) goto L42;
            KtvMvMidiMicLabelAnim r15 = r10.k;
            if (r15 == null) goto L43;
            String r16 = r14.d;
            String r17 = r14.b;
            Intrinsics.checkNotNull(r17);
            int r18 = KtvMicHighScoreLabelAnim.h;
            r15.a(r16, r17, com.bytedance.android.live.core.utils.s1.f(130.0f));
            return;
        L43:
            return;
        L42:
            return;
        L45:
            return;
        L41:
            return;
        L21:
            r11 = null;
            goto L23
        L40:
            return;
        L39:
            return;
        L5:
            r6 = null;
            goto L7
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ KtvStageWidget a;

        public d(KtvStageWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            final StateMachine.c.b r5 = (StateMachine.c.b) r4;
            if ((((KtvRoomLyricsStateMachineConfig.d) r5.c) instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L5;
        L7:
            Lazy r0 = KtvCommonSettingHelper.a;
            Intrinsics.checkNotNullParameter(new KtvStageWidget$initView$12$1(this, r5), "cb");
            return;
        L5:
            if (this.a.y.isCurrentUserIsSinger() == true) goto L7;
            this.a.Cq(false, true);
            goto L7
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ KtvStageWidget a;

        public e(KtvStageWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L6;
            this.a.Bq("onValueChanged");
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ KtvStageWidget a;

        public f(KtvStageWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            sh6.b r7 = (sh6.b) r6;
            KtvStageWidget r0 = this.a;
            Object r1 = null;
            if (r7 == null) goto L5;
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r8 = (com.bytedance.android.livesdk.ktvimpl.base.sei.a) sh6.c.b(r7);
        L7:
            if (r0.n == true) goto L30;
            pd2.d.n.getClass();
            pd2.d.w(LinkMonitorData.BusinessShowContribute, new JSONObject());
            if ((r8 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.n) == false) goto L31;
            ALogger.i("onSongFeedbackShow", "onSongFeedbackShow1");
            com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r3 = r0.j;
            if ((r3 instanceof View) == false) goto L16;
            r1 = r3;
        L16:
            View r2 = (View) r1;
            if (r2 == null) goto L19;
            r2.setVisibility(0);
        L19:
            com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r4 = r0.j;
            if (r4 == null) goto L22;
            r4.F5((com.bytedance.android.livesdk.ktvimpl.base.sei.n) r8);
        L22:
            View r9 = r0.l;
            if (r9 == null) goto L25;
            r9.setBackgroundColor(ColorProtector.parseColor("#81000000"));
        L25:
            View r10 = r0.l;
            if (r10 == null) goto L28;
            r10.setVisibility(0);
        L28:
            ALogger.i("onSongFeedbackShow", "onSongFeedbackShow2:3000");
            com.bytedance.android.live.core.utils.i0.c().postDelayed(new c2(r0), KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION);
            return;
        L31:
            return;
        L30:
            return;
        L5:
            r8 = null;
            goto L7
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ KtvStageWidget a;

        public g(KtvStageWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if ((!Intrinsics.areEqual((Boolean) r3, Boolean.TRUE)) == false) goto L17;
            Object r4 = this.a.j;
            if ((r4 instanceof View) == true) goto L7;
            r4 = null;
        L7:
            View r5 = (View) r4;
            if (r5 == null) goto L10;
            r5.setVisibility(8);
        L10:
            View r6 = this.a.l;
            if (r6 == null) goto L13;
            r6.setBackgroundColor(0);
        L13:
            View r7 = this.a.l;
            if (r7 == null) goto L18;
            r7.setVisibility(8);
            return;
        L18:
            return;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ KtvStageWidget a;

        public h(KtvStageWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            py.k r3 = (py.k) r2;
            if (r3 == null) goto L8;
            KtvMvMidiMicLabelAnim r0 = this.a.k;
            if (r0 == null) goto L9;
            r0.setUserAvatar(r3);
            return;
        L9:
            return;
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ KtvStageWidget a;

        public i(KtvStageWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.p0(Intrinsics.areEqual(r4, Boolean.TRUE));
            return;
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ KtvStageWidget a;

        public j(KtvStageWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3 = (StateMachine.c.b) r2;
            this.a.Aq(r3);
            KtvStageWidget.zq(this.a, r3);
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566514;
    }

    public final Widget getWidget() {
        return this;
    }

    public final void onBizDestory() {
    }

    public void onBizEnterRoom() {
    }

    public final void onBizHide() {
    }

    public void onBizLeaveRoom() {
    }

    public final void onBizShow() {
    }

    public final void Eq() {
        KtvRoomViewModel r0 = (KtvRoomViewModel) this.d;
        if (r0 == null) goto L5;
        r0.init(this);
    L5:
        com.bytedance.live.datacontext.n<Integer> r1 = this.y.getKtvCardViewSizeChanged();
        if (r1 == null) goto L8;
        r1.setValue(Integer.valueOf(com.bytedance.android.live.core.utils.s1.j(2131168834)));
    L8:
        View r2 = ((Widget) this).contentView;
        com.bytedance.android.live.ktv.common.util.c r3 = null;
        if (r2 == null) goto L13;
        ViewStub r4 = (ViewStub) r2.findViewById(2131377080);
        if (r4 == null) goto L13;
        KeyEvent.Callback r5 = r4.inflate();
    L15:
        if ((r5 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a) == true) goto L17;
        r5 = null;
    L17:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r6 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a) r5;
        this.j = r6;
        if (r6 == null) goto L20;
        r6.setKtvRoomViewModel((KtvRoomViewModel) this.d);
    L20:
        Object r7 = this.j;
        if ((r7 instanceof View) == true) goto L23;
        r7 = null;
    L23:
        View r8 = (View) r7;
        if (r8 == null) goto L26;
        r8.setVisibility(8);
    L26:
        View r9 = ((Widget) this).contentView;
        if (r9 == null) goto L29;
        KtvMvMidiMicLabelAnim r10 = (KtvMvMidiMicLabelAnim) r9.findViewById(2131376980);
    L30:
        this.k = r10;
        if (r10 == null) goto L33;
        r10.b();
    L33:
        View r11 = ((Widget) this).contentView;
        if (r11 == null) goto L36;
        View r12 = r11.findViewById(2131376994);
    L37:
        this.l = r12;
        enableSubWidgetManager();
        Lazy r13 = KtvCommonSettingHelper.a;
        Fq();
        KtvContext.observerCurrentUserIsSinger$default(this.y, this, false, new e(this), 2, null);
        View r14 = ((Widget) this).contentView;
        if ((r14 instanceof ViewGroup) == true) goto L40;
        r14 = null;
    L40:
        ViewGroup r15 = (ViewGroup) r14;
        if (r15 == null) goto L43;
        MvLyricWidget r16 = new MvLyricWidget(this, (ViewGroup) r15.findViewById(2131379318), new KtvStageWidget$initView$$inlined$let$lambda$1(this), (KtvRoomViewModel) this.d);
        this.i = r16;
        r16.v = false;
        r16.g(null);
    L43:
        KtvStageWidget$loadMvWidget$mvRunContext$1 r17 = new KtvStageWidget$loadMvWidget$mvRunContext$1(this);
        View r18 = ((Widget) this).contentView;
        if (r18 == null) goto L85;
        RecycleWidgetHelper.Builder r19 = new RecycleWidgetHelper.Builder((ViewGroup) r18);
        int r20 = RecycleWidgetHelper.a;
        DataCenter r21 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter("mv_widget_recycle_key", "key");
        if (r21 == null) goto L48;
        r19.c = "mv_widget_recycle_key";
        r19.b = r21;
    L48:
        Intrinsics.checkNotNullParameter(r17, "runContext");
        r19.a = r17;
        r19.d = 2;
        Function1<Boolean, Unit> r22 = new KtvStageWidget$loadMvWidget$1(this);
        Intrinsics.checkNotNullParameter(r22, "cb");
        r19.e = r22;
        KtvStageWidget$loadMvWidget$2 r23 = KtvStageWidget$loadMvWidget$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r23, "cb");
        r19.f = r23;
        KtvMvWidget r24 = (KtvMvWidget) r19.a(new KtvStageWidget$loadMvWidget$3(this));
        long r25 = this.z.b().getRoomId();
        KtvMvViewModel r26 = (KtvMvViewModel) r24.d;
        if (r26 == null) goto L51;
        r26.updateRoomId(r25);
    L51:
        Unit r27 = Unit.INSTANCE;
        com.bytedance.android.live.ktv.common.util.c r28 = r24.j;
        if ((r28 instanceof com.bytedance.android.live.ktv.common.util.c) == false) goto L55;
        r3 = r28;
    L55:
        com.bytedance.android.live.ktv.common.util.c r29 = r3;
        if (r29 == null) goto L58;
        this.y.getStatisticHelper().b(r29);
    L58:
        RxUtilKt.c(this.y.observeSingEndedFeedbackSei(new f(this)), this.m);
        KtvRoomViewModel r30 = (KtvRoomViewModel) this.d;
        if (r30 == null) goto L63;
        MutableLiveData<oe2.f> r31 = r30.getStageUiState();
        if (r31 == null) goto L63;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r31, this, KtvStageWidget$initView$5.INSTANCE, new g(this));
    L63:
        KtvRoomViewModel r32 = (KtvRoomViewModel) this.d;
        if (r32 == null) goto L68;
        MutableLiveData<oe2.f> r33 = r32.getStageUiState();
        if (r33 == null) goto L68;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r33, this, KtvStageWidget$initView$7.INSTANCE, new h(this));
    L68:
        KtvRoomViewModel r34 = (KtvRoomViewModel) this.d;
        if (r34 == null) goto L73;
        NextLiveData<Boolean> r35 = r34.getSingerFollowState();
        if (r35 == null) goto L73;
        r35.observe(this, new i(this));
    L73:
        KtvRoomViewModel r36 = (KtvRoomViewModel) this.d;
        if (r36 == null) goto L78;
        MutableLiveData<qd> r37 = r36.getKtvMicLabelEvent();
        if (r37 == null) goto L78;
        r37.observe(this, new c(this));
    L78:
        Intrinsics.checkNotNullParameter(new KtvStageWidget$initView$11(this), "cb");
        KtvRoomViewModel r38 = (KtvRoomViewModel) this.d;
        if (r38 == null) goto L86;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r39 = r38.getStateChangeEvent();
        if (r39 == null) goto L87;
        r39.observe(this, new d(this));
        return;
    L87:
        return;
    L86:
        return;
    L85:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L36:
        r12 = null;
        goto L37
    L29:
        r10 = null;
    L13:
        r5 = null;
        goto L15
    }

    public final void Fq() {
        if (this.g != null) goto L6;
        KtvMvControlAreaWidget r0 = new KtvMvControlAreaWidget((KtvRoomViewModel) this.d, this.y, new KtvRoomChallengeViewWrapper(((Widget) this).context, (KtvRoomViewModel) this.d));
        this.g = r0;
        ((Widget) this).subWidgetManager.load(2131376991, r0, false);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidget, com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget
    public final ViewModelProvider.Factory getViewModelFactory() {
        return new KtvRoomViewModelFactory(this.y, this.z);
    }

    public final void onDestroy() {
        ALogger.e("coreVm排查", "mvstage onDestroy");
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.y.getSeiProcessor().getValue()).g(this);
        this.y.getRealOpenStateData().removeObserver(this.t);
        com.bytedance.android.livesdk.ktvimpl.base.frame.b r0 = this.y.getKWidgetManager();
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "widget");
        Class<?> r1 = getClass();
        Intrinsics.checkNotNullParameter(r1, "clazz");
        IKWidget<?> r2 = r0.a.remove(r1);
        if (r2 == null) goto L5;
        r2.onUnLoad();
    L5:
        this.y.getCurrentMvVid().setValue(null);
        KtvMvControlAreaWidget r3 = this.g;
        if (r3 == null) goto L11;
        WidgetManager r4 = ((Widget) this).subWidgetManager;
        if (r4 == null) goto L10;
        r4.unload(r3);
    L10:
        this.g = null;
    L11:
        KtvMvMidiWidget r5 = this.h;
        if (r5 == null) goto L17;
        WidgetManager r6 = ((Widget) this).subWidgetManager;
        if (r6 == null) goto L16;
        r6.unload(r5);
    L16:
        this.h = null;
    L17:
        this.m.dispose();
        this.y.getLyricResourceManager().d = true;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L20;
        r7.put("ktv_mv_style_flag", Boolean.FALSE);
    L20:
        xs2.b.a().post(new id2.b(null, "KtvMvStageWidget"));
        com.bytedance.live.datacontext.n<Integer> r8 = this.y.getKtvCardViewSizeChanged();
        if (r8 == null) goto L23;
        r8.setValue(0);
    L23:
        this.y.getBizLcMager().c(this);
        super.onDestroy();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvStageWidget for r4v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.ktvimpl.base.KtvContext r0 = r4.y;
        com.bytedance.android.livesdk.ktvimpl.base.frame.b r0 = r0.getKWidgetManager();
        r0.getClass();
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, "widget");
        java.lang.Class<?> r1 = getClass();
        boolean r2 = com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget.class.isAssignableFrom(r1);
        if (r2 == true) goto L5;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder("loadKWidget class ERROR:");
        r0.append(r1);
        java.lang.String r0 = r0.toString();
        java.lang.String r1 = bb0.b.b();
        java.lang.StringBuilder r2 = new java.lang.StringBuilder();
        r2.append(r0);
        r2.append(", invoke class :");
        java.lang.String r0 = com.bytedance.android.livesdk.ktvimpl.base.frame.b.class.getSimpleName();
        r2.append(r0);
        java.lang.String r0 = r2.toString();
        com.bytedance.android.live.core.log.ALogger.i(r1, r0);
    L9:
        com.bytedance.android.livesdk.ktvimpl.base.KtvContext r0 = r4.y;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.ktvimpl.base.sei.m> r0 = r0.getSeiProcessor();
        java.lang.Object r0 = r0.getValue();
        com.bytedance.android.livesdk.ktvimpl.base.sei.d r0 = (com.bytedance.android.livesdk.ktvimpl.base.sei.d) r0;
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a(r0, r4);
        com.bytedance.android.livesdk.ktvimpl.base.KtvContext r0 = r4.y;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h r0 = r0.getLyricResourceManager();
        r0.d = false;
        return;
    L5:
        java.util.HashMap<java.lang.Class<? extends com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget<?>>, com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget<?>> r2 = r0.a;
        boolean r2 = r2.containsKey(r1);
        if (r2 == false) goto L8;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder("kwidget repeat:");
        r0.append(r1);
        java.lang.String r0 = r0.toString();
        java.lang.String r1 = bb0.b.b();
        java.lang.StringBuilder r2 = new java.lang.StringBuilder();
        r2.append(r0);
        r2.append(", invoke class :");
        java.lang.String r0 = com.bytedance.android.livesdk.ktvimpl.base.frame.b.class.getSimpleName();
        r2.append(r0);
        java.lang.String r0 = r2.toString();
        com.bytedance.android.live.core.log.ALogger.i(r1, r0);
        goto L9
    L8:
        java.util.HashMap<java.lang.Class<? extends com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget<?>>, com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget<?>> r0 = r0.a;
        java.lang.Class<? extends com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget<?>> r1 = (java.lang.Class<? extends com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget<?>>) r1;
        java.lang.Object r4 = (com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget<?>) r4;
        r0.put(r1, r4);
        yq();
        goto L9
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        KtvMvMidiWidget r0 = this.h;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidget
    public final AbsKtvControlWidget.WidgetType wq() {
        return AbsKtvControlWidget.WidgetType.KTV_MV;
    }

    public final void Aq(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        KtvRoomLyricsStateMachineConfig.d r3 = (KtvRoomLyricsStateMachineConfig.d) r2.c;
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L10;
        if (this.y.isCurrentUserIsSinger() == false) goto L15;
        Bq("onPreparing");
        return;
    L15:
        return;
    L10:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L12;
        return;
    L12:
        if (this.y.isCurrentUserIsSinger() == false) goto L18;
        Bq("onSinging");
        return;
    }

    public final void Bq(String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        KtvContext r0 = this.y;
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r1 = r0.getRealOpenStateData();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L8:
        boolean r3 = false;
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L11;
    L14:
        boolean r4 = true;
    L15:
        KtvRoomViewModel r5 = (KtvRoomViewModel) this.d;
        if (r5 == null) goto L24;
        KtvRoomLyricsStateMachineConfig.d r6 = r5.getCurState();
        if (r6 == null) goto L24;
        MusicPanel r8 = r6.b();
        if (r8 == null) goto L24;
        if (KtvUtilsKt.B(r8) != true) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == false) goto L36;
        if (r4 == true) goto L36;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r10 = KtvRoomContext.a.a();
        if (r10 == null) goto L34;
        com.bytedance.live.datacontext.m<Boolean> r11 = r10.isMidiOpened();
        if (r11 == null) goto L34;
        if (((Boolean) r11.getValue()).booleanValue() != true) goto L34;
    L35:
        r3 = true;
    L34:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.M.getValue()).booleanValue() == true) goto L35;
    L36:
        ALogger.i("ttlive_ktv", "KtvMvStageWidget, initMidiViewAndSendMidiStatusSei: isChallenging = " + r4 + ", supportScore = " + r9 + ", showMidi = " + r3 + ", source = " + r7);
        Cq(r3, true);
        return;
    L24:
        r9 = false;
        goto L25
    L11:
        if (ne2.a.d() == true) goto L14;
        r4 = false;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(com.bytedance.android.livesdk.ktvimpl.base.sei.w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r3 = r2.b;
        if ((r3 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r3 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r0 = this.v;
        if (r0 == null) goto L5;
        r0.onSeiResult(r10);
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r1 = this.w;
        if (r1 == null) goto L8;
        r1.onSeiResult(r10);
    L8:
        boolean r2 = false;
        if (ne2.a.a() == true) goto L52;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r3 = r10.b;
        if ((r3 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L14;
    L32:
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r4 = r10.b;
        if ((r4 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L39;
        if (ne2.a.d() == false) goto L37;
        Cq(false, true);
    L37:
        this.q = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).s();
        goto L52
    L39:
        if ((r4 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == false) goto L52;
        if (this.q != null) goto L52;
        String r5 = r4.a();
        KtvRoomViewModel r6 = (KtvRoomViewModel) this.d;
        if (r6 == null) goto L47;
        Object r7 = r6.getCurrentSingerUserId();
        if (r7 == null) goto L47;
    L49:
        if (Intrinsics.areEqual(r5, r7) == false) goto L52;
        Cq(true, true);
    L47:
        r7 = 0;
        goto L49
    L14:
        if (((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r3).s() == null) goto L32;
        String r8 = r10.b.a();
        Integer r9 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).s();
        KtvRoomViewModel r11 = (KtvRoomViewModel) this.d;
        if (r11 == null) goto L19;
        Object r12 = r11.getCurrentSingerUserId();
        if (r12 == null) goto L19;
    L21:
        if (Intrinsics.areEqual(r8, r12) == true) goto L23;
    L31:
        this.q = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).s();
        goto L52
    L23:
        if (ne2.a.d() == true) goto L31;
        if (r9 != null) goto L27;
    L29:
        boolean r13 = false;
    L30:
        Cq(r13, true);
        goto L31
    L27:
        if (r9.intValue() != 1) goto L29;
        r13 = true;
    L19:
        r12 = 0;
    L52:
        if (this.n == false) goto L54;
        return;
    L54:
        if ((r10.b instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L56;
        return;
    L56:
        if (this.y.isCurrentUserIsSinger() == true) goto L158;
        KtvRoomViewModel r14 = (KtvRoomViewModel) this.d;
        String r15 = null;
        if (r14 == null) goto L61;
        KtvDressSyncData r16 = r14.getKtvMidiSkinDress();
    L62:
        String r17 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).r();
        if (r16 == null) goto L67;
        MidiSkinDressInfo r18 = r16.getDressInfo();
        if (r18 == null) goto L67;
        String r19 = r18.getDressId();
    L69:
        if (Intrinsics.areEqual(r17, r19) == false) goto L119;
        long r20 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).j();
        if (r16 == null) goto L73;
        Long r21 = r16.getSongId();
    L74:
        if (r21 == null) goto L119;
        if (r20 != r21.longValue()) goto L119;
        String r22 = r10.b.a();
        if (r16 == null) goto L81;
        String r23 = r16.getSingerIdString();
    L83:
        if (Intrinsics.areEqual(r22, r23) == false) goto L119;
        KtvDressSyncData r24 = this.r;
        if (r24 == null) goto L89;
        MidiSkinDressInfo r25 = r24.getDressInfo();
        if (r25 == null) goto L89;
        String r26 = r25.getDressId();
    L90:
        if (r16 == null) goto L94;
        MidiSkinDressInfo r27 = r16.getDressInfo();
        if (r27 == null) goto L94;
        String r28 = r27.getDressId();
    L96:
        if ((!Intrinsics.areEqual(r26, r28)) == true) goto L106;
        KtvDressSyncData r29 = this.r;
        if (r29 == null) goto L100;
        Long r30 = r29.getSongId();
    L101:
        long r31 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).j();
        if (r30 == null) goto L106;
        if (r30.longValue() == r31) goto L119;
    L100:
        r30 = null;
    L106:
        MvLyricWidget r110 = this.i;
        if (r110 == null) goto L117;
        if (r16 == null) goto L114;
        MidiSkinDressInfo r32 = r16.getDressInfo();
        if (r32 == null) goto L114;
        MidiSkinMaterial r33 = r32.getMaterial();
        if (r33 == null) goto L114;
        r15 = r33.getLyricColorValue();
    L114:
        KtvMvLyricPresenter r111 = r110.k;
        if (r111 == null) goto L117;
        r111.h(r15);
    L117:
        this.r = r16;
        return;
    L94:
        r28 = null;
    L89:
        r26 = null;
        goto L90
    L81:
        r23 = null;
        goto L83
    L73:
        r21 = null;
    L119:
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).r(), BDLocationException.ERROR_TIMEOUT) == true) goto L123;
        if (((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).r() == null) goto L123;
        return;
    L123:
        if (this.r == null) goto L156;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r112 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r34 = r112.w();
        if (r34 == null) goto L128;
        String r35 = r34.h();
        if (r35 == null) goto L128;
    L129:
        long r36 = r112.j();
        KtvDressSyncData r113 = this.r;
        if (r113 == null) goto L132;
        Long r114 = r113.getSongId();
    L133:
        if (r114 != null) goto L136;
    L144:
        if (r2 == true) goto L157;
        MvLyricWidget r115 = this.i;
        if (r115 == null) goto L150;
        KtvMvLyricPresenter r116 = r115.k;
        if (r116 == null) goto L150;
        r116.h(null);
    L150:
        this.r = null;
        return;
    L157:
        return;
    L136:
        if (r36 != r114.longValue()) goto L144;
        KtvDressSyncData r117 = this.r;
        if (r117 == null) goto L140;
        String r118 = r117.getSingerIdString();
    L142:
        if (Intrinsics.areEqual(r35, r118) == false) goto L144;
        r2 = true;
        goto L144
    L140:
        r118 = null;
        goto L142
    L132:
        r114 = null;
    L128:
        r35 = r112.a();
        goto L129
    L156:
        return;
    L67:
        r19 = null;
        goto L69
    L61:
        r16 = null;
        goto L62
    }

    public KtvStageWidget(KtvContext r2, sb0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "dataEntity");
        this.y = r2;
        this.z = r3;
        this.m = new CompositeDisposable();
        Object r4 = r2.getKtvCoreViewModel().getValue();
        if ((r4 instanceof BaseCoreViewModel) == true) goto L5;
        r4 = null;
    L5:
        this.p = (BaseCoreViewModel) r4;
        this.s = r2.getBizLcMager();
        this.t = new b(this);
        r2.getBizLcMager().a(this);
        this.u = vm2.d.Z();
        this.x = new j(this);
    }

    public static final void zq(KtvStageWidget r4, StateMachine.c.b r5) {
        r4.getClass();
        if (r5 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r5.c;
    L7:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L9;
        long r1 = 500;
    L10:
        r4.m.add(Observable.timer(r1, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b2(r4, r5)));
        return;
    L9:
        r1 = 1000;
        goto L10
    L5:
        r0 = null;
        goto L7
    }

    public final void Cq(boolean r9, boolean r10) {
        MusicPanel r0 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.y);
        MvLyricWidget r1 = null;
        if (r0 == null) goto L7;
        KtvMusic r2 = r0.a;
        if (r2 == null) goto L7;
        String r3 = r2.getMidiUrl();
    L8:
        boolean r4 = true;
        boolean r5 = !TextUtils.isEmpty(r3);
        if (Intrinsics.areEqual(this.o, Boolean.FALSE) == false) goto L11;
        r5 = true;
    L11:
        if (r9 == false) goto L22;
        if (r5 == true) goto L14;
    L25:
        if (r9 == false) goto L28;
        if (r5 == false) goto L28;
    L29:
        this.n = r4;
        return;
    L28:
        r4 = false;
        goto L29
    L14:
        if (this.h != null) goto L25;
        T r6 = this.d;
        if (r6 == 0) goto L25;
        KtvContext r7 = this.y;
        Intrinsics.checkNotNull(r6);
        KtvRoomViewModel r8 = (KtvRoomViewModel) r6;
        MvLyricWidget r11 = this.i;
        if ((r11 instanceof com.bytedance.android.livesdk.ktvimpl.base.lyrics.b) == false) goto L21;
        r1 = r11;
    L21:
        KtvMvMidiWidget r12 = new KtvMvMidiWidget(r7, r8, r1, this.l);
        this.h = r12;
        ((Widget) this).subWidgetManager.load(2131376995, r12, r10);
        goto L25
    L22:
        KtvMvMidiWidget r13 = this.h;
        if (r13 == null) goto L25;
        ((Widget) this).subWidgetManager.unload(r13);
        this.h = null;
    L7:
        r3 = null;
        goto L8
    }
}
