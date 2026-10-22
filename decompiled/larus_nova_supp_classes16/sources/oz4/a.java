package oz4;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements com.bytedance.ee.bear.doc.b {
    public final BearUrl a;
    public final d b;

    public a(BearUrl r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r4, String r5) {
        if (this.b != null) goto L5;
        return;
    L5:
        tt5.a.b("DocToolbarAnalytic", "report:" + r4 + ",color:" + r5);
        HashMap r0 = new HashMap();
        r0.put(JSEventListener.ACTION, r4);
        BearUrl r6 = this.a;
        String r1 = "ERR";
        if (r6 != null) goto L9;
    L10:
        String r7 = "ERR";
    L12:
        r0.put("file_id", r7);
        BearUrl r8 = this.a;
        if (r8 != null) goto L16;
    L19:
        r0.put("file_type", r1);
        r0.put("module", r1);
        if (TextUtils.isEmpty(r5) == true) goto L22;
        r0.put("op_item", r5);
    L22:
        this.b.v("toggle_attribute", r0);
        return;
    L16:
        if (TextUtils.isEmpty(r8.a) == true) goto L19;
        r1 = this.a.a;
        goto L19
    L9:
        if (TextUtils.isEmpty(r6.b) == true) goto L10;
        r7 = du5.b.g(this.a.b);
        goto L12
    }
}
