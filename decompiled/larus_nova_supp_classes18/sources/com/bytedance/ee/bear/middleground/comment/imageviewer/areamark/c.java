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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnTouchListener {
    public final /* synthetic */ CommentAreaMarkLayout a;
    public final /* synthetic */ a b;

    public c(CommentAreaMarkLayout r1, a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r13, MotionEvent r14) {
        CommentRectF r15 = null;
        if (r14 == null) goto L5;
        Integer r0 = Integer.valueOf(r14.getAction());
    L7:
        if (r0 != null) goto L10;
    L101:
        return false;
    L10:
        if (r0.intValue() != 0) goto L101;
        CommentAreaMarkLayout r1 = this.a;
        float r2 = r14.getX();
        float r16 = r14.getY();
        if (r1.n == true) goto L14;
        tt5.a.k("CommentAreaMarkLayout", "getTouchCommentRectF: commentRectVisible is false");
    L94:
        tt5.a.h("CommentImageAreaMarkRender", "onTouch :" + r15 + ", uuid: " + du5.b.h(this.a.getImageUUID()));
        if (r15 == null) goto L101;
        IImageViewer r17 = this.b.b;
        if (r17 == null) goto L101;
        r17.Wh();
        goto L101
    L14:
        CommentRectF r3 = r1.k0;
        int r6 = 1;
        boolean r7 = true;
        if (r3 == null) goto L53;
        CommentAreaMarkLayout.d r8 = r1.p0;
        if (r8 != null) goto L19;
    L21:
        boolean r9 = false;
    L22:
        tt5.a.h("CommentAreaMarkLayout", "getTouchCommentRectF: deletable = " + r9);
        if (r9 == false) goto L53;
        if (r1.B(r3).contains(r2, r16) != true) goto L53;
        tt5.a.h("CommentAreaMarkLayout", "removeAreaRect: before remove, target size = " + ((ArrayList) r1.b).size() + ", source size = " + ((ArrayList) r1.a).size());
        String r18 = r3.h;
        if (TextUtils.isEmpty(r18) == false) goto L29;
        tt5.a.k("CommentAreaMarkLayout", "removeAreaRect: target uuid is empty");
        r7 = false;
    L45:
        r1.k0 = null;
        tt5.a.b("CommentAreaMarkLayout", "handleDeleteIconClick: mCommentTargetRectList = " + r1.b);
        CommentRectLayout.b r19 = r1.J;
        if (r19 == null) goto L48;
        r19.invalidate();
    L48:
        if (r7 == false) goto L52;
        CommentAreaMarkLayout.d r110 = r1.p0;
        if (r110 == null) goto L52;
        r110.c(r3);
    L52:
        r15 = r3;
        goto L94
    L29:
        Iterator r10 = ((ArrayList) r1.b).iterator();
        int r11 = 0;
    L31:
        if (r10.hasNext() == false) goto L36;
        if (TextUtils.equals(((CommentRectF) r10.next()).h, r18) == true) goto L37;
        r11 = r11 + 1;
    L37:
        if (r11 != (-1)) goto L39;
    L43:
        r7 = false;
    L44:
        tt5.a.h("CommentAreaMarkLayout", "removeAreaRect: after remove, removed = " + r7 + ", target size = " + ((ArrayList) r1.b).size() + ", source size = " + ((ArrayList) r1.a).size());
        goto L45
    L39:
        if (((ArrayList) r1.a).size() <= r11) goto L43;
        if (TextUtils.equals(((CommentRectF) ListProtector.get(r1.a, r11)).h, r18) == false) goto L43;
        ListProtector.remove(r1.b, r11);
        ListProtector.remove(r1.a, r11);
        goto L44
    L36:
        r11 = -1;
        goto L37
    L19:
        if (r8.a(r3) != true) goto L21;
        r9 = true;
    L53:
        ArrayList r4 = new ArrayList();
        int r5 = ((ArrayList) r1.b).size() - 1;
        if (r5 < 0) goto L75;
    L55:
        int r12 = r5 - 1;
        CommentRectF r20 = (CommentRectF) ListProtector.get(r1.b, r5);
        if (r20.getType() != 5) goto L69;
        Intrinsics.checkNotNull(r20);
        CommentAreaMarkLayout.c r21 = r1.z(r20);
        if (r21 == null) goto L60;
        RectF r22 = r21.a;
    L61:
        if (r22 != null) goto L63;
    L65:
        boolean r23 = false;
    L66:
        if (r23 == false) goto L69;
        r1.A(r20);
        r15 = r20;
        goto L94
    L63:
        if (r22.contains(r2, r16) != true) goto L65;
        r23 = true;
        goto L66
    L60:
        r22 = null;
    L69:
        if (r20.contains(r2, r16) == false) goto L71;
        Intrinsics.checkNotNull(r20);
        r4.add(r20);
    L71:
        if (r12 < 0) goto L75;
        r5 = r12;
    L75:
        if (r4.isEmpty() == true) goto L94;
        if (r4.size() != 1) goto L81;
        r15 = (CommentRectF) ListProtector.get(r4, 0);
        r1.A(r15);
        goto L94
    L81:
        if ((!r4.isEmpty()) == false) goto L100;
        r15 = (CommentRectF) ListProtector.get(r4, 0);
        float r111 = (((RectF) r15).right - ((RectF) r15).left) * (((RectF) r15).bottom - ((RectF) r15).top);
        int r24 = r4.size();
    L83:
        if (r6 >= r24) goto L93;
        CommentRectF r25 = (CommentRectF) ListProtector.get(r4, r6);
        float r26 = (((RectF) r25).right - ((RectF) r25).left) * (((RectF) r25).bottom - ((RectF) r25).top);
        if (r26 >= r111) goto L88;
    L91:
        r15 = r25;
        r111 = r26;
    L92:
        r6 = r6 + 1;
        goto L83
    L88:
        if (Math.abs(r26 - r111) >= 0.5f) goto L92;
        if (r25.d <= r15.d) goto L92;
    L93:
        r1.A(r15);
        goto L94
    L100:
        throw new IllegalArgumentException("Rects list cannot be empty".toString());
    L5:
        r0 = null;
        goto L7
    }
}
