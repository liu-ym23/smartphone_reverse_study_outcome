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

/* JADX INFO: loaded from: classes16.dex */
public final class a extends m75.a<o55.b> implements i<o55.b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f497455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.biz.importfile.im.data.a f497456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f497457g;

    /* JADX INFO: renamed from: j55.a$a, reason: collision with other inner class name */
    public static final class C6394a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f497458a = null;

        static {
            f497458a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            return (x) org.koin.java.a.c(x.class, null, null, 6);
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T, R> f497459a = null;

        static {
            f497459a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            x r101 = (x) r100;
            Intrinsics.checkNotNullParameter(r101, "hostService");
            r101.r();
            return "";
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f497460a = null;

        static {
            f497460a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            tt5.a.h("ImImportFilePresenter", "hostService goToCustomService Success ");
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f497461a = null;

        static {
            f497461a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("ImImportFilePresenter", "hostService goToCustomService Fail", (Throwable) r100, false);
        }
    }

    static {
    }

    @Override // i55.i
    public final /* synthetic */ void a(ImportFileEntity r100) {
    }

    @Override // i55.i
    public final /* synthetic */ void b() {
    }

    @Override // i55.i
    public final /* synthetic */ String c() {
        return h.a();
    }

    @Override // i55.i
    public final /* synthetic */ void g(LiveData r100) {
    }

    @Override // i55.i
    public final void d() {
        ((o55.b) this.f512352a).W40();
        if (this.f497455e > ((((Number) com.bytedance.ee.bear.appsetting.c.a.f206237a.d("drive_convert_file_size_limit", 20)).intValue() * 1024) * 1024)) goto L12;
        tt5.a.h("ImImportFilePresenter", "startImport");
        CompositeDisposable r100 = this.f497457g;
        com.bytedance.ee.bear.drive.biz.importfile.im.data.a r101 = this.f497456f;
        r101.getClass();
        StringBuilder r102 = new StringBuilder("startImport msgId=");
        r102.append(r101.f223043b);
        r102.append(", hasSourceId=");
        String r103 = r101.f223044c;
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        r102.append(!r104);
        tt5.a.h("ImImportFileModel", r102.toString());
        r101.f223046e.a(r101.f223045d, "start_import_file");
        final String r105 = r101.f223043b;
        final String r106 = r101.f223044c;
        r100.add(Flowable.create(new ImImportFileModel$pullChatToken$1(r105, r106), BackpressureStrategy.BUFFER).doOnNext(j.f223056a).flatMap(new k(r101)).delay(1, TimeUnit.SECONDS).doOnError(new l(r101)).flatMap(new m(r101)).doOnError(new n(r101)).observeOn(fo5.d.d()).subscribe(new j55.b(this), new j55.c(this)));
        return;
    L7:
        if (r103.length() == 0) goto L10;
        r104 = false;
        goto L11
    L12:
        tt5.a.d("ImImportFilePresenter", "size too large..");
        ((o55.b) this.f512352a).Do(ImportFailedType.FailedSize, -1);
        ((o55.b) this.f512352a).Fh(this.f497455e);
    }

    @Override // i55.i
    public final void r() {
        Flowable.just("").subscribeOn(fo5.d.b()).map(b.f497458a).map(c.f497459a).subscribe(d.f497460a, e.f497461a);
    }

    @Override // m75.a, m75.d
    public final void detachView() {
        super.detachView();
        this.f497457g.clear();
    }

    @Override // i55.i
    public final CompositeDisposable getCompositeDisposable() {
        return this.f497457g;
    }

    public a(FragmentActivity r100, long r101, com.bytedance.ee.bear.drive.biz.importfile.im.data.a r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r102, "importModel");
        super(r100);
        this.f497455e = r101;
        this.f497456f = r102;
        this.f497457g = new CompositeDisposable();
    }
}
