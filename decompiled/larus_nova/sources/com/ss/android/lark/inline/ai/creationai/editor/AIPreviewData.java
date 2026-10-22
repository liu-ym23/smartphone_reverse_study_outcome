package com.ss.android.lark.inline.ai.creationai.editor;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\u0001 BQ\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014¨\u0006!"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/editor/AIPreviewData;", "Ljava/io/Serializable;", "editor", "", "conversationId", "", DBDefinition.TASK_ID, "theme", "bgColor", "status", "fontSize", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEditor", "()Ljava/lang/Object;", "setEditor", "(Ljava/lang/Object;)V", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "getTaskId", "setTaskId", "getTheme", "setTheme", "getBgColor", "setBgColor", "getStatus", "setStatus", "getFontSize", "setFontSize", "toString", "Status", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPreviewData implements Serializable {
    private String bgColor;
    private String conversationId;
    private Object editor;
    private String fontSize;
    private String status;
    private String taskId;
    private String theme;

    public String toString() {
        return "AIPreviewData(editor=" + this.editor + ", conversationId=" + this.conversationId + ", taskId=" + this.taskId + ", theme=" + this.theme + ", bgColor=" + this.bgColor + ", status=" + this.status + ", fontSize=" + this.fontSize + ')';
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Object getEditor() {
        return this.editor;
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

    public final void setEditor(Object r100) {
        this.editor = r100;
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

    public AIPreviewData(Object r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.editor = r100;
        this.conversationId = r101;
        this.taskId = r102;
        this.theme = r103;
        this.bgColor = r104;
        this.status = r105;
        this.fontSize = r106;
    }

    public /* synthetic */ AIPreviewData(Object r110, String r111, String r112, String r113, String r114, String r115, String r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 16) == 0) goto L5;
        String r100 = null;
    L6:
        this(r110, r111, r112, r113, r100, r115, r116);
        return;
    L5:
        r100 = r114;
        goto L6
    }
}
