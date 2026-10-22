package l65;

import com.bytedance.ee.bear.drive.biz.comment.p1;
import com.bytedance.ee.bear.drive.biz.docplugin.AttachmentFollowVM;
import com.bytedance.ee.bear.drive.biz.preview.vc.comment.DriveCommentState;
import com.bytedance.ee.bear.drive.biz.preview.vc.comment.DriveDocCommentFollowConnector;
import com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider;
import com.bytedance.ee.util.ui.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public final int a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final boolean e;
    public py4.i f;
    public final f g;
    public sy4.d h;
    public final List<com.bytedance.ee.bear.drive.biz.preview.vc.connector.d> i;
    public Boolean j;
    public boolean k;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.bytedance.ee.bear.drive.biz.preview.vc.comment.DriveDocCommentFollowConnector] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v13, types: [com.bytedance.ee.bear.drive.biz.preview.vc.comment.a] */
    /* JADX WARN: Type inference failed for: r12v2, types: [n65.a] */
    /* JADX WARN: Type inference failed for: r12v4, types: [m65.a] */
    /* JADX WARN: Type inference failed for: r12v6, types: [o65.b] */
    /* JADX WARN: Type inference failed for: r12v8, types: [com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.bytedance.ee.bear.drive.biz.preview.vc.connector.e] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    public final void a(Class<? extends com.bytedance.ee.bear.drive.biz.preview.vc.connector.e> r12, Object r13) {
        Intrinsics.checkNotNullParameter(r12, "clazz");
        int r1 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        boolean r2 = false;
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(this.a) == false) goto L10;
        boolean r3 = this.e;
        if (r3 == false) goto L9;
        ((ArrayList) this.i).add(new k(this));
        if (Boolean.FALSE.equals(this.j) == false) goto L10;
        m.b(new j(this, false), 30);
        goto L10
    L9:
        m.b(new j(this, r3), 30);
    L10:
        f r4 = this.g;
        Boolean r5 = this.j;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r12, "clazz");
        AbsFollowableContentProvider r6 = r4.c;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r12, "clazz");
        tt5.a.h("CCMFollow_FollowableContentProvider", "initConnector: name=".concat(r12.getSimpleName()));
        Class<? extends com.bytedance.ee.bear.drive.biz.preview.vc.connector.e>[] r0 = r6.c();
        int r7 = r0.length;
        int r8 = 0;
    L11:
        ?? r9 = 0;
        r9 = 0;
        r9 = 0;
        r9 = 0;
        r9 = 0;
        r9 = 0;
        r9 = 0;
        if (r8 >= r7) goto L17;
        Class<? extends com.bytedance.ee.bear.drive.biz.preview.vc.connector.e> r10 = r0[r8];
        if (Intrinsics.areEqual(r10, r12) == true) goto L18;
        r8 = r8 + 1;
    L18:
        if (r10 != null) goto L20;
        tt5.a.k("CCMFollow_FollowableContentProvider", "initConnector fail, type not enable");
    L45:
        if (Intrinsics.areEqual(r12, com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.class) == false) goto L66;
        ?? r14 = (com.bytedance.ee.bear.drive.biz.preview.vc.comment.a) r4.a(r12);
        if (r14 == 0) goto L94;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.comment.ICommentWrapper");
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector setFollowDocumentInfo: ");
        WeakReference<p1> r11 = new WeakReference((p1) r13);
        r14.a = r11;
        com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.c r16 = r14.b;
        p1 r17 = r11.get();
        if (r17 != null) goto L51;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector addCommentSwitchChangeListener: mCommentWrapper is null");
    L52:
        com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.C0154a r18 = r14.c;
        WeakReference<p1> r19 = r14.a;
        if (r19 != null) goto L55;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector.java.addCommentClosedChangeListener: mCommentWrapper IS NULL");
    L59:
        StringBuilder r110 = new StringBuilder("setFollowDocumentInfo mLatestState is null?=");
        if (r14.e != null) goto L62;
        r2 = true;
    L62:
        r110.append(r2);
        tt5.a.h("CCMFollow_CommentVCFollowConnector", r110.toString());
        DriveCommentState r111 = r14.e;
        if (r111 == null) goto L78;
        r14.h(r111);
    L78:
        r9 = r14;
        goto L94
    L55:
        p1 r20 = r19.get();
        if (r20 != null) goto L58;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector addCommentClosedChangeListener: mCommentWrapper is null");
        goto L59
    L58:
        r20.M7(r18);
        goto L59
    L51:
        r17.G7(r16);
    L94:
        if (r9 == 0) goto L103;
        r9.g();
        return;
    L103:
        return;
    L66:
        if (Intrinsics.areEqual(r12, DriveDocCommentFollowConnector.class) == false) goto L74;
        r14 = (DriveDocCommentFollowConnector) r4.a(r12);
        if (r14 == 0) goto L94;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.comment.ICommentWrapper");
        p1 r112 = (p1) r13;
        Intrinsics.checkNotNullParameter(r112, "commentWrapper");
        tt5.a.h("DriveDocCommentFollowConnector", "setFollowDocumentInfo.");
        Iterator r21 = ((Map) r14.a.getValue()).values().iterator();
    L71:
        if (r21.hasNext() == false) goto L78;
        ((p65.b) r21.next()).b(r112);
        goto L71
    L74:
        if (Intrinsics.areEqual(r12, com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.class) == false) goto L80;
        r14 = (com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b) r4.a(r12);
        if (r14 == 0) goto L94;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.preview.vc.pdf.IPDFViewAbstractLayer");
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r113 = (com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a) r13;
        r14.h = new WeakReference(r113);
        r113.setScrollListener(r14.f);
        r113.setPDFActionListener(r14.g);
        goto L78
    L80:
        if (Intrinsics.areEqual(r12, o65.b.class) == false) goto L85;
        r14 = (o65.b) r4.a(r12);
        if (r14 == 0) goto L94;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.preview.vc.video.IVideoViewAbstractLayer");
        o65.a r114 = (o65.a) r13;
        r14.f = new WeakReference(r114);
        r114.setVideoActionListener(r14.g);
        goto L78
    L85:
        if (Intrinsics.areEqual(r12, m65.a.class) == false) goto L90;
        r14 = (m65.a) r4.a(r12);
        if (r14 == 0) goto L94;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.preview.vc.audio.IAudioViewAbstractLayer");
        m65.b r115 = (m65.b) r13;
        r14.f = new WeakReference(r115);
        r115.setAudioActionListener(r14.g);
        goto L78
    L90:
        if (Intrinsics.areEqual(r12, n65.a.class) == false) goto L94;
        r14 = (n65.a) r4.a(r12);
        if (r14 == 0) goto L94;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.preview.vc.image.ImageViewAbstractLayer");
        n65.b r116 = (n65.b) r13;
        r14.f = new WeakReference(r116);
        r116.setImageActionListener(r14.g);
        goto L78
    L20:
        Iterator r22 = ((ArrayList) r6.b).iterator();
    L22:
        if (r22.hasNext() == false) goto L26;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r23).getClass(), r12) == false) goto L22;
    L28:
        if (((com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r23) == null) goto L30;
        tt5.a.k("CCMFollow_FollowableContentProvider", "initConnector fail, type already init");
        goto L45
    L30:
        Function0<com.bytedance.ee.bear.drive.biz.preview.vc.connector.e> r24 = r6.a.get(r12);
        if (r24 == null) goto L33;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r26 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r24.invoke();
    L34:
        if (r26 == null) goto L45;
        StringBuilder r27 = new StringBuilder("initConnector name=");
        r27.append(r12.getSimpleName());
        r27.append(", mIsBlockPreview=");
        r27.append(r6.c);
        r27.append(", fileBlockState=");
        if (r5 == null) goto L38;
        boolean r28 = r5.booleanValue();
    L39:
        r27.append(r28);
        tt5.a.h("CCMFollow_FollowableContentProvider", r27.toString());
        r26.f(r6.c);
        if (r5 == null) goto L42;
        boolean r29 = r5.booleanValue();
    L43:
        r26.e(r29);
        r26.a(r6.e);
        ((ArrayList) r6.b).add(r26);
        goto L45
    L42:
        r29 = r6.c;
        goto L43
    L38:
        r28 = r6.c;
        goto L39
    L33:
        r26 = null;
        goto L34
    L26:
        r23 = null;
        goto L28
    L17:
        r10 = null;
        goto L18
    }

    public i(int r2, boolean r3, AttachmentFollowVM r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "attachmentFollowVM");
        this.i = new ArrayList();
        this.a = r2;
        this.e = r3;
        this.g = new f(this, r2, r3, r5);
    }
}
