package qx4;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.debug.net.RequestDetailFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.supervisor.token.Token;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements View.OnLongClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ RequestDetailFragment b;

    public h(View r1, RequestDetailFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r4) {
        if (((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).p(((TextView) this.a.findViewById(2131384432)).getText().toString(), new Token("LARK-PSDA-ccm_android_debug_copy_response_header")) == false) goto L7;
        Toast.showText(this.b.requireContext(), "复制成功");
        return false;
    L7:
        return false;
    }
}
