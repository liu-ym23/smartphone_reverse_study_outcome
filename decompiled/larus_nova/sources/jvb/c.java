package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingSource f500594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmHttpMethod f500596c;

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
        return MapsKt.emptyMap();
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
        return this.f500594a;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.f500596c;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.f500595b;
    }

    public c(String r100, MmRecordingSource r101) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        this.f500594a = r101;
        StringBuilder r102 = new StringBuilder();
        Lazy r103 = MmNetworkReqPath.f433890a;
        r102.append(MmNetworkReqPath.a(r101) + "bizid2token");
        r102.append("?biz_id_list=");
        r102.append(r100);
        r102.append("&minutes_biz_type=2");
        this.f500595b = r102.toString();
        this.f500596c = MmHttpMethod.GET;
    }
}
