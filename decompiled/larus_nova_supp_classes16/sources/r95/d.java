package r95;

import android.graphics.RectF;
import com.bytedance.ee.bear.drive.biz.comment.n1;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.ss.android.lark.passportc.entity.UserSession;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface d extends n1 {
    void a(float r1, boolean r2);

    void c(z r1, UserSession r2);

    void d();

    RectF getDisplayRect();

    float getMinimumScale();

    float getScale();

    String getViewTag();

    void i(float r1, float r2, float r3);

    void setImageActionListener(n65.b.a r1);

    void setOnPhotoRequestListener(com.bytedance.ee.bear.drive.view.preview.imageviewer.b r1);

    void setOnScaleEventListener(bm5.b r1);
}
