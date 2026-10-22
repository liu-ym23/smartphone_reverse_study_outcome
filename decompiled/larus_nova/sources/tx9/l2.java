package tx9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006("}, d2 = {"Lcom/larus/trace/MyInfoTabElementShow;", "Lcom/larus/trace/MobEvent;", "mobKey", "", "tabName", "currentPage", "position", "type", "creationId", "isTemplate", "publicStatus", "templateSubtype", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMobKey", "()Ljava/lang/String;", "getTabName", "getCurrentPage", "getPosition", "getType", "getCreationId", "getPublicStatus", "getTemplateSubtype", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l2 implements e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f547882a;

    @SerializedName("creation_id")
    private final String creationId;

    @SerializedName("current_page")
    private final String currentPage;

    @SerializedName("is_template")
    private final String isTemplate;

    @SerializedName("position")
    private final String position;

    @SerializedName("public_status")
    private final String publicStatus;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME)
    private final String tabName;

    @SerializedName("template_sub_type")
    private final String templateSubtype;

    @SerializedName("type")
    private final String type;

    public l2() {
        this(null, null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l2) == true) goto L8;
        return false;
    L8:
        l2 r101 = (l2) r100;
        if (Intrinsics.areEqual(this.f547882a, r101.f547882a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.currentPage, r101.currentPage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.creationId, r101.creationId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isTemplate, r101.isTemplate) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.publicStatus, r101.publicStatus) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.templateSubtype, r101.templateSubtype) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f547882a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tabName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.currentPage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.position;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.type;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.creationId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.isTemplate;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.publicStatus;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.templateSubtype;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
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
        return "MyInfoTabElementShow(mobKey=" + this.f547882a + ", tabName=" + this.tabName + ", currentPage=" + this.currentPage + ", position=" + this.position + ", type=" + this.type + ", creationId=" + this.creationId + ", isTemplate=" + this.isTemplate + ", publicStatus=" + this.publicStatus + ", templateSubtype=" + this.templateSubtype + ')';
    }

    @Override // tx9.e2
    public final String a() {
        return this.f547882a;
    }

    public final String getType() {
        return this.type;
    }

    @Override // tx9.e2
    public final void b(by7.e r100, JSONObject r101) {
        e2.a.a(this, r100, r101);
    }

    public l2(String r100, String r101, String r102, String r103, String r104, String r105, String r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        String r106 = "my_info_tab_element_show";
    L7:
        if ((r112 & 2) == 0) goto L10;
        r100 = "";
    L10:
        if ((r112 & 4) == 0) goto L13;
        r101 = "";
    L13:
        if ((r112 & 8) == 0) goto L16;
        r102 = "";
    L16:
        if ((r112 & 16) == 0) goto L19;
        r103 = "";
    L19:
        if ((r112 & 32) == 0) goto L22;
        r104 = "";
    L22:
        if ((r112 & 64) == 0) goto L25;
        r105 = "";
    L25:
        if ((r112 & 128) == 0) goto L28;
        r110 = "";
    L28:
        if ((r112 & 256) == 0) goto L30;
        r111 = "";
    L30:
        this.f547882a = r106;
        this.tabName = r100;
        this.currentPage = r101;
        this.position = r102;
        this.type = r103;
        this.creationId = r104;
        this.isTemplate = r105;
        this.publicStatus = r110;
        this.templateSubtype = r111;
        return;
    L5:
        r106 = null;
        goto L7
    }
}
