package com.bytedance.ee.drive.preview.plugin;

import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ee.drive.preview.plugin.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C3472a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f242717a = null;

        static {
            int[] r100 = new int[OfficeDrivePreviewState.values().length];
            r100[OfficeDrivePreviewState.LOAD_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[OfficeDrivePreviewState.PASSWORD_PROTECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[OfficeDrivePreviewState.FILE_NOT_SUPPORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[OfficeDrivePreviewState.SIZE_LIMIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[OfficeDrivePreviewState.NO_PERMISSION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[OfficeDrivePreviewState.INITIAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[OfficeDrivePreviewState.LOADING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[OfficeDrivePreviewState.LOADED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f242717a = r100;
        }
    }

    public static final boolean a(OfficeDrivePreviewState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        switch(C3472a.f242717a[r100.ordinal()]) {
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

    public static final OfficeDrivePreviewState b(OfficeDrivePreviewState r100, Integer r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        if (r101 == null) goto L9;
        if (r101.intValue() != 1) goto L9;
        return OfficeDrivePreviewState.LOADING;
    L9:
        if (r101 != null) goto L12;
    L21:
        if (r101 == null) goto L28;
        if (r101.intValue() != 3) goto L28;
        if (r102 == false) goto L28;
        return OfficeDrivePreviewState.LOAD_FAILED;
    L28:
        return null;
    L12:
        if (r101.intValue() != 2) goto L21;
        if (r102 == true) goto L15;
        return null;
    L15:
        int r103 = C3472a.f242717a[r100.ordinal()];
        if (r103 == 7) goto L30;
        if (r103 == 8) goto L30;
        return r100;
    L30:
        return OfficeDrivePreviewState.LOADED;
    }
}
