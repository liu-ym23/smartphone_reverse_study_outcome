package com.bytedance.android.livesdk.ktvimpl.base;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.CommonOrderSongViewModel;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.search.viewmodel.CommonSearchViewModel;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.plantform.utils.o0;
import com.bytedance.android.live.liveinteract.plantform.utils.p0;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.config.xa0;
import com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongDialog;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongHandler;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.efffectselect.EffectMusicSelectDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.efffectselect.manager.EffectMusicSelectFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.efffectselect.viewmodel.EffectMusicSelectViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.KtvDressViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvEchoChecker;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor.KtvComponentAnchorLogicWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience.KtvComponentAudienceLogicWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.KtvChallengeWidget;
import com.bytedance.android.livesdk.ktvimpl.speech.LyricsRecognitionWidget;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomState;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/KtvControlWidget;", "Lcom/bytedance/android/livesdk/ktvapi/AbsKtvControlWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvControlWidget extends AbsKtvControlWidget implements com.bytedance.android.livesdk.ktvimpl.base.sei.b, Observer<KVData> {
    public static final /* synthetic */ int v = 0;
    public final String d;
    public Pair<KtvRoomContext, ? extends Disposable> e;
    public int f;
    public final com.bytedance.android.livesdk.ktvimpl.base.sei.m g;
    public String h;
    public KtvChallengeWidget i;
    public LyricsRecognitionWidget j;
    public boolean k;
    public final KtvControlWidget$usbReceiver$1 l;
    public final p0 m;
    public final o0 n;
    public com.bytedance.android.live.liveinteract.plantform.utils.m o;
    public final boolean p;
    public boolean q;
    public Integer r;
    public Pair<? extends DataContext, ? extends Disposable> s;
    public Disposable t;
    public final AbsKtvControlWidget.a u;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvControlWidget a;

        public b(KtvControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            String r5 = ((pv0.c) r4).a;
            if (r5 != null) goto L5;
            return;
        L5:
            if (((Boolean) vm2.h.h.getValue(null, vm2.h.a[6])).booleanValue() == false) goto L7;
            ALogger.i(this.a.d, "KtvControlWidget:  rtc-sei:".concat(r5));
        L7:
            KtvControlWidget r0 = this.a;
            if (((Widget) r0).isViewValid == true) goto L10;
            return;
        L10:
            if (r0.k == true) goto L19;
            com.bytedance.android.livesdk.ktvimpl.base.sei.m r1 = r0.g;
            if (r1 == null) goto L18;
            r1.d(r0, r5);
            return;
        L18:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvControlWidget a;

        public c(KtvControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            od2.a r14 = (od2.a) r13;
            final KtvControlWidget r0 = this.a;
            Integer r3 = Integer.valueOf(FirstLevelTab.OrderSongTab.getValue());
            String r1 = r14.a;
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            String r4 = r14.b;
            if (r4 == null) goto L9;
            r2 = r4;
        L9:
            id2.d r15 = r14.c;
            int r5 = KtvControlWidget.v;
            r0.getClass();
            EffectMusicSelectDataContext.Companion.getClass();
            if (EffectMusicSelectDataContext.Companion.d() != null) goto L39;
            Pair<? extends DataContext, ? extends Disposable> r6 = com.bytedance.live.datacontext.d.a(KtvControlWidget$openEffectMusicSelectSongDialog$1.INSTANCE);
            r0.s = r6;
            if (r6 == null) goto L14;
            DataContext r7 = (DataContext) r6.getFirst();
        L16:
            if ((r7 instanceof EffectMusicSelectDataContext) == true) goto L18;
            r7 = null;
        L18:
            EffectMusicSelectDataContext r8 = (EffectMusicSelectDataContext) r7;
            if (r8 == null) goto L21;
            com.bytedance.live.datacontext.b.a(r8, KtvControlWidget$openEffectMusicSelectSongDialog$2.INSTANCE);
        L21:
            KSongOrderSongHandler r9 = new KSongOrderSongHandler();
            if (r8 == null) goto L26;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b> r10 = r8.m50getCommonOrderSongViewModel();
            if (r10 == null) goto L26;
            CommonOrderSongViewModel.Companion.getClass();
            r10.d(CommonOrderSongViewModel.a.a(r0, r9));
        L26:
            if (r8 == null) goto L30;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.ktv.common.search.viewmodel.a> r11 = r8.m51getCommonSearchViewModel();
            if (r11 == null) goto L30;
            CommonSearchViewModel.Companion.getClass();
            r11.d(CommonSearchViewModel.a.a(r0, r9));
        L30:
            if (r8 == null) goto L34;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r12 = r8.m49getBusinessOrderSongViewModel();
            if (r12 == null) goto L34;
            EffectMusicSelectViewModel.a r16 = EffectMusicSelectViewModel.Companion;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r17 = EffectMusicSelectDataContext.Companion.b();
            com.bytedance.android.live.ktv.common.search.viewmodel.a r18 = EffectMusicSelectDataContext.Companion.c();
            r16.getClass();
            Intrinsics.checkNotNullParameter(r0, "viewModelStoreOwner");
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r19 = new ViewModelProvider(r0, new EffectMusicSelectViewModel.EffectMusicSelectViewModelFactory(r17, r18, null)).get(EffectMusicSelectViewModel.class);
            r19.initData();
            Unit r20 = Unit.INSTANCE;
            r12.d(r19);
        L34:
            r9.a = EffectMusicSelectDataContext.Companion.a();
            r9.b = EffectMusicSelectDataContext.Companion.b();
            if (r8 == null) goto L39;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a> r21 = r8.m52getKtvDressViewModel();
            if (r21 == null) goto L39;
            KtvDressViewModel.Companion.getClass();
            r21.d(KtvDressViewModel.a.a(r0));
            goto L39
        L14:
            r7 = null;
        L39:
            com.bytedance.android.livesdk.ktvimpl.base.util.q.e();
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r22 = EffectMusicSelectDataContext.Companion.a();
            if (r22 == null) goto L42;
            r22.updateRequiredSongInfo(r2);
        L42:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r23 = EffectMusicSelectDataContext.Companion.a();
            if (r23 == null) goto L46;
            r23.updateOrderSongExtraInfo(new td2.b(r1, new WeakReference(((Widget) r0).context)));
        L46:
            if (Intrinsics.areEqual(r1, "sing_song") == false) goto L48;
            String r24 = "component_btn_click";
        L49:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r25 = EffectMusicSelectDataContext.Companion.a();
            if (r25 == null) goto L52;
            r25.clearSelectedSongList();
        L52:
            KSongOrderSongUtilKt.b(((Widget) r0).context, CloseOrderSongDialogSource.AUTO);
            int r26 = EffectMusicSelectFirstLevelTabManager.q;
            Context r27 = ((Widget) r0).context;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r28 = EffectMusicSelectDataContext.Companion.b();
            com.bytedance.android.live.ktv.common.search.viewmodel.a r29 = EffectMusicSelectDataContext.Companion.c();
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r30 = EffectMusicSelectDataContext.Companion.a();
            EffectMusicSelectDataContext r31 = EffectMusicSelectDataContext.Companion.d();
            if (r31 == null) goto L57;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a> r32 = r31.m52getKtvDressViewModel();
            if (r32 == null) goto L57;
            com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r33 = (com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a) r32.getValue();
        L58:
            EffectMusicSelectFirstLevelTabManager r110 = new EffectMusicSelectFirstLevelTabManager(r3, r27, r28, r29, r30, r33);
            int r34 = KSongOrderSongDialog.p;
            KSongOrderSongDialog r35 = KSongOrderSongDialog.a.a(EffectMusicSelectDataContext.Companion.a(), r110, new KtvControlWidget$openEffectMusicSelectSongDialog$4(r0), 4);
            FragmentActivity r36 = ((Widget) r0).context;
            if (r36 == null) goto L70;
            FragmentManager r37 = r36.getSupportFragmentManager();
            LandscapeRestrictionOperation r38 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r35, "KSongOrderSongDialog", r38);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r37, r35, r38) == false) goto L72;
        L65:
            pd2.d.n.getClass();
            pd2.d.G(r24, true);
            if (r0.t != null) goto L74;
            r0.t = xs2.b.a().b(id2.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.ktvimpl.base.g(r0, r15), com.bytedance.android.livesdk.ktvimpl.base.h.a);
            return;
        L74:
            return;
        L72:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L71
        L64:
            r35.showNow(r37, "KSongOrderSongDialog");
            goto L65
        L70:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L57:
            r33 = null;
            goto L58
        L48:
            r24 = "other";
            goto L49
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvControlWidget a;

        public d(KtvControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            boolean r3 = KtvEchoChecker.a;
            KtvEchoChecker.b(((Widget) this.a).context);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ KtvControlWidget a;

        public e(KtvControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (KtvEchoChecker.b == false) goto L6;
            KtvEchoChecker.b(((Widget) this.a).context);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ KtvControlWidget a;

        public g(KtvControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (((Boolean) xa0.a.getValue()).booleanValue() == false) goto L15;
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L7;
            LayerEventDispatcher r1 = o70.c.a(Integer.valueOf(r0.hashCode()));
        L8:
            if (r1 != null) goto L10;
            return;
        L10:
            if (r4 == null) goto L12;
            boolean r5 = r4.booleanValue();
        L13:
            r1.b(new u0(r5));
            return;
        L12:
            r5 = false;
            goto L13
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ KtvControlWidget a;

        public h(KtvControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            sh6.b r6 = (sh6.b) r5;
            DataCenter r7 = ((Widget) this.a).dataCenter;
            if (r7 == null) goto L5;
            LayerEventDispatcher r8 = o70.c.a(Integer.valueOf(r7.hashCode()));
        L6:
            if (r8 == null) goto L9;
            r8.b(new o42.c(true, false, "IKtvService subscribe"));
            return;
        L9:
            return;
        L5:
            r8 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.KtvControlWidget$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass3(KtvControlWidget r8) {
            super(1, r8, KtvControlWidget.class, "handleKtvAllStateChanged", "handleKtvAllStateChanged(I)V", 0);
        }

        public final void invoke(int r12) {
            KtvControlWidget r0 = (KtvControlWidget) ((CallableReference) this).receiver;
            int r1 = KtvControlWidget.v;
            r0.getClass();
            String r2 = "handleKtvAllStateChanged:newState" + r12 + ",curState:" + r0.f;
            ALogger.i(bb0.b.b(), r2 + ", invoke class :KtvControlWidget");
            int r3 = r0.f;
            if (r12 != r3) goto L5;
        L64:
            r0.xq();
            return;
        L5:
            if (v.a(r3, 8) == v.a(r12, 8)) goto L63;
            boolean r4 = v.a(r12, 8);
            String r5 = bb0.b.b();
            ALogger.i(r5, ("toggleAudioKtv,openAudioKtv:" + r4) + ", invoke class :KtvControlWidget");
            IKtvService r6 = jc1.k.f(IKtvService.class);
            if (r6 == null) goto L9;
            android.util.Pair r7 = r6.provideStageModeLogInjector();
        L10:
            if (r4 == false) goto L41;
            Pair<KtvRoomContext, ? extends Disposable> r8 = r0.e;
            if (r8 == null) goto L14;
            KtvRoomContext r9 = (KtvRoomContext) r8.getFirst();
        L66:
            u r10 = com.bytedance.android.live.liveinteract.api.utils.m.e(r0);     // Catch: JSONException -> L37
            if (r10 == null) goto L39;
            String r11 = r10.i();     // Catch: JSONException -> L37
            if (r11 == null) goto L39;
            JSONObject r13 = new JSONObject(r11);     // Catch: JSONException -> L37
            long r14 = r13.optLong("linkmic_ktv_song_id");     // Catch: JSONException -> L37
            if (r14 == 0) goto L25;
            if (r9 == null) goto L25;
            com.bytedance.live.datacontext.m<Long> r15 = r9.getRelevantLiveSongId();     // Catch: JSONException -> L37
            if (r15 == null) goto L25;
            r15.setValue(Long.valueOf(r14));     // Catch: JSONException -> L37
        L25:
            String r16 = r13.optString("linkmic_ktv_song_name");     // Catch: JSONException -> L37
            if (r16 == null) goto L39;
            if (r16.length() <= 0) goto L30;
            boolean r17 = true;
        L31:
            if (r17 != true) goto L39;
            if (r9 == null) goto L39;
            com.bytedance.live.datacontext.n<String> r18 = r9.getRelevantLiveSongName();     // Catch: JSONException -> L37
            if (r18 == null) goto L39;
            r18.setValue(r16);     // Catch: JSONException -> L37
            goto L39
        L30:
            r17 = false;
        L39:
            if (r7 == null) goto L50;
            j0 r19 = j0.l();
            Object r20 = r7.first;
            Object r21 = r7.second;
            Intrinsics.checkNotNull(r21);
            r19.addSendLogFilter(r20, (com.bytedance.android.livesdk.log.filter.v) r21);
        L50:
            boolean r22 = !r4;
            if (r0.isAnchor() == true) goto L55;
            if (r22 == false) goto L55;
            ArrayList<Integer> r23 = ke2.a.a;
            com.bytedance.android.live.ktv.common.util.a.c();
            ALogger.w("KtvComponent_MergeMode", "KtvControl toggleAudienceWidget, isEnableKtvComponentV2=true");
        L55:
            if (r4 == false) goto L59;
            IPerformanceManager r24 = jc1.k.f(IPerformanceManager.class);
            if (r24 == null) goto L62;
            r24.onModuleStart("multi_audio_ktv", null);
        L62:
            com.bytedance.android.livesdk.ktvimpl.base.util.p.g.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.util.p.f = r4;
            goto L63
        L59:
            IPerformanceManager r25 = jc1.k.f(IPerformanceManager.class);
            if (r25 == null) goto L62;
            r25.onModuleStop("multi_audio_ktv");
        L37:
            e = move-exception;
            ALogger.e(r0.d, "handle relevant live extra failed", e);
            goto L39
        L14:
            r9 = null;
            goto L66
        L41:
            if (r7 == null) goto L45;
            String r26 = (String) r7.first;
            if (r26 == null) goto L45;
            j0.l().removeSendLogFilter(r26);
        L45:
            Pair<KtvRoomContext, ? extends Disposable> r27 = r0.e;
            if (r27 == null) goto L50;
            Disposable r28 = (Disposable) r27.getSecond();
            if (r28 == null) goto L50;
            r28.dispose();
            goto L50
        L9:
            r7 = null;
        L63:
            r0.f = r12;
            goto L64
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).intValue());
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final boolean isAnchor() {
        return a0.d(((Widget) this).dataCenter, false);
    }

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        com.bytedance.android.live.ktv.common.music.download.m r0 = KtvMusicManager.a;
        KtvMusicManager.j();
        KtvContext.Companion.getClass();
        KtvContext r1 = KtvContext.a.g();
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.ktvimpl.base.sei.m> r2 = r1.getSeiProcessor();
        if (r2 == null) goto L10;
        com.bytedance.android.livesdk.ktvimpl.base.sei.m r3 = (com.bytedance.android.livesdk.ktvimpl.base.sei.m) r2.getValue();
        if (r3 == null) goto L10;
        p0 r4 = this.m;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "recieverPipe");
        ALogger.i(r4.d, "addStreamInfoReciever");
        r4.a.add(r3);
    L10:
        if (this.q == true) goto L12;
    L14:
        KtvContext r5 = KtvContext.a.g();
        r5.setDataCenter(((Widget) this).dataCenter);
        com.bytedance.live.datacontext.n r6 = null;
        if (((Boolean) vm2.h.Y0.getValue(null, vm2.h.a[101(0x65, float:1.42E-43)])).booleanValue() == false) goto L18;
        r5.getBigEventHelper().setValue(new com.bytedance.android.livesdk.ktvimpl.base.util.h(((Widget) this).dataCenter));
    L18:
        if (KtvContext.access$getEnableRoomStateSync$cp() == true) goto L20;
    L22:
        this.u.a(AbsKtvControlWidget.WidgetType.CHORUS, new ChorusWidget());
        com.bytedance.live.datacontext.m<Integer> r7 = r5.getKtvAllState();
        if (r7 == null) goto L29;
        Observable r8 = r7.a();
        if (r8 == null) goto L29;
        ObservableSubscribeProxy r9 = (ObservableSubscribeProxy) r8.as(autoDispose());
        if (r9 == null) goto L29;
        final AnonymousClass3 r10 = new AnonymousClass3(this);
        r9.subscribe(new i(r10));
    L29:
        com.bytedance.android.livesdk.chatroom.o r11 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        u r12 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r11 == null) goto L83;
        if (r12 == null) goto L83;
        ((ObservableSubscribeProxy) jc1.k.n(IBaseBrowserService.class).registerExternalMethodFactory(new qd2.b(r11)).as(autoDispose())).subscribe();
        com.bytedance.live.datacontext.j r13 = r12.s();
        if (r13 == null) goto L41;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r14 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r13.getValue();
        if (r14 == null) goto L41;
        BehaviorSubject r15 = r14.a();
        if (r15 == null) goto L41;
        ObservableSubscribeProxy r16 = (ObservableSubscribeProxy) r15.as(autoDispose());
        if (r16 == null) goto L41;
        final KtvControlWidget$onCreate$4$1 r17 = new KtvControlWidget$onCreate$4$1(this);
        r16.subscribe(new i(r17));
    L41:
        com.bytedance.live.datacontext.j r18 = r12.getVideoTalkRoomSubScene();
        if (r18 == null) goto L50;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r19 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r18.getValue();
        if (r19 == null) goto L50;
        BehaviorSubject r20 = r19.a();
        if (r20 == null) goto L50;
        ObservableSubscribeProxy r21 = (ObservableSubscribeProxy) r20.as(autoDispose());
        if (r21 == null) goto L50;
        final KtvControlWidget$onCreate$4$2 r22 = new KtvControlWidget$onCreate$4$2(this);
        r21.subscribe(new i(r22));
    L50:
        ((ObservableSubscribeProxy) xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new b(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(od2.a.class).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new c(this));
        com.bytedance.live.datacontext.m r23 = r11.R2();
        if (r23 == null) goto L57;
        Observable r24 = r23.a();
        if (r24 == null) goto L57;
        ObservableSubscribeProxy r25 = (ObservableSubscribeProxy) r24.as(autoDispose());
        if (r25 == null) goto L57;
        r25.subscribe(new d(this));
    L57:
        com.bytedance.live.datacontext.j r26 = r12.s();
        boolean r27 = false;
        if (r26 == null) goto L64;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r28 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r26.getValue();
        if (r28 == null) goto L64;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r29 = r28.t();
        if (r29 == null) goto L64;
        int r30 = r29.a;
    L65:
        com.bytedance.live.datacontext.j r31 = r12.s();
        if (r31 == null) goto L72;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r32 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r31.getValue();
        if (r32 == null) goto L72;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r33 = r32.t();
        if (r33 == null) goto L72;
        int r34 = r33.b;
    L74:
        if (r30 != 9) goto L77;
        if (r34 != 0) goto L77;
        boolean r35 = true;
    L78:
        if (r30 == 9) goto L80;
    L82:
        KtvUtilsKt.l(r35, r27);
        goto L83
    L80:
        if (r34 != 61) goto L82;
        r27 = true;
    L77:
        r35 = false;
    L72:
        r34 = 0;
    L64:
        r30 = 0;
    L83:
        com.bytedance.live.datacontext.k<Object> r36 = r5.getEchoStateCheckEvent();
        if (r36 == null) goto L90;
        PublishSubject r37 = r36.onEvent();
        if (r37 == null) goto L90;
        ObservableSubscribeProxy r38 = (ObservableSubscribeProxy) r37.as(autoDispose());
        if (r38 == null) goto L90;
        r38.subscribe(new e(this), f.a);
    L90:
        ArrayList<Integer> r39 = ke2.a.a;
        com.bytedance.android.live.ktv.common.util.a.c();
        ALogger.w("KtvComponent_MergeMode", "KtvControl onCreate, isEnableKtvComponentV2=true");
        if (isAnchor() == false) goto L94;
        this.u.a(AbsKtvControlWidget.WidgetType.KTV_COMPONENT_V2_ANCHOR_LOGIC, new KtvComponentAnchorLogicWidget(this.u));
    L97:
        if (((Boolean) KtvSettingHelper.r0.getValue()).booleanValue() == false) goto L99;
        this.u.a(AbsKtvControlWidget.WidgetType.MIDI_DEBUG_VIEW, new MidiScoreDebugWidget());
    L99:
        enableSubWidgetManager();
        KtvChallengeWidget r40 = new KtvChallengeWidget();
        this.i = r40;
        WidgetManager r41 = ((Widget) this).subWidgetManager;
        if (r41 == null) goto L103;
        r41.load(r40);
    L103:
        if (isAnchor() == false) goto L107;
        enableSubWidgetManager();
        LyricsRecognitionWidget r42 = new LyricsRecognitionWidget();
        this.j = r42;
        WidgetManager r43 = ((Widget) this).subWidgetManager;
        if (r43 == null) goto L107;
        r43.load(r42);
    L107:
        IntentFilter r44 = new IntentFilter();
        r44.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        wq(((Widget) this).context, this.l, r44);     // Catch: Throwable -> L110
    L111:
        ((Widget) this).dataCenter.observe("cmd_open_ktv_component_with_link_check", this);
        ((Widget) this).dataCenter.observe("cmd_open_play_mode_after_linkin", this);
        ((Widget) this).dataCenter.observe("cmd_open_play_mode_direct", this);
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L133;
        com.bytedance.live.datacontext.m r45 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).I1();
        if (r45 == null) goto L120;
        Observable r46 = r45.a();
        if (r46 == null) goto L120;
        ObservableSubscribeProxy r47 = (ObservableSubscribeProxy) r46.as(AutoDispose.bind(this));
        if (r47 == null) goto L120;
        r47.subscribe(new g(this));
    L120:
        IKtvService r48 = jc1.k.f(IKtvService.class);
        if (r48 == null) goto L123;
        r6 = r48.ktvCardState();
    L123:
        if (r6 == null) goto L129;
        Observable r49 = r6.a();
        if (r49 == null) goto L129;
        ObservableSubscribeProxy r50 = (ObservableSubscribeProxy) r49.as(AutoDispose.bind(this));
        if (r50 == null) goto L129;
        r50.subscribe(new h(this));
    L129:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.c(getComponentContext(), fd2.j.class, this);
        return;
    L133:
        return;
    L110:
        ALogger.e("KtvcontrolWidget", "register usb Receiver fail");
        goto L111
    L94:
        if (ke2.a.e() == true) goto L97;
        this.u.a(AbsKtvControlWidget.WidgetType.KTV_COMPONENT_V2_ANCHOR_LOGIC, new KtvComponentAudienceLogicWidget(this.u));
        goto L97
    L20:
        if (r5.getKtvRoomModel().getValue() != null) goto L22;
        oe2.d r51 = new oe2.d();
        r5.getKtvRoomModel().setValue(r51);
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) r5.getSeiProcessor().getValue()).c(r51, 1.0f);
        goto L22
    L12:
        if (isAnchor() == true) goto L14;
        ALogger.i(bb0.b.b(), "init IMStreamInfoCatcher, invoke class :KtvControlWidget");
        this.o = new com.bytedance.android.live.liveinteract.plantform.utils.m(((Widget) this).dataCenter, this.m);
        goto L14
    }

    public final void onDestroy() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.d(getComponentContext(), fd2.j.class);
        Disposable r0 = this.t;
        if (r0 != null) goto L5;
    L7:
        ALogger.i(this.d, "onDestroy");
        Integer r1 = this.r;
        if (r1 != null) goto L11;
    L23:
        Pair<KtvRoomContext, ? extends Disposable> r2 = this.e;
        if (r2 == null) goto L28;
        Disposable r3 = (Disposable) r2.getSecond();
        if (r3 == null) goto L28;
        r3.dispose();
    L28:
        Pair<? extends DataContext, ? extends Disposable> r4 = this.s;
        if (r4 == null) goto L35;
        Disposable r5 = (Disposable) r4.getSecond();
        if (r5 == null) goto L35;
        if (r5.isDisposed() == true) goto L35;
        r5.dispose();
        this.s = null;
    L35:
        Context r6 = ((Widget) this).context;
        KtvControlWidget$usbReceiver$1 r7 = this.l;
        ReceiverRegisterLancet.loge(r7, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L75;
        r6.unregisterReceiver(r7);
    L47:
        if (isAnchor() == true) goto L58;
        p0 r8 = this.m;
        Integer r9 = r8.j;
        if (r9 == null) goto L58;
        if ((r8.i - r9.intValue()) < 30) goto L58;
        Pair[] r10 = new Pair[13];
        int r11 = r8.i + 1;
        Integer r12 = r8.j;
        if (r12 == null) goto L56;
        int r13 = r12.intValue();
    L57:
        r10[0] = TuplesKt.to("total_sync_index", String.valueOf(r11 - r13));
        r10[1] = TuplesKt.to("total_sync_index_end", String.valueOf(r8.i));
        r10[2] = TuplesKt.to("im_receive_times", String.valueOf(r8.h));
        r10[3] = TuplesKt.to("stream_receive_times", String.valueOf(r8.g));
        r10[4] = TuplesKt.to("useLessImIndex", String.valueOf(r8.n));
        r10[5] = TuplesKt.to("useLessSeiIndex", String.valueOf(r8.m));
        r10[6] = TuplesKt.to("firstSeiIndex", String.valueOf(r8.k));
        r10[7] = TuplesKt.to("firstImIndex", String.valueOf(r8.l));
        r10[8] = TuplesKt.to("lastImIndex", String.valueOf(r8.p));
        r10[9] = TuplesKt.to("lastSeiIndex", String.valueOf(r8.o));
        r10[10] = TuplesKt.to("total_miss_times", String.valueOf(r8.r));
        r10[11] = TuplesKt.to("totalReportIndexStart", String.valueOf(r8.j));
        r10[12] = TuplesKt.to("totalReportIndex", String.valueOf(r8.i));
        j0.l().sendLog("ttlive_sei_receiver_im_stream", MapsKt.hashMapOf(r10), new Object[0]);
        goto L58
    L56:
        r13 = 0;
    L58:
        com.bytedance.android.live.liveinteract.plantform.utils.m r14 = this.o;
        if (r14 == null) goto L61;
        hd0.c.f().e(r14.c);
    L61:
        KtvChallengeWidget r15 = this.i;
        if (r15 == null) goto L66;
        WidgetManager r16 = ((Widget) this).subWidgetManager;
        if (r16 == null) goto L66;
        r16.unload(r15);
    L66:
        LyricsRecognitionWidget r17 = this.j;
        if (r17 == null) goto L71;
        WidgetManager r18 = ((Widget) this).subWidgetManager;
        if (r18 == null) goto L71;
        r18.unload(r17);
    L71:
        KtvContext.Companion.getClass();
        KtvContext.a.g().setDataCenter(null);
        com.bytedance.android.livesdk.ktvimpl.base.util.p.g.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.p.f = false;
        super/*com.bytedance.android.livesdk.ktvapi.HolderRoomWidget*/.onDestroy();
        com.bytedance.android.live.ktv.common.music.download.m r19 = KtvMusicManager.a;
        KtvMusicManager.d();
        DataCenter r20 = ((Widget) this).dataCenter;
        if (r20 == null) goto L77;
        r20.removeObserver(this);
        return;
    L77:
        return;
    L75:
    L41:
        e = move-exception;
        if (r7 == null) goto L44;
        Npth.addTag("unregisterReceiver", r7.toString());
    L44:
        e.printStackTrace();
        goto L47
    L38:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r7, r6) == false) goto L47;
        r6.unregisterReceiver(r7);     // Catch: Exception -> L41
        goto L47
    L11:
        if (r1.intValue() != 9) goto L23;
        Long r21 = KtvLoggerHelper.a;
        KtvLoggerHelper.e0("close_live");
        MiddlewareRoomContext r22 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r22 == null) goto L17;
        com.bytedance.live.datacontext.m r23 = r22.getAudienceRoomState();
        if (r23 == null) goto L17;
        LiveRoomState r24 = (LiveRoomState) r23.getValue();
    L19:
        if (r24 != LiveRoomState.LIVE_FINISHED) goto L21;
        String r25 = "live_end";
    L22:
        KtvLoggerHelper.d0(r25);
        goto L23
    L21:
        r25 = "user_left";
    L17:
        r24 = null;
        goto L19
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public final void xq() {
        if (isAnchor() == false) goto L5;
        return;
    L5:
        KtvContext.Companion.getClass();
        if (KtvContext.a.c(1) == false) goto L21;
        if (KtvContext.a.k() == true) goto L21;
        List r0 = vm2.h.f0().a();
        if (r0 == null) goto L26;
        u r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r1 == null) goto L26;
        com.bytedance.live.datacontext.j r2 = r1.s();
        if (r2 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.getValue();
        if (r3 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r4 = r3.t();
        if (r4 == null) goto L26;
        this.q = r0.contains(String.valueOf(r4.a));
    L26:
        if (this.q == true) goto L28;
        this.o = null;
        return;
    L28:
        if (this.o != null) goto L32;
        this.o = new com.bytedance.android.live.liveinteract.plantform.utils.m(((Widget) this).dataCenter, this.m);
        return;
    L32:
        return;
    L21:
        if (KtvContext.a.k() == false) goto L26;
        if (vm2.h.f0().b() == false) goto L26;
        this.q = true;
        goto L26
    }

    /* JADX WARN: Type inference failed for: r4v8, types: [com.bytedance.android.livesdk.ktvimpl.base.KtvControlWidget$usbReceiver$1] */
    public KtvControlWidget(AbsKtvControlWidget.a r4) {
        Intrinsics.checkNotNullParameter(r4, "loader");
        this.u = r4;
        this.d = "KtvControlWidget";
        KtvContext.Companion.getClass();
        this.f = KtvContext.a.e();
        KtvContext r5 = KtvContext.a.g();
        if (r5 == null) goto L7;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.ktvimpl.base.sei.m> r6 = r5.getSeiProcessor();
        if (r6 == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.base.sei.m r7 = (com.bytedance.android.livesdk.ktvimpl.base.sei.m) r6.getValue();
    L8:
        this.g = r7;
        this.h = "";
        this.l = new KtvControlWidget$usbReceiver$1();
        p0 r8 = new p0();
        this.m = r8;
        this.n = new o0(r8);
        this.p = !((Boolean) vm2.d.l.getValue(null, vm2.d.a[10])).booleanValue();
        this.q = vm2.h.f0().b();
        return;
    L7:
        r7 = null;
        goto L8
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (isViewValid() == false) goto L70;
        if (r7 == null) goto L57;
        String r0 = r7.getKey();
        int r1 = r0.hashCode();
        if (r1 == (-2016471229)) goto L44;
        if (r1 == (-141909622)) goto L39;
        if (r1 == 1811180216) goto L14;
        return;
    L14:
        if (r0.equals("cmd_open_ktv_component_with_link_check") == false) goto L58;
        Pair r8 = (Pair) r7.getData();
        if (r8 != null) goto L18;
        return;
    L18:
        if (((Boolean) r8.getFirst()).booleanValue() == false) goto L60;
        String r9 = (String) r8.getSecond();
        int r2 = ge2.a.a;
        if (ge2.a.a(((Widget) this).dataCenter) == false) goto L37;
        KtvContext.a r3 = KtvContext.Companion;
        r3.getClass();
        if (KtvContext.a.c(1) == true) goto L61;
        u r4 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r4 == null) goto L32;
        com.bytedance.live.datacontext.j r5 = r4.getVideoTalkRoomSubScene();
        if (r5 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getValue();
        if (r10 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r11 = r10.t();
        if (r11 == null) goto L32;
        int r12 = r11.a;
    L33:
        com.bytedance.android.livesdk.chatroom.viewmodel.e.a.getClass();
        if (com.bytedance.android.livesdk.chatroom.viewmodel.e.a.a.contains(Integer.valueOf(r12)) == true) goto L36;
        this.h = r9;
        ((Widget) this).dataCenter.put("data_room_video_talk_log_open_success_for_enter_from", r9);
        ((Widget) this).dataCenter.put("cmd_init_video_talk_room_with_pending_play_mode", 10);
        return;
    L36:
        r3.getClass();
        KtvContext.a.a(1);
        return;
    L32:
        r12 = 0;
        goto L33
    L61:
        return;
    L37:
        ((Widget) this).dataCenter.put("cmd_init_video_ktv", Boolean.TRUE);
        return;
    L60:
        return;
    L58:
        return;
    L39:
        if (r0.equals("cmd_open_play_mode_direct") == false) goto L65;
        String r13 = (String) r7.getData();
        KtvContext.a r14 = KtvContext.Companion;
        r14.getClass();
        boolean r15 = KtvContext.a.c(1);
        String r16 = bb0.b.b();
        ALogger.i(r16, ("CMD_OPEN_PLAY_MODE_DIRECT, " + r13 + ",isKtvOpened:" + r15) + ", invoke class :KtvControlWidget");
        if (r15 == true) goto L66;
        r14.getClass();
        KtvContext.a.a(1);
        return;
    L66:
        return;
    L65:
        return;
    L44:
        if (r0.equals("cmd_open_play_mode_after_linkin") == false) goto L68;
        Pair r17 = (Pair) r7.getData();
        if (r17 == null) goto L48;
        Integer r18 = (Integer) r17.getFirst();
    L49:
        if (r17 == null) goto L51;
        String r19 = (String) r17.getSecond();
    L51:
        if (r18 != null) goto L54;
        return;
    L54:
        if (r18.intValue() != 10) goto L69;
        KtvContext.Companion.getClass();
        KtvContext.a.a(1);
        return;
    L69:
        return;
    L48:
        r18 = null;
        goto L49
    L68:
        return;
    L57:
        return;
    }

    public final void onSei(String r6) {
        Intrinsics.checkNotNullParameter(r6, "sei");
        if (((Widget) this).isViewValid == true) goto L5;
        return;
    L5:
        if (this.k == false) goto L7;
        return;
    L7:
        JSONObject r2 = null;
        if (this.p == false) goto L17;
        com.bytedance.android.livesdk.ktvimpl.base.sei.m r1 = this.g;
        if (r1 == null) goto L16;
        Intrinsics.checkNotNullParameter(r6, "seiData");
        String r3 = (String) r1.h.invoke(r6);
        if (r3 == null) goto L16;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.e(r3) == false) goto L16;
    L18:
        if (r3 != null) goto L21;
        return;
    L21:
        if (this.q == false) goto L32;
        o0 r4 = this.n;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "sei");
        if (((Boolean) vm2.d.l.getValue(null, vm2.d.a[10])).booleanValue() == false) goto L36;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r6) == true) goto L36;
        return;
    L36:
        LiveSeiUtil.i.getClass();     // Catch: Throwable -> L29
        r2 = LiveSeiUtil.c(r6);     // Catch: Throwable -> L29
    L30:
        if (r2 == null) goto L39;
        r4.a(r2, 2, r6);
        return;
    L39:
        return;
    L29:
        ALogger.e("SeiStreamInfoCatcher", "to jsonObject fail");
        goto L30
    L32:
        com.bytedance.android.livesdk.ktvimpl.base.sei.m r0 = this.g;
        if (r0 == null) goto L41;
        r0.d(this, r6);
        return;
    L41:
        return;
    L16:
        r3 = null;
        goto L18
    L17:
        r3 = r6;
        goto L18
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void wq(Context r8, KtvControlWidget$usbReceiver$1 r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
