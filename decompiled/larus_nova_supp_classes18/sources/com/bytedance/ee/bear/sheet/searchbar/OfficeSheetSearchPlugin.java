package com.bytedance.ee.bear.sheet.searchbar;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin;
import com.bytedance.ee.bear.document.search.OfficeSearchPlugin;
import com.bytedance.ee.bear.document.search.SearchViewModel;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import hn5.c;
import hn5.d;
import hn5.e;
import java.util.HashMap;
import qm5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeSheetSearchPlugin extends OfficeSearchPlugin implements p {

    public class a extends OfficeSearchPlugin.d {
        public final void b() {
            super.b();
        }

        public a(OfficeSheetSearchPlugin r1) {
            super(r1);
        }

        public final void c(int r1) {
            super.c(r1);
            b.d("change_button");
        }

        public final void d(String r1, boolean r2) {
            super.d(r1, r2);
            if (r2 == false) goto L5;
            String r3 = "return";
        L6:
            b.d(r3);
            return;
        L5:
            r3 = "edit";
            goto L6
        }
    }

    public static /* synthetic */ void c(OfficeSheetSearchPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    public static /* synthetic */ void d(OfficeSheetSearchPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void ensureSearchFragment() {
        SheetSearchToolbarFragment r0 = instantiateFragment(SheetSearchToolbarFragment.class);
        r0.t = new c();
        getUIContainer().i(this, r0);
        b.b("ccm_sheet_search_replace_view", new HashMap());
    }

    public boolean shouldDisableLandscape() {
        SearchViewModel r0 = ((OfficeSearchPlugin) this).searchViewModel;
        if ((r0 instanceof SheetSearchViewModel) == true) goto L5;
        return false;
    L5:
        return ((SheetSearchViewModel) r0).getShouldDisableLandscapeInVc();
    }

    public boolean shouldDisableLandscapeInVc() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 30) goto L8;
        boolean r2 = r0.isInMultiWindowMode();
    L10:
        if (getDocViewModel().getOpenSource() == DocsOpenSource.vc) goto L12;
        return false;
    L12:
        if (ku5.c.k(getContext()) == false) goto L14;
        return false;
    L14:
        if (yo5.a.a(r0) == false) goto L16;
        return false;
    L16:
        if (n.D(r0) == true) goto L23;
        if (r2 == true) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L8:
        r2 = false;
        goto L10
    }

    public OfficeSheetSearchPlugin() {
    }

    public Class<SheetSearchViewModel> getModelClass() {
        return SheetSearchViewModel.class;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(Boolean r3) {
        BaseUnspecifiedOrientationPlugin r0 = findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (Boolean.TRUE.equals(r3) == false) goto L6;
        if (r0 == null) goto L9;
        r0.onOrientationSupportPanelShowing(this);
        return;
    L9:
        return;
    L6:
        if (r0 == null) goto L11;
        r0.onOrientationSupportPanelDismiss(this);
        return;
    }

    private /* synthetic */ void lambda$onAttachToHost$1(Boolean r2) {
        BaseSelectionPlugin r0 = findPlugin(BaseSelectionPlugin.class);
        if (r2.booleanValue() == false) goto L7;
        if (r0 == null) goto L8;
        r0.closeActionMode();
        return;
    L8:
        return;
    }

    public void onAttachToHost(ChameleonPluginHost r3) {
        super.onAttachToHost(r3);
        ((OfficeSearchPlugin) this).searchViewModel.getActive().observe(getLifecycleOwner(), new d(this));
        SearchViewModel r4 = ((OfficeSearchPlugin) this).searchViewModel;
        if ((r4 instanceof SheetSearchViewModel) == false) goto L6;
        SheetSearchViewModel r5 = (SheetSearchViewModel) r4;
        r5.setShouldDisableLandscapeInVc(shouldDisableLandscapeInVc());
        r5.getFocusStatus().observe(getLifecycleOwner(), new e(this));
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        ((OfficeSearchPlugin) this).searchViewModel.setDelegate(new a(this));
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }
}
