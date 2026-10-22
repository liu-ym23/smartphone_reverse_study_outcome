package com.bytedance.android.shopping.feed.utils;

import android.view.View;
import com.bytedance.android.shopping.feed.repository.dto.PreviewWillListResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 implements Observer<PreviewWillListResponse> {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ View c;

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        int r4 = ProductFeedActionHelper.a;
        ProductFeedActionHelper.a(this.c.getContext(), false, this.b);
    }

    public final void onNext(Object r3) {
        PreviewWillListResponse r4 = (PreviewWillListResponse) r3;
        Intrinsics.checkNotNullParameter(r4, "t");
        if (r4.getStatusCode() != 0) goto L5;
        this.a.invoke(Boolean.valueOf(!this.b));
        int r5 = ProductFeedActionHelper.a;
        ProductFeedActionHelper.a(this.c.getContext(), true, this.b);
        return;
    L5:
        int r6 = ProductFeedActionHelper.a;
        ProductFeedActionHelper.a(this.c.getContext(), false, this.b);
    }

    public a0(Function1 r1, boolean r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
