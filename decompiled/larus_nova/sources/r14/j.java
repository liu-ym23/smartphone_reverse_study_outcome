package r14;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b/\u00100R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\"\u0010,\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000f¨\u00062"}, d2 = {"Lr14/j;", "", "", "aid", "Ljava/lang/String;", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "", "commentCount", "J", "c", "()J", "setCommentCount", "(J)V", "diggCount", "d", "setDiggCount", "downloadCount", "getDownloadCount", "setDownloadCount", "playCount", "getPlayCount", "setPlayCount", "shareCount", "e", "setShareCount", "collectCount", "b", "setCollectCount", "forwardCount", "getForwardCount", "setForwardCount", "", "loseCount", "I", "getLoseCount", "()I", "setLoseCount", "(I)V", "loseCommentCount", "getLoseCommentCount", "setLoseCommentCount", "whatsappShareCount", "getWhatsappShareCount", "setWhatsappShareCount", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class j implements Cloneable {

    @SerializedName("aid")
    private String aid;

    @SerializedName("collect_count")
    private long collectCount;

    @SerializedName("comment_count")
    private long commentCount;

    @SerializedName("digg_count")
    private long diggCount;

    @SerializedName("download_count")
    private long downloadCount;

    @SerializedName("forward_count")
    private long forwardCount;

    @SerializedName("lose_comment_count")
    private int loseCommentCount;

    @SerializedName("lose_count")
    private int loseCount;

    @SerializedName("play_count")
    private long playCount;

    @SerializedName("share_count")
    private long shareCount;

    @SerializedName("whatsapp_share_count")
    private long whatsappShareCount;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.aid, Long.valueOf(this.commentCount), Long.valueOf(this.diggCount), Long.valueOf(this.playCount), Long.valueOf(this.shareCount), Long.valueOf(this.forwardCount), Long.valueOf(this.downloadCount)});
    }

    public final j a() {
        j r100 = new j();
        r100.aid = this.aid;
        r100.commentCount = this.commentCount;
        r100.diggCount = this.diggCount;
        r100.playCount = this.playCount;
        r100.shareCount = this.shareCount;
        r100.forwardCount = this.forwardCount;
        r100.downloadCount = this.downloadCount;
        r100.whatsappShareCount = this.whatsappShareCount;
        return r100;
    }

    public final String toString() {
        return "AwemeStatistics{aid='" + this.aid + "', commentCount=" + this.commentCount + ", diggCount=" + this.diggCount + ", playCount=" + this.playCount + ", shareCount=" + this.shareCount + ", forwardCount=" + this.forwardCount + ", downloadCount=" + this.downloadCount + ", whatsappShareCount=" + this.whatsappShareCount + '}';
    }

    public j() {
        this.collectCount = -1;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public final long b() {
        return this.collectCount;
    }

    public final long c() {
        return this.commentCount;
    }

    public final long d() {
        return this.diggCount;
    }

    public final long e() {
        return this.shareCount;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.commentCount == r101.commentCount) goto L11;
    L25:
        return false;
    L11:
        if (this.diggCount != r101.diggCount) goto L25;
        if (this.playCount != r101.playCount) goto L25;
        if (this.shareCount != r101.shareCount) goto L25;
        if (this.forwardCount != r101.forwardCount) goto L25;
        if (this.downloadCount != r101.downloadCount) goto L25;
        if (this.whatsappShareCount != r101.whatsappShareCount) goto L25;
        if (Intrinsics.areEqual(this.aid, r101.aid) == false) goto L25;
        return true;
    }
}
