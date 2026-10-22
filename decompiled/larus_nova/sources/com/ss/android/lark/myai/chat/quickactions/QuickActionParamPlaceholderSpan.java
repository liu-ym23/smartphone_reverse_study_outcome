package com.ss.android.lark.myai.chat.quickactions;

import android.text.Editable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.span.f;
import com.ss.android.lark.keyboard.edittext2.span.i;
import com.ss.android.lark.keyboard.edittext2.span.k;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/myai/chat/quickactions/QuickActionParamPlaceholderSpan;", "Landroid/text/style/ForegroundColorSpan;", "Lcom/ss/android/lark/keyboard/edittext2/span/InlineBlockSpan;", "Lcom/ss/android/lark/keyboard/edittext2/span/LongClickableSpan;", "<init>", "()V", "reselect", "Lcom/ss/android/lark/keyboard/edittext2/span/SelectionControlSpan$SelectResult;", "selStart", "", "selEnd", "text", "Landroid/text/Editable;", "onLongClick", "", "view", "Landroid/widget/TextView;", "Companion", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickActionParamPlaceholderSpan extends ForegroundColorSpan implements f, i {

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.f
    public final k.a a(int r100, int r101, Spannable r102) {
        throw null;
    }

    public QuickActionParamPlaceholderSpan() {
        super(UDColorUtils.getColor(LarkContext.getApplication(), R.color.text_placeholder));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.i
    public final void b(TextView r100) {
        Boolean r101 = null;
        if (r100 == null) goto L5;
        r101 = Boolean.valueOf(r100.performAccessibilityAction(32, null));
    L5:
        Log.i("QuickActionParamPlaceholderSpan", "perform onLongClick, call result is " + Intrinsics.areEqual(r101, Boolean.TRUE));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r100, int r101, Editable r102) {
        Intrinsics.checkNotNullParameter(r102, "text");
        int r103 = r102.getSpanStart(this);
        int r104 = r102.getSpanEnd(this);
        boolean r105 = false;
        if (r103 < 0) goto L6;
        if (r103 > r104) goto L6;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L10;
        return null;
    L10:
        if (r103 > r100) goto L13;
        if (r101 > r104) goto L13;
        r105 = true;
    L13:
        if (r105 == true) goto L15;
        IntRange r107 = new IntRange(r103 + 1, r104 - 1);
        if (r107.contains(r100) == false) goto L19;
        int r108 = r107.getFirst() - 1;
    L21:
        if (r107.contains(r101) == false) goto L23;
        int r109 = r107.getLast() + 1;
    L24:
        if (r108 != r100) goto L29;
        if (r109 != r101) goto L29;
        return null;
    L29:
        return f.a.b(r108, r109, r102);
    L23:
        r109 = r101;
        goto L24
    L19:
        r108 = r100;
        goto L21
    L15:
        return f.a.b(r103, r103, r102);
    L6:
        r106 = false;
        goto L8
    }
}
