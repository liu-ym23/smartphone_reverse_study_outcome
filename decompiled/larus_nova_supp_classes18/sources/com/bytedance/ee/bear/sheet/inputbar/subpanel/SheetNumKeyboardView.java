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
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.base.embedded.b;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import h18.e;
import java.util.Iterator;
import java.util.Locale;
import rcb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetNumKeyboardView extends KeyboardView {
    public static final /* synthetic */ int c = 0;
    public final Context a;
    public boolean b;

    private int getKeyboardXml() {
        if (c.a.a.g("ccm.sheet.mobile_formula_editor_enabled") == false) goto L5;
        return 2132082737;
    L5:
        return 2132082736;
    }

    public final void d() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        final Activity r1 = Contexts.requireActivity(r0);
        if (ku5.c.k(r0) == true) goto L11;
        Configuration r2 = f.a;
        if (b.g() == true) goto L11;
        setKeyboard(new Keyboard(getContext(), getKeyboardXml()));
        return;
    L11:
        final View r3 = r1.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L16;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L16;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L16:
        if (r3 == null) goto L20;
        r3.post(new y(this, r1, r3));
        return;
    }

    public String getCurrencySymbol() {
        String r0 = getContext().getResources().getConfiguration().locale.getLanguage();
        if (r0.equals(Locale.CHINESE.getLanguage()) == false) goto L5;
        return "¥";
    L5:
        if (r0.equals(Locale.JAPANESE.getLanguage()) == true) goto L11;
        return "$";
    L11:
        return "¥";
    }

    @Override // android.inputmethodservice.KeyboardView, android.view.View
    public final void onDraw(Canvas r10) {
        super.onDraw(r10);
        Keyboard r0 = getKeyboard();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<Keyboard.Key> r1 = r0.getKeys().iterator();
    L7:
        if (r1.hasNext() == false) goto L49;
        Keyboard.Key r2 = r1.next();
        int r3 = r2.codes[0];
        if (r3 == 1001) goto L48;
        if (r3 == 1002) goto L48;
        if (r3 == 1003) goto L48;
        if (r3 == 1004) goto L48;
        if (r3 == 61) goto L48;
        if (r3 == (-5)) goto L26;
        if (r3 == 1006) goto L26;
        if (r3 == 1007) goto L26;
        b(2131244059, r10, r2);
        c(r10, r2, getResources().getDimension(2131168157), Typeface.DEFAULT);
    L26:
        if (this.b == false) goto L30;
        if (r3 == 1006) goto L29;
        if (r3 != 1007) goto L30;
    L29:
        b(2131244060, r10, r2);
    L31:
        int r4 = r2.codes[0];
        if (r4 != 1006) goto L34;
        r2.icon = AppCompatResources.getDrawable(this.a, 2131254932);
    L36:
        Drawable r5 = r2.icon;
        if (r5 != null) goto L39;
    L45:
        Drawable r6 = r2.icon;
        if (r6 == null) goto L7;
        r6.setBounds(r2.x + ((r2.width - r6.getIntrinsicWidth()) / 2), r2.y + ((r2.height - r2.icon.getIntrinsicHeight()) / 2), (r2.x + ((r2.width - r2.icon.getIntrinsicWidth()) / 2)) + r2.icon.getIntrinsicWidth(), (r2.y + ((r2.height - r2.icon.getIntrinsicHeight()) / 2)) + r2.icon.getIntrinsicHeight());
        r2.icon.draw(r10);
        goto L7
    L39:
        if (this.b == false) goto L44;
        int r7 = r2.codes[0];
        if (r7 == 1006) goto L43;
        if (r7 != 1007) goto L44;
    L43:
        DrawableCompat.setTint(r5, getResources().getColor(2131102416));
    L44:
        DrawableCompat.setTint(r5, getResources().getColor(2131102418));
        goto L45
    L34:
        if (r4 != 1007) goto L36;
        r2.icon = AppCompatResources.getDrawable(this.a, 2131254929);
    L30:
        b(2131244061, r10, r2);
    L48:
        b(2131244061, r10, r2);
        c(r10, r2, getResources().getDimension(2131168157), Typeface.DEFAULT);
        goto L7
    }

    public void setGray(boolean r1) {
        this.b = r1;
    }

    public SheetNumKeyboardView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SheetNumKeyboardView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = false;
        this.a = r1;
        d();
    }

    public static /* synthetic */ void a(SheetNumKeyboardView r6, Activity r7, View r8) {
        r6.getClass();
        if (com.bytedance.ee.util.ui.b.a(r7) == false) goto L15;
        int r9 = r8.getWidth();
        int r0 = r8.getHeight();
        if (r9 != 0) goto L10;
        if (r0 != 0) goto L10;
        Keyboard r10 = null;
    L11:
        if (r10 != null) goto L13;
        r10 = new Keyboard(r6.getContext(), r6.getKeyboardXml());
    L13:
        r6.setKeyboard(r10);
        return;
    L10:
        r10 = new Keyboard(r6.getContext(), r6.getKeyboardXml(), 0, r8.getWidth(), r8.getHeight());
        goto L11
    }

    public final void b(int r4, Canvas r5, Keyboard.Key r6) {
        Drawable r7 = this.a.getResources().getDrawable(r4);
        int[] r0 = r6.getCurrentDrawableState();
        if (r6.codes[0] == 0) goto L5;
        r7.setState(r0);
    L5:
        int r1 = r6.x;
        int r2 = r6.y;
        r7.setBounds(r1, r2, r6.width + r1, r6.height + r2);
        r7.draw(r5);
    }

    public final void c(Canvas r5, Keyboard.Key r6, float r7, Typeface r8) {
        if (r6.codes[0] != 1001) goto L5;
        r6.label = getCurrencySymbol();
    L5:
        Paint r0 = new Paint();
        r0.setTextAlign(Paint.Align.CENTER);
        r0.setAntiAlias(true);
        r0.setColor(this.a.getResources().getColor(2131102418));
        if (r6.label == null) goto L9;
        int r1 = e.a;
        Typeface r9 = e.b(this.a, r8.getStyle());
        r0.setTextSize(r7);
        r0.setTypeface(r9);
        int r10 = r6.x;
        int r2 = r6.y;
        Rect r11 = new Rect(r10, r2, r6.width + r10, r6.height + r2);
        Paint.FontMetricsInt r12 = r0.getFontMetricsInt();
        r5.drawText(r6.label.toString(), r11.centerX(), (((r11.bottom + r11.top) - r12.bottom) - r12.top) / 2, r0);
        return;
    }

    @Override // android.inputmethodservice.KeyboardView, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        if (r3 != 0) goto L5;
        if (r4 != 0) goto L5;
        return;
    L5:
        post(new z(this));
    }
}
