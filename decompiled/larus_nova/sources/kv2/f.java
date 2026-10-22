package kv2;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.j0;
import com.bytedance.android.live.core.widget.LiveEditText;
import com.bytedance.android.live.core.widget.LiveTextView;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.model.m0;
import com.bytedance.android.livesdk.config.qm;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.service.k;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublishSubject<d> f506234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, d> f506235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PolarisFileWrapper f506236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f506237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f506238e;

    public class a implements Observer<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f506239a;

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
        }

        public a(f r100) {
            this.f506239a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Logger.e("LiveFontManager", r100.toString());
        }

        @Override // io.reactivex.Observer
        public final void onNext(d r100) {
            d r101 = r100;
            Map<String, d> r102 = this.f506239a.f506235b;
            ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
            r103.put(r101.f506243b, r101);
        }
    }

    public class b extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f506240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f506241b;

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(final DownloadInfo r100) {
            super.onSuccessed(r100);
            this.f506241b.f506238e = false;
            Observable r101 = Observable.fromCallable(new h(r100)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            final String r102 = this.f506240a;
            r101.subscribe(new i(this, r102), new j());
        }

        public b(f r100, String r101) {
            this.f506241b = r100;
            this.f506240a = r101;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            super.onFailed(r100, r101);
            Logger.e("LiveFontManager", "font download failed: " + this.f506240a);
            this.f506241b.f506238e = false;
            ALogger.e("LiveFontManager", r101);
        }
    }

    public static final class c implements k.b<j0> {
        public c() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [R, kv2.f] */
        @Override // com.bytedance.android.livesdk.service.k.b
        public final k.b.a<j0> setup(k.b.a<j0> r100) {
            r100.f158001a = new f();
            r100.f158002b = true;
            return r100;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f506242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f506243b;

        public d(String r100, Typeface r101) {
            this.f506242a = r101;
            this.f506243b = r100;
        }
    }

    public final void a() {
        if (this.f506238e == false) goto L5;
        return;
    L5:
        m0 r100 = qm.f121067a.getValue();
        String r101 = r100.name;
        if (TextUtils.isEmpty(r101) == false) goto L10;
        Logger.e("LiveFontManager", "font name from setting is empty");
        return;
    L10:
        if (((ConcurrentHashMap) this.f506235b).get(r101) == null) goto L13;
        Logger.d("LiveFontManager", "font already loaded from local");
        return;
    L13:
        ImageModel r102 = r100.font;
        if (r102 != null) goto L17;
        Logger.e("LiveFontManager", "font url from setting is null");
        return;
    L17:
        Iterator<String> r103 = r102.getUrls().iterator();
    L19:
        if (r103.hasNext() == false) goto L23;
        String r104 = r103.next();
        if (TextUtils.isEmpty(r104) == true) goto L19;
    L25:
        if (TextUtils.isEmpty(r104) == false) goto L28;
        Logger.e("LiveFontManager", "no valid download url");
        return;
    L28:
        this.f506238e = true;
        Downloader.with(((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).b().context()).url(r104).name(r101 + ".ttf").savePath(this.f506236c.getAbsolutePath()).monitorScene("live_font_manager").mainThreadListener(new b(this, r101)).download();
        return;
    L23:
        r104 = null;
        goto L25
    }

    @Override // com.bytedance.android.live.core.utils.j0
    public final Single<Typeface> get() {
        final String r100 = qm.f121067a.getValue().name;
        Logger.d("LiveFontManager", "get font: ");
        if (r100 == null) goto L5;
        d r101 = (d) ((ConcurrentHashMap) this.f506235b).get(r100);
        if (r101 == null) goto L10;
        Logger.d("LiveFontManager", "cache hit: ".concat(r100));
        return Single.just(r101.f506242a).observeOn(AndroidSchedulers.mainThread());
    L10:
        Logger.d("LiveFontManager", "cache not hit, waiting for font ready: ".concat(r100));
        return this.f506234a.filter(new kv2.b(r100)).map(new kv2.c()).firstOrError().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    L5:
        return Single.create(new kv2.a());
    }

    @Override // com.bytedance.android.live.core.utils.j0
    public final void init() {
        if (this.f506237d == false) goto L5;
        return;
    L5:
        LiveTextView.setFontManager(this);
        LiveEditText.setFontManager(this);
        File r100 = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).b().context().getExternalCacheDir();     // Catch: Exception -> L11
        if (r100 == null) goto L9;
        String r101 = r100.getAbsolutePath() + "/src/hotsoon/assets/fonts";     // Catch: Exception -> L11
    L14:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        this.f506236c = r102;
        if (FileUtils.ensureDirExists(r102) == true) goto L18;
        Logger.e("LiveFontManager", "ensure font directory exists failed");
        return;
    L18:
        this.f506234a.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        Logger.d("LiveFontManager", "loading local fonts");
        File[] r103 = this.f506236c.listFiles();
        if (r103 != null) goto L21;
        a();
    L22:
        this.f506237d = true;
        return;
    L21:
        Observable.fromArray(r103).subscribeOn(Schedulers.io()).filter(new kv2.d()).map(new e()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this));
        goto L22
    L9:
        b0.o().getClass();     // Catch: Exception -> L11
        com.bytedance.android.live.core.log.g.n("ttlive_init", "getFontCacheDirPath failed; getExternalCacheDir is null");     // Catch: Exception -> L11
    L13:
        r101 = "";
    L11:
        e = move-exception;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_init", "LiveFontManager init crash!!!");
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.e("ttlive_exception", e);
        goto L13
    }

    public f() {
        this.f506234a = PublishSubject.create();
        this.f506235b = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.live.core.utils.j0
    public final Typeface getHostTypeface(int r100) {
        return ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).e().getHostTypeface(r100);
    }
}
