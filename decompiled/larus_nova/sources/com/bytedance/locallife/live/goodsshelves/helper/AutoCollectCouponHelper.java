package com.bytedance.locallife.live.goodsshelves.helper;

import com.bytedance.locallife.live.model.CollectScene;
import com.bytedance.locallife.live.model.CollectSource;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.live.util.LiveLocalLifeGsonUtil;
import com.bytedance.locallife.live.util.s;
import com.bytedance.locallife.live.util.w;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class AutoCollectCouponHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f259625a = null;

    public AutoCollectCouponHelper() {
    }

    static {
        f259625a = LazyKt.lazy(AutoCollectCouponHelper$api$2.INSTANCE);
    }

    public static Map c(LiveLocalLifeRoomInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "roomInfo");
        Pair[] r101 = new Pair[4];
        r101[0] = TuplesKt.to("enter_from_merge", r100.getEnterFromMerge());
        r101[1] = TuplesKt.to("enter_method", r100.getEnterMethod());
        r101[2] = TuplesKt.to("action_type", r100.getActionType());
        String r102 = r100.getSaleChannel();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101[3] = TuplesKt.to(LiveLocalLifeRoomInfo.SALE_CHANNEL, r102);
        return MapsKt.mapOf(r101);
    }

    public static final void a(Map r100, Map r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.putAll(r100);
        r102.putAll(r101);
        int r103 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c("live_life_toast_show", r102);
    }

    public static Map d(LiveLocalLifeRoomInfo r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "roomInfo");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("enter_from_merge", r100.getEnterFromMerge());
        r103.put("anchor_id", r100.getAnchorId());
        r103.put("room_id", r100.getRoomId());
        r103.put("action_type", r100.getActionType());
        r103.put("request_id", r100.getRequestId());
        r103.put("video_id", r100.getVideoId());
        r103.put("enter_method", r100.getEnterMethod());
        r103.put("cid", r100.getCid());
        r103.put("log_extra", r100.getLogExtra());
        r103.put("is_other_channel", r100.isOtherChannel());
        String r104 = "";
        if (r102 == null) goto L6;
        String r105 = w.f(r102, "product_type");
        if (r105 == null) goto L6;
    L7:
        r103.put("product_type", r105);
        if (r102 == null) goto L11;
        String r106 = w.f(r102, "product_bizline");
        if (r106 == null) goto L11;
    L12:
        r103.put("product_bizline", r106);
        if (r101 != null) goto L15;
        r101 = "";
    L15:
        r103.put("product_id", r101);
        String r107 = r100.getSaleChannel();
        if (r107 == null) goto L19;
        r104 = r107;
    L19:
        r103.put(LiveLocalLifeRoomInfo.SALE_CHANNEL, r104);
        r103.put("entry_type", "3002");
        r103.put("collect_from", "project_card");
        r103.put("from_position", BrowserDependency.UrlClickType.CARD);
        r103.put("aweme_user_id", r100.getAnchorId());
        return r103;
    L11:
        r106 = "";
    L6:
        r105 = "";
        goto L7
    }

    public static void b(String r100, boolean r101, String r102, List r103, Map r110, Map r111, Function1 r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, "enterRoomParams");
        Intrinsics.checkNotNullParameter(r111, "trackLogInfo");
        Intrinsics.checkNotNullParameter(r112, "nextRun");
        if (s.d(r100) == true) goto L5;
    L15:
        if (r101 == false) goto L17;
        r112.invoke(Boolean.TRUE);
        return;
    L17:
        r112.invoke(Boolean.FALSE);
        return;
    L5:
        if (s.d(r102) == false) goto L15;
        Gson r104 = LiveLocalLifeGsonUtil.f260680a;
        Gson r105 = LiveLocalLifeGsonUtil.a.a();
        Object r106 = ((Map) GsonProtectorUtils.fromJson(r105, r102, Map.class)).get("coupons");
        if ((r106 instanceof List) == false) goto L9;
        List r107 = (List) r106;
    L11:
        if (r113 != 2) goto L13;
        int r108 = CollectSource.ComponentCardBtn.getValue();
    L14:
        ((dv6.b) f259625a.getValue()).h(GsonProtectorUtils.toJson(r105, r107), CollectScene.AutoCollect.getValue(), r108, GsonProtectorUtils.toJson(r105, r110)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r105, true, r112, r103, r111), new b(r103, r112, r111));
        return;
    L13:
        r108 = CollectSource.ComponentCardContent.getValue();
        goto L14
    L9:
        r107 = null;
        goto L11
    }
}
