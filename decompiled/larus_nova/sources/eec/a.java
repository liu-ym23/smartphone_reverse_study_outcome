package eec;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends SpannableStringBuilder {
    public a(CharSequence r100) {
        String r101 = (String) r100;
        super(r101, 0, r101.length());
    }

    public final a a(CharSequence r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        int r101 = length();
        return (a) replace(r101, r101, r100, 0, r100.length());
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Editable append(CharSequence r100) {
        return a(r100);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final /* bridge */ /* synthetic */ SpannableStringBuilder append(CharSequence r100) {
        return a(r100);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence r100) throws IOException {
        return a(r100);
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence r100, Object r101, int r102) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        int r103 = length();
        a(r100);
        super.setSpan(r101, r103, length(), r102);
    L6:
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object r100, int r101, int r102, int r103) {
        super.setSpan(r100, r101, r102, r103);
    }
}
