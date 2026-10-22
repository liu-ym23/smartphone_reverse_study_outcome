package hu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/larus/settings/provider/creation/UserAddCreationConfig;", "", "enableAddCreation", "", "showCreationMine", "showCreationOthers", "showNumberOfUses", "showPromptMineDetails", "createTabIsFirst", "<init>", "(ZZZZZZ)V", "getEnableAddCreation", "()Z", "getShowCreationMine", "getShowCreationOthers", "getShowNumberOfUses", "getShowPromptMineDetails", "getCreateTabIsFirst", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f487261a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f487262b = null;

    @SerializedName("creation_tab_is_first")
    private final boolean createTabIsFirst;

    @SerializedName("enable_add_creation")
    private final boolean enableAddCreation;

    @SerializedName("show_creation_mine")
    private final boolean showCreationMine;

    @SerializedName("show_creation_others")
    private final boolean showCreationOthers;

    @SerializedName("show_number_of_uses")
    private final boolean showNumberOfUses;

    @SerializedName("show_prompt_mine_details")
    private final boolean showPromptMineDetails;

    public static final class a {
    }

    public z() {
        this(false, false, false, false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
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
        if (this.createTabIsFirst == r101.createTabIsFirst) goto L26;
        return false;
    L26:
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
        if (this.createTabIsFirst == true) goto L27;
        r100 = 1237;
    L27:
        return r110 + r100;
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
        return "UserAddCreationConfig(enableAddCreation=" + this.enableAddCreation + ", showCreationMine=" + this.showCreationMine + ", showCreationOthers=" + this.showCreationOthers + ", showNumberOfUses=" + this.showNumberOfUses + ", showPromptMineDetails=" + this.showPromptMineDetails + ", createTabIsFirst=" + this.createTabIsFirst + ')';
    }

    static {
        f487261a = new z(true, true, true, true, 32);
        f487262b = new z(false, false, false, false, 63);
    }

    public final boolean a() {
        return this.createTabIsFirst;
    }

    public final boolean b() {
        return this.enableAddCreation;
    }

    public final boolean c() {
        return this.showCreationMine;
    }

    public final boolean d() {
        return this.showCreationOthers;
    }

    public z(boolean r100, boolean r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 16) == 0) goto L15;
        r103 = false;
    L15:
        if ((r104 & 32) == 0) goto L17;
        boolean r105 = true;
    L18:
        this.enableAddCreation = r100;
        this.showCreationMine = r101;
        this.showCreationOthers = r102;
        this.showNumberOfUses = false;
        this.showPromptMineDetails = r103;
        this.createTabIsFirst = r105;
        return;
    L17:
        r105 = false;
        goto L18
    }
}
