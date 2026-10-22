package com.bytedance.ee.bear.document.feed;

import android.R;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.a6;
import com.bytedance.ee.bear.document.comment.CommentPanelViewModel;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.document.comment.bean.CommentJsRequestBean;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.doccomponent.DocComponentPlugin;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.event.IEventPlugin;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import dg5.a0;
import dg5.b0;
import dg5.d1;
import dg5.u;
import dg5.v0;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FeedPlugin extends BaseFeedPlugin implements com.bytedance.ee.bear.document.orientation.p {
    private static final String BIZ_FEED_DOC_REQUEST_NATIVE = "biz.feed.requestNative";
    private static final String BIZ_FEED_READ_MESSAGE = "biz.feed.readMessages";
    private static final String TAG = "FeedPlugin";
    private com.bytedance.ee.bear.middleground.feed.export.bean.f feed;
    private com.bytedance.ee.bear.middleground.feed.export.bean.e feedData;
    private FeedPanelViewModel feedPanelViewModel;
    private boolean hostReady;
    private final List<BaseFeedPlugin.a> jumpToCommentListeners;
    private tb5.m mFeedCallback;
    private final IEventPlugin.a mOnDeleteListener;
    private Set<String> mUnSendReadMsgIds;
    private boolean owner;
    private Observer<DocPermission> permGet;
    protected Observer<Boolean> showObservable;
    private String token;
    private String type;
    private q webFeedListener;

    public static class OpenFeedModel implements NonProguard {
        public Long lastLegacyMessageTimestamp;

        public OpenFeedModel() {
            this.lastLegacyMessageTimestamp = null;
        }
    }

    public class a implements IEventPlugin.a {
        public final /* synthetic */ FeedPlugin a;

        public a(FeedPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.event.IEventPlugin.a
        public final void a(final String r2) {
            com.bytedance.ee.util.ui.j.c(new l(this, r2));
        }
    }

    public class b implements q.a {
        public final /* synthetic */ FeedPlugin a;

        public b(FeedPlugin r1) {
            this.a = r1;
        }
    }

    public class c implements tb5.i {
        public final /* synthetic */ FeedPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(FeedPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            tt5.a.h(FeedPlugin.TAG, "closeFeed");
            if (FeedPlugin.access$000(this.a) != null) goto L5;
            return;
        L5:
            if (FeedPlugin.access$000(this.a).c() == false) goto L9;
            FeedPlugin.access$000(this.a).b();
            return;
        }
    }

    public class d implements tb5.i<String> {
        public final /* synthetic */ FeedPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(FeedPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, tb5.m r6) {
            String r7 = (String) r5;
            tt5.a.h(FeedPlugin.TAG, "feed ready");
            FeedPlugin.access$1702(this.a, true);
            if (FeedPlugin.access$1800(this.a) == null) goto L8;
            q r8 = FeedPlugin.access$1800(this.a);
            r8.k = true;
            if (r8.j == null) goto L9;
            Toast.cancel();
            q.b r0 = r8.j;
            r8.l(r0.a, r0.b, true);
            r8.j = null;
            return;
        L9:
            return;
        }
    }

    public class e implements tb5.i<JSEventListener> {
        public final /* synthetic */ FeedPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(FeedPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            JSEventListener r4 = (JSEventListener) r2;
            tt5.a.h(FeedPlugin.TAG, "JSAddEventListener callback = " + r3 + ", mUnSendReadMsgIds size = " + FeedPlugin.access$1400(this.a).size());
            FeedPlugin.access$1002(this.a, r3);
            if (FeedPlugin.access$1400(this.a).isEmpty() == true) goto L6;
            FeedPlugin.access$1500(this.a, new ArrayList(FeedPlugin.access$1400(this.a)));
            FeedPlugin.access$1400(this.a).clear();
        L6:
            if (this.a.isShowing() == false) goto L9;
            this.a.updateMessageConfig();
            return;
        }
    }

    public class f implements tb5.i<CommentJsRequestBean> {
        public final /* synthetic */ FeedPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(FeedPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, tb5.m r5) {
            CommentJsRequestBean r6 = (CommentJsRequestBean) r4;
            if (r6 != null) goto L5;
        L13:
            tt5.a.k(FeedPlugin.TAG, "JSCommentRequestNative is null");
            return;
        L5:
            if (TextUtils.isEmpty(r6.getAction()) == true) goto L13;
            tt5.a.h(FeedPlugin.TAG, "JSCommentRequestNative action = " + r6.getAction());
            if ("fetchMessage".equals(r6.getAction()) == false) goto L15;
            FeedPlugin.access$1202(this.a, r6.isOwner());
            FeedPlugin.access$1300(this.a, false, null);
            if (FeedPlugin.access$000(this.a) != null) goto L12;
            tt5.a.d(FeedPlugin.TAG, "JSCommentRequestNative feed = null");
            return;
        L12:
            FeedPlugin.access$000(this.a).b.setOwner(FeedPlugin.access$1200(this.a));
            FeedPlugin.access$000(this.a).d(FeedPlugin.access$1200(this.a), r6.getOptions()).map(new m()).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new n(this), new o());
            return;
        }
    }

    public class g implements tb5.i<String> {
        public final /* synthetic */ FeedPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(FeedPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            String r5 = (String) r3;
            if (FeedPlugin.access$000(this.a) != null) goto L5;
        L7:
            boolean r6 = false;
        L8:
            JSONObject r0 = new JSONObject();
            r0.put("show", Boolean.valueOf(r6));
            r0.put("height", Integer.valueOf(com.bytedance.ee.util.ui.n.E(FeedPlugin.access$1600(this.a).getPanelHeight())));
            tt5.a.h(FeedPlugin.TAG, "JS request feed panel status：" + r0.toString());
            r4.b(r0);
            return;
        L5:
            if (FeedPlugin.access$000(this.a).c() == false) goto L7;
            r6 = true;
            goto L8
        }
    }

    public class h implements tb5.i<String> {
        public final /* synthetic */ FeedPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public h(FeedPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            String r4 = (String) r2;
            tt5.a.h(FeedPlugin.TAG, "JS notify feed refresh");
            if (FeedPlugin.access$000(this.a) != null) goto L5;
            return;
        L5:
            if (FeedPlugin.access$000(this.a).c() == true) goto L7;
            return;
        L7:
            if (TextUtils.isEmpty(r4) == false) goto L9;
            FeedPlugin.access$000(this.a).g(false);
            return;
        L9:
            d1 r5 = FeedPlugin.access$000(this.a).a.l;
            r5.getClass();
            Flowable r6 = Flowable.just(r4).map(new v0(r5)).subscribeOn(fo5.d.a()).observeOn(fo5.d.a());
            r5.c(r5.n);
            r5.c(r5.m);
            Disposable r7 = r5.m(r6);
            r5.n = r7;
            r5.a(r7);
        }
    }

    public class i implements tb5.i<OpenFeedModel> {
        public final /* synthetic */ FeedPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public i(FeedPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            OpenFeedModel r4 = (OpenFeedModel) r2;
            tt5.a.h(FeedPlugin.TAG, "openFeed:" + r4);
            FeedPlugin.access$1300(this.a, true, r4.lastLegacyMessageTimestamp);
            this.a.updateMessageConfig();
        }
    }

    public class j implements tb5.i<ReadMessageBean> {
        public final /* synthetic */ FeedPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public j(FeedPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            ReadMessageBean r4 = (ReadMessageBean) r2;
            tt5.a.h(FeedPlugin.TAG, "readMessages: " + r4);
            if (FeedPlugin.access$000(this.a) == null) goto L6;
            FeedPlugin.access$000(this.a).e(r4.getMessageIds());
            return;
        }
    }

    public static /* synthetic */ void c(FeedPlugin r0, Boolean r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void d(FeedPlugin r0, String r1, String r2) {
        r0.lambda$createFeed$4(r1, r2);
    }

    public static /* synthetic */ Void e(FeedPlugin r0, Boolean r1) {
        return r0.lambda$createFeed$8(r1);
    }

    public static /* synthetic */ void f(FeedPlugin r0, DocPermission r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void g(FeedPlugin r0, List r1) {
        r0.lambda$createFeed$5(r1);
    }

    public static /* synthetic */ void h(FeedPlugin r0, boolean r1) {
        r0.lambda$createFeed$6(r1);
    }

    public static /* synthetic */ void i(FeedPlugin r0, com.bytedance.ee.bear.middleground.comment.export.a r1) {
        r0.lambda$onAttachToHost$2(r1);
    }

    public static /* synthetic */ void j(FeedPlugin r0, String r1) {
        r0.lambda$onAttachToHost$3(r1);
    }

    public static /* synthetic */ void k(FeedPlugin r0, boolean r1) {
        r0.handleLandscape(r1);
    }

    public static /* synthetic */ void l(FeedPlugin r0) {
        r0.lambda$createFeed$7();
    }

    public static /* synthetic */ void m(FeedPlugin r0, DocumentInfo r1) {
        r0.lambda$createFeed$9(r1);
    }

    @Override // com.bytedance.ee.bear.document.feed.BaseFeedPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void checkAutoShowFeed() {
        tt5.a.h(TAG, "[AutoShowFeed]checkAutoShowFeed");
        String r0 = getUrl();
        a6 r2 = (a6) getHostAbilityOrNull(a6.class);     // Catch: Throwable -> L17
        if (r2 == null) goto L6;
        Map<String, String> r3 = r2.getExtraData();     // Catch: Throwable -> L17
    L7:
        if (r3 != null) goto L9;
    L12:
        boolean r4 = getDocViewModel().isSyncBlock();     // Catch: Throwable -> L17
        if (((com.bytedance.ee.bear.middleground.feed.export.bean.h) org.koin.java.a.a(com.bytedance.ee.bear.middleground.feed.export.bean.h.class)).i(r0, r3) == false) goto L21;
        if (r4 == true) goto L22;
        tt5.a.h(TAG, "[AutoShowFeed]auto open feed..");     // Catch: Throwable -> L17
        this.feedPanelViewModel.setFeedPanel(Boolean.TRUE);     // Catch: Throwable -> L17
        return;
    L22:
        return;
    L21:
        return;
    L9:
        if (TextUtils.equals(Boolean.TRUE.toString(), r3.get("extra_reopen_from_permission_change")) == false) goto L12;
        tt5.a.h(TAG, "[AutoShowFeed]reopen because of permission change");     // Catch: Throwable -> L17
        return;
    L6:
        r3 = null;
    L17:
        th = move-exception;
        tt5.a.e(TAG, "[AutoShowFeed]check auto show feed error!", th, false);
    }

    private ViewGroup getParentView() {
        if (findPlugin(FollowPlugin.class) != null) goto L10;
        if (findPlugin(DocComponentPlugin.class) != null) goto L10;
        return getUIContainer().c(this);
    L10:
        return (ViewGroup) getActivity().findViewById(R.id.content);
    }

    private /* synthetic */ void lambda$createFeed$7() {
        Iterator<BaseFeedPlugin.a> r0 = this.jumpToCommentListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a();
        goto L4
    }

    @Override // com.bytedance.ee.bear.document.feed.BaseFeedPlugin
    public void hideWithAnim() {
        com.bytedance.ee.bear.middleground.feed.a r0 = this.feed;
        if (r0 == null) goto L5;
        a0 r1 = r0.a;
        r1.getClass();
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{0, r1.c.getHeight()});
        r2.setDuration(300);
        r2.addUpdateListener(new u(r1));
        r2.addListener(new b0(r1));
        r2.start();
        return;
    L5:
        tt5.a.d(TAG, "hideWithAnim failed! feed is null!");
    }

    @Override // com.bytedance.ee.bear.document.feed.BaseFeedPlugin
    public boolean isShowing() {
        com.bytedance.ee.bear.middleground.feed.a r0 = this.feed;
        if (r0 != null) goto L5;
        tt5.a.d(TAG, "isShowing failed! feed is null!");
        return false;
    L5:
        return r0.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateMessageConfig() {
        p r6 = new p(this.token, this.type, this.feed.b.isOwner(), this.feed.b.isAuto(), this.feed.b.getFilterTimestamp());
        this.feed.f(this.feedPanelViewModel.jsConfig2MessageConfig(this, r6, ((DocumentPluginHost) getHost()).a()));
        tt5.a.h(TAG, "JSAddEventListener feed:  isWhole=" + this.feedPanelViewModel.isWhole());
        this.feed.b.setWhole(this.feedPanelViewModel.isWhole());
    }

    public FeedPlugin() {
        this.owner = false;
        this.mUnSendReadMsgIds = new HashSet();
        this.jumpToCommentListeners = new ArrayList();
        this.hostReady = false;
        this.webFeedListener = null;
        this.showObservable = new com.bytedance.ee.bear.document.feed.d(this);
        this.permGet = new com.bytedance.ee.bear.document.feed.e(this);
        this.mOnDeleteListener = new a(this);
    }

    private void registerPermObserver() {
        if (getDocViewModel() != null) goto L5;
        return;
    L5:
        if (getDocViewModel().getDocumentInfoProvider() != null) goto L8;
        return;
    L8:
        if (getDocViewModel().getDocumentInfoProvider().c() != null) goto L10;
        return;
    L10:
        getDocViewModel().getDocumentInfoProvider().c().observe(getLifecycleOwner(), this.permGet);
    }

    private void requestPerm() {
        if (getDocViewModel() != null) goto L5;
        return;
    L5:
        if (getDocViewModel().getDocumentInfoProvider() == null) goto L10;
        String r0 = getDocViewModel().getToken();
        getDocViewModel().getDocumentInfoProvider().i(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return super.shouldDisableLandscape();
    }

    public static /* synthetic */ com.bytedance.ee.bear.middleground.feed.export.bean.f access$000(FeedPlugin r0) {
        return r0.feed;
    }

    public static /* synthetic */ tb5.m access$1000(FeedPlugin r0) {
        return r0.mFeedCallback;
    }

    public static /* synthetic */ boolean access$1200(FeedPlugin r0) {
        return r0.owner;
    }

    public static /* synthetic */ Set access$1400(FeedPlugin r0) {
        return r0.mUnSendReadMsgIds;
    }

    public static /* synthetic */ FeedPanelViewModel access$1600(FeedPlugin r0) {
        return r0.feedPanelViewModel;
    }

    public static /* synthetic */ q access$1800(FeedPlugin r0) {
        return r0.webFeedListener;
    }

    public static /* synthetic */ String access$900(String r0) throws JSONException {
        return getBodyWithJson(r0);
    }

    private static String getBodyWithJson(String r1) throws JSONException {
        return JSONObjectProtectorUtils.getJSONObject(new org.json.JSONObject(r1), "data").get("body").toString();
    }

    private void handleLandscape(boolean r2) {
        BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r0 == null) goto L8;
        if (r2 == false) goto L6;
        r0.onOrientationSupportPanelShowing(this);
        return;
    L6:
        r0.onOrientationSupportPanelDismiss(this);
        return;
    }

    private /* synthetic */ void lambda$createFeed$5(List r3) {
        tt5.a.h(TAG, "feed read,   " + this.mFeedCallback);
        if (this.mFeedCallback == null) goto L5;
        sendReadFeedToWeb(r3);
        return;
    L5:
        tt5.a.h(TAG, "mReadListener is null");
        this.mUnSendReadMsgIds.addAll(r3);
    }

    private /* synthetic */ void lambda$createFeed$6(boolean r3) {
        tt5.a.h(TAG, "onSetRemind,   " + r3 + " " + this.mFeedCallback);
        if (this.mFeedCallback == null) goto L5;
        sendRemindToWeb(r3);
        return;
    L5:
        tt5.a.h(TAG, "mReadListener is null");
    }

    private /* synthetic */ Void lambda$createFeed$8(Boolean r1) {
        hideWithAnim();
        return null;
    }

    private void lambda$createFeed$9(DocumentInfo r5) {
        Boolean r0 = Boolean.valueOf(f35.b.g(r5));
        if (this.feed.c() == true) goto L5;
    L7:
        Boolean r6 = Boolean.valueOf(f35.b.f(r5));
        tt5.a.h(TAG, "canCopy=" + r6);
        this.feed.b.setCanCopy(r6.booleanValue());
        return;
    L5:
        if (r0.booleanValue() == true) goto L7;
        tt5.a.h(TAG, "canRead=" + r0 + " hide feed");
        this.feed.b();
        goto L7
    }

    private /* synthetic */ void lambda$new$0(Boolean r3) {
        if (r3 == null) goto L4;
        tt5.a.h(TAG, "show feed panel");
        showFeedPanel(true, null, r3.booleanValue());
        return;
    L4:
        com.bytedance.ee.bear.middleground.feed.a r4 = this.feed;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.c() == false) goto L12;
        this.feed.b();
        return;
    }

    private void lambda$new$1(DocPermission r2) {
        if (r2 == null) goto L15;
        IDocUserPermission r3 = r2.a;
        if (r3 == null) goto L18;
        com.bytedance.ee.bear.middleground.feed.a r0 = this.feed;
        boolean r4 = f35.b.h(r3);
        a0 r1 = r0.a;
        if (r1 == null) goto L16;
        SpaceEmptyState r5 = r1.i;
        if (r5 == null) goto L17;
        if (r4 == false) goto L12;
        int r6 = 0;
    L13:
        r5.setVisibility(r6);
        return;
    L12:
        r6 = 8;
        goto L13
    L17:
        return;
    L16:
        return;
    L18:
        return;
    }

    private void lambda$onAttachToHost$2(com.bytedance.ee.bear.middleground.comment.export.a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.feed == null) goto L18;
        boolean r0 = r5.c;
        boolean r1 = r5.a;
        boolean r6 = r5.b;
        tt5.a.h(TAG, "close:" + r0 + " enter: " + r1 + " start:" + r6);
        if (r0 == true) goto L9;
        if (r6 == false) goto L17;
        this.feed.h(r1);
        return;
    L17:
        return;
    L9:
        if (this.feed.c() == false) goto L15;
        this.feed.b();
        return;
    L15:
        return;
    }

    private void lambda$onAttachToHost$3(String r3) {
        if (r3 == null) goto L13;
        com.bytedance.ee.bear.middleground.feed.a r0 = this.feed;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.feedData != null) goto L8;
        return;
    L8:
        if (lbb.a.a(r0.b.getToken()) == true) goto L10;
        return;
    L10:
        if (lbb.a.a(r3) == true) goto L17;
        tt5.a.h(TAG, "set new token");
        this.feed.b.setToken(r3);
        this.feedData.a.c(r3);
        return;
    L17:
        return;
    }

    private void sendChangeToWeb(JSONObject r3) {
        if (this.mFeedCallback == null) goto L6;
        r3.put(JSEventListener.ACTION, JSEventListener.ACTION_CHANGE);
        this.mFeedCallback.b(r3);
        return;
    }

    private void sendReadFeedToWeb(List<String> r3) {
        if (this.mFeedCallback == null) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put("msgIds", r3);
        r0.put(JSEventListener.ACTION, JSEventListener.ACTION_READMESSAGE);
        this.mFeedCallback.b(r0);
        return;
    }

    private void sendRemindToWeb(boolean r3) {
        if (this.mFeedCallback == null) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put("isRemind", Boolean.valueOf(r3));
        r0.put(JSEventListener.ACTION, JSEventListener.ACTION_TOGGLE_MUTE);
        this.mFeedCallback.b(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.document.feed.BaseFeedPlugin
    public void addJumpToCommentListener(BaseFeedPlugin.a r2) {
        if (this.jumpToCommentListeners.contains(r2) == true) goto L6;
        this.jumpToCommentListeners.add(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put("biz.feed.showMessages", new i(this));
        r3.put("biz.feed.notifyMessageChange", new h(this));
        r3.put("biz.feed.getMessageStatus", new g(this));
        r3.put(BIZ_FEED_DOC_REQUEST_NATIVE, new f(this));
        r3.put("biz.feed.addEventListener", new e(this));
        r3.put("biz.feed.closePanel", new c(this));
        r3.put(BIZ_FEED_READ_MESSAGE, new j(this));
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.feed.notification_optimization") == false) goto L6;
        r3.put("biz.feed.ready", new d(this));
        return;
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        FeedPanelViewModel r4 = (FeedPanelViewModel) viewModel(FeedPanelViewModel.class);
        this.feedPanelViewModel = r4;
        r4.getShowFeedPanel().observe(getLifecycleOwner(), this.showObservable);
        registerPermObserver();
        ((CommentPanelViewModel) viewModel(CommentPanelViewModel.class)).getCommentAnimationLiveData().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.feed.a(this));
        getDocViewModel().liveDocObjToken().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.feed.c(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        com.bytedance.ee.bear.middleground.feed.a r0 = this.feed;
        if (r0 == null) goto L6;
        a0 r1 = r0.a;
        r1.g();
        r1.j.e();
        r1.j.f();
        r1.b(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.document.feed.BaseFeedPlugin
    public void readMessage(List<String> r2) {
        com.bytedance.ee.bear.middleground.feed.a r0 = this.feed;
        if (r0 == null) goto L5;
        r0.e(r2);
        return;
    L5:
        tt5.a.d(TAG, "readMessage failed! feed is null!");
    }

    @Override // com.bytedance.ee.bear.document.feed.BaseFeedPlugin
    public void removeJumpToCommentListener(BaseFeedPlugin.a r2) {
        this.jumpToCommentListeners.remove(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ tb5.m access$1002(FeedPlugin r0, tb5.m r1) {
        r0.mFeedCallback = r1;
        return r1;
    }

    public static /* synthetic */ void access$1100(FeedPlugin r0, JSONObject r1) {
        r0.sendChangeToWeb(r1);
    }

    public static /* synthetic */ boolean access$1202(FeedPlugin r0, boolean r1) {
        r0.owner = r1;
        return r1;
    }

    public static /* synthetic */ void access$1500(FeedPlugin r0, List r1) {
        r0.sendReadFeedToWeb(r1);
    }

    public static /* synthetic */ boolean access$1702(FeedPlugin r0, boolean r1) {
        r0.hostReady = r1;
        return r1;
    }

    private /* synthetic */ void lambda$createFeed$4(String r3, String r4) {
        CommentPlugin r0 = (CommentPlugin) findPlugin(CommentPlugin.class);
        if (r0 == null) goto L6;
        r0.translate(r3, r4, 0);
        return;
    }

    private void showFeedPanel(boolean r2, Long r3) {
        showFeedPanel(r2, r3, false);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        IEventPlugin r3 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r3 == null) goto L5;
        r3.addDeleteListener(this.mOnDeleteListener);
    L5:
        checkAutoShowFeed();
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        IEventPlugin r3 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r3 == null) goto L5;
        r3.removeDeleteListener(this.mOnDeleteListener);
    L5:
        this.feedPanelViewModel.resetValue();
        com.bytedance.ee.bear.middleground.feed.a r4 = this.feed;
        if (r4 == null) goto L9;
        r4.a();
        this.feed = null;
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static /* synthetic */ void access$1300(FeedPlugin r0, boolean r1, Long r2) {
        r0.showFeedPanel(r1, r2);
    }

    private void showFeedPanel(boolean r4, Long r5, boolean r6) {
        BearUrl r0 = getDocViewModel().getBearUrl();
        if (r0 != null) goto L7;
        tt5.a.d(TAG, "showFeedPanel: bearUrl = null !");
        return;
    L7:
        if (TextUtils.isEmpty(r0.a) == false) goto L9;
    L17:
        tt5.a.d(TAG, "parse url:" + r0.a + "  " + du5.b.g(r0.b));
        return;
    L9:
        if (TextUtils.isEmpty(r0.b) == true) goto L17;
        String r1 = r0.a;
        this.type = r1;
        String r2 = r0.b;
        this.token = r2;
        createFeed(r2, r1, r5, r6);
        if (r4 == true) goto L14;
        return;
    L14:
        if (this.feed.c() == true) goto L20;
        this.feed.g(r6);
        requestPerm();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.bytedance.ee.bear.document.feed.f] */
    private void createFeed(String r7, String r8, Long r9, boolean r10) {
        if (this.feed != null) goto L11;
        tt5.a.h(TAG, "create feed");
        WebPluginHost r1 = (WebPluginHost) getHost();
        FeedPanelViewModel r2 = this.feedPanelViewModel;
        ((hg5.b) org.koin.java.a.a(hg5.b.class)).d(sbb.e.e(r8));
        q r0 = new q(r1, r2);
        boolean r3 = this.hostReady;
        r0.k = r3;
        if (r3 == true) goto L7;
    L9:
        this.webFeedListener = r0;
        MessageConfig r4 = new MessageConfig();
        r4.setDocumentType(sbb.e.e(r8));
        r4.setToken(r7);
        r4.setAuto(r10);
        r4.setOwner(this.owner);
        r4.setLoadingSuccess(false);
        r4.setSupportMute(true);
        r4.setFilterTimestamp(r9);
        this.feedData = ((com.bytedance.ee.bear.middleground.feed.export.bean.h) org.koin.java.a.a(com.bytedance.ee.bear.middleground.feed.export.bean.h.class)).c(r7, sbb.e.e(r8), new com.bytedance.ee.bear.document.feed.f(this));
        com.bytedance.ee.bear.middleground.feed.export.bean.h r11 = (com.bytedance.ee.bear.middleground.feed.export.bean.h) org.koin.java.a.a(com.bytedance.ee.bear.middleground.feed.export.bean.h.class);
        com.bytedance.ee.bear.middleground.feed.export.bean.b r12 = new com.bytedance.ee.bear.middleground.feed.export.bean.b();
        FragmentActivity r13 = getActivity();
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.a = r13;
        ViewGroup r14 = getParentView();
        Intrinsics.checkNotNullParameter(r14, "parentView");
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r12.b = r14;
        com.bytedance.ee.bear.middleground.feed.export.bean.e r16 = this.feedData;
        Intrinsics.checkNotNullParameter(r16, "feedData");
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r12.c = r16;
        Intrinsics.checkNotNullParameter(r0, "feedListener");
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r12.d = r0;
        Intrinsics.checkNotNullParameter(r4, "messageConfig");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r12.e = r4;
        this.feed = r11.k(r12);
        r0.d = new com.bytedance.ee.bear.document.feed.g(this);
        r0.f = new com.bytedance.ee.bear.document.feed.h(this);
        r0.g = new com.bytedance.ee.bear.document.feed.i(this);
        r0.e = new b(this);
        r0.i = new com.bytedance.ee.bear.document.feed.j(this);
        r0.h = new k(this);
        ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().g().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.feed.b(this));
        return;
    L7:
        if (r0.j == null) goto L9;
        Toast.cancel();
        q.b r5 = r0.j;
        r0.l(r5.a, r5.b, true);
        r0.j = null;
        goto L9
    }
}
