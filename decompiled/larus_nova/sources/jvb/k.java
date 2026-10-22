package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class k implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f500622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f500623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmRecordingSource f500624c;

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
        a r100 = this.f500622a;
        if ((r100 instanceof a.b) == false) goto L6;
        String r101 = "recording_id";
    L8:
        Pair[] r102 = new Pair[3];
        r102[0] = TuplesKt.to(r101, r100.a());
        r102[1] = TuplesKt.to("status", "5");
        if (this.f500623b == false) goto L11;
        String r103 = "0";
    L12:
        r102[2] = TuplesKt.to("save_audio_type", r103);
        return MapsKt.hashMapOf(r102);
    L11:
        r103 = "1";
        goto L12
    L6:
        if ((r100 instanceof a.C6488a) == false) goto L15;
        r101 = "object_token";
        goto L8
    L15:
        throw new NoWhenBranchMatchedException();
    }

    @Override // gvb.a
    public final String getPath() {
        Lazy r100 = MmNetworkReqPath.f433890a;
        return MmNetworkReqPath.c(this.f500624c, this.f500622a instanceof a.b);
    }

    @Override // gvb.a
    public final Map<String, String> e() {
        return MapsKt.emptyMap();
    }

    @Override // gvb.a
    public final MmRecordingSource getClientSource() {
        return this.f500624c;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return MmHttpMethod.POST;
    }

    public k(a r100, boolean r101, MmRecordingSource r102) {
        Intrinsics.checkNotNullParameter(r100, "audioSaveIdentity");
        this.f500622a = r100;
        this.f500623b = r101;
        this.f500624c = r102;
    }
}
