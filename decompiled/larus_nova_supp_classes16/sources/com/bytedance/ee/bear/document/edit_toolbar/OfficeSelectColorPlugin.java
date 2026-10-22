package com.bytedance.ee.bear.document.edit_toolbar;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.core.toolbar.selectcolor.impl.SelectColorV2ViewModel;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import java.util.Objects;
import tb5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeSelectColorPlugin extends DocumentPluginV3 implements BaseSelectColorPlugin<ChameleonPluginHost> {
    private static final String TAG = "SelectColorV2Plugin";
    private ix4.b highlightHandle;
    private BaseSelectColorPlugin.a showHighlightDelegate;
    private Boolean toolbarV2Mode;

    public class a implements ix4.b.a {
        public final /* synthetic */ OfficeSelectColorPlugin a;

        public final FragmentManager a() {
            return this.a.getHost().getActivity().getSupportFragmentManager();
        }

        public a(OfficeSelectColorPlugin r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void init() {
        this.highlightHandle = new ix4.b(new a(this));
    }

    public OfficeSelectColorPlugin() {
        init();
    }

    public OfficeSelectColorPlugin(Boolean r1) {
        this.toolbarV2Mode = r1;
        init();
    }

    public static /* synthetic */ Boolean access$100(OfficeSelectColorPlugin r0) {
        return r0.toolbarV2Mode;
    }

    public static /* synthetic */ BaseSelectColorPlugin.a access$200(OfficeSelectColorPlugin r0) {
        return r0.showHighlightDelegate;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.navigation.setHighlightPanel", this.highlightHandle);
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseSelectColorPlugin
    public void setShowHighlightDelegate(BaseSelectColorPlugin.a r1) {
        this.showHighlightDelegate = r1;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    public void onAttachToUIContainer(ChameleonPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        SelectColorV2ViewModel r4 = (SelectColorV2ViewModel) q.c(getHost(), SelectColorV2ViewModel.class, null);
        ix4.b r5 = this.highlightHandle;
        Objects.requireNonNull(r5);
        r4.setDelegate(new g(r5));
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseSelectColorPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Fragment access$000(OfficeSelectColorPlugin r0, Class r1, Bundle r2) {
        return r0.instantiateFragment(r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseSelectColorPlugin
    public void processItemClick(Highlight.ColorItem r2, Highlight.ColorItem r3, Highlight.ColorItem r4, Highlight.ColorItem r5) {
        this.highlightHandle.a(r2, r3, r4, r5);
    }
}
