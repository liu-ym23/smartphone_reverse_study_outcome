package my0;

import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.scope.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements ly0.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<sq2.a, IHostAppMonitorListener.Stub> f516359a;

    /* JADX INFO: renamed from: my0.a$a, reason: collision with other inner class name */
    public static final class C6872a extends IHostAppMonitorListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq2.a f516360a;

        public C6872a(sq2.a r100) {
            this.f516360a = r100;
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
        public final void appEnterBackground(boolean r100, boolean r101) {
            this.f516360a.a(r100);
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public a() {
        this.f516359a = new LinkedHashMap();
    }

    @Override // ly0.a
    public final void o5(sq2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        IHostAppMonitorListener.Stub r101 = this.f516359a.remove(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        Lazy r102 = HostAppMonitorService.f102946c;
        HostAppMonitorService.a.a().b(r101);
    }

    @Override // ly0.a
    public final void y0(sq2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        C6872a r101 = new C6872a(r100);
        this.f516359a.put(r100, r101);
        Lazy r102 = HostAppMonitorService.f102946c;
        HostAppMonitorService.a.a().a(r101);
    }
}
