package com.larus.drive.sdk.api.file.download;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/drive/sdk/api/file/download/DriveDownloadPriority;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOWEST", "LOW", EffectConstants.NORMAL, "HIGH", "HIGHEST", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveDownloadPriority extends Enum<DriveDownloadPriority> {
    public static final DriveDownloadPriority HIGH = null;
    public static final DriveDownloadPriority HIGHEST = null;
    public static final DriveDownloadPriority LOW = null;
    public static final DriveDownloadPriority LOWEST = null;
    public static final DriveDownloadPriority NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveDownloadPriority[] f341577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341578b = null;
    private final int value;

    public static EnumEntries<DriveDownloadPriority> getEntries() {
        return f341578b;
    }

    static {
        DriveDownloadPriority r100 = new DriveDownloadPriority("LOWEST", 0, -10);
        LOWEST = r100;
        DriveDownloadPriority r101 = new DriveDownloadPriority("LOW", 1, -5);
        LOW = r101;
        DriveDownloadPriority r102 = new DriveDownloadPriority(EffectConstants.NORMAL, 2, 0);
        NORMAL = r102;
        DriveDownloadPriority r103 = new DriveDownloadPriority("HIGH", 3, 5);
        HIGH = r103;
        DriveDownloadPriority r104 = new DriveDownloadPriority("HIGHEST", 4, 10);
        HIGHEST = r104;
        DriveDownloadPriority[] r105 = {r100, r101, r102, r103, r104};
        f341577a = r105;
        f341578b = EnumEntriesKt.enumEntries(r105);
    }

    public static DriveDownloadPriority[] values() {
        return (DriveDownloadPriority[]) f341577a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DriveDownloadPriority valueOf(String r100) {
        return (DriveDownloadPriority) a.a(DriveDownloadPriority.class, r100);
    }

    public DriveDownloadPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
