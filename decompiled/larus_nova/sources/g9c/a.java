package g9c;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f480537a = 0;

    /* JADX INFO: renamed from: g9c.a$a, reason: collision with other inner class name */
    public static final class C5997a {
        public static Drawable a(float r100, int r101, int r102, int r103) {
            GradientDrawable r104 = new GradientDrawable();
            r104.setShape(0);
            if (r100 <= 0.0f) goto L5;
            r104.setCornerRadius(r100);
        L5:
            r104.setColor(r101);
            r104.setStroke(r102, r103);
            return r104;
        }
    }

    static {
    }
}
