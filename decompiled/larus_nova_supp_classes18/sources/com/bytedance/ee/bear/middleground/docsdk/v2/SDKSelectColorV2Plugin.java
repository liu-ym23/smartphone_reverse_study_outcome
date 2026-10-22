package com.bytedance.ee.bear.middleground.docsdk.v2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorV2ViewModel;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.EditorSdkPluginHost;
import java.util.Map;
import tb5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SDKSelectColorV2Plugin extends AbsEditorSdkPlugin {
    private l45.b highlightHandle;
    private k45.a selectorModule;

    public class a implements l45.b.a {
        public final /* synthetic */ SDKSelectColorV2Plugin a;

        public final boolean c(Highlight r1) {
            return false;
        }

        public final void isAnnounceDoc() {
        }

        public final FragmentManager getFragmentManager() {
            return this.a.getHost().getActivity().getSupportFragmentManager();
        }

        public final Boolean b() {
            return Boolean.FALSE;
        }

        public final f getPlugin() {
            return this.a;
        }

        public a(SDKSelectColorV2Plugin r1) {
            this.a = r1;
        }

        public final <F extends Fragment> F a(Class<F> r2, Bundle r3) {
            return (F) SDKSelectColorV2Plugin.access$000(this.a, r2, r3);
        }
    }

    public static /* synthetic */ void a(SDKSelectColorV2Plugin r0, Highlight.ColorItem r1, Highlight.ColorItem r2, Highlight.ColorItem r3, Highlight.ColorItem r4) {
        r0.lambda$onAttachToUIContainer$0(r1, r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void init() {
        this.selectorModule = new k45.a();
        this.highlightHandle = new l45.b(new a(this));
    }

    public SDKSelectColorV2Plugin() {
        init();
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.navigation.setHighlightPanel", this.highlightHandle);
    }

    public void onAttachToUIContainer(EditorSdkPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        q.c(getHost(), SelectColorV2ViewModel.class, null).setDelegate(new b(this));
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((EditorSdkPluginHost) r1, r2);
    }

    public static /* synthetic */ Fragment access$000(SDKSelectColorV2Plugin r0, Class r1, Bundle r2) {
        return r0.instantiateFragment(r1, r2);
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0(Highlight.ColorItem r2, Highlight.ColorItem r3, Highlight.ColorItem r4, Highlight.ColorItem r5) {
        this.highlightHandle.a(r2, r3, r4, r5);
    }
}
