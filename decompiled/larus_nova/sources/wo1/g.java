package wo1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.sti.IBigCardAnimExcuteListener;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements IBigCardAnimExcuteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f560507a;

    public g(h r100) {
        this.f560507a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.IBigCardAnimExcuteListener
    public final void onAnimDone(boolean r100) {
        ALogger.i("LoadShortTouchBigCardMethod", "大卡动画执行结束");
        this.f560507a.finishWithSuccess();
    }
}
