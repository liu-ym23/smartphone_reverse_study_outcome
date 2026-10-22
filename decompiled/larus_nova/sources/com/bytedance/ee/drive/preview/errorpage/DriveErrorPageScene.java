package com.bytedance.ee.drive.preview.errorpage;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveErrorPageScene[] f242697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242698b = null;

    public static EnumEntries<DriveErrorPageScene> getEntries() {
        return f242698b;
    }

    static {
        DriveErrorPageScene r100 = new DriveErrorPageScene("NO_NETWORK", 0);
        NO_NETWORK = r100;
        DriveErrorPageScene r101 = new DriveErrorPageScene("LOAD_FAILED", 1);
        LOAD_FAILED = r101;
        DriveErrorPageScene r102 = new DriveErrorPageScene("SIZE_ZERO", 2);
        SIZE_ZERO = r102;
        DriveErrorPageScene r103 = new DriveErrorPageScene("SIZE_ENDLESS", 3);
        SIZE_ENDLESS = r103;
        DriveErrorPageScene r104 = new DriveErrorPageScene("UNSUPPORTED_TYPE", 4);
        UNSUPPORTED_TYPE = r104;
        DriveErrorPageScene r105 = new DriveErrorPageScene("TRANSCODING", 5);
        TRANSCODING = r105;
        DriveErrorPageScene r110 = new DriveErrorPageScene("EXTENSION_MISMATCH", 6);
        EXTENSION_MISMATCH = r110;
        DriveErrorPageScene r111 = new DriveErrorPageScene("PREVIEW_CONTENT_FAILED", 7);
        PREVIEW_CONTENT_FAILED = r111;
        DriveErrorPageScene[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f242697a = r112;
        f242698b = EnumEntriesKt.enumEntries(r112);
    }

    public static DriveErrorPageScene[] values() {
        return (DriveErrorPageScene[]) f242697a.clone();
    }

    public static DriveErrorPageScene valueOf(String r100) {
        return (DriveErrorPageScene) a.a(DriveErrorPageScene.class, r100);
    }

    public DriveErrorPageScene(String r100, int r101) {
        super(r100, r101);
    }
}
