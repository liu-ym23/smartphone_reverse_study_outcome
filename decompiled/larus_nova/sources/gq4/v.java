package gq4;

import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class v implements com.bytedance.ee.bear.share.export.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DocumentPluginHost f482175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.document.orientation.p f482176b;

    public static final class a {
    }

    public static final class b<P extends com.bytedance.ee.bear.browser.plugin.f> implements com.bytedance.ee.bear.browser.plugin.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f482177a;

        public b(v r100) {
            this.f482177a = r100;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.g
        public final void a(com.bytedance.ee.bear.browser.plugin.f r100) {
            BaseUnspecifiedOrientationPlugin r101 = (BaseUnspecifiedOrientationPlugin) r100;
            Intrinsics.checkNotNullParameter(r101, CloudControlInf.PLUGIN);
            r101.onOrientationSupportPanelDismiss(this.f482177a.f482176b);
        }
    }

    public static final class c<P extends com.bytedance.ee.bear.browser.plugin.f> implements com.bytedance.ee.bear.browser.plugin.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f482178a;

        public c(v r100) {
            this.f482178a = r100;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.g
        public final void a(com.bytedance.ee.bear.browser.plugin.f r100) {
            BaseUnspecifiedOrientationPlugin r101 = (BaseUnspecifiedOrientationPlugin) r100;
            Intrinsics.checkNotNullParameter(r101, CloudControlInf.PLUGIN);
            r101.onOrientationSupportPanelShowing(this.f482178a.f482176b);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.export.e
    public final void onDestory() {
        tt5.a.b("SimpleShareFragmentLifeCycle", "onDestory");
        DocumentPluginHost r100 = this.f482175a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f482176b == null) goto L9;
        r100.findPluginToDo(BaseUnspecifiedOrientationPlugin.class, new b(this));
        return;
    }

    @Override // com.bytedance.ee.bear.share.export.e
    public final void onResume() {
        tt5.a.b("SimpleShareFragmentLifeCycle", "onResume");
    }

    @Override // com.bytedance.ee.bear.share.export.e
    public final void onViewCreated() {
        tt5.a.b("SimpleShareFragmentLifeCycle", "onViewCreated");
        DocumentPluginHost r100 = this.f482175a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f482176b == null) goto L9;
        r100.findPluginToDo(BaseUnspecifiedOrientationPlugin.class, new c(this));
        return;
    }

    @Override // com.bytedance.ee.bear.share.export.e
    public final void b(com.bytedance.ee.bear.share.export.d r100) {
        Intrinsics.checkNotNullParameter(r100, "iShareFragmentHost");
        tt5.a.b("SimpleShareFragmentLifeCycle", "onAttach");
    }

    public v(DocumentPluginHost r100, com.bytedance.ee.bear.document.orientation.p r101) {
        this.f482175a = r100;
        this.f482176b = r101;
    }
}
