package k25;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f501492a;

    public d1() {
        this.f501492a = new Object[64];
        int r100 = 0;
    L3:
        Object[] r101 = this.f501492a;
        if (r100 >= r101.length) goto L6;
        r101[r100] = new Object();
        r100 = r100 + 1;
        goto L3
    }

    public final Object a(m0 r100, boolean r101) {
        if (r100 == null) goto L15;
        if (r101 == false) goto L15;
        int r102 = ((((Objects.hashCode(r100.f501550k) + TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER) * 31) + Objects.hashCode(r100.f501541b)) * 31) + r100.f501555p;
        Object[] r103 = this.f501492a;
        int r104 = r103.length;
        int r105 = r102 % r104;
        if (r105 != 0) goto L9;
        int r106 = 0;
    L14:
        return r103[r106];
    L9:
        if ((((r102 ^ r104) >> 31) | 1) > 0) goto L12;
        r105 = r105 + r104;
    L12:
        r106 = r105;
    L15:
        return this;
    }
}
