package com.ss.android.ugc.aweme.search.common.saas.bcm;

import bolts.Task;
import com.bytedance.android.btm.api.BtmSDK;
import java.util.Iterator;
import java.util.List;
import kc.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/bcm/ECSearchSaaSBcmManager;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchSaaSBcmManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchSaaSBcmManager f452034a = null;

    private ECSearchSaaSBcmManager() {
    }

    static {
        f452034a = new ECSearchSaaSBcmManager();
    }

    @JvmStatic
    public static final String a(boolean r100, String r101) {
        final JSONObject r102 = new JSONObject();     // Catch: Exception -> L19
        if (r100 == false) goto L5;
        final a r103 = BtmSDK.getBcmChainByToken$default(BtmSDK.INSTANCE, r101, 20, false, 4, null);     // Catch: Exception -> L19
    L6:
        JSONArray r104 = new JSONArray();     // Catch: Exception -> L19
        if (r103 != null) goto L27;
    L17:
        r102.put("chain", r104);     // Catch: Exception -> L19
        final Function0<Unit> r105 = new ECSearchSaaSBcmManager$getCurrentBcmChain$eventTask$1(r103, r102);     // Catch: Exception -> L19
        Task.callInBackground(new ECSearchSaaSBcmManager$sam$java_util_concurrent_Callable$0(r105));     // Catch: Exception -> L19
        return r102.toString();
    L27:
        List<a.C6534a> r106 = r103.f502353a;     // Catch: Throwable -> L22
        if (r106 == null) goto L17;
        Iterator<T> r107 = r106.iterator();     // Catch: Throwable -> L22
    L12:
        if (r107.hasNext() == false) goto L17;
        a.C6534a r108 = (a.C6534a) r107.next();     // Catch: Throwable -> L22
        f452034a.getClass();     // Catch: Throwable -> L22
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L22
        r109.put("btm", r108.f502356c);     // Catch: Throwable -> L21
        r109.put("btm_show_id", r108.f502358e);     // Catch: Throwable -> L21
    L15:
        r104.put(r109);     // Catch: Throwable -> L22
    L5:
        r103 = BtmSDK.getBcmChainByFinder$default(BtmSDK.INSTANCE, null, 20, false, 4, null);     // Catch: Exception -> L19
    L19:
        return "";
    }
}
