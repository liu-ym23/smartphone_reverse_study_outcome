package com.bytedance.ies.bullet.core;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface s {

    public static class a implements s {
        public a() {
        }

        @Override // com.bytedance.ies.bullet.core.s
        public final void HP(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.s
        public final void Ox(Uri r100, h16.e r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.s
        public final void TH(Uri r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "e");
        }

        @Override // com.bytedance.ies.bullet.core.s
        public final void bK(Uri r100, com.bytedance.ies.bullet.service.base.o r101, t36.j r102) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r102, "schemaModelUnion");
        }

        @Override // com.bytedance.ies.bullet.core.s
        public final u26.b getLynxClient() {
            return null;
        }

        @Override // com.bytedance.ies.bullet.core.s
        public final void go(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.s
        public final void onLoadFail(Uri r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "e");
        }
    }

    void HP(Uri r100, com.bytedance.ies.bullet.service.base.o r101);

    void LG(Uri r100, com.bytedance.ies.bullet.service.base.o r101, Throwable r102);

    void Ox(Uri r100, h16.e r101);

    void TH(Uri r100, Throwable r101);

    void bK(Uri r100, com.bytedance.ies.bullet.service.base.o r101, t36.j r102);

    void gQ(Uri r100, com.bytedance.ies.bullet.service.base.o r101);

    u26.b getLynxClient();

    void go(Uri r100, com.bytedance.ies.bullet.service.base.o r101);

    void onLoadFail(Uri r100, Throwable r101);
}
