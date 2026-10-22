package y81;

import android.view.ViewGroup;
import android.widget.TextSwitcher;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f566810a;

    public m(l r100) {
        this.f566810a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        l r101 = (l) r100;
        Integer r102 = this.f566810a.P;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.intValue() != 2) goto L25;
        ViewGroup r103 = this.f566810a.f566779n;
        if (r103 != null) goto L10;
    L14:
        TextSwitcher r104 = this.f566810a.H;
        if (r104 != null) goto L17;
    L21:
        TextSwitcher r105 = this.f566810a.H;
        if (r105 == null) goto L26;
        r105.setCurrentText(s1.B(R.string.ttlive_dou_plus_indicator_off));
        return;
    L26:
        return;
    L17:
        if (r104.getVisibility() != 8) goto L21;
        TextSwitcher r106 = this.f566810a.H;
        if (r106 == null) goto L21;
        r106.setVisibility(0);
        goto L21
    L10:
        if (r103.getVisibility() != 0) goto L14;
        ViewGroup r107 = this.f566810a.f566779n;
        if (r107 == null) goto L14;
        r107.setVisibility(8);
        goto L14
    }
}
