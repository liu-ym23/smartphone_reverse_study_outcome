package com.larus.live.impl.bridge.request;

import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class XRequestMethod extends com.larus.live.impl.bridge.request.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f355774c = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/live/impl/bridge/request/XRequestMethod$RequestMethodType;", "", com.alipay.sdk.m.p.e.f25671s, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMethod", "()Ljava/lang/String;", "GET", "POST", "PUT", "DELETE", "UNSUPPORTED", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RequestMethodType extends Enum<RequestMethodType> {
        public static final a Companion = null;
        public static final RequestMethodType DELETE = null;
        public static final RequestMethodType GET = null;
        public static final RequestMethodType POST = null;
        public static final RequestMethodType PUT = null;
        public static final RequestMethodType UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestMethodType[] f355775a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f355776b = null;
        private final String method;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<RequestMethodType> getEntries() {
            return f355776b;
        }

        static {
            RequestMethodType r100 = new RequestMethodType("GET", 0, MonitorConstants.CONNECT_TYPE_GET);
            GET = r100;
            RequestMethodType r101 = new RequestMethodType("POST", 1, UGCMonitor.TYPE_POST);
            POST = r101;
            RequestMethodType r102 = new RequestMethodType("PUT", 2, "put");
            PUT = r102;
            RequestMethodType r103 = new RequestMethodType("DELETE", 3, "delete");
            DELETE = r103;
            RequestMethodType r104 = new RequestMethodType("UNSUPPORTED", 4, "unsupported");
            UNSUPPORTED = r104;
            RequestMethodType[] r105 = {r100, r101, r102, r103, r104};
            f355775a = r105;
            f355776b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static RequestMethodType[] values() {
            return (RequestMethodType[]) f355775a.clone();
        }

        public final String getMethod() {
            return this.method;
        }

        public static RequestMethodType valueOf(String r100) {
            return (RequestMethodType) r27.a.a(RequestMethodType.class, r100);
        }

        public RequestMethodType(String r100, int r101, String r102) {
            super(r100, r101);
            this.method = r102;
        }
    }

    public static final class a {
    }

    public interface b {
        void intercept();
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355777a = null;

        static {
            int[] r100 = new int[XReadableType.values().length];
            r100[XReadableType.Map.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[XReadableType.String.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[XReadableType.Array.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f355777a = r100;
        }
    }

    static {
    }

    public XRequestMethod() {
    }

    @Override // com.larus.live.impl.bridge.request.a
    public final void e(final d r110, final com.larus.live.impl.bridge.request.a.b r111, final XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        RequestMethodType.a r100 = RequestMethodType.Companion;
        String r101 = r110.a();
        r100.getClass();
        if (r101 != null) goto L55;
        RequestMethodType r102 = RequestMethodType.UNSUPPORTED;
    L8:
        final RequestMethodType r103 = r102;
        if (r103 != RequestMethodType.UNSUPPORTED) goto L12;
        g(r110.a(), r110.getUrl(), 0, -3, "Illegal method " + r110.a(), r112.name());
        r111.a(-3, "Illegal method " + r110.a(), null);
        return;
    L12:
        b r104 = (b) provideContext(b.class);
        if (r104 == null) goto L15;
        r104.intercept();
    L15:
        final XReadableMap r105 = r110.f355797g;
        Object r106 = r110.f355794d;
        final String r113 = r110.f355795e;
        boolean r107 = r106 instanceof t;
        if (r107 == false) goto L18;
        t r108 = (t) r106;
    L19:
        if (r108 == null) goto L21;
        XReadableType r109 = r108.getType();
    L22:
        if (r109 != null) goto L24;
        int r114 = -1;
    L26:
        if (r114 != 1) goto L28;
        if (r107 == false) goto L44;
        t r115 = (t) r106;
    L45:
        if (r115 == null) goto L48;
        Object r116 = r115.asMap();
    L47:
        Object r117 = r116;
    L49:
        final XReadableMap r118 = r110.f355796f;
        if (TextUtils.isEmpty(r110.getUrl()) == false) goto L53;
        g(r110.a(), r110.getUrl(), 0, -3, "Illegal empty url", r112.name());
        r111.a(-3, "url is empty", null);
        return;
    L53:
        r56.c r119 = (r56.c) provideContext(r56.c.class);
        r56.c r120 = r56.c.f536312g;
        final Object r121 = r117;
        TTExecutors.getNormalExecutor().execute(new yi9.b(r105, r110, r118, r112, this, r103, r121, r113, r111));
        return;
    L48:
        r117 = null;
        goto L49
    L44:
        r115 = null;
        goto L45
    L28:
        if (r114 != 2) goto L30;
        if (r107 == false) goto L39;
        t r122 = (t) r106;
    L40:
        if (r122 == null) goto L48;
        r116 = r122.asString();
        goto L47
    L39:
        r122 = null;
        goto L40
    L30:
        if (r114 != 3) goto L48;
        if (r107 == false) goto L34;
        t r123 = (t) r106;
    L35:
        if (r123 == null) goto L48;
        r116 = r123.asArray();
        goto L47
    L34:
        r123 = null;
        goto L35
    L24:
        r114 = c.f355777a[r109.ordinal()];
        goto L26
    L21:
        r109 = null;
        goto L22
    L18:
        r108 = null;
        goto L19
    L55:
        r102 = RequestMethodType.valueOf(r101.toUpperCase(Locale.ROOT));     // Catch: Exception -> L6
    L6:
        r102 = RequestMethodType.UNSUPPORTED;
        goto L8
    }

    public final void g(final String r110, final String r111, final Integer r112, final int r113, final String r114, final String r115) {
        r56.c r100 = (r56.c) provideContext(r56.c.class);
        r56.c r101 = r56.c.f536312g;
        TTExecutors.getNormalExecutor().execute(new yi9.c(r110, r111, r112, r113, r114, r115, this));
    }
}
