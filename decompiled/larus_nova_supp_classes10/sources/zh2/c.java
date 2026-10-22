package zh2;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final void a(View r6, a r7) {
        Intrinsics.checkNotNullParameter(r6, "$this$setHeaderConstraint");
        if (r7 != null) goto L6;
        r6.setVisibility(8);
        return;
    L6:
        Integer r0 = r7.p;
        if (r0 == null) goto L9;
        r6.setPadding(UtilityKotlinExtentionsKt.d(Integer.valueOf(r0.intValue())), r6.getPaddingTop(), r6.getPaddingRight(), r6.getPaddingBottom());
    L9:
        Integer r1 = r7.h;
        if (r1 == null) goto L12;
        int r2 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r1.intValue()));
        r6.setPadding(r6.getPaddingLeft(), r2, r6.getPaddingRight(), r6.getPaddingBottom());
    L12:
        Integer r3 = r7.t;
        if (r3 == null) goto L15;
        int r4 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r3.intValue()));
        r6.setPadding(r6.getPaddingLeft(), r6.getPaddingTop(), r4, r6.getPaddingBottom());
    L15:
        Integer r5 = r7.l;
        if (r5 == null) goto L18;
        int r8 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r5.intValue()));
        r6.setPadding(r6.getPaddingLeft(), r6.getPaddingTop(), r6.getPaddingRight(), r8);
    L18:
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        if ((r9 instanceof ConstraintLayout.LayoutParams) == true) goto L21;
        r9 = null;
    L21:
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r9;
        if (r10 == null) goto L97;
        Integer r11 = r7.a;
        if (r11 == null) goto L26;
        ((ViewGroup.MarginLayoutParams) r10).width = UtilityKotlinExtentionsKt.d(Integer.valueOf(r11.intValue()));
    L26:
        Integer r12 = r7.b;
        if (r12 == null) goto L29;
        ((ViewGroup.MarginLayoutParams) r10).height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r12.intValue()));
    L29:
        Integer r13 = r7.c;
        boolean r14 = true;
        int r15 = 0;
        if (r13 == null) goto L32;
        int r16 = r13.intValue();
        r10.leftToLeft = r16;
        r10.rightToRight = r16;
        boolean r17 = true;
    L33:
        Integer r18 = r7.d;
        if (r18 == null) goto L36;
        int r19 = r18.intValue();
        r10.topToTop = r19;
        r10.bottomToBottom = r19;
    L37:
        int r20 = -1;
        if (r14 == true) goto L48;
        Integer r21 = r7.e;
        if (r21 == null) goto L42;
        int r22 = r21.intValue();
    L43:
        r10.topToTop = r22;
        Integer r23 = r7.f;
        if (r23 == null) goto L46;
        int r24 = r23.intValue();
    L47:
        r10.topToBottom = r24;
        goto L48
    L46:
        r24 = -1;
        goto L47
    L42:
        r22 = -1;
    L48:
        Integer r25 = r7.g;
        if (r25 == null) goto L51;
        int r26 = r25.intValue();
    L52:
        ((ViewGroup.MarginLayoutParams) r10).topMargin = UtilityKotlinExtentionsKt.d(Integer.valueOf(r26));
        if (r14 == true) goto L63;
        Integer r27 = r7.i;
        if (r27 == null) goto L57;
        int r28 = r27.intValue();
    L58:
        r10.bottomToTop = r28;
        Integer r29 = r7.j;
        if (r29 == null) goto L61;
        int r30 = r29.intValue();
    L62:
        r10.bottomToBottom = r30;
        goto L63
    L61:
        r30 = -1;
        goto L62
    L57:
        r28 = -1;
    L63:
        Integer r31 = r7.k;
        if (r31 == null) goto L66;
        int r32 = r31.intValue();
    L67:
        ((ViewGroup.MarginLayoutParams) r10).bottomMargin = UtilityKotlinExtentionsKt.d(Integer.valueOf(r32));
        if (r17 == true) goto L78;
        Integer r33 = r7.m;
        if (r33 == null) goto L72;
        int r34 = r33.intValue();
    L73:
        r10.leftToLeft = r34;
        Integer r35 = r7.n;
        if (r35 == null) goto L76;
        int r36 = r35.intValue();
    L77:
        r10.leftToRight = r36;
        goto L78
    L76:
        r36 = -1;
        goto L77
    L72:
        r34 = -1;
    L78:
        Integer r37 = r7.o;
        if (r37 == null) goto L81;
        int r38 = r37.intValue();
    L82:
        ((ViewGroup.MarginLayoutParams) r10).leftMargin = UtilityKotlinExtentionsKt.d(Integer.valueOf(r38));
        if (r17 == true) goto L92;
        Integer r39 = r7.q;
        if (r39 == null) goto L87;
        int r40 = r39.intValue();
    L88:
        r10.rightToLeft = r40;
        Integer r41 = r7.r;
        if (r41 == null) goto L91;
        r20 = r41.intValue();
    L91:
        r10.rightToRight = r20;
        goto L92
    L87:
        r40 = -1;
    L92:
        Integer r42 = r7.s;
        if (r42 == null) goto L95;
        r15 = r42.intValue();
    L95:
        ((ViewGroup.MarginLayoutParams) r10).rightMargin = UtilityKotlinExtentionsKt.d(Integer.valueOf(r15));
        r6.setLayoutParams(r10);
        return;
    L81:
        r38 = 0;
        goto L82
    L66:
        r32 = 0;
        goto L67
    L51:
        r26 = 0;
        goto L52
    L36:
        r14 = false;
        goto L37
    L32:
        r17 = false;
        goto L33
    }
}
