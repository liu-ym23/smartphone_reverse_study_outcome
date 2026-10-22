package com.ss.android.lark.officesdk.minutes.api.fileupload.depend;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/fileupload/depend/RecordingDownloadType;", "", "<init>", "(Ljava/lang/String;I)V", "Origin", "Cover", "Preview", "Image", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordingDownloadType extends Enum<RecordingDownloadType> {
    public static final RecordingDownloadType Cover = null;
    public static final RecordingDownloadType Image = null;
    public static final RecordingDownloadType Origin = null;
    public static final RecordingDownloadType Preview = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordingDownloadType[] f433484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433485b = null;

    public static EnumEntries<RecordingDownloadType> getEntries() {
        return f433485b;
    }

    static {
        RecordingDownloadType r100 = new RecordingDownloadType("Origin", 0);
        Origin = r100;
        RecordingDownloadType r101 = new RecordingDownloadType("Cover", 1);
        Cover = r101;
        RecordingDownloadType r102 = new RecordingDownloadType("Preview", 2);
        Preview = r102;
        RecordingDownloadType r103 = new RecordingDownloadType("Image", 3);
        Image = r103;
        RecordingDownloadType[] r104 = {r100, r101, r102, r103};
        f433484a = r104;
        f433485b = EnumEntriesKt.enumEntries(r104);
    }

    public static RecordingDownloadType[] values() {
        return (RecordingDownloadType[]) f433484a.clone();
    }

    public static RecordingDownloadType valueOf(String r100) {
        return (RecordingDownloadType) a.a(RecordingDownloadType.class, r100);
    }

    public RecordingDownloadType(String r100, int r101) {
        super(r100, r101);
    }
}
