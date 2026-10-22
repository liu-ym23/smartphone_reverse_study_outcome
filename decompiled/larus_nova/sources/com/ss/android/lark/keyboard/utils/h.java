package com.ss.android.lark.keyboard.utils;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public final class h {
    public static View b(Context r100) {
        ImageView r101 = new ImageView(r100);
        r101.setId(R.id.btn_send);
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        r102.gravity = 8388629;
        int r103 = UIUtils.getDimens(r100, R.dimen.keyboard_icon_vertical_padding);
        int r104 = UIUtils.getDimens(r100, R.dimen.keyboard_icon_horizontal_padding);
        r101.setLayoutParams(r102);
        r101.setImageDrawable(ContextCompat.getDrawable(r100, R.drawable.ud_icon_send_colorful));
        r101.setImageTintList(UIUtils.getColorStateList(r100, R.color.kb_send_icon_color_selector));
        r101.setEnabled(false);
        r101.setClickable(true);
        r101.setPadding(r104, r103, 0, r103);
        return r101;
    }

    public static AppCompatImageView a(Context r100, int r101, int r102) {
        AppCompatImageView r103 = new AppCompatImageView(r100);
        r103.setId(r101);
        r103.setImageDrawable(AppCompatResources.getDrawable(r100, r102));
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.gravity = 16;
        r103.setClickable(true);
        r103.setFocusable(true);
        r103.setLayoutParams(r104);
        return r103;
    }
}
