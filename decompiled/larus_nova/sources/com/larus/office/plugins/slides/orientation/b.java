package com.larus.office.plugins.slides.orientation;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f363455d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Integer, Boolean> f363456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f363457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f363458c;

    public static final class a {
    }

    static {
    }

    public b(FragmentActivity r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "onChange");
        this.f363456a = r101;
        this.f363457b = -1;
        c r102 = new c(r100, this);
        this.f363458c = r102;
        r102.enable();
    }
}
