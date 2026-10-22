package com.bytedance.ee.bear.drive.biz.comment;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f222796a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f222797a = null;

        static {
            int[] r100 = new int[DriveHeaderCommentEntryAction.values().length];
            r100[DriveHeaderCommentEntryAction.CREATE_CURRENT_PAGE_COMMENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DriveHeaderCommentEntryAction.OPEN_DEFAULT_ENTRY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DriveHeaderCommentEntryAction.HIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f222797a = r100;
        }
    }

    static {
    }

    public static boolean a(boolean r100, Function0 r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r101, "doubaoDriveCommentEnabledProvider");
        Intrinsics.checkNotNullParameter(r102, "driveMoreOpenChatEnabledProvider");
        if (r100 == false) goto L6;
        return ((Boolean) r101.invoke()).booleanValue();
    L6:
        return ((Boolean) r102.invoke()).booleanValue();
    }
}
