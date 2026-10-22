package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lt06/w;", "Lt06/a;", "", "", "enableSceneList", "Ljava/util/List;", "b", "()Ljava/util/List;", "blockPageUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "warningPageUrl", "d", "reportUrl", "getReportUrl", "", "maxContentSize", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class w extends a {

    @SerializedName("block_page_url")
    private final String blockPageUrl;

    @SerializedName("enable_scene")
    private final List<String> enableSceneList;

    @SerializedName("max_content_size")
    private final Integer maxContentSize;

    @SerializedName("report_url")
    private final String reportUrl;

    @SerializedName("warn_page_url")
    private final String warningPageUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.enableSceneList, r101.enableSceneList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockPageUrl, r101.blockPageUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.warningPageUrl, r101.warningPageUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reportUrl, r101.reportUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.maxContentSize, r101.maxContentSize) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.enableSceneList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.blockPageUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.warningPageUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.reportUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.maxContentSize;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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

    public final String toString() {
        return "WebContentVerifyStrategyConfig(enableSceneList=" + this.enableSceneList + ", blockPageUrl=" + this.blockPageUrl + ", warningPageUrl=" + this.warningPageUrl + ", reportUrl=" + this.reportUrl + ", maxContentSize=" + this.maxContentSize + ')';
    }

    public w() {
        this.enableSceneList = null;
        this.blockPageUrl = null;
        this.warningPageUrl = null;
        this.reportUrl = null;
        this.maxContentSize = null;
    }

    public final String a() {
        return this.blockPageUrl;
    }

    public final List<String> b() {
        return this.enableSceneList;
    }

    public final Integer c() {
        return this.maxContentSize;
    }

    public final String d() {
        return this.warningPageUrl;
    }
}
