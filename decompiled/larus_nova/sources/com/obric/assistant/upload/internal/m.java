package com.obric.assistant.upload.internal;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f393570a = 0;

    static {
    }

    public static void a(String r100, Exception r101) {
        Intrinsics.checkNotNullParameter("ObricUploadImageCompress", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "e");
        FLogger.f375446a.e("ObricUpload_ObricUploadImageCompress", "thread[name: " + ThreadMethodProxy.currentThread().getName() + "] -- " + r100, r101);
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.e("ObricUpload_".concat(r100), "thread[name: " + ThreadMethodProxy.currentThread().getName() + "] -- " + r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i("ObricUpload_".concat(r100), "thread[name: " + ThreadMethodProxy.currentThread().getName() + "] -- " + r101);
    }
}
