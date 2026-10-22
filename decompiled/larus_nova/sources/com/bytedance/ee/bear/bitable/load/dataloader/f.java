package com.bytedance.ee.bear.bitable.load.dataloader;

import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppLoader f214536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f214537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f214538c;

    public f(BitableAppLoader r100, String r101, long r102) {
        this.f214536a = r100;
        this.f214537b = r101;
        this.f214538c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Throwable r111 = (Throwable) r110;
        Intrinsics.checkNotNullParameter(r111, LynxError.LYNX_THROWABLE);
        if ((r111 instanceof TimeoutException) == false) goto L5;
        String r100 = "timeout";
    L6:
        String r101 = r100;
        tt5.a.l("BitableAppLoader", "queryAppClientVarsPreloadData failed: preloadQueryResult=".concat(r101), r111);
        BitableAppLoader r102 = this.f214536a;
        String r112 = this.f214537b;
        long r103 = this.f214538c;
        String r104 = r111.getMessage();
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r102.m(r112, new BitableAppLoader.a(r103, -1, r104, BitableAppLoader.j(this.f214536a, r111), "preload", r101, 32), r111);
        return;
    L5:
        r100 = "rust_error";
        goto L6
    }
}
