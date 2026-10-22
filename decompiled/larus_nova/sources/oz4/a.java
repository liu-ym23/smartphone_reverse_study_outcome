package oz4;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements com.bytedance.ee.bear.doc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BearUrl f527191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f527192b;

    public a(BearUrl r100, d r101) {
        this.f527191a = r100;
        this.f527192b = r101;
    }

    public final void a(String r100, String r101) {
        if (this.f527192b != null) goto L5;
        return;
    L5:
        tt5.a.b("DocToolbarAnalytic", "report:" + r100 + ",color:" + r101);
        HashMap r102 = new HashMap();
        r102.put("action", r100);
        BearUrl r103 = this.f527191a;
        String r104 = "ERR";
        if (r103 != null) goto L9;
    L10:
        String r105 = "ERR";
    L12:
        r102.put("file_id", r105);
        BearUrl r106 = this.f527191a;
        if (r106 != null) goto L16;
    L19:
        r102.put("file_type", r104);
        r102.put(EventConstant.Key.MODULE, r104);
        if (TextUtils.isEmpty(r101) == true) goto L22;
        r102.put("op_item", r101);
    L22:
        this.f527192b.v("toggle_attribute", r102);
        return;
    L16:
        if (TextUtils.isEmpty(r106.f222560a) == true) goto L19;
        r104 = this.f527191a.f222560a;
        goto L19
    L9:
        if (TextUtils.isEmpty(r103.f222561b) == true) goto L10;
        r105 = du5.b.g(this.f527191a.f222561b);
        goto L12
    }
}
