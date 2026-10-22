package i45;

import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.document.toolbar.media.impl.SelectMediaViewModel;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public SelectMediaViewModel a;
    public Disposable b;
    public final /* synthetic */ c c;

    public class a implements SelectMediaViewModel.b {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }
    }

    public final void a() {
        SelectMediaViewModel r0 = (SelectMediaViewModel) ViewModelProviders.of(this.c.a.getActivity()).get(SelectMediaViewModel.class);
        this.a = r0;
        r0.setDelegate(new a(this));
    }

    public final void b() {
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        SelectMediaViewModel r1 = this.a;
        if (r1 == null) goto L11;
        r1.setDelegate(null);
        return;
    L11:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.b.dispose();
        goto L7
    }

    public b(c r1) {
        this.c = r1;
    }
}
