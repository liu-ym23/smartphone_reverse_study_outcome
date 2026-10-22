package hq5;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSearchbar f486510a;

    public c(WikiSearchbar r100) {
        this.f486510a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 3) goto L5;
        tt5.a.h("Wiki_WikiSearchbar", "keyboard search click. ");
        WikiSearchbar r103 = this.f486510a;
        int r104 = WikiSearchbar.f241065i;
        r103.getClass();
        rcb.c.d(r103);
        r103.getInputFromXml().setFocusableInTouchMode(true);
        r103.getInputFromXml().clearFocus();
    L5:
        return true;
    }
}
