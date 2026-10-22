package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/im/bean/message/block/QuickReplyReviewStatus;", "", "value", "", "isEnabled", "", "<init>", "(Ljava/lang/String;IIZ)V", "getValue", "()I", "()Z", "REVIEW_STATUS_DEFAULT", "REVIEW_STATUS_PENDING", "REVIEW_STATUS_PASS", "REVIEW_STATUS_REJECT", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickReplyReviewStatus extends Enum<QuickReplyReviewStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ QuickReplyReviewStatus[] $VALUES = null;
    public static final a Companion = null;
    public static final QuickReplyReviewStatus REVIEW_STATUS_DEFAULT = null;
    public static final QuickReplyReviewStatus REVIEW_STATUS_PASS = null;
    public static final QuickReplyReviewStatus REVIEW_STATUS_PENDING = null;
    public static final QuickReplyReviewStatus REVIEW_STATUS_REJECT = null;
    private final boolean isEnabled;
    private final int value;

    private static final /* synthetic */ QuickReplyReviewStatus[] $values() {
        return new QuickReplyReviewStatus[]{REVIEW_STATUS_DEFAULT, REVIEW_STATUS_PENDING, REVIEW_STATUS_PASS, REVIEW_STATUS_REJECT};
    }

    public static EnumEntries<QuickReplyReviewStatus> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.im.bean.message.block.QuickReplyReviewStatus$a] */
    static {
        REVIEW_STATUS_DEFAULT = new QuickReplyReviewStatus("REVIEW_STATUS_DEFAULT", 0, 0, true);
        REVIEW_STATUS_PENDING = new QuickReplyReviewStatus("REVIEW_STATUS_PENDING", 1, 1, false);
        REVIEW_STATUS_PASS = new QuickReplyReviewStatus("REVIEW_STATUS_PASS", 2, 2, true);
        REVIEW_STATUS_REJECT = new QuickReplyReviewStatus("REVIEW_STATUS_REJECT", 3, 3, false);
        QuickReplyReviewStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static QuickReplyReviewStatus[] values() {
        return (QuickReplyReviewStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public static QuickReplyReviewStatus valueOf(String r100) {
        return (QuickReplyReviewStatus) r27.a.a(QuickReplyReviewStatus.class, r100);
    }

    private QuickReplyReviewStatus(String r100, int r101, int r102, boolean r103) {
        super(r100, r101);
        this.value = r102;
        this.isEnabled = r103;
    }
}
