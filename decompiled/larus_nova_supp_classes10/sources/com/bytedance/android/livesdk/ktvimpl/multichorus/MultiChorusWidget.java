package com.bytedance.android.livesdk.ktvimpl.multichorus;

import am2.x;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.model.api.i0;
import com.bytedance.android.live.ktv.common.model.api.j0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.ktvapi.WidgetViewModelProviders;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.widget.HolderRoomScopeWidget;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedChorusCacheSyncMode;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/multichorus/MultiChorusWidget;", "Lcom/bytedance/android/livesdk/ktvapi/util/a;", "Lcom/bytedance/android/livesdk/ktvimpl/base/widget/HolderRoomScopeWidget;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiChorusWidget extends HolderRoomScopeWidget implements com.bytedance.android.livesdk.ktvapi.util.a {
    public static final /* synthetic */ int t = 0;
    public String d;
    public String e;
    public final List<String> f;
    public int g;
    public MultiChorusViewModel h;
    public final CompositeDisposable i;
    public final HashMap<LifecycleOwner, Observer<Integer>> j;
    public boolean k;
    public boolean l;
    public String m;
    public MusicPanel n;
    public long o;
    public long p;
    public boolean q;
    public final Lazy r;
    public final Lazy s;

    public static final class a {
    }

    public static final class b<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Function1 r0 = this.a;
            r0.invoke((Boolean) r2);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ MultiChorusWidget a;

        public c(MultiChorusWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r12) {
            Integer r13 = (Integer) r12;
            MultiChorusWidget r0 = this.a;
            int r1 = MultiChorusWidget.t;
            r0.getClass();
            if (r13 != null) goto L6;
        L11:
            MultiChorusWidget r2 = this.a;
            int r14 = r13.intValue();
            List r3 = (List) ((Widget) r2).dataCenter.get("data_online_changed_list", new ArrayList());
            MultiChorusViewModel r4 = r2.h;
            if (r4 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L14:
            i0 r5 = r4.obtainChorusInfo();
            if (r5 == null) goto L17;
            String r6 = r5.c();
        L18:
            k.n(IMiddlewareUserService.class).user().n().getClass();
            Iterator r7 = r3.iterator();
            String r8 = "";
        L20:
            if (r7.hasNext() == false) goto L30;
            LinkPlayerInfo r9 = (LinkPlayerInfo) r7.next();
            if (r9.getUser() == null) goto L20;
            IBaseUser r10 = r9.getUser();
            Intrinsics.checkNotNull(r10);
            if (Intrinsics.areEqual(r6, r10.getIdString()) == false) goto L20;
            r8 = r9.getInteractId();
            if (r8 != null) goto L29;
            r8 = "";
        L29:
            StringBuilder r11 = new StringBuilder("updateRoleForRtc leadUserName ");
            IBaseUser r15 = r9.getUser();
            Intrinsics.checkNotNull(r15);
            r11.append(r15.getNickName());
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", r11.toString());
            goto L20
        L30:
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", "updateRoleForRtc  role " + r14 + " leadUserInteractId " + r8);
            ei6.a r16 = r2.Z0();
            if (((Boolean) KtvSettingHelper.p0.getValue()).booleanValue() == true) goto L33;
        L38:
            StringBuilder r17 = new StringBuilder("updateRoleForRtc client == null : ");
            if (r16 != null) goto L41;
            boolean r18 = true;
        L42:
            r17.append(r18);
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", r17.toString());
            if (r14 == 0) goto L144;
            if (r14 == 1) goto L129;
            if (r14 != 2) goto L47;
            if (r16 == null) goto L80;
            ri6.b r19 = r16.r();
            if (r19 == null) goto L80;
            if (r19.C() != true) goto L80;
            if (j.i() == true) goto L80;
            k.n(IInteractService.class).updateSelfSilenceStatus(false, null);
            r2.q = true;
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", "unSilenceUserSelfIfNeed ;; success");
        L80:
            if (r16 == null) goto L85;
            ChorusManager r110 = r16.i();
            if (r110 == null) goto L85;
            r110.C();
        L85:
            if (j.i() == false) goto L90;
            if (r16 == null) goto L94;
            ChorusManager r111 = r16.i();
            if (r111 == null) goto L94;
            r111.H(zi6.a.e.a, r8);
        L94:
            KtvContext.Companion.getClass();
            if (KtvContext.a.g().getKtvCoreController().getValue() != null) goto L117;
            n<com.bytedance.android.livesdk.ktvimpl.base.i> r112 = KtvContext.a.g().getKtvCoreController();
            if (j.i() == false) goto L103;
            o r20 = m.j(r2);
            if (r20 == null) goto L108;
            com.bytedance.live.datacontext.j r21 = r20.getLiveStream();
            if (r21 == null) goto L108;
            com.bytedance.android.live.pushstream.d r22 = (com.bytedance.android.live.pushstream.d) r21.getValue();
        L109:
            com.bytedance.android.livesdk.ktvimpl.base.i r23 = new com.bytedance.android.livesdk.ktvimpl.base.i(r22, (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue());
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r24 = KSongTuningPanelHelperKt.d();
            if (r24 == null) goto L112;
            r24.c();
        L112:
            Unit r25 = Unit.INSTANCE;
            r112.setValue(r23);
            if (((com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue()) == null) goto L121;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r113 = KSongTuningPanelHelperKt.d();
            if (r113 == null) goto L121;
            r113.s();
        L121:
            if (((Boolean) vm2.h.t2.getValue(null, vm2.h.a[174(0xae, float:2.44E-43)])).booleanValue() == true) goto L123;
            return;
        L123:
            if (((com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue()) == null) goto L172;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r114 = KSongTuningPanelHelperKt.d();
            if (r114 == null) goto L173;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a.a.b(r114, r114.e(), 6);
            if (((Boolean) KtvSettingHelper.A.getValue()).booleanValue() == false) goto L174;
            r114.G(r114.A());
            return;
        L174:
            return;
        L173:
            return;
        L172:
            return;
        L108:
            r22 = null;
            goto L109
        L103:
            IInteractService r26 = k.f(IInteractService.class);
            if (r26 == null) goto L108;
            rj0.d r27 = r26.getCommonService();
            if (r27 == null) goto L108;
            r22 = r27.getLiveStream();
            goto L109
        L117:
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r115 = KSongTuningPanelHelperKt.d();
            if (r115 == null) goto L121;
            r115.c();
            goto L121
        L90:
            if (r16 == null) goto L94;
            ChorusManager r116 = r16.i();
            if (r116 == null) goto L94;
            r116.z(LiveWrappedChorusCacheSyncMode.CHORUS_CACHE_SYNC_MODE_RETRANSMITTER);
            goto L94
        L47:
            if (r14 == 3) goto L52;
            if (r14 == 4) goto L144;
            return;
        L52:
            if (j.i() == false) goto L57;
            if (r16 == null) goto L61;
            ChorusManager r117 = r16.i();
            if (r117 == null) goto L61;
            r117.H(zi6.a.b.a, r8);
        L61:
            KtvContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.i r118 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
            if (r118 == null) goto L64;
            r118.d();
            com.bytedance.android.livesdk.ktvimpl.base.m.a(1.0f, "recoveryVoiceVolume");
        L64:
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r119 = KSongTuningPanelHelperKt.d();
            if (r119 == null) goto L67;
            r119.C();
        L67:
            r2.Eq(r16, j.i());
            if (r16 == null) goto L168;
            ChorusManager r120 = r16.i();
            if (r120 == null) goto L169;
            r120.z(LiveWrappedChorusCacheSyncMode.CHORUS_CACHE_SYNC_MODE_CONSUMER);
            return;
        L169:
            return;
        L168:
            return;
        L57:
            if (r16 == null) goto L61;
            ChorusManager r121 = r16.i();
            if (r121 == null) goto L61;
            r121.C();
            goto L61
        L129:
            if (r16 == null) goto L134;
            ChorusManager r122 = r16.i();
            if (r122 == null) goto L134;
            r122.C();
        L134:
            if (j.i() == false) goto L139;
            if (r16 == null) goto L176;
            ChorusManager r123 = r16.i();
            if (r123 == null) goto L177;
            r123.H(zi6.a.c.a, r8);
            return;
        L177:
            return;
        L176:
            return;
        L139:
            if (r16 == null) goto L179;
            ChorusManager r124 = r16.i();
            if (r124 == null) goto L180;
            r124.z(LiveWrappedChorusCacheSyncMode.CHORUS_CACHE_SYNC_MODE_PRODUCER);
            return;
        L180:
            return;
        L179:
            return;
        L144:
            if (j.i() == false) goto L149;
            if (r16 == null) goto L149;
            ChorusManager r125 = r16.i();
            if (r125 == null) goto L149;
            r125.H(zi6.a.d.a, r8);
        L149:
            KtvContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.i r126 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
            if (r126 == null) goto L152;
            r126.d();
            com.bytedance.android.livesdk.ktvimpl.base.m.a(1.0f, "recoveryVoiceVolume");
        L152:
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r127 = KSongTuningPanelHelperKt.d();
            if (r127 == null) goto L155;
            r127.C();
        L155:
            r2.Eq(r16, false);
            if (r16 == null) goto L182;
            ChorusManager r128 = r16.i();
            if (r128 == null) goto L183;
            r128.C();
            return;
        L183:
            return;
        L182:
            return;
        L41:
            r18 = false;
            goto L42
        L33:
            if (MultiChorusContext.Companion.c() == false) goto L38;
            if (r16 == null) goto L38;
            ri6.b r28 = r16.r();
            if (r28 == null) goto L38;
            r28.y(true);
            goto L38
        L17:
            r6 = null;
            goto L18
        L6:
            if (r13.intValue() != 2) goto L11;
            MultiChorusViewModel r29 = r0.h;
            if (r29 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L10:
            r29.showStartMultiChorusToast();
            goto L11
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ MultiChorusWidget a;

        public d(MultiChorusWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r15) {
            i0 r16 = (i0) r15;
            MultiChorusWidget r0 = this.a;
            int r1 = MultiChorusWidget.t;
            List r2 = (List) ((Widget) r0).dataCenter.get("data_online_changed_list", new ArrayList());
            if (r16 == null) goto L5;
            List r3 = j0.a(r16);
        L6:
            String r4 = k.n(IMiddlewareUserService.class).user().n().toString();
            ei6.a r5 = r0.Z0();
            if (r16 == null) goto L9;
            Object r17 = r16.c();
        L10:
            StringBuilder r6 = new StringBuilder("updateMuteStatus client == null : ");
            if (r5 != null) goto L13;
            boolean r8 = true;
        L14:
            r6.append(r8);
            r6.append("  curRole ：");
            MultiChorusViewModel r9 = r0.h;
            if (r9 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L17:
            r6.append(r9.getCurrentUserChorusRole());
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", r6.toString());
            Iterator r7 = r2.iterator();
        L19:
            if (r7.hasNext() == false) goto L64;
            LinkPlayerInfo r10 = (LinkPlayerInfo) r7.next();
            if (r10.getUser() == null) goto L19;
            IBaseUser r11 = r10.getUser();
            Intrinsics.checkNotNull(r11);
            if (Intrinsics.areEqual(r4, r11.getIdString()) == true) goto L19;
            IBaseUser r12 = r10.getUser();
            Intrinsics.checkNotNull(r12);
            if (r3.contains(r12.getIdString()) == true) goto L27;
            IBaseUser r13 = r10.getUser();
            Intrinsics.checkNotNull(r13);
            if (Intrinsics.areEqual(r13.getIdString(), r17) == false) goto L59;
            MultiChorusViewModel r14 = r0.h;
            if (r14 != null) goto L53;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L53:
            if (r14.getCurrentUserChorusRole() != 3) goto L59;
            StringBuilder r18 = new StringBuilder("updateMuteStatus mute LeadSinger : ");
            IBaseUser r19 = r10.getUser();
            Intrinsics.checkNotNull(r19);
            r18.append(r19.getNickName());
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", r18.toString());
            if (r5 == null) goto L19;
            ri6.b r110 = r5.r();
            if (r110 == null) goto L19;
            r110.D(bj6.a.b(r5), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, String.valueOf(r10.getInteractId()), 0);
        L59:
            StringBuilder r111 = new StringBuilder("updateMuteStatus unMute online guest : ");
            IBaseUser r112 = r10.getUser();
            Intrinsics.checkNotNull(r112);
            r111.append(r112.getNickName());
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", r111.toString());
            if (r5 == null) goto L19;
            ri6.b r113 = r5.r();
            if (r113 == null) goto L19;
            r113.D(bj6.a.b(r5), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, String.valueOf(r10.getInteractId()), 100);
            goto L19
        L27:
            MultiChorusViewModel r114 = r0.h;
            if (r114 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L31:
            if (r114.getCurrentUserChorusRole() == 2) goto L42;
            MultiChorusViewModel r115 = r0.h;
            if (r115 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L36:
            if (r115.getCurrentUserChorusRole() == 1) goto L42;
            MultiChorusViewModel r116 = r0.h;
            if (r116 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L41:
            if (r116.getCurrentUserChorusRole() != 3) goto L19;
        L42:
            StringBuilder r117 = new StringBuilder("updateMuteStatus mute viceSinger : ");
            IBaseUser r118 = r10.getUser();
            Intrinsics.checkNotNull(r118);
            r117.append(r118.getNickName());
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", r117.toString());
            if (r5 == null) goto L19;
            ri6.b r119 = r5.r();
            if (r119 == null) goto L19;
            r119.D(bj6.a.b(r5), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, String.valueOf(r10.getInteractId()), 0);
            goto L19
        L64:
            return;
        L13:
            r8 = false;
            goto L14
        L9:
            r17 = 0L;
            goto L10
        L5:
            r3 = new ArrayList();
            goto L6
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ MultiChorusWidget a;

        public e(MultiChorusWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            List r7 = (List) r6;
            int r0 = 0;
            if (r7 == null) goto L5;
            int r1 = r7.size();
        L7:
            if (r1 > 1) goto L9;
            MultiChorusWidget r3 = this.a;
            r3.g = 0;
            ((ArrayList) r3.f).clear();
        L9:
            MultiChorusContext.a r4 = MultiChorusContext.Companion;
            MultiChorusContext r5 = r4.getContext();
            if (r5 == null) goto L12;
            r0 = r5.getOneSongAccumulatorMultiChorusUserCount();
        L12:
            if (r1 <= r0) goto L16;
            MultiChorusContext r2 = r4.getContext();
            if (r2 == null) goto L16;
            r2.setOneSongAccumulatorMultiChorusUserCount(r1);
        L16:
            MultiChorusWidget r8 = this.a;
            int r9 = r8.g;
            String r10 = null;
            if (r9 >= r1) goto L36;
            r8.g = r1;
            ArrayList r11 = new ArrayList();
            if (r7 == null) goto L26;
            Iterator<T> r12 = r7.iterator();
        L22:
            if (r12.hasNext() == false) goto L26;
            String r13 = ((jd2.e) r12.next()).a;
            if (r13 == null) goto L22;
            r11.add(r13);
        L26:
            ArrayList r14 = new ArrayList();
            r14.addAll(this.a.f);
            r11.removeAll(r14);
            IMiddlewareUserService r15 = k.f(IMiddlewareUserService.class);
            if (r15 == null) goto L34;
            com.bytedance.android.livesdk.user.e r16 = r15.user();
            if (r16 == null) goto L34;
            String r17 = r16.n();
            if (r17 == null) goto L34;
            r10 = r17;
        L34:
            if (CollectionsKt.contains(r11, r10) == false) goto L55;
            MultiChorusWidget.wq(this.a, com.bytedance.android.livesdk.ktvimpl.multichorus.c.e(), true);
        L55:
            ((ArrayList) this.a.f).clear();
            if (r7 == null) goto L63;
            Iterator<T> r18 = r7.iterator();
        L59:
            if (r18.hasNext() == false) goto L63;
            String r19 = ((jd2.e) r18.next()).a;
            if (r19 == null) goto L59;
            ((ArrayList) this.a.f).add(r19);
        L63:
            MultiChorusWidget r20 = this.a;
            if (r20.g > 1) goto L82;
            r20.Bq(r20.n);
            return;
        L82:
            return;
        L36:
            if (r9 <= r1) goto L55;
            r8.g = r1;
            ArrayList r21 = new ArrayList();
            if (r7 == null) goto L45;
            Iterator<T> r22 = r7.iterator();
        L41:
            if (r22.hasNext() == false) goto L45;
            String r23 = ((jd2.e) r22.next()).a;
            if (r23 == null) goto L41;
            r21.add(r23);
        L45:
            ArrayList r24 = new ArrayList();
            r24.addAll(this.a.f);
            r24.removeAll(r21);
            IMiddlewareUserService r25 = k.f(IMiddlewareUserService.class);
            if (r25 == null) goto L53;
            com.bytedance.android.livesdk.user.e r26 = r25.user();
            if (r26 == null) goto L53;
            String r27 = r26.n();
            if (r27 == null) goto L53;
            r10 = r27;
        L53:
            if (CollectionsKt.contains(r24, r10) == false) goto L55;
            MultiChorusWidget r28 = this.a;
            r28.Bq(r28.n);
            goto L55
        L5:
            r1 = 0;
            goto L7
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ MultiChorusWidget a;

        public f(MultiChorusWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            boolean r1 = true;
            if (((Boolean) r10).booleanValue() == true) goto L50;
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", "MultiChorus closed");
            MultiChorusViewModel r11 = this.a.h;
            if (r11 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L7:
            r11.clearDataByClose();
            this.a.getClass();
            if (k.n(IInteractService.class).isAudienceLinkEngineOn() == false) goto L10;
        L13:
            boolean r12 = true;
        L14:
            if (r12 == false) goto L43;
            MultiChorusViewModel r13 = this.a.h;
            if (r13 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L18:
            r13.updateRole(4);
            MultiChorusWidget r14 = this.a;
            List r4 = (List) ((Widget) r14).dataCenter.get("data_online_changed_list", new ArrayList());
            ei6.a r5 = r14.Z0();
            String r6 = k.n(IMiddlewareUserService.class).user().n().toString();
            StringBuilder r7 = new StringBuilder("unMuteAllByClose client == null : ");
            if (r5 == null) goto L22;
            r1 = false;
        L22:
            r7.append(r1);
            r7.append("  curRole ：");
            MultiChorusViewModel r15 = r14.h;
            if (r15 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L25:
            r7.append(r15.getCurrentUserChorusRole());
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", r7.toString());
            Iterator r16 = r4.iterator();
        L27:
            if (r16.hasNext() == false) goto L43;
            LinkPlayerInfo r0 = (LinkPlayerInfo) r16.next();
            if (r0.getUser() == null) goto L27;
            IBaseUser r2 = r0.getUser();
            if (r2 == null) goto L33;
            String r3 = r2.getIdString();
        L35:
            if (Intrinsics.areEqual(r6, r3) == true) goto L27;
            StringBuilder r8 = new StringBuilder("unMuteAllByClose unMute online guest : ");
            IBaseUser r9 = r0.getUser();
            Intrinsics.checkNotNull(r9);
            r8.append(r9.getNickName());
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", r8.toString());
            if (r5 == null) goto L27;
            ri6.b r17 = r5.r();
            if (r17 == null) goto L27;
            r17.D(bj6.a.b(r5), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, String.valueOf(r0.getInteractId()), 100);
            goto L27
        L33:
            r3 = null;
        L43:
            if (((Boolean) KtvSettingHelper.p0.getValue()).booleanValue() == false) goto L49;
            ei6.a r18 = this.a.Z0();
            if (r18 == null) goto L49;
            ri6.b r19 = r18.r();
            if (r19 == null) goto L49;
            r19.y(false);
        L49:
            this.a.Cq();
        L60:
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r110 = KSongTuningPanelHelperKt.d();
            if (r110 == null) goto L75;
            r110.m(r110.e(), false, false);
            return;
        L75:
            return;
        L10:
            if (j.i() == true) goto L13;
            r12 = false;
            goto L14
        L50:
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", "MultiChorus opened");
            MultiChorusViewModel r111 = this.a.h;
            if (r111 != null) goto L53;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L53:
            r111.updateSongInfo();
            if (((Boolean) KtvSettingHelper.p0.getValue()).booleanValue() == false) goto L60;
            ei6.a r112 = this.a.Z0();
            if (r112 == null) goto L60;
            ri6.b r113 = r112.r();
            if (r113 == null) goto L60;
            r113.y(true);
            goto L60
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ MultiChorusWidget a;

        public g(MultiChorusWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            List r5 = (List) r4;
            if (ChorusContext.Companion.c() == true) goto L21;
            MultiChorusViewModel r0 = this.a.h;
            if (r0 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L8:
            if (r5 == null) goto L10;
            int r2 = r5.size();
        L11:
            r0.onSongListChanged(r2);
            List r6 = r5;
            if (r6 != null) goto L14;
        L17:
            boolean r7 = true;
        L18:
            if (r7 == false) goto L22;
            MultiChorusWidget r8 = this.a;
            r8.Eq(r8.Z0(), false);
            return;
        L22:
            return;
        L14:
            if (r6.isEmpty() == true) goto L17;
            r7 = false;
            goto L18
        L10:
            r2 = 0;
            goto L11
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ MultiChorusWidget a;

        public h(MultiChorusWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((com.bytedance.android.livesdk.chatroom.viewmodel.j) r2).a != 0) goto L9;
            MultiChorusViewModel r3 = this.a.h;
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L7:
            r3.clearDataByCloseTalkRoom();
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ MultiChorusWidget a;

        public i(MultiChorusWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            MultiChorusContext.Companion.getClass();
            if (MultiChorusContext.a.d() == false) goto L6;
            com.bytedance.android.livesdk.ktvimpl.multichorus.c.g(((Widget) this.a).context, false, 6);
            return;
        }
    }

    static {
    }

    public final List<jd2.e> Sh() {
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return r0.obtainMultiChorusUserList();
    }

    public final ei6.a Z0() {
        return k.n(IInteractService.class).getRtcClient(Boolean.valueOf(j.i()));
    }

    public final jd2.d Ze() {
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return r0.obtainMultiChorusData();
    }

    public final com.bytedance.android.livesdk.ktvapi.util.e bj() {
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return r0.obtainMusicJoinStatus();
    }

    public final int i0() {
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L6:
        return r0.getCurrentUserChorusRole();
    }

    public final oe2.b yq() {
        KtvContext.Companion.getClass();
        return (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
    }

    public MultiChorusWidget() {
        this.d = BDLocationException.ERROR_TIMEOUT;
        this.e = BDLocationException.ERROR_TIMEOUT;
        this.f = new ArrayList();
        this.i = new CompositeDisposable();
        this.j = new HashMap();
        this.m = BDLocationException.ERROR_TIMEOUT;
        this.r = LazyKt.lazy(new MultiChorusWidget$mKtvCoreListener$2(this));
        this.s = LazyKt.lazy(new MultiChorusWidget$linkPlayerStateObserver$2(this));
    }

    public final void Cq() {
        if (j.i() == false) goto L17;
        ei6.a r0 = Z0();
        if (r0 != null) goto L12;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.T0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.a.a();
        if (r1 == null) goto L11;
        hg6.g r2 = r1.rtcManger();
        if (r2 == null) goto L11;
        r0 = r2.V0();
    L11:
        r0 = null;
    L12:
        if (r0 == null) goto L18;
        ChorusManager r3 = r0.i();
        if (r3 == null) goto L19;
        r3.H(zi6.a.d.a, "");
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        WidgetViewModelProviders r0 = WidgetViewModelProviders.a;
        MultiChorusViewModelFactory r1 = new MultiChorusViewModelFactory(getContext(), ((Widget) this).dataCenter);
        r0.getClass();
        MultiChorusViewModel r2 = (MultiChorusViewModel) WidgetViewModelProviders.a(this, r1).get(MultiChorusViewModel.class);
        this.h = r2;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r2.observerCurUserMultiChorusRole(this, new c(this));
        MultiChorusViewModel r3 = this.h;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L8:
        r3.observeChorusInfo(this, new d(this));
        Pair r4 = com.bytedance.live.datacontext.d.a(MultiChorusWidget$initDataContext$pair$1.INSTANCE);
        MultiChorusContext r5 = (MultiChorusContext) r4.getFirst();
        r5.m441getService().d(this);
        com.bytedance.live.datacontext.b.a(r5, MultiChorusContext.class);
        this.i.add((Disposable) r4.getSecond());
        zq(MultiChorusWidget$setupChorusSwitchListeners$1.INSTANCE, new MultiChorusWidget$setupChorusSwitchListeners$2(this));
        zq(MultiChorusWidget$setupChorusSwitchListeners$3.INSTANCE, new MultiChorusWidget$setupChorusSwitchListeners$4(this));
        zq(MultiChorusWidget$setupChorusSwitchListeners$5.INSTANCE, new MultiChorusWidget$setupChorusSwitchListeners$6(this));
        Iterator<Map.Entry<LifecycleOwner, Observer<Integer>>> r6 = this.j.entrySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L15;
        Map.Entry<LifecycleOwner, Observer<Integer>> r7 = r6.next();
        MultiChorusViewModel r8 = this.h;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L14:
        r8.observerCurUserMultiChorusRole(r7.getKey(), r7.getValue());
        goto L10
    L15:
        this.j.clear();
        this.k = true;
        MultiChorusContext.a r9 = MultiChorusContext.Companion;
        r9.h(this, new e(this));
        MultiChorusContext r10 = r9.getContext();
        if (r10 == null) goto L42;
        jd2.d r11 = r9.j();
        if (r11 == null) goto L20;
        Long r12 = r11.c;
    L21:
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r13 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r13 == null) goto L30;
        KtvRoomLyricsStateMachineConfig.d r14 = r13.getCurState();
        if (r14 == null) goto L30;
        MusicPanel r15 = r14.b();
        if (r15 == null) goto L30;
        KtvMusic r16 = r15.a;
        if (r16 == null) goto L30;
        Long r17 = Long.valueOf(r16.getMId());
    L31:
        boolean r18 = Intrinsics.areEqual(r12, r17);
        int r19 = 0;
        if (r18 == false) goto L41;
        List<jd2.e> r20 = r9.k();
        if (r20 == null) goto L36;
        int r21 = r20.size();
    L37:
        if (r21 <= 0) goto L41;
        List<jd2.e> r22 = r9.k();
        if (r22 == null) goto L41;
        r19 = r22.size();
        goto L41
    L36:
        r21 = 0;
    L41:
        r10.setOneSongAccumulatorMultiChorusUserCount(r19);
    L30:
        r17 = null;
        goto L31
    L20:
        r12 = null;
    L42:
        hd0.c.f().c((com.bytedance.android.livesdk.app.dataholder.Observer) this.s.getValue());
        Disposable r23 = r9.g(new f(this));
        if (r23 == null) goto L45;
        RxUtilKt.c(r23, this.i);
    L45:
        KtvComponentOrderedSongDataContext r24 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r24 == null) goto L50;
        Disposable r25 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r24, null, new g(this), 3);
        if (r25 == null) goto L50;
        RxUtilKt.c(r25, this.i);
    L50:
        u r26 = m.e(this);
        if (r26 == null) goto L61;
        com.bytedance.live.datacontext.j r27 = r26.getVideoTalkRoomSubScene();
        if (r27 == null) goto L61;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r28 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r27.getValue();
        if (r28 == null) goto L61;
        BehaviorSubject r29 = r28.a();
        if (r29 == null) goto L61;
        Disposable r30 = r29.subscribe(new h(this));
        if (r30 == null) goto L61;
        RxUtilKt.c(r30, this.i);
    L61:
        KtvContext.Companion.getClass();
        Disposable r31 = KtvContext.observerCurrentUserIsSinger$default(KtvContext.a.g(), null, false, new i(this), 3, null);
        if (r31 == null) goto L68;
        RxUtilKt.c(r31, this.i);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        Cq();
        hd0.c.f().e((com.bytedance.android.livesdk.app.dataholder.Observer) this.s.getValue());
        Bq(this.n);
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r0 == null) goto L5;
        r0.unregisterKtvCoreListener((MultiChorusWidget$mKtvCoreListener$2.a) this.r.getValue());
    L5:
        this.i.dispose();
        this.j.clear();
    }

    public final void Bq(MusicPanel r37) {
        if (r37 == null) goto L6;
        String r1 = r37.d;
        if (r1 == null) goto L6;
    L7:
        com.bytedance.android.livesdk.log.filter.o r2 = com.bytedance.android.livesdk.log.j0.l().c(x.class);
        if ((r2 instanceof t) == true) goto L10;
        r2 = null;
    L10:
        t r3 = (t) r2;
        if (r3 == null) goto L15;
        Map<String, String> r4 = r3.getMap();
        if (r4 == null) goto L15;
        String r5 = r4.get("enter_from_merge");
    L17:
        if (Intrinsics.areEqual(r5, "single_song") == false) goto L44;
        com.bytedance.android.livesdk.log.filter.o r6 = com.bytedance.android.livesdk.log.j0.l().c(x.class);
        if ((r6 instanceof t) == true) goto L21;
        r6 = null;
    L21:
        t r7 = (t) r6;
        if (r7 == null) goto L26;
        Map<String, String> r8 = r7.getMap();
        if (r8 == null) goto L26;
        String r9 = r8.get("enter_method");
    L28:
        if (Intrinsics.areEqual(r9, "song") == false) goto L44;
        if (r37 == null) goto L33;
        KtvMusic r10 = r37.a;
        if (r10 == null) goto L33;
        Long r11 = Long.valueOf(r10.getMId());
    L34:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r12 = KtvRoomContext.a.a();
        if (r12 == null) goto L39;
        com.bytedance.live.datacontext.m<Long> r13 = r12.getRelevantLiveSongId();
        if (r13 == null) goto L39;
        Long r14 = (Long) r13.getValue();
    L41:
        if (Intrinsics.areEqual(r11, r14) == false) goto L44;
        r1 = "from_detail_pop_music";
    L39:
        r14 = null;
    L33:
        r11 = null;
    L26:
        r9 = null;
    L44:
        if (this.l == false) goto L175;
        this.l = false;
        long r15 = this.o + (System.currentTimeMillis() - this.p);
        this.o = r15;
        String r16 = this.m;
        String r17 = String.valueOf(r15 / 1000);
        String r18 = this.d;
        String r19 = this.e;
        Intrinsics.checkNotNullParameter(r16, "chorusTime");
        Intrinsics.checkNotNullParameter(r17, "chorusDuration");
        Intrinsics.checkNotNullParameter(r1, "fromRequestType");
        Intrinsics.checkNotNullParameter(r18, "userChorusId");
        Intrinsics.checkNotNullParameter(r19, "chorusLeadId");
        if (r37 == null) goto L52;
        LinkedHashMap r110 = new LinkedHashMap();
        r110.put("user_chorus_id", r18);
        r110.put("from_request_type", r1);
        r110.put("chorus_time", r16);
        r110.put("chorus_lead_id", r19);
        r110.put("chorus_duration", r17);
        int r20 = ke2.b.a;
        ke2.b.j(r110);
        Long r21 = KtvLoggerHelper.a;
        r110.put("play_mode", KtvLoggerHelper.E());
        r110.put("function_type2", k.n(IInteractService.class).getFunctionTypeForLog());
        ke2.b.p(r110);
        r110.put("song_id", String.valueOf(r37.a.getMId()));
        String r22 = r37.a.getMTitle();
        if (r22 != null) goto L51;
        r22 = "";
    L51:
        r110.put("song_name", r22);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_ksong_play_chorus_duration", r110, new Object[]{IRoom.class, x.class});
    L52:
        if (r37 == null) goto L56;
        KtvMusic r23 = r37.a;
        if (r23 == null) goto L56;
        String r24 = com.bytedance.android.live.ktv.common.util.a.b(r23);
    L58:
        if (r24.length() != 0) goto L60;
        boolean r25 = true;
    L61:
        if (r25 == false) goto L63;
        HashMap r111 = null;
    L64:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r26 = KSongTuningPanelHelperKt.d();
        if ((r26 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L67;
        r26 = null;
    L67:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r27 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r26;
        if (r27 == null) goto L70;
        Boolean r28 = r27.J();
    L71:
        boolean r112 = Intrinsics.areEqual(r28, Boolean.TRUE);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r29 = KSongTuningPanelHelperKt.d();
        if (r29 == null) goto L74;
        r29.b();
    L74:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r30 = KSongTuningPanelHelperKt.d();
        if (r30 == null) goto L77;
        r30.P();
    L77:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r31 = KSongTuningPanelHelperKt.d();
        if (r31 == null) goto L80;
        r31.P();
    L80:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r32 = KSongTuningPanelHelperKt.d();
        if (r32 == null) goto L83;
        r32.b();
    L83:
        Long r33 = KtvLoggerHelper.a;
        if (r37 == null) goto L88;
        KtvMusic r34 = r37.a;
        if (r34 == null) goto L88;
        long r35 = r34.getMId();
    L89:
        long r36 = this.o / 1000;
        String r38 = j.g();
        if (r37 == null) goto L95;
        KtvMusic r39 = r37.a;
        if (r39 == null) goto L95;
        String r40 = r39.getMTitle();
        if (r40 == null) goto L95;
    L96:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r113 = KSongTuningPanelHelperKt.d();
        if ((r113 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L99;
        r113 = null;
    L99:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r114 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r113;
        if (r114 == null) goto L102;
        boolean r115 = r114.d0();
    L103:
        if (r37 == null) goto L108;
        String r41 = r37.b();
        if (r41 == null) goto L108;
        String r210 = r41;
    L109:
        if (r37 == null) goto L116;
        KtvMusic r42 = r37.a;
        if (r42 == null) goto L116;
        String r43 = r42.getMAuthor();
        if (r43 == null) goto L116;
        String r211 = r43;
    L117:
        oe2.b r44 = yq();
        if (r44 == null) goto L120;
        String r212 = r44.getEnterFrom();
    L121:
        if (r37 == null) goto L127;
        KtvMusic r45 = r37.a;
        if (r45 == null) goto L127;
        List r46 = r45.getTags();
        if (r46 == null) goto L127;
        boolean r213 = r46.contains("原唱");
    L128:
        oe2.b r47 = yq();
        if (r47 == null) goto L131;
        String r214 = r47.c();
    L132:
        oe2.b r48 = yq();
        if (r48 == null) goto L135;
        String r310 = r48.a();
    L136:
        if (r37 == null) goto L146;
        KtvMusic r49 = r37.a;
        if (r49 == null) goto L146;
        String r50 = r49.getMidiUrl();
        if (r50 == null) goto L146;
        if (r50.length() <= 0) goto L144;
        boolean r51 = true;
    L145:
        Boolean r311 = Boolean.valueOf(r51);
    L147:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r52 = KtvRoomContext.a.a();
        if (r52 == null) goto L154;
        n<Float> r53 = r52.getReportMidiScore();
        if (r53 == null) goto L154;
        Float r54 = (Float) r53.getValue();
        if (r54 == null) goto L154;
        Integer r312 = Integer.valueOf((int) r54.floatValue());
    L155:
        if (r37 != null) goto L157;
    L159:
        boolean r313 = false;
    L160:
        KtvComponentContext r55 = KtvComponentContext.Companion.getContext();
        if (r55 == null) goto L169;
        n<KtvComponentUIContext> r56 = r55.getKtvComponentUIContext();
        if (r56 == null) goto L169;
        KtvComponentUIContext r57 = (KtvComponentUIContext) r56.getValue();
        if (r57 == null) goto L169;
        MutableLiveData<Boolean> r58 = r57.getScoreOpen();
        if (r58 == null) goto L169;
        Boolean r314 = (Boolean) r58.getValue();
    L170:
        if (r37 == null) goto L172;
        Boolean r315 = r37.A;
    L173:
        KtvLoggerHelper.a0(r1, r35, r36, r38, r40, false, "normal", r115, r210, r211, r111, r112 ? 1 : 0, "", false, r212, r213, r214, r310, r311, r312, r313, r314, r315, r37, null, null);
        this.d = BDLocationException.ERROR_TIMEOUT;
        this.e = BDLocationException.ERROR_TIMEOUT;
        this.m = BDLocationException.ERROR_TIMEOUT;
        this.n = null;
        this.o = 0;
        this.p = 0;
        return;
    L172:
        r315 = null;
    L169:
        r314 = null;
        goto L170
    L157:
        if (r37.t != true) goto L159;
        r313 = true;
    L154:
        r312 = null;
        goto L155
    L144:
        r51 = false;
    L146:
        r311 = null;
        goto L147
    L135:
        r310 = null;
        goto L136
    L131:
        r214 = null;
    L127:
        r213 = false;
        goto L128
    L120:
        r212 = null;
    L116:
        r211 = "";
    L108:
        r210 = "";
        goto L109
    L102:
        r115 = false;
    L95:
        r40 = "";
    L88:
        r35 = 0;
        goto L89
    L70:
        r28 = null;
        goto L71
    L63:
        r111 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("song_type", r24)});
        goto L64
    L60:
        r25 = false;
    L56:
        r24 = "";
        goto L58
    L175:
        return;
    L15:
        r5 = null;
    L6:
        r1 = "";
        goto L7
    }

    public final void cancelApply(h80.a<Boolean> r3) {
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.cancelApply(r3);
    }

    public final void z9(h80.a<Boolean> r3) {
        if (k.n(IInteractService.class).getCurrentScene() != 0) goto L14;
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L8:
        if (r0.getApplied() == false) goto L15;
        MultiChorusViewModel r1 = this.h;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L12:
        r1.getCurrentKtvStrategy().cancelApply(r3);
        return;
    L15:
        return;
    }

    public final void Aq(LifecycleOwner r3, Observer<Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (this.k == false) goto L8;
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L7:
        r0.observerCurUserMultiChorusRole(r3, r4);
        return;
    L8:
        this.j.put(r3, r4);
    }

    public final void Eq(ei6.a r2, boolean r3) {
        if (r3 == false) goto L5;
        return;
    L5:
        if (this.q == false) goto L13;
        if (r2 == null) goto L14;
        ri6.b r4 = r2.r();
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.C() == true) goto L16;
        k.n(IInteractService.class).updateSelfSilenceStatus(true, null);
        this.q = false;
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("MultiChorusWidget", "silenceUserSelfIfNeed ;; success");
        return;
    L16:
        return;
    L14:
        return;
    }

    public final void Gd(LifecycleOwner r3, Observer<com.bytedance.android.livesdk.ktvapi.util.e> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.observeMusicJoinStatus(r3, r4);
    }

    public final void r9(LifecycleOwner r3, Observer<List<jd2.e>> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.observeMultiChorusUserList(r3, r4);
    }

    public final void zq(KProperty1<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d, Boolean> r3, Function1<? super Boolean, Unit> r4) {
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
        if (r0 == null) goto L6;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r0, this, r3, new b(r4));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void wq(MultiChorusWidget r26, MusicPanel r27, boolean r28) {
        r26.getClass();
        if (hd0.c.f().h() == false) goto L246;
        MultiChorusContext.a r1 = MultiChorusContext.Companion;
        List<jd2.e> r2 = r1.k();
        if (r2 == null) goto L7;
        int r3 = r2.size();
    L9:
        if (r3 <= 1) goto L247;
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r4 == null) goto L13;
        KtvRoomLyricsStateMachineConfig.d r5 = r4.getCurState();
    L15:
        if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L248;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r6 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r6 == null) goto L19;
        KtvRoomLyricsStateMachineConfig.d r7 = r6.getCurState();
    L21:
        if ((r7 instanceof KtvRoomLyricsStateMachineConfig.d.a) == true) goto L249;
        MusicPanel r8 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
        if (r8 == null) goto L27;
        KtvMusic r9 = r8.a;
        if (r9 == null) goto L27;
        Long r10 = Long.valueOf(r9.getMId());
    L28:
        if (r27 == null) goto L32;
        KtvMusic r11 = r27.a;
        if (r11 == null) goto L32;
        Long r12 = Long.valueOf(r11.getMId());
    L34:
        if (Intrinsics.areEqual(r10, r12) == true) goto L36;
        return;
    L36:
        if (r27 == null) goto L39;
        String r13 = r27.d;
        if (r13 == null) goto L39;
    L40:
        com.bytedance.android.livesdk.log.filter.o r14 = com.bytedance.android.livesdk.log.j0.l().c(x.class);
        if ((r14 instanceof t) == true) goto L43;
        r14 = null;
    L43:
        t r15 = (t) r14;
        if (r15 == null) goto L48;
        Map<String, String> r16 = r15.getMap();
        if (r16 == null) goto L48;
        String r17 = r16.get("enter_from_merge");
    L50:
        if (Intrinsics.areEqual(r17, "single_song") == false) goto L77;
        com.bytedance.android.livesdk.log.filter.o r18 = com.bytedance.android.livesdk.log.j0.l().c(x.class);
        if ((r18 instanceof t) == true) goto L54;
        r18 = null;
    L54:
        t r19 = (t) r18;
        if (r19 == null) goto L59;
        Map<String, String> r20 = r19.getMap();
        if (r20 == null) goto L59;
        String r21 = r20.get("enter_method");
    L61:
        if (Intrinsics.areEqual(r21, "song") == false) goto L77;
        if (r27 == null) goto L66;
        KtvMusic r22 = r27.a;
        if (r22 == null) goto L66;
        Long r23 = Long.valueOf(r22.getMId());
    L67:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r110 = KtvRoomContext.a.a();
        if (r110 == null) goto L72;
        com.bytedance.live.datacontext.m<Long> r111 = r110.getRelevantLiveSongId();
        if (r111 == null) goto L72;
        Long r112 = (Long) r111.getValue();
    L74:
        if (Intrinsics.areEqual(r23, r112) == false) goto L77;
        r13 = "from_detail_pop_music";
    L72:
        r112 = null;
    L66:
        r23 = null;
    L59:
        r21 = null;
    L77:
        if (r26.l == false) goto L79;
        if (r28 == true) goto L79;
        return;
    L79:
        r26.l = true;
        r26.n = r27;
        r26.p = System.currentTimeMillis();
        r26.m = String.valueOf(com.bytedance.android.livesdk.ktvimpl.multichorus.c.c() / 1000);
        jd2.d r24 = r1.j();
        String r113 = BDLocationException.ERROR_TIMEOUT;
        if (r24 != null) goto L82;
    L86:
        String r25 = BDLocationException.ERROR_TIMEOUT;
    L87:
        r26.e = r25;
        jd2.d r29 = r1.j();
        if (r29 == null) goto L91;
        String r30 = r29.d;
        if (r30 == null) goto L91;
    L92:
        r26.d = r30;
        String r31 = r26.m;
        Intrinsics.checkNotNullParameter(r13, "fromRequestType");
        Intrinsics.checkNotNullParameter(r31, "chorusTime");
        if (r27 == null) goto L113;
        LinkedHashMap r114 = new LinkedHashMap();
        jd2.d r32 = r1.j();
        if (r32 == null) goto L100;
        String r33 = r32.d;
        if (r33 == null) goto L100;
    L101:
        r114.put("user_chorus_id", r33);
        r114.put("from_request_type", r13);
        r114.put("chorus_time", r31);
        jd2.d r34 = r1.j();
        if (r34 != null) goto L104;
    L109:
        r114.put("chorus_lead_id", r113);
        int r35 = ke2.b.a;
        ke2.b.j(r114);
        Long r36 = KtvLoggerHelper.a;
        r114.put("play_mode", KtvLoggerHelper.E());
        r114.put("function_type2", k.n(IInteractService.class).getFunctionTypeForLog());
        ke2.b.p(r114);
        r114.put("song_id", String.valueOf(r27.a.getMId()));
        String r37 = r27.a.getMTitle();
        if (r37 != null) goto L112;
        r37 = "";
    L112:
        r114.put("song_name", r37);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_ksong_chorus_play", r114, new Object[]{IRoom.class, x.class});
        goto L113
    L104:
        if (r2.a(r34.e) == false) goto L106;
        String r38 = r34.e;
    L107:
        if (r38 == null) goto L109;
        r113 = r38;
        goto L109
    L106:
        r38 = String.valueOf(r34.b);
    L100:
        r33 = BDLocationException.ERROR_TIMEOUT;
    L113:
        if (r27 == null) goto L117;
        KtvMusic r39 = r27.a;
        if (r39 == null) goto L117;
        String r40 = com.bytedance.android.live.ktv.common.util.a.b(r39);
    L118:
        if (r40 != null) goto L120;
        int r41 = 1;
    L126:
        Pair[] r42 = new Pair[r41];
        if (r40 != null) goto L129;
        r40 = "";
    L129:
        r42[0] = TuplesKt.to("song_type", r40);
        HashMap r43 = MapsKt.hashMapOf(r42);
        int r44 = r41;
    L130:
        com.bytedance.android.livesdk.log.filter.o r45 = com.bytedance.android.livesdk.log.j0.l().c(x.class);
        if ((r45 instanceof t) == true) goto L133;
        r45 = null;
    L133:
        t r46 = (t) r45;
        if (r46 == null) goto L138;
        Map<String, String> r47 = r46.getMap();
        if (r47 == null) goto L138;
        String r48 = r47.get("enter_from_merge");
    L140:
        if (Intrinsics.areEqual(r48, "single_song") == false) goto L166;
        com.bytedance.android.livesdk.log.filter.o r49 = com.bytedance.android.livesdk.log.j0.l().c(x.class);
        if ((r49 instanceof t) == true) goto L144;
        r49 = null;
    L144:
        t r50 = (t) r49;
        if (r50 == null) goto L149;
        Map<String, String> r51 = r50.getMap();
        if (r51 == null) goto L149;
        String r52 = r51.get("enter_method");
    L151:
        if (Intrinsics.areEqual(r52, "song") == false) goto L166;
        if (r27 == null) goto L156;
        KtvMusic r53 = r27.a;
        if (r53 == null) goto L156;
        Long r54 = Long.valueOf(r53.getMId());
    L157:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r55 = KtvRoomContext.a.a();
        if (r55 == null) goto L162;
        com.bytedance.live.datacontext.m<Long> r56 = r55.getRelevantLiveSongId();
        if (r56 == null) goto L162;
        Long r57 = (Long) r56.getValue();
    L164:
        if (Intrinsics.areEqual(r54, r57) == false) goto L166;
        r13 = "from_detail_pop_music";
    L162:
        r57 = null;
    L156:
        r54 = null;
    L149:
        r52 = null;
    L166:
        Long r58 = KtvLoggerHelper.a;
        String r59 = j.g();
        if (r27 == null) goto L172;
        KtvMusic r60 = r27.a;
        if (r60 == null) goto L172;
        String r61 = r60.getMTitle();
        if (r61 == null) goto L172;
    L173:
        if (r27 == null) goto L177;
        KtvMusic r62 = r27.a;
        if (r62 == null) goto L177;
        long r63 = r62.getMId();
    L178:
        if (r27 == null) goto L181;
        String r115 = r27.b();
        if (r115 == null) goto L181;
    L182:
        if (r27 == null) goto L187;
        KtvMusic r116 = r27.a;
        if (r116 == null) goto L187;
        String r117 = r116.getMAuthor();
        if (r117 == null) goto L187;
    L188:
        oe2.b r118 = r26.yq();
        if (r118 == null) goto L191;
        String r119 = r118.getEnterFrom();
    L192:
        if (r27 == null) goto L198;
        KtvMusic r120 = r27.a;
        if (r120 == null) goto L198;
        List r121 = r120.getTags();
        if (r121 == null) goto L198;
        boolean r122 = r121.contains("原唱");
    L199:
        if (r27 == null) goto L201;
        Boolean r123 = r27.A;
    L202:
        boolean r124 = Intrinsics.areEqual(r123, Boolean.TRUE);
        oe2.b r64 = r26.yq();
        if (r64 == null) goto L205;
        String r125 = r64.c();
    L206:
        oe2.b r65 = r26.yq();
        if (r65 == null) goto L209;
        String r126 = r65.a();
    L210:
        if (r27 == null) goto L220;
        KtvMusic r66 = r27.a;
        if (r66 == null) goto L220;
        String r67 = r66.getMidiUrl();
        if (r67 == null) goto L220;
        boolean r68 = r44;
        if (r67.length() > 0) goto L219;
        r68 = 0;
    L219:
        Boolean r127 = Boolean.valueOf(r68);
    L221:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r69 = KSongTuningPanelHelperKt.d();
        if (r69 == null) goto L224;
        boolean r128 = r69.R();
    L225:
        Boolean r210 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.M.getValue();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r70 = KSongTuningPanelHelperKt.d();
        if (r70 == null) goto L231;
        MutableLiveData r71 = r70.F();
        if (r71 == null) goto L231;
        Boolean r72 = (Boolean) r71.getValue();
        if (r72 == null) goto L231;
    L232:
        boolean r211 = r72.booleanValue();
        if (r27 == null) goto L238;
        String r73 = r27.g();
        if (r73 == null) goto L238;
        String r212 = r73;
    L239:
        String r74 = r26.m;
        cg6.a r0 = r26.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L244;
        hg6.g r75 = r0.getRtcManager();
        if (r75 == null) goto L244;
        r75.b();
    L244:
        KtvLoggerHelper.Z(r13, r59, r61, r63, r115, r117, r43, r119, r122, r124, r125, r126, r127, r128, r210, r211, r212, r27, "", "", r74);
        return;
    L238:
        r212 = "";
    L231:
        r72 = Boolean.FALSE;
        goto L232
    L224:
        r128 = false;
    L220:
        r127 = null;
        goto L221
    L209:
        r126 = null;
        goto L210
    L205:
        r125 = null;
        goto L206
    L201:
        r123 = null;
    L198:
        r122 = false;
        goto L199
    L191:
        r119 = null;
    L187:
        r117 = "";
    L181:
        r115 = "";
    L177:
        r63 = 0;
    L172:
        r61 = "";
    L138:
        r48 = null;
        goto L140
    L120:
        if (r40.length() != 0) goto L122;
        r41 = 1;
        boolean r76 = true;
    L123:
        if (r76 != r41) goto L126;
        r43 = null;
        r44 = r41;
        goto L130
    L122:
        r41 = 1;
        r76 = false;
    L117:
        r40 = null;
    L91:
        r30 = BDLocationException.ERROR_TIMEOUT;
        goto L92
    L82:
        if (r2.a(r24.e) == false) goto L84;
        r25 = r24.e;
    L85:
        if (r25 != null) goto L87;
    L84:
        r25 = String.valueOf(r24.b);
    L48:
        r17 = null;
    L39:
        r13 = "";
    L32:
        r12 = null;
    L27:
        r10 = null;
        goto L28
    L249:
        return;
    L19:
        r7 = null;
        goto L21
    L248:
        return;
    L13:
        r5 = null;
        goto L15
    L247:
        return;
    L7:
        r3 = 0;
        goto L9
    }

    public static final void xq(MultiChorusWidget r2, Boolean r3, Boolean r4) {
        r2.getClass();
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r5 = KtvComponentContext.Companion.a();
        if (r5 == null) goto L26;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r6 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r5.getValue();
        if (r6 == null) goto L27;
        boolean r0 = r6.e;
        if (r3 == null) goto L10;
        boolean r7 = r3.booleanValue();
    L11:
        if (r4 == null) goto L13;
        boolean r8 = r4.booleanValue();
    L14:
        boolean r1 = true;
        if (((Boolean) KtvSettingHelper.X0.getValue()).booleanValue() == false) goto L20;
        if (r7 == false) goto L23;
        if (r8 == false) goto L23;
        if (r0 == true) goto L23;
    L24:
        MultiChorusContext.Companion.m(r1);
        return;
    L23:
        r1 = false;
        goto L24
    L20:
        if (r7 == false) goto L23;
        if (r8 == false) goto L23;
    L13:
        r8 = r6.a;
        goto L14
    L10:
        r7 = r6.b;
        goto L11
    L27:
        return;
    }

    public final void Vi(MusicPanel r3, Function1<Object, Unit> r4, Function1<? super Throwable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "music");
        Intrinsics.checkNotNullParameter(r4, "successCallback");
        Intrinsics.checkNotNullParameter(r5, "failCallback");
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.joinMultiChorus(r3, r4, r5);
    }

    public final void gj(MusicPanel r3, Function1<? super com.bytedance.android.live.network.response.e<Object>, Unit> r4, Function1<? super Throwable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "music");
        Intrinsics.checkNotNullParameter(r4, "successCallback");
        Intrinsics.checkNotNullParameter(r5, "failCallback");
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.leaveMultiChorus(r3, r4, r5);
    }

    public final void i5(IBaseUser r3, h80.a<Boolean> r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "consumer");
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        MultiChorusViewModel r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L5:
        r0.permit(r3, r4, r5);
    }
}
