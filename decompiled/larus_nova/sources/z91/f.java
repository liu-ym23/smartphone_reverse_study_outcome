package z91;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.mvi.UserInfoDataSource;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserInfoDataSource f570983a;

    public f(UserInfoDataSource r100) {
        this.f570983a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = this.f570983a.f100054a;
        ALogger.e(r101, (Throwable) r100);
    }
}
