package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/UploadEngineType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "FILE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadEngineType extends Enum<UploadEngineType> {
    public static final UploadEngineType FILE = null;
    public static final UploadEngineType IMAGE = null;
    public static final UploadEngineType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UploadEngineType[] f314822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314823b = null;

    public static EnumEntries<UploadEngineType> getEntries() {
        return f314823b;
    }

    static {
        UploadEngineType r100 = new UploadEngineType("IMAGE", 0);
        IMAGE = r100;
        UploadEngineType r101 = new UploadEngineType("VIDEO", 1);
        VIDEO = r101;
        UploadEngineType r102 = new UploadEngineType("FILE", 2);
        FILE = r102;
        UploadEngineType[] r103 = {r100, r101, r102};
        f314822a = r103;
        f314823b = EnumEntriesKt.enumEntries(r103);
    }

    public static UploadEngineType[] values() {
        return (UploadEngineType[]) f314822a.clone();
    }

    public static UploadEngineType valueOf(String r100) {
        return (UploadEngineType) a.a(UploadEngineType.class, r100);
    }

    public UploadEngineType(String r100, int r101) {
        super(r100, r101);
    }
}
