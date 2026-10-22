package com.ss.android.lark.inline.ai.api.creationai;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b-\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0089\u0001\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010>\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001aR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/CreationAIPanel;", "Ljava/io/Serializable;", "show", "", "scene", "", "mode", "conversationId", DBDefinition.TASK_ID, "writingStatus", "editor", "Lcom/ss/android/lark/inline/ai/api/creationai/Editor;", "uiConfig", "Lcom/ss/android/lark/inline/ai/api/creationai/UIConfig;", "dragBar", "Lcom/ss/android/lark/inline/ai/api/creationai/DragBar;", "theme", "maskType", "disableLandscape", "heightRatio", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/inline/ai/api/creationai/Editor;Lcom/ss/android/lark/inline/ai/api/creationai/UIConfig;Lcom/ss/android/lark/inline/ai/api/creationai/DragBar;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;)V", "getShow", "()Z", "setShow", "(Z)V", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getMode", "setMode", "getConversationId", "setConversationId", "getTaskId", "setTaskId", "getWritingStatus", "setWritingStatus", "getEditor", "()Lcom/ss/android/lark/inline/ai/api/creationai/Editor;", "setEditor", "(Lcom/ss/android/lark/inline/ai/api/creationai/Editor;)V", "getUiConfig", "()Lcom/ss/android/lark/inline/ai/api/creationai/UIConfig;", "setUiConfig", "(Lcom/ss/android/lark/inline/ai/api/creationai/UIConfig;)V", "getDragBar", "()Lcom/ss/android/lark/inline/ai/api/creationai/DragBar;", "setDragBar", "(Lcom/ss/android/lark/inline/ai/api/creationai/DragBar;)V", "getTheme", "setTheme", "getMaskType", "setMaskType", "getDisableLandscape", "setDisableLandscape", "getHeightRatio", "()Ljava/lang/Float;", "setHeightRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "toString", "Companion", "Builder", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationAIPanel implements Serializable {
    public static final a Companion = null;
    public static final float HEIGHT_RATIO = 0.95f;
    public static final String STYLE_FULLSCREEN = "fullScreen";
    private String conversationId;
    private boolean disableLandscape;
    private DragBar dragBar;
    private Editor editor;
    private Float heightRatio;
    private String maskType;
    private String mode;
    private String scene;
    private boolean show;
    private String taskId;
    private String theme;
    private UIConfig uiConfig;
    private String writingStatus;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "CreationAIPanel(show=" + this.show + ", scene=" + this.scene + ", mode=" + this.mode + ", conversationId=" + this.conversationId + ", taskId=" + this.taskId + ", writingStatus=" + this.writingStatus + ", editor=" + this.editor + ", uiConfig=" + this.uiConfig + ", dragBar=" + this.dragBar + ", theme=" + this.theme + ", maskType=" + this.maskType + ", disableLandscape=" + this.disableLandscape + ", heightRatio=" + this.heightRatio + ')';
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final boolean getDisableLandscape() {
        return this.disableLandscape;
    }

    public final DragBar getDragBar() {
        return this.dragBar;
    }

    public final Editor getEditor() {
        return this.editor;
    }

    public final Float getHeightRatio() {
        return this.heightRatio;
    }

    public final String getMaskType() {
        return this.maskType;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getScene() {
        return this.scene;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTheme() {
        return this.theme;
    }

    public final UIConfig getUiConfig() {
        return this.uiConfig;
    }

    public final String getWritingStatus() {
        return this.writingStatus;
    }

    public final void setConversationId(String r100) {
        this.conversationId = r100;
    }

    public final void setDisableLandscape(boolean r100) {
        this.disableLandscape = r100;
    }

    public final void setDragBar(DragBar r100) {
        this.dragBar = r100;
    }

    public final void setEditor(Editor r100) {
        this.editor = r100;
    }

    public final void setHeightRatio(Float r100) {
        this.heightRatio = r100;
    }

    public final void setMaskType(String r100) {
        this.maskType = r100;
    }

    public final void setMode(String r100) {
        this.mode = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }

    public final void setTaskId(String r100) {
        this.taskId = r100;
    }

    public final void setTheme(String r100) {
        this.theme = r100;
    }

    public final void setUiConfig(UIConfig r100) {
        this.uiConfig = r100;
    }

    public final void setWritingStatus(String r100) {
        this.writingStatus = r100;
    }

    public CreationAIPanel(boolean r100, String r101, String r102, String r103, String r104, String r105, Editor r106, UIConfig r107, DragBar r110, String r111, String r112, Boolean r113, Float r114) {
        this.mode = "float";
        this.heightRatio = Float.valueOf(0.95f);
        this.show = r100;
        this.scene = r101;
        this.mode = r102;
        this.conversationId = r103;
        this.taskId = r104;
        this.writingStatus = r105;
        this.editor = r106;
        this.uiConfig = r107;
        this.dragBar = r110;
        this.theme = r111;
        this.maskType = r112;
        if (r113 == null) goto L5;
        boolean r108 = r113.booleanValue();
    L6:
        this.disableLandscape = r108;
        this.heightRatio = r114;
        return;
    L5:
        r108 = false;
        goto L6
    }
}
