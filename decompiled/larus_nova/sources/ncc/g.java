package ncc;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class g extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f518742a;

    @Override // android.text.SpannableStringBuilder
    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.f518742a});
    }

    public g() {
        super("");
    }

    public g(CharSequence r100) {
        super(r100, 0, r100.length());
    }

    public final g a(CharSequence r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        int r101 = length();
        this.f518742a = r100;
        return (g) replace(r101, r101, r100, 0, r100.length());
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Editable append(CharSequence r100) {
        return a(r100);
    }

    @Override // android.text.SpannableStringBuilder
    public final boolean equals(Object r100) {
        if ((r100 instanceof Spanned) == true) goto L5;
    L26:
        return false;
    L5:
        if (toString().equals(r100.toString()) == false) goto L26;
        Spanned r101 = (Spanned) r100;
        Object[] r102 = getSpans(0, length(), Object.class);
        Object[] r103 = r101.getSpans(0, r101.length(), Object.class);
        if (r102.length != r103.length) goto L26;
        int r104 = 0;
    L10:
        if (r104 >= r102.length) goto L24;
        Object r105 = r102[r104];
        Object[] r106 = r101.getSpans(getSpanStart(r105), getSpanEnd(r105), r105.getClass());
        if (r106.length == 0) goto L13;
        Object r107 = r106[0];
        if (r105 == r107) goto L22;
        if (r105.equals(r107) == false) goto L23;
        if (getSpanFlags(r105) == r101.getSpanFlags(r107)) goto L22;
    L23:
        return false;
    L22:
        r104 = r104 + 1;
        goto L10
    L13:
        return false;
    L24:
        return true;
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
    public final /* bridge */ /* synthetic */ SpannableStringBuilder append(CharSequence r100, Object r101, int r102) {
        b(r100, r101, r102);
        return this;
    }

    public final void b(CharSequence r100, Object r101, int r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        int r103 = length();
        a(r100);
        this.f518742a = r100;
        setSpan(r101, r103, length(), r102);
        this.f518742a = null;
    }

    public final void c(CharSequence r100, Map r101, int r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        int r103 = length();
        a(r100);
        this.f518742a = r100;
        if (CollectionUtils.isEmpty(r101) == true) goto L11;
        Iterator r104 = r101.keySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        setSpan(r101.get((String) r104.next()), r103, length(), r102);
    L11:
        this.f518742a = null;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object r100, int r110, int r111, int r112) {
    L36:
        e = move-exception;
        Log.e("Span is:" + r100.getClass().getSimpleName() + ", start is:" + r110 + "end:" + r111);
        e.printStackTrace();
        return;
    L3:
        if ((r100 instanceof b) == false) goto L16;
        CharSequence r101 = this.f518742a;     // Catch: IndexOutOfBoundsException -> L36
        int r102 = 2;
        if (r101 != null) goto L7;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L14;
        r102 = 1;
    L14:
        b r104 = (b) r100;     // Catch: IndexOutOfBoundsException -> L36
        Object r105 = new b(r104.f518713c, r104.f518714d, r104.f518715e, true);     // Catch: IndexOutOfBoundsException -> L36
        Object r106 = new b(r104.f518713c, r104.f518714d, r104.f518715e, false);     // Catch: IndexOutOfBoundsException -> L36
        super.setSpan(r105, r110, r110 + r102, r112);     // Catch: IndexOutOfBoundsException -> L36
        super.setSpan(r106, r111 - r102, r111, r112);     // Catch: IndexOutOfBoundsException -> L36
        return;
    L7:
        if (r101.length() <= 2) goto L10;
        int r107 = com.ss.android.lark.widget.emoji.a.f445831a;     // Catch: IndexOutOfBoundsException -> L36
        CharSequence r108 = this.f518742a;     // Catch: IndexOutOfBoundsException -> L36
        r103 = com.ss.android.lark.widget.emoji.a.a(r108, r108.length() - 2);     // Catch: IndexOutOfBoundsException -> L36
        goto L11
    L16:
        if ((r100 instanceof a) == false) goto L19;
        a r109 = (a) r100;     // Catch: IndexOutOfBoundsException -> L36
        Object r113 = new a(r109.f518708a, true, r109.f518710c);     // Catch: IndexOutOfBoundsException -> L36
        Object r114 = new a(r109.f518708a, false, r109.f518710c);     // Catch: IndexOutOfBoundsException -> L36
        super.setSpan(r113, r110, r110 + 1, r112);     // Catch: IndexOutOfBoundsException -> L36
        super.setSpan(r114, r111 - 1, r111, r112);     // Catch: IndexOutOfBoundsException -> L36
        return;
    L19:
        if ((r100 instanceof c) == false) goto L34;
        c r115 = (c) r100;     // Catch: IndexOutOfBoundsException -> L36
        if ((r111 - r110) <= 15) goto L33;
        int r116 = r110;
    L23:
        if (r116 >= r111) goto L47;
        int r117 = r116 + 15;     // Catch: IndexOutOfBoundsException -> L36
        if (r117 < r111) goto L27;
        boolean r118 = true;
    L28:
        int r119 = Math.min(r117, r111);     // Catch: IndexOutOfBoundsException -> L36
        if (r118 == false) goto L31;
        c r120 = r115;
    L32:
        super.setSpan(r120, r116, r119, r112);     // Catch: IndexOutOfBoundsException -> L36
        r116 = r117;
        goto L23
    L31:
        r120 = new c(r115.f518720e);     // Catch: IndexOutOfBoundsException -> L36
        r120.f518722g = false;     // Catch: IndexOutOfBoundsException -> L36
        goto L32
    L27:
        r118 = false;
        goto L28
    L47:
        return;
    L33:
        super.setSpan(r100, r110, r111, r112);     // Catch: IndexOutOfBoundsException -> L36
        return;
    L34:
        super.setSpan(r100, r110, r111, r112);     // Catch: IndexOutOfBoundsException -> L36
    }
}
