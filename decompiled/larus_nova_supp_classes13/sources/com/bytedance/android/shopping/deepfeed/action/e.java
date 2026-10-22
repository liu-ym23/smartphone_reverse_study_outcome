package com.bytedance.android.shopping.deepfeed.action;

import android.content.Context;
import com.bytedance.android.shopping.anchorv3.repository.dto.PreviewWillListResponse;
import he3.i1;
import he3.p0;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ p0 c;
    public final /* synthetic */ Function1 d;

    public e(d r1, boolean r2, p0 r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r4) {
        PreviewWillListResponse r5 = (PreviewWillListResponse) r4;
        com.bytedance.android.ec.sdk.helper.i r6 = com.bytedance.android.ec.sdk.helper.i.a;
        Context r0 = this.a.getContext();
        if (this.b == false) goto L5;
        String r1 = "已取消收藏";
    L6:
        r6.e(r0, r1, false, false);
        p0 r7 = this.c;
        if (r7 == null) goto L11;
        i1 r8 = r7.e();
        if (r8 == null) goto L11;
        r8.c(Boolean.valueOf(!this.b));
    L11:
        Function1 r9 = this.d;
        if (r9 == null) goto L15;
        Unit r10 = (Unit) r9.invoke(Boolean.valueOf(!this.b));
        return;
    L15:
        return;
    L5:
        r1 = "添加收藏成功";
        goto L6
    }
}
