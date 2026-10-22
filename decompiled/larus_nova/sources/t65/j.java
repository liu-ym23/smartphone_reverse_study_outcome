package t65;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ee.bear.drive.biz.upload.error.DriveUploadErrorTipsActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.im.internal.network.proto2.AvCmd;
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class j extends s65.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f544666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f544667b;

    public j(k r100, Context r101) {
        this.f544667b = r100;
        this.f544666a = r101;
    }

    @Override // rf5.e
    public final void onUploadErrorCode(String r100, int r101, long r110) {
        tt5.a.h("UploadErrorManager", "onUploadErrorCode = " + r101);
        this.f544667b.getClass();
        boolean r111 = true;
        if (r101 != 12009) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        Context r103 = this.f544667b.f544670a;
        Toast.showText(r103, r103.getText(R.string.Drive_Drive_UploadFailByPolicy), 0);
        return;
    L8:
        this.f544667b.getClass();
        if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).isFeishuBrand() == true) goto L28;
        long r104 = System.currentTimeMillis();
        if ((r104 - k.f544668b) < 1000) goto L14;
        boolean r105 = false;
    L15:
        k.f544668b = r104;
        if (r105 == false) goto L18;
    L27:
        tt5.a.h("UploadErrorManager", "isNeedShowDialog block by repeat");
        goto L28
    L18:
        if (r101 == k.f544669c) goto L27;
        ArrayList r106 = new ArrayList();
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.mobile.cta_component_enable", false) == false) goto L23;
        r106.add(90003042);
    L25:
        if (r106.contains(Integer.valueOf(r101)) == false) goto L28;
        k.f544669c = r101;
    L29:
        if (r111 == false) goto L36;
        Context r107 = this.f544666a;
        Intent r112 = new Intent(r107, DriveUploadErrorTipsActivity.class);
        r112.putExtra("drive_upload_error", r101);
        if ((r107 instanceof Application) == false) goto L33;
        r112.addFlags(268435456);
    L33:
        r107.startActivity(r112);
        return;
    L36:
        return;
    L23:
        r106.add(90003042);
        r106.add(Integer.valueOf(AvCmd.CommandEventType.TRIGGER_NOISY_VALUE));
        goto L25
    L14:
        r105 = true;
    L28:
        r111 = false;
        goto L29
    L5:
        r102 = false;
        goto L6
    }
}
