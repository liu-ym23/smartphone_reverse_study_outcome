package com.bytedance.ee.bear.document.ai.inlineai.bean;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.ss.android.lark.inline.ai.api.ui.TextContentList;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001EBu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u00104\u001a\u00020\u0007H\u0016J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010=\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J~\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016¨\u0006F"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSInput;", "Ljava/io/Serializable;", "show", "", "status", "", "text", "", "placeholder", "textContentList", "Lcom/ss/android/lark/inline/ai/api/ui/TextContentList;", "writingText", "showStopBtn", "showKeyboard", "recentPrompt", "Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPrompt;", "placehoderSelected", "<init>", "(ZILjava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/inline/ai/api/ui/TextContentList;Ljava/lang/String;ZLjava/lang/Boolean;Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPrompt;Z)V", "getShow", "()Z", "setShow", "(Z)V", "getStatus", "()I", "setStatus", "(I)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getPlaceholder", "setPlaceholder", "getTextContentList", "()Lcom/ss/android/lark/inline/ai/api/ui/TextContentList;", "setTextContentList", "(Lcom/ss/android/lark/inline/ai/api/ui/TextContentList;)V", "getWritingText", "setWritingText", "getShowStopBtn", "setShowStopBtn", "getShowKeyboard", "()Ljava/lang/Boolean;", "setShowKeyboard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRecentPrompt", "()Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPrompt;", "setRecentPrompt", "(Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPrompt;)V", "getPlacehoderSelected", "setPlacehoderSelected", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ZILjava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/inline/ai/api/ui/TextContentList;Ljava/lang/String;ZLjava/lang/Boolean;Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPrompt;Z)Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSInput;", "equals", "other", "", "hashCode", "Status", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSInput implements Serializable {
    private boolean placehoderSelected;
    private String placeholder;
    private JSPrompt recentPrompt;
    private boolean show;
    private Boolean showKeyboard;
    private boolean showStopBtn;
    private int status;
    private String text;
    private TextContentList textContentList;
    private String writingText;

    public static /* synthetic */ JSInput copy$default(JSInput r11, boolean r12, int r13, String r14, String r16, TextContentList r17, String r18, boolean r19, Boolean r110, JSPrompt r20, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        boolean r2 = r11.show;
    L7:
        if ((r22 & 2) == 0) goto L9;
        int r3 = r11.status;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.text;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.placeholder;
    L19:
        if ((r22 & 16) == 0) goto L21;
        TextContentList r6 = r11.textContentList;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.writingText;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r8 = r11.showStopBtn;
    L31:
        if ((r22 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        Boolean r9 = r11.showKeyboard;
    L35:
        if ((r22 & 256) == 0) goto L37;
        JSPrompt r10 = r11.recentPrompt;
    L39:
        if ((r22 & 512) == 0) goto L41;
        boolean r1 = r11.placehoderSelected;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r110;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
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

    public final JSPrompt component9() {
        return this.recentPrompt;
    }

    public final JSInput copy(boolean r13, int r14, String r16, String r17, TextContentList r18, String r19, boolean r110, Boolean r20, JSPrompt r21, boolean r22) {
        return new JSInput(r13, r14, r16, r17, r18, r19, r110, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof JSInput) == true) goto L8;
        return false;
    L8:
        JSInput r6 = (JSInput) r5;
        if (this.show == r6.show) goto L12;
        return false;
    L12:
        if (this.status == r6.status) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.placeholder, r6.placeholder) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.textContentList, r6.textContentList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.writingText, r6.writingText) == true) goto L27;
        return false;
    L27:
        if (this.showStopBtn == r6.showStopBtn) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.showKeyboard, r6.showKeyboard) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.recentPrompt, r6.recentPrompt) == true) goto L36;
        return false;
    L36:
        if (this.placehoderSelected == r6.placehoderSelected) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.show == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.status) * 31;
        String r3 = this.text;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.placeholder;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        TextContentList r10 = this.textContentList;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.writingText;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        if (this.showStopBtn == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r16 + r17) * 31;
        Boolean r19 = this.showKeyboard;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        JSPrompt r22 = this.recentPrompt;
        if (r22 == null) goto L34;
        r4 = r22.hashCode();
    L34:
        int r23 = (r21 + r4) * 31;
        if (this.placehoderSelected == true) goto L39;
        r1 = 1237;
    L39:
        return r23 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("JSInput(show=");
        r0.append(this.show);
        r0.append(", status=");
        r0.append(this.status);
        r0.append(", text.length=");
        String r1 = this.text;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append(", placeholder=");
        r0.append(this.placeholder);
        r0.append(", writingText=");
        r0.append(this.writingText);
        r0.append(", showStopBtn=");
        r0.append(this.showStopBtn);
        r0.append(", showKeyboard=");
        r0.append(this.showKeyboard);
        r0.append(", textContentList=");
        r0.append(this.textContentList);
        r0.append(", recentPrompt=");
        r0.append(this.recentPrompt);
        r0.append(", placehoderSelected=");
        r0.append(this.placehoderSelected);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final boolean getPlacehoderSelected() {
        return this.placehoderSelected;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final JSPrompt getRecentPrompt() {
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

    public final void setPlacehoderSelected(boolean r1) {
        this.placehoderSelected = r1;
    }

    public final void setPlaceholder(String r1) {
        this.placeholder = r1;
    }

    public final void setRecentPrompt(JSPrompt r1) {
        this.recentPrompt = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public final void setShowKeyboard(Boolean r1) {
        this.showKeyboard = r1;
    }

    public final void setShowStopBtn(boolean r1) {
        this.showStopBtn = r1;
    }

    public final void setStatus(int r1) {
        this.status = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setTextContentList(TextContentList r1) {
        this.textContentList = r1;
    }

    public final void setWritingText(String r1) {
        this.writingText = r1;
    }

    public JSInput(boolean r1, int r2, String r3, String r4, TextContentList r5, String r6, boolean r7, Boolean r8, JSPrompt r9, boolean r10) {
        this.show = r1;
        this.status = r2;
        this.text = r3;
        this.placeholder = r4;
        this.textContentList = r5;
        this.writingText = r6;
        this.showStopBtn = r7;
        this.showKeyboard = r8;
        this.recentPrompt = r9;
        this.placehoderSelected = r10;
    }

    public /* synthetic */ JSInput(boolean r12, int r13, String r14, String r16, TextContentList r17, String r18, boolean r19, Boolean r110, JSPrompt r20, boolean r21, int r22, DefaultConstructorMarker r23) {
        boolean r2 = false;
        if ((r22 & 2) == 0) goto L5;
        int r1 = 0;
    L6:
        JSPrompt r4 = null;
        if ((r22 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r22 & 8) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r22 & 16) == 0) goto L17;
        TextContentList r6 = null;
    L19:
        if ((r22 & 32) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r22 & 64) == 0) goto L25;
        boolean r8 = false;
    L27:
        if ((r22 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L29;
        Boolean r9 = null;
    L31:
        if ((r22 & 256) != 0) goto L35;
        r4 = r20;
    L35:
        if ((r22 & 512) != 0) goto L38;
        r2 = r21;
    L38:
        this(r12, r1, r3, r5, r6, r7, r8, r9, r4, r2);
        return;
    L29:
        r9 = r110;
        goto L31
    L25:
        r8 = r19;
        goto L27
    L21:
        r7 = r18;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L6
    }
}
