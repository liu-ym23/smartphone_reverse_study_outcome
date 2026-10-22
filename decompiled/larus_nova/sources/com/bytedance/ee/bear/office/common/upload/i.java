package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235389a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235390a = null;

        static {
            int[] r100 = new int[DriveFile.Status.values().length];
            r100[DriveFile.Status.PENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r100[DriveFile.Status.QUEUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r100[DriveFile.Status.READY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r100[DriveFile.Status.INFLIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[DriveFile.Status.SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r100[DriveFile.Status.RANGE_FINISH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[DriveFile.Status.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[DriveFile.Status.CANCEL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[DriveFile.Status.UNKNOWN.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f235390a = r100;
        }
    }

    static {
    }

    public static OfficeUploadStatus a(DriveFile.Status r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L5:
        switch(r101) {
            case -1: goto L12;
            case 0: goto L7;
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L12;
            default: goto L7;
        };
    L7:
        throw new NoWhenBranchMatchedException();
    L13:
        return OfficeUploadStatus.FINISH;
    L14:
        return OfficeUploadStatus.UPLOADING;
    L15:
        return OfficeUploadStatus.UNSTARTED;
    L12:
        return OfficeUploadStatus.FAILED;
    L4:
        r101 = a.f235390a[r100.ordinal()];
        goto L5
    }
}
