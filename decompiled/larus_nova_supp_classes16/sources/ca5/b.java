package ca5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Runnable {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ CommentRectLayout b;
    public final /* synthetic */ a c;
    public final /* synthetic */ sk5.c d;

    public b(FragmentActivity r1, CommentRectLayout r2, a r3, sk5.c r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        tt5.a.h("DrivePdfCommentOnboardCtrl", "postDelayed");
        if (this.a != null) goto L6;
        tt5.a.h("DrivePdfCommentOnboardCtrl", "activity null");
        return;
    L6:
        CommentRectLayout r1 = this.b;
        if (r1 != null) goto L11;
        tt5.a.h("DrivePdfCommentOnboardCtrl", "target null");
        return;
    L11:
        if (r1.isAttachedToWindow() == true) goto L15;
        tt5.a.h("DrivePdfCommentOnboardCtrl", "target not attached");
        return;
    L15:
        if (this.c.a == false) goto L17;
    L23:
        tt5.a.h("DrivePdfCommentOnboardCtrl", "already posted or finished");
        return;
    L17:
        if (this.d.isDebugMode() == true) goto L21;
        int r2 = c.b;
        if (((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().f("ccm_mobile_drive_pdf_area_box_comment_intro") == true) goto L23;
    L21:
        this.c.a = true;
        this.d.g(new c(this.b), this.a);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
