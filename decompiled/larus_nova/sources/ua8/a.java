package ua8;

import android.text.method.LinkMovementMethod;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import lw8.l;

/* JADX INFO: loaded from: classes25.dex */
public final class a extends TextView implements ow8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f549290a;

    @Override // ow8.a
    public final int getMarkdownWidth() {
        return 0;
    }

    @Override // ow8.a
    public final int getSelectedColor() {
        return 1719254015;
    }

    @Override // ow8.a
    public final TextView o() {
        return this;
    }

    @Override // ow8.a
    public final boolean q(int r100, int r101) {
        return false;
    }

    public a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100.getContext());
        setMovementMethod(LinkMovementMethod.getInstance());
    }
}
