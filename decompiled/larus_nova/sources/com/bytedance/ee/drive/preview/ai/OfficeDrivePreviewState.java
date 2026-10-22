package com.bytedance.ee.drive.preview.ai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/drive/preview/ai/OfficeDrivePreviewState;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "LOADING", "LOADED", "LOAD_FAILED", "NO_PERMISSION", "PASSWORD_PROTECTED", "FILE_NOT_SUPPORT", "SIZE_LIMIT", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeDrivePreviewState extends Enum<OfficeDrivePreviewState> {
    public static final OfficeDrivePreviewState FILE_NOT_SUPPORT = null;
    public static final OfficeDrivePreviewState INITIAL = null;
    public static final OfficeDrivePreviewState LOADED = null;
    public static final OfficeDrivePreviewState LOADING = null;
    public static final OfficeDrivePreviewState LOAD_FAILED = null;
    public static final OfficeDrivePreviewState NO_PERMISSION = null;
    public static final OfficeDrivePreviewState PASSWORD_PROTECTED = null;
    public static final OfficeDrivePreviewState SIZE_LIMIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeDrivePreviewState[] f242690a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242691b = null;

    public static EnumEntries<OfficeDrivePreviewState> getEntries() {
        return f242691b;
    }

    static {
        OfficeDrivePreviewState r100 = new OfficeDrivePreviewState("INITIAL", 0);
        INITIAL = r100;
        OfficeDrivePreviewState r101 = new OfficeDrivePreviewState("LOADING", 1);
        LOADING = r101;
        OfficeDrivePreviewState r102 = new OfficeDrivePreviewState("LOADED", 2);
        LOADED = r102;
        OfficeDrivePreviewState r103 = new OfficeDrivePreviewState("LOAD_FAILED", 3);
        LOAD_FAILED = r103;
        OfficeDrivePreviewState r104 = new OfficeDrivePreviewState("NO_PERMISSION", 4);
        NO_PERMISSION = r104;
        OfficeDrivePreviewState r105 = new OfficeDrivePreviewState("PASSWORD_PROTECTED", 5);
        PASSWORD_PROTECTED = r105;
        OfficeDrivePreviewState r110 = new OfficeDrivePreviewState("FILE_NOT_SUPPORT", 6);
        FILE_NOT_SUPPORT = r110;
        OfficeDrivePreviewState r111 = new OfficeDrivePreviewState("SIZE_LIMIT", 7);
        SIZE_LIMIT = r111;
        OfficeDrivePreviewState[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f242690a = r112;
        f242691b = EnumEntriesKt.enumEntries(r112);
    }

    public static OfficeDrivePreviewState[] values() {
        return (OfficeDrivePreviewState[]) f242690a.clone();
    }

    public static OfficeDrivePreviewState valueOf(String r100) {
        return (OfficeDrivePreviewState) a.a(OfficeDrivePreviewState.class, r100);
    }

    public OfficeDrivePreviewState(String r100, int r101) {
        super(r100, r101);
    }
}
