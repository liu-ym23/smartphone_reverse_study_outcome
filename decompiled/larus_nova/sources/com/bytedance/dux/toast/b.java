package com.bytedance.dux.toast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f205834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<Toast> f205835b;

    public class a implements LifecycleEventObserver {
        public a() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            if (r101 != Lifecycle.Event.ON_STOP) goto L10;
            WeakReference<Toast> r102 = b.f205835b;
            if (r102 != null) goto L7;
            return;
        L7:
            if (r102.get() == null) goto L12;
            b.f205835b.get().cancel();
            return;
        L12:
            return;
        }
    }

    static {
        DuxComponent r100 = DuxComponent.DIALOG;
        f205834a = new a();
        f205835b = new WeakReference(null);
        new WeakReference(null);
    }

    public static Drawable a(boolean r100) {
        GradientDrawable r101 = new GradientDrawable();
        if (r100 == true) goto L5;
        int r102 = 56;
    L6:
        if (r102 > 0) goto L8;
        r102 = 12;
    L8:
        r101.setCornerRadius(em4.g.c(r102));
        r101.setColor(ColorProtector.parseColor("#E6393B44"));
        return r101;
    L5:
        r102 = -1;
        goto L6
    }

    public static void c(Context r100, CharSequence r101) {
        b(r100, 0, r101, 1);
    }

    public static void d(Context r100, CharSequence r101) {
        b(r100, 0, r101, 1);
    }

    public static void b(Context r100, int r101, CharSequence r102, int r103) {
        View r104 = LayoutInflater.from(r100).inflate(R.layout.dux_popup_toast_new, null);     // Catch: Exception -> L8
        ImageView r105 = (ImageView) r104.findViewById(R.id.icon);     // Catch: Exception -> L8
        LinearLayout r106 = (LinearLayout) r104.findViewById(R.id.toast_container);     // Catch: Exception -> L8
        TextView r107 = (TextView) r104.findViewById(R.id.text);     // Catch: Exception -> L8
        r107.setTextColor(ContextCompat.getColor(r100, R.color.ConstTextInverse));     // Catch: Exception -> L8
        if (r101 == 0) goto L5;
        r107.setText(r101);     // Catch: Exception -> L8
    L6:
        r107.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);     // Catch: Exception -> L8
        r105.setVisibility(8);     // Catch: Exception -> L8
        r106.setMinimumHeight(0);     // Catch: Exception -> L8
        r106.setMinimumWidth(0);     // Catch: Exception -> L8
        int r108 = em4.g.c(10);     // Catch: Exception -> L8
        int r109 = em4.g.c(16);     // Catch: Exception -> L8
        r106.setPadding(r109, r108, r109, r108);     // Catch: Exception -> L8
        r106.setBackground(a(false));     // Catch: Exception -> L8
        Toast r110 = new Toast(r100.getApplicationContext());     // Catch: Exception -> L8
        r110.setDuration(r103);     // Catch: Exception -> L8
        r110.setGravity(17, 0, 0);     // Catch: Exception -> L8
        r110.setView(r104);     // Catch: Exception -> L8
        r110.show();     // Catch: Exception -> L8
        f205835b = new WeakReference(r110);     // Catch: Exception -> L8
        ProcessLifecycleOwner.get().getLifecycle().addObserver(f205834a);     // Catch: Exception -> L8
        return;
    L5:
        r107.setText(r102);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
