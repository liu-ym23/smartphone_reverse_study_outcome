package com.bytedance.android.livesdk.livecommerce.room.quick;

import bk2.a;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/quick/ActionObserver;", "T", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lbk2/a;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActionObserver<T> implements Observer<a<? extends T>> {
    public final Function1<T, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public ActionObserver(Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onActionUnhandledContent");
        this.a = r2;
    }

    public final void onChanged(Object r2) {
        a r3 = (a) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.a == false) goto L7;
        T r4 = null;
    L8:
        if (r4 == null) goto L12;
        this.a.invoke(r4);
        return;
    L12:
        return;
    L7:
        r3.a = true;
        r4 = r3.b;
        goto L8
    }
}
