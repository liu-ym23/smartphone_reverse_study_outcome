package com.larus.chat.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutMessageMenuNewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutCompat f324019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f324020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f324021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f324022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f324023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f324024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f324025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f324026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f324027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f324028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f324029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f324030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f324031m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f324032n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f324033o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f324034p;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f324019a;
    }

    public static LarusLayoutMessageMenuNewBinding a(LayoutInflater r210) {
        View r100 = r210.inflate(R.layout.larus_layout_message_menu_new, null, false);
        int r101 = R.id.balloon_ic_copy;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.balloon_ic_copy);
        if (r102 == null) goto L35;
        r101 = R.id.balloon_ic_question;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.balloon_ic_question);
        if (r103 == null) goto L35;
        r101 = R.id.balloon_ic_read;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.balloon_ic_read);
        if (r104 == null) goto L35;
        r101 = R.id.balloon_ic_rewrite;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.balloon_ic_rewrite);
        if (r105 == null) goto L35;
        r101 = R.id.balloon_menu_copy;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.balloon_menu_copy);
        if (r106 == null) goto L35;
        r101 = R.id.balloon_menu_question;
        LinearLayout r110 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.balloon_menu_question);
        if (r110 == null) goto L35;
        r101 = R.id.balloon_menu_read;
        LinearLayout r111 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.balloon_menu_read);
        if (r111 == null) goto L35;
        r101 = R.id.balloon_menu_rewrite;
        LinearLayout r112 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.balloon_menu_rewrite);
        if (r112 == null) goto L35;
        r101 = R.id.balloon_text_copy;
        TextView r113 = (TextView) ViewBindings.findChildViewById(r100, R.id.balloon_text_copy);
        if (r113 == null) goto L35;
        r101 = R.id.balloon_text_question;
        TextView r114 = (TextView) ViewBindings.findChildViewById(r100, R.id.balloon_text_question);
        if (r114 == null) goto L35;
        r101 = R.id.balloon_text_read;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r100, R.id.balloon_text_read);
        if (r115 == null) goto L35;
        r101 = R.id.balloon_text_rewrite;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r100, R.id.balloon_text_rewrite);
        if (r116 == null) goto L35;
        r101 = R.id.divider_1;
        View r117 = ViewBindings.findChildViewById(r100, R.id.divider_1);
        if (r117 == null) goto L35;
        r101 = R.id.divider_2;
        View r118 = ViewBindings.findChildViewById(r100, R.id.divider_2);
        if (r118 == null) goto L35;
        r101 = R.id.divider_3;
        View r119 = ViewBindings.findChildViewById(r100, R.id.divider_3);
        if (r119 == null) goto L35;
        return new LarusLayoutMessageMenuNewBinding((LinearLayoutCompat) r100, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusLayoutMessageMenuNewBinding(LinearLayoutCompat r100, AppCompatImageView r101, AppCompatImageView r102, AppCompatImageView r103, AppCompatImageView r104, LinearLayout r105, LinearLayout r106, LinearLayout r110, LinearLayout r111, TextView r112, TextView r113, TextView r114, TextView r115, View r116, View r117, View r118) {
        this.f324019a = r100;
        this.f324020b = r101;
        this.f324021c = r102;
        this.f324022d = r103;
        this.f324023e = r104;
        this.f324024f = r105;
        this.f324025g = r106;
        this.f324026h = r110;
        this.f324027i = r111;
        this.f324028j = r112;
        this.f324029k = r113;
        this.f324030l = r114;
        this.f324031m = r115;
        this.f324032n = r116;
        this.f324033o = r117;
        this.f324034p = r118;
    }
}
