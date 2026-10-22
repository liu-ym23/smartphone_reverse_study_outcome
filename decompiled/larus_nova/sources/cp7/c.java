package cp7;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f464723a = 0;

    public static abstract class a {

        /* JADX INFO: renamed from: cp7.c$a$a, reason: collision with other inner class name */
        public static final class C5565a {
            public static boolean a(View r100) {
                int r101 = cp7.d.f464724a;
                if (r100.getVisibility() == 0) goto L5;
            L12:
                return true;
            L5:
                if (r100.getAlpha() < 0.05d) goto L12;
                if (r100.getScaleX() < 0.01d) goto L12;
                if (r100.getScaleY() < 0.01d) goto L12;
                return false;
            }

            public static int b(Drawable r100) {
                int r101 = cp7.d.f464724a;
            L4:
                if ((r100 instanceof StateListDrawable) == false) goto L6;
                r100 = ((StateListDrawable) r100).getCurrent();
                goto L4
            L6:
                if (r100 != null) goto L9;
            L12:
                return 0;
            L9:
                if ((r100 instanceof ColorDrawable) == false) goto L18;
                int r102 = ((ColorDrawable) r100).getColor();
                if (Color.alpha(r102) < 5) goto L12;
                int r103 = Color.red(r102);
                int r104 = Color.green(r102);
                int r105 = Color.blue(r102);
                if (r103 <= 240) goto L18;
                if (r104 <= 240) goto L18;
                if (r105 <= 240) goto L18;
                return 2;
            L18:
                return 1;
            }
        }

        static {
        }

        public a() {
        }

        public abstract boolean a(cp7.b r100, View r101, int r102, int r103, int r104, int r105, int r106, int r107, a r108);
    }

    public interface b {
        int a();
    }

    /* JADX INFO: renamed from: cp7.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC5566c {
        public AbstractC5566c() {
        }

        public abstract void a(View r100, String r101, int r102, int r103);
    }

    public static abstract class d {
        public d() {
        }

        public abstract void a(String r100, long r101);

        public abstract void b(long r100);
    }

    public static abstract class e<T extends View> extends a {
        public abstract T b(View r100);

        public abstract int c(T r100);

        public e() {
        }

        @Override // cp7.c.a
        public final boolean a(cp7.b r100, View r101, int r102, int r110, int r111, int r112, int r113, int r114, a r115) {
            View r103 = b(r101);
            if (r103 != null) goto L5;
            return false;
        L5:
            if (a.C5565a.a(r101) == false) goto L7;
            int r104 = 0;
        L12:
            r100.a(r111, r112, r113, r114, r104);
            return true;
        L7:
            int r105 = c(r103);
            if (r105 != 0) goto L10;
            int r116 = a.C5565a.b(r101.getBackground());
        L11:
            r104 = r116;
            goto L12
        L10:
            r116 = r105;
            goto L11
        }
    }

    static {
    }
}
