package rc9;

import android.app.Application;
import com.bytedance.reparo.IReparoConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends IReparoConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qc9.a f537179a;

    @Override // com.bytedance.reparo.IReparoConfig
    public final boolean enable() {
        this.f537179a.enable();
        return true;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getAppId() {
        return this.f537179a.getAppId();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final Application getApplication() {
        return this.f537179a.getApplication();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getChannel() {
        return this.f537179a.getChannel();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getDeviceId() {
        return this.f537179a.getDeviceId();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getUpdateVersionCode() {
        return this.f537179a.getUpdateVersionCode();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final boolean isMainProcess() {
        return this.f537179a.a();
    }

    public d(a r100) {
        this.f537179a = r100;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String executePatchRequest(int r100, String r101, byte[] r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "localPatchInfoBytes");
        Intrinsics.checkNotNullParameter(r103, "contentType");
        return this.f537179a.b(r100, r101, r102, r103);
    }
}
