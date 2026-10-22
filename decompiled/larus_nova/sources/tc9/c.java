package tc9;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.IMCmd;
import com.larus.im.bean.IMMsg;
import com.larus.im.bean.IMMsgExt;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0002()BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003JP\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/larus/im/bean/IMEvent;", "", "eventType", "", "message", "Lcom/larus/im/bean/IMMsg;", "cmd", "Lcom/larus/im/bean/IMCmd;", MapBundleKey.MapObjKey.OBJ_GEO, "Lcom/larus/im/bean/IMEvent$IMGeoInfo;", "messageList", "", "<init>", "(Ljava/lang/Integer;Lcom/larus/im/bean/IMMsg;Lcom/larus/im/bean/IMCmd;Lcom/larus/im/bean/IMEvent$IMGeoInfo;Ljava/util/List;)V", "getEventType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Lcom/larus/im/bean/IMMsg;", "getCmd", "()Lcom/larus/im/bean/IMCmd;", "getGeo", "()Lcom/larus/im/bean/IMEvent$IMGeoInfo;", "getMessageList", "()Ljava/util/List;", "needTrace", "", "shortString", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Lcom/larus/im/bean/IMMsg;Lcom/larus/im/bean/IMCmd;Lcom/larus/im/bean/IMEvent$IMGeoInfo;Ljava/util/List;)Lcom/larus/im/bean/IMEvent;", "equals", "other", "hashCode", "toString", "Companion", "IMGeoInfo", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("cmd")
    private final IMCmd cmd;

    @SerializedName("event_type")
    private final Integer eventType;

    @SerializedName(MapBundleKey.MapObjKey.OBJ_GEO)
    private final b geo;

    @SerializedName("message")
    private final IMMsg message;

    @SerializedName("message_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<IMMsg> messageList;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/im/bean/IMEvent$IMGeoInfo;", "", "latitude", "", "longitude", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLatitude", "()Ljava/lang/String;", "getLongitude", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("latitude")
        private final String latitude;

        @SerializedName("longitude")
        private final String longitude;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.latitude, r101.latitude) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.longitude, r101.longitude) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.latitude;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.longitude;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "IMGeoInfo(latitude=" + this.latitude + ", longitude=" + this.longitude + ')';
        }

        public b() {
            this.latitude = "";
            this.longitude = "";
        }
    }

    static {
    }

    public c() {
        this.eventType = 1;
        this.message = null;
        this.cmd = null;
        this.geo = null;
        this.messageList = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.eventType, r101.eventType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cmd, r101.cmd) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.geo, r101.geo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageList, r101.messageList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.eventType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        IMMsg r104 = this.message;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        IMCmd r107 = this.cmd;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        b r110 = this.geo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<IMMsg> r113 = this.messageList;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "IMEvent(eventType=" + this.eventType + ", message=" + this.message + ", cmd=" + this.cmd + ", geo=" + this.geo + ", messageList=" + this.messageList + ')';
    }

    public final boolean c() {
        Integer r100 = this.eventType;
        if (r100 != null) goto L6;
    L7:
        return true;
    L6:
        if (r100.intValue() != 1) goto L7;
        IMMsg r101 = this.message;
        if (r101 == null) goto L16;
        Integer r102 = r101.j();
        if (r102 == null) goto L16;
        if (r102.intValue() != 1) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == true) goto L19;
        return true;
    L19:
        IMMsgExt r104 = this.message.d();
        if (r104 != null) goto L22;
    L24:
        boolean r105 = false;
    L25:
        if (r105 == true) goto L36;
        IMMsgExt r106 = this.message.d();
        if (r106 != null) goto L29;
    L31:
        boolean r107 = false;
    L32:
        if (r107 == true) goto L37;
        return false;
    L37:
        return true;
    L29:
        if (r106.isErr() != true) goto L31;
        r107 = true;
        goto L32
    L36:
        return true;
    L22:
        if (r104.isFinish() != true) goto L24;
        r105 = true;
    L16:
        r103 = false;
        goto L17
    }

    public final IMCmd a() {
        return this.cmd;
    }

    public final Integer b() {
        return this.eventType;
    }
}
