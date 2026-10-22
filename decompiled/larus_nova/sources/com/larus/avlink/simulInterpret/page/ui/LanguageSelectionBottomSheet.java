package com.larus.avlink.simulInterpret.page.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.dtf.face.config.IConstValues;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.avlink.impl.databinding.DialogLanguageSelectionBottomSheetBinding;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u0011H\u0002J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0011H\u0002J\b\u0010*\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectionBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/DialogLanguageSelectionBottomSheetBinding;", "leftLanguage", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "rightLanguage", "isEditingLeft", "", "languageList", "", "onLanguagesSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "tempSelectedLanguage", "adapter", "Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectBottomSheetAdapter;", IConstValues.DEVICE_TYPE, "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupBottomSheetBehavior", "updateCurrentLanguagesDisplay", "updateContainerSelection", "setupRecyclerView", "handleLanguageSelection", "selectedLanguage", "setupButtons", "onDestroyView", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LanguageSelectionBottomSheet extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f294523m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DialogLanguageSelectionBottomSheetBinding f294524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.larus.avlink.simulInterpret.page.model.a f294525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.larus.avlink.simulInterpret.page.model.a f294526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f294527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<com.larus.avlink.simulInterpret.page.model.a> f294528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super com.larus.avlink.simulInterpret.page.model.a, ? super com.larus.avlink.simulInterpret.page.model.a, Unit> f294529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.larus.avlink.simulInterpret.page.model.a f294530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LanguageSelectBottomSheetAdapter f294531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DoraDeviceType f294532l;

    public static final class a {
        public static LanguageSelectionBottomSheet a(com.larus.avlink.simulInterpret.page.model.a r100, com.larus.avlink.simulInterpret.page.model.a r101, List r102, Function2 r103, boolean r104, DoraDeviceType r105) {
            Intrinsics.checkNotNullParameter(r100, "currentLanguage");
            Intrinsics.checkNotNullParameter(r101, "otherSideLanguage");
            Intrinsics.checkNotNullParameter(r102, "languages");
            Intrinsics.checkNotNullParameter(r103, "onSelected");
            Intrinsics.checkNotNullParameter(r105, IConstValues.DEVICE_TYPE);
            LanguageSelectionBottomSheet r106 = new LanguageSelectionBottomSheet();
            if (r104 == false) goto L5;
            r106.f294525e = r100;
            r106.f294526f = r101;
        L6:
            r106.f294527g = r104;
            r106.f294528h = r102;
            r106.f294529i = r103;
            r106.f294532l = r105;
            return r106;
        L5:
            r106.f294525e = r101;
            r106.f294526f = r100;
            goto L6
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.avlink.simulInterpret.page.ui.n] */
    public final void S90() {
        if (this.f294527g == false) goto L5;
        com.larus.avlink.simulInterpret.page.model.a r100 = this.f294525e;
    L6:
        com.larus.avlink.simulInterpret.page.model.a r101 = this.f294530j;
        if (r101 == null) goto L10;
        r100 = r101;
    L10:
        this.f294531k = new LanguageSelectBottomSheetAdapter(r100, this.f294528h, new n(this));
        DialogLanguageSelectionBottomSheetBinding r102 = this.f294524d;
        if (r102 == null) goto L16;
        RecyclerView r103 = r102.f293110d;
        if (r103 == null) goto L17;
        r103.setLayoutManager(new LinearLayoutManager(r103.getContext()));
        r103.setAdapter(this.f294531k);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r100 = this.f294526f;
        goto L6
    }

    public final void T90() {
        DialogLanguageSelectionBottomSheetBinding r100 = this.f294524d;
        if (r100 == null) goto L13;
        Context r101 = getContext();
        if (r101 == null) goto L14;
        int r102 = r101.getColor(R.color.primary_50);
        Context r103 = getContext();
        if (r103 == null) goto L15;
        int r104 = r103.getColor(R.color.neutral_100);
        if (this.f294527g == false) goto L11;
        r100.f293111e.setBackgroundResource(R.drawable.bg_language_select_window_selected);
        r100.f293114h.setBackgroundResource(R.drawable.bg_language_select_window);
        r100.f293113g.setTextColor(r102);
        r100.f293112f.setColorFilter(r102);
        r100.f293116j.setTextColor(r104);
        r100.f293115i.clearColorFilter();
        return;
    L11:
        r100.f293111e.setBackgroundResource(R.drawable.bg_language_select_window);
        r100.f293114h.setBackgroundResource(R.drawable.bg_language_select_window_selected);
        r100.f293113g.setTextColor(r104);
        r100.f293112f.clearColorFilter();
        r100.f293116j.setTextColor(r102);
        r100.f293115i.setColorFilter(r102);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void U90() {
        DialogLanguageSelectionBottomSheetBinding r100 = this.f294524d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f294532l != DoraDeviceType.DEVICE_LITE) goto L7;
        r100.f293112f.setImageResource(R.drawable.icon_left_earphone_si);
        r100.f293115i.setImageResource(R.drawable.icon_right_earphone_si);
    L8:
        r100.f293113g.setText(this.f294525e.f294493a);
        r100.f293116j.setText(this.f294526f.f294493a);
        T90();
        r100.f293111e.setOnClickListener(new k(this));
        r100.f293114h.setOnClickListener(new l(this));
        r100.f293117k.setOnClickListener(new m(this));
        return;
    L7:
        r100.f293112f.setImageResource(R.drawable.icon_phone_si);
        r100.f293115i.setImageResource(R.drawable.icon_glass_si);
        goto L8
    }

    public LanguageSelectionBottomSheet() {
        com.larus.avlink.simulInterpret.page.model.a r100 = com.larus.avlink.simulInterpret.page.model.a.f294491e;
        com.larus.avlink.simulInterpret.page.model.a r101 = com.larus.avlink.simulInterpret.page.model.a.f294491e;
        this.f294525e = r101;
        com.larus.avlink.simulInterpret.page.model.a r102 = com.larus.avlink.simulInterpret.page.model.a.f294492f;
        this.f294526f = r102;
        this.f294528h = CollectionsKt.listOf(new com.larus.avlink.simulInterpret.page.model.a[]{r101, r102});
        this.f294532l = DoraDeviceType.DEVICE_LITE;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f294531k = null;
        this.f294524d = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        View r103 = null;
        if ((r102 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r104 = (BottomSheetDialog) r102;
    L6:
        if (r104 == null) goto L8;
        r103 = r104.findViewById(R.id.design_bottom_sheet);
    L8:
        if (r103 == null) goto L10;
        r103.setBackgroundResource(android.R.color.transparent);
        BottomSheetBehavior.from(r103).setState(3);
    L10:
        U90();
        S90();
        DialogLanguageSelectionBottomSheetBinding r105 = this.f294524d;
        if (r105 == null) goto L14;
        r105.f293108b.setOnClickListener(new o(this));
        r105.f293109c.setOnClickListener(new p(this));
        return;
    L14:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.dialog_language_selection_bottom_sheet, r111, false);
        int r114 = R.id.bottom_buttons;
        if (((LinearLayout) ViewBindings.findChildViewById(r113, R.id.bottom_buttons)) == null) goto L33;
        r114 = R.id.cancel_button;
        TextView r100 = (TextView) ViewBindings.findChildViewById(r113, R.id.cancel_button);
        if (r100 == null) goto L33;
        r114 = R.id.confirm_button;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r113, R.id.confirm_button);
        if (r101 == null) goto L33;
        r114 = R.id.current_languages_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r113, R.id.current_languages_container)) == null) goto L33;
        r114 = R.id.language_recycler_view;
        RecyclerView r102 = (RecyclerView) ViewBindings.findChildViewById(r113, R.id.language_recycler_view);
        if (r102 == null) goto L33;
        r114 = R.id.left_language_container;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.left_language_container);
        if (r103 == null) goto L33;
        r114 = R.id.left_language_icon;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r113, R.id.left_language_icon);
        if (r104 == null) goto L33;
        r114 = R.id.left_language_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r113, R.id.left_language_text);
        if (r105 == null) goto L33;
        r114 = R.id.right_language_container;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.right_language_container);
        if (r106 == null) goto L33;
        r114 = R.id.right_language_icon;
        ImageView r107 = (ImageView) ViewBindings.findChildViewById(r113, R.id.right_language_icon);
        if (r107 == null) goto L33;
        r114 = R.id.right_language_text;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r113, R.id.right_language_text);
        if (r115 == null) goto L33;
        r114 = R.id.subtitle_text;
        if (((TextView) ViewBindings.findChildViewById(r113, R.id.subtitle_text)) == null) goto L33;
        r114 = R.id.swap_button;
        ImageView r116 = (ImageView) ViewBindings.findChildViewById(r113, R.id.swap_button);
        if (r116 == null) goto L33;
        r114 = R.id.title_text;
        if (((TextView) ViewBindings.findChildViewById(r113, R.id.title_text)) == null) goto L33;
        ConstraintLayout r117 = (ConstraintLayout) r113;
        this.f294524d = new DialogLanguageSelectionBottomSheetBinding(r117, r100, r101, r102, r103, r104, r105, r106, r107, r115, r116);
        return r117;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
