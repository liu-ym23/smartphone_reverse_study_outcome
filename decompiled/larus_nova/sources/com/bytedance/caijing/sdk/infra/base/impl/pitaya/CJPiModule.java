package com.bytedance.caijing.sdk.infra.base.impl.pitaya;

import android.content.Context;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/pitaya/CJPiModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "", "inputJsonString", "kvStorageRead", "jsonString", "", "kvStorageWrite", "abSettingKey", "getABTestValAndExposure", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-impl-pitaya_release"}, k = 1, mv = {1, 6, 0})
public final class CJPiModule extends JSModule {
    public static final a Companion = null;
    public static final String NAME = "CJPayIntelligenceJsModule";
    private static de4.a callback;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static final /* synthetic */ de4.a access$getCallback$cp() {
        return callback;
    }

    public CJPiModule(Context r100) {
        super(r100);
    }

    public static final /* synthetic */ void access$setCallback$cp(de4.a r100) {
        callback = r100;
    }

    @JSMethod
    public final String getABTestValAndExposure(String r100) {
        Intrinsics.checkNotNullParameter(r100, "abSettingKey");
        de4.a r101 = callback;     // Catch: Exception -> L10
        if (r101 == null) goto L13;
        String r102 = r101.getABTestValAndExposure(r100);     // Catch: Exception -> L10
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L13:
        return "";
    L15:
        return "";
    }

    @JSMethod
    public final String kvStorageRead(String r100) {
        Intrinsics.checkNotNullParameter(r100, "inputJsonString");
        JSONObject r101 = new JSONObject();
        JSONArray r102 = new JSONArray(r100);     // Catch: Exception -> L14
        int r103 = r102.length();     // Catch: Exception -> L14
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L13;
        String r105 = JSONArrayProtectorUtils.getString(r102, r104);     // Catch: Exception -> L14
        de4.a r106 = callback;     // Catch: Exception -> L14
        if (r106 == null) goto L8;
        String r107 = r106.storeStringRead(r105, "");     // Catch: Exception -> L14
    L9:
        if (r107 == null) goto L11;
        r101.put(r105, r107);     // Catch: Exception -> L14
    L11:
        r104 = r104 + 1;
        goto L4
    L8:
        r107 = null;
    L13:
        return r101.toString();
    }

    @JSMethod
    public final void kvStorageWrite(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L13
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L13
    L5:
        if (r102.hasNext() == false) goto L23;
        String r103 = r102.next();     // Catch: Exception -> L13
        Object r104 = r101.get(r103);     // Catch: Exception -> L12
        de4.a r105 = callback;     // Catch: Exception -> L12
        if (r105 == null) goto L5;
        r105.storeStringWrite(r103, r104.toString());     // Catch: Exception -> L12
        goto L5
    L23:
        return;
    }
}
