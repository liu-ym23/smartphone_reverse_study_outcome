package gt8;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f482615a;

    @Override // gt8.d.b
    public int getType() {
        return 0;
    }

    public g(d r100) {
        this.f482615a = r100;
    }

    @Override // gt8.d.b
    public final void a(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f482615a.f482601f.onTouchEvent(r100);
    }
}
