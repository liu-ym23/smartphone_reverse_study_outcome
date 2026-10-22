package ft1;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.config.mm;
import com.bytedance.android.livesdk.config.xm0;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements is2.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f478754f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f478755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f478756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f478757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f478758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RoomBaseSession f478759e;

    public static final class a {
    }

    static {
    }

    @Override // is2.g
    public final String businessTypeV2() {
        return "RoomCrashObserver";
    }

    @Override // tw2.a
    public final Map<String, Object> getEnvData() {
        return null;
    }

    @Override // tw2.b
    public final Map<String, Object> getPropertyParams() {
        return null;
    }

    @Override // tw2.b
    public final String getSpm() {
        return null;
    }

    @Override // tw2.b
    public final boolean isIgnored() {
        return false;
    }

    @Override // is2.g
    public final void onOrientationChangeV2(int r100) {
    }

    @Override // is2.g
    public final void onRoomBackgroundV2() {
    }

    public e(RoomBaseSession r100) {
        this.f478758d = SourceType.DEFAULT;
        this.f478759e = r100;
        this.f478755a = new CompositeDisposable();
    }

    @Override // is2.g
    public final void onRoomPrepareV2(boolean r100) {
        if (r100 == false) goto L5;
        int r101 = b.f478750a;
        ALogger.i("LiveCrashTagRecorder", hashCode() + ":room prepare");
        Map<String, String> r102 = d.f478752a;
        d.d(hashCode());
        d.c(MapsKt.mapOf(new Pair[]{TuplesKt.to("live_sdk_entered", "false"), TuplesKt.to("live_room_source", this.f478758d)}), hashCode());
        return;
    }

    @Override // is2.g
    public final void onRoomEnterV2(Room r100, ls2.a r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r101, "enterExtra");
        Room r102 = (Room) jm2.a.e(r100);
        int r103 = b.f478750a;
        if (mm.f120767a.getValue().b() == false) goto L12;
        if (r102 == null) goto L12;
        RoomBaseSession r104 = this.f478759e;
        if (r104 == null) goto L12;
        Context r105 = r104.getContext();
        if (r105 == null) goto L12;
        ALogger.i("LiveCrashTagRecorder", "LiveRoomCrashRecover create");
        if ((r105 instanceof Activity) == false) goto L12;
        j r106 = new j((Activity) r105, this.f478759e);
        Intrinsics.checkNotNullParameter(r102, "room");
        ALogger.i("LiveCrashTagRecorder", "LiveRoomCrashRecover enter room");
        r106.f478769b = String.valueOf(r102.f162599id);
        r106.f478770c = System.currentTimeMillis();
        Unit r107 = Unit.INSTANCE;
        this.f478757c = r106;
    L12:
        ALogger.i("LiveCrashTagRecorder", hashCode() + ":room enter");
        int r108 = c.f478751a;
        LinkedHashMap r109 = new LinkedHashMap();
        if (r102 != null) goto L93;
    L40:
        r109.put("live_sdk_entered", "true");
        Map<String, String> r110 = d.f478752a;
        d.c(r109, hashCode());
        MiddlewareRoomContext.a r111 = MiddlewareRoomContext.Companion;
        if (r102 == null) goto L43;
        long r112 = r102.getRoomId();
    L44:
        MiddlewareRoomContext r113 = MiddlewareRoomContext.a.c(r111, null, r112, 1);
        IInteractService r114 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: Exception -> L85
        if (r114 == null) goto L50;
        int r115 = r114.getCurrentScene();     // Catch: Exception -> L85
        if (r115 < 0) goto L50;
        d.b(String.valueOf(r115), hashCode());     // Catch: Exception -> L85
    L50:
        if (r113 == null) goto L62;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r116 = r113.getVideoTalkRoomSubScene();     // Catch: Exception -> L85
        if (r116 == null) goto L62;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r117 = r116.getValue();     // Catch: Exception -> L85
        if (r117 == null) goto L62;
        BehaviorSubject r118 = r117.a();     // Catch: Exception -> L85
        if (r118 == null) goto L62;
        Disposable r119 = r118.subscribe(new g(this));     // Catch: Exception -> L85
        if (r119 == null) goto L62;
        CompositeDisposable r120 = this.f478755a;     // Catch: Exception -> L85
        if (r120 == null) goto L62;
        r120.add(r119);     // Catch: Exception -> L85
    L62:
        if (r113 == null) goto L74;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r121 = r113.getVoiceTalkRoomSubScene();     // Catch: Exception -> L85
        if (r121 == null) goto L74;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r122 = r121.getValue();     // Catch: Exception -> L85
        if (r122 == null) goto L74;
        BehaviorSubject r123 = r122.a();     // Catch: Exception -> L85
        if (r123 == null) goto L74;
        Disposable r124 = r123.subscribe(new h(this));     // Catch: Exception -> L85
        if (r124 == null) goto L74;
        CompositeDisposable r125 = this.f478755a;     // Catch: Exception -> L85
        if (r125 == null) goto L74;
        r125.add(r124);     // Catch: Exception -> L85
    L74:
        if (r113 == null) goto L87;
        m<Boolean> r126 = r113.isMultiAnchorLinkOn();     // Catch: Exception -> L85
        if (r126 == null) goto L87;
        Observable<Boolean> r127 = r126.a();     // Catch: Exception -> L85
        if (r127 == null) goto L87;
        Disposable r128 = r127.subscribe(new i(this));     // Catch: Exception -> L85
        if (r128 == null) goto L87;
        CompositeDisposable r129 = this.f478755a;     // Catch: Exception -> L85
        if (r129 == null) goto L87;
        r129.add(r128);     // Catch: Exception -> L85
    L87:
        int r130 = b.f478750a;
        xm0 r131 = xm0.f121617a;
        if (r131.getValue().booleanValue() == true) goto L90;
        return;
    L90:
        if (r131.getValue().booleanValue() == false) goto L98;
        f r132 = new f(this, new WeakReference(this.f478759e));
        this.f478756b = r132;
        Npth.registerCrashCallback(r132, CrashType.ALL);
        return;
    L98:
        return;
    L85:
        e = move-exception;
        int r133 = b.f478750a;
        ALogger.e("LiveCrashTagRecorder", "monitor live scene error:" + e.toString());
        goto L87
    L43:
        r112 = 0;
        goto L44
    L93:
        EpisodeExtraInfo r134 = r102.getEpisodeExtra2();     // Catch: Exception -> L38
        if (r134 == null) goto L19;
        Long r135 = r134.getSeasonId();     // Catch: Exception -> L38
        if (r135 == null) goto L19;
        r109.put("live_season_id", String.valueOf(r135.longValue()));     // Catch: Exception -> L38
    L19:
        r109.put(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID, String.valueOf(r102.getRoomId()));     // Catch: Exception -> L38
        r109.put("live_anchor_id", r102.getOwnerUserIdString());     // Catch: Exception -> L38
        LiveMode r136 = r102.getStreamType();     // Catch: Exception -> L38
        int r137 = h1.f66189a;     // Catch: Exception -> L38
        r109.put("live_room_type", i1.a(r136));     // Catch: Exception -> L38
        if (r102.isPaidRoom() == false) goto L22;
        String r138 = "1";
    L23:
        r109.put("is_paidlive", r138);     // Catch: Exception -> L38
        EpisodeExtraInfo r139 = r102.getEpisodeExtra2();     // Catch: Exception -> L38
        if (r139 == null) goto L30;
        IBaseEpisodeMod r140 = r139.getMod();     // Catch: Exception -> L38
        if (r140 == null) goto L30;
        String r141 = c.a(Integer.valueOf(r140.getEpisodeStage()));     // Catch: Exception -> L38
        if (r141 == null) goto L30;
        r109.put("live_episode_stage", r141);     // Catch: Exception -> L38
    L30:
        String r142 = c.b(r102.getEpisodeExtra2());     // Catch: Exception -> L38
        if (r142 == null) goto L33;
        r109.put("live_episode_sub_type", r142);     // Catch: Exception -> L38
    L33:
        String r143 = g4.d();     // Catch: Exception -> L38
        if (r143 == null) goto L36;
        r109.put("enter_from_merge", r143);     // Catch: Exception -> L38
    L36:
        r109.put("enter_method", g4.e());     // Catch: Exception -> L38
        Unit r144 = Unit.INSTANCE;     // Catch: Exception -> L38
        goto L40
    L22:
        r138 = "0";
    L38:
        e = move-exception;
        ALogger.e("LiveCrashTag", "get room info map error:" + e.toString());
        Unit r145 = Unit.INSTANCE;
        goto L40
    }

    @Override // is2.g
    public final void onRoomPreloadV2(Room r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r100, "room");
    }

    @Override // is2.g
    public final void onRoomExitV2(long r100, String r101, boolean r102, Room r103, ls2.e r104, boolean r105, EndReason r106) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r104, "error");
        Intrinsics.checkNotNullParameter(r106, "reason");
        if (r105 == true) goto L20;
        return;
    L20:
        j r107 = this.f478757c;     // Catch: Exception -> L17
        if (r107 == null) goto L9;
        int r108 = b.f478750a;     // Catch: Exception -> L17
        ALogger.i("LiveCrashTagRecorder", "LiveRoomCrashRecover exit room");     // Catch: Exception -> L17
        r107.f478769b = "";     // Catch: Exception -> L17
    L9:
        this.f478757c = null;     // Catch: Exception -> L17
        int r109 = b.f478750a;     // Catch: Exception -> L17
        ALogger.i("LiveCrashTagRecorder", hashCode() + ":room exit");     // Catch: Exception -> L17
        f r110 = this.f478756b;     // Catch: Exception -> L17
        if (r110 == null) goto L12;
        Npth.unregisterCrashCallback(r110, CrashType.ALL);     // Catch: Exception -> L17
        this.f478756b = null;     // Catch: Exception -> L17
    L12:
        CompositeDisposable r111 = this.f478755a;     // Catch: Exception -> L17
        if (r111 == null) goto L15;
        r111.dispose();     // Catch: Exception -> L17
    L15:
        Map<String, String> r112 = d.f478752a;     // Catch: Exception -> L17
        d.a(hashCode());     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        int r113 = b.f478750a;
        ALogger.e("LiveCrashTagRecorder", "exit room error:" + e.toString());
    }
}
