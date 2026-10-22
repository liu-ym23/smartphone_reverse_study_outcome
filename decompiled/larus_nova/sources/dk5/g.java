package dk5;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements FlowableOnSubscribe<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f469010a;

    public g(e r100) {
        this.f469010a = r100;
    }

    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<List<String>> r100) {
        ck5.i r101 = this.f469010a.f469004b;
        r101.getClass();
        List<String> r102 = ((ck5.h) r101.a().c()).c();     // Catch: Exception -> L5
    L7:
        r100.onNext(r102);
        r100.onComplete();
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
        r102 = new ArrayList();
        goto L7
    }
}
