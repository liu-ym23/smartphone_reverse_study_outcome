package j20;

import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractGameFeedbackDialog f496911a;

    public f(InteractGameFeedbackDialog r100) {
        this.f496911a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        InteractGameFeedbackDialog r101 = this.f496911a;
        int r102 = InteractGameFeedbackDialog.f61778i;
        r101.getClass();
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.i("GameFeedbackDialog", "提交反馈成功：" + ((j10.b) r100));
        InteractGameFeedbackDialog.M0(this.f496911a);
        f2.c("反馈成功！", 0);
    }
}
