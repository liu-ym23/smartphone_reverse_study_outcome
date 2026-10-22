package yub;

import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.officesdk.minutes.service.fileupload.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.c f569260a;

    public c(k r100) {
        this.f569260a = r100;
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.y
    public final void f(y.a r100, y.a r101) {
        Intrinsics.checkNotNullParameter(r100, "oldState");
        Intrinsics.checkNotNullParameter(r101, "newState");
        this.f569260a.a(d.c(r100), d.c(r101));
    }
}
