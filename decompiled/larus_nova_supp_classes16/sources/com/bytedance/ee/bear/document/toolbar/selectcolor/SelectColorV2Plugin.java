package com.bytedance.ee.bear.document.toolbar.selectcolor;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.edit_toolbar.BaseSelectColorPlugin;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorV2ViewModel;
import java.util.Map;
import java.util.Objects;
import l45.b;
import tb5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorV2Plugin extends DocumentPluginV2 implements BaseSelectColorPlugin<PluginHost> {
    private static final String TAG = "SelectColorV2Plugin";
    private b highlightHandle;
    private k45.a selectorModule;
    private BaseSelectColorPlugin.a showHighlightDelegate;
    private Boolean toolbarV2Mode;

    public class a implements b.a {
        public final /* synthetic */ SelectColorV2Plugin a;

        @Override // l45.b.a
        public final void isAnnounceDoc() {
        }

        @Override // l45.b.a
        public final Boolean b() {
            return SelectColorV2Plugin.access$100(this.a);
        }

        @Override // l45.b.a
        public final FragmentManager getFragmentManager() {
            return this.a.getHost().getActivity().getSupportFragmentManager();
        }

        @Override // l45.b.a
        public final f getPlugin() {
            return this.a;
        }

        public a(SelectColorV2Plugin r1) {
            this.a = r1;
        }

        @Override // l45.b.a
        public final boolean c(Highlight r2) {
            if (SelectColorV2Plugin.access$200(this.a) == null) goto L6;
            SelectColorV2Plugin.access$200(this.a).a(r2);
            return true;
        L6:
            return false;
        }

        @Override // l45.b.a
        public final <F extends Fragment> F a(Class<F> r2, Bundle r3) {
            return (F) SelectColorV2Plugin.access$000(this.a, r2, r3);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void init() {
        this.selectorModule = new k45.a();
        this.highlightHandle = new b(new a(this));
    }

    public SelectColorV2Plugin() {
        init();
    }

    public SelectColorV2Plugin(Boolean r1) {
        this.toolbarV2Mode = r1;
        init();
    }

    public static /* synthetic */ Boolean access$100(SelectColorV2Plugin r0) {
        return r0.toolbarV2Mode;
    }

    public static /* synthetic */ BaseSelectColorPlugin.a access$200(SelectColorV2Plugin r0) {
        return r0.showHighlightDelegate;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.navigation.setHighlightPanel", this.highlightHandle);
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseSelectColorPlugin
    public void setShowHighlightDelegate(BaseSelectColorPlugin.a r1) {
        this.showHighlightDelegate = r1;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        SelectColorV2ViewModel r4 = (SelectColorV2ViewModel) q.c(getHost(), SelectColorV2ViewModel.class, null);
        final b r5 = this.highlightHandle;
        Objects.requireNonNull(r5);
        r4.setDelegate(new k45.b(r5));
    }

    public static /* synthetic */ Fragment access$000(SelectColorV2Plugin r0, Class r1, Bundle r2) {
        return r0.instantiateFragment(r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseSelectColorPlugin
    public void processItemClick(Highlight.ColorItem r2, Highlight.ColorItem r3, Highlight.ColorItem r4, Highlight.ColorItem r5) {
        this.highlightHandle.a(r2, r3, r4, r5);
    }
}
