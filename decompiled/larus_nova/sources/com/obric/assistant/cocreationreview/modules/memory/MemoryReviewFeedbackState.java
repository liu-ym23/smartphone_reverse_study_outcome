package com.obric.assistant.cocreationreview.modules.memory;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/memory/MemoryReviewFeedbackState;", "", TemplateNodeType.RAW, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "PENDING", "SUBMITTED", "SUBMITTING", "FAILED", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MemoryReviewFeedbackState extends Enum<MemoryReviewFeedbackState> {
    public static final a Companion = null;
    public static final MemoryReviewFeedbackState FAILED = null;
    public static final MemoryReviewFeedbackState PENDING = null;
    public static final MemoryReviewFeedbackState SUBMITTED = null;
    public static final MemoryReviewFeedbackState SUBMITTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MemoryReviewFeedbackState[] f387403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387404b = null;
    private final String raw;

    public static final class a {
        public a() {
        }

        public static MemoryReviewFeedbackState a(String r100) {
            MemoryReviewFeedbackState[] r101 = MemoryReviewFeedbackState.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            MemoryReviewFeedbackState r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getRaw(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return MemoryReviewFeedbackState.PENDING;
        L8:
            r104 = null;
            goto L9
        }
    }

    public static EnumEntries<MemoryReviewFeedbackState> getEntries() {
        return f387404b;
    }

    static {
        MemoryReviewFeedbackState r100 = new MemoryReviewFeedbackState("PENDING", 0, AiBotPollingAuthResult.STATUS_PENDING);
        PENDING = r100;
        MemoryReviewFeedbackState r101 = new MemoryReviewFeedbackState("SUBMITTED", 1, "submitted");
        SUBMITTED = r101;
        MemoryReviewFeedbackState r102 = new MemoryReviewFeedbackState("SUBMITTING", 2, "submitting");
        SUBMITTING = r102;
        MemoryReviewFeedbackState r103 = new MemoryReviewFeedbackState("FAILED", 3, "failed");
        FAILED = r103;
        MemoryReviewFeedbackState[] r104 = {r100, r101, r102, r103};
        f387403a = r104;
        f387404b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static MemoryReviewFeedbackState[] values() {
        return (MemoryReviewFeedbackState[]) f387403a.clone();
    }

    public final String getRaw() {
        return this.raw;
    }

    public static MemoryReviewFeedbackState valueOf(String r100) {
        return (MemoryReviewFeedbackState) r27.a.a(MemoryReviewFeedbackState.class, r100);
    }

    public MemoryReviewFeedbackState(String r100, int r101, String r102) {
        super(r100, r101);
        this.raw = r102;
    }
}
