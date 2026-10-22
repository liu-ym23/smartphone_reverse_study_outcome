package com.permissionx.guolindev.request;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f404377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f404378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f404379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f404380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f404381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f404382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f404383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f404384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<String> f404385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<String> f404386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<String> f404387k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<String> f404388l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public noa.b f404389m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public noa.a f404390n;

    public static final class a {
    }

    static {
    }

    public final FragmentManager a() {
        Fragment r100 = this.f404378b;
        if (r100 == null) goto L5;
        FragmentManager r101 = r100.getChildFragmentManager();
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return getActivity().getSupportFragmentManager();
    L5:
        r101 = null;
        goto L6
    }

    public final FragmentActivity getActivity() {
        FragmentActivity r100 = this.f404377a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        return null;
    }

    public final InvisibleFragment b() {
        Fragment r100 = a().findFragmentByTag("InvisibleFragment");
        if (r100 != null) goto L20;
        monitor-enter(this);
        InvisibleFragment r101 = new InvisibleFragment();     // Catch: Throwable -> L15
        if (a().findFragmentByTag("InvisibleFragment") != null) goto L13;
        FragmentTransaction r102 = a().beginTransaction();     // Catch: Throwable -> L15
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "InvisibleFragment", 0) == true) goto L12;
        r102 = r102.add(r101, "InvisibleFragment");     // Catch: Throwable -> L15
    L12:
        r102.commitNowAllowingStateLoss();     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return r101;
    L15:
        th = move-exception;
        throw th;
    L20:
        return (InvisibleFragment) r100;
    }

    public final int c() {
        return getActivity().getApplicationInfo().targetSdkVersion;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void d(Set<String> r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r101, "chainTask");
        InvisibleFragment r102 = b();
        Intrinsics.checkNotNullParameter(this, "permissionBuilder");
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r101, "chainTask");
        r102.f404354e = this;
        r102.f404355f = r101;
        ActivityResultLauncher<String[]> r103 = r102.f404356g;
        Object[] r104 = r100.toArray(new String[0]);
        if (r104 == null) goto L7;
        r103.launch(r104);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public o(FragmentActivity r100, Fragment r101, Set<String> r102, Set<String> r103) {
        Intrinsics.checkNotNullParameter(r102, "normalPermissions");
        Intrinsics.checkNotNullParameter(r103, "specialPermissions");
        this.f404379c = -1;
        this.f404383g = new LinkedHashSet();
        this.f404384h = new LinkedHashSet();
        this.f404385i = new LinkedHashSet();
        this.f404386j = new LinkedHashSet();
        this.f404387k = new LinkedHashSet();
        this.f404388l = new LinkedHashSet();
        if (r100 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f404377a = r100;
    L5:
        if (r100 != null) goto L8;
        if (r101 == null) goto L8;
        FragmentActivity r104 = r101.requireActivity();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f404377a = r104;
    L8:
        this.f404378b = r101;
        this.f404380d = r102;
        this.f404381e = r103;
    }
}
