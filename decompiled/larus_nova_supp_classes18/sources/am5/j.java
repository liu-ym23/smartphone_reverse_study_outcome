package am5;

import android.graphics.PointF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ CommentRectLayout a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ j(CommentRectLayout r1) {
        this.a = r1;
        this.b = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CommentRectLayout r0 = this.a;
        boolean r1 = this.b;
        int r2 = CommentRectLayout.P;
        r0.getClass();
        float r6 = r0.y.getLeft() + (r0.y.getWidth() / 2.0f);     // Catch: Exception -> L19
        float r7 = r0.y.getTop() + (r0.y.getHeight() / 2.0f);     // Catch: Exception -> L19
        tt5.a.b("CommentRectLayout", "moveBgImage viewCenterX=" + r6 + ", viewCenterY=" + r7);     // Catch: Exception -> L19
        int[] r8 = new int[2];     // Catch: Exception -> L19
        r0.getLocationOnScreen(r8);     // Catch: Exception -> L19
        int[] r4 = new int[2];     // Catch: Exception -> L19
        r0.E.getLocationOnScreen(r4);     // Catch: Exception -> L19
        float r9 = r6 + (r8[0] - r4[0]);     // Catch: Exception -> L19
        float r10 = r7 + (r8[1] - r4[1]);     // Catch: Exception -> L19
        SubsamplingScaleImageView r5 = r0.E;     // Catch: Exception -> L19
        r5.getClass();     // Catch: Exception -> L19
        PointF r11 = new PointF();     // Catch: Exception -> L19
        PointF r12 = r5.z;     // Catch: Exception -> L19
        SubsamplingScaleImageView.f r13 = null;
        if (r12 != null) goto L6;
        r11 = null;
    L7:
        if (r11 != null) goto L9;
        tt5.a.k("CommentRectLayout", "viewToSourceCoord returned null");     // Catch: Exception -> L19
        return;
    L9:
        tt5.a.b("CommentRectLayout", "moveBgImage target sourcePoint=" + r11 + ", isReady=" + r0.E.b1 + ", sWidth=" + r0.E.getSWidth() + ", sHeight=" + r0.E.getSHeight());     // Catch: Exception -> L19
        SubsamplingScaleImageView r3 = r0.E;     // Catch: Exception -> L19
        if (r3.b1 == false) goto L13;
        r13 = new SubsamplingScaleImageView.f(r3, r11);     // Catch: Exception -> L19
    L13:
        if (r13 == null) goto L17;
        if (r1 == false) goto L16;
        r13.d = 300;     // Catch: Exception -> L19
        r13.g = true;     // Catch: Exception -> L19
        r13.a();     // Catch: Exception -> L19
        return;
    L16:
        r13.d = 0;     // Catch: Exception -> L19
        r13.g = false;     // Catch: Exception -> L19
        r13.a();     // Catch: Exception -> L19
        return;
    L17:
        tt5.a.k("CommentRectLayout", "animateCenter returned null, image probably not ready");     // Catch: Exception -> L19
        return;
    L6:
        float r14 = r9 - r12.x;     // Catch: Exception -> L19
        float r15 = r5.x;     // Catch: Exception -> L19
        r11.set(r14 / r15, (r10 - r12.y) / r15);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        tt5.a.e("CommentRectLayout", "moveBgImageToCreateRect error", e, false);
    }
}
