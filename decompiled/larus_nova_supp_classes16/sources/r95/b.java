package r95;

import android.graphics.BitmapFactory;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.DefaultDrivePhotoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.facade.common.BaseCommonActivity;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.passportc.entity.UserSession;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static DefaultDrivePhotoView a(BaseCommonActivity r6, z r7, UserSession r8) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        boolean r1 = true;
        r0.inJustDecodeBounds = true;
        String r9 = z75.b.a(r7.d, r8);
        BitmapFactory.decodeFile(r9, r0);
        if (i75.m.b(r0.outWidth, r0.outHeight) == false) goto L5;
    L11:
        boolean r10 = true;
    L13:
        if (r0.outWidth > 0) goto L15;
    L17:
        r1 = false;
    L18:
        c r11 = new c();
        r11.a = false;
        r11.b = false;
        r11.c = r10;
        r11.d = r1;
        r11.e = r0;
        r11.f = 0;
        r11.g = 0;
        r11.h = 0;
        return new DefaultDrivePhotoView(r6, r11);
    L15:
        if (r0.outHeight <= 0) goto L17;
    L5:
        if (FileUtils.y(r9) >= 31457280) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L11;
        r10 = false;
        goto L13
    L7:
        r12 = false;
        goto L8
    }
}
