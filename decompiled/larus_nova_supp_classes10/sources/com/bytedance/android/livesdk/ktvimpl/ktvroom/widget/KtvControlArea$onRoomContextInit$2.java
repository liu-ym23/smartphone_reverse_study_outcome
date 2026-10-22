package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvControlArea$onRoomContextInit$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public KtvControlArea$onRoomContextInit$2(l r8) {
        super(1, r8, l.class, "updateControlButtonVisibilityForChallenge", "updateControlButtonVisibilityForChallenge(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r3) {
        l r0 = (l) ((CallableReference) this).receiver;
        int r1 = l.x;
        r0.d(r3);
    }
}
