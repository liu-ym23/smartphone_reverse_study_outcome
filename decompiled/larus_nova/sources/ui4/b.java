package ui4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b<DATA, STATE> implements ti4.w<DATA, STATE> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f550153b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ti4.x<DATA, STATE>> f550154a;

    public static final class a {
        public static b a(List r100) {
            Intrinsics.checkNotNullParameter(r100, "defaultHandlers");
            b r101 = new b();
            Iterator r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r101.b((ti4.x) r102.next());
            goto L4
        L6:
            return r101;
        }
    }

    static {
    }

    public b() {
        this.f550154a = new ArrayList();
    }

    @Override // ti4.w
    public final void a(Function1<? super ti4.x<DATA, STATE>, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        CollectionsKt.removeAll(this.f550154a, r100);
    }

    @Override // ti4.w
    public final void b(ti4.x<DATA, STATE> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        ((ArrayList) this.f550154a).add(r100);
    }

    @Override // ti4.x
    public final void c(DATA r100, int r101, STATE r102) {
        Iterator r103 = ((ArrayList) this.f550154a).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((ti4.x) r103.next()).c(r100, r101, r102);
        goto L4
    }
}
