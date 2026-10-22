package com.bytedance.ee.bear.bitable.card.view.cell.number;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import ku5.c;
import wp4.f;

/* JADX INFO: loaded from: classes15.dex */
public class STNumberKeyboardView extends KeyboardView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f207919b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Editable f207920a;

    public final void c() {
        Context r100 = getContext();
        if (r100 != null) goto L6;
        return;
    L6:
        if (c.k(r100) == true) goto L8;
    L18:
        Keyboard r101 = null;
    L19:
        if (r101 != null) goto L21;
        r101 = new Keyboard(getContext(), R.xml.bitable_number_keyboard);
    L21:
        setKeyboard(r101);
        return;
    L8:
        if ((r100 instanceof Activity) == false) goto L18;
        View r102 = ((Activity) r100).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L14;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L14:
        int r104 = r102.getWidth();
        int r105 = r102.getHeight();
        if (r104 != 0) goto L17;
        if (r105 == 0) goto L18;
    L17:
        r101 = new Keyboard(getContext(), R.xml.bitable_number_keyboard, 0, r102.getWidth(), r102.getHeight());
        goto L19
    }

    public Editable getEditableText() {
        return this.f207920a;
    }

    @Override // android.inputmethodservice.KeyboardView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        Iterator<Keyboard.Key> r101 = getKeyboard().getKeys().iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        Keyboard.Key r102 = r101.next();
        int r103 = r102.codes[0];
        if (r103 == (-5)) goto L7;
        if (r103 == 1002) goto L10;
        if (r103 != 1003) goto L4;
        b(R.drawable.number_keyboard_btn_center_selector, r100, r102);
        a(r100, r102, R.drawable.ud_icon_sheet_sign_outlined);
        goto L4
    L10:
        b(R.drawable.number_keyboard_confirm_btn_side_selector, r100, r102);
        a(r100, r102, R.drawable.ud_icon_list_check_bold_outlined);
        goto L4
    L7:
        b(R.drawable.number_keyboard_btn_side_selector, r100, r102);
        a(r100, r102, R.drawable.ud_icon_delete_outlined);
        goto L4
    }

    public STNumberKeyboardView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public STNumberKeyboardView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        c();
    }

    public final void a(Canvas r100, Keyboard.Key r101, int r102) {
        Drawable r103 = AppCompatResources.getDrawable(getContext(), r102);
        r101.icon = r103;
        int r104 = r101.codes[0];
        if (r104 != 1002) goto L6;
        r103.setTint(n.h(getContext(), R.color.static_white));
        return;
    L6:
        if (r104 != 1003) goto L8;
    L11:
        r103.setTint(n.h(getContext(), R.color.icon_n1));
        return;
    L8:
        if (r104 == (-5)) goto L11;
        r103.draw(r100);
    }

    public final void b(int r100, Canvas r101, Keyboard.Key r102) {
        Drawable r103 = getResources().getDrawable(r100);
        int[] r104 = r102.getCurrentDrawableState();
        if (r102.codes[0] == 0) goto L5;
        r103.setState(r104);
    L5:
        int r105 = r102.x;
        int r106 = r102.y;
        r103.setBounds(r105, r106, r102.width + r105, r102.height + r106);
        r103.draw(r101);
        Drawable r107 = r102.icon;
        if (r107 == null) goto L9;
        r107.setBounds(r102.x + ((r102.width - r107.getIntrinsicWidth()) / 2), r102.y + ((r102.height - r102.icon.getIntrinsicHeight()) / 2), r102.x + ((r102.width + r102.icon.getIntrinsicWidth()) / 2), r102.y + ((r102.height + r102.icon.getIntrinsicHeight()) / 2));
        r102.icon.draw(r101);
        return;
    }

    @Override // android.inputmethodservice.KeyboardView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        if (r102 != 0) goto L5;
        if (r103 != 0) goto L5;
        return;
    L5:
        post(new f(this));
    }
}
