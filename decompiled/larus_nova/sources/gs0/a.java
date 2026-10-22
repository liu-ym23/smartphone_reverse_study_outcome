package gs0;

import com.bytedance.android.livesdkapi.player.ISetSurfaceInterceptor;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C6061a f482431d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f482432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f482433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ILivePlayerClient f482434c;

    /* JADX INFO: renamed from: gs0.a$a, reason: collision with other inner class name */
    public static final class C6061a implements ISetSurfaceInterceptor {
        public C6061a() {
        }

        @Override // com.bytedance.android.livesdkapi.player.ISetSurfaceInterceptor
        public final ISetSurfaceInterceptor.MODE intercept(ILivePlayerClient r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "client");
            if (r100.isPlaying() == false) goto L9;
            if (Intrinsics.areEqual(r100.getEventHub().getFirstFrame().getValue(), Boolean.TRUE) == false) goto L9;
            return ISetSurfaceInterceptor.MODE.ADD;
        L9:
            return ISetSurfaceInterceptor.MODE.DEFAULT;
        }
    }

    public static final class b {
    }

    static {
        f482431d = new C6061a();
    }

    public a(ILivePlayerClient r100) {
        this.f482434c = r100;
    }

    public final void a(boolean r100) {
        this.f482432a = r100;
        if (r100 == false) goto L7;
        ILivePlayerClient r101 = this.f482434c;
        if (r101 == null) goto L11;
        r101.setSetSurfaceInterceptor(f482431d);
        return;
    L11:
        return;
    L7:
        ILivePlayerClient r102 = this.f482434c;
        if (r102 == null) goto L13;
        r102.setSetSurfaceInterceptor(null);
        return;
    }

    public final void b(boolean r100) {
        this.f482433b = r100;
        if (r100 == false) goto L7;
        ILivePlayerClient r101 = this.f482434c;
        if (r101 == null) goto L11;
        r101.setSetSurfaceInterceptor(f482431d);
        return;
    L11:
        return;
    L7:
        ILivePlayerClient r102 = this.f482434c;
        if (r102 == null) goto L13;
        r102.setSetSurfaceInterceptor(null);
        return;
    }
}
