package pc5;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.middleground.drive.export.ProgressingEntity;
import com.bytedance.ee.bear.widgets.t;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends LinearLayout {
    public static final /* synthetic */ int h = 0;
    public AppCompatImageView a;
    public TextView b;
    public q c;
    public c d;
    public b e;
    public String f;
    public final CompositeDisposable g;

    public class a extends t {
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ i f;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r6) {
            CompositeDisposable r7 = this.f.g;
            Flowable r0 = Flowable.just("");
            final String r1 = this.c;
            final String r2 = this.d;
            final String r3 = this.e;
            r7.add(r0.doOnNext(new f(this, r1, r2, r3)).subscribe(new g(), new h()));
        }

        public a(i r1, String r2, String r3, String r4) {
            this.f = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
        }
    }

    public static class b implements rf5.e {
        public final WeakReference<i> a;

        @Override // rf5.e
        public final void onExistUploadingFile() {
            tt5.a.h("DriveUploadView", "onExistUploadingFile()...");
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new m(this));
        }

        @Override // rf5.e
        public final void onUploadFinished() {
            tt5.a.h("DriveUploadView", "onUploadFinished()...");
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new o(this));
        }

        public b(i r2) {
            this.a = new WeakReference(r2);
        }

        @Override // rf5.e
        public final void onUploadError(int r3) {
            tt5.a.h("DriveUploadView", "onUploadError()...");
            Flowable.just(Integer.valueOf(r3)).observeOn(fo5.d.d()).subscribe(new j(this));
        }

        @Override // rf5.e
        public final void onFileCountChange(final int r3, final int r4) {
            tt5.a.h("DriveUploadView", "onFileCountChange()...");
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new k(this, r3, r4));
        }

        @Override // rf5.e
        public final void onFileProgressChange(int r2, ProgressingEntity r3) {
            tt5.a.h("DriveUploadView", "onFileProgressChange()...");
            Flowable.just(Integer.valueOf(r2)).observeOn(fo5.d.d()).subscribe(new p(this));
        }

        @Override // rf5.e
        public final void onUploadFileSuccess(String r3, final rf5.d r4) {
            tt5.a.h("DriveUploadView", "onUploadFileSuccess()... key =" + r3 + ", token = " + yu5.c.j(r4.a) + ", nodeToken: " + yu5.c.j(r4.b));
            Flowable.just("").observeOn(fo5.d.d()).subscribe(new n(this, r4));
        }

        @Override // rf5.e
        public final void onUploadErrorCode(String r1, final int r2, long r3) {
            tt5.a.h("DriveUploadView", "onUploadErrorCode()...");
            Flowable.just("").observeOn(fo5.d.d()).subscribe(new l(this, r2));
        }
    }

    public interface c {
        void j0();

        void k(rf5.d r1);

        void o0();
    }

    public final void b() {
        tt5.a.h("DriveUploadView", "unObserveProgress. ");
        if (this.e != null) goto L5;
        return;
    L5:
        this.g.add(Flowable.just("").doOnNext(new pc5.a(this)).subscribe(new pc5.b(), new pc5.c()));
    }

    public final void c() {
        q r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.b + 1;
        int r3 = r0.c;
        if (r3 != 0) goto L9;
        r1 = 0;
    L9:
        if (r0.d != 16) goto L11;
        int r2 = r0.a;
        this.a.setImageResource(2131256189);
        com.bytedance.ee.util.ui.l.c(this.a, 2131102189);
        this.a.clearAnimation();
        this.b.setText(getContext().getResources().getQuantityString(2131755021, r2, new Object[]{Integer.valueOf(r2)}));
        return;
    L11:
        this.a.setImageResource(2131254277);
        com.bytedance.ee.util.ui.l.c(this.a, 2131105548);
        if (this.a.getAnimation() != null) goto L14;
        this.a.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772212));
    L14:
        this.b.setText(getContext().getString(2131888457) + String.format(Locale.CHINA, " %d/%d", new Object[]{Integer.valueOf(r1), Integer.valueOf(r3)}));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g.clear();
    }

    public i(Context r2) {
        super(r2);
        this.g = new CompositeDisposable();
        View.inflate(getContext(), 2131563517, this);
        this.a = findViewById(2131391921);
        this.b = (TextView) findViewById(2131391936);
    }

    public void setViewDelegate(c r1) {
        this.d = r1;
    }

    public final void a(final String r5, final String r6, String r7) {
        tt5.a.h("DriveUploadView", "observeProgress, key: " + du5.b.g(r5) + ", mountPoint: " + r6);
        this.f = r5;
        if (this.e != null) goto L6;
        this.e = new b(this);
        this.g.add(Flowable.just("").doOnNext(new d(this, r5, r6)).subscribe(new pc5.b(), new e()));
        setOnClickListener(new a(this, r5, r6, r7));
        return;
    }
}
