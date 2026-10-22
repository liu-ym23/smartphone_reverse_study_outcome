package xd2;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f563281a;

    public f(Function1 r100) {
        this.f563281a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ExceptionUtils.handleException(s1.getContext(), r101);
        this.f563281a.invoke(r101);
    }
}
