package com.ss.android.lark.inline.ai.ui.richtext;

import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.ss.android.lark.inline.ai.ui.InlineAIEditText;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class InlineAiRichTextMovementMethod extends com.ss.android.lark.keyboard.edittext2.span.h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InlineAIEditText f427609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f427610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f427611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f427612i;

    public static final class a {
    }

    static {
    }

    public InlineAiRichTextMovementMethod(InlineAIEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        this.f427609f = r100;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.h, com.ss.android.lark.keyboard.edittext2.widget.o, android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(final TextView r110, Spannable r111, MotionEvent r210) {
        if (r110 == null) goto L75;
        if (r210 == null) goto L75;
        if (r111 == null) goto L75;
        int r100 = r210.getActionMasked();
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L11;
    L71:
        return super.onTouchEvent(r110, r111, r210);
    L11:
        float r101 = (r210.getX() - r110.getTotalPaddingLeft()) + r110.getScrollX();
        float r102 = (r210.getY() - r110.getTotalPaddingTop()) + r110.getScrollY();
        Layout r103 = r110.getLayout();
        int r104 = r103.getLineBottom(r103.getLineCount() - 1);
        int r112 = r103.getLineTop(0);
        int r113 = r103.getLineForVertical((int) r102);
        int r114 = r103.getOffsetForHorizontal(r113, r101);
        if (r104 < r102) goto L73;
        if (r112 > r102) goto L73;
        InlineAIAtSpanHolder.a[] r105 = (InlineAIAtSpanHolder.a[]) r111.getSpans(r114, r114, InlineAIAtSpanHolder.a.class);
        Intrinsics.checkNotNull(r105);
        if (r105.length != 0) goto L19;
        boolean r115 = true;
    L21:
        if ((!r115) == false) goto L71;
        InlineAIAtSpanHolder.a r106 = r105[0];
        int r116 = r111.getSpanStart(r106);
        int r117 = r111.getSpanEnd(r106);
        if (r114 < r111.length()) goto L27;
        return super.onTouchEvent(r110, r111, r210);
    L27:
        if ((r116 + 1) > r114) goto L30;
        if (r114 >= r117) goto L30;
        boolean r118 = true;
    L31:
        if (r118 == false) goto L33;
    L32:
        boolean r119 = true;
    L43:
        if (r119 == false) goto L45;
        if (r100 == 0) goto L68;
        if (r100 != 1) goto L71;
        if ((System.currentTimeMillis() - this.f427610g) < 500) goto L52;
        boolean r107 = true;
    L54:
        if (r113 == (r110.getLineCount() - 1)) goto L56;
    L58:
        boolean r108 = false;
    L59:
        int r120 = ViewConfiguration.get(r110.getContext()).getScaledTouchSlop();
        double r109 = 2;
        if ((((float) Math.pow(r101 - this.f427611h, r109)) + ((float) Math.pow(r102 - this.f427612i, r109))) <= (r120 * r120)) goto L62;
        boolean r121 = true;
    L63:
        if (r107 == true) goto L71;
        if (r108 == true) goto L71;
        if (r121 == true) goto L71;
        Log.i("InlineAiRichTextMovementMethod", "onClick: x is " + r101 + " , y is " + r102 + ", characterOffset is " + r114);
        r106.onClick(r110);
        r110.setShowSoftInputOnFocus(false);
        InlineAIEditText r122 = this.f427609f;
        Function0<Unit> r123 = new AnonymousClass1(r110);
        r122.getClass();
        Intrinsics.checkNotNullParameter(r123, "action");
        r122.f427420g = r123;
        return true;
    L62:
        r121 = false;
        goto L63
    L56:
        if (r101 <= r103.getLineRight(r110.getLineCount() - 1)) goto L58;
        r108 = true;
        goto L59
    L52:
        r107 = false;
        goto L54
    L68:
        this.f427611h = r101;
        this.f427612i = r102;
        this.f427610g = System.currentTimeMillis();
        return true;
    L45:
        return super.onTouchEvent(r110, r111, r210);
    L33:
        float r124 = r103.getPaint().measureText(String.valueOf(r111.charAt(r114)));
        float r125 = r103.getPrimaryHorizontal(r114);
        if (r114 == r116) goto L36;
        if (r114 == r117) goto L40;
    L42:
        r119 = false;
        goto L43
    L40:
        if ((r125 - (r124 / 2.0f)) < r101) goto L42;
    L36:
        if ((r125 + (r124 / 2.0f)) > r101) goto L42;
    L30:
        r118 = false;
        goto L31
    L19:
        r115 = false;
    L73:
        return super.onTouchEvent(r110, r111, r210);
    L75:
        return super.onTouchEvent(r110, r111, r210);
    }
}
