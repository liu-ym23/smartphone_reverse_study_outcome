package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class g implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f500604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingSource f500605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f500606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f500607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmHttpMethod f500608e;

    @Override // gvb.a
    public final Map<String, String> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("biz_id_list", CollectionsKt.joinToString$default(this.f500604a, ",", null, null, 0, null, null, 62, null)), TuplesKt.to("minutes_biz_type", String.valueOf(this.f500606c))});
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
        return false;
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
        return this.f500605b;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.f500608e;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.f500607d;
    }

    public g(List<String> r100, MmRecordingSource r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "bizIdList");
        this.f500604a = r100;
        this.f500605b = r101;
        this.f500606c = 2;
        Lazy r103 = MmNetworkReqPath.f433890a;
        if (r102 == false) goto L5;
        String r104 = MmNetworkReqPath.b(r101) + "lookup_by_bizids";
    L6:
        this.f500607d = r104;
        this.f500608e = MmHttpMethod.GET;
        return;
    L5:
        r104 = MmNetworkReqPath.a(r101) + "recording/lookup_by_bizids";
        goto L6
    }
}
