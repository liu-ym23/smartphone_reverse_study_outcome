package com.ivy.ivykit.plugin.impl.render;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f278437a = 0;

    public static final class a extends LinearLayout {
        public a(Context r100, final Function0<Unit> r110) {
            Intrinsics.checkNotNullParameter(r110, "buttonClick");
            super(r100);
            setOrientation(1);
            setGravity(17);
            setBackgroundColor(-1);
            ImageView r101 = new ImageView(r100);
            LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(200, 200);
            r102.setMargins(0, 0, 0, 100);
            r101.setLayoutParams(r102);
            r101.setImageResource(R.drawable.img_forbid_light);
            addView(r101);
            TextView r103 = new TextView(r100);
            LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
            r104.setMargins(0, 0, 0, 25);
            r103.setLayoutParams(r104);
            r103.setTextColor(ColorProtector.parseColor("#161823"));
            r103.setText("你要访问的网站存在风险");
            r103.setTextSize(17.0f);
            r103.setTypeface(null, 1);
            r103.setGravity(17);
            addView(r103);
            TextView r105 = new TextView(r100);
            LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
            r106.setMargins(0, 0, 0, 145);
            r105.setLayoutParams(r106);
            r105.setTextColor(ColorProtector.parseColor("#99161823"));
            r105.setText("继续访问可能会导致个人隐私泄露,账号被盗用等危害");
            r105.setTextSize(14.0f);
            r105.setTypeface(null, 1);
            addView(r105);
            Button r107 = new Button(r100);
            r107.setLayoutParams(new LinearLayout.LayoutParams(500, -2));
            r107.setText("继续访问");
            r107.setTextSize(16.0f);
            r107.setTypeface(Typeface.DEFAULT_BOLD);
            r107.setTextColor(ColorProtector.parseColor("#161823"));
            GradientDrawable r108 = new GradientDrawable();
            r108.setCornerRadius(10.0f);
            r108.setColor(ColorProtector.parseColor("#09161823"));
            r107.setBackground(r108);
            r107.setOnClickListener(new g(r110));
            addView(r107);
        }
    }

    static {
    }
}
