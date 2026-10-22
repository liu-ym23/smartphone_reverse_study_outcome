package com.ss.videoarch.strategy.network;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class VeLSNetworkManagerImpl {
    static String TAG = "VeLSSettingsManager";
    private HttpApi mHttpApi;

    public static class Inner {
        private static final VeLSNetworkManagerImpl instance = null;

        private Inner() {
        }

        static {
            instance = new VeLSNetworkManagerImpl();
        }

        public static /* synthetic */ VeLSNetworkManagerImpl access$000() {
            return instance;
        }
    }

    public VeLSNetworkManagerImpl() {
    }

    private native void nativeNotifyNetworkChange(int r100);

    public static VeLSNetworkManagerImpl getInstance() {
        return Inner.access$000();
    }

    public int getNetworkType() {
        return NetworkMonitorLoader.inst().getNetworkType();
    }

    public void notifyNetworkChange() {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return;
    L5:
        nativeNotifyNetworkChange(getNetworkType());
    }

    private String sendRequestByGet(String r100) {
        return new LSSDKConfig.DefaultHttpExecutor().executeGet(r100);
    L5:
        e = move-exception;
        e.toString();
        return "";
    }

    public String SendRequest(String r100) {
        return sendRequestByGet(r100);
    }

    public void init(LSSDKConfig r100) {
        this.mHttpApi = new HttpApi(r100);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public JSONObject sendDnsRequestByHosts(List<String> r100) {
        Objects.toString(r100);
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L11
        r101.put("Enabled", true);     // Catch: Exception -> L11
        JSONArray r102 = new JSONArray();     // Catch: Exception -> L11
        Iterator<String> r103 = r100.iterator();     // Catch: Exception -> L11
    L5:
        if (r103.hasNext() == false) goto L9;
        String r104 = r103.next();     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r104) == true) goto L5;
        r102.put(r104);     // Catch: Exception -> L11
        goto L5
    L9:
        r101.put("DomainNames", r102);     // Catch: Exception -> L11
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L11
        r105.put("HTTPDNSRequest", r101);     // Catch: Exception -> L11
        return this.mHttpApi.postJson("/api/neptune/v3/sdk/PackLiveSDK", r105);
    L11:
        e = move-exception;
        e.toString();
        return null;
    }

    private String sendRequestByPost(String r100, String r101) {
        if (this.mHttpApi != null) goto L10;
        return "";
    L10:
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L7
        return this.mHttpApi.postJson(r100, r102).toString();
    L7:
        e = move-exception;
        e.toString();
        return "";
    }

    public String SendRequest(String r100, String r101) {
        return sendRequestByPost(r100, r101);
    }

    public String SendRequestWithNodeInfo(String r100, String r101, boolean r102, boolean r103, String r104) {
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(r104) == false) goto L9;
        r104 = null;
    L9:
        String r105 = DnsOptimizer.inst().addNodeOptimizerRequestBody(r102, r103, r104);
        if (TextUtils.isEmpty(r105) == true) goto L13;
        r101 = ((r101.substring(0, r101.length() - 1) + ",") + r105) + i.f25855d;
    L13:
        return sendRequestByPost(r100, r101);
    }
}
