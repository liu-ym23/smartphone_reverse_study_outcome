package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class i implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f500617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f500618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmRecordingSource f500619e;

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
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("quota_type", this.f500616b), TuplesKt.to("feature_key", this.f500617c), TuplesKt.to("object_token", this.f500615a), TuplesKt.to("license_plan_key", this.f500618d)});
    }

    @Override // gvb.a
    public final String getPath() {
        return "/minutes/api/report_upgrade_event";
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
        return this.f500619e;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return MmHttpMethod.POST;
    }

    public i(String r100, String r101, String r102, String r103, MmRecordingSource r104) {
        Intrinsics.checkNotNullParameter(r100, "objectToken");
        Intrinsics.checkNotNullParameter(r101, "quotaType");
        Intrinsics.checkNotNullParameter(r102, "featureKey");
        Intrinsics.checkNotNullParameter(r103, "licensePlanKey");
        this.f500615a = r100;
        this.f500616b = r101;
        this.f500617c = r102;
        this.f500618d = r103;
        this.f500619e = r104;
    }
}
