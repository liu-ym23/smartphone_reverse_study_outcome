package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class j implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingSource f500621b;

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
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("guide_type", this.f500620a)});
    }

    @Override // gvb.a
    public final Map<String, String> a() {
        return new HashMap();
    }

    @Override // gvb.a
    public final String getPath() {
        Lazy r100 = MmNetworkReqPath.f433890a;
        return MmNetworkReqPath.a(this.f500621b) + "user/guide/add";
    }

    @Override // gvb.a
    public final Map<String, String> e() {
        return MapsKt.emptyMap();
    }

    @Override // gvb.a
    public final MmRecordingSource getClientSource() {
        return this.f500621b;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return MmHttpMethod.POST;
    }

    public j(String r100, MmRecordingSource r101) {
        Intrinsics.checkNotNullParameter(r100, "guideType");
        this.f500620a = r100;
        this.f500621b = r101;
    }
}
