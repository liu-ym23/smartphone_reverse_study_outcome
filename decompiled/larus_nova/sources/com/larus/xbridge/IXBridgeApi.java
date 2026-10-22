package com.larus.xbridge;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J4\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H&¨\u0006\f"}, d2 = {"Lcom/larus/xbridge/IXBridgeApi;", "", "init", "", "registerCustomBridges", "sendEvent", "eventName", "", "params", "", "containerID", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IXBridgeApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f379669a = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J0\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/xbridge/IXBridgeApi$Companion;", "Lcom/larus/xbridge/IXBridgeApi;", "<init>", "()V", "impl", "init", "", "registerCustomBridges", "sendEvent", "eventName", "", "params", "", "", "containerID", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IXBridgeApi {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f379670b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final IXBridgeApi f379671c = null;

        private Companion() {
        }

        static {
            f379670b = new Companion();
            f379671c = (IXBridgeApi) ServiceManager.get().getService(IXBridgeApi.class);
        }

        @Override // com.larus.xbridge.IXBridgeApi
        public final void a() {
            IXBridgeApi r100 = f379671c;
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        @Override // com.larus.xbridge.IXBridgeApi
        public final void init() {
            IXBridgeApi r100 = f379671c;
            if (r100 == null) goto L6;
            r100.init();
            return;
        }

        @Override // com.larus.xbridge.IXBridgeApi
        public final void b(String r100, Map<String, ? extends Object> r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            IXBridgeApi r103 = f379671c;
            if (r103 == null) goto L6;
            r103.b(r100, r101, r102);
            return;
        }
    }

    static {
        f379669a = Companion.f379670b;
    }

    void a();

    void b(String r100, Map<String, ? extends Object> r101, String r102);

    void init();
}
