package ds;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u0019"}, d2 = {"Lds/b;", "", "", "promoteScene", "Ljava/lang/String;", "getPromoteScene", "()Ljava/lang/String;", "contentId", "getContentId", "enterMethod", "getEnterMethod", "trafficSource", "getTrafficSource", "Lds/d;", "trafficExtra", "Lds/d;", "getTrafficExtra", "()Lds/d;", "Lds/c;", "promoteSceneSub", "Lds/c;", "getPromoteSceneSub", "()Lds/c;", "previousPage", "getPreviousPage", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID)
    private final String contentId;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("previous_page")
    private final String previousPage;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE)
    private final String promoteScene;

    @SerializedName("promote_scene_sub")
    private final c promoteSceneSub;

    @SerializedName("traffic_extra")
    private final d trafficExtra;

    @SerializedName("traffic_source")
    private final String trafficSource;

    public b() {
        this(null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.promoteScene, r101.promoteScene) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.contentId, r101.contentId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.trafficSource, r101.trafficSource) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.trafficExtra, r101.trafficExtra) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.promoteSceneSub, r101.promoteSceneSub) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.promoteScene;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.contentId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.enterMethod;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.trafficSource;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        d r113 = this.trafficExtra;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        c r116 = this.promoteSceneSub;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.previousPage;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentSourceInfo(promoteScene=" + this.promoteScene + ", contentId=" + this.contentId + ", enterMethod=" + this.enterMethod + ", trafficSource=" + this.trafficSource + ", trafficExtra=" + this.trafficExtra + ", promoteSceneSub=" + this.promoteSceneSub + ", previousPage=" + this.previousPage + ")";
    }

    public b(String r100, String r101, String r102, String r103, d r104, c r105, String r106) {
        this.promoteScene = r100;
        this.contentId = r101;
        this.enterMethod = r102;
        this.trafficSource = r103;
        this.trafficExtra = r104;
        this.promoteSceneSub = r105;
        this.previousPage = r106;
    }
}
