package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class l implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f500625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmHttpMethod f500627c;

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
    public final Map<String, String> f() {
        Pair[] r100 = new Pair[2];
        String r101 = "1";
        r100[0] = TuplesKt.to("option_type", "1");
        if (this.f500625a == false) goto L5;
        r101 = "0";
    L5:
        r100[1] = TuplesKt.to("default_option", r101);
        return MapsKt.mapOf(r100);
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
    public final MmRecordingSource getClientSource() {
        return MmRecordingSource.FEISHU_HARDWARE_D1204;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.f500627c;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.f500626b;
    }

    public l(boolean r100) {
        this.f500625a = r100;
        Lazy r101 = MmNetworkReqPath.f433890a;
        this.f500626b = MmNetworkReqPath.a(MmRecordingSource.FEISHU_HARDWARE_D1204) + "set-default-option";
        this.f500627c = MmHttpMethod.POST;
    }
}
