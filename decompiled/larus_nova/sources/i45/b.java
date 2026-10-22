package i45;

import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.document.toolbar.media.impl.SelectMediaViewModel;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SelectMediaViewModel f488213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f488214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f488215c;

    public class a implements SelectMediaViewModel.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f488216a;

        public a(b r100) {
            this.f488216a = r100;
        }
    }

    public final void a() {
        SelectMediaViewModel r100 = (SelectMediaViewModel) ViewModelProviders.of(this.f488215c.f488217a.getActivity()).get(SelectMediaViewModel.class);
        this.f488213a = r100;
        r100.setDelegate(new a(this));
    }

    public final void b() {
        Disposable r100 = this.f488214b;
        if (r100 != null) goto L5;
    L7:
        SelectMediaViewModel r101 = this.f488213a;
        if (r101 == null) goto L11;
        r101.setDelegate(null);
        return;
    L11:
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        this.f488214b.dispose();
        goto L7
    }

    public b(c r100) {
        this.f488215c = r100;
    }
}
