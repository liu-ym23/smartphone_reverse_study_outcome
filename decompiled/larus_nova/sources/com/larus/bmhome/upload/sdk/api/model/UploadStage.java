package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/UploadStage;", "", "<init>", "(Ljava/lang/String;I)V", "CREATED", "PREPROCESSING", "CREDENTIAL_PREPARING", "UPLOADING", "REGISTERING", "SUCCESS", "FAILED", "CANCELLED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadStage extends Enum<UploadStage> {
    public static final UploadStage CANCELLED = null;
    public static final UploadStage CREATED = null;
    public static final UploadStage CREDENTIAL_PREPARING = null;
    public static final UploadStage FAILED = null;
    public static final UploadStage PREPROCESSING = null;
    public static final UploadStage REGISTERING = null;
    public static final UploadStage SUCCESS = null;
    public static final UploadStage UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UploadStage[] f314828a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314829b = null;

    public static EnumEntries<UploadStage> getEntries() {
        return f314829b;
    }

    static {
        UploadStage r100 = new UploadStage("CREATED", 0);
        CREATED = r100;
        UploadStage r101 = new UploadStage("PREPROCESSING", 1);
        PREPROCESSING = r101;
        UploadStage r102 = new UploadStage("CREDENTIAL_PREPARING", 2);
        CREDENTIAL_PREPARING = r102;
        UploadStage r103 = new UploadStage("UPLOADING", 3);
        UPLOADING = r103;
        UploadStage r104 = new UploadStage("REGISTERING", 4);
        REGISTERING = r104;
        UploadStage r105 = new UploadStage("SUCCESS", 5);
        SUCCESS = r105;
        UploadStage r110 = new UploadStage("FAILED", 6);
        FAILED = r110;
        UploadStage r111 = new UploadStage("CANCELLED", 7);
        CANCELLED = r111;
        UploadStage[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f314828a = r112;
        f314829b = EnumEntriesKt.enumEntries(r112);
    }

    public static UploadStage[] values() {
        return (UploadStage[]) f314828a.clone();
    }

    public static UploadStage valueOf(String r100) {
        return (UploadStage) a.a(UploadStage.class, r100);
    }

    public UploadStage(String r100, int r101) {
        super(r100, r101);
    }
}
