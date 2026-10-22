package com.ss.android.lark.inline.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/InlineAIErrorCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "InlineAI_UNUSABLE_CODE", "INLINEAI_ADMINDEACTIVATED_CODE", "InlineAI_INPUT_COMPLIENCE_ERROR", "InlineAI_OUTPUT_COMPLIENCE_ERROR", "InlineAI_CROSS_REGION_ERROR", "InlineAI_CROSS_BRAND_ERROR", "InlineAI_NOPERMISSION_CODE", "Companion", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InlineAIErrorCode extends Enum<InlineAIErrorCode> {
    public static final a Companion = null;
    public static final InlineAIErrorCode INLINEAI_ADMINDEACTIVATED_CODE = null;
    public static final InlineAIErrorCode InlineAI_CROSS_BRAND_ERROR = null;
    public static final InlineAIErrorCode InlineAI_CROSS_REGION_ERROR = null;
    public static final InlineAIErrorCode InlineAI_INPUT_COMPLIENCE_ERROR = null;
    public static final InlineAIErrorCode InlineAI_NOPERMISSION_CODE = null;
    public static final InlineAIErrorCode InlineAI_OUTPUT_COMPLIENCE_ERROR = null;
    public static final InlineAIErrorCode InlineAI_UNUSABLE_CODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InlineAIErrorCode[] f426801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426802b = null;
    private final int value;

    public static EnumEntries<InlineAIErrorCode> getEntries() {
        return f426802b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.inline.ai.api.InlineAIErrorCode$a] */
    static {
        InlineAIErrorCode r100 = new InlineAIErrorCode("InlineAI_UNUSABLE_CODE", 0, -1);
        InlineAI_UNUSABLE_CODE = r100;
        InlineAIErrorCode r101 = new InlineAIErrorCode("INLINEAI_ADMINDEACTIVATED_CODE", 1, 666900005);
        INLINEAI_ADMINDEACTIVATED_CODE = r101;
        InlineAIErrorCode r102 = new InlineAIErrorCode("InlineAI_INPUT_COMPLIENCE_ERROR", 2, 13030);
        InlineAI_INPUT_COMPLIENCE_ERROR = r102;
        InlineAIErrorCode r103 = new InlineAIErrorCode("InlineAI_OUTPUT_COMPLIENCE_ERROR", 3, 13031);
        InlineAI_OUTPUT_COMPLIENCE_ERROR = r103;
        InlineAIErrorCode r104 = new InlineAIErrorCode("InlineAI_CROSS_REGION_ERROR", 4, 13020);
        InlineAI_CROSS_REGION_ERROR = r104;
        InlineAIErrorCode r105 = new InlineAIErrorCode("InlineAI_CROSS_BRAND_ERROR", 5, 13021);
        InlineAI_CROSS_BRAND_ERROR = r105;
        InlineAIErrorCode r110 = new InlineAIErrorCode("InlineAI_NOPERMISSION_CODE", 6, 4);
        InlineAI_NOPERMISSION_CODE = r110;
        InlineAIErrorCode[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f426801a = r111;
        f426802b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static InlineAIErrorCode[] values() {
        return (InlineAIErrorCode[]) f426801a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static InlineAIErrorCode valueOf(String r100) {
        return (InlineAIErrorCode) r27.a.a(InlineAIErrorCode.class, r100);
    }

    public InlineAIErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
