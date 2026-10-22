package com.bytedance.awemeopen.apps.framework.utils;

import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "it", "invoke", "(Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;)V"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class AosFragmentOperateUtil$Companion$obtainFragmentWithConsumer$2 extends Lambda implements Function1 {
    public static final AosFragmentOperateUtil$Companion$obtainFragmentWithConsumer$2 INSTANCE = null;

    static {
        INSTANCE = new AosFragmentOperateUtil$Companion$obtainFragmentWithConsumer$2();
    }

    public AosFragmentOperateUtil$Companion$obtainFragmentWithConsumer$2() {
        super(1);
    }

    public final void invoke(AosBaseFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((AosBaseFragment) r1);
        return Unit.INSTANCE;
    }
}
