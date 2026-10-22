package x72;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.o0;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements o0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.a f562808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k32.a f562809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f562810c;

    @Override // com.bytedance.android.live.core.utils.o0.b
    public final void a() {
        ALogger.e("TextParseInterceptor", "download image failed");
        h.b(this.f562810c, this.f562808a, this.f562809b);
    }

    @Override // com.bytedance.android.live.core.utils.o0.b
    public final void b() {
        ALogger.e("TextParseInterceptor", "download image timeout");
        h.b(this.f562810c, this.f562808a, this.f562809b);
    }

    @Override // com.bytedance.android.live.core.utils.o0.b
    public final void c() {
        ALogger.d("TextParseInterceptor", "download image success");
        h.b(this.f562810c, this.f562808a, this.f562809b);
    }

    public f(h r100, a r101, k32.a r102) {
        this.f562810c = r100;
        this.f562808a = r101;
        this.f562809b = r102;
    }
}
