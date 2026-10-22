package j55;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.x;
import com.bytedance.ee.bear.drive.biz.importfile.im.data.ImImportFileModel$pullChatToken$1;
import com.bytedance.ee.bear.drive.biz.importfile.im.data.j;
import com.bytedance.ee.bear.drive.biz.importfile.im.data.k;
import com.bytedance.ee.bear.drive.biz.importfile.im.data.l;
import com.bytedance.ee.bear.drive.biz.importfile.im.data.m;
import com.bytedance.ee.bear.drive.biz.importfile.im.data.n;
import com.bytedance.ee.bear.drive.biz.importfile.request.error.ImportFailedType;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import i55.h;
import i55.i;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends m75.a<o55.b> implements i<o55.b> {
    public final long e;
    public final com.bytedance.ee.bear.drive.biz.importfile.im.data.a f;
    public final CompositeDisposable g;

    /* JADX INFO: renamed from: j55.a$a, reason: collision with other inner class name */
    public static final class C0241a {
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            return (x) org.koin.java.a.c(x.class, null, null, 6);
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            x r3 = (x) r2;
            Intrinsics.checkNotNullParameter(r3, "hostService");
            r3.r();
            return "";
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            tt5.a.h("ImImportFilePresenter", "hostService goToCustomService Success ");
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            tt5.a.e("ImImportFilePresenter", "hostService goToCustomService Fail", (Throwable) r4, false);
        }
    }

    static {
    }

    @Override // i55.i
    public final /* synthetic */ void a(ImportFileEntity r1) {
    }

    @Override // i55.i
    public final /* synthetic */ void b() {
    }

    @Override // i55.i
    public final /* synthetic */ String c() {
        return h.a();
    }

    @Override // i55.i
    public final /* synthetic */ void g(LiveData r1) {
    }

    @Override // i55.i
    public final void d() {
        ((o55.b) this.a).W40();
        if (this.e > ((((Number) com.bytedance.ee.bear.appsetting.c.a.a.d("drive_convert_file_size_limit", 20)).intValue() * 1024) * 1024)) goto L12;
        tt5.a.h("ImImportFilePresenter", "startImport");
        CompositeDisposable r0 = this.g;
        com.bytedance.ee.bear.drive.biz.importfile.im.data.a r1 = this.f;
        r1.getClass();
        StringBuilder r2 = new StringBuilder("startImport msgId=");
        r2.append(r1.b);
        r2.append(", hasSourceId=");
        String r3 = r1.c;
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        r2.append(!r4);
        tt5.a.h("ImImportFileModel", r2.toString());
        r1.e.a(r1.d, "start_import_file");
        final String r5 = r1.b;
        final String r6 = r1.c;
        r0.add(Flowable.create(new ImImportFileModel$pullChatToken$1(r5, r6), BackpressureStrategy.BUFFER).doOnNext(j.a).flatMap(new k(r1)).delay(1, TimeUnit.SECONDS).doOnError(new l(r1)).flatMap(new m(r1)).doOnError(new n(r1)).observeOn(fo5.d.d()).subscribe(new j55.b(this), new j55.c(this)));
        return;
    L7:
        if (r3.length() == 0) goto L10;
        r4 = false;
        goto L11
    L12:
        tt5.a.d("ImImportFilePresenter", "size too large..");
        ((o55.b) this.a).Do(ImportFailedType.FailedSize, -1);
        ((o55.b) this.a).Fh(this.e);
    }

    @Override // i55.i
    public final void r() {
        Flowable.just("").subscribeOn(fo5.d.b()).map(b.a).map(c.a).subscribe(d.a, e.a);
    }

    @Override // m75.a, m75.d
    public final void detachView() {
        super.detachView();
        this.g.clear();
    }

    @Override // i55.i
    public final CompositeDisposable getCompositeDisposable() {
        return this.g;
    }

    public a(FragmentActivity r2, long r3, com.bytedance.ee.bear.drive.biz.importfile.im.data.a r5) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r5, "importModel");
        super(r2);
        this.e = r3;
        this.f = r5;
        this.g = new CompositeDisposable();
    }
}
