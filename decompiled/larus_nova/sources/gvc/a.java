package gvc;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ByteString f482844d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteString f482845e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ByteString f482846f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ByteString f482847g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ByteString f482848h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ByteString f482849i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString f482850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteString f482851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f482852c;

    public final String toString() {
        return cvc.c.l("%s: %s", new Object[]{this.f482850a.utf8(), this.f482851b.utf8()});
    }

    static {
        f482844d = ByteString.encodeUtf8(":");
        f482845e = ByteString.encodeUtf8(":status");
        f482846f = ByteString.encodeUtf8(":method");
        f482847g = ByteString.encodeUtf8(":path");
        f482848h = ByteString.encodeUtf8(":scheme");
        f482849i = ByteString.encodeUtf8(":authority");
    }

    public final int hashCode() {
        return ((TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.f482850a.hashCode()) * 31) + this.f482851b.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f482850a.equals(r101.f482850a) == true) goto L7;
        return false;
    L7:
        if (this.f482851b.equals(r101.f482851b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public a(ByteString r100, ByteString r101) {
        this.f482850a = r100;
        this.f482851b = r101;
        this.f482852c = (r100.size() + 32) + r101.size();
    }

    public a(String r100, String r101) {
        this(ByteString.encodeUtf8(r100), ByteString.encodeUtf8(r101));
    }

    public a(ByteString r100, String r101) {
        this(r100, ByteString.encodeUtf8(r101));
    }
}
