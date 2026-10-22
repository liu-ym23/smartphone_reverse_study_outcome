package lu2;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.paidlive.IPaidLivePresenter;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes11.dex */
@ServiceLookup("com.bytedance.android.livesdk.vscore_impl.VSServiceImpl")
public interface f extends IService {
    IPaidLivePresenter createPaidLivePresenter();

    ViewModel createPaidLiveTicketSaleManager(com.bytedance.android.livesdk.vscore_api.paidlive.d r100, DataCenter r101);

    a createStyleMonitor(DataCenter r100);

    d descriptorProvider();

    su2.a getMatchTitleImageLoader();

    boolean isNeedSendShow(String r100, String r101);

    com.bytedance.android.livesdk.vscore_api.paidlive.b paidLiveUtils();

    g toolbarBehaviorProvider();
}
