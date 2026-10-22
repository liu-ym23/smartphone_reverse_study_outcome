package zc1;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.wallet.model.WalletCheckOrderOriginalResult;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.GsonBuilder;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements Consumer<WalletCheckOrderOriginalResult> {
    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(WalletCheckOrderOriginalResult r100) throws Exception {
        WalletCheckOrderOriginalResult r101 = r100;
        if (r101.statusCode == 0) goto L5;
    L9:
        ApiServerException r102 = new ApiServerException(r101.statusCode);
        r102.setExtra(GsonProtectorUtils.toJson(new GsonBuilder().create(), r101.extra));
        throw r102;
    L5:
        if (r101.getStatus() == 0) goto L7;
        return;
    L7:
        if (r101.statusCode == 0) goto L9;
    }
}
