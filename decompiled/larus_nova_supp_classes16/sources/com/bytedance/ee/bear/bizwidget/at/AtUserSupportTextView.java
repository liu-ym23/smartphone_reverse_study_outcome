package com.bytedance.ee.bear.bizwidget.at;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ov4.b;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AtUserSupportTextView extends AppCompatTextView {
    /* JADX WARN: Multi-variable type inference failed */
    public AtUserSupportTextView(Context r2) {
        super(r2);
        setHighlightColor(r2.getResources().getColor(2131103546));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AtUserSupportTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        setHighlightColor(r1.getResources().getColor(2131103546));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(String r4, b r5) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        a.h("AtUserSupportTextView", "setMultiUserSpanText()...text is empty");
        return;
    L6:
        SpannableStringBuilder r0 = new SpannableStringBuilder(r4);
        int r6 = r4.indexOf("@");
        r0.delete(r6, r6 + 1);
        r0.setSpan(r5, r6, r5.c.length() + r6, 17);
        setText(r0);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(String r9, List<b> r10) {
        if (TextUtils.isEmpty(r9) == false) goto L7;
        a.h("AtUserSupportTextView", "setMultiUserSpanText()...text is empty");
        return;
    L7:
        if (r9.contains("@") == true) goto L11;
        a.h("AtUserSupportTextView", "setMultiUserSpanText()...@ is not exit");
        setText(r9);
        return;
    L11:
        if (hu5.a.d(r10) == false) goto L14;
        a.h("AtUserSupportTextView", "setMultiUserSpanText()...userSpans is empty");
        setText(r9);
        return;
    L14:
        SpannableStringBuilder r2 = new SpannableStringBuilder(r9);
        Iterator r11 = ((ArrayList) r10).iterator();     // Catch: Exception -> L24
        int r4 = -1;
    L17:
        if (r11.hasNext() == false) goto L22;
        b r5 = (b) r11.next();     // Catch: Exception -> L24
        String r6 = "@" + r5.c;     // Catch: Exception -> L24
        int r7 = r9.indexOf(r6, r4 + 1);     // Catch: Exception -> L24
        if (r7 == r4) goto L17;
        if (r7 == (-1)) goto L17;
        r2.setSpan(r5, r7, r6.length() + r7, 17);     // Catch: Exception -> L24
        r4 = r7;
        goto L17
    L22:
        setText(r2);     // Catch: Exception -> L24
    L26:
        setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L24:
        e = move-exception;
        a.d("AtUserSupportTextView", "setMultiUserSpanText fail: " + e);
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AtUserSupportTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setHighlightColor(r1.getResources().getColor(2131103546));
    }
}
