package com.bytedance.ee.bear.bitable.toast;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u000fH\u0016J\u001c\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toast/BitableToastPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "mShowTipsHandler", "Lcom/bytedance/ee/bear/bitable/toast/BitableToastPlugin$ShowTipsHandler;", "mHideTipsHandler", "Lcom/bytedance/ee/bear/bitable/toast/BitableToastPlugin$HideTipsHandler;", "currentToast", "Lcom/bytedance/ee/bear/bitable/toast/BitableClickableToast;", "pendingToastQueue", "Ljava/util/LinkedList;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onDetachFromUIContainer", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "Companion", "ShowTipsHandler", "HideTipsHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableToastPlugin extends DocumentPlugin {
    private static final String CALLBACK_PARAM_CLOSE_TYPE = "closeType";
    private static final String CALLBACK_PARAM_ID = "id";
    public static final a Companion = null;
    private static final String HIDE_TIPS = "biz.bitable.hideTips";
    private static final String SHOW_TIPS = "biz.bitable.showTips";
    private static final String TAG = "BitableToastPlugin";
    private com.bytedance.ee.bear.bitable.toast.b currentToast;
    private b mHideTipsHandler;
    private c mShowTipsHandler;
    private LinkedList<com.bytedance.ee.bear.bitable.toast.b> pendingToastQueue;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<Void> {
        public final /* synthetic */ BitableToastPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BitableToastPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            Void r4 = (Void) r2;
            tt5.a.h(BitableToastPlugin.TAG, "HideTipsHandler: hide tips.");
            com.bytedance.ee.bear.bitable.toast.b r5 = BitableToastPlugin.access$getCurrentToast$p(this.a);
            if (r5 == null) goto L5;
            j.e(r5.h);
            j.f(new fv4.a(r5));
        L5:
            if (r3 == null) goto L8;
            r3.b(new JSONObject());
            return;
        }
    }

    public final class c implements i<ToastModel> {
        public final /* synthetic */ BitableToastPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(BitableToastPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r10, m r11) {
            ToastModel r12 = (ToastModel) r10;
            tt5.a.h(BitableToastPlugin.TAG, "ShowTipsHandler: show tips.");
            if (r12 == null) goto L24;
            FragmentActivity r3 = BitableToastPlugin.access$getActivity(this.a);
            Integer r4 = r12.getType();
            String r1 = r12.getContent();
            if (r1 != null) goto L8;
            r1 = "";
        L8:
            String r5 = r1;
            String r6 = r12.getConfirmText();
            Long r2 = r12.getDuration();
            if (r2 == null) goto L11;
            long r7 = r2.longValue();
        L12:
            com.bytedance.ee.bear.bitable.toast.b r0 = new com.bytedance.ee.bear.bitable.toast.b(r3, r4, r5, r6, Long.valueOf(r7), new e(r11, r12));
            BitableToastPlugin r13 = this.a;
            r0.i = new d(r13);
            if (BitableToastPlugin.access$getCurrentToast$p(r13) != null) goto L17;
            BitableToastPlugin.access$setCurrentToast$p(this.a, r0);
            com.bytedance.ee.bear.bitable.toast.b r14 = BitableToastPlugin.access$getCurrentToast$p(this.a);
            if (r14 == null) goto L21;
            j.f(new fv4.d(r14));
            return;
        L21:
            return;
        L17:
            BitableToastPlugin.access$getPendingToastQueue$p(this.a).add(r0);
            com.bytedance.ee.bear.bitable.toast.b r16 = BitableToastPlugin.access$getCurrentToast$p(this.a);
            if (r16 == null) goto L23;
            j.e(r16.h);
            j.f(new fv4.a(r16));
            return;
        L23:
            return;
        L11:
            r7 = ToastModel.DEFAULT_DURATION;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public BitableToastPlugin() {
        this.pendingToastQueue = new LinkedList();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(BitableToastPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.bitable.toast.b access$getCurrentToast$p(BitableToastPlugin r0) {
        return r0.currentToast;
    }

    public static final /* synthetic */ LinkedList access$getPendingToastQueue$p(BitableToastPlugin r0) {
        return r0.pendingToastQueue;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        c r0 = new c(this);
        this.mShowTipsHandler = r0;
        this.mHideTipsHandler = new b(this);
        Intrinsics.checkNotNull(r0);
        r3.put(SHOW_TIPS, r0);
        i<?> r1 = this.mHideTipsHandler;
        Intrinsics.checkNotNull(r1);
        r3.put(HIDE_TIPS, r1);
    }

    public static final /* synthetic */ void access$setCurrentToast$p(BitableToastPlugin r0, com.bytedance.ee.bear.bitable.toast.b r1) {
        r0.currentToast = r1;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        com.bytedance.ee.bear.bitable.toast.b r3 = this.currentToast;
        if (r3 == null) goto L5;
        j.e(r3.h);
        j.f(new fv4.a(r3));
    L5:
        Iterator<T> r4 = this.pendingToastQueue.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        com.bytedance.ee.bear.bitable.toast.b.InterfaceC0027b r5 = ((com.bytedance.ee.bear.bitable.toast.b) r4.next()).c;
        if (r5 == null) goto L7;
        r5.onTimeout();
        goto L7
    L11:
        this.pendingToastQueue.clear();
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
