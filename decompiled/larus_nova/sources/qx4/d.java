package qx4;

import android.view.View;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.bytedance.ee.bear.debug.net.RequestAdapter;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.supervisor.token.Token;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DebugRequest f535108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RequestAdapter f535109b;

    public d(DebugRequest r100, RequestAdapter r101) {
        this.f535108a = r100;
        this.f535109b = r101;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        if (((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).p(this.f535108a.f216900e, new Token("LARK-PSDA-ccm_android_debug_copy_net_request_logid")) == false) goto L7;
        Toast.showText(RequestAdapter.y2(this.f535109b), "logId已复制到剪切板");
        return true;
    L7:
        return true;
    }
}
