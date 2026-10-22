package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingSource f500603a;

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
        return new HashMap();
    }

    @Override // gvb.a
    public final Map<String, String> f() {
        return new HashMap();
    }

    @Override // gvb.a
    public final String getPath() {
        Lazy r100 = MmNetworkReqPath.f433890a;
        return MmNetworkReqPath.a(this.f500603a) + "user/guide";
    }

    @Override // gvb.a
    public final Map<String, String> e() {
        return MapsKt.emptyMap();
    }

    @Override // gvb.a
    public final MmRecordingSource getClientSource() {
        return this.f500603a;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return MmHttpMethod.GET;
    }

    public e(MmRecordingSource r100) {
        this.f500603a = r100;
    }
}
