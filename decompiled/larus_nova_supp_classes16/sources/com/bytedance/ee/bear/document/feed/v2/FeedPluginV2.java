package com.bytedance.ee.bear.document.feed.v2;

import android.R;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.a6;
import com.bytedance.ee.bear.document.comment.CommentPanelViewModel;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.doccomponent.DocComponentPlugin;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.event.IEventPlugin;
import com.bytedance.ee.bear.document.feed.BaseFeedPlugin;
import com.bytedance.ee.bear.document.feed.FeedPanelViewModel;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.util.MessageResultBeanParserV2;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.utils.CollectionUtils;
import gg5.i0;
import gg5.j0;
import gg5.w;
import gg5.x;
import gg5.z;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import l15.l;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FeedPluginV2 extends BaseFeedPlugin implements p {
    private static final String TAG = "FeedPluginV2";
    private boolean autoShow;
    private CompositeDisposable compositeDisposable;
    private vf5.a feed;
    private com.bytedance.ee.bear.middleground.feed.export.bean.e feedData;
    private FeedPanelViewModel feedPanelViewModel;
    private boolean hostReady;
    private final List<BaseFeedPlugin.a> jumpToCommentListeners;
    private m mFeedCallback;
    private final IEventPlugin.a mOnDeleteListener;
    private Set<String> mUnSendReadMsgIds;
    private boolean needLoadMore;
    private boolean owner;
    private Observer<DocPermission> permGet;
    private Observer<Boolean> showObservable;
    private String token;
    private String type;
    private l webFeedListener;

    public class a implements IEventPlugin.a {
        public final /* synthetic */ FeedPluginV2 a;

        public a(FeedPluginV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.event.IEventPlugin.a
        public final void a(final String r2) {
            j.c(new l15.g(this, r2));
        }
    }

    public class b implements vf5.b {
        public final /* synthetic */ FeedPluginV2 a;

        public b(FeedPluginV2 r1) {
            this.a = r1;
        }
    }

    public class c extends l {
        public final /* synthetic */ FeedPluginV2 h;

        public final void e(List<String> r3) {
            tt5.a.h(FeedPluginV2.TAG, "feed read,   " + FeedPluginV2.access$1300(this.h));
            if (FeedPluginV2.access$1300(this.h) == null) goto L5;
            FeedPluginV2.access$1500(this.h, r3);
            return;
        L5:
            tt5.a.h(FeedPluginV2.TAG, "mReadListener is null");
            FeedPluginV2.access$1600(this.h).addAll(r3);
        }

        public c(FeedPluginV2 r1, WebPluginHost r2, FeedPanelViewModel r3, int r4) {
            this.h = r1;
            super(r2, r3);
        }
    }

    public class d implements tb5.i {
        public final /* synthetic */ FeedPluginV2 a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(FeedPluginV2 r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            tt5.a.h(FeedPluginV2.TAG, "closeFeed");
            if (FeedPluginV2.access$000(this.a) != null) goto L5;
            return;
        L5:
            if (FeedPluginV2.access$000(this.a).c() == false) goto L9;
            FeedPluginV2.access$000(this.a).b();
            return;
        }
    }

    public class e implements tb5.i<String> {
        public final /* synthetic */ FeedPluginV2 a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(FeedPluginV2 r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            String r7 = (String) r5;
            tt5.a.h(FeedPluginV2.TAG, "feed ready");
            FeedPluginV2.access$2302(this.a, true);
            if (FeedPluginV2.access$2400(this.a) == null) goto L8;
            l r8 = FeedPluginV2.access$2400(this.a);
            r8.f = true;
            if (r8.e == null) goto L9;
            Toast.cancel();
            l.a r0 = r8.e;
            r8.d(r0.a, r0.b, true);
            r8.e = null;
            return;
        L9:
            return;
        }
    }

    public class f implements tb5.i<JSEventListener> {
        public final /* synthetic */ FeedPluginV2 a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(FeedPluginV2 r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            JSEventListener r4 = (JSEventListener) r2;
            tt5.a.h(FeedPluginV2.TAG, "JSAddEventListener callback = " + r3 + ", mUnSendReadMsgIds size = " + FeedPluginV2.access$1600(this.a).size());
            FeedPluginV2.access$1302(this.a, r3);
            if (CollectionUtils.isEmpty(FeedPluginV2.access$1600(this.a)) == true) goto L6;
            FeedPluginV2.access$1500(this.a, new ArrayList(FeedPluginV2.access$1600(this.a)));
            FeedPluginV2.access$1600(this.a).clear();
        L6:
            if (this.a.isShowing() == true) goto L8;
            return;
        L8:
            if (FeedPluginV2.access$2100(this.a) == false) goto L10;
            FeedPluginV2.access$1000(this.a);
            FeedPluginV2.access$2102(this.a, false);
        L10:
            this.a.updateMessageConfig();
        }
    }

    public class g implements tb5.i<String> {
        public final /* synthetic */ FeedPluginV2 a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(FeedPluginV2 r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            String r5 = (String) r3;
            if (FeedPluginV2.access$000(this.a) != null) goto L5;
        L7:
            boolean r6 = false;
        L8:
            JSONObject r0 = new JSONObject();
            r0.put("show", Boolean.valueOf(r6));
            r0.put("height", Integer.valueOf(n.E(FeedPluginV2.access$800(this.a).getPanelHeight())));
            tt5.a.h(FeedPluginV2.TAG, "JS request feed panel status：" + r0.toString());
            r4.b(r0);
            return;
        L5:
            if (FeedPluginV2.access$000(this.a).c() == false) goto L7;
            r6 = true;
            goto L8
        }
    }

    public class h implements tb5.i<String> {
        public final /* synthetic */ FeedPluginV2 a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public h(FeedPluginV2 r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            String r5 = (String) r3;
            tt5.a.h(FeedPluginV2.TAG, "JS notify feed refresh");
            if (FeedPluginV2.access$000(this.a) != null) goto L5;
            return;
        L5:
            if (FeedPluginV2.access$000(this.a).c() == true) goto L7;
            return;
        L7:
            if (TextUtils.isEmpty(r5) == false) goto L9;
            FeedPluginV2.access$000(this.a).d(false);
            return;
        L9:
            MessageResultBean r6 = MessageResultBeanParserV2.a(r5);
            if (r6 != null) goto L12;
        L16:
            tt5.a.d(FeedPluginV2.TAG, "messageResultBean is null");
            return;
        L12:
            if (r6.getData() == null) goto L16;
            if (r6.getData().getDataType() != 2) goto L16;
            FeedPluginV2.access$800(this.a).setFeedMessageData(r6.getData());
        }
    }

    public class i implements tb5.i {
        public final /* synthetic */ FeedPluginV2 a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public i(FeedPluginV2 r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            tt5.a.h(FeedPluginV2.TAG, "openFeed:" + r2);
            FeedPluginV2.access$2200(this.a, true);
            this.a.updateMessageConfig();
        }
    }

    public static /* synthetic */ void c(FeedPluginV2 r0, DocumentInfo r1) {
        r0.lambda$createFeed$5(r1);
    }

    public static /* synthetic */ void d(FeedPluginV2 r0, DocPermission r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void e(FeedPluginV2 r0, String r1) {
        r0.lambda$onAttachToHost$3(r1);
    }

    public static /* synthetic */ Void f(FeedPluginV2 r0) {
        return r0.lambda$createFeed$4();
    }

    public static /* synthetic */ void g(FeedPluginV2 r0, com.bytedance.ee.bear.middleground.comment.export.a r1) {
        r0.lambda$onAttachToHost$2(r1);
    }

    public static /* synthetic */ void h(FeedPluginV2 r0, Boolean r1) {
        r0.lambda$new$0(r1);
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
        this.autoShow = true;     // Catch: Throwable -> L17
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

    private vf5.b getFeedModel() {
        return new b(this);
    }

    private ViewGroup getParentView() {
        if (findPlugin(FollowPlugin.class) != null) goto L10;
        if (findPlugin(DocComponentPlugin.class) != null) goto L10;
        return getUIContainer().c(this);
    L10:
        return (ViewGroup) getActivity().findViewById(R.id.content);
    }

    private void loadMore() {
        if (this.mFeedCallback == null) goto L5;
        JSONObject r0 = new JSONObject();
        r0.put(JSEventListener.ACTION, JSEventListener.ACTION_LOAD_MORE);
        this.mFeedCallback.b(r0);
        return;
    L5:
        this.needLoadMore = true;
    }

    private void sendReadAllToWeb() {
        if (this.mFeedCallback == null) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put(JSEventListener.ACTION, JSEventListener.ACTION_MARK_ALL_READ);
        this.mFeedCallback.b(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.document.feed.BaseFeedPlugin
    public void hideWithAnim() {
        gg5.a r0 = this.feed;
        if (r0 == null) goto L7;
        i0 r1 = r0.a;
        if (r1 == null) goto L9;
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{0, r1.d.getHeight()});
        r2.setDuration(300);
        r2.addUpdateListener(new x(r1));
        r2.addListener(new j0(r1));
        r2.start();
        return;
    L9:
        return;
    L7:
        tt5.a.d(TAG, "hideWithAnim failed! feed is null!");
    }

    @Override // com.bytedance.ee.bear.document.feed.BaseFeedPlugin
    public boolean isShowing() {
        gg5.a r0 = this.feed;
        if (r0 != null) goto L5;
        tt5.a.d(TAG, "isShowing failed! feed is null!");
        return false;
    L5:
        return r0.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateMessageConfig() {
        com.bytedance.ee.bear.document.feed.p r6 = new com.bytedance.ee.bear.document.feed.p(this.token, this.type, this.feed.a().isOwner(), this.feed.a().isAuto(), null);
        gg5.a r0 = this.feed;
        MessageConfig r1 = this.feedPanelViewModel.jsConfig2MessageConfig(this, r6, ((DocumentPluginHost) getHost()).a());
        gg5.a r2 = r0;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "messageConfig");
        r2.c = r1;
        gg5.m r3 = r2.b;
        if (r3 == null) goto L6;
        if (r1 == null) goto L6;
        r3.e.setValue(r1);
        r3.f();
    L6:
        tt5.a.h(TAG, "JSAddEventListener feed:  isWhole=" + this.feedPanelViewModel.isWhole());
        this.feed.a().setWhole(this.feedPanelViewModel.isWhole());
    }

    public FeedPluginV2() {
        this.owner = false;
        this.mUnSendReadMsgIds = new HashSet();
        this.jumpToCommentListeners = new ArrayList();
        this.autoShow = false;
        this.needLoadMore = false;
        this.hostReady = false;
        this.webFeedListener = null;
        this.showObservable = new l15.e(this);
        this.compositeDisposable = new CompositeDisposable();
        this.permGet = new l15.f(this);
        this.mOnDeleteListener = new a(this);
    }

    private /* synthetic */ Void lambda$createFeed$4() {
        hideWithAnim();
        return null;
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

    public static /* synthetic */ vf5.a access$000(FeedPluginV2 r0) {
        return r0.feed;
    }

    public static /* synthetic */ void access$1000(FeedPluginV2 r0) {
        r0.loadMore();
    }

    public static /* synthetic */ String access$1100(FeedPluginV2 r0) {
        return r0.type;
    }

    public static /* synthetic */ String access$1200(FeedPluginV2 r0) {
        return r0.token;
    }

    public static /* synthetic */ m access$1300(FeedPluginV2 r0) {
        return r0.mFeedCallback;
    }

    public static /* synthetic */ Set access$1600(FeedPluginV2 r0) {
        return r0.mUnSendReadMsgIds;
    }

    public static /* synthetic */ void access$1700(FeedPluginV2 r0) {
        r0.sendReadAllToWeb();
    }

    public static /* synthetic */ List access$1900(FeedPluginV2 r0) {
        return r0.jumpToCommentListeners;
    }

    public static /* synthetic */ boolean access$2100(FeedPluginV2 r0) {
        return r0.needLoadMore;
    }

    public static /* synthetic */ l access$2400(FeedPluginV2 r0) {
        return r0.webFeedListener;
    }

    public static /* synthetic */ boolean access$700(FeedPluginV2 r0) {
        return r0.autoShow;
    }

    public static /* synthetic */ FeedPanelViewModel access$800(FeedPluginV2 r0) {
        return r0.feedPanelViewModel;
    }

    public static /* synthetic */ CompositeDisposable access$900(FeedPluginV2 r0) {
        return r0.compositeDisposable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private l createWebFeedListner(String r5) {
        return new c(this, (WebPluginHost) getHost(), this.feedPanelViewModel, ((hg5.b) org.koin.java.a.a(hg5.b.class)).d(sbb.e.e(this.type)));
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

    private /* synthetic */ void lambda$createFeed$5(DocumentInfo r5) {
        Boolean r0 = Boolean.valueOf(f35.b.g(r5));
        if (this.feed.c() == true) goto L5;
    L7:
        Boolean r6 = Boolean.valueOf(f35.b.f(r5));
        tt5.a.h(TAG, "canCopy=" + r6);
        this.feed.a().setCanCopy(r6.booleanValue());
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
        showFeedPanel(true, r3.booleanValue());
        return;
    L4:
        gg5.a r4 = this.feed;
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
        gg5.a r0 = this.feed;
        boolean r4 = f35.b.h(r3);
        i0 r1 = r0.a;
        if (r1 == null) goto L16;
        SpaceEmptyState r5 = r1.j;
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

    private void lambda$onAttachToHost$2(com.bytedance.ee.bear.middleground.comment.export.a r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.feed == null) goto L31;
        boolean r0 = r8.c;
        boolean r1 = r8.a;
        boolean r9 = r8.b;
        tt5.a.h(TAG, "close:" + r0 + " enter: " + r1 + " start:" + r9);
        if (r0 == true) goto L9;
        if (r9 == false) goto L28;
        i0 r10 = this.feed.a;
        if (r10 == null) goto L29;
        tt5.a.h("PanelViewV2", "toComment:" + r1);
        if (r1 == false) goto L17;
        com.bytedance.ee.bear.middleground.comment.h r2 = ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).f();
        int r6 = r10.k.c();
        r2.getClass();
        com.bytedance.ee.bear.middleground.comment.card.a.a = r6;
        ValueAnimator r3 = ValueAnimator.ofInt(new int[]{0, r10.d.getWidth()});
        r3.setDuration(300);
        r3.addUpdateListener(new w(r10));
        r3.start();
        return;
    L17:
        ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).f().getClass();
        if (com.bytedance.ee.bear.middleground.comment.card.a.b != 0) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == true) goto L23;
        com.bytedance.ee.bear.facade.common.widget.d r5 = r10.k;
        ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).f().getClass();
        int r7 = com.bytedance.ee.bear.middleground.comment.card.a.b;
        com.bytedance.ee.bear.middleground.comment.card.a.b = 0;
        r5.l(r7);
    L23:
        ValueAnimator r11 = ValueAnimator.ofInt(new int[]{r10.d.getWidth(), 0});
        r11.setDuration(300);
        r11.addUpdateListener(new z(r10));
        r11.start();
        return;
    L20:
        r4 = false;
        goto L21
    L29:
        return;
    L28:
        return;
    L9:
        if (this.feed.c() == false) goto L26;
        this.feed.b();
        return;
    L26:
        return;
    }

    private void lambda$onAttachToHost$3(String r3) {
        if (r3 == null) goto L13;
        gg5.a r0 = this.feed;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.feedData != null) goto L8;
        return;
    L8:
        if (lbb.a.a(r0.a().getToken()) == true) goto L10;
        return;
    L10:
        if (lbb.a.a(r3) == true) goto L17;
        tt5.a.h(TAG, "set new token");
        this.feed.a().setToken(r3);
        this.feedData.a.c(r3);
        return;
    L17:
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

    private void showFeedPanel(boolean r2) {
        showFeedPanel(r2, false);
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
        r3.put("biz.feed.addEventListener", new f(this));
        r3.put("biz.feed.closePanel", new d(this));
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.feed.notification_optimization") == false) goto L6;
        r3.put("biz.feed.ready", new e(this));
        return;
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        FeedPanelViewModel r4 = (FeedPanelViewModel) viewModel(FeedPanelViewModel.class);
        this.feedPanelViewModel = r4;
        r4.getShowFeedPanel().observe(getLifecycleOwner(), this.showObservable);
        registerPermObserver();
        ((CommentPanelViewModel) viewModel(CommentPanelViewModel.class)).getCommentAnimationLiveData().observe(getLifecycleOwner(), new l15.c(this));
        getDocViewModel().liveDocObjToken().observe(getLifecycleOwner(), new l15.d(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        gg5.a r0 = this.feed;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "configuration");
        i0 r1 = r0.a;
        if (r1 == null) goto L9;
        r1.e();
        r1.k.e();
        r1.k.f();
        r1.b(r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.document.feed.BaseFeedPlugin
    public void readMessage(List<String> r3) {
        gg5.a r0 = this.feed;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNullParameter(r3, "messageIds");
        gg5.m r1 = r0.b;
        if (r1 == null) goto L9;
        r1.g(r3);
        return;
    L9:
        return;
    L7:
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

    public static /* synthetic */ m access$1302(FeedPluginV2 r0, m r1) {
        r0.mFeedCallback = r1;
        return r1;
    }

    public static /* synthetic */ void access$1400(FeedPluginV2 r0, boolean r1) {
        r0.sendRemindToWeb(r1);
    }

    public static /* synthetic */ void access$1500(FeedPluginV2 r0, List r1) {
        r0.sendReadFeedToWeb(r1);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$1800(FeedPluginV2 r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static /* synthetic */ void access$2000(FeedPluginV2 r0, boolean r1) {
        r0.handleLandscape(r1);
    }

    public static /* synthetic */ boolean access$2102(FeedPluginV2 r0, boolean r1) {
        r0.needLoadMore = r1;
        return r1;
    }

    public static /* synthetic */ void access$2200(FeedPluginV2 r0, boolean r1) {
        r0.showFeedPanel(r1);
    }

    public static /* synthetic */ boolean access$2302(FeedPluginV2 r0, boolean r1) {
        r0.hostReady = r1;
        return r1;
    }

    private void showFeedPanel(boolean r4, boolean r5) {
        BearUrl r0 = getDocViewModel().getBearUrl();
        if (r0 != null) goto L7;
        tt5.a.d(TAG, "showFeedPanel: bearUrl = null !");
        return;
    L7:
        if (TextUtils.isEmpty(r0.a) == false) goto L9;
    L19:
        tt5.a.d(TAG, "parse url:" + r0.a + "  " + du5.b.g(r0.b));
        return;
    L9:
        if (TextUtils.isEmpty(r0.b) == true) goto L19;
        String r1 = r0.a;
        this.type = r1;
        String r2 = r0.b;
        this.token = r2;
        createFeed(r2, r1, r5);
        if (r4 == true) goto L14;
        return;
    L14:
        if (this.feed.c() == true) goto L22;
        this.feed.d(r5);
        requestPerm();
        getWeb().getWebView().clearFocus();
        BaseSelectionPlugin r6 = (BaseSelectionPlugin) findPlugin(BaseSelectionPlugin.class);
        if (r6 == null) goto L23;
        r6.closeActionMode();
        return;
    L23:
        return;
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        IEventPlugin r3 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r3 == null) goto L5;
        r3.addDeleteListener(this.mOnDeleteListener);
    L5:
        checkAutoShowFeed();
    }

    public void onDetachFromUIContainer(DocumentPluginHost r4, t r5) {
        super.onDetachFromUIContainer(r4, r5);
        IEventPlugin r6 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r6 == null) goto L5;
        r6.removeDeleteListener(this.mOnDeleteListener);
    L5:
        this.compositeDisposable.clear();
        this.feedPanelViewModel.resetValue();
        gg5.a r7 = this.feed;
        if (r7 == null) goto L20;
        gg5.a r8 = r7;
        if (r8.c() == false) goto L12;
        i0 r9 = r8.a;
        if (r9 == null) goto L12;
        r9.d(false);
    L12:
        i0 r10 = r8.a;
        if (r10 == null) goto L18;
        tt5.a.h("PanelViewV2", "destroy message");
        gg5.m r0 = r10.m;
        r0.d.setValue(null);
        r0.f.setValue(null);
        MutableLiveData r1 = r0.i;
        if (r1 == null) goto L17;
        r1.removeObserver(r0.j);
    L17:
        r0.n.getClass();
        r0.b();
        r10.o.a();
    L18:
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

    /* JADX WARN: Multi-variable type inference failed */
    private void createFeed(String r10, String r11, boolean r12) {
        if (this.feed != null) goto L11;
        tt5.a.h(TAG, "create feed");
        l r0 = createWebFeedListner(r10);
        boolean r1 = this.hostReady;
        r0.f = r1;
        if (r1 == true) goto L7;
    L9:
        this.webFeedListener = r0;
        MessageConfig r7 = new MessageConfig();
        r7.setDocumentType(sbb.e.e(r11));
        r7.setToken(r10);
        r7.setAuto(r12);
        r7.setOwner(this.owner);
        r7.setLoadingSuccess(false);
        r7.setSupportMute(false);
        this.feed = ((com.bytedance.ee.bear.middleground.feed.export.bean.h) org.koin.java.a.a(com.bytedance.ee.bear.middleground.feed.export.bean.h.class)).b(getActivity(), ((DocumentPluginHost) getHost()).getHostFragment(), getParentView(), r0, r7, getFeedModel());
        r0.d = new l15.a(this);
        ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().g().observe(getLifecycleOwner(), new l15.b(this));
        return;
    L7:
        if (r0.e == null) goto L9;
        Toast.cancel();
        l.a r2 = r0.e;
        r0.d(r2.a, r2.b, true);
        r0.e = null;
        goto L9
    }
}
