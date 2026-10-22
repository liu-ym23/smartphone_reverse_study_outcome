package l15;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.comment.u2;
import com.bytedance.ee.bear.document.feed.BaseFeedPlugin;
import com.bytedance.ee.bear.document.feed.FeedPanelViewModel;
import com.bytedance.ee.bear.document.feed.v2.FeedPluginV2;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class l implements com.bytedance.ee.bear.middleground.feed.export.bean.j {
    public final u2 a;
    public final WebPluginHost b;
    public final FeedPanelViewModel c;
    public Function0<Void> d;
    public a e;
    public boolean f;
    public final boolean g;

    public static class a {
        public final Notice<?> a;
        public final long b;

        public a(Notice<?> r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
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

    public final void c(Notice<?> r6) {
        tt5.a.h("WebFeedListenerV2", "toMessage()... messageId: " + r6.getNoticeId() + ", optFg: " + this.g + ", hostReady: " + this.f);
        if (this.g == false) goto L9;
        long r2 = System.currentTimeMillis();
        if (this.f == false) goto L7;
        d(r6, r2, false);
        return;
    L7:
        Toast.showText(this.b.getActivity(), this.b.getActivity().getString(2131889108));
        this.e = new a(r6, r2);
        ((com.bytedance.ee.bear.middleground.feed.export.bean.h) org.koin.java.a.a(com.bytedance.ee.bear.middleground.feed.export.bean.h.class)).j(r6);
        return;
    L9:
        d(r6, -1, false);
    }

    public l(WebPluginHost r2, FeedPanelViewModel r3) {
        this.f = false;
        this.a = new u2();
        this.c = r3;
        this.b = r2;
        boolean r4 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.feed.notification_optimization");
        this.g = r4;
        tt5.a.h("WebFeedListenerV2", "WebFeedListener init, optFg: " + r4);
    }

    public final void b(boolean r4, boolean r5) {
        tt5.a.h("WebFeedListenerV2", "statusChange()... show: " + r4 + ", dumpToComment: " + r5);
        this.c.setShow(r4);
        if (r4 == true) goto L5;
        u2 r0 = this.a;
        vv4.k r1 = this.b.getWeb();
        r0.getClass();
        JSONObject r2 = new JSONObject();
        r2.put("commentPanelOpen", Boolean.valueOf(r5));
        r1.j("javascript:lark.biz.feed.hideMessages", r2);
        this.e = null;
    L5:
        FeedPluginV2.access$2000(((FeedPluginV2.c) this).h, r4);
    }

    public final void d(Notice<?> r8, long r9, boolean r11) {
        tt5.a.h("WebFeedListenerV2", "toMessageImpl()... messageId = " + r8.getNoticeId());
        ((com.bytedance.ee.bear.middleground.feed.export.bean.h) org.koin.java.a.a(com.bytedance.ee.bear.middleground.feed.export.bean.h.class)).g(r8, Boolean.valueOf(r11));
        this.c.setWhole(r8.isGlobalComment());
        u2 r0 = this.a;
        vv4.k r1 = this.b.getWeb();
        boolean r2 = r8.isGlobalComment();
        String r3 = r8.getCommentId();
        String r4 = r8.getReplyId();
        String r5 = r8.getMentionId();
        r0.getClass();
        JSONObject r6 = new JSONObject();
        r6.put("isGlobalComment", Boolean.valueOf(r2));
        String r7 = "";
        if (TextUtils.isEmpty(r3) == false) goto L5;
        r3 = "";
    L5:
        r6.put("commentId", r3);
        if (TextUtils.isEmpty(r4) == false) goto L8;
        r4 = "";
    L8:
        r6.put("replyId", r4);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        r5 = "";
    L11:
        r6.put("mentionId", r5);
        if (TextUtils.isEmpty("feed") == true) goto L15;
        r7 = "feed";
    L15:
        r6.put(DocRedirectToDocxPlugin.FROM, r7);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.feed.notification_optimization") == false) goto L18;
        r6.put("clickTime", Long.valueOf(r9));
        r6.put("isReplay", Boolean.valueOf(r11));
    L18:
        tt5.a.h("Comment#PublishHandler", "scrollToMention:" + r6.toString());
        r1.j("javascript:lark.biz.feed.scrollToMessage", r6);
        if (r8.isGlobalComment() == false) goto L26;
        if (this.g == false) goto L33;
        Function0<Void> r10 = this.d;
        if (r10 == null) goto L35;
        r10.invoke();
        return;
    L35:
        return;
    L33:
        return;
    L26:
        if (TextUtils.isEmpty(r8.getCommentId()) == false) goto L28;
        return;
    L28:
        if (TextUtils.isEmpty(r8.getReplyId()) == true) goto L38;
        Iterator r12 = FeedPluginV2.access$1900(((FeedPluginV2.c) this).h).iterator();
    L31:
        if (r12.hasNext() == false) goto L39;
        ((BaseFeedPlugin.a) r12.next()).a();
        goto L31
    L39:
        return;
    }
}
