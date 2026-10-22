package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0006\u00100\u001a\u00020\nJ\u0013\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\nHÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001J\u0016\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u0006<"}, d2 = {"Lcom/larus/bmhome/auth/CreationConfig;", "Landroid/os/Parcelable;", "enableAddCreation", "", "showCreationMine", "showCreationOthers", "showNumberOfUses", "showPromptMineDetails", "autoAddEnable", SoloKtvContext.SOLO_PAGE_ENTRANCE, "", "landingEnable", "redDotEnable", "enableRefactor", "privateDownload", "privatePublish", "creationDownload", "<init>", "(ZZZZZZIZZZZZZ)V", "getEnableAddCreation", "()Z", "getShowCreationMine", "getShowCreationOthers", "getShowNumberOfUses", "getShowPromptMineDetails", "getAutoAddEnable", "getEntrance", "()I", "getLandingEnable", "getRedDotEnable", "getEnableRefactor", "getPrivateDownload", "getPrivatePublish", "getCreationDownload", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationConfig implements Parcelable {
    public static final Parcelable.Creator<CreationConfig> CREATOR = null;

    @SerializedName("auto_add_creation")
    private final boolean autoAddEnable;

    @SerializedName("creation_tab_download_button_exposed")
    private final boolean creationDownload;

    @SerializedName("enable_add_creation")
    private final boolean enableAddCreation;

    @SerializedName("enable_profile_private_tab_refactor")
    private final boolean enableRefactor;

    @SerializedName("show_creation_entrance")
    private final int entrance;

    @SerializedName("creation_tab_landing")
    private final boolean landingEnable;

    @SerializedName("private_tab_download_button_exposed")
    private final boolean privateDownload;

    @SerializedName("private_tab_publish_button_exposed")
    private final boolean privatePublish;

    @SerializedName("show_red_dot")
    private final boolean redDotEnable;

    @SerializedName("show_creation_mine")
    private final boolean showCreationMine;

    @SerializedName("show_creation_others")
    private final boolean showCreationOthers;

    @SerializedName("show_number_of_uses")
    private final boolean showNumberOfUses;

    @SerializedName("show_prompt_mine_details")
    private final boolean showPromptMineDetails;

    public static final class a implements Parcelable.Creator<CreationConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            if (r110.readInt() == 0) goto L5;
            boolean r100 = true;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r101 = true;
        L11:
            if (r110.readInt() == 0) goto L13;
            boolean r102 = true;
        L15:
            if (r110.readInt() == 0) goto L17;
            boolean r103 = true;
        L19:
            if (r110.readInt() == 0) goto L21;
            boolean r104 = true;
        L23:
            if (r110.readInt() == 0) goto L25;
            boolean r105 = true;
        L26:
            int r111 = r110.readInt();
            if (r110.readInt() == 0) goto L29;
            boolean r112 = true;
        L31:
            if (r110.readInt() == 0) goto L33;
            boolean r113 = true;
        L35:
            if (r110.readInt() == 0) goto L37;
            boolean r114 = true;
        L39:
            if (r110.readInt() == 0) goto L41;
            boolean r115 = true;
        L43:
            if (r110.readInt() == 0) goto L45;
            boolean r116 = true;
        L47:
            if (r110.readInt() == 0) goto L49;
            boolean r117 = true;
        L51:
            return new CreationConfig(r100, r101, r102, r103, r104, r105, r111, r112, r113, r114, r115, r116, r117);
        L49:
            r117 = false;
            goto L51
        L45:
            r116 = false;
            goto L47
        L41:
            r115 = false;
            goto L43
        L37:
            r114 = false;
            goto L39
        L33:
            r113 = false;
            goto L35
        L29:
            r112 = false;
            goto L31
        L25:
            r105 = false;
            goto L26
        L21:
            r104 = false;
            goto L23
        L17:
            r103 = false;
            goto L19
        L13:
            r102 = false;
            goto L15
        L9:
            r101 = false;
            goto L11
        L5:
            r100 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CreationConfig[] newArray(int r100) {
            return new CreationConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public CreationConfig() {
        this(false, false, false, false, false, false, 1, false, false, false, false, false, false);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationConfig) == true) goto L8;
        return false;
    L8:
        CreationConfig r101 = (CreationConfig) r100;
        if (this.enableAddCreation == r101.enableAddCreation) goto L12;
        return false;
    L12:
        if (this.showCreationMine == r101.showCreationMine) goto L15;
        return false;
    L15:
        if (this.showCreationOthers == r101.showCreationOthers) goto L18;
        return false;
    L18:
        if (this.showNumberOfUses == r101.showNumberOfUses) goto L21;
        return false;
    L21:
        if (this.showPromptMineDetails == r101.showPromptMineDetails) goto L24;
        return false;
    L24:
        if (this.autoAddEnable == r101.autoAddEnable) goto L27;
        return false;
    L27:
        if (this.entrance == r101.entrance) goto L30;
        return false;
    L30:
        if (this.landingEnable == r101.landingEnable) goto L33;
        return false;
    L33:
        if (this.redDotEnable == r101.redDotEnable) goto L36;
        return false;
    L36:
        if (this.enableRefactor == r101.enableRefactor) goto L39;
        return false;
    L39:
        if (this.privateDownload == r101.privateDownload) goto L42;
        return false;
    L42:
        if (this.privatePublish == r101.privatePublish) goto L45;
        return false;
    L45:
        if (this.creationDownload == r101.creationDownload) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableAddCreation == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.showCreationMine == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.showCreationOthers == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.showNumberOfUses == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.showPromptMineDetails == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.autoAddEnable == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (((r110 + r111) * 31) + this.entrance) * 31;
        if (this.landingEnable == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.redDotEnable == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (r114 + r115) * 31;
        if (this.enableRefactor == false) goto L37;
        int r117 = 1231;
    L38:
        int r118 = (r116 + r117) * 31;
        if (this.privateDownload == false) goto L41;
        int r119 = 1231;
    L42:
        int r120 = (r118 + r119) * 31;
        if (this.privatePublish == false) goto L45;
        int r121 = 1231;
    L46:
        int r122 = (r120 + r121) * 31;
        if (this.creationDownload == true) goto L51;
        r100 = 1237;
    L51:
        return r122 + r100;
    L45:
        r121 = 1237;
        goto L46
    L41:
        r119 = 1237;
        goto L42
    L37:
        r117 = 1237;
        goto L38
    L33:
        r115 = 1237;
        goto L34
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreationConfig(enableAddCreation=" + this.enableAddCreation + ", showCreationMine=" + this.showCreationMine + ", showCreationOthers=" + this.showCreationOthers + ", showNumberOfUses=" + this.showNumberOfUses + ", showPromptMineDetails=" + this.showPromptMineDetails + ", autoAddEnable=" + this.autoAddEnable + ", entrance=" + this.entrance + ", landingEnable=" + this.landingEnable + ", redDotEnable=" + this.redDotEnable + ", enableRefactor=" + this.enableRefactor + ", privateDownload=" + this.privateDownload + ", privatePublish=" + this.privatePublish + ", creationDownload=" + this.creationDownload + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.enableAddCreation ? 1 : 0);
        r100.writeInt(this.showCreationMine ? 1 : 0);
        r100.writeInt(this.showCreationOthers ? 1 : 0);
        r100.writeInt(this.showNumberOfUses ? 1 : 0);
        r100.writeInt(this.showPromptMineDetails ? 1 : 0);
        r100.writeInt(this.autoAddEnable ? 1 : 0);
        r100.writeInt(this.entrance);
        r100.writeInt(this.landingEnable ? 1 : 0);
        r100.writeInt(this.redDotEnable ? 1 : 0);
        r100.writeInt(this.enableRefactor ? 1 : 0);
        r100.writeInt(this.privateDownload ? 1 : 0);
        r100.writeInt(this.privatePublish ? 1 : 0);
        r100.writeInt(this.creationDownload ? 1 : 0);
    }

    public final boolean a() {
        return this.creationDownload;
    }

    public final boolean b() {
        return this.enableAddCreation;
    }

    public final boolean c() {
        return this.enableRefactor;
    }

    public final int d() {
        return this.entrance;
    }

    public final boolean e() {
        return this.landingEnable;
    }

    public final boolean g() {
        return this.redDotEnable;
    }

    public final boolean h() {
        return this.showCreationMine;
    }

    public final boolean i() {
        return this.showCreationOthers;
    }

    public CreationConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, int r106, boolean r107, boolean r108, boolean r110, boolean r111, boolean r112, boolean r113) {
        this.enableAddCreation = r100;
        this.showCreationMine = r101;
        this.showCreationOthers = r102;
        this.showNumberOfUses = r103;
        this.showPromptMineDetails = r104;
        this.autoAddEnable = r105;
        this.entrance = r106;
        this.landingEnable = r107;
        this.redDotEnable = r108;
        this.enableRefactor = r110;
        this.privateDownload = r111;
        this.privatePublish = r112;
        this.creationDownload = r113;
    }
}
