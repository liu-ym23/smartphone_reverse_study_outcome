package com.ss.android.lark.inline.ai.api.knowledgeai;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIPageMode;", "", "scene", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/CreateScene;", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/inline/ai/api/knowledgeai/CreateScene;)V", "getScene", "()Lcom/ss/android/lark/inline/ai/api/knowledgeai/CreateScene;", "setScene", "(Lcom/ss/android/lark/inline/ai/api/knowledgeai/CreateScene;)V", "HIDE", "BOTTOM_SHEET", "KEYBOARD", "isFromKeyboard", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KnowledgeAIPageMode extends Enum<KnowledgeAIPageMode> {
    public static final KnowledgeAIPageMode BOTTOM_SHEET = null;
    public static final KnowledgeAIPageMode HIDE = null;
    public static final KnowledgeAIPageMode KEYBOARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KnowledgeAIPageMode[] f426824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426825b = null;
    private CreateScene scene;

    public static EnumEntries<KnowledgeAIPageMode> getEntries() {
        return f426825b;
    }

    public final boolean isFromKeyboard() {
        return CollectionsKt.contains(SetsKt.setOf(new CreateScene[]{CreateScene.CREATE_KEYBOARD_FROM_QUOTE, CreateScene.KEYBOARD_SEND, CreateScene.KEYBOARD_RECOMMEND_QUESTION}), this.scene);
    }

    static {
        KnowledgeAIPageMode r100 = new KnowledgeAIPageMode("HIDE", 0, null, 1, null);
        HIDE = r100;
        KnowledgeAIPageMode r101 = new KnowledgeAIPageMode("BOTTOM_SHEET", 1, CreateScene.CLICK_ENTRY);
        BOTTOM_SHEET = r101;
        KnowledgeAIPageMode r102 = new KnowledgeAIPageMode("KEYBOARD", 2, CreateScene.CREATE_KEYBOARD_FROM_QUOTE);
        KEYBOARD = r102;
        KnowledgeAIPageMode[] r103 = {r100, r101, r102};
        f426824a = r103;
        f426825b = EnumEntriesKt.enumEntries(r103);
    }

    public static KnowledgeAIPageMode[] values() {
        return (KnowledgeAIPageMode[]) f426824a.clone();
    }

    public final CreateScene getScene() {
        return this.scene;
    }

    public static KnowledgeAIPageMode valueOf(String r100) {
        return (KnowledgeAIPageMode) r27.a.a(KnowledgeAIPageMode.class, r100);
    }

    public final KnowledgeAIPageMode setScene(CreateScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.scene = r100;
        return this;
    }

    /* JADX INFO: renamed from: setScene, reason: collision with other method in class */
    public final void m8641setScene(CreateScene r100) {
        this.scene = r100;
    }

    public KnowledgeAIPageMode(String r100, int r101, CreateScene r102) {
        super(r100, r101);
        this.scene = r102;
    }

    public /* synthetic */ KnowledgeAIPageMode(String r100, int r101, CreateScene r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
