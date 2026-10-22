package z80;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.android.livehostapi.business.IHostRealNameAuthorization;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import gu2.g;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v80.h;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements x80.a {

    public static final class a implements IHostOCRApiProxy.BytedCertCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v80.b.InterfaceC7971b f570887a;

        public a(v80.b.InterfaceC7971b r100) {
            this.f570887a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.IHostOCRApiProxy.BytedCertCallback
        public final void onH5Close(JSONObject r100) {
            int r101 = -1;
            String r102 = null;
            if (r100 == null) goto L5;
            Integer r103 = Integer.valueOf(r100.optInt("error_code", -1));
        L6:
            if (r100 == null) goto L8;
            JSONObject r104 = r100.optJSONObject("ext_data");
        L9:
            if (r104 == null) goto L11;
            JSONObject r105 = r104.optJSONObject("state");
        L12:
            if (r105 == null) goto L14;
            Integer r106 = Integer.valueOf(r105.optInt("living_detect_state"));
        L16:
            if (r106 != null) goto L19;
        L24:
            if (r100 == null) goto L26;
            r102 = r100.optString("error_msg");
        L26:
            v80.b.InterfaceC7971b r107 = this.f570887a;
            if (r103 == null) goto L29;
            r101 = r103.intValue();
        L29:
            if (r102 != null) goto L31;
            r102 = "取消";
        L31:
            if (r104 != null) goto L33;
            r104 = new JSONObject();
        L33:
            r107.a(false, r101, r102, r104);
            return;
        L19:
            if (r106.intValue() != 1) goto L24;
            v80.b.InterfaceC7971b r108 = this.f570887a;
            if (r104 != null) goto L23;
            r104 = new JSONObject();
        L23:
            r108.a(true, 0, "成功", r104);
            return;
        L14:
            r106 = null;
            goto L16
        L11:
            r105 = null;
            goto L12
        L8:
            r104 = null;
            goto L9
        L5:
            r103 = null;
            goto L6
        }
    }

    public c() {
    }

    @Override // x80.a
    public final void a(h r110) {
        if ((r110 instanceof v80.b) == true) goto L5;
        return;
    L5:
        v80.b r111 = (v80.b) r110;
        if ((r111.getContext() instanceof Activity) == true) goto L8;
        return;
    L8:
        v80.b.InterfaceC7971b r100 = r111.f553598g;
        if (r100 != null) goto L11;
        return;
    L11:
        boolean r101 = false;
        if (((IHostContext) k.f(IHostContext.class)) != null) goto L15;
        r100.a(false, -1, null, new JSONObject());
        return;
    L15:
        Context r102 = r111.getContext();
        if (r102 == null) goto L38;
        Activity r103 = (Activity) r102;
        HashMap<String, String> r112 = r111.f553599h;
        a r104 = new a(r100);
        g r105 = g.f482754a;
        if (((IHostRealNameAuthorization) k.f(IHostRealNameAuthorization.class)) == null) goto L20;
        boolean r106 = true;
    L22:
        if (r106 == false) goto L27;
        Intrinsics.checkNotNullParameter(r103, "activity");
        Intrinsics.checkNotNullParameter(r112, "certInfo");
        Intrinsics.checkNotNullParameter(r104, "certH5CloseCallback");
        IHostRealNameAuthorization r107 = (IHostRealNameAuthorization) k.f(IHostRealNameAuthorization.class);
        if (r107 == null) goto L41;
        r107.startBytedCert(r103, r112, g.b(r105), new gu2.h(r103, r104));
        return;
    L41:
        return;
    L27:
        y30.b r108 = y30.a.b();
        if (r108 == null) goto L40;
        Intrinsics.checkNotNullParameter(r103, "activity");
        Intrinsics.checkNotNullParameter(r112, "dict");
        Intrinsics.checkNotNullParameter(r104, "certH5CloseCallback");
        if (((IHostRealNameAuthorization) k.f(IHostRealNameAuthorization.class)) == null) goto L32;
        r101 = true;
    L32:
        if (r101 == false) goto L35;
        SafetyGuard.a(null, new Throwable("unexpected_liveauthsdk_code_exec"), "unexpected_liveauthsdk_code_exec");
    L35:
        fu2.a r113 = r108.f565730a;
        y30.b.a(r108);
        r113.b();
        r108.f565730a.c();
        r108.f565730a.d();
        fu2.a r114 = r108.f565730a;
        r114.f();
        r114.a();
        return;
    L40:
        return;
    L20:
        r106 = false;
        goto L22
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
}
