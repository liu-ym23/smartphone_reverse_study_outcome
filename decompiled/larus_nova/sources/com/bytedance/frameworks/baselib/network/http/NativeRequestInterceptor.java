package com.bytedance.frameworks.baselib.network.http;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeRequestInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f244668a;

    public static final enum RequestModified extends Enum<RequestModified> {
        public static final RequestModified BOTH_MODIFIED = null;
        public static final RequestModified HEADER_MODIFIED = null;
        public static final RequestModified NOT_MODIFIED = null;
        public static final RequestModified URL_MODIFIED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestModified[] f244669a = null;
        public final int mValue;

        static {
            RequestModified r100 = new RequestModified("NOT_MODIFIED", 0, 0);
            NOT_MODIFIED = r100;
            RequestModified r101 = new RequestModified("URL_MODIFIED", 1, 1);
            URL_MODIFIED = r101;
            RequestModified r102 = new RequestModified("HEADER_MODIFIED", 2, 2);
            HEADER_MODIFIED = r102;
            RequestModified r103 = new RequestModified("BOTH_MODIFIED", 3, 3);
            BOTH_MODIFIED = r103;
            f244669a = new RequestModified[]{r100, r101, r102, r103};
        }

        public static RequestModified[] values() {
            return (RequestModified[]) f244669a.clone();
        }

        public int getValue() {
            return this.mValue;
        }

        public static RequestModified valueOf(String r100) {
            return (RequestModified) r27.a.a(RequestModified.class, r100);
        }

        public RequestModified(String r100, int r101, int r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f244670a = null;

        static {
            int[] r100 = new int[RequestModified.values().length];
            f244670a = r100;
            r100[RequestModified.URL_MODIFIED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f244670a[RequestModified.HEADER_MODIFIED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f244670a[RequestModified.BOTH_MODIFIED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface b {
        void a();

        c b(String r100);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RequestModified f244671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f244672b;

        public c(RequestModified r100) {
            this.f244671a = r100;
        }

        public static void a(JSONObject r100, Map r101) throws JSONException {
            if (r101 != null) goto L4;
            return;
        L4:
            JSONObject r102 = new JSONObject();
            Iterator r103 = r101.entrySet().iterator();
        L6:
            if (r103.hasNext() == false) goto L11;
            Map.Entry r104 = (Map.Entry) r103.next();
            if (((String) r104.getValue()).isEmpty() == true) goto L6;
            r102.put((String) r104.getKey(), r104.getValue());
            goto L6
        L11:
            r100.put("new_headers", r102);
        }
    }
}
