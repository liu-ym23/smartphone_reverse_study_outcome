package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final c a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UiType.values().length];
            r0[UiType.HIDDEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[UiType.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[UiType.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new c();
    }

    public c() {
    }

    public static b a(t r5) {
        if (r5.e == true) goto L7;
        return new b.c(OfficeUploadDisabledReason.MENU_CONFIG_DISABLED);
    L7:
        if (((Boolean) r5.c.invoke()).booleanValue() == true) goto L11;
        return new b.C0131b(OfficeUploadDisabledReason.OWNER_NOT_READY);
    L11:
        if (((Boolean) r5.d.invoke()).booleanValue() != true) goto L13;
        g0 r0 = r5.b;
        if ((r0 instanceof g0.a) == false) goto L21;
        if (StringsKt.isBlank(((g0.a) r0).a) == false) goto L21;
        return new b.C0131b(OfficeUploadDisabledReason.TARGET_INVALID);
    L21:
        if (((Boolean) r5.f.invoke()).booleanValue() == false) goto L23;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L26
        Object r2 = Result.constructor-impl((PermissionResponse) r5.g.invoke());     // Catch: Throwable -> L26
    L28:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L32;
        tt5.a.l("OfficeUploadAvailability", "upload permission validate failed, action=" + r5.a, r3);
    L32:
        if (Result.isFailure-impl(r2) == false) goto L34;
        r2 = null;
    L34:
        PermissionResponse r4 = (PermissionResponse) r2;
        if (r4 != null) goto L39;
        return new b.C0131b(OfficeUploadDisabledReason.PERMISSION_UNAVAILABLE);
    L39:
        if (r4.getAllow() == true) goto L55;
        int r6 = a.a[r4.getDenySource().getUiType().ordinal()];
        if (r6 == 1) goto L52;
        if (r6 == 2) goto L57;
        if (r6 != 3) goto L49;
        return new b.d(r4);
    L49:
        throw new NoWhenBranchMatchedException();
    L57:
        return new b.C0131b(OfficeUploadDisabledReason.PERMISSION_DISABLED);
    L52:
        return new b.c(OfficeUploadDisabledReason.PERMISSION_HIDDEN);
    L55:
        return b.a.a;
    L26:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L23:
        return new b.C0131b(OfficeUploadDisabledReason.FOLDER_NOT_WRITABLE);
    L13:
        return new b.C0131b(OfficeUploadDisabledReason.NETWORK_UNAVAILABLE);
    }
}
