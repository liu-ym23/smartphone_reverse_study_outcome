package r12;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.livesdk.gift.platform.format.jsb.FormatSendGiftResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f535615a;

    public d(e r100) {
        this.f535615a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        FormatSendGiftResultModel r102 = new FormatSendGiftResultModel();
        r102.a(FormatSendGiftResultModel.Code.Failed);
        if ((r101 instanceof ApiException) == false) goto L8;
        r102.b(Integer.valueOf(((ApiException) r101).getErrorCode()));
        if ((r101 instanceof ApiServerException) == false) goto L7;
        r102.c(((ApiServerException) r101).getPrompt());
    L7:
        this.f535615a.finishWithResult(r102);
        return;
    L8:
        this.f535615a.finishWithFailure(new RuntimeException("2: " + r101.getMessage()));
    }
}
