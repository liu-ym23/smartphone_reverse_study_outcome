package v2b;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.ss.android.lark.widget.span.e0;

/* JADX INFO: loaded from: classes35.dex */
public final class f {
    public static void a(SpannableStringBuilder r100, Context r101) {
        if (r100.getSpans(r100.length() - 1, r100.length(), ImageSpan.class).length != 0) goto L5;
        boolean r102 = true;
    L7:
        if ((!r102) == false) goto L10;
        r100.append("\n\n");
        e0.a r103 = new e0.a();
        r103.f448672a = zz7.b.g(r101, 5);
        r100.setSpan(new e0(r103), r100.length() - 1, r100.length(), 33);
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L7
    }
}
