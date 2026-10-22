package com.larus.drive.biz.impl.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapterFooterState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "LOADING", "FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveFileListAdapterFooterState extends Enum<DriveFileListAdapterFooterState> {
    public static final DriveFileListAdapterFooterState FAIL = null;
    public static final DriveFileListAdapterFooterState IDLE = null;
    public static final DriveFileListAdapterFooterState LOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveFileListAdapterFooterState[] f341087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341088b = null;

    public static EnumEntries<DriveFileListAdapterFooterState> getEntries() {
        return f341088b;
    }

    static {
        DriveFileListAdapterFooterState r100 = new DriveFileListAdapterFooterState("IDLE", 0);
        IDLE = r100;
        DriveFileListAdapterFooterState r101 = new DriveFileListAdapterFooterState("LOADING", 1);
        LOADING = r101;
        DriveFileListAdapterFooterState r102 = new DriveFileListAdapterFooterState("FAIL", 2);
        FAIL = r102;
        DriveFileListAdapterFooterState[] r103 = {r100, r101, r102};
        f341087a = r103;
        f341088b = EnumEntriesKt.enumEntries(r103);
    }

    public static DriveFileListAdapterFooterState[] values() {
        return (DriveFileListAdapterFooterState[]) f341087a.clone();
    }

    public static DriveFileListAdapterFooterState valueOf(String r100) {
        return (DriveFileListAdapterFooterState) r27.a.a(DriveFileListAdapterFooterState.class, r100);
    }

    public DriveFileListAdapterFooterState(String r100, int r101) {
        super(r100, r101);
    }
}
