package com.larksuite.common_selection;

import android.graphics.Path;
import android.graphics.Point;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class u implements s {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f282931a = null;

        static {
            int[] r100 = new int[SelectionGranularity.values().length];
            r100[SelectionGranularity.CHARACTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[SelectionGranularity.WORD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[SelectionGranularity.PARAGRAPH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[SelectionGranularity.ALL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f282931a = r100;
        }
    }

    public u() {
    }

    @Override // com.larksuite.common_selection.s
    public final boolean i(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return true;
    }

    @Override // com.larksuite.common_selection.s
    public final int a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof TextView) == true) goto L7;
        return 1;
    L7:
        return ((TextView) r100).getText().length();
    }

    @Override // com.larksuite.common_selection.s
    public final boolean h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return r100 instanceof TextView;
    }

    @Override // com.larksuite.common_selection.s
    public final float j(o r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        return 0.0f;
    }

    @Override // com.larksuite.common_selection.s
    public final Point d(o r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "point");
        View r102 = r100.f282908a;
        if ((r102 instanceof TextView) == false) goto L5;
        TextView r103 = (TextView) r102;
    L6:
        if (r103 == null) goto L8;
        int r104 = r103.getLeft();
        int r105 = r103.getTop();
        Point r106 = new Point();
        int r107 = 0;
        if (r103.getLayout() != null) goto L15;
        if (r101 == false) goto L13;
        r107 = r103.getWidth();
    L13:
        r106.x = r104 + r107;
        r106.y = r105 + r103.getHeight();
        return r106;
    L15:
        Layout r108 = r103.getLayout();
        int r109 = RangesKt.coerceIn(r100.f282909b, 0, r103.getText().length());
        int r110 = r108.getLineForOffset(r109);
        float r111 = r108.getPrimaryHorizontal(r109);
        int r112 = r108.getLineBottom(r110);
        r106.x = (r104 + r103.getPaddingLeft()) + ((int) r111);
        r106.y = (r105 + r103.getPaddingTop()) + r112;
        return r106;
    L8:
        return new Point();
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larksuite.common_selection.s
    public final p b(View r210, o r211, SelectionGranularity r212) {
        Intrinsics.checkNotNullParameter(r210, "view");
        Intrinsics.checkNotNullParameter(r211, "point");
        Intrinsics.checkNotNullParameter(r212, "granularity");
        if ((r210 instanceof TextView) == true) goto L5;
        return null;
    L5:
        int r100 = r211.f282909b;
        int r101 = a.f282931a[r212.ordinal()];
        if (r101 != 1) goto L8;
        TextView r102 = (TextView) r210;
        Intrinsics.checkNotNullParameter(r102, "view");
        IntRange r103 = new IntRange(r100, RangesKt.coerceIn(r100 + 1, 0, r102.getText().length()));
    L51:
        if (r103 != null) goto L53;
        return null;
    L53:
        return new p(new o(r210, r103.getFirst()), new o(r210, r103.getLast()));
    L8:
        if (r101 != 2) goto L10;
        CharSequence r104 = ((TextView) r210).getText();
        Intrinsics.checkNotNullParameter(r104, "text");
        if (r100 >= 0) goto L27;
    L49:
        r103 = null;
        goto L51
    L27:
        if (r100 > r104.length()) goto L49;
        if (r100 != r104.length()) goto L32;
    L33:
        if (r100 <= 0) goto L36;
        r100 = r100 - 1;
    L36:
        if (Character.isLetterOrDigit(r104.charAt(r100)) == false) goto L49;
        int r105 = r100;
    L39:
        if (r105 <= 0) goto L44;
        int r106 = r105 - 1;
        if (Character.isLetterOrDigit(r104.charAt(r106)) == false) goto L44;
        r105 = r106;
    L44:
        if (r100 >= (r104.length() - 1)) goto L48;
        int r107 = r100 + 1;
        if (Character.isLetterOrDigit(r104.charAt(r107)) == false) goto L48;
        r100 = r107;
    L48:
        r103 = new IntRange(r105, r100 + 1);
        goto L51
    L32:
        if (Character.isLetterOrDigit(r104.charAt(r100)) == true) goto L36;
    L10:
        if (r101 != 3) goto L12;
        CharSequence r108 = ((TextView) r210).getText();
        if (r100 < 0) goto L49;
        if (r100 > r108.length()) goto L49;
        String r109 = r108.toString();
        int r110 = StringsKt.lastIndexOf$default(r109, '\n', r100 - 1, false, 4, null) + 1;
        int r111 = StringsKt.indexOf$default(r109, '\n', r100, false, 4, null);
        if (r111 != (-1)) goto L23;
        r111 = r108.length();
    L23:
        r103 = new IntRange(r110, r111);
        goto L51
    L12:
        if (r101 != 4) goto L49;
        r103 = new IntRange(0, ((TextView) r210).getText().length());
        goto L51
    }

    @Override // com.larksuite.common_selection.s
    public final e c(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof TextView) == true) goto L5;
        return null;
    L5:
        CharSequence r103 = ((TextView) r100).getText();
        if (r101 >= 0) goto L8;
    L13:
        return null;
    L8:
        if (r102 > r103.length()) goto L13;
        if (r101 > r102) goto L13;
        return new e(r103.subSequence(r101, r102));
    }

    @Override // com.larksuite.common_selection.s
    public final o g(View r100, float r110, float r111) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r101 = 0;
        if ((r100 instanceof TextView) == false) goto L22;
        TextView r102 = (TextView) r100;
        if (r102.getLayout() == null) goto L22;
        Layout r103 = r102.getLayout();
        int r112 = r103.getLineForVertical(RangesKt.coerceIn((int) r111, 0, r103.getHeight() - 1));
        int r104 = r103.getOffsetForHorizontal(r112, r110);
        if (r104 >= (r103.getText().length() - 1)) goto L20;
        Intrinsics.checkNotNull(r103);
        int r105 = r104 + 1;
        if (r105 > 0) goto L13;
    L15:
        if (r101 == 0) goto L20;
        float r106 = r103.getPrimaryHorizontal(r104);
        float r113 = r103.getLineRight(r112);
        if (r110 <= (r113 - ((r113 - r106) / 2))) goto L20;
        r104 = r105;
        goto L20
    L13:
        if (r103.getLineForOffset(r105) <= r103.getLineForOffset(r105 - 1)) goto L15;
        r101 = 1;
    L20:
        return new o(r100, r104);
    L22:
        if (r110 < (r100.getWidth() / 2)) goto L26;
        r101 = 1;
    L26:
        return new o(r100, r101);
    }

    @Override // com.larksuite.common_selection.s
    public final void e(View r110, int r111, int r112, Path r113) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r113, "outPath");
        if ((r110 instanceof TextView) == false) goto L16;
        TextView r100 = (TextView) r110;
        if (r100.getLayout() == null) goto L16;
        Layout r114 = r100.getLayout();
        int r115 = RangesKt.coerceIn(r111, 0, r114.getText().length());
        int r116 = RangesKt.coerceIn(r112, 0, r114.getText().length());
        r113.reset();
        if (r115 >= r116) goto L18;
        r114.getSelectionPath(r115, r116, r113);
        int r101 = r114.getLineForOffset(r116 - 1);
        float r102 = r114.getLineBottom(r101);
        int r117 = RangesKt.coerceAtLeast(r114.getLineStart(r101), r115);
        int r118 = RangesKt.coerceAtMost(r114.getLineEnd(r101), r116);
        float r103 = r114.getPrimaryHorizontal(r117);
        float r104 = r114.getPrimaryHorizontal(r118);
        float r105 = r114.getLineTop(r101) + r114.getLineDescent(r101);
        if (r102 > r105) goto L12;
    L14:
        r113.offset(r100.getPaddingLeft(), r100.getPaddingTop());
        return;
    L12:
        if (r104 <= r103) goto L14;
        r113.addRect(r103, r105, r104, r102, Path.Direction.CW);
        goto L14
    L18:
        return;
    L16:
        r113.reset();
        r113.addRect(0.0f, 0.0f, r110.getWidth(), r110.getHeight(), Path.Direction.CW);
    }

    @Override // com.larksuite.common_selection.s
    public final float f(View r100, float r101, float r102, o r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "point");
        if ((r100 instanceof TextView) == false) goto L16;
        TextView r104 = (TextView) r100;
        if (r104.getLayout() == null) goto L18;
        Layout r105 = r104.getLayout();
        int r106 = r103.f282909b;
        float r107 = r105.getPrimaryHorizontal(r106);
        int r108 = r105.getLineForOffset(r106);
        float r109 = r105.getLineTop(r108);
        float r110 = r105.getLineBottom(r108);
        if (r102 >= r109) goto L11;
        float r111 = r109 - r102;
    L14:
        float r112 = r101 - r107;
        return (r112 * r112) + (r111 * r111);
    L11:
        if (r102 <= r110) goto L13;
        r111 = r102 - r110;
        goto L14
    L13:
        r111 = 0.0f;
        goto L14
    L18:
        return Float.MAX_VALUE;
    L16:
        return Float.MAX_VALUE;
    }
}
