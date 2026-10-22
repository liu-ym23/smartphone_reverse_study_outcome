package o92;

import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.livesdk.interactivity.common.utils.LiveHighlightAppLogger;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f522459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f522460b;

    public a(b r100) {
        this.f522459a = r100;
        this.f522460b = 0;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        int r102 = this.f522459a.f522462b.getCurrentItem();
        int r103 = r102 + 1;
        PagerAdapter r104 = this.f522459a.f522462b.getAdapter();
        if (r104 != null) goto L5;
    L13:
        if (r102 != r103) goto L15;
    L17:
        this.f522459a.f522462b.setCurrentItem(r103);
        return;
    L15:
        if (this.f522459a.f522464d == false) goto L17;
        LiveHighlightAppLogger.c(this.f522460b);
        goto L17
    L5:
        if (r103 != r104.getCount()) goto L13;
        b r105 = this.f522459a;
        if (r105.f522465e == true) goto L12;
        Disposable r106 = r105.f522461a;
        if (r106 == null) goto L11;
        r106.dispose();
    L11:
        r105.f522461a = null;
        goto L13
    L12:
        r103 = 0;
        goto L13
    }
}
