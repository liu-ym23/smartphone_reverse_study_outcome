package com.obric.assistant.cocreationreview.modules.memory;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/memory/MemoryReviewAudioTranscriptCode;", "", "<init>", "(Ljava/lang/String;I)V", "OK", "EMPTY", "NOT_FOUND", "INVALID_CURSOR", "STALE_CURSOR", "TOO_LARGE", "INTERNAL_ERROR", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MemoryReviewAudioTranscriptCode extends Enum<MemoryReviewAudioTranscriptCode> {
    public static final a Companion = null;
    public static final MemoryReviewAudioTranscriptCode EMPTY = null;
    public static final MemoryReviewAudioTranscriptCode INTERNAL_ERROR = null;
    public static final MemoryReviewAudioTranscriptCode INVALID_CURSOR = null;
    public static final MemoryReviewAudioTranscriptCode NOT_FOUND = null;
    public static final MemoryReviewAudioTranscriptCode OK = null;
    public static final MemoryReviewAudioTranscriptCode STALE_CURSOR = null;
    public static final MemoryReviewAudioTranscriptCode TOO_LARGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MemoryReviewAudioTranscriptCode[] f387399a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387400b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MemoryReviewAudioTranscriptCode> getEntries() {
        return f387400b;
    }

    static {
        MemoryReviewAudioTranscriptCode r100 = new MemoryReviewAudioTranscriptCode("OK", 0);
        OK = r100;
        MemoryReviewAudioTranscriptCode r101 = new MemoryReviewAudioTranscriptCode("EMPTY", 1);
        EMPTY = r101;
        MemoryReviewAudioTranscriptCode r102 = new MemoryReviewAudioTranscriptCode("NOT_FOUND", 2);
        NOT_FOUND = r102;
        MemoryReviewAudioTranscriptCode r103 = new MemoryReviewAudioTranscriptCode("INVALID_CURSOR", 3);
        INVALID_CURSOR = r103;
        MemoryReviewAudioTranscriptCode r104 = new MemoryReviewAudioTranscriptCode("STALE_CURSOR", 4);
        STALE_CURSOR = r104;
        MemoryReviewAudioTranscriptCode r105 = new MemoryReviewAudioTranscriptCode("TOO_LARGE", 5);
        TOO_LARGE = r105;
        MemoryReviewAudioTranscriptCode r110 = new MemoryReviewAudioTranscriptCode("INTERNAL_ERROR", 6);
        INTERNAL_ERROR = r110;
        MemoryReviewAudioTranscriptCode[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f387399a = r111;
        f387400b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static MemoryReviewAudioTranscriptCode[] values() {
        return (MemoryReviewAudioTranscriptCode[]) f387399a.clone();
    }

    public static MemoryReviewAudioTranscriptCode valueOf(String r100) {
        return (MemoryReviewAudioTranscriptCode) r27.a.a(MemoryReviewAudioTranscriptCode.class, r100);
    }

    public MemoryReviewAudioTranscriptCode(String r100, int r101) {
        super(r100, r101);
    }
}
