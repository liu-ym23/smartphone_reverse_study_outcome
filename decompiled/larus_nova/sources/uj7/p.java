package uj7;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f550426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550427b;

    public class a implements bk7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f550428a;

        @Override // bk7.c
        public final void b() {
            Toast.makeText(this.f550428a.f550427b, "onStartLoad", 0).show();
        }

        @Override // bk7.c
        public final void onHide() {
            Toast.makeText(this.f550428a.f550427b, "onHide", 0).show();
        }

        @Override // bk7.c
        public final void onLoadSucceed() {
            Toast.makeText(this.f550428a.f550427b, "onLoadSucceed", 0).show();
        }

        @Override // bk7.c
        public final void onShow() {
            Toast.makeText(this.f550428a.f550427b, SendEventContainerMethodParamModel.EventKinds.onShow, 0).show();
        }

        public a(p r100) {
            this.f550428a = r100;
        }

        @Override // bk7.c
        public final void a(String r100) {
            Toast.makeText(this.f550428a.f550427b, "onLoadFailed", 0).show();
        }

        @Override // bk7.c
        public final void onClose(int r100) {
            Toast.makeText(this.f550428a.f550427b, "onClose type = " + r100, 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r210) {
        String r110 = this.f550426a.getText().toString();
        if (TextUtils.isEmpty(r110) == false) goto L6;
        Toast.makeText(this.f550427b, "数据为空", 0).show();
        return;
    L6:
        bk7.b r111 = (bk7.b) hn7.d.b(bk7.b.class);
        if (r111 != null) goto L22;
        Toast.makeText(this.f550427b, "lynx service为空", 0).show();
        return;
    L22:
        JSONObject r112 = new JSONObject(r110);     // Catch: Exception -> L19
        String r113 = r112.optString(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY, "");     // Catch: Exception -> L19
        JSONObject r114 = new JSONObject();     // Catch: Exception -> L19
        JSONObject r115 = new JSONObject();     // Catch: Exception -> L19
        r115.put("title", r112.optString("title", ""));     // Catch: Exception -> L19
        r115.put(BdpAppEventConstant.PARAMS_SUB_TITLE, r112.optString(BdpAppEventConstant.PARAMS_SUB_TITLE, ""));     // Catch: Exception -> L19
        r115.put("button_text", r112.optString("button_text", ""));     // Catch: Exception -> L19
        r115.put("pic_url", r112.optString("pic_url", ""));     // Catch: Exception -> L19
        r115.put("schema", r112.optString("schema", ""));     // Catch: Exception -> L19
        r115.put("extra", r112.optString("extra", ""));     // Catch: Exception -> L19
        r115.put("popup_key", r112.optString("popup_key", ""));     // Catch: Exception -> L19
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L19
        if (r112.optJSONObject("reward") == null) goto L13;
        r100.put("amount_text", r112.optJSONObject("reward").optString("amount_text", ""));     // Catch: Exception -> L19
        r100.put("unit_text", r112.optJSONObject("reward").optString("unit_text", ""));     // Catch: Exception -> L19
    L13:
        r115.put("reward", r100);     // Catch: Exception -> L19
        r114.put("popupData", r115);     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r113) == false) goto L17;
        Toast.makeText(this.f550427b, "lynx schema 为空", 0).show();     // Catch: Exception -> L19
        return;
    L17:
        r111.N(this.f550427b, r113, r114, new a(this), true);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        Toast.makeText(this.f550427b, "error = " + e.getMessage(), 0).show();
    }

    public p(ProjectActivity r100, EditText r101) {
        this.f550427b = r100;
        this.f550426a = r101;
    }
}
