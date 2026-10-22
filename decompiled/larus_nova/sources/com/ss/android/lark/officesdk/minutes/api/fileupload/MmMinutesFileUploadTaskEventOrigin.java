package com.ss.android.lark.officesdk.minutes.api.fileupload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/fileupload/MmMinutesFileUploadTaskEventOrigin;", "", "<init>", "(Ljava/lang/String;I)V", "CREATED", "RESTORED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmMinutesFileUploadTaskEventOrigin extends Enum<MmMinutesFileUploadTaskEventOrigin> {
    public static final MmMinutesFileUploadTaskEventOrigin CREATED = null;
    public static final MmMinutesFileUploadTaskEventOrigin RESTORED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmMinutesFileUploadTaskEventOrigin[] f433480a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433481b = null;

    public static EnumEntries<MmMinutesFileUploadTaskEventOrigin> getEntries() {
        return f433481b;
    }

    static {
        MmMinutesFileUploadTaskEventOrigin r100 = new MmMinutesFileUploadTaskEventOrigin("CREATED", 0);
        CREATED = r100;
        MmMinutesFileUploadTaskEventOrigin r101 = new MmMinutesFileUploadTaskEventOrigin("RESTORED", 1);
        RESTORED = r101;
        MmMinutesFileUploadTaskEventOrigin[] r102 = {r100, r101};
        f433480a = r102;
        f433481b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmMinutesFileUploadTaskEventOrigin[] values() {
        return (MmMinutesFileUploadTaskEventOrigin[]) f433480a.clone();
    }

    public static MmMinutesFileUploadTaskEventOrigin valueOf(String r100) {
        return (MmMinutesFileUploadTaskEventOrigin) a.a(MmMinutesFileUploadTaskEventOrigin.class, r100);
    }

    public MmMinutesFileUploadTaskEventOrigin(String r100, int r101) {
        super(r100, r101);
    }
}
