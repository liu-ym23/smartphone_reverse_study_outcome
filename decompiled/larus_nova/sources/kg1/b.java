package kg1;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f503347a = null;

    static {
        f503347a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        lg1.b r101 = (lg1.b) r100;
        String r102 = d.f503349a;
        if (r101.b() != 0) goto L9;
        List<lg1.a> r103 = r101.a();
        if (r103 == null) goto L9;
        if ((!r103.isEmpty()) != true) goto L9;
        boolean r104 = true;
    L10:
        d.f503353e = r104;
        d.a(r104, true);
        return;
    L9:
        r104 = false;
        goto L10
    }
}
