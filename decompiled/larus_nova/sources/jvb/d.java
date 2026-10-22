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
public final class d implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmRecordingSource f500599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f500600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f500601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f500602f;

    @Override // gvb.a
    public final Map<String, String> a() {
        boolean r100 = false;
        HashMap r101 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("quota_type_list", this.f500598b), TuplesKt.to("scene", "MinutesDetailForRealtimeRecording"), TuplesKt.to("language", this.f500600d), TuplesKt.to("upgrade_optional", String.valueOf(this.f500601e))});
        if (this.f500597a.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        r101.put("object_token", this.f500597a);
    L9:
        if (this.f500602f.length() <= 0) goto L11;
        r100 = true;
    L11:
        if (r100 == false) goto L13;
        r101.put("function_scene_list[]", this.f500602f);
    L13:
        return r101;
    L5:
        r102 = false;
        goto L6
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
    public final String getPath() {
        Lazy r100 = MmNetworkReqPath.f433890a;
        return MmNetworkReqPath.a(this.f500599c) + "quota_data";
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
        return this.f500599c;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return MmHttpMethod.GET;
    }

    public d(String r100, String r101, MmRecordingSource r102, String r103) {
        String r104 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.a.a();
        Intrinsics.checkNotNullParameter(r100, "objectToken");
        Intrinsics.checkNotNullParameter(r101, "quotaTypeList");
        Intrinsics.checkNotNullParameter(r104, "language");
        Intrinsics.checkNotNullParameter(r103, "functionScene");
        this.f500597a = r100;
        this.f500598b = r101;
        this.f500599c = r102;
        this.f500600d = r104;
        this.f500601e = false;
        this.f500602f = r103;
    }
}
