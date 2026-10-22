package com.ss.android.lark.inline.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/QuickActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PromptTask", "API", "Companion", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickActionType extends Enum<QuickActionType> {
    public static final QuickActionType API = null;
    public static final a Companion = null;
    public static final QuickActionType PromptTask = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QuickActionType[] f426809a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426810b = null;
    private final int value;

    public static EnumEntries<QuickActionType> getEntries() {
        return f426810b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.inline.ai.api.QuickActionType$a] */
    static {
        QuickActionType r100 = new QuickActionType("PromptTask", 0, 0);
        PromptTask = r100;
        QuickActionType r101 = new QuickActionType("API", 1, 1);
        API = r101;
        QuickActionType[] r102 = {r100, r101};
        f426809a = r102;
        f426810b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static QuickActionType[] values() {
        return (QuickActionType[]) f426809a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static QuickActionType valueOf(String r100) {
        return (QuickActionType) r27.a.a(QuickActionType.class, r100);
    }

    public QuickActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
