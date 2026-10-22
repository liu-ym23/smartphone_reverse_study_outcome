package mx3;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long[][] f516195k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zw3.b f516197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f516198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f516199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f516200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f516201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f516202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f516203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long[][] f516204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.applog.priority.b f516205j;

    static {
        f516195k = new long[][]{new long[]{60000, 0, 12}, new long[]{120000, 5, 1}, new long[]{com.heytap.mcssdk.constant.a.f276323j, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
    }

    public final String toString() {
        return "mPrefix=" + this.f516196a + ", mTableIndex=" + this.f516198c + ", mHasSendCount=" + this.f516199d + ", mHasSendPackCount=" + this.f516200e + ", mContinueSuccSendCount=" + this.f516201f + ", mLastSendTime=" + this.f516202g;
    }

    public b(String r110, zw3.b r111, com.bytedance.applog.priority.b r112) {
        this.f516197b = r111;
        this.f516196a = r110;
        this.f516205j = r112;
        this.f516198c = 0;
        if ((System.currentTimeMillis() - r111.f573809e.getLong(r110 + "downgrade_time", 0)) >= 10800000) goto L5;
        this.f516198c = r111.f573809e.getInt(r110 + "downgrade_index", 0);
    L6:
        long[][] r113 = f516195k;
        this.f516204i = (long[][]) Array.newInstance(Long.TYPE, new int[]{5, r113[0].length});
        int r100 = 0;
    L7:
        if (r100 >= 5) goto L9;
        long[] r101 = r113[r100];
        System.arraycopy(r101, 0, this.f516204i[r100], 0, r101.length);
        r100 = r100 + 1;
        goto L7
    L9:
        com.bytedance.applog.priority.b r114 = this.f516205j;
        if (r114 == null) goto L27;
        int r115 = r114.f192592a;
        if (r115 != 0) goto L15;
        this.f516204i[0][2] = 2147483647L;
    L17:
        long r116 = r114.f192595d;
        if (r116 <= 0) goto L32;
        int r102 = 1;
    L20:
        long[][] r103 = this.f516204i;
        if (r102 >= r103.length) goto L33;
        if (r102 != 1) goto L25;
        r103[r102][0] = 2 * r116;
    L26:
        r102 = r102 + 1;
        goto L20
    L25:
        r103[r102][0] = r103[r102 - 1][0] * 2;
        goto L26
    L33:
        return;
    L32:
        return;
    L15:
        if ((-1) == r115) goto L17;
        this.f516204i[0][2] = 60;
        goto L17
    L27:
        return;
    L5:
        r111.f573809e.edit().remove(r110 + "downgrade_time").remove(r110 + "downgrade_index").apply();
        goto L6
    }
}
