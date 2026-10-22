package com.larus.doc.api.data;

import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import e39.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/doc/api/data/Document;", "Ljava/io/Serializable;", "resourceId", "", "title", UserInfo.UPDATE_TIME, "", "nodeInfo", "Lcom/larus/doc/api/data/NodeInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/larus/doc/api/data/NodeInfo;)V", "getResourceId", "()Ljava/lang/String;", "getTitle", "getUpdateTime", "()J", "getNodeInfo", "()Lcom/larus/doc/api/data/NodeInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Document implements Serializable {

    @SerializedName("content")
    private final a nodeInfo;

    @SerializedName("key")
    private final String resourceId;

    @SerializedName("name")
    private final String title;

    @SerializedName("update_time")
    private final long updateTime;

    public Document() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ Document copy$default(Document r100, String r101, String r102, long r103, a r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.resourceId;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.title;
    L8:
        String r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.updateTime;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.nodeInfo;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.resourceId;
    }

    public final String component2() {
        return this.title;
    }

    public final long component3() {
        return this.updateTime;
    }

    public final a component4() {
        return this.nodeInfo;
    }

    public final Document copy(String r100, String r101, long r110, a r111) {
        return new Document(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Document) == true) goto L8;
        return false;
    L8:
        Document r101 = (Document) r100;
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (this.updateTime == r101.updateTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nodeInfo, r101.nodeInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.resourceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.updateTime;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        a r109 = this.nodeInfo;
        if (r109 == null) goto L15;
        r101 = r109.hashCode();
    L15:
        return r108 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "Document(resourceId=" + this.resourceId + ", title=" + this.title + ", updateTime=" + this.updateTime + ", nodeInfo=" + this.nodeInfo + ')';
    }

    public final a getNodeInfo() {
        return this.nodeInfo;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public Document(String r100, String r101, long r102, a r103) {
        this.resourceId = r100;
        this.title = r101;
        this.updateTime = r102;
        this.nodeInfo = r103;
    }

    public /* synthetic */ Document(String r100, String r101, long r102, a r103, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r105 = r102;
        if ((r110 & 8) == 0) goto L16;
        a r113 = null;
    L17:
        this(r112, r104, r105, r113);
        return;
    L16:
        r113 = r103;
        goto L17
    L9:
        r104 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
