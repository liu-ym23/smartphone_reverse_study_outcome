package com.bytedance.ee.bear.middleground.comment.share;

import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ SharePermissionViewModel a;
    public final /* synthetic */ Function1<Map<String, SharePermissionViewModel.b>, Unit> b;
    public final /* synthetic */ Map<String, SharePermissionViewModel.b> c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(SharePermissionViewModel r1, Function1<? super Map<String, SharePermissionViewModel.b>, Unit> r2, Map<String, SharePermissionViewModel.b> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        tt5.a.e(this.a.d, "fetchUserPermissions: ", r5, false);
        this.b.invoke(this.c);
    }
}
