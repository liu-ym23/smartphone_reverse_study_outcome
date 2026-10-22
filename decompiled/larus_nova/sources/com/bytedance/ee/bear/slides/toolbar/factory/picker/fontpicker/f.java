package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends an4.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f238714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatImageView f238715b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f238716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ an4.b f238717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ItemV2 f238718c;

        public a(f r100, an4.b r101, ItemV2 r102) {
            this.f238716a = r100;
            this.f238717b = r101;
            this.f238718c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            f r101 = this.f238716a;
            an4.b r102 = this.f238717b;
            FragmentManager r103 = r102.getFragmentManager();
            r101.getClass();
            b r104 = b.f238702a;
            Fragment r105 = r103.findFragmentByTag("fontName");
            if ((r105 instanceof FontPickerFragment) == false) goto L5;
            FontPickerFragment r106 = (FontPickerFragment) r105;
        L6:
            if (r106 != null) goto L8;
            r106 = new FontPickerFragment();
        L8:
            ItemV2 r107 = this.f238718c;
            r101.getClass();
            if (r106.isAdded() == true) goto L21;
            r106.ea0(r102.b().getHeight());
            FragmentManager r108 = r102.getFragmentManager();
            LandscapeRestrictionOperation r109 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r106, "fontName", r109);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r108, r106, r109) == false) goto L19;
        L16:
            r106.f238692n = new g(r102, r101);
            Intrinsics.checkNotNullParameter(r107, "itemData");
            r106.f238693o = r107;
            r106.ga0();
            return;
        L19:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
        L15:
            r106.show(r108, "fontName");
            goto L16
        L21:
            return;
        L5:
            r106 = null;
            goto L6
        }
    }

    public f() {
    }

    @Override // an4.e
    public final ItemIdV2 getItemId() {
        return b.f238702a;
    }

    @Override // an4.e
    public final void onHostDestroy(an4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarContext");
        super.onHostDestroy(r100);
        FragmentManager r101 = r100.getFragmentManager();
        b r102 = b.f238702a;
        Fragment r103 = r101.findFragmentByTag("fontName");
        if ((r103 instanceof FontPickerFragment) == false) goto L5;
        FontPickerFragment r104 = (FontPickerFragment) r103;
    L6:
        if (r104 != null) goto L8;
        return;
    L8:
        if (r104.isAdded() == false) goto L21;
        r104.dismissAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L20;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    L21:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // an4.g
    public final View b(an4.b r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "toolbarContext");
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = LayoutInflater.from(r101.getContext()).inflate(R.layout.core_doc_sub_toolbar_item_font_picker, r101, false);
        this.f238714a = (TextView) r102.findViewById(R.id.font_picker_text);
        this.f238715b = (AppCompatImageView) r102.findViewById(R.id.font_picker_icon);
        return r102;
    }

    @Override // an4.g
    public final void a(an4.b r100, View r101, ItemV2 r102) {
        Intrinsics.checkNotNullParameter(r100, "toolbarContext");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "data");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl((FontData) JSON.parseObject(r102.getValue(), FontData.class));     // Catch: Throwable -> L5
    L7:
        FontItem r105 = null;
        if (Result.m9455isFailureimpl(r104) == false) goto L10;
        r104 = null;
    L10:
        FontData r106 = (FontData) r104;
        if (r106 == null) goto L13;
        r105 = r106.getValue();
    L13:
        if (r105 == null) goto L34;
        TextView r107 = this.f238714a;
        if (r107 == null) goto L21;
        String r108 = r105.getName();
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r107.setText(r108);
    L21:
        if (Intrinsics.areEqual(r105.isSupport(), Boolean.TRUE) == false) goto L28;
        TextView r109 = this.f238714a;
        if (r109 == null) goto L25;
        r109.setTextColor(n.h(r101.getContext(), R.color.text_title));
    L25:
        AppCompatImageView r110 = this.f238715b;
        if (r110 == null) goto L34;
        r110.setVisibility(8);
        goto L34
    L28:
        TextView r111 = this.f238714a;
        if (r111 == null) goto L31;
        r111.setTextColor(n.h(r101.getContext(), R.color.text_disable));
    L31:
        AppCompatImageView r112 = this.f238715b;
        if (r112 == null) goto L34;
        r112.setVisibility(8);
    L34:
        r101.setOnClickListener(new a(this, r100, r102));
        return;
    L5:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
