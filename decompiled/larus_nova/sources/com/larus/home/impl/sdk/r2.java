package com.larus.home.impl.sdk;

import com.larus.platform.api.r3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class r2 implements r3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r2 f346229b = null;

    public static final class a implements r3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rx9.k f346230a;

        @Override // com.larus.platform.api.r3.b
        public final void end() {
            this.f346230a.a();
        }

        @Override // com.larus.platform.api.r3.b
        public final void start() {
            this.f346230a.b();
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f346230a = new rx9.k(r100);
        }
    }

    static {
        f346229b = new r2();
    }

    public r2() {
    }

    @Override // com.larus.platform.api.r3
    public final r3.b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new a(r100);
    }
}
