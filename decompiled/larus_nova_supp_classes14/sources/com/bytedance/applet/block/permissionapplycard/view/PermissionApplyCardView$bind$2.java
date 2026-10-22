package com.bytedance.applet.block.permissionapplycard.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PermissionApplyCardView$bind$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public PermissionApplyCardView$bind$2(Object r8) {
        super(0, r8, mi8.e.class, "onRefuse", "onRefuse()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m979invoke() {
        ((mi8.e) ((CallableReference) this).receiver).onRefuse();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m979invoke();
        return Unit.INSTANCE;
    }
}
