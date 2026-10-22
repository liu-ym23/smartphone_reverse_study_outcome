package com.larus.platform.service;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.pia.core.metrics.ErrorType;
import com.larus.platform.api.PermissionHelperDelegate;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class i2 implements com.larus.platform.api.g1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i2 f365748b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f365749c = null;

    public i2() {
    }

    static {
        f365748b = new i2();
        f365749c = LazyKt.lazy(new h2());
    }

    public static com.larus.platform.api.g1 p() {
        return (com.larus.platform.api.g1) f365749c.getValue();
    }

    @Override // com.larus.platform.api.g1
    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        com.larus.platform.api.g1 r101 = p();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.d(r100) != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.g1
    public final void f(boolean r100) {
        com.larus.platform.api.g1 r101 = p();
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.larus.platform.api.g1
    public final void i(FragmentActivity r100, com.larus.platform.api.g1.c r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        com.larus.platform.api.g1 r102 = p();
        if (r102 == null) goto L6;
        r102.i(r100, r101);
        return;
    }

    public static void q(Fragment r100, List r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
        if (r100 != null) goto L5;
    L11:
        PermissionHelperDelegate.f364836b.permission(r101, r102);
        return;
    L5:
        if (PermissionHelperDelegate.f364836b.isConditionMet(r100.getActivity()) == true) goto L11;
        com.larus.platform.api.g1 r103 = p();
        if (r103 == null) goto L13;
        r103.b(r100, r101, r102, null);
        return;
    }

    @Override // com.larus.platform.api.g1
    public final void a(FragmentActivity r100, List<String> r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
        if (r100 != null) goto L5;
    L11:
        PermissionHelperDelegate.f364836b.permission(r101, r102);
        return;
    L5:
        if (PermissionHelperDelegate.f364836b.isConditionMet(r100) == true) goto L11;
        com.larus.platform.api.g1 r103 = p();
        if (r103 == null) goto L13;
        r103.a(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.g1
    public final void m(FragmentActivity r100, List<String> r101, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
        if (r100 != null) goto L5;
    L11:
        PermissionHelperDelegate.f364836b.permissionForDetail(r101, r102);
        return;
    L5:
        if (PermissionHelperDelegate.f364836b.isConditionMet(r100) == true) goto L11;
        com.larus.platform.api.g1 r103 = p();
        if (r103 == null) goto L13;
        r103.m(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.g1
    public final void b(Fragment r100, List<String> r101, Function1<? super Boolean, Unit> r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
        if (r100 != null) goto L5;
    L11:
        PermissionHelperDelegate.f364836b.permission(r101, r102, r103);
        return;
    L5:
        if (PermissionHelperDelegate.f364836b.isConditionMet(r100.getActivity()) == true) goto L11;
        com.larus.platform.api.g1 r104 = p();
        if (r104 == null) goto L13;
        r104.b(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.platform.api.g1
    public final void l(FragmentActivity r100, String r101, String r102, com.larus.platform.api.g1.b r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "permission");
        com.larus.platform.api.g1 r104 = p();
        if (r104 == null) goto L6;
        r104.l(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.platform.api.g1
    public final void j(Fragment r100, FragmentActivity r101, List<String> r102, JSONObject r110, com.larus.platform.api.g1.c r111) {
        Intrinsics.checkNotNullParameter(r102, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r111, "requestCallBack");
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
    L7:
        PermissionHelperDelegate.f364836b.permissionAny(r102, r111);
        return;
    L6:
        if (PermissionHelperDelegate.f364836b.isConditionMet(r101) == true) goto L7;
        com.larus.platform.api.g1 r103 = p();
        if (r103 == null) goto L13;
        r103.j(r100, r101, r102, r110, r111);
        return;
    }

    @Override // com.larus.platform.api.g1
    public final void k(Fragment r100, List<String> r110, com.larus.platform.api.g1.c r111, Map<String, String> r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r110, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r111, "requestCallBack");
        if (r100 != null) goto L5;
    L11:
        PermissionHelperDelegate.f364836b.permission(r110, r111, r112, r113, true);
        return;
    L5:
        if (PermissionHelperDelegate.f364836b.isConditionMet(r100.getActivity()) == true) goto L11;
        com.larus.platform.api.g1 r101 = p();
        if (r101 == null) goto L13;
        r101.k(r100, r110, r111, r112, r113);
        return;
    }

    @Override // com.larus.platform.api.g1
    public final void g(FragmentActivity r100, List<String> r110, com.larus.platform.api.g1.c r111, Map<String, String> r112, JSONObject r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r111, "requestCallBack");
        if (r100 != null) goto L5;
    L11:
        PermissionHelperDelegate.f364836b.permission(r110, r111, r112, r113, r114);
        return;
    L5:
        if (PermissionHelperDelegate.f364836b.isConditionMet(r100) == true) goto L11;
        com.larus.platform.api.g1 r101 = p();
        if (r101 == null) goto L13;
        r101.g(r100, r110, r111, r112, r113, r114);
        return;
    }
}
