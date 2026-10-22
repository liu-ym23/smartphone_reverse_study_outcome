package hq5;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSearchbar f486508a;

    public a(WikiSearchbar r100) {
        this.f486508a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WikiSearchbar r101 = this.f486508a;
        int r102 = WikiSearchbar.f241065i;
        r101.getClass();
        tt5.a.h("Wiki_WikiSearchbar", "clear click. ");
        r101.f241069d = true;
        if (TextUtils.isEmpty(String.valueOf(r101.getInputFromXml().getText())) == true) goto L5;
        r101.getInputFromXml().setText("");
    L5:
        r101.getClearFromXml().setVisibility(8);
        r101.getCancelFromXml().setVisibility(0);
        r101.getInputFromXml().setFocusableInTouchMode(true);
        r101.getInputFromXml().setFocusable(true);
        r101.getInputFromXml().requestFocus();
        rcb.c.h(r101.getInputFromXml(), null);
    }
}
