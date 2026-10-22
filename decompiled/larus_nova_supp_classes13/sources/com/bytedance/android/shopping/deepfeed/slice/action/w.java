package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface w extends x, u, y {
    DeepFeedProductEventTracker A();

    void b(boolean r1);

    com.bytedance.android.shopping.deepfeed.action.d c();

    void d(String r1, List<String> r2, View r3);

    void g(String r1, String r2);

    void h(View r1, String r2);

    boolean i();

    vc3.c j(vc3.d r1);

    void m(Boolean r1, View r2);

    vc3.a n(String r1, String r2, String r3, boolean r4, View r5);

    vc3.b q();

    v r(String r1);

    String s(String r1);

    void t(Function1<? super String, Unit> r1);

    void u(String r1, boolean r2);

    boolean v();

    void w(int r1);

    void x(Function0<Unit> r1);

    void y(boolean r1);

    void z(int r1, String r2);
}
