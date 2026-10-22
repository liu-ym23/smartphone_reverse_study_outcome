package org.nanohttpd.protocols.http.response;

import com.ss.bduploader.BDAbstractUpload;

/* JADX INFO: loaded from: classes42.dex */
public final enum Status extends Enum<Status> implements b {
    public static final Status ACCEPTED = null;
    public static final Status BAD_REQUEST = null;
    public static final Status CONFLICT = null;
    public static final Status CREATED = null;
    public static final Status EXPECTATION_FAILED = null;
    public static final Status FORBIDDEN = null;
    public static final Status FOUND = null;
    public static final Status GONE = null;
    public static final Status INTERNAL_ERROR = null;
    public static final Status LENGTH_REQUIRED = null;
    public static final Status METHOD_NOT_ALLOWED = null;
    public static final Status MULTI_STATUS = null;
    public static final Status NOT_ACCEPTABLE = null;
    public static final Status NOT_FOUND = null;
    public static final Status NOT_IMPLEMENTED = null;
    public static final Status NOT_MODIFIED = null;
    public static final Status NO_CONTENT = null;
    public static final Status OK = null;
    public static final Status PARTIAL_CONTENT = null;
    public static final Status PAYLOAD_TOO_LARGE = null;
    public static final Status PRECONDITION_FAILED = null;
    public static final Status RANGE_NOT_SATISFIABLE = null;
    public static final Status REDIRECT = null;
    public static final Status REDIRECT_SEE_OTHER = null;
    public static final Status REQUEST_TIMEOUT = null;
    public static final Status SERVICE_UNAVAILABLE = null;
    public static final Status SWITCH_PROTOCOL = null;
    public static final Status TEMPORARY_REDIRECT = null;
    public static final Status TOO_MANY_REQUESTS = null;
    public static final Status UNAUTHORIZED = null;
    public static final Status UNSUPPORTED_HTTP_VERSION = null;
    public static final Status UNSUPPORTED_MEDIA_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Status[] f526214a = null;
    private final String description;
    private final int requestStatus;

    static {
        Status r100 = new Status("SWITCH_PROTOCOL", 0, 101, "Switching Protocols");
        SWITCH_PROTOCOL = r100;
        Status r101 = new Status("OK", 1, 200, "OK");
        OK = r101;
        Status r102 = new Status("CREATED", 2, 201, "Created");
        CREATED = r102;
        Status r103 = new Status("ACCEPTED", 3, 202, "Accepted");
        ACCEPTED = r103;
        Status r104 = new Status("NO_CONTENT", 4, 204, "No Content");
        NO_CONTENT = r104;
        Status r105 = new Status("PARTIAL_CONTENT", 5, 206, "Partial Content");
        PARTIAL_CONTENT = r105;
        Status r106 = new Status("MULTI_STATUS", 6, 207, "Multi-Status");
        MULTI_STATUS = r106;
        Status r110 = new Status("REDIRECT", 7, 301, "Moved Permanently");
        REDIRECT = r110;
        Status r111 = new Status("FOUND", 8, 302, "Found");
        FOUND = r111;
        Status r112 = new Status("REDIRECT_SEE_OTHER", 9, 303, "See Other");
        REDIRECT_SEE_OTHER = r112;
        Status r113 = new Status("NOT_MODIFIED", 10, 304, "Not Modified");
        NOT_MODIFIED = r113;
        Status r107 = new Status("TEMPORARY_REDIRECT", 11, 307, "Temporary Redirect");
        TEMPORARY_REDIRECT = r107;
        Status r108 = new Status("BAD_REQUEST", 12, 400, "Bad Request");
        BAD_REQUEST = r108;
        Status r109 = new Status("UNAUTHORIZED", 13, 401, "Unauthorized");
        UNAUTHORIZED = r109;
        Status r114 = new Status("FORBIDDEN", 14, 403, "Forbidden");
        FORBIDDEN = r114;
        Status r115 = new Status("NOT_FOUND", 15, 404, "Not Found");
        NOT_FOUND = r115;
        Status r116 = new Status("METHOD_NOT_ALLOWED", 16, 405, "Method Not Allowed");
        METHOD_NOT_ALLOWED = r116;
        Status r117 = new Status("NOT_ACCEPTABLE", 17, 406, "Not Acceptable");
        NOT_ACCEPTABLE = r117;
        Status r118 = new Status("REQUEST_TIMEOUT", 18, 408, "Request Timeout");
        REQUEST_TIMEOUT = r118;
        Status r119 = new Status("CONFLICT", 19, 409, "Conflict");
        CONFLICT = r119;
        Status r120 = new Status("GONE", 20, 410, "Gone");
        GONE = r120;
        Status r121 = new Status("LENGTH_REQUIRED", 21, 411, "Length Required");
        LENGTH_REQUIRED = r121;
        Status r122 = new Status("PRECONDITION_FAILED", 22, 412, "Precondition Failed");
        PRECONDITION_FAILED = r122;
        Status r123 = new Status("PAYLOAD_TOO_LARGE", 23, 413, "Payload Too Large");
        PAYLOAD_TOO_LARGE = r123;
        Status r124 = new Status("UNSUPPORTED_MEDIA_TYPE", 24, 415, "Unsupported Media Type");
        UNSUPPORTED_MEDIA_TYPE = r124;
        Status r125 = new Status("RANGE_NOT_SATISFIABLE", 25, 416, "Requested Range Not Satisfiable");
        RANGE_NOT_SATISFIABLE = r125;
        Status r126 = new Status("EXPECTATION_FAILED", 26, 417, "Expectation Failed");
        EXPECTATION_FAILED = r126;
        Status r127 = new Status("TOO_MANY_REQUESTS", 27, BDAbstractUpload.KeyIsXQuicLibAvailable, "Too Many Requests");
        TOO_MANY_REQUESTS = r127;
        Status r128 = new Status("INTERNAL_ERROR", 28, 500, "Internal Server Error");
        INTERNAL_ERROR = r128;
        Status r129 = new Status("NOT_IMPLEMENTED", 29, 501, "Not Implemented");
        NOT_IMPLEMENTED = r129;
        Status r130 = new Status("SERVICE_UNAVAILABLE", 30, 503, "Service Unavailable");
        SERVICE_UNAVAILABLE = r130;
        Status r131 = new Status("UNSUPPORTED_HTTP_VERSION", 31, 505, "HTTP Version Not Supported");
        UNSUPPORTED_HTTP_VERSION = r131;
        f526214a = new Status[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131};
    }

    public static Status[] values() {
        return (Status[]) f526214a.clone();
    }

    @Override // org.nanohttpd.protocols.http.response.b
    public String getDescription() {
        return "" + this.requestStatus + " " + this.description;
    }

    @Override // org.nanohttpd.protocols.http.response.b
    public int getRequestStatus() {
        return this.requestStatus;
    }

    public static Status lookup(int r100) {
        Status[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        Status r104 = r101[r103];
        if (r104.getRequestStatus() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static Status valueOf(String r100) {
        return (Status) r27.a.a(Status.class, r100);
    }

    public Status(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.requestStatus = r102;
        this.description = r103;
    }
}
