package com.ss.android.lark.biz.im.api.extension.scroll;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f410241a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f410242a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C4769a f410243b = null;

        /* JADX INFO: renamed from: com.ss.android.lark.biz.im.api.extension.scroll.e$a$a, reason: collision with other inner class name */
        public static final class C4769a implements e {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C4769a f410244b = null;

            static {
                f410244b = new C4769a();
            }

            public C4769a() {
            }

            @Override // com.ss.android.lark.biz.im.api.extension.scroll.e
            public final void a(String r100, ScrollEvent r101) {
                Intrinsics.checkNotNullParameter(r100, "<unused var>");
                Intrinsics.checkNotNullParameter(r101, "<unused var>");
            }
        }

        public a() {
        }

        static {
            f410242a = new a();
            f410243b = C4769a.f410244b;
        }
    }

    static {
        f410241a = a.f410242a;
    }

    void a(String r100, ScrollEvent r101);
}
