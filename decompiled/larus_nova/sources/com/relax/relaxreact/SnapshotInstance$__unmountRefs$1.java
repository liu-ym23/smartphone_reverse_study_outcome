package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00010\u0003j\u0002`\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<no name provided>", "", BytedCertConstant.LivenessInfoConfigKey.FRAME_NUM, "Lkotlin/Function0;", "Lcom/relax/relaxreact/RefUnmount;", "_key", "", "Lcom/relax/relaxreact/RefKey;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class SnapshotInstance$__unmountRefs$1 extends Lambda implements Function2<Function0<? extends Unit>, String, Unit> {
    public static final SnapshotInstance$__unmountRefs$1 INSTANCE = null;

    static {
        INSTANCE = new SnapshotInstance$__unmountRefs$1();
    }

    public SnapshotInstance$__unmountRefs$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function0<Unit> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.LivenessInfoConfigKey.FRAME_NUM);
        Intrinsics.checkNotNullParameter(r101, "_key");
        r100.invoke();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
