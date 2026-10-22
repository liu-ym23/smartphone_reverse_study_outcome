package jr9;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/platform/model/share/ShareItemConfig;", "", "channelType", "", "shareType", "shareItemUIConfig", "Lcom/larus/platform/model/share/ShareItemUIConfig;", "traceMap", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/share/ShareItemUIConfig;Ljava/util/Map;)V", "getChannelType", "()Ljava/lang/String;", "getShareType", "getShareItemUIConfig", "()Lcom/larus/platform/model/share/ShareItemUIConfig;", "setShareItemUIConfig", "(Lcom/larus/platform/model/share/ShareItemUIConfig;)V", "getTraceMap", "()Ljava/util/Map;", "setTraceMap", "(Ljava/util/Map;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient b f500141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Map<String, String> f500142b;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private final String channelType;

    @SerializedName("share_type")
    private final String shareType;

    public a() {
        String r100 = null;
        this(r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.channelType, r101.channelType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shareType, r101.shareType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f500141a, r101.f500141a) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f500142b, r101.f500142b) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.channelType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.shareType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.f500141a;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.f500142b.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareItemConfig(channelType=" + this.channelType + ", shareType=" + this.shareType + ", shareItemUIConfig=" + this.f500141a + ", traceMap=" + this.f500142b + ')';
    }

    public final String b() {
        return this.channelType;
    }

    public final String c() {
        return this.shareType;
    }

    public static a a(a r100) {
        String r101 = r100.channelType;
        b r102 = r100.f500141a;
        Map<String, String> r103 = r100.f500142b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "traceMap");
        return new a(r101, ShareType.FILE_URL, r102, r103);
    }

    public /* synthetic */ a(String r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r102 & 8) == 0) goto L11;
        LinkedHashMap r103 = new LinkedHashMap();
    L12:
        this(r100, r101, null, r103);
        return;
    L11:
        r103 = null;
        goto L12
    }

    public a(String r100, String r101, b r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r103, "traceMap");
        this.channelType = r100;
        this.shareType = r101;
        this.f500141a = r102;
        this.f500142b = r103;
    }
}
