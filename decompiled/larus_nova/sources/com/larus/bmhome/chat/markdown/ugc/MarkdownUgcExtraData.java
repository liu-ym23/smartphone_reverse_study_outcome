package com.larus.bmhome.chat.markdown.ugc;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003JP\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/markdown/ugc/MarkdownUgcExtraData;", "", "videoScene", "", "recommendTitle", "", "query", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reqId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getVideoScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRecommendTitle", "()Ljava/lang/String;", "getQuery", "()Ljava/util/ArrayList;", "getReqId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Lcom/larus/bmhome/chat/markdown/ugc/MarkdownUgcExtraData;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownUgcExtraData {

    @SerializedName("query")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final ArrayList<String> query;

    @SerializedName("recommend_title")
    private final String recommendTitle;

    @SerializedName("text_area_req_id")
    private final String reqId;

    @SerializedName("video_scene")
    private final Integer videoScene;

    public MarkdownUgcExtraData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarkdownUgcExtraData copy$default(MarkdownUgcExtraData r100, Integer r101, String r102, ArrayList r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.videoScene;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.recommendTitle;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.query;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.reqId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.videoScene;
    }

    public final String component2() {
        return this.recommendTitle;
    }

    public final ArrayList<String> component3() {
        return this.query;
    }

    public final String component4() {
        return this.reqId;
    }

    public final MarkdownUgcExtraData copy(Integer r100, String r101, ArrayList<String> r102, String r103) {
        return new MarkdownUgcExtraData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MarkdownUgcExtraData) == true) goto L8;
        return false;
    L8:
        MarkdownUgcExtraData r101 = (MarkdownUgcExtraData) r100;
        if (Intrinsics.areEqual(this.videoScene, r101.videoScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recommendTitle, r101.recommendTitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reqId, r101.reqId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.videoScene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.recommendTitle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<String> r107 = this.query;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.reqId;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public String toString() {
        return "MarkdownUgcExtraData(videoScene=" + this.videoScene + ", recommendTitle=" + this.recommendTitle + ", query=" + this.query + ", reqId=" + this.reqId + ')';
    }

    public final ArrayList<String> getQuery() {
        return this.query;
    }

    public final String getRecommendTitle() {
        return this.recommendTitle;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final Integer getVideoScene() {
        return this.videoScene;
    }

    public MarkdownUgcExtraData(Integer r100, String r101, ArrayList<String> r102, String r103) {
        this.videoScene = r100;
        this.recommendTitle = r101;
        this.query = r102;
        this.reqId = r103;
    }

    public /* synthetic */ MarkdownUgcExtraData(Integer r100, String r101, ArrayList r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = new ArrayList();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
