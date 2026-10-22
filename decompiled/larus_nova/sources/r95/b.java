package r95;

import android.graphics.BitmapFactory;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.DefaultDrivePhotoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.facade.common.BaseCommonActivity;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.passportc.entity.UserSession;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static DefaultDrivePhotoView a(BaseCommonActivity r100, z r101, UserSession r102) {
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        boolean r104 = true;
        r103.inJustDecodeBounds = true;
        String r105 = z75.b.a(r101.f225836d, r102);
        BitmapFactory.decodeFile(r105, r103);
        if (i75.m.b(r103.outWidth, r103.outHeight) == false) goto L5;
    L11:
        boolean r106 = true;
    L13:
        if (r103.outWidth > 0) goto L15;
    L17:
        r104 = false;
    L18:
        c r107 = new c();
        r107.f536707a = false;
        r107.f536708b = false;
        r107.f536709c = r106;
        r107.f536710d = r104;
        r107.f536711e = r103;
        r107.f536712f = 0;
        r107.f536713g = 0;
        r107.f536714h = 0;
        return new DefaultDrivePhotoView(r100, r107);
    L15:
        if (r103.outHeight <= 0) goto L17;
    L5:
        if (FileUtils.y(r105) >= 31457280) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == true) goto L11;
        r106 = false;
        goto L13
    L7:
        r108 = false;
        goto L8
    }
}
