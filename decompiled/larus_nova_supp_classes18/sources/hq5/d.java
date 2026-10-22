package hq5;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnFocusChangeListener {
    public final /* synthetic */ WikiSearchbar a;

    public d(WikiSearchbar r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r2, boolean r3) {
        if (r3 == true) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(String.valueOf(this.a.getInputFromXml().getText())) == false) goto L10;
        WikiSearchbar r4 = this.a;
        r4.getClass();
        tt5.a.h("Wiki_WikiSearchbar", "input click. ");
        WikiSearchbar.c r5 = r4.f;
        if (r5 == null) goto L11;
        r5.a();
        return;
    L11:
        return;
    }
}
