package com.ss.android.lark.utils;

import android.R;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes38.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f444747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f444748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static h08.b f444749c;

    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f444750a = 0;

        /* JADX INFO: renamed from: com.ss.android.lark.utils.q$a$a, reason: collision with other inner class name */
        public class C5376a implements a {
            public C5376a() {
            }
        }

        static {
            new C5376a();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f444751a = null;

        static {
            f444751a = new c();
        }
    }

    public static class c implements View.OnTouchListener {
        public c() {
        }

        public static void a(View r100, boolean r101) {
            Object r102 = r100.getTag(-1);
            if ((r102 instanceof Float) == true) goto L5;
            return;
        L5:
            float r103 = 1.0f;
            if (r101 == false) goto L8;
            r103 = 1.0f + ((Float) r102).floatValue();
        L8:
            r100.animate().scaleX(r103).scaleY(r103).setDuration(200).start();
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 != 0) goto L5;
            a(r100, true);
        L9:
            return false;
        L5:
            if (r102 != 1) goto L7;
        L8:
            a(r100, false);
            goto L9
        L7:
            if (r102 != 3) goto L9;
            goto L8
        }
    }

    public static void a(View r100) {
        if (r100 == null) goto L17;
        Drawable r101 = r100.getBackground();
        Object r102 = r100.getTag(-5);
        if ((r102 instanceof Drawable) == false) goto L7;
        ViewCompat.setBackground(r100, (Drawable) r102);
        return;
    L7:
        Drawable r103 = r101;
        if (r101 != null) goto L10;
        r103 = new ColorDrawable(0);
    L10:
        Drawable.ConstantState r104 = r103.getConstantState();
        Drawable r105 = r103;
        if (r104 == null) goto L14;
        Drawable r106 = r103.getConstantState().newDrawable().mutate();
        r106.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f})));
        StateListDrawable r107 = new StateListDrawable();
        r107.addState(new int[]{R.attr.state_pressed}, r106);
        r107.addState(StateSet.WILD_CARD, r103);
        r105 = r107;
    L14:
        ViewCompat.setBackground(r100, r105);
        r100.setTag(-5, r105);
        return;
    }

    public static void b(View... r100) {
        if (r100.length == 0) goto L13;
        int r101 = 0;
    L7:
        if (r101 >= r100.length) goto L17;
        View r102 = r100[r101];
        if (r102 == null) goto L12;
        r102.setTag(-1, Float.valueOf(-0.08f));
        r102.setClickable(true);
        r102.setOnTouchListener(b.f444751a);
    L12:
        r101 = r101 + 1;
        goto L7
    L17:
        return;
    }
}
