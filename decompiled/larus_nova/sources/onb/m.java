package onb;

import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$ResultCode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f524437a = null;

    static {
        HashMap r100 = new HashMap(4);
        f524437a = r100;
        r100.put(DocFeed$Value$ResultCode.PULL_DATA_NETWORK_TIMEOUT, "RN JS connect timeout");
        r100.put(DocFeed$Value$ResultCode.PULL_DATA_NETWORK_NETWORK_ERROR, "RN JS disconnect");
        r100.put(DocFeed$Value$ResultCode.PULL_DATA_NETWORK_NO_PERMISSION, "JS update data timeout");
        r100.put(DocFeed$Value$ResultCode.PULL_DATA_NETWORK_PARSE_RESPONSE, "JS message error");
    }
}
