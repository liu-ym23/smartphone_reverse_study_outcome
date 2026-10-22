package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/document/RnSyncPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "contentCallback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "commentCallback", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onDetachFromHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RnSyncPlugin extends DocumentPlugin {
    private static final String BIZ_COMMENT_ON_MESSAGE = null;
    private static final String BIZ_RN_BASE = null;
    private static final String BIZ_RN_HANDLEMESSAGE = null;
    public static final a Companion = null;
    private static final String TAG = "RnSyncPlugin";
    private tb5.m commentCallback;
    private tb5.m contentCallback;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements tb5.i {
        public final /* synthetic */ RnSyncPlugin a;

        public b(RnSyncPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, tb5.m r5) {
            String r6 = (String) r4;
            if (RnSyncPlugin.access$getContentCallback$p(this.a) == null) goto L5;
            RnSyncPlugin r7 = this.a;
            com.bytedance.ee.bear.rn.j r2 = (com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6);
            tb5.m r8 = RnSyncPlugin.access$getContentCallback$p(r7);
            Intrinsics.checkNotNull(r8);
            r2.p(r8);
        L5:
            if (r5 == null) goto L7;
            tt5.a.h(RnSyncPlugin.TAG, "rn handleMessage callback: " + r5.hashCode());
            ((com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6)).j(r5);
        L7:
            RnSyncPlugin.access$setContentCallback$p(this.a, r5);
        }
    }

    public static final class c<T> implements tb5.i {
        public final /* synthetic */ RnSyncPlugin a;

        public c(RnSyncPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, tb5.m r5) {
            String r6 = (String) r4;
            if (RnSyncPlugin.access$getCommentCallback$p(this.a) == null) goto L5;
            RnSyncPlugin r7 = this.a;
            com.bytedance.ee.bear.rn.j r2 = (com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6);
            tb5.m r8 = RnSyncPlugin.access$getCommentCallback$p(r7);
            Intrinsics.checkNotNull(r8);
            r2.o(r8);
        L5:
            if (r5 == null) goto L7;
            ((com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6)).k(r5);
        L7:
            RnSyncPlugin.access$setCommentCallback$p(this.a, r5);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    static {
        Companion = new a();
        BIZ_RN_BASE = "biz.rn.";
        BIZ_RN_HANDLEMESSAGE = "biz.rn.handleMessage";
        BIZ_COMMENT_ON_MESSAGE = "biz.comment.onMessage";
    }

    public RnSyncPlugin() {
    }

    public static final /* synthetic */ String access$getBIZ_COMMENT_ON_MESSAGE$cp() {
        return BIZ_COMMENT_ON_MESSAGE;
    }

    public static final /* synthetic */ String access$getBIZ_RN_HANDLEMESSAGE$cp() {
        return BIZ_RN_HANDLEMESSAGE;
    }

    public static final /* synthetic */ tb5.m access$getCommentCallback$p(RnSyncPlugin r0) {
        return r0.commentCallback;
    }

    public static final /* synthetic */ tb5.m access$getContentCallback$p(RnSyncPlugin r0) {
        return r0.contentCallback;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(BIZ_RN_HANDLEMESSAGE, new b(this));
        r3.put(BIZ_COMMENT_ON_MESSAGE, new c(this));
    }

    public void onDetachFromHost(DocumentPluginHost r4) {
        super.onDetachFromHost(r4);
        if (this.contentCallback == null) goto L6;
        com.bytedance.ee.bear.rn.j r5 = (com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6);
        tb5.m r2 = this.contentCallback;
        Intrinsics.checkNotNull(r2);
        r5.p(r2);
    L6:
        if (this.commentCallback == null) goto L9;
        com.bytedance.ee.bear.rn.j r6 = (com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6);
        tb5.m r0 = this.commentCallback;
        Intrinsics.checkNotNull(r0);
        r6.o(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$setCommentCallback$p(RnSyncPlugin r0, tb5.m r1) {
        r0.commentCallback = r1;
    }

    public static final /* synthetic */ void access$setContentCallback$p(RnSyncPlugin r0, tb5.m r1) {
        r0.contentCallback = r1;
    }
}
