package com.ss.ugc.effectplatform.algorithm;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public interface f {

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f457253a = null;

        public a() {
        }

        static {
            f457253a = new a();
        }

        @Override // com.ss.ugc.effectplatform.algorithm.f
        public final void loadLibrary(String r100) {
            Intrinsics.checkNotNullParameter(r100, "libName");
            FLogger r101 = FLogger.f375446a;
            r101.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r100));
            com.bytedance.librarian.a.c(r100);
            r101.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r100));
        }
    }

    void loadLibrary(String r100);
}
