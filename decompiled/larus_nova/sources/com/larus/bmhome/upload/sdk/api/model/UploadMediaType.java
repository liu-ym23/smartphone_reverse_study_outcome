package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/UploadMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "FILE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadMediaType extends Enum<UploadMediaType> {
    public static final UploadMediaType FILE = null;
    public static final UploadMediaType IMAGE = null;
    public static final UploadMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UploadMediaType[] f314824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314825b = null;

    public static EnumEntries<UploadMediaType> getEntries() {
        return f314825b;
    }

    static {
        UploadMediaType r100 = new UploadMediaType("IMAGE", 0);
        IMAGE = r100;
        UploadMediaType r101 = new UploadMediaType("VIDEO", 1);
        VIDEO = r101;
        UploadMediaType r102 = new UploadMediaType("FILE", 2);
        FILE = r102;
        UploadMediaType[] r103 = {r100, r101, r102};
        f314824a = r103;
        f314825b = EnumEntriesKt.enumEntries(r103);
    }

    public static UploadMediaType[] values() {
        return (UploadMediaType[]) f314824a.clone();
    }

    public static UploadMediaType valueOf(String r100) {
        return (UploadMediaType) a.a(UploadMediaType.class, r100);
    }

    public UploadMediaType(String r100, int r101) {
        super(r100, r101);
    }
}
