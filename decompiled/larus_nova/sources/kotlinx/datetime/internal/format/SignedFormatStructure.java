package kotlinx.datetime.internal.format;

import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.z;

/* JADX INFO: loaded from: classes42.dex */
public final class SignedFormatStructure<T> implements q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<T> f505270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f505271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<l<T>> f505272c;

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlinx.datetime.internal.format.u] */
    @Override // kotlinx.datetime.internal.format.n
    public final kotlinx.datetime.internal.format.parser.u<T> parser() {
        return kotlinx.datetime.internal.format.parser.q.a(CollectionsKt.listOf(new kotlinx.datetime.internal.format.parser.u[]{new kotlinx.datetime.internal.format.parser.u(CollectionsKt.listOf(new z(new u(this), this.f505271b, "sign for " + this.f505272c)), CollectionsKt.emptyList()), this.f505270a.parser()}));
    }

    @Override // kotlinx.datetime.internal.format.n
    public final huc.e<T> a() {
        return new huc.f(this.f505270a.a(), new SignedFormatStructure$formatter$1(this));
    }

    public final int hashCode() {
        int r100 = this.f505270a.hashCode() * 31;
        if (this.f505271b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SignedFormatStructure(" + this.f505270a + ')';
    }

    public SignedFormatStructure(e r100) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        this.f505270a = r100;
        this.f505271b = true;
        List r101 = CollectionsKt.createListBuilder();
        o.a(r101, r100);
        List r102 = CollectionsKt.build(r101);
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        l r105 = ((k) r104.next()).b().getSign();
        if (r105 == null) goto L4;
        r103.add(r105);
        goto L4
    L8:
        Set<l<T>> r106 = CollectionsKt.toSet(r103);
        this.f505272c = r106;
        if ((!r106.isEmpty()) == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("Signed format must contain at least one field with a sign".toString());
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof SignedFormatStructure) == false) goto L9;
        SignedFormatStructure r101 = (SignedFormatStructure) r100;
        if (Intrinsics.areEqual(this.f505270a, r101.f505270a) == false) goto L9;
        if (this.f505271b != r101.f505271b) goto L9;
        return true;
    L9:
        return false;
    }
}
