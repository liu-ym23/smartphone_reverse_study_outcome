package com.bytedance.ee.bear.document.sharewords.view;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ i a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ HashMap<String, ForwardTarget> c;

    public l(i r1, Context r2, HashMap<String, ForwardTarget> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        Boolean r6 = (Boolean) r5;
        i r7 = this.a;
        Context r0 = this.b;
        int r1 = this.c.size();
        ForwardTarget r2 = (ForwardTarget) CollectionsKt.firstOrNull(this.c.values());
        r7.getClass();
        if (r1 != 1) goto L5;
        com.bytedance.ee.util.ui.j.f(new j(r0, r1, r2, r7));
    L6:
        Toast.cancelLoading();
        return;
    L5:
        com.bytedance.ee.util.ui.j.f(new j(r0, r1, null, r7));
        goto L6
    }
}
