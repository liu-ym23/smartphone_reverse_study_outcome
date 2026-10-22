package com.bytedance.jedi.model.repository;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0007\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", OuterPayLoginWrapper.LOGIN_STYLE_V1, "V", "cur", "new", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class SyncExtensions$syncChangedItemTo$6 extends Lambda implements Function2 {
    public static final SyncExtensions$syncChangedItemTo$6 INSTANCE = null;

    static {
        INSTANCE = new SyncExtensions$syncChangedItemTo$6();
    }

    public SyncExtensions$syncChangedItemTo$6() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        if (r101 != null) goto L4;
        r101 = null;
    L4:
        if (r101 != null) goto L7;
        return r100;
    L7:
        return r101;
    }
}
