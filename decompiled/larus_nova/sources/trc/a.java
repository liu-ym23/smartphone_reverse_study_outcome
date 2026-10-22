package trc;

import io.github.alexzhirkevich.compottie.internal.animation.expressions.f;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.v;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements src.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f547330b = null;

    static {
        f547330b = new a();
    }

    public a() {
    }

    public final f a(final f r100, String r101, List<? extends f> r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (Intrinsics.areEqual(r101, "toFixed") == false) goto L6;
        v.b(r102, r101);
        final f r103 = (f) CollectionsKt.singleOrNull(r102);
        Lazy r104 = e.f547335a;
        Intrinsics.checkNotNullParameter(r100, "number");
        return new d(r100, r103);
    L6:
        if (Intrinsics.areEqual(r101, "toPrecision") == false) goto L8;
        v.b(r102, r101);
        final f r105 = (f) CollectionsKt.singleOrNull(r102);
        Lazy r106 = e.f547335a;
        Intrinsics.checkNotNullParameter(r100, "number");
        return new b(r100, r105);
    L8:
        return null;
    }
}
