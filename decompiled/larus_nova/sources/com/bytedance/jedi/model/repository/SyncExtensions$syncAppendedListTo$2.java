package com.bytedance.jedi.model.repository;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0006\b\u0001\u0010\u0004\u0018\u0001\"\u0006\b\u0002\u0010\u0005\u0018\u0001\"\u0006\b\u0003\u0010\u0002\u0018\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", OuterPayLoginWrapper.LOGIN_STYLE_V1, "K", "V", "K1", "it", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class SyncExtensions$syncAppendedListTo$2 extends Lambda implements Function1 {
    public static final SyncExtensions$syncAppendedListTo$2 INSTANCE = null;

    static {
        INSTANCE = new SyncExtensions$syncAppendedListTo$2();
    }

    public SyncExtensions$syncAppendedListTo$2() {
        super(1);
    }

    public final List invoke(List r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new RuntimeException();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        return invoke((List) r100);
    }
}
