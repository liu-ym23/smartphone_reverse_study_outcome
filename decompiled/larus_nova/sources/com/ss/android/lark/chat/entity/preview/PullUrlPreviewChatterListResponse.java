package com.ss.android.lark.chat.entity.preview;

import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/PullUrlPreviewChatterListResponse;", "Ljava/io/Serializable;", "chatterInfos", "", "Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo;", "chatterIds", "", "hasMore", "", "nextToken", "<init>", "(Ljava/util/List;Ljava/util/List;ZLjava/lang/String;)V", "getChatterInfos", "()Ljava/util/List;", "getChatterIds", "getHasMore", "()Z", "getNextToken", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PullUrlPreviewChatterListResponse implements Serializable {
    private final List<String> chatterIds;
    private final List<ChatterPreviewChatterInfo> chatterInfos;
    private final boolean hasMore;
    private final String nextToken;

    public PullUrlPreviewChatterListResponse() {
        this(null, null, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PullUrlPreviewChatterListResponse copy$default(PullUrlPreviewChatterListResponse r100, List r101, List r102, boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.chatterInfos;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.chatterIds;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.hasMore;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.nextToken;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<ChatterPreviewChatterInfo> component1() {
        return this.chatterInfos;
    }

    public final List<String> component2() {
        return this.chatterIds;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final String component4() {
        return this.nextToken;
    }

    public final PullUrlPreviewChatterListResponse copy(List<ChatterPreviewChatterInfo> r100, List<String> r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "chatterInfos");
        Intrinsics.checkNotNullParameter(r103, "nextToken");
        return new PullUrlPreviewChatterListResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PullUrlPreviewChatterListResponse) == true) goto L8;
        return false;
    L8:
        PullUrlPreviewChatterListResponse r101 = (PullUrlPreviewChatterListResponse) r100;
        if (Intrinsics.areEqual(this.chatterInfos, r101.chatterInfos) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterIds, r101.chatterIds) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r101.hasMore) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nextToken, r101.nextToken) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.chatterInfos.hashCode() * 31;
        List<String> r101 = this.chatterIds;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.hasMore == false) goto L9;
        int r104 = 1231;
    L11:
        return ((r103 + r104) * 31) + this.nextToken.hashCode();
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PullUrlPreviewChatterListResponse(chatterInfos=" + this.chatterInfos + ", chatterIds=" + this.chatterIds + ", hasMore=" + this.hasMore + ", nextToken=" + this.nextToken + ')';
    }

    public final List<String> getChatterIds() {
        return this.chatterIds;
    }

    public final List<ChatterPreviewChatterInfo> getChatterInfos() {
        return this.chatterInfos;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNextToken() {
        return this.nextToken;
    }

    public PullUrlPreviewChatterListResponse(List<ChatterPreviewChatterInfo> r100, List<String> r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "chatterInfos");
        Intrinsics.checkNotNullParameter(r103, "nextToken");
        this.chatterInfos = r100;
        this.chatterIds = r101;
        this.hasMore = r102;
        this.nextToken = r103;
    }

    public /* synthetic */ PullUrlPreviewChatterListResponse(List r100, List r101, boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
