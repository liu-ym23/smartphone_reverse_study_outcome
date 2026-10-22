package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003R(\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/protocol/data/b;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/m;", "Lba6/b;", "Lcom/bytedance/kmp/ec/yata/common/platform/l;", "", "", "type", "Ljava/util/List;", "getType", "()Ljava/util/List;", "getType$annotations", "()V", "containerType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "containerName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "url", "getUrl", "version", "getVersion", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class b implements m<b>, ba6.b, com.bytedance.kmp.ec.yata.common.platform.l {

    @SerializedName("container_name")
    private final String containerName;

    @SerializedName(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE)
    private final String containerType;

    @SerializedName("type")
    private final List<String> type;

    @SerializedName("url")
    private final String url;

    @SerializedName("version")
    private final String version;

    public b() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.containerType, r101.containerType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.containerName, r101.containerName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.containerType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.containerName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.url;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.version;
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
        return "Container(type=" + this.type + ", containerType=" + this.containerType + ", containerName=" + this.containerName + ", url=" + this.url + ", version=" + this.version + ')';
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final Map<String, Object> f() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(this, "<this>");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("type", getType()), TuplesKt.to(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, b()), TuplesKt.to("container_name", a()), TuplesKt.to("url", getUrl()), TuplesKt.to("version", getVersion())});
    }

    @Override // ba6.b
    public final String getContainerType() {
        String r100 = this.containerType;
        if (r100 != null) goto L6;
        return DSLType.Slice;
    L6:
        return r100;
    }

    @Override // ba6.b
    public final String a() {
        return this.containerName;
    }

    public final String b() {
        return this.containerType;
    }

    public final List<String> getType() {
        return this.type;
    }

    @Override // ba6.b
    public final String getUrl() {
        return this.url;
    }

    @Override // ba6.b
    public final String getVersion() {
        return this.version;
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final b d(int r100) {
        return new b(this.type, this.containerType, this.containerName, this.url, this.version);
    }

    public b(List<String> r100, String r101, String r102, String r103, String r104) {
        this.type = r100;
        this.containerType = r101;
        this.containerName = r102;
        this.url = r103;
        this.version = r104;
    }
}
