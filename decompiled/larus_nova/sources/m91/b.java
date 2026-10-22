package m91;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseElement f512574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f512575b;

    public b(BaseElement r100) {
        this.f512574a = r100;
        this.f512575b = null;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e(this.f512574a.g(), "[" + this.f512574a + "] Element事件订阅出错", r101);
        Function1 r102 = this.f512575b;
        if (r102 == null) goto L6;
        r102.invoke(r101);
        return;
    }
}
