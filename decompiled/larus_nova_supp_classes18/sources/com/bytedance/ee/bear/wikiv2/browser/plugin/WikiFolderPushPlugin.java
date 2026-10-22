package com.bytedance.ee.bear.wikiv2.browser.plugin;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiFolderPushPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "mHashCode", "", "kotlin.jvm.PlatformType", "chainPushManager", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/push/WikiChainPushManager;", "callbackMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "doFavoriteObserver", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/DoFavoriteEvent;", "doPinObserver", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/DoPinEvent;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "getChainPushUuid", "spaceId", "registerWikiPush", "callbackPushMsg", WikiFolderPushPlugin.PUSH_MSG, "onDetachFromHost", "Companion", "WikiFolderPushHandler", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiFolderPushPlugin extends DocumentPlugin {
    public static final String BLOCK_ID = "blockId";
    public static final a Companion = null;
    public static final String DATA = "data";
    public static final String OPT = "operation";
    public static final int OPT_ADD = 1;
    public static final int OPT_REMOVE = 0;
    public static final String PIN = "Pin";
    public static final String PUSH_MSG = "pushMsg";
    public static final String STAR = "Star";
    public static final String TAG = "WikiFolderPushPlugin";
    public static final String UNPIN = "Unpin";
    public static final String UNSTAR = "Unstar";
    public static final String WIKI_TOKEN = "wikiToken";
    private ConcurrentHashMap<String, tb5.m> callbackMap;
    private final cr5.a chainPushManager;
    private Observer<com.bytedance.ee.bear.wikiv2.wikitreev2.b> doFavoriteObserver;
    private Observer<com.bytedance.ee.bear.wikiv2.wikitreev2.d> doPinObserver;
    private final String mHashCode;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<BlockInfo> {
        public final /* synthetic */ WikiFolderPushPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(WikiFolderPushPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r4, tb5.m r5) {
            BlockInfo r6 = (BlockInfo) r4;
            if (r5 != null) goto L21;
            tt5.a.k(WikiFolderPushPlugin.TAG, "WikiFolderPushHandler callback is null, return");
            return;
        L21:
            BlockInfo.Companion.getClass();     // Catch: Exception -> L17
            if (BlockInfo.a.a(r6) == false) goto L20;
            if (r6 == null) goto L20;
            if (r6.getBlockId() == null) goto L20;
            if (1 != r6.getOpt()) goto L14;
            WikiFolderPushPlugin.access$getCallbackMap$p(this.a).put(r6.getBlockId(), r5);     // Catch: Exception -> L17
            WikiFolderPushPlugin.access$registerWikiPush(this.a, r6.getSpaceId());     // Catch: Exception -> L17
            goto L20
        L14:
            if (r6.getOpt() != 0) goto L20;
            WikiFolderPushPlugin.access$getCallbackMap$p(this.a).remove(r6.getBlockId());     // Catch: Exception -> L17
        L20:
            return;
        L17:
            e = move-exception;
            tt5.a.d(WikiFolderPushPlugin.TAG, "WikiFolderPushHandler fail: " + e.getMessage());
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ WikiFolderPushPlugin a;

        public c(WikiFolderPushPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            com.bytedance.ee.bear.wikiv2.wikitreev2.b r7 = (com.bytedance.ee.bear.wikiv2.wikitreev2.b) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            tt5.a.h(WikiFolderPushPlugin.TAG, "onFavChange token is " + du5.b.g(r7.b) + " isFav is " + r7.c);     // Catch: Exception -> L9
            JSONObject r1 = new JSONObject();     // Catch: Exception -> L9
            JSONObject r2 = new JSONObject();     // Catch: Exception -> L9
            r2.put(WikiFolderPushPlugin.WIKI_TOKEN, r7.b);     // Catch: Exception -> L9
            r1.put(WikiFolderPushPlugin.DATA, r2);     // Catch: Exception -> L9
            if (r7.c == false) goto L6;
            String r8 = WikiFolderPushPlugin.STAR;
        L7:
            r1.put(WikiFolderPushPlugin.OPT, r8);     // Catch: Exception -> L9
            WikiFolderPushPlugin.access$callbackPushMsg(this.a, r1.toString());     // Catch: Exception -> L9
            return;
        L6:
            r8 = WikiFolderPushPlugin.UNSTAR;
        L9:
            e = move-exception;
            tt5.a.d(WikiFolderPushPlugin.TAG, e.getMessage());
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ WikiFolderPushPlugin a;

        public d(WikiFolderPushPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            com.bytedance.ee.bear.wikiv2.wikitreev2.d r7 = (com.bytedance.ee.bear.wikiv2.wikitreev2.d) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            tt5.a.h(WikiFolderPushPlugin.TAG, "onPinChange token is " + du5.b.g(r7.b) + " isPin is " + r7.c);     // Catch: Exception -> L9
            JSONObject r1 = new JSONObject();     // Catch: Exception -> L9
            JSONObject r2 = new JSONObject();     // Catch: Exception -> L9
            r2.put(WikiFolderPushPlugin.WIKI_TOKEN, r7.b);     // Catch: Exception -> L9
            r1.put(WikiFolderPushPlugin.DATA, r2);     // Catch: Exception -> L9
            if (r7.c == false) goto L6;
            String r8 = WikiFolderPushPlugin.PIN;
        L7:
            r1.put(WikiFolderPushPlugin.OPT, r8);     // Catch: Exception -> L9
            WikiFolderPushPlugin.access$callbackPushMsg(this.a, r1.toString());     // Catch: Exception -> L9
            return;
        L6:
            r8 = WikiFolderPushPlugin.UNPIN;
        L9:
            e = move-exception;
            tt5.a.d(WikiFolderPushPlugin.TAG, e.getMessage());
        }
    }

    public static final class e implements cr5.d.b {
        public final /* synthetic */ WikiFolderPushPlugin a;

        public e(WikiFolderPushPlugin r1) {
            this.a = r1;
        }

        @Override // cr5.d.b
        public final void a(String r2) {
            WikiFolderPushPlugin.access$callbackPushMsg(this.a, r2);
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WikiFolderPushPlugin() {
        this.mHashCode = Integer.toHexString(hashCode());
        this.chainPushManager = new cr5.a();
        this.callbackMap = new ConcurrentHashMap();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getCallbackMap$p(WikiFolderPushPlugin r0) {
        return r0.callbackMap;
    }

    private final void callbackPushMsg(String r7) {
        tt5.a.h(TAG, "receive push msg");
        Iterator<T> r0 = this.callbackMap.keySet().iterator();     // Catch: Exception -> L14
    L5:
        if (r0.hasNext() == false) goto L24;
        String r2 = (String) r0.next();     // Catch: Exception -> L14
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L14
        r3.put(BLOCK_ID, r2);     // Catch: Exception -> L14
        if (r7 != null) goto L9;
        String r5 = "";
    L10:
        r3.put(PUSH_MSG, r5);     // Catch: Exception -> L14
        tb5.m r4 = this.callbackMap.get(r2);     // Catch: Exception -> L14
        if (r4 == null) goto L5;
        r4.onCallBack(r3.toString());     // Catch: Exception -> L14
        goto L5
    L9:
        r5 = r7;
        goto L10
    L24:
        return;
    L14:
        e = move-exception;
        tt5.a.d(TAG, e.getMessage());
    }

    private final String getChainPushUuid(String r3) {
        return this.mHashCode + '#' + r3;
    }

    private final void registerWikiPush(String r6) {
        if (r6 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        this.chainPushManager.a(r6, getChainPushUuid(r6), TAG, new cr5.d.c());
        cr5.a r1 = this.chainPushManager;
        e r2 = new e(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "spaceId");
        Intrinsics.checkNotNullParameter(r2, "handler");
        cr5.d r3 = r1.c.get(r6);
        tt5.a.h(r1.a, "setChainPushRawHandler, spaceId=" + r6 + ", wikiPush=" + r3);
        if (r3 == null) goto L14;
        r3.f = r2;
        return;
    L14:
        return;
    L4:
        if (r6.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public void onAttachToHost(DocumentPluginHost r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r4);
        tt5.a.h(TAG, "onAttachToHost, bindBridgeHandler");
        cr5.a r5 = this.chainPushManager;
        int r0 = qc5.a.a;
        ce5.a r1 = new ce5.a();
        Intrinsics.checkNotNullParameter(r1, "userComponentAbility");
        boolean r2 = r1.d.isCurrentEnable("ccm.workspace.folder_block_enable");
        tt5.a.h("SpaceFeatureGatingV2", "isWikiFolderBlockEnable()...enable = " + r2);
        r5.b = r2;
        bindBridgeHandler("biz.wiki.registerPush", new b(this));
        c r6 = new c(this);
        this.doFavoriteObserver = r6;
        this.doPinObserver = new d(this);
        WikiTreeObserver.b().a(r6);
        Observer<com.bytedance.ee.bear.wikiv2.wikitreev2.d> r7 = this.doPinObserver;
        if (r7 == null) goto L6;
        WikiTreeObserver.d.a(r7);
        return;
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        ConcurrentHashMap<String, tb5.m> r3 = this.callbackMap;
        if (r3 == null) goto L5;
        r3.clear();
    L5:
        Observer<com.bytedance.ee.bear.wikiv2.wikitreev2.b> r4 = this.doFavoriteObserver;
        if (r4 == null) goto L8;
        WikiTreeObserver.b().d(r4);
    L8:
        Observer<com.bytedance.ee.bear.wikiv2.wikitreev2.d> r5 = this.doPinObserver;
        if (r5 == null) goto L12;
        WikiTreeObserver.d.d(r5);
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$callbackPushMsg(WikiFolderPushPlugin r0, String r1) {
        r0.callbackPushMsg(r1);
    }

    public static final /* synthetic */ void access$registerWikiPush(WikiFolderPushPlugin r0, String r1) {
        r0.registerWikiPush(r1);
    }
}
