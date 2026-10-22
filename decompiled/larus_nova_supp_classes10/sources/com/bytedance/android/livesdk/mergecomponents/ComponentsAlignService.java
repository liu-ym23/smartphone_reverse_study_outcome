package com.bytedance.android.livesdk.mergecomponents;

import am2.n;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.g;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.IExternalFunctionInjector;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.InteractionContext;
import com.bytedance.android.livesdk.config.tj0;
import com.bytedance.android.livesdk.config.yj0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.mergecomponents.context.CardContextInjectContext;
import com.bytedance.android.livesdk.mergecomponents.context.InteractivityInjectContext;
import com.bytedance.android.livesdk.mergecomponents.context.LiveLocalLifeInjectContext;
import com.bytedance.android.livesdk.mergecomponents.context.ToolbarInjectContext;
import com.bytedance.android.livesdk.mergecomponents.context.a;
import com.bytedance.android.livesdk.room.handler.SimpleLiveRoomViewHandler;
import com.bytedance.android.livesdk.room.handler.b;
import com.bytedance.android.livesdk.room.handler.c;
import com.bytedance.android.livesdk.room.util.ConvertorKt;
import com.bytedance.android.livesdk.room.util.j;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.arch.CommonRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.PreviewMergeConfig;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.arch.IComponentsAlign;
import com.bytedance.android.livesdkapi.feed.arch.IInjectBusinessContext;
import com.bytedance.android.livesdkapi.feed.arch.PreViewRoomControllerLifeCycle;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LivePreviewDanmakuConfig;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ILayoutConstraint;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.livesdk.preview.merge.MergeDataContext;
import com.bytedance.livesdk.preview.merge.PreviewViewHolderStatus;
import fm2.e;
import fm2.f;
import fm2.h;
import fm2.i;
import fm2.l;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ComponentsAlignService implements IComponentsAlign {
    public Pair<RoomContext, ? extends Disposable> a;
    public final List<IInjectBusinessContext> b;
    public final PreviewMergeConfig c;

    public final void disRoomContext() {
        Pair<RoomContext, ? extends Disposable> r0 = this.a;
        if (r0 == null) goto L7;
        Disposable r1 = (Disposable) r0.getSecond();
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        this.a = null;
        ALogger.i("livetoolbar", "disRoomContext");
        ALogger.i("ComponentsAlignService", "======disRoomContext=====");
    }

    public ComponentsAlignService(PreviewMergeConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.c = r2;
        this.b = new ArrayList();
        if (r2.isPreviewCautious() == false) goto L6;
        registerInjectContext(new a());
        registerInjectContext(new ToolbarInjectContext());
        registerInjectContext(new LiveLocalLifeInjectContext());
    L6:
        if (((Boolean) yj0.a.getValue()).booleanValue() == false) goto L9;
        registerInjectContext(new CardContextInjectContext());
    L9:
        if (((g) tj0.a.getValue()).a() == false) goto L11;
    L12:
        registerInjectContext(new InteractivityInjectContext());
        return;
    L11:
        if (LivePreviewDanmakuConfig.Companion.isPreviewDanmakuEnable() == true) goto L12;
    }

    public final ILiveRoomMessageHandler createLiveRoomMessageHandler(d r2) {
        return new com.bytedance.android.livesdk.room.handler.d(r2);
    }

    public final void registerInjectContext(IInjectBusinessContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (this.b.contains(r2) == true) goto L6;
        this.b.add(r2);
        return;
    }

    public final IBaseLiveRoomFunctionHandler createFunctionHandler(DataCenter r4, DataContext r5) {
        Intrinsics.checkNotNullParameter(r5, "mergeDataContext");
        PreviewViewHolderStatus r0 = null;
        if (r4 == null) goto L25;
        com.bytedance.android.livesdk.room.handler.a r1 = new com.bytedance.android.livesdk.room.handler.a(r4);
        MergeDataContext r6 = (MergeDataContext) r5;
        r1.d = r6;
        if (r6 == null) goto L11;
        Completable r7 = r6.getOnCleared();
        if (r7 == null) goto L11;
        Disposable r8 = r7.subscribe(new b(r1));
        if (r8 == null) goto L11;
        RxUtilKt.c(r8, r1.c);
    L11:
        if (r6 == null) goto L14;
        r0 = r6.getViewHolderStatus();
    L14:
        if (r0 != PreviewViewHolderStatus.ON_SELECT) goto L16;
        r1.a.b(Boolean.TRUE);
    L16:
        if (r6 == null) goto L24;
        k r9 = r6.getVhEvent();
        if (r9 == null) goto L24;
        PublishSubject r10 = r9.onEvent();
        if (r10 == null) goto L24;
        Disposable r11 = r10.subscribe(new c(r1));
        if (r11 == null) goto L24;
        RxUtilKt.c(r11, r1.c);
    L24:
        return r1;
    L25:
        return null;
    }

    public final DataContext createInteractionContext(DataCenter r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        InteractionContext r0 = com.bytedance.live.datacontext.d.b(r4, null).a(InteractionContext.class);
        if (r0 == null) goto L5;
        InteractionContext.Companion.getClass();
        String r5 = InteractionContext.b.b(r3);
        Intrinsics.checkNotNullParameter(r0, "self");
        com.bytedance.live.datacontext.b.a(r0, r5);
    L5:
        ALogger.i("ComponentsAlignService", "createInteractionContext, interactionContext.hashcode=" + r0.hashCode() + ", fragment=" + r4.hashCode());
        return r0;
    }

    public final IRoomState createRoomStats(Room r9, DataCenter r10) {
        if (r9 == null) goto L24;
        Bundle r2 = new Bundle();
        r2.putBoolean("EXTRA_BOOL_ROOM_HAS_COMMERCE", r9.isHasCommerceGoods());
        boolean r1 = true;
        if (r9.getRoomCart() == null) goto L6;
        r2.putBoolean("EXTRA_BOOL_ROOM_HAS_CART_INFO", true);
        r2.putBoolean("EXTRA_BOOL_ROOM_HAS_INIT_GOOD", r9.getRoomCart().getContainCart());
        r2.putInt("EXTRA_INT_TOTAL_SHOPPING_GOOD", r9.getRoomCart().getTotal());
        r2.putInt("EXTRA_INT_FLASH_SHOPPING_GOOD", r9.getRoomCart().getFlashTotal());
        r2.putString("EXTRA_STRING_CART_ICON", r9.getRoomCart().getCartIcon());
        r2.putInt("EXTRA_INT_SHOW_CART", r9.getRoomCart().getShowCartExt());
        r2.putSerializable("EXTRA_MAP_CART_VERTICAL", r9.getRoomCart().getVerticalMap());
        r2.putSerializable("EXTRA_MAP_CART_HORIZONTAL", r9.getRoomCart().getHorizontalMap());
        r2.putSerializable("EXTRA_MAP_CART_STYLE", r9.getRoomCart().getCartStyleMap());
    L6:
        com.bytedance.android.livesdk.commerce.a r0 = new com.bytedance.android.livesdk.commerce.a(r9);
        if (r10 == null) goto L11;
        Bundle r3 = (Bundle) r10.get("data_preview_outer_merge_data", new Bundle());
        if (r3 == null) goto L11;
        r0.d(r3.getString("enter_from_merge"));
        r0.e(r3.getString("enter_method"));
        r0.a(r3.getString("action_type"));
        r0.i(r3.getString("video_id"));
    L11:
        r0.g(g4.b());
        r0.f(l0.a("IESLiveEffectAdTrackExtraServiceKey", j0.l().c(n.class)));
        r0.h(g4.g(r9.id));
        HashMap r5 = new HashMap();
        if (r10 == null) goto L16;
        Boolean r4 = (Boolean) r10.get("data_current_is_preview", Boolean.TRUE);
        if (r4 == null) goto L16;
        r1 = r4.booleanValue();
    L16:
        r2.putBoolean("data_current_is_preview", r1);
        if (r10 == null) goto L21;
        Boolean r11 = (Boolean) r10.get("data_current_is_game", Boolean.FALSE);
        if (r11 == null) goto L21;
        boolean r12 = r11.booleanValue();
    L22:
        r2.putBoolean("data_current_is_game", r12);
        return ConvertorKt.d(false, true, r2, r9, r0.a, r5, MapsKt.emptyMap(), false);
    L21:
        r12 = false;
        goto L22
    L24:
        return null;
    }

    public final CommonRoomContext getCommonRoomContext(DataCenter r2, long r3) {
        RoomContext.Companion.getClass();
        return RoomContext.a.a(r2, r3);
    }

    public final boolean initCommonRoomContext(DataCenter r5, CommonRoomContext r6) {
        Intrinsics.checkNotNullParameter(r6, "commonRoomContext");
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r7 == null) goto L11;
        Room r0 = jm2.a.e((vh7.c) r6.getRoom().getValue());
        if (r0 == null) goto L7;
        r7.getRoom().setValue(r0);
        r7.getInteractionDataPrepared().setValue(r0);
    L7:
        User r8 = jm2.a.e((vh7.c) r6.getUser().getValue());
        if (r8 == null) goto L10;
        r7.getUser().setValue(r8);
    L10:
        return true;
    L11:
        return false;
    }

    public final void injectPreviewBusinessDataCenter(DataCenter r9, Room r10) {
        ALogger.i("ComponentsAlignService", "injectPreviewBusinessDataCenter");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        IInjectBusinessContext r2 = (IInjectBusinessContext) r0.next();
        long r3 = System.currentTimeMillis();
        r2.injectPreviewBusinessDataCenter(r9, r10);
        ALogger.i("ComponentsAlignService", "it = " + r2 + ", inject DataCenter time: " + (System.currentTimeMillis() - r3));
        goto L4
    }

    public final void injectPreviewRoomControllerProvider(DataCenter r8, Room r9) {
        if (this.c.isPreviewCautious() == true) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.b.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IInjectBusinessContext r1 = (IInjectBusinessContext) r0.next();
        long r2 = System.currentTimeMillis();
        r1.injectPreviewRoomController(r8, r9);
        ALogger.i("ComponentsAlignService", "it = " + r1 + ", inject RoomController time: " + (System.currentTimeMillis() - r2));
        goto L7
    }

    public final ILiveRoomViewHandler createRoomViewHandler(DataContext r3, Fragment r4, DataCenter r5) {
        if (r5 == null) goto L17;
        HashMap r0 = new HashMap();
        if ((r3 instanceof InteractionContext) == true) goto L7;
        r3 = null;
    L7:
        InteractionContext r6 = (InteractionContext) r3;
        if (r6 == null) goto L12;
        m r7 = r6.getRoomPlaceHolders();
        if (r7 == null) goto L12;
        Map r8 = (Map) r7.getValue();
    L13:
        if (r8 == null) goto L16;
        r0.putAll(r8);
    L16:
        return new SimpleLiveRoomViewHandler(r0, null, r5);
    L12:
        r8 = null;
        goto L13
    L17:
        return null;
    }

    public final void addPlaceHolderWidget(DataContext r3, DataCenter r4, ILayoutConstraint r5, com.bytedance.android.livesdk.room.placeholder.widget.d r6) {
        Intrinsics.checkNotNullParameter(r5, "constraint");
        Intrinsics.checkNotNullParameter(r6, "placeHolder");
        if ((r3 instanceof InteractionContext) == true) goto L5;
        r3 = null;
    L5:
        InteractionContext r7 = (InteractionContext) r3;
        if (r7 == null) goto L12;
        Map r8 = (Map) r7.getRoomPlaceHolders().getValue();
        ALogger.i("ComponentsAlignService", "addPlaceHolderWidget, interactionContext hashcode=" + r7.hashCode() + "， roomPlaceHolders = " + r7.getRoomPlaceHolders().hashCode());
        if (r8.containsKey(r5) == false) goto L10;
        ALogger.i("ComponentsAlignService", "add placeholder widget for " + r5 + " twice");
        return;
    L10:
        Map r9 = MapsKt.plus(r8, MapsKt.mapOf(TuplesKt.to(r5, r6)));
        r7.getRoomPlaceHolders().setValue(r9);
        ALogger.i("ComponentsAlignService", "add placeholder widget map=" + r9);
        return;
    }

    public final <T> void callController(PreViewRoomControllerLifeCycle r3, T r4, long r5, Integer r7) {
        Intrinsics.checkNotNullParameter(r3, "lifeCycle");
        if (this.c.isPreviewCautious() == true) goto L5;
        return;
    L5:
        int r1 = fm2.m.a;
        Intrinsics.checkNotNullParameter(r3, "lifeCycle");
        if (r7 != null) goto L9;
        return;
    L9:
        switch(fm2.a.a[r3.ordinal()]) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L11;
            default: goto L39;
        };
    L11:
        int r6 = r7.intValue();
        IExternalFunctionInjector r8 = jc1.k.f(IExternalFunctionInjector.class);
        if (r8 == null) goto L14;
        r8.clearLiveRoomController(String.valueOf(r5), r6, ILiveRoomControllerProvider.ProviderSource.PREVIEW);
    L14:
        boolean r9 = j.a;
        j.a("roomId->" + r5 + " ====clearLiveRoomController, indentCode=" + r7 + '}');
        return;
    L15:
        fm2.m.a(new fm2.c(r4, r5, r7), r5, r7.intValue());
        return;
    L16:
        fm2.m.a(new fm2.b(r4, r5, r7), r5, r7.intValue());
        return;
    L17:
        fm2.m.a(new l(r4, r5, r7), r5, r7.intValue());
        return;
    L18:
        fm2.m.a(new fm2.k(r5, r7), r5, r7.intValue());
        return;
    L19:
        fm2.m.a(new fm2.j(r5, r7), r5, r7.intValue());
        return;
    L20:
        fm2.m.a(new i(r5, r7), r5, r7.intValue());
        return;
    L21:
        fm2.m.a(new h(r5, r7), r5, r7.intValue());
        return;
    L22:
        fm2.m.a(new fm2.g(r4, r5, r7), r5, r7.intValue());
        return;
    L23:
        fm2.m.a(new f(r4, r5, r7), r5, r7.intValue());
        return;
    L24:
        fm2.m.a(new e(r5, r7), r5, r7.intValue());
        return;
    L25:
        fm2.m.a(new fm2.d(r5, r7), r5, r7.intValue());
        return;
    }

    public final void injectPreviewBusinessContext(Context r7, DataCenter r8, long r9, Room r11) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r11, "room");
        ALogger.i("ComponentsAlignService", "injectPreviewBusinessContext, roomId=" + r9);
        CommonRoomContext r10 = getCommonRoomContext(r8, r9);
        if ((r10 instanceof RoomContext) == true) goto L5;
        r10 = null;
    L5:
        RoomContext r12 = (RoomContext) r10;
        Iterator<T> r13 = this.b.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        IInjectBusinessContext r14 = (IInjectBusinessContext) r13.next();
        long r1 = System.currentTimeMillis();
        r14.injectPreviewBusinessRoomContext(r7, r12, r8);
        ALogger.i("ComponentsAlignService", "it = " + r14 + ", inject context time: " + (System.currentTimeMillis() - r1));
        goto L7
    }

    public final void updateRoomControllerHandler(DataContext r3, DataCenter r4, Fragment r5, ILiveRoomViewHandler r6) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "roomViewHandler");
        if (r5 == null) goto L6;
        createInteractionContext(r4, r5);
    L6:
        if ((r6 instanceof SimpleLiveRoomViewHandler) == false) goto L23;
        Map r7 = ((SimpleLiveRoomViewHandler) r6).e;
        if ((r3 instanceof InteractionContext) == true) goto L10;
        r3 = null;
    L10:
        InteractionContext r8 = (InteractionContext) r3;
        if (r8 == null) goto L28;
        Map r9 = (Map) r8.getRoomPlaceHolders().getValue();
        Iterator r10 = r9.keySet().iterator();
    L14:
        if (r10.hasNext() == false) goto L29;
        ILayoutConstraint r11 = (ILayoutConstraint) r10.next();
        if (r7.containsKey(r11) == true) goto L22;
        Object r0 = r9.get(r11);
        if (r0 == null) goto L21;
        r7.put(r11, (com.bytedance.android.livesdk.room.placeholder.widget.d) r0);
        goto L22
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.room.placeholder.widget.IExternalWidgetPlaceHolder");
    L22:
        ALogger.i("ComponentsAlignService", "updateRoomControllerHandler, " + r11);
        goto L14
    L29:
        return;
    L28:
        return;
    }

    public final boolean createRoomContext(DataCenter r5, long r6, Integer r8, d r9, wlc.c r10) {
        if (this.a != null) goto L11;
        Pair<RoomContext, ? extends Disposable> r0 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        this.a = r0;
        if (r0 == null) goto L7;
        RoomContext r1 = (RoomContext) r0.getFirst();
    L8:
        if (r1 == null) goto L10;
        StringBuilder r2 = new StringBuilder();
        r2.append(r6);
        r2.append('_');
        r2.append(r8);
        r1.shareByUniqueId(r5, r2.toString());
    L10:
        ALogger.i("ComponentsAlignService", "=====init RoomContext, roomId=" + r6 + "=======");
        goto L11
    L7:
        r1 = null;
    L11:
        RoomContext.a r7 = RoomContext.Companion;
        RoomContext r3 = RoomContext.a.c(r7, r5, 0, 2);
        if (r3 == null) goto L17;
        com.bytedance.live.datacontext.j r4 = r3.getMessageManager();
        if (r4 == null) goto L17;
        r4.d(r9);
    L17:
        if ((r10 instanceof emc.a) == true) goto L19;
        r10 = null;
    L19:
        emc.a r11 = (emc.a) r10;
        if (r11 == null) goto L27;
        RoomContext r12 = RoomContext.a.c(r7, r5, 0, 2);
        if (r12 == null) goto L27;
        com.bytedance.live.datacontext.j r13 = r12.getStreamMessageManager();
        if (r13 == null) goto L27;
        r13.d(r11);
    L27:
        if (RoomContext.a.c(r7, r5, 0, 2) == null) goto L29;
        return true;
    L29:
        return false;
    }
}
