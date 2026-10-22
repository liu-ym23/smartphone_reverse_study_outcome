package tx9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006&"}, d2 = {"Lcom/larus/trace/CancelCreation;", "Lcom/larus/trace/MobEvent;", "mobKey", "", "previousPage", "currentPage", "success", "creationId", "type", "publicStatus", "recommendFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMobKey", "()Ljava/lang/String;", "getPreviousPage", "getCurrentPage", "getSuccess", "getCreationId", "getType", "getPublicStatus", "getRecommendFrom", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u implements e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f547890a;

    @SerializedName("creation_id")
    private final String creationId;

    @SerializedName("current_page")
    private final String currentPage;

    @SerializedName("previous_page")
    private final String previousPage;

    @SerializedName("public_status")
    private final String publicStatus;

    @SerializedName("recommend_from")
    private final String recommendFrom;

    @SerializedName("success")
    private final String success;

    @SerializedName("type")
    private final String type;

    public u() {
        this(null, null, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f547890a, r101.f547890a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.currentPage, r101.currentPage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.success, r101.success) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.creationId, r101.creationId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.publicStatus, r101.publicStatus) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.recommendFrom, r101.recommendFrom) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f547890a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.previousPage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.currentPage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.success;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.creationId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.type;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.publicStatus;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.recommendFrom;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "CancelCreation(mobKey=" + this.f547890a + ", previousPage=" + this.previousPage + ", currentPage=" + this.currentPage + ", success=" + this.success + ", creationId=" + this.creationId + ", type=" + this.type + ", publicStatus=" + this.publicStatus + ", recommendFrom=" + this.recommendFrom + ')';
    }

    @Override // tx9.e2
    public final String a() {
        return this.f547890a;
    }

    public final String getType() {
        return this.type;
    }

    @Override // tx9.e2
    public final void b(by7.e r100, JSONObject r101) {
        e2.a.a(this, r100, r101);
    }

    public u(String r100, String r101, String r102, String r103, String r104, String r105, String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        String r106 = "cancel_creation";
    L7:
        if ((r111 & 2) == 0) goto L10;
        r100 = "";
    L10:
        if ((r111 & 4) == 0) goto L13;
        r101 = "";
    L13:
        if ((r111 & 8) == 0) goto L16;
        r102 = "";
    L16:
        if ((r111 & 16) == 0) goto L19;
        r103 = "";
    L19:
        if ((r111 & 32) == 0) goto L22;
        r104 = "";
    L22:
        if ((r111 & 64) == 0) goto L25;
        r105 = "";
    L25:
        if ((r111 & 128) == 0) goto L27;
        r110 = "";
    L27:
        this.f547890a = r106;
        this.previousPage = r100;
        this.currentPage = r101;
        this.success = r102;
        this.creationId = r103;
        this.type = r104;
        this.publicStatus = r105;
        this.recommendFrom = r110;
        return;
    L5:
        r106 = null;
        goto L7
    }
}
