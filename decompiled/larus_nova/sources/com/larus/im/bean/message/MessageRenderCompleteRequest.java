package com.larus.im.bean.message;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/im/bean/message/MessageRenderCompleteRequest;", "", "renderToken", "", "renderCompleteTimestamp", "", PromotionProductPrivilegesStruct.TAGS, "", "<init>", "(Ljava/lang/String;JLjava/util/Map;)V", "getRenderToken", "()Ljava/lang/String;", "getRenderCompleteTimestamp", "()J", "getTags", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageRenderCompleteRequest {
    private final long renderCompleteTimestamp;
    private final String renderToken;
    private final Map<String, String> tags;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageRenderCompleteRequest copy$default(MessageRenderCompleteRequest r100, String r101, long r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.renderToken;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.renderCompleteTimestamp;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.tags;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.renderToken;
    }

    public final long component2() {
        return this.renderCompleteTimestamp;
    }

    public final Map<String, String> component3() {
        return this.tags;
    }

    public final MessageRenderCompleteRequest copy(String r100, long r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "renderToken");
        Intrinsics.checkNotNullParameter(r102, PromotionProductPrivilegesStruct.TAGS);
        return new MessageRenderCompleteRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageRenderCompleteRequest) == true) goto L8;
        return false;
    L8:
        MessageRenderCompleteRequest r101 = (MessageRenderCompleteRequest) r100;
        if (Intrinsics.areEqual(this.renderToken, r101.renderToken) == true) goto L12;
        return false;
    L12:
        if (this.renderCompleteTimestamp == r101.renderCompleteTimestamp) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.renderToken.hashCode() * 31;
        long r101 = this.renderCompleteTimestamp;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.tags.hashCode();
    }

    public String toString() {
        return "MessageRenderCompleteRequest(renderToken=" + this.renderToken + ", renderCompleteTimestamp=" + this.renderCompleteTimestamp + ", tags=" + this.tags + ')';
    }

    public final long getRenderCompleteTimestamp() {
        return this.renderCompleteTimestamp;
    }

    public final String getRenderToken() {
        return this.renderToken;
    }

    public final Map<String, String> getTags() {
        return this.tags;
    }

    public MessageRenderCompleteRequest(String r100, long r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "renderToken");
        Intrinsics.checkNotNullParameter(r102, PromotionProductPrivilegesStruct.TAGS);
        this.renderToken = r100;
        this.renderCompleteTimestamp = r101;
        this.tags = r102;
    }

    public /* synthetic */ MessageRenderCompleteRequest(String r100, long r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        this(r100, r101, r102);
    }
}
