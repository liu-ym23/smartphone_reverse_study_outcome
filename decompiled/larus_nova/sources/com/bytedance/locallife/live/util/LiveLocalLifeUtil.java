package com.bytedance.locallife.live.util;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.camera.core.processing.util.GLUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.state.RoomState;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.locallife.host.ILifeBulletService;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class LiveLocalLifeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f260683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f260684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ObservableEmitter<Map<String, Object>> f260685c;

    public static final class a implements os6.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f260686a;

        @Override // os6.f
        public final void b() {
        }

        @Override // os6.f
        public final void a() {
            Function0<Unit> r100 = this.f260686a;
            if (r100 == null) goto L6;
            r100.invoke();
            return;
        }

        public a(Function0<Unit> r100) {
            this.f260686a = r100;
        }
    }

    public static final class b<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f260687a = null;

        static {
            f260687a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Map<String, Object>> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            LiveLocalLifeUtil.f260685c = r100;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f260688a = null;

        static {
            f260688a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.locallife.live.goodsshelves.manager.k.a((Map) r100, null);
        }
    }

    static {
        f260684b = true;
        Observable.create(b.f260687a).throttleFirst(500, TimeUnit.MILLISECONDS).subscribeOn(AndroidSchedulers.mainThread()).subscribe(c.f260688a);
    }

    public static String g() {
        String r100 = String.valueOf(LiveLifeSaaSUtil.u().e(LiveLifeSaaSUtil.q()));
        if (r100 != null) goto L6;
        return "-1";
    L6:
        return r100;
    }

    public static Object b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (LiveLifeSaaSUtil.y().containsKey(r100) == false) goto L9;
        Object r101 = LiveLifeSaaSUtil.y().get(r100);
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101;
    L9:
        return LiveLifeSaaSUtil.a(r100, Object.class, null);
    }

    public static JSONObject c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r101 = LiveLocalLifeViewModel.Companion.a(r100);
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        String r104 = "";
        if (r103 == false) goto L86;
        FragmentActivity r105 = o.a(r100);
        if (r105 == null) goto L13;
        Bundle r106 = LiveLifeSaaSUtil.f().getLiveLocalRoomInfo(r105, r100, true);
        JSONObject r107 = new JSONObject();
        if (r106 == null) goto L18;
        String r108 = r106.getString("room_id");
        if (r108 == null) goto L18;
    L19:
        r107.put("room_id", r108);
        if (r106 == null) goto L23;
        String r109 = r106.getString("anchor_id");
        if (r109 == null) goto L23;
    L24:
        r107.put("anchor_id", r109);
        if (r106 == null) goto L27;
        boolean r110 = r106.getBoolean(IPerformanceManager.Params.is_portrait);
    L28:
        r107.put(IPerformanceManager.Params.is_portrait, r110);
        if (r106 == null) goto L32;
        String r111 = r106.getString("is_life");
        if (r111 == null) goto L32;
    L33:
        r107.put("is_life", r111);
        if (r106 == null) goto L36;
        r102 = r106.getBoolean(IPerformanceManager.Params.is_anchor);
    L36:
        r107.put(IPerformanceManager.Params.is_anchor, r102);
        if (r106 == null) goto L40;
        String r112 = r106.getString("enter_method");
        if (r112 == null) goto L40;
    L41:
        r107.put("enter_method", r112);
        if (r106 == null) goto L45;
        String r113 = r106.getString("action_type");
        if (r113 == null) goto L45;
    L46:
        r107.put("action_type", r113);
        if (r106 == null) goto L50;
        String r114 = r106.getString("video_id");
        if (r114 == null) goto L50;
    L51:
        r107.put("video_id", r114);
        if (r106 == null) goto L55;
        String r115 = r106.getString("request_id");
        if (r115 == null) goto L55;
    L56:
        r107.put("request_id", r115);
        if (r106 == null) goto L62;
        String r116 = r106.getString("enter_from_merge");
        if (r116 == null) goto L62;
        r104 = r116;
    L62:
        r107.put("enter_from_merge", r104);
        return r107;
    L55:
        r115 = "";
    L50:
        r114 = "";
    L45:
        r113 = "";
    L40:
        r112 = "";
    L32:
        r111 = "";
        goto L33
    L27:
        r110 = false;
    L23:
        r109 = "";
    L18:
        r108 = "";
        goto L19
    L13:
        return new JSONObject();
    L86:
        FragmentActivity r117 = o.a(r100);     // Catch: Exception -> L85
        if (r117 == null) goto L83;
        JSONObject r118 = LiveLifeSaaSUtil.x().a(r117);     // Catch: Exception -> L85
        if (r118 == null) goto L83;
        Bundle r119 = LiveLifeSaaSUtil.f().getLiveLocalRoomInfo(r117, r100, true);     // Catch: Exception -> L85
        if (r119 == null) goto L75;
        String r120 = r119.getString("room_id", "");     // Catch: Exception -> L85
        if (r120 == null) goto L75;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r120) == false) goto L75;
        r118.put("room_id", r120);     // Catch: Exception -> L85
    L75:
        if (com.bytedance.locallife.live.experiment.a.a() == false) goto L89;
        if (r119 == null) goto L89;
        String r121 = r119.getString("enter_from_merge", "");     // Catch: Exception -> L85
        if (r121 == null) goto L89;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r121) == false) goto L89;
        r118.put("enter_from_merge", r121);     // Catch: Exception -> L85
    L89:
        return r118;
    L83:
        return null;
    L5:
        if (r101.isPreview() != true) goto L7;
        r103 = true;
        goto L8
    }

    @JvmStatic
    public static final Room d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        FragmentActivity r101 = o.a(r100);
        if (r101 == null) goto L7;
        Object r102 = LiveLifeSaaSUtil.f().getRoomInfoByUniqueKey(r101, r100);
        if ((r102 instanceof Room) == false) goto L7;
        return (Room) r102;
    L7:
        return null;
    }

    @JvmStatic
    public static final LiveLocalLifeRoomInfo e(String r110) {
        Intrinsics.checkNotNullParameter(r110, "uniqueKey");
        LiveLocalLifeRoomInfo r100 = new LiveLocalLifeRoomInfo();
        FragmentActivity r101 = o.a(r110);
        if (r101 != null) goto L5;
        return r100;
    L5:
        it6.f r102 = LiveLifeSaaSUtil.f();
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r103 = LiveLocalLifeViewModel.Companion.a(r110);
        boolean r104 = false;
        if (r103 == null) goto L8;
        boolean r105 = r103.isPreview();
    L9:
        Bundle r106 = r102.getLiveLocalRoomInfo(r101, r110, r105);
        JSONObject r107 = c(r110);     // Catch: Exception -> L12
    L13:
        r100.setUniqueKey(r110);
        if (r106 == null) goto L19;
        r100.setRoomId(r106.getString("room_id", ""));
        r100.setAnchorId(r106.getString("anchor_id", ""));
        r100.setEnterMethod(r106.getString("enter_method", ""));
        if (com.bytedance.locallife.live.experiment.a.a() == false) goto L18;
        r100.setEnterFromMerge(r106.getString("enter_from_merge", ""));
    L18:
        r100.setClickMethod(r106.getString("click_method", ""));
        r100.setActionType(r106.getString("action_type", ""));
        r100.setVideoId(r106.getString("video_id", ""));
        r100.setRequestId(r106.getString("request_id", ""));
        r100.setAnchor(r106.getBoolean(IPerformanceManager.Params.is_anchor, false));
        r100.setPortrait(r106.getBoolean(IPerformanceManager.Params.is_portrait, false));
        r100.setEnterLocalLifeLiveParams(r106.getString(RoomState.EXTRA_DATA_ENTER_LOCALLIFT_LIVE_PARAMS, ""));
        r100.setEnterLocalLifeLiveActionParams(r106.getString("locallife_live_enter_action_params", ""));
        r100.setEnterLocalLifeLiveEnvParams(r106.getString(RoomState.EXTRA_DATA_ENTER_LOCALLIFT_LIVE_ENV_PARAMS, ""));
        r100.setSearchParams(r106.getString("search_params", ""));
        r100.setSearchId(r106.getString("search_id", ""));
        r100.setSearchResultId(r106.getString("search_result_id", ""));
        r100.setImTrackerExtra(r106.getString(ILiveRoomPlayFragmentConstant.EXTRA_IM_TRACKER_EXTRA, ""));
        r100.setExtraParams(r106.getString("extra_params", ""));
        r100.setDeliveryStatusStart(r106.getString("delivery_status_start", ""));
        r100.setLogPb(r106.getString("log_pb", ""));
        r100.setLife(r106.getString("is_life", ""));
        r100.setFeedRespFrom(r106.getString(ILiveRoomPlayFragmentConstant.EXTRA_FEED_RESP_FROM, ""));
        r100.setLifeRefluxInfo(r106.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIFE_REFLUX_INFO, ""));
        r100.setLifeShareRefluxInfo(r106.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIFE_SHARE_REFLUX_INFO, ""));
        r100.setLifeShareId(r106.getString("life_share_id", ""));
        r100.setLifeLivePackComponentConfig(r106.getString("life_live_pack_component_config", ""));
        r100.setLiveLifeEnterParamsString(r106.getString("life_enter_params", ""));
        r100.setLiveRecommendInfo(r106.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO, ""));
    L21:
        if (r107 != null) goto L23;
    L30:
        return r100;
    L23:
        if (com.bytedance.locallife.live.experiment.a.a() == true) goto L25;
    L28:
        r100.setEnterFromMerge(r107.optString("enter_from_merge"));
    L29:
        r100.setOtherChannel(r107.optString("is_other_channel"));
        r100.setLogExtra(r107.optString("log_extra"));
        r100.setCid(r107.optString("creative_id"));
        goto L30
    L25:
        if (r100.getEnterFromMerge().length() != 0) goto L27;
        r104 = true;
    L27:
        if (r104 == false) goto L29;
    L19:
        if (r107 == null) goto L21;
        r100.setRoomId(r107.optString("room_id"));
        r100.setAnchorId(r107.optString("anchor_id"));
        r100.setEnterMethod(r107.optString("enter_method"));
        r100.setActionType(r107.optString("action_type"));
        r100.setVideoId(r107.optString("video_id", ""));
        r100.setRequestId(r107.optString("request_id"));
    L12:
        r107 = null;
        goto L13
    L8:
        r105 = false;
        goto L9
    }

    @JvmStatic
    public static final String f(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r101 = LiveLocalLifeViewModel.Companion.a(r100);
        if (r101 == null) goto L14;
        LiveLocalLifeRoomInfo r102 = r101.getRoomInfo();
        if (r102 == null) goto L15;
        String r103 = r102.getRoomId();
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    L15:
        return "";
    L14:
        return "";
    }

    @JvmStatic
    public static final Map<String, Object> h(String r110) {
        Intrinsics.checkNotNullParameter(r110, "uniqueKey");
        Room r100 = d(r110);
        LiveLocalLifeRoomInfo r111 = e(r110);
        Pair[] r101 = new Pair[8];
        Pair[] r102 = new Pair[6];
        r102[0] = TuplesKt.to("enter_from_merge", r111.getEnterFromMerge());
        r102[1] = TuplesKt.to("anchor_id", r111.getAnchorId());
        r102[2] = TuplesKt.to("room_id", r111.getRoomId());
        r102[3] = TuplesKt.to("action_type", r111.getActionType());
        r102[4] = TuplesKt.to("request_id", r111.getRequestId());
        if (r100 == null) goto L11;
        User r103 = r100.mo8271getOwner();
        if (r103 == null) goto L11;
        FollowInfo r104 = r103.getFollowInfo();
        if (r104 == null) goto L11;
        if (r104.isFollowing() != true) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        String r106 = "1";
    L15:
        r102[5] = TuplesKt.to("is_following", r106);
        r101[0] = TuplesKt.to(ILiveRoomPlayFragmentConstant.LIVE_ROOM_DATA, MapsKt.mutableMapOf(r102));
        r101[1] = TuplesKt.to("video_id", r111.getVideoId());
        r101[2] = TuplesKt.to("enter_method", r111.getEnterMethod());
        r101[3] = TuplesKt.to("cid", r111.getCid());
        r101[4] = TuplesKt.to("log_extra", r111.getLogExtra());
        r101[5] = TuplesKt.to("is_other_channel", r111.isOtherChannel());
        r101[6] = TuplesKt.to("log_pb", r111.getLogPb());
        r101[7] = TuplesKt.to("is_life", r111.isLife());
        return MapsKt.mutableMapOf(r101);
    L14:
        r106 = "0";
    L11:
        r105 = false;
        goto L12
    }

    @JvmStatic
    public static final String i(Float r110) {
        if (r110 == null) goto L4;
        Float r100 = Float.valueOf(r110.floatValue() / 100.0f);
    L5:
        if (r100 != null) goto L7;
        return "";
    L7:
        if (r100.floatValue() > 9999) goto L26;
        String r111 = new DecimalFormat("0.00").format(r100);
        if (StringsKt.indexOf$default(r111, ".00", 0, false, 6, null) == (-1)) goto L12;
        r111 = StringsKt.replace$default(r111, ".00", "", false, 4, null);
    L25:
        return "￥" + r111;
    L12:
        if (StringsKt.indexOf$default(r111, ".", 0, false, 6, null) == (-1)) goto L25;
        if (r111.charAt(r111.length() - 1) != '0') goto L25;
        if (r111.length() <= 0) goto L18;
        boolean r101 = true;
    L19:
        if (r101 == false) goto L25;
        r111 = r111.substring(0, r111.length() - 1);
        goto L25
    L18:
        r101 = false;
        goto L19
    L26:
        return "￥" + new DecimalFormat(GLUtils.VERSION_UNKNOWN).format(Float.valueOf(r110.floatValue() / 1000000.0f)) + 19975;
    L4:
        r100 = null;
        goto L5
    }

    @JvmStatic
    public static final boolean j(Integer r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L11:
        return false;
    L9:
        if (r100.intValue() != 17) goto L11;
    L12:
        return true;
    L5:
        if (r100.intValue() == 16) goto L12;
        goto L6
    }

    public static void k(final String r110, Context r111) {
        Intrinsics.checkNotNullParameter(r110, "url");
        boolean r100 = true;
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        i r102 = j.f260705a;
        Intrinsics.checkNotNullParameter(r110, "url");
        String r103 = "";
        if (StringsKt.contains$default(r110, "show_live_window_when_open_next_page", false, 2, null) == false) goto L18;
        Uri r104 = UriProtector.parse(r110);
        String r105 = UriProtector.getQueryParameter(r104, "show_live_window_when_open_next_page");
        if (r105 == null) goto L13;
        int r106 = CastIntegerProtector.parseInt(r105);
    L14:
        String r107 = UriProtector.getQueryParameter(r104, "show_live_window_request_page");
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        j.b(r106, r107);
        goto L18
    L13:
        r106 = 0;
    L18:
        if (r111 != null) goto L64;
        r111 = LiveLifeSaaSUtil.s().getCurrentActivity();
        if (r111 != null) goto L64;
        return;
    L64:
        Uri r108 = UriProtector.parse(r110);     // Catch: Exception -> L58
        String r109 = r108.getAuthority();     // Catch: Exception -> L58
        if (r109 != null) goto L26;
        r109 = "";
    L26:
        String r112 = r108.getScheme();     // Catch: Exception -> L58
        if (r112 != null) goto L29;
        r112 = "";
    L29:
        String r113 = r108.getPath();     // Catch: Exception -> L58
        if (r113 == null) goto L36;
        String r114 = StringsKt.trimEnd(r113, new char[]{'/'});     // Catch: Exception -> L58
        if (r114 == null) goto L36;
        r103 = r114;
    L36:
        if (Intrinsics.areEqual(r112, "http") == true) goto L59;
        if (Intrinsics.areEqual(r112, "https") == true) goto L59;
        if (StringsKt.startsWith$default(r110, "aweme://lynxview", false, 2, null) == false) goto L44;
    L47:
        boolean r115 = true;
    L49:
        if (StringsKt.endsWith$default(r109, "_popup", false, 2, null) == true) goto L54;
        if (StringsKt.endsWith$default(r103, "_popup", false, 2, null) == true) goto L54;
        boolean r116 = false;
    L55:
        if (r115 == false) goto L59;
        if (r116 == false) goto L59;
    L60:
        if (r100 == false) goto L62;
        ConcurrentHashMap<Class<?>, Object> r117 = LifeServiceManager.f162660a;
        ((ILifeBulletService) LifeServiceManager.b(ILifeBulletService.class)).open(r111, r110, null, new LiveLocalLifeUtil$openSchema$1(r110));
        return;
    L62:
        LiveLifeSaaSUtil.k().openSchema(r111, r110);
        return;
    L54:
        r116 = true;
        goto L55
    L44:
        if (StringsKt.endsWith$default(r109, "_popup", false, 2, null) == true) goto L47;
        r115 = false;
    L59:
        r100 = false;
        goto L60
    L5:
        r101 = false;
        goto L6
    }

    @JvmStatic
    public static final <T> void l(View r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (com.bytedance.locallife.common.utils.g.a(r100) == false) goto L5;
        return;
    L5:
        r101.invoke();
    }

    @JvmStatic
    public static final void a(Context r100, Function0<Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (LiveLifeSaaSUtil.B() == true) goto L7;
        LiveLifeSaaSUtil.b().g(r100, "live_detail", "live_room", new a(r101));
        if (r102 == null) goto L10;
        r102.invoke();
        return;
    L10:
        return;
    L7:
        if (r101 == null) goto L12;
        r101.invoke();
        return;
    }
}
