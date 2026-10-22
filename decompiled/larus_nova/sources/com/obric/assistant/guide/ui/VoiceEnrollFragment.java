package com.obric.assistant.guide.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.impl.databinding.ObricGuideForVoiceEnrollBinding;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/guide/ui/VoiceEnrollFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricGuideForVoiceEnrollBinding;", "drawable", "Landroid/graphics/drawable/Drawable;", "isObricOS", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateViews", "updateRecordButtonEnabled", "enabled", "goToNextView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceEnrollFragment extends Fragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f389350g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObricGuideForVoiceEnrollBinding f389351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f389352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f389353f;

    public static final class a {
    }

    static {
    }

    public VoiceEnrollFragment() {
        this.f389353f = t9a.b.a().b();
    }

    public final void S90() {
        FragmentActivity r100 = getActivity();
        if ((r100 instanceof UserGuideActivity) == false) goto L5;
        UserGuideActivity r101 = (UserGuideActivity) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        ViewPager2 r102 = r101.Q1();
        RecyclerView.Adapter r103 = r102.getAdapter();
        if (r103 == null) goto L11;
        int r104 = r103.getItemCount();
    L12:
        int r105 = r102.getCurrentItem();
        FLogger.f375446a.i("VoiceEnrollFragment", "goToNextView, currentPage=" + r105 + ", totalPage=" + r104);
        int r106 = r105 + 1;
        if (r104 != r106) goto L15;
        r101.S1("voice_enroll_next_last_page");
        r101.finish();
        return;
    L15:
        r102.setCurrentItem(r106, true);
        return;
    L11:
        r104 = 0;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r14v24, types: [com.obric.assistant.guide.ui.o0] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        IObricUserGuide r112 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r112 != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r112 != null) goto L10;
    L12:
        boolean r101 = false;
    L13:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("onViewCreated, savedInstanceState=");
        if (r111 == null) goto L16;
        boolean r113 = true;
    L17:
        r103.append(r113);
        r103.append(", isObricOS=");
        r103.append(this.f389353f);
        r103.append(", serviceAvailable=");
        if (r112 == null) goto L20;
        boolean r114 = true;
    L21:
        r103.append(r114);
        r103.append(", useSystemDrawable=");
        r103.append(r100);
        r103.append(", isVoicePrintExist=");
        r103.append(r101);
        r102.i("VoiceEnrollFragment", r103.toString());
        if (this.f389353f == true) goto L24;
        this.f389352e = requireContext().getDrawable(R.drawable.obric_guide_voice_enroll_ex);
    L32:
        FLogger r115 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("onViewCreated drawable loaded, drawableAvailable=");
        if (this.f389352e == null) goto L35;
        boolean r105 = true;
    L36:
        r104.append(r105);
        r115.i("VoiceEnrollFragment", r104.toString());
        ObricGuideForVoiceEnrollBinding r116 = this.f389351d;
        if (r116 == null) goto L41;
        ImageView r117 = r116.f389590i;
        if (r117 == null) goto L41;
        r117.setImageDrawable(this.f389352e);
    L41:
        ObricGuideForVoiceEnrollBinding r118 = this.f389351d;
        if (r118 == null) goto L46;
        TextView r119 = r118.f389592k;
        if (r119 == null) goto L46;
        r119.setOnClickListener(new j0(this));
    L46:
        ObricGuideForVoiceEnrollBinding r120 = this.f389351d;
        if (r120 == null) goto L51;
        OButton r121 = r120.f389586e;
        if (r121 == null) goto L51;
        r121.setOnClickListener(new m0(this));
    L51:
        ObricGuideForVoiceEnrollBinding r122 = this.f389351d;
        if (r122 == null) goto L56;
        OButton r123 = r122.f389585d;
        if (r123 == null) goto L56;
        r123.setOnClickListener(new n0(this));
    L56:
        final ?? r124 = new o0(this);
        if (this.f389353f == false) goto L68;
        ObricGuideForVoiceEnrollBinding r125 = this.f389351d;
        if (r125 == null) goto L63;
        OFloatingTitleBar r126 = r125.f389587f;
        if (r126 == null) goto L63;
        OFloatingTitleBar.k(r126, new p0(r124), 2);
    L63:
        ObricGuideForVoiceEnrollBinding r127 = this.f389351d;
        if (r127 == null) goto L107;
        OFloatingTitleBar r128 = r127.f389587f;
        if (r128 == null) goto L107;
        r128.h(R.drawable.o_floating_title_bar_icon_close, -1, new q0(this));
    L107:
        ObricGuideForVoiceEnrollBinding r129 = this.f389351d;
        if (r129 == null) goto L112;
        OCheckBoxLayout r130 = r129.f389584c;
        if (r130 == null) goto L112;
        r130.setChecked(false);
    L112:
        ObricGuideForVoiceEnrollBinding r131 = this.f389351d;
        if (r131 == null) goto L117;
        OButton r132 = r131.f389591j;
        if (r132 == null) goto L117;
        r132.setEnabled(true);
        r132.setAlpha(0.3f);
    L117:
        ObricGuideForVoiceEnrollBinding r133 = this.f389351d;
        if (r133 == null) goto L122;
        OCheckBoxLayout r134 = r133.f389584c;
        if (r134 == null) goto L122;
        r134.setOnCheckedChangeListener(new s0(this));
    L122:
        ObricGuideForVoiceEnrollBinding r135 = this.f389351d;
        if (r135 == null) goto L131;
        OButton r136 = r135.f389591j;
        if (r136 == null) goto L132;
        r136.setOnClickListener(new t0(this));
        return;
    L132:
        return;
    L131:
        return;
    L68:
        int r137 = rda.a.f537347a;
        ObricGuideForVoiceEnrollBinding r138 = this.f389351d;
        if (r138 == null) goto L71;
        OFloatingTitleBar r139 = r138.f389587f;
    L72:
        NovaTitleBarEx.b6(rda.a.b(r139), R.drawable.larus_ic_left_back, false, null, null, new r0(r124), 14);
        int r140 = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_16, null, R.dimen.larus_dp_16));
        ObricGuideForVoiceEnrollBinding r141 = this.f389351d;
        if (r141 == null) goto L77;
        OButton r142 = r141.f389591j;
        if (r142 == null) goto L77;
        r142.setBackgroundResource(R.drawable.obric_bg_account_button_white);
    L77:
        ObricGuideForVoiceEnrollBinding r143 = this.f389351d;
        if (r143 == null) goto L82;
        OButton r144 = r143.f389591j;
        if (r144 == null) goto L82;
        r144.setRadius(r140);
    L82:
        ObricGuideForVoiceEnrollBinding r145 = this.f389351d;
        if (r145 == null) goto L87;
        OButton r146 = r145.f389591j;
        if (r146 == null) goto L87;
        r146.setTextColor(ContextCompat.getColor(requireContext(), R.color.larus_base_1));
    L87:
        ObricGuideForVoiceEnrollBinding r147 = this.f389351d;
        if (r147 == null) goto L92;
        OButton r148 = r147.f389586e;
        if (r148 == null) goto L92;
        r148.setRadius(r140);
    L92:
        ObricGuideForVoiceEnrollBinding r149 = this.f389351d;
        if (r149 == null) goto L97;
        OButton r150 = r149.f389585d;
        if (r150 == null) goto L97;
        r150.setBackgroundResource(R.drawable.obric_bg_account_button_white);
    L97:
        ObricGuideForVoiceEnrollBinding r151 = this.f389351d;
        if (r151 == null) goto L102;
        OButton r152 = r151.f389585d;
        if (r152 == null) goto L102;
        r152.setRadius(r140);
    L102:
        ObricGuideForVoiceEnrollBinding r153 = this.f389351d;
        if (r153 == null) goto L107;
        OButton r154 = r153.f389585d;
        if (r154 == null) goto L107;
        r154.setTextColor(ContextCompat.getColor(requireContext(), R.color.larus_base_1));
        goto L107
    L71:
        r139 = null;
        goto L72
    L35:
        r105 = false;
        goto L36
    L24:
        if (r100 == true) goto L129;
        this.f389352e = requireContext().getDrawable(R.drawable.obric_guide_voice_enroll_o);
        goto L32
    L129:
        Context r155 = requireContext().createPackageContext("com.android.settings", 2);     // Catch: Exception -> L128
        int r106 = r155.getResources().getIdentifier("obric_guide_voice_enroll_n1", "drawable", "com.android.settings");     // Catch: Exception -> L128
        if (r106 == 0) goto L29;
        Configuration r107 = new Configuration(r155.getResources().getConfiguration());     // Catch: Exception -> L128
        r107.uiMode = requireContext().getResources().getConfiguration().uiMode;     // Catch: Exception -> L128
        Context r156 = r155.createConfigurationContext(r107);     // Catch: Exception -> L128
        NewMiraResourcesManager.getInstance().install(r156);     // Catch: Exception -> L128
        Drawable r157 = r156.getDrawable(r106);     // Catch: Exception -> L128
    L30:
        this.f389352e = r157;
    L29:
        r157 = null;
        goto L30
    L20:
        r114 = false;
        goto L21
    L16:
        r113 = false;
        goto L17
    L10:
        if (r112.j() != true) goto L12;
        r101 = true;
        goto L13
    L5:
        if (r112.h() != true) goto L7;
        r100 = true;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.obric_guide_for_voice_enroll, r111, false);
        int r114 = R.id.already_enroll;
        TextView r100 = (TextView) ViewBindings.findChildViewById(r113, R.id.already_enroll);
        if (r100 == null) goto L35;
        r114 = R.id.checkbox_voiceprint;
        OCheckBoxLayout r101 = (OCheckBoxLayout) ViewBindings.findChildViewById(r113, R.id.checkbox_voiceprint);
        if (r101 == null) goto L35;
        r114 = R.id.foot_zone;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.foot_zone)) == null) goto L35;
        r114 = R.id.hint;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.hint)) == null) goto L35;
        r114 = R.id.mid_zone;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.mid_zone)) == null) goto L35;
        r114 = R.id.next_step;
        OButton r102 = (OButton) ViewBindings.findChildViewById(r113, R.id.next_step);
        if (r102 == null) goto L35;
        r114 = R.id.setup_later;
        OButton r103 = (OButton) ViewBindings.findChildViewById(r113, R.id.setup_later);
        if (r103 == null) goto L35;
        r114 = R.id.title_bar;
        OFloatingTitleBar r104 = (OFloatingTitleBar) ViewBindings.findChildViewById(r113, R.id.title_bar);
        if (r104 == null) goto L35;
        r114 = R.id.top_zone;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.top_zone)) == null) goto L35;
        r114 = R.id.voice_enroll_already_hint;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r113, R.id.voice_enroll_already_hint);
        if (r105 == null) goto L35;
        r114 = R.id.voice_enroll_hint;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r113, R.id.voice_enroll_hint);
        if (r106 == null) goto L35;
        r114 = R.id.voice_enroll_image;
        ImageView r107 = (ImageView) ViewBindings.findChildViewById(r113, R.id.voice_enroll_image);
        if (r107 == null) goto L35;
        r114 = R.id.voice_enroll_start;
        OButton r115 = (OButton) ViewBindings.findChildViewById(r113, R.id.voice_enroll_start);
        if (r115 == null) goto L35;
        r114 = R.id.voiceprint_hint1;
        if (((TextView) ViewBindings.findChildViewById(r113, R.id.voiceprint_hint1)) == null) goto L35;
        r114 = R.id.voiceprint_hint2;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r113, R.id.voiceprint_hint2);
        if (r116 == null) goto L35;
        ConstraintLayout r117 = (ConstraintLayout) r113;
        this.f389351d = new ObricGuideForVoiceEnrollBinding(r117, r100, r101, r102, r103, r104, r105, r106, r107, r115, r116);
        return r117;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
