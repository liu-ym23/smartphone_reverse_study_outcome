package u82;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f549173a;

    public k(Function1 r100) {
        this.f549173a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1 r101 = this.f549173a;
        User.Companion.getClass();
        r101.invoke(User.a.a((IBaseUser) r100));
    }
}
