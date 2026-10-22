package to1;

import am2.n;
import am2.x;
import com.bytedance.android.live.base.model.message.h1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.utils.i3;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.q;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends z40.a<ActivityTopBannerViewIntent, com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a> {

    /* JADX INFO: renamed from: to1.a$a, reason: collision with other inner class name */
    public static final class C7748a {
    }

    static {
    }

    public final JSONObject c() {
        JSONObject r100 = new JSONObject();
        o r101 = j0.l().c(x.class);
        String r102 = null;
        String r103 = "";
        if ((r101 instanceof t) == false) goto L19;
        t r104 = (t) r101;
        if (r104.getMap().containsKey("enter_from") == false) goto L7;
        String r105 = r104.getMap().get("enter_from");
    L9:
        if (r104.getMap().containsKey("source") == false) goto L11;
        String r106 = r104.getMap().get("source");
    L12:
        HashMap r107 = new HashMap();
        if (r105 == null) goto L18;
        if (r106 == null) goto L18;
        r r108 = z51.a.c(null, 0);
        if (r108 == null) goto L18;
        r108.dataMapping(r105, r106, r107);
    L18:
        String r109 = (String) r107.get("enter_from_merge");
        String r110 = (String) r107.get("enter_method");
    L20:
        o r111 = j0.l().c(n.class);
        if ((r111 instanceof q) == false) goto L30;
        q r112 = (q) r111;
        if (r112.getMap().containsKey(ILiveRoomPlayFragmentConstant.IES_LIVE_EFFECT_AD_TRACK_EXTRA_SERVICE) == false) goto L25;
        String r113 = r112.getMap().get(ILiveRoomPlayFragmentConstant.IES_LIVE_EFFECT_AD_TRACK_EXTRA_SERVICE);
    L27:
        if (r112.getMap().containsKey("ad_extra_data") == false) goto L29;
        String r114 = r112.getMap().get("ad_extra_data");
    L31:
        DataCenter r115 = this.f569886b;
        if (r115 == null) goto L34;
        IRoom r116 = (IRoom) r115.get("data_room", null);
    L35:
        DataCenter r117 = this.f569886b;
        if (r117 == null) goto L40;
        Boolean r118 = (Boolean) r117.get("data_is_anchor", Boolean.FALSE);
        if (r118 == null) goto L40;
        boolean r119 = r118.booleanValue();
    L41:
        JSONObject r120 = r100.put("enter_from_merge", r109).put("enter_method", r110);
        if (r119 == false) goto L44;
        String r121 = "live_take_detail";
    L45:
        JSONObject r122 = r120.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r121);
        if (r116 == null) goto L48;
        Long r123 = Long.valueOf(r116.getId());
    L49:
        JSONObject r124 = r122.put("room_id", String.valueOf(r123));
        if (r116 == null) goto L55;
        String r125 = r116.getOwnerUserIdString();
        if (r125 == null) goto L55;
        r103 = r125;
    L55:
        JSONObject r126 = r124.put("anchor_id", r103);
        if (r116 == null) goto L58;
        String r127 = r116.getRequestId();
    L59:
        JSONObject r128 = r126.put("request_id", r127);
        if (r116 == null) goto L62;
        r102 = r116.getLog_pb();
    L62:
        r128.put("log_pb", r102).put(ILiveRoomPlayFragmentConstant.IES_LIVE_EFFECT_AD_TRACK_EXTRA_SERVICE, r113).put("ad_extra_data", r114);
        return r100;
    L58:
        r127 = null;
        goto L59
    L48:
        r123 = null;
        goto L49
    L44:
        r121 = "live_detail";
    L40:
        r119 = false;
        goto L41
    L34:
        r116 = null;
        goto L35
    L29:
        r114 = "";
        goto L31
    L25:
        r113 = "";
        goto L27
    L30:
        r114 = "";
        r113 = r114;
        goto L31
    L11:
        r106 = "";
        goto L12
    L7:
        r105 = "";
        goto L9
    L19:
        r109 = "";
        r110 = r109;
        goto L20
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.utils.f2
    public final void a(ActivityTopBannerViewIntent r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        if ((r110 instanceof ActivityTopBannerViewIntent.a) == false) goto L10;
        ActivityTopBannerViewIntent.a r111 = (ActivityTopBannerViewIntent.a) r110;
        h1 r100 = r111.f115104a;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getExtra() == null) goto L131;
        ALogger.i("tag_banner_TOP", "message = " + r111.f115104a);
        Single.just(r111.f115104a.getExtra()).observeOn(Schedulers.io()).map(c.f546895a).map(new d(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r111));
        return;
    L131:
        return;
    L10:
        boolean r101 = true;
        if ((r110 instanceof ActivityTopBannerViewIntent.c) == false) goto L19;
        int r112 = b.f546893a[((ActivityTopBannerViewIntent.c) r110).f115106a.ordinal()];
        if (r112 == 1) goto L17;
        if (r112 != 2) goto L132;
        JSONObject r113 = new JSONObject();
        JSONObject r102 = new JSONObject();
        r102.put("foreground", true);
        r113.put("type", "app");
        r113.put("args", r102);
        Unit r103 = Unit.INSTANCE;
        b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("H5_appStateChange", r113));
        return;
    L132:
        return;
    L17:
        JSONObject r114 = new JSONObject();
        JSONObject r104 = new JSONObject();
        r104.put("foreground", false);
        r114.put("type", "app");
        r114.put("args", r104);
        Unit r105 = Unit.INSTANCE;
        b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("H5_appStateChange", r114));
        return;
    L19:
        if ((r110 instanceof ActivityTopBannerViewIntent.f) == false) goto L39;
        ActivityTopBannerViewIntent.f r115 = (ActivityTopBannerViewIntent.f) r110;
        if (r115.f115110a == null) goto L133;
        JSONObject r106 = new JSONObject();
        JSONObject r107 = new JSONObject();
        IBaseUser.Status r116 = r115.f115110a.getStatus();
        if (r116 == null) goto L37;
        int r117 = b.f546894b[r116.ordinal()];
        if (r117 == 1) goto L31;
        if (r117 == 2) goto L30;
        if (r117 != 3) goto L37;
        String r118 = "3";
    L113:
        r107.put("code", r118);     // Catch: JSONException -> L34
        r106.put("args", r107);     // Catch: JSONException -> L34
        b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("H5_loginStatus", r106));     // Catch: JSONException -> L34
        return;
    L34:
        e = move-exception;
        ALogger.e("tag_banner_TOP", "JsEventCase->" + e);
        return;
    L30:
        r118 = "2";
        goto L113
    L31:
        r118 = "1";
    L37:
        throw new NoWhenBranchMatchedException();
    L133:
        return;
    L39:
        if ((r110 instanceof ActivityTopBannerViewIntent.e) == false) goto L52;
        ActivityTopBannerViewIntent.e r119 = (ActivityTopBannerViewIntent.e) r110;
        JSONObject r120 = new JSONObject();
        JSONObject r108 = new JSONObject();
        DataCenter r109 = this.f569886b;     // Catch: JSONException -> L49
        if (r109 == null) goto L46;
        Boolean r121 = (Boolean) r109.get("data_is_anchor", Boolean.FALSE);     // Catch: JSONException -> L49
        if (r121 == null) goto L46;
        boolean r122 = r121.booleanValue();     // Catch: JSONException -> L49
    L47:
        r108.put("status", i3.a(r122));     // Catch: JSONException -> L49
        r120.put("args", r108);     // Catch: JSONException -> L49
        r120.put("code", 0);     // Catch: JSONException -> L49
        b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("top_right_banner_status", r120));     // Catch: JSONException -> L49
        return;
    L46:
        r122 = false;
    L49:
        e = move-exception;
        ALogger.e("tag_banner_TOP", "JsEventCase->" + e);
        return;
    L52:
        if ((r110 instanceof ActivityTopBannerViewIntent.d) == false) goto L130;
        ActivityTopBannerViewIntent.d r123 = (ActivityTopBannerViewIntent.d) r110;
        JSONObject r124 = new JSONObject();     // Catch: JSONException -> L106
        com.bytedance.android.livesdk.chatroom.o r125 = o3.f();     // Catch: JSONException -> L106
        if (r125 == null) goto L57;
        Boolean r126 = r125.isVSRoom();     // Catch: JSONException -> L106
    L59:
        if (Intrinsics.areEqual(r126, Boolean.TRUE) == false) goto L88;
        Boolean r127 = o3.f().isPortraitInteraction();     // Catch: JSONException -> L106
        if (r127 == null) goto L63;
        boolean r128 = r127.booleanValue();     // Catch: JSONException -> L106
    L64:
        Boolean r129 = o3.f().isVSVerticalStream();     // Catch: JSONException -> L106
        if (r129 == null) goto L67;
        boolean r130 = r129.booleanValue();     // Catch: JSONException -> L106
    L68:
        eq1.b r131 = new eq1.b(r128, r130);     // Catch: JSONException -> L106
        BannerInRoomCollection.BannerInfo r132 = r123.f115108b;     // Catch: JSONException -> L106
        if (r132 == null) goto L88;
        List<b1> r133 = r132.getBannerList();     // Catch: JSONException -> L106
        if (r133 == null) goto L88;
        Iterator<T> r134 = r133.iterator();     // Catch: JSONException -> L106
    L74:
        if (r134.hasNext() == false) goto L88;
        b1 r135 = (b1) r134.next();     // Catch: JSONException -> L106
        String r136 = r135.getSchemaUrl();     // Catch: JSONException -> L106
        if (r136 == null) goto L74;
        if (r136.length() <= 0) goto L80;
        boolean r137 = true;
    L81:
        if (r137 == true) goto L84;
        r136 = null;
    L84:
        if (r136 == null) goto L74;
        String r138 = r131.b(r136);     // Catch: JSONException -> L106
        if (r138 == null) goto L74;
        r135.setSchemaUrl(r138);     // Catch: JSONException -> L106
        goto L74
    L80:
        r137 = false;
        goto L81
    L67:
        r130 = false;
        goto L68
    L63:
        r128 = true;
    L88:
        BannerInRoomCollection.BannerInfo r139 = r123.f115108b;     // Catch: JSONException -> L106
        if (r139 == null) goto L91;
        List<b1> r140 = r139.getBannerList();     // Catch: JSONException -> L106
    L92:
        r124.put("data", JsonUtil.toJSONString(r140));     // Catch: JSONException -> L106
        r124.put("type", "init");     // Catch: JSONException -> L106
        r124.put("log", c());     // Catch: JSONException -> L106
        com.bytedance.android.livesdk.chatroom.o r141 = z51.a.h(null, 3);     // Catch: JSONException -> L106
        if (r141 == null) goto L103;
        m<IRoom> r142 = r141.getRoom();     // Catch: JSONException -> L106
        if (r142 == null) goto L103;
        IRoom r143 = r142.getValue();     // Catch: JSONException -> L106
        if (r143 == null) goto L103;
        IRoomAuthStatus r144 = r143.getRoomAuthStatus();     // Catch: JSONException -> L106
        if (r144 == null) goto L103;
        if (r144.enableBanner() != true) goto L103;
    L104:
        r124.put("enable", r101);     // Catch: JSONException -> L106
        b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("H5_roomStatusChange", r124));     // Catch: JSONException -> L106
        return;
    L103:
        r101 = false;
        goto L104
    L91:
        r140 = null;
        goto L92
    L57:
        r126 = null;
    L106:
        e = move-exception;
        ALogger.e("tag_banner_TOP", "JsEventCase->" + e);
        return;
    }
}
