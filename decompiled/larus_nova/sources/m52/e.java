package m52;

import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f512104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject<Integer> f512105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f512106c;

    public e() {
        this.f512105b = PublishSubject.create();
        this.f512106c = true;
    }

    public final void a(int r100) {
        if (r100 != this.f512104a) goto L5;
        return;
    L5:
        this.f512104a = r100;
        this.f512105b.onNext(Integer.valueOf(r100));
    }

    public final void onEvent(IModelListDataManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getType() == IModelListDataManager.ModelChangeType.INSERT_BOTTOM) goto L5;
        return;
    L5:
        if (this.f512106c == false) goto L9;
        a(this.f512104a + 1);
        return;
    }
}
