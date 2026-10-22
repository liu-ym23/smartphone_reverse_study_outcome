package com.bytedance.ee.bear.sheet.inputbar.subpanel;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import cn5.y;
import cn5.z;
import com.bytedance.ee.bear.appsetting.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.base.embedded.b;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import h18.e;
import java.util.Iterator;
import java.util.Locale;
import rcb.f;

/* JADX INFO: loaded from: classes18.dex */
public class SheetNumKeyboardView extends KeyboardView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f238076c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f238077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f238078b;

    private int getKeyboardXml() {
        if (c.a.f206237a.g("ccm.sheet.mobile_formula_editor_enabled") == false) goto L5;
        return R.xml.sheet_number_keyboard_formula;
    L5:
        return R.xml.sheet_number_keyboard;
    }

    public final void d() {
        Context r100 = getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        final Activity r101 = Contexts.requireActivity(r100);
        if (ku5.c.k(r100) == true) goto L11;
        Configuration r102 = f.f537199a;
        if (b.g() == true) goto L11;
        setKeyboard(new Keyboard(getContext(), getKeyboardXml()));
        return;
    L11:
        final View r103 = r101.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L16;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L16;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L16:
        if (r103 == null) goto L20;
        r103.post(new y(this, r101, r103));
        return;
    }

    public String getCurrencySymbol() {
        String r100 = getContext().getResources().getConfiguration().locale.getLanguage();
        if (r100.equals(Locale.CHINESE.getLanguage()) == false) goto L5;
        return "¥";
    L5:
        if (r100.equals(Locale.JAPANESE.getLanguage()) == true) goto L11;
        return "$";
    L11:
        return "¥";
    }

    @Override // android.inputmethodservice.KeyboardView, android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        Keyboard r100 = getKeyboard();
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<Keyboard.Key> r101 = r100.getKeys().iterator();
    L7:
        if (r101.hasNext() == false) goto L49;
        Keyboard.Key r102 = r101.next();
        int r103 = r102.codes[0];
        if (r103 == 1001) goto L48;
        if (r103 == 1002) goto L48;
        if (r103 == 1003) goto L48;
        if (r103 == 1004) goto L48;
        if (r103 == 61) goto L48;
        if (r103 == (-5)) goto L26;
        if (r103 == 1006) goto L26;
        if (r103 == 1007) goto L26;
        b(R.drawable.number_keyboard_btn_center_selector, r110, r102);
        c(r110, r102, getResources().getDimension(R.dimen.sheet_number_keyboard_text_size), Typeface.DEFAULT);
    L26:
        if (this.f238078b == false) goto L30;
        if (r103 == 1006) goto L29;
        if (r103 != 1007) goto L30;
    L29:
        b(R.drawable.number_keyboard_btn_side_normal, r110, r102);
    L31:
        int r104 = r102.codes[0];
        if (r104 != 1006) goto L34;
        r102.icon = AppCompatResources.getDrawable(this.f238077a, R.drawable.ud_icon_insert_right_outlined);
    L36:
        Drawable r105 = r102.icon;
        if (r105 != null) goto L39;
    L45:
        Drawable r106 = r102.icon;
        if (r106 == null) goto L7;
        r106.setBounds(r102.x + ((r102.width - r106.getIntrinsicWidth()) / 2), r102.y + ((r102.height - r102.icon.getIntrinsicHeight()) / 2), (r102.x + ((r102.width - r102.icon.getIntrinsicWidth()) / 2)) + r102.icon.getIntrinsicWidth(), (r102.y + ((r102.height - r102.icon.getIntrinsicHeight()) / 2)) + r102.icon.getIntrinsicHeight());
        r102.icon.draw(r110);
        goto L7
    L39:
        if (this.f238078b == false) goto L44;
        int r107 = r102.codes[0];
        if (r107 == 1006) goto L43;
        if (r107 != 1007) goto L44;
    L43:
        DrawableCompat.setTint(r105, getResources().getColor(R.color.icon_disable));
    L44:
        DrawableCompat.setTint(r105, getResources().getColor(R.color.icon_n1));
        goto L45
    L34:
        if (r104 != 1007) goto L36;
        r102.icon = AppCompatResources.getDrawable(this.f238077a, R.drawable.ud_icon_insert_down_outlined);
    L30:
        b(R.drawable.number_keyboard_btn_side_selector, r110, r102);
    L48:
        b(R.drawable.number_keyboard_btn_side_selector, r110, r102);
        c(r110, r102, getResources().getDimension(R.dimen.sheet_number_keyboard_text_size), Typeface.DEFAULT);
        goto L7
    }

    public void setGray(boolean r100) {
        this.f238078b = r100;
    }

    public SheetNumKeyboardView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SheetNumKeyboardView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f238078b = false;
        this.f238077a = r100;
        d();
    }

    public static /* synthetic */ void a(SheetNumKeyboardView r100, Activity r101, View r102) {
        r100.getClass();
        if (com.bytedance.ee.util.ui.b.a(r101) == false) goto L15;
        int r103 = r102.getWidth();
        int r104 = r102.getHeight();
        if (r103 != 0) goto L10;
        if (r104 != 0) goto L10;
        Keyboard r105 = null;
    L11:
        if (r105 != null) goto L13;
        r105 = new Keyboard(r100.getContext(), r100.getKeyboardXml());
    L13:
        r100.setKeyboard(r105);
        return;
    L10:
        r105 = new Keyboard(r100.getContext(), r100.getKeyboardXml(), 0, r102.getWidth(), r102.getHeight());
        goto L11
    }

    public final void b(int r100, Canvas r101, Keyboard.Key r102) {
        Drawable r103 = this.f238077a.getResources().getDrawable(r100);
        int[] r104 = r102.getCurrentDrawableState();
        if (r102.codes[0] == 0) goto L5;
        r103.setState(r104);
    L5:
        int r105 = r102.x;
        int r106 = r102.y;
        r103.setBounds(r105, r106, r102.width + r105, r102.height + r106);
        r103.draw(r101);
    }

    public final void c(Canvas r100, Keyboard.Key r101, float r102, Typeface r103) {
        if (r101.codes[0] != 1001) goto L5;
        r101.label = getCurrencySymbol();
    L5:
        Paint r104 = new Paint();
        r104.setTextAlign(Paint.Align.CENTER);
        r104.setAntiAlias(true);
        r104.setColor(this.f238077a.getResources().getColor(R.color.icon_n1));
        if (r101.label == null) goto L9;
        int r105 = e.f483540a;
        Typeface r106 = e.b(this.f238077a, r103.getStyle());
        r104.setTextSize(r102);
        r104.setTypeface(r106);
        int r107 = r101.x;
        int r108 = r101.y;
        Rect r109 = new Rect(r107, r108, r101.width + r107, r101.height + r108);
        Paint.FontMetricsInt r110 = r104.getFontMetricsInt();
        r100.drawText(r101.label.toString(), r109.centerX(), (((r109.bottom + r109.top) - r110.bottom) - r110.top) / 2, r104);
        return;
    }

    @Override // android.inputmethodservice.KeyboardView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        if (r102 != 0) goto L5;
        if (r103 != 0) goto L5;
        return;
    L5:
        post(new z(this));
    }
}
