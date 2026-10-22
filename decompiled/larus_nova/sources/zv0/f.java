package zv0;

import com.bytedance.android.live.recharge.model.ExchangeInfo;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes47.dex */
public interface f {
    long getAvailableDiamonds();

    ExchangeInfo getExchangeInfo();

    boolean isDiamondAvailable(long r100);

    boolean isSyncWalletInfoSuccess();

    Observable<ExchangeInfo> observeExchangeInfo();

    Observable<Long> observeWallet();

    void setAvailableDiamonds(long r100);

    void sync(String r100);

    void syncExchangeInfo();

    void syncFromEnterRoom();

    void syncWithExtra(String r100, String r101);
}
