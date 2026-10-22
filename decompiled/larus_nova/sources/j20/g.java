package j20;

import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractGameFeedbackDialog f496912a;

    public g(InteractGameFeedbackDialog r100) {
        this.f496912a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        InteractGameFeedbackDialog r101 = this.f496912a;
        int r102 = InteractGameFeedbackDialog.f61778i;
        r101.getClass();
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.e("GameFeedbackDialog", "提交反馈失败", (Throwable) r100);
        f2.c("反馈失败！", 0);
        InteractGameFeedbackDialog.M0(this.f496912a);
    }
}
