package com.larus.im.internal.jni.dependency;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/im/internal/jni/dependency/FlowHttpNativeResult;", "", "url", "", "header", "status", "", "message", ContainerPosition.BODY, "networkUnavailable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Z)V", "getUrl", "()Ljava/lang/String;", "getHeader", "getStatus", "()J", "getMessage", "getBody", "getNetworkUnavailable", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowHttpNativeResult {
    private final String body;
    private final String header;
    private final String message;
    private final boolean networkUnavailable;
    private final long status;
    private final String url;

    public static /* synthetic */ FlowHttpNativeResult copy$default(FlowHttpNativeResult r100, String r101, String r102, long r103, String r110, String r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.header;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.status;
    L11:
        long r104 = r103;
        if ((r113 & 8) == 0) goto L14;
        r110 = r100.message;
    L14:
        String r105 = r110;
        if ((r113 & 16) == 0) goto L17;
        r111 = r100.body;
    L17:
        String r106 = r111;
        if ((r113 & 32) == 0) goto L20;
        r112 = r100.networkUnavailable;
    L20:
        String r107 = r101;
        return r100.copy(r107, r115, r104, r105, r106, r112);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.header;
    }

    public final long component3() {
        return this.status;
    }

    public final String component4() {
        return this.message;
    }

    public final String component5() {
        return this.body;
    }

    public final boolean component6() {
        return this.networkUnavailable;
    }

    public final FlowHttpNativeResult copy(String r110, String r111, long r112, String r113, String r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r111, "header");
        Intrinsics.checkNotNullParameter(r113, "message");
        Intrinsics.checkNotNullParameter(r114, ContainerPosition.BODY);
        return new FlowHttpNativeResult(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowHttpNativeResult) == true) goto L8;
        return false;
    L8:
        FlowHttpNativeResult r101 = (FlowHttpNativeResult) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L15;
        return false;
    L15:
        if (this.status == r101.status) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.body, r101.body) == true) goto L24;
        return false;
    L24:
        if (this.networkUnavailable == r101.networkUnavailable) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.url.hashCode() * 31) + this.header.hashCode()) * 31;
        long r101 = this.status;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.message.hashCode()) * 31) + this.body.hashCode()) * 31;
        if (this.networkUnavailable == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 + r103;
    L5:
        r103 = 1237;
        goto L7
    }

    public String toString() {
        return "FlowHttpNativeResult(url=" + this.url + ", header=" + this.header + ", status=" + this.status + ", message=" + this.message + ", body=" + this.body + ", networkUnavailable=" + this.networkUnavailable + ')';
    }

    public final String getBody() {
        return this.body;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getNetworkUnavailable() {
        return this.networkUnavailable;
    }

    public final long getStatus() {
        return this.status;
    }

    public final String getUrl() {
        return this.url;
    }

    public FlowHttpNativeResult(String r100, String r101, long r102, String r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "header");
        Intrinsics.checkNotNullParameter(r103, "message");
        Intrinsics.checkNotNullParameter(r104, ContainerPosition.BODY);
        this.url = r100;
        this.header = r101;
        this.status = r102;
        this.message = r103;
        this.body = r104;
        this.networkUnavailable = r105;
    }
}
