package com.bytedance.jedi.model.merge;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\n\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0001\"\u0004\b\u0004\u0010\u0002\"\u0004\b\u0005\u0010\u0003\"\u0004\b\u0006\u0010\u0004\"\u0004\b\u0007\u0010\u00012\u0006\u0010\u0005\u001a\u0002H\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00032\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0001H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", OuterPayLoginWrapper.LOGIN_STYLE_V1, "K", "V", "K1", "<anonymous parameter 0>", "newV", "<anonymous parameter 2>", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class MergeStrategy$Companion$keyMerge$2 extends Lambda implements Function3<Object, Object, Object, Object> {
    public static final MergeStrategy$Companion$keyMerge$2 INSTANCE = null;

    static {
        INSTANCE = new MergeStrategy$Companion$keyMerge$2();
    }

    public MergeStrategy$Companion$keyMerge$2() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object r100, Object r101, Object r102) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101;
    }
}
