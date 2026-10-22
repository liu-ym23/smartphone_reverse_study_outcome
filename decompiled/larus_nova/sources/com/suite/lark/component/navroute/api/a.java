package com.suite.lark.component.navroute.api;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.suite.lark.component.navroute.api.g;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public interface a<T extends g, B> {

    /* JADX INFO: renamed from: com.suite.lark.component.navroute.api.a$a, reason: collision with other inner class name */
    public static final class C5522a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f460252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lifecycle f460253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FragmentManager f460254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f460255d;

        public C5522a(Lifecycle r100, FragmentManager r101) {
            Intrinsics.checkNotNullParameter("selected_more", "requestKey");
            this.f460252a = "selected_more";
            this.f460253b = r100;
            this.f460254c = r101;
        }
    }

    C5522a a(Function1 r100);

    void b(com.suite.lark.component.navroute.fragment.c r100, g r101);

    boolean c(int r100, Bundle r101);

    void d(c<?> r100);

    boolean e(Bundle r100);

    void f(c<?> r100, Function1<? super B, Unit> r101);

    boolean g(String r100);

    void h(com.suite.lark.component.navroute.fragment.c r100, Function1 r101);

    void i(c r100, ForsetiNavOptions r101);
}
