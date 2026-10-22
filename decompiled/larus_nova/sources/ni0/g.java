package ni0;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f519224a;

    public g(Context r100) {
        this.f519224a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("GroupLiveGameInviteUtils", "inviteFriends failed", r101);
        ExceptionUtils.handleException(this.f519224a, r101);
    }
}
