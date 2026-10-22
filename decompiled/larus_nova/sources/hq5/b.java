package hq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSearchbar f486509a;

    public b(WikiSearchbar r100) {
        this.f486509a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WikiSearchbar r101 = this.f486509a;
        int r102 = WikiSearchbar.f241065i;
        r101.a();
    }
}
