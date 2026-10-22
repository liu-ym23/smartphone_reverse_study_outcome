package com.larus.kmp.voice_setting.voice.dialog.v2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/dialog/v2/UgcVoiceCreatePageStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NORMAL_STATUS", "RECODING_STATUS", "VERIFY_STATUS", "FAIL_STATUS", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UgcVoiceCreatePageStatus extends Enum<UgcVoiceCreatePageStatus> {
    public static final UgcVoiceCreatePageStatus FAIL_STATUS = null;
    public static final UgcVoiceCreatePageStatus NORMAL_STATUS = null;
    public static final UgcVoiceCreatePageStatus RECODING_STATUS = null;
    public static final UgcVoiceCreatePageStatus VERIFY_STATUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UgcVoiceCreatePageStatus[] f352999a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353000b = null;
    private final String value;

    public static EnumEntries<UgcVoiceCreatePageStatus> getEntries() {
        return f353000b;
    }

    static {
        UgcVoiceCreatePageStatus r100 = new UgcVoiceCreatePageStatus("NORMAL_STATUS", 0, "normal");
        NORMAL_STATUS = r100;
        UgcVoiceCreatePageStatus r101 = new UgcVoiceCreatePageStatus("RECODING_STATUS", 1, "recording");
        RECODING_STATUS = r101;
        UgcVoiceCreatePageStatus r102 = new UgcVoiceCreatePageStatus("VERIFY_STATUS", 2, "verify");
        VERIFY_STATUS = r102;
        UgcVoiceCreatePageStatus r103 = new UgcVoiceCreatePageStatus("FAIL_STATUS", 3, "fail");
        FAIL_STATUS = r103;
        UgcVoiceCreatePageStatus[] r104 = {r100, r101, r102, r103};
        f352999a = r104;
        f353000b = EnumEntriesKt.enumEntries(r104);
    }

    public static UgcVoiceCreatePageStatus[] values() {
        return (UgcVoiceCreatePageStatus[]) f352999a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static UgcVoiceCreatePageStatus valueOf(String r100) {
        return (UgcVoiceCreatePageStatus) r27.a.a(UgcVoiceCreatePageStatus.class, r100);
    }

    public UgcVoiceCreatePageStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
