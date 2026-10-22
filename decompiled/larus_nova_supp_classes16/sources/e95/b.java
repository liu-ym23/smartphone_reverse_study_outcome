package e95;

import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final z a;
    public final a95.a b;
    public boolean c;
    public boolean d;
    public final CompositeDisposable e;
    public Disposable f;

    public static final class a {
    }

    /* JADX INFO: renamed from: e95.b$b, reason: collision with other inner class name */
    public interface InterfaceC0219b {
    }

    public interface c {
    }

    static {
    }

    public b(z r2, a95.a r3) {
        Intrinsics.checkNotNullParameter(r2, "fileModel");
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        this.a = r2;
        this.b = r3;
        this.e = new CompositeDisposable();
    }
}
