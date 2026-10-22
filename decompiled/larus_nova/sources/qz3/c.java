package qz3;

import android.view.MotionEvent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.y;
import com.bytedance.awemeopen.apps.framework.feed.pinch.utils.f;
import com.bytedance.awemeopen.apps.framework.feed.pinch.utils.j;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<MotionEvent> f535330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Unit> f535331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<String> f535332c;

    @Override // qz3.a
    public final void e() {
        this.f535331b.setValue(Unit.INSTANCE);
    }

    public c() {
        this.f535330a = new MutableLiveData();
        new MutableLiveData();
        this.f535331b = new MutableLiveData();
        this.f535332c = new MutableLiveData();
    }

    @Override // qz3.a
    public final void b(y r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f535331b.removeObserver(r100);
    }

    public final void f(String r100) {
        this.f535332c.setValue(r100);
    }

    @Override // qz3.a
    public final void a(LifecycleOwner r100, y r101) {
        Intrinsics.checkNotNullParameter(r101, "observer");
        if (r100 != null) goto L5;
        return;
    L5:
        this.f535331b.observe(r100, r101);
    }

    @Override // qz3.a
    public final void c(LifecycleOwner r100, f r101) {
        Intrinsics.checkNotNullParameter(r101, "observer");
        if (r100 != null) goto L5;
        return;
    L5:
        this.f535330a.observe(r100, r101);
    }

    @Override // qz3.a
    public final void d(LifecycleOwner r100, j r101) {
        Intrinsics.checkNotNullParameter(r101, "observer");
        if (r100 != null) goto L5;
        return;
    L5:
        this.f535332c.observe(r100, r101);
    }
}
