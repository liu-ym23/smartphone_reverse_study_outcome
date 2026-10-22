package d56;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends Dialog implements DialogInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f467055a;

    public static int a(int r100) {
        if (r100 != 1) goto L7;
        return R.style.SSTheme_Dialog_Alert;
    L7:
        if (r100 != 2) goto L11;
        return R.style.SSTheme_Dialog_Alert_Night;
    L11:
        if (r100 < 16777216) goto L14;
        return r100;
    L14:
        throw null;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        a r111 = this.f467055a;
        r111.f467038c.requestFeature(1);
        r111.f467038c.setContentView(r111.f467048m);
        ViewGroup r100 = (ViewGroup) r111.f467038c.findViewById(R.id.contentPanel);
        ScrollView r101 = (ScrollView) r111.f467038c.findViewById(R.id.scrollView);
        r111.f467043h = r101;
        boolean r102 = false;
        r101.setFocusable(false);
        TextView r103 = (TextView) r111.f467038c.findViewById(R.id.message);
        r111.f467047l = r103;
        if (r103 == null) goto L12;
        r103.setVisibility(8);
        r111.f467043h.removeView(r111.f467047l);
        r100.setVisibility(8);
        View r104 = r111.f467038c.findViewById(R.id.scrollIndicatorUp);
        View r105 = r111.f467038c.findViewById(R.id.scrollIndicatorDown);
        if (r104 != null) goto L8;
        if (r105 == null) goto L12;
    L8:
        if (r104 == null) goto L10;
        r100.removeView(r104);
    L10:
        if (r105 == null) goto L12;
        r100.removeView(r105);
    L12:
        Button r106 = (Button) r111.f467038c.findViewById(R.id.button1);
        r111.f467040e = r106;
        r106.setOnClickListener(r111.f467050o);
        r111.getClass();
        if (TextUtils.isEmpty(null) == false) goto L15;
        r111.f467040e.setVisibility(8);
        int r107 = 0;
    L16:
        Button r108 = (Button) r111.f467038c.findViewById(R.id.button2);
        r111.f467041f = r108;
        r108.setOnClickListener(r111.f467050o);
        r111.getClass();
        if (TextUtils.isEmpty(null) == false) goto L19;
        r111.f467041f.setVisibility(8);
    L20:
        Button r109 = (Button) r111.f467038c.findViewById(R.id.button3);
        r111.f467042g = r109;
        r109.setOnClickListener(r111.f467050o);
        r111.getClass();
        if (TextUtils.isEmpty(null) == false) goto L23;
        r111.f467042g.setVisibility(8);
    L24:
        if (r107 == 0) goto L26;
        boolean r112 = true;
    L27:
        ViewGroup r113 = (ViewGroup) r111.f467038c.findViewById(R.id.topPanel);
        r111.f467045j = (ImageView) r111.f467038c.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(r111.f467039d)) == false) goto L34;
        TextView r114 = (TextView) r111.f467038c.findViewById(R.id.alertTitle);
        r111.f467046k = r114;
        r114.setText(r111.f467039d);
        int r115 = r111.f467044i;
        if (r115 == 0) goto L32;
        r111.f467045j.setImageResource(r115);
    L33:
        boolean r116 = true;
    L35:
        View r117 = r111.f467038c.findViewById(R.id.buttonPanel);
        if (r112 == true) goto L38;
        r117.setVisibility(8);
    L38:
        FrameLayout r118 = (FrameLayout) r111.f467038c.findViewById(R.id.customPanel);
        r111.f467038c.setFlags(131072, 131072);
        r118.setVisibility(8);
        if (r116 == false) goto L44;
        View r119 = r111.f467038c.findViewById(R.id.titleDividerTop);
        if (r119 == null) goto L44;
        r119.setVisibility(0);
    L44:
        if (r100.getVisibility() != 0) goto L46;
        r102 = true;
    L46:
        if (r112 == false) goto L50;
        if (r116 == false) goto L50;
        if (r102 == true) goto L50;
        UIUtils.updateLayoutMargin(r113, -3, -3, -3, (int) UIUtils.dip2Px(r111.f467036a, 16.0f));
    L50:
        View r120 = r111.f467038c.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L55;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r121 = ThreadMethodProxy.currentThread();
        if (r121 == com.larus.home.impl.utils.c.f346341a) goto L55;
        com.larus.home.impl.utils.c.a(r121, "getDecorView");
    L55:
        View r122 = r111.f467038c.findViewById(R.id.parentPanel);
        if (r122 == null) goto L60;
        if (r120 == null) goto L61;
        r120.setOnApplyWindowInsetsListener(new b(r111, r122));
        r120.setFitsSystemWindows(true);
        r120.requestApplyInsets();
        return;
    L61:
        return;
    L60:
        return;
    L32:
        r111.f467046k.setPadding(r111.f467045j.getPaddingLeft(), r111.f467045j.getPaddingTop(), r111.f467045j.getPaddingRight(), r111.f467045j.getPaddingBottom());
        r111.f467045j.setVisibility(8);
        goto L33
    L34:
        r111.f467038c.findViewById(R.id.title_template).setVisibility(8);
        r111.f467045j.setVisibility(8);
        r113.setVisibility(8);
        r116 = false;
        goto L35
    L26:
        r112 = false;
        goto L27
    L23:
        Button r123 = r111.f467042g;
        r111.getClass();
        r123.setText(null);
        r111.f467042g.setVisibility(0);
        r107 = r107 | 4;
        goto L24
    L19:
        Button r124 = r111.f467041f;
        r111.getClass();
        r124.setText(null);
        r111.f467041f.setVisibility(0);
        r107 = r107 | 2;
        goto L20
    L15:
        Button r125 = r111.f467040e;
        r111.getClass();
        r125.setText(null);
        r111.f467040e.setVisibility(0);
        r107 = 1;
        goto L16
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence r100) {
        super.setTitle(r100);
        a r101 = this.f467055a;
        r101.f467039d = r100;
        TextView r102 = r101.f467046k;
        if (r102 == null) goto L6;
        r102.setText(r100);
        return;
    }

    public c(Context r100, int r101) {
        super(r100, a(r101));
        this.f467055a = new a(getContext(), this, getWindow());
        throw new IllegalArgumentException("NightMode is NUll");
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        ScrollView r102 = this.f467055a.f467043h;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        return true;
    L11:
        return super.onKeyDown(r100, r101);
    L5:
        if (r102.executeKeyEvent(r101) == false) goto L7;
        r103 = true;
        goto L8
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int r100, KeyEvent r101) {
        ScrollView r102 = this.f467055a.f467043h;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        return true;
    L11:
        return super.onKeyUp(r100, r101);
    L5:
        if (r102.executeKeyEvent(r101) == false) goto L7;
        r103 = true;
        goto L8
    }
}
