package ia4;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.bdp.bdpbase.util.o;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends Dialog implements DialogInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f488909a;

    public e(Context r100) {
        super(r100, R.style.microapp_i_dialog_support_rtl);
        this.f488909a = new a(getContext(), this, getWindow());
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        a r111 = this.f488909a;
        r111.f488876c.requestFeature(1);
        r111.f488876c.setContentView(r111.f488889p);
        ViewGroup r100 = (ViewGroup) r111.f488876c.findViewById(R.id.bdp_contentPanel);
        ScrollView r101 = (ScrollView) r111.f488876c.findViewById(R.id.bdp_scrollView);
        r111.f488882i = r101;
        boolean r102 = false;
        r101.setFocusable(false);
        TextView r103 = (TextView) r111.f488876c.findViewById(R.id.bdp_message);
        r111.f488886m = r103;
        if (r103 == null) goto L19;
        r103.setVisibility(8);
        r111.f488882i.removeView(r111.f488886m);
        if (r111.f488878e == null) goto L8;
        ViewGroup r104 = (ViewGroup) r111.f488882i.getParent();
        int r105 = r104.indexOfChild(r111.f488882i);
        r104.removeViewAt(r105);
        r104.addView(r111.f488878e, r105, new ViewGroup.LayoutParams(-1, -1));
    L9:
        View r106 = r111.f488876c.findViewById(R.id.bdp_scrollIndicatorUp);
        View r107 = r111.f488876c.findViewById(R.id.bdp_scrollIndicatorDown);
        if (r106 != null) goto L12;
        if (r107 == null) goto L19;
    L12:
        ListView r108 = r111.f488878e;
        if (r108 == null) goto L15;
        r108.setOnScrollListener(new b(r106, r107));
        r111.f488878e.post(new c(r111, r106, r107));
        goto L19
    L15:
        if (r106 == null) goto L17;
        r100.removeView(r106);
    L17:
        if (r107 == null) goto L19;
        r100.removeView(r107);
        goto L19
    L8:
        r100.setVisibility(8);
    L19:
        Button r109 = (Button) r111.f488876c.findViewById(R.id.bdp_button1);
        r111.f488879f = r109;
        r109.setOnClickListener(r111.f488893t);
        if (TextUtils.isEmpty(null) == false) goto L22;
        r111.f488879f.setVisibility(8);
        int r112 = 0;
    L23:
        Button r113 = (Button) r111.f488876c.findViewById(R.id.bdp_button2);
        r111.f488880g = r113;
        r113.setOnClickListener(r111.f488893t);
        if (TextUtils.isEmpty(null) == false) goto L26;
        r111.f488880g.setVisibility(8);
    L27:
        Button r114 = (Button) r111.f488876c.findViewById(R.id.bdp_button3);
        r111.f488881h = r114;
        r114.setOnClickListener(r111.f488893t);
        if (TextUtils.isEmpty(null) == false) goto L30;
        r111.f488881h.setVisibility(8);
    L31:
        if (r112 == 0) goto L33;
        boolean r115 = true;
    L34:
        ViewGroup r116 = (ViewGroup) r111.f488876c.findViewById(R.id.bdp_topPanel);
        r111.f488884k = (ImageView) r111.f488876c.findViewById(R.id.bdp_icon);
        if ((!TextUtils.isEmpty(r111.f488877d)) == false) goto L41;
        TextView r117 = (TextView) r111.f488876c.findViewById(R.id.bdp_alertTitle);
        r111.f488885l = r117;
        r117.setText(r111.f488877d);
        int r118 = r111.f488883j;
        if (r118 == 0) goto L39;
        r111.f488884k.setImageResource(r118);
    L40:
        boolean r119 = true;
    L42:
        View r120 = r111.f488876c.findViewById(R.id.bdp_buttonPanel);
        if (r115 == true) goto L49;
        r120.setVisibility(8);
        ListView r121 = r111.f488878e;
        if (r121 == null) goto L49;
        if (r121.getParent() == null) goto L49;
        ListView r122 = r111.f488878e;
        r122.setPadding(r122.getPaddingLeft(), r111.f488878e.getPaddingTop(), r111.f488878e.getPaddingRight(), r111.f488878e.getPaddingTop());
    L49:
        FrameLayout r123 = (FrameLayout) r111.f488876c.findViewById(R.id.bdp_customPanel);
        r111.f488876c.setFlags(131072, 131072);
        r123.setVisibility(8);
        if (r119 == false) goto L58;
        if (r111.f488878e == null) goto L54;
        View r124 = r111.f488876c.findViewById(R.id.bdp_titleDivider);
    L55:
        if (r124 == null) goto L58;
        r124.setVisibility(0);
        goto L58
    L54:
        r124 = r111.f488876c.findViewById(R.id.bdp_titleDividerTop);
    L58:
        if (r100.getVisibility() != 0) goto L60;
        r102 = true;
    L60:
        if (r115 == false) goto L83;
        if (r119 == false) goto L83;
        if (r102 == true) goto L83;
        int r125 = (int) o.a(r111.f488874a, 16.0f);
        if (r116 == null) goto L83;
        ViewGroup.LayoutParams r126 = r116.getLayoutParams();
        if (r126 == null) goto L83;
        if ((r126 instanceof ViewGroup.MarginLayoutParams) == false) goto L83;
        ViewGroup.MarginLayoutParams r127 = (ViewGroup.MarginLayoutParams) r126;
        if (r127.leftMargin == (-3)) goto L74;
    L80:
        if (r125 == (-3)) goto L82;
        r127.bottomMargin = r125;
    L82:
        r116.setLayoutParams(r127);
        goto L83
    L74:
        if (r127.topMargin != (-3)) goto L80;
        if (r127.rightMargin != (-3)) goto L80;
        if (r127.bottomMargin != r125) goto L80;
    L83:
        ListView r128 = r111.f488878e;
        if (r128 == null) goto L90;
        ListAdapter r129 = r111.f488887n;
        if (r129 == null) goto L90;
        r128.setAdapter(r129);
        int r130 = r111.f488888o;
        if (r130 <= (-1)) goto L90;
        r128.setItemChecked(r130, true);
        r128.setSelection(r130);
    L90:
        Window r131 = getWindow();
        if (r131 == null) goto L94;
        r131.setBackgroundDrawable(new ColorDrawable(ColorProtector.parseColor("#00000000")));
        return;
    L94:
        return;
    L39:
        r111.f488885l.setPadding(r111.f488884k.getPaddingLeft(), r111.f488884k.getPaddingTop(), r111.f488884k.getPaddingRight(), r111.f488884k.getPaddingBottom());
        r111.f488884k.setVisibility(8);
        goto L40
    L41:
        r111.f488876c.findViewById(R.id.bdp_title_template).setVisibility(8);
        r111.f488884k.setVisibility(8);
        r116.setVisibility(8);
        r119 = false;
        goto L42
    L33:
        r115 = false;
        goto L34
    L30:
        r111.f488881h.setText(null);
        r111.f488881h.setVisibility(0);
        r112 = r112 | 4;
        goto L31
    L26:
        r111.f488880g.setText(null);
        r111.f488880g.setVisibility(0);
        r112 = r112 | 2;
        goto L27
    L22:
        r111.f488879f.setText(null);
        r111.f488879f.setVisibility(0);
        r112 = 1;
        goto L23
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence r100) {
        super.setTitle(r100);
        a r101 = this.f488909a;
        r101.f488877d = r100;
        TextView r102 = r101.f488885l;
        if (r102 == null) goto L6;
        r102.setText(r100);
        return;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        ScrollView r102 = this.f488909a.f488882i;
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
        ScrollView r102 = this.f488909a.f488882i;
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
