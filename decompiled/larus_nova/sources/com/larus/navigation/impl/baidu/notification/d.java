package com.larus.navigation.impl.baidu.notification;

import android.app.UiModeManager;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f359793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f359794b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Integer, Integer> f359795c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Integer, Integer> f359796d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Integer, String> f359797e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<Integer, String> f359798f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<Integer, String> f359799g = null;

    static {
        f359793a = LazyKt.lazy(new b());
        f359794b = LazyKt.lazy(new c());
        Map r100 = MapsKt.createMapBuilder();
        Integer r101 = Integer.valueOf(R.drawable.larus_ic_nav_straight);
        r100.put(1, r101);
        Integer r102 = Integer.valueOf(R.drawable.larus_ic_nav_slight_right);
        r100.put(2, r102);
        Integer r103 = Integer.valueOf(R.drawable.larus_ic_nav_right);
        r100.put(3, r103);
        r100.put(4, Integer.valueOf(R.drawable.larus_ic_nav_sharp_right));
        Integer r110 = Integer.valueOf(R.drawable.larus_ic_nav_uturn);
        r100.put(5, r110);
        r100.put(6, Integer.valueOf(R.drawable.larus_ic_nav_sharp_left));
        r100.put(7, Integer.valueOf(R.drawable.larus_ic_nav_left));
        Integer r111 = Integer.valueOf(R.drawable.larus_ic_nav_slight_left);
        r100.put(8, r111);
        r100.put(9, r111);
        r100.put(10, r102);
        r100.put(11, r111);
        r100.put(12, r102);
        r100.put(13, r102);
        r100.put(14, r111);
        r100.put(15, r111);
        r100.put(16, r102);
        r100.put(17, r111);
        r100.put(18, r102);
        r100.put(19, r111);
        r100.put(20, r101);
        r100.put(21, r102);
        r100.put(22, r102);
        r100.put(23, r101);
        r100.put(24, r111);
        r100.put(25, r101);
        r100.put(26, r111);
        r100.put(27, r102);
        r100.put(28, r103);
        int r112 = 29;
    L4:
        if (r112 >= 37) goto L6;
        r100.put(Integer.valueOf(r112), r101);
        r112 = r112 + 1;
        goto L4
    L6:
        r100.put(37, Integer.valueOf(R.drawable.larus_ic_nav_end));
        r100.put(38, r101);
        r100.put(39, r101);
        r100.put(40, r101);
        f359795c = MapsKt.build(r100);
        Map r104 = MapsKt.createMapBuilder();
        r104.put(1, r101);
        r104.put(2, r102);
        r104.put(3, r103);
        r104.put(4, Integer.valueOf(R.drawable.larus_ic_nav_sharp_right));
        r104.put(5, Integer.valueOf(R.drawable.larus_ic_nav_sharp_left));
        r104.put(6, Integer.valueOf(R.drawable.larus_ic_nav_left));
        r104.put(7, r111);
        r104.put(8, r102);
        r104.put(9, r111);
        r104.put(10, r101);
        r104.put(11, r101);
        r104.put(12, r110);
        r104.put(13, r110);
        r104.put(14, r103);
        r104.put(15, r102);
        r104.put(16, r101);
        r104.put(17, r111);
        r104.put(18, r111);
        r104.put(19, Integer.valueOf(R.drawable.larus_ic_nav_sharp_left));
        r104.put(20, Integer.valueOf(R.drawable.larus_ic_nav_left));
        r104.put(21, r111);
        r104.put(22, r101);
        r104.put(23, r102);
        r104.put(24, r103);
        r104.put(25, Integer.valueOf(R.drawable.larus_ic_nav_sharp_right));
        r104.put(26, Integer.valueOf(R.drawable.larus_ic_nav_left));
        r104.put(27, r103);
        r104.put(28, r111);
        r104.put(29, r102);
        r104.put(30, r110);
        r104.put(31, r110);
        r104.put(32, r101);
        int r113 = 33;
    L8:
        if (r113 >= 48) goto L10;
        r104.put(Integer.valueOf(r113), r101);
        r113 = r113 + 1;
        goto L8
    L10:
        f359796d = MapsKt.build(r104);
        f359797e = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, "wn_turn_front"), TuplesKt.to(2, "wn_turn_right_front"), TuplesKt.to(3, "wn_turn_right"), TuplesKt.to(4, "wn_turn_right_back"), TuplesKt.to(5, "wn_turn_left_back"), TuplesKt.to(6, "wn_turn_left"), TuplesKt.to(7, "wn_turn_left_front"), TuplesKt.to(8, "wn_turn_right_front_straight"), TuplesKt.to(9, "wn_turn_left_front_straight"), TuplesKt.to(10, "wn_turn_left_passroad_front"), TuplesKt.to(11, "wn_turn_right_passroad_front"), TuplesKt.to(12, "wn_turn_left_passroad_uturn"), TuplesKt.to(13, "wn_turn_right_passroad_uturn"), TuplesKt.to(14, "wn_turn_passroad_right"), TuplesKt.to(15, "wn_turn_left_diagonal_passroad_right_front"), TuplesKt.to(16, "wn_turn_left_passroad_front"), TuplesKt.to(17, "wn_turn_left_diagonal_passroad_left_front"), TuplesKt.to(18, "wn_turn_left_diagonal_passroad_left_front"), TuplesKt.to(19, "wn_turn_left_diagonal_passroad_left_back"), TuplesKt.to(20, "wn_turn_passroad_left"), TuplesKt.to(21, "wn_turn_right_diagonal_passroad_left_front"), TuplesKt.to(22, "wn_turn_right_passroad_front"), TuplesKt.to(23, "wn_turn_right_diagonal_passroad_right_front"), TuplesKt.to(24, "wn_turn_passroad_right"), TuplesKt.to(25, "wn_turn_right_diagonal_passroad_right_back"), TuplesKt.to(26, "wn_turn_passroad_left"), TuplesKt.to(27, "wn_turn_passroad_right"), TuplesKt.to(28, "wn_turn_goto_leftroad_front"), TuplesKt.to(29, "wn_turn_goto_rightroad_front"), TuplesKt.to(30, "wn_turn_goto_leftroad_uturn"), TuplesKt.to(31, "wn_turn_goto_rightroad_uturn"), TuplesKt.to(32, "wn_waypoint")});
        f359798f = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, "light_turn_front"), TuplesKt.to(2, "light_turn_right_front"), TuplesKt.to(3, "light_turn_right"), TuplesKt.to(4, "light_turn_right_back"), TuplesKt.to(5, "light_turn_back"), TuplesKt.to(6, "light_turn_left_back"), TuplesKt.to(7, "light_turn_left"), TuplesKt.to(8, "light_turn_left_front"), TuplesKt.to(9, "light_turn_left_side"), TuplesKt.to(10, "light_turn_right_side"), TuplesKt.to(11, "light_turn_left_side_ic"), TuplesKt.to(12, "light_turn_right_side_main"), TuplesKt.to(13, "light_turn_right_side_ic"), TuplesKt.to(14, "light_turn_left_side_main"), TuplesKt.to(15, "light_turn_left_2branch_left"), TuplesKt.to(16, "light_turn_left_2branch_right"), TuplesKt.to(17, "light_turn_right_2branch_left"), TuplesKt.to(18, "light_turn_right_2branch_right"), TuplesKt.to(19, "light_turn_3branch_left_straight"), TuplesKt.to(20, "light_turn_right_3branch_middle"), TuplesKt.to(21, "light_turn_right_3branch_right"), TuplesKt.to(22, "light_turn_3branch_right_straight"), TuplesKt.to(23, "light_turn_left_3branch_middle"), TuplesKt.to(24, "light_turn_left_3branch_left"), TuplesKt.to(25, "light_turn_3branch_center"), TuplesKt.to(26, "light_turn_3branch_left"), TuplesKt.to(27, "light_turn_3branch_right"), TuplesKt.to(28, "light_turn_ring"), TuplesKt.to(29, "light_turn_ring_front"), TuplesKt.to(30, "light_turn_ring_right_front"), TuplesKt.to(31, "light_turn_ring_right"), TuplesKt.to(32, "light_turn_ring_right_back"), TuplesKt.to(33, "light_turn_ring_back"), TuplesKt.to(34, "light_turn_ring_left_back"), TuplesKt.to(35, "light_turn_ring_left"), TuplesKt.to(36, "light_turn_ring_left_front"), TuplesKt.to(37, "light_turn_dest"), TuplesKt.to(38, "light_turn_via_1"), TuplesKt.to(39, "light_turn_inferry"), TuplesKt.to(40, "light_turn_tollgate")});
        f359799g = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, "cn_front"), TuplesKt.to(2, "cn_right_front"), TuplesKt.to(3, "cn_right"), TuplesKt.to(4, "cn_right_back"), TuplesKt.to(5, "cn_left_back"), TuplesKt.to(6, "cn_left"), TuplesKt.to(7, "cn_left_front"), TuplesKt.to(8, "cn_right_front_straight"), TuplesKt.to(9, "cn_left_front_straight"), TuplesKt.to(10, "cn_left_passroad_front"), TuplesKt.to(11, "cn_right_passroad_front"), TuplesKt.to(12, "cn_left_passroad_uturn"), TuplesKt.to(13, "cn_right_passroad_uturn"), TuplesKt.to(14, "cn_leftdiagonal_passroad_right"), TuplesKt.to(15, "cn_leftdiagonal_passroad_right_front"), TuplesKt.to(16, "cn_left_passroad_front"), TuplesKt.to(17, "cn_leftdiagonal_passroad_left_front"), TuplesKt.to(18, "cn_leftdiagonal_passroad_left"), TuplesKt.to(19, "cn_leftdiagonal_passroad_left_back"), TuplesKt.to(20, "cn_rightdiagonal_passroad_left"), TuplesKt.to(21, "cn_rightdiagonal_passroad_left_front"), TuplesKt.to(22, "cn_right_passroad_front"), TuplesKt.to(23, "cn_rightdiagonal_passroad_right_front"), TuplesKt.to(24, "cn_rightdiagonal_passroad_right"), TuplesKt.to(25, "cn_rightdiagonal_passroad_right_back"), TuplesKt.to(26, "cn_passroad_left"), TuplesKt.to(27, "cn_passroad_right"), TuplesKt.to(28, "cn_goto_left_road"), TuplesKt.to(29, "cn_goto_right_road"), TuplesKt.to(30, "cn_goto_left_road_uturn"), TuplesKt.to(31, "cn_goto_right_road_uturn"), TuplesKt.to(32, "wn_waypoint"), TuplesKt.to(33, "cn_left_three_leftSide"), TuplesKt.to(34, "cn_left_three_middle"), TuplesKt.to(35, "cn_left_three_rightSide"), TuplesKt.to(36, "cn_left_two_leftSide"), TuplesKt.to(37, "cn_left_two_rightSide"), TuplesKt.to(38, "cn_right_three_leftSide"), TuplesKt.to(39, "cn_right_three_middle"), TuplesKt.to(40, "cn_right_three_rightSide"), TuplesKt.to(41, "cn_right_two_leftSide"), TuplesKt.to(42, "cn_right_two_rightSide"), TuplesKt.to(43, "cn_three_leftSide"), TuplesKt.to(44, "cn_three_middle"), TuplesKt.to(45, "cn_three_rightSide"), TuplesKt.to(46, "cn_two_leftSide"), TuplesKt.to(47, "cn_two_rightSide")});
    }

    public static boolean b() {
        UiModeManager r100 = (UiModeManager) f359793a.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getNightMode() != 2) goto L7;
        return true;
    }

    public static String a(int r100, int r101) {
        boolean r102 = b();
        FLogger r103 = FLogger.f375446a;
        r103.i("BaiduNaviIconUrlMappingUtil", "isNightMode:" + r102);
        String r104 = null;
        if (r100 != 0) goto L5;
        String r105 = f359797e.get(Integer.valueOf(r101));
    L12:
        if (r105 != null) goto L15;
    L19:
        r103.i("BaiduNaviIconUrlMappingUtil", "getURl:" + r104);
        return r104;
    L15:
        if (b() == false) goto L17;
        String r106 = "dark";
    L18:
        r104 = ((String) f359794b.getValue()) + r105 + '_' + r106 + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;
        goto L19
    L17:
        r106 = "light";
        goto L18
    L5:
        if (r100 != 1) goto L7;
        r105 = f359799g.get(Integer.valueOf(r101));
        goto L12
    L7:
        if (r100 == 2) goto L9;
        r105 = null;
        goto L12
    L9:
        r105 = f359798f.get(Integer.valueOf(r101));
        goto L12
    }
}
