package rr2;

import android.content.res.Configuration;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import io.reactivex.subjects.PublishSubject;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements rr2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f538976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject<Configuration> f538977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f538978c;

    public static final class a implements a81.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f538979a;

        @Override // a81.b
        public final void b(int r100) {
        }

        public a(b r100) {
            this.f538979a = r100;
        }

        @Override // a81.b
        public final void a(Configuration r100) {
            Intrinsics.checkNotNullParameter(r100, "newConfig");
            this.f538979a.f538977b.onNext(r100);
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // rr2.a
    public final PublishSubject fg() {
        if (this.f538976a == true) goto L8;
        this.f538976a = true;
        IScreenRotateService r100 = (IScreenRotateService) k.f(IScreenRotateService.class);
        if (r100 == null) goto L8;
        r100.registerGlobalOnConfigChanged(this.f538978c);
    L8:
        return this.f538977b;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        IScreenRotateService r100 = (IScreenRotateService) k.f(IScreenRotateService.class);
        if (r100 == null) goto L6;
        r100.unregisterOnGlobalConfigChanged(this.f538978c);
        return;
    }

    public b() {
        this.f538977b = PublishSubject.create();
        this.f538978c = new a(this);
    }
}
