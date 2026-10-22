package lmc;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.ugc.live.sdk.msg.data.SdkUplinkPacket;
import com.ss.ugc.live.sdk.msg.network.n;
import com.ss.ugc.live.sdk.msg.uplink.UplinkException;
import com.ss.ugc.live.sdk.msg.uplink.UplinkStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f509935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> f509936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> f509937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SdkUplinkPacket f509938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f509939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.network.g f509940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Exception f509941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f509942h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f509943i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f509944j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f509945k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f509946l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f509947m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.network.f f509948n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.network.e f509949o;

    public final com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, Exception> a() {
        SdkUplinkPacket r100 = this.f509938d;
        com.ss.ugc.live.sdk.msg.network.g r101 = this.f509940f;
        Exception r102 = this.f509941g;
        boolean r103 = false;
        if (r100 == null) goto L29;
        ByteString r104 = r100.payload;
        if (r104 == null) goto L9;
        byte[] r105 = r104.toByteArray();
        if (r105 == null) goto L9;
    L10:
        ArrayList r106 = new ArrayList();
        Map<String, String> r107 = r100.headers;
        if (r107 == null) goto L16;
        Iterator<Map.Entry<String, String>> r108 = r107.entrySet().iterator();
    L14:
        if (r108.hasNext() == false) goto L16;
        Map.Entry<String, String> r109 = r108.next();
        r106.add(new com.ss.ugc.live.sdk.msg.network.d(r109.getKey(), r109.getValue()));
    L16:
        com.ss.ugc.live.sdk.msg.network.g r110 = new com.ss.ugc.live.sdk.msg.network.g();
        r110.f458311a = r100.statusCode.intValue();
        r110.f458312b = r100.statusMessage;
        r110.f458314d = r105;
        r110.f458313c = r106;
        com.ss.ugc.live.sdk.msg.network.f r111 = this.f509948n;
        if (this.f509939e == false) goto L19;
        int r112 = 1;
    L20:
        r110.f458316f = r112;
        if (r105.length != 0) goto L24;
        r103 = true;
    L24:
        if ((!r103) == false) goto L28;
        n r113 = r111.f458307j;
        if (r113 == null) goto L28;
        r110.f458315e = r113.decode(r105);
    L28:
        int r114 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        return new com.ss.ugc.live.sdk.msg.utils.g.c(r110);
    L19:
        r112 = 2;
    L9:
        r105 = new byte[0];
        goto L10
    L29:
        if (r101 == null) goto L43;
        byte[] r115 = r101.f458314d;
        if (r115 != null) goto L34;
        r115 = new byte[0];
    L34:
        com.ss.ugc.live.sdk.msg.network.g r116 = new com.ss.ugc.live.sdk.msg.network.g();
        r116.f458311a = r101.f458311a;
        r116.f458312b = r101.f458312b;
        r116.f458314d = r115;
        r116.f458313c = r101.f458313c;
        com.ss.ugc.live.sdk.msg.network.f r117 = this.f509948n;
        r116.f458316f = 0;
        if (r115.length != 0) goto L38;
        r103 = true;
    L38:
        if ((true ^ r103) == false) goto L42;
        n r118 = r117.f458307j;
        if (r118 == null) goto L42;
        r116.f458315e = r118.decode(r115);
    L42:
        int r119 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        return new com.ss.ugc.live.sdk.msg.utils.g.c(r116);
    L43:
        if (r102 == null) goto L46;
        int r120 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(r102);
    L46:
        if (this.f509944j == true) goto L48;
    L50:
        int r121 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new UplinkException(-3, "request not finish", null, null, 12, null));
    L48:
        if (this.f509935a == false) goto L50;
        com.ss.ugc.live.sdk.msg.network.g r122 = new com.ss.ugc.live.sdk.msg.network.g();
        r122.f458311a = 0;
        r122.f458312b = "disable_response";
        r122.f458314d = new byte[0];
        r122.f458313c = new ArrayList();
        r122.f458316f = 1;
        int r123 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        return new com.ss.ugc.live.sdk.msg.utils.g.c(r122);
    }

    public final SdkUplinkPacket b() {
        Map<String, String> r100 = this.f509948n.f458300c;
        if (r100 != null) goto L6;
        r100 = new HashMap();
    L6:
        Map<String, String> r101 = this.f509948n.f458301d;
        if (r101 != null) goto L10;
        r101 = new HashMap();
    L10:
        byte[] r102 = this.f509948n.a();
        String r103 = UriProtector.parse(this.f509948n.f458299b).getPath();     // Catch: Exception -> L16
        if (r103 != null) goto L18;
        r103 = this.f509948n.f458299b;     // Catch: Exception -> L16
    L18:
        return new SdkUplinkPacket.Builder().uniqueID(Long.valueOf(this.f509945k)).serviceID(Long.valueOf(this.f509946l)).uri(r103).queryParams(r101).headers(r100).payload(ByteString.of(Arrays.copyOf(r102, r102.length))).build();
    L16:
        r103 = this.f509948n.f458299b;
        goto L18
    }

    public final boolean f() {
        String r100 = UriProtector.parse(this.f509948n.f458299b).getPath();     // Catch: Exception -> L4
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
    L10:
        return false;
    L8:
        if (TextUtils.equals(HTTP.URL_DEFAULT, r100) == true) goto L10;
        return true;
    L4:
        r100 = null;
        goto L6
    }

    public final void d(com.ss.ugc.live.sdk.msg.network.g r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "httpResponse");
        Intrinsics.checkNotNullParameter(UplinkStrategy.ORIGIN_HTTP, "useUplinkStrategy");
        this.f509940f = r100;
        f r102 = this.f509942h;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "httpResponse");
        Intrinsics.checkNotNullParameter(UplinkStrategy.ORIGIN_HTTP, "uplinkStrategy");
        r102.f509956f = System.currentTimeMillis();
        r102.f509952b = UplinkStrategy.ORIGIN_HTTP;
        r102.f509954d = r101;
        r102.f509957g = true;
        r102.f509958h = r100.f458311a;
        r102.f509959i = r100.f458312b;
        r102.f509960j = com.ss.ugc.live.sdk.msg.utils.c.c(r100);
    }

    public final void c(Exception r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        Intrinsics.checkNotNullParameter(r101, "useUplinkStrategy");
        this.f509941g = r100;
        f r103 = this.f509942h;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        Intrinsics.checkNotNullParameter(r101, "uplinkStrategy");
        r103.f509956f = System.currentTimeMillis();
        r103.f509952b = r101;
        r103.f509954d = r102;
        r103.f509957g = false;
        if ((r100 instanceof UplinkException) == false) goto L5;
        int r104 = ((UplinkException) r100).getStatusCode();
    L6:
        r103.f509958h = r104;
        String r105 = r100.getMessage();
        if (r105 != null) goto L10;
        r105 = "Unknown Exception";
    L10:
        r103.f509959i = r105;
        if ((r100 instanceof UplinkException) == false) goto L13;
        String r106 = ((UplinkException) r100).getLogId();
    L14:
        r103.f509960j = r106;
        return;
    L13:
        r106 = null;
        goto L14
    L5:
        r104 = -1;
        goto L6
    }

    public final void e(SdkUplinkPacket r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "uplinkPacket");
        Intrinsics.checkNotNullParameter(r101, "useUplinkStrategy");
        this.f509939e = r103;
        this.f509938d = r100;
        f r104 = this.f509942h;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "uplinkPacket");
        Intrinsics.checkNotNullParameter(r101, "uplinkStrategy");
        r104.f509956f = System.currentTimeMillis();
        r104.f509952b = r101;
        r104.f509954d = r102;
        r104.f509957g = true;
        r104.f509958h = r100.statusCode.intValue();
        r104.f509959i = r100.statusMessage;
        r104.f509960j = com.ss.ugc.live.sdk.msg.utils.h.b(r100);
    }

    public d(long r100, long r101, long r102, com.ss.ugc.live.sdk.msg.network.f r103, com.ss.ugc.live.sdk.msg.network.e r104) {
        Intrinsics.checkNotNullParameter(r103, "originHttpRequest");
        Intrinsics.checkNotNullParameter(r104, "httpCallback");
        this.f509945k = r100;
        this.f509946l = r101;
        this.f509947m = r102;
        this.f509948n = r103;
        this.f509949o = r104;
        Map<String, String> r105 = r103.f458300c;
        if (r105 == null) goto L7;
        String r106 = r105.get("BYTELINK-DISABLE-RESPONSE");
        if (r106 == null) goto L7;
        boolean r107 = Boolean.parseBoolean(r106);
    L8:
        this.f509935a = r107;
        this.f509942h = new f(r100, r101);
        return;
    L7:
        r107 = false;
        goto L8
    }
}
