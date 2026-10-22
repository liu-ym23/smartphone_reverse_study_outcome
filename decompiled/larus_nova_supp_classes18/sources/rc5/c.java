package rc5;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements b {
    public c() {
    }

    @Override // rc5.b
    public final void b(tc5.a r2) {
        lc5.f.a.C(r2);
    }

    @Override // rc5.b
    public final void a(String r14, String r15, String r16) {
        lc5.f.a r0 = lc5.f.a;
        JSONObject r11 = new JSONObject();
        if (r14 != null) goto L5;
        String r3 = "";
    L6:
        lc5.f.a.b(r0, new lc5.g(r11, r3, r15, "", sbb.e.e.b, "", r16, DocumentType.FOLDER_NAME, null));
        com.bytedance.ee.bear.contract.d r1 = lc5.f.a.d();
        if (r1 == null) goto L10;
        r1.i("ccm_space_create_new_view", r11);
        return;
    L10:
        return;
    L5:
        r3 = r14;
        goto L6
    }

    @Override // rc5.b
    public final void c(String r1, String r2, String r3) {
        lc5.f.g(r1, r2, r3);
    }
}
