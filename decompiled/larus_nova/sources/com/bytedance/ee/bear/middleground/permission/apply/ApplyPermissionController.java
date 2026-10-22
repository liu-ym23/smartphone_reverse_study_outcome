package com.bytedance.ee.bear.middleground.permission.apply;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class ApplyPermissionController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f232872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NoPermission f232873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ApplyPermissionPageMode f232874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f232875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f232876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f232877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f232878g;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232879a = null;

        static {
            int[] r100 = new int[ApplyPermissionPageMode.values().length];
            r100[ApplyPermissionPageMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ApplyPermissionPageMode.AUDIT_CONTROL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f232879a = r100;
        }
    }

    static {
    }

    public final int a() {
        ApplyPermissionPageMode r100 = this.f232874c;
        int r101 = b.f232879a[r100.ordinal()];
        if (r101 != 1) goto L5;
        PermApplyViewModel r102 = c();
        if (r102 == null) goto L16;
        LiveData<PermApplyViewModel.PermType> r103 = r102.getPermType();
        if (r103 == null) goto L16;
        PermApplyViewModel.PermType r104 = r103.getValue();
        if (r104 == null) goto L16;
    L18:
        return r104.getCode();
    L16:
        r104 = PermApplyViewModel.PermType.READ;
        goto L18
    L5:
        if (r101 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final int b() {
        Integer r100 = StringsKt.toIntOrNull(this.f232873b.getDocumentType());
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.intValue();
    }

    public final PermApplyViewModel c() {
        return (PermApplyViewModel) this.f232877f.getValue();
    }

    public final String d() {
        ApplyPermissionPageMode r100 = this.f232874c;
        int r101 = b.f232879a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "apply_permission";
    L5:
        if (r101 != 2) goto L8;
        return "admin_forbidden";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final int e() {
        ApplyPermissionPageMode r100 = this.f232874c;
        int r101 = b.f232879a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return R.string.Doc_Permission_SendRequest;
    L5:
        if (r101 != 2) goto L8;
        return R.string.Doc_Facade_ApplyFor;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public ApplyPermissionController(Fragment r100, NoPermission r101, ApplyPermissionPageMode r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "mode");
        this.f232872a = r100;
        this.f232873b = r101;
        this.f232874c = r102;
        this.f232876e = new CompositeDisposable();
        this.f232877f = LazyKt.lazy(new ApplyPermissionController$normalViewModel$2(this));
        this.f232878g = LazyKt.lazy(new ApplyPermissionController$auditFetcher$2(this));
    }
}
