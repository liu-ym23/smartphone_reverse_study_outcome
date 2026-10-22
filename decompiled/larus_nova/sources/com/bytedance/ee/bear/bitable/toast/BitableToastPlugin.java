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

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableToastPlugin f215971a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BitableToastPlugin r100) {
            this.f215971a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            Void r102 = (Void) r100;
            tt5.a.h(BitableToastPlugin.TAG, "HideTipsHandler: hide tips.");
            com.bytedance.ee.bear.bitable.toast.b r103 = BitableToastPlugin.access$getCurrentToast$p(this.f215971a);
            if (r103 == null) goto L5;
            j.e(r103.f215987h);
            j.f(new fv4.a(r103));
        L5:
            if (r101 == null) goto L8;
            r101.b(new JSONObject());
            return;
        }
    }

    public final class c implements i<ToastModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableToastPlugin f215972a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(BitableToastPlugin r100) {
            this.f215972a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            ToastModel r112 = (ToastModel) r110;
            tt5.a.h(BitableToastPlugin.TAG, "ShowTipsHandler: show tips.");
            if (r112 == null) goto L24;
            FragmentActivity r100 = BitableToastPlugin.access$getActivity(this.f215972a);
            Integer r101 = r112.getType();
            String r102 = r112.getContent();
            if (r102 != null) goto L8;
            r102 = "";
        L8:
            String r103 = r102;
            String r104 = r112.getConfirmText();
            Long r105 = r112.getDuration();
            if (r105 == null) goto L11;
            long r106 = r105.longValue();
        L12:
            com.bytedance.ee.bear.bitable.toast.b r107 = new com.bytedance.ee.bear.bitable.toast.b(r100, r101, r103, r104, Long.valueOf(r106), new e(r111, r112));
            BitableToastPlugin r113 = this.f215972a;
            r107.f215988i = new d(r113);
            if (BitableToastPlugin.access$getCurrentToast$p(r113) != null) goto L17;
            BitableToastPlugin.access$setCurrentToast$p(this.f215972a, r107);
            com.bytedance.ee.bear.bitable.toast.b r114 = BitableToastPlugin.access$getCurrentToast$p(this.f215972a);
            if (r114 == null) goto L21;
            j.f(new fv4.d(r114));
            return;
        L21:
            return;
        L17:
            BitableToastPlugin.access$getPendingToastQueue$p(this.f215972a).add(r107);
            com.bytedance.ee.bear.bitable.toast.b r115 = BitableToastPlugin.access$getCurrentToast$p(this.f215972a);
            if (r115 == null) goto L23;
            j.e(r115.f215987h);
            j.f(new fv4.a(r115));
            return;
        L23:
            return;
        L11:
            r106 = 3000;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public BitableToastPlugin() {
        this.pendingToastQueue = new LinkedList();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(BitableToastPlugin r100) {
        return r100.getActivity();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.bitable.toast.b access$getCurrentToast$p(BitableToastPlugin r100) {
        return r100.currentToast;
    }

    public static final /* synthetic */ LinkedList access$getPendingToastQueue$p(BitableToastPlugin r100) {
        return r100.pendingToastQueue;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        c r101 = new c(this);
        this.mShowTipsHandler = r101;
        this.mHideTipsHandler = new b(this);
        Intrinsics.checkNotNull(r101);
        r100.put(SHOW_TIPS, r101);
        i<?> r102 = this.mHideTipsHandler;
        Intrinsics.checkNotNull(r102);
        r100.put(HIDE_TIPS, r102);
    }

    public static final /* synthetic */ void access$setCurrentToast$p(BitableToastPlugin r100, com.bytedance.ee.bear.bitable.toast.b r101) {
        r100.currentToast = r101;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        com.bytedance.ee.bear.bitable.toast.b r102 = this.currentToast;
        if (r102 == null) goto L5;
        j.e(r102.f215987h);
        j.f(new fv4.a(r102));
    L5:
        Iterator<T> r103 = this.pendingToastQueue.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        com.bytedance.ee.bear.bitable.toast.b.InterfaceC3083b r104 = ((com.bytedance.ee.bear.bitable.toast.b) r103.next()).f215982c;
        if (r104 == null) goto L7;
        r104.onTimeout();
        goto L7
    L11:
        this.pendingToastQueue.clear();
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }
}
