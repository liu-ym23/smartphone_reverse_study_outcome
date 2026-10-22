package ud5;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final boolean a(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (new JSONObject((String) c.a.a.d("ccm_mobile_workspace_config", "")).optBoolean("disable_wiki", false) == true) goto L7;
        if (((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("ccm_workspace_wiki_entrance") == false) goto L7;
        return false;
    L7:
        return true;
    L13:
        return false;
    }
}
