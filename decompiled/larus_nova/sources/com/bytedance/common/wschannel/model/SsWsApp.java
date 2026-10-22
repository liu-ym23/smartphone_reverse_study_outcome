package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SsWsApp implements IWsApp, Parcelable {
    public static final Parcelable.Creator<SsWsApp> CREATOR = null;
    private String appKey;
    private int channelId;
    private String extra;
    private int fPid;
    private Map<String, String> headers;
    private int mAppId;
    private int mAppVersion;
    private String mDeviceId;
    boolean mDisableFallbackWs;
    private String mInstallId;
    int mMode;
    boolean mNewPrivateProtocolEnabled;
    private int mPlatform;
    String mPrivateProtocolUrl;
    List<Integer> mServiceIdList;
    private List<String> urls;

    public static class SsWsAppBuilder {
        private int channelId;
        private Map<String, String> headers;
        private int mAppId;
        private String mAppKey;
        private int mAppVersion;
        private String mDeviceId;
        boolean mDisableFallbackWS;
        private String mExtra;
        private int mFpid;
        private String mInstallId;
        int mMode;
        boolean mNewPrivateProtocolEnabled;
        private int mPlatform;
        String mPrivateProtocolUrl;
        List<Integer> mServiceIdList;
        private List<String> urls;

        public SsWsApp build() {
            return new SsWsApp(this.channelId, this.mAppId, this.mDeviceId, this.mInstallId, this.urls, this.mAppVersion, this.mPlatform, this.mFpid, this.mAppKey, this.mExtra, this.mNewPrivateProtocolEnabled, this.mServiceIdList, this.mPrivateProtocolUrl, this.mMode, this.mDisableFallbackWS, this, null);
        }

        public SsWsAppBuilder() {
            this.mServiceIdList = new ArrayList();
        }

        public static /* synthetic */ Map access$000(SsWsAppBuilder r100) {
            return r100.headers;
        }

        public SsWsApp buildFromJson(JSONObject r100) {
            SsWsApp r101 = new SsWsApp();
            r101.parseFromJson(r100);
            return r101;
        }

        public SsWsAppBuilder disableFallbackWS(boolean r100) {
            this.mDisableFallbackWS = r100;
            return this;
        }

        public SsWsAppBuilder enableNewPrivateProtocol(boolean r100) {
            this.mNewPrivateProtocolEnabled = r100;
            return this;
        }

        public SsWsAppBuilder setAppId(int r100) {
            this.mAppId = r100;
            return this;
        }

        public SsWsAppBuilder setAppKey(String r100) {
            this.mAppKey = r100;
            return this;
        }

        public SsWsAppBuilder setAppVersion(int r100) {
            this.mAppVersion = r100;
            return this;
        }

        public SsWsAppBuilder setChannelId(int r100) {
            this.channelId = r100;
            return this;
        }

        public SsWsAppBuilder setConnectUrls(List<String> r100) {
            this.urls = r100;
            return this;
        }

        public SsWsAppBuilder setDeviceId(String r100) {
            this.mDeviceId = r100;
            return this;
        }

        public SsWsAppBuilder setExtra(String r100) {
            this.mExtra = r100;
            return this;
        }

        public SsWsAppBuilder setFPID(int r100) {
            this.mFpid = r100;
            return this;
        }

        public SsWsAppBuilder setHeaders(Map<String, String> r100) {
            this.headers = r100;
            return this;
        }

        public SsWsAppBuilder setInstallId(String r100) {
            this.mInstallId = r100;
            return this;
        }

        public SsWsAppBuilder setPlatform(int r100) {
            this.mPlatform = r100;
            return this;
        }

        public SsWsAppBuilder setPrivateProtocolUrl(String r100) {
            this.mPrivateProtocolUrl = r100;
            return this;
        }

        public SsWsAppBuilder setServiceIdList(List<Integer> r100) {
            this.mServiceIdList = r100;
            return this;
        }

        public SsWsAppBuilder setTransportMode(int r100) {
            this.mMode = r100;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int hashCode() {
        int r100 = this.headers.hashCode() * 31;
        List<String> r101 = this.urls;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.channelId) * 31;
        String r105 = this.extra;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((r104 + r106) * 31) + this.mAppId) * 31;
        String r108 = this.mDeviceId;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.mInstallId;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (((((((r110 + r112) * 31) + this.mAppVersion) * 31) + this.mPlatform) * 31) + this.fPid) * 31;
        String r114 = this.appKey;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public JSONObject toJson() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("channel_id", this.channelId);
        r100.put("app_id", this.mAppId);
        r100.put("device_id", this.mDeviceId);
        r100.put("install_id", this.mInstallId);
        JSONArray r101 = new JSONArray();
        List<String> r102 = this.urls;
        if (r102 == null) goto L8;
        Iterator<String> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r101.put(r103.next());
    L8:
        r100.put("headers", Utils.mapToJson(this.headers));
        r100.put("urls", r101);
        r100.put("app_version", this.mAppVersion);
        r100.put("platform", this.mPlatform);
        r100.put(WsConstants.KEY_FPID, this.fPid);
        r100.put("app_kay", this.appKey);
        r100.put("extra", this.extra);
        r100.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, this.mNewPrivateProtocolEnabled);
        JSONArray r104 = new JSONArray();
        List<Integer> r105 = this.mServiceIdList;
        if (r105 == null) goto L14;
        Iterator<Integer> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r104.put(r106.next());
    L14:
        r100.put(WsConstants.KEY_SERVICE_ID_LIST, r104);
        r100.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, this.mPrivateProtocolUrl);
        r100.put(WsConstants.KEY_TRANSPORT_MODE, this.mMode);
        r100.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, this.mDisableFallbackWs);
        return r100;
    }

    public SsWsApp() {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public boolean disableFallbackWSEnabled() {
        return this.mDisableFallbackWs;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getAppId() {
        return this.mAppId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getAppKey() {
        return this.appKey;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getAppVersion() {
        return this.mAppVersion;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getChannelId() {
        return this.channelId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public List<String> getConnectUrls() {
        return this.urls;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getDeviceId() {
        return this.mDeviceId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getFPID() {
        return this.fPid;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getInstallId() {
        return this.mInstallId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getPlatform() {
        return this.mPlatform;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getPrivateProtocolUrl() {
        return this.mPrivateProtocolUrl;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public List<Integer> getServiceIdList() {
        return this.mServiceIdList;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getTransportMode() {
        return this.mMode;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public boolean newPrivateProtocolEnabled() {
        return this.mNewPrivateProtocolEnabled;
    }

    public SsWsApp(Parcel r100) {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
        int r101 = r100.readInt();
        this.headers = new HashMap(r101);
        boolean r102 = false;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        String r104 = r100.readString();
        String r105 = r100.readString();
        this.headers.put(r104, r105);
        r103 = r103 + 1;
        goto L3
    L5:
        this.urls = r100.createStringArrayList();
        this.channelId = r100.readInt();
        this.extra = r100.readString();
        this.mAppId = r100.readInt();
        this.mDeviceId = r100.readString();
        this.mInstallId = r100.readString();
        this.mAppVersion = r100.readInt();
        this.mPlatform = r100.readInt();
        this.fPid = r100.readInt();
        this.appKey = r100.readString();
        if (r100.readByte() == 0) goto L8;
        boolean r106 = true;
    L9:
        this.mNewPrivateProtocolEnabled = r106;
        int r107 = r100.readInt();
        int r108 = 0;
    L10:
        if (r108 >= r107) goto L12;
        this.mServiceIdList.add(Integer.valueOf(r100.readInt()));
        r108 = r108 + 1;
        goto L10
    L12:
        this.mPrivateProtocolUrl = r100.readString();
        this.mMode = r100.readInt();
        if (r100.readByte() == 0) goto L15;
        r102 = true;
    L15:
        this.mDisableFallbackWs = r102;
        return;
    L8:
        r106 = false;
        goto L9
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L67:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L67;
        SsWsApp r101 = (SsWsApp) r100;
        if (this.channelId == r101.channelId) goto L14;
        return false;
    L14:
        if (this.mAppId == r101.mAppId) goto L17;
        return false;
    L17:
        if (this.mAppVersion == r101.mAppVersion) goto L20;
        return false;
    L20:
        if (this.mPlatform == r101.mPlatform) goto L23;
        return false;
    L23:
        if (this.fPid == r101.fPid) goto L26;
        return false;
    L26:
        if (this.headers.equals(r101.headers) == true) goto L28;
        return false;
    L28:
        List<String> r102 = this.urls;
        if (r102 == null) goto L34;
        if (r102.equals(r101.urls) == false) goto L35;
    L36:
        String r103 = this.extra;
        if (r103 == null) goto L42;
        if (r103.equals(r101.extra) == false) goto L43;
    L44:
        String r104 = this.mDeviceId;
        if (r104 == null) goto L50;
        if (r104.equals(r101.mDeviceId) == false) goto L51;
    L52:
        String r105 = this.mInstallId;
        if (r105 == null) goto L58;
        if (r105.equals(r101.mInstallId) == false) goto L59;
    L60:
        String r106 = this.appKey;
        String r107 = r101.appKey;
        if (r106 != null) goto L68;
        if (r107 == null) goto L69;
        return false;
    L69:
        return true;
    L68:
        return r106.equals(r107);
    L59:
        return false;
    L58:
        if (r101.mInstallId == null) goto L60;
    L51:
        return false;
    L50:
        if (r101.mDeviceId == null) goto L52;
    L43:
        return false;
    L42:
        if (r101.extra == null) goto L44;
    L35:
        return false;
    L34:
        if (r101.urls == null) goto L36;
        goto L35
    }

    public void parseFromJson(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.channelId = r100.optInt("channel_id");
        this.mAppId = r100.optInt("app_id");
        this.mDeviceId = r100.optString("device_id");
        this.mInstallId = r100.optString("install_id");
        this.mAppVersion = r100.optInt("app_version");
        this.mPlatform = r100.optInt("platform");
        this.fPid = r100.optInt(WsConstants.KEY_FPID);
        this.appKey = r100.optString("app_kay");
        this.extra = r100.optString("extra");
        JSONArray r101 = r100.optJSONArray("urls");
        this.urls.clear();
        int r102 = 0;
        if (r101 == null) goto L9;
        int r103 = r101.length();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L9;
        this.urls.add(r101.optString(r104));
        r104 = r104 + 1;
    L9:
        this.mNewPrivateProtocolEnabled = r100.optBoolean(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE);
        JSONArray r105 = r100.optJSONArray(WsConstants.KEY_SERVICE_ID_LIST);
        this.mServiceIdList.clear();
        if (r105 == null) goto L14;
        int r106 = r105.length();
    L12:
        if (r102 >= r106) goto L14;
        this.mServiceIdList.add(Integer.valueOf(r105.optInt(r102)));
        r102 = r102 + 1;
    L14:
        this.mPrivateProtocolUrl = r100.optString(WsConstants.KEY_PRIVATE_PROTOCOL_URL);
        this.mMode = r100.optInt(WsConstants.KEY_TRANSPORT_MODE);
        this.mDisableFallbackWs = r100.optBoolean(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET);
        this.headers.clear();
        this.headers.putAll(Utils.jsonToMap(r100.optJSONObject("headers")));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.headers.size());
        Iterator<Map.Entry<String, String>> r102 = this.headers.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, String> r103 = r102.next();
        r100.writeString(r103.getKey());
        r100.writeString(r103.getValue());
        goto L4
    L6:
        r100.writeStringList(this.urls);
        r100.writeInt(this.channelId);
        r100.writeString(this.extra);
        r100.writeInt(this.mAppId);
        r100.writeString(this.mDeviceId);
        r100.writeString(this.mInstallId);
        r100.writeInt(this.mAppVersion);
        r100.writeInt(this.mPlatform);
        r100.writeInt(this.fPid);
        r100.writeString(this.appKey);
        r100.writeByte(this.mNewPrivateProtocolEnabled ? 1 : 0);
        r100.writeInt(this.mServiceIdList.size());
        Iterator<Integer> r104 = this.mServiceIdList.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r100.writeInt(r104.next().intValue());
        goto L8
    L10:
        r100.writeString(this.mPrivateProtocolUrl);
        r100.writeInt(this.mMode);
        r100.writeByte(this.mDisableFallbackWs ? 1 : 0);
    }

    private SsWsApp(int r100, int r101, String r102, String r103, List<String> r104, int r105, int r110, int r111, String r112, String r113, boolean r114, List<Integer> r115, String r116, int r117, boolean r118, SsWsAppBuilder r119) {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
        this.mAppId = r101;
        this.channelId = r100;
        this.mDeviceId = r102;
        this.mInstallId = r103;
        if (r104 == null) goto L5;
        this.urls.addAll(r104);
    L5:
        this.mAppVersion = r105;
        this.mPlatform = r110;
        this.fPid = r111;
        this.appKey = r112;
        this.extra = r113;
        if (SsWsAppBuilder.access$000(r119) == null) goto L8;
        this.headers.putAll(SsWsAppBuilder.access$000(r119));
    L8:
        this.mNewPrivateProtocolEnabled = r114;
        this.mServiceIdList = r115;
        this.mPrivateProtocolUrl = r116;
        this.mMode = r117;
        this.mDisableFallbackWs = r118;
    }

    public /* synthetic */ SsWsApp(int r100, int r101, String r102, String r103, List r104, int r105, int r106, int r107, String r108, String r110, boolean r111, List r112, String r113, int r114, boolean r115, SsWsAppBuilder r116, AnonymousClass1 r117) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116);
    }
}
