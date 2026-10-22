package com.ss.android.lark.forwardv2.sharefile;

import com.ss.android.lark.forwardv2.e;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import hib.d;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b<T> implements RxScheduledExecutor.Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f425046a = null;

    static {
        f425046a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
    public final void consume(Object r100) {
        File r101 = (File) r100;
        Log.i("FileShareEnhancedView", "click open local preview file");
        d r102 = e.f424890a;
        com.ss.android.lark.forwardv2.a r103 = e.a.a().g();
        Intrinsics.checkNotNull(r101);
        r103.a(r101);
    }
}
