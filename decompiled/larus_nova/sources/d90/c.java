package d90;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.oj1;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MatchDrawer;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSConfigDrawer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import ju1.n;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {
    public static final boolean a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$enableLandscapeDrawerEntrance");
        if (l(r100) == false) goto L25;
        Intrinsics.checkNotNullParameter(r100, "$this$isVSSpecialDrawerSupportLandscape");
        Integer[] r101 = {3, 2};
        Room r102 = q(r100);
        if (r102 == null) goto L15;
        EpisodeExtraInfo r103 = r102.getEpisodeExtra2();
        if (r103 == null) goto L15;
        VSConfigDrawer r104 = r103.getVsConfigDrawer();
        if (r104 == null) goto L15;
        MatchDrawer r105 = r104.drawer;
        if (r105 == null) goto L15;
        Integer r106 = r105.getDisplayMode();
        if (r106 == null) goto L15;
        int r107 = r106.intValue();
    L17:
        if (ArraysKt.contains(r101, Integer.valueOf(r107)) == true) goto L19;
    L21:
        boolean r108 = false;
    L22:
        if (r108 == false) goto L26;
        return true;
    L26:
        return false;
    L19:
        if (oj1.f120911a.getValue().c() == false) goto L21;
        r108 = true;
    L15:
        r107 = 0;
        goto L17
    L25:
        return false;
    }

    public static final boolean c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAnchor");
        return z.e(r100.f467480h, false);
    }

    public static final boolean d(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isCommentaryRoom");
        Room r101 = q(r100);
        RoomSpecificSceneTypeInfo r102 = null;
        if (r101 == null) goto L5;
        RoomSpecificSceneTypeInfo r103 = r101.getSceneTypeInfo();
    L7:
        if ((r103 instanceof RoomSpecificSceneTypeInfo) == false) goto L10;
        r102 = r103;
    L10:
        if (r102 != null) goto L12;
    L14:
        return false;
    L12:
        if (r102.isCommentaryRoom() != true) goto L14;
        return true;
    L5:
        r103 = null;
        goto L7
    }

    public static final boolean e(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isHorizontalStream");
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, r100.f467480h, 0, 2);
        if (r101 == null) goto L7;
        m<Room> r102 = r101.getRoom();
        if (r102 == null) goto L7;
        Room r103 = r102.getValue();
    L9:
        if (r103 == null) goto L21;
        StreamUrl r104 = r103.getStreamUrl();
        if (r104 != null) goto L13;
    L15:
        StreamUrlExtra r105 = r103.getStreamUrlExtraSafely();
        if (r105.getWidth() <= r105.getHeight()) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L21;
        return true;
    L18:
        r106 = false;
        goto L19
    L13:
        if (r104.getStreamOrientation() != 2) goto L15;
        return true;
    L21:
        return false;
    L7:
        r103 = null;
        goto L9
    }

    public static final boolean f(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLandscape");
        return !i(r100);
    }

    public static final boolean g(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLandscapeMarginOpt");
        if (f(r100) == false) goto L11;
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, r100.f467480h, 0, 2);
        if (r101 == null) goto L11;
        m<Boolean> r102 = r101.isOptLandscapeMargin();
        if (r102 == null) goto L11;
        if (r102.getValue().booleanValue() != true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean h(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMediaOrVs");
        if (e.b(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (k(r100) == true) goto L8;
        return false;
    }

    public static final boolean i(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isPortrait");
        DataCenter r101 = r100.f467480h;
        if (r101 == null) goto L7;
        Boolean r102 = (Boolean) r101.get("data_is_portrait", Boolean.TRUE);
        if (r102 == null) goto L7;
        return r102.booleanValue();
    L7:
        return true;
    }

    public static final boolean j(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVSFirstShow");
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, r100.f467480h, 0, 2);
        if (r101 == null) goto L13;
        Room r102 = r101.getVsRoom();
        if (r102 == null) goto L13;
        EpisodeExtraInfo r103 = r102.getEpisodeExtra2();
        if (r103 == null) goto L13;
        IBaseEpisodeMod r104 = r103.getMod();
        if (r104 == null) goto L13;
        if (r104.getEpisodeStage() != EpisodeMod.EpisodeStageType.PREMIERE) goto L13;
        return true;
    L13:
        return false;
    }

    public static final boolean k(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVSRoom");
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, r100.f467480h, 0, 2);
        if (r101 == null) goto L7;
        Room r102 = r101.getVsRoom();
        if (r102 == null) goto L7;
        return r102.isMergeVSRoom();
    L7:
        return false;
    }

    public static final boolean l(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVSSpecialDrawer");
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, r100.f467480h, 0, 2);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isVSSpecialDrawer() != true) goto L7;
        return true;
    }

    public static final boolean m(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVSSpecialDrawerSupportPortrait");
        Integer[] r101 = {3, 1};
        Room r102 = q(r100);
        if (r102 == null) goto L13;
        EpisodeExtraInfo r103 = r102.getEpisodeExtra2();
        if (r103 == null) goto L13;
        VSConfigDrawer r104 = r103.getVsConfigDrawer();
        if (r104 == null) goto L13;
        MatchDrawer r105 = r104.drawer;
        if (r105 == null) goto L13;
        Integer r106 = r105.getDisplayMode();
        if (r106 == null) goto L13;
        int r107 = r106.intValue();
    L15:
        if (ArraysKt.contains(r101, Integer.valueOf(r107)) == true) goto L17;
        return false;
    L17:
        if (oj1.f120911a.getValue().f() == false) goto L21;
        return true;
    L21:
        return false;
    L13:
        r107 = 0;
        goto L15
    }

    public static final boolean n(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVSVerticalStream");
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, r100.f467480h, 0, 2);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isVSVerticalStream() != true) goto L7;
        return true;
    }

    public static final LiveMode o(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$liveMode");
        DataCenter r101 = r100.f467480h;
        if (r101 != null) goto L5;
        return null;
    L5:
        return (LiveMode) r101.get("data_live_mode", null);
    }

    public static final int p(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$loadStrategy");
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, r100.f467480h, 0, 2);
        if (r101 == null) goto L14;
        j<IDynamicStrategyContext> r102 = r101.getDynamicStrategy();
        if (r102 == null) goto L15;
        IDynamicStrategyContext r103 = r102.getValue();
        if (r103 == null) goto L16;
        PropertyOwner<n> r104 = r103.getStrategy("live_component_strategy");
        if (r104 == null) goto L17;
        n r105 = r104.f64752a;
        if (r105 != null) goto L13;
        return 0;
    L13:
        return r105.b(0);
    L17:
        return 0;
    L16:
        return 0;
    L15:
        return 0;
    L14:
        return 0;
    }

    public static final Room q(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$room");
        DataCenter r101 = r100.f467480h;
        if (r101 != null) goto L5;
        return null;
    L5:
        return (Room) r101.get("data_room", null);
    }

    public static final void b(a r100, j70.f r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$initShowState");
        Intrinsics.checkNotNullParameter(r101, "elementType");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        DataCenter r104 = r100.f467480h;     // Catch: Throwable -> L8
        DataCenter r105 = null;
        if (r104 == null) goto L6;
        r105 = r104.put("data_component_show_state", new kw2.a("state_init", r101.f497559b, null, r102));     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
