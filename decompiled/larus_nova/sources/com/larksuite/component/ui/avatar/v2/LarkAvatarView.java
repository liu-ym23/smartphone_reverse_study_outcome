package com.larksuite.component.ui.avatar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import b08.a;
import b08.b;
import b08.c;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import uz7.e;
import wz7.d;

/* JADX INFO: loaded from: classes24.dex */
public class LarkAvatarView extends LKUIRoundedImageView2 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f284068a;

    public LarkAvatarView(Context r100) {
        this(r100, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(AvatarModel r100) {
        this.f284068a.a(getClass(), this, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(d r100) {
        if (r100 == null) goto L4;
        this.f284068a.a(getClass(), this, r100);
        return;
    L4:
        m(d.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(Class<?> r100) {
        a r101 = this.f284068a;
        Class<?> r102 = getClass();
        r101.getClass();
        b r103 = r101.b(r102, getClass(), r100);
        if (r103 == null) goto L6;
        r103.unbind(this);
        return;
    }

    public LarkAvatarView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LarkAvatarView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f284068a = new a();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.civ_badge_background, R.attr.civ_badge_icon, R.attr.civ_badge_min_size, R.attr.civ_badge_padding, R.attr.civ_badge_position_angle, R.attr.civ_badge_text, R.attr.civ_badge_text_color, R.attr.civ_badge_text_size, R.attr.civ_border_color, R.attr.civ_border_drawable, R.attr.civ_border_padding, R.attr.civ_border_width, R.attr.civ_oval, R.attr.civ_radius, R.attr.civ_radius_left_bottom, R.attr.civ_radius_left_top, R.attr.civ_radius_right_bottom, R.attr.civ_radius_right_top, R.attr.civ_selected_board_color, R.attr.civ_selected_mask_color, R.attr.civ_touch_select_enable}, r102, 0);
        setOval(r103.getBoolean(12, true));
        r103.recycle();
        registerModelBinder(tz7.a.class, ImageView.class, new tz7.b());
        registerModelBinder(uz7.d.class, ImageView.class, new e());
        registerModelBinder(AvatarModel.class, ImageView.class, new uz7.c());
        registerModelBinder(vz7.b.class, View.class, new vz7.a());
        registerModelBinder(wz7.a.class, View.class, new wz7.b());
        registerModelBinder(d.class, View.class, new wz7.c());
    }

    @Override // b08.c
    public final <M, V extends View> void registerModelBinder(Class<M> r100, Class<V> r101, b<? super V, ? super M> r102) {
        this.f284068a.registerModelBinder(r100, r101, r102);
    }
}
