package om2;

import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.livesdk.user.f;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f524244a;

    public b(f r100) {
        this.f524244a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        UserEvent r101 = (UserEvent) r100;
        if (this.f524244a.isLogin() == false) goto L6;
        a.f524241e.a();
        return;
    }
}
