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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveThumbnailImageProvider {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final DriveImagePreviewLoader d;
    public final Map<String, h75.a> e;
    public boolean f;

    public static final class a {
    }

    public static final class b implements Action {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ Disposable b;
        public final /* synthetic */ DriveThumbnailImageProvider c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Ref.ObjectRef<h75.a> e;

        public b(AtomicBoolean r1, Disposable r2, DriveThumbnailImageProvider r3, String r4, Ref.ObjectRef<h75.a> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void run() {
            this.a.set(true);
            this.b.dispose();
            DriveThumbnailImageProvider r0 = this.c;
            String r1 = this.d;
            h75.a r2 = (h75.a) this.e.element;
            if (r2 != null) goto L5;
            r0.getClass();
        L6:
            this.e.element = null;
            return;
        L5:
            r0.c(r1, r2);
            r2.cancel();
            goto L6
        }
    }

    public static final class c<V> implements Callable {
        public final /* synthetic */ DriveThumbnailImageProvider a;
        public final /* synthetic */ String b;

        public c(DriveThumbnailImageProvider r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.concurrent.Callable
        public final g call() {
            DriveThumbnailImageProvider r0 = this.a;
            String r1 = this.b;
            w85.b r2 = ((w85.c) r0.a.getValue()).c(r1, DownloadRequestInfo.DownloadType.COVER);
            if (r2 != null) goto L29;
        L20:
            File r3 = null;
        L21:
            if (r2 == null) goto L25;
            InputStream r4 = r2.a;
            if (r4 == null) goto L25;
            r4.close();
        L25:
            if (r3 == null) goto L28;
            return new g.a(r3);
        L28:
            return g.b.a;
        L29:
            r3 = r2.b;     // Catch: Throwable -> L15
            if (r3 == null) goto L20;
            if (r3.exists() == false) goto L12;
            if (r3.length() <= 0) goto L12;
            boolean r5 = true;
        L13:
            if (r5 == false) goto L20;
        L12:
            r5 = false;
        L15:
            th = move-exception;
            InputStream r6 = r2.a;
            if (r6 == null) goto L19;
            r6.close();
        L19:
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ DriveThumbnailImageProvider a;
        public final /* synthetic */ AtomicBoolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Function1<i, Unit> e;
        public final /* synthetic */ int f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ Ref.ObjectRef<h75.a> h;

        /* JADX WARN: Multi-variable type inference failed */
        public d(DriveThumbnailImageProvider r1, AtomicBoolean r2, boolean r3, String r4, Function1<? super i, Unit> r5, int r6, boolean r7, Ref.ObjectRef<h75.a> r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void accept(Object r8) {
            g r9 = (g) r8;
            if (this.a.f == false) goto L5;
            return;
        L5:
            if (this.b.get() == false) goto L8;
            return;
        L8:
            if ((r9 instanceof g.a) == false) goto L11;
            DriveThumbnailImageProvider.a(this.a, this.b, this.e, new i.a(((g.a) r9).a));
            return;
        L11:
            if (Intrinsics.areEqual(r9, g.b.a) == false) goto L17;
            if (this.c == false) goto L15;
            DriveThumbnailImageProvider.b(this.b, this.a, this.d, this.f, this.g, this.h, this.e);
            return;
        L15:
            tt5.a.h("DriveThumbnailImageProvider", "[thumbnail download] result=source_empty token=" + du5.b.i(this.d) + " reason=remote_cover_disabled");
            DriveThumbnailImageProvider.a(this.a, this.b, this.e, null);
            return;
        L17:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ DriveThumbnailImageProvider b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ int e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ Ref.ObjectRef<h75.a> g;
        public final /* synthetic */ Function1<i, Unit> h;

        /* JADX WARN: Multi-variable type inference failed */
        public e(String r1, DriveThumbnailImageProvider r2, AtomicBoolean r3, boolean r4, int r5, boolean r6, Ref.ObjectRef<h75.a> r7, Function1<? super i, Unit> r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void accept(Object r8) {
            tt5.a.l("DriveThumbnailImageProvider", "[thumbnail download] result=cache_failed token=" + du5.b.i(this.a), (Throwable) r8);
            if (this.b.f == false) goto L5;
            return;
        L5:
            if (this.c.get() == false) goto L7;
            return;
        L7:
            if (this.d == false) goto L9;
            DriveThumbnailImageProvider.b(this.c, this.b, this.a, this.e, this.f, this.g, this.h);
            return;
        L9:
            DriveThumbnailImageProvider.a(this.b, this.c, this.h, null);
        }
    }

    static {
    }

    public final void e() {
        this.f = true;
        List r0 = CollectionsKt.toList(((LinkedHashMap) this.e).values());
        ((LinkedHashMap) this.e).clear();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((h75.a) r1.next()).cancel();
        goto L4
    }

    public DriveThumbnailImageProvider() {
        this.a = LazyKt.lazy(DriveThumbnailImageProvider$imageDownloader$2.INSTANCE);
        this.b = LazyKt.lazy(DriveThumbnailImageProvider$drivePreviewService$2.INSTANCE);
        this.c = LazyKt.lazy(DriveThumbnailImageProvider$infoProvideService$2.INSTANCE);
        this.d = new DriveImagePreviewLoader();
        this.e = new LinkedHashMap();
    }

    public final void c(String r2, h75.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(((LinkedHashMap) this.e).get(r2), r3) == false) goto L8;
        this.e.remove(r2);
        return;
    }

    public static final void a(DriveThumbnailImageProvider r0, AtomicBoolean r1, Function1 r2, i r3) {
        if (r0.f == false) goto L5;
        return;
    L5:
        if (r1.get() == true) goto L10;
        r2.invoke(r3);
        return;
    }

    public final Disposable d(String r17, boolean r18, boolean r19, int r20, Function1<? super i, Unit> r21) {
        Intrinsics.checkNotNullParameter(r21, "callback");
        if (r17 != null) goto L5;
        String r10 = "";
    L7:
        if (StringsKt.isBlank(r10) == false) goto L10;
        tt5.a.k("DriveThumbnailImageProvider", "[thumbnail download] result=source_empty token=empty reason=empty_token");
        r21.invoke(null);
        return Disposables.disposed();
    L10:
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        AtomicBoolean r12 = new AtomicBoolean(false);
        return Disposables.fromAction(new b(r12, Flowable.fromCallable(new c(this, r10)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new d(this, r12, r18, r10, r21, r20, r19, r11), new e(r10, this, r12, r18, r20, r19, r11, r21)), this, r10, r11));
    L5:
        r10 = r17;
        goto L7
    }

    public static final void b(AtomicBoolean r7, DriveThumbnailImageProvider r8, String r9, int r10, boolean r11, final Ref.ObjectRef r12, Function1 r13) {
        if (r7.get() == true) goto L42;
        Function1<h75.a, Unit> r0 = new DriveThumbnailImageProvider$load$loadRemoteSource$1(r12);
        DriveThumbnailImageProvider$load$loadRemoteSource$2 r6 = new DriveThumbnailImageProvider$load$loadRemoteSource$2(r8, r7, r13);
        r8.getClass();
        String r14 = "";
        String r3 = ((b0) r8.c.getValue()).r();     // Catch: Exception -> L22
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L18;
        r3 = p.u;     // Catch: Exception -> L22
        if (r3 != null) goto L18;
        r3 = "";
    L18:
        if (StringsKt.isBlank(r3) == true) goto L25;
        r14 = "https://" + r3 + "/space/api/box/stream/download/v2/cover/" + r9 + "?width=" + r10 + "&height=" + r10 + "&policy=near";     // Catch: Exception -> L22
    L25:
        if ((!StringsKt.isBlank(r14)) == false) goto L28;
        r6.invoke(new i.b(new BearGlideUrl(r14), DriveThumbnailRemoteSource.COVER));
        return;
    L28:
        if (r11 == true) goto L30;
        tt5.a.k("DriveThumbnailImageProvider", "[thumbnail download] result=cover_url_unavailable token=" + du5.b.i(r9) + " coverSize=" + r10 + " fallback=none reason=preview_fallback_disabled");
        r6.invoke(null);
        return;
    L30:
        tt5.a.k("DriveThumbnailImageProvider", "[thumbnail download] result=cover_url_unavailable token=" + du5.b.i(r9) + " coverSize=" + r10 + " fallback=preview");
        String r5 = du5.b.i(r9);
        h75.a r16 = r8.e.remove(r9);
        if (r16 == null) goto L33;
        r16.cancel();
    L33:
        Ref.ObjectRef r17 = new Ref.ObjectRef();
        h75.a r18 = r8.d.fetchDriveImagePreview(r9, new h(r8, r9, r17, r5, r6));
        r17.element = r18;
        if (r18 == null) goto L41;
        r8.e.put(r9, r18);
        r0.invoke(r18);
        return;
    L41:
        return;
    L9:
        if (StringsKt.isBlank(r3) == true) goto L12;
        r4 = false;
    L22:
        e = move-exception;
        tt5.a.l("DriveThumbnailImageProvider", "[thumbnail download] result=cover_url_build_failed token=" + du5.b.i(r9) + " coverSize=" + r10, e);
        goto L25
    }
}
