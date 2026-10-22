package qz3;

import android.view.MotionEvent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.y;
import com.bytedance.awemeopen.apps.framework.feed.pinch.utils.f;
import com.bytedance.awemeopen.apps.framework.feed.pinch.utils.j;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements a {
    public final MutableLiveData<MotionEvent> a;
    public final MutableLiveData<Unit> b;
    public final MutableLiveData<String> c;

    @Override // qz3.a
    public final void e() {
        this.b.setValue(Unit.INSTANCE);
    }

    public c() {
        this.a = new MutableLiveData();
        new MutableLiveData();
        this.b = new MutableLiveData();
        this.c = new MutableLiveData();
    }

    @Override // qz3.a
    public final void b(y r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.b.removeObserver(r2);
    }

    public final void f(String r2) {
        this.c.setValue(r2);
    }

    @Override // qz3.a
    public final void a(LifecycleOwner r2, y r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2 != null) goto L5;
        return;
    L5:
        this.b.observe(r2, r3);
    }

    @Override // qz3.a
    public final void c(LifecycleOwner r2, f r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2 != null) goto L5;
        return;
    L5:
        this.a.observe(r2, r3);
    }

    @Override // qz3.a
    public final void d(LifecycleOwner r2, j r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2 != null) goto L5;
        return;
    L5:
        this.c.observe(r2, r3);
    }
}
