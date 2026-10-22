package z2;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class j implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f569738a;

    public /* synthetic */ j(i r100) {
        this.f569738a = r100;
    }

    public final void a(List r100) {
        Function1 r101 = this.f569738a;
        Intrinsics.checkNotNullParameter(r100, "uris");
        r101.invoke(r100);
    }
}
