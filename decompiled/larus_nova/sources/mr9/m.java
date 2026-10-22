package mr9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/upload/ResourceUploadToken;", "", "serviceId", "", "uploadPathPrefix", "uploadHost", "auth", "Lcom/larus/platform/model/upload/ImageAuth;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/upload/ImageAuth;)V", "getServiceId", "()Ljava/lang/String;", "getUploadPathPrefix", "getUploadHost", "getAuth", "()Lcom/larus/platform/model/upload/ImageAuth;", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class m {

    @SerializedName("auth")
    private final b auth;

    @SerializedName("service_id")
    private final String serviceId;

    @SerializedName("upload_host")
    private final String uploadHost;

    @SerializedName("upload_path_prefix")
    private final String uploadPathPrefix;

    /* JADX WARN: Multi-variable type inference failed */
    public m() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.serviceId, r101.serviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uploadPathPrefix, r101.uploadPathPrefix) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uploadHost, r101.uploadHost) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.auth, r101.auth) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.serviceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.uploadPathPrefix;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.uploadHost;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        b r110 = this.auth;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "[serviceId:" + this.serviceId + ", uploadPathPrefix:" + this.uploadPathPrefix + ", uploadHost:" + this.uploadHost + ", auth:" + this.auth + ']';
    }

    public final b a() {
        return this.auth;
    }

    public final String b() {
        return this.serviceId;
    }

    public final String c() {
        return this.uploadHost;
    }

    public final String d() {
        return this.uploadPathPrefix;
    }

    public /* synthetic */ m(String r100, String r101, b r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L8;
        String r104 = "";
    L10:
        if ((r103 & 4) == 0) goto L13;
        r101 = "";
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = null;
    L15:
        this(r100, r104, r101, r102);
        return;
    L8:
        r104 = null;
        goto L10
    }

    public m(String r100, String r101, String r102, b r103) {
        this.serviceId = r100;
        this.uploadPathPrefix = r101;
        this.uploadHost = r102;
        this.auth = r103;
    }
}
