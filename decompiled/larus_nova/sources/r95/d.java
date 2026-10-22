package r95;

import android.graphics.RectF;
import com.bytedance.ee.bear.drive.biz.comment.n1;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.ss.android.lark.passportc.entity.UserSession;

/* JADX INFO: loaded from: classes16.dex */
public interface d extends n1 {
    void a(float r100, boolean r101);

    void c(z r100, UserSession r101);

    void d();

    RectF getDisplayRect();

    float getMinimumScale();

    float getScale();

    String getViewTag();

    void i(float r100, float r101, float r102);

    void setImageActionListener(n65.b.a r100);

    void setOnPhotoRequestListener(com.bytedance.ee.bear.drive.view.preview.imageviewer.b r100);

    void setOnScaleEventListener(bm5.b r100);
}
