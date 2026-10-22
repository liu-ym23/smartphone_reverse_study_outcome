package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/model/ExportFileConfig;", "", "enableMenuExportFile", "", "enableMenuExportToDoc", "enableMenuCreateDoc", "enableShareExportFile", "exportMsgLimit", "", "<init>", "(ZZZZI)V", "getEnableMenuExportFile", "()Z", "getEnableMenuExportToDoc", "getEnableMenuCreateDoc", "getEnableShareExportFile", "getExportMsgLimit", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExportFileConfig {

    @SerializedName("enable_menu_create_doc")
    private final boolean enableMenuCreateDoc;

    @SerializedName("enable_menu_export_file")
    private final boolean enableMenuExportFile;

    @SerializedName("enable_menu_export_to_doc")
    private final boolean enableMenuExportToDoc;

    @SerializedName("enable_share_export_file")
    private final boolean enableShareExportFile;

    @SerializedName("export_msg_limit")
    private final int exportMsgLimit;

    public ExportFileConfig() {
        this(false, false, false, false, 0, 31, null);
    }

    public static /* synthetic */ ExportFileConfig copy$default(ExportFileConfig r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.enableMenuExportFile;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.enableMenuExportToDoc;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.enableMenuCreateDoc;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.enableShareExportFile;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.exportMsgLimit;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.enableMenuExportFile;
    }

    public final boolean component2() {
        return this.enableMenuExportToDoc;
    }

    public final boolean component3() {
        return this.enableMenuCreateDoc;
    }

    public final boolean component4() {
        return this.enableShareExportFile;
    }

    public final int component5() {
        return this.exportMsgLimit;
    }

    public final ExportFileConfig copy(boolean r100, boolean r101, boolean r110, boolean r111, int r112) {
        return new ExportFileConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ExportFileConfig) == true) goto L8;
        return false;
    L8:
        ExportFileConfig r101 = (ExportFileConfig) r100;
        if (this.enableMenuExportFile == r101.enableMenuExportFile) goto L12;
        return false;
    L12:
        if (this.enableMenuExportToDoc == r101.enableMenuExportToDoc) goto L15;
        return false;
    L15:
        if (this.enableMenuCreateDoc == r101.enableMenuCreateDoc) goto L18;
        return false;
    L18:
        if (this.enableShareExportFile == r101.enableShareExportFile) goto L21;
        return false;
    L21:
        if (this.exportMsgLimit == r101.exportMsgLimit) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableMenuExportFile == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableMenuExportToDoc == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableMenuCreateDoc == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enableShareExportFile == true) goto L19;
        r100 = 1237;
    L19:
        return ((r106 + r100) * 31) + this.exportMsgLimit;
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
        return "ExportFileConfig(enableMenuExportFile=" + this.enableMenuExportFile + ", enableMenuExportToDoc=" + this.enableMenuExportToDoc + ", enableMenuCreateDoc=" + this.enableMenuCreateDoc + ", enableShareExportFile=" + this.enableShareExportFile + ", exportMsgLimit=" + this.exportMsgLimit + ')';
    }

    public final boolean getEnableMenuCreateDoc() {
        return this.enableMenuCreateDoc;
    }

    public final boolean getEnableMenuExportFile() {
        return this.enableMenuExportFile;
    }

    public final boolean getEnableMenuExportToDoc() {
        return this.enableMenuExportToDoc;
    }

    public final boolean getEnableShareExportFile() {
        return this.enableShareExportFile;
    }

    public final int getExportMsgLimit() {
        return this.exportMsgLimit;
    }

    public ExportFileConfig(boolean r100, boolean r101, boolean r102, boolean r103, int r104) {
        this.enableMenuExportFile = r100;
        this.enableMenuExportToDoc = r101;
        this.enableMenuCreateDoc = r102;
        this.enableShareExportFile = r103;
        this.exportMsgLimit = r104;
    }

    public /* synthetic */ ExportFileConfig(boolean r100, boolean r101, boolean r102, boolean r103, int r104, int r105, DefaultConstructorMarker r110) {
        boolean r106 = true;
        if ((r105 & 1) == 0) goto L5;
        boolean r111 = true;
    L7:
        if ((r105 & 2) == 0) goto L9;
        boolean r107 = true;
    L11:
        if ((r105 & 4) == 0) goto L13;
        boolean r108 = true;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        int r109 = 10;
    L22:
        this(r111, r107, r108, r106, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
