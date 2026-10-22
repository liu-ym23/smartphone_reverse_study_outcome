package y02;

import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray.l;
import java.util.Comparator;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements Comparator<NormalGiftMessage> {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(NormalGiftMessage r100, NormalGiftMessage r101) {
        NormalGiftMessage r102 = r100;
        NormalGiftMessage r103 = r101;
        if (r102 == null) goto L38;
        if (r103 == null) goto L38;
        if (r102.n() == null) goto L12;
        if (r103.n() == null) goto L12;
        return r102.g(r103);
    L12:
        if (r102.o() != null) goto L14;
    L16:
        long r104 = r102.l();
        long r105 = r103.l();
        if (r102.f129792v == true) goto L19;
        long r106 = r104 - r105;
    L21:
        if (r106 != 0) goto L27;
        if ((r103 instanceof l) == true) goto L37;
        r106 = r103.m().compareTo(r102.m());
    L37:
        return -1;
    L27:
        if (r106 >= 0) goto L29;
    L28:
        return 1;
    L29:
        if (r106 != 0) goto L37;
        long r107 = r102.G;
        long r108 = r103.G;
        if (r107 > r108) goto L37;
        if (r107 < r108) goto L28;
        if (r102.K == false) goto L38;
    L19:
        r106 = 0;
        goto L21
    L14:
        if (r103.o() == null) goto L16;
        return r102.c(r103);
    L38:
        return 0;
    }
}
