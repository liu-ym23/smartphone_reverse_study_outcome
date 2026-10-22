package com.bytedance.bdp.appbase.netapi.base;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\nB7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\rR\u0014\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/base/NetResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "headers", "", "", "errInfo", "Lcom/bytedance/bdp/appbase/netapi/base/ErrorInfo;", "(Ljava/lang/Object;Ljava/util/Map;Lcom/bytedance/bdp/appbase/netapi/base/ErrorInfo;)V", "(Ljava/lang/Object;Lcom/bytedance/bdp/appbase/netapi/base/ErrorInfo;)V", PlayerResolution.SDKKEY.ORIGIN, "Lorg/json/JSONObject;", "(Ljava/lang/Object;Lorg/json/JSONObject;Ljava/util/Map;Lcom/bytedance/bdp/appbase/netapi/base/ErrorInfo;)V", "Ljava/lang/Object;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final class NetResult<T> {
    public final T data;
    public final ErrorInfo errInfo;
    public final Map<String, String> headers;
    public final JSONObject origin;

    public NetResult(T r100, ErrorInfo r101) {
        this(r100, null, null, r101);
    }

    public NetResult(T r100, Map<String, String> r101, ErrorInfo r102) {
        this(r100, null, r101, r102);
    }

    public NetResult(T r100, JSONObject r101, Map<String, String> r102, ErrorInfo r103) {
        this.data = r100;
        this.origin = r101;
        this.headers = r102;
        this.errInfo = r103;
    }
}
