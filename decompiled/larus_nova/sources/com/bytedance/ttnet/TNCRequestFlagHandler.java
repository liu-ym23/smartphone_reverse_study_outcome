package com.bytedance.ttnet;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.http.RequestContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TNCRequestFlagHandler implements SsHttpCall.IRequestFlagHandler {
    private static final String TAG = "TNCRequestFlagHandler";
    private static volatile TNCRequestFlagHandler sInstance;
    private final List<SingleRequestFlagConfig> mRequestFlagConfigs;
    private final AtomicBoolean mRequestFlagCtlEnabled;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class SingleRequestFlagConfig {
        final List<String> mMatchHosts;
        final List<String> mMatchPaths;
        int mTncRequestCronetFlags;
        int mTncRequestTTNetFlags;

        public SingleRequestFlagConfig(int r100, int r101, List<String> r102, List<String> r103) {
            ArrayList r104 = new ArrayList();
            this.mMatchHosts = r104;
            ArrayList r105 = new ArrayList();
            this.mMatchPaths = r105;
            this.mTncRequestCronetFlags = r100;
            this.mTncRequestTTNetFlags = r101;
            r104.addAll(r102);
            r105.addAll(r103);
        }
    }

    public static TNCRequestFlagHandler getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(TNCRequestFlagHandler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TNCRequestFlagHandler();     // Catch: Throwable -> L11
        SsHttpCall.setRequestFlagHandler(sInstance);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TNCRequestFlagHandler.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public TNCRequestFlagHandler() {
        this.mRequestFlagConfigs = new CopyOnWriteArrayList();
        this.mRequestFlagCtlEnabled = new AtomicBoolean(false);
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public int getPriorityInContext(Request r100) {
        if ((r100.getExtraInfo() instanceof BaseRequestContext) == true) goto L5;
        return -999;
    L5:
        return ((BaseRequestContext) r100.getExtraInfo()).priorityLevel;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public Request handleFlag(Request r100) {
        if (r100 != null) goto L5;
        return r100;
    L5:
        if ((r100.getExtraInfo() instanceof BaseRequestContext) == false) goto L12;
        int r101 = ((BaseRequestContext) r100.getExtraInfo()).commonParamLevel;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "handleFlag commonParamLevelInCtx: " + r101);
    L9:
        if (r101 <= 0) goto L12;
        r100.setCommonParamLevel(Math.max(r100.getCommonParamLevel(), r101));
    L12:
        if (this.mRequestFlagCtlEnabled.get() == true) goto L14;
        return r100;
    L14:
        Iterator<SingleRequestFlagConfig> r102 = this.mRequestFlagConfigs.iterator();
    L15:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L47;
        SingleRequestFlagConfig r104 = r102.next();
        Iterator<String> r105 = r104.mMatchHosts.iterator();
    L19:
        if (r105.hasNext() == false) goto L23;
        if (UrlUtils.matchPattern(r100.getHost(), r105.next()) == false) goto L19;
        boolean r106 = true;
    L24:
        if (r106 == false) goto L15;
        List<String> r107 = r104.mMatchPaths;
        if (r107 == null) goto L15;
        Iterator<String> r108 = r107.iterator();
    L31:
        if (r108.hasNext() == false) goto L37;
        String r109 = r108.next();
        if (r100.getPath() == null) goto L31;
        if (r100.getPath().startsWith(r109) == false) goto L31;
    L38:
        if (r103 == false) goto L15;
        if (r100.getExtraInfo() != null) goto L44;
        Request.Builder r110 = r100.newBuilder();
        r110.setExtraInfo(new RequestContext());
        r100 = r110.build();
    L44:
        if ((r100.getExtraInfo() instanceof BaseRequestContext) == false) goto L15;
        BaseRequestContext r111 = (BaseRequestContext) r100.getExtraInfo();
        r111.request_flag |= r104.mTncRequestCronetFlags;
        r111.request_type_flags = r104.mTncRequestTTNetFlags | r111.request_type_flags;
        Request.Builder r112 = r100.newBuilder();
        r112.setExtraInfo(r111);
        r100 = r112.build();
        goto L15
    L37:
        r103 = false;
        goto L38
    L23:
        r106 = false;
        goto L24
    L47:
        if ((r100.getExtraInfo() instanceof BaseRequestContext) == false) goto L85;
        int r113 = ((BaseRequestContext) r100.getExtraInfo()).request_type_flags;
        if ((r113 & 2048) <= 0) goto L51;
        boolean r114 = true;
    L53:
        if ((r113 & 4096) > 0) goto L56;
        r103 = false;
    L56:
        if (r114 == true) goto L58;
        if (r103 == true) goto L58;
        return r100;
    L58:
        Request.Builder r115 = r100.newBuilder();
        ArrayList r116 = new ArrayList();
        r116.addAll(r100.getHeaders());
        if (r114 == false) goto L61;
        r116.add(new Header(Request.KEY_BYPASS_TTNET_FEATURES, "1"));
    L61:
        if (r103 == false) goto L63;
        r116.add(new Header(Request.KEY_BYPASS_DISPATCH, "1"));
    L63:
        r115.headers(r116);
        return r115.build();
    L51:
        r114 = false;
        goto L53
    L85:
        return r100;
    }

    public void parseJson2Config(JSONObject r110) {
        JSONArray r100 = r110.optJSONArray("request_flag_control");
        if (r100 != null) goto L5;
        return;
    L5:
        this.mRequestFlagCtlEnabled.set(false);
        this.mRequestFlagConfigs.clear();
        ArrayList r101 = new ArrayList();     // Catch: JSONException -> L38
        int r102 = 0;
    L8:
        if (r102 >= r100.length()) goto L33;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r100, r102);     // Catch: JSONException -> L38
        int r104 = r103.optInt("cronet_flags");     // Catch: JSONException -> L38
        int r105 = r103.optInt("ttnet_flags");     // Catch: JSONException -> L38
        JSONArray r106 = r103.optJSONArray("prefix_group");     // Catch: JSONException -> L38
        JSONArray r107 = r103.optJSONArray("host_group");     // Catch: JSONException -> L38
        ArrayList r108 = new ArrayList();     // Catch: JSONException -> L38
        if (r106 == null) goto L16;
        int r111 = 0;
    L14:
        if (r111 >= r106.length()) goto L16;
        r108.add(r106.optString(r111, ""));     // Catch: JSONException -> L38
        r111 = r111 + 1;     // Catch: JSONException -> L38
    L16:
        ArrayList r109 = new ArrayList();     // Catch: JSONException -> L38
        if (r107 == null) goto L22;
        int r112 = 0;
    L20:
        if (r112 >= r107.length()) goto L22;
        r109.add(r107.optString(r112, ""));     // Catch: JSONException -> L38
        r112 = r112 + 1;     // Catch: JSONException -> L38
    L22:
        if (r104 > 0) goto L25;
        if (r105 > 0) goto L25;
    L31:
        r102 = r102 + 1;     // Catch: JSONException -> L38
    L25:
        if (r108.isEmpty() == true) goto L31;
        if (r109.isEmpty() == true) goto L31;
        r101.add(new SingleRequestFlagConfig(r104, r105, r109, r108));     // Catch: JSONException -> L38
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "paths: " + r108);     // Catch: JSONException -> L38
        Logger.d(TAG, "hosts: " + r109);     // Catch: JSONException -> L38
        Logger.d(TAG, "flag: " + r104);     // Catch: JSONException -> L38
        Logger.d(TAG, "type flag: " + r105);     // Catch: JSONException -> L38
        goto L31
    L33:
        if (r110.optInt("req_flag_ctl_enabled") > 0) goto L35;
        return;
    L35:
        if (r101.size() <= 0) goto L50;
        this.mRequestFlagConfigs.addAll(r101);     // Catch: JSONException -> L38
        this.mRequestFlagCtlEnabled.set(true);     // Catch: JSONException -> L38
        return;
    L50:
        return;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public boolean shouldBypassInterceptor(Request r100) {
        if ((r100.getExtraInfo() instanceof BaseRequestContext) == false) goto L10;
        int r101 = ((BaseRequestContext) r100.getExtraInfo()).request_type_flags;
        if ((r101 & 1024) <= 0) goto L7;
    L8:
        return true;
    L7:
        if ((r101 & 2048) > 0) goto L8;
        return false;
    L10:
        return false;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public boolean shouldUseCustomInterceptor(Request r100) {
        if ((r100.getExtraInfo() instanceof BaseRequestContext) == true) goto L5;
        return false;
    L5:
        if ((((BaseRequestContext) r100.getExtraInfo()).request_type_flags & 8192) <= 0) goto L9;
        return true;
    L9:
        return false;
    }
}
