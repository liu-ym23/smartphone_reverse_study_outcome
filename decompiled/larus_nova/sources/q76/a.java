package q76;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a<Element> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Element> f531971a;

    /* JADX INFO: renamed from: q76.a$a, reason: collision with other inner class name */
    public interface InterfaceC7294a<Element> {
        void a(Element r100);
    }

    public static final class b implements InterfaceC7294a<Element> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Element, Unit> f531972a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Element, Unit> r100) {
            this.f531972a = r100;
        }

        @Override // q76.a.InterfaceC7294a
        public final void a(Element r100) {
            this.f531972a.invoke(r100);
        }
    }

    public a() {
        this.f531971a = new CopyOnWriteArrayList();
    }

    public final void a(Function1<? super Element, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        b r101 = new b(r100);
        Intrinsics.checkNotNullParameter(r101, "action");
        Iterator<Element> r102 = this.f531971a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        r101.a(r102.next());     // Catch: Exception -> L8
        goto L4
    }
}
