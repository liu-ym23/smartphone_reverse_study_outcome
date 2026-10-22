package com.larus.bot.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemLongTextArrow;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.bot.impl.feature.edit.feature.firstmet.tts.BotCreateTtsPlayerView;
import com.larus.bot.impl.feature.edit.view.BotEditScrollView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageBotEditBinding implements ViewBinding {
    public final FrameLayout A;
    public final AppCompatImageView B;
    public final View C;
    public final View D;
    public final ConstraintLayout E;
    public final AppCompatTextView F;
    public final ViewStub G;
    public final ViewStub H;
    public final ConstraintLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final BotEditScrollView f317929J;
    public final NovaTitleBarEx K;
    public final ItemTextToggle L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f317930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemLongTextArrow f317931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemLongTextArrow f317932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f317933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f317934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f317935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LarusLayoutBotBioEditBinding f317936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f317937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f317938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f317939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f317940k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f317941l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f317942m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f317943n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AppCompatEditText f317944o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LarusBotCreateDescSkeletonBinding f317945p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LarusLayoutBotFirstMetEditBinding f317946q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ItemTextToggle f317947r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ItemGroup f317948s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ItemTextArrow f317949t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ItemTextArrow f317950u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ItemTextArrow f317951v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ItemTextArrow f317952w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ItemTextArrow f317953x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ItemTextArrow f317954y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AppCompatEditText f317955z;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317930a;
    }

    public static LarusPageBotEditBinding a(LayoutInflater r410, ViewGroup r411) {
        View r100 = r410.inflate(R.layout.larus_page_bot_edit, r411, false);
        int r101 = R.id.access_permission;
        ItemLongTextArrow r102 = (ItemLongTextArrow) ViewBindings.findChildViewById(r100, R.id.access_permission);
        if (r102 == null) goto L135;
        r101 = R.id.access_permission_advance;
        ItemLongTextArrow r103 = (ItemLongTextArrow) ViewBindings.findChildViewById(r100, R.id.access_permission_advance);
        if (r103 == null) goto L135;
        r101 = R.id.advance_settings_container;
        ConstraintLayout r104 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.advance_settings_container);
        if (r104 == null) goto L135;
        r101 = R.id.advance_settings_expand;
        ConstraintLayout r105 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.advance_settings_expand);
        if (r105 == null) goto L135;
        r101 = R.id.avatar_container;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.avatar_container);
        if (r106 == null) goto L135;
        r101 = R.id.bio_edit_container;
        View r107 = ViewBindings.findChildViewById(r100, R.id.bio_edit_container);
        if (r107 == null) goto L135;
        int r108 = R.id.bio_edit;
        AppCompatEditText r109 = (AppCompatEditText) ViewBindings.findChildViewById(r107, R.id.bio_edit);
        if (r109 == null) goto L133;
        r108 = R.id.bio_skeleton;
        View r110 = ViewBindings.findChildViewById(r107, R.id.bio_skeleton);
        if (r110 == null) goto L133;
        LarusBotCreateDescSkeletonBinding r111 = LarusBotCreateDescSkeletonBinding.a(r110);
        AppCompatTextView r112 = (AppCompatTextView) ViewBindings.findChildViewById(r107, R.id.bio_title);
        if (r112 == null) goto L131;
        LarusLayoutBotBioEditBinding r113 = new LarusLayoutBotBioEditBinding((ConstraintLayout) r107, r109, r111, r112);
        r101 = R.id.bottom_fixed_area;
        ConstraintLayout r114 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.bottom_fixed_area);
        if (r114 == null) goto L135;
        r101 = R.id.create_btn;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r100, R.id.create_btn);
        if (r115 == null) goto L135;
        r101 = R.id.create_btn_mask;
        View r116 = ViewBindings.findChildViewById(r100, R.id.create_btn_mask);
        if (r116 == null) goto L135;
        r101 = R.id.create_quota;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r100, R.id.create_quota);
        if (r117 == null) goto L135;
        r101 = R.id.desc_polish;
        AppCompatTextView r118 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.desc_polish);
        if (r118 == null) goto L135;
        r101 = R.id.desc_polish_undo;
        AppCompatTextView r119 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.desc_polish_undo);
        if (r119 == null) goto L135;
        r101 = R.id.desc_title;
        AppCompatTextView r120 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.desc_title);
        if (r120 == null) goto L135;
        r101 = R.id.description_edit;
        AppCompatEditText r121 = (AppCompatEditText) ViewBindings.findChildViewById(r100, R.id.description_edit);
        if (r121 == null) goto L135;
        r101 = R.id.description_edit_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.description_edit_container)) == null) goto L135;
        r101 = R.id.description_skeleton;
        View r122 = ViewBindings.findChildViewById(r100, R.id.description_skeleton);
        if (r122 == null) goto L135;
        LarusBotCreateDescSkeletonBinding r123 = LarusBotCreateDescSkeletonBinding.a(r122);
        r101 = R.id.expand_advance_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.expand_advance_icon)) == null) goto L135;
        r101 = R.id.expand_advance_text;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.expand_advance_text)) == null) goto L135;
        r101 = R.id.first_met_edit_container;
        View r124 = ViewBindings.findChildViewById(r100, R.id.first_met_edit_container);
        if (r124 == null) goto L135;
        int r125 = R.id.prologue_edit;
        AppCompatEditText r210 = (AppCompatEditText) ViewBindings.findChildViewById(r124, R.id.prologue_edit);
        if (r210 == null) goto L130;
        r125 = R.id.prologue_skeleton;
        View r126 = ViewBindings.findChildViewById(r124, R.id.prologue_skeleton);
        if (r126 == null) goto L130;
        LarusBotCreateDescSkeletonBinding r211 = LarusBotCreateDescSkeletonBinding.a(r126);
        r125 = R.id.prologue_suggests_divider;
        View r212 = ViewBindings.findChildViewById(r124, R.id.prologue_suggests_divider);
        if (r212 == null) goto L130;
        r125 = R.id.prologue_title;
        AppCompatTextView r213 = (AppCompatTextView) ViewBindings.findChildViewById(r124, R.id.prologue_title);
        if (r213 == null) goto L130;
        r125 = R.id.suggest_prompt_item;
        ItemTextArrow r214 = (ItemTextArrow) ViewBindings.findChildViewById(r124, R.id.suggest_prompt_item);
        if (r214 == null) goto L130;
        r125 = R.id.tts_container;
        BotCreateTtsPlayerView r215 = (BotCreateTtsPlayerView) ViewBindings.findChildViewById(r124, R.id.tts_container);
        if (r215 == null) goto L130;
        LarusLayoutBotFirstMetEditBinding r127 = new LarusLayoutBotFirstMetEditBinding((ConstraintLayout) r124, r210, r211, r212, r213, r214, r215);
        ItemTextToggle r216 = (ItemTextToggle) ViewBindings.findChildViewById(r100, R.id.gen_pic);
        if (r216 != null) goto L61;
        r101 = R.id.gen_pic;
        goto L135
    L61:
        if (((ItemGroup) ViewBindings.findChildViewById(r100, R.id.group_settings)) == null) goto L127;
        ItemGroup r217 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.group_settings_advance);
        if (r217 == null) goto L126;
        ItemTextArrow r218 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.item_language);
        if (r218 == null) goto L125;
        ItemTextArrow r219 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.item_language_advance);
        if (r219 == null) goto L124;
        ItemTextArrow r220 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.item_voice);
        if (r220 == null) goto L123;
        ItemTextArrow r221 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.item_voice_advance);
        if (r221 == null) goto L122;
        ItemTextArrow r222 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.model_item);
        if (r222 == null) goto L121;
        ItemTextArrow r223 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.model_item_advance);
        if (r223 == null) goto L120;
        AppCompatEditText r224 = (AppCompatEditText) ViewBindings.findChildViewById(r100, R.id.name_edit);
        if (r224 == null) goto L119;
        FrameLayout r310 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.name_edit_area);
        if (r310 == null) goto L118;
        AppCompatImageView r311 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.name_edit_clear);
        if (r311 != null) goto L83;
        r101 = R.id.name_edit_clear;
        goto L135
    L83:
        if (((ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.name_edit_container)) == null) goto L116;
        View r312 = ViewBindings.findChildViewById(r100, R.id.name_edit_cover);
        if (r312 == null) goto L115;
        View r313 = ViewBindings.findChildViewById(r100, R.id.name_edit_skeleton);
        if (r313 == null) goto L114;
        ConstraintLayout r314 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.name_edit_skeleton_container);
        if (r314 == null) goto L113;
        AppCompatTextView r315 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.name_title);
        if (r315 == null) goto L112;
        ViewStub r316 = (ViewStub) ViewBindings.findChildViewById(r100, R.id.new_auto_fill_btn_stub);
        if (r316 == null) goto L111;
        ViewStub r317 = (ViewStub) ViewBindings.findChildViewById(r100, R.id.old_auto_fill_btn_stub);
        if (r317 == null) goto L110;
        ConstraintLayout r318 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.scroll_child);
        if (r318 == null) goto L109;
        BotEditScrollView r319 = (BotEditScrollView) ViewBindings.findChildViewById(r100, R.id.scroll_view);
        if (r319 == null) goto L108;
        NovaTitleBarEx r412 = (NovaTitleBarEx) ViewBindings.findChildViewById(r100, R.id.title);
        if (r412 == null) goto L107;
        ItemTextToggle r413 = (ItemTextToggle) ViewBindings.findChildViewById(r100, R.id.web_search);
        if (r413 != null) goto L105;
        r101 = R.id.web_search;
        goto L135
    L105:
        return new LarusPageBotEditBinding((ConstraintLayout) r100, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r118, r119, r120, r121, r123, r127, r216, r217, r218, r219, r220, r221, r222, r223, r224, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r412, r413);
    L107:
        r101 = R.id.title;
        goto L135
    L108:
        r101 = R.id.scroll_view;
        goto L135
    L109:
        r101 = R.id.scroll_child;
        goto L135
    L110:
        r101 = R.id.old_auto_fill_btn_stub;
        goto L135
    L111:
        r101 = R.id.new_auto_fill_btn_stub;
        goto L135
    L112:
        r101 = R.id.name_title;
        goto L135
    L113:
        r101 = R.id.name_edit_skeleton_container;
        goto L135
    L114:
        r101 = R.id.name_edit_skeleton;
        goto L135
    L115:
        r101 = R.id.name_edit_cover;
        goto L135
    L116:
        r101 = R.id.name_edit_container;
        goto L135
    L118:
        r101 = R.id.name_edit_area;
        goto L135
    L119:
        r101 = R.id.name_edit;
        goto L135
    L120:
        r101 = R.id.model_item_advance;
        goto L135
    L121:
        r101 = R.id.model_item;
        goto L135
    L122:
        r101 = R.id.item_voice_advance;
        goto L135
    L123:
        r101 = R.id.item_voice;
        goto L135
    L124:
        r101 = R.id.item_language_advance;
        goto L135
    L125:
        r101 = R.id.item_language;
        goto L135
    L126:
        r101 = R.id.group_settings_advance;
        goto L135
    L127:
        r101 = R.id.group_settings;
    L130:
        throw new NullPointerException("Missing required view with ID: ".concat(r124.getResources().getResourceName(r125)));
    L131:
        r108 = R.id.bio_title;
    L133:
        throw new NullPointerException("Missing required view with ID: ".concat(r107.getResources().getResourceName(r108)));
    L135:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusPageBotEditBinding(ConstraintLayout r100, ItemLongTextArrow r101, ItemLongTextArrow r102, ConstraintLayout r103, ConstraintLayout r104, FrameLayout r105, LarusLayoutBotBioEditBinding r106, ConstraintLayout r110, TextView r111, View r112, TextView r113, AppCompatTextView r114, AppCompatTextView r115, AppCompatTextView r116, AppCompatEditText r117, LarusBotCreateDescSkeletonBinding r118, LarusLayoutBotFirstMetEditBinding r119, ItemTextToggle r210, ItemGroup r211, ItemTextArrow r212, ItemTextArrow r213, ItemTextArrow r214, ItemTextArrow r215, ItemTextArrow r216, ItemTextArrow r217, AppCompatEditText r218, FrameLayout r219, AppCompatImageView r310, View r311, View r312, ConstraintLayout r313, AppCompatTextView r314, ViewStub r315, ViewStub r316, ConstraintLayout r317, BotEditScrollView r318, NovaTitleBarEx r319, ItemTextToggle r410) {
        this.f317930a = r100;
        this.f317931b = r101;
        this.f317932c = r102;
        this.f317933d = r103;
        this.f317934e = r104;
        this.f317935f = r105;
        this.f317936g = r106;
        this.f317937h = r110;
        this.f317938i = r111;
        this.f317939j = r112;
        this.f317940k = r113;
        this.f317941l = r114;
        this.f317942m = r115;
        this.f317943n = r116;
        this.f317944o = r117;
        this.f317945p = r118;
        this.f317946q = r119;
        this.f317947r = r210;
        this.f317948s = r211;
        this.f317949t = r212;
        this.f317950u = r213;
        this.f317951v = r214;
        this.f317952w = r215;
        this.f317953x = r216;
        this.f317954y = r217;
        this.f317955z = r218;
        this.A = r219;
        this.B = r310;
        this.C = r311;
        this.D = r312;
        this.E = r313;
        this.F = r314;
        this.G = r315;
        this.H = r316;
        this.I = r317;
        this.f317929J = r318;
        this.K = r319;
        this.L = r410;
    }
}
