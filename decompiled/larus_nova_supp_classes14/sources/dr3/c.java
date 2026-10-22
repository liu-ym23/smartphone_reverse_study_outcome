package dr3;

import android.content.Context;
import android.view.View;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends e<Unit, fr3.a.b, View> {
    public c(fr3.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        super(CollectionsKt.emptyList(), r2);
    }

    @Override // dr3.e
    public final View b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new View(r2);
    }
}
