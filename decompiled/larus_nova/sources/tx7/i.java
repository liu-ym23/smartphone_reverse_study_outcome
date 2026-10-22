package tx7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class i implements IHostUserDepend {

    public static final class a implements hx7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IHostUserDepend.ILogoutStatusCallback f547834a;

        @Override // hx7.b
        public final void onFail() {
            this.f547834a.onFail();
        }

        @Override // hx7.b
        public final void onSuccess() {
            this.f547834a.onSuccess();
        }

        public a(IHostUserDepend.ILogoutStatusCallback r100) {
            this.f547834a = r100;
        }
    }

    public i() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final IHostUserDepend.UserModelExt getUserModelExt() {
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final void login(Activity r100, IHostUserDepend.ILoginStatusCallback r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "loginStatusCallback");
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final void login(Activity r100, IHostUserDepend.ILoginStatusCallback r101, Map<String, String> r102, IHostUserDepend.LoginParamsExt r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "loginStatusCallback");
        Intrinsics.checkNotNullParameter(r103, "params");
    }

    public static hx7.h a() {
        Map<Class<?>, com.ivy.ivykit.api.bridge.d<?>> r100 = com.ivy.ivykit.api.bridge.b.f278301a;
        return (hx7.h) com.ivy.ivykit.api.bridge.b.a(hx7.h.class);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getAvatarURL() {
        hx7.h r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAvatarURL();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getBoundPhone() {
        hx7.h r100 = a();
        if (r100 == null) goto L7;
        r100.getBoundPhone();
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getNickname() {
        hx7.h r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNickname();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getSecUid() {
        hx7.h r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSecUid();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getUniqueID() {
        hx7.h r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUniqueID();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getUserId() {
        hx7.h r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUserId();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final boolean hasLogin() {
        hx7.h r100 = a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.hasLogin();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final void logout(Activity r100, IHostUserDepend.ILogoutStatusCallback r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "logoutStatusCallback");
        hx7.h r103 = a();
        if (r103 == null) goto L6;
        r103.a(new a(r101));
        return;
    }
}
