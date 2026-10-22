package hq9;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.OfficeAskDoubaoType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\tJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0019Jb\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\rHÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/larus/platform/model/LarkDriveConfigV2;", "", "enableLarkDriveList", "", "moreCreateDocTypes", "", "", "useOfficeIcon", "officeAskDoubao", "Lcom/larus/platform/model/OfficeAskDoubaoType;", "menuConfig", "Lcom/larus/platform/model/LarkDriveMenuConfig;", "tabType", "", "<init>", "(ZLjava/util/List;ZLjava/util/List;Lcom/larus/platform/model/LarkDriveMenuConfig;Ljava/lang/Integer;)V", "getEnableLarkDriveList", "()Z", "getMoreCreateDocTypes", "()Ljava/util/List;", "getUseOfficeIcon", "getOfficeAskDoubao", "getMenuConfig", "()Lcom/larus/platform/model/LarkDriveMenuConfig;", "getTabType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "supportsAskDoubaoType", "type", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/util/List;ZLjava/util/List;Lcom/larus/platform/model/LarkDriveMenuConfig;Ljava/lang/Integer;)Lcom/larus/platform/model/LarkDriveConfigV2;", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d2 {

    @SerializedName("enable_lark_drive_list")
    private final boolean enableLarkDriveList;

    @SerializedName("menu_config")
    private final e2 menuConfig;

    @SerializedName("more_create_doc_types")
    private final List<String> moreCreateDocTypes;

    @SerializedName("office_ask_doubao")
    private final List<OfficeAskDoubaoType> officeAskDoubao;

    @SerializedName("tab_type")
    private final Integer tabType;

    @SerializedName("use_office_icon")
    private final boolean useOfficeIcon;

    public d2() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d2) == true) goto L8;
        return false;
    L8:
        d2 r101 = (d2) r100;
        if (this.enableLarkDriveList == r101.enableLarkDriveList) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.moreCreateDocTypes, r101.moreCreateDocTypes) == true) goto L15;
        return false;
    L15:
        if (this.useOfficeIcon == r101.useOfficeIcon) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.officeAskDoubao, r101.officeAskDoubao) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.menuConfig, r101.menuConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tabType, r101.tabType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableLarkDriveList == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        List<String> r103 = this.moreCreateDocTypes;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        if (this.useOfficeIcon == true) goto L14;
        r100 = 1237;
    L14:
        int r107 = (r106 + r100) * 31;
        List<OfficeAskDoubaoType> r108 = this.officeAskDoubao;
        if (r108 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r107 + r109) * 31;
        e2 r111 = this.menuConfig;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.tabType;
        if (r114 == null) goto L27;
        r104 = r114.hashCode();
    L27:
        return r113 + r104;
    L21:
        r112 = r111.hashCode();
        goto L22
    L17:
        r109 = r108.hashCode();
        goto L18
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LarkDriveConfigV2(enableLarkDriveList=" + this.enableLarkDriveList + ", moreCreateDocTypes=" + this.moreCreateDocTypes + ", useOfficeIcon=" + this.useOfficeIcon + ", officeAskDoubao=" + this.officeAskDoubao + ", menuConfig=" + this.menuConfig + ", tabType=" + this.tabType + ')';
    }

    public final boolean a() {
        return this.enableLarkDriveList;
    }

    public final e2 b() {
        return this.menuConfig;
    }

    public final List<OfficeAskDoubaoType> c() {
        return this.officeAskDoubao;
    }

    public final Integer d() {
        return this.tabType;
    }

    public final boolean e() {
        return this.useOfficeIcon;
    }

    public d2(Object r100) {
        List<String> r101 = CollectionsKt.listOf(new String[]{"doc", "ppt", DocumentType.SHEET_NAME});
        List<OfficeAskDoubaoType> r102 = CollectionsKt.listOf(new OfficeAskDoubaoType[]{OfficeAskDoubaoType.FILE, OfficeAskDoubaoType.DOC, OfficeAskDoubaoType.PPT, OfficeAskDoubaoType.SHEET, OfficeAskDoubaoType.WIKI});
        e2 r103 = new e2(0);
        this.enableLarkDriveList = false;
        this.moreCreateDocTypes = r101;
        this.useOfficeIcon = false;
        this.officeAskDoubao = r102;
        this.menuConfig = r103;
        this.tabType = null;
    }

    public final boolean f(OfficeAskDoubaoType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        List<OfficeAskDoubaoType> r101 = this.officeAskDoubao;
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        return r101.contains(r100);
    }
}
