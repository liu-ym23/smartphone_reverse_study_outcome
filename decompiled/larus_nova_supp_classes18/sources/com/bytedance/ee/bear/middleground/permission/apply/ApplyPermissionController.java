package com.bytedance.ee.bear.middleground.permission.apply;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ApplyPermissionController {
    public final Fragment a;
    public final NoPermission b;
    public final ApplyPermissionPageMode c;
    public p d;
    public final CompositeDisposable e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ApplyPermissionPageMode.values().length];
            r0[ApplyPermissionPageMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ApplyPermissionPageMode.AUDIT_CONTROL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final int a() {
        ApplyPermissionPageMode r0 = this.c;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        PermApplyViewModel r2 = c();
        if (r2 == null) goto L16;
        LiveData<PermApplyViewModel.PermType> r3 = r2.getPermType();
        if (r3 == null) goto L16;
        PermApplyViewModel.PermType r4 = (PermApplyViewModel.PermType) r3.getValue();
        if (r4 == null) goto L16;
    L18:
        return r4.getCode();
    L16:
        r4 = PermApplyViewModel.PermType.READ;
        goto L18
    L5:
        if (r1 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final int b() {
        Integer r0 = StringsKt.toIntOrNull(this.b.getDocumentType());
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.intValue();
    }

    public final PermApplyViewModel c() {
        return (PermApplyViewModel) this.f.getValue();
    }

    public final String d() {
        ApplyPermissionPageMode r0 = this.c;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "apply_permission";
    L5:
        if (r1 != 2) goto L8;
        return "admin_forbidden";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final int e() {
        ApplyPermissionPageMode r0 = this.c;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return 2131888124;
    L5:
        if (r1 != 2) goto L8;
        return 2131887714;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public ApplyPermissionController(Fragment r2, NoPermission r3, ApplyPermissionPageMode r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "mode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = new CompositeDisposable();
        this.f = LazyKt.lazy(new ApplyPermissionController$normalViewModel$2(this));
        this.g = LazyKt.lazy(new ApplyPermissionController$auditFetcher$2(this));
    }
}
