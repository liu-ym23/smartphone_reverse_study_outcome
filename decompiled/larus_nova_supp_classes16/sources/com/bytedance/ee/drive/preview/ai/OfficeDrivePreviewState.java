package com.bytedance.ee.drive.preview.ai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final /* synthetic */ OfficeDrivePreviewState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeDrivePreviewState> getEntries() {
        return b;
    }

    static {
        OfficeDrivePreviewState r0 = new OfficeDrivePreviewState("INITIAL", 0);
        INITIAL = r0;
        OfficeDrivePreviewState r1 = new OfficeDrivePreviewState("LOADING", 1);
        LOADING = r1;
        OfficeDrivePreviewState r3 = new OfficeDrivePreviewState("LOADED", 2);
        LOADED = r3;
        OfficeDrivePreviewState r5 = new OfficeDrivePreviewState("LOAD_FAILED", 3);
        LOAD_FAILED = r5;
        OfficeDrivePreviewState r7 = new OfficeDrivePreviewState("NO_PERMISSION", 4);
        NO_PERMISSION = r7;
        OfficeDrivePreviewState r9 = new OfficeDrivePreviewState("PASSWORD_PROTECTED", 5);
        PASSWORD_PROTECTED = r9;
        OfficeDrivePreviewState r11 = new OfficeDrivePreviewState("FILE_NOT_SUPPORT", 6);
        FILE_NOT_SUPPORT = r11;
        OfficeDrivePreviewState r13 = new OfficeDrivePreviewState("SIZE_LIMIT", 7);
        SIZE_LIMIT = r13;
        OfficeDrivePreviewState[] r16 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r16;
        b = EnumEntriesKt.enumEntries(r16);
    }

    public static OfficeDrivePreviewState[] values() {
        return (OfficeDrivePreviewState[]) a.clone();
    }

    public static OfficeDrivePreviewState valueOf(String r1) {
        return (OfficeDrivePreviewState) a.a(OfficeDrivePreviewState.class, r1);
    }

    public OfficeDrivePreviewState(String r1, int r2) {
        super(r1, r2);
    }
}
