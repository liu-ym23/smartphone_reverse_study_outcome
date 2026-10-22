package io.ktor.http.content;

import io.ktor.http.x;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lio/ktor/http/content/VersionCheckResult;", "", "Lio/ktor/http/x;", "statusCode", "Lio/ktor/http/x;", "getStatusCode", "()Lio/ktor/http/x;", "OK", "NOT_MODIFIED", "PRECONDITION_FAILED", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final enum VersionCheckResult extends Enum<VersionCheckResult> {
    public static final VersionCheckResult NOT_MODIFIED = null;
    public static final VersionCheckResult OK = null;
    public static final VersionCheckResult PRECONDITION_FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VersionCheckResult[] f491837a = null;
    private final x statusCode;

    public static VersionCheckResult valueOf(String r100) {
        return (VersionCheckResult) r27.a.a(VersionCheckResult.class, r100);
    }

    public static VersionCheckResult[] values() {
        return (VersionCheckResult[]) f491837a.clone();
    }

    static {
        x r100 = x.f491916c;
        VersionCheckResult r101 = new VersionCheckResult("OK", 0, x.f491917d);
        OK = r101;
        VersionCheckResult r102 = new VersionCheckResult("NOT_MODIFIED", 1, x.f491921h);
        NOT_MODIFIED = r102;
        VersionCheckResult r103 = new VersionCheckResult("PRECONDITION_FAILED", 2, x.f491924k);
        PRECONDITION_FAILED = r103;
        f491837a = new VersionCheckResult[]{r101, r102, r103};
    }

    public final x getStatusCode() {
        return this.statusCode;
    }

    public VersionCheckResult(String r100, int r101, x r102) {
        super(r100, r101);
        this.statusCode = r102;
    }
}
