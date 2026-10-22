package nz;

import com.bytedance.android.live.broadcast.api.model.g1;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class d0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f521311a;

    public d0(Function1 r100) {
        this.f521311a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1 r101 = this.f521311a;
        r101.invoke((g1) r100);
    }
}
