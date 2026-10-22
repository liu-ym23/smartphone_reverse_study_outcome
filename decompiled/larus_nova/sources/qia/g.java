package qia;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JU\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006$"}, d2 = {"Lcom/obric/audio/enroll/model/EnrollTeam;", "", "index", "", "title", "", "query", "subtitleContent", "subtitleLines", "subtitleSmall", "", "textSimilarity", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZI)V", "getIndex", "()I", "getTitle", "()Ljava/lang/String;", "getQuery", "getSubtitleContent", "getSubtitleLines", "getSubtitleSmall", "()Z", "getTextSimilarity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("index")
    private final int index;

    @SerializedName("query")
    private final String query;

    @SerializedName("subtitle_content")
    private final String subtitleContent;

    @SerializedName("subtitle_lines")
    private final int subtitleLines;

    @SerializedName("subtitle_small")
    private final boolean subtitleSmall;

    @SerializedName("text_similarity")
    private final int textSimilarity;

    @SerializedName("title")
    private final String title;

    public g() {
        this(0, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.index == r101.index) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subtitleContent, r101.subtitleContent) == true) goto L21;
        return false;
    L21:
        if (this.subtitleLines == r101.subtitleLines) goto L24;
        return false;
    L24:
        if (this.subtitleSmall == r101.subtitleSmall) goto L27;
        return false;
    L27:
        if (this.textSimilarity == r101.textSimilarity) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.index * 31;
        String r101 = this.title;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.query;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.subtitleContent;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (((r107 + r102) * 31) + this.subtitleLines) * 31;
        if (this.subtitleSmall == false) goto L17;
        int r110 = 1231;
    L19:
        return ((r109 + r110) * 31) + this.textSimilarity;
    L17:
        r110 = 1237;
        goto L19
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "EnrollTeam(index=" + this.index + ", title=" + this.title + ", query=" + this.query + ", subtitleContent=" + this.subtitleContent + ", subtitleLines=" + this.subtitleLines + ", subtitleSmall=" + this.subtitleSmall + ", textSimilarity=" + this.textSimilarity + ')';
    }

    public final int a() {
        return this.index;
    }

    public final String b() {
        return this.query;
    }

    public final String c() {
        return this.subtitleContent;
    }

    public final int d() {
        return this.subtitleLines;
    }

    public final int e() {
        return this.textSimilarity;
    }

    public final String f() {
        return this.title;
    }

    public g(int r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r101 & 16) == 0) goto L8;
        int r102 = 1;
    L9:
        this.index = r100;
        this.title = null;
        this.query = null;
        this.subtitleContent = null;
        this.subtitleLines = r102;
        this.subtitleSmall = false;
        this.textSimilarity = 0;
        return;
    L8:
        r102 = 0;
        goto L9
    }
}
