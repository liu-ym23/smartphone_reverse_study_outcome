package e2c;

import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f470878g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f470879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f470880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f470881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f470882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f470883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f470884f;

    static {
        new a(TTVideoEngineInterface.PLAYER_OPTION_ENABLE_SC_ABR_STRATEGY, 4096, 1);
        new a(1033, 1024, 1);
        new a(67, 64, 1);
        new a(19, 16, 1);
        f470878g = new a(MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, 256, 0);
        new a(301, 256, 1);
    }

    public final String toString() {
        return "GF(0x" + Integer.toHexString(this.f470883e) + ',' + this.f470882d + ')';
    }

    public final int a(int r100, int r101) {
        if (r100 == 0) goto L7;
        if (r101 == 0) goto L9;
        int[] r102 = this.f470879a;
        int[] r103 = this.f470880b;
        return r102[(r103[r100] + r103[r101]) % (this.f470882d - 1)];
    L9:
        return 0;
    L7:
        return 0;
    }

    public a(int r100, int r101, int r102) {
        this.f470883e = r100;
        this.f470882d = r101;
        this.f470884f = r102;
        this.f470879a = new int[r101];
        this.f470880b = new int[r101];
        int r103 = 0;
        int r104 = 1;
    L3:
        if (r103 >= r101) goto L8;
        this.f470879a[r103] = r104;
        r104 = r104 * 2;
        if (r104 < r101) goto L7;
        r104 = (r104 ^ r100) & (r101 - 1);
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        int r105 = 0;
    L10:
        if (r105 >= (r101 - 1)) goto L12;
        this.f470880b[this.f470879a[r105]] = r105;
        r105 = r105 + 1;
        goto L10
    L12:
        this.f470881c = new b(this, new int[]{0});
        new b(this, new int[]{1});
    }
}
