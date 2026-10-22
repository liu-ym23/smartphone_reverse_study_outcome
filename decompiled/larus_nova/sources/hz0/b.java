package hz0;

import com.bytedance.revenue.platform.api.core.rx.c;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements gz0.a, ha0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BehaviorSubject<String> f487668a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // gz0.a
    public final String K2() {
        String r100 = this.f487668a.getValue();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public b() {
        int r100 = c.f267509a;
        this.f487668a = BehaviorSubject.create();
    }

    @Override // gz0.a
    public final BehaviorSubject P4() {
        return this.f487668a;
    }

    @Override // ha0.b
    public final void d1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f487668a.onNext(r100);
    }
}
