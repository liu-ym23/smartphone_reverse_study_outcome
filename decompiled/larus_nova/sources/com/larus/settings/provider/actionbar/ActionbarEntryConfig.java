package com.larus.settings.provider.actionbar;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/larus/settings/provider/actionbar/ActionbarEntryConfig;", "", "abcEntryExpandEnable", "", "abcEntryReorderEnable", "abcEntryRedDotEnable", "abcEntryRedDotToText", "abcEntryRedDotMaxExposureTimes", "", "enableShowInstructionUpdateDialog", "<init>", "(ZZZZIZ)V", "getAbcEntryExpandEnable", "()Z", "getAbcEntryReorderEnable", "getAbcEntryRedDotEnable", "getAbcEntryRedDotToText", "getAbcEntryRedDotMaxExposureTimes", "()I", "getEnableShowInstructionUpdateDialog", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionbarEntryConfig {
    public static final a Companion = null;
    private static final ActionbarEntryConfig config_mainland = null;
    private static final ActionbarEntryConfig config_oversea = null;

    @SerializedName("acb_entry_expand_enable")
    private final boolean abcEntryExpandEnable;

    @SerializedName("acb_entry_red_dot_enable")
    private final boolean abcEntryRedDotEnable;

    @SerializedName("acb_entry_red_dot_max_exposure_times")
    private final int abcEntryRedDotMaxExposureTimes;

    @SerializedName("acb_entry_red_dot_to_text")
    private final boolean abcEntryRedDotToText;

    @SerializedName("acb_entry_reorder_enable")
    private final boolean abcEntryReorderEnable;

    @SerializedName("enable_show_instruction_update_dialog")
    private final boolean enableShowInstructionUpdateDialog;

    public static final class a {
        public a() {
        }
    }

    public ActionbarEntryConfig() {
        this(false, false, false, false, 0, false, 63, null);
    }

    public static /* synthetic */ ActionbarEntryConfig copy$default(ActionbarEntryConfig r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.abcEntryExpandEnable;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.abcEntryReorderEnable;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.abcEntryRedDotEnable;
    L11:
        boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.abcEntryRedDotToText;
    L14:
        boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.abcEntryRedDotMaxExposureTimes;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.enableShowInstructionUpdateDialog;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final boolean component1() {
        return this.abcEntryExpandEnable;
    }

    public final boolean component2() {
        return this.abcEntryReorderEnable;
    }

    public final boolean component3() {
        return this.abcEntryRedDotEnable;
    }

    public final boolean component4() {
        return this.abcEntryRedDotToText;
    }

    public final int component5() {
        return this.abcEntryRedDotMaxExposureTimes;
    }

    public final boolean component6() {
        return this.enableShowInstructionUpdateDialog;
    }

    public final ActionbarEntryConfig copy(boolean r100, boolean r110, boolean r111, boolean r112, int r113, boolean r114) {
        return new ActionbarEntryConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ActionbarEntryConfig) == true) goto L8;
        return false;
    L8:
        ActionbarEntryConfig r101 = (ActionbarEntryConfig) r100;
        if (this.abcEntryExpandEnable == r101.abcEntryExpandEnable) goto L12;
        return false;
    L12:
        if (this.abcEntryReorderEnable == r101.abcEntryReorderEnable) goto L15;
        return false;
    L15:
        if (this.abcEntryRedDotEnable == r101.abcEntryRedDotEnable) goto L18;
        return false;
    L18:
        if (this.abcEntryRedDotToText == r101.abcEntryRedDotToText) goto L21;
        return false;
    L21:
        if (this.abcEntryRedDotMaxExposureTimes == r101.abcEntryRedDotMaxExposureTimes) goto L24;
        return false;
    L24:
        if (this.enableShowInstructionUpdateDialog == r101.enableShowInstructionUpdateDialog) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.abcEntryExpandEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.abcEntryReorderEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.abcEntryRedDotEnable == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.abcEntryRedDotToText == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (((r106 + r107) * 31) + this.abcEntryRedDotMaxExposureTimes) * 31;
        if (this.enableShowInstructionUpdateDialog == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
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

    public String toString() {
        return "ActionbarEntryConfig(abcEntryExpandEnable=" + this.abcEntryExpandEnable + ", abcEntryReorderEnable=" + this.abcEntryReorderEnable + ", abcEntryRedDotEnable=" + this.abcEntryRedDotEnable + ", abcEntryRedDotToText=" + this.abcEntryRedDotToText + ", abcEntryRedDotMaxExposureTimes=" + this.abcEntryRedDotMaxExposureTimes + ", enableShowInstructionUpdateDialog=" + this.enableShowInstructionUpdateDialog + ')';
    }

    static {
        Companion = new a();
        config_mainland = new ActionbarEntryConfig(false, false, true, true, 3, true);
        config_oversea = new ActionbarEntryConfig(false, false, false, false, 0, false, 63, null);
    }

    public static final /* synthetic */ ActionbarEntryConfig access$getConfig_mainland$cp() {
        return config_mainland;
    }

    public static final /* synthetic */ ActionbarEntryConfig access$getConfig_oversea$cp() {
        return config_oversea;
    }

    public final boolean getAbcEntryExpandEnable() {
        return this.abcEntryExpandEnable;
    }

    public final boolean getAbcEntryRedDotEnable() {
        return this.abcEntryRedDotEnable;
    }

    public final int getAbcEntryRedDotMaxExposureTimes() {
        return this.abcEntryRedDotMaxExposureTimes;
    }

    public final boolean getAbcEntryRedDotToText() {
        return this.abcEntryRedDotToText;
    }

    public final boolean getAbcEntryReorderEnable() {
        return this.abcEntryReorderEnable;
    }

    public final boolean getEnableShowInstructionUpdateDialog() {
        return this.enableShowInstructionUpdateDialog;
    }

    public ActionbarEntryConfig(boolean r100, boolean r101, boolean r102, boolean r103, int r104, boolean r105) {
        this.abcEntryExpandEnable = r100;
        this.abcEntryReorderEnable = r101;
        this.abcEntryRedDotEnable = r102;
        this.abcEntryRedDotToText = r103;
        this.abcEntryRedDotMaxExposureTimes = r104;
        this.enableShowInstructionUpdateDialog = r105;
    }

    public /* synthetic */ ActionbarEntryConfig(boolean r100, boolean r101, boolean r102, boolean r103, int r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        boolean r114 = false;
    L7:
        if ((r112 & 2) == 0) goto L9;
        boolean r104 = false;
    L11:
        if ((r112 & 4) == 0) goto L13;
        boolean r105 = false;
    L15:
        if ((r112 & 8) == 0) goto L17;
        boolean r106 = false;
    L19:
        if ((r112 & 16) == 0) goto L21;
        int r107 = 3;
    L23:
        if ((r112 & 32) == 0) goto L25;
        boolean r115 = false;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
