package sq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/platform/model/creation/CreationDetailLayoutConfig;", "", "experimentGroup", "", "layoutDirection", "showPlusButton", "", "albumAttachAppendRawImage", "publishInSharePanel", "toolPresentationBySource", "Lcom/larus/platform/model/creation/ToolPresentationBySource;", "<init>", "(IIZZZLcom/larus/platform/model/creation/ToolPresentationBySource;)V", "getExperimentGroup", "()I", "getLayoutDirection", "getShowPlusButton", "()Z", "getAlbumAttachAppendRawImage", "getPublishInSharePanel", "getToolPresentationBySource", "()Lcom/larus/platform/model/creation/ToolPresentationBySource;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("albumAttachAppendRawImage")
    private final boolean albumAttachAppendRawImage;

    @SerializedName("experimentGroup")
    private final int experimentGroup;

    @SerializedName("layoutDirection")
    private final int layoutDirection;

    @SerializedName("isPublishInSharePanel")
    private final boolean publishInSharePanel;

    @SerializedName("showPlusButton")
    private final boolean showPlusButton;

    @SerializedName("toolPresentationBySource")
    private final z toolPresentationBySource;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.experimentGroup == r101.experimentGroup) goto L12;
        return false;
    L12:
        if (this.layoutDirection == r101.layoutDirection) goto L15;
        return false;
    L15:
        if (this.showPlusButton == r101.showPlusButton) goto L18;
        return false;
    L18:
        if (this.albumAttachAppendRawImage == r101.albumAttachAppendRawImage) goto L21;
        return false;
    L21:
        if (this.publishInSharePanel == r101.publishInSharePanel) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.toolPresentationBySource, r101.toolPresentationBySource) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.experimentGroup * 31) + this.layoutDirection) * 31;
        int r101 = 1231;
        if (this.showPlusButton == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.albumAttachAppendRawImage == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.publishInSharePanel == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (r105 + r101) * 31;
        z r107 = this.toolPresentationBySource;
        if (r107 != null) goto L17;
        int r108 = 0;
    L19:
        return r106 + r108;
    L17:
        r108 = r107.hashCode();
        goto L19
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreationDetailLayoutConfig(experimentGroup=" + this.experimentGroup + ", layoutDirection=" + this.layoutDirection + ", showPlusButton=" + this.showPlusButton + ", albumAttachAppendRawImage=" + this.albumAttachAppendRawImage + ", publishInSharePanel=" + this.publishInSharePanel + ", toolPresentationBySource=" + this.toolPresentationBySource + ')';
    }

    public final boolean b() {
        return this.albumAttachAppendRawImage;
    }

    public final int c() {
        return this.experimentGroup;
    }

    public final int d() {
        return this.layoutDirection;
    }

    public final boolean e() {
        return this.publishInSharePanel;
    }

    public final boolean f() {
        return this.showPlusButton;
    }

    public final z g() {
        return this.toolPresentationBySource;
    }

    public /* synthetic */ e(int r100) {
        this(0, 0, false, false, false, null);
    }

    public static e a(e r100) {
        return new e(0, r100.layoutDirection, r100.showPlusButton, r100.albumAttachAppendRawImage, r100.publishInSharePanel, r100.toolPresentationBySource);
    }

    public e(int r100, int r101, boolean r102, boolean r103, boolean r104, z r105) {
        this.experimentGroup = r100;
        this.layoutDirection = r101;
        this.showPlusButton = r102;
        this.albumAttachAppendRawImage = r103;
        this.publishInSharePanel = r104;
        this.toolPresentationBySource = r105;
    }
}
