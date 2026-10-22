package t65;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class f implements Consumer {
    public final /* synthetic */ String a;

    public /* synthetic */ f(String r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        String r0 = this.a;
        String r5 = (String) r4;
        com.bytedance.ee.bear.contract.d r6 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        HashMap r1 = new HashMap();
        r1.put(JSEventListener.ACTION, r0);
        r1.put("trigger_action", "drive");
        r6.v("client_commerce", r1);
    }
}
