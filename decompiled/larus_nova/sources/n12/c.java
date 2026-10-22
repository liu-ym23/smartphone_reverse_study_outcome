package n12;

import com.bytedance.android.livesdk.gift.configmodel.k1;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;
import kotlin.collections.ArraysKt;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer[] f516665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Long[] f516666b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Integer[] f516667c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Integer[] f516668d = null;

    public static final class a {
    }

    public c() {
    }

    static {
        f516665a = new Integer[]{200, 700, 6000, 10000};
        f516666b = new Long[]{1000L, 1500L, 1500L, 1500L, 2000L};
        f516667c = new Integer[]{Integer.valueOf(R.drawable.ttlive_bg_new_normal_gift_level_1_v2), Integer.valueOf(R.drawable.ttlive_bg_new_normal_gift_level_2_v2), Integer.valueOf(R.drawable.ttlive_bg_new_normal_gift_level_3_v2), Integer.valueOf(R.drawable.ttlive_bg_new_normal_gift_level_4_v2), Integer.valueOf(R.drawable.ttlive_bg_new_normal_gift_level_5_v2)};
        f516668d = new Integer[]{Integer.valueOf(R.drawable.ttlive_bg_new_normal_gift_level_1_v3_rotation_0), Integer.valueOf(R.drawable.ttlive_bg_new_normal_gift_level_2_v3_rotation_0), Integer.valueOf(R.drawable.ttlive_bg_new_normal_gift_level_3_v3_rotation_0), Integer.valueOf(R.drawable.ttlive_bg_new_normal_gift_level_4_v3_rotation_0), Integer.valueOf(R.drawable.ttlive_bg_new_normal_gift_level_5_v3_rotation_0)};
    }

    public static int m(long r100) {
        int r101 = n(r100);
        ReadOnlyProperty r102 = com.bytedance.android.livesdk.gift.platform.business.e.f129034t;
        KProperty<?>[] r103 = com.bytedance.android.livesdk.gift.platform.business.e.f129015a;
        if (r101 > ((k1) r102.getValue(null, r103[18])).b().length) goto L7;
        Integer r104 = (Integer) ArraysKt.getOrNull(((k1) r102.getValue(null, r103[18])).b(), r101);
        if (r104 == null) goto L7;
        return r104.intValue();
    L7:
        return 0;
    }

    public static int n(long r100) {
        Integer[] r101 = f516665a;
        int r102 = 0;
        if (r100 >= r101[0].intValue()) goto L6;
        return 0;
    L6:
        if (r102 >= 4) goto L11;
        if (r100 < r101[r102].intValue()) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return r102;
    L11:
        return 4;
    }

    @Override // n12.f
    public final int b(long r100) {
        int r101 = n(r100);
        if (r101 < 5) goto L7;
        return R.drawable.ttlive_bg_new_normal_gift_level_1_v2;
    L7:
        return f516667c[r101].intValue();
    }

    @Override // n12.f
    public final int c(long r100) {
        int r101 = n(r100);
        if (r101 < 5) goto L7;
        return R.drawable.ttlive_bg_new_normal_gift_level_1_v3_rotation_0;
    L7:
        return f516668d[r101].intValue();
    }

    @Override // n12.f
    public final long i(long r100, float r101) {
        if (r101 > 0.0f) goto L6;
        r101 = 1.0f;
    L6:
        if (r100 < 28888) goto L9;
        long r102 = 7975;
    L22:
        return RangesKt.coerceAtLeast((long) (r102 / r101), 1000);
    L9:
        if (r100 < 10001) goto L12;
        r102 = 6975;
        goto L22
    L12:
        if (r100 < 3000) goto L15;
        r102 = 5975;
        goto L22
    L15:
        if (r100 < MediaPlayer.MEDIA_PLAYER_OPTION_BYTEVC1_SW_FORBIDDEN) goto L18;
        r102 = 3975;
        goto L22
    L18:
        if (r100 < 66) goto L20;
        r102 = 2975;
        goto L22
    L20:
        r102 = 1975;
        goto L22
    }

    @Override // n12.f
    public final long k(long r100, float r101) {
        Long[] r102 = f516666b;
        int r103 = m(r100);
        if (r103 >= 5) goto L5;
        Long r104 = r102[r103];
    L7:
        if (r104 == null) goto L9;
        long r105 = r104.longValue();
    L11:
        return RangesKt.coerceAtLeast((long) (r105 / r101), 1000);
    L9:
        r105 = 1000;
        goto L11
    L5:
        r104 = null;
        goto L7
    }
}
