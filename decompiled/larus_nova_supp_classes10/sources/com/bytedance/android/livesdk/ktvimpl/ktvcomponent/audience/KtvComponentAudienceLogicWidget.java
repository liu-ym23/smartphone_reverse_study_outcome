package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodel.j;
import com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.android.livesdk.ktvapi.model.PanelType;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.i;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.KSongSettingViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.KtvComponentUIWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusWidget;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.ai;
import com.bytedance.android.livesdk.message.model.d0;
import com.bytedance.android.livesdk.message.model.f0;
import com.bytedance.android.livesdk.message.model.l8;
import com.bytedance.android.livesdk.message.model.lh;
import com.bytedance.android.livesdk.message.model.on;
import com.bytedance.android.livesdk.message.model.s2;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/audience/KtvComponentAudienceLogicWidget;", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "Lvlc/l;", "a", "OpenSource", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentAudienceLogicWidget extends HolderRoomWidget implements l {
    public boolean d;
    public final IRoom e;
    public KtvComponentContext f;
    public KtvComponentUIWidget g;
    public boolean h;
    public MultiChorusWidget i;
    public final CompositeDisposable j;
    public long k;
    public final AbsKtvControlWidget.a l;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/audience/KtvComponentAudienceLogicWidget$OpenSource;", "", "", "value", "I", "getValue", "()I", "UNKNOW", "NORMAL", "AUTO", "CHORUS", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum OpenSource extends Enum<OpenSource> {
        public static final OpenSource AUTO = null;
        public static final OpenSource CHORUS = null;
        public static final OpenSource NORMAL = null;
        public static final OpenSource UNKNOW = null;
        public static final /* synthetic */ OpenSource[] a = null;
        private final int value;

        static {
            OpenSource r1 = new OpenSource("UNKNOW", 0, 0);
            UNKNOW = r1;
            OpenSource r2 = new OpenSource("NORMAL", 1, 1);
            NORMAL = r2;
            OpenSource r3 = new OpenSource("AUTO", 2, 2);
            AUTO = r3;
            OpenSource r4 = new OpenSource("CHORUS", 3, 3);
            CHORUS = r4;
            a = new OpenSource[]{r1, r2, r3, r4};
        }

        public static OpenSource valueOf(String r1) {
            return (OpenSource) r27.a.a(OpenSource.class, r1);
        }

        public static OpenSource[] values() {
            return (OpenSource[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public OpenSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            j r3 = (j) r2;
            MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r4 = KtvComponentContext.Companion.a();
            if (r4 == null) goto L6;
            com.bytedance.android.livesdk.ktvapi.util.d.b(r4, KtvComponentAudienceLogicWidget$onCreate$1$1.INSTANCE);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ KtvComponentAudienceLogicWidget a;

        public d(KtvComponentAudienceLogicWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            if (r5 != null) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L9;
            this.a.xq("open_video_chorus");
            xs2.b.a().post(new jd2.f(PanelType.ORDER_SONG_PANEL.getValue(), 14));
            return;
        L9:
            if (Intrinsics.areEqual(r5, Boolean.FALSE) == false) goto L21;
            KtvComponentAudienceLogicWidget r6 = this.a;
            if (r6.h == false) goto L22;
            MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
            if (r0 == null) goto L17;
            com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r1 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r0.getValue();
            if (r1 == null) goto L17;
            Boolean r2 = Boolean.valueOf(r1.a);
        L18:
            KtvComponentAudienceLogicWidget.wq(r6, r2);
            return;
        L17:
            r2 = null;
            goto L18
        L22:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience.KtvComponentAudienceLogicWidget$onCreate$3, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass3 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d.class, "openRealtimeChorusSwitch", "getOpenRealtimeChorusSwitch()Z", 0);
        }

        public Object get(Object r1) {
            return Boolean.valueOf(((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r1).e);
        }
    }

    static {
    }

    public final String getSource() {
        KtvComponentContext r0 = this.f;
        if (r0 == null) goto L7;
        n<Integer> r1 = r0.getOpenSource();
        if (r1 == null) goto L7;
        Integer r2 = (Integer) r1.getValue();
    L8:
        int r3 = OpenSource.AUTO.getValue();
        if (r2 != null) goto L12;
    L14:
        int r4 = OpenSource.CHORUS.getValue();
        if (r2 != null) goto L18;
        return null;
    L18:
        if (r2.intValue() != r4) goto L22;
        return "pk_chorus";
    L22:
        return null;
    L12:
        if (r2.intValue() != r3) goto L14;
        return "auto";
    L7:
        r2 = null;
        goto L8
    }

    public final void onDestroy() {
        String r4 = k.n(IInteractService.class).getFunctionType2BeforeReset();
        KtvComponentContext r0 = this.f;
        if (r0 == null) goto L7;
        n<Integer> r1 = r0.getKtvComponentStatus();
        if (r1 == null) goto L7;
        Integer r2 = (Integer) r1.getValue();
    L8:
        if (r2 != null) goto L11;
    L13:
        KtvComponentContext r3 = this.f;
        if (r3 == null) goto L18;
        n<Integer> r5 = r3.getOpenSource();
        if (r5 == null) goto L18;
        r5.setValue(null);
    L18:
        super.onDestroy();
        vlc.d r6 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r6 == null) goto L21;
        r6.removeMessageListener(this);
    L21:
        this.j.dispose();
        return;
    L11:
        if (r2.intValue() != 1) goto L13;
        long r7 = (System.currentTimeMillis() - this.k) / 1000;
        int r8 = ke2.b.a;
        ke2.b.h(r7, r4, r4, getSource(), 16);
    L7:
        r2 = null;
        goto L8
    }

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(KtvComponentAudienceLogicWidget$initDataContext$pair$1.INSTANCE);
        KtvComponentContext r1 = (KtvComponentContext) r0.getFirst();
        this.j.add((Disposable) r0.getSecond());
        com.bytedance.live.datacontext.b.a(r1, KtvComponentContext.class);
        this.f = r1;
        n<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.b> r2 = r1.getKSongSettingViewModel();
        if (r2 == null) goto L5;
        KSongSettingViewModel.Companion.getClass();
        r2.setValue(KSongSettingViewModel.a.a(this));
    L5:
        KtvComponentContext.a r3 = KtvComponentContext.Companion;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r4 = r3.a();
        if (r4 == null) goto L8;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r4, this, KtvComponentAudienceLogicWidget$initDataContext$1.INSTANCE, com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience.c.a);
    L8:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r5 = r3.a();
        if (r5 == null) goto L11;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r5, this, KtvComponentAudienceLogicWidget$initDataContext$3.INSTANCE, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience.d(this));
    L11:
        vlc.d r6 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r6 == null) goto L14;
        r6.addMessageListener(MessageType.KTV_MESSAGE.getIntType(), this);
    L14:
        vlc.d r7 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r7 == null) goto L17;
        r7.addMessageListener(MessageType.CHORUS_MESSAGE.getIntType(), this);
    L17:
        KtvContext.Companion.getClass();
        KtvContext r8 = KtvContext.a.g();
        if (r8 == null) goto L26;
        com.bytedance.live.datacontext.k<i> r9 = r8.getKtvContainerPositionUpdateEvent();
        if (r9 == null) goto L26;
        PublishSubject r10 = r9.onEvent();
        if (r10 == null) goto L26;
        Disposable r11 = r10.subscribe(new e(this));
        if (r11 == null) goto L26;
        RxUtilKt.c(r11, this.j);
    L26:
        MultiChorusWidget r12 = new MultiChorusWidget();
        this.i = r12;
        AbsKtvControlWidget.a r13 = this.l;
        AbsKtvControlWidget.WidgetType r14 = AbsKtvControlWidget.WidgetType.MULTI_CHORUS;
        Intrinsics.checkNotNull(r12);
        r13.a(r14, r12);
        MultiChorusWidget r15 = this.i;
        Intrinsics.checkNotNull(r15);
        r15.Aq(this, new f(this));
        z5 r16 = this.e.getLinkerDetail();
        if (r16 != null) goto L29;
    L39:
        z5 r17 = this.e.getLinkerDetail();
        boolean r18 = false;
        if (r17 == null) goto L44;
        List<Long> r19 = r17.getPlayModes();
        if (r19 == null) goto L44;
        boolean r20 = r19.contains(Long.valueOf(21));
    L45:
        z5 r21 = this.e.getLinkerDetail();
        if (r21 == null) goto L50;
        List<Long> r22 = r21.getPlayModes();
        if (r22 == null) goto L50;
        boolean r23 = r22.contains(Long.valueOf(10));
    L51:
        z5 r24 = this.e.getLinkerDetail();
        if (r24 == null) goto L56;
        List<Long> r25 = r24.getPlayModes();
        if (r25 == null) goto L56;
        boolean r26 = r25.contains(Long.valueOf(8));
    L57:
        z5 r27 = this.e.getLinkerDetail();
        if (r27 == null) goto L62;
        List<Long> r28 = r27.getPlayModes();
        if (r28 == null) goto L62;
        boolean r29 = r28.contains(Long.valueOf(9));
    L63:
        if (r20 == true) goto L69;
        if (r23 == true) goto L69;
        if (r26 == true) goto L69;
        if (r29 == true) goto L69;
        boolean r30 = false;
    L70:
        if (r30 == true) goto L72;
    L77:
        ALogger.w("KtvComponent_MergeMode", "KtvComponentAudienceLogicWidget:getSettingIfNeed, isComponentOpen=" + r18);
        if (r18 == true) goto L80;
    L83:
        com.bytedance.live.datacontext.j r31 = m.d().getVideoTalkRoomSubScene();
        if (r31 == null) goto L92;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r32 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r31.getValue();
        if (r32 == null) goto L92;
        BehaviorSubject r33 = r32.a();
        if (r33 == null) goto L92;
        Disposable r34 = r33.subscribe(b.a, c.a);
        if (r34 == null) goto L92;
        RxUtilKt.c(r34, this.j);
    L92:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r35 = r3.a();
        if (r35 == null) goto L96;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r35, this, AnonymousClass3.INSTANCE, new d(this));
        return;
    L96:
        return;
    L80:
        if (this.d == false) goto L82;
        ALogger.i("KtvComponentAudienceLogicWidget", "is fetching ktv component setting");
        goto L83
    L82:
        this.d = true;
        long r36 = System.currentTimeMillis();
        this.j.add(((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).getAudienceSingEnableSetting(this.e.getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience.a(this, r36), new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience.b(this, r36)));
        goto L83
    L72:
        if (o.c() != 9) goto L74;
        boolean r37 = true;
    L75:
        if (r37 == true) goto L77;
        r18 = true;
        goto L77
    L74:
        r37 = false;
    L69:
        r30 = true;
    L62:
        r29 = false;
    L56:
        r26 = false;
    L50:
        r23 = false;
    L44:
        r20 = false;
        goto L45
    L29:
        if (r16.getUiLayout() != 63) goto L39;
        z5 r38 = this.e.getLinkerDetail();
        if (r38 == null) goto L39;
        List<Long> r39 = r38.getPlayModes();
        if (r39 == null) goto L39;
        if (r39.contains(Long.valueOf(36)) != true) goto L39;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r40 = r3.a();
        if (r40 == null) goto L39;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r40, KtvComponentAudienceLogicWidget$getSettingIfNeed$1.INSTANCE);
        goto L39
    }

    public KtvComponentAudienceLogicWidget(AbsKtvControlWidget.a r2) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        this.l = r2;
        this.e = com.bytedance.android.live.ktv.common.util.a.c();
        this.j = new CompositeDisposable();
    }

    public final void onMessage(tlc.d r15) {
        boolean r1 = true;
        if ((r15 instanceof l8) == false) goto L150;
        final l8 r16 = (l8) r15;
        int r0 = r16.getMessageType();
        Boolean r3 = null;
        String r4 = null;
        Collection r5 = null;
        List r6 = null;
        if (r0 != 6) goto L7;
        u r2 = m.e(this);
        if (r2 == null) goto L142;
        com.bytedance.live.datacontext.j r7 = r2.J();
        if (r7 == null) goto L142;
        LivePlayModeLogContext r8 = (LivePlayModeLogContext) r7.getValue();
        if (r8 == null) goto L142;
        r8.addPlayMode(21);
    L142:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r9 = KtvComponentContext.Companion.a();
        if (r9 == null) goto L145;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r9, new KtvComponentAudienceLogicWidget$onKtvMessage$1(r16));
    L145:
        lh r17 = r16.getOpenKtvComponentContent();
        if (r17 == null) goto L148;
        r3 = Boolean.valueOf(r17.a());
    L148:
        wq(this, r3);
        return;
    L7:
        if (r0 != 7) goto L9;
        KtvComponentContext.a r18 = KtvComponentContext.Companion;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r10 = r18.a();
        if (r10 == null) goto L91;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r10, KtvComponentAudienceLogicWidget$onKtvComponentClose$1.INSTANCE);
    L91:
        KtvComponentContext r11 = this.f;
        if (r11 == null) goto L96;
        n<Integer> r12 = r11.getKtvComponentStatus();
        if (r12 == null) goto L96;
        r12.setValue(0);
    L96:
        KtvContext.Companion.getClass();
        KtvContext r13 = KtvContext.a.g();
        if (r13 == null) goto L101;
        com.bytedance.live.datacontext.m<Integer> r14 = r13.getKtvComponentStatus();
        if (r14 == null) goto L101;
        r14.setValue(0);
    L101:
        KtvContext.a.n(1);
        if (KtvContext.a.c(1) == true) goto L108;
        xq("auto");
        KtvComponentContext r19 = this.f;
        if (r19 == null) goto L113;
        n<KtvComponentUIContext> r20 = r19.getKtvComponentUIContext();
        if (r20 == null) goto L113;
        r20.setValue(null);
    L113:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r110 = r18.a();
        if (r110 == null) goto L116;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r110, KtvComponentAudienceLogicWidget$onKtvComponentClose$2.INSTANCE);
    L116:
        long r21 = (System.currentTimeMillis() - this.k) / 1000;
        int r111 = ke2.b.a;
        KtvComponentContext r112 = this.f;
        if (r112 == null) goto L121;
        n<Integer> r113 = r112.getOpenSource();
        if (r113 == null) goto L121;
        Integer r114 = (Integer) r113.getValue();
    L122:
        int r22 = OpenSource.AUTO.getValue();
        if (r114 != null) goto L126;
    L128:
        String r115 = null;
    L129:
        ke2.b.h(r21, null, null, r115, 28);
        KtvComponentContext r116 = this.f;
        if (r116 == null) goto L134;
        n<Integer> r117 = r116.getOpenSource();
        if (r117 == null) goto L134;
        r117.setValue(null);
    L134:
        i0.c().post(new g(this));
        return;
    L126:
        if (r114.intValue() != r22) goto L128;
        r115 = "auto";
    L121:
        r114 = null;
        goto L122
    L108:
        KtvComponentUIWidget r23 = this.g;
        if (r23 == null) goto L113;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r24 = r23.t;
        if (r24 == null) goto L113;
        r24.j();
        goto L113
    L9:
        if (r0 != 8) goto L11;
        final d0 r118 = r16.getAudienceAddSongSettingChangedContent();
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r25 = KtvComponentContext.Companion.a();
        if (r25 == null) goto L176;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r25, new KtvComponentAudienceLogicWidget$onKtvComponentSettingChanged$1(r118));
        return;
    L176:
        return;
    L11:
        if (r0 == 16) goto L82;
        switch(r0) {
            case 12: goto L48;
            case 13: goto L31;
            case 14: goto L14;
            default: goto L183;
        };
    L14:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r26 = KtvComponentContext.Companion.a();
        if (r26 == null) goto L17;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r26, new KtvComponentAudienceLogicWidget$onKtvMessage$3(r16));
    L17:
        f0 r27 = r16.getAudienceMultiChorusSettingChangedContent();
        if (r27 == null) goto L20;
        String r28 = r27.b();
    L21:
        if (r28 != null) goto L23;
    L26:
        if (r1 == true) goto L165;
        f0 r119 = r16.getAudienceMultiChorusSettingChangedContent();
        if (r119 == null) goto L30;
        r4 = r119.b();
    L30:
        f2.c(r4, 0);
        return;
    L165:
        return;
    L23:
        if (r28.length() == 0) goto L26;
        r1 = false;
        goto L26
    L20:
        r28 = null;
        goto L21
    L31:
        on r120 = r16.getWantToListenSongRemovedContent();
        if (r120 == null) goto L34;
        List r121 = r120.a();
    L36:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L167;
        bb0.a r29 = bb0.b.a;
        if (r29 == null) goto L40;
        r5 = r29.g();
    L40:
        if (r5 != null) goto L42;
        r5 = new ArrayList();
    L42:
        Intrinsics.checkNotNullParameter(r5, "originList");
        ArrayList r30 = new ArrayList();
        r30.addAll(r5);
        if (r121 != null) goto L45;
        r121 = new ArrayList();
    L45:
        r30.removeAll(r121);
        Intrinsics.checkNotNullParameter(r30, "newList");
        bb0.a r122 = bb0.b.a;
        if (r122 == null) goto L168;
        r122.e(r30);
        return;
    L168:
        return;
    L167:
        return;
    L34:
        r121 = null;
        goto L36
    L48:
        Intrinsics.checkNotNullParameter(r16, "message");
        ai r31 = r16.getPermitWantToListenSong();
        if (r31 == null) goto L51;
        boolean r32 = r31.c();
    L52:
        ai r33 = r16.getPermitWantToListenSong();
        if (r33 == null) goto L55;
        List r34 = r33.a();
    L56:
        ai r123 = r16.getPermitWantToListenSong();
        if (r123 == null) goto L59;
        String r124 = r123.b();
    L60:
        bb0.a r35 = bb0.b.a;
        if (r35 == null) goto L63;
        r6 = r35.g();
    L63:
        if (r34 == null) goto L76;
        Iterator r36 = r34.iterator();
    L66:
        if (r36.hasNext() == false) goto L76;
        long r37 = ((Number) r36.next()).longValue();
        if (Lists.notEmpty(r6) == false) goto L76;
        if (r6 == null) goto L66;
        Iterator r38 = r6.iterator();
    L72:
        if (r38.hasNext() == false) goto L66;
        if (r37 != ((Number) r38.next()).longValue()) goto L72;
        boolean r39 = true;
    L77:
        if (r32 == true) goto L170;
        if (r39 == true) goto L80;
        return;
    L80:
        if (StringUtils.isEmpty(r124) == true) goto L172;
        f2.c(s1.C(2131918488, new Object[]{r124}), 0);
        return;
    L172:
        return;
    L170:
        return;
    L76:
        r39 = false;
        goto L77
    L59:
        r124 = null;
        goto L60
    L55:
        r34 = null;
        goto L56
    L51:
        r32 = false;
        goto L52
    L183:
        return;
    L82:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r40 = KtvComponentContext.Companion.a();
        if (r40 == null) goto L174;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r40, new KtvComponentAudienceLogicWidget$onKtvMessage$4(r16));
        return;
    L174:
        return;
    L150:
        if ((r15 instanceof s2) == true) goto L152;
        return;
    L152:
        if (((s2) r15).getMsgType() != 1) goto L181;
        KtvComponentUIWidget r125 = this.g;
        if (r125 == null) goto L182;
        r125.lr(s1.B(2131918299), 5);
        return;
    L182:
        return;
    }

    public final void xq(String r3) {
        ALogger.i("KtvComponentAudienceLogicWidget", "unloadComponentUIWidget, source=".concat(r3));
        boolean r4 = Intrinsics.areEqual(r3, "open_video_chorus");
        this.h = r4;
        if (r4 == false) goto L17;
        KtvContext.Companion.getClass();
        n<com.bytedance.android.livesdk.ktvimpl.base.i> r5 = KtvContext.a.g().getKtvCoreController();
        if (r5 == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.base.i r6 = (com.bytedance.android.livesdk.ktvimpl.base.i) r5.getValue();
    L8:
        if (r6 == null) goto L10;
        r6.s();
    L10:
        if (r6 == null) goto L12;
        r6.l();
    L12:
        if (r6 == null) goto L14;
        r6.j();
    L14:
        n<com.bytedance.android.livesdk.ktvimpl.base.i> r7 = KtvContext.a.g().getKtvCoreController();
        if (r7 == null) goto L17;
        r7.setValue(null);
        goto L17
    L7:
        r6 = null;
    L17:
        KtvComponentUIWidget r8 = this.g;
        if (r8 == null) goto L20;
        this.l.k(r8);
    L20:
        this.g = null;
    }

    public static void wq(final KtvComponentAudienceLogicWidget r4, final Boolean r5) {
        boolean r0 = true;
        r4.getClass();
        if (KtvSettingHelper.n().booleanValue() == false) goto L44;
        KtvComponentContext r2 = r4.f;
        if (r2 == null) goto L10;
        n<Integer> r3 = r2.getKtvComponentStatus();
        if (r3 == null) goto L10;
        r3.setValue(1);
    L10:
        KtvContext.a r6 = KtvContext.Companion;
        r6.getClass();
        KtvContext r7 = KtvContext.a.g();
        if (r7 == null) goto L15;
        com.bytedance.live.datacontext.m<Integer> r8 = r7.getKtvComponentStatus();
        if (r8 == null) goto L15;
        r8.setValue(1);
    L15:
        r6.getClass();
        KtvContext.a.a(1);
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r1 = KtvComponentContext.Companion.a();
        if (r1 == null) goto L22;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r9 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r1.getValue();
        if (r9 == null) goto L22;
        if (r9.e != true) goto L22;
    L23:
        if (r0 == false) goto L26;
        ALogger.i("KtvComponentAudienceLogicWidget", "openComponentSuccess, isOpenVideoChorus = true return");
        return;
    L26:
        if (r4.g != null) goto L28;
        KtvComponentUIWidget r10 = new KtvComponentUIWidget(r4.getSource(), new KtvComponentAudienceLogicWidget$onKtvComponentOpen$1(r4, r5), new KtvComponentAudienceLogicWidget$onKtvComponentOpen$2(r4));
        r4.g = r10;
        r4.l.a(AbsKtvControlWidget.WidgetType.KTV_COMPONENT_V2_UI_WIDGET, r10);
    L28:
        r4.k = System.currentTimeMillis();
        int r11 = ke2.b.a;
        KtvComponentContext r12 = r4.f;
        if (r12 == null) goto L33;
        n<Integer> r13 = r12.getOpenSource();
        if (r13 == null) goto L33;
        Integer r14 = (Integer) r13.getValue();
    L34:
        int r15 = OpenSource.AUTO.getValue();
        if (r14 != null) goto L38;
    L40:
        String r16 = null;
    L41:
        ke2.b.g(null, null, r16);
        return;
    L38:
        if (r14.intValue() != r15) goto L40;
        r16 = "auto";
    L33:
        r14 = null;
    L22:
        r0 = false;
        goto L23
    }
}
