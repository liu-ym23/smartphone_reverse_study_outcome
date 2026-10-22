package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.Context;
import com.bytedance.ee.bear.VisibleSecretResult;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface d {
    o a(n r1, Context r2);

    Flowable<Boolean> b(c0 r1);

    Flowable<VisibleSecretResult> c(String r1, int r2);

    Flowable<Boolean> d(String r1, int r2, String r3, int r4, int r5);
}
