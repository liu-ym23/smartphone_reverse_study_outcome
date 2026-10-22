package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/KeyboardInputPocket;", "", "inputBoxTitle", "", "inputPlaceholder", "inputPlaceholderPrompt", "inputPlaceholderPromptForModel", "selectedModel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInputBoxTitle", "()Ljava/lang/String;", "getInputPlaceholder", "getInputPlaceholderPrompt", "getInputPlaceholderPromptForModel", "getSelectedModel", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardInputPocket {

    @SerializedName("input_box_title")
    private final String inputBoxTitle;

    @SerializedName("input_placeholder")
    private final String inputPlaceholder;

    @SerializedName("input_placeholder_prompt")
    private final String inputPlaceholderPrompt;

    @SerializedName("input_placeholder_prompt_for_model")
    private final String inputPlaceholderPromptForModel;

    @SerializedName("selected_model")
    private final String selectedModel;

    public KeyboardInputPocket() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ KeyboardInputPocket copy$default(KeyboardInputPocket r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.inputBoxTitle;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.inputPlaceholder;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.inputPlaceholderPrompt;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.inputPlaceholderPromptForModel;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.selectedModel;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.inputBoxTitle;
    }

    public final String component2() {
        return this.inputPlaceholder;
    }

    public final String component3() {
        return this.inputPlaceholderPrompt;
    }

    public final String component4() {
        return this.inputPlaceholderPromptForModel;
    }

    public final String component5() {
        return this.selectedModel;
    }

    public final KeyboardInputPocket copy(String r100, String r101, String r110, String r111, String r112) {
        return new KeyboardInputPocket(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KeyboardInputPocket) == true) goto L8;
        return false;
    L8:
        KeyboardInputPocket r101 = (KeyboardInputPocket) r100;
        if (Intrinsics.areEqual(this.inputBoxTitle, r101.inputBoxTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.inputPlaceholder, r101.inputPlaceholder) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputPlaceholderPrompt, r101.inputPlaceholderPrompt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.inputPlaceholderPromptForModel, r101.inputPlaceholderPromptForModel) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.selectedModel, r101.selectedModel) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.inputBoxTitle;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.inputPlaceholder;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.inputPlaceholderPrompt;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.inputPlaceholderPromptForModel;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.selectedModel;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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

    public String toString() {
        return "KeyboardInputPocket(inputBoxTitle=" + this.inputBoxTitle + ", inputPlaceholder=" + this.inputPlaceholder + ", inputPlaceholderPrompt=" + this.inputPlaceholderPrompt + ", inputPlaceholderPromptForModel=" + this.inputPlaceholderPromptForModel + ", selectedModel=" + this.selectedModel + ')';
    }

    public final String getInputBoxTitle() {
        return this.inputBoxTitle;
    }

    public final String getInputPlaceholder() {
        return this.inputPlaceholder;
    }

    public final String getInputPlaceholderPrompt() {
        return this.inputPlaceholderPrompt;
    }

    public final String getInputPlaceholderPromptForModel() {
        return this.inputPlaceholderPromptForModel;
    }

    public final String getSelectedModel() {
        return this.selectedModel;
    }

    public KeyboardInputPocket(String r100, String r101, String r102, String r103, String r104) {
        this.inputBoxTitle = r100;
        this.inputPlaceholder = r101;
        this.inputPlaceholderPrompt = r102;
        this.inputPlaceholderPromptForModel = r103;
        this.selectedModel = r104;
    }

    public /* synthetic */ KeyboardInputPocket(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r110 & 8) == 0) goto L17;
        r103 = null;
    L17:
        String r107 = r103;
        if ((r110 & 16) == 0) goto L20;
        String r113 = "";
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
