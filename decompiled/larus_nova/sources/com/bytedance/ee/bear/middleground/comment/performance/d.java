package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.bear.middleground.comment.uitls.h;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f232066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, e> f232067b;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        return !CollectionUtils.isEmpty(this.f232067b);
    }

    public final void c() {
        Iterator<String> r100 = this.f232067b.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L19;
        String r101 = r100.next();
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L14;
        e r103 = this.f232067b.get(r101);
        if (r103 == null) goto L17;
        tt5.a.h("Comment#SendCommentTracker", r101 + " send cancel");
        h r104 = this.f232066a.f232225d0;
        String r105 = r103.f232069b;
        String r106 = r103.getType();
        long r107 = System.currentTimeMillis() - r103.f232070c;
        r104.getClass();
        HashMap r108 = new HashMap();
        r108.put("file_type", r104.f232204b);
        r108.put("file_id", du5.b.g(r104.f232203a));
        r108.put("domain", r105);
        r108.put("type", r106);
        r108.put(ChameleonOpenTracker.ParamKey.COST, Long.valueOf(r107));
        r108.put("comment_style", r104.f232208f);
        r108.put("res", "cancel");
        tt5.a.b("Comment#CommentAnalytic", "reportPartCommentSendCancel params = " + r108);
        r104.f232209g.a("mobile_comment_send_dev", r108);
        this.f232067b.remove(r101);
        goto L4
    L17:
        tt5.a.d("Comment#SendCommentTracker", r101 + " not exist");
        goto L4
    L14:
        tt5.a.d("Comment#SendCommentTracker", "getPartCommentSendParam uuid is null");
        goto L4
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L13
    }

    public d(p r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f232066a = r100;
        this.f232067b = new ConcurrentHashMap();
    }

    public final boolean a(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        return this.f232067b.containsKey(r100);
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r100 != null) goto L7;
        tt5.a.d("Comment#SendCommentTracker", "partCommentStartSend uuid is null");
        return;
    L7:
        if (this.f232067b.containsKey(r100) == false) goto L10;
        tt5.a.d("Comment#SendCommentTracker", r100.concat(" has exist"));
        return;
    L10:
        tt5.a.h("Comment#SendCommentTracker", r100.concat(" start send"));
        e r102 = new e(r101);
        this.f232067b.put(r100, r102);
    }

    public final void d(String r100, String r110, String r111) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        tt5.a.d("Comment#SendCommentTracker", "getPartCommentSendParam uuid is null");
        return;
    L12:
        if (r110 != null) goto L14;
        return;
    L14:
        e r102 = this.f232067b.get(r100);
        if (r102 != null) goto L18;
        tt5.a.d("Comment#SendCommentTracker", r100 + " not exist");
        return;
    L18:
        tt5.a.h("Comment#SendCommentTracker", r100 + " send result " + r110);
        h r103 = this.f232066a.f232225d0;
        String r104 = r102.f232069b;
        String r105 = r102.getType();
        long r106 = System.currentTimeMillis() - r102.f232070c;
        r103.getClass();
        HashMap r107 = new HashMap();
        r107.put("file_type", r103.f232204b);
        r107.put("file_id", du5.b.g(r103.f232203a));
        r107.put("domain", r104);
        r107.put("type", r105);
        r107.put(ChameleonOpenTracker.ParamKey.COST, Long.valueOf(r106));
        r107.put("comment_style", r103.f232208f);
        r107.put("res", r110);
        r107.put("fail_reason", r111);
        tt5.a.b("Comment#CommentAnalytic", "reportPartCommentSendSuccess params = " + r107);
        r103.f232209g.a("mobile_comment_send_dev", r107);
        this.f232067b.remove(r100);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }
}
