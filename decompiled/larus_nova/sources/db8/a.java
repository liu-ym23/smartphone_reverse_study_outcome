package db8;

import android.view.View;
import android.view.ViewGroup;
import jc8.b;
import jc8.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a extends b<jc8.a> {
    @Override // jc8.b
    public final String c() {
        return "EmptyBlockHolder";
    }

    public a() {
    }

    @Override // jc8.b
    public final d f(jc8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        return new d(0, 0, 0, 0);
    }

    @Override // jc8.b
    public final View h(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        View r101 = new View(r100.getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        return r101;
    }
}
