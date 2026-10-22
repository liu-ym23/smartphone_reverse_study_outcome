package com.bytedance.ee.bear.document.ai.inlineai.bean;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.inline.ai.api.ui.DragBar;
import com.ss.android.lark.inline.ai.api.ui.Feedback;
import com.ss.android.lark.inline.ai.api.ui.History;
import com.ss.android.lark.inline.ai.api.ui.Images;
import com.ss.android.lark.inline.ai.api.ui.Range;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 k2\u00020\u0001:\u0001kB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010j\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR:\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR\u001c\u0010Q\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR\u001c\u0010T\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\r\"\u0004\bV\u0010\u000fR\u001c\u0010W\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\r\"\u0004\bY\u0010\u000fR\u001a\u0010Z\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0007\"\u0004\b\\\u0010\tR\u001c\u0010]\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\r\"\u0004\b_\u0010\u000fR\u001a\u0010`\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0007\"\u0004\bb\u0010\tR\u001e\u0010c\u001a\u0004\u0018\u00010dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010i\u001a\u0004\be\u0010f\"\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSInlineAIPanel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "contentExtra", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getContentExtra", "()Ljava/util/HashMap;", "setContentExtra", "(Ljava/util/HashMap;)V", "images", "Lcom/ss/android/lark/inline/ai/api/ui/Images;", "getImages", "()Lcom/ss/android/lark/inline/ai/api/ui/Images;", "setImages", "(Lcom/ss/android/lark/inline/ai/api/ui/Images;)V", "prompts", "Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPrompts;", "getPrompts", "()Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPrompts;", "setPrompts", "(Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPrompts;)V", "operates", "Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSOperates;", "getOperates", "()Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSOperates;", "setOperates", "(Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSOperates;)V", "input", "Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSInput;", "getInput", "()Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSInput;", "setInput", "(Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSInput;)V", "tips", "Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSTips;", "getTips", "()Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSTips;", "setTips", "(Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSTips;)V", "feedback", "Lcom/ss/android/lark/inline/ai/api/ui/Feedback;", "getFeedback", "()Lcom/ss/android/lark/inline/ai/api/ui/Feedback;", "setFeedback", "(Lcom/ss/android/lark/inline/ai/api/ui/Feedback;)V", "range", "Lcom/ss/android/lark/inline/ai/api/ui/Range;", "getRange", "()Lcom/ss/android/lark/inline/ai/api/ui/Range;", "setRange", "(Lcom/ss/android/lark/inline/ai/api/ui/Range;)V", "history", "Lcom/ss/android/lark/inline/ai/api/ui/History;", "getHistory", "()Lcom/ss/android/lark/inline/ai/api/ui/History;", "setHistory", "(Lcom/ss/android/lark/inline/ai/api/ui/History;)V", "dragBar", "Lcom/ss/android/lark/inline/ai/api/ui/DragBar;", "getDragBar", "()Lcom/ss/android/lark/inline/ai/api/ui/DragBar;", "setDragBar", "(Lcom/ss/android/lark/inline/ai/api/ui/DragBar;)V", "conversationId", "getConversationId", "setConversationId", "taskId", "getTaskId", "setTaskId", "theme", "getTheme", "setTheme", "maskType", "getMaskType", "setMaskType", "lock", "getLock", "setLock", JSEventListener.STYLE, "getStyle", "setStyle", "showOnboarding", "getShowOnboarding", "setShowOnboarding", "heightRatio", "", "getHeightRatio", "()Ljava/lang/Float;", "setHeightRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "toString", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSInlineAIPanel implements NonProguard {
    public static final a Companion = null;
    public static final String STYLE_FULLSCREEN = "fullScreen";
    private String content;
    private HashMap<String, Object> contentExtra;
    private String conversationId;
    private DragBar dragBar;
    private Feedback feedback;
    private Float heightRatio;
    private History history;
    private Images images;
    private JSInput input;
    private boolean lock;
    private String maskType;
    private JSOperates operates;
    private JSPrompts prompts;
    private Range range;
    private boolean show;
    private boolean showOnboarding;
    private String style;
    private String taskId;
    private String theme;
    private JSTips tips;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("InlineAIPanel(show=");
        r0.append(this.show);
        r0.append(", content=");
        String r1 = this.content;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append(", images=");
        r0.append(this.images);
        r0.append(", prompts=");
        r0.append(this.prompts);
        r0.append(", operates=");
        r0.append(this.operates);
        r0.append(", input=");
        r0.append(this.input);
        r0.append(", tips=");
        r0.append(this.tips);
        r0.append(", feedback=");
        r0.append(this.feedback);
        r0.append(", history=");
        r0.append(this.history);
        r0.append(", dragBar=");
        r0.append(this.dragBar);
        r0.append(", conversationId=");
        r0.append(this.conversationId);
        r0.append(", taskId=");
        r0.append(this.taskId);
        r0.append(", theme=");
        r0.append(this.theme);
        r0.append(", maskType=");
        r0.append(this.maskType);
        r0.append(", lock=");
        r0.append(this.lock);
        r0.append(",style=");
        r0.append(this.style);
        r0.append(",showOnboarding=");
        r0.append(this.showOnboarding);
        r0.append(",heightRatio=");
        r0.append(this.heightRatio);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public JSInlineAIPanel() {
        this.lock = true;
        this.showOnboarding = true;
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

    public final DragBar getDragBar() {
        return this.dragBar;
    }

    public final Feedback getFeedback() {
        return this.feedback;
    }

    public final Float getHeightRatio() {
        return this.heightRatio;
    }

    public final History getHistory() {
        return this.history;
    }

    public final Images getImages() {
        return this.images;
    }

    public final JSInput getInput() {
        return this.input;
    }

    public final boolean getLock() {
        return this.lock;
    }

    public final String getMaskType() {
        return this.maskType;
    }

    public final JSOperates getOperates() {
        return this.operates;
    }

    public final JSPrompts getPrompts() {
        return this.prompts;
    }

    public final Range getRange() {
        return this.range;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final boolean getShowOnboarding() {
        return this.showOnboarding;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTheme() {
        return this.theme;
    }

    public final JSTips getTips() {
        return this.tips;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setContentExtra(HashMap<String, Object> r1) {
        this.contentExtra = r1;
    }

    public final void setConversationId(String r1) {
        this.conversationId = r1;
    }

    public final void setDragBar(DragBar r1) {
        this.dragBar = r1;
    }

    public final void setFeedback(Feedback r1) {
        this.feedback = r1;
    }

    public final void setHeightRatio(Float r1) {
        this.heightRatio = r1;
    }

    public final void setHistory(History r1) {
        this.history = r1;
    }

    public final void setImages(Images r1) {
        this.images = r1;
    }

    public final void setInput(JSInput r1) {
        this.input = r1;
    }

    public final void setLock(boolean r1) {
        this.lock = r1;
    }

    public final void setMaskType(String r1) {
        this.maskType = r1;
    }

    public final void setOperates(JSOperates r1) {
        this.operates = r1;
    }

    public final void setPrompts(JSPrompts r1) {
        this.prompts = r1;
    }

    public final void setRange(Range r1) {
        this.range = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public final void setShowOnboarding(boolean r1) {
        this.showOnboarding = r1;
    }

    public final void setStyle(String r1) {
        this.style = r1;
    }

    public final void setTaskId(String r1) {
        this.taskId = r1;
    }

    public final void setTheme(String r1) {
        this.theme = r1;
    }

    public final void setTips(JSTips r1) {
        this.tips = r1;
    }
}
