package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends an4.g {
    public TextView a;
    public AppCompatImageView b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ an4.b b;
        public final /* synthetic */ ItemV2 c;

        public a(f r1, an4.b r2, ItemV2 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            f r8 = this.a;
            an4.b r0 = this.b;
            FragmentManager r1 = r0.getFragmentManager();
            r8.getClass();
            b r2 = b.a;
            FontPickerFragment r3 = r1.findFragmentByTag("fontName");
            if ((r3 instanceof FontPickerFragment) == false) goto L5;
            FontPickerFragment r4 = r3;
        L6:
            if (r4 != null) goto L8;
            r4 = new FontPickerFragment();
        L8:
            ItemV2 r5 = this.c;
            r8.getClass();
            if (r4.isAdded() == true) goto L21;
            r4.ea0(r0.b().getHeight());
            FragmentManager r6 = r0.getFragmentManager();
            LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "fontName", r9);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r4, r9) == false) goto L19;
        L16:
            r4.n = new g(r0, r8);
            Intrinsics.checkNotNullParameter(r5, "itemData");
            r4.o = r5;
            r4.ga0();
            return;
        L19:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
        L15:
            r4.show(r6, "fontName");
            goto L16
        L21:
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public f() {
    }

    public final ItemIdV2 getItemId() {
        return b.a;
    }

    public final void onHostDestroy(an4.b r2) {
        Intrinsics.checkNotNullParameter(r2, "toolbarContext");
        super/*an4.e*/.onHostDestroy(r2);
        FragmentManager r3 = r2.getFragmentManager();
        b r0 = b.a;
        FontPickerFragment r4 = r3.findFragmentByTag("fontName");
        if ((r4 instanceof FontPickerFragment) == false) goto L5;
        FontPickerFragment r5 = r4;
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.isAdded() == false) goto L21;
        r5.dismissAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L20;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    L21:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final View b(an4.b r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "toolbarContext");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131559942, r4, false);
        this.a = (TextView) r5.findViewById(2131373133);
        this.b = r5.findViewById(2131373131);
        return r5;
    }

    public final void a(an4.b r5, View r6, ItemV2 r7) {
        Intrinsics.checkNotNullParameter(r5, "toolbarContext");
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, WikiFolderPushPlugin.DATA);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl((FontData) JSON.parseObject(r7.getValue(), FontData.class));     // Catch: Throwable -> L5
    L7:
        FontItem r2 = null;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        FontData r3 = (FontData) r1;
        if (r3 == null) goto L13;
        r2 = r3.getValue();
    L13:
        if (r2 == null) goto L34;
        TextView r4 = this.a;
        if (r4 == null) goto L21;
        String r8 = r2.getName();
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        r4.setText(r8);
    L21:
        if (Intrinsics.areEqual(r2.isSupport(), Boolean.TRUE) == false) goto L28;
        TextView r9 = this.a;
        if (r9 == null) goto L25;
        r9.setTextColor(n.h(r6.getContext(), 2131106622));
    L25:
        AppCompatImageView r10 = this.b;
        if (r10 == null) goto L34;
        r10.setVisibility(8);
        goto L34
    L28:
        TextView r11 = this.a;
        if (r11 == null) goto L31;
        r11.setTextColor(n.h(r6.getContext(), 2131106610));
    L31:
        AppCompatImageView r12 = this.b;
        if (r12 == null) goto L34;
        r12.setVisibility(8);
    L34:
        r6.setOnClickListener(new a(this, r5, r7));
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
