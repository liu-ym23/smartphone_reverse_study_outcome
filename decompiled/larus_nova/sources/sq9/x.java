package sq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003JW\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\rHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/larus/platform/model/creation/InstructionDTO;", "", "itemId", "", "actionBarKey", "", "name", "icon", "Lcom/larus/platform/model/creation/Icon;", "darkModeIcon", "hidden", "", "instructionType", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/creation/Icon;Lcom/larus/platform/model/creation/Icon;ZI)V", "getItemId", "()J", "getActionBarKey", "()Ljava/lang/String;", "getName", "getIcon", "()Lcom/larus/platform/model/creation/Icon;", "getDarkModeIcon", "getHidden", "()Z", "getInstructionType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class x {

    @SerializedName("action_bar_key")
    private final String actionBarKey;

    @SerializedName("dark_mode_icon")
    private final v darkModeIcon;

    @SerializedName("hidden")
    private final boolean hidden;

    @SerializedName("icon")
    private final v icon;

    @SerializedName("instruction_type")
    private final int instructionType;

    @SerializedName("item_id")
    private final long itemId;

    @SerializedName("name")
    private final String name;

    public x() {
        this(0, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.itemId == r101.itemId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionBarKey, r101.actionBarKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.darkModeIcon, r101.darkModeIcon) == true) goto L24;
        return false;
    L24:
        if (this.hidden == r101.hidden) goto L27;
        return false;
    L27:
        if (this.instructionType == r101.instructionType) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r100 = this.itemId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.actionBarKey;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.name;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        v r109 = this.icon;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        v r112 = this.darkModeIcon;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        int r113 = (r111 + r103) * 31;
        if (this.hidden == false) goto L21;
        int r114 = 1231;
    L23:
        return ((r113 + r114) * 31) + this.instructionType;
    L21:
        r114 = 1237;
        goto L23
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "InstructionDTO(itemId=" + this.itemId + ", actionBarKey=" + this.actionBarKey + ", name=" + this.name + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", hidden=" + this.hidden + ", instructionType=" + this.instructionType + ')';
    }

    public final v a() {
        return this.icon;
    }

    public final int b() {
        return this.instructionType;
    }

    public final String c() {
        return this.name;
    }

    public x(int r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        long r102 = -1;
    L6:
        String r103 = "";
        if ((r101 & 2) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r101 & 4) != 0) goto L15;
        r103 = null;
    L15:
        if ((r101 & 64) == 0) goto L17;
        r100 = 0;
    L17:
        this.itemId = r102;
        this.actionBarKey = r104;
        this.name = r103;
        this.icon = null;
        this.darkModeIcon = null;
        this.hidden = false;
        this.instructionType = r100;
        return;
    L9:
        r104 = null;
        goto L11
    L5:
        r102 = 0;
        goto L6
    }
}
