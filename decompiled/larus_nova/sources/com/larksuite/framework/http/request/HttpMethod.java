package com.larksuite.framework.http.request;

/* JADX INFO: loaded from: classes24.dex */
public final enum HttpMethod extends Enum<HttpMethod> {
    public static final HttpMethod DELETE = null;
    public static final HttpMethod GET = null;
    public static final HttpMethod HEAD = null;
    public static final HttpMethod OPTIONS = null;
    public static final HttpMethod PATCH = null;
    public static final HttpMethod POST = null;
    public static final HttpMethod PUT = null;
    public static final HttpMethod TRACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HttpMethod[] f285577a = null;
    private final String value;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285578a = null;

        static {
            int[] r100 = new int[HttpMethod.values().length];
            f285578a = r100;
            r100[HttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f285578a[HttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        HttpMethod r100 = new HttpMethod("GET", 0, "GET");
        GET = r100;
        HttpMethod r101 = new HttpMethod("POST", 1, "POST");
        POST = r101;
        HttpMethod r102 = new HttpMethod("PUT", 2, "PUT");
        PUT = r102;
        HttpMethod r103 = new HttpMethod("DELETE", 3, "DELETE");
        DELETE = r103;
        HttpMethod r104 = new HttpMethod("HEAD", 4, "HEAD");
        HEAD = r104;
        HttpMethod r105 = new HttpMethod("PATCH", 5, "PATCH");
        PATCH = r105;
        HttpMethod r110 = new HttpMethod("OPTIONS", 6, "OPTIONS");
        OPTIONS = r110;
        HttpMethod r111 = new HttpMethod("TRACE", 7, "TRACE");
        TRACE = r111;
        f285577a = new HttpMethod[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static HttpMethod[] values() {
        return (HttpMethod[]) f285577a.clone();
    }

    public boolean hasBody() {
        int r100 = a.f285578a[ordinal()];
        if (r100 != 1) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 2) goto L8;
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static HttpMethod valueOf(String r100) {
        return (HttpMethod) r27.a.a(HttpMethod.class, r100);
    }

    public HttpMethod(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
