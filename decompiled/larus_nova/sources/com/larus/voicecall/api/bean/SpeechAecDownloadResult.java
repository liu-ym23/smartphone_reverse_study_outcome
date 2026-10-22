package com.larus.voicecall.api.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/voicecall/api/bean/SpeechAecDownloadResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "DOWNLOAD_FAILED", "UNZIP_FAILED", "META_LOAD_FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SpeechAecDownloadResult extends Enum<SpeechAecDownloadResult> {
    public static final SpeechAecDownloadResult DOWNLOAD_FAILED = null;
    public static final SpeechAecDownloadResult META_LOAD_FAILED = null;
    public static final SpeechAecDownloadResult SUCCESS = null;
    public static final SpeechAecDownloadResult UNZIP_FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SpeechAecDownloadResult[] f377093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f377094b = null;
    private final int value;

    public static EnumEntries<SpeechAecDownloadResult> getEntries() {
        return f377094b;
    }

    static {
        SpeechAecDownloadResult r100 = new SpeechAecDownloadResult("SUCCESS", 0, 0);
        SUCCESS = r100;
        SpeechAecDownloadResult r101 = new SpeechAecDownloadResult("DOWNLOAD_FAILED", 1, 1);
        DOWNLOAD_FAILED = r101;
        SpeechAecDownloadResult r102 = new SpeechAecDownloadResult("UNZIP_FAILED", 2, 2);
        UNZIP_FAILED = r102;
        SpeechAecDownloadResult r103 = new SpeechAecDownloadResult("META_LOAD_FAILED", 3, 3);
        META_LOAD_FAILED = r103;
        SpeechAecDownloadResult[] r104 = {r100, r101, r102, r103};
        f377093a = r104;
        f377094b = EnumEntriesKt.enumEntries(r104);
    }

    public static SpeechAecDownloadResult[] values() {
        return (SpeechAecDownloadResult[]) f377093a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SpeechAecDownloadResult valueOf(String r100) {
        return (SpeechAecDownloadResult) a.a(SpeechAecDownloadResult.class, r100);
    }

    public SpeechAecDownloadResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
