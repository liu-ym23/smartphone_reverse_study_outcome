package xg1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.config.uc0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f563587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f563588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f563589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f563590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final og2.a f563591e;

    public k() {
        this.f563589c = false;
        this.f563590d = false;
        this.f563591e = new og2.a(BaseFeedMonitor.Scene.SERVICE_SCENE_ROOM_DRAW_SCHEMA);
        if (e.f563574d == null) goto L5;
    L14:
        this.f563587a = e.f563574d;
        return;
    L5:
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e.f563574d != null) goto L9;
        e.f563574d = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void c(Map r110) {
        if (jc1.k.f(IFeatureService.class) == null) goto L48;
        z90.a r100 = ((IFeatureService) jc1.k.f(IFeatureService.class)).getFeatureManager();
        if (r100 == null) goto L49;
        LongSparseArray r101 = (LongSparseArray) r100.getFeature("live_room_type", new LongSparseArray());
        LongSparseArray r102 = (LongSparseArray) r100.getFeature("room_tag_array_level1", new LongSparseArray());
        LongSparseArray r103 = (LongSparseArray) r100.getFeature("room_tag_array_level2", new LongSparseArray());
        LongSparseArray r104 = (LongSparseArray) r100.getFeature("room_tag_array_level3", new LongSparseArray());
        Iterator r105 = r110.entrySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L35;
        Map.Entry r111 = (Map.Entry) r105.next();
        ArrayList r112 = new ArrayList();
        if (((nn1.a) r111.getValue()).a() == null) goto L34;
        Iterator<nn1.c> r113 = ((nn1.a) r111.getValue()).a().iterator();
    L13:
        if (r113.hasNext() == false) goto L34;
        nn1.c r114 = r113.next();
        r112.add(Long.valueOf(r114.b()));
        String r115 = String.valueOf(r114.a());
        r115.getClass();
        byte r116 = -1;
        switch(r115.hashCode()) {
            case 49: goto L26;
            case 50: goto L22;
            case 51: goto L18;
            default: goto L29;
        };
    L29:
        switch(r116) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L31;
            default: goto L13;
        };
    L31:
        r104.put(((Long) r111.getKey()).longValue(), Long.valueOf(r114.b()));
        goto L13
    L32:
        r103.put(((Long) r111.getKey()).longValue(), Long.valueOf(r114.b()));
        goto L13
    L33:
        r102.put(((Long) r111.getKey()).longValue(), Long.valueOf(r114.b()));
        goto L13
    L18:
        if (r115.equals("3") == false) goto L29;
        r116 = 2;
        goto L29
    L22:
        if (r115.equals("2") == false) goto L29;
        r116 = 1;
        goto L29
    L26:
        if (r115.equals("1") == false) goto L29;
        r116 = 0;
    L34:
        r101.put(((Long) r111.getKey()).longValue(), TextUtils.join(",", r112));
        goto L8
    L35:
        FeatureType r106 = FeatureType.MONITOR;
        r100.i("live_room_type", r101, r106);
        r100.i("room_tag_array_level1", r102, r106);
        r100.i("room_tag_array_level2", r103, r106);
        r100.i("room_tag_array_level3", r104, r106);
        return;
    L49:
        return;
    }

    public static Bundle a(FeedItem r100, FeedExtra r101) {
        String r102 = null;
        if (r100 != null) goto L5;
    L27:
        return null;
    L5:
        if (r100.getItem() == null) goto L27;
        if ((r100.getItem() instanceof Room) == false) goto L27;
        Bundle r103 = ArgumentsBuilder.buildRoomArgs((Room) r100.getItem());
        if (r101 != null) goto L28;
    L26:
        return r103;
    L28:
        r103.putString(ILiveRoomPlayFragmentConstant.EXTRA_LOG_PB, String.valueOf(r101.getLogPb()));     // Catch: Exception -> L24
        r103.putString("log_pb", String.valueOf(r101.getLogPb()));     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r101.reqId) == true) goto L14;
    L16:
        r103.putString(ILiveRoomPlayFragmentConstant.EXTRA_REQUEST_ID, r101.reqId);     // Catch: Exception -> L24
        r103.putString("request_id", r101.reqId);     // Catch: Exception -> L24
        if (r100.isRecommendCard == false) goto L19;
        r102 = "pop_card";
    L19:
        r103.putString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_MERGE_RECOMMEND, r102);     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r100.liveReason) == true) goto L22;
        r103.putString("live_reason", r100.liveReason);     // Catch: Exception -> L24
    L22:
        r103.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_PSEUDO_LIVING, r100.isPseudoLiving);     // Catch: Exception -> L24
        goto L26
    L14:
        if (TextUtils.isEmpty(String.valueOf(r101.getLogPb())) == true) goto L16;
        r101.reqId = JSONObjectProtectorUtils.getString(tv5.a.c(r101.getLogPb()), "impr_id");     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ALogger.e("NewFeedStyleEntranceUtils", e);
        goto L26
    }

    public static void b(long r100, long r101) {
        if (uc0.f121361a.getValue().intValue() != 1) goto L6;
        Bundle r102 = new Bundle();
        r102.putLong(ILiveRoomPlayFragmentConstant.EXTRA_LOADING_SHOW_EXTRA, r100);
        r102.putLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID, r101);
        ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).a().startLive(TTLiveSDK.hostService().appContext().context(), r101, r102);
        return;
    }
}
