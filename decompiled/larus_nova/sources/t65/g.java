package t65;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class g implements Consumer {
    public /* synthetic */ g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.l("ExceedLimitHandler", "reportCreateExceedQuotaEvent ", (Throwable) r100);
    }
}
