package com.bytedance.ee.drive.mime;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/drive/mime/DriveLocalMime;", "", "value", "", "Lcom/bytedance/ee/drive/mime/DriveLocalMimeType;", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NOT_SUPPORT", "DOCUMENT", "IMAGE", "AUDIO", "VIDEO", "PDF", "APK", "ARCHIVE", "WPS", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveLocalMime extends Enum<DriveLocalMime> {
    public static final DriveLocalMime APK = null;
    public static final DriveLocalMime ARCHIVE = null;
    public static final DriveLocalMime AUDIO = null;
    public static final DriveLocalMime DOCUMENT = null;
    public static final DriveLocalMime IMAGE = null;
    public static final DriveLocalMime NOT_SUPPORT = null;
    public static final DriveLocalMime PDF = null;
    public static final DriveLocalMime VIDEO = null;
    public static final DriveLocalMime WPS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveLocalMime[] f242659a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242660b = null;
    private final int value;

    public static EnumEntries<DriveLocalMime> getEntries() {
        return f242660b;
    }

    static {
        DriveLocalMime r100 = new DriveLocalMime("NOT_SUPPORT", 0, 1);
        NOT_SUPPORT = r100;
        DriveLocalMime r101 = new DriveLocalMime("DOCUMENT", 1, 2);
        DOCUMENT = r101;
        DriveLocalMime r102 = new DriveLocalMime("IMAGE", 2, 3);
        IMAGE = r102;
        DriveLocalMime r103 = new DriveLocalMime("AUDIO", 3, 4);
        AUDIO = r103;
        DriveLocalMime r104 = new DriveLocalMime("VIDEO", 4, 5);
        VIDEO = r104;
        DriveLocalMime r110 = new DriveLocalMime("PDF", 5, 6);
        PDF = r110;
        DriveLocalMime r111 = new DriveLocalMime("APK", 6, 7);
        APK = r111;
        DriveLocalMime r112 = new DriveLocalMime("ARCHIVE", 7, 8);
        ARCHIVE = r112;
        DriveLocalMime r113 = new DriveLocalMime("WPS", 8, 9);
        WPS = r113;
        DriveLocalMime[] r105 = {r100, r101, r102, r103, r104, r110, r111, r112, r113};
        f242659a = r105;
        f242660b = EnumEntriesKt.enumEntries(r105);
    }

    public static DriveLocalMime[] values() {
        return (DriveLocalMime[]) f242659a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DriveLocalMime valueOf(String r100) {
        return (DriveLocalMime) a.a(DriveLocalMime.class, r100);
    }

    public DriveLocalMime(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
