package vj5;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.doc.translate.i;
import kotlin.jvm.internal.Intrinsics;
import sj5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a implements View.OnClickListener {
    public a() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        if (TextUtils.equals((CharSequence) r3.getTag(), "right_button") == false) goto L7;
        i.b r4 = (i.b) this;
        tt5.a.h("TranslateMoreItemV3", "translete more click");
        r4.a.translateV2(null);
        r4.c.k((String) r4.b.element);
        b r5 = r4.c.getHost();
        if (r5 == null) goto L11;
        r5.a();
        return;
    L11:
        return;
    L7:
        i.b r6 = (i.b) this;
        tt5.a.h("TranslateMoreItemV3", "translete click");
        r6.a.translateV2((String) r6.b.element);
        r6.c.k((String) r6.b.element);
        b r7 = r6.c.getHost();
        if (r7 == null) goto L13;
        r7.a();
        return;
    }
}
