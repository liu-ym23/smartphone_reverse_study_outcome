package p11;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kc0.q;

/* JADX INFO: loaded from: classes47.dex */
public interface h extends q {
    q11.b g();

    String getTheme();

    boolean h();

    void i(Observer<q11.b> r100);

    boolean isInCloudCollaborate();

    void j(GiftReceiverRepoService.h r100);

    q11.d k();

    void l(GiftReceiverRepoService.h r100);

    void m(Observer<q11.b> r100);

    void n(GiftTrayWidget.g r100);

    void o(GiftTrayWidget.g r100);
}
