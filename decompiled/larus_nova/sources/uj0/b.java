package uj0;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.revenue.platform.api.core.rx.f;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import uf2.a0;
import uf2.d0;
import uf2.z;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements uj0.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Disposable> f550237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, a> f550238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, z.a> f550239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> f550240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentLinkedQueue<C7890b> f550241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f550242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f550243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f550244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d0 f550245j;

    public static final class a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L6;
            a r101 = (a) r100;
            r101.getClass();
            r101.getClass();
            r101.getClass();
            return true;
        L6:
            return false;
        }

        public final int hashCode() {
            return (((0 * 31) + 0) * 31) + 0;
        }

        public final String toString() {
            return "GLTexture(textureId=0, width=0, height=0)";
        }
    }

    /* JADX INFO: renamed from: uj0.b$b, reason: collision with other inner class name */
    public static final class C7890b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.liveinteract.videotalk.avatarmix.d f550246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bitmap f550247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final z.a f550248c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C7890b) == false) goto L12;
            C7890b r101 = (C7890b) r100;
            if (Intrinsics.areEqual(this.f550246a, r101.f550246a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f550247b, r101.f550247b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f550248c, r101.f550248c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r100 = this.f550246a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Bitmap r104 = this.f550247b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            z.a r107 = this.f550248c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "RenderTask(struct=" + this.f550246a + ", bitmap=" + this.f550247b + ", videoSink=" + this.f550248c + ")";
        }

        public C7890b(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r100, Bitmap r101, z.a r102) {
            Intrinsics.checkNotNullParameter(r100, "struct");
            this.f550246a = r100;
            this.f550247b = r101;
            this.f550248c = r102;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f550249a;

        public c(b r100) {
            this.f550249a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            Iterator<T> r102 = ((LinkedHashMap) this.f550249a.f550239d).entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Map.Entry r103 = (Map.Entry) r102.next();
            Map<String, com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> r104 = this.f550249a.f550240e;
            LinkedHashMap r105 = (LinkedHashMap) r104;
            com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r106 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r105.get(r103.getKey());
            if (r106 == null) goto L4;
            this.f550249a.f550241f.add(new C7890b(r106, null, (z.a) r103.getValue()));
            this.f550249a.c();
            goto L4
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f550250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C7890b f550251b;

        public d(b r100, C7890b r101) {
            this.f550250a = r100;
            this.f550251b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            a r111 = (a) r110;
            Map<String, a> r100 = this.f550250a.f550238c;
            int r101 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.f79071b;
            r100.put(com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.C1233a.a(this.f550251b.f550246a), r111);
            b r102 = this.f550250a;
            z.a r103 = this.f550251b.f550248c;
            r102.getClass();
            r111.getClass();
            r111.getClass();
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r104 = ILiveWrappedLivePusher.a.b();
            if (r104 == null) goto L5;
            r111.getClass();
            r104.newVideoMixerTexture(0, 0, 0, 1, new int[]{0, 0, 0}, null, 0);
        L5:
            if (r103 == null) goto L8;
            r103.a();
        L8:
            if ((r103 instanceof a0.a) == true) goto L10;
            r103 = null;
        L10:
            a0.a r105 = (a0.a) r103;
            if (r105 == null) goto L13;
            r105.c();
        L13:
            this.f550250a.c();
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f550252a;

        public e(b r100) {
            this.f550252a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Throwable) r100).printStackTrace();
            this.f550252a.c();
        }
    }

    public final void c() {
        Disposable r100 = this.f550242g;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        if (r100.isDisposed() == true) goto L7;
        return;
    L7:
        C7890b r101 = this.f550241f.poll();
        if (r101 != null) goto L10;
        return;
    L10:
        Disposable r102 = Single.create(new uj0.c(this, r101.f550246a, r101.f550247b)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r101), new e(this));
        this.f550242g = r102;
        uj0.d.a r103 = uj0.d.f550256a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r104 = r101.f550246a;
        r103.getClass();
        String r105 = uj0.d.a.a(r104);
        this.f550237b.put(r105, r102);
    }

    @Override // uj0.d
    public final void init() {
        if (this.f550244i == false) goto L5;
        return;
    L5:
        this.f550244i = true;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r100 = ILiveWrappedLivePusher.a.b();
        if (r100 == null) goto L8;
        r100.getSafeHandlerThreadPoolExecutor();
    L8:
        ALogger.d("MicseatMixer", "GLRenderer init");
        f.a(Observable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this)), this.f550243h);
    }

    @Override // uj0.d
    public final void release() {
        if (this.f550244i == true) goto L5;
        return;
    L5:
        this.f550244i = false;
        ALogger.d("MicseatMixer", "GLRenderer release");
        ((LinkedHashMap) this.f550238c).clear();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r100 = ILiveWrappedLivePusher.a.b();
        if (r100 == null) goto L8;
        r100.getSafeHandlerThreadPoolExecutor();
    L8:
        Iterator r101 = ((LinkedHashMap) this.f550239d).entrySet().iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        Map.Entry r102 = (Map.Entry) r101.next();
        ((z.a) r102.getValue()).a();
        ((z.a) r102.getValue()).dispose();
        goto L10
    L12:
        ((LinkedHashMap) this.f550239d).clear();
        ((LinkedHashMap) this.f550240e).clear();
        ((LinkedHashMap) this.f550237b).clear();
        this.f550243h.clear();
    }

    public b(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "liveCore");
        this.f550245j = r100;
        this.f550237b = new LinkedHashMap();
        this.f550238c = new LinkedHashMap();
        this.f550239d = new LinkedHashMap();
        this.f550240e = new LinkedHashMap();
        this.f550241f = new ConcurrentLinkedQueue();
        this.f550243h = new CompositeDisposable();
    }

    @Override // uj0.d
    public final void a(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r100) {
        Intrinsics.checkNotNullParameter(r100, "struct");
        if (this.f550244i == true) goto L5;
        return;
    L5:
        ALogger.d("MicseatMixer", "GLRenderer clear " + r100);
        uj0.d.f550256a.getClass();
        String r101 = uj0.d.a.a(r100);
        Map<String, a> r102 = this.f550238c;
        int r103 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.f79071b;
        r102.remove(com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.C1233a.a(r100));
        Disposable r104 = this.f550237b.remove(r101);
        if (r104 == null) goto L8;
        r104.dispose();
    L8:
        z.a r105 = this.f550239d.remove(r101);
        if (r105 == null) goto L11;
        r105.a();
        r105.dispose();
    L11:
        this.f550240e.remove(r101);
    }

    @Override // uj0.d
    public final void b(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r110, Bitmap r210) {
        Intrinsics.checkNotNullParameter(r110, "struct");
        Intrinsics.checkNotNullParameter(r210, SimplayerImageStrategy.RESULT_BITMAP);
        if (this.f550244i == true) goto L5;
        return;
    L5:
        ALogger.d("MicseatMixer", "GLRenderer render " + r110);
        uj0.d.f550256a.getClass();
        String r100 = uj0.d.a.a(r110);
        ti6.f r101 = r110.f79078d;
        z.a r102 = (z.a) ((LinkedHashMap) this.f550239d).get(r100);
        if (r102 == null) goto L27;
    L20:
        if (r102 == null) goto L25;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r103 = ILiveWrappedLivePusher.a.b();
        if (r103 == null) goto L24;
        double r104 = r101.f546162d;
        double r111 = r101.f546163e;
        r103.newVideoMixerDescription((float) r104, (float) r111, (float) (r104 + r101.f546164f), (float) (r111 + r101.f546165g), 1, 2);
    L24:
        r102.b();
    L25:
        this.f550240e.put(r100, r110);
        this.f550241f.add(new C7890b(r110, r210, r102));
        c();
        return;
    L27:
        z r105 = this.f550245j.C();     // Catch: Throwable -> L18
        if (r105 == null) goto L13;
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Throwable -> L18
        ILiveWrappedLivePusher r112 = ILiveWrappedLivePusher.a.b();     // Catch: Throwable -> L18
        if (r112 == null) goto L12;
        double r113 = r101.f546162d;     // Catch: Throwable -> L18
        double r114 = r101.f546163e;     // Catch: Throwable -> L18
        r112.newVideoMixerDescription((float) r113, (float) r114, (float) (r113 + r101.f546164f), (float) (r114 + r101.f546165g), 1, 2);     // Catch: Throwable -> L18
    L12:
        r210.getWidth();     // Catch: Throwable -> L18
        r210.getHeight();     // Catch: Throwable -> L18
        z.a r106 = r105.b();     // Catch: Throwable -> L18
    L14:
        r102 = r106;
        if (r102 == null) goto L20;
        r102.a();     // Catch: Throwable -> L18
        this.f550239d.put(r100, r102);     // Catch: Throwable -> L18
        goto L20
    L13:
        r106 = null;
    L18:
        th = move-exception;
        ALogger.e("MicseatMixer", "create layer failed", th);
        goto L20
    }
}
