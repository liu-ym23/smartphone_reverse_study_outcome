package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmRecordingUpdateStatus;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class h implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingUpdateStatus f500610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmRecordingSource f500611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f500612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f500613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f500614f;

    public static final class a {
    }

    static {
    }

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
        return true;
    }

    @Override // gvb.a
    public final Map<String, String> f() {
        HashMap r100 = new HashMap();
        if (this.f500614f == false) goto L5;
        r100.put("recording_id", this.f500609a);
    L6:
        r100.put("status", String.valueOf(this.f500610b.getValue()));
        Boolean r101 = this.f500612d;
        if (r101 != null) goto L9;
    L13:
        Long r102 = this.f500613e;
        if (r102 == null) goto L16;
        r100.put("duration_ms", String.valueOf(r102.longValue()));
    L16:
        return r100;
    L9:
        if (r101.booleanValue() == false) goto L11;
        String r103 = "0";
    L12:
        r100.put("save_artifact_type", r103);
        goto L13
    L11:
        r103 = "1";
        goto L12
    L5:
        r100.put("object_token", this.f500609a);
        goto L6
    }

    @Override // gvb.a
    public final String getPath() {
        Lazy r100 = MmNetworkReqPath.f433890a;
        return MmNetworkReqPath.c(this.f500611c, this.f500614f);
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
        return this.f500611c;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return MmHttpMethod.POST;
    }

    public h(String r100, MmRecordingUpdateStatus r101, MmRecordingSource r102, Boolean r103, Long r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "recordingStatusIdentity");
        Intrinsics.checkNotNullParameter(r101, "status");
        this.f500609a = r100;
        this.f500610b = r101;
        this.f500611c = r102;
        this.f500612d = r103;
        this.f500613e = r104;
        this.f500614f = r105;
    }
}
