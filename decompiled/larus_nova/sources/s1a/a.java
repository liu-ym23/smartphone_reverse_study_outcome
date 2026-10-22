package s1a;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.context.internal.VContextStore;
import defpackage.s0;
import defpackage.t0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    public static final Fragment c(ComponentFeature r100) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return com.larus.ui.arch.component.internal.attach.a.b(r100, r100);
    }

    public static final boolean d(ComponentFeature r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (q1a.a.a(r100, r100).getResources().getConfiguration().orientation != 2) goto L6;
        boolean r102 = true;
    L7:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L9
    L11:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L15;
        r103 = r104;
    L15:
        return ((Boolean) r103).booleanValue();
    L6:
        r102 = false;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final boolean e(ComponentFeature r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        Bundle r102 = com.larus.ui.arch.component.internal.attach.a.b(r100, r100).getArguments();     // Catch: Throwable -> L10
        boolean r103 = false;
        if (r102 != null) goto L6;
    L8:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L10
    L12:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L16;
        r104 = r105;
    L16:
        return ((Boolean) r104).booleanValue();
    L6:
        if (r102.getBoolean("O_WINDOW_CHAT") != true) goto L8;
        r103 = true;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static final t1a.b g(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        FragmentManager r101 = r100.getFragmentManager();
        if (x1a.a.f562150a == false) goto L5;
    L13:
        if (r101 != null) goto L19;
        x1a.b r102 = x1a.a.f562152c;
        if (r102 == null) goto L18;
        r102.ensureNotReachHere(new IllegalStateException("Fragment is detached from Activity or not added to Activity."), "VContextExt.kt");
    L18:
        return new t0();
    L19:
        boolean r103 = c.f540187a;
        if (c.f540187a == true) goto L23;
        VContextStore.Companion.getClass();
        return VContextStore.a.a(r100).getOrInit(h(r100.requireActivity()));
    L23:
        b r104 = b.f540184a;
        monitor-enter(r104);
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);     // Catch: Throwable -> L34
        t1a.b r105 = b.f540185b.get(r100);     // Catch: Throwable -> L34
        monitor-exit(r104);
        if (r105 == null) goto L29;
        return r105;
    L29:
        boolean r106 = r100.getRetainInstance();
        VContextStore.Companion.getClass();
        t1a.b r107 = VContextStore.a.a(r100).getOrInit(h(r100.requireActivity()));
        if (r106 == false) goto L33;
        return r107;
    L33:
        return r104.a(r100, r101, r107);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (r100.isDetached() == false) goto L13;
        x1a.b r108 = x1a.a.f562152c;
        if (r108 == null) goto L9;
        r108.ensureNotReachHere(new IllegalStateException("Fragment is detached from Activity or not added to Activity."), "VContextExt.kt");
    L9:
        boolean r109 = c.f540187a;
        if (c.f540187a == true) goto L13;
        return new s0();
    }

    public static final FragmentActivity getActivity(ComponentFeature r100) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return q1a.a.a(r100, r100);
    }

    public static final t1a.b h(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        VContextStore.Companion.getClass();
        return VContextStore.getOrInit$default(VContextStore.a.a(r100), null, 1, null);
    }

    public static final void f(Fragment r100, Class<? extends t1a.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        g(r100).l(JvmClassMappingKt.getKotlinClass(r101));
    }

    public static final void a(Fragment r100, t1a.a r101, Class<? extends t1a.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "ability");
        Intrinsics.checkNotNullParameter(r102, "clazz");
        g(r100).k(r101, JvmClassMappingKt.getKotlinClass(r102));
    }

    public static final void b(FragmentActivity r100, t1a.a r101, Class<? extends t1a.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "ability");
        Intrinsics.checkNotNullParameter(r102, "clazz");
        h(r100).k(r101, JvmClassMappingKt.getKotlinClass(r102));
    }
}
