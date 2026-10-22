package xh9;

import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f563910a = null;

    static {
        f563910a = new ConcurrentHashMap();
    }

    public static void a(int r100, String r101) {
        if (r101 != null) goto L5;
    L7:
        r101 = null;
    L9:
        if (r101 != null) goto L11;
    L14:
        if (r101 != null) goto L16;
        r101 = "unknown";
    L16:
        JSONObject r102 = new JSONObject();
        r102.put("side_bar", r100);
        r102.put("feed_id", r101);
        FLogger.f375446a.w("DouBaoFeedDataMonitor", "reportConversationDataEmpty sideBar=" + r100 + " feedId=" + r101);
        g.f365738a.monitorEventForSlardar("mixed_feed_item_empty_data", r102, null, null);
        return;
    L11:
        if (f563910a.putIfAbsent(r101, Boolean.TRUE) == null) goto L14;
        FLogger.f375446a.d("DouBaoFeedDataMonitor", "skip report, feedId already reported, feedId=".concat(r101));
        return;
    L5:
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
        goto L7
    }
}
