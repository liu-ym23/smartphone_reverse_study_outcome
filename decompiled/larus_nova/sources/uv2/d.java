package uv2;

import com.bytedance.android.live.profit.vip.h;
import com.bytedance.android.livesdk.utils.k6;
import com.bytedance.android.livesdk.widget.ui.subscribe.SubscribeSelectPanel;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscribeSelectPanel f551806a;

    public d(SubscribeSelectPanel r100) {
        this.f551806a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SubscribeSelectPanel r101 = this.f551806a;
        SubscribeSelectPanel.c(r101, (h) r100);
        com.bytedance.android.live.profit.vip.e r102 = yt0.c.l();
        if (r102 == null) goto L10;
        m<Boolean> r103 = r102.getHasNewSubscribeEmoji();
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.getValue().booleanValue() == true) goto L12;
        k6.b(1, false);
        return;
    L12:
        return;
    }
}
