package com.ss.android.lark.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: com.ss.android.lark.ui.a$a, reason: collision with other inner class name */
    public class C5370a implements IActionTitlebar$TextAction.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f444569a;

        public C5370a(TextView r100) {
            this.f444569a = r100;
        }
    }

    public class b implements IActionTitlebar$TextAction.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f444570a;

        public b(TextView r100) {
            this.f444570a = r100;
        }
    }

    public static View a(Context r100, IActionTitlebar$Action r101) {
        if ((r101 instanceof c) == false) goto L12;
        ImageView r102 = new ImageView(r100);
        c r103 = (c) r101;
        Drawable r104 = r103.f444572b;
        if (r104 == null) goto L7;
        r102.setImageDrawable(r104);
    L8:
        int r105 = r103.f444573c;
        View r106 = r102;
        if (r105 == 0) goto L23;
        r102.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r100, r105)));
        r106 = r102;
    L23:
        if (r101.getBackground() == 0) goto L25;
        r106.setBackgroundResource(r101.getBackground());
    L25:
        int r107 = fib.a.f477428a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.ux_optimization") == true) goto L28;
    L32:
        int r108 = com.larksuite.framework.utils.autoscale.a.f285947a;
        Resources r109 = Resources.getSystem();
        float r110 = WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()).density;
        Resources r111 = Resources.getSystem();
        r106.setPadding((int) ((9 * r110) + 0.5f), 0, (int) ((15 * WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()).density) + 0.5f), 0);
    L33:
        return r106;
    L28:
        if (r101.getPadding() == null) goto L32;
        if (r106 != null) goto L31;
        return null;
    L31:
        r106.setPadding(r101.getPadding().left, r101.getPadding().top, r101.getPadding().right, r101.getPadding().bottom);
        goto L33
    L7:
        r102.setImageDrawable(AppCompatResources.getDrawable(r100, r101.getDrawableRes()));
        goto L8
    L12:
        if ((r101 instanceof IActionTitlebar$TextAction) == false) goto L19;
        IActionTitlebar$TextAction r112 = (IActionTitlebar$TextAction) r101;
        TextView r113 = new TextView(r100);
        r113.setTextColor(r113.getResources().getColor(R.color.lkui_N900));
        r113.setSingleLine();
        r113.setGravity(16);
        r113.setEllipsize(TextUtils.TruncateAt.END);
        r113.setText(r101.getText());
        r113.setTextSize(r112.getTextSize());
        IActionTitlebar$TextAction r114 = (IActionTitlebar$TextAction) r101;
        if (r114.getColor() == (-1)) goto L16;
        r113.setTextColor(r100.getResources().getColorStateList(r112.getColor()));
    L17:
        r114.setOnTextColorChangedListener(new C5370a(r113));
        r114.setOnTextChangedListener(new b(r113));
        r106 = r113;
        goto L23
    L16:
        r113.setTextColor(r100.getResources().getColorStateList(R.color.black_c2_c3_selector));
        goto L17
    L19:
        if ((r101 instanceof d) == false) goto L21;
        r106 = ((d) r101).f444603a;
        goto L23
    L21:
        r106 = null;
        goto L23
    }
}
