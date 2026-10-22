package v81;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import u81.f;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f553657a;

    public c(b r100) {
        this.f553657a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        Iterator r102 = ((ArrayList) this.f553657a.f553649a).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        f.a r103 = (f.a) r102.next();
        if (r103 == null) goto L4;
        r103.a();
        goto L4
    }
}
