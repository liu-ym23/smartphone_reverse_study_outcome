package t65;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ee.bear.drive.biz.upload.error.DriveUploadErrorTipsActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j extends s65.a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ k b;

    public j(k r1, Context r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void onUploadErrorCode(String r8, int r9, long r10) {
        tt5.a.h("UploadErrorManager", "onUploadErrorCode = " + r9);
        this.b.getClass();
        boolean r11 = true;
        if (r9 != 12009) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        Context r13 = this.b.a;
        Toast.showText(r13, r13.getText(2131888454), 0);
        return;
    L8:
        this.b.getClass();
        if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).isFeishuBrand() == true) goto L28;
        long r1 = System.currentTimeMillis();
        if ((r1 - k.b) < 1000) goto L14;
        boolean r14 = false;
    L15:
        k.b = r1;
        if (r14 == false) goto L18;
    L27:
        tt5.a.h("UploadErrorManager", "isNeedShowDialog block by repeat");
        goto L28
    L18:
        if (r9 == k.c) goto L27;
        ArrayList r16 = new ArrayList();
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.mobile.cta_component_enable", false) == false) goto L23;
        r16.add(90003042);
    L25:
        if (r16.contains(Integer.valueOf(r9)) == false) goto L28;
        k.c = r9;
    L29:
        if (r11 == false) goto L36;
        Context r17 = this.a;
        Intent r18 = new Intent(r17, DriveUploadErrorTipsActivity.class);
        r18.putExtra("drive_upload_error", r9);
        if ((r17 instanceof Application) == false) goto L33;
        r18.addFlags(268435456);
    L33:
        r17.startActivity(r18);
        return;
    L36:
        return;
    L23:
        r16.add(90003042);
        r16.add(13001);
        goto L25
    L14:
        r14 = true;
    L28:
        r11 = false;
        goto L29
    L5:
        r12 = false;
        goto L6
    }
}
