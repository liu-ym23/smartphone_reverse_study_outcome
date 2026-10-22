package com.bytedance.ee.bear.document;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.insets.WindowInsetsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0015\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/document/FullScreenPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "lastNavigationBarColor", "", "isFixedFullscreenPreRPadding", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "handleSetFullscreen", "data", "Lcom/bytedance/ee/bear/document/FullScreenPlugin$SetFullscreenData;", "handlePreRFullscreenPadding", "isFullscreen", "onDetachFromHost", "onDetachFromUIContainer", "Companion", "SetFullscreenHandler", "SetFullscreenData", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullScreenPlugin extends DocumentPlugin {
    public static final a Companion = null;
    private static final String SET_FULLSCREEN = null;
    private static final String TAG = null;
    private boolean isFixedFullscreenPreRPadding;
    private int lastNavigationBarColor;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/FullScreenPlugin$SetFullscreenData;", "Lcom/bytedance/ee/util/io/NonProguard;", "enable", "", "<init>", "(Z)V", "getEnable", "()Z", "setEnable", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SetFullscreenData implements NonProguard {
        private boolean enable;

        public SetFullscreenData() {
            boolean r2 = false;
            this(r2, 1, null);
        }

        public static /* synthetic */ SetFullscreenData copy$default(SetFullscreenData r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.enable;
        L6:
            return r0.copy(r1);
        }

        public final boolean component1() {
            return this.enable;
        }

        public final SetFullscreenData copy(boolean r2) {
            return new SetFullscreenData(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof SetFullscreenData) == true) goto L9;
            return false;
        L9:
            if (this.enable == ((SetFullscreenData) r4).enable) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            if (this.enable == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public String toString() {
            return "SetFullscreenData(enable=" + this.enable + ')';
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public SetFullscreenData(boolean r1) {
            this.enable = r1;
        }

        public final void setEnable(boolean r1) {
            this.enable = r1;
        }

        public /* synthetic */ SetFullscreenData(boolean r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = false;
        L5:
            this(r1);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<SetFullscreenData> {
        public final /* synthetic */ FullScreenPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(FullScreenPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            SetFullscreenData r5 = (SetFullscreenData) r3;
            FullScreenPlugin.Companion.getClass();
            tt5.a.h(FullScreenPlugin.access$getTAG$cp(), "SetFullscreenHandler handle: " + r5);
            if (r5 != null) goto L5;
            tt5.a.d(FullScreenPlugin.access$getTAG$cp(), "SetFullscreenHandler: data is null");
            return;
        L5:
            this.a.handleSetFullscreen(r5);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ FullScreenPlugin a;
        public final /* synthetic */ boolean b;

        public c(FullScreenPlugin r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FullScreenPlugin.access$handlePreRFullscreenPadding(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    static {
        Companion = new a();
        TAG = "FullScreenPlugin";
        SET_FULLSCREEN = "biz.util.setFullscreen";
    }

    public FullScreenPlugin() {
    }

    public static final /* synthetic */ String access$getSET_FULLSCREEN$cp() {
        return SET_FULLSCREEN;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    private final void handlePreRFullscreenPadding(boolean r11) {
        String r1 = TAG;
        tt5.a.h(r1, "handlePreRFullscreenPadding: isFullscreen=" + r11);
    L40:
        e = move-exception;
        tt5.a.d(TAG, "handlePreRFullscreenPadding error: e=" + e);
        return;
    L4:
        if (getActivity() != null) goto L8;
        tt5.a.d(r1, "handlePreRFullscreenPadding: activity is null");     // Catch: Exception -> L40
        return;
    L8:
        if (Build.VERSION.SDK_INT >= 23) goto L12;
        tt5.a.h(r1, "handlePreRFullscreenPadding: only support on Android M and above");     // Catch: Exception -> L40
        return;
    L12:
        if (isUIContainerDetached() == false) goto L15;
        tt5.a.h(r1, "handlePreRFullscreenPadding: isUIContainerDetached, skip padding adjustment");     // Catch: Exception -> L40
        return;
    L15:
        ViewGroup r2 = (ViewGroup) getActivity().findViewById(R.id.content);     // Catch: Exception -> L40
        if (r2 == null) goto L44;
        WindowInsets r4 = r2.getRootWindowInsets();     // Catch: Exception -> L40
        if (r4 == null) goto L45;
        WindowInsetsCompat r5 = WindowInsetsCompat.toWindowInsetsCompat(r4);     // Catch: Exception -> L40
        int r7 = 0;
        if (r4.getSystemWindowInsetTop() <= 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L26;
        tt5.a.h(r1, "handlePreRFullscreenPadding: hasTopInset=false, skip padding adjustment");     // Catch: Exception -> L40
        return;
    L26:
        tt5.a.h(r1, "handlePreRFullscreenPadding: hasTopInset=true, top=" + r4.getSystemWindowInsetTop() + ", will adjust padding");     // Catch: Exception -> L40
        if (r11 == true) goto L29;
        int r0 = ((WindowInsetsCompat.Type.statusBars() | 0) | WindowInsetsCompat.Type.captionBar()) | WindowInsetsCompat.Type.navigationBars();     // Catch: Exception -> L40
    L30:
        Insets r3 = r5.getInsets(r0 | WindowInsetsCompat.Type.ime());     // Catch: Exception -> L40
        int r8 = r3.left;     // Catch: Exception -> L40
        if (r11 == false) goto L33;
        int r9 = 0;
    L34:
        r2.setPadding(r8, r9, r3.right, r3.bottom);     // Catch: Exception -> L40
        StringBuilder r10 = new StringBuilder("handlePreRFullscreenPadding: isFullscreen=");     // Catch: Exception -> L40
        r10.append(r11);     // Catch: Exception -> L40
        r10.append(", topPadding=");     // Catch: Exception -> L40
        if (r11 == true) goto L38;
        r7 = r3.top;     // Catch: Exception -> L40
    L38:
        r10.append(r7);     // Catch: Exception -> L40
        r10.append(", hasTopInset=");     // Catch: Exception -> L40
        r10.append(r6);     // Catch: Exception -> L40
        tt5.a.h(r1, r10.toString());     // Catch: Exception -> L40
        return;
    L33:
        r9 = r3.top;     // Catch: Exception -> L40
        goto L34
    L29:
        r0 = 0;
        goto L30
    L22:
        r6 = false;
        goto L23
    L45:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handleSetFullscreen(SetFullscreenData r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        String r0 = TAG;
        tt5.a.h(r0, "SetFullscreenHandler handle: " + r7);
        boolean r8 = r7.getEnable();
        tt5.a.h(r0, "fullscreenPlugin Fullscreen state changed: " + r8);
        Fragment r1 = ((DocumentPluginHost) getHost()).getHostFragment();
        if (r1 != null) goto L5;
    L14:
        com.ss.android.lark.insets.f r2 = WindowInsetsUtils.c(getActivity());
        tt5.a.h(r0, "fullscreenPlugin onViewCreated: !isInForseti");
        boolean r3 = !r8;
        r2.c(r3);
        r2.f(r3);
        if (this.isFixedFullscreenPreRPadding == true) goto L17;
    L23:
        r2.o(!r8);
        if (r8 == false) goto L26;
        this.lastNavigationBarColor = r2.a();
        r2.i(0);
        r2.b(0);
        return;
    L26:
        int r9 = this.lastNavigationBarColor;
        if (r9 == 0) goto L31;
        r2.i(r9);
        r2.b(this.lastNavigationBarColor);
        return;
    L31:
        return;
    L17:
        if (Build.VERSION.SDK_INT >= 30) goto L23;
        DocumentPluginHost r4 = (DocumentPluginHost) getHost();
        if (r4 == null) goto L23;
        View r5 = r4.getContentView();
        if (r5 == null) goto L23;
        r5.post(new c(this, r8));
        goto L23
    L5:
        if (ForsetiHelper.s(r1) == false) goto L14;
        r2 = WindowInsetsUtils.b(r1);
        View r6 = ((DocumentPluginHost) getHost()).getContentView();
        if (r6.getRootView() == null) goto L23;
        View r10 = r6.getRootView().findViewById(2131387279);
        tt5.a.h(r0, "fullscreenPlugin onViewCreated: isInForseti , statusBarFiller: " + r10);
        if (r10 == null) goto L23;
        if (r8 == false) goto L12;
        int r11 = 8;
    L13:
        r10.setVisibility(r11);
        goto L23
    L12:
        r11 = 0;
        goto L13
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super.onAttachToHost(r2);
        this.isFixedFullscreenPreRPadding = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.fix_fullscreen_pre_r_padding");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public void onDetachFromHost(DocumentPluginHost r1) {
        super.onDetachFromHost(r1);
    }

    public static final /* synthetic */ void access$handlePreRFullscreenPadding(FullScreenPlugin r0, boolean r1) {
        r0.handlePreRFullscreenPadding(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onAttachToUIContainer(r1, r2);
        tt5.a.h(TAG, "onAttachToUIContainer");
        bindBridgeHandler(SET_FULLSCREEN, new b(this));
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        tt5.a.h(TAG, "onDetachFromUIContainer");
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
}
