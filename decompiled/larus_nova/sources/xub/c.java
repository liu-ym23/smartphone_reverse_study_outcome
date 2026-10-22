package xub;

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
public final class c implements gvb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f565119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f565120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f565121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f565122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f565123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MmRecordingSource f565124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f565125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MmHttpMethod f565126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MmHttpContentType f565127k;

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
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("name", this.f565117a);
        r100.put("file_size", this.f565118b);
        r100.put("file_header", this.f565119c);
        r100.put("drive_upload", "true");
        r100.put("upload_token", this.f565120d);
        MmMinutesCreateSource r101 = ivb.a.a(this.f565124h);
        if (r101 == null) goto L5;
        String r102 = Integer.valueOf(r101.getValue()).toString();
    L6:
        if (r102 == null) goto L8;
        r100.put("create_source", r102);
    L8:
        String r103 = this.f565121e;
        boolean r104 = false;
        if (r103 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L17;
        r100.put("upload_unique_id", this.f565121e);
    L17:
        String r106 = this.f565122f;
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == true) goto L26;
        r100.put("ext_data", this.f565122f);
    L26:
        String r108 = this.f565123g;
        if (r108 != null) goto L29;
    L30:
        r104 = true;
    L31:
        if (r104 == true) goto L33;
        r100.put("doubao_biz_info", this.f565123g);
    L33:
        return r100;
    L29:
        if (r108.length() != 0) goto L31;
    L20:
        if (r106.length() == 0) goto L23;
        r107 = false;
        goto L24
    L11:
        if (r103.length() == 0) goto L14;
        r105 = false;
        goto L15
    L5:
        r102 = null;
        goto L6
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
        return this.f565124h;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return this.f565127k;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.f565126j;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.f565125i;
    }

    public c(String r100, String r101, String r102, String r103, String r104, String r105, String r106, MmRecordingSource r107) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "fileSize");
        Intrinsics.checkNotNullParameter(r102, "fileHeader");
        Intrinsics.checkNotNullParameter(r103, "uploadToken");
        this.f565117a = r100;
        this.f565118b = r101;
        this.f565119c = r102;
        this.f565120d = r103;
        this.f565121e = r104;
        this.f565122f = r105;
        this.f565123g = r106;
        this.f565124h = r107;
        Lazy r108 = MmNetworkReqPath.f433890a;
        this.f565125i = MmNetworkReqPath.a(r107) + "upload/prepare";
        this.f565126j = MmHttpMethod.POST;
        this.f565127k = MmHttpContentType.JSON;
    }
}
