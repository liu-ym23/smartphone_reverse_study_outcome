package com.larus.drive.sdk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/drive/sdk/api/DrivePickerScene;", "", "<init>", "(Ljava/lang/String;I)V", "FINDER", "FILE_SELECTOR", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DrivePickerScene extends Enum<DrivePickerScene> {
    public static final DrivePickerScene FILE_SELECTOR = null;
    public static final DrivePickerScene FINDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DrivePickerScene[] f341558a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341559b = null;

    public static EnumEntries<DrivePickerScene> getEntries() {
        return f341559b;
    }

    static {
        DrivePickerScene r100 = new DrivePickerScene("FINDER", 0);
        FINDER = r100;
        DrivePickerScene r101 = new DrivePickerScene("FILE_SELECTOR", 1);
        FILE_SELECTOR = r101;
        DrivePickerScene[] r102 = {r100, r101};
        f341558a = r102;
        f341559b = EnumEntriesKt.enumEntries(r102);
    }

    public static DrivePickerScene[] values() {
        return (DrivePickerScene[]) f341558a.clone();
    }

    public static DrivePickerScene valueOf(String r100) {
        return (DrivePickerScene) a.a(DrivePickerScene.class, r100);
    }

    public DrivePickerScene(String r100, int r101) {
        super(r100, r101);
    }
}
