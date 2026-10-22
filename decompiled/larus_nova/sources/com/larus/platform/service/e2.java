package com.larus.platform.service;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.view.GradientMaskView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e2 implements com.larus.platform.api.f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e2 f365734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365735b = null;

    public e2() {
    }

    static {
        f365734a = new e2();
        f365735b = LazyKt.lazy(new d2());
    }

    public static com.larus.platform.api.f3 h() {
        return (com.larus.platform.api.f3) f365735b.getValue();
    }

    @Override // com.larus.platform.api.f3
    public final int f() {
        com.larus.platform.api.f3 r100 = h();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f();
    }

    @Override // com.larus.platform.api.f3
    public final int g() {
        com.larus.platform.api.f3 r100 = h();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.g();
    }

    @Override // com.larus.platform.api.f3
    public final boolean isPad() {
        com.larus.platform.api.f3 r100 = h();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isPad();
    }

    @Override // com.larus.platform.api.f3
    public final int d(Integer r100) {
        com.larus.platform.api.f3 r101 = h();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.d(r100);
    }

    @Override // com.larus.platform.api.f3
    public final int e(ViewGroup r100) {
        com.larus.platform.api.f3 r101 = h();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.e(r100);
    }

    @Override // com.larus.platform.api.f3
    public final boolean a(Activity r100, Configuration r101) {
        com.larus.platform.api.f3 r102 = h();
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.a(r100, r101);
    }

    @Override // com.larus.platform.api.f3
    public final void b(ChatConstraintLayout r100, List r101) {
        Intrinsics.checkNotNullParameter(r101, "blockViewIds");
        com.larus.platform.api.f3 r102 = h();
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.f3
    public final void c(LinearLayoutManager r100, GradientMaskView r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        Intrinsics.checkNotNullParameter(r101, "maskView");
        com.larus.platform.api.f3 r103 = h();
        if (r103 == null) goto L6;
        r103.c(r100, r101, r102);
        return;
    }
}
