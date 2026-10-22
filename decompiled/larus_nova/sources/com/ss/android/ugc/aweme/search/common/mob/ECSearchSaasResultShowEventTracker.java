package com.ss.android.ugc.aweme.search.common.mob;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.NetworkUtils;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAbility;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import java.util.LinkedHashMap;
import jx5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/mob/ECSearchSaasResultShowEventTracker;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchSaasResultShowEventTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f451751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SaasFlyingSessionSet f451752b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f451753c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ECSearchSaasResultShowEventTracker f451754d = null;

    private ECSearchSaasResultShowEventTracker() {
    }

    static {
        f451754d = new ECSearchSaasResultShowEventTracker();
        f451752b = new SaasFlyingSessionSet();
        f451753c = new Handler(Looper.getMainLooper());
    }

    public static void a(ECSearchResultSceneKey r100) {
        if (r100 != null) goto L6;
        Logger.b("EventTrackerDebug", "end sceneKey == null, just return");
        return;
    L6:
        final ECSearchSaasResultShowEvent r101 = f451752b.a(r100);
        StringBuilder r102 = new StringBuilder("end sceneKey = ");
        r102.append(r100);
        r102.append(", event = ");
        if (r101 == null) goto L9;
        int r103 = r101.hashCode();
    L10:
        r102.append(r103);
        Logger.a("EventTrackerDebug", r102.toString());
        if (r101 != null) goto L13;
    L22:
        StringBuilder r104 = new StringBuilder("end event = ");
        r104.append(r101);
        r104.append(", event.start = ");
        Long r105 = null;
        if (r101 == null) goto L25;
        Long r106 = Long.valueOf(r101.f451727a);
    L26:
        r104.append(r106);
        r104.append(" event.status = ");
        if (r101 == null) goto L29;
        r105 = Long.valueOf(r101.f451727a);
    L29:
        r104.append(r105);
        r104.append(", just return");
        Logger.b("EventTrackerDebug", r104.toString());
        return;
    L25:
        r106 = null;
        goto L26
    L13:
        if (r101.f451727a == 0) goto L22;
        if (r101.f451743q == (-1)) goto L22;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L20;
        r101.h(true);
        return;
    L20:
        f451753c.post(new ECSearchSaasResultShowEventTracker$end$1(r101));
        return;
    L9:
        r103 = 0;
        goto L10
    }

    public static ECSearchSaasResultShowEvent b(ECSearchResultSceneKey r100) {
        if (r100 == null) goto L8;
        ECSearchSaasResultShowEvent r101 = f451752b.a(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return ECSearchSaasResultShowEventTrackerKt.f451757b;
    L8:
        return ECSearchSaasResultShowEventTrackerKt.f451757b;
    }

    public final ECSearchSaasResultShowEvent d(ECSearchResultSceneKey r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneKey");
        SaasFlyingSessionSet r101 = f451752b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "sceneKey");
        ECSearchResultSceneKey r102 = ECSearchSaasResultShowEventTrackerKt.f451756a;
        if ((!Intrinsics.areEqual(r100, r102)) == false) goto L11;
        ECSearchSaasResultShowEvent r103 = (ECSearchSaasResultShowEvent) ((LinkedHashMap) r101.f451771b).get(r100);
        if (r103 == null) goto L11;
        r103.e();
        r103.c("canceled by new request.");
        if (Intrinsics.areEqual(r103, ECSearchSaasResultShowEventTrackerKt.f451757b) == true) goto L11;
        r103.h(false);
    L11:
        ECSearchSaasResultShowEvent r104 = r101.a(r100);
        if (r104 != null) goto L14;
        Logger.a("EventTrackerDebug", "syncSceneKey event == null, sceneKey = " + r100 + " trigger = TRIGGER_SEARCH_BY_SWITCH_TAB start");
        return c(this, 6, r100, null, 12);
    L14:
        Logger.a("EventTrackerDebug", "syncSceneKey event = " + r104.hashCode() + ", sceneKey = " + r100);
        Intrinsics.checkNotNullParameter(r100, "sceneKey");
        Intrinsics.checkNotNullParameter(r104, "event");
        if (r101.f451770a != null) goto L17;
        return r104;
    L17:
        if ((!Intrinsics.areEqual(r100, r102)) == false) goto L22;
        Logger.a("EventTrackerDebug", "FlyingSessionSet putIfAbsent sceneKey = " + r100 + ", event = " + r104.hashCode());
        r101.b(r100, r104);
        return r104;
    L22:
        return r104;
    }

    public static ECSearchSaasResultShowEvent c(ECSearchSaasResultShowEventTracker r100, int r101, ECSearchResultSceneKey r110, Long r111, int r112) {
        ECSearchSaasResultShowEvent r102 = null;
        if ((r112 & 2) == 0) goto L6;
        r110 = null;
    L6:
        if ((r112 & 8) == 0) goto L8;
        r111 = null;
    L8:
        r100.getClass();
        long r103 = System.currentTimeMillis();
        long r104 = r103 - f451751a;
        f451751a = r103;
        if (r104 >= 1000) goto L12;
    L30:
        return r102;
    L12:
        if (r110 != null) goto L14;
        ECSearchResultSceneKey r105 = ECSearchSaasResultShowEventTrackerKt.f451756a;
    L15:
        r102 = new ECSearchSaasResultShowEvent(r105);
        r102.f451727a = r103;
        if (r111 == null) goto L18;
        long r113 = r111.longValue();
    L19:
        r102.f451728b = r113;
        r102.f451729c = 0;
        r102.f451730d = 0;
        Logger.a("EventTrackerDebug", "start start = " + r103 + ", sceneKey = " + r110 + ", trigger = " + r101);
        SaasFlyingSessionSet r106 = f451752b;
        if (r110 != null) goto L22;
        r110 = ECSearchSaasResultShowEventTrackerKt.f451756a;
    L22:
        r106.b(r110, r102);
        ITradeSearchHostService r107 = TradeSearch.c(TradeSearch.f453393a);
        if (r107 == null) goto L27;
        ITradeSearchHostAbility r108 = r107.getITradeSearchHostAbility();
        if (r108 == null) goto L27;
        r108.getNetworkStateManager();
    L27:
        NetworkUtils.NetworkType r109 = NetworkUtils.NetworkType.NONE;
        r102.f451748v = r109;
        b.a.f500873a.b();
        if (r102.f451748v != r109) goto L30;
        r102.f451743q = 1;
        r102.f451745s = 1;
        r102.f451744r = "NO_NETWORK";
        goto L30
    L18:
        r113 = 0;
        goto L19
    L14:
        r105 = r110;
        goto L15
    }
}
