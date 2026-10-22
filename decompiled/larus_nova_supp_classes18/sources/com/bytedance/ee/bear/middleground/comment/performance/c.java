package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.bear.middleground.comment.uitls.h;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public final p a;

    public static final class a {
    }

    static {
    }

    public c(p r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
    }

    public final void a(double r6, float r8, String r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "commentId");
        tt5.a.h("Comment#ScrollFpsTracker", "trackFps()... fps: " + r6 + ", commentId = " + r9 + ", replyCount = " + r10);
        p r0 = this.a;
        h r1 = r0.d0;
        String r2 = r0.k.getType();
        String r3 = du5.b.g(this.a.i);
        r1.getClass();
        HashMap r4 = new HashMap();
        r4.put("fps", Double.valueOf(r6));
        r4.put("refresh_rate", Integer.valueOf((int) r8));
        r4.put("comment_style", r1.f);
        r4.put("comment_id", r9);
        r4.put("reply_count", Integer.valueOf(r10));
        r4.put("image_count", Integer.valueOf(r11));
        r4.put("file_type", r2);
        r4.put("file_id", r3);
        if (r1.e == false) goto L5;
        String r7 = "true";
    L6:
        r4.put("is_vc", r7);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentScrollFps params = " + r4);
        r1.g.a("mobile_comment_scroll_fps_dev", r4);
        return;
    L5:
        r7 = "false";
        goto L6
    }
}
