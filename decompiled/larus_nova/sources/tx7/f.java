package tx7;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import com.ivy.ivykit.api.bridge.inject.HostPermissionState;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class f implements IHostPermissionDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hx7.e f547829a;

    public static final class a implements hx7.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnPermissionCallback f547830a;

        /* JADX INFO: renamed from: tx7.f$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C7792a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f547831a = null;

            static {
                int[] r100 = new int[HostPermissionState.values().length];
                r100[HostPermissionState.GRANTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[HostPermissionState.DENIED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[HostPermissionState.REJECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f547831a = r100;
            }
        }

        public a(OnPermissionCallback r100) {
            this.f547830a = r100;
        }

        @Override // hx7.i
        public final void onResult(boolean r100, Map<String, ? extends HostPermissionState> r101) {
            Intrinsics.checkNotNullParameter(r101, "result");
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator r103 = ((LinkedHashMap) r101).entrySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L15;
            Map.Entry r104 = (Map.Entry) r103.next();
            HostPermissionState r105 = (HostPermissionState) r104.getValue();
            int r106 = C7792a.f547831a[r105.ordinal()];
            if (r106 != 1) goto L8;
            r102.put(r104.getKey(), PermissionState.GRANTED);
            goto L4
        L8:
            if (r106 != 2) goto L10;
            r102.put(r104.getKey(), PermissionState.DENIED);
            goto L4
        L10:
            if (r106 != 3) goto L4;
            r102.put(r104.getKey(), PermissionState.REJECTED);
            goto L4
        L15:
            this.f547830a.onResult(r100, r102);
        }
    }

    public f() {
        Map<Class<?>, com.ivy.ivykit.api.bridge.d<?>> r100 = com.ivy.ivykit.api.bridge.b.f278301a;
        this.f547829a = (hx7.e) com.ivy.ivykit.api.bridge.b.a(hx7.e.class);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend
    public final boolean isPermissionAllGranted(Context r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "permission");
        hx7.e r102 = this.f547829a;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.isPermissionAllGranted(r100, (String[]) Arrays.copyOf(r101, r101.length));
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend
    public final void requestPermission(Activity r100, IBDXBridgeContext r101, String r102, String[] r103, OnPermissionCallback r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "bridgeName");
        Intrinsics.checkNotNullParameter(r103, "permission");
        Intrinsics.checkNotNullParameter(r104, "callback");
        hx7.e r105 = this.f547829a;
        if (r105 == null) goto L6;
        r105.a(r100, (String[]) Arrays.copyOf(r103, r103.length), new a(r104));
        return;
    }
}
