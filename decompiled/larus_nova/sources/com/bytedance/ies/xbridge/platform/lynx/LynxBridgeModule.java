package com.bytedance.ies.xbridge.platform.lynx;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeRegister;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.Arguments;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n66.d;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/xbridge/platform/lynx/LynxBridgeModule;", "Lcom/lynx/jsbridge/LynxModule;", "", "func", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "Lcom/bytedance/ies/xbridge/XBridgeRegister;", "xBridgeRegister", "", NotificationCompat.CATEGORY_CALL, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final class LynxBridgeModule extends LynxModule {
    public static final a Companion = null;
    public static final String NAME = "LynxBridge";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f249513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ReadableMap f249514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ XBridgeRegister f249515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Callback f249516d;

        public static final class a implements XBridgeMethod.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Callback f249517a;

            public a(Callback r100) {
                this.f249517a = r100;
            }

            @Override // com.bytedance.ies.xbridge.XBridgeMethod.Callback
            public final void invoke(Map<String, Object> r100) {
                Intrinsics.checkNotNullParameter(r100, "data");
                this.f249517a.invoke(new Object[]{Arguments.makeNativeMap(r100)});
            }
        }

        public b(String r100, ReadableMap r101, XBridgeRegister r102, Callback r103) {
            this.f249513a = r100;
            this.f249514b = r101;
            this.f249515c = r102;
            this.f249516d = r103;
        }

        public final void a() {
            m66.a r100 = (m66.a) XBridge.INSTANCE.getPlatform(m66.a.class);     // Catch: Exception -> L6
            if (r100 == null) goto L11;
            r100.a(this.f249513a, new d(this.f249514b), new a(this.f249516d), this.f249515c);     // Catch: Exception -> L6
            return;
        L11:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public LynxBridgeModule(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @LynxMethod
    public final void call(String r100, ReadableMap r101, Callback r102, XBridgeRegister r103) {
        Intrinsics.checkNotNullParameter(r100, "func");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "xBridgeRegister");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        new Handler().post(new b(r100, r101, r103, r102));
    }
}
