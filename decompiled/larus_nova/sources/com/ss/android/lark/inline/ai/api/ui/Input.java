package com.ss.android.lark.inline.ai.api.ui;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001EBu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u00104\u001a\u00020\u0007H\u0016J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010=\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J~\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016¨\u0006F"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Input;", "Ljava/io/Serializable;", "show", "", "status", "", "text", "", GXTemplateKey.GAIAX_PLACEHOLDER, "textContentList", "Lcom/ss/android/lark/inline/ai/api/ui/TextContentList;", "writingText", "showStopBtn", "showKeyboard", "recentPrompt", "Lcom/ss/android/lark/inline/ai/api/ui/Prompt;", "placehoderSelected", "<init>", "(ZILjava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/inline/ai/api/ui/TextContentList;Ljava/lang/String;ZLjava/lang/Boolean;Lcom/ss/android/lark/inline/ai/api/ui/Prompt;Z)V", "getShow", "()Z", "setShow", "(Z)V", "getStatus", "()I", "setStatus", "(I)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getPlaceholder", "setPlaceholder", "getTextContentList", "()Lcom/ss/android/lark/inline/ai/api/ui/TextContentList;", "setTextContentList", "(Lcom/ss/android/lark/inline/ai/api/ui/TextContentList;)V", "getWritingText", "setWritingText", "getShowStopBtn", "setShowStopBtn", "getShowKeyboard", "()Ljava/lang/Boolean;", "setShowKeyboard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRecentPrompt", "()Lcom/ss/android/lark/inline/ai/api/ui/Prompt;", "setRecentPrompt", "(Lcom/ss/android/lark/inline/ai/api/ui/Prompt;)V", "getPlacehoderSelected", "setPlacehoderSelected", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ZILjava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/inline/ai/api/ui/TextContentList;Ljava/lang/String;ZLjava/lang/Boolean;Lcom/ss/android/lark/inline/ai/api/ui/Prompt;Z)Lcom/ss/android/lark/inline/ai/api/ui/Input;", "equals", "other", "", "hashCode", "Status", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Input implements Serializable {
    private boolean placehoderSelected;
    private String placeholder;
    private Prompt recentPrompt;
    private boolean show;
    private Boolean showKeyboard;
    private boolean showStopBtn;
    private int status;
    private String text;
    private TextContentList textContentList;
    private String writingText;

    public static /* synthetic */ Input copy$default(Input r110, boolean r111, int r112, String r113, String r114, TextContentList r115, String r116, boolean r117, Boolean r118, Prompt r210, boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        boolean r100 = r110.show;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = r110.status;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.text;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.placeholder;
    L19:
        if ((r212 & 16) == 0) goto L21;
        TextContentList r104 = r110.textContentList;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.writingText;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r106 = r110.showStopBtn;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Boolean r107 = r110.showKeyboard;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Prompt r119 = r110.recentPrompt;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r108 = r110.placehoderSelected;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.show;
    }

    public final boolean component10() {
        return this.placehoderSelected;
    }

    public final int component2() {
        return this.status;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.placeholder;
    }

    public final TextContentList component5() {
        return this.textContentList;
    }

    public final String component6() {
        return this.writingText;
    }

    public final boolean component7() {
        return this.showStopBtn;
    }

    public final Boolean component8() {
        return this.showKeyboard;
    }

    public final Prompt component9() {
        return this.recentPrompt;
    }

    public final Input copy(boolean r110, int r111, String r112, String r113, TextContentList r114, String r115, boolean r116, Boolean r210, Prompt r211, boolean r212) {
        return new Input(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Input) == true) goto L8;
        return false;
    L8:
        Input r101 = (Input) r100;
        if (this.show == r101.show) goto L12;
        return false;
    L12:
        if (this.status == r101.status) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.placeholder, r101.placeholder) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.textContentList, r101.textContentList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.writingText, r101.writingText) == true) goto L27;
        return false;
    L27:
        if (this.showStopBtn == r101.showStopBtn) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.showKeyboard, r101.showKeyboard) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.recentPrompt, r101.recentPrompt) == true) goto L36;
        return false;
    L36:
        if (this.placehoderSelected == r101.placehoderSelected) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.show == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.status) * 31;
        String r103 = this.text;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.placeholder;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        TextContentList r110 = this.textContentList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.writingText;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.showStopBtn == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        Boolean r118 = this.showKeyboard;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        Prompt r121 = this.recentPrompt;
        if (r121 == null) goto L34;
        r104 = r121.hashCode();
    L34:
        int r122 = (r120 + r104) * 31;
        if (this.placehoderSelected == true) goto L39;
        r100 = 1237;
    L39:
        return r122 + r100;
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = 1237;
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
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Input(show=");
        r100.append(this.show);
        r100.append(", status=");
        r100.append(this.status);
        r100.append(", text.length=");
        String r101 = this.text;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.length());
    L6:
        r100.append(r102);
        r100.append(", placeholder=");
        r100.append(this.placeholder);
        r100.append(", writingText=");
        r100.append(this.writingText);
        r100.append(", showStopBtn=");
        r100.append(this.showStopBtn);
        r100.append(", showKeyboard=");
        r100.append(this.showKeyboard);
        r100.append(", textContentList=");
        r100.append(this.textContentList);
        r100.append(", recentPrompt=");
        r100.append(this.recentPrompt);
        r100.append(", placehoderSelected=");
        r100.append(this.placehoderSelected);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final boolean getPlacehoderSelected() {
        return this.placehoderSelected;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final Prompt getRecentPrompt() {
        return this.recentPrompt;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final Boolean getShowKeyboard() {
        return this.showKeyboard;
    }

    public final boolean getShowStopBtn() {
        return this.showStopBtn;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getText() {
        return this.text;
    }

    public final TextContentList getTextContentList() {
        return this.textContentList;
    }

    public final String getWritingText() {
        return this.writingText;
    }

    public final void setPlacehoderSelected(boolean r100) {
        this.placehoderSelected = r100;
    }

    public final void setPlaceholder(String r100) {
        this.placeholder = r100;
    }

    public final void setRecentPrompt(Prompt r100) {
        this.recentPrompt = r100;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }

    public final void setShowKeyboard(Boolean r100) {
        this.showKeyboard = r100;
    }

    public final void setShowStopBtn(boolean r100) {
        this.showStopBtn = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextContentList(TextContentList r100) {
        this.textContentList = r100;
    }

    public final void setWritingText(String r100) {
        this.writingText = r100;
    }

    public Input(boolean r100, int r101, String r102, String r103, TextContentList r104, String r105, boolean r106, Boolean r107, Prompt r108, boolean r110) {
        this.show = r100;
        this.status = r101;
        this.text = r102;
        this.placeholder = r103;
        this.textContentList = r104;
        this.writingText = r105;
        this.showStopBtn = r106;
        this.showKeyboard = r107;
        this.recentPrompt = r108;
        this.placehoderSelected = r110;
    }

    public /* synthetic */ Input(boolean r110, int r111, String r112, String r113, TextContentList r114, String r115, boolean r116, Boolean r117, Prompt r210, boolean r211, int r212, DefaultConstructorMarker r213) {
        boolean r100 = false;
        if ((r212 & 2) == 0) goto L5;
        int r101 = 0;
    L6:
        Prompt r102 = null;
        if ((r212 & 4) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r212 & 8) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r212 & 16) == 0) goto L17;
        TextContentList r105 = null;
    L19:
        if ((r212 & 32) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r212 & 64) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r212 & 128) == 0) goto L29;
        Boolean r108 = null;
    L31:
        if ((r212 & 256) != 0) goto L35;
        r102 = r210;
    L35:
        if ((r212 & 512) != 0) goto L38;
        r100 = r211;
    L38:
        this(r110, r101, r103, r104, r105, r106, r107, r108, r102, r100);
        return;
    L29:
        r108 = r117;
        goto L31
    L25:
        r107 = r116;
        goto L27
    L21:
        r106 = r115;
        goto L23
    L17:
        r105 = r114;
        goto L19
    L13:
        r104 = r113;
        goto L15
    L9:
        r103 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L6
    }
}
