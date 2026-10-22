package n69;

import com.larus.common_ui.dialog.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f518172a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        c.a();
        this.f518172a.invoke();
    }

    public b(Function0<Unit> r100) {
        this.f518172a = r100;
    }
}
