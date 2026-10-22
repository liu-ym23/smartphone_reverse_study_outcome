package com.bytedance.ee.bear.bitable.document;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OfficeBitableLinkedDocxPlugin$showLinkedDocx$fragment$2 extends FunctionReferenceImpl implements Function1<Fragment, Unit> {
    public OfficeBitableLinkedDocxPlugin$showLinkedDocx$fragment$2(Object r100) {
        super(1, r100, b.class, "onLinkedDocxContentDetached", "onLinkedDocxContentDetached(Landroidx/fragment/app/Fragment;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((b) this.receiver).Gi(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Fragment r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
