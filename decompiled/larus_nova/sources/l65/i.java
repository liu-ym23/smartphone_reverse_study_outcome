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

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f507719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f507720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f507721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f507722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f507723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public py4.i f507724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f507725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public sy4.d f507726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.drive.biz.preview.vc.connector.d> f507727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f507728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f507729k;

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
    public final void a(Class<? extends com.bytedance.ee.bear.drive.biz.preview.vc.connector.e> r110, Object r111) {
        Intrinsics.checkNotNullParameter(r110, "clazz");
        int r100 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.f217038a;
        boolean r101 = false;
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C3093a.a(this.f507719a) == false) goto L10;
        boolean r102 = this.f507723e;
        if (r102 == false) goto L9;
        ((ArrayList) this.f507727i).add(new k(this));
        if (Boolean.FALSE.equals(this.f507728j) == false) goto L10;
        m.b(new j(this, false), 30);
        goto L10
    L9:
        m.b(new j(this, r102), 30);
    L10:
        f r103 = this.f507725g;
        Boolean r104 = this.f507728j;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r110, "clazz");
        AbsFollowableContentProvider r105 = r103.f507710c;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r110, "clazz");
        tt5.a.h("CCMFollow_FollowableContentProvider", "initConnector: name=".concat(r110.getSimpleName()));
        Class<? extends com.bytedance.ee.bear.drive.biz.preview.vc.connector.e>[] r106 = r105.c();
        int r107 = r106.length;
        int r108 = 0;
    L11:
        ?? r109 = 0;
        r109 = 0;
        r109 = 0;
        r109 = 0;
        r109 = 0;
        r109 = 0;
        r109 = 0;
        if (r108 >= r107) goto L17;
        Class<? extends com.bytedance.ee.bear.drive.biz.preview.vc.connector.e> r112 = r106[r108];
        if (Intrinsics.areEqual(r112, r110) == true) goto L18;
        r108 = r108 + 1;
    L18:
        if (r112 != null) goto L20;
        tt5.a.k("CCMFollow_FollowableContentProvider", "initConnector fail, type not enable");
    L45:
        if (Intrinsics.areEqual(r110, com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.class) == false) goto L66;
        ?? r113 = (com.bytedance.ee.bear.drive.biz.preview.vc.comment.a) r103.a(r110);
        if (r113 == 0) goto L94;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.comment.ICommentWrapper");
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector setFollowDocumentInfo: ");
        WeakReference<p1> r114 = new WeakReference((p1) r111);
        r113.f223795a = r114;
        com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.c r115 = r113.f223796b;
        p1 r116 = r114.get();
        if (r116 != null) goto L51;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector addCommentSwitchChangeListener: mCommentWrapper is null");
    L52:
        com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.C3210a r117 = r113.f223797c;
        WeakReference<p1> r118 = r113.f223795a;
        if (r118 != null) goto L55;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector.java.addCommentClosedChangeListener: mCommentWrapper IS NULL");
    L59:
        StringBuilder r119 = new StringBuilder("setFollowDocumentInfo mLatestState is null?=");
        if (r113.f223799e != null) goto L62;
        r101 = true;
    L62:
        r119.append(r101);
        tt5.a.h("CCMFollow_CommentVCFollowConnector", r119.toString());
        DriveCommentState r120 = r113.f223799e;
        if (r120 == null) goto L78;
        r113.h(r120);
    L78:
        r109 = r113;
        goto L94
    L55:
        p1 r121 = r118.get();
        if (r121 != null) goto L58;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector addCommentClosedChangeListener: mCommentWrapper is null");
        goto L59
    L58:
        r121.M7(r117);
        goto L59
    L51:
        r116.G7(r115);
    L94:
        if (r109 == 0) goto L103;
        r109.g();
        return;
    L103:
        return;
    L66:
        if (Intrinsics.areEqual(r110, DriveDocCommentFollowConnector.class) == false) goto L74;
        r113 = (DriveDocCommentFollowConnector) r103.a(r110);
        if (r113 == 0) goto L94;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.comment.ICommentWrapper");
        p1 r122 = (p1) r111;
        Intrinsics.checkNotNullParameter(r122, "commentWrapper");
        tt5.a.h("DriveDocCommentFollowConnector", "setFollowDocumentInfo.");
        Iterator r123 = ((Map) r113.f223794a.getValue()).values().iterator();
    L71:
        if (r123.hasNext() == false) goto L78;
        ((p65.b) r123.next()).b(r122);
        goto L71
    L74:
        if (Intrinsics.areEqual(r110, com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.class) == false) goto L80;
        r113 = (com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b) r103.a(r110);
        if (r113 == 0) goto L94;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.preview.vc.pdf.IPDFViewAbstractLayer");
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r124 = (com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a) r111;
        r113.f223815h = new WeakReference(r124);
        r124.setScrollListener(r113.f223813f);
        r124.setPDFActionListener(r113.f223814g);
        goto L78
    L80:
        if (Intrinsics.areEqual(r110, o65.b.class) == false) goto L85;
        r113 = (o65.b) r103.a(r110);
        if (r113 == 0) goto L94;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.preview.vc.video.IVideoViewAbstractLayer");
        o65.a r125 = (o65.a) r111;
        r113.f522198f = new WeakReference(r125);
        r125.setVideoActionListener(r113.f522199g);
        goto L78
    L85:
        if (Intrinsics.areEqual(r110, m65.a.class) == false) goto L90;
        r113 = (m65.a) r103.a(r110);
        if (r113 == 0) goto L94;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.preview.vc.audio.IAudioViewAbstractLayer");
        m65.b r126 = (m65.b) r111;
        r113.f512282f = new WeakReference(r126);
        r126.setAudioActionListener(r113.f512283g);
        goto L78
    L90:
        if (Intrinsics.areEqual(r110, n65.a.class) == false) goto L94;
        r113 = (n65.a) r103.a(r110);
        if (r113 == 0) goto L94;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.preview.vc.image.ImageViewAbstractLayer");
        n65.b r127 = (n65.b) r111;
        r113.f518158f = new WeakReference(r127);
        r127.setImageActionListener(r113.f518159g);
        goto L78
    L20:
        Iterator r128 = ((ArrayList) r105.f223807b).iterator();
    L22:
        if (r128.hasNext() == false) goto L26;
        Object r129 = r128.next();
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r129).getClass(), r110) == false) goto L22;
    L28:
        if (((com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r129) == null) goto L30;
        tt5.a.k("CCMFollow_FollowableContentProvider", "initConnector fail, type already init");
        goto L45
    L30:
        Function0<com.bytedance.ee.bear.drive.biz.preview.vc.connector.e> r130 = r105.f223806a.get(r110);
        if (r130 == null) goto L33;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r131 = r130.invoke();
    L34:
        if (r131 == null) goto L45;
        StringBuilder r132 = new StringBuilder("initConnector name=");
        r132.append(r110.getSimpleName());
        r132.append(", mIsBlockPreview=");
        r132.append(r105.f223808c);
        r132.append(", fileBlockState=");
        if (r104 == null) goto L38;
        boolean r133 = r104.booleanValue();
    L39:
        r132.append(r133);
        tt5.a.h("CCMFollow_FollowableContentProvider", r132.toString());
        r131.f(r105.f223808c);
        if (r104 == null) goto L42;
        boolean r134 = r104.booleanValue();
    L43:
        r131.e(r134);
        r131.a(r105.f223810e);
        ((ArrayList) r105.f223807b).add(r131);
        goto L45
    L42:
        r134 = r105.f223808c;
        goto L43
    L38:
        r133 = r105.f223808c;
        goto L39
    L33:
        r131 = null;
        goto L34
    L26:
        r129 = null;
        goto L28
    L17:
        r112 = null;
        goto L18
    }

    public i(int r100, boolean r101, AttachmentFollowVM r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "attachmentFollowVM");
        this.f507727i = new ArrayList();
        this.f507719a = r100;
        this.f507723e = r101;
        this.f507725g = new f(this, r100, r101, r103);
    }
}
