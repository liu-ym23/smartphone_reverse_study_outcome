package com.larus.im.bean.conversation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/larus/im/bean/conversation/ForkConversationRequest;", "", "source", "Lcom/larus/im/bean/conversation/ForkSource;", "forkType", "Lcom/larus/im/bean/conversation/ForkType;", "projectId", "", "ext", "", "<init>", "(Lcom/larus/im/bean/conversation/ForkSource;Lcom/larus/im/bean/conversation/ForkType;Ljava/lang/String;Ljava/util/Map;)V", "getSource", "()Lcom/larus/im/bean/conversation/ForkSource;", "getForkType", "()Lcom/larus/im/bean/conversation/ForkType;", "getProjectId", "()Ljava/lang/String;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForkConversationRequest {
    private final Map<String, String> ext;
    private final ForkType forkType;
    private final String projectId;
    private final ForkSource source;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ForkConversationRequest copy$default(ForkConversationRequest r100, ForkSource r101, ForkType r102, String r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.source;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.forkType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.projectId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ext;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final ForkSource component1() {
        return this.source;
    }

    public final ForkType component2() {
        return this.forkType;
    }

    public final String component3() {
        return this.projectId;
    }

    public final Map<String, String> component4() {
        return this.ext;
    }

    public final ForkConversationRequest copy(ForkSource r100, ForkType r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "forkType");
        Intrinsics.checkNotNullParameter(r103, "ext");
        return new ForkConversationRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ForkConversationRequest) == true) goto L8;
        return false;
    L8:
        ForkConversationRequest r101 = (ForkConversationRequest) r100;
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L12;
        return false;
    L12:
        if (this.forkType == r101.forkType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.projectId, r101.projectId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.source.hashCode() * 31) + this.forkType.hashCode()) * 31;
        String r101 = this.projectId;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.ext.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ForkConversationRequest(source=" + this.source + ", forkType=" + this.forkType + ", projectId=" + this.projectId + ", ext=" + this.ext + ')';
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final ForkType getForkType() {
        return this.forkType;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final ForkSource getSource() {
        return this.source;
    }

    public ForkConversationRequest(ForkSource r100, ForkType r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "forkType");
        Intrinsics.checkNotNullParameter(r103, "ext");
        this.source = r100;
        this.forkType = r101;
        this.projectId = r102;
        this.ext = r103;
    }

    public /* synthetic */ ForkConversationRequest(ForkSource r100, ForkType r101, String r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = MapsKt.emptyMap();
    L8:
        this(r100, r101, r102, r103);
    }
}
