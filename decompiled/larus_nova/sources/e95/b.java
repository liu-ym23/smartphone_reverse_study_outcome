package e95;

import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f471490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a95.a f471491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f471492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f471493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f471494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f471495f;

    public static final class a {
    }

    /* JADX INFO: renamed from: e95.b$b, reason: collision with other inner class name */
    public interface InterfaceC5757b {
    }

    public interface c {
    }

    static {
    }

    public b(z r100, a95.a r101) {
        Intrinsics.checkNotNullParameter(r100, "fileModel");
        Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
        this.f471490a = r100;
        this.f471491b = r101;
        this.f471494e = new CompositeDisposable();
    }
}
