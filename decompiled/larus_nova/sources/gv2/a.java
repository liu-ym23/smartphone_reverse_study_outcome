package gv2;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.vscore_api.paidlive.b;
import com.bytedance.android.livesdk.vscore_api.paidlive.d;
import com.bytedance.android.livesdk.vscore_impl.paidlive.c;
import com.bytedance.android.livesdk.vscore_impl.paidlive.e;
import com.bytedance.android.livesdkapi.paidlive.IPaidLivePresenter;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes11.dex */
public interface a {
    b J0();

    e a();

    c c();

    IPaidLivePresenter createPaidLivePresenter();

    ViewModel createPaidLiveTicketSaleManager(d r100, DataCenter r101);

    void d();
}
