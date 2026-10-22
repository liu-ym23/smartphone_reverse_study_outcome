package e92;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f471453a;

    public f(k r100) {
        this.f471453a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        k r102 = this.f471453a;
        r102.f471464c = false;
        if ((r101 instanceof ApiServerException) == false) goto L5;
        IESUIUtils.displayToast(r102.f471465d, ((ApiServerException) r101).getPrompt());
        return;
    L5:
        f2.b(R.string.ttlive_live_profile_action_error, 0);
    }
}
