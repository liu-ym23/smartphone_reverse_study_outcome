package com.bytedance.jedi.model.repository;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00052\u0006\u0010\u0007\u001a\u0002H\u0003H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "curV", "newV", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class SyncExtensions$syncRemovedItemTo$1 extends Lambda implements Function2 {
    public static final SyncExtensions$syncRemovedItemTo$1 INSTANCE = null;

    static {
        INSTANCE = new SyncExtensions$syncRemovedItemTo$1();
    }

    public SyncExtensions$syncRemovedItemTo$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(Object r100, Object r101) {
        return Boolean.valueOf(Intrinsics.areEqual(r100, r101));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke(r100, r101);
    }
}
