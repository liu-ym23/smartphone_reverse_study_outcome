package ap3;

import com.bytedance.android.ec.window.base.db.WindowDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> implements ObservableOnSubscribe {
    public final /* synthetic */ WindowDatabase a;
    public final /* synthetic */ String b;

    public a(WindowDatabase r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<List<io.b>> r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        c r0 = c.a;
        monitor-enter(r0);
        ho.d r1 = this.a.d();     // Catch: Throwable -> L8
        ho.d r2 = r1;     // Catch: Throwable -> L8
        List r3 = r2.a(this.b);     // Catch: Throwable -> L8
        monitor-exit(r0);
        r4.onNext(r3);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
