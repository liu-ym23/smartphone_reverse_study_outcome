package rc5;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements b {
    public c() {
    }

    @Override // rc5.b
    public final void b(tc5.a r100) {
        lc5.f.f508440a.C(r100);
    }

    @Override // rc5.b
    public final void a(String r110, String r111, String r112) {
        lc5.f.a r100 = lc5.f.f508440a;
        JSONObject r113 = new JSONObject();
        if (r110 != null) goto L5;
        String r101 = "";
    L6:
        lc5.f.a.b(r100, new lc5.g(r113, r101, r111, "", sbb.e.f541294e.f541317b, "", r112, DocumentType.FOLDER_NAME, null));
        com.bytedance.ee.bear.contract.d r102 = lc5.f.a.d();
        if (r102 == null) goto L10;
        r102.i("ccm_space_create_new_view", r113);
        return;
    L10:
        return;
    L5:
        r101 = r110;
        goto L6
    }

    @Override // rc5.b
    public final void c(String r100, String r101, String r102) {
        lc5.f.g(r100, r101, r102);
    }
}
