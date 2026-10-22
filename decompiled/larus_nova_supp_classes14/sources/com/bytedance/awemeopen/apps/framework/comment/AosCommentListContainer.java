package com.bytedance.awemeopen.apps.framework.comment;

import android.R;
import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBSViewInfoManager;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.a0;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.c0;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.s;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.t;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.u;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.y;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.google.android.material.internal.AosBottomSheetBehavior;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AosCommentListContainer implements c0 {
    public final CommentPageParam a;
    public final a0 b;
    public final s24.b c;
    public final Activity d;
    public ViewGroup e;
    public View f;
    public CommentListView g;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b h;
    public final CommentPageParam i;
    public final AosBSViewInfoManager j;
    public long k;

    public final void b() {
        this.e = (ViewGroup) this.h.getActivity().findViewById(R.id.content);
        View r0 = View.inflate(this.d, 2131558599, null);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, -1);
        r1.bottomMargin = this.a.m;
        final AosBSViewInfoManager r3 = this.j;
        s24.b r4 = this.c;
        r3.getClass();
        Intrinsics.checkNotNullParameter(this, "bottomSheetDialog");
        Intrinsics.checkNotNullParameter(r0, "view");
        r3.g = this;
        if (r3.b != null) goto L18;
        View r5 = View.inflate(getActivity(), 2131558617, null);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r6 = (FrameLayout) r5;
        r3.b = r6;
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNull(r6.findViewById(2131367947), "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        FrameLayout r7 = r3.b;
        Intrinsics.checkNotNull(r7);
        View r8 = r7.findViewById(2131368870);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r9 = (FrameLayout) r8;
        r3.c = r9;
        Intrinsics.checkNotNull(r9);
        CoordinatorLayout.LayoutParams r10 = r9.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r11 = r10;
        int r12 = getBottomSheetHeight();
        if (r12 <= 0) goto L7;
        ((ViewGroup.MarginLayoutParams) r11).height = r12;
    L7:
        FrameLayout r13 = r3.c;
        Intrinsics.checkNotNull(r13);
        AosBottomSheetBehavior<FrameLayout> r14 = AosBottomSheetBehavior.from(r13);
        r3.a = r14;
        if (r14 == null) goto L11;
        r14.setHideable(true);
    L11:
        AosBottomSheetBehavior<FrameLayout> r15 = r3.a;
        if (r15 == null) goto L15;
        r15.setState(3);
    L15:
        FrameLayout r16 = r3.c;
        if (r16 == null) goto L18;
        x54.b.b(r16);
    L18:
        FrameLayout r17 = r3.b;
        if (r17 == null) goto L21;
        View r18 = r17.findViewById(2131367947);
    L22:
        FrameLayout r19 = r3.c;
        if (r19 == null) goto L25;
        r19.removeAllViews();
    L25:
        FrameLayout r20 = r3.c;
        if (r20 == null) goto L28;
        r20.addView(r0, r1);
    L28:
        if (r18 == null) goto L32;
        View r2 = r18.findViewById(2131389274);
        if (r2 == null) goto L32;
        r2.setOnClickListener(new s(r3, this));
    L32:
        FrameLayout r21 = r3.c;
        if (r21 == null) goto L35;
        r21.setOnTouchListener(new t());
    L35:
        AosBottomSheetBehavior<FrameLayout> r22 = r3.a;
        if (r22 == null) goto L38;
        r22.addBottomSheetCallback(new y(r3, this));
    L38:
        r3.h = r4;
        FrameLayout r23 = r3.c;
        if (r23 == null) goto L41;
        r23.post(new u(r3));
    L41:
        FrameLayout r24 = r3.b;
        if (r24 == null) goto L44;
        float r25 = r24.getHeight();
    L45:
        r3.j = r25;
        FrameLayout r26 = r3.b;
        this.f = r26;
        ViewGroup r27 = this.e;
        if (r27 == null) goto L48;
        r27.addView(r26);
    L48:
        CommentListView r28 = (CommentListView) r0.findViewById(2131367388);
        this.g = r28;
        if (r28 == null) goto L51;
        r28.t(this.i, null);
    L51:
        CommentListView r29 = this.g;
        if (r29 == null) goto L54;
        r29.setPageOwner(this.h);
    L54:
        CommentListView r30 = this.g;
        if (r30 == null) goto L57;
        r30.setCloseCommentButton(new AosCommentListContainer$init$1$1(this));
    L57:
        this.j.d = this.b;
        return;
    L44:
        r25 = 0.0f;
        goto L45
    L21:
        r18 = null;
        goto L22
    }

    public final void c() {
        CommentListView r0 = this.g;
        if (r0 == null) goto L5;
        int r1 = r0.getMaxConsumeMainCommentCount();
    L6:
        long r2 = SystemClock.elapsedRealtime();
        LinkedHashMap r5 = new LinkedHashMap();
        CommentPageParam r3 = this.i;
        String r4 = "";
        if (r3 == null) goto L10;
        String r6 = r3.g;
        if (r6 == null) goto L10;
    L11:
        r5.put("enter_from", r6);
        CommentPageParam r7 = this.i;
        if (r7 == null) goto L15;
        String r8 = r7.b;
        if (r8 == null) goto L15;
    L16:
        r5.put("author_openid", r8);
        CommentPageParam r9 = this.i;
        if (r9 == null) goto L22;
        String r10 = r9.a;
        if (r10 == null) goto L22;
        r4 = r10;
    L22:
        r5.put("group_id", r4);
        r5.put("impr_id", this.i.h);
        r5.put("consume_count", Integer.valueOf(r1));
        r5.put("duration", Long.valueOf(r2 - this.k));
        CommentPageParam r11 = this.i;
        if (r11 == null) goto L30;
        Map<String, Object> r12 = r11.v;
        if (r12 == null) goto L30;
        Iterator<Map.Entry<String, Object>> r13 = r12.entrySet().iterator();
    L28:
        if (r13.hasNext() == false) goto L30;
        Map.Entry<String, Object> r14 = r13.next();
        r5.put(r14.getKey(), r14.getValue());
    L30:
        AosEventReporter.s(AosEventReporter.a, "close_comment", r5, null, null, null, 28);
        return;
    L15:
        r8 = "";
    L10:
        r6 = "";
        goto L11
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.c0
    public Activity getActivity() {
        Activity r0 = this.d;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.c0
    public final int getBottomSheetHeight() {
        return ((int) (((d0.c(this.d) * 1.0f) / 4) * 3)) + this.i.m;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.c0
    public final void a() {
        c();
        ViewGroup r0 = this.e;
        boolean r1 = false;
        if (r0 == null) goto L10;
        View r2 = this.f;
        Intrinsics.checkNotNull(r2);
        if (r0.indexOfChild(r2) == (-1)) goto L7;
        boolean r3 = true;
    L8:
        if (r3 != true) goto L10;
        r1 = true;
        goto L10
    L7:
        r3 = false;
    L10:
        if (r1 == false) goto L15;
        ViewGroup r4 = this.e;
        if (r4 == null) goto L16;
        r4.removeView(this.f);
        return;
    L16:
        return;
    }

    public AosCommentListContainer(Activity r2, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r3, CommentPageParam r4, zz3.d.C0195d r5, zz3.d.c r6) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "mPageOwner");
        Intrinsics.checkNotNullParameter(r4, "pageParam");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r2;
        this.h = r3;
        this.i = r4;
        this.j = new AosBSViewInfoManager();
        this.k = -1;
    }
}
