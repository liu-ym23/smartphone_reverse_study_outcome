package lda;

import com.obric.assistant.cocreationreview.s3;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class n implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f508820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f508821b;

    public /* synthetic */ n(q r100, k r101) {
        this.f508820a = r100;
        this.f508821b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        q r100 = this.f508820a;
        Function1 r101 = this.f508821b;
        LinkedHashSet<Function1<u, Unit>> r102 = r100.f508826c;
        monitor-enter(r102);
        r100.f508826c.remove(r101);     // Catch: Throwable -> L11
        int r103 = r100.f508826c.size();     // Catch: Throwable -> L11
        monitor-exit(r102);
        int r104 = s3.f387719a;
        s3.b("omni.repository.observe", "remove listeners=" + r103);
        if (r103 != 0) goto L10;
        r100.d();
    L10:
        return Unit.INSTANCE;
    L11:
        th = move-exception;
        throw th;
    }
}
