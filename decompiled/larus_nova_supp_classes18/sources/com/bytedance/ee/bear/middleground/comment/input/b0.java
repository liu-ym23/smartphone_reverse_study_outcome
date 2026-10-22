package com.bytedance.ee.bear.middleground.comment.input;

import android.graphics.Matrix;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.contract.imageviewer.delegate.ImageAction;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter;
import com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.AreaMarkMode;
import com.bytedance.ee.bear.middleground.comment.uitls.CommentUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.vfs.VFSPath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0 implements CommentImageAdapter.a {
    public final /* synthetic */ BaseInputComment a;

    public static final class a implements uw4.b {
        public final /* synthetic */ BaseInputComment a;

        public final void a(String r1, int r2) {
        }

        public final void b(String r1, int r2, ImageData.Image r3, LargeImageView r4) {
        }

        public final void e() {
        }

        public a(BaseInputComment r1) {
            this.a = r1;
        }

        public final void c(String r2, int r3, View r4) {
            if (this.a.b0 == null) goto L6;
            com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a.f(r2, r3, r4);
            return;
        }

        public final void d(String r2, FrameLayout r3, LargeImageView r4) {
            com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a r0 = this.a.b0;
            if (r0 == null) goto L6;
            r0.e(r2, r3, r4);
            return;
        }
    }

    public static final class b implements uw4.f {
        public final /* synthetic */ BaseInputComment a;

        public final void a() {
        }

        public final void c() {
        }

        public final void d(String r1) {
        }

        public final void e(String r1) {
        }

        public final void f(String r1, float[] r2, Matrix r3) {
        }

        public b(BaseInputComment r1) {
            this.a = r1;
        }

        public final void b(String r3, View r4, View r5, VFSPath r6) {
            tt5.a.h("Comment#ImageViewerWrapper", "onClickAreaMark... uuid = " + du5.b.h(r3));
            com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a r7 = this.a.b0;
            if (r7 == null) goto L6;
            r7.g(r4, r5, r6);
            return;
        }
    }

    public static final class c implements tw4.b {
        public final /* synthetic */ BaseInputComment a;

        public c(BaseInputComment r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "imageUUID");
            BaseInputComment r3 = this.a;
            r3.a.d0.i(r3.j.reply_id);
        }

        public final void b(ImageAction r3) {
            Intrinsics.checkNotNullParameter(r3, "imageAction");
            this.a.a.d0.h(r3.getAction(), this.a.j.reply_id);
        }
    }

    public static final class d implements uw4.c {
        public final /* synthetic */ BaseInputComment a;

        public static final class a implements Runnable {
            public final /* synthetic */ BaseInputComment a;

            public a(BaseInputComment r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if (this.a.U.isSelected() == true) goto L9;
                this.a.w0(100);     // Catch: Throwable -> L6
                return;
            }
        }

        public final void onCreated() {
            this.a.Z();
        }

        public d(BaseInputComment r1) {
            this.a = r1;
        }

        public final void a(IImageViewer r2) {
            Intrinsics.checkNotNullParameter(r2, "viewer");
            BaseInputComment r3 = this.a;
            r3.a0 = null;
            com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a r4 = r3.b0;
            if (r4 == null) goto L5;
            r4.c();
        L5:
            BaseInputComment r5 = this.a;
            r5.b0 = null;
            r5.W.notifyDataSetChanged();
            com.bytedance.ee.util.ui.j.c(new a(this.a));
        }

        public final void b(String r3) {
            ((sw4.c) org.koin.java.a.c(sw4.c.class, null, null, 6)).c((FragmentManager) this.a.g.invoke(), this.a.L());
        }
    }

    public b0(BaseInputComment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter.a
    public final void a(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r11) {
        b2 r0 = this.a.X;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r11, "selectedItem");
        ImageData r5 = com.bytedance.ee.bear.middleground.comment.uitls.j.a(r11, r0.k, null);
        if (r5 != null) goto L5;
        return;
    L5:
        Lazy r12 = CommentUtils.a;
        Pair r13 = CommentUtils.a(this.a.a.k.b, true);
        boolean r1 = ((Boolean) r13.component1()).booleanValue();
        boolean r14 = ((Boolean) r13.component2()).booleanValue();
        r5.getToolStatus().setAreaComment(r14);
        IImageViewer r15 = this.a.a0;
        if (r15 == null) goto L8;
        r15.wn(r5);
        return;
    L8:
        com.bytedance.ee.bear.browser.plugin.s.a(2130772329, 2130772330, 2130772329, 2130772330);
        BaseInputComment r16 = this.a;
        sw4.c r2 = (sw4.c) org.koin.java.a.c(sw4.c.class, null, null, 6);
        FragmentActivity r3 = this.a.a.getActivity();
        FragmentManager r4 = (FragmentManager) this.a.g.invoke();
        String r6 = this.a.L();
        com.bytedance.ee.bear.middleground.comment.uitls.p r7 = this.a.a;
        r16.a0 = r2.b(r3, r4, r5, r6, r7.i, r7.k.b, "input_comment");
        if (r1 == false) goto L17;
        BaseInputComment r17 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.p r8 = r17.a;
        AreaMarkMode r9 = AreaMarkMode.EDIT;
        IImageViewer r10 = r17.a0;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r18 = r17.X.k;
        ArrayList r19 = new ArrayList();
        Iterator r20 = ((ArrayList) r18).iterator();
    L12:
        if (r20.hasNext() == false) goto L16;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r21 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r20.next();
        if (r21 == null) goto L12;
        r19.add(r21);
        goto L12
    L16:
        BaseInputComment r22 = this.a;
        com.bytedance.ee.bear.middleground.comment.p r23 = r22.a.h;
        com.bytedance.ee.bear.middleground.comment.control.z r24 = r22.b;
        CommentInputRequest r25 = r22.j;
        r17.b0 = new com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a(r8, r10, r9, r19, r23, r24, r25.comment_id, r25.reply_id);
    L17:
        BaseInputComment r110 = this.a;
        IImageViewer r26 = r110.a0;
        if (r26 == null) goto L20;
        r26.mG(new a(r110));
    L20:
        BaseInputComment r111 = this.a;
        IImageViewer r27 = r111.a0;
        if (r27 == null) goto L23;
        r27.qK(new b(r111));
    L23:
        BaseInputComment r112 = this.a;
        IImageViewer r28 = r112.a0;
        if (r28 == null) goto L26;
        r28.RX(new c(r112));
    L26:
        BaseInputComment r113 = this.a;
        IImageViewer r29 = r113.a0;
        if (r29 == null) goto L36;
        r29.xJ(new d(r113));
        return;
    }
}
