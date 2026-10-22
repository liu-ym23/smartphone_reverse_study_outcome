package wk2;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPublicBottomScreenProduct;
import com.bytedance.android.livesdk.livecommerce.utils.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ ECPublicBottomScreenProduct b;

    public b(a r1, ECPublicBottomScreenProduct r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        new e("livesdk_video_product_comment_click", this.b.getProductId()).k();
        Context r4 = this.a.getContext();     // Catch: Exception -> L8
        String r0 = this.b.getSchema();     // Catch: Exception -> L8
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        Handler r1 = k.a;     // Catch: Exception -> L8
        com.bytedance.android.livesdk.livecommerce.room.f.b(r4, r0);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
