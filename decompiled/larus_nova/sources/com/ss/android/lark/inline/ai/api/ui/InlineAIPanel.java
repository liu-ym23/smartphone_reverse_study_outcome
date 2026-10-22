package com.ss.android.lark.inline.ai.api.ui;

import android.view.View;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\bc\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u008b\u00012\u00020\u0001:\u0004\u008b\u0001\u008c\u0001B\u009b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0004\b'\u0010(J\b\u0010o\u001a\u00020\u0007H\u0016J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010s\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0002\u0010kJ¤\u0002\u0010\u0085\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\"\u001a\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010$\u001a\u00020\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&HÆ\u0001¢\u0006\u0003\u0010\u0086\u0001J\u0015\u0010\u0087\u0001\u001a\u00020\u00032\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\nHÖ\u0003J\u000b\u0010\u0089\u0001\u001a\u00030\u008a\u0001HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R:\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00101\"\u0004\b]\u00103R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u00101\"\u0004\b_\u00103R\u001c\u0010 \u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00101\"\u0004\ba\u00103R\u001c\u0010!\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00101\"\u0004\bc\u00103R\u001a\u0010\"\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010)\"\u0004\be\u0010+R\u001c\u0010#\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00101\"\u0004\bg\u00103R\u001a\u0010$\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010)\"\u0004\bi\u0010+R\u001e\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010n\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m¨\u0006\u008d\u0001"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/InlineAIPanel;", "Ljava/io/Serializable;", "isContentUseCustomView", "", "contentCustomView", "Landroid/view/View;", "content", "", "contentExtra", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "images", "Lcom/ss/android/lark/inline/ai/api/ui/Images;", "prompts", "Lcom/ss/android/lark/inline/ai/api/ui/Prompts;", "operates", "Lcom/ss/android/lark/inline/ai/api/ui/Operates;", "input", "Lcom/ss/android/lark/inline/ai/api/ui/Input;", FilterData.FilterOptionItem.Type.RANGE, "Lcom/ss/android/lark/inline/ai/api/ui/Range;", "tips", "Lcom/ss/android/lark/inline/ai/api/ui/Tips;", "feedback", "Lcom/ss/android/lark/inline/ai/api/ui/Feedback;", "history", "Lcom/ss/android/lark/inline/ai/api/ui/History;", "dragBar", "Lcom/ss/android/lark/inline/ai/api/ui/DragBar;", "conversationId", DBDefinition.TASK_ID, "theme", "maskType", "lock", "style", "showOnboarding", "heightRatio", "", "<init>", "(ZLandroid/view/View;Ljava/lang/String;Ljava/util/HashMap;Lcom/ss/android/lark/inline/ai/api/ui/Images;Lcom/ss/android/lark/inline/ai/api/ui/Prompts;Lcom/ss/android/lark/inline/ai/api/ui/Operates;Lcom/ss/android/lark/inline/ai/api/ui/Input;Lcom/ss/android/lark/inline/ai/api/ui/Range;Lcom/ss/android/lark/inline/ai/api/ui/Tips;Lcom/ss/android/lark/inline/ai/api/ui/Feedback;Lcom/ss/android/lark/inline/ai/api/ui/History;Lcom/ss/android/lark/inline/ai/api/ui/DragBar;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/Float;)V", "()Z", "setContentUseCustomView", "(Z)V", "getContentCustomView", "()Landroid/view/View;", "setContentCustomView", "(Landroid/view/View;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContentExtra", "()Ljava/util/HashMap;", "setContentExtra", "(Ljava/util/HashMap;)V", "getImages", "()Lcom/ss/android/lark/inline/ai/api/ui/Images;", "setImages", "(Lcom/ss/android/lark/inline/ai/api/ui/Images;)V", "getPrompts", "()Lcom/ss/android/lark/inline/ai/api/ui/Prompts;", "setPrompts", "(Lcom/ss/android/lark/inline/ai/api/ui/Prompts;)V", "getOperates", "()Lcom/ss/android/lark/inline/ai/api/ui/Operates;", "setOperates", "(Lcom/ss/android/lark/inline/ai/api/ui/Operates;)V", "getInput", "()Lcom/ss/android/lark/inline/ai/api/ui/Input;", "setInput", "(Lcom/ss/android/lark/inline/ai/api/ui/Input;)V", "getRange", "()Lcom/ss/android/lark/inline/ai/api/ui/Range;", "setRange", "(Lcom/ss/android/lark/inline/ai/api/ui/Range;)V", "getTips", "()Lcom/ss/android/lark/inline/ai/api/ui/Tips;", "setTips", "(Lcom/ss/android/lark/inline/ai/api/ui/Tips;)V", "getFeedback", "()Lcom/ss/android/lark/inline/ai/api/ui/Feedback;", "setFeedback", "(Lcom/ss/android/lark/inline/ai/api/ui/Feedback;)V", "getHistory", "()Lcom/ss/android/lark/inline/ai/api/ui/History;", "setHistory", "(Lcom/ss/android/lark/inline/ai/api/ui/History;)V", "getDragBar", "()Lcom/ss/android/lark/inline/ai/api/ui/DragBar;", "setDragBar", "(Lcom/ss/android/lark/inline/ai/api/ui/DragBar;)V", "getConversationId", "setConversationId", "getTaskId", "setTaskId", "getTheme", "setTheme", "getMaskType", "setMaskType", "getLock", "setLock", "getStyle", "setStyle", "getShowOnboarding", "setShowOnboarding", "getHeightRatio", "()Ljava/lang/Float;", "setHeightRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(ZLandroid/view/View;Ljava/lang/String;Ljava/util/HashMap;Lcom/ss/android/lark/inline/ai/api/ui/Images;Lcom/ss/android/lark/inline/ai/api/ui/Prompts;Lcom/ss/android/lark/inline/ai/api/ui/Operates;Lcom/ss/android/lark/inline/ai/api/ui/Input;Lcom/ss/android/lark/inline/ai/api/ui/Range;Lcom/ss/android/lark/inline/ai/api/ui/Tips;Lcom/ss/android/lark/inline/ai/api/ui/Feedback;Lcom/ss/android/lark/inline/ai/api/ui/History;Lcom/ss/android/lark/inline/ai/api/ui/DragBar;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/Float;)Lcom/ss/android/lark/inline/ai/api/ui/InlineAIPanel;", "equals", "other", "hashCode", "", "Companion", "Builder", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InlineAIPanel implements Serializable {
    public static final a Companion = null;
    public static final String STYLE_FULLSCREEN = "fullScreen";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient View f426841a;
    private String content;
    private HashMap<String, Object> contentExtra;
    private String conversationId;
    private DragBar dragBar;
    private Feedback feedback;
    private Float heightRatio;
    private History history;
    private Images images;
    private Input input;
    private boolean isContentUseCustomView;
    private boolean lock;
    private String maskType;
    private Operates operates;
    private Prompts prompts;
    private Range range;
    private boolean showOnboarding;
    private String style;
    private String taskId;
    private String theme;
    private Tips tips;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public InlineAIPanel() {
        this(false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, false, null, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InlineAIPanel copy$default(InlineAIPanel r110, boolean r111, View r112, String r210, HashMap r211, Images r212, Prompts r213, Operates r214, Input r215, Range r216, Tips r217, Feedback r218, History r219, DragBar r310, String r311, String r312, String r313, String r314, boolean r315, String r316, boolean r317, Float r318, int r319, Object r410) {
        if ((r319 & 1) == 0) goto L5;
        boolean r100 = r110.isContentUseCustomView;
    L7:
        if ((r319 & 2) == 0) goto L9;
        View r101 = r110.f426841a;
    L11:
        if ((r319 & 4) == 0) goto L13;
        String r102 = r110.content;
    L15:
        if ((r319 & 8) == 0) goto L17;
        HashMap r103 = r110.contentExtra;
    L19:
        if ((r319 & 16) == 0) goto L21;
        Images r104 = r110.images;
    L23:
        if ((r319 & 32) == 0) goto L25;
        Prompts r105 = r110.prompts;
    L27:
        if ((r319 & 64) == 0) goto L29;
        Operates r106 = r110.operates;
    L31:
        if ((r319 & 128) == 0) goto L33;
        Input r107 = r110.input;
    L35:
        if ((r319 & 256) == 0) goto L37;
        Range r113 = r110.range;
    L39:
        if ((r319 & 512) == 0) goto L41;
        Tips r114 = r110.tips;
    L43:
        if ((r319 & 1024) == 0) goto L45;
        Feedback r115 = r110.feedback;
    L47:
        if ((r319 & 2048) == 0) goto L49;
        History r116 = r110.history;
    L51:
        if ((r319 & 4096) == 0) goto L53;
        DragBar r117 = r110.dragBar;
    L55:
        if ((r319 & 8192) == 0) goto L57;
        String r118 = r110.conversationId;
    L58:
        String r320 = r118;
        if ((r319 & 16384) == 0) goto L61;
        String r119 = r110.taskId;
    L62:
        String r321 = r119;
        if ((r319 & 32768) == 0) goto L65;
        String r120 = r110.theme;
    L66:
        String r322 = r120;
        if ((r319 & 65536) == 0) goto L69;
        String r121 = r110.maskType;
    L70:
        String r323 = r121;
        if ((r319 & 131072) == 0) goto L73;
        boolean r122 = r110.lock;
    L74:
        boolean r324 = r122;
        if ((r319 & 262144) == 0) goto L77;
        String r123 = r110.style;
    L78:
        String r325 = r123;
        if ((r319 & 524288) == 0) goto L81;
        boolean r124 = r110.showOnboarding;
    L83:
        if ((r319 & 1048576) == 0) goto L85;
        Float r108 = r110.heightRatio;
    L87:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r124, r108);
    L85:
        r108 = r318;
        goto L87
    L81:
        r124 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.isContentUseCustomView;
    }

    public final Tips component10() {
        return this.tips;
    }

    public final Feedback component11() {
        return this.feedback;
    }

    public final History component12() {
        return this.history;
    }

    public final DragBar component13() {
        return this.dragBar;
    }

    public final String component14() {
        return this.conversationId;
    }

    public final String component15() {
        return this.taskId;
    }

    public final String component16() {
        return this.theme;
    }

    public final String component17() {
        return this.maskType;
    }

    public final boolean component18() {
        return this.lock;
    }

    public final String component19() {
        return this.style;
    }

    public final View component2() {
        return this.f426841a;
    }

    public final boolean component20() {
        return this.showOnboarding;
    }

    public final Float component21() {
        return this.heightRatio;
    }

    public final String component3() {
        return this.content;
    }

    public final HashMap<String, Object> component4() {
        return this.contentExtra;
    }

    public final Images component5() {
        return this.images;
    }

    public final Prompts component6() {
        return this.prompts;
    }

    public final Operates component7() {
        return this.operates;
    }

    public final Input component8() {
        return this.input;
    }

    public final Range component9() {
        return this.range;
    }

    public final InlineAIPanel copy(boolean r210, View r211, String r212, HashMap<String, Object> r213, Images r214, Prompts r215, Operates r310, Input r311, Range r312, Tips r313, Feedback r314, History r315, DragBar r316, String r317, String r318, String r319, String r410, boolean r411, String r412, boolean r413, Float r414) {
        return new InlineAIPanel(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InlineAIPanel) == true) goto L8;
        return false;
    L8:
        InlineAIPanel r101 = (InlineAIPanel) r100;
        if (this.isContentUseCustomView == r101.isContentUseCustomView) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f426841a, r101.f426841a) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contentExtra, r101.contentExtra) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.prompts, r101.prompts) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.operates, r101.operates) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.input, r101.input) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.range, r101.range) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tips, r101.tips) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.feedback, r101.feedback) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.history, r101.history) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.dragBar, r101.dragBar) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.theme, r101.theme) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.maskType, r101.maskType) == true) goto L60;
        return false;
    L60:
        if (this.lock == r101.lock) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L66;
        return false;
    L66:
        if (this.showOnboarding == r101.showOnboarding) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.heightRatio, r101.heightRatio) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isContentUseCustomView == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        View r103 = this.f426841a;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.content;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        HashMap<String, Object> r110 = this.contentExtra;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Images r113 = this.images;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Prompts r116 = this.prompts;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Operates r119 = this.operates;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Input r122 = this.input;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Range r125 = this.range;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Tips r128 = this.tips;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Feedback r131 = this.feedback;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        History r134 = this.history;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        DragBar r137 = this.dragBar;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.conversationId;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.taskId;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.theme;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.maskType;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        if (this.lock == false) goto L73;
        int r152 = 1231;
    L74:
        int r153 = (r151 + r152) * 31;
        String r154 = this.style;
        if (r154 != null) goto L77;
        int r155 = 0;
    L78:
        int r156 = (r153 + r155) * 31;
        if (this.showOnboarding == true) goto L82;
        r100 = 1237;
    L82:
        int r157 = (r156 + r100) * 31;
        Float r158 = this.heightRatio;
        if (r158 == null) goto L87;
        r104 = r158.hashCode();
    L87:
        return r157 + r104;
    L77:
        r155 = r154.hashCode();
        goto L78
    L73:
        r152 = 1237;
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
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
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("InlineAIPanel(isContentUseCustomView=");
        r100.append(this.isContentUseCustomView);
        r100.append(", contentCustomView=");
        r100.append(this.f426841a);
        r100.append(", content=");
        String r101 = this.content;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.length());
    L6:
        r100.append(r102);
        r100.append(", prompts=");
        r100.append(this.prompts);
        r100.append(", operates=");
        r100.append(this.operates);
        r100.append(", input=");
        r100.append(this.input);
        r100.append(", range=");
        r100.append(this.range);
        r100.append(", tips=");
        r100.append(this.tips);
        r100.append(", feedback=");
        r100.append(this.feedback);
        r100.append(", history=");
        r100.append(this.history);
        r100.append(", dragBar=");
        r100.append(this.dragBar);
        r100.append(", conversationId=");
        r100.append(this.conversationId);
        r100.append(", taskId=");
        r100.append(this.taskId);
        r100.append(", theme=");
        r100.append(this.theme);
        r100.append(", maskType=");
        r100.append(this.maskType);
        r100.append(", lock=");
        r100.append(this.lock);
        r100.append(",style=");
        r100.append(this.style);
        r100.append(",showOnboarding=");
        r100.append(this.showOnboarding);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final String getContent() {
        return this.content;
    }

    public final View getContentCustomView() {
        return this.f426841a;
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

    public final Input getInput() {
        return this.input;
    }

    public final boolean getLock() {
        return this.lock;
    }

    public final String getMaskType() {
        return this.maskType;
    }

    public final Operates getOperates() {
        return this.operates;
    }

    public final Prompts getPrompts() {
        return this.prompts;
    }

    public final Range getRange() {
        return this.range;
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

    public final Tips getTips() {
        return this.tips;
    }

    public final boolean isContentUseCustomView() {
        return this.isContentUseCustomView;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setContentCustomView(View r100) {
        this.f426841a = r100;
    }

    public final void setContentExtra(HashMap<String, Object> r100) {
        this.contentExtra = r100;
    }

    public final void setContentUseCustomView(boolean r100) {
        this.isContentUseCustomView = r100;
    }

    public final void setConversationId(String r100) {
        this.conversationId = r100;
    }

    public final void setDragBar(DragBar r100) {
        this.dragBar = r100;
    }

    public final void setFeedback(Feedback r100) {
        this.feedback = r100;
    }

    public final void setHeightRatio(Float r100) {
        this.heightRatio = r100;
    }

    public final void setHistory(History r100) {
        this.history = r100;
    }

    public final void setImages(Images r100) {
        this.images = r100;
    }

    public final void setInput(Input r100) {
        this.input = r100;
    }

    public final void setLock(boolean r100) {
        this.lock = r100;
    }

    public final void setMaskType(String r100) {
        this.maskType = r100;
    }

    public final void setOperates(Operates r100) {
        this.operates = r100;
    }

    public final void setPrompts(Prompts r100) {
        this.prompts = r100;
    }

    public final void setRange(Range r100) {
        this.range = r100;
    }

    public final void setShowOnboarding(boolean r100) {
        this.showOnboarding = r100;
    }

    public final void setStyle(String r100) {
        this.style = r100;
    }

    public final void setTaskId(String r100) {
        this.taskId = r100;
    }

    public final void setTheme(String r100) {
        this.theme = r100;
    }

    public final void setTips(Tips r100) {
        this.tips = r100;
    }

    public InlineAIPanel(boolean r100, View r101, String r102, HashMap<String, Object> r103, Images r104, Prompts r105, Operates r106, Input r110, Range r111, Tips r112, Feedback r113, History r114, DragBar r115, String r116, String r117, String r118, String r119, boolean r210, String r211, boolean r212, Float r213) {
        this.isContentUseCustomView = r100;
        this.f426841a = r101;
        this.content = r102;
        this.contentExtra = r103;
        this.images = r104;
        this.prompts = r105;
        this.operates = r106;
        this.input = r110;
        this.range = r111;
        this.tips = r112;
        this.feedback = r113;
        this.history = r114;
        this.dragBar = r115;
        this.conversationId = r116;
        this.taskId = r117;
        this.theme = r118;
        this.maskType = r119;
        this.lock = r210;
        this.style = r211;
        this.showOnboarding = r212;
        this.heightRatio = r213;
    }

    public /* synthetic */ InlineAIPanel(boolean r210, View r211, String r212, HashMap r213, Images r214, Prompts r215, Operates r216, Input r310, Range r311, Tips r312, Feedback r313, History r314, DragBar r315, String r316, String r317, String r318, String r319, boolean r410, String r411, boolean r412, Float r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r414 & 2) == 0) goto L9;
        View r101 = null;
    L11:
        if ((r414 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r414 & 8) == 0) goto L17;
        HashMap r103 = null;
    L19:
        if ((r414 & 16) == 0) goto L21;
        Images r104 = null;
    L23:
        if ((r414 & 32) == 0) goto L25;
        Prompts r105 = null;
    L27:
        if ((r414 & 64) == 0) goto L29;
        Operates r106 = null;
    L31:
        if ((r414 & 128) == 0) goto L33;
        Input r107 = null;
    L35:
        if ((r414 & 256) == 0) goto L37;
        Range r110 = null;
    L39:
        if ((r414 & 512) == 0) goto L41;
        Tips r111 = null;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        Feedback r112 = null;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        History r113 = null;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        DragBar r114 = null;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r414 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r414 & 65536) == 0) goto L69;
        String r117 = null;
    L70:
        boolean r118 = true;
        if ((r414 & 131072) == 0) goto L73;
        boolean r119 = true;
    L75:
        if ((r414 & 262144) == 0) goto L77;
        String r217 = null;
    L79:
        if ((r414 & 524288) != 0) goto L83;
        r118 = r412;
    L83:
        if ((r414 & 1048576) == 0) goto L85;
        Float r109 = null;
    L86:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r119, r217, r118, r109);
        return;
    L85:
        r109 = r413;
        goto L86
    L77:
        r217 = r411;
        goto L79
    L73:
        r119 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L70
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r115 = r316;
        goto L59
    L53:
        r114 = r315;
        goto L55
    L49:
        r113 = r314;
        goto L51
    L45:
        r112 = r313;
        goto L47
    L41:
        r111 = r312;
        goto L43
    L37:
        r110 = r311;
        goto L39
    L33:
        r107 = r310;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
