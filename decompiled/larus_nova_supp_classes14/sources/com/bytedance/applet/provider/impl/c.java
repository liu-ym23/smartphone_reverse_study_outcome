package com.bytedance.applet.provider.impl;

import androidx.collection.LruCache;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.utils.j;
import com.bytedance.ai.utils.k;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import jw3.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements e {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // jw3.e
    public final int e() {
        com.bytedance.ai.settings.a r0 = com.bytedance.ai.settings.b.a;
        return ((Number) com.bytedance.ai.settings.b.b.a()).intValue();
    }

    @Override // jw3.e
    public final void a(Long r25) {
        LruCache r1 = j.a;
        if (r25 == null) goto L29;
        r25.longValue();
        j.a r0 = (j.a) j.a.remove(r25);
        if (r0 == null) goto L30;
        String r2 = r0.e;
        if (r2 == null) goto L9;
        j.a r3 = (j.a) j.b.remove(r2);
    L9:
        com.bytedance.ai.monitor.b.d("applet_local_plugin_summary", new k(r0));
        h2.a r4 = f2.b.c;
        if (r4 == null) goto L14;
        boolean r5 = true;
        if (r4.l != true) goto L14;
    L15:
        if (r5 == false) goto L31;
        long r6 = j.a(r0.k.d, r0.j.d);
        long r7 = j.a(r0.l.d, r0.k.d);
        long r8 = j.a(r0.m.d, r0.l.d);
        long r9 = j.a(r0.n.d, r0.m.d);
        long r10 = j.a(r0.q.d, r0.n.d);
        long r11 = j.a(r0.s.d, r0.q.d);
        long r13 = j.a(r0.u.d, r0.t.d);
        long r14 = j.a(r0.u.d, Long.valueOf(r0.f));
        StringBuilder r15 = new StringBuilder("\n================================================================================================\nBasic info:\nmsgId: ");
        r15.append(r0.a);
        r15.append(", questionId: ");
        r15.append(r0.b);
        r15.append(", apiName: ");
        r15.append(r0.c);
        r15.append(":\nreceived time: ");
        r15.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(r0.f)));
        r15.append("\n-------------------------\ntimestamp:\n");
        StringBuilder r12 = new StringBuilder();
        Iterator r16 = r0.w.iterator();
    L18:
        if (r16.hasNext() == false) goto L24;
        j.c r17 = (j.c) r16.next();
        String r18 = r17.c;
        Long r19 = r17.d;
        long r110 = r0.f;
        j.a r26 = r0;
        StringBuilder r20 = new StringBuilder();
        r20.append(r18);
        r20.append(" time: ");
        if (r19 == null) goto L22;
        Object r21 = Long.valueOf(r19.longValue() - r110);
    L23:
        r20.append(r21);
        r20.append(" ms");
        r12.append(r20.toString());
        r12.append("\r\n");
        r0 = r26;
        goto L18
    L22:
        r21 = CommentPublishScene.UNKNOWN;
        goto L23
    L24:
        r15.append(r12.toString());
        r15.append("\n-------------------------\ncosts:\ntotal cost: ");
        r15.append(r14);
        r15.append(" ms\n\n");
        r15.append(j.c("app action listener", r6, r14));
        r15.append('\n');
        r15.append(j.c("applet runtime manager", r7, r14));
        r15.append('\n');
        r15.append(j.c("run applet", r8, r14));
        r15.append('\n');
        r15.append(j.c("applet runtime", r9, r14));
        r15.append('\n');
        r15.append(j.c("front end", r10, r14));
        r15.append('\n');
        r15.append(j.c("reply to report", r11, r14));
        r15.append('\n');
        r15.append(j.c("send ack", r13, r14));
        r15.append("\n================================================================================================\n        ");
        String r22 = StringsKt.trimIndent(r15.toString());
        g.a.d("LocalPluginPerformanceManager", "LocalPlugin status\n" + r22);
        return;
    L31:
        return;
    L14:
        r5 = false;
        goto L15
    L30:
        return;
    }

    @Override // jw3.e
    public final void d(Object r2) {
        if ((r2 instanceof j.a) == false) goto L5;
        j.a r3 = (j.a) r2;
    L6:
        if (r3 == null) goto L11;
        j.c r4 = r3.v;
        if (r4 == null) goto L12;
        r4.a();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // jw3.e
    public final void f(Object r2) {
        if ((r2 instanceof j.a) == false) goto L5;
        j.a r3 = (j.a) r2;
    L6:
        if (r3 == null) goto L11;
        j.c r4 = r3.u;
        if (r4 == null) goto L12;
        r4.a();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // jw3.e
    public final j.a h(Long r2) {
        j.a r3 = j.b(r2);
        if (r3 == null) goto L7;
        j.c r0 = r3.t;
        if (r0 == null) goto L7;
        r0.a();
    L7:
        return r3;
    }

    @Override // jw3.e
    public final void b(Object r2, int r3) {
        if ((r2 instanceof j.a) == false) goto L5;
        j.a r4 = (j.a) r2;
    L6:
        if (r4 == null) goto L9;
        r4.h = r3;
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // jw3.e
    public final void g(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if ((r2 instanceof j.a) == false) goto L5;
        j.a r4 = (j.a) r2;
    L6:
        if (r4 == null) goto L9;
        Intrinsics.checkNotNullParameter(r3, "msg");
        r4.i = new j.b.b(r3);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // jw3.e
    public final void c(Long r8, Long r9, String r10, String r11) {
        LruCache r0 = j.a;
        if (r8 == null) goto L6;
        r8.longValue();
        j.a r1 = new j.a(r8, r9, r10, r11, 48);
        j.a.put(r8, r1);
        return;
    }
}
