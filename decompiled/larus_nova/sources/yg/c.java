package yg;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lyg/c;", "", "", "app", "Ljava/lang/String;", "getApp", "()Ljava/lang/String;", "setApp", "(Ljava/lang/String;)V", "appVersion", "getAppVersion", "setAppVersion", "platform", "getPlatform", "setPlatform", "msgID", "getMsgID", "setMsgID", "Business", "getBusiness", "setBusiness", "msgType", "getMsgType", "setMsgType", "itemID", "getItemID", "setItemID", "bizMsgID", "getBizMsgID", "setBizMsgID", "", "action", "Ljava/lang/Integer;", "getAction", "()Ljava/lang/Integer;", "setAction", "(Ljava/lang/Integer;)V", "", WsConstants.KEY_PAYLOAD, "Ljava/util/Map;", "getPayload", "()Ljava/util/Map;", "setPayload", "(Ljava/util/Map;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("Business")
    private String Business;

    @SerializedName("action")
    private Integer action;

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    @SerializedName("app")
    private String f567460app;

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName("bizMsgID")
    private String bizMsgID;

    @SerializedName("itemID")
    private String itemID;

    @SerializedName("msgID")
    private String msgID;

    @SerializedName("msgType")
    private String msgType;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    private Map<String, String> payload;

    @SerializedName("platform")
    private String platform;

    public c() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L26;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f567460app, r101.f567460app) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appVersion, r101.appVersion) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.platform, r101.platform) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msgID, r101.msgID) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.Business, r101.Business) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.msgType, r101.msgType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.itemID, r101.itemID) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bizMsgID, r101.bizMsgID) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f567460app;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.appVersion;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.platform;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.msgID;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.Business;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.msgType;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.itemID;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.bizMsgID;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.action;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.payload;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SceneRecvMessage(app=" + this.f567460app + ", appVersion=" + this.appVersion + ", platform=" + this.platform + ", msgID=" + this.msgID + ", Business=" + this.Business + ", msgType=" + this.msgType + ", itemID=" + this.itemID + ", bizMsgID=" + this.bizMsgID + ", action=" + this.action + ", payload=" + this.payload + ")";
    }

    public c(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, Integer r108, Map<String, String> r110) {
        this.f567460app = r100;
        this.appVersion = r101;
        this.platform = r102;
        this.msgID = r103;
        this.Business = r104;
        this.msgType = r105;
        this.itemID = r106;
        this.bizMsgID = r107;
        this.action = r108;
        this.payload = r110;
    }
}
