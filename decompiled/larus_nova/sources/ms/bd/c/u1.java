package ms.bd.c;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ttm.player.MediaPlayer;
import java.util.Locale;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes6.dex */
public final class u1 implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f515371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f515372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f515373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f515374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t1 f515375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f515376f;

    static {
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ce6a42", new byte[0]);
    }

    public final String toString() {
        this.f515375e.getClass();
        Locale r100 = Locale.US;
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "607e6f", new byte[]{98, 54, 8, 84, HTTP.CR, Base64.padSymbol, 112, 21, 42, 112, 35, 126, 1, 2});
        Long r102 = Long.valueOf(this.f515371a);
        Long r103 = Long.valueOf(this.f515372b);
        Long r104 = Long.valueOf(this.f515373c);
        long r105 = this.f515374d;
        long r106 = 0;
        if (r105 == 0) goto L7;
        r106 = this.f515376f - r105;
    L7:
        return String.format(r100, r101, new Object[]{r102, r103, r104, Long.valueOf(r106), this.f515375e});
    }

    public u1() {
        this.f515375e = new t1();
    }

    public final u1 a() {
        return (u1) super.clone();
    L5:
        throw new AssertionError();
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }
}
