package com.bytedance.ee.bear.document.feed;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.document.comment.u2;
import com.bytedance.ee.bear.document.h5;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;

/* JADX INFO: loaded from: classes16.dex */
public final class q implements com.bytedance.ee.bear.middleground.feed.export.bean.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2 f219888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebPluginHost f219889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FeedPanelViewModel f219890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f219891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f219892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f219893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f219894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<Boolean, Void> f219895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BaseFeedPlugin.a f219896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f219897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f219898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f219899l;

    public interface a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageBean f219900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f219901b;

        public b(MessageBean r100, long r101) {
            this.f219900a = r100;
            this.f219901b = r101;
        }
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.i
    public final void h(int r100) {
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.i
    public final void k() {
        this.f219897j = null;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.i
    public final void a(String r100) {
        WebPluginHost r101 = this.f219889b;
        if (r101 == null) goto L9;
        y3 r102 = (y3) r101.getHostAbilityOrNull(y3.class);
        if (r102 == null) goto L9;
        if (r102.getTitle().getValue() == null) goto L9;
        CharSequence r103 = r102.getTitle().getValue();
    L10:
        ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.a(com.bytedance.ee.bear.docshost.k.class)).e(r100, r103);
        return;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.i
    public final void c(MessageResultBean r100) {
        a r101 = this.f219892e;
        if (r101 == null) goto L8;
        FeedPlugin.b r102 = (FeedPlugin.b) r101;
        if (FeedPlugin.access$000(r102.f219858a) == null) goto L9;
        ((com.bytedance.ee.bear.middleground.feed.a) FeedPlugin.access$000(r102.f219858a)).f232602a.f468405l.l(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.i
    public final boolean d(String r100) {
        return h5.a(r100, this.f219889b);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.i
    public final void e(MessageBean r100) {
        tt5.a.h("WebFeedListener", "toMessage()... messageId: " + r100.getMessageId() + ", optFg: " + this.f219899l + ", hostReady: " + this.f219898k);
        if (this.f219899l == false) goto L12;
        long r101 = System.currentTimeMillis();
        if (this.f219898k == false) goto L8;
        l(r100, r101, false);
        return;
    L8:
        if (this.f219889b.getActivity() == null) goto L10;
        Toast.showText(this.f219889b.getActivity(), this.f219889b.getActivity().getString(R.string.LarkCCM_Docs_LoadingDocument_Toast_Mob));
    L10:
        this.f219897j = new b(r100, r101);
        return;
    L12:
        l(r100, -1, false);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.i
    public final void f(String r100) {
        a r101 = this.f219892e;
        if (r101 == null) goto L15;
        FeedPlugin.b r102 = (FeedPlugin.b) r101;
        r102.getClass();
        String r103 = FeedPlugin.access$900(r100);     // Catch: Exception -> L9 JSONException -> L11
        if (FeedPlugin.access$1000(r102.f219858a) == null) goto L16;
        tt5.a.h("FeedPlugin", "web callback");     // Catch: Exception -> L9 JSONException -> L11
        FeedPlugin.access$1100(r102.f219858a, JSON.parseObject(r103));     // Catch: Exception -> L9 JSONException -> L11
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

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.i
    public final void g(List<String> r100) {
        c r101 = this.f219893f;
        if (r101 == null) goto L6;
        FeedPlugin.g(((h) r101).f219874a, r100);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.i
    public final void i(int r100) {
        this.f219890c.setPanelHeight(r100);
        u2 r101 = this.f219888a;
        vv4.k r102 = this.f219889b.getWeb();
        int r103 = com.bytedance.ee.util.ui.n.E(r100);
        r101.getClass();
        JSONObject r104 = new JSONObject();
        r104.put2("height", Integer.valueOf(r103));
        r102.j("javascript:lark.biz.util.setPanelHeight", r104);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.i
    public final void j(boolean r100) {
        d r101 = this.f219894g;
        if (r101 == null) goto L6;
        FeedPlugin.h(((i) r101).f219875a, r100);
        return;
    }

    public q(WebPluginHost r100, FeedPanelViewModel r101) {
        this.f219898k = false;
        this.f219888a = new u2();
        this.f219890c = r101;
        this.f219889b = r100;
        boolean r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.feed.notification_optimization");
        this.f219899l = r102;
        tt5.a.h("WebFeedListener", "WebFeedListener init, optFg: " + r102);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.i
    public final void b(boolean r100, boolean r101) {
        tt5.a.h("WebFeedListener", "statusChange()... show: " + r100 + ", dumpToComment: " + r101);
        this.f219890c.setShow(r100);
        if (r100 == true) goto L5;
        u2 r102 = this.f219888a;
        vv4.k r103 = this.f219889b.getWeb();
        r102.getClass();
        JSONObject r104 = new JSONObject();
        r104.put2("commentPanelOpen", Boolean.valueOf(r101));
        r103.j("javascript:lark.biz.feed.hideMessages", r104);
        this.f219897j = null;
    L5:
        e r105 = this.f219891d;
        if (r105 == null) goto L9;
        FeedPlugin.k(((g) r105).f219873a, r100);
        return;
    }

    public final void l(MessageBean r110, long r111, boolean r112) {
        tt5.a.h("WebFeedListener", "toMessageImpl()... messageId = " + r110.getMessageId());
        FeedPanelViewModel r100 = this.f219890c;
        if (r110.getIs_whole() != 1) goto L5;
        boolean r101 = true;
    L6:
        r100.setWhole(r101);
        if (MessageBean.MESSAGE_DOC_MENTION.equals(r110.getType()) == false) goto L13;
        u2 r102 = this.f219888a;
        vv4.k r103 = this.f219889b.getWeb();
        String r104 = r110.getMentionId();
        String r113 = r110.getReply_id();
        r102.getClass();
        JSONObject r105 = new JSONObject();
        r105.put2("isGlobalComment", Boolean.FALSE);
        r105.put2("mentionId", r104);
        r105.put2("replyId", r113);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.feed.notification_optimization") == false) goto L11;
        r105.put2("clickTime", Long.valueOf(r111));
        r105.put2("isReplay", Boolean.valueOf(r112));
    L11:
        tt5.a.h("Comment#PublishHandler", "scrollToMention:" + r105.toString());
        r103.j("javascript:lark.biz.feed.scrollToMessage", r105);
        return;
    L13:
        if (r110.getIs_whole() != 1) goto L22;
        u2 r106 = this.f219888a;
        vv4.k r107 = this.f219889b.getWeb();
        String r108 = r110.getComment_id();
        String r114 = r110.getReply_id();
        r106.getClass();
        JSONObject r109 = new JSONObject();
        Boolean r115 = Boolean.TRUE;
        r109.put2("isGlobalComment", r115);
        r109.put2("commentId", r108);
        r109.put2("replyId", r114);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.feed.notification_optimization") == false) goto L17;
        r109.put2("clickTime", Long.valueOf(r111));
        r109.put2("isReplay", Boolean.valueOf(r112));
    L17:
        r107.j("javascript:lark.biz.feed.scrollToMessage", r109);
        if (this.f219899l == false) goto L37;
        Function1<Boolean, Void> r116 = this.f219895h;
        if (r116 == null) goto L38;
        r116.invoke(r115);
        return;
    L38:
        return;
    L37:
        return;
    L22:
        u2 r117 = this.f219888a;
        vv4.k r118 = this.f219889b.getWeb();
        String r119 = r110.getComment_id();
        String r120 = r110.getReply_id();
        r117.getClass();
        JSONObject r121 = new JSONObject();
        r121.put2("commentId", r119);
        String r122 = "";
        if (TextUtils.isEmpty(r120) == false) goto L25;
        r120 = "";
    L25:
        r121.put2("replyId", r120);
        if (TextUtils.isEmpty("feed") == true) goto L29;
        r122 = "feed";
    L29:
        r121.put2("from", r122);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.feed.notification_optimization") == false) goto L32;
        r121.put2("clickTime", Long.valueOf(r111));
        r121.put2("isReplay", Boolean.valueOf(r112));
    L32:
        tt5.a.h("Comment#PublishHandler", "scrollToCommentFromFeed:" + r121.toString());
        r118.j("javascript:lark.biz.comment.activate", r121);
        BaseFeedPlugin.a r123 = this.f219896i;
        if (r123 == null) goto L40;
        r123.a();
        return;
    L40:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
