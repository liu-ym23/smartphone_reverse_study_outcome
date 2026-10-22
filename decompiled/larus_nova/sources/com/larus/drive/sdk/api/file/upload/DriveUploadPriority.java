package com.larus.drive.sdk.api.file.upload;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/drive/sdk/api/file/upload/DriveUploadPriority;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOWEST", "LOW", EffectConstants.NORMAL, "HIGH", "HIGHEST", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveUploadPriority extends Enum<DriveUploadPriority> {
    public static final DriveUploadPriority HIGH = null;
    public static final DriveUploadPriority HIGHEST = null;
    public static final DriveUploadPriority LOW = null;
    public static final DriveUploadPriority LOWEST = null;
    public static final DriveUploadPriority NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveUploadPriority[] f341587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341588b = null;
    private final int value;

    public static EnumEntries<DriveUploadPriority> getEntries() {
        return f341588b;
    }

    static {
        DriveUploadPriority r100 = new DriveUploadPriority("LOWEST", 0, -10);
        LOWEST = r100;
        DriveUploadPriority r101 = new DriveUploadPriority("LOW", 1, -5);
        LOW = r101;
        DriveUploadPriority r102 = new DriveUploadPriority(EffectConstants.NORMAL, 2, 0);
        NORMAL = r102;
        DriveUploadPriority r103 = new DriveUploadPriority("HIGH", 3, 5);
        HIGH = r103;
        DriveUploadPriority r104 = new DriveUploadPriority("HIGHEST", 4, 10);
        HIGHEST = r104;
        DriveUploadPriority[] r105 = {r100, r101, r102, r103, r104};
        f341587a = r105;
        f341588b = EnumEntriesKt.enumEntries(r105);
    }

    public static DriveUploadPriority[] values() {
        return (DriveUploadPriority[]) f341587a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DriveUploadPriority valueOf(String r100) {
        return (DriveUploadPriority) a.a(DriveUploadPriority.class, r100);
    }

    public DriveUploadPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
