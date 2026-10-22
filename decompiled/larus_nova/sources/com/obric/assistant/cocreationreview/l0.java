package com.obric.assistant.cocreationreview;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public interface l0 {

    public static final class a {
        public static void a(com.obric.assistant.cocreationreview.a r100, Vote r101, j1 r102, k1 r103) {
            Intrinsics.checkNotNullParameter(r100, "record");
            Intrinsics.checkNotNullParameter(r101, "vote");
            Intrinsics.checkNotNullParameter(r102, "defaultAction");
            Intrinsics.checkNotNullParameter(r103, "showDetailAction");
            r102.invoke();
        }
    }

    e5 a(Context r100);

    l5 b();

    w5 c(j5 r100, com.obric.assistant.cocreationreview.a r101, a5 r102, boolean r103, b r104);

    String d(com.obric.assistant.cocreationreview.a r100);

    ModuleKey e();

    void f(com.obric.assistant.cocreationreview.a r100, Vote r101, j1 r102, k1 r103);
}
