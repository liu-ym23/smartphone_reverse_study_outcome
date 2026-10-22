package m91;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseElement f512572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f512573b;

    public a(BaseElement r100, Function1 r101) {
        this.f512572a = r100;
        this.f512573b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T r100) {
        this.f512573b.invoke(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ALogger.e(this.f512572a.g(), "[" + this.f512572a + "] element invoke onNext() error", e);
        if (v.a() == true) goto L8;
        return;
    L8:
        throw e;
    }
}
