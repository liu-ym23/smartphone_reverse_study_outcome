package x61;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f562588b;

    public f(Function1 r100) {
        this.f562588b = r100;
    }

    @Override // x61.h
    public final View a(c.a r100) {
        c.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        return (View) this.f562588b.invoke(r101);
    }
}
