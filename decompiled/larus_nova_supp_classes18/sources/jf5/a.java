package jf5;

import android.graphics.Matrix;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.contract.imageviewer.delegate.ImageAction;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.imageviewer.ImageViewerDialogFragment;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.AreaMarkMode;
import com.bytedance.ee.bear.middleground.comment.uitls.CommentUtils;
import com.bytedance.ee.bear.middleground.comment.uitls.j;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.vfs.VFSPath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uw4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final p a;
    public final z b;
    public IImageViewer c;
    public ImageData d;
    public final boolean e;
    public com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a f;

    /* JADX INFO: renamed from: jf5.a$a, reason: collision with other inner class name */
    public static final class C0251a {
    }

    public static final class b implements f {
        public final /* synthetic */ a a;

        public final void a() {
        }

        public final void c() {
        }

        public final void d(String r1) {
        }

        public final void e(String r1) {
        }

        public b(a r1) {
            this.a = r1;
        }

        public final void f(String r2, float[] r3, Matrix r4) {
            Intrinsics.checkNotNullParameter(r2, "imageToken");
            Intrinsics.checkNotNullParameter(r4, "matrix");
            Function3<String, float[], Matrix, Unit> r0 = this.a.b.c0();
            if (r0 == null) goto L6;
            r0.invoke(r2, r3, r4);
            return;
        }

        public final void b(String r3, View r4, View r5, VFSPath r6) {
            Intrinsics.checkNotNullParameter(r4, "view");
            tt5.a.h("Comment#ImageViewerWrapper", "onClickAreaMark... uuid = " + du5.b.h(r3));
            com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a r7 = this.a.f;
            if (r7 == null) goto L6;
            r7.g(r4, r5, r6);
            return;
        }
    }

    public static final class c implements tw4.b {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "imageUUID");
            this.a.a.d0.i(this.b);
        }

        public final void b(ImageAction r3) {
            Intrinsics.checkNotNullParameter(r3, "imageAction");
            this.a.a.d0.h(r3.getAction(), this.b);
        }

        public c(a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements uw4.c {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public final void onCreated() {
        }

        public final void a(IImageViewer r2) {
            Intrinsics.checkNotNullParameter(r2, "viewer");
            if (Intrinsics.areEqual(r2, this.a.c) == false) goto L5;
            this.a.c = null;
        L5:
            com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a r3 = this.a.f;
            if (r3 == null) goto L8;
            r3.c();
        L8:
            this.a.f = null;
        }

        public final void b(String r5) {
            ((sw4.c) org.koin.java.a.c(sw4.c.class, null, null, 6)).f(this.a.a.d(), "Comment#ImageViewerWrapper");
            this.a.b.g1().invoke(this.b, 0, this.c, -1);
        }

        public d(a r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e implements uw4.b {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public final void a(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "uuid");
        }

        public final void e() {
        }

        public e(a r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void c(String r6, int r7, View r8) {
            Intrinsics.checkNotNullParameter(r6, "uuid");
            tt5.a.h("Comment#ImageViewerWrapper", "onSwipe... uuid = " + du5.b.h(r6) + ", index = " + r7);
            this.a.b.g1().invoke(this.b, 0, this.c, Integer.valueOf(r7));
            if (this.a.f == null) goto L6;
            com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a.f(r6, r7, r8);
            return;
        }

        public final void d(String r2, FrameLayout r3, LargeImageView r4) {
            com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.e(r2, r3, r4);
            return;
        }

        public final void b(String r1, int r2, ImageData.Image r3, LargeImageView r4) {
            tt5.a.h("Comment#ImageViewerWrapper", "onLoadSuccess... uuid = " + du5.b.h(r1) + ", index = " + r2);
        }
    }

    static {
    }

    public final void a() {
        IImageViewer r0 = this.c;
        if (r0 == null) goto L5;
        r0.close();
    L5:
        this.c = null;
    }

    public final boolean b() {
        if (this.e == true) goto L5;
        return false;
    L5:
        p r0 = this.a;
        if (r0.s == true) goto L9;
        return false;
    L9:
        if (r0.k.b == sbb.e.o.b) goto L11;
        return false;
    L11:
        CommentPlugin.g r1 = r0.R;
        if (r1 != null) goto L14;
        return false;
    L14:
        if (r1.b() != true) goto L18;
        return true;
    L18:
        return false;
    }

    public final void d() {
        boolean r0 = b();
        ImageData r1 = this.d;
        if (r1 == null) goto L7;
        ImageData.ToolStatus r2 = r1.getToolStatus();
        if (r2 == null) goto L7;
        r2.setFollowMark(r0);
    L7:
        ImageData r3 = this.d;
        if (r3 == null) goto L17;
        List r4 = r3.getImageList();
        if (r4 == null) goto L17;
        Iterator r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        ImageData.ToolStatus r6 = ((ImageData.Image) r5.next()).getSingleToolStatus();
        if (r6 == null) goto L13;
        r6.setFollowMark(r0);
    L17:
        IImageViewer r7 = this.c;
        if (r7 == null) goto L22;
        boolean r8 = true;
        if (r7.isShowing() != true) goto L22;
    L23:
        if (r8 == false) goto L37;
        ImageData r9 = this.d;
        if (r9 == null) goto L27;
        ImageData r10 = r9.clone();
    L28:
        IImageViewer r11 = this.c;
        if (r11 == null) goto L38;
        r11.wn(r10);
        return;
    L38:
        return;
    L27:
        r10 = null;
        goto L28
    L37:
        return;
    L22:
        r8 = false;
        goto L23
    }

    public a(p r2, z r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "commentListeners");
        this.a = r2;
        this.b = r3;
        this.e = com.bytedance.ee.bear.appsetting.c.a.a.g("byteview.meeting.annotate_in_magic_share");
    }

    public final void c(String r27, String r28, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r29, int r30, boolean r31, CommentBean r32, CommentImageShowSource r33) {
        Intrinsics.checkNotNullParameter(r27, "commentId");
        Intrinsics.checkNotNullParameter(r28, "replyId");
        Intrinsics.checkNotNullParameter(r33, "showSource");
        if (r29 != null) goto L5;
    L114:
        int r3 = 0;
        StringBuilder r4 = new StringBuilder("showCommentImageViewer()... params illegal! commentId = ");
        r4.append(r27);
        r4.append(", replyId = ");
        r4.append(r28);
        r4.append(", imageList.size = ");
        if (r29 == null) goto L117;
        r3 = r29.size();
    L117:
        r4.append(r3);
        r4.append(", activeIndex = ");
        r4.append(r30);
        tt5.a.d("Comment#ImageViewerWrapper", r4.toString());
        a();
        return;
    L5:
        if (r29.isEmpty() == true) goto L114;
        if (r30 < 0) goto L114;
        if (r30 >= r29.size()) goto L114;
        Lazy r5 = CommentUtils.a;
        p r6 = this.a;
        Pair r7 = CommentUtils.a(r6.k.b, r6.q.getComment());
        boolean r8 = ((Boolean) r7.component1()).booleanValue();
        boolean r9 = ((Boolean) r7.component2()).booleanValue();
        ImageData.ToolStatus r10 = new ImageData.ToolStatus();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r11 = true;
        if (jg5.e.a.a.g() == false) goto L28;
        if (this.a.q.g() == false) goto L17;
        p r12 = this.a;
        if (r12.S.c(r12.k.b, r12.i, "CONTENT_COPY").getAllow() == false) goto L17;
        boolean r13 = true;
    L18:
        r10.setCopy(r13);
        p r14 = this.a;
        PermissionResponse r15 = r14.S.c(r14.k.b, r14.i, "ATTACHMENT_DOWNLOAD");
        if (this.a.q.e() == false) goto L23;
        if (r15.getAllow() == false) goto L23;
    L24:
        boolean r16 = true;
    L26:
        r10.setExport(r16);
    L42:
        r10.setFollowMark(b());
        r10.setAreaComment(r9);
        ImageData r17 = j.a((CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) ListProtector.get(r29, r30), r29, r10);
        IImageViewer r2 = this.c;
        if (r2 != null) goto L84;
        CommentPlugin.g r18 = this.a.R;
        if (r18 != null) goto L47;
    L49:
        boolean r19 = false;
    L50:
        int r20 = 2130772330;
        if (r19 == false) goto L53;
        int r21 = 0;
    L54:
        CommentPlugin.g r22 = this.a.R;
        if (r22 != null) goto L57;
    L59:
        r11 = false;
    L60:
        if (r11 == false) goto L62;
        r20 = 0;
    L62:
        s r110 = s.a(2130772329, r21, 2130772329, r20);
        sw4.c r111 = (sw4.c) org.koin.java.a.c(sw4.c.class, null, null, 6);
        if (r31 == false) goto L66;
        FragmentActivity r112 = this.a.getActivity();
        FragmentManager r113 = this.a.d();
        p r23 = this.a;
        ImageViewerDialogFragment r24 = r111.b(r112, r113, r17, "Comment#ImageViewerWrapper", r23.i, r23.k.b, "");
    L65:
        ImageViewerDialogFragment r25 = r24;
        this.c = r25;
        if (r8 == false) goto L78;
        p r26 = this.a;
        AreaMarkMode r34 = AreaMarkMode.READ;
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r1 = r29;
        ArrayList r35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r36 = r1.iterator();
    L75:
        if (r36.hasNext() == false) goto L77;
        r35.add((CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r36.next());
        goto L75
    L77:
        this.f = new com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a(r26, r25, r34, r35, this.a.h, this.b, r27, r28, r32, r33);
    L78:
        IImageViewer r37 = this.c;
        if (r37 == null) goto L81;
        r37.qK(new b(this));
    L81:
        IImageViewer r38 = this.c;
        if (r38 == null) goto L106;
        r38.RX(new c(this, r28));
    L106:
        IImageViewer r39 = this.c;
        if (r39 == null) goto L109;
        r39.xJ(new d(this, r27, r28));
    L109:
        IImageViewer r40 = this.c;
        if (r40 == null) goto L112;
        r40.mG(new e(this, r27, r28));
    L112:
        this.d = r17;
        return;
    L66:
        FragmentActivity r114 = this.a.getActivity();
        FragmentManager r115 = this.a.d();
        p r41 = this.a;
        FrameLayout r42 = r41.e;
        String r43 = r41.i;
        int r44 = r41.k.b;
        if (r41.s == false) goto L69;
        String r45 = ThumbGlideUrl.SOURCE_VC;
    L70:
        r24 = r111.d(r114, r115, r110, r42, r17, "Comment#ImageViewerWrapper", r43, r44, r45);
        goto L65
    L69:
        r45 = "";
        goto L70
    L57:
        if (r22.a() != true) goto L59;
    L53:
        r21 = 2130772330;
        goto L54
    L47:
        if (r18.a() != true) goto L49;
        r19 = true;
        goto L50
    L84:
        r2.wn(r17);
        com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a r46 = this.f;
        if (r46 == null) goto L91;
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r47 = r29;
        ArrayList r48 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));
        Iterator<T> r49 = r47.iterator();
    L88:
        if (r49.hasNext() == false) goto L90;
        r48.add((CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r49.next());
        goto L88
    L90:
        r46.d = r48;
    L91:
        com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a r50 = this.f;
        if (r50 == null) goto L94;
        r50.j = r33;
    L94:
        if (r50 == null) goto L96;
        r50.c();
    L96:
        CommentPlugin.g r51 = this.a.R;
        if (r51 != null) goto L99;
    L101:
        r11 = false;
    L102:
        if (r11 == false) goto L106;
        s r52 = ((sw4.c) org.koin.java.a.c(sw4.c.class, null, null, 6)).g();
        if (r52 == null) goto L106;
        r52.b = 0;
        r52.d = 0;
        goto L106
    L99:
        if (r51.a() != true) goto L101;
    L23:
        if (r15.getDenySource().getDenyType() == DenyType.FILE_STRATEGY) goto L24;
        r16 = false;
    L17:
        r13 = false;
        goto L18
    L28:
        if (this.a.q.g() == false) goto L32;
        p r53 = this.a;
        if (r53.S.e(r53.k.b, r53.i).a == false) goto L32;
        boolean r54 = true;
    L33:
        r10.setCopy(r54);
        p r55 = this.a;
        bf5.a r56 = r55.S;
        int r116 = r55.k.b;
        gj5.c r57 = r56.d(r55.i);
        if (this.a.q.e() == false) goto L38;
        if (r57.a == false) goto L38;
    L39:
        boolean r58 = true;
    L41:
        r10.setExport(r58);
    L38:
        if (r57.b == FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L39;
        r58 = false;
    L32:
        r54 = false;
        goto L33
    }
}
