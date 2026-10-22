package com.bytedance.awemeopen.apps.framework.comment.view.commentimage;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.c0;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AosCommentImageContainer implements c0 {
    public final CommentPageParam a;
    public ViewGroup b;
    public CommentImageView c;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b d;
    public final CommentPageParam e;
    public View f;
    public int g;

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.c0
    public final void a() {
    }

    public final void c() {
        this.b = (ViewGroup) this.d.getActivity().findViewById(R.id.content);
        View r0 = View.inflate(this.d.getActivity(), 2131558595, null);
        this.f = r0;
        if (r0 == null) goto L5;
        CommentImageView r1 = (CommentImageView) r0.findViewById(2131367363);
    L6:
        this.c = r1;
        if (r1 == null) goto L14;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r2 = this.d;
        CommentPageParam r3 = this.a;
        Intrinsics.checkNotNullParameter(r2, "mPageOwner");
        Intrinsics.checkNotNullParameter(r3, "pageParam");
        r1.f = r2;
        r1.g = r3;
        if (r1.e != null) goto L14;
        Activity r4 = r2.getActivity();
        py3.a r5 = new py3.a();
        r5.b = r1;
        r5.a = null;
        Unit r6 = Unit.INSTANCE;
        SlidesImagePageAdapter r7 = new SlidesImagePageAdapter(r4, r5);
        r1.e = r7;
        VerticalViewPager r8 = r1.d;
        if (r8 == null) goto L14;
        r8.setAdapter(r7);
    L14:
        CommentImageView r9 = this.c;
        if (r9 == null) goto L17;
        r9.setCloseCommentButton(new AosCommentImageContainer$init$1$1(this));
    L17:
        this.g = z04.c.a(this.d.getActivity());
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean d() {
        ViewGroup r0 = this.b;
        if (r0 == null) goto L11;
        View r2 = this.f;
        Intrinsics.checkNotNull(r2);
        if (r0.indexOfChild(r2) == (-1)) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    L11:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.c0
    public Activity getActivity() {
        Activity r0 = this.d.getActivity();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.c0
    public final int getBottomSheetHeight() {
        int r0 = d0.c(this.d.getActivity());
        if ((this.d.getActivity() instanceof Activity) == false) goto L8;
        int r1 = w04.a.a;
        if (w04.a.b(this.d.getActivity()) == true) goto L7;
        return r0;
    L7:
        return r0 + this.e.m;
    L8:
        return r0;
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "exitMethod");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        e(r4);     // Catch: Throwable -> L17
        ViewGroup r5 = this.b;     // Catch: Throwable -> L17
        boolean r1 = false;
        if (r5 == null) goto L11;
        View r2 = this.f;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L17
        if (r5.indexOfChild(r2) == (-1)) goto L8;
        boolean r6 = true;
    L9:
        if (r6 != true) goto L11;
        r1 = true;
        goto L11
    L8:
        r6 = false;
    L11:
        if (r1 == false) goto L15;
        ViewGroup r7 = this.b;     // Catch: Throwable -> L17
        if (r7 == null) goto L15;
        r7.removeView(this.f);     // Catch: Throwable -> L17
    L15:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void e(String r8) {
        LinkedHashMap r2 = new LinkedHashMap();
        String r0 = this.e.b;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r2.put("author_openid", r0);
        String r3 = this.e.g;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r2.put("enter_from", r3);
        r2.put("enter_method", "click_pic");
        String r4 = this.e.a;
        if (r4 == null) goto L12;
        r1 = r4;
    L12:
        r2.put("group_id", r1);
        r2.put("exit_method", r8);
        AosEventReporter.s(AosEventReporter.a, "exit_cmt_pic_inflow", r2, null, null, null, 28);
    }

    public AosCommentImageContainer(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r2, CommentPageParam r3) {
        Intrinsics.checkNotNullParameter(r2, "mPageOwner");
        Intrinsics.checkNotNullParameter(r3, "pageParam");
        this.a = r3;
        this.d = r2;
        this.e = r3;
    }
}
