package com.bytedance.ee.bear.document.follow;

import android.os.SystemClock;
import android.util.Pair;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.magicshare.cursor.CursorPosData;
import com.bytedance.ee.bear.bizwidget.magicshare.cursor.WebFollowCursorDispatcher;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.doc.follow.event.ContentEvent;
import com.bytedance.ee.bear.doc.follow.event.LoadStateChangedEvent;
import com.bytedance.ee.bear.doc.follow.event.PositionKeeperApiCreatedEvent;
import com.bytedance.ee.bear.doc.follow.event.TitleChangedEvent;
import com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl;
import com.bytedance.ee.bear.doc.follow.impl.WebRNFollowImpl;
import com.bytedance.ee.bear.doc.follow.impl.r;
import com.bytedance.ee.bear.doc.follow.impl.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.c4;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FollowPlugin extends DocumentPlugin implements pw4.a {
    private static final String BACK_TO_LAST_POSITION = "javascript:lark.biz.positionKeeper.backToLastPosition";
    private static final String CLEAR_LAST_POSITION = "javascript:lark.biz.positionKeeper.clearLastPosition";
    private static final String FOLLOW_READY = "biz.vcSdk.followReady";
    private static final String KEEP_CURRENT_POSITION = "javascript:lark.biz.positionKeeper.keepCurrentPosition";
    private static final String TAG = "FollowPlugin";
    private sy4.f curTitleBarState;
    private sy4.d docFollowStateObserver;
    private BaseFollowImpl documentFollow;
    private final p35.f mRenderGoneListener;

    public class DocumentWebFollowImpl extends WebRNFollowImpl {
        final /* synthetic */ FollowPlugin this$0;

        @Override // com.bytedance.ee.bear.doc.follow.impl.WebRNFollowImpl
        public void registerPerfMonitor(py4.d.b r5) {
            a05.f r2 = (a05.f) this.this$0.getHostAbilityOrNull(a05.f.class);     // Catch: Throwable -> L7
            tt5.a.h(FollowPlugin.TAG, "registerPerfMonitor cb=" + r5 + " perfMonitorAbility=" + r2);     // Catch: Throwable -> L7
            if (r2 == null) goto L12;
            r2.registerPerfMonitor(r5);     // Catch: Throwable -> L7
            return;
        L12:
            return;
        L7:
            th = move-exception;
            tt5.a.f(FollowPlugin.TAG, th, false);
        }

        @Override // com.bytedance.ee.bear.doc.follow.impl.WebRNFollowImpl
        public void unregisterPerfMonitor(py4.d.b r5) {
            a05.f r2 = (a05.f) this.this$0.getHostAbilityOrNull(a05.f.class);     // Catch: Throwable -> L7
            tt5.a.h(FollowPlugin.TAG, "registerPerfMonitor cb=" + r5 + " perfMonitorAbility=" + r2);     // Catch: Throwable -> L7
            if (r2 == null) goto L12;
            r2.unregisterPerfMonitor(r5);     // Catch: Throwable -> L7
            return;
        L12:
            return;
        L7:
            th = move-exception;
            tt5.a.f(FollowPlugin.TAG, th, false);
        }

        public DocumentWebFollowImpl(FollowPlugin r1, Fragment r2, k r3, String r4, int r5) {
            this.this$0 = r1;
            super(r2, r3, r4, r5);
        }
    }

    public class a implements p35.f {
        public final /* synthetic */ FollowPlugin a;

        public a(FollowPlugin r1) {
            this.a = r1;
        }

        @Override // p35.f
        public final void a(boolean r6, int r7) {
            tt5.a.h(FollowPlugin.TAG, "receive onRenderProcessGone, start to reset follow plugin (" + FollowPlugin.access$000(this.a) + ")");
            Map<String, Pair<py4.c, r>> r8 = t.a;
            long r9 = SystemClock.uptimeMillis();
            if ((r9 - t.b) < 100) goto L13;
            t.b = r9;
            tt5.a.h("CCMFollow_FragHelper", "resetAllFollowApiV2Delegate()...");
            Set r10 = ((HashMap) t.a).entrySet();
            if (hu5.a.d(r10) == true) goto L11;
            Iterator r11 = r10.iterator();
        L9:
            if (r11.hasNext() == false) goto L14;
            Map.Entry r12 = (Map.Entry) r11.next();
            r12.setValue(new Pair((py4.c) ((Pair) r12.getValue()).first, new r()));
            goto L9
        L14:
            return;
        L11:
            return;
        }
    }

    public class b extends sy4.c {
        public final /* synthetic */ FollowPlugin b;

        @Override // sy4.c
        public final View c() {
            TitleBar r0 = FollowPlugin.access$100(this.b);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getTitleBarLayout();
        }

        public b(FollowPlugin r1) {
            this.b = r1;
        }

        @Override // sy4.c, sy4.d
        public final void a(sy4.b r2) {
            super.a(r2);
            if ((r2 instanceof sy4.f) == false) goto L6;
            FollowPlugin.access$202(this.b, (sy4.f) r2);
            return;
        }
    }

    public class c implements x2.b {
        public final /* synthetic */ FollowPlugin a;

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onLoadCancel() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onSSRLoadSuccess() {
        }

        public c(FollowPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r2, Throwable r3) {
            this.a.processEvent(new LoadStateChangedEvent(LoadStateChangedEvent.LoadState.LoadFail));
        }
    }

    public class d implements PositionKeeperApiCreatedEvent.a {
        public d() {
        }
    }

    public class e implements i<Void> {
        public final /* synthetic */ FollowPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(FollowPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            Void r4 = (Void) r2;
            tt5.a.h(FollowPlugin.TAG, "followReady");
            this.a.processEvent(new LoadStateChangedEvent(LoadStateChangedEvent.LoadState.LoadSuccess));
        }
    }

    public class f implements i<CursorPosData> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            CursorPosData r4 = (CursorPosData) r2;
            StringBuilder r5 = new StringBuilder("update cursor pos, data is ");
            if (r4 != null) goto L5;
            Object r0 = "null";
        L6:
            r5.append(r0);
            tt5.a.b(FollowPlugin.TAG, r5.toString());
            if (r4 != null) goto L9;
            tt5.a.h(FollowPlugin.TAG, "UpdateCursorPosHandler, data is null");
            return;
        L9:
            ArrayList<WebFollowCursorDispatcher.a> r6 = WebFollowCursorDispatcher.a;
            Intrinsics.checkNotNullParameter(r4, "data");
            WebFollowCursorDispatcher.b = r4;
            WebFollowCursorDispatcher.a r7 = (WebFollowCursorDispatcher.a) CollectionsKt.lastOrNull(WebFollowCursorDispatcher.a);
            if (r7 == null) goto L14;
            r7.a(r4);
            return;
        L14:
            return;
        L5:
            r0 = r4;
            goto L6
        }
    }

    public static /* synthetic */ void c(FollowPlugin r0, String r1) {
        r0.lambda$bindTitle$0(r1);
    }

    private static /* synthetic */ boolean lambda$setTitleBarState$1(sy4.b r0) {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void bindLoad() {
        bindBridgeHandler(FOLLOW_READY, new e(this));
        ((DocumentPluginHost) getHost()).getDocumentLoader().S3(new c(this));
    }

    private void bindPositionKeeperEvent() {
        tt5.a.h(TAG, "bindPositionKeeperEvent()...");
        processEvent(new PositionKeeperApiCreatedEvent(new d()));
    }

    public void processMoveToWiki() {
        processEvent(new LoadStateChangedEvent(LoadStateChangedEvent.LoadState.LoadWikiToReplaceDoc));
    }

    public FollowPlugin() {
        this.mRenderGoneListener = new a(this);
        this.docFollowStateObserver = new b(this);
    }

    private void bindFollowEvents() {
        bindLoad();
        bindTitle();
        if (sbb.e.g.getType().equals(getDocViewModel().getDocumentType()) == false) goto L5;
    L6:
        bindPositionKeeperEvent();
        return;
    L5:
        if (sbb.e.o.getType().equals(getDocViewModel().getDocumentType()) == true) goto L6;
    }

    private void bindTitle() {
        getDocViewModel().getDocName().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.follow.a(this));
    }

    private void setTitleBarState() {
        TitleBar r0 = getTitleBar();
        if (r0 != null) goto L5;
        return;
    L5:
        ((com.bytedance.ee.bear.document.titlebar.a) org.koin.java.a.a(com.bytedance.ee.bear.document.titlebar.a.class)).a();
        r0.setLeftIconVisibility(false);
        r0.h();
        r0.setTitleVisibility(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pw4.a
    public String getFollowApiHostId() {
        return t.b(((DocumentPluginHost) getHost()).c());
    }

    public sy4.f getCurTitleBarState() {
        return this.curTitleBarState;
    }

    public BaseFollowImpl getDocumentFollow() {
        return this.documentFollow;
    }

    public static /* synthetic */ k access$000(FollowPlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ TitleBar access$100(FollowPlugin r0) {
        return r0.getTitleBar();
    }

    private /* synthetic */ void lambda$bindTitle$0(String r2) {
        if (r2 != null) goto L5;
        r2 = null;
    L5:
        processEvent(new TitleChangedEvent(r2));
    }

    public void addTitleBarStateInterceptor(sy4.c.b r3) {
        sy4.d r0 = this.docFollowStateObserver;
        if ((r0 instanceof sy4.c) == false) goto L6;
        ((sy4.c) r0).b(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        super.getBridgeHandlers(r3);
        r3.put("biz.vcfollow.updateCursorPos", new f());
    }

    public void onAttachToHost(DocumentPluginHost r8) {
        super.onAttachToHost(r8);
        String r5 = r8.a().getToken();
        int r6 = r8.a().getDocumentTypeValue();
        this.documentFollow = new DocumentWebFollowImpl(this, r8.c(), getWeb(), r5, r6);
        k r0 = getWeb();
        if ((r0 instanceof c4) == false) goto L5;
        ((c4) r0).A(this.mRenderGoneListener);
    L5:
        r8.registerHostAbility(this);
        bindFollowEvents();
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        r2.unregisterHostAbility(this);
        k r3 = getWeb();
        if ((r3 instanceof c4) == false) goto L6;
        ((c4) r3).g(this.mRenderGoneListener);
        return;
    }

    public boolean processEvent(ContentEvent r2) {
        return this.documentFollow.processContentEvent(r2);
    }

    public void removeTitleBarStateInterceptor(sy4.c.b r3) {
        sy4.d r0 = this.docFollowStateObserver;
        if ((r0 instanceof sy4.c) == false) goto L6;
        ((ArrayList) ((sy4.c) r0).a).remove(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ sy4.f access$202(FollowPlugin r0, sy4.f r1) {
        r0.curTitleBarState = r1;
        return r1;
    }

    public static /* synthetic */ void access$500(FollowPlugin r0, String r1) {
        r0.execJS(r1);
    }

    public static /* synthetic */ void access$600(FollowPlugin r0, String r1) {
        r0.execJS(r1);
    }

    public static /* synthetic */ void access$800(FollowPlugin r0, String r1) {
        r0.execJS(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onAttachToUIContainer(r1, r2);
        r2.disablePluginsFitSystemWindow();
        setTitleBarState();
        this.documentFollow.registerDocFollowStateObserver(this.docFollowStateObserver);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.documentFollow.unregisterDocFollowStateObserver(this.docFollowStateObserver);
        WebFollowCursorDispatcher.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static /* synthetic */ void access$700(FollowPlugin r0, String r1, JSONObject r2) {
        r0.execJS(r1, r2);
    }
}
