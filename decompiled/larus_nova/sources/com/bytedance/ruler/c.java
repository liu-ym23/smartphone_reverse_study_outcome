package com.bytedance.ruler;

import android.os.Handler;
import com.bytedance.ruler.utils.ALogWrapper;
import com.bytedance.ruler.utils.AppLogWrapper;
import com.bytedance.ruler.utils.AsyncExecutorKt;
import com.bytedance.ruler.utils.AsyncExecutorKt$runInBackground$1;
import com.bytedance.ruler.utils.AsyncExecutorKt$runInBackground$2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.bytedance.express.b {
    public c() {
    }

    @Override // com.bytedance.express.b
    public final void a(final Function0<Unit> r100) {
        if (Intrinsics.areEqual(AsyncExecutorKt.f267756b.get(), Boolean.TRUE) == false) goto L5;
        AsyncExecutorKt.a(new AsyncExecutorKt$runInBackground$1(r100));
        return;
    L5:
        Handler r101 = com.bytedance.ruler.utils.a.f267757a;
        com.bytedance.ruler.utils.a.a(new AsyncExecutorKt$runInBackground$2(r100), 0);
    }

    @Override // com.bytedance.express.b
    public final void c(Function1<? super com.bytedance.express.util.a.b, Unit> r100) {
        AppLogWrapper r101 = d.f267684h;
        if (r101 == null) goto L6;
        r101.b("expr", r100);
        return;
    }

    @Override // com.bytedance.express.b
    public final void b(int r100, Function1<? super com.bytedance.express.util.a.C3487a, Unit> r101) {
        ALogWrapper r102 = d.f267685i;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
