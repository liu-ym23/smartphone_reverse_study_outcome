package com.bytedance.jedi.model.merge;

import com.amap.api.col.s.ce;
import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\t\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0002\"\u0004\b\u0005\u0010\u0003\"\u0004\b\u0006\u0010\u0001\"\u0004\b\u0007\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "K1", "K", "V", OuterPayLoginWrapper.LOGIN_STYLE_V1, ce.f26396k, "<anonymous parameter 1>", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class MergeStrategy$Companion$keyMerge$1 extends Lambda implements Function2<Object, Object, Object> {
    public static final MergeStrategy$Companion$keyMerge$1 INSTANCE = null;

    static {
        INSTANCE = new MergeStrategy$Companion$keyMerge$1();
    }

    public MergeStrategy$Companion$keyMerge$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        if (r100 != null) goto L4;
        r100 = null;
    L4:
        if (r100 == null) goto L7;
        return r100;
    L7:
        throw new RuntimeException();
    }
}
