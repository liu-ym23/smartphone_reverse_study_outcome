package com.bytedance.locallife.live.controller;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.room.state.RoomState;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.locallife.live.card.o;
import com.bytedance.locallife.live.card.u;
import com.bytedance.locallife.live.experiment.l0;
import com.bytedance.locallife.live.experiment.v;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesCard;
import com.bytedance.locallife.live.message.LiveLocalLifeMessage;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.live.msgcenter.MsgCenter;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.t;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import nv6.n;
import nv6.p;
import nv6.t0;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f259378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f259379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f259380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f259381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BehaviorSubject<IRoomState> f259382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f259383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.locallife.live.card.sticker.b f259384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f259385j;

    public static final class a {
    }

    static {
    }

    public final void d() {
        ALogger.i("currentRoomState", "code =" + this.f259375b + ", loadGroupPurchaseCard, roomId=" + this.f259374a);
        RoomState r100 = m8276getCurrentRoomState();
        boolean r101 = false;
        if (r100 == null) goto L5;
        boolean r102 = r100.isAnchor();
    L7:
        if (isViewHandlerAttached() == true) goto L9;
        return;
    L9:
        if (isContextAttached() == true) goto L11;
        return;
    L11:
        if (isRoomStateAttached() == false) goto L96;
        Context r103 = getContext();
        if (r103 != null) goto L16;
        return;
    L16:
        ILiveRoomViewHandler r104 = getHandler();
        if (r104 != null) goto L19;
        return;
    L19:
        if (r102 == false) goto L22;
        return;
    L22:
        if (this.f259381f == true) goto L94;
        int r105 = v.f259509a;
        Class r106 = Integer.TYPE;     // Catch: Throwable -> L38
        if (LiveLifeSaaSUtil.y().containsKey("live_local_life_expound_card_refactor") == false) goto L33;
        Object r107 = LiveLifeSaaSUtil.y().get("live_local_life_expound_card_refactor");     // Catch: Throwable -> L38
        if (r107 != null) goto L30;
        Object r108 = null;
    L34:
        Integer r109 = (Integer) r108;     // Catch: Throwable -> L38
        if (r109 == null) goto L39;
        int r110 = r109.intValue();     // Catch: Throwable -> L38
    L41:
        if (r110 != 1) goto L43;
        boolean r111 = true;
    L45:
        if (r111 == false) goto L67;
        o r112 = new o(r103, r104, this.f259382g, this.f259375b);
        LiveLocalLifeViewModel.Companion r113 = LiveLocalLifeViewModel.Companion;
        String r114 = r112.f259274d;
        r113.getClass();
        LiveLocalLifeViewModel r115 = LiveLocalLifeViewModel.Companion.a(r114);
        if (r115 == null) goto L53;
        u r116 = r115.getGroupPurchaseInfoRepository();
        if (r116 == null) goto L53;
        if (j0.g(r116.f259344d, r112.f259274d) != true) goto L53;
        r101 = true;
    L53:
        if (r101 == false) goto L61;
        LiveLocalLifeViewModel r117 = LiveLocalLifeViewModel.Companion.a(r112.f259274d);
        if (r117 == null) goto L61;
        u r118 = r117.getGroupPurchaseInfoRepository();
        if (r118 == null) goto L61;
        com.bytedance.locallife.live.card.a r119 = r118.f259349i;
        if (r119 == null) goto L61;
        r119.f259221j = r112.f259277g - r119.f259220i;
        r112.g(r119);
    L61:
        LiveLocalLifeViewModel r120 = LiveLocalLifeViewModel.Companion.a(r112.f259274d);
        if (r120 == null) goto L66;
        u r121 = r120.getGroupPurchaseInfoRepository();
        if (r121 == null) goto L66;
        Intrinsics.checkNotNullParameter(r112, "observer");
        ((ArrayList) r121.f259347g).add(r112);
    L66:
        this.f259381f = true;
        return;
    L67:
        com.bytedance.locallife.live.card.l r122 = new com.bytedance.locallife.live.card.l(r103, r104, this.f259382g, this.f259375b);
        LiveLocalLifeViewModel.Companion r123 = LiveLocalLifeViewModel.Companion;
        String r124 = r122.f259248d;
        r123.getClass();
        LiveLocalLifeViewModel r125 = LiveLocalLifeViewModel.Companion.a(r124);
        if (r125 == null) goto L74;
        u r126 = r125.getGroupPurchaseInfoRepository();
        if (r126 == null) goto L74;
        if (j0.g(r126.f259344d, r122.f259248d) != true) goto L74;
        boolean r127 = true;
    L75:
        if (r127 == false) goto L83;
        LiveLocalLifeViewModel r128 = LiveLocalLifeViewModel.Companion.a(r122.f259248d);
        if (r128 == null) goto L83;
        u r129 = r128.getGroupPurchaseInfoRepository();
        if (r129 == null) goto L83;
        com.bytedance.locallife.live.card.a r130 = r129.f259349i;
        if (r130 == null) goto L83;
        r122.w(0, r130.f259212a, r130.f259213b, r130);
    L83:
        LiveLocalLifeViewModel r131 = LiveLocalLifeViewModel.Companion.a(r122.f259248d);
        if (r131 == null) goto L88;
        u r132 = r131.getGroupPurchaseInfoRepository();
        if (r132 == null) goto L88;
        Intrinsics.checkNotNullParameter(r122, "observer");
        ((ArrayList) r132.f259347g).add(r122);
    L88:
        this.f259381f = true;
        return;
    L74:
        r127 = false;
        goto L75
    L43:
        r111 = false;
        goto L45
    L30:
        if ((r107 instanceof Integer) == true) goto L32;
        r108 = LiveLifeSaaSUtil.a("live_local_life_expound_card_refactor", r106, 0);     // Catch: Throwable -> L38
        goto L34
    L32:
        r108 = (Integer) r107;     // Catch: Throwable -> L38
        goto L34
    L33:
        r108 = LiveLifeSaaSUtil.a("live_local_life_expound_card_refactor", r106, 0);     // Catch: Throwable -> L38
    L39:
        r110 = 0;
        goto L41
    L94:
        return;
    L96:
        return;
    L5:
        r102 = false;
        goto L7
    }

    public final void e() {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259375b;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L17;
        u r103 = r102.getGroupPurchaseInfoRepository();
        if (r103 == null) goto L17;
        r103.f259343c = false;
        r103.f259349i = null;
        ((ArrayList) r103.f259347g).clear();
        ((ArrayList) r103.f259348h).clear();
        ConcurrentHashMap<Long, String> r104 = av6.b.f16381a;
        long r105 = r103.f259344d;
        if (r105 == 0) goto L10;
        av6.b.f16381a.remove(Long.valueOf(r105));
    L10:
        r103.f259344d = 0;
        String r106 = r103.f259346f;
        if (r106 == null) goto L13;
        t.d(r106);
    L13:
        String r107 = r103.f259346f;
        if (r107 == null) goto L16;
        t.d(r107);
    L16:
        r103.f259346f = null;
    L17:
        this.f259381f = false;
        Disposable r108 = this.f259385j;
        if (r108 != null) goto L20;
    L22:
        boolean r109 = false;
    L23:
        if (r109 == false) goto L28;
        Disposable r110 = this.f259385j;
        if (r110 == null) goto L27;
        r110.dispose();
    L27:
        this.f259385j = null;
    L28:
        com.bytedance.locallife.live.card.sticker.b r111 = this.f259384i;
        if (r111 == null) goto L34;
        Lazy r112 = MsgCenter.f260620a;
        MsgCenter.h(r111.f259317h);
        com.bytedance.locallife.live.card.sticker.h r113 = r111.f259316g;
        r113.f259326b = null;
        r113.f259329e = null;
        if ((r113.f259332h instanceof com.bytedance.locallife.live.card.sticker.g) == true) goto L33;
        com.bytedance.locallife.live.card.sticker.b r114 = r113.f259325a;
        r114.f259312c.requestDismiss(r114);
    L33:
        r113.f259332h = null;
        r113.f259333i = null;
        r113.f259334j = null;
        r113.f259335k = null;
        r113.f259336l = null;
    L34:
        this.f259384i = null;
        this.f259383h = false;
        return;
    L20:
        if (r108.isDisposed() == true) goto L22;
        r109 = true;
        goto L23
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onActivityCreated() {
        super.onActivityCreated();
        this.f259379d = true;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onDestroy() {
        super.onDestroy();
        ALogger.i("currentRoomState", "code =" + this.f259375b + " roomID=" + this.f259374a + " destoryed " + isRoomStateAttached());
        e();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onExitRoom() {
        super.onExitRoom();
        e();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onStart() {
        super.onStart();
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259375b;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L14;
        u r103 = r102.getGroupPurchaseInfoRepository();
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.f259350j == false) goto L16;
        ConcurrentHashMap<Class<?>, Object> r104 = LifeServiceManager.f162660a;
        com.bytedance.locallife.live.service.a r105 = (com.bytedance.locallife.live.service.a) LifeServiceManager.b(com.bytedance.locallife.live.service.a.class);
        Room r106 = LiveLocalLifeUtil.d(r103.f259341a);
        if (r106 == null) goto L11;
        long r107 = r106.getRoomId();
    L12:
        r105.a("update", r107, "preview_re_check", null, r103.f259341a, "");
        r103.f259350j = false;
        return;
    L11:
        r107 = 0;
        goto L12
    L16:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onWidgetLoadFinished() {
        super.onWidgetLoadFinished();
        if (this.f259378c == true) goto L5;
        return;
    L5:
        if (this.f259379d == true) goto L7;
        return;
    L7:
        if (this.f259380e == false) goto L65;
        d();
        RoomState r100 = m8276getCurrentRoomState();
        boolean r101 = false;
        if (r100 == null) goto L12;
        boolean r102 = r100.isAnchor();
    L13:
        if (r102 == false) goto L16;
        return;
    L16:
        if (isViewHandlerAttached() == true) goto L18;
        return;
    L18:
        if (isContextAttached() == false) goto L67;
        Context r103 = getContext();
        if (r103 == null) goto L68;
        ILiveRoomViewHandler r104 = getHandler();
        if (r104 == null) goto L69;
        LiveLocalLifeViewModel.Companion r105 = LiveLocalLifeViewModel.Companion;
        String r106 = this.f259375b;
        r105.getClass();
        LiveLocalLifeViewModel r107 = LiveLocalLifeViewModel.Companion.a(r106);
        if (r107 != null) goto L29;
    L31:
        boolean r108 = false;
    L32:
        if (r108 == false) goto L35;
        return;
    L35:
        if (this.f259383h == true) goto L64;
        com.bytedance.locallife.live.card.sticker.b r109 = new com.bytedance.locallife.live.card.sticker.b(this.f259375b, r103, r104, this.f259382g);
        this.f259384i = r109;
        LiveLocalLifeViewModel r110 = LiveLocalLifeViewModel.Companion.a(r109.f259310a);
        if (r110 == null) goto L43;
        u r111 = r110.getGroupPurchaseInfoRepository();
        if (r111 == null) goto L43;
        if (j0.g(r111.f259344d, r109.f259310a) != true) goto L43;
        r101 = true;
    L43:
        if (r101 == false) goto L54;
        LiveLocalLifeViewModel r112 = LiveLocalLifeViewModel.Companion.a(r109.f259310a);
        if (r112 == null) goto L54;
        u r113 = r112.getGroupPurchaseInfoRepository();
        if (r113 == null) goto L54;
        com.bytedance.locallife.live.card.a r114 = r113.f259349i;
        if (r114 == null) goto L51;
        n r115 = r114.f259213b;
    L52:
        if (r115 == null) goto L54;
        r109.f259316g.c(r115, r109.f259315f);
        goto L54
    L51:
        r115 = null;
    L54:
        LiveLocalLifeViewModel r116 = LiveLocalLifeViewModel.Companion.a(r109.f259310a);
        if (r116 == null) goto L59;
        u r117 = r116.getGroupPurchaseInfoRepository();
        if (r117 == null) goto L59;
        Intrinsics.checkNotNullParameter(r109, "observer");
        ((ArrayList) r117.f259348h).add(r109);
    L59:
        this.f259383h = true;
        return;
    L64:
        return;
    L29:
        if (r107.isPreview() != true) goto L31;
        r108 = true;
        goto L32
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L12:
        r102 = false;
        goto L13
    }

    public static int c(String r100) {
        Integer r101 = 0;
        if (Intrinsics.areEqual(r100, "draw") == true) goto L14;
        IStrategyService r102 = (IStrategyService) jc1.k.f(IStrategyService.class);
        if (r102 == null) goto L13;
        LiveData r103 = IStrategyService.a.a(r102, "live_life_card_load_delay_strategy", r101, false, 12);
        if (r103 == null) goto L13;
        Integer r104 = (Integer) r103.getValue();
        if (r104 == null) goto L13;
        r101 = r104;
    L13:
        return r101.intValue();
    L14:
        return 0;
    }

    @Override // com.bytedance.locallife.live.controller.d
    public final void a(LiveLocalLifeMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        int r101 = r100.getType();
        int r102 = 1;
        int r103 = 0;
        if (r101 != 3) goto L5;
        mv6.e r104 = r100.get_messageBody();
        if (r104 == null) goto L30;
        List<String> r105 = r104.b();
    L31:
        List<String> r106 = r105;
        if (r106 != null) goto L34;
    L37:
        boolean r107 = true;
    L38:
        if (r107 == false) goto L41;
        return;
    L41:
        if (4 != r100.getUpdateType()) goto L43;
        boolean r108 = true;
    L44:
        if (r108 == false) goto L55;
        LiveLocalLifeViewModel.Companion r109 = LiveLocalLifeViewModel.Companion;
        String r110 = this.f259375b;
        r109.getClass();
        LiveLocalLifeViewModel r111 = LiveLocalLifeViewModel.Companion.a(r110);
        if (r111 == null) goto L52;
        u r112 = r111.getGroupPurchaseInfoRepository();
        if (r112 == null) goto L52;
        if (r112.b() != true) goto L52;
        boolean r113 = true;
    L53:
        if (r113 == false) goto L55;
    L56:
        mv6.e r114 = r100.get_messageBody();
        if (r114 == null) goto L69;
        List<String> r115 = r114.b();
        if (r115 == null) goto L70;
        Iterator<T> r116 = r115.iterator();
    L62:
        if (r116.hasNext() == false) goto L73;
        b((String) r116.next(), r102);
        goto L62
    L73:
        return;
    L70:
        return;
    L69:
        return;
    L52:
        r113 = false;
    L55:
        r102 = 0;
        goto L56
    L43:
        r108 = false;
        goto L44
    L34:
        if (r106.isEmpty() == true) goto L37;
        r107 = false;
        goto L38
    L30:
        r105 = null;
        goto L31
    L5:
        if (r101 != 101) goto L71;
        LiveLocalLifeViewModel.Companion r117 = LiveLocalLifeViewModel.Companion;
        String r118 = this.f259375b;
        r117.getClass();
        LiveLocalLifeViewModel r119 = LiveLocalLifeViewModel.Companion.a(r118);
        if (r119 == null) goto L14;
        u r120 = r119.getGroupPurchaseInfoRepository();
        if (r120 == null) goto L14;
        if (r120.b() != true) goto L14;
    L15:
        if (r102 == 0) goto L17;
        r103 = 2;
    L17:
        mv6.e r121 = r100.get_messageBody();
        if (r121 == null) goto L64;
        t0 r122 = r121.g();
        if (r122 == null) goto L67;
        List<LiveGoodsShelvesCard> r123 = r122.a();
        if (r123 == null) goto L68;
        Iterator<T> r124 = r123.iterator();
    L25:
        if (r124.hasNext() == false) goto L72;
        b(((LiveGoodsShelvesCard) r124.next()).getCardId(), r103);
        goto L25
    L72:
        return;
    L68:
        return;
    L67:
        return;
    L64:
        return;
    L14:
        r102 = 0;
        goto L15
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onContextAttached(r100);
        this.f259380e = true;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onRoomStatusChanged(IRoomState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        super.onRoomStatusChanged(r100);
        ALogger.i("currentRoomState", "code =" + this.f259375b + ", onRoomStatusChanged, roomId=" + this.f259374a);
        this.f259378c = true;
        this.f259382g.onNext(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onSpecificWidgetLoadFinished(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetClassName");
        super.onSpecificWidgetLoadFinished(r100);
        ALogger.i("currentRoomState", "code =" + this.f259375b + "  roomID=" + this.f259374a + " onSpecificWidgetLoadFinished " + isRoomStateAttached());
        LiveLocalLifeViewModel.Companion r101 = LiveLocalLifeViewModel.Companion;
        String r102 = this.f259375b;
        r101.getClass();
        LiveLocalLifeViewModel r103 = LiveLocalLifeViewModel.Companion.a(r102);
        if (r103 == null) goto L8;
        LiveLocalLifeRoomInfo r104 = r103.getRoomInfo();
        if (r104 == null) goto L8;
        String r105 = r104.getActionType();
        if (r105 == null) goto L8;
    L10:
        if (Intrinsics.areEqual(r100, "3") == false) goto L56;
        ILiveService r106 = TTLiveService.getLiveService();
        boolean r107 = false;
        if (r106 == null) goto L14;
        Integer r108 = (Integer) r106.getLiveSettingValue("live_local_life_card_enable", 0);
    L16:
        if (r108 != null) goto L19;
    L20:
        if (r108 != null) goto L23;
    L25:
        boolean r109 = false;
    L27:
        if (r109 == false) goto L57;
        int r110 = l0.f259505a;
        Class r111 = Integer.TYPE;     // Catch: Throwable -> L43
        if (LiveLifeSaaSUtil.y().containsKey("local_life_sdk_card_preload") == false) goto L38;
        Object r112 = LiveLifeSaaSUtil.y().get("local_life_sdk_card_preload");     // Catch: Throwable -> L43
        if (r112 != null) goto L35;
        Object r113 = null;
    L39:
        Integer r114 = (Integer) r113;     // Catch: Throwable -> L43
        if (r114 == null) goto L44;
        int r115 = r114.intValue();     // Catch: Throwable -> L43
    L45:
        if (1 != r115) goto L47;
        r107 = true;
    L47:
        if (r107 == false) goto L49;
    L52:
        this.f259385j = Single.timer(c(r105), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this));
        return;
    L49:
        if (c(null) > 0) goto L52;
        if (Intrinsics.areEqual(r105, "draw") == true) goto L52;
        return;
    L35:
        if ((r112 instanceof Integer) == true) goto L37;
        r113 = LiveLifeSaaSUtil.a("local_life_sdk_card_preload", r111, 1);     // Catch: Throwable -> L43
        goto L39
    L37:
        r113 = (Integer) r112;     // Catch: Throwable -> L43
        goto L39
    L38:
        r113 = LiveLifeSaaSUtil.a("local_life_sdk_card_preload", r111, 1);     // Catch: Throwable -> L43
    L44:
        r115 = 1;
        goto L45
    L57:
        return;
    L23:
        if (r108.intValue() != 2) goto L25;
    L26:
        r109 = true;
        goto L27
    L19:
        if (r108.intValue() == 1) goto L26;
    L14:
        r108 = null;
        goto L16
    L56:
        return;
    L8:
        r105 = "";
        goto L10
    }

    public f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        super(r100, r101);
        this.f259382g = BehaviorSubject.create();
    }

    public final void b(String r110, int r111) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        LiveLocalLifeViewModel.Companion r102 = LiveLocalLifeViewModel.Companion;
        String r103 = this.f259375b;
        r102.getClass();
        LiveLocalLifeViewModel r104 = LiveLocalLifeViewModel.Companion.a(r103);
        if (r104 == null) goto L18;
        u r105 = r104.getGroupPurchaseInfoRepository();
        if (r105 == null) goto L18;
        if (r105.f259343c == true) goto L18;
        r100 = true;
    L18:
        String r106 = null;
        if (r100 == false) goto L27;
        if (r111 != 1) goto L22;
        String r112 = "only_update_sticker_for_attr";
    L26:
        String r107 = r112;
    L28:
        LiveLocalLifeViewModel r113 = LiveLocalLifeViewModel.Companion.a(this.f259375b);
        if (r113 == null) goto L41;
        u r114 = r113.getGroupPurchaseInfoRepository();
        if (r114 == null) goto L41;
        com.bytedance.locallife.live.card.a r115 = r114.f259349i;
        if (r115 == null) goto L35;
        n r116 = r115.f259213b;
    L36:
        if (r116 == null) goto L41;
        p r117 = r116.a();
        if (r117 == null) goto L41;
        r106 = r117.g();
        goto L41
    L35:
        r116 = null;
    L41:
        if (Intrinsics.areEqual(r110, r106) == true) goto L43;
        return;
    L43:
        ConcurrentHashMap<Class<?>, Object> r118 = LifeServiceManager.f162660a;
        com.bytedance.locallife.live.service.a r108 = (com.bytedance.locallife.live.service.a) LifeServiceManager.b(com.bytedance.locallife.live.service.a.class);
        Room r119 = LiveLocalLifeUtil.d(this.f259375b);
        if (r119 == null) goto L46;
        long r120 = r119.getRoomId();
    L47:
        r108.a("update", r120, r107, null, this.f259375b, "");
        return;
    L46:
        r120 = 0;
        goto L47
    L22:
        if (r111 == 2) goto L24;
        return;
    L24:
        r112 = "only_update_sticker_for_user";
        goto L26
    L27:
        r107 = null;
        goto L28
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
