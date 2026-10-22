package rb9;

import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import eb9.n;
import eb9.o;
import fb9.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<o<?>, Unit> f536994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<List<o<?>>> f536995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<List<? extends o<?>>, Unit> f536996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f536997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f536998e;

    @Override // fb9.i
    public final n n() {
        return this.f536997d;
    }

    @Override // fb9.i
    public final boolean o() {
        return this.f536998e;
    }

    @Override // fb9.i
    public final List<o<?>> b(List<? extends o<?>> r210) {
        Intrinsics.checkNotNullParameter(r210, "cards");
        List<? extends o<?>> r100 = r210;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L18;
        o r103 = (o) r102.next();
        n r104 = r103.f471910d;
        if (r104 == null) goto L16;
        if (r104 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L16;
        boolean r110 = true;
    L17:
        String r106 = r103.f471907a;
        Enum<?> r107 = r103.f471908b;
        DATA r111 = r103.f471909c;
        n r112 = r103.f471910d;
        long r113 = r103.f471912f;
        long r108 = r103.f471913g;
        long r109 = r103.f471914h;
        Intrinsics.checkNotNullParameter(r106, "id");
        Intrinsics.checkNotNullParameter(r107, "type");
        Intrinsics.checkNotNullParameter(r111, "data");
        r101.add(new o(r106, r107, r111, r112, r110, r113, r108, r109));
        goto L4
    L10:
        if (r104.a(this.f536997d) != true) goto L12;
        r105 = true;
    L16:
        r110 = false;
        goto L17
    L18:
        return r101;
    }

    @Override // fb9.i
    public final void f(o<?> r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        if (r100.f471910d != null) goto L5;
        return;
    L5:
        this.f536994a.invoke(r100);
    }

    @Override // fb9.i
    public final void h(n r100) {
        this.f536997d = r100;
    }

    @Override // fb9.i
    public final int i(n r100) {
        Intrinsics.checkNotNullParameter(r100, "selectionKey");
        Iterator<o<?>> r101 = this.f536995b.invoke().iterator();
        boolean r102 = false;
        int r103 = 0;
    L4:
        if (r101.hasNext() == false) goto L14;
        n r104 = r101.next().f471910d;
        if (r104 != null) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == true) goto L15;
        r103 = r103 + 1;
    L15:
        Integer r106 = Integer.valueOf(r103);
        if (r106.intValue() < 0) goto L18;
        r102 = true;
    L18:
        if (r102 == true) goto L21;
        r106 = null;
    L21:
        if (r106 != null) goto L23;
        return -1;
    L23:
        return r106.intValue();
    L8:
        if (r104.a(r100) != true) goto L10;
        r105 = true;
        goto L11
    L14:
        r103 = -1;
        goto L15
    }

    @Override // fb9.i
    public final void l(n r100) {
        n r101 = this.f536997d;
        if (r101 != null) goto L5;
        if (r100 != null) goto L5;
    L12:
        boolean r102 = true;
    L13:
        boolean r103 = !r102;
        this.f536997d = r100;
        if (r103 == true) goto L16;
        return;
    L16:
        this.f536996c.invoke(b(this.f536995b.invoke()));
        return;
    L5:
        r102 = false;
        if (r101 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L13;
    L8:
        if (r101.a(r100) != true) goto L10;
        r104 = true;
        goto L11
    }

    public d(Function1 r100, com.larus.home.impl.main.side_bar.feed.arch.b r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "cardSelectionHandler");
        Intrinsics.checkNotNullParameter(r101, "cardsProvider");
        Intrinsics.checkNotNullParameter(r102, "selectionChangedHandler");
        this.f536994a = r100;
        this.f536995b = r101;
        this.f536996c = r102;
        this.f536998e = true;
    }
}
