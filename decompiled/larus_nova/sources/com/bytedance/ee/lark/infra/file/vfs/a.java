package com.bytedance.ee.lark.infra.file.vfs;

import com.ss.android.lark.storage.file.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3476a f242794a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C3476a f242795b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C3476a f242796c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C3476a f242797d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C3476a f242798e = null;

    /* JADX INFO: renamed from: com.bytedance.ee.lark.infra.file.vfs.a$a, reason: collision with other inner class name */
    public static final class C3476a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f242799a;

        @Override // com.ss.android.lark.storage.file.b
        public final String getName() {
            return this.f242799a;
        }

        public C3476a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f242799a = r100;
        }
    }

    static {
        f242794a = new C3476a("file");
        f242795b = new C3476a("cache_root");
        f242796c = new C3476a("user");
        f242797d = new C3476a("temp");
        f242798e = new C3476a("private_tmp");
    }
}
