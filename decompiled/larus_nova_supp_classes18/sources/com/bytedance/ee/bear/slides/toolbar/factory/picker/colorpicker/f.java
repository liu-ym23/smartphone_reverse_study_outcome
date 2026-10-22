package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import an4.g;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends g {

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
        public final void onClick(View r4) {
            f r5 = this.a;
            FragmentManager r0 = this.b.getFragmentManager();
            r5.getClass();
            ColorPickerTabFragment r6 = r0.findFragmentByTag(ToolbarPrimaryItemId.TextTransformSecondaryItemId.fontColor.name());
            if ((r6 instanceof ColorPickerTabFragment) == false) goto L5;
            ColorPickerTabFragment r7 = r6;
        L6:
            if (r7 != null) goto L8;
            r7 = new ColorPickerTabFragment();
        L8:
            f.c(this.a, this.b, r7, this.c);
            return;
        L5:
            r7 = null;
            goto L6
        }
    }

    public static final class b implements ColorPickerTabFragment.a {
        public final /* synthetic */ an4.b a;
        public final /* synthetic */ f b;

        @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.ColorPickerTabFragment.a
        public final void a(String r3) {
            Intrinsics.checkNotNullParameter("fontColor", "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            an4.b r0 = this.a;
            this.b.getClass();
            r0.a(ToolbarPrimaryItemId.TextTransformSecondaryItemId.fontColor, r3);
        }

        public b(an4.b r1, f r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public f() {
    }

    public final ItemIdV2 getItemId() {
        return ToolbarPrimaryItemId.TextTransformSecondaryItemId.fontColor;
    }

    public final View b(an4.b r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "toolbarContext");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r4.getContext()).inflate(2131564886, r4, false);
    }

    private final void update(ColorPickerTabFragment r1, an4.b r2, ItemV2 r3) {
        r1.update(r3);
        r1.j = new b(r2, this);
    }

    public final void a(an4.b r11, View r12, ItemV2 r13) {
        Intrinsics.checkNotNullParameter(r11, "toolbarContext");
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r13, WikiFolderPushPlugin.DATA);
        ImageView r0 = (ImageView) r12.findViewById(2131387561);
        if (r0 == null) goto L5;
        r0.setImageResource(2131248241);
    L5:
        RoundedView r1 = (RoundedView) r12.findViewById(2131387562);
        ColorPickerTabFragment r2 = null;
        if (r1 != null) goto L50;
    L40:
        ColorPickerTabFragment r3 = r11.getFragmentManager().findFragmentByTag(ToolbarPrimaryItemId.TextTransformSecondaryItemId.fontColor.name());
        if ((r3 instanceof ColorPickerTabFragment) == false) goto L43;
        r2 = r3;
    L43:
        if (r2 != null) goto L46;
        r2 = new ColorPickerTabFragment();
    L46:
        if (r2.isAdded() == false) goto L48;
        update(r2, r11, r13);
    L48:
        r12.setOnClickListener(new a(this, r11, r13));
        return;
    L50:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L35
        JSONArray r5 = new JSONObject(r13.getValue()).optJSONArray("value");     // Catch: Throwable -> L35
        if (r5 == null) goto L18;
        int r6 = r5.length();     // Catch: Throwable -> L35
        int r7 = 0;
    L11:
        if (r7 >= r6) goto L18;
        JSONObject r8 = r5.optJSONObject(r7);     // Catch: Throwable -> L35
        if (r8 == null) goto L17;
        if (Intrinsics.areEqual("textColor", r8.optString("key")) == false) goto L17;
    L19:
        if (r8 == null) goto L21;
        String r9 = r8.optString("value");     // Catch: Throwable -> L35
    L22:
        if (r9 == null) goto L24;
        ColorValueItem r10 = (ColorValueItem) new Gson().fromJson(r9, ColorValueItem.class);     // Catch: Throwable -> L35
    L25:
        if (r10 != null) goto L27;
    L33:
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L40;
        tt5.a.d("SelectColorToolbarFactory", "updateIndicator error: " + r15);
        goto L40
    L27:
        if (Intrinsics.areEqual(r10.getType(), "transparent") == false) goto L32;
        r1.setColor(-16777216);     // Catch: Throwable -> L35
        if (h18.f.a(r1.getContext()) == false) goto L31;
        r1.setBoard(true);     // Catch: Throwable -> L35
        goto L33
    L31:
        r1.setBoard(false);     // Catch: Throwable -> L35
        goto L33
    L32:
        c.a.getClass();     // Catch: Throwable -> L35
        c.a(r1, r10);     // Catch: Throwable -> L35
        r1.setBoard(c.d(r1.getContext(), r10));     // Catch: Throwable -> L35
        goto L33
    L24:
        r10 = null;
        goto L25
    L21:
        r9 = null;
    L17:
        r7 = r7 + 1;     // Catch: Throwable -> L35
    L18:
        r8 = null;
    L35:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    }

    public static final void c(f r2, an4.b r3, ColorPickerTabFragment r4, ItemV2 r5) {
        r2.getClass();
        if (r4.isAdded() == true) goto L14;
        r4.ea0(r3.b().getHeight());
        Bundle r0 = new Bundle();
        PluginHost.writePluginHostToBundle(r0, r3.getPluginHost());
        r4.setArguments(r0);
        r2.update(r4, r3, r5);
        FragmentManager r6 = r3.getFragmentManager();
        String r7 = ToolbarPrimaryItemId.TextTransformSecondaryItemId.fontColor.name();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, r7, r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r4, r8) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r4.show(r6, r7);
        return;
    L15:
        return;
    }
}
