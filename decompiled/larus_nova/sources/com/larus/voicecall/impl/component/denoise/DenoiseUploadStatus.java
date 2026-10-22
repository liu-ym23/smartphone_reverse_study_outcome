package com.larus.voicecall.impl.component.denoise;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/voicecall/impl/component/denoise/DenoiseUploadStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AuthorizedAndEnabled", "Enable", "Close", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DenoiseUploadStatus extends Enum<DenoiseUploadStatus> {
    public static final DenoiseUploadStatus AuthorizedAndEnabled = null;
    public static final DenoiseUploadStatus Close = null;
    public static final DenoiseUploadStatus Enable = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DenoiseUploadStatus[] f377358a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f377359b = null;
    private final int value;

    public static EnumEntries<DenoiseUploadStatus> getEntries() {
        return f377359b;
    }

    static {
        DenoiseUploadStatus r100 = new DenoiseUploadStatus("AuthorizedAndEnabled", 0, 1);
        AuthorizedAndEnabled = r100;
        DenoiseUploadStatus r101 = new DenoiseUploadStatus("Enable", 1, 2);
        Enable = r101;
        DenoiseUploadStatus r102 = new DenoiseUploadStatus("Close", 2, 3);
        Close = r102;
        DenoiseUploadStatus[] r103 = {r100, r101, r102};
        f377358a = r103;
        f377359b = EnumEntriesKt.enumEntries(r103);
    }

    public static DenoiseUploadStatus[] values() {
        return (DenoiseUploadStatus[]) f377358a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DenoiseUploadStatus valueOf(String r100) {
        return (DenoiseUploadStatus) r27.a.a(DenoiseUploadStatus.class, r100);
    }

    public DenoiseUploadStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
