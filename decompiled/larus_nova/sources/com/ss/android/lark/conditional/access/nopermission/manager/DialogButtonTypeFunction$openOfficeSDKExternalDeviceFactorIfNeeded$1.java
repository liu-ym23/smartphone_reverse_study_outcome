package com.ss.android.lark.conditional.access.nopermission.manager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class DialogButtonTypeFunction$openOfficeSDKExternalDeviceFactorIfNeeded$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public DialogButtonTypeFunction$openOfficeSDKExternalDeviceFactorIfNeeded$1(Object r100) {
        super(0, r100, SecurityPolicyDialogActionManager.class, "exitDialog", "exitDialog()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((SecurityPolicyDialogActionManager) this.receiver).getClass();
        SecurityPolicyDialogActionManager.b();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
