package com.bytedance.ee.bear.sheet.inputbar.formula;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FormulaSignatureView extends FrameLayout {
    public final TextView a;

    public final void a() {
        setVisibility(8);
    }

    public FormulaSignatureView(Context r2) {
        this(r2, null);
    }

    public final void b(FormulaSignatureHelpData r13) {
        if (r13 != null) goto L4;
    L34:
        setVisibility(8);
        return;
    L4:
        if (r13.getFunctionName() == null) goto L34;
        int r0 = ContextCompat.getColor(getContext(), 2131105568);
        int r1 = ContextCompat.getColor(getContext(), 2131106607);
        SpannableStringBuilder r2 = new SpannableStringBuilder();
        r2.append(r13.getFunctionName());
        r2.append('(');
        List<FormulaSignatureHelpData.Param> r3 = r13.getParams();
        int r4 = r13.getActiveParam();
        if (r3 == null) goto L27;
        int r7 = 0;
    L10:
        if (r7 >= r3.size()) goto L27;
        FormulaSignatureHelpData.Param r8 = (FormulaSignatureHelpData.Param) ListProtector.get(r3, r7);
        int r9 = r2.length();
        if (r8.getName() != null) goto L14;
        String r10 = "";
    L16:
        if (r8.isOptional() == false) goto L18;
        r2.append('[').append(r10).append(']');
    L19:
        int r11 = r2.length();
        if (r7 != r4) goto L22;
        r2.setSpan(new ForegroundColorSpan(r0), r9, r11, 33);
        r2.setSpan(new StyleSpan(1), r9, r11, 33);
    L24:
        if (r7 >= (r3.size() - 1)) goto L26;
        r2.append(", ");
    L26:
        r7 = r7 + 1;
        goto L10
    L22:
        r2.setSpan(new ForegroundColorSpan(r1), r9, r11, 33);
        goto L24
    L18:
        r2.append(r10);
        goto L19
    L14:
        r10 = r8.getName();
    L27:
        r2.append(')');
        if (r13.getReturnType() != null) goto L30;
    L32:
        this.a.setText(r2);
        setVisibility(0);
        return;
    L30:
        if (r13.getReturnType().isEmpty() == true) goto L32;
        int r5 = r2.length();
        r2.append(" → ").append(r13.getReturnType());
        r2.setSpan(new ForegroundColorSpan(r1), r5, r2.length(), 33);
        goto L32
    }

    public FormulaSignatureView(Context r2, AttributeSet r3) {
        super(r2, r3);
        LayoutInflater.from(r2).inflate(2131564567, this, true);
        this.a = (TextView) findViewById(2131373224);
        setVisibility(8);
    }
}
