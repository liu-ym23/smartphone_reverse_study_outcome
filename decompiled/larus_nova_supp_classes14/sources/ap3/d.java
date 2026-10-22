package ap3;

import com.bytedance.android.ec.window.base.db.WindowDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T> implements ObservableOnSubscribe {
    public final /* synthetic */ WindowDatabase a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public d(WindowDatabase r1, String r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void subscribe(ObservableEmitter<List<io.c>> r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        g r0 = g.a;
        monitor-enter(r0);
        ho.h r1 = this.a.e();     // Catch: Throwable -> L8
        ho.h r2 = r1;     // Catch: Throwable -> L8
        List r3 = r2.a(this.b, this.c, this.d);     // Catch: Throwable -> L8
        monitor-exit(r0);
        r6.onNext(r3);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
