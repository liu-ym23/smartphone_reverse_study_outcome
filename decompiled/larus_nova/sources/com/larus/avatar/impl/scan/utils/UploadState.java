package com.larus.avatar.impl.scan.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/avatar/impl/scan/utils/UploadState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "UPLOADING", "SUCCESS", "FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadState extends Enum<UploadState> {
    public static final UploadState FAIL = null;
    public static final UploadState IDLE = null;
    public static final UploadState SUCCESS = null;
    public static final UploadState UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UploadState[] f291131a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291132b = null;

    public static EnumEntries<UploadState> getEntries() {
        return f291132b;
    }

    static {
        UploadState r100 = new UploadState("IDLE", 0);
        IDLE = r100;
        UploadState r101 = new UploadState("UPLOADING", 1);
        UPLOADING = r101;
        UploadState r102 = new UploadState("SUCCESS", 2);
        SUCCESS = r102;
        UploadState r103 = new UploadState("FAIL", 3);
        FAIL = r103;
        UploadState[] r104 = {r100, r101, r102, r103};
        f291131a = r104;
        f291132b = EnumEntriesKt.enumEntries(r104);
    }

    public static UploadState[] values() {
        return (UploadState[]) f291131a.clone();
    }

    public static UploadState valueOf(String r100) {
        return (UploadState) r27.a.a(UploadState.class, r100);
    }

    public UploadState(String r100, int r101) {
        super(r100, r101);
    }
}
