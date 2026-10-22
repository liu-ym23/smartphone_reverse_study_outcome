package com.enroll.audio.enroll.model;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/enroll/audio/enroll/model/TipsCode;", "", BaseSwitches.V, "", "<init>", "(Ljava/lang/String;II)V", "getV", "()I", "TIPS_CODE_CHECKING_ENROLL", "TIPS_CODE_SAY_it", "TIPS_CODE_FASTER_SAY_it", "TIPS_CODE_CHECK_SENTENCE_ERROR", "TIPS_CODE_ERROR_EDIT_VOICE", "TIPS_CODE_ERROR_TEXT_SIMILARITY", "TIPS_CODE_CHECK_SENTENCE_NETWORK", "TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE", "TIPS_CODE_ASR_TASK_START_FAILED", "TIPS_CODE_ASR_SESSION_START_FAILED", "TIPS_CODE_ASR_NETWORK_ERROR", "TIPS_CODE_ASR_TIMEOUT_RETRY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TipsCode extends Enum<TipsCode> {
    public static final TipsCode TIPS_CODE_ASR_NETWORK_ERROR = null;
    public static final TipsCode TIPS_CODE_ASR_SESSION_START_FAILED = null;
    public static final TipsCode TIPS_CODE_ASR_TASK_START_FAILED = null;
    public static final TipsCode TIPS_CODE_ASR_TIMEOUT_RETRY = null;
    public static final TipsCode TIPS_CODE_CHECKING_ENROLL = null;
    public static final TipsCode TIPS_CODE_CHECK_SENTENCE_ERROR = null;
    public static final TipsCode TIPS_CODE_CHECK_SENTENCE_NETWORK = null;
    public static final TipsCode TIPS_CODE_ERROR_EDIT_VOICE = null;
    public static final TipsCode TIPS_CODE_ERROR_TEXT_SIMILARITY = null;
    public static final TipsCode TIPS_CODE_FASTER_SAY_it = null;
    public static final TipsCode TIPS_CODE_SAY_it = null;
    public static final TipsCode TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TipsCode[] f273737a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f273738b = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f273739v;

    public static EnumEntries<TipsCode> getEntries() {
        return f273738b;
    }

    static {
        TipsCode r100 = new TipsCode("TIPS_CODE_CHECKING_ENROLL", 0, 1);
        TIPS_CODE_CHECKING_ENROLL = r100;
        TipsCode r101 = new TipsCode("TIPS_CODE_SAY_it", 1, 0);
        TIPS_CODE_SAY_it = r101;
        TipsCode r102 = new TipsCode("TIPS_CODE_FASTER_SAY_it", 2, 2);
        TIPS_CODE_FASTER_SAY_it = r102;
        TipsCode r103 = new TipsCode("TIPS_CODE_CHECK_SENTENCE_ERROR", 3, -2);
        TIPS_CODE_CHECK_SENTENCE_ERROR = r103;
        TipsCode r104 = new TipsCode("TIPS_CODE_ERROR_EDIT_VOICE", 4, -4);
        TIPS_CODE_ERROR_EDIT_VOICE = r104;
        TipsCode r105 = new TipsCode("TIPS_CODE_ERROR_TEXT_SIMILARITY", 5, -5);
        TIPS_CODE_ERROR_TEXT_SIMILARITY = r105;
        TipsCode r110 = new TipsCode("TIPS_CODE_CHECK_SENTENCE_NETWORK", 6, -6);
        TIPS_CODE_CHECK_SENTENCE_NETWORK = r110;
        TipsCode r111 = new TipsCode("TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE", 7, -7);
        TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE = r111;
        TipsCode r112 = new TipsCode("TIPS_CODE_ASR_TASK_START_FAILED", 8, -8);
        TIPS_CODE_ASR_TASK_START_FAILED = r112;
        TipsCode r113 = new TipsCode("TIPS_CODE_ASR_SESSION_START_FAILED", 9, -9);
        TIPS_CODE_ASR_SESSION_START_FAILED = r113;
        TipsCode r114 = new TipsCode("TIPS_CODE_ASR_NETWORK_ERROR", 10, -10);
        TIPS_CODE_ASR_NETWORK_ERROR = r114;
        TipsCode r106 = new TipsCode("TIPS_CODE_ASR_TIMEOUT_RETRY", 11, -11);
        TIPS_CODE_ASR_TIMEOUT_RETRY = r106;
        TipsCode[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
        f273737a = r107;
        f273738b = EnumEntriesKt.enumEntries(r107);
    }

    public static TipsCode[] values() {
        return (TipsCode[]) f273737a.clone();
    }

    public final int getV() {
        return this.f273739v;
    }

    public static TipsCode valueOf(String r100) {
        return (TipsCode) a.a(TipsCode.class, r100);
    }

    public TipsCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.f273739v = r102;
    }
}
