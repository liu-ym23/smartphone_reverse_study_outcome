package com.larus.kmp.voice_setting.voice.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/VoiceRowUploadState;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "UPLOADING", "FAIL", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceRowUploadState extends Enum<VoiceRowUploadState> {
    public static final VoiceRowUploadState FAIL = null;
    public static final VoiceRowUploadState SUCCESS = null;
    public static final VoiceRowUploadState UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceRowUploadState[] f353415a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353416b = null;

    public static EnumEntries<VoiceRowUploadState> getEntries() {
        return f353416b;
    }

    static {
        VoiceRowUploadState r100 = new VoiceRowUploadState("SUCCESS", 0);
        SUCCESS = r100;
        VoiceRowUploadState r101 = new VoiceRowUploadState("UPLOADING", 1);
        UPLOADING = r101;
        VoiceRowUploadState r102 = new VoiceRowUploadState("FAIL", 2);
        FAIL = r102;
        VoiceRowUploadState[] r103 = {r100, r101, r102};
        f353415a = r103;
        f353416b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceRowUploadState[] values() {
        return (VoiceRowUploadState[]) f353415a.clone();
    }

    public static VoiceRowUploadState valueOf(String r100) {
        return (VoiceRowUploadState) a.a(VoiceRowUploadState.class, r100);
    }

    public VoiceRowUploadState(String r100, int r101) {
        super(r100, r101);
    }
}
