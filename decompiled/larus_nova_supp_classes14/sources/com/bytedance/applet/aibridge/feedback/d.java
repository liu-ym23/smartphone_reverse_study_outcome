package com.bytedance.applet.aibridge.feedback;

import android.os.Bundle;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import f3.h;
import hq9.n3;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import q99.e;
import q99.l;
import q99.m;
import q99.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements o99.a {
    public final /* synthetic */ h<AbsSetupFeedbackDataMethodIDL.b> a;

    public final void d() {
    }

    public final void e(q99.d r1) {
    }

    public final void h() {
    }

    public final void i() {
    }

    public d(h<AbsSetupFeedbackDataMethodIDL.b> r1) {
        this.a = r1;
    }

    public final Bundle b(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return r2;
    }

    public final n3 f(n3 r2) {
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        return r2;
    }

    public final void a(m r4, l r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "error");
        FLogger.a.v("js_fb_setup", "send [" + r5.a + "]:" + r5.b);
        h.a.a(this.a, "1_[" + r5.a + "]:" + r5.b, null, null, 14);
    }

    public final void c(e r1, q99.a r2) {
        o99.a.a.a(r1, r2);
    }

    public final void g(m r4, n r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "result");
        Message r6 = r5.a;
        FLogger r7 = FLogger.a;
        StringBuilder r0 = new StringBuilder("send ok;[feedback]");
        Map r1 = null;
        if (r6 == null) goto L5;
        Integer r2 = r6.getFeedback();
    L6:
        r0.append(r2);
        r0.append("[ext]");
        if (r6 == null) goto L9;
        r1 = r6.getExt();
    L9:
        r0.append(r1);
        r7.v("js_fb_setup", r0.toString());
        h<AbsSetupFeedbackDataMethodIDL.b> r8 = this.a;
        Intrinsics.checkNotNullParameter(AbsSetupFeedbackDataMethodIDL.b.class, "<this>");
        h.a.b(r8, k3.c.a(AbsSetupFeedbackDataMethodIDL.b.class));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void j(e r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "delivery");
        Intrinsics.checkNotNullParameter(r1, "delivery");
    }
}
