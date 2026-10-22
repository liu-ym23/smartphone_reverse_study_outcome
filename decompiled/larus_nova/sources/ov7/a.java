package ov7;

import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f526924g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f526925h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f526926i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f526927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f526928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f526929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f526930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f526931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f526932f;

    static {
        new a(TTVideoEngineInterface.PLAYER_OPTION_ENABLE_SC_ABR_STRATEGY, 4096, 1);
        new a(1033, 1024, 1);
        a r100 = new a(67, 64, 1);
        new a(19, 16, 1);
        f526924g = new a(MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, 256, 0);
        f526925h = new a(301, 256, 1);
        f526926i = r100;
    }

    public final String toString() {
        return "GF(0x" + Integer.toHexString(this.f526931e) + ',' + this.f526930d + ')';
    }

    public final int b(int r100) {
        if (r100 == 0) goto L6;
        return this.f526927a[(this.f526930d - this.f526928b[r100]) - 1];
    L6:
        throw new ArithmeticException();
    }

    public final b a(int r100, int r101) {
        if (r100 < 0) goto L9;
        if (r101 == 0) goto L5;
        int[] r102 = new int[r100 + 1];
        r102[0] = r101;
        return new b(this, r102);
    L5:
        return this.f526929c;
    L9:
        throw new IllegalArgumentException();
    }

    public final int c(int r100, int r101) {
        if (r100 == 0) goto L7;
        if (r101 == 0) goto L9;
        int[] r102 = this.f526927a;
        int[] r103 = this.f526928b;
        return r102[(r103[r100] + r103[r101]) % (this.f526930d - 1)];
    L9:
        return 0;
    L7:
        return 0;
    }

    public a(int r100, int r101, int r102) {
        this.f526931e = r100;
        this.f526930d = r101;
        this.f526932f = r102;
        this.f526927a = new int[r101];
        this.f526928b = new int[r101];
        int r103 = 0;
        int r104 = 1;
    L3:
        if (r103 >= r101) goto L8;
        this.f526927a[r103] = r104;
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
        this.f526928b[this.f526927a[r105]] = r105;
        r105 = r105 + 1;
        goto L10
    L12:
        this.f526929c = new b(this, new int[]{0});
        new b(this, new int[]{1});
    }
}
