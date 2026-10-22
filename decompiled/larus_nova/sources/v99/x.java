package v99;

import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class x implements fya.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f553871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f553872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f553873c;

    public static final class a {
    }

    static {
    }

    public x() {
    }

    @Override // fya.a.d
    public final boolean isLoading() {
        return this.f553873c;
    }

    @Override // fya.a.d
    public final void b(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        int r101 = 0;
        this.f553873c = false;
        ValueAnimator r102 = this.f553872b;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        this.f553872b = null;
        CharSequence r103 = r100.getText();
        y r104 = this.f553871a;
        if (r104 != null) goto L8;
    L15:
        if (r104 != null) goto L17;
    L24:
        this.f553871a = null;
        if ((r100 instanceof EditText) == false) goto L31;
        EditText r105 = (EditText) r100;
        Editable r106 = r105.getText();
        if (r106 == null) goto L29;
        r101 = r106.length();
    L29:
        r105.setSelection(r101);
        return;
    L31:
        return;
    L17:
        if ((r103 instanceof Spannable) == false) goto L24;
        Spannable r107 = (Spannable) r103;
        int r108 = r107.getSpanStart(r104);
        int r109 = r107.getSpanEnd(r104);
        r107.removeSpan(r104);
        if (r108 < 0) goto L24;
        if (r109 < r108) goto L24;
        if (r109 > r107.length()) goto L24;
        r100.setText(new SpannableStringBuilder(r103).delete(r108, r109));
        goto L24
    L8:
        if ((r103 instanceof Editable) == false) goto L15;
        Editable r110 = (Editable) r103;
        int r111 = r110.getSpanStart(r104);
        int r112 = r110.getSpanEnd(r104);
        r110.removeSpan(r104);
        if (r111 < 0) goto L24;
        if (r112 < r111) goto L24;
        if (r112 > r110.length()) goto L24;
        r110.delete(r111, r112);
        goto L24
    }

    @Override // fya.a.d
    public final void a(final TextView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        if (this.f553873c == false) goto L6;
        return;
    L6:
        if (r101 == false) goto L8;
        int r102 = R.drawable.larus_dot_immers;
    L9:
        this.f553871a = new y(r102, r100.getContext());
        Editable r103 = ((EditText) r100).getEditableText();
        if (r103 != null) goto L12;
        return;
    L12:
        this.f553873c = true;
        r103.append(" ");
        y r104 = this.f553871a;
        int r105 = 0;
        if (r104 == null) goto L16;
        r103.setSpan(r104, RangesKt.coerceAtLeast(r103.length() - 1, 0), r103.length(), 17);
    L16:
        EditText r106 = (EditText) r100;
        Editable r107 = r106.getText();
        if (r107 == null) goto L19;
        r105 = r107.length();
    L19:
        r106.setSelection(r105);
        ValueAnimator r108 = ValueAnimator.ofInt(new int[]{0, 255});
        r108.setDuration(400);
        r108.setRepeatCount(-1);
        r108.setRepeatMode(2);
        r108.addUpdateListener(new w(this, r100));
        r108.start();
        this.f553872b = r108;
        return;
    L8:
        r102 = R.drawable.larus_chat_common_loading_dot;
        goto L9
    }
}
