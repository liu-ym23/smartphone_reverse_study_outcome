package com.larus.im.bean.message.block;

import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/bean/message/block/AudioRecordErrorCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_ERROR", CJPayFingerprintConstants.ERROR_AUTH_FAILED_MSG, "ERROR_AUTH_FINISHED", "ERROR_START_FAILED_IN_SAME_DEVICE", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioRecordErrorCode extends Enum<AudioRecordErrorCode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AudioRecordErrorCode[] $VALUES = null;
    public static final AudioRecordErrorCode ERROR_AUTH_FAILED = null;
    public static final AudioRecordErrorCode ERROR_AUTH_FINISHED = null;
    public static final AudioRecordErrorCode ERROR_START_FAILED_IN_SAME_DEVICE = null;
    public static final AudioRecordErrorCode NO_ERROR = null;
    private final int value;

    private static final /* synthetic */ AudioRecordErrorCode[] $values() {
        return new AudioRecordErrorCode[]{NO_ERROR, ERROR_AUTH_FAILED, ERROR_AUTH_FINISHED, ERROR_START_FAILED_IN_SAME_DEVICE};
    }

    public static EnumEntries<AudioRecordErrorCode> getEntries() {
        return $ENTRIES;
    }

    static {
        NO_ERROR = new AudioRecordErrorCode("NO_ERROR", 0, 0);
        ERROR_AUTH_FAILED = new AudioRecordErrorCode(CJPayFingerprintConstants.ERROR_AUTH_FAILED_MSG, 1, 1);
        ERROR_AUTH_FINISHED = new AudioRecordErrorCode("ERROR_AUTH_FINISHED", 2, 2);
        ERROR_START_FAILED_IN_SAME_DEVICE = new AudioRecordErrorCode("ERROR_START_FAILED_IN_SAME_DEVICE", 3, 3);
        AudioRecordErrorCode[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static AudioRecordErrorCode[] values() {
        return (AudioRecordErrorCode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AudioRecordErrorCode valueOf(String r100) {
        return (AudioRecordErrorCode) a.a(AudioRecordErrorCode.class, r100);
    }

    private AudioRecordErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
