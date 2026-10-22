package t85;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements com.bytedance.ee.bear.drivesdk.plugin.model.menu.a {
    public d() {
    }

    @Override // com.bytedance.ee.bear.drivesdk.plugin.model.menu.a
    public final void a(BaseOpenEntity r100, String r101, String r102) {
        com.bytedance.ee.bear.drive.report.c r103 = o75.b.a().Ke();
        if (r100 != null) goto L5;
        r103.getClass();
        return;
    L5:
        HashMap<String, Object> r104 = r103.g(r100);
        r104.put("click", r101);
        r104.put(PickerReporterConstants.KEY.TARGET, r102);
        r103.c(r100.getFileId(), r104);
        r103.A("ccm_drive_file_menu_click", r104);
    }
}
