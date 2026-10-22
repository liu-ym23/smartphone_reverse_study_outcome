package hq5;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements TextView.OnEditorActionListener {
    public final /* synthetic */ WikiSearchbar a;

    public c(WikiSearchbar r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 3) goto L5;
        tt5.a.h("Wiki_WikiSearchbar", "keyboard search click. ");
        WikiSearchbar r4 = this.a;
        int r5 = WikiSearchbar.i;
        r4.getClass();
        rcb.c.d(r4);
        r4.getInputFromXml().setFocusableInTouchMode(true);
        r4.getInputFromXml().clearFocus();
    L5:
        return true;
    }
}
