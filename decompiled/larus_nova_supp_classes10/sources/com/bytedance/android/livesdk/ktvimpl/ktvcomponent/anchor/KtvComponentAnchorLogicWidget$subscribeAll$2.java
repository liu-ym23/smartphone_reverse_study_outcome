package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import gd0.v;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvComponentAnchorLogicWidget$subscribeAll$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public KtvComponentAnchorLogicWidget$subscribeAll$2(KtvComponentAnchorLogicWidget r8) {
        super(1, r8, KtvComponentAnchorLogicWidget.class, "handleKtvAllStateChanged", "handleKtvAllStateChanged(I)V", 0);
    }

    public final void invoke(int r3) {
        KtvComponentAnchorLogicWidget r0 = (KtvComponentAnchorLogicWidget) ((CallableReference) this).receiver;
        int r1 = KtvComponentAnchorLogicWidget.q;
        boolean r4 = v.a(r3, 8);
        r0.Lq(!r4);
        if (r4 == false) goto L16;
        KtvComponentContext r5 = KtvComponentContext.Companion.getContext();
        if (r5 == null) goto L9;
        com.bytedance.live.datacontext.n<Integer> r6 = r5.getKtvComponentStatus();
        if (r6 == null) goto L9;
        Integer r7 = (Integer) r6.getValue();
    L10:
        if (r7 != null) goto L13;
        return;
    L13:
        if (r7.intValue() != 1) goto L17;
        r0.yq(false, "function_switch");
        return;
    L17:
        return;
    L9:
        r7 = null;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
