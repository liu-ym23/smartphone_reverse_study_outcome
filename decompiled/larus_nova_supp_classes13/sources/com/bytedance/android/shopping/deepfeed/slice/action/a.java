package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a implements v {
    public v a;
    public Map<String, ? extends Object> b;

    public a() {
    }

    public abstract boolean d(IAction r1, View r2);

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public void dispose() {
        v r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public final void a(v r2) {
        Intrinsics.checkNotNullParameter(r2, "next");
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public void b(Map r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public boolean m(final IAction r4, View r5) {
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "targetView");
        if (this.b != null) goto L5;
        IAction r1 = r4;
    L13:
        if (r4.getDisable() == false) goto L15;
    L17:
        v r0 = this.a;
        if (r0 != null) goto L20;
        return true;
    L20:
        return r0.m(r4, r5);
    L15:
        if (d(r1, r5) == false) goto L17;
        return true;
    L5:
        final LinkedHashMap r2 = new LinkedHashMap();
        Map r3 = r4.getParams();
        if (r3 == null) goto L8;
        r2.putAll(r3);
    L8:
        Map<String, ? extends Object> r6 = this.b;
        if (r6 == null) goto L11;
        r2.putAll(r6);
    L11:
        r1 = new AbsDeepFeedAction$mergeData$3(r4, r2);
        goto L13
    }
}
