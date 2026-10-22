package mg2;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class b {
    static {
        d.a r0 = d.a;
    }

    public static /* synthetic */ void a(d r2, LayerDescriptorList r3, boolean r4, boolean r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = true;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = true;
    L8:
        r2.L3(r3, r4, r5, false);
    }
}
