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
import com.larus.nova.R;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class FormulaSignatureView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f238011a;

    public final void a() {
        setVisibility(8);
    }

    public FormulaSignatureView(Context r100) {
        this(r100, null);
    }

    public final void b(FormulaSignatureHelpData r110) {
        if (r110 != null) goto L4;
    L34:
        setVisibility(8);
        return;
    L4:
        if (r110.getFunctionName() == null) goto L34;
        int r100 = ContextCompat.getColor(getContext(), R.color.primary_pri_500);
        int r101 = ContextCompat.getColor(getContext(), R.color.text_caption);
        SpannableStringBuilder r102 = new SpannableStringBuilder();
        r102.append(r110.getFunctionName());
        r102.append('(');
        List<FormulaSignatureHelpData.Param> r103 = r110.getParams();
        int r104 = r110.getActiveParam();
        if (r103 == null) goto L27;
        int r105 = 0;
    L10:
        if (r105 >= r103.size()) goto L27;
        FormulaSignatureHelpData.Param r106 = (FormulaSignatureHelpData.Param) ListProtector.get(r103, r105);
        int r107 = r102.length();
        if (r106.getName() != null) goto L14;
        String r111 = "";
    L16:
        if (r106.isOptional() == false) goto L18;
        r102.append('[').append(r111).append(']');
    L19:
        int r108 = r102.length();
        if (r105 != r104) goto L22;
        r102.setSpan(new ForegroundColorSpan(r100), r107, r108, 33);
        r102.setSpan(new StyleSpan(1), r107, r108, 33);
    L24:
        if (r105 >= (r103.size() - 1)) goto L26;
        r102.append(", ");
    L26:
        r105 = r105 + 1;
        goto L10
    L22:
        r102.setSpan(new ForegroundColorSpan(r101), r107, r108, 33);
        goto L24
    L18:
        r102.append(r111);
        goto L19
    L14:
        r111 = r106.getName();
    L27:
        r102.append(')');
        if (r110.getReturnType() != null) goto L30;
    L32:
        this.f238011a.setText(r102);
        setVisibility(0);
        return;
    L30:
        if (r110.getReturnType().isEmpty() == true) goto L32;
        int r109 = r102.length();
        r102.append(" → ").append(r110.getReturnType());
        r102.setSpan(new ForegroundColorSpan(r101), r109, r102.length(), 33);
        goto L32
    }

    public FormulaSignatureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.sheet_formula_signature_view, this, true);
        this.f238011a = (TextView) findViewById(R.id.formula_signature_text);
        setVisibility(8);
    }
}
