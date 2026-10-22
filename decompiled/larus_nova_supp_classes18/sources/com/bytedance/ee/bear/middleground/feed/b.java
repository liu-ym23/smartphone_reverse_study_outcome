package com.bytedance.ee.bear.middleground.feed;

import android.os.SystemClock;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.feed.FeedPlugin;
import com.bytedance.ee.bear.document.feed.f;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$ActionValue;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Stage;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.e;
import com.bytedance.ee.bear.middleground.feed.export.bean.g;
import com.bytedance.ee.bear.middleground.feed.export.bean.h;
import com.bytedance.ee.bear.middleground.feed.export.bean.i;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import l15.l;
import uf5.l0;
import uf5.m0;
import uf5.q0;
import uf5.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements h {

    public class a extends q0 implements e {
        public final h.a b;

        @Override // uf5.q0, com.bytedance.ee.bear.middleground.feed.export.bean.g
        public final void a(String r2, String r3) {
            f r0 = this.b;
            if (r0 == null) goto L5;
            FeedPlugin.d(r0.a, r2, r3);
            return;
        L5:
            super.a(r2, r3);
        }

        public a(String r1, sbb.e r2, f r3) {
            super(r1, r2);
            this.b = r3;
        }
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.h
    public final void f() {
        r r0 = bg5.a.b;
        ((d) org.koin.java.a.c(d.class, null, null, 6)).j("tag_doc_feedopen_feed_from_larkfeed", "key_open_start_view_oncreated", String.valueOf(SystemClock.uptimeMillis()));     // Catch: Throwable -> L5
    L7:
        bg5.a.m(DocFeed$Value$Stage.VC_ONCREATE_FRAGMENT);
        return;
    L5:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.h
    public final void h() {
        r r0 = bg5.a.b;
        ((d) org.koin.java.a.c(d.class, null, null, 6)).j("tag_doc_feedopen_feed_from_larkfeed", "key_open_start_vc_oncreate", String.valueOf(SystemClock.uptimeMillis()));     // Catch: Throwable -> L5
    L7:
        bg5.a.m(DocFeed$Value$Stage.VC_ONCREATE_ACTIVITY);
        bg5.a.a(DocFeed$Value$Stage.VC_ONCREATE_FRAGMENT);
        return;
    L5:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.h
    public final void d(Map<String, Object> r1) {
        bg5.a.d(r1);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.h
    public final boolean e(String r2) {
        l0.b().getClass();
        return "docs_feed".equals(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.h
    public final void j(Notice r2) {
        bg5.a.n(DocFeed$Value$ActionValue.FEED_REPLAY, r2);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.h
    public final com.bytedance.ee.bear.middleground.feed.a k(com.bytedance.ee.bear.middleground.feed.export.bean.b r7) {
        FragmentActivity r1 = r7.a;
        g r3 = r7.c;
        i r4 = r7.d;
        MessageConfig r5 = r7.e;
        return new com.bytedance.ee.bear.middleground.feed.a(r1, r7.b, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.h
    public final q0 a(String r2, sbb.e r3) {
        return new q0(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.h
    public final void g(Notice r5, Boolean r6) {
        r r0 = bg5.a.b;
        boolean r7 = r6.booleanValue();
        Intrinsics.checkNotNullParameter(DocFeed$Value$ActionValue.FEED_SCROLL_TO_MESSAGE_SUCCESS, "actionStr");
        Intrinsics.checkNotNullParameter(r5, "notice");
        tt5.a.h("Feed_FeedReportV2", "reportToMessageSuccess");
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L5
        r1.put("action", DocFeed$Value$ActionValue.FEED_SCROLL_TO_MESSAGE_SUCCESS);     // Catch: Throwable -> L5
        r1.put("mentionId", r5.getMentionId());     // Catch: Throwable -> L5
        r1.put("commentId", r5.getCommentId());     // Catch: Throwable -> L5
        r1.put("isGlobalComment", Boolean.valueOf(r5.isGlobalComment()));     // Catch: Throwable -> L5
        r1.put("noticeType", r5.getNoticeType());     // Catch: Throwable -> L5
        r1.put("commentType", Integer.valueOf(r5.getCommentType()));     // Catch: Throwable -> L5
        r1.put("isReplay", Boolean.valueOf(r7));     // Catch: Throwable -> L5
        r1.put("isUserClick", Boolean.FALSE);     // Catch: Throwable -> L5
        ((d) org.koin.java.a.c(d.class, null, null, 6)).n("docx_comment_monitor_dev", r1);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.h
    public final boolean i(String r1, Map<String, String> r2) {
        return m0.e(r1, r2);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.h
    public final a c(String r2, sbb.e r3, f r4) {
        return new a(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.h
    public final gg5.a b(FragmentActivity r9, Fragment r10, ViewGroup r11, l r12, MessageConfig r13, vf5.b r14) {
        return new gg5.a(r9, r10, r11, r12, r13, r14);
    }
}
