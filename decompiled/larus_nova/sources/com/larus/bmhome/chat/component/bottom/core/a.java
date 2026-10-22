package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.resourcebar.ResourceBar;
import com.larus.chat.common.databinding.LarusWidgetInputSuggestedActionBinding;
import com.larus.common_ui.view.ChatInputInnerView;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements va8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<LarusWidgetInputBinding> f298411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<com.larus.bmhome.chat.component.bottom.core.inputtext.p0> f298412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<View> f298413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<View> f298414d;

    public final void A() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 == null) goto L8;
        AppCompatImageView r101 = r100.f351501k;
        if (r101 == null) goto L9;
        r101.setImageResource(R.drawable.icon_window_action_full_screen);
        r101.setScaleType(ImageView.ScaleType.CENTER);
        return;
    L9:
        return;
    }

    public final void B() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 == null) goto L8;
        AppCompatImageView r101 = r100.f351502l;
        if (r101 == null) goto L9;
        r101.setImageResource(R.drawable.icon_obric_window_action_input);
        r101.setScaleType(ImageView.ScaleType.CENTER);
        return;
    L9:
        return;
    }

    public final void C() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 == null) goto L8;
        AppCompatImageView r101 = r100.N;
        if (r101 == null) goto L9;
        r101.setImageResource(R.drawable.icon_obric_window_action_menu_entrance);
        r101.setScaleType(ImageView.ScaleType.CENTER);
        return;
    L9:
        return;
    }

    public final void D() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 == null) goto L8;
        AppCompatImageView r101 = r100.f351510t;
        if (r101 == null) goto L9;
        r101.setImageResource(R.drawable.icon_window_input_action_send);
        r101.setScaleType(ImageView.ScaleType.CENTER);
        return;
    L9:
        return;
    }

    public final void E() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 == null) goto L8;
        AppCompatImageView r101 = r100.f351512v;
        if (r101 == null) goto L9;
        r101.setImageResource(R.drawable.icon_obric_window_action_speak);
        r101.setScaleType(ImageView.ScaleType.CENTER);
        return;
    L9:
        return;
    }

    public final View F() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351513w;
    }

    public final AppCompatImageView G() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351512v;
    }

    public final ChatInputInnerView H() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.R;
    }

    public final TextView I() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 == null) goto L7;
        ChatInputInnerView r101 = r100.R;
        if (r101 == null) goto L7;
        return r101.f328174a.f326617d;
    L7:
        return null;
    }

    public final AppCompatImageView J() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351514x;
    }

    public final ViewGroup K() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.T;
    }

    @Override // va8.c
    public final GradientMaskView a() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351495e;
    }

    @Override // va8.c
    public final TextView b() {
        com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r100 = this.f298412b.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Y0();
    }

    @Override // va8.c
    public final View c() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 == null) goto L7;
        LarusWidgetInputSuggestedActionBinding r101 = r100.L;
        if (r101 == null) goto L7;
        return r101.f324088a;
    L7:
        return null;
    }

    @Override // va8.c
    public final RecyclerView d() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351494d;
    }

    @Override // va8.c
    public final View e() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351498h;
    }

    @Override // va8.c
    public final View f() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351503m;
    }

    @Override // va8.c
    public final ConstraintLayout h() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.I;
    }

    @Override // va8.c
    public final View j() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.C;
    }

    @Override // va8.c
    public final Integer k() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 == null) goto L9;
        RecyclerView r101 = r100.f351494d;
        if (r101 == null) goto L9;
        RecyclerView.Adapter r102 = r101.getAdapter();
        if (r102 == null) goto L9;
        return Integer.valueOf(r102.getItemCount());
    L9:
        return null;
    }

    public final AppCompatImageView m() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351497g;
    }

    public final AppCompatImageView n() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351499i;
    }

    public final AppCompatImageView o() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351501k;
    }

    public final ViewGroup p() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.F;
    }

    public final ConstraintLayout q() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.H;
    }

    public final View r() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351491a;
    }

    public final int s() {
        com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r100 = this.f298412b.invoke();
        if (r100 == null) goto L7;
        EditText r101 = r100.Y0();
        if (r101 == null) goto L7;
        return r101.getLineCount();
    L7:
        return 0;
    }

    public final AppCompatImageView t() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351502l;
    }

    public final AppCompatImageView u() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.N;
    }

    public final View v() {
        View r100 = this.f298414d.invoke();
        if (r100 != null) goto L9;
        LarusWidgetInputBinding r101 = this.f298411a.invoke();
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.f351504n;
    L9:
        return r100;
    }

    public final View w() {
        View r100 = this.f298413c.invoke();
        if (r100 != null) goto L9;
        LarusWidgetInputBinding r101 = this.f298411a.invoke();
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.f351505o;
    L9:
        return r100;
    }

    public final ResourceBar x() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.O;
    }

    public final AppCompatImageView y() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351510t;
    }

    public final void z() {
        LarusWidgetInputBinding r100 = this.f298411a.invoke();
        if (r100 == null) goto L8;
        AppCompatImageView r101 = r100.f351499i;
        if (r101 == null) goto L9;
        r101.setImageResource(R.drawable.icon_obric_window_action_entrance);
        r101.setScaleType(ImageView.ScaleType.CENTER);
        return;
    L9:
        return;
    }

    @Override // va8.c
    public final void g(Function1<? super Boolean, Unit> r100) {
        com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r101 = this.f298412b.invoke();
        if (r101 == null) goto L6;
        r101.m1(r100);
        return;
    }

    @Override // va8.c
    public final void i(int r100) {
        LarusWidgetInputBinding r101 = this.f298411a.invoke();
        if (r101 == null) goto L10;
        RecyclerView r102 = r101.f351494d;
        if (r102 == null) goto L11;
        RecyclerView.Adapter r103 = r102.getAdapter();
        if (r103 == null) goto L12;
        r103.notifyItemChanged(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void l(va8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "appearance");
        LarusWidgetInputBinding r101 = this.f298411a.invoke();
        if (r101 != null) goto L5;
        return;
    L5:
        Integer r102 = r100.f553944a;
        if (r102 == null) goto L10;
        int r103 = r102.intValue();
        com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r104 = this.f298412b.invoke();
        if (r104 == null) goto L10;
        r104.setTextColor(r103);
    L10:
        Integer r105 = r100.f553945b;
        if (r105 == null) goto L13;
        r101.R.setNormalTextColor(r105.intValue());
    L13:
        Integer r106 = r100.f553946c;
        if (r106 == null) goto L16;
        r101.f351502l.setColorFilter(r106.intValue());
    L16:
        Integer r107 = r100.f553947d;
        if (r107 == null) goto L20;
        r101.N.setColorFilter(r107.intValue());
        return;
    }

    public a(g4 r100, h4 r101, i4 r102, j4 r103) {
        Intrinsics.checkNotNullParameter(r100, "bindingProvider");
        Intrinsics.checkNotNullParameter(r101, "inputTextDelegateProvider");
        Intrinsics.checkNotNullParameter(r102, "actionModifyConfirmProvider");
        Intrinsics.checkNotNullParameter(r103, "actionModifyCancelProvider");
        this.f298411a = r100;
        this.f298412b = r101;
        this.f298413c = r102;
        this.f298414d = r103;
    }
}
