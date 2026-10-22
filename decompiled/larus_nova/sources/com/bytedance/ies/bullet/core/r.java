package com.bytedance.ies.bullet.core;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.d1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface r extends q {

    public static class a extends q.a implements r {
        @Override // com.bytedance.ies.bullet.core.r
        public final void loadTemplateError(Throwable r100) {
        }

        public void vH(com.bytedance.ies.bullet.service.base.o r100) {
        }

        public void yO(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
        }

        public a() {
        }

        @Override // com.bytedance.ies.bullet.core.r
        public final void QP(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r100, "url");
        }

        @Override // com.bytedance.ies.bullet.core.r
        public final void loadTemplateReady(d1 r100) {
            Intrinsics.checkNotNullParameter(r100, "resourceInfo");
            Intrinsics.checkNotNullParameter(r100, "resourceInfo");
        }
    }

    void QP(String r100);

    void loadTemplateError(Throwable r100);

    void loadTemplateReady(d1 r100);

    void vH(com.bytedance.ies.bullet.service.base.o r100);

    void yO(Uri r100, com.bytedance.ies.bullet.service.base.o r101);
}
