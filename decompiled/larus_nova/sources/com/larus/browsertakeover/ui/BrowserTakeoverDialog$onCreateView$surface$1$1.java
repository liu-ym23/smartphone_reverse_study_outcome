package com.larus.browsertakeover.ui;

import com.larus.browsertakeover.session.BrowserTakeoverSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class BrowserTakeoverDialog$onCreateView$surface$1$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public BrowserTakeoverDialog$onCreateView$surface$1$1(Object r100) {
        super(1, r100, BrowserTakeoverSession.class, "onFirstFrameSubmitted", "onFirstFrameSubmitted(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r100) {
        ((BrowserTakeoverSession) this.receiver).onFirstFrameSubmitted(r100);
    }
}
