package com.bytedance.ee.bear.drive.biz.comment;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l1 {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveHeaderCommentEntryAction.values().length];
            r0[DriveHeaderCommentEntryAction.CREATE_CURRENT_PAGE_COMMENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DriveHeaderCommentEntryAction.OPEN_DEFAULT_ENTRY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DriveHeaderCommentEntryAction.HIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public static boolean a(boolean r1, Function0 r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "doubaoDriveCommentEnabledProvider");
        Intrinsics.checkNotNullParameter(r3, "driveMoreOpenChatEnabledProvider");
        if (r1 == false) goto L6;
        return ((Boolean) r2.invoke()).booleanValue();
    L6:
        return ((Boolean) r3.invoke()).booleanValue();
    }
}
