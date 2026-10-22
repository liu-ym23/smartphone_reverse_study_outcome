package qx4;

import android.view.View;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.bytedance.ee.bear.debug.net.RequestAdapter;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.supervisor.token.Token;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnLongClickListener {
    public final /* synthetic */ DebugRequest a;
    public final /* synthetic */ RequestAdapter b;

    public d(DebugRequest r1, RequestAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r4) {
        if (((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).p(this.a.e, new Token("LARK-PSDA-ccm_android_debug_copy_net_request_logid")) == false) goto L7;
        Toast.showText(RequestAdapter.y2(this.b), "logId已复制到剪切板");
        return true;
    L7:
        return true;
    }
}
