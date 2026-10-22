package n12;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements f {
    public d() {
    }

    @Override // n12.f
    public final int b(long r100) {
        if (r100 <= 1000) goto L7;
        return R.drawable.ttlive_bg_normal_gift_level_5;
    L7:
        if (r100 <= 500) goto L11;
        return R.drawable.ttlive_bg_normal_gift_level_4;
    L11:
        if (r100 <= 200) goto L15;
        return R.drawable.ttlive_bg_normal_gift_level_3;
    L15:
        if (r100 <= 60) goto L18;
        return R.drawable.ttlive_bg_normal_gift_level_2;
    L18:
        return R.drawable.ttlive_bg_normal_gift_level_1;
    }

    @Override // n12.f
    public final int c(long r100) {
        if (r100 <= 1000) goto L7;
        return R.drawable.ttlive_bg_normal_gift_level_5_rotation_0;
    L7:
        if (r100 <= 500) goto L11;
        return R.drawable.ttlive_bg_normal_gift_level_4_rotation_0;
    L11:
        if (r100 <= 200) goto L15;
        return R.drawable.ttlive_bg_normal_gift_level_3_rotation_0;
    L15:
        if (r100 <= 60) goto L18;
        return R.drawable.ttlive_bg_normal_gift_level_2_rotation_0;
    L18:
        return R.drawable.ttlive_bg_normal_gift_level_1_rotation_0;
    }

    @Override // n12.f
    public final long i(long r100, float r101) {
        return 0;
    }

    @Override // n12.f
    public final long k(long r100, float r101) {
        return 0;
    }
}
