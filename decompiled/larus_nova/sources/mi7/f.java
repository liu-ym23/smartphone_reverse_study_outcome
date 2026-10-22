package mi7;

import android.util.Pair;
import ci7.z;
import com.bytedance.ug.sdk.deeplink.interfaces.INetwork;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    public class a extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final boolean markAsNewUser() {
            return super.markAsNewUser();
        }

        public a() {
        }
    }

    public static Map a(Map r100) {
        a r101 = new a();     // Catch: Exception -> L8
        if (r100 != null) goto L5;
        Map r102 = new HashMap();     // Catch: Exception -> L8
    L6:
        Pair<String, String> r103 = BDNetworkTagManager.getInstance().buildBDNetworkTag(r101);     // Catch: Exception -> L8
        r102.put(r103.first, r103.second);     // Catch: Exception -> L8
        return r102;
    L5:
        r102 = r100;
    L8:
        return r100;
    }

    public static String b(String r100, Map r101) {
        INetwork r102 = (INetwork) z.a(INetwork.class);
        if (r102 != null) goto L10;
    L8:
        return null;
    L10:
        return r102.get(r100, a(r101), true, 2000);
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static String c(String r100, Map r110, byte[] r111, long r112, JSONObject r113) {
        INetwork r101 = (INetwork) z.a(INetwork.class);
        if (r101 != null) goto L10;
    L8:
        return null;
    L10:
        return r101.post(r100, a(r110), r111, r112, false, "application/json; charset=utf-8", true);
    L6:
        th = move-exception;
        th.printStackTrace();
        d.a(r113, "code", th.getMessage());
        goto L8
    }
}
