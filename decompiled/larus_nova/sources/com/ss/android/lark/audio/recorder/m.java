package com.ss.android.lark.audio.recorder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface m {

    public static final class a {
        public static void a(p r100) {
            Intrinsics.checkNotNullParameter(r100, "recordTask");
            m r101 = r100.a(4);
            r100.b(r101);
            r101.b(r100);
        }
    }

    boolean a();

    void b(p r100);

    void c(p r100);

    void d(p r100);

    void e(p r100);

    void f(p r100);
}
