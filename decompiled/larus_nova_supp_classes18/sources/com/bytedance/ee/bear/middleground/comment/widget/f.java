package com.bytedance.ee.bear.middleground.comment.widget;

import android.text.SpannableStringBuilder;
import com.bytedance.ee.bear.widget.AtEditText;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends com.bytedance.ee.bear.widget.l {
    @Override // com.bytedance.ee.bear.widget.l
    public final Function<db5.a, db5.g> f() {
        return new g0(b());
    }

    @Override // com.bytedance.ee.bear.widget.l
    public final Single<String> g() {
        SpannableStringBuilder r0 = (SpannableStringBuilder) ((AtEditText) b()).getText();
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L8;
        if (r0 == null) goto L6;
        r0 = com.bytedance.ee.bear.middleground.comment.input.utils.d.a(r0);
        goto L8
    L6:
        r0 = null;
    L8:
        return Single.just(new db5.g(r0)).map(new i0()).map(new db5.f()).map(new db5.e());
    }

    public f(AtEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        super(r2);
    }
}
