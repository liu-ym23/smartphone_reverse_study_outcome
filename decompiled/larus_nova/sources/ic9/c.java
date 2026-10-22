package ic9;

import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.applog.api.IApplog;
import com.larus.platform.api.q1;
import com.larus.platform.api.y;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f489259a = null;

    public static final class a implements v48.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f489260a;

        public a(y r100) {
            this.f489260a = r100;
        }

        @Override // v48.e
        public final void onGetId(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_INSTALL_ID);
            Intrinsics.checkNotNullParameter(r102, "ssid");
            this.f489260a.onGetId(r100, r101, r102);
            if (this.f489260a.a() == false) goto L6;
            IApplog.f287053a.k(this);
            return;
        }
    }

    static {
        f489259a = new c();
    }

    public c() {
    }

    @Override // com.larus.platform.api.q1
    public final String getClientDid() {
        return IApplog.f287053a.getClientDid();
    }

    @Override // com.larus.platform.api.q1
    public final String getDeviceId() {
        return IApplog.f287053a.getDeviceId();
    }

    @Override // com.larus.platform.api.q1
    public final String getInstallId() {
        return IApplog.f287053a.getInstallId();
    }

    @Override // com.larus.platform.api.q1
    public final String getUserID() {
        return IApplog.f287053a.getUserID();
    }

    @Override // com.larus.platform.api.q1
    public final String getUserUniqueID() {
        return IApplog.f287053a.getUserUniqueID();
    }

    @Override // com.larus.platform.api.q1
    public final void d(boolean r100) {
        if (r100 == false) goto L4;
        IApplog.f287053a.l();
        return;
    L4:
        IApplog.f287053a.g();
    }

    @Override // com.larus.platform.api.q1
    public final void e(y r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IApplog.f287053a.j(new a(r100));
    }

    @Override // com.larus.platform.api.q1
    public final void putCommonParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        IApplog.f287053a.putCommonParams(r100);
    }

    @Override // com.larus.platform.api.q1
    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        IApplog.f287053a.a(r100, r101);
    }

    @Override // com.larus.platform.api.q1
    public final void b(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IApplog.f287053a.b(r100, r101);
    }

    @Override // com.larus.platform.api.q1
    public final void c(String r100, Function0<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueGenerator");
        IApplog.f287053a.c(r100, r101);
    }

    @Override // com.larus.platform.api.q1
    public final void reportEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IApplog.f287053a.reportEvent(r100, r101);
    }
}
