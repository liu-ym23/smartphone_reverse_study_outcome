package com.ss.android.lark.inline.ai.api.creationai;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010(\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/Input;", "Ljava/io/Serializable;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "writingStatus", "", "getWritingStatus", "()Ljava/lang/String;", "setWritingStatus", "(Ljava/lang/String;)V", "text", "getText", "setText", GXTemplateKey.GAIAX_PLACEHOLDER, "getPlaceholder", "setPlaceholder", "textContentList", "Lcom/ss/android/lark/inline/ai/api/creationai/TextContentList;", "getTextContentList", "()Lcom/ss/android/lark/inline/ai/api/creationai/TextContentList;", "setTextContentList", "(Lcom/ss/android/lark/inline/ai/api/creationai/TextContentList;)V", "writingText", "getWritingText", "setWritingText", "showStopBtn", "getShowStopBtn", "setShowStopBtn", "showKeyboard", "getShowKeyboard", "()Ljava/lang/Boolean;", "setShowKeyboard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "toString", "Status", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Input implements Serializable {
    private String placeholder;
    private boolean show;
    private Boolean showKeyboard;
    private boolean showStopBtn;
    private String text;
    private TextContentList textContentList;
    private String writingStatus;
    private String writingText;

    public String toString() {
        StringBuilder r100 = new StringBuilder("Input(show=");
        r100.append(this.show);
        r100.append(", writingStatus=");
        r100.append(this.writingStatus);
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
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public Input() {
        this.writingStatus = "waiting";
    }

    public final String getPlaceholder() {
        return this.placeholder;
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

    public final String getText() {
        return this.text;
    }

    public final TextContentList getTextContentList() {
        return this.textContentList;
    }

    public final String getWritingStatus() {
        return this.writingStatus;
    }

    public final String getWritingText() {
        return this.writingText;
    }

    public final void setPlaceholder(String r100) {
        this.placeholder = r100;
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

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextContentList(TextContentList r100) {
        this.textContentList = r100;
    }

    public final void setWritingStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.writingStatus = r100;
    }

    public final void setWritingText(String r100) {
        this.writingText = r100;
    }
}
