package j41;

import android.graphics.Bitmap;
import com.bytedance.android.live.revenuelink.rtc.i;
import fr2.e0;
import io.reactivex.disposables.CompositeDisposable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f497336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f497337b;

    public c(i r100) {
        this.f497337b = r100;
        this.f497336a = new CompositeDisposable();
    }

    public static final void a(c r110, Bitmap r210, e0 r211) {
        r110.getClass();
        int[] r100 = new int[r210.getWidth() * r210.getHeight()];
        r210.getPixels(r100, 0, r210.getWidth(), 0, 0, r210.getWidth(), r210.getHeight());
        int r101 = r210.getWidth();
        int r102 = r210.getHeight();
        int r103 = r101 * r102;
        int r104 = (r103 * 3) / 2;
        byte[] r105 = new byte[r104];
        int r106 = (r103 * 5) / 4;
        int r107 = 0;
        int r108 = 0;
        int r111 = 0;
        int r112 = 0;
    L3:
        if (r108 >= r102) goto L29;
        int r113 = 0;
    L5:
        if (r113 >= r101) goto L28;
        int r114 = r100[r112];
        int r115 = (16711680 & r114) >> 16;
        int r116 = (65280 & r114) >> 8;
        int[] r117 = r100;
        int r118 = (r114 & 255) >> r107;
        int r109 = (((((r115 * 66) + (r116 * 129)) + (r118 * 25)) + 128) >> 8) + 16;
        int r119 = (((((r115 * (-38)) - (r116 * 74)) + (r118 * 112)) + 128) >> 8) + 128;
        int r120 = (((((r115 * 112) - (r116 * 94)) - (r118 * 18)) + 128) >> 8) + 128;
        int r121 = r111 + 1;
        if (r109 >= 0) goto L10;
        r109 = 0;
    L12:
        r105[r111] = (byte) r109;
        if ((r108 % 2) != 0) goto L27;
        if ((r112 % 2) != 0) goto L27;
        int r122 = r106 + 1;
        if (r120 >= 0) goto L19;
        r120 = 0;
    L21:
        r105[r106] = (byte) r120;
        int r123 = r103 + 1;
        if (r119 >= 0) goto L24;
        r119 = 0;
    L26:
        r105[r103] = (byte) r119;
        r103 = r123;
        r106 = r122;
        goto L27
    L24:
        if (r119 <= 255) goto L26;
        r119 = 255;
        goto L26
    L19:
        if (r120 <= 255) goto L21;
        r120 = 255;
    L27:
        r112 = r112 + 1;
        r113 = r113 + 1;
        r111 = r121;
        r100 = r117;
        r107 = 0;
        goto L5
    L10:
        if (r109 <= 255) goto L12;
        r109 = 255;
        goto L12
    L28:
        r108 = r108 + 1;
        r107 = 0;
        goto L3
    L29:
        ByteBuffer r124 = ByteBuffer.allocateDirect(r104);
        if (r124 == null) goto L32;
        r124.put(r105);
    L32:
        if (r124 == null) goto L34;
        r124.position(0);
    L34:
        if (r211 == null) goto L47;
        i r125 = r110.f497337b;
        if (r125 == null) goto L38;
        String r126 = String.valueOf(r210.hashCode());
        vc0.a r127 = vc0.b.a(r211);
        i97.a r128 = i97.a.f488802a;
        r125.S1(r126, r127, System.currentTimeMillis() * ((long) 1000));
    L38:
        i r129 = r110.f497337b;
        if (r129 == null) goto L48;
        r129.o();
        return;
    L48:
        return;
    }
}
