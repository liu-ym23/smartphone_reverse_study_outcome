package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.format.parser.x;

/* JADX INFO: loaded from: classes42.dex */
public final class j<T> implements q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f505292a;

    @Override // kotlinx.datetime.internal.format.n
    public final huc.e<T> a() {
        return new huc.c(this.f505292a);
    }

    public final int hashCode() {
        return this.f505292a.hashCode();
    }

    @Override // kotlinx.datetime.internal.format.n
    public final kotlinx.datetime.internal.format.parser.u<T> parser() {
        if (this.f505292a.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        List r101 = CollectionsKt.emptyList();
    L48:
        return new kotlinx.datetime.internal.format.parser.u(r101, CollectionsKt.emptyList());
    L8:
        List r102 = CollectionsKt.createListBuilder();
        String r103 = "";
        if (guc.d.a(this.f505292a.charAt(0)) == false) goto L23;
        String r104 = this.f505292a;
        int r105 = r104.length();
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L16;
        if (guc.d.a(r104.charAt(r106)) == false) goto L14;
        r106 = r106 + 1;
        goto L11
    L14:
        r104 = r104.substring(0, r106);
    L16:
        r102.add(new kotlinx.datetime.internal.format.parser.j(CollectionsKt.listOf(new kotlinx.datetime.internal.format.parser.b(r104))));
        String r107 = this.f505292a;
        int r108 = r107.length();
        int r109 = 0;
    L17:
        if (r109 >= r108) goto L22;
        if (guc.d.a(r107.charAt(r109)) == false) goto L20;
        r109 = r109 + 1;
        goto L17
    L20:
        String r110 = r107.substring(r109);
    L25:
        if (r110.length() <= 0) goto L27;
        boolean r111 = true;
    L28:
        if (r111 == true) goto L30;
    L46:
        r101 = CollectionsKt.build(r102);
        goto L48
    L30:
        if (guc.d.a(r110.charAt(r110.length() - 1)) == false) goto L45;
        int r112 = StringsKt.getLastIndex(r110);
    L33:
        if ((-1) >= r112) goto L38;
        if (guc.d.a(r110.charAt(r112)) == false) goto L36;
        r112 = r112 - 1;
        goto L33
    L36:
        r103 = r110.substring(0, r112 + 1);
    L38:
        r102.add(new x(r103));
        int r113 = StringsKt.getLastIndex(r110);
    L39:
        if ((-1) >= r113) goto L44;
        if (guc.d.a(r110.charAt(r113)) == false) goto L42;
        r113 = r113 - 1;
        goto L39
    L42:
        r110 = r110.substring(r113 + 1);
    L44:
        r102.add(new kotlinx.datetime.internal.format.parser.j(CollectionsKt.listOf(new kotlinx.datetime.internal.format.parser.b(r110))));
        goto L46
    L45:
        r102.add(new x(r110));
        goto L46
    L27:
        r111 = false;
        goto L28
    L22:
        r110 = "";
        goto L25
    L23:
        r110 = this.f505292a;
        goto L25
    L5:
        r100 = false;
        goto L6
    }

    public final String toString() {
        return "ConstantFormatStructure(" + this.f505292a + ')';
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        this.f505292a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof j) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f505292a, ((j) r100).f505292a) == false) goto L7;
        return true;
    }
}
