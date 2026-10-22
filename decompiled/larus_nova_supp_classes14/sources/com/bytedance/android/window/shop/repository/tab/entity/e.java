package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class e implements QModel {
    public static final /* synthetic */ int e = 0;
    public final ECUrlModel a;
    public final ECUrlModel b;
    public final long c;
    public final String d;

    public static final class a {
    }

    static {
    }

    public int modelType() {
        return 0;
    }

    public float b() {
        ECUrlModel r0 = this.a;
        if (r0 == null) goto L5;
        float r1 = r0.getWidth();
        float r2 = RangesKt.coerceAtLeast(this.a.getHeight(), 0.01f);
    L7:
        return RangesKt.coerceIn(r1 / r2, 0.01f, 100.0f);
    L5:
        r1 = this.b.getWidth();
        r2 = RangesKt.coerceAtLeast(this.b.getHeight(), 0.01f);
        goto L7
    }

    public e(ECUrlModel r2, ECUrlModel r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r3, "cover");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
    }
}
