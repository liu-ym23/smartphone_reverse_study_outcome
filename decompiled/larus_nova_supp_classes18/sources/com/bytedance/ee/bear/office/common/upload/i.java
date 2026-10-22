package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFile.Status.values().length];
            r0[DriveFile.Status.PENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[DriveFile.Status.QUEUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[DriveFile.Status.READY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[DriveFile.Status.INFLIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[DriveFile.Status.SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[DriveFile.Status.RANGE_FINISH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[DriveFile.Status.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[DriveFile.Status.CANCEL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[DriveFile.Status.UNKNOWN.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    static {
    }

    public static OfficeUploadStatus a(DriveFile.Status r1) {
        if (r1 != null) goto L4;
        int r2 = -1;
    L5:
        switch(r2) {
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
        r2 = a.a[r1.ordinal()];
        goto L5
    }
}
