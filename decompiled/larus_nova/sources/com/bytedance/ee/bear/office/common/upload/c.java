package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f235343a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235344a = null;

        static {
            int[] r100 = new int[UiType.values().length];
            r100[UiType.HIDDEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[UiType.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[UiType.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f235344a = r100;
        }
    }

    static {
        f235343a = new c();
    }

    public c() {
    }

    public static b a(t r100) {
        if (r100.f235423e == true) goto L7;
        return new b.c(OfficeUploadDisabledReason.MENU_CONFIG_DISABLED);
    L7:
        if (r100.f235421c.invoke().booleanValue() == true) goto L11;
        return new b.C3378b(OfficeUploadDisabledReason.OWNER_NOT_READY);
    L11:
        if (r100.f235422d.invoke().booleanValue() != true) goto L13;
        g0 r101 = r100.f235420b;
        if ((r101 instanceof g0.a) == false) goto L21;
        if (StringsKt.isBlank(((g0.a) r101).f235370a) == false) goto L21;
        return new b.C3378b(OfficeUploadDisabledReason.TARGET_INVALID);
    L21:
        if (r100.f235424f.invoke().booleanValue() == false) goto L23;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L26
        Object r103 = Result.m9449constructorimpl(r100.f235425g.invoke());     // Catch: Throwable -> L26
    L28:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L32;
        tt5.a.l("OfficeUploadAvailability", "upload permission validate failed, action=" + r100.f235419a, r104);
    L32:
        if (Result.m9455isFailureimpl(r103) == false) goto L34;
        r103 = null;
    L34:
        PermissionResponse r105 = (PermissionResponse) r103;
        if (r105 != null) goto L39;
        return new b.C3378b(OfficeUploadDisabledReason.PERMISSION_UNAVAILABLE);
    L39:
        if (r105.getAllow() == true) goto L55;
        int r106 = a.f235344a[r105.getDenySource().getUiType().ordinal()];
        if (r106 == 1) goto L52;
        if (r106 == 2) goto L57;
        if (r106 != 3) goto L49;
        return new b.d(r105);
    L49:
        throw new NoWhenBranchMatchedException();
    L57:
        return new b.C3378b(OfficeUploadDisabledReason.PERMISSION_DISABLED);
    L52:
        return new b.c(OfficeUploadDisabledReason.PERMISSION_HIDDEN);
    L55:
        return b.a.f235338a;
    L26:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L23:
        return new b.C3378b(OfficeUploadDisabledReason.FOLDER_NOT_WRITABLE);
    L13:
        return new b.C3378b(OfficeUploadDisabledReason.NETWORK_UNAVAILABLE);
    }
}
