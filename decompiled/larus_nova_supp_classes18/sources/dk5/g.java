package dk5;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements FlowableOnSubscribe<List<String>> {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    public final void subscribe(FlowableEmitter<List<String>> r2) {
        ck5.i r0 = this.a.b;
        r0.getClass();
        List<String> r1 = ((ck5.h) r0.a().c()).c();     // Catch: Exception -> L5
    L7:
        r2.onNext(r1);
        r2.onComplete();
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
        r1 = new ArrayList();
        goto L7
    }
}
