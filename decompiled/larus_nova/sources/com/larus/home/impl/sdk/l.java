package com.larus.home.impl.sdk;

import com.larus.calendar.ErrorCode;
import com.larus.platform.api.SdkCalendarErrorCode;
import com.larus.platform.api.b5;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f346196a = null;

        static {
            int[] r100 = new int[ErrorCode.values().length];
            r100[ErrorCode.ArgumentError.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[ErrorCode.NoPermission.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[ErrorCode.AlreadyExists.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ErrorCode.NoAccount.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[ErrorCode.Unknown.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[ErrorCode.Success.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[ErrorCode.NotFound.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[ErrorCode.NotGetId.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f346196a = r100;
        }
    }

    public static final b5 a(com.larus.calendar.a r100) {
        String r101 = r100.f321324a;
        ErrorCode r102 = r100.f321325b;
        switch(a.f346196a[r102.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        SdkCalendarErrorCode r103 = SdkCalendarErrorCode.NotGetId;
    L15:
        return new b5(r101, r103);
    L7:
        r103 = SdkCalendarErrorCode.NotFound;
        goto L15
    L8:
        r103 = SdkCalendarErrorCode.Success;
        goto L15
    L9:
        r103 = SdkCalendarErrorCode.Unknown;
        goto L15
    L10:
        r103 = SdkCalendarErrorCode.NoAccount;
        goto L15
    L11:
        r103 = SdkCalendarErrorCode.AlreadyExists;
        goto L15
    L12:
        r103 = SdkCalendarErrorCode.NoPermission;
        goto L15
    L13:
        r103 = SdkCalendarErrorCode.ArgumentError;
        goto L15
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
