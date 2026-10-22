package com.bytedance.ee.bear.utils;

import android.content.ClipData;
import android.text.SpannableStringBuilder;
import db5.l;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public static Single<ClipData> a(SpannableStringBuilder r1, final String r2, l r3) {
        return Single.just(new db5.g(r1)).map(r3).map(new eb5.a()).flatMap(new b()).map(new c(r2));
    }
}
