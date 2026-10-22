package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AdvancedVoiceFinishReason[] f230538a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f230539b = null;
    private final boolean shouldCancelActiveGesture;

    public static EnumEntries<AdvancedVoiceFinishReason> getEntries() {
        return f230539b;
    }

    static {
        AdvancedVoiceFinishReason r100 = new AdvancedVoiceFinishReason("SHORT_CLICK", 0, false);
        SHORT_CLICK = r100;
        AdvancedVoiceFinishReason r101 = new AdvancedVoiceFinishReason("FINAL", 1, false);
        FINAL = r101;
        AdvancedVoiceFinishReason r102 = new AdvancedVoiceFinishReason("EMPTY_FINAL", 2, false);
        EMPTY_FINAL = r102;
        AdvancedVoiceFinishReason r103 = new AdvancedVoiceFinishReason("RECORD_TOO_SHORT", 3, false);
        RECORD_TOO_SHORT = r103;
        AdvancedVoiceFinishReason r104 = new AdvancedVoiceFinishReason("CANCEL", 4, true);
        CANCEL = r104;
        AdvancedVoiceFinishReason r105 = new AdvancedVoiceFinishReason("FAILURE", 5, true);
        FAILURE = r105;
        AdvancedVoiceFinishReason r110 = new AdvancedVoiceFinishReason("DISMISS", 6, true);
        DISMISS = r110;
        AdvancedVoiceFinishReason r111 = new AdvancedVoiceFinishReason("DESTROY", 7, true);
        DESTROY = r111;
        AdvancedVoiceFinishReason r112 = new AdvancedVoiceFinishReason("REPLACED", 8, true);
        REPLACED = r112;
        AdvancedVoiceFinishReason[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f230538a = r113;
        f230539b = EnumEntriesKt.enumEntries(r113);
    }

    public static AdvancedVoiceFinishReason[] values() {
        return (AdvancedVoiceFinishReason[]) f230538a.clone();
    }

    public final boolean getShouldCancelActiveGesture() {
        return this.shouldCancelActiveGesture;
    }

    public static AdvancedVoiceFinishReason valueOf(String r100) {
        return (AdvancedVoiceFinishReason) r27.a.a(AdvancedVoiceFinishReason.class, r100);
    }

    public AdvancedVoiceFinishReason(String r100, int r101, boolean r102) {
        super(r100, r101);
        this.shouldCancelActiveGesture = r102;
    }
}
