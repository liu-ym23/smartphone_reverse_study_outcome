package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.edit_toolbar.ToolbarV2PanelViewModel;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.connect.common.Constants;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends an4.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f238597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f238598b;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f238599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ an4.b f238600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FontSizeItem f238601c;

        public b(d r100, an4.b r101, FontSizeItem r102) {
            this.f238599a = r100;
            this.f238600b = r101;
            this.f238601c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            d r111 = this.f238599a;
            an4.b r100 = this.f238600b;
            FontSizeItem r101 = this.f238601c;
            r111.getClass();
            FragmentManager r102 = r100.getFragmentManager();
            c r103 = c.f238596a;
            Fragment r104 = r102.findFragmentByTag("fontSize");
            Fragment r105 = r104;
            if (r104 != null) goto L9;
            int r106 = FontSizeFragment.f238586j;
            if (r101 != null) goto L7;
            r101 = new FontSizeItem();
            r101.setValue(Constants.VIA_REPORT_TYPE_START_WAP);
            r101.setMax("50");
            r101.setMin(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        L7:
            String r107 = JSON.toJSONString(r101);
            Intrinsics.checkNotNullParameter(r107, "fontSizeJson");
            FontSizeFragment r108 = new FontSizeFragment();
            r108.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("fontSizeData", r107)}));
            g r109 = new g(r111, r100);
            Intrinsics.checkNotNullParameter(r109, "listener");
            r108.f238589g = r109;
            r105 = r108;
        L9:
            if (r105.isAdded() == true) goto L20;
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.ee.bear.slides.toolbar.factory.fontsize.FontSizeFragment");
            f r112 = new f(r111, r100, r105);
            Intrinsics.checkNotNullParameter(r112, "listener");
            ((FontSizeFragment) r105).f238588f = r112;
            ToolbarV2PanelViewModel r113 = (ToolbarV2PanelViewModel) q.c(r100.getPluginHost(), ToolbarV2PanelViewModel.class, null);
            e r114 = r111.f238598b;
            if (r114 == null) goto L14;
            ((ToolbarV2PanelViewModel) q.c(r100.getPluginHost(), ToolbarV2PanelViewModel.class, null)).getToolbar().removeObserver(r114);
            r111.f238598b = null;
        L14:
            e r115 = new e(r111, r100, r105);
            r113.getToolbar().observe(r100.getFragment().getViewLifecycleOwner(), r115);
            r111.f238598b = r115;
            FragmentTransaction r116 = r100.getFragmentManager().beginTransaction().setCustomAnimations(R.anim.core_subtoolbar_font_size_in, R.anim.core_subtoolbar_font_size_out, R.anim.core_subtoolbar_font_size_in, R.anim.core_subtoolbar_font_size_out).setReorderingAllowed(true);
            int r117 = r100.c().getId();
            boolean r118 = LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r116, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "fontSize", r117);
            FragmentTransaction r119 = r116;
            if (r118 == true) goto L18;
            r119 = r116.replace(r117, r105, "fontSize");
        L18:
            r119.addToBackStack("fontSize").commitAllowingStateLoss();
            return;
        }
    }

    static {
    }

    public d() {
    }

    @Override // an4.e
    public final ItemIdV2 getItemId() {
        return c.f238596a;
    }

    @Override // an4.e
    public final void onHostDestroy(an4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarContext");
        super.onHostDestroy(r100);
        FragmentManager r101 = r100.getFragmentManager();
        c r102 = c.f238596a;
        Fragment r103 = r101.findFragmentByTag("fontSize");
        if (r103 == null) goto L6;
        c(r100, r103);
        return;
    }

    @Override // an4.g
    public final View b(an4.b r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "toolbarContext");
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = LayoutInflater.from(r101.getContext()).inflate(R.layout.core_doc_sub_toolbar_item_font_size, r101, false);
        this.f238597a = (TextView) r102.findViewById(R.id.sub_toolbar_item_font_size);
        return r102;
    }

    public final void c(an4.b r100, Fragment r101) {
        if (r101.isAdded() == true) goto L5;
        return;
    L5:
        e r102 = this.f238598b;
        if (r102 == null) goto L8;
        ((ToolbarV2PanelViewModel) q.c(r100.getPluginHost(), ToolbarV2PanelViewModel.class, null)).getToolbar().removeObserver(r102);
        this.f238598b = null;
    L8:
        FragmentManager r103 = r100.getFragmentManager();
        if (r103.getBackStackEntryCount() <= 0) goto L11;
        c r104 = c.f238596a;
        r103.popBackStackImmediate("fontSize", 1);
        return;
    L11:
        r103.beginTransaction().remove(r101).commitAllowingStateLoss();
    }

    @Override // an4.g
    public final void a(an4.b r100, View r101, ItemV2 r102) {
        Intrinsics.checkNotNullParameter(r100, "toolbarContext");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "data");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl((FontSizeItem) JSON.parseObject(r102.getValue(), FontSizeItem.class));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == false) goto L10;
        r104 = null;
    L10:
        FontSizeItem r105 = (FontSizeItem) r104;
        if (r105 == null) goto L22;
        TextView r106 = this.f238597a;
        if (r106 == null) goto L22;
        String r107 = r105.getValue();
        String r108 = "";
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        String r109 = r105.getExtra();
        if (r109 == null) goto L21;
        r108 = r109;
    L21:
        r106.setText(r107.concat(r108));
    L22:
        r101.setOnClickListener(new b(this, r100, r105));
        return;
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
