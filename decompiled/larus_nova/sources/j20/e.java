package j20;

import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractGameFeedbackDialog f496909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f496910b;

    public e(InteractGameFeedbackDialog r100, List r101) {
        this.f496909a = r100;
        this.f496910b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        a r102 = this.f496909a.f61779a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r102.f496905a = this.f496910b;
        r102.notifyDataSetChanged();
        this.f496909a.getClass();
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.e("GameFeedbackDialog", "从server获取游戏反馈tag列表失败", r101);
    }
}
