package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmHttpMethod f500593b;

    @Override // gvb.a
    public final ByteString b() {
        return null;
    }

    @Override // gvb.a
    public final String c() {
        return null;
    }

    @Override // gvb.a
    public final boolean d() {
        return false;
    }

    @Override // gvb.a
    public final Map<String, String> a() {
        return MapsKt.mapOf(TuplesKt.to("option_type", "1"));
    }

    public b() {
        Lazy r100 = MmNetworkReqPath.f433890a;
        this.f500592a = MmNetworkReqPath.a(MmRecordingSource.FEISHU_HARDWARE_D1204) + "get-default-option";
        this.f500593b = MmHttpMethod.GET;
    }

    @Override // gvb.a
    public final Map<String, String> e() {
        return MapsKt.emptyMap();
    }

    @Override // gvb.a
    public final Map<String, String> f() {
        return MapsKt.emptyMap();
    }

    @Override // gvb.a
    public final MmRecordingSource getClientSource() {
        return MmRecordingSource.FEISHU_HARDWARE_D1204;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.f500593b;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.f500592a;
    }
}
