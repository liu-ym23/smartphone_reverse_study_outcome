package t09;

import com.bytedance.common.utility.NetworkClient;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements xo7.e {
    public e() {
    }

    @Override // xo7.e
    public final String a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Iterator r101 = ((HashMap) r100).entrySet().iterator();
        JSONObject r102 = new JSONObject();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r101.next();
        r102.put((String) r103.getKey(), (String) r103.getValue());
        goto L4
    L6:
        byte[] r104 = r102.toString().getBytes(Charset.forName("UTF-8"));
        return NetworkClient.getDefault().post("https://zlink.toutiao.com/api/preinstall_collect", r104, false, "application/json", true);
    }
}
