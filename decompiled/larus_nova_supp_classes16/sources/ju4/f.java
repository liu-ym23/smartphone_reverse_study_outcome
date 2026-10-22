package ju4;

import android.view.View;
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements View.OnFocusChangeListener {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r2, boolean r3) {
        if (r3 == false) goto L5;
        int r4 = com.bytedance.ee.bear.bitable.pro.d.a;
        JSONObject r5 = new JSONObject();
        r5.put("click", FileUploadModel.FROM_COMMENT);
        com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_application_click", r5);
        return;
    }
}
