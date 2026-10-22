package com.bytedance.ee.bear.middleground.comment.imageviewer.areamark;

import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentAreaMarkLayout;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentAreaMarkLayout f231682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f231683b;

    public c(CommentAreaMarkLayout r100, a r101) {
        this.f231682a = r100;
        this.f231683b = r101;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        CommentRectF r112 = null;
        if (r111 == null) goto L5;
        Integer r100 = Integer.valueOf(r111.getAction());
    L7:
        if (r100 != null) goto L10;
    L101:
        return false;
    L10:
        if (r100.intValue() != 0) goto L101;
        CommentAreaMarkLayout r101 = this.f231682a;
        float r102 = r111.getX();
        float r113 = r111.getY();
        if (r101.f236798n == true) goto L14;
        tt5.a.k("CommentAreaMarkLayout", "getTouchCommentRectF: commentRectVisible is false");
    L94:
        tt5.a.h("CommentImageAreaMarkRender", "onTouch :" + r112 + ", uuid: " + du5.b.h(this.f231682a.getImageUUID()));
        if (r112 == null) goto L101;
        IImageViewer r114 = this.f231683b.f231663b;
        if (r114 == null) goto L101;
        r114.Wh();
        goto L101
    L14:
        CommentRectF r103 = r101.f236763k0;
        int r104 = 1;
        boolean r105 = true;
        if (r103 == null) goto L53;
        CommentAreaMarkLayout.d r106 = r101.f236764p0;
        if (r106 != null) goto L19;
    L21:
        boolean r107 = false;
    L22:
        tt5.a.h("CommentAreaMarkLayout", "getTouchCommentRectF: deletable = " + r107);
        if (r107 == false) goto L53;
        if (r101.B(r103).contains(r102, r113) != true) goto L53;
        tt5.a.h("CommentAreaMarkLayout", "removeAreaRect: before remove, target size = " + ((ArrayList) r101.f236786b).size() + ", source size = " + ((ArrayList) r101.f236785a).size());
        String r115 = r103.f236781h;
        if (TextUtils.isEmpty(r115) == false) goto L29;
        tt5.a.k("CommentAreaMarkLayout", "removeAreaRect: target uuid is empty");
        r105 = false;
    L45:
        r101.f236763k0 = null;
        tt5.a.b("CommentAreaMarkLayout", "handleDeleteIconClick: mCommentTargetRectList = " + r101.f236786b);
        CommentRectLayout.b r116 = r101.f236784J;
        if (r116 == null) goto L48;
        r116.invalidate();
    L48:
        if (r105 == false) goto L52;
        CommentAreaMarkLayout.d r117 = r101.f236764p0;
        if (r117 == null) goto L52;
        r117.c(r103);
    L52:
        r112 = r103;
        goto L94
    L29:
        Iterator r108 = ((ArrayList) r101.f236786b).iterator();
        int r109 = 0;
    L31:
        if (r108.hasNext() == false) goto L36;
        if (TextUtils.equals(((CommentRectF) r108.next()).f236781h, r115) == true) goto L37;
        r109 = r109 + 1;
    L37:
        if (r109 != (-1)) goto L39;
    L43:
        r105 = false;
    L44:
        tt5.a.h("CommentAreaMarkLayout", "removeAreaRect: after remove, removed = " + r105 + ", target size = " + ((ArrayList) r101.f236786b).size() + ", source size = " + ((ArrayList) r101.f236785a).size());
        goto L45
    L39:
        if (((ArrayList) r101.f236785a).size() <= r109) goto L43;
        if (TextUtils.equals(((CommentRectF) ListProtector.get(r101.f236785a, r109)).f236781h, r115) == false) goto L43;
        ListProtector.remove(r101.f236786b, r109);
        ListProtector.remove(r101.f236785a, r109);
        goto L44
    L36:
        r109 = -1;
        goto L37
    L19:
        if (r106.a(r103) != true) goto L21;
        r107 = true;
    L53:
        ArrayList r118 = new ArrayList();
        int r119 = ((ArrayList) r101.f236786b).size() - 1;
        if (r119 < 0) goto L75;
    L55:
        int r120 = r119 - 1;
        CommentRectF r121 = (CommentRectF) ListProtector.get(r101.f236786b, r119);
        if (r121.getType() != 5) goto L69;
        Intrinsics.checkNotNull(r121);
        CommentAreaMarkLayout.c r122 = r101.z(r121);
        if (r122 == null) goto L60;
        RectF r123 = r122.f236768a;
    L61:
        if (r123 != null) goto L63;
    L65:
        boolean r124 = false;
    L66:
        if (r124 == false) goto L69;
        r101.A(r121);
        r112 = r121;
        goto L94
    L63:
        if (r123.contains(r102, r113) != true) goto L65;
        r124 = true;
        goto L66
    L60:
        r123 = null;
    L69:
        if (r121.contains(r102, r113) == false) goto L71;
        Intrinsics.checkNotNull(r121);
        r118.add(r121);
    L71:
        if (r120 < 0) goto L75;
        r119 = r120;
    L75:
        if (r118.isEmpty() == true) goto L94;
        if (r118.size() != 1) goto L81;
        r112 = (CommentRectF) ListProtector.get(r118, 0);
        r101.A(r112);
        goto L94
    L81:
        if ((!r118.isEmpty()) == false) goto L100;
        r112 = (CommentRectF) ListProtector.get(r118, 0);
        float r125 = (((RectF) r112).right - ((RectF) r112).left) * (((RectF) r112).bottom - ((RectF) r112).top);
        int r126 = r118.size();
    L83:
        if (r104 >= r126) goto L93;
        CommentRectF r127 = (CommentRectF) ListProtector.get(r118, r104);
        float r128 = (((RectF) r127).right - ((RectF) r127).left) * (((RectF) r127).bottom - ((RectF) r127).top);
        if (r128 >= r125) goto L88;
    L91:
        r112 = r127;
        r125 = r128;
    L92:
        r104 = r104 + 1;
        goto L83
    L88:
        if (Math.abs(r128 - r125) >= 0.5f) goto L92;
        if (r127.f236777d <= r112.f236777d) goto L92;
    L93:
        r101.A(r112);
        goto L94
    L100:
        throw new IllegalArgumentException("Rects list cannot be empty".toString());
    L5:
        r100 = null;
        goto L7
    }
}
