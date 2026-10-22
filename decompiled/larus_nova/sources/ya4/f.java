package ya4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR(\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0015\u0010\u0004\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lya4/f;", "", "", "startPageUrl", "Ljava/lang/String;", "getStartPageUrl", "()Ljava/lang/String;", "setStartPageUrl", "(Ljava/lang/String;)V", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "appIcon", "getAppIcon", "setAppIcon", "schema", "getSchema", "setSchema", "snapshotPath", "getSnapshotPath", "setSnapshotPath", "cardInfo", "getCardInfo", "setCardInfo", "cardInfo$annotations", "()V", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
public final class f {

    @SerializedName("appIcon")
    private String appIcon;

    @SerializedName("cardInfo")
    private String cardInfo;

    @SerializedName("schema")
    private String schema;

    @SerializedName("snapshotPath")
    private String snapshotPath;

    @SerializedName("startPageUrl")
    private String startPageUrl;

    @SerializedName("title")
    private String title;

    public f() {
        this.startPageUrl = "";
        this.title = "";
        this.appIcon = "";
        this.schema = "";
        this.snapshotPath = "";
        this.cardInfo = "";
    }
}
