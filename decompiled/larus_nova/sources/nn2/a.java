package nn2;

import am2.n;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.livesdk.config.feed.LiveFeedAdParams;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f519628d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<Long> f519629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Double> f519630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f519631c;

    /* JADX INFO: renamed from: nn2.a$a, reason: collision with other inner class name */
    public static final class C6941a {
        public static a a() {
            a r100 = a.f519628d;
            if (r100 != null) goto L6;
            r100 = new a();
        L6:
            if (a.f519628d != null) goto L8;
            a.f519628d = r100;
        L8:
            return r100;
        }
    }

    static {
    }

    public a() {
        this.f519629a = new LinkedHashSet();
        this.f519630b = new LinkedHashMap();
        this.f519631c = "";
    }

    public final boolean b(long r100) {
        return this.f519629a.contains(Long.valueOf(r100));
    }

    public final void c(long r100, int r101) {
        if (r101 == 14) goto L5;
        this.f519629a.remove(Long.valueOf(r100));
        return;
    L5:
        if (this.f519629a.size() <= 100) goto L7;
        LinkedHashSet<Long> r102 = this.f519629a;
        r102.remove(CollectionsKt.first(r102));
    L7:
        this.f519629a.add(Long.valueOf(r100));
    }

    public static void a(String r100, Room r110, String r111) {
        LiveFeedAdParams r112 = (LiveFeedAdParams) GsonProtectorUtils.fromJson(new Gson(), r110.adRawString, LiveFeedAdParams.class);
        if (r112 != null) goto L5;
        r112 = new LiveFeedAdParams(null, null, null, null, null, null, 63, null);
    L5:
        JSONObject r101 = new JSONObject();
        r101.put("tag", r111);
        r101.put("label", r100);
        r101.put("category", "app_union");
        r101.put("value", r112.getCreativeId());
        r101.put("is_ad_event", 1);
        r101.put("event_ts", System.currentTimeMillis());
        r101.put("log_extra", r112.getLogExtra());
        r101.put("nt", NetworkUtils.getNetworkType(LiveResUtil.getContext()).getValue());
        r101.put(BaseHttpRequestInfo.KEY_USER_AGENT, n.f().f4312a);
    }
}
