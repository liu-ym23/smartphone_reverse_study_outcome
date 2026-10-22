package com.ss.android.lark.imageocr.mvp;

import android.os.Handler;
import android.os.Looper;
import com.larksuite.framework.mvp.BaseModel;
import com.ss.android.lark.imageocr_export.OCRParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCRParams f426467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f426468b;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.BaseModel, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        this.f426468b.removeCallbacksAndMessages(null);
    }

    public b(OCRParams r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f426467a = r100;
        this.f426468b = new Handler(Looper.getMainLooper());
    }
}
