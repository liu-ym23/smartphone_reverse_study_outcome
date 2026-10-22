package t85;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements com.bytedance.ee.bear.drivesdk.plugin.model.menu.a {
    public d() {
    }

    @Override // com.bytedance.ee.bear.drivesdk.plugin.model.menu.a
    public final void a(BaseOpenEntity r4, String r5, String r6) {
        com.bytedance.ee.bear.drive.report.c r0 = o75.b.a().Ke();
        if (r4 != null) goto L5;
        r0.getClass();
        return;
    L5:
        HashMap<String, Object> r1 = r0.g(r4);
        r1.put("click", r5);
        r1.put("target", r6);
        r0.c(r4.getFileId(), r1);
        r0.A("ccm_drive_file_menu_click", r1);
    }
}
