package xub;

import com.larus.platform.model.SlashMentionConfig;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.MmMinutesCreateSource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingSource f565105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f565106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmHttpMethod f565107d;

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
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("file_info[]", this.f565104a);
        MmMinutesCreateSource r101 = ivb.a.a(this.f565105b);
        if (r101 == null) goto L5;
        String r102 = Integer.valueOf(r101.getValue()).toString();
    L6:
        if (r102 == null) goto L8;
        r100.put("create_source", r102);
    L8:
        return r100;
    L5:
        r102 = null;
        goto L6
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
        return this.f565105b;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.f565107d;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.f565106c;
    }

    public a(String r100, MmRecordingSource r101) {
        Intrinsics.checkNotNullParameter(r100, "fileInfoStr");
        this.f565104a = r100;
        this.f565105b = r101;
        Lazy r102 = MmNetworkReqPath.f433890a;
        this.f565106c = MmNetworkReqPath.a(r101) + SlashMentionConfig.SLASH_CONTENT_QUOTA;
        this.f565107d = MmHttpMethod.GET;
    }
}
