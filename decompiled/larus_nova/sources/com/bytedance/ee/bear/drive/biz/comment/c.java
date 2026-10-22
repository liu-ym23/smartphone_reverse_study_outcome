package com.bytedance.ee.bear.drive.biz.comment;

import android.os.Handler;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.biz.preview.orientation.DrivePreviewStatus;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.PhotoViewContainer;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f222716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f222717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f222718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f222719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f222720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f222721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InterfaceC3176c f222722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CommentRectLayout f222723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final et3.c f222724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f222725j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f222726k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f222727l;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f222728a;

        public final void a() {
            c r100 = this.f222728a;
            r100.f222725j.removeCallbacks(r100.f222727l);
            c r101 = this.f222728a;
            boolean r102 = true;
            r101.f222718c = true;
            InterfaceC3176c r103 = r101.f222722g;
            if (r103 == null) goto L30;
            float r104 = r101.f222716a;
            float r105 = r101.f222717b;
            r95.x r106 = (r95.x) r103;
            tt5.a.h("preview_image", "photoview container onLongClick()");
            if (AppInfoUtils.e().booleanValue() == false) goto L8;
            tt5.a.h("PhotoViewContainer", "initListener, mempope app un-support");
            return;
        L8:
            if (r106.f536736a.f225009f.liveOuterCommentable().getValue() != null) goto L10;
            return;
        L10:
            if (r106.f536736a.f225009f.liveOuterCommentable().getValue().booleanValue() == false) goto L33;
            PhotoViewContainer r107 = r106.f536736a;
            DriveConfigurationVM r108 = r107.f225022s;
            if (r108 != null) goto L14;
        L18:
            r102 = false;
        L19:
            if (r102 == false) goto L22;
            return;
        L22:
            if (r106.f536736a.f225009f.liveOuterCommentCardVisible().getValue() != null) goto L24;
        L26:
            r106.f536736a.f225009f.liveInnerForceFullScreen().postValue(Boolean.TRUE);
            if (r106.f536736a.f225007d.q() == true) goto L34;
            r106.f536736a.f225012i.i(2.0f, r104, r105);
            r106.f536736a.e();
            r106.f536736a.f225007d.v(r104, r105);
            return;
        L34:
            return;
        L24:
            if (r106.f536736a.f225009f.liveOuterCommentCardVisible().getValue().run().booleanValue() == false) goto L26;
            return;
        L14:
            if (r108.getLiveUiState() == null) goto L18;
            if (r107.f225022s.getLiveUiState().getValue() != DrivePreviewStatus.LANDSCAPE) goto L18;
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

        public a(c r100) {
            this.f222728a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentRectF f222729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f222730b;

        public final void a() {
            c r100 = this.f222730b;
            if (r100.f222720e == false) goto L5;
            return;
        L5:
            r100.f222725j.removeCallbacks(r100.f222726k);
            c r101 = this.f222730b;
            r101.f222718c = true;
            if (r101.f222722g == null) goto L15;
            CommentRectF r102 = this.f222729a;
            if (r102 == null) goto L10;
            CommentRectLayout r103 = r101.f222723h;
            r103.B = r102.f236775b;
            r103.f236784J.invalidate();
        L10:
            InterfaceC3176c r104 = this.f222730b.f222722g;
            CommentRectF r105 = this.f222729a;
            r95.x r106 = (r95.x) r104;
            r106.getClass();
            tt5.a.h("preview_image", "photoview container onClick()");
            if (r105 == null) goto L13;
            r106.f536736a.f225009f.liveInnerCommentSelected().postValue(r105);
            r106.f536736a.f();
            return;
        L13:
            r106.f536736a.f225009f.liveInnerSingleTap().postValue(null);
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

        public b(c r100) {
            this.f222730b = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.comment.c$c, reason: collision with other inner class name */
    public interface InterfaceC3176c {
    }

    public c(CommentRectLayout r100) {
        this.f222724i = new et3.c("bear_drive_image_scale");
        this.f222725j = new Handler();
        this.f222726k = new a(this);
        this.f222727l = new b(this);
        this.f222723h = r100;
    }
}
