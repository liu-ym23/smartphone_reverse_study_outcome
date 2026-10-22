package io.ktor.http.auth;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/http/auth/HeaderValueEncoding;", "", "QUOTED_WHEN_REQUIRED", "QUOTED_ALWAYS", "URI_ENCODE", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final enum HeaderValueEncoding extends Enum<HeaderValueEncoding> {
    public static final HeaderValueEncoding QUOTED_ALWAYS = null;
    public static final HeaderValueEncoding QUOTED_WHEN_REQUIRED = null;
    public static final HeaderValueEncoding URI_ENCODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HeaderValueEncoding[] f491830a = null;

    public static HeaderValueEncoding valueOf(String r100) {
        return (HeaderValueEncoding) r27.a.a(HeaderValueEncoding.class, r100);
    }

    public static HeaderValueEncoding[] values() {
        return (HeaderValueEncoding[]) f491830a.clone();
    }

    static {
        HeaderValueEncoding r100 = new HeaderValueEncoding("QUOTED_WHEN_REQUIRED", 0);
        QUOTED_WHEN_REQUIRED = r100;
        HeaderValueEncoding r101 = new HeaderValueEncoding("QUOTED_ALWAYS", 1);
        QUOTED_ALWAYS = r101;
        HeaderValueEncoding r102 = new HeaderValueEncoding("URI_ENCODE", 2);
        URI_ENCODE = r102;
        f491830a = new HeaderValueEncoding[]{r100, r101, r102};
    }

    public HeaderValueEncoding(String r100, int r101) {
        super(r100, r101);
    }
}
