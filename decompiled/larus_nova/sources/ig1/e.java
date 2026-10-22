package ig1;

import com.bytedance.crash.dumper.Scraps;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f489714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject f489715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject f489716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f489717d;

    @Override // ig1.b
    public final void release() {
        Disposable r100 = this.f489714a;
        if (r100 != null) goto L5;
    L10:
        this.f489714a = null;
        this.f489717d = false;
        return;
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    public e() {
        PublishSubject r100 = PublishSubject.create();
        this.f489715b = r100;
        this.f489716c = r100;
    }

    @Override // ig1.b
    public final boolean b() {
        return this.f489717d;
    }

    @Override // ig1.b
    public final PublishSubject c() {
        return this.f489716c;
    }

    public final PublishSubject d(long r100, TimeUnit r101) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        this.f489717d = true;
        Disposable r102 = this.f489714a;
        if (r102 != null) goto L5;
    L10:
        this.f489714a = Observable.timer(r100, r101).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this));
        return this.f489716c;
    L5:
        if ((true ^ r102.isDisposed()) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        r102.dispose();
        goto L10
    }
}
