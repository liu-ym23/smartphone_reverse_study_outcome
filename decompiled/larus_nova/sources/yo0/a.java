package yo0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.openplatform.impl.base.api.response.OpenPlatformRespExtra;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.openapi.OpenApiErrorInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f568618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OpenPlatformContext f568619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<Long> f568620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f568621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a f568622e;

    /* JADX INFO: renamed from: yo0.a$a, reason: collision with other inner class name */
    public interface InterfaceC8363a {
        void a(d r100);

        void b(d r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC8363a f568623a;

        public b(InterfaceC8363a r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.f568623a = r100;
        }

        public final void a(Throwable r100) {
            InterfaceC8363a r101 = this.f568623a;
            d.a.f568627d.getClass();
            if ((r100 instanceof CustomApiServerException) == false) goto L27;
            CustomApiServerException r102 = (CustomApiServerException) r100;
            Intrinsics.checkNotNullParameter(r102, "error");
            String r103 = r102.getExtra();
            if (r103 != null) goto L7;
        L25:
            d.a r104 = d.a.C8364a.b(OpenApiErrorInfo.INTERNAL_ERROR, null);
        L30:
            r101.a(r104.a());
            return;
        L7:
            if (r103.length() <= 0) goto L9;
            boolean r105 = true;
        L10:
            if (r105 != true) goto L25;
            JsonElement r106 = GsonHelper.parser().parse(r103);     // Catch: Exception -> L32
            if (r106 == null) goto L25;
            JsonObject r107 = r106.getAsJsonObject();     // Catch: Exception -> L32
            if (r107 == null) goto L25;
            OpenPlatformRespExtra r108 = (OpenPlatformRespExtra) GsonHelper.get().fromJson(r107, OpenPlatformRespExtra.class);     // Catch: Exception -> L32
            if (r108 == null) goto L18;
            int r109 = r108.errorCode;     // Catch: Exception -> L32
        L19:
            if (r108 == null) goto L22;
            String r110 = r108.errorMsg;     // Catch: Exception -> L32
            if (r110 == null) goto L22;
        L23:
            r104 = d.a.C8364a.a(r109, r110, null);     // Catch: Exception -> L32
        L22:
            r110 = OpenApiErrorInfo.INTERNAL_ERROR.getErrorMsg();     // Catch: Exception -> L32
            goto L23
        L18:
            r109 = OpenApiErrorInfo.INTERNAL_ERROR.getErrorCode();     // Catch: Exception -> L32
            goto L19
        L9:
            r105 = false;
            goto L10
        L27:
            if ((r100 instanceof NetworkErrorException) == false) goto L29;
            r104 = d.a.C8364a.b(OpenApiErrorInfo.NETWORK_ERROR, null);
            goto L30
        L29:
            r104 = d.a.C8364a.b(OpenApiErrorInfo.INTERNAL_ERROR, null);
            goto L30
        }

        public final void c(JSONObject r100) {
            InterfaceC8363a r101 = this.f568623a;
            d.a.f568627d.getClass();
            d.a r102 = new d.a(OpenApiErrorInfo.SUCCESS.getErrorCode());
            r102.f568629b = r100;
            r101.b(r102.a());
        }

        public static void b(b r100, OpenApiErrorInfo r101) {
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "errorInfo");
            InterfaceC8363a r102 = r100.f568623a;
            d.a.f568627d.getClass();
            r102.a(d.a.C8364a.b(r101, null).a());
        }
    }

    public static final class c {
    }

    public final void a(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.f568622e.a(r100);
    }

    public abstract String b();

    public abstract void call(JSONObject r100, b r101);

    static {
        OpenApiErrorInfo.INCORRECT_PARAMS.getErrorCode();
    }

    public a(OpenPlatformContext r100, Queue<Long> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r101, "callHistory");
        Intrinsics.checkNotNullParameter(r102, "appId");
        this.f568622e = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.f568619b = r100;
        this.f568620c = r101;
        this.f568621d = r102;
        this.f568618a = new ArrayList();
    }
}
