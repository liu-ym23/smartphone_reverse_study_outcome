package com.ss.android.lark.chat.cot;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rHÆ\u0003J\t\u0010.\u001a\u00020\u000fHÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\t\u00100\u001a\u00020\u000fHÆ\u0003J\u0095\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fHÆ\u0001J\u0013\u00102\u001a\u00020\u000f2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010\u0011\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!¨\u00068"}, d2 = {"Lcom/ss/android/lark/chat/cot/ToolCallExtra;", "Lcom/ss/android/lark/chat/cot/CotBlockExtra;", "toolCallName", "", "icon", "args", "argsJson", "result", "resultJson", "parentMessageId", "resultAreas", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/cot/ToolCallResultArea;", "Lkotlin/collections/ArrayList;", "onlyText", "", "onlyCapsule", "onlyCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ZZZ)V", "getToolCallName", "()Ljava/lang/String;", "getIcon", "getArgs", "getArgsJson", "getResult", "getResultJson", "getParentMessageId", "getResultAreas", "()Ljava/util/ArrayList;", "getOnlyText", "()Z", "setOnlyText", "(Z)V", "getOnlyCapsule", "setOnlyCapsule", "getOnlyCode", "setOnlyCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "", "hashCode", "", "toString", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToolCallExtra implements CotBlockExtra {
    private final String args;
    private final String argsJson;
    private final String icon;
    private boolean onlyCapsule;
    private boolean onlyCode;
    private boolean onlyText;
    private final String parentMessageId;
    private final String result;
    private final ArrayList<ToolCallResultArea> resultAreas;
    private final String resultJson;
    private final String toolCallName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToolCallExtra copy$default(ToolCallExtra r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, ArrayList r210, boolean r211, boolean r212, boolean r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.toolCallName;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.icon;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.args;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.argsJson;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.result;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.resultJson;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.parentMessageId;
    L31:
        if ((r214 & 128) == 0) goto L33;
        ArrayList r107 = r110.resultAreas;
    L35:
        if ((r214 & 256) == 0) goto L37;
        boolean r118 = r110.onlyText;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r119 = r110.onlyCapsule;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        boolean r108 = r110.onlyCode;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final String component1() {
        return this.toolCallName;
    }

    public final boolean component10() {
        return this.onlyCapsule;
    }

    public final boolean component11() {
        return this.onlyCode;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.args;
    }

    public final String component4() {
        return this.argsJson;
    }

    public final String component5() {
        return this.result;
    }

    public final String component6() {
        return this.resultJson;
    }

    public final String component7() {
        return this.parentMessageId;
    }

    public final ArrayList<ToolCallResultArea> component8() {
        return this.resultAreas;
    }

    public final boolean component9() {
        return this.onlyText;
    }

    public final ToolCallExtra copy(String r110, String r111, String r112, String r113, String r114, String r115, String r210, ArrayList<ToolCallResultArea> r211, boolean r212, boolean r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r211, "resultAreas");
        return new ToolCallExtra(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ToolCallExtra) == true) goto L8;
        return false;
    L8:
        ToolCallExtra r101 = (ToolCallExtra) r100;
        if (Intrinsics.areEqual(this.toolCallName, r101.toolCallName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.args, r101.args) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.argsJson, r101.argsJson) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.result, r101.result) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resultJson, r101.resultJson) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.parentMessageId, r101.parentMessageId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.resultAreas, r101.resultAreas) == true) goto L33;
        return false;
    L33:
        if (this.onlyText == r101.onlyText) goto L36;
        return false;
    L36:
        if (this.onlyCapsule == r101.onlyCapsule) goto L39;
        return false;
    L39:
        if (this.onlyCode == r101.onlyCode) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.toolCallName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.icon;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.args;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.argsJson;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.result;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.resultJson;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.parentMessageId;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        int r120 = (((r118 + r101) * 31) + this.resultAreas.hashCode()) * 31;
        int r121 = 1231;
        if (this.onlyText == false) goto L33;
        int r122 = 1231;
    L34:
        int r123 = (r120 + r122) * 31;
        if (this.onlyCapsule == false) goto L37;
        int r124 = 1231;
    L38:
        int r125 = (r123 + r124) * 31;
        if (this.onlyCode == true) goto L43;
        r121 = 1237;
    L43:
        return r125 + r121;
    L37:
        r124 = 1237;
        goto L38
    L33:
        r122 = 1237;
        goto L34
    L25:
        r117 = r116.hashCode();
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
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ToolCallExtra(toolCallName=" + this.toolCallName + ", icon=" + this.icon + ", args=" + this.args + ", argsJson=" + this.argsJson + ", result=" + this.result + ", resultJson=" + this.resultJson + ", parentMessageId=" + this.parentMessageId + ", resultAreas=" + this.resultAreas + ", onlyText=" + this.onlyText + ", onlyCapsule=" + this.onlyCapsule + ", onlyCode=" + this.onlyCode + ')';
    }

    public final String getArgs() {
        return this.args;
    }

    public final String getArgsJson() {
        return this.argsJson;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final boolean getOnlyCapsule() {
        return this.onlyCapsule;
    }

    public final boolean getOnlyCode() {
        return this.onlyCode;
    }

    public final boolean getOnlyText() {
        return this.onlyText;
    }

    public final String getParentMessageId() {
        return this.parentMessageId;
    }

    public final String getResult() {
        return this.result;
    }

    public final ArrayList<ToolCallResultArea> getResultAreas() {
        return this.resultAreas;
    }

    public final String getResultJson() {
        return this.resultJson;
    }

    public final String getToolCallName() {
        return this.toolCallName;
    }

    public final void setOnlyCapsule(boolean r100) {
        this.onlyCapsule = r100;
    }

    public final void setOnlyCode(boolean r100) {
        this.onlyCode = r100;
    }

    public final void setOnlyText(boolean r100) {
        this.onlyText = r100;
    }

    public ToolCallExtra(String r100, String r101, String r102, String r103, String r104, String r105, String r106, ArrayList<ToolCallResultArea> r107, boolean r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r107, "resultAreas");
        this.toolCallName = r100;
        this.icon = r101;
        this.args = r102;
        this.argsJson = r103;
        this.result = r104;
        this.resultJson = r105;
        this.parentMessageId = r106;
        this.resultAreas = r107;
        this.onlyText = r110;
        this.onlyCapsule = r111;
        this.onlyCode = r112;
    }

    public /* synthetic */ ToolCallExtra(String r110, String r111, String r112, String r113, String r114, String r210, String r211, ArrayList r212, boolean r213, boolean r214, boolean r215, int r216, DefaultConstructorMarker r217) {
        if ((r216 & 128) == 0) goto L5;
        ArrayList r115 = new ArrayList();
    L7:
        if ((r216 & 256) == 0) goto L9;
        boolean r116 = true;
    L11:
        if ((r216 & 512) == 0) goto L13;
        boolean r117 = false;
    L15:
        if ((r216 & 1024) == 0) goto L17;
        boolean r118 = false;
    L18:
        this(r110, r111, r112, r113, r114, r210, r211, r115, r116, r117, r118);
        return;
    L17:
        r118 = r215;
        goto L18
    L13:
        r117 = r214;
        goto L15
    L9:
        r116 = r213;
        goto L11
    L5:
        r115 = r212;
        goto L7
    }
}
