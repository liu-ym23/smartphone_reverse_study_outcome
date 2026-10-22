package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/JumpSomewherePocket;", "", "jumpSchemaUrl", "", "jumpInstructionId", "insertPrompt", "selectedModel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJumpSchemaUrl", "()Ljava/lang/String;", "getJumpInstructionId", "getInsertPrompt", "getSelectedModel", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JumpSomewherePocket {

    @SerializedName("insert_prompt")
    private final String insertPrompt;

    @SerializedName("jump_instruction_id")
    private final String jumpInstructionId;

    @SerializedName("jump_schema_url")
    private final String jumpSchemaUrl;

    @SerializedName("selected_model")
    private final String selectedModel;

    public JumpSomewherePocket() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ JumpSomewherePocket copy$default(JumpSomewherePocket r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.jumpSchemaUrl;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.jumpInstructionId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.insertPrompt;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.selectedModel;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.jumpSchemaUrl;
    }

    public final String component2() {
        return this.jumpInstructionId;
    }

    public final String component3() {
        return this.insertPrompt;
    }

    public final String component4() {
        return this.selectedModel;
    }

    public final JumpSomewherePocket copy(String r100, String r101, String r102, String r103) {
        return new JumpSomewherePocket(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JumpSomewherePocket) == true) goto L8;
        return false;
    L8:
        JumpSomewherePocket r101 = (JumpSomewherePocket) r100;
        if (Intrinsics.areEqual(this.jumpSchemaUrl, r101.jumpSchemaUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpInstructionId, r101.jumpInstructionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.insertPrompt, r101.insertPrompt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectedModel, r101.selectedModel) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.jumpSchemaUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.jumpInstructionId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.insertPrompt;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.selectedModel;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public String toString() {
        return "JumpSomewherePocket(jumpSchemaUrl=" + this.jumpSchemaUrl + ", jumpInstructionId=" + this.jumpInstructionId + ", insertPrompt=" + this.insertPrompt + ", selectedModel=" + this.selectedModel + ')';
    }

    public final String getInsertPrompt() {
        return this.insertPrompt;
    }

    public final String getJumpInstructionId() {
        return this.jumpInstructionId;
    }

    public final String getJumpSchemaUrl() {
        return this.jumpSchemaUrl;
    }

    public final String getSelectedModel() {
        return this.selectedModel;
    }

    public JumpSomewherePocket(String r100, String r101, String r102, String r103) {
        this.jumpSchemaUrl = r100;
        this.jumpInstructionId = r101;
        this.insertPrompt = r102;
        this.selectedModel = r103;
    }

    public /* synthetic */ JumpSomewherePocket(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
