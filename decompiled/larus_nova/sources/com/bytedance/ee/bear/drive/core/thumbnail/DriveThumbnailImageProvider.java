package com.bytedance.ee.bear.drive.core.thumbnail;

import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.drive.loader.download.platform.api.DriveImagePreviewLoader;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.util.glide.BearGlideUrl;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import s45.p;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveThumbnailImageProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f224290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f224291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f224292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DriveImagePreviewLoader f224293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, h75.a> f224294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f224295f;

    public static final class a {
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f224296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Disposable f224297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DriveThumbnailImageProvider f224298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f224299d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<h75.a> f224300e;

        public b(AtomicBoolean r100, Disposable r101, DriveThumbnailImageProvider r102, String r103, Ref.ObjectRef<h75.a> r104) {
            this.f224296a = r100;
            this.f224297b = r101;
            this.f224298c = r102;
            this.f224299d = r103;
            this.f224300e = r104;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f224296a.set(true);
            this.f224297b.dispose();
            DriveThumbnailImageProvider r100 = this.f224298c;
            String r101 = this.f224299d;
            h75.a r102 = this.f224300e.element;
            if (r102 != null) goto L5;
            r100.getClass();
        L6:
            this.f224300e.element = null;
            return;
        L5:
            r100.c(r101, r102);
            r102.cancel();
            goto L6
        }
    }

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveThumbnailImageProvider f224301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f224302b;

        public c(DriveThumbnailImageProvider r100, String r101) {
            this.f224301a = r100;
            this.f224302b = r101;
        }

        @Override // java.util.concurrent.Callable
        public final g call() {
            DriveThumbnailImageProvider r100 = this.f224301a;
            String r101 = this.f224302b;
            w85.b r102 = ((w85.c) r100.f224290a.getValue()).c(r101, DownloadRequestInfo.DownloadType.COVER);
            if (r102 != null) goto L29;
        L20:
            File r103 = null;
        L21:
            if (r102 == null) goto L25;
            InputStream r104 = r102.f558652a;
            if (r104 == null) goto L25;
            r104.close();
        L25:
            if (r103 == null) goto L28;
            return new g.a(r103);
        L28:
            return g.b.f224375a;
        L29:
            r103 = r102.f558653b;     // Catch: Throwable -> L15
            if (r103 == null) goto L20;
            if (r103.exists() == false) goto L12;
            if (r103.length() <= 0) goto L12;
            boolean r105 = true;
        L13:
            if (r105 == false) goto L20;
        L12:
            r105 = false;
        L15:
            th = move-exception;
            InputStream r106 = r102.f558652a;
            if (r106 == null) goto L19;
            r106.close();
        L19:
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveThumbnailImageProvider f224303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f224304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f224305c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f224306d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1<i, Unit> f224307e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f224308f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f224309g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<h75.a> f224310h;

        /* JADX WARN: Multi-variable type inference failed */
        public d(DriveThumbnailImageProvider r100, AtomicBoolean r101, boolean r102, String r103, Function1<? super i, Unit> r104, int r105, boolean r106, Ref.ObjectRef<h75.a> r107) {
            this.f224303a = r100;
            this.f224304b = r101;
            this.f224305c = r102;
            this.f224306d = r103;
            this.f224307e = r104;
            this.f224308f = r105;
            this.f224309g = r106;
            this.f224310h = r107;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            g r101 = (g) r100;
            if (this.f224303a.f224295f == false) goto L5;
            return;
        L5:
            if (this.f224304b.get() == false) goto L8;
            return;
        L8:
            if ((r101 instanceof g.a) == false) goto L11;
            DriveThumbnailImageProvider.a(this.f224303a, this.f224304b, this.f224307e, new i.a(((g.a) r101).f224374a));
            return;
        L11:
            if (Intrinsics.areEqual(r101, g.b.f224375a) == false) goto L17;
            if (this.f224305c == false) goto L15;
            DriveThumbnailImageProvider.b(this.f224304b, this.f224303a, this.f224306d, this.f224308f, this.f224309g, this.f224310h, this.f224307e);
            return;
        L15:
            tt5.a.h("DriveThumbnailImageProvider", "[thumbnail download] result=source_empty token=" + du5.b.i(this.f224306d) + " reason=remote_cover_disabled");
            DriveThumbnailImageProvider.a(this.f224303a, this.f224304b, this.f224307e, null);
            return;
        L17:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f224311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DriveThumbnailImageProvider f224312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f224313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f224314d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f224315e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f224316f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<h75.a> f224317g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Function1<i, Unit> f224318h;

        /* JADX WARN: Multi-variable type inference failed */
        public e(String r100, DriveThumbnailImageProvider r101, AtomicBoolean r102, boolean r103, int r104, boolean r105, Ref.ObjectRef<h75.a> r106, Function1<? super i, Unit> r107) {
            this.f224311a = r100;
            this.f224312b = r101;
            this.f224313c = r102;
            this.f224314d = r103;
            this.f224315e = r104;
            this.f224316f = r105;
            this.f224317g = r106;
            this.f224318h = r107;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.l("DriveThumbnailImageProvider", "[thumbnail download] result=cache_failed token=" + du5.b.i(this.f224311a), (Throwable) r100);
            if (this.f224312b.f224295f == false) goto L5;
            return;
        L5:
            if (this.f224313c.get() == false) goto L7;
            return;
        L7:
            if (this.f224314d == false) goto L9;
            DriveThumbnailImageProvider.b(this.f224313c, this.f224312b, this.f224311a, this.f224315e, this.f224316f, this.f224317g, this.f224318h);
            return;
        L9:
            DriveThumbnailImageProvider.a(this.f224312b, this.f224313c, this.f224318h, null);
        }
    }

    static {
    }

    public final void e() {
        this.f224295f = true;
        List r100 = CollectionsKt.toList(((LinkedHashMap) this.f224294e).values());
        ((LinkedHashMap) this.f224294e).clear();
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((h75.a) r101.next()).cancel();
        goto L4
    }

    public DriveThumbnailImageProvider() {
        this.f224290a = LazyKt.lazy(DriveThumbnailImageProvider$imageDownloader$2.INSTANCE);
        this.f224291b = LazyKt.lazy(DriveThumbnailImageProvider$drivePreviewService$2.INSTANCE);
        this.f224292c = LazyKt.lazy(DriveThumbnailImageProvider$infoProvideService$2.INSTANCE);
        this.f224293d = new DriveImagePreviewLoader();
        this.f224294e = new LinkedHashMap();
    }

    public final void c(String r100, h75.a r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(((LinkedHashMap) this.f224294e).get(r100), r101) == false) goto L8;
        this.f224294e.remove(r100);
        return;
    }

    public static final void a(DriveThumbnailImageProvider r100, AtomicBoolean r101, Function1 r102, i r103) {
        if (r100.f224295f == false) goto L5;
        return;
    L5:
        if (r101.get() == true) goto L10;
        r102.invoke(r103);
        return;
    }

    public final Disposable d(String r110, boolean r111, boolean r112, int r210, Function1<? super i, Unit> r211) {
        Intrinsics.checkNotNullParameter(r211, "callback");
        if (r110 != null) goto L5;
        String r113 = "";
    L7:
        if (StringsKt.isBlank(r113) == false) goto L10;
        tt5.a.k("DriveThumbnailImageProvider", "[thumbnail download] result=source_empty token=empty reason=empty_token");
        r211.invoke(null);
        return Disposables.disposed();
    L10:
        Ref.ObjectRef r114 = new Ref.ObjectRef();
        AtomicBoolean r115 = new AtomicBoolean(false);
        return Disposables.fromAction(new b(r115, Flowable.fromCallable(new c(this, r113)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new d(this, r115, r111, r113, r211, r210, r112, r114), new e(r113, this, r115, r111, r210, r112, r114, r211)), this, r113, r114));
    L5:
        r113 = r110;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4, types: [T, h75.a, java.lang.Object] */
    public static final void b(AtomicBoolean r100, DriveThumbnailImageProvider r101, String r102, int r110, boolean r111, final Ref.ObjectRef r112, Function1 r113) {
        if (r100.get() == true) goto L42;
        Function1<h75.a, Unit> r103 = new DriveThumbnailImageProvider$load$loadRemoteSource$1(r112);
        DriveThumbnailImageProvider$load$loadRemoteSource$2 r104 = new DriveThumbnailImageProvider$load$loadRemoteSource$2(r101, r100, r113);
        r101.getClass();
        String r114 = "";
        String r105 = ((b0) r101.f224292c.getValue()).r();     // Catch: Exception -> L22
        if (r105 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == false) goto L18;
        r105 = p.f540584u;     // Catch: Exception -> L22
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        if (StringsKt.isBlank(r105) == true) goto L25;
        r114 = "https://" + r105 + "/space/api/box/stream/download/v2/cover/" + r102 + "?width=" + r110 + "&height=" + r110 + "&policy=near";     // Catch: Exception -> L22
    L25:
        if ((!StringsKt.isBlank(r114)) == false) goto L28;
        r104.invoke(new i.b(new BearGlideUrl(r114), DriveThumbnailRemoteSource.COVER));
        return;
    L28:
        if (r111 == true) goto L30;
        tt5.a.k("DriveThumbnailImageProvider", "[thumbnail download] result=cover_url_unavailable token=" + du5.b.i(r102) + " coverSize=" + r110 + " fallback=none reason=preview_fallback_disabled");
        r104.invoke(null);
        return;
    L30:
        tt5.a.k("DriveThumbnailImageProvider", "[thumbnail download] result=cover_url_unavailable token=" + du5.b.i(r102) + " coverSize=" + r110 + " fallback=preview");
        String r107 = du5.b.i(r102);
        h75.a r108 = r101.f224294e.remove(r102);
        if (r108 == null) goto L33;
        r108.cancel();
    L33:
        Ref.ObjectRef r109 = new Ref.ObjectRef();
        ?? r115 = r101.f224293d.fetchDriveImagePreview(r102, new h(r101, r102, r109, r107, r104));
        r109.element = r115;
        if (r115 == 0) goto L41;
        r101.f224294e.put(r102, (h75.a) r115);
        r103.invoke(r115);
        return;
    L41:
        return;
    L9:
        if (StringsKt.isBlank(r105) == true) goto L12;
        r106 = false;
    L22:
        e = move-exception;
        tt5.a.l("DriveThumbnailImageProvider", "[thumbnail download] result=cover_url_build_failed token=" + du5.b.i(r102) + " coverSize=" + r110, e);
        goto L25
    }
}
