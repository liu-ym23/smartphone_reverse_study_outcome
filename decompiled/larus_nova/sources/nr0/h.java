package nr0;

import android.content.Context;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.i;
import com.bytedance.android.live.profit.lottery.l;
import com.bytedance.android.live.profit.lottery.t;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CompositeDisposable f520161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Long, Pair<Boolean, Boolean>> f520162b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Long f520163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f520164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f520165e = null;

    public h() {
    }

    static {
        f520165e = new h();
        f520162b = new LinkedHashMap();
    }

    public static Integer c(String r100) {
        if (r100 != null) goto L24;
        return null;
    L24:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L21
        JSONArray r102 = new JSONObject(r100).optJSONArray("condition_list");     // Catch: Throwable -> L21
        if (r102 == null) goto L18;
        int r103 = r102.length();     // Catch: Throwable -> L21
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r105 >= r103) goto L17;
        JSONObject r106 = JSONArrayProtectorUtils.getJSONObject(r102, r105);     // Catch: Throwable -> L21
        if (r106.optInt("type") == 53) goto L11;
        r105 = r105 + 1;     // Catch: Throwable -> L21
        goto L8
    L11:
        JSONObject r107 = r106.optJSONObject("game_play");     // Catch: Throwable -> L21
        if (r107 == null) goto L15;
        r104 = r107.optInt("play_seconds");     // Catch: Throwable -> L21
    L15:
        return Integer.valueOf(r104);
    L17:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L21
    L23:
        return null;
    L18:
        r108 = null;
    L21:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    public final void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Long r101 = f520163c;
        monitor-enter(this);
        Map<Long, Pair<Boolean, Boolean>> r102 = f520162b;     // Catch: Throwable -> L37
        Pair r103 = (Pair) ((LinkedHashMap) r102).get(r101);     // Catch: Throwable -> L37
        monitor-exit(this);
        if (r103 == null) goto L27;
        boolean r104 = ((Boolean) r103.component1()).booleanValue();
        boolean r105 = ((Boolean) r103.component2()).booleanValue();
        if (r104 == true) goto L27;
        if (r105 == false) goto L12;
        ThreadUtils.a().postAtFrontOfQueue(new a("已成功参与福袋"));
        goto L27
    L12:
        i r106 = yt0.c.f();
        if (r106 == null) goto L23;
        n<? extends com.bytedance.android.live.profit.lottery.g> r107 = r106.getCurrentLottery();
        if (r107 == null) goto L23;
        com.bytedance.android.live.profit.lottery.g r108 = r107.getValue();
        if (r108 == null) goto L23;
        LotteryState r109 = r108.getState();
        if (r109 == null) goto L23;
        t r110 = l.a(r109);
        if (r110 == null) goto L23;
        String r111 = r110.f88202i;
    L24:
        Integer r112 = c(r111);
        if (r112 == null) goto L27;
        ThreadUtils.a().postAtFrontOfQueue(new a("未达成在小游戏停留" + r112.intValue() + 's'));
    L23:
        r111 = null;
    L27:
        ((LinkedHashMap) r102).clear();
        f520163c = null;
        CompositeDisposable r113 = f520161a;
        if (r113 == null) goto L30;
        r113.dispose();
    L30:
        f520161a = null;
        String r114 = f520164d;
        if (r114 != null) goto L33;
    L35:
        f520164d = null;
        return;
    L33:
        if (((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).mg(r100, UriProtector.parse(r114), null) != null) goto L35;
        ALogger.i("MiniGameLotteryEvent", "exit minigame open failed schema failed");
    L37:
        th = move-exception;
        throw th;
    }

    public static void d(String r100, JSONObject r101) {
        IHostLiveOpenPlatform r102 = TTLiveSDK.hostService().hostOpenPlatform();
        JSONObject r103 = new JSONObject();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        r103.put("to_state", r100);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(r103.put("extra", r101));     // Catch: Throwable -> L5
    L7:
        Unit r105 = Unit.INSTANCE;
        r102.dispatchMiniGameEvent("live_lottery_state", r103);
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final void a(long r100, boolean r101, boolean r102) {
        h r103 = f520165e;
        monitor-enter(r103);
        f520162b.put(Long.valueOf(r100), new Pair(Boolean.valueOf(r101), Boolean.valueOf(r102)));     // Catch: Throwable -> L7
        monitor-exit(r103);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
