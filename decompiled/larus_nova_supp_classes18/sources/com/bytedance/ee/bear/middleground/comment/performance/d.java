package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.bear.middleground.comment.uitls.h;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final p a;
    public final ConcurrentHashMap<String, e> b;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        return !CollectionUtils.isEmpty(this.b);
    }

    public final void c() {
        Iterator<String> r0 = this.b.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        String r1 = r0.next();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L14;
        e r3 = this.b.get(r1);
        if (r3 == null) goto L17;
        tt5.a.h("Comment#SendCommentTracker", r1 + " send cancel");
        h r4 = this.a.d0;
        String r5 = r3.b;
        String r6 = r3.getType();
        long r7 = System.currentTimeMillis() - r3.c;
        r4.getClass();
        HashMap r8 = new HashMap();
        r8.put("file_type", r4.b);
        r8.put("file_id", du5.b.g(r4.a));
        r8.put("domain", r5);
        r8.put(ResourceData.KEY_TYPE, r6);
        r8.put("cost", Long.valueOf(r7));
        r8.put("comment_style", r4.f);
        r8.put("res", DocFeed$Value$Result.CANCEL);
        tt5.a.b("Comment#CommentAnalytic", "reportPartCommentSendCancel params = " + r8);
        r4.g.a("mobile_comment_send_dev", r8);
        this.b.remove(r1);
        goto L4
    L17:
        tt5.a.d("Comment#SendCommentTracker", r1 + " not exist");
        goto L4
    L14:
        tt5.a.d("Comment#SendCommentTracker", "getPartCommentSendParam uuid is null");
        goto L4
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L13
    }

    public d(p r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
        this.b = new ConcurrentHashMap();
    }

    public final boolean a(String r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        return this.b.containsKey(r2);
    }

    public final void e(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        if (r3 != null) goto L7;
        tt5.a.d("Comment#SendCommentTracker", "partCommentStartSend uuid is null");
        return;
    L7:
        if (this.b.containsKey(r3) == false) goto L10;
        tt5.a.d("Comment#SendCommentTracker", r3.concat(" has exist"));
        return;
    L10:
        tt5.a.h("Comment#SendCommentTracker", r3.concat(" start send"));
        e r0 = new e(r4);
        this.b.put(r3, r0);
    }

    public final void d(String r9, String r10, String r11) {
        if (r9 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        tt5.a.d("Comment#SendCommentTracker", "getPartCommentSendParam uuid is null");
        return;
    L12:
        if (r10 != null) goto L14;
        return;
    L14:
        e r1 = this.b.get(r9);
        if (r1 != null) goto L18;
        tt5.a.d("Comment#SendCommentTracker", r9 + " not exist");
        return;
    L18:
        tt5.a.h("Comment#SendCommentTracker", r9 + " send result " + r10);
        h r2 = this.a.d0;
        String r3 = r1.b;
        String r4 = r1.getType();
        long r5 = System.currentTimeMillis() - r1.c;
        r2.getClass();
        HashMap r6 = new HashMap();
        r6.put("file_type", r2.b);
        r6.put("file_id", du5.b.g(r2.a));
        r6.put("domain", r3);
        r6.put(ResourceData.KEY_TYPE, r4);
        r6.put("cost", Long.valueOf(r5));
        r6.put("comment_style", r2.f);
        r6.put("res", r10);
        r6.put("fail_reason", r11);
        tt5.a.b("Comment#CommentAnalytic", "reportPartCommentSendSuccess params = " + r6);
        r2.g.a("mobile_comment_send_dev", r6);
        this.b.remove(r9);
        return;
    L4:
        if (r9.length() == 0) goto L7;
        r0 = false;
        goto L9
    }
}
