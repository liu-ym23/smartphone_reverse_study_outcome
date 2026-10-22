package qv6;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.locallife.live.util.p;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f534905a = 0;

    static {
    }

    public e() {
    }

    public static void a(String r110, Map r111, boolean r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        if (r113 != null) goto L5;
        r100.getClass();
        r113 = LiveLocalLifeViewModel.access$getLAST_USED_UNIQUE_KEY$cp();
    L5:
        r100.getClass();
        LiveLocalLifeViewModel r114 = LiveLocalLifeViewModel.Companion.a(r113);
        String r101 = null;
        if (r114 == null) goto L8;
        LiveLocalLifeRoomInfo r115 = r114.getRoomInfo();
    L9:
        Room r102 = LiveLocalLifeUtil.d(LiveLocalLifeViewModel.access$getLAST_USED_UNIQUE_KEY$cp());
        if (r115 == null) goto L12;
        String r103 = r115.getLogExtra();
    L13:
        if (r115 == null) goto L15;
        String r104 = r115.isOtherChannel();
    L16:
        if (r115 == null) goto L18;
        String r105 = r115.getVideoId();
    L19:
        if (r115 == null) goto L22;
        String r106 = r115.getCid();
        if (r106 == null) goto L22;
    L23:
        Pair[] r107 = new Pair[8];
        if (r115 == null) goto L26;
        String r108 = r115.getRoomId();
    L27:
        boolean r109 = false;
        r107[0] = TuplesKt.to("room_id", r108);
        if (r115 == null) goto L30;
        String r116 = r115.getAnchorId();
    L31:
        r107[1] = TuplesKt.to("anchor_id", r116);
        if (r115 == null) goto L34;
        String r117 = r115.getEnterFromMerge();
    L35:
        r107[2] = TuplesKt.to("enter_from_merge", r117);
        if (r115 == null) goto L38;
        String r118 = r115.getEnterMethod();
    L39:
        r107[3] = TuplesKt.to("enter_method", r118);
        if (r115 == null) goto L42;
        String r119 = r115.getActionType();
    L43:
        r107[4] = TuplesKt.to("action_type", r119);
        if (r115 == null) goto L46;
        String r120 = r115.getRequestId();
    L47:
        r107[5] = TuplesKt.to("request_id", r120);
        if (r102 == null) goto L52;
        User r121 = r102.mo8271getOwner();
        if (r121 == null) goto L52;
        FollowInfo r122 = r121.getFollowInfo();
    L54:
        if ((r122 instanceof FollowInfo) == true) goto L57;
        r122 = null;
    L57:
        if (r122 != null) goto L59;
    L61:
        boolean r123 = false;
    L62:
        if (r123 == false) goto L64;
        String r124 = "1";
    L65:
        r107[6] = TuplesKt.to("is_following", r124);
        if (r115 == null) goto L68;
        String r125 = r115.getLifeInitialInfo();
    L69:
        r107[7] = TuplesKt.to("life_initial_info", r125);
        Map r126 = MapsKt.mutableMapOf(r107);
        int r127 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.f246865a;
        if (r115 == null) goto L72;
        String r128 = r115.getClickMethod();
    L74:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r128) == false) goto L79;
        if (r115 == null) goto L77;
        String r129 = r115.getClickMethod();
    L78:
        r126.put("click_method", r129);
        goto L79
    L77:
        r129 = null;
    L79:
        if (r111 == null) goto L86;
        Iterator r130 = r111.entrySet().iterator();
    L82:
        if (r130.hasNext() == false) goto L86;
        Map.Entry r131 = (Map.Entry) r130.next();
        String r132 = (String) r131.getKey();
        if (r132 == null) goto L82;
        r126.put(r132, r131.getValue());
    L86:
        if (r112 == false) goto L97;
        if (TextUtils.isEmpty(r103) == true) goto L91;
        r126.put("log_extra", r103);
    L91:
        if (TextUtils.isEmpty(r104) == true) goto L94;
        r126.put("is_other_channel", r104);
    L94:
        if (TextUtils.isEmpty(r106) == true) goto L97;
        r126.put("cid", r106);
    L97:
        if (TextUtils.isEmpty(r105) == true) goto L99;
        r126.put("video_id", r105);
    L99:
        if (r115 == null) goto L101;
        String r133 = r115.getSearchParams();
    L102:
        if (r133 != null) goto L104;
    L107:
        boolean r134 = true;
    L108:
        if (r134 == true) goto L113;
        if (r115 == null) goto L111;
        String r135 = r115.getSearchParams();
    L112:
        r126.put("search_params", r135);
        goto L113
    L111:
        r135 = null;
    L113:
        if (r115 == null) goto L115;
        String r136 = r115.getSearchId();
    L116:
        if (r136 != null) goto L118;
    L121:
        boolean r137 = true;
    L122:
        if (r137 == true) goto L127;
        if (r115 == null) goto L125;
        String r138 = r115.getSearchId();
    L126:
        r126.put("search_id", r138);
        goto L127
    L125:
        r138 = null;
    L127:
        if (r115 == null) goto L129;
        String r139 = r115.getSearchResultId();
    L130:
        if (r139 != null) goto L132;
    L133:
        r109 = true;
    L134:
        if (r109 == true) goto L138;
        if (r115 == null) goto L137;
        r101 = r115.getSearchResultId();
    L137:
        r126.put("search_result_id", r101);
    L138:
        int r140 = p.f260728a;
        LiveLocalLifeViewModel.Companion.getClass();
        p.d(LiveLocalLifeViewModel.access$getLAST_USED_UNIQUE_KEY$cp(), r126);
        int r141 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c(r110, r126);
        return;
    L132:
        if (r139.length() != 0) goto L134;
    L129:
        r139 = null;
        goto L130
    L118:
        if (r136.length() == 0) goto L121;
        r137 = false;
        goto L122
    L115:
        r136 = null;
        goto L116
    L104:
        if (r133.length() == 0) goto L107;
        r134 = false;
        goto L108
    L101:
        r133 = null;
        goto L102
    L72:
        r128 = null;
        goto L74
    L68:
        r125 = null;
        goto L69
    L64:
        r124 = "0";
        goto L65
    L59:
        if (r122.isFollowing() != true) goto L61;
        r123 = true;
    L52:
        r122 = null;
        goto L54
    L46:
        r120 = null;
        goto L47
    L42:
        r119 = null;
        goto L43
    L38:
        r118 = null;
        goto L39
    L34:
        r117 = null;
        goto L35
    L30:
        r116 = null;
        goto L31
    L26:
        r108 = null;
    L22:
        r106 = "";
        goto L23
    L18:
        r105 = null;
        goto L19
    L15:
        r104 = null;
        goto L16
    L12:
        r103 = null;
        goto L13
    L8:
        r115 = null;
        goto L9
    }

    public static void b(String r100, Map r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        LinkedHashMap r104 = new LinkedHashMap();
        if (r101 == null) goto L10;
        Iterator r105 = r101.entrySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L10;
        Map.Entry r106 = (Map.Entry) r105.next();
        String r107 = (String) r106.getKey();
        if (r107 == null) goto L6;
        r104.put(r107, r106.getValue());
    L10:
        LiveLocalLifeViewModel.Companion r108 = LiveLocalLifeViewModel.Companion;
        if (r103 != null) goto L13;
        r108.getClass();
        String r109 = LiveLocalLifeViewModel.access$getLAST_USED_UNIQUE_KEY$cp();
    L14:
        r108.getClass();
        LiveLocalLifeViewModel r110 = LiveLocalLifeViewModel.Companion.a(r109);
        if (r110 == null) goto L22;
        Map<String, Object> r111 = r110.getShelfPerfLog();
        if (r111 == null) goto L22;
        Iterator<Map.Entry<String, Object>> r112 = r111.entrySet().iterator();
    L20:
        if (r112.hasNext() == false) goto L22;
        Map.Entry<String, Object> r113 = r112.next();
        r104.put(r113.getKey(), (String) r113.getValue());
    L22:
        r104.put("gecko_id", LiveLocalLifeUtil.g());
        a(r100, r104, r102, r103);
        return;
    L13:
        r109 = r103;
        goto L14
    }
}
