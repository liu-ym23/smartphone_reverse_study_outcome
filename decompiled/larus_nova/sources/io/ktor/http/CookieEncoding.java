package io.ktor.http;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/http/CookieEncoding;", "", "RAW", "DQUOTES", "URI_ENCODING", "BASE64_ENCODING", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final enum CookieEncoding extends Enum<CookieEncoding> {
    public static final CookieEncoding BASE64_ENCODING = null;
    public static final CookieEncoding DQUOTES = null;
    public static final CookieEncoding RAW = null;
    public static final CookieEncoding URI_ENCODING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CookieEncoding[] f491807a = null;

    public static CookieEncoding valueOf(String r100) {
        return (CookieEncoding) r27.a.a(CookieEncoding.class, r100);
    }

    public static CookieEncoding[] values() {
        return (CookieEncoding[]) f491807a.clone();
    }

    static {
        CookieEncoding r100 = new CookieEncoding("RAW", 0);
        RAW = r100;
        CookieEncoding r101 = new CookieEncoding("DQUOTES", 1);
        DQUOTES = r101;
        CookieEncoding r102 = new CookieEncoding("URI_ENCODING", 2);
        URI_ENCODING = r102;
        CookieEncoding r103 = new CookieEncoding("BASE64_ENCODING", 3);
        BASE64_ENCODING = r103;
        f491807a = new CookieEncoding[]{r100, r101, r102, r103};
    }

    public CookieEncoding(String r100, int r101) {
        super(r100, r101);
    }
}
