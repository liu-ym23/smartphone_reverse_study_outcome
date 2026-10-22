package tf1;

import com.bytedance.android.livesdk.gift.model.f1;
import com.bytedance.android.livesdk.gift.model.g1;
import com.bytedance.android.livesdk.message.model.a8;
import com.bytedance.android.livesdk.message.model.cc;
import com.bytedance.android.livesdk.message.model.hi;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements Comparable<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f545709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f545710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a8 f545711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f545712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f545713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f545714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f545715g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final hi f545716h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<f1> f545717i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<g1> f545718j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final cc f545719k;

    public c() {
        throw null;
    }

    public final String a() {
        if (this.f545716h == null) goto L7;
        return "PrizeNoticeMessage";
    L7:
        if (this.f545719k == null) goto L10;
        return "TopEffectMessage";
    L10:
        return "unknown";
    }

    @Override // java.lang.Comparable
    public final int compareTo(c r100) {
        c r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = (int) (this.f545712d - r101.f545712d);
        if (r102 <= 0) goto L5;
        return -1;
    L5:
        if (r102 >= 0) goto L7;
        return 1;
    L7:
        return 0;
    }

    public c(long r110, String r111, a8 r112, long r113, long r210, long r211, hi r212, List r213, List r214, cc r215, int r216) {
        if ((r216 & 32) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r216 & 64) == 0) goto L9;
        long r101 = 0;
    L10:
        cc r114 = null;
        if ((r216 & 256) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r216 & 512) == 0) goto L17;
        List r115 = null;
    L19:
        if ((r216 & 1024) != 0) goto L22;
        r114 = r215;
    L22:
        Intrinsics.checkNotNullParameter(r111, "filePath");
        this.f545709a = r110;
        this.f545710b = r111;
        this.f545711c = r112;
        this.f545712d = r113;
        this.f545713e = 0;
        this.f545714f = r100;
        this.f545715g = r101;
        this.f545716h = r212;
        this.f545717i = r102;
        this.f545718j = r115;
        this.f545719k = r114;
        return;
    L17:
        r115 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r211;
        goto L10
    L5:
        r100 = r210;
        goto L7
    }
}
