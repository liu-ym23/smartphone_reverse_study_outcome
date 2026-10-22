package d31;

import com.bytedance.android.live.revlink.impl.model.BizType;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.ttm.player.MediaPlayer;
import d11.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f466661m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f466663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f466664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f466665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f466666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f466667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f466668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f466669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f466670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f466671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f466672k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BizType f466673l;

    /* JADX INFO: renamed from: d31.a$a, reason: collision with other inner class name */
    public static final class C5622a {
        public static a a(d11.c r110) {
            Intrinsics.checkNotNullParameter(r110, "params");
            return new a(0, 0, 0, r110.f466273a, r110.f466279g, r110.f466278f, 0, null, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_THREAD_BUSY_COUNT);
        }

        public static a b(d11.d r110) {
            Intrinsics.checkNotNullParameter(r110, "params");
            int r100 = r110.f466285e;
            int r101 = r110.f466284d;
            int r102 = r110.f466294n;
            int r103 = r110.f466281a;
            String r104 = String.valueOf(r110.f466299s);
            int r111 = r110.f466289i;
            BizType r105 = BizType.PK;
            if (r111 == r105.ordinal()) goto L10;
            r105 = BizType.OpenGame;
            if (r111 == r105.ordinal()) goto L10;
            r105 = BizType.AnchorLink;
            if (r111 == r105.ordinal()) goto L10;
            BizType r112 = BizType.None;
        L13:
            return new a(r100, r101, r102, r103, null, 0, 0, r104, null, null, r112, 1904);
        L10:
            r112 = r105;
            goto L13
        }

        public static a c(g r110) {
            Intrinsics.checkNotNullParameter(r110, "params");
            d11.a r100 = r110.f466330j;
            return new a(r100.f466251a, r100.f466252b, r100.f466253c, r110.f466321a, r100.f466258h, r110.f466325e, 0, null, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_TAKE_SCREEN_SHOT_SYNC);
        }
    }

    static {
    }

    public a() {
        this(0, 0, 0, 0, null, 0, 0, null, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L30;
        a r101 = (a) r100;
        if (this.f466662a == r101.f466662a) goto L8;
        return false;
    L8:
        if (this.f466663b == r101.f466663b) goto L10;
        return false;
    L10:
        if (this.f466664c == r101.f466664c) goto L12;
        return false;
    L12:
        if (this.f466665d == r101.f466665d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f466666e, r101.f466666e) == true) goto L16;
        return false;
    L16:
        if (this.f466667f == r101.f466667f) goto L18;
        return false;
    L18:
        if (this.f466668g == r101.f466668g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f466669h, r101.f466669h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f466670i, r101.f466670i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f466671j, r101.f466671j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f466672k, r101.f466672k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f466673l, r101.f466673l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((this.f466662a * 31) + this.f466663b) * 31) + this.f466664c) * 31) + this.f466665d) * 31;
        String r101 = this.f466666e;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f466667f) * 31) + this.f466668g) * 31;
        String r105 = this.f466669h;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f466670i;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Long r111 = this.f466671j;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f466672k;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        BizType r117 = this.f466673l;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        return r116 + r102;
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ApiCallParams(matchType=" + this.f466662a + ", inviteType=" + this.f466663b + ", inviteSource=" + this.f466664c + ", reqScene=" + this.f466665d + ", reqSource=" + this.f466666e + ", type=" + this.f466667f + ", mode=" + this.f466668g + ", source=" + this.f466669h + ", status=" + this.f466670i + ", channelId=" + this.f466671j + ", queryStr=" + this.f466672k + ", bizType=" + this.f466673l + ")";
    }

    public final int getType() {
        return this.f466667f;
    }

    public a(int r110, int r111, int r112, int r113, String r114, int r210, int r211, String r212, Long r213, String r214, BizType r215, int r216) {
        int r100 = 0;
        if ((r216 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r216 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r216 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r216 & 8) == 0) goto L17;
        int r104 = 0;
    L18:
        String r105 = "";
        if ((r216 & 16) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r216 & 32) == 0) goto L25;
        int r107 = 0;
    L27:
        if ((r216 & 64) != 0) goto L31;
        r100 = r211;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r115 = "";
    L34:
        Long r116 = null;
        if ((r216 & 256) == 0) goto L37;
        String r117 = "";
    L39:
        if ((r216 & 512) != 0) goto L43;
        r116 = r213;
    L43:
        if ((r216 & 1024) != 0) goto L47;
        r105 = r214;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        BizType r108 = BizType.None;
    L50:
        Intrinsics.checkNotNullParameter(r106, "reqSource");
        Intrinsics.checkNotNullParameter(r115, "source");
        Intrinsics.checkNotNullParameter(r117, "status");
        Intrinsics.checkNotNullParameter(r105, "queryStr");
        Intrinsics.checkNotNullParameter(r108, "bizType");
        this.f466662a = r101;
        this.f466663b = r102;
        this.f466664c = r103;
        this.f466665d = r104;
        this.f466666e = r106;
        this.f466667f = r107;
        this.f466668g = r100;
        this.f466669h = r115;
        this.f466670i = r117;
        this.f466671j = r116;
        this.f466672k = r105;
        this.f466673l = r108;
        return;
    L49:
        r108 = r215;
        goto L50
    L37:
        r117 = null;
        goto L39
    L33:
        r115 = r212;
        goto L34
    L25:
        r107 = r210;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
