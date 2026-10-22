package com.bytedance.android.shopping.mall.homepage.card.common;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class BottomInfoView$nameSize$2 extends Lambda implements Function0<Float> {
    public static final BottomInfoView$nameSize$2 INSTANCE = null;

    static {
        INSTANCE = new BottomInfoView$nameSize$2();
    }

    public BottomInfoView$nameSize$2() {
        super(0);
    }

    public final float invoke() {
        if (com.bytedance.android.ec.hybrid.tools.e.b.getType().c() == false) goto L5;
        return 11.0f;
    L5:
        return 12.0f;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1217invoke() {
        return Float.valueOf(invoke());
    }
}
