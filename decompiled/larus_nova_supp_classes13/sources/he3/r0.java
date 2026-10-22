package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lhe3/r0;", "", "Lhe3/k2;", "baseInfo", "Lhe3/k2;", "a", "()Lhe3/k2;", "Lhe3/l2;", "scoreInfo", "Lhe3/l2;", "getScoreInfo", "()Lhe3/l2;", "Lhe3/a;", "bindAuthorInfo", "Lhe3/a;", "getBindAuthorInfo", "()Lhe3/a;", "Lhe3/u0;", "custom", "Lhe3/u0;", "getCustom", "()Lhe3/u0;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r0 {

    @SerializedName("base_info")
    private final k2 baseInfo;

    @SerializedName("bind_author_info")
    private final a bindAuthorInfo;

    @SerializedName("custom")
    private final u0 custom;

    @SerializedName("score_info")
    private final l2 scoreInfo;

    public r0() {
        this(null, 15);
    }

    public final k2 a() {
        return this.baseInfo;
    }

    public r0(k2 r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this.baseInfo = r2;
        this.scoreInfo = null;
        this.bindAuthorInfo = null;
        this.custom = null;
    }
}
