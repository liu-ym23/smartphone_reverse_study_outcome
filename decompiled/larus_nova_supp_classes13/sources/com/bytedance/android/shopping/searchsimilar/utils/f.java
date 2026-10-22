package com.bytedance.android.shopping.searchsimilar.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.searchsimilar.api.SimilarProductApi;
import com.bytedance.android.shopping.searchsimilar.view.SearchSimilarAuthorizationDialog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static boolean a;

    public f() {
    }

    static {
    }

    public static final void a(Context r3, boolean r4) {
        new Handler(Looper.getMainLooper()).postDelayed(new c(new SearchSimilarAuthorizationDialog(r3, r4)), 100);
        SimilarProductApi.a.getClass();
        SimilarProductApi r5 = SimilarProductApi.a.a;
        if (r5 == null) goto L5;
        Observable<CommerceBaseResponse> r6 = r5.updateShowSimilarProductGuide();
    L6:
        if (r6 == null) goto L12;
        Observable r7 = r6.subscribeOn(Schedulers.io());
        if (r7 == null) goto L12;
        Observable r8 = r7.observeOn(AndroidSchedulers.mainThread());
        if (r8 == null) goto L12;
        r8.subscribe(new d());
    L12:
        a = false;
        return;
    L5:
        r6 = null;
        goto L6
    }
}
