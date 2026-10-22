package mg2;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class b {
    static {
        d.a r100 = d.f513706a;
    }

    public static /* synthetic */ void a(d r100, LayerDescriptorList r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = true;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = true;
    L8:
        r100.L3(r101, r102, r103, false);
    }
}
