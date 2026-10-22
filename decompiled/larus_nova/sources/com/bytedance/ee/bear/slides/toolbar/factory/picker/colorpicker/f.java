package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import an4.g;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends g {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f238669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ an4.b f238670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ItemV2 f238671c;

        public a(f r100, an4.b r101, ItemV2 r102) {
            this.f238669a = r100;
            this.f238670b = r101;
            this.f238671c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            f r101 = this.f238669a;
            FragmentManager r102 = this.f238670b.getFragmentManager();
            r101.getClass();
            Fragment r103 = r102.findFragmentByTag(ToolbarPrimaryItemId.TextTransformSecondaryItemId.fontColor.name());
            if ((r103 instanceof ColorPickerTabFragment) == false) goto L5;
            ColorPickerTabFragment r104 = (ColorPickerTabFragment) r103;
        L6:
            if (r104 != null) goto L8;
            r104 = new ColorPickerTabFragment();
        L8:
            f.c(this.f238669a, this.f238670b, r104, this.f238671c);
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class b implements ColorPickerTabFragment.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ an4.b f238672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f238673b;

        @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.ColorPickerTabFragment.a
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter("fontColor", "key");
            Intrinsics.checkNotNullParameter(r100, "value");
            an4.b r101 = this.f238672a;
            this.f238673b.getClass();
            r101.a(ToolbarPrimaryItemId.TextTransformSecondaryItemId.fontColor, r100);
        }

        public b(an4.b r100, f r101) {
            this.f238672a = r100;
            this.f238673b = r101;
        }
    }

    public f() {
    }

    @Override // an4.e
    public final ItemIdV2 getItemId() {
        return ToolbarPrimaryItemId.TextTransformSecondaryItemId.fontColor;
    }

    @Override // an4.g
    public final View b(an4.b r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "toolbarContext");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return LayoutInflater.from(r101.getContext()).inflate(R.layout.slides_doc_sub_toolbar_item_font_color, r101, false);
    }

    private final void update(ColorPickerTabFragment r100, an4.b r101, ItemV2 r102) {
        r100.update(r102);
        r100.f238639j = new b(r101, this);
    }

    @Override // an4.g
    public final void a(an4.b r110, View r111, ItemV2 r112) {
        Intrinsics.checkNotNullParameter(r110, "toolbarContext");
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r112, "data");
        ImageView r100 = (ImageView) r111.findViewById(R.id.sub_toolbar_item_font_color_icon);
        if (r100 == null) goto L5;
        r100.setImageResource(R.drawable.slides_doc_toolbar_font_icon);
    L5:
        RoundedView r101 = (RoundedView) r111.findViewById(R.id.sub_toolbar_item_font_color_indicator);
        ColorPickerTabFragment r102 = null;
        if (r101 != null) goto L50;
    L40:
        Fragment r103 = r110.getFragmentManager().findFragmentByTag(ToolbarPrimaryItemId.TextTransformSecondaryItemId.fontColor.name());
        if ((r103 instanceof ColorPickerTabFragment) == false) goto L43;
        r102 = (ColorPickerTabFragment) r103;
    L43:
        if (r102 != null) goto L46;
        r102 = new ColorPickerTabFragment();
    L46:
        if (r102.isAdded() == false) goto L48;
        update(r102, r110, r112);
    L48:
        r111.setOnClickListener(new a(this, r110, r112));
        return;
    L50:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L35
        JSONArray r105 = new JSONObject(r112.getValue()).optJSONArray("value");     // Catch: Throwable -> L35
        if (r105 == null) goto L18;
        int r106 = r105.length();     // Catch: Throwable -> L35
        int r107 = 0;
    L11:
        if (r107 >= r106) goto L18;
        JSONObject r108 = r105.optJSONObject(r107);     // Catch: Throwable -> L35
        if (r108 == null) goto L17;
        if (Intrinsics.areEqual("textColor", r108.optString("key")) == false) goto L17;
    L19:
        if (r108 == null) goto L21;
        String r109 = r108.optString("value");     // Catch: Throwable -> L35
    L22:
        if (r109 == null) goto L24;
        ColorValueItem r113 = (ColorValueItem) new Gson().fromJson(r109, ColorValueItem.class);     // Catch: Throwable -> L35
    L25:
        if (r113 != null) goto L27;
    L33:
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L40;
        tt5.a.d("SelectColorToolbarFactory", "updateIndicator error: " + r115);
        goto L40
    L27:
        if (Intrinsics.areEqual(r113.getType(), ECPromotion.TRANSPARENT_BOTTON_ICON) == false) goto L32;
        r101.setColor(-16777216);     // Catch: Throwable -> L35
        if (h18.f.a(r101.getContext()) == false) goto L31;
        r101.setBoard(true);     // Catch: Throwable -> L35
        goto L33
    L31:
        r101.setBoard(false);     // Catch: Throwable -> L35
        goto L33
    L32:
        c.f238659a.getClass();     // Catch: Throwable -> L35
        c.a(r101, r113);     // Catch: Throwable -> L35
        r101.setBoard(c.d(r101.getContext(), r113));     // Catch: Throwable -> L35
        goto L33
    L24:
        r113 = null;
        goto L25
    L21:
        r109 = null;
    L17:
        r107 = r107 + 1;     // Catch: Throwable -> L35
    L18:
        r108 = null;
    L35:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    }

    public static final void c(f r100, an4.b r101, ColorPickerTabFragment r102, ItemV2 r103) {
        r100.getClass();
        if (r102.isAdded() == true) goto L14;
        r102.ea0(r101.b().getHeight());
        Bundle r104 = new Bundle();
        PluginHost.writePluginHostToBundle(r104, r101.getPluginHost());
        r102.setArguments(r104);
        r100.update(r102, r101, r103);
        FragmentManager r105 = r101.getFragmentManager();
        String r106 = ToolbarPrimaryItemId.TextTransformSecondaryItemId.fontColor.name();
        LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r102, r106, r107);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r105, r102, r107) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r102.show(r105, r106);
        return;
    L15:
        return;
    }
}
