package bi2;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryItemDecoration;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryNoBorderItemDecoration;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final a a = null;

    /* JADX INFO: renamed from: bi2.a$a, reason: collision with other inner class name */
    public static final class C0000a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0000a) == false) goto L14;
            C0000a r4 = (C0000a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "ItemPadding(left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ")";
        }

        public C0000a(int r1, int r2) {
            this.a = r1;
            this.b = 0;
            this.c = r2;
            this.d = 0;
        }
    }

    public a() {
    }

    public static int a(int r3, boolean r4, boolean r5) {
        if (r4 == true) goto L9;
        if (r3 == 1) goto L20;
        if (r3 == 2) goto L20;
        if (r3 == 3) goto L8;
        return 2131247953;
    L8:
        return 2131247954;
    L20:
        return 2131234300;
    L9:
        if (r5 == false) goto L15;
        if (r3 == 1) goto L20;
        if (r3 == 2) goto L20;
        if (r3 == 3) goto L14;
        return 2131247957;
    L14:
        return 2131247955;
    L15:
        if (r3 == 1) goto L20;
        if (r3 == 2) goto L20;
        if (r3 == 3) goto L19;
        return 2131247958;
    L19:
        return 2131247956;
    }

    static {
        a = new a();
    }

    public static Drawable c(String r1, int r2) {
        GradientDrawable r0 = new GradientDrawable();
        Integer r3 = s.b(r1);
        if (r3 == null) goto L5;
        r0.setColor(r3.intValue());
    L5:
        r0.setCornerRadius(UtilityKotlinExtentionsKt.c(Integer.valueOf(r2)));
        return r0;
    }

    public static RecyclerView.ItemDecoration b(int r23, boolean r24, boolean r25, int r26, int r27) {
        if (r23 == 2) goto L19;
        if (r23 == 3) goto L11;
        if (r23 == 4) goto L21;
        return new CategoryItemDecoration(r26, r27, null, null, null, null, null, null, 252);
    L21:
        return new CategoryNoBorderItemDecoration((int) 10.0f);
    L11:
        if (r24 == false) goto L14;
        CategoryItemDecoration r12 = new CategoryItemDecoration(r26, UtilityKotlinExtentionsKt.d(8), null, null, Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(0.0f))), Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(12.0f))), 0, Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(8.0f))), 12);
    L22:
        return r12;
    L14:
        if (r24 == true) goto L23;
        if (r25 == false) goto L23;
        r12 = new CategoryItemDecoration(r26, UtilityKotlinExtentionsKt.d(8), Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(0.0f))), Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(50.0f))), null, null, null, null, 240);
    L23:
        return new CategoryItemDecoration(r26, UtilityKotlinExtentionsKt.d(8), null, null, null, null, null, null, 252);
    L19:
        return new CategoryNoBorderItemDecoration(2);
    }
}
