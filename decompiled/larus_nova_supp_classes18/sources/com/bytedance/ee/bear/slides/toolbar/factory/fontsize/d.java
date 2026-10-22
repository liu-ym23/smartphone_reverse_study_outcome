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
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends an4.g {
    public TextView a;
    public e b;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ an4.b b;
        public final /* synthetic */ FontSizeItem c;

        public b(d r1, an4.b r2, FontSizeItem r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            d r11 = this.a;
            an4.b r0 = this.b;
            FontSizeItem r1 = this.c;
            r11.getClass();
            FragmentManager r2 = r0.getFragmentManager();
            c r3 = c.a;
            FontSizeFragment r4 = r2.findFragmentByTag("fontSize");
            if (r4 != null) goto L9;
            int r5 = FontSizeFragment.j;
            if (r1 != null) goto L7;
            r1 = new FontSizeItem();
            r1.setValue("16");
            r1.setMax("50");
            r1.setMin("10");
        L7:
            String r6 = JSON.toJSONString(r1);
            Intrinsics.checkNotNullParameter(r6, "fontSizeJson");
            r4 = new FontSizeFragment();
            r4.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("fontSizeData", r6)}));
            g r7 = new g(r11, r0);
            Intrinsics.checkNotNullParameter(r7, "listener");
            r4.g = r7;
        L9:
            if (r4.isAdded() == true) goto L20;
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.slides.toolbar.factory.fontsize.FontSizeFragment");
            f r8 = new f(r11, r0, r4);
            Intrinsics.checkNotNullParameter(r8, "listener");
            r4.f = r8;
            ToolbarV2PanelViewModel r9 = q.c(r0.getPluginHost(), ToolbarV2PanelViewModel.class, null);
            e r12 = r11.b;
            if (r12 == null) goto L14;
            q.c(r0.getPluginHost(), ToolbarV2PanelViewModel.class, null).getToolbar().removeObserver(r12);
            r11.b = null;
        L14:
            e r13 = new e(r11, r0, r4);
            r9.getToolbar().observe(r0.getFragment().getViewLifecycleOwner(), r13);
            r11.b = r13;
            FragmentTransaction r14 = r0.getFragmentManager().beginTransaction().setCustomAnimations(2130772184, 2130772185, 2130772184, 2130772185).setReorderingAllowed(true);
            int r15 = r0.c().getId();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r14, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "fontSize", r15) == true) goto L18;
            r14 = r14.replace(r15, r4, "fontSize");
        L18:
            r14.addToBackStack("fontSize").commitAllowingStateLoss();
            return;
        }
    }

    static {
    }

    public d() {
    }

    public final ItemIdV2 getItemId() {
        return c.a;
    }

    public final void onHostDestroy(an4.b r3) {
        Intrinsics.checkNotNullParameter(r3, "toolbarContext");
        super/*an4.e*/.onHostDestroy(r3);
        FragmentManager r0 = r3.getFragmentManager();
        c r1 = c.a;
        Fragment r2 = r0.findFragmentByTag("fontSize");
        if (r2 == null) goto L6;
        c(r3, r2);
        return;
    }

    public final View b(an4.b r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "toolbarContext");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131559943, r4, false);
        this.a = (TextView) r5.findViewById(2131387564);
        return r5;
    }

    public final void c(an4.b r5, Fragment r6) {
        if (r6.isAdded() == true) goto L5;
        return;
    L5:
        e r0 = this.b;
        if (r0 == null) goto L8;
        q.c(r5.getPluginHost(), ToolbarV2PanelViewModel.class, null).getToolbar().removeObserver(r0);
        this.b = null;
    L8:
        FragmentManager r7 = r5.getFragmentManager();
        if (r7.getBackStackEntryCount() <= 0) goto L11;
        c r8 = c.a;
        r7.popBackStackImmediate("fontSize", 1);
        return;
    L11:
        r7.beginTransaction().remove(r6).commitAllowingStateLoss();
    }

    public final void a(an4.b r5, View r6, ItemV2 r7) {
        Intrinsics.checkNotNullParameter(r5, "toolbarContext");
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, WikiFolderPushPlugin.DATA);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl((FontSizeItem) JSON.parseObject(r7.getValue(), FontSizeItem.class));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = null;
    L10:
        FontSizeItem r9 = (FontSizeItem) r8;
        if (r9 == null) goto L22;
        TextView r1 = this.a;
        if (r1 == null) goto L22;
        String r2 = r9.getValue();
        String r3 = "";
        if (r2 != null) goto L17;
        r2 = "";
    L17:
        String r4 = r9.getExtra();
        if (r4 == null) goto L21;
        r3 = r4;
    L21:
        r1.setText(r2.concat(r3));
    L22:
        r6.setOnClickListener(new b(this, r5, r9));
        return;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
