package com.bytedance.ee.bear.drive.biz.comment;

import android.os.Handler;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.biz.preview.orientation.DrivePreviewStatus;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.PhotoViewContainer;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public float a;
    public float b;
    public boolean c;
    public boolean d;
    public boolean e;
    public long f;
    public InterfaceC0120c g;
    public final CommentRectLayout h;
    public final et3.c i;
    public final Handler j;
    public final a k;
    public final b l;

    public class a implements Runnable {
        public final /* synthetic */ c a;

        public final void a() {
            c r0 = this.a;
            r0.j.removeCallbacks(r0.l);
            c r1 = this.a;
            boolean r2 = true;
            r1.c = true;
            InterfaceC0120c r3 = r1.g;
            if (r3 == null) goto L30;
            float r4 = r1.a;
            float r5 = r1.b;
            r95.x r6 = (r95.x) r3;
            tt5.a.h("preview_image", "photoview container onLongClick()");
            if (AppInfoUtils.e().booleanValue() == false) goto L8;
            tt5.a.h("PhotoViewContainer", "initListener, mempope app un-support");
            return;
        L8:
            if (r6.a.f.liveOuterCommentable().getValue() != null) goto L10;
            return;
        L10:
            if (((Boolean) r6.a.f.liveOuterCommentable().getValue()).booleanValue() == false) goto L33;
            PhotoViewContainer r7 = r6.a;
            DriveConfigurationVM r8 = r7.s;
            if (r8 != null) goto L14;
        L18:
            r2 = false;
        L19:
            if (r2 == false) goto L22;
            return;
        L22:
            if (r6.a.f.liveOuterCommentCardVisible().getValue() != null) goto L24;
        L26:
            r6.a.f.liveInnerForceFullScreen().postValue(Boolean.TRUE);
            if (r6.a.d.q() == true) goto L34;
            r6.a.i.i(2.0f, r4, r5);
            r6.a.e();
            r6.a.d.v(r4, r5);
            return;
        L34:
            return;
        L24:
            if (((Boolean) ((com.bytedance.ee.bear.drive.view.preview.wrapper.y) r6.a.f.liveOuterCommentCardVisible().getValue()).run()).booleanValue() == false) goto L26;
            return;
        L14:
            if (r8.getLiveUiState() == null) goto L18;
            if (r7.s.getLiveUiState().getValue() != DrivePreviewStatus.LANDSCAPE) goto L18;
        L33:
            return;
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

        public a(c r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public CommentRectF a;
        public final /* synthetic */ c b;

        public final void a() {
            c r0 = this.b;
            if (r0.e == false) goto L5;
            return;
        L5:
            r0.j.removeCallbacks(r0.k);
            c r1 = this.b;
            r1.c = true;
            if (r1.g == null) goto L15;
            CommentRectF r2 = this.a;
            if (r2 == null) goto L10;
            CommentRectLayout r3 = r1.h;
            r3.B = r2.b;
            r3.J.invalidate();
        L10:
            InterfaceC0120c r4 = this.b.g;
            CommentRectF r5 = this.a;
            r95.x r6 = (r95.x) r4;
            r6.getClass();
            tt5.a.h("preview_image", "photoview container onClick()");
            if (r5 == null) goto L13;
            r6.a.f.liveInnerCommentSelected().postValue(r5);
            r6.a.f();
            return;
        L13:
            r6.a.f.liveInnerSingleTap().postValue(null);
            return;
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

        public b(c r1) {
            this.b = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.comment.c$c, reason: collision with other inner class name */
    public interface InterfaceC0120c {
    }

    public c(CommentRectLayout r3) {
        this.i = new et3.c("bear_drive_image_scale");
        this.j = new Handler();
        this.k = new a(this);
        this.l = new b(this);
        this.h = r3;
    }
}
