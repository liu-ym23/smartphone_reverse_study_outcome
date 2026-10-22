package ap3;

import com.bytedance.android.ec.window.base.db.WindowDatabase;
import ho.l;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h<T> implements ObservableOnSubscribe {
    public final /* synthetic */ WindowDatabase a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public h(WindowDatabase r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(ObservableEmitter<List<io.d>> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        CollectionsKt.emptyList();
        i r0 = i.a;
        monitor-enter(r0);
        l r1 = this.a.f();     // Catch: Throwable -> L8
        l r2 = r1;     // Catch: Throwable -> L8
        List r3 = r2.a(this.b, this.c);     // Catch: Throwable -> L8
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        r5.onNext(r3);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
