package com.bytedance.ies.bullet.core;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface q extends s {

    public static class a implements q {
        public a() {
        }

        @Override // com.bytedance.ies.bullet.core.s
        public void HP(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.s
        public void LG(Uri r100, com.bytedance.ies.bullet.service.base.o r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.s
        public void Ox(Uri r100, h16.e r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.s
        public void TH(Uri r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "e");
        }

        @Override // com.bytedance.ies.bullet.core.s
        public void bK(Uri r100, com.bytedance.ies.bullet.service.base.o r101, t36.j r102) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r102, "schemaModelUnion");
        }

        @Override // com.bytedance.ies.bullet.core.s
        public void gQ(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.s
        public u26.b getLynxClient() {
            return null;
        }

        @Override // com.bytedance.ies.bullet.core.s
        public void go(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.q
        public void lX() {
        }

        @Override // com.bytedance.ies.bullet.core.q
        public void onClose() {
        }

        @Override // com.bytedance.ies.bullet.core.s
        public void onLoadFail(Uri r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "e");
        }

        @Override // com.bytedance.ies.bullet.core.q
        public void onOpen() {
        }

        @Override // com.bytedance.ies.bullet.core.q
        public void rS() {
        }
    }

    void lX();

    void onClose();

    void onOpen();

    void rS();
}
