package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/unified/AdvancedVoiceFinishReason;", "", "shouldCancelActiveGesture", "", "<init>", "(Ljava/lang/String;IZ)V", "getShouldCancelActiveGesture", "()Z", "SHORT_CLICK", "FINAL", "EMPTY_FINAL", "RECORD_TOO_SHORT", "CANCEL", "FAILURE", "DISMISS", "DESTROY", "REPLACED", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AdvancedVoiceFinishReason extends Enum<AdvancedVoiceFinishReason> {
    public static final AdvancedVoiceFinishReason CANCEL = null;
    public static final AdvancedVoiceFinishReason DESTROY = null;
    public static final AdvancedVoiceFinishReason DISMISS = null;
    public static final AdvancedVoiceFinishReason EMPTY_FINAL = null;
    public static final AdvancedVoiceFinishReason FAILURE = null;
    public static final AdvancedVoiceFinishReason FINAL = null;
    public static final AdvancedVoiceFinishReason RECORD_TOO_SHORT = null;
    public static final AdvancedVoiceFinishReason REPLACED = null;
    public static final AdvancedVoiceFinishReason SHORT_CLICK = null;
    public static final /* synthetic */ AdvancedVoiceFinishReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final boolean shouldCancelActiveGesture;

    public static EnumEntries<AdvancedVoiceFinishReason> getEntries() {
        return b;
    }

    static {
        AdvancedVoiceFinishReason r0 = new AdvancedVoiceFinishReason("SHORT_CLICK", 0, false);
        SHORT_CLICK = r0;
        AdvancedVoiceFinishReason r1 = new AdvancedVoiceFinishReason("FINAL", 1, false);
        FINAL = r1;
        AdvancedVoiceFinishReason r3 = new AdvancedVoiceFinishReason("EMPTY_FINAL", 2, false);
        EMPTY_FINAL = r3;
        AdvancedVoiceFinishReason r5 = new AdvancedVoiceFinishReason("RECORD_TOO_SHORT", 3, false);
        RECORD_TOO_SHORT = r5;
        AdvancedVoiceFinishReason r7 = new AdvancedVoiceFinishReason("CANCEL", 4, true);
        CANCEL = r7;
        AdvancedVoiceFinishReason r9 = new AdvancedVoiceFinishReason("FAILURE", 5, true);
        FAILURE = r9;
        AdvancedVoiceFinishReason r11 = new AdvancedVoiceFinishReason("DISMISS", 6, true);
        DISMISS = r11;
        AdvancedVoiceFinishReason r13 = new AdvancedVoiceFinishReason("DESTROY", 7, true);
        DESTROY = r13;
        AdvancedVoiceFinishReason r15 = new AdvancedVoiceFinishReason("REPLACED", 8, true);
        REPLACED = r15;
        AdvancedVoiceFinishReason[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static AdvancedVoiceFinishReason[] values() {
        return (AdvancedVoiceFinishReason[]) a.clone();
    }

    public final boolean getShouldCancelActiveGesture() {
        return this.shouldCancelActiveGesture;
    }

    public static AdvancedVoiceFinishReason valueOf(String r1) {
        return (AdvancedVoiceFinishReason) r27.a.a(AdvancedVoiceFinishReason.class, r1);
    }

    public AdvancedVoiceFinishReason(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.shouldCancelActiveGesture = r3;
    }
}
