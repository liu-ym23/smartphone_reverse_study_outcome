package com.larus.office.base.plugins.toast;

import android.content.Context;
import android.webkit.WebView;
import androidx.collection.SieveCacheKt;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.document.y5;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.compose.foundation.toast.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0003!\"#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u0011\u001a\u00020\tJC\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/office/base/plugins/toast/ToastPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "currentToast", "Lcom/larksuite/component/universe_design/toast/UDToastImpl;", "getPluginId", "", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "clearToast", "showToast", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "data", "Lcom/larus/office/base/plugins/toast/ToastModel;", "duration", "", "iconResId", "", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "(Landroid/content/Context;Lcom/larus/office/base/plugins/toast/ToastModel;Ljava/lang/Long;Ljava/lang/Integer;Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;)V", "cancelCurrentToast", "successIcon", "warningIcon", "Companion", "ShowToastHandler", "HideToastHandler", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToastPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_HIDE_TOAST = "biz.util.hideToast";
    private static final String BIZ_SHOW_TOAST = "biz.util.showToast";
    public static final a Companion = null;
    private static final String TAG = "ToastPluginV2";
    private com.larksuite.component.universe_design.toast.c currentToast;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<ToastModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToastPluginV2 f360784a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(ToastPluginV2 r100) {
            this.f360784a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            FLogger.f375446a.i(ToastPluginV2.TAG, "Hide toast:" + ((ToastModel) r100));
            ToastPluginV2.access$cancelCurrentToast(this.f360784a);
        }
    }

    public final class c implements i<ToastModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToastPluginV2 f360785a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(ToastPluginV2 r100) {
            this.f360785a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r110) {
            ToastModel r101 = (ToastModel) r100;
            FLogger r102 = FLogger.f375446a;
            r102.i(ToastPluginV2.TAG, "Show toast:" + r101);
            ChameleonPluginHost r103 = this.f360785a.getHost();
            if (r103 == null) goto L7;
            k r104 = r103.getWeb();
            if (r104 == null) goto L7;
            WebView r105 = r104.getWebView();
        L9:
            if (r105 != null) goto L11;
        L13:
            boolean r106 = false;
        L15:
            if (ToastPluginV2.access$isVisibleToUser(this.f360785a) == false) goto L35;
            if (r106 == true) goto L35;
            if (r101 == null) goto L37;
            ToastPluginV2 r107 = this.f360785a;
            if (r101.getDuration() >= 3) goto L22;
            long r108 = -1;
        L23:
            int r109 = r101.getType();
            if (r109 != 1) goto L26;
            ToastPluginV2.showToast$default(r107, ToastPluginV2.access$getContext(r107), r101, Long.valueOf(r108), Integer.valueOf(ToastPluginV2.access$warningIcon(r107)), null, 16, null);
            return;
        L26:
            if (r109 == 2) goto L33;
            if (r109 != 3) goto L29;
            ToastPluginV2.access$showToast(r107, ToastPluginV2.access$getContext(r107), r101, Long.valueOf(r108), Integer.valueOf(ToastPluginV2.access$successIcon(r107)), r110);
            return;
        L29:
            if (r109 == 4) goto L31;
            ToastPluginV2.showToast$default(r107, ToastPluginV2.access$getContext(r107), r101, Long.valueOf(r108), null, null, 24, null);
            return;
        L31:
            ToastPluginV2.showToast$default(r107, ToastPluginV2.access$getContext(r107), r101, Long.valueOf(SieveCacheKt.NodeLinkMask), null, null, 24, null);
            return;
        L33:
            ToastPluginV2.showToast$default(r107, ToastPluginV2.access$getContext(r107), r101, Long.valueOf(r108), Integer.valueOf(R.drawable.larus_toast_failure_icon), null, 16, null);
            return;
        L22:
            r108 = -2;
            goto L23
        L37:
            return;
        L35:
            r102.w(ToastPluginV2.TAG, "Ignore show toast because not visible ");
            return;
        L11:
            if (this.f360785a.getHost().getWeb().getWebView().getWindowVisibility() == 0) goto L13;
            r106 = true;
        L7:
            r105 = null;
            goto L9
        }
    }

    public static final class d implements UDToast.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f360786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ToastPluginV2 f360787b;

        @Override // com.larksuite.component.universe_design.toast.UDToast.b
        public final void a(com.ss.android.lark.compose.foundation.toast.b r100) {
            Intrinsics.checkNotNullParameter(r100, "toast");
            this.f360786a.b(new JSONObject());
            r100.cancel();
            if (ToastPluginV2.access$getCurrentToast$p(this.f360787b) != r100) goto L6;
            ToastPluginV2.access$setCurrentToast$p(this.f360787b, null);
            return;
        }

        public d(m r100, ToastPluginV2 r101) {
            this.f360786a = r100;
            this.f360787b = r101;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void a(ToastPluginV2 r100) {
        cancelCurrentToast$lambda$6(r100);
    }

    public static /* synthetic */ void c(ToastPluginV2 r100, Context r101, ToastModel r102, Long r103, Integer r104, m r105) {
        showToast$lambda$5(r100, r101, r102, r103, r104, r105);
    }

    private final int successIcon() {
        return v19.c.b(R.attr.larus_toast_success_icon, null, R.drawable.larus_toast_success_icon);
    }

    private final int warningIcon() {
        return v19.c.b(R.attr.larus_toast_warning_icon, null, R.drawable.larus_toast_warning_icon);
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final void cancelCurrentToast() {
        t0.e(new cn9.b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public String getPluginId() {
        String r100 = y5.f222532a;
        return y5.f222535d;
    }

    public ToastPluginV2() {
    }

    public final void clearToast() {
        cancelCurrentToast();
    }

    public static final /* synthetic */ void access$cancelCurrentToast(ToastPluginV2 r100) {
        r100.cancelCurrentToast();
    }

    public static final /* synthetic */ Context access$getContext(ToastPluginV2 r100) {
        return r100.getContext();
    }

    public static final /* synthetic */ com.larksuite.component.universe_design.toast.c access$getCurrentToast$p(ToastPluginV2 r100) {
        return r100.currentToast;
    }

    public static final /* synthetic */ boolean access$isVisibleToUser(ToastPluginV2 r100) {
        return r100.isVisibleToUser();
    }

    public static final /* synthetic */ int access$successIcon(ToastPluginV2 r100) {
        return r100.successIcon();
    }

    public static final /* synthetic */ int access$warningIcon(ToastPluginV2 r100) {
        return r100.warningIcon();
    }

    private static final void cancelCurrentToast$lambda$6(ToastPluginV2 r100) {
        com.larksuite.component.universe_design.toast.c r101 = r100.currentToast;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        r100.currentToast = null;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put(BIZ_SHOW_TOAST, new c(this));
        r100.put(BIZ_HIDE_TOAST, new b(this));
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        super.onAttachToHost(r100);
        Lazy r101 = com.larus.office.base.service.m.f361113a;
        com.larus.office.base.service.m.f361118f = new WeakReference(this);
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        super.onDetachFromHost(r100);
        Lazy r101 = com.larus.office.base.service.m.f361113a;
        com.larus.office.base.service.m.f361118f = null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }

    public static final /* synthetic */ void access$setCurrentToast$p(ToastPluginV2 r100, com.larksuite.component.universe_design.toast.c r101) {
        r100.currentToast = r101;
    }

    private final void showToast(final Context r100, final ToastModel r110, final Long r111, final Integer r112, final m r113) {
        if (r100 != null) goto L4;
        return;
    L4:
        t0.e(new cn9.a(this, r100, r110, r111, r112, r113));
    }

    public static final /* synthetic */ void access$showToast(ToastPluginV2 r100, Context r101, ToastModel r102, Long r103, Integer r104, m r105) {
        r100.showToast(r101, r102, r103, r104, r105);
    }

    private static final void showToast$lambda$5(ToastPluginV2 r100, Context r101, ToastModel r102, Long r103, Integer r104, m r105) {
        com.larksuite.component.universe_design.toast.c r106 = r100.currentToast;
        if (r106 == null) goto L5;
        r106.cancel();
    L5:
        UDToast.a r107 = UDToast.build(r101);
        String r108 = r102.getMessage();
        if (r108 == null) goto L8;
        r107.g(r108);
    L8:
        if (r103 == null) goto L10;
        r107.f285429b.f417630d = r103.longValue();
    L10:
        if (r104 == null) goto L12;
        int r109 = r104.intValue();
        FlowToast.a r110 = r107.f285429b;
        r110.f417629c = UDIconUtils.getIconDrawable(r110.f417627a, r109);
    L12:
        String r111 = r102.getButtonMessage();
        if (r111 != null) goto L15;
    L18:
        boolean r112 = true;
    L19:
        if (r112 == true) goto L22;
        if (r105 == null) goto L22;
        r107.c(r111, new d(r105, r100));
    L22:
        g r113 = r107.a();
        r113.show();
        r100.currentToast = r113;
        return;
    L15:
        if (r111.length() == 0) goto L18;
        r112 = false;
        goto L19
    }

    public static /* synthetic */ void showToast$default(ToastPluginV2 r100, Context r101, ToastModel r102, Long r110, Integer r111, m r112, int r113, Object r114) {
        if ((r113 & 4) == 0) goto L5;
        Long r103 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        Integer r104 = null;
    L11:
        if ((r113 & 16) == 0) goto L13;
        m r105 = null;
    L14:
        r100.showToast(r101, r102, r103, r104, r105);
        return;
    L13:
        r105 = r112;
        goto L14
    L9:
        r104 = r111;
        goto L11
    L5:
        r103 = r110;
        goto L7
    }
}
