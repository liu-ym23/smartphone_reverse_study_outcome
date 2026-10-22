package io.ktor.http;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"io/ktor/http/CacheControl$Visibility", "", "Lio/ktor/http/CacheControl$Visibility;", "", "headerValue", "Ljava/lang/String;", "getHeaderValue$ktor_http", "()Ljava/lang/String;", "Public", "Private", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final enum CacheControl$Visibility extends Enum<CacheControl$Visibility> {
    public static final CacheControl$Visibility Private = null;
    public static final CacheControl$Visibility Public = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheControl$Visibility[] f491799a = null;
    private final String headerValue;

    public static CacheControl$Visibility valueOf(String r100) {
        return (CacheControl$Visibility) r27.a.a(CacheControl$Visibility.class, r100);
    }

    public static CacheControl$Visibility[] values() {
        return (CacheControl$Visibility[]) f491799a.clone();
    }

    static {
        CacheControl$Visibility r100 = new CacheControl$Visibility("Public", 0, "public");
        Public = r100;
        CacheControl$Visibility r101 = new CacheControl$Visibility("Private", 1, BridgePrivilege.PRIVATE);
        Private = r101;
        f491799a = new CacheControl$Visibility[]{r100, r101};
    }

    public final String getHeaderValue$ktor_http() {
        return this.headerValue;
    }

    public CacheControl$Visibility(String r100, int r101, String r102) {
        super(r100, r101);
        this.headerValue = r102;
    }
}
