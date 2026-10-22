package com.bytedance.ee.bear.office.list.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadActionType;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadPickerFragment;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeUploadHeaderAction {
    public static final OfficeUploadHeaderAction a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSpaceHeaderAction.values().length];
            r0[OfficeSpaceHeaderAction.UPLOAD_IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OfficeSpaceHeaderAction.UPLOAD_FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new OfficeUploadHeaderAction();
    }

    public OfficeUploadHeaderAction() {
    }

    public static boolean b(OfficeSpaceHeaderAction r1) {
        Intrinsics.checkNotNullParameter(r1, "action");
        if (r1 != OfficeSpaceHeaderAction.UPLOAD_IMAGE) goto L5;
    L8:
        return true;
    L5:
        if (r1 == OfficeSpaceHeaderAction.UPLOAD_FILE) goto L8;
        return false;
    }

    public static OfficeUploadActionType f(OfficeSpaceHeaderAction r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L11;
        return null;
    L11:
        return OfficeUploadActionType.FILE;
    L9:
        return OfficeUploadActionType.MEDIA;
    }

    public static /* synthetic */ p0 d(OfficeSpaceHeaderAction r6, OfficeSpaceTab r7, com.bytedance.ee.bear.office.list.i r8) {
        return a.c(r6, r7, r8, false, null);
    }

    public static boolean e(Fragment r4, OfficeSpaceHeaderAction r5, com.bytedance.ee.bear.office.common.upload.g0 r6, Object r7, com.bytedance.ee.bear.office.common.upload.t r8) {
        FragmentActivity r0 = r4.getActivity();
        if (r0 != null) goto L5;
        return false;
    L5:
        OfficeUploadActionType r9 = f(r5);
        if (r9 != null) goto L8;
        return false;
    L8:
        com.bytedance.ee.bear.office.common.upload.c.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "context");
        com.bytedance.ee.bear.office.common.upload.b r2 = com.bytedance.ee.bear.office.common.upload.c.a(r8);
        if ((r2 instanceof com.bytedance.ee.bear.office.common.upload.b.a) == false) goto L11;
        FragmentManager r10 = r4.requireActivity().getSupportFragmentManager();
        Fragment r3 = r10.findFragmentByTag("OfficeUploadPickerFragment");
        if ((r3 instanceof OfficeUploadPickerFragment) == false) goto L25;
        OfficeUploadPickerFragment r11 = (OfficeUploadPickerFragment) r3;
    L26:
        if (r11 != null) goto L33;
        r11 = new OfficeUploadPickerFragment();
        FragmentTransaction r12 = r10.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r11, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "OfficeUploadPickerFragment", 0) == true) goto L31;
        r12 = r12.add(r11, "OfficeUploadPickerFragment");
    L31:
        r12.commitNowAllowingStateLoss();
    L33:
        return r11.U90(r9, r6, r7, r8);
    L25:
        r11 = null;
        goto L26
    L11:
        if ((r2 instanceof com.bytedance.ee.bear.office.common.upload.b.d) == false) goto L15;
        com.bytedance.ee.bear.office.common.upload.z.a(r0, r2);
        return true;
    L15:
        if ((r2 instanceof com.bytedance.ee.bear.office.common.upload.b.c) == false) goto L17;
    L21:
        return false;
    L17:
        if ((r2 instanceof com.bytedance.ee.bear.office.common.upload.b.C0131b) == true) goto L21;
        throw new NoWhenBranchMatchedException();
    }

    public final p0 c(OfficeSpaceHeaderAction r8, OfficeSpaceTab r9, com.bytedance.ee.bear.office.list.i r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "action");
        Intrinsics.checkNotNullParameter(r9, "tab");
        Intrinsics.checkNotNullParameter(r10, "capability");
        OfficeUploadActionType r1 = f(r8);
        if (r1 == null) goto L5;
        if (r11 == true) goto L8;
        com.bytedance.ee.bear.office.common.upload.g0 r2 = com.bytedance.ee.bear.office.common.upload.g0.b.a;
    L12:
        com.bytedance.ee.bear.office.common.upload.t r13 = a(r1, r2, r10, r9, r11, null);
        if (r11 == false) goto L15;
    L18:
        boolean r14 = true;
    L19:
        if (r14 == false) goto L21;
        com.bytedance.ee.bear.office.common.upload.c.a.getClass();
        Intrinsics.checkNotNullParameter(r13, "context");
        com.bytedance.ee.bear.office.common.upload.b r15 = com.bytedance.ee.bear.office.common.upload.c.a(r13);
        if ((r15 instanceof com.bytedance.ee.bear.office.common.upload.b.a) == true) goto L36;
        if ((r15 instanceof com.bytedance.ee.bear.office.common.upload.b.d) == true) goto L36;
        if ((r15 instanceof com.bytedance.ee.bear.office.common.upload.b.C0131b) == false) goto L31;
        return new p0(true, false);
    L31:
        if ((r15 instanceof com.bytedance.ee.bear.office.common.upload.b.c) == false) goto L34;
        return new p0(false, false);
    L34:
        throw new NoWhenBranchMatchedException();
    L36:
        return new p0(true, true);
    L21:
        return new p0(false, false);
    L15:
        if (CollectionsKt.listOf(new OfficeSpaceTab[]{OfficeSpaceTab.RECENT, OfficeSpaceTab.MINE, OfficeSpaceTab.SHARED, OfficeSpaceTab.FAVORITE}).contains(r9) == true) goto L18;
        r14 = false;
        goto L19
    L8:
        if (r12 != null) goto L10;
        r12 = "";
    L10:
        r2 = new com.bytedance.ee.bear.office.common.upload.g0.a(r12);
        goto L12
    L5:
        return new p0(false, false);
    }

    public static com.bytedance.ee.bear.office.common.upload.t a(OfficeUploadActionType r7, com.bytedance.ee.bear.office.common.upload.g0 r8, final com.bytedance.ee.bear.office.list.i r9, final OfficeSpaceTab r10, final boolean r11, final Fragment r12) {
        if (r12 != null) goto L5;
        r12 = r9.a();
    L5:
        return new com.bytedance.ee.bear.office.common.upload.t(r7, r8, new OfficeUploadHeaderAction$buildGuardContext$1(r12), new OfficeUploadHeaderAction$buildGuardContext$2(r9), new OfficeUploadHeaderAction$buildGuardContext$3(r11, r10, r9));
    }
}
