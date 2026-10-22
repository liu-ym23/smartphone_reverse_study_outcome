package com.bytedance.jedi.model.repository;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\b\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001\"\u0004\b\u0003\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "K1", "K", "V", OuterPayLoginWrapper.LOGIN_STYLE_V1, "it", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class SyncExtensions$syncChangedItemTo$4 extends Lambda implements Function1 {
    public static final SyncExtensions$syncChangedItemTo$4 INSTANCE = null;

    static {
        INSTANCE = new SyncExtensions$syncChangedItemTo$4();
    }

    public SyncExtensions$syncChangedItemTo$4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        if (r100 != null) goto L4;
        r100 = null;
    L4:
        if (r100 == null) goto L7;
        return r100;
    L7:
        throw new RuntimeException();
    }
}
