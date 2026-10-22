package n3c;

import com.bytedance.lark.policy.model.ErrorCode;
import com.bytedance.lark.policy.utils.EventTrace;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.network.service.NetworkErrorResultException;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.a f517026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<JSONObject, Unit> f517027b;

    /* JADX WARN: Multi-variable type inference failed */
    public k(com.ss.android.lark.security.compliance.infra.network.a r100, Function1<? super JSONObject, Unit> r101) {
        this.f517026a = r100;
        this.f517027b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Throwable r111 = (Throwable) r110;
        if ((r111 instanceof JSONException) == false) goto L6;
        int r100 = ScsLogger.f440428a;
        StringBuilder r101 = new StringBuilder("parse json error: path: ");
        r101.append(this.f517026a.f440432a);
        r101.append(",requestBody:");
        r101.append(this.f517026a.f440436e);
        r101.append(',');
        JSONException r112 = (JSONException) r111;
        r101.append(r112.getMessage());
        ScsLogger.c("Network", r101.toString());
        int r102 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.NETWORK_REQUEST_ERROR, "json parse error: path: " + this.f517026a.f440432a + "},msg:" + r112.getMessage(), null, 12);
    L18:
        this.f517027b.invoke(null);
        return;
    L6:
        if ((r111 instanceof NetworkErrorResultException) == false) goto L17;
        Boolean r103 = (Boolean) ((LinkedHashMap) l.f517029b).get(this.f517026a.f440432a);
        if (r103 == null) goto L10;
        boolean r104 = r103.booleanValue();
    L11:
        NetworkErrorResultException r113 = (NetworkErrorResultException) r111;
        if (r113.getNetworkErrorResult().getErrorCode() != (-2)) goto L14;
    L15:
        int r105 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.NETWORK_REQUEST_ERROR, "network request error,path:" + this.f517026a.f440432a + ",isFirstRequest:" + r104 + ",errMsg:" + r113.getNetworkErrorResult().getErrorMessage(), null, 12);
    L16:
        int r106 = ScsLogger.f440428a;
        ScsLogger.c("Network", "network error: path: " + this.f517026a.f440432a + ",requestBody:" + this.f517026a.f440436e + ",isFirstRequest:" + r104 + ",errorInfo:" + r113.getNetworkErrorResult());
        goto L18
    L14:
        if (r113.getNetworkErrorResult().getErrorCode() != (-6)) goto L16;
    L10:
        r104 = true;
        goto L11
    L17:
        int r107 = ScsLogger.f440428a;
        ScsLogger.c("Network", "unknown network error: path: " + this.f517026a.f440432a + ",requestBody:" + this.f517026a.f440436e + ",doRealRequest,msg:" + r111.getMessage());
        int r108 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.NETWORK_REQUEST_ERROR, "unknown network error: path: " + this.f517026a.f440432a + "},msg:" + r111.getMessage(), null, 12);
        goto L18
    }
}
