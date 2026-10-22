package hq5;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ WikiSearchbar a;

    public a(WikiSearchbar r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        WikiSearchbar r5 = this.a;
        int r0 = WikiSearchbar.i;
        r5.getClass();
        tt5.a.h("Wiki_WikiSearchbar", "clear click. ");
        r5.d = true;
        if (TextUtils.isEmpty(String.valueOf(r5.getInputFromXml().getText())) == true) goto L5;
        r5.getInputFromXml().setText("");
    L5:
        r5.getClearFromXml().setVisibility(8);
        r5.getCancelFromXml().setVisibility(0);
        r5.getInputFromXml().setFocusableInTouchMode(true);
        r5.getInputFromXml().setFocusable(true);
        r5.getInputFromXml().requestFocus();
        rcb.c.h(r5.getInputFromXml(), null);
    }
}
