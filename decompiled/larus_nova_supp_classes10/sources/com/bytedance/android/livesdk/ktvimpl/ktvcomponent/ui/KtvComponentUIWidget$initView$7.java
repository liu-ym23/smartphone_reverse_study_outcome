package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvComponentUIWidget$initView$7 extends FunctionReferenceImpl implements Function0<Unit> {
    public KtvComponentUIWidget$initView$7(KtvComponentUIWidget r8) {
        super(0, r8, KtvComponentUIWidget.class, "switchUiByKtvChallenge", "switchUiByKtvChallenge()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m319invoke() {
        KtvComponentUIWidget r0 = (KtvComponentUIWidget) ((CallableReference) this).receiver;
        TokenCert r1 = KtvComponentUIWidget.y1;
        r0.getClass();
        if (KtvComponentUIWidget.kr() == false) goto L5;
        r0.rr();
        return;
    L5:
        r0.qr();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m319invoke();
        return Unit.INSTANCE;
    }
}
