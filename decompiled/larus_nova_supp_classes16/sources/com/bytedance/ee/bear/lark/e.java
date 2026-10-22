package com.bytedance.ee.bear.lark;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {

    public static class a implements View.OnTouchListener {
        public final InterfaceC0197a a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.lark.e$a$a, reason: collision with other inner class name */
        public interface InterfaceC0197a {
        }

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            int r3 = r2.getAction();
            if (r3 != 0) goto L5;
            InterfaceC0197a r4 = this.a;
            if (r4 == null) goto L19;
            d r5 = (d) r4;
            if (r5.a == false) goto L20;
            r5.b.setColorFilter(r5.c);
            return false;
        L20:
            return false;
        L19:
            return false;
        L5:
            if (r3 != 1) goto L21;
            InterfaceC0197a r6 = this.a;
            if (r6 == null) goto L17;
            ((d) r6).b.setColorFilter(null);
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

    public static void b(AppCompatImageView r2, int r3, boolean r4) {
        if (r2 == null) goto L5;
        r2.setOnTouchListener(new a(new d(r4, r2, r3)));
        return;
    }
}
