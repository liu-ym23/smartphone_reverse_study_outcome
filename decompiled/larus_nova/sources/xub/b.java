package xub;

import com.bytedance.android.livesdkapi.vr.LiveVrEffectInfo;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f565110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f565111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f565112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmRecordingSource f565113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f565114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MmHttpMethod f565115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MmHttpContentType f565116i;

    @Override // gvb.a
    public final ByteString b() {
        return null;
    }

    @Override // gvb.a
    public final boolean d() {
        return false;
    }

    @Override // gvb.a
    public final String c() {
        return new JSONObject().put("auto_transcribe", true).put("language", LiveVrEffectInfo.STREAM_FORMAT_LITE_MODE_6DOF_OFF_MIXED).put("object_token", this.f565108a).put("upload_id", this.f565109b).put("upload_token", this.f565110c).put("vhid", this.f565111d).put("upload_file_tokens", this.f565112e).toString();
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
        return this.f565113f;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return this.f565116i;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.f565115h;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.f565114g;
    }

    public b(String r100, String r101, String r102, String r103, String r104, MmRecordingSource r105) {
        Intrinsics.checkNotNullParameter(r100, "objectToken");
        Intrinsics.checkNotNullParameter(r101, "uploadId");
        Intrinsics.checkNotNullParameter(r102, "uploadToken");
        Intrinsics.checkNotNullParameter(r103, "vhId");
        Intrinsics.checkNotNullParameter(r104, "uploadFileTokens");
        this.f565108a = r100;
        this.f565109b = r101;
        this.f565110c = r102;
        this.f565111d = r103;
        this.f565112e = r104;
        this.f565113f = r105;
        Lazy r106 = MmNetworkReqPath.f433890a;
        this.f565114g = MmNetworkReqPath.a(r105) + "upload/finish";
        this.f565115h = MmHttpMethod.POST;
        this.f565116i = MmHttpContentType.JSON;
    }
}
