package com.larus.audio.call.aec;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/audio/call/aec/AecConsumeResult;", "", "message", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "EMPTY_QUEUE", "EMPTY_QUEUE_EXCEPT_FLAG", "SENTENCE_END", "SENTENCE_END_NOVALID", "SENTENCE_PART", "SENTENCE_END_MORE_SENTENCE", "AHEAD_OF_SENTENCE", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AecConsumeResult extends Enum<AecConsumeResult> {
    public static final AecConsumeResult AHEAD_OF_SENTENCE = null;
    public static final AecConsumeResult EMPTY_QUEUE = null;
    public static final AecConsumeResult EMPTY_QUEUE_EXCEPT_FLAG = null;
    public static final AecConsumeResult SENTENCE_END = null;
    public static final AecConsumeResult SENTENCE_END_MORE_SENTENCE = null;
    public static final AecConsumeResult SENTENCE_END_NOVALID = null;
    public static final AecConsumeResult SENTENCE_PART = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AecConsumeResult[] f288942a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288943b = null;
    private final String message;

    public static EnumEntries<AecConsumeResult> getEntries() {
        return f288943b;
    }

    static {
        AecConsumeResult r100 = new AecConsumeResult("EMPTY_QUEUE", 0, "empty");
        EMPTY_QUEUE = r100;
        AecConsumeResult r101 = new AecConsumeResult("EMPTY_QUEUE_EXCEPT_FLAG", 1, "empty_except_flag");
        EMPTY_QUEUE_EXCEPT_FLAG = r101;
        AecConsumeResult r102 = new AecConsumeResult("SENTENCE_END", 2, "sentence_end");
        SENTENCE_END = r102;
        AecConsumeResult r103 = new AecConsumeResult("SENTENCE_END_NOVALID", 3, "sentence_end_error");
        SENTENCE_END_NOVALID = r103;
        AecConsumeResult r104 = new AecConsumeResult("SENTENCE_PART", 4, "sentence_part");
        SENTENCE_PART = r104;
        AecConsumeResult r105 = new AecConsumeResult("SENTENCE_END_MORE_SENTENCE", 5, "sentence_end_more_ref");
        SENTENCE_END_MORE_SENTENCE = r105;
        AecConsumeResult r110 = new AecConsumeResult("AHEAD_OF_SENTENCE", 6, "ahead_of_sentence");
        AHEAD_OF_SENTENCE = r110;
        AecConsumeResult[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f288942a = r111;
        f288943b = EnumEntriesKt.enumEntries(r111);
    }

    public static AecConsumeResult[] values() {
        return (AecConsumeResult[]) f288942a.clone();
    }

    public final String getMessage() {
        return this.message;
    }

    public static AecConsumeResult valueOf(String r100) {
        return (AecConsumeResult) r27.a.a(AecConsumeResult.class, r100);
    }

    public AecConsumeResult(String r100, int r101, String r102) {
        super(r100, r101);
        this.message = r102;
    }
}
