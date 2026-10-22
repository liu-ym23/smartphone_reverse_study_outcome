package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz;

import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.api.ui.g;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/ForsetiPlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "sourceFragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "pageViewTypeListener", "com/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/ForsetiPlugin$pageViewTypeListener$1", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/ForsetiPlugin$pageViewTypeListener$1;", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "Companion", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiPlugin extends AbsChameleonPlugin {
    public static final a Companion = null;
    public static final String TAG = "CML_TAG_ForsetiPlugin";
    private final b pageViewTypeListener;
    private final Fragment sourceFragment;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForsetiPlugin f411202a;

        public b(ForsetiPlugin r100) {
            this.f411202a = r100;
        }

        @Override // com.ss.android.lark.api.ui.g
        public final void a(ForsetiPageViewType r100) {
            Intrinsics.checkNotNullParameter(r100, "pageViewType");
            j.e(ForsetiPlugin.TAG, "pageViewType: " + r100);
            ChameleonPluginHost r101 = this.f411202a.getHost();
            ChameleonConfig r102 = null;
            if (r101 == null) goto L7;
            k r103 = r101.getWeb();
            if (r103 == null) goto L7;
            WebView r104 = r103.getWebView();
        L9:
            if ((r104 instanceof ChameleonWebView) == false) goto L11;
            ChameleonWebView r105 = (ChameleonWebView) r104;
        L12:
            if (r105 == null) goto L14;
            r102 = r105.getChameleonConfig();
        L14:
            if (r102 == null) goto L28;
            OpenConfig r106 = r102.getOpenConfig();
            if (r106 != null) goto L18;
            return;
        L18:
            if (r100 != ForsetiPageViewType.MODAL_R_VIEW) goto L20;
        L25:
            boolean r107 = true;
        L26:
            r106.setModelView(r107);
            return;
        L20:
            if (r100 == ForsetiPageViewType.MODAL_C_HALF_VIEW) goto L25;
            if (r100 == ForsetiPageViewType.POPOVER_R_VIEW) goto L25;
            r107 = false;
            goto L26
        L28:
            return;
        L11:
            r105 = null;
        L7:
            r104 = null;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public ForsetiPlugin(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "sourceFragment");
        this.sourceFragment = r100;
        this.pageViewTypeListener = new b(this);
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        super.onAttachToHost(r100);
        sua.a r101 = (sua.a) swb.a.a(sua.a.class);
        ForsetiPageViewType r102 = null;
        if (r101 == null) goto L5;
        tua.b r103 = r101.tryGetChainManager(this.sourceFragment.getActivity());
    L6:
        if (r100 == null) goto L15;
        Fragment r104 = r100.getFragment();
        if (r104 == null) goto L16;
        if (r103 == null) goto L11;
        r102 = r103.w(r104);
    L11:
        j.e(TAG, "type: " + r102);
        if (r103 == null) goto L17;
        r103.z(r104, this.pageViewTypeListener);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        super.onDetachFromHost(r100);
        if (r100 == null) goto L13;
        Fragment r101 = r100.getFragment();
        if (r101 == null) goto L14;
        sua.a r102 = (sua.a) swb.a.a(sua.a.class);
        if (r102 == null) goto L9;
        tua.b r103 = r102.tryGetChainManager(this.sourceFragment.getActivity());
    L10:
        if (r103 == null) goto L15;
        r103.i(r101, this.pageViewTypeListener);
        return;
    L15:
        return;
    L9:
        r103 = null;
        goto L10
    L14:
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }
}
