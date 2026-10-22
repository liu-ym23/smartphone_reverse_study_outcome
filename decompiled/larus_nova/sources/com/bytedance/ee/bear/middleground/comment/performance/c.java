package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.bear.middleground.comment.uitls.h;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.optimize.statistics.FrescoMonitorConst;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f232065a;

    public static final class a {
    }

    static {
    }

    public c(p r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f232065a = r100;
    }

    public final void a(double r100, float r101, String r102, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r102, "commentId");
        tt5.a.h("Comment#ScrollFpsTracker", "trackFps()... fps: " + r100 + ", commentId = " + r102 + ", replyCount = " + r110);
        p r103 = this.f232065a;
        h r104 = r103.f232225d0;
        String r105 = r103.f232235k.getType();
        String r106 = du5.b.g(this.f232065a.f232233i);
        r104.getClass();
        HashMap r107 = new HashMap();
        r107.put("fps", Double.valueOf(r100));
        r107.put("refresh_rate", Integer.valueOf((int) r101));
        r107.put("comment_style", r104.f232208f);
        r107.put("comment_id", r102);
        r107.put("reply_count", Integer.valueOf(r110));
        r107.put(FrescoMonitorConst.IMAGE_COUNT, Integer.valueOf(r111));
        r107.put("file_type", r105);
        r107.put("file_id", r106);
        if (r104.f232207e == false) goto L5;
        String r108 = "true";
    L6:
        r107.put("is_vc", r108);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentScrollFps params = " + r107);
        r104.f232209g.a("mobile_comment_scroll_fps_dev", r107);
        return;
    L5:
        r108 = "false";
        goto L6
    }
}
