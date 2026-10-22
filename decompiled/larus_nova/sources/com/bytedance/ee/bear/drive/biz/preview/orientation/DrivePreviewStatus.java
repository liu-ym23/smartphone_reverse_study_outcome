package com.bytedance.ee.bear.drive.biz.preview.orientation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/orientation/DrivePreviewStatus;", "", "uiState", "Lcom/bytedance/ee/bear/drive/biz/preview/orientation/DriveUIState;", "<init>", "(Ljava/lang/String;ILcom/bytedance/ee/bear/drive/biz/preview/orientation/DriveUIState;)V", "getUiState", "()Lcom/bytedance/ee/bear/drive/biz/preview/orientation/DriveUIState;", "LANDSCAPE", "Portrait", "BLOCK", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DrivePreviewStatus extends Enum<DrivePreviewStatus> {
    public static final DrivePreviewStatus BLOCK = null;
    public static final DrivePreviewStatus LANDSCAPE = null;
    public static final DrivePreviewStatus Portrait = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DrivePreviewStatus[] f223670a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f223671b = null;
    private final c uiState;

    public static EnumEntries<DrivePreviewStatus> getEntries() {
        return f223671b;
    }

    static {
        DrivePreviewStatus r100 = new DrivePreviewStatus("LANDSCAPE", 0, new c());
        LANDSCAPE = r100;
        DrivePreviewStatus r101 = new DrivePreviewStatus("Portrait", 1, new c());
        Portrait = r101;
        DrivePreviewStatus r102 = new DrivePreviewStatus("BLOCK", 2, new c());
        BLOCK = r102;
        DrivePreviewStatus[] r103 = {r100, r101, r102};
        f223670a = r103;
        f223671b = EnumEntriesKt.enumEntries(r103);
    }

    public static DrivePreviewStatus[] values() {
        return (DrivePreviewStatus[]) f223670a.clone();
    }

    public final c getUiState() {
        return this.uiState;
    }

    public static DrivePreviewStatus valueOf(String r100) {
        return (DrivePreviewStatus) r27.a.a(DrivePreviewStatus.class, r100);
    }

    public DrivePreviewStatus(String r100, int r101, c r102) {
        super(r100, r101);
        this.uiState = r102;
    }
}
