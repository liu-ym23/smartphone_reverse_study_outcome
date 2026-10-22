package qq8;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d implements pq8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oq8.b f534496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public nq8.a f534497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public uq8.a f534498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rq8.a f534499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qq8.a f534500e;

    public static final class a {
    }

    static {
    }

    public final void b() {
        FLogger.f375446a.d("LarkInputController", "unbind");
        nq8.a r100 = this.f534497b;
        if (r100 != null) goto L5;
        return;
    L5:
        uq8.a r101 = this.f534498c;
        if (r101 == null) goto L8;
        r100.f(r101);
    L8:
        r100.a(this.f534500e);
        this.f534498c = null;
        this.f534497b = null;
    }

    @Override // pq8.a
    public final void onDestroy() {
        FLogger.f375446a.i("LarkInputController", LiveCommonConstants.REASON_ON_DEDTROY);
        b();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [qq8.a] */
    public d(oq8.b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f534496a = r100;
        this.f534499d = new rq8.a();
        this.f534500e = new qq8.a(this);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [qq8.b] */
    /* JADX WARN: Type inference failed for: r3v0, types: [qq8.c] */
    @Override // pq8.a
    public final void a(final nq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        FLogger.f375446a.i("LarkInputController", "bindEditor");
        b();
        this.f534497b = r100;
        uq8.a r101 = new uq8.a(this.f534496a, new b(r100), new c(this));
        this.f534498c = r101;
        r100.d(r101);
        r100.e(this.f534500e);
    }
}
