package lf6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f509064b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f509065a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c> f509066a;

        public a() {
            this.f509066a = new ArrayList();
        }
    }

    public static final class b {
    }

    static {
    }

    public d(List r100) {
        this.f509065a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Function1<? super c, Unit> r100) {
        Iterator<T> r101 = this.f509065a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke(r101.next());
        goto L4
    }
}
