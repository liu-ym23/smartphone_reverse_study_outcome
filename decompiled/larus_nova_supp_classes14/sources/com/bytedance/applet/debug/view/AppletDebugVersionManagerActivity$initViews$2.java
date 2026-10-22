package com.bytedance.applet.debug.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppletDebugVersionManagerActivity$initViews$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public AppletDebugVersionManagerActivity$initViews$2(Object r8) {
        super(0, r8, AppletDebugVersionManagerActivity.class, "updateConfirmButtonState", "updateConfirmButtonState()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m980invoke() {
        AppletDebugVersionManagerActivity r0 = (AppletDebugVersionManagerActivity) ((CallableReference) this).receiver;
        int r1 = AppletDebugVersionManagerActivity.q;
        r0.S1();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m980invoke();
        return Unit.INSTANCE;
    }
}
