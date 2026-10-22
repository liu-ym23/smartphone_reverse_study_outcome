package mx4;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Unit r2 = (Unit) r1;
        this.a.h.c();
    }
}
