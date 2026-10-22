package com.ss.android.lark.inline.ai.ui.richtext;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u00010B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010!\u001a\u00020\u0003H\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010#\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0087\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R1\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0016¨\u00061"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/richtext/AIPreviewData;", "Ljava/io/Serializable;", "content", "", "contentExtra", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "conversationId", DBDefinition.TASK_ID, "theme", "bgColor", "status", "fontSize", "<init>", "(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getContentExtra", "()Ljava/util/HashMap;", "getConversationId", "setConversationId", "(Ljava/lang/String;)V", "getTaskId", "setTaskId", "getTheme", "setTheme", "getBgColor", "setBgColor", "getStatus", "setStatus", "getFontSize", "setFontSize", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "Status", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPreviewData implements Serializable {
    private String bgColor;
    private final String content;
    private final HashMap<String, Object> contentExtra;
    private String conversationId;
    private String fontSize;
    private String status;
    private String taskId;
    private String theme;

    public AIPreviewData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPreviewData copy$default(AIPreviewData r100, String r110, HashMap r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.content;
    L7:
        if ((r118 & 2) == 0) goto L9;
        HashMap r102 = r100.contentExtra;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.conversationId;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.taskId;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.theme;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.bgColor;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.status;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.fontSize;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.content;
    }

    public final HashMap<String, Object> component2() {
        return this.contentExtra;
    }

    public final String component3() {
        return this.conversationId;
    }

    public final String component4() {
        return this.taskId;
    }

    public final String component5() {
        return this.theme;
    }

    public final String component6() {
        return this.bgColor;
    }

    public final String component7() {
        return this.status;
    }

    public final String component8() {
        return this.fontSize;
    }

    public final AIPreviewData copy(String r110, HashMap<String, Object> r111, String r112, String r113, String r114, String r115, String r116, String r117) {
        return new AIPreviewData(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIPreviewData) == true) goto L8;
        return false;
    L8:
        AIPreviewData r101 = (AIPreviewData) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contentExtra, r101.contentExtra) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.theme, r101.theme) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.content;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HashMap<String, Object> r104 = this.contentExtra;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.conversationId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.taskId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.theme;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.bgColor;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.status;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.fontSize;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
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
        StringBuilder r100 = new StringBuilder("AIPreviewData(content length=");
        String r101 = this.content;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.length());
    L6:
        r100.append(r102);
        r100.append(", conversationId=");
        r100.append(this.conversationId);
        r100.append(", taskId=");
        r100.append(this.taskId);
        r100.append(", theme=");
        r100.append(this.theme);
        r100.append(", bgColor=");
        r100.append(this.bgColor);
        r100.append(", status=");
        r100.append(this.status);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getContent() {
        return this.content;
    }

    public final HashMap<String, Object> getContentExtra() {
        return this.contentExtra;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getFontSize() {
        return this.fontSize;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTheme() {
        return this.theme;
    }

    public final void setBgColor(String r100) {
        this.bgColor = r100;
    }

    public final void setConversationId(String r100) {
        this.conversationId = r100;
    }

    public final void setFontSize(String r100) {
        this.fontSize = r100;
    }

    public final void setStatus(String r100) {
        this.status = r100;
    }

    public final void setTaskId(String r100) {
        this.taskId = r100;
    }

    public final void setTheme(String r100) {
        this.theme = r100;
    }

    public AIPreviewData(String r100, HashMap<String, Object> r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        this.content = r100;
        this.contentExtra = r101;
        this.conversationId = r102;
        this.taskId = r103;
        this.theme = r104;
        this.bgColor = r105;
        this.status = r106;
        this.fontSize = r107;
    }

    public /* synthetic */ AIPreviewData(String r110, HashMap r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        HashMap r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
