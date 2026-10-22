package com.bytedance.ies.bullet.lynx;

import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.service.base.d1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class n {
    public n() {
    }

    public void afterReadTemplate(String r100, byte[] r101, q r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "lynxFile");
        Intrinsics.checkNotNullParameter(r102, "listener");
    }

    public void afterRender() {
    }

    public void beforeLoadTemplate() {
    }

    public void beforeLoadTemplateWithUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    public void beforeReadTemplate() {
    }

    public void beforeRender() {
    }

    public void loadTemplateError(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    public void loadTemplateError(Throwable r100) {
    }

    public void loadTemplateReady(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "resourceInfo");
    }

    public v26.l provideTaskConfig() {
        return null;
    }
}
