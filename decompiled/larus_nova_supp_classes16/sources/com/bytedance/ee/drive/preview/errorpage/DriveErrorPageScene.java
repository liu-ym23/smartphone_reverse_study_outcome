package com.bytedance.ee.drive.preview.errorpage;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/drive/preview/errorpage/DriveErrorPageScene;", "", "<init>", "(Ljava/lang/String;I)V", "NO_NETWORK", "LOAD_FAILED", "SIZE_ZERO", "SIZE_ENDLESS", "UNSUPPORTED_TYPE", "TRANSCODING", "EXTENSION_MISMATCH", "PREVIEW_CONTENT_FAILED", "contentmanager-drive-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveErrorPageScene extends Enum<DriveErrorPageScene> {
    public static final DriveErrorPageScene EXTENSION_MISMATCH = null;
    public static final DriveErrorPageScene LOAD_FAILED = null;
    public static final DriveErrorPageScene NO_NETWORK = null;
    public static final DriveErrorPageScene PREVIEW_CONTENT_FAILED = null;
    public static final DriveErrorPageScene SIZE_ENDLESS = null;
    public static final DriveErrorPageScene SIZE_ZERO = null;
    public static final DriveErrorPageScene TRANSCODING = null;
    public static final DriveErrorPageScene UNSUPPORTED_TYPE = null;
    public static final /* synthetic */ DriveErrorPageScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DriveErrorPageScene> getEntries() {
        return b;
    }

    static {
        DriveErrorPageScene r0 = new DriveErrorPageScene("NO_NETWORK", 0);
        NO_NETWORK = r0;
        DriveErrorPageScene r1 = new DriveErrorPageScene("LOAD_FAILED", 1);
        LOAD_FAILED = r1;
        DriveErrorPageScene r3 = new DriveErrorPageScene("SIZE_ZERO", 2);
        SIZE_ZERO = r3;
        DriveErrorPageScene r5 = new DriveErrorPageScene("SIZE_ENDLESS", 3);
        SIZE_ENDLESS = r5;
        DriveErrorPageScene r7 = new DriveErrorPageScene("UNSUPPORTED_TYPE", 4);
        UNSUPPORTED_TYPE = r7;
        DriveErrorPageScene r9 = new DriveErrorPageScene("TRANSCODING", 5);
        TRANSCODING = r9;
        DriveErrorPageScene r11 = new DriveErrorPageScene("EXTENSION_MISMATCH", 6);
        EXTENSION_MISMATCH = r11;
        DriveErrorPageScene r13 = new DriveErrorPageScene("PREVIEW_CONTENT_FAILED", 7);
        PREVIEW_CONTENT_FAILED = r13;
        DriveErrorPageScene[] r16 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r16;
        b = EnumEntriesKt.enumEntries(r16);
    }

    public static DriveErrorPageScene[] values() {
        return (DriveErrorPageScene[]) a.clone();
    }

    public static DriveErrorPageScene valueOf(String r1) {
        return (DriveErrorPageScene) a.a(DriveErrorPageScene.class, r1);
    }

    public DriveErrorPageScene(String r1, int r2) {
        super(r1, r2);
    }
}
