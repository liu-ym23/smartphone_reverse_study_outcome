package ju4;

import android.view.View;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f500488a = null;

    static {
        f500488a = new f();
    }

    public f() {
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L5;
        int r102 = com.bytedance.ee.bear.bitable.pro.d.f215166a;
        JSONObject r103 = new JSONObject();
        r103.put("click", "comment");
        com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_application_click", r103);
        return;
    }
}
