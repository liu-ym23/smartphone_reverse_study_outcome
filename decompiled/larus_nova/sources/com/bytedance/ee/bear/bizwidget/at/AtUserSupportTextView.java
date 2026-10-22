package com.bytedance.ee.bear.bizwidget.at;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ov4.b;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class AtUserSupportTextView extends AppCompatTextView {
    public AtUserSupportTextView(Context r100) {
        super(r100);
        setHighlightColor(r100.getResources().getColor(R.color.lkui_transparent));
    }

    public AtUserSupportTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setHighlightColor(r100.getResources().getColor(R.color.lkui_transparent));
    }

    public final void x(String r100, b r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        a.h("AtUserSupportTextView", "setMultiUserSpanText()...text is empty");
        return;
    L6:
        SpannableStringBuilder r102 = new SpannableStringBuilder(r100);
        int r103 = r100.indexOf("@");
        r102.delete(r103, r103 + 1);
        r102.setSpan(r101, r103, r101.f526902c.length() + r103, 17);
        setText(r102);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void y(String r100, List<b> r110) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        a.h("AtUserSupportTextView", "setMultiUserSpanText()...text is empty");
        return;
    L7:
        if (r100.contains("@") == true) goto L11;
        a.h("AtUserSupportTextView", "setMultiUserSpanText()...@ is not exit");
        setText(r100);
        return;
    L11:
        if (hu5.a.d(r110) == false) goto L14;
        a.h("AtUserSupportTextView", "setMultiUserSpanText()...userSpans is empty");
        setText(r100);
        return;
    L14:
        SpannableStringBuilder r101 = new SpannableStringBuilder(r100);
        Iterator r111 = ((ArrayList) r110).iterator();     // Catch: Exception -> L24
        int r102 = -1;
    L17:
        if (r111.hasNext() == false) goto L22;
        b r103 = (b) r111.next();     // Catch: Exception -> L24
        String r104 = "@" + r103.f526902c;     // Catch: Exception -> L24
        int r105 = r100.indexOf(r104, r102 + 1);     // Catch: Exception -> L24
        if (r105 == r102) goto L17;
        if (r105 == (-1)) goto L17;
        r101.setSpan(r103, r105, r104.length() + r105, 17);     // Catch: Exception -> L24
        r102 = r105;
        goto L17
    L22:
        setText(r101);     // Catch: Exception -> L24
    L26:
        setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L24:
        e = move-exception;
        a.d("AtUserSupportTextView", "setMultiUserSpanText fail: " + e);
        goto L26
    }

    public AtUserSupportTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setHighlightColor(r100.getResources().getColor(R.color.lkui_transparent));
    }
}
