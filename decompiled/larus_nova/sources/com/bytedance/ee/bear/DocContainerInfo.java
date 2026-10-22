package com.bytedance.ee.bear;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u0004H\u0016J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/DocContainerInfo;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "node_token", "", "biz_type", "", "is_exist", "", "logId", "<init>", "(Ljava/lang/String;IZLjava/lang/String;)V", "getNode_token", "()Ljava/lang/String;", "setNode_token", "(Ljava/lang/String;)V", "getBiz_type", "()I", "setBiz_type", "(I)V", "()Z", "set_exist", "(Z)V", "getLogId", "setLogId", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocContainerInfo extends Result<Serializable> {
    private int biz_type;
    private boolean is_exist;
    private String logId;
    private String node_token;

    public DocContainerInfo() {
        this(null, 0, false, null, 15, null);
    }

    public static /* synthetic */ DocContainerInfo copy$default(DocContainerInfo r100, String r101, int r102, boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.node_token;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.biz_type;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.is_exist;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.logId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.node_token;
    }

    public final int component2() {
        return this.biz_type;
    }

    public final boolean component3() {
        return this.is_exist;
    }

    public final String component4() {
        return this.logId;
    }

    public final DocContainerInfo copy(String r100, int r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "node_token");
        Intrinsics.checkNotNullParameter(r103, "logId");
        return new DocContainerInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocContainerInfo) == true) goto L8;
        return false;
    L8:
        DocContainerInfo r101 = (DocContainerInfo) r100;
        if (Intrinsics.areEqual(this.node_token, r101.node_token) == true) goto L12;
        return false;
    L12:
        if (this.biz_type == r101.biz_type) goto L15;
        return false;
    L15:
        if (this.is_exist == r101.is_exist) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.node_token.hashCode() * 31) + this.biz_type) * 31;
        if (this.is_exist == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.logId.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "Container info node_token is " + du5.b.g(this.node_token) + " , biz_type is " + this.biz_type + " ,is_exist is " + this.is_exist + ", logid is " + this.logId;
    }

    public final int getBiz_type() {
        return this.biz_type;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getNode_token() {
        return this.node_token;
    }

    public final boolean is_exist() {
        return this.is_exist;
    }

    public final void setBiz_type(int r100) {
        this.biz_type = r100;
    }

    public final void setLogId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logId = r100;
    }

    public final void setNode_token(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.node_token = r100;
    }

    public final void set_exist(boolean r100) {
        this.is_exist = r100;
    }

    public DocContainerInfo(String r100, int r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "node_token");
        Intrinsics.checkNotNullParameter(r103, "logId");
        this.node_token = r100;
        this.biz_type = r101;
        this.is_exist = r102;
        this.logId = r103;
    }

    public /* synthetic */ DocContainerInfo(String r100, int r101, boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = true;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
