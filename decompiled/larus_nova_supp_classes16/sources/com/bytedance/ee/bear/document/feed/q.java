package com.bytedance.ee.bear.document.feed;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.comment.u2;
import com.bytedance.ee.bear.document.h5;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q implements com.bytedance.ee.bear.middleground.feed.export.bean.i {
    public final u2 a;
    public final WebPluginHost b;
    public final FeedPanelViewModel c;
    public e d;
    public a e;
    public c f;
    public d g;
    public Function1<Boolean, Void> h;
    public BaseFeedPlugin.a i;
    public b j;
    public boolean k;
    public final boolean l;

    public interface a {
    }

    public static class b {
        public final MessageBean a;
        public final long b;

        public b(MessageBean r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    public final void h(int r1) {
    }

    public final void k() {
        this.j = null;
    }

    public final void a(String r3) {
        WebPluginHost r0 = this.b;
        if (r0 == null) goto L9;
        y3 r1 = (y3) r0.getHostAbilityOrNull(y3.class);
        if (r1 == null) goto L9;
        if (r1.getTitle().getValue() == null) goto L9;
        CharSequence r2 = (CharSequence) r1.getTitle().getValue();
    L10:
        ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.a(com.bytedance.ee.bear.docshost.k.class)).e(r3, r2);
        return;
    L9:
        r2 = null;
        goto L10
    }

    public final void c(MessageResultBean r3) {
        a r0 = this.e;
        if (r0 == null) goto L8;
        FeedPlugin.b r1 = (FeedPlugin.b) r0;
        if (FeedPlugin.access$000(r1.a) == null) goto L9;
        FeedPlugin.access$000(r1.a).a.l.l(r3);
        return;
    L9:
        return;
    }

    public final boolean d(String r2) {
        return h5.a(r2, this.b);
    }

    public final void e(MessageBean r6) {
        tt5.a.h("WebFeedListener", "toMessage()... messageId: " + r6.getMessageId() + ", optFg: " + this.l + ", hostReady: " + this.k);
        if (this.l == false) goto L12;
        long r2 = System.currentTimeMillis();
        if (this.k == false) goto L8;
        l(r6, r2, false);
        return;
    L8:
        if (this.b.getActivity() == null) goto L10;
        Toast.showText(this.b.getActivity(), this.b.getActivity().getString(2131889108));
    L10:
        this.j = new b(r6, r2);
        return;
    L12:
        l(r6, -1, false);
    }

    public final void f(String r4) {
        a r0 = this.e;
        if (r0 == null) goto L15;
        FeedPlugin.b r1 = (FeedPlugin.b) r0;
        r1.getClass();
        String r5 = FeedPlugin.access$900(r4);     // Catch: Exception -> L9 JSONException -> L11
        if (FeedPlugin.access$1000(r1.a) == null) goto L16;
        tt5.a.h("FeedPlugin", "web callback");     // Catch: Exception -> L9 JSONException -> L11
        FeedPlugin.access$1100(r1.a, JSON.parseObject(r5));     // Catch: Exception -> L9 JSONException -> L11
    L18:
        return;
    L16:
        return;
    L11:
        tt5.a.d("FeedPlugin", "parse json error");
        return;
    L9:
        e = move-exception;
        tt5.a.f("FeedPlugin", e, false);
        return;
    }

    public final void g(List<String> r2) {
        c r0 = this.f;
        if (r0 == null) goto L6;
        FeedPlugin.g(((h) r0).a, r2);
        return;
    }

    public final void i(int r4) {
        this.c.setPanelHeight(r4);
        u2 r0 = this.a;
        vv4.k r1 = this.b.getWeb();
        int r5 = com.bytedance.ee.util.ui.n.E(r4);
        r0.getClass();
        JSONObject r2 = new JSONObject();
        r2.put("height", Integer.valueOf(r5));
        r1.j("javascript:lark.biz.util.setPanelHeight", r2);
    }

    public final void j(boolean r2) {
        d r0 = this.g;
        if (r0 == null) goto L6;
        FeedPlugin.h(((i) r0).a, r2);
        return;
    }

    public q(WebPluginHost r2, FeedPanelViewModel r3) {
        this.k = false;
        this.a = new u2();
        this.c = r3;
        this.b = r2;
        boolean r4 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.feed.notification_optimization");
        this.l = r4;
        tt5.a.h("WebFeedListener", "WebFeedListener init, optFg: " + r4);
    }

    public final void b(boolean r4, boolean r5) {
        tt5.a.h("WebFeedListener", "statusChange()... show: " + r4 + ", dumpToComment: " + r5);
        this.c.setShow(r4);
        if (r4 == true) goto L5;
        u2 r0 = this.a;
        vv4.k r1 = this.b.getWeb();
        r0.getClass();
        JSONObject r2 = new JSONObject();
        r2.put("commentPanelOpen", Boolean.valueOf(r5));
        r1.j("javascript:lark.biz.feed.hideMessages", r2);
        this.j = null;
    L5:
        e r6 = this.d;
        if (r6 == null) goto L9;
        FeedPlugin.k(((g) r6).a, r4);
        return;
    }

    public final void l(MessageBean r12, long r13, boolean r16) {
        tt5.a.h("WebFeedListener", "toMessageImpl()... messageId = " + r12.getMessageId());
        FeedPanelViewModel r0 = this.c;
        if (r12.getIs_whole() != 1) goto L5;
        boolean r1 = true;
    L6:
        r0.setWhole(r1);
        if ("MESSAGE_DOC_MENTION".equals(r12.getType()) == false) goto L13;
        u2 r2 = this.a;
        vv4.k r3 = this.b.getWeb();
        String r9 = r12.getMentionId();
        String r14 = r12.getReply_id();
        r2.getClass();
        JSONObject r4 = new JSONObject();
        r4.put("isGlobalComment", Boolean.FALSE);
        r4.put("mentionId", r9);
        r4.put("replyId", r14);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.feed.notification_optimization") == false) goto L11;
        r4.put("clickTime", Long.valueOf(r13));
        r4.put("isReplay", Boolean.valueOf(r16));
    L11:
        tt5.a.h("Comment#PublishHandler", "scrollToMention:" + r4.toString());
        r3.j("javascript:lark.biz.feed.scrollToMessage", r4);
        return;
    L13:
        if (r12.getIs_whole() != 1) goto L22;
        u2 r5 = this.a;
        vv4.k r6 = this.b.getWeb();
        String r7 = r12.getComment_id();
        String r17 = r12.getReply_id();
        r5.getClass();
        JSONObject r8 = new JSONObject();
        Boolean r10 = Boolean.TRUE;
        r8.put("isGlobalComment", r10);
        r8.put("commentId", r7);
        r8.put("replyId", r17);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.feed.notification_optimization") == false) goto L17;
        r8.put("clickTime", Long.valueOf(r13));
        r8.put("isReplay", Boolean.valueOf(r16));
    L17:
        r6.j("javascript:lark.biz.feed.scrollToMessage", r8);
        if (this.l == false) goto L37;
        Function1<Boolean, Void> r18 = this.h;
        if (r18 == null) goto L38;
        r18.invoke(r10);
        return;
    L38:
        return;
    L37:
        return;
    L22:
        u2 r11 = this.a;
        vv4.k r19 = this.b.getWeb();
        String r20 = r12.getComment_id();
        String r110 = r12.getReply_id();
        r11.getClass();
        JSONObject r21 = new JSONObject();
        r21.put("commentId", r20);
        String r22 = "";
        if (TextUtils.isEmpty(r110) == false) goto L25;
        r110 = "";
    L25:
        r21.put("replyId", r110);
        if (TextUtils.isEmpty("feed") == true) goto L29;
        r22 = "feed";
    L29:
        r21.put(DocRedirectToDocxPlugin.FROM, r22);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.feed.notification_optimization") == false) goto L32;
        r21.put("clickTime", Long.valueOf(r13));
        r21.put("isReplay", Boolean.valueOf(r16));
    L32:
        tt5.a.h("Comment#PublishHandler", "scrollToCommentFromFeed:" + r21.toString());
        r19.j("javascript:lark.biz.comment.activate", r21);
        BaseFeedPlugin.a r111 = this.i;
        if (r111 == null) goto L40;
        r111.a();
        return;
    L40:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
