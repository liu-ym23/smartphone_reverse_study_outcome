package com.bytedance.ee.bear.lark;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    public static class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC3253a f227359a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.lark.e$a$a, reason: collision with other inner class name */
        public interface InterfaceC3253a {
        }

        public a(d r100) {
            this.f227359a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 != 0) goto L5;
            InterfaceC3253a r103 = this.f227359a;
            if (r103 == null) goto L19;
            d r104 = (d) r103;
            if (r104.f227332a == false) goto L20;
            r104.f227333b.setColorFilter(r104.f227334c);
            return false;
        L20:
            return false;
        L19:
            return false;
        L5:
            if (r102 != 1) goto L21;
            InterfaceC3253a r105 = this.f227359a;
            if (r105 == null) goto L17;
            ((d) r105).f227333b.setColorFilter(null);
            return false;
        L17:
            return false;
        L21:
            return false;
        }
    }

    public static int a() {
        return Color.argb((int) 25.5f, 6, 14, 219);
    }

    public static void b(AppCompatImageView r100, int r101, boolean r102) {
        if (r100 == null) goto L5;
        r100.setOnTouchListener(new a(new d(r102, r100, r101)));
        return;
    }
}
