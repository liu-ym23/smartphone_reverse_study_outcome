package com.bytedance.awemeopen.apps.framework.comment.view.diggbury;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BuryView2;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.DiggNewView2;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.utils.y;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements View.OnClickListener {
    public final Context a;
    public final CommentPageParam b;
    public final sy3.i c;
    public ViewGroup d;
    public DiggNewView2 e;
    public BuryView2 f;
    public o14.a g;
    public long h;
    public m i;
    public boolean j;

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (this.g != null) goto L6;
        return;
    L6:
        if (y.b(r7, 500) == false) goto L8;
        return;
    L8:
        int r2 = 1;
        boolean r5 = false;
        if (Intrinsics.areEqual(r7, this.e) == false) goto L29;
        DiggNewView2 r8 = this.e;
        if (r8 != null) goto L13;
    L15:
        if (r5 == false) goto L17;
        r2 = 2;
    L17:
        o14.a r0 = this.g;
        Intrinsics.checkNotNull(r0);
        final a r9 = new a(r0, r2);
        if (NetworkUtils.b(this.a) == true) goto L21;
        Context r10 = this.a;
        new zx3.a(r10, r10.getString(2131911865)).d();
    L27:
        b(this.g, r2);
        return;
    L21:
        if (this.j == true) goto L27;
        final DiggNewView2 r1 = this.e;
        if (r1 == null) goto L27;
        final Function0<Unit> r3 = new DiggBuryViewDelegate$onDiggViewClick$action$1(this, r1, r9);
        Context r11 = this.a;
        int r6 = com.bytedance.awemeopen.bizmodels.user.a.a;
        com.bytedance.awemeopen.apps.framework.comment.util.e.a(r11, "like_comment", new DiggBuryViewDelegate$onDiggViewClick$1(r3, r1), "DiggBuryViewDelegate");
        goto L27
    L13:
        if (r8.c != true) goto L15;
        r5 = true;
        goto L15
    L29:
        if (Intrinsics.areEqual(r7, this.f) == false) goto L52;
        BuryView2 r12 = this.f;
        if (r12 != null) goto L33;
    L35:
        r2 = 0;
    L36:
        if (r2 == 0) goto L38;
        int r13 = 4;
    L39:
        o14.a r4 = this.g;
        Intrinsics.checkNotNull(r4);
        final a r14 = new a(r4, r13);
        if (NetworkUtils.b(this.a) == true) goto L43;
        Context r15 = this.a;
        new zx3.a(r15, r15.getString(2131911865)).d();
    L49:
        b(this.g, r13);
        return;
    L43:
        if (this.j == true) goto L49;
        if (this.f == null) goto L49;
        final Function0<Unit> r16 = new DiggBuryViewDelegate$onBuryViewClick$action$1(this, r14);
        Context r17 = this.a;
        int r18 = com.bytedance.awemeopen.bizmodels.user.a.a;
        com.bytedance.awemeopen.apps.framework.comment.util.e.a(r17, "like_comment", new DiggBuryViewDelegate$onBuryViewClick$1(r16, this), "DiggBuryViewDelegate");
        goto L49
    L38:
        r13 = 3;
        goto L39
    L33:
        if (r12.c != true) goto L35;
    }

    public final void b(o14.a r9, int r10) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (r10 != 1) goto L7;
        String r11 = "like_comment";
    L17:
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("author_openid", this.b.b);
        r3.put("group_id", this.b.a);
        r3.put("impr_id", this.b.h);
        User r1 = r9.o();
        if (r1 == null) goto L21;
        String r2 = r1.u();
        if (r2 == null) goto L21;
    L22:
        r3.put("comment_user_id", r2);
        r3.put("comment_id", r9.cid);
        r3.put("content", r9.l());
        if (this.c.c == false) goto L25;
        String r4 = CommentScene.COMMENTSCENE_NO_AWEME;
    L26:
        r3.put("is_card_sdk", r4);
        r3.put("enter_from_cmt", this.b.g);
        if (r9.a != 1) goto L29;
        String r12 = "reply";
    L30:
        r3.put("comment_category", r12);
        r3.put("current_action", r11);
        AosEventReporter.s(AosEventReporter.a, "comment_action", r3, null, null, null, 28);
        return;
    L29:
        r12 = "reply_to_reply";
        goto L30
    L25:
        r4 = "0";
    L21:
        r2 = "";
        goto L22
    L7:
        if (r10 != 2) goto L9;
        r11 = "cancel_like_comment";
        goto L17
    L9:
        if (r10 != 3) goto L11;
        r11 = "dislike_comment";
        goto L17
    L11:
        if (r10 == 4) goto L13;
        return;
    L13:
        r11 = "cancel_dislike_comment";
        goto L17
    }

    public d(Context r2, CommentPageParam r3, sy3.i r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pageParam");
        Intrinsics.checkNotNullParameter(r4, "commentViewConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.h = -1;
    }
}
