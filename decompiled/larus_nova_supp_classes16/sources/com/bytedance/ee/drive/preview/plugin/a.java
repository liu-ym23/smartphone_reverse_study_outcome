package com.bytedance.ee.drive.preview.plugin;

import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ee.drive.preview.plugin.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0205a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeDrivePreviewState.values().length];
            r0[OfficeDrivePreviewState.LOAD_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[OfficeDrivePreviewState.PASSWORD_PROTECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[OfficeDrivePreviewState.FILE_NOT_SUPPORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[OfficeDrivePreviewState.SIZE_LIMIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[OfficeDrivePreviewState.NO_PERMISSION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[OfficeDrivePreviewState.INITIAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[OfficeDrivePreviewState.LOADING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[OfficeDrivePreviewState.LOADED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public static final boolean a(OfficeDrivePreviewState r1) {
        Intrinsics.checkNotNullParameter(r1, "state");
        switch(C0205a.a[r1.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return false;
    L7:
        return true;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static final OfficeDrivePreviewState b(OfficeDrivePreviewState r3, Integer r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "currentState");
        if (r4 == null) goto L9;
        if (r4.intValue() != 1) goto L9;
        return OfficeDrivePreviewState.LOADING;
    L9:
        if (r4 != null) goto L12;
    L21:
        if (r4 == null) goto L28;
        if (r4.intValue() != 3) goto L28;
        if (r5 == false) goto L28;
        return OfficeDrivePreviewState.LOAD_FAILED;
    L28:
        return null;
    L12:
        if (r4.intValue() != 2) goto L21;
        if (r5 == true) goto L15;
        return null;
    L15:
        int r6 = C0205a.a[r3.ordinal()];
        if (r6 == 7) goto L30;
        if (r6 == 8) goto L30;
        return r3;
    L30:
        return OfficeDrivePreviewState.LOADED;
    }
}
