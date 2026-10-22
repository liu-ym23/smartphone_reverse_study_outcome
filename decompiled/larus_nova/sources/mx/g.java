package mx;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class g extends l {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f516141p;

    @Override // mx.l
    public void c(SwitchSettingViewHolder r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f516148l = r101;
        if (r101 == false) goto L5;
        int r102 = 1;
    L6:
        this.f516141p = r102;
        return;
    L5:
        r102 = 2;
        goto L6
    }

    public g(String r110, int r111, String r112, int r113) {
        String r100 = "";
        if ((r113 & 4) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r113 & 16) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r113 & 32) != 0) goto L14;
        r100 = null;
    L14:
        String r103 = r100;
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter(r103, "disableToast");
        if (r111 != 1) goto L17;
        boolean r104 = true;
    L18:
        super(r110, r101, r104, false, r102, r103, 64);
        this.f516141p = r111;
        return;
    L17:
        r104 = false;
        goto L18
    L9:
        r102 = false;
        goto L11
    L5:
        r101 = r112;
        goto L7
    }
}
