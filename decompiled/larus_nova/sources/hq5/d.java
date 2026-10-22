package hq5;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSearchbar f486511a;

    public d(WikiSearchbar r100) {
        this.f486511a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == true) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(String.valueOf(this.f486511a.getInputFromXml().getText())) == false) goto L10;
        WikiSearchbar r102 = this.f486511a;
        r102.getClass();
        tt5.a.h("Wiki_WikiSearchbar", "input click. ");
        WikiSearchbar.c r103 = r102.f241071f;
        if (r103 == null) goto L11;
        r103.a();
        return;
    L11:
        return;
    }
}
