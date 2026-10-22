package jqa;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.skydoves.balloon.IconGravity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f500102a = null;

        static {
            int[] r100 = new int[IconGravity.values().length];
            r100[IconGravity.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[IconGravity.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[IconGravity.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[IconGravity.END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f500102a = r100;
        }
    }

    public static final void a(TextView r100, lqa.a r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "vectorTextViewParams");
        Integer r102 = r101.f510375m;
        Drawable r103 = null;
        if (r102 != null) goto L13;
        Integer r104 = r101.f510379q;
        if (r104 == null) goto L7;
        r102 = Integer.valueOf(r100.getContext().getResources().getDimensionPixelSize(r104.intValue()));
    L8:
        if (r102 != null) goto L13;
        Integer r105 = r101.f510380r;
        if (r105 == null) goto L12;
        r102 = Integer.valueOf(r100.getContext().getResources().getDimensionPixelSize(r105.intValue()));
        goto L13
    L12:
        r102 = null;
        goto L13
    L7:
        r102 = null;
    L13:
        Integer r106 = r101.f510374l;
        if (r106 != null) goto L24;
        Integer r107 = r101.f510378p;
        if (r107 == null) goto L18;
        r106 = Integer.valueOf(r100.getContext().getResources().getDimensionPixelSize(r107.intValue()));
    L19:
        if (r106 != null) goto L24;
        Integer r108 = r101.f510380r;
        if (r108 == null) goto L23;
        r106 = Integer.valueOf(r100.getContext().getResources().getDimensionPixelSize(r108.intValue()));
        goto L24
    L23:
        r106 = null;
        goto L24
    L18:
        r106 = null;
    L24:
        Drawable r109 = r101.f510367e;
        if (r109 != null) goto L30;
        Integer r110 = r101.f510363a;
        if (r110 == null) goto L29;
        r109 = AppCompatResources.getDrawable(r100.getContext(), r110.intValue());
        goto L30
    L29:
        r109 = null;
    L30:
        if (r109 == null) goto L32;
        Drawable r111 = jqa.a.a(r109, r100.getContext(), r106, r102);
        jqa.a.b(r111, r101.f510377o);
    L33:
        Drawable r112 = r101.f510368f;
        if (r112 != null) goto L39;
        Integer r113 = r101.f510364b;
        if (r113 == null) goto L38;
        r112 = AppCompatResources.getDrawable(r100.getContext(), r113.intValue());
        goto L39
    L38:
        r112 = null;
    L39:
        if (r112 == null) goto L41;
        Drawable r114 = jqa.a.a(r112, r100.getContext(), r106, r102);
        jqa.a.b(r114, r101.f510377o);
    L42:
        Drawable r115 = r101.f510369g;
        if (r115 != null) goto L48;
        Integer r116 = r101.f510365c;
        if (r116 == null) goto L47;
        r115 = AppCompatResources.getDrawable(r100.getContext(), r116.intValue());
        goto L48
    L47:
        r115 = null;
    L48:
        if (r115 == null) goto L50;
        Drawable r117 = jqa.a.a(r115, r100.getContext(), r106, r102);
        jqa.a.b(r117, r101.f510377o);
    L51:
        Drawable r118 = r101.f510370h;
        if (r118 != null) goto L57;
        Integer r119 = r101.f510366d;
        if (r119 == null) goto L56;
        r118 = AppCompatResources.getDrawable(r100.getContext(), r119.intValue());
        goto L57
    L56:
        r118 = null;
    L57:
        if (r118 == null) goto L60;
        r103 = jqa.a.a(r118, r100.getContext(), r106, r102);
        jqa.a.b(r103, r101.f510377o);
    L60:
        if (r101.f510371i == false) goto L62;
        r100.setCompoundDrawablesWithIntrinsicBounds(r114, r103, r111, r117);
    L63:
        Integer r120 = r101.f510373k;
        if (r120 == null) goto L66;
        r100.setCompoundDrawablePadding(r120.intValue());
    L69:
        r100.setContentDescription(r101.f510372j);
        return;
    L66:
        Integer r121 = r101.f510376n;
        if (r121 == null) goto L69;
        r100.setCompoundDrawablePadding(r100.getContext().getResources().getDimensionPixelSize(r121.intValue()));
        goto L69
    L62:
        r100.setCompoundDrawablesWithIntrinsicBounds(r111, r103, r114, r117);
        goto L63
    L50:
        r117 = null;
        goto L51
    L41:
        r114 = null;
        goto L42
    L32:
        r111 = null;
        goto L33
    }
}
