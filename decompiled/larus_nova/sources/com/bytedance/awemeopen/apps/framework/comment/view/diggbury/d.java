package com.bytedance.awemeopen.apps.framework.comment.view.diggbury;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BuryView2;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.DiggNewView2;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.utils.y;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f194235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommentPageParam f194236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final sy3.i f194237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f194238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DiggNewView2 f194239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BuryView2 f194240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o14.a f194241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f194242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m f194243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f194244j;

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f194241g != null) goto L6;
        return;
    L6:
        if (y.b(r100, 500) == false) goto L8;
        return;
    L8:
        int r101 = 1;
        boolean r102 = false;
        if (Intrinsics.areEqual(r100, this.f194239e) == false) goto L29;
        DiggNewView2 r103 = this.f194239e;
        if (r103 != null) goto L13;
    L15:
        if (r102 == false) goto L17;
        r101 = 2;
    L17:
        o14.a r104 = this.f194241g;
        Intrinsics.checkNotNull(r104);
        final a r105 = new a(r104, r101);
        if (NetworkUtils.b(this.f194235a) == true) goto L21;
        Context r106 = this.f194235a;
        new zx3.a(r106, r106.getString(R.string.network_unavailable)).d();
    L27:
        b(this.f194241g, r101);
        return;
    L21:
        if (this.f194244j == true) goto L27;
        final DiggNewView2 r107 = this.f194239e;
        if (r107 == null) goto L27;
        final Function0<Unit> r108 = new DiggBuryViewDelegate$onDiggViewClick$action$1(this, r107, r105);
        Context r109 = this.f194235a;
        int r110 = com.bytedance.awemeopen.bizmodels.user.a.f198216a;
        com.bytedance.awemeopen.apps.framework.comment.util.e.a(r109, "like_comment", new DiggBuryViewDelegate$onDiggViewClick$1(r108, r107), "DiggBuryViewDelegate");
        goto L27
    L13:
        if (r103.f194263c != true) goto L15;
        r102 = true;
        goto L15
    L29:
        if (Intrinsics.areEqual(r100, this.f194240f) == false) goto L52;
        BuryView2 r111 = this.f194240f;
        if (r111 != null) goto L33;
    L35:
        r101 = 0;
    L36:
        if (r101 == 0) goto L38;
        int r112 = 4;
    L39:
        o14.a r113 = this.f194241g;
        Intrinsics.checkNotNull(r113);
        final a r114 = new a(r113, r112);
        if (NetworkUtils.b(this.f194235a) == true) goto L43;
        Context r115 = this.f194235a;
        new zx3.a(r115, r115.getString(R.string.network_unavailable)).d();
    L49:
        b(this.f194241g, r112);
        return;
    L43:
        if (this.f194244j == true) goto L49;
        if (this.f194240f == null) goto L49;
        final Function0<Unit> r116 = new DiggBuryViewDelegate$onBuryViewClick$action$1(this, r114);
        Context r117 = this.f194235a;
        int r118 = com.bytedance.awemeopen.bizmodels.user.a.f198216a;
        com.bytedance.awemeopen.apps.framework.comment.util.e.a(r117, "like_comment", new DiggBuryViewDelegate$onBuryViewClick$1(r116, this), "DiggBuryViewDelegate");
        goto L49
    L38:
        r112 = 3;
        goto L39
    L33:
        if (r111.f194263c != true) goto L35;
    }

    public final void b(o14.a r100, int r110) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r110 != 1) goto L7;
        String r111 = "like_comment";
    L17:
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("author_openid", this.f194236b.f194076b);
        r101.put("group_id", this.f194236b.f194075a);
        r101.put("impr_id", this.f194236b.f194082h);
        User r102 = r100.o();
        if (r102 == null) goto L21;
        String r103 = r102.u();
        if (r103 == null) goto L21;
    L22:
        r101.put("comment_user_id", r103);
        r101.put("comment_id", r100.cid);
        r101.put("content", r100.l());
        if (this.f194237c.f543878c == false) goto L25;
        String r104 = "1";
    L26:
        r101.put("is_card_sdk", r104);
        r101.put("enter_from_cmt", this.f194236b.f194081g);
        if (r100.f521700a != 1) goto L29;
        String r105 = "reply";
    L30:
        r101.put("comment_category", r105);
        r101.put("current_action", r111);
        AosEventReporter.s(AosEventReporter.f194596a, "comment_action", r101, null, null, null, 28);
        return;
    L29:
        r105 = "reply_to_reply";
        goto L30
    L25:
        r104 = "0";
    L21:
        r103 = "";
        goto L22
    L7:
        if (r110 != 2) goto L9;
        r111 = "cancel_like_comment";
        goto L17
    L9:
        if (r110 != 3) goto L11;
        r111 = "dislike_comment";
        goto L17
    L11:
        if (r110 == 4) goto L13;
        return;
    L13:
        r111 = "cancel_dislike_comment";
        goto L17
    }

    public d(Context r100, CommentPageParam r101, sy3.i r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageParam");
        Intrinsics.checkNotNullParameter(r102, "commentViewConfig");
        this.f194235a = r100;
        this.f194236b = r101;
        this.f194237c = r102;
        this.f194242h = -1;
    }
}
