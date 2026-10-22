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
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class o implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f500637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f500638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f500639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmRecordingSource f500640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f500641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f500642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MmHttpMethod f500643h;

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
        if (this.f500641f == false) goto L5;
        String r100 = "recording_id";
    L7:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, this.f500636a), TuplesKt.to("latitude", String.valueOf(this.f500637b)), TuplesKt.to("longitude", String.valueOf(this.f500638c)), TuplesKt.to("location", this.f500639d)});
    L5:
        r100 = "object_token";
        goto L7
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
        return this.f500640e;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.f500643h;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.f500642g;
    }

    public o(String r100, double r101, double r102, String r103, MmRecordingSource r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "locationIdentity");
        Intrinsics.checkNotNullParameter(r103, "location");
        this.f500636a = r100;
        this.f500637b = r101;
        this.f500638c = r102;
        this.f500639d = r103;
        this.f500640e = r104;
        this.f500641f = r105;
        Lazy r106 = MmNetworkReqPath.f433890a;
        if (r105 == false) goto L5;
        String r107 = MmNetworkReqPath.b(r104) + "location";
    L6:
        this.f500642g = r107;
        this.f500643h = MmHttpMethod.POST;
        return;
    L5:
        r107 = MmNetworkReqPath.a(r104) + "audio/location";
        goto L6
    }
}
