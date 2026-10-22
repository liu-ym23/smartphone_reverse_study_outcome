package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.larus.nova.R;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f529733a = null;

    public static class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f529734c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f529735d;

        public a() {
            this.f529734c = 0;
            this.f529735d = 0;
        }

        public a(ImageView r100, AttributeSet r101, int r102) {
            super(r100, r101, r102);
            this.f529734c = a(r100, r101, true);
            this.f529735d = a(r100, r101, false);
        }

        public static int a(ImageView r100, AttributeSet r101, boolean r102) {
            if (r102 == false) goto L4;
            String r103 = "src";
        L5:
            int r104 = r101.getAttributeResourceValue("http://schemas.android.com/apk/res/android", r103, 0);
            if (r104 <= 0) goto L12;
            String r105 = r100.getResources().getResourceTypeName(r104);
            if (i.f529733a.contains(r105) == false) goto L12;
            if (i.c(r100, r102, r104) == true) goto L12;
            return r104;
        L12:
            return 0;
        L4:
            r103 = "background";
            goto L5
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f529736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f529737b;

        public b() {
            this.f529736a = false;
            this.f529737b = -1;
        }

        public b(View r100, AttributeSet r101, int r102) {
            TypedArray r103 = r100.getContext().obtainStyledAttributes(r101, new int[]{R.attr.freezesAnimation, R.attr.loopCount}, r102, 0);
            this.f529736a = r103.getBoolean(0, false);
            this.f529737b = r103.getInt(1, -1);
            r103.recycle();
        }
    }

    static {
        f529733a = Arrays.asList(new String[]{TemplateNodeType.RAW, "drawable", "mipmap"});
    }

    public static void a(int r100, Drawable r101) {
        if ((r101 instanceof d) == false) goto L6;
        ((d) r101).f529714g.z(r100);
        return;
    }

    public static a b(ImageView r100, AttributeSet r101, int r102) {
        if (r101 == null) goto L10;
        if (r100.isInEditMode() == true) goto L10;
        a r103 = new a(r100, r101, r102);
        int r104 = r103.f529737b;
        if (r104 < 0) goto L8;
        a(r104, r100.getDrawable());
        a(r104, r100.getBackground());
    L8:
        return r103;
    L10:
        return new a();
    }

    public static boolean c(ImageView r100, boolean r101, int r102) {
        Resources r103 = r100.getResources();
        if (r103 != null) goto L15;
    L13:
        return false;
    L15:
        String r104 = r103.getResourceTypeName(r102);     // Catch: Throwable -> L14
        if (f529733a.contains(r104) == true) goto L7;
        return false;
    L7:
        d r105 = new d(r103, r102);     // Catch: Throwable -> L14
        if (r101 == false) goto L10;
        r100.setImageDrawable(r105);     // Catch: Throwable -> L14
        return true;
    L10:
        r100.setBackground(r105);     // Catch: Throwable -> L14
        return true;
    }
}
